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
 * Sets the scene transition overridden for a scene.
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class SetSceneSceneTransitionOverrideRequest extends Request<SetSceneSceneTransitionOverrideRequest.Data> {
    /**
     * SetSceneSceneTransitionOverrideRequest constructor
     */
    public SetSceneSceneTransitionOverrideRequest(String canvasUuid, String sceneName,
            String sceneUuid, String transitionName, int transitionDuration) {
        super("SetSceneSceneTransitionOverride", new Data(canvasUuid, sceneName, sceneUuid, transitionName, transitionDuration));
    }

    /**
     * SetSceneSceneTransitionOverride Request Data
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

        /**
         * Name of the scene transition to use as override. Specify `null` to remove
         */
        @JsonProperty("transitionName")
        private String transitionName;

        /**
         * Duration to use for any overridden transition. Specify `null` to remove
         */
        @JsonProperty("transitionDuration")
        private int transitionDuration;
    }
}
