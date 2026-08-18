package com.github.egorovna26.obs_remote_control.session;

import com.github.egorovna26.obs_remote_control.message.Message;
import com.github.egorovna26.obs_remote_control.message.event.Event;
import com.github.egorovna26.obs_remote_control.message.hello.Hello;
import com.github.egorovna26.obs_remote_control.message.identified.Identified;
import com.github.egorovna26.obs_remote_control.message.identify.Identify;
import com.github.egorovna26.obs_remote_control.message.requestresponse.RequestResponse;
import com.github.egorovna26.obs_remote_control.util.JsonUtil;
import lombok.CustomLog;
import lombok.Getter;
import lombok.Setter;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import static com.github.egorovna26.obs_remote_control.message.Message.*;

@Getter
@Setter
@CustomLog
public class OBSRemoteSession extends WebSocketListener {
    private final Map<Class<? extends Event>, List<Consumer>> eventListeners = new ConcurrentHashMap<>();
    private final Map<UUID, Consumer> requestResponseListeners = new ConcurrentHashMap<>();
    private OkHttpClient okHttpClient;
    private String host;
    private int port;
    private String password;
    private boolean reconnection = false;
    private WebSocket webSocket;
    private Runnable onReady;

    public OBSRemoteSession() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(log::info);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public void connect(String host, int port, String password) {
        this.host = host;
        this.port = port;
        this.password = password;
        this.webSocket = okHttpClient.newWebSocket(new Request.Builder().url("ws://" + host + ":" + port + "/").build(), this);
        okHttpClient.connectionPool().evictAll();
        this.reconnection = true;
    }

    public void disconnect() {
        reconnection = false;
        if (webSocket != null) {
            webSocket.close(1000, null);
            webSocket = null;
        }
    }

    public void reconnect() {
        if (isReconnection()) {
            try {
                disconnect();
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                log.error("Reconnecting timeout error", e);
            } finally {
                log.info("Reconnected to OBS remote protocol");
                connect(host, port, password);
            }
        }
    }

    public void shutdown() {
        okHttpClient.dispatcher().executorService().shutdown();
    }

    public <T extends Event> void addEventListener(Class<T> cls, Consumer<T> listener) {
        List<Consumer> listeners;
        if (eventListeners.containsKey(cls)) {
            listeners = eventListeners.get(cls);
        } else {
            listeners = new CopyOnWriteArrayList<>();
        }
        listeners.add(listener);
        eventListeners.put(cls, listeners);
    }

    public <T extends Event> void removeEventListener(Class<T> cls, Consumer<T> listener) {
        List<Consumer> listeners;
        if (eventListeners.containsKey(cls)) {
            listeners = eventListeners.get(cls);
        } else {
            return;
        }
        listeners.remove(listener);
        eventListeners.put(cls, listeners);
    }

    public void sendRequest(UUID requestId, Message message, Consumer<? extends RequestResponse> consumer) {
        if (webSocket != null) {
            requestResponseListeners.put(requestId, consumer);
            String json = JsonUtil.toJson(message);
            webSocket.send(json);
        }
    }

    @Override
    public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
        log.info("Opened connection to OBS remote protocol");
    }

    @Override
    public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
        log.info("Received message from OBS remote protocol: " + text);
        Message message = JsonUtil.fromJson(text, Message.class);
        if (message != null) {
            switch (message.getOp()) {
                case HELLO:
                    onHello((Hello) message);
                    break;
                case IDENTIFIED:
                    onIdentified((Identified) message);
                    break;
                case EVENT:
                    onEvent((Event) message);
                    break;
                case REQUEST_RESPONSE:
                    onRequestResponse((RequestResponse) message);
                    break;
            }
        }
    }

    @Override
    public void onClosing(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
        log.info("Closing connection to OBS remote protocol");
        webSocket.close(1000, reason);
        this.webSocket = null;
    }

    @Override
    public void onClosed(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
        log.info("Closed connection to OBS remote protocol");
        reconnect();
    }

    @Override
    public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t, @Nullable Response response) {
        log.error("Failure while connecting to OBS remote protocol", t);
        reconnect();
    }

    private void onHello(Hello hello) {
        Identify identify = new Identify(hello.getRpcVersion());
        if (hello.authenticationRequired()) {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                String secretString = password + hello.getSalt();
                byte[] secretHash = digest.digest(secretString.getBytes(StandardCharsets.UTF_8));
                String encodedSecret = Base64.getEncoder().encodeToString(secretHash);
                String resultString = encodedSecret + hello.getChallenge();
                byte[] resultHash = digest.digest(resultString.getBytes(StandardCharsets.UTF_8));
                identify.setAuthentication(Base64.getEncoder().encodeToString(resultHash));
            } catch (Exception e) {
                log.error("Authentication error", e);
            }
        }
        webSocket.send(JsonUtil.toJson(identify));
    }

    private void onIdentified(Identified identified) {
        log.info(identified.toString());
        if (onReady != null) {
            onReady.run();
        }
    }

    private void onEvent(Event event) {
        log.info(event.toString());
        if (eventListeners.containsKey(event.getClass())) {
            List<Consumer> listeners = eventListeners.get(event.getClass());
            for (Consumer listener : listeners) {
                listener.accept(event);
            }
        }
    }

    private void onRequestResponse(RequestResponse requestResponse) {
        try {
            if (requestResponseListeners.containsKey(requestResponse.getRequestId())) {
                requestResponseListeners.get(requestResponse.getRequestId()).accept(requestResponse);
            }
        } finally {
            requestResponseListeners.remove(requestResponse.getRequestId());
        }
    }
}
