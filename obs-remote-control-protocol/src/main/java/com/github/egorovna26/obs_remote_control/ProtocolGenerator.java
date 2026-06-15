package com.github.egorovna26.obs_remote_control;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.egorovna26.obs_remote_control.message.event.Event;
import com.github.egorovna26.obs_remote_control.message.requestresponse.RequestResponse;
import com.github.egorovna26.obs_remote_control.protocol.*;
import com.github.egorovna26.obs_remote_control.session.BlockingConsumer;
import com.github.egorovna26.obs_remote_control.session.OBSRemoteSession;
import com.github.egorovna26.obs_remote_control.util.Utils;
import com.squareup.javapoet.*;
import lombok.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;

import javax.lang.model.element.Modifier;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ProtocolGenerator {
    private static final String URL = "https://raw.githubusercontent.com/obsproject/obs-websocket/master/docs/generated/protocol.json";
    private static final Path BASE_PATH = Paths.get("obs-remote-control/src/main/java");
    private static final String EVENTS = "com.github.egorovna26.obs_remote_control.message.event";
    private static final String REQUESTS = "com.github.egorovna26.obs_remote_control.message.request";
    private static final String RESPONSES = "com.github.egorovna26.obs_remote_control.message.requestresponse";

    public static void main(String[] args) throws Exception {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        try (Response response = okHttpClient.newCall(new Request.Builder().url(URL).build()).execute()) {
            if (response.body() != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                Protocol protocol = objectMapper.readValue(response.body().string(), Protocol.class);

                normalize(protocol);

                generateEvents(protocol.getEvents());
                generateRequest(protocol.getRequests());
                generateResponse(protocol.getRequests());
                generateBase(protocol.getRequests());
            }
        }
    }

    private static void normalize(Protocol protocol) {
        for (ProtocolRequest protocolRequest : protocol.getRequests()) {
            protocolRequest.setCategory(StringUtils.replace(protocolRequest.getCategory(), " ", "_"));
            protocolRequest.setDescription(StringUtils.replace(protocolRequest.getDescription(), "\\", "\\\\"));
            protocolRequest.setDescription(StringUtils.replace(protocolRequest.getDescription(), "<", "&lt;"));
            protocolRequest.setDescription(StringUtils.replace(protocolRequest.getDescription(), ">", "&gt;"));
            for (ProtocolRequestField protocolRequestField : protocolRequest.getRequestFields()) {
                protocolRequestField.setValueDescription(StringUtils.replace(protocolRequestField.getValueDescription(), "\\", "\\\\"));
                protocolRequestField.setValueDescription(StringUtils.replace(protocolRequestField.getValueDescription(), "<", "&lt;"));
                protocolRequestField.setValueDescription(StringUtils.replace(protocolRequestField.getValueDescription(), ">", "&gt;"));
            }
            for (ProtocolResponseField protocolResponseField : protocolRequest.getResponseFields()) {
                protocolResponseField.setValueDescription(StringUtils.replace(protocolResponseField.getValueDescription(), "\\", "\\\\"));
                protocolResponseField.setValueDescription(StringUtils.replace(protocolResponseField.getValueDescription(), "<", "&lt;"));
                protocolResponseField.setValueDescription(StringUtils.replace(protocolResponseField.getValueDescription(), ">", "&gt;"));
            }
        }
        for (ProtocolEvent protocolEvent : protocol.getEvents()) {
            protocolEvent.setCategory(StringUtils.replace(protocolEvent.getCategory(), " ", "_"));
            protocolEvent.setDescription(StringUtils.replace(protocolEvent.getDescription(), "\\", "\\\\"));
            protocolEvent.setDescription(StringUtils.replace(protocolEvent.getDescription(), "<", "&lt;"));
            protocolEvent.setDescription(StringUtils.replace(protocolEvent.getDescription(), ">", "&gt;"));
            for (ProtocolDataField protocolDataField : protocolEvent.getDataFields()) {
                protocolDataField.setValueDescription(StringUtils.replace(protocolDataField.getValueDescription(), "\\", "\\\\"));
                protocolDataField.setValueDescription(StringUtils.replace(protocolDataField.getValueDescription(), "<", "&lt;"));
                protocolDataField.setValueDescription(StringUtils.replace(protocolDataField.getValueDescription(), ">", "&gt;"));
            }
        }
    }

    private static void generateEvents(List<ProtocolEvent> protocolEvents) throws Exception {
        TypeSpec.Builder eventTypeBuilder = TypeSpec
                .enumBuilder("EventType")
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(Serializable.class)
                .addAnnotation(RequiredArgsConstructor.class)
                .addAnnotation(Getter.class)
                .addField(FieldSpec.builder(String.class, "eventType")
                        .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                        .build())
                .addField(FieldSpec.builder(ParameterizedTypeName.get(ClassName.get(Class.class),
                                WildcardTypeName.subtypeOf(Event.class)), "eventClass")
                        .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                        .build())
                .addMethod(MethodSpec.methodBuilder("find")
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .addParameter(String.class, "eventType")
                        .returns(ClassName.get(EVENTS, "EventType"))
                        .beginControlFlow("for (EventType value : EventType.values())")
                        .beginControlFlow("if ($T.equalsIgnoreCase(eventType, value.getEventType()))", StringUtils.class)
                        .addStatement("return value")
                        .endControlFlow()
                        .endControlFlow()
                        .addStatement("return null")
                        .build())
                .addJavadoc("Event Types");
        for (ProtocolEvent protocolEvent : protocolEvents) {
            eventTypeBuilder.addEnumConstant(Utils.uc2uu(protocolEvent.getEventType()),
                    TypeSpec.anonymousClassBuilder("$S, $T.class", protocolEvent.getEventType(),
                                    ClassName.get(EVENTS + "." + protocolEvent.getCategory(),
                                            protocolEvent.getEventType()))
                            .addJavadoc(protocolEvent.getDescription())
                            .build());
            TypeSpec.Builder eventBuilder = TypeSpec
                    .classBuilder(protocolEvent.getEventType())
                    .addModifiers(Modifier.PUBLIC);
            if (protocolEvent.getDataFields().isEmpty()) {
                eventBuilder.superclass(ParameterizedTypeName.get(ClassName.get(Event.class), ClassName.get(Void.class)));
            } else {
                eventBuilder.superclass(ParameterizedTypeName.get(ClassName.get(Event.class),
                        ClassName.get("", protocolEvent.getEventType() + ".Data")));
                TypeSpec.Builder dataBuilder = TypeSpec.classBuilder("Data")
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .addSuperinterface(Serializable.class)
                        .addAnnotation(NoArgsConstructor.class);
                if (!protocolEvent.getDataFields().isEmpty()) {
                    dataBuilder.addAnnotation(AllArgsConstructor.class);
                }
                dataBuilder
                        .addAnnotation(Getter.class)
                        .addAnnotation(Setter.class)
                        .addAnnotation(AnnotationSpec.builder(ToString.class)
                                .addMember("callSuper", "true")
                                .build())
                        .addJavadoc(protocolEvent.getEventType() + " Event Data");
                for (ProtocolDataField protocolDataField : protocolEvent.getDataFields()) {
                    dataBuilder.addField(FieldSpec
                            .builder(convertType(protocolDataField.getValueType()), protocolDataField.getValueName())
                            .addModifiers(Modifier.PRIVATE)
                            .addAnnotation(AnnotationSpec.builder(JsonProperty.class)
                                    .addMember("value", "\"" + protocolDataField.getValueName() + "\"")
                                    .build())
                            .addJavadoc(protocolDataField.getValueDescription())
                            .build());
                    MethodSpec.Builder dataFieldBuilder;
                    if (StringUtils.equalsIgnoreCase(protocolDataField.getValueType(), "Boolean")) {
                        if (StringUtils.startsWith(protocolDataField.getValueName(), "is")) {
                            dataFieldBuilder = MethodSpec
                                    .methodBuilder(protocolDataField.getValueName())
                                    .addStatement("return getData().getEventData()." + protocolDataField.getValueName() + "()");
                        } else {
                            dataFieldBuilder = MethodSpec
                                    .methodBuilder("is" + Utils.lc2uc(protocolDataField.getValueName()))
                                    .addStatement("return getData().getEventData().is" + Utils.lc2uc(protocolDataField.getValueName()) + "()");
                        }
                    } else {
                        dataFieldBuilder = MethodSpec
                                .methodBuilder("get" + Utils.lc2uc(protocolDataField.getValueName()))
                                .addStatement("return getData().getEventData().get" + Utils.lc2uc(protocolDataField.getValueName()) + "()");
                    }
                    dataFieldBuilder.addModifiers(Modifier.PUBLIC)
                            .returns(convertType(protocolDataField.getValueType()))
                            .addJavadoc("@return " + protocolDataField.getValueDescription());
                    eventBuilder
                            .addMethod(dataFieldBuilder.build());
                }
                eventBuilder.addType(dataBuilder.build());
            }
            eventBuilder
                    .addAnnotation(NoArgsConstructor.class)
                    .addAnnotation(Getter.class)
                    .addAnnotation(Setter.class)
                    .addAnnotation(AnnotationSpec.builder(ToString.class)
                            .addMember("callSuper", "true")
                            .build())
                    .addJavadoc(protocolEvent.getDescription());
            JavaFile.builder(EVENTS + "." + protocolEvent.getCategory(), eventBuilder.build())
                    .indent("    ")
                    .build()
                    .writeTo(BASE_PATH);
        }
        JavaFile.builder(EVENTS, eventTypeBuilder.build())
                .indent("    ")
                .build()
                .writeTo(BASE_PATH);
    }

    private static void generateRequest(List<ProtocolRequest> requests) throws Exception {
        TypeSpec.Builder requestTypeBuilder = TypeSpec
                .enumBuilder("RequestType")
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(Serializable.class)
                .addAnnotation(RequiredArgsConstructor.class)
                .addAnnotation(Getter.class)
                .addField(FieldSpec.builder(String.class, "requestType")
                        .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                        .build())
                .addField(FieldSpec.builder(ParameterizedTypeName.get(ClassName.get(Class.class),
                                WildcardTypeName.subtypeOf(com.github.egorovna26.obs_remote_control.message.request.Request.class)), "requestClass")
                        .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                        .build())
                .addField(FieldSpec.builder(ParameterizedTypeName.get(ClassName.get(Class.class),
                                WildcardTypeName.subtypeOf(RequestResponse.class)), "responseClass")
                        .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                        .build())
                .addMethod(MethodSpec.methodBuilder("find")
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .addParameter(String.class, "requestType")
                        .returns(ClassName.get(REQUESTS, "RequestType"))
                        .beginControlFlow("for (RequestType value : RequestType.values())")
                        .beginControlFlow("if ($T.equalsIgnoreCase(requestType, value.getRequestType()))", StringUtils.class)
                        .addStatement("return value")
                        .endControlFlow()
                        .endControlFlow()
                        .addStatement("return null")
                        .build())
                .addJavadoc("Request Types");
        for (ProtocolRequest protocolRequest : requests) {
            requestTypeBuilder.addEnumConstant(Utils.uc2uu(protocolRequest.getRequestType()),
                    TypeSpec.anonymousClassBuilder("$S, $T.class, $T.class",
                                    protocolRequest.getRequestType(),
                                    ClassName.get(REQUESTS + "." + protocolRequest.getCategory(),
                                            protocolRequest.getRequestType() + "Request"),
                                    ClassName.get(RESPONSES + "." + protocolRequest.getCategory(),
                                            protocolRequest.getRequestType() + "Response"))
                            .addJavadoc(protocolRequest.getDescription())
                            .build());
            TypeSpec.Builder requestBuilder = TypeSpec
                    .classBuilder(protocolRequest.getRequestType() + "Request")
                    .addModifiers(Modifier.PUBLIC);
            MethodSpec.Builder requestConstructorBuilder = MethodSpec.constructorBuilder()
                    .addModifiers(Modifier.PUBLIC)
                    .addJavadoc(protocolRequest.getRequestType() + "Request constructor");
            CodeBlock.Builder requestSuperBuilder = CodeBlock
                    .builder()
                    .add("super($S", protocolRequest.getRequestType());
            if (protocolRequest.getRequestFields().isEmpty()) {
                requestSuperBuilder.add(", null)");
                requestBuilder.superclass(ParameterizedTypeName.get(ClassName.get(com.github.egorovna26.obs_remote_control.message.request.Request.class), ClassName.get(Void.class)));
            } else {
                requestSuperBuilder.add(", new Data(");
                requestSuperBuilder.add(protocolRequest.getRequestFields().stream()
                        .map(ProtocolRequestField::getValueName)
                        .filter(valueName -> StringUtils.containsNone(valueName, "."))
                        .collect(Collectors.joining(", ")));
                requestSuperBuilder.add("))");
                requestBuilder.superclass(ParameterizedTypeName.get(ClassName.get(com.github.egorovna26.obs_remote_control.message.request.Request.class),
                        ClassName.get("", protocolRequest.getRequestType() + "Request.Data")));
                TypeSpec.Builder dataBuilder = TypeSpec.classBuilder("Data")
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .addSuperinterface(Serializable.class)
                        .addAnnotation(NoArgsConstructor.class);
                if (!protocolRequest.getRequestFields().isEmpty()) {
                    dataBuilder.addAnnotation(AllArgsConstructor.class);
                }
                dataBuilder
                        .addAnnotation(Getter.class)
                        .addAnnotation(Setter.class)
                        .addAnnotation(AnnotationSpec.builder(ToString.class)
                                .addMember("callSuper", "true")
                                .build())
                        .addJavadoc(protocolRequest.getRequestType() + " Request Data");
                for (ProtocolRequestField protocolRequestField : protocolRequest.getRequestFields()) {
                    if (StringUtils.contains(protocolRequestField.getValueName(), ".")) {
                        continue;
                    }
                    requestConstructorBuilder.addParameter(convertType(protocolRequestField.getValueType()), protocolRequestField.getValueName());
                    dataBuilder.addField(FieldSpec
                            .builder(convertType(protocolRequestField.getValueType()), protocolRequestField.getValueName())
                            .addModifiers(Modifier.PRIVATE)
                            .addAnnotation(AnnotationSpec.builder(JsonProperty.class)
                                    .addMember("value", "\"" + protocolRequestField.getValueName() + "\"")
                                    .build())
                            .addJavadoc(protocolRequestField.getValueDescription())
                            .build());
                }
                requestBuilder.addType(dataBuilder.build());
            }
            requestConstructorBuilder.addStatement(requestSuperBuilder.build());
            requestBuilder
                    .addAnnotation(Getter.class)
                    .addAnnotation(Setter.class)
                    .addAnnotation(AnnotationSpec.builder(ToString.class)
                            .addMember("callSuper", "true")
                            .build())
                    .addMethod(requestConstructorBuilder.build())
                    .addJavadoc(protocolRequest.getDescription());
            JavaFile.builder(REQUESTS + "." + protocolRequest.getCategory(), requestBuilder.build())
                    .indent("    ")
                    .build()
                    .writeTo(BASE_PATH);
        }
        JavaFile.builder(REQUESTS, requestTypeBuilder.build())
                .indent("    ")
                .build()
                .writeTo(BASE_PATH);
    }

    private static void generateResponse(List<ProtocolRequest> requests) throws Exception {
        for (ProtocolRequest protocolRequest : requests) {
            TypeSpec.Builder responseBuilder = TypeSpec
                    .classBuilder(protocolRequest.getRequestType() + "Response")
                    .addModifiers(Modifier.PUBLIC);
            if (protocolRequest.getResponseFields().isEmpty()) {
                responseBuilder.superclass(ParameterizedTypeName.get(ClassName.get(RequestResponse.class), ClassName.get(Void.class)));
            } else {
                responseBuilder.superclass(ParameterizedTypeName.get(ClassName.get(RequestResponse.class),
                        ClassName.get("", protocolRequest.getRequestType() + "Response.Data")));
                TypeSpec.Builder dataBuilder = TypeSpec.classBuilder("Data")
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .addSuperinterface(Serializable.class)
                        .addAnnotation(NoArgsConstructor.class);
                if (!protocolRequest.getResponseFields()
                        .isEmpty()) {
                    dataBuilder.addAnnotation(AllArgsConstructor.class);
                }
                dataBuilder
                        .addAnnotation(Getter.class)
                        .addAnnotation(Setter.class)
                        .addAnnotation(AnnotationSpec.builder(ToString.class)
                                .addMember("callSuper", "true")
                                .build())
                        .addJavadoc(protocolRequest.getRequestType() + " Request Response Data");
                for (ProtocolResponseField protocolResponseField : protocolRequest.getResponseFields()) {
                    dataBuilder.addField(FieldSpec
                            .builder(convertType(protocolResponseField.getValueType()), protocolResponseField.getValueName())
                            .addModifiers(Modifier.PRIVATE)
                            .addAnnotation(AnnotationSpec.builder(JsonProperty.class)
                                    .addMember("value", "\"" + protocolResponseField.getValueName() + "\"")
                                    .build())
                            .addJavadoc(protocolResponseField.getValueDescription())
                            .build());
                    MethodSpec.Builder dataFieldBuilder;
                    if (StringUtils.equalsIgnoreCase(protocolResponseField.getValueType(), "Boolean")) {
                        if (StringUtils.startsWith(protocolResponseField.getValueName(), "is")) {
                            dataFieldBuilder = MethodSpec
                                    .methodBuilder(protocolResponseField.getValueName())
                                    .addStatement("return getData().getResponseData()." + protocolResponseField.getValueName() + "()");
                        } else {
                            dataFieldBuilder = MethodSpec
                                    .methodBuilder("is" + Utils.lc2uc(protocolResponseField.getValueName()))
                                    .addStatement("return getData().getResponseData().is" + Utils.lc2uc(protocolResponseField.getValueName()) + "()");
                        }
                    } else {
                        dataFieldBuilder = MethodSpec
                                .methodBuilder("get" + Utils.lc2uc(protocolResponseField.getValueName()))
                                .addStatement("return getData().getResponseData().get" + Utils.lc2uc(protocolResponseField.getValueName()) + "()");
                    }
                    dataFieldBuilder.addModifiers(Modifier.PUBLIC)
                            .returns(convertType(protocolResponseField.getValueType()))
                            .addJavadoc("@return " + protocolResponseField.getValueDescription());
                    responseBuilder
                            .addMethod(dataFieldBuilder.build());
                }
                responseBuilder.addType(dataBuilder.build());
            }
            responseBuilder
                    .addAnnotation(NoArgsConstructor.class)
                    .addAnnotation(Getter.class)
                    .addAnnotation(Setter.class)
                    .addAnnotation(AnnotationSpec.builder(ToString.class)
                            .addMember("callSuper", "true")
                            .build())
                    .addJavadoc(protocolRequest.getDescription());
            JavaFile.builder(RESPONSES + "." + protocolRequest.getCategory(), responseBuilder.build())
                    .indent("    ")
                    .build()
                    .writeTo(BASE_PATH);
        }
    }

    private static void generateBase(List<ProtocolRequest> protocolRequests) throws Exception {
        TypeSpec.Builder baseBuilder = TypeSpec.classBuilder("OBSRemoteControlBase")
                .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                .addAnnotation(RequiredArgsConstructor.class)
                .addAnnotation(CustomLog.class)
                .addField(FieldSpec.builder(int.class, "DEFAULT_TIMEOUT")
                        .addModifiers(Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
                        .initializer("2000")
                        .build())
                .addField(FieldSpec.builder(OBSRemoteSession.class, "session")
                        .addModifiers(Modifier.PROTECTED, Modifier.FINAL)
                        .initializer("new $T()", OBSRemoteSession.class)
                        .build())
                .addField(FieldSpec.builder(int.class, "timeout")
                        .addModifiers(Modifier.PROTECTED)
                        .addAnnotation(Getter.class)
                        .addAnnotation(Setter.class)
                        .initializer("DEFAULT_TIMEOUT")
                        .build());
        for (ProtocolRequest protocolRequest : protocolRequests) {
            MethodSpec.Builder requestBaseBuilder = MethodSpec.methodBuilder(Utils.uc2lc(protocolRequest.getRequestType()))
                    .addModifiers(Modifier.PUBLIC)
                    .returns(ClassName.get(RESPONSES + "." + protocolRequest.getCategory(), protocolRequest.getRequestType() + "Response"))
                    .addJavadoc(protocolRequest.getDescription());
            for (ProtocolRequestField protocolRequestField : protocolRequest.getRequestFields()) {
                if (StringUtils.containsNone(protocolRequestField.getValueName(), ".")) {
                    requestBaseBuilder.addParameter(convertType(protocolRequestField.getValueType()), protocolRequestField.getValueName());
                }
            }
            requestBaseBuilder.addStatement("return send(new $T(" +
                    protocolRequest.getRequestFields().stream()
                            .map(ProtocolRequestField::getValueName)
                            .filter(value -> StringUtils.containsNone(value, "."))
                            .collect(Collectors.joining(", "))
                    + "))", ClassName.get(REQUESTS + "." + protocolRequest.getCategory(), protocolRequest.getRequestType() + "Request"));
            baseBuilder.addMethod(requestBaseBuilder.build());
        }
        baseBuilder.addMethod(MethodSpec.methodBuilder("send")
                .addModifiers(Modifier.PRIVATE)
                .addTypeVariable(TypeVariableName.get("R", com.github.egorovna26.obs_remote_control.message.request.Request.class))
                .addTypeVariable(TypeVariableName.get("RR", RequestResponse.class))
                .returns(TypeVariableName.get("RR"))
                .addParameter(TypeVariableName.get("R"), "request")
                .addStatement("$T<RR> blockingConsumer = new $T<>()", BlockingConsumer.class, BlockingConsumer.class)
                .addStatement("session.sendRequest(request.getRequestId(), request, blockingConsumer)")
                .beginControlFlow("try")
                .addStatement("return blockingConsumer.get(timeout)")
                .nextControlFlow("catch ($T e)", Exception.class)
                .addStatement("log.error(\"Send error\", e)")
                .endControlFlow()
                .addStatement("return null")
                .addJavadoc("Send blocking request")
                .build());
        JavaFile.builder("com.github.egorovna26.obs_remote_control", baseBuilder.build())
                .indent("    ")
                .build()
                .writeTo(BASE_PATH);
    }

    private static Type convertType(String valueType) {
        switch (valueType) {
            case "Object":
                return Object.class;
            case "Number":
                return int.class;
            case "String":
                return String.class;
            case "Boolean":
                return boolean.class;

        }
        return Object.class;
    }
}
