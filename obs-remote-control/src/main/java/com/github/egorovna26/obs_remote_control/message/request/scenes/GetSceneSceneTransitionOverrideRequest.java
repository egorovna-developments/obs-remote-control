package com.github.egorovna26.obs_remote_control.message.request.scenes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.egorovna26.obs_remote_control.message.request.Request;
import java.io.Serializable;
import java.lang.String;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Gets the scene transition overridden for a scene.
 *
 * Note: A transition UUID response field is not currently able to be implemented as of 2024-1-18.
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class GetSceneSceneTransitionOverrideRequest extends Request<GetSceneSceneTransitionOverrideRequest.Data> {
    /**
     * GetSceneSceneTransitionOverrideRequest constructor
     */
    public GetSceneSceneTransitionOverrideRequest(String canvasUuid, String sceneName,
            String sceneUuid) {
        super("GetSceneSceneTransitionOverride", new Data(canvasUuid, sceneName, sceneUuid));
    }

    /**
     * GetSceneSceneTransitionOverride Request Data
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
         * UUID of the canvas the scene is in, if using the sceneName field
         */
        @JsonProperty("canvasUuid")
        private String canvasUuid;

        /**
         * Name of the scene
         */
        @JsonProperty("sceneName")
        private String sceneName;

        /**
         * UUID of the scene
         */
        @JsonProperty("sceneUuid")
        private String sceneUuid;
    }
}
