package com.github.egorovna26.obs_remote_control.message.requestresponse.scenes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.egorovna26.obs_remote_control.message.requestresponse.RequestResponse;
import java.io.Serializable;
import java.lang.String;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Gets the current program scene.
 *
 * Note 1: This request is slated to have the `currentProgram`-prefixed fields removed from in an upcoming RPC version.
 *
 * Note 2: Canvases do not have any concept of a program or preview scene, so this request does not support canvases.
 */
@NoArgsConstructor
@Getter
@Setter
@ToString(
        callSuper = true
)
public class GetCurrentProgramSceneResponse extends RequestResponse<GetCurrentProgramSceneResponse.Data> {
    /**
     * @return Current program scene name
     */
    public String getSceneName() {
        return getData().getResponseData().getSceneName();
    }

    /**
     * @return Current program scene UUID
     */
    public String getSceneUuid() {
        return getData().getResponseData().getSceneUuid();
    }

    /**
     * @return Current program scene name (Deprecated)
     */
    public String getCurrentProgramSceneName() {
        return getData().getResponseData().getCurrentProgramSceneName();
    }

    /**
     * @return Current program scene UUID (Deprecated)
     */
    public String getCurrentProgramSceneUuid() {
        return getData().getResponseData().getCurrentProgramSceneUuid();
    }

    /**
     * GetCurrentProgramScene Request Response Data
     */
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString(
            callSuper = true
    )
    public static class Data implements Serializable {
        /**
         * Current program scene name
         */
        @JsonProperty("sceneName")
        private String sceneName;

        /**
         * Current program scene UUID
         */
        @JsonProperty("sceneUuid")
        private String sceneUuid;

        /**
         * Current program scene name (Deprecated)
         */
        @JsonProperty("currentProgramSceneName")
        private String currentProgramSceneName;

        /**
         * Current program scene UUID (Deprecated)
         */
        @JsonProperty("currentProgramSceneUuid")
        private String currentProgramSceneUuid;
    }
}
