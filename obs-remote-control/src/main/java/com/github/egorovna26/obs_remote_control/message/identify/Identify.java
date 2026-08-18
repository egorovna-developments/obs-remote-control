package com.github.egorovna26.obs_remote_control.message.identify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.egorovna26.obs_remote_control.message.Message;
import lombok.*;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Identify extends Message {
    private static int ALL = 983039;

    @JsonProperty(value = "d")
    private Data data;

    public Identify(int rpcVersion) {
        this(rpcVersion, null, ALL);
    }

    public Identify(int rpcVersion, String authentication, int eventSubscriptions) {
        super(IDENTIFY);
        this.data = new Data(rpcVersion, authentication, eventSubscriptions);
    }

    public void setAuthentication(String authentication) {
        getData().setAuthentication(authentication);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString(callSuper = true)
    public static class Data implements Serializable {
        @JsonProperty(value = "rpcVersion")
        private int rpcVersion;
        @JsonProperty(value = "authentication")
        private String authentication;
        @JsonProperty(value = "eventSubscriptions")
        private int eventSubscriptions;
    }
}
