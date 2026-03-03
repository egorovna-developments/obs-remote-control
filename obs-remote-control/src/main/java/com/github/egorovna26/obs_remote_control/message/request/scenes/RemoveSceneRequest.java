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
 * Removes a scene from OBS.
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class RemoveSceneRequest extends Request<RemoveSceneRequest.Data> {
    /**
     * RemoveSceneRequest constructor
     */
    public RemoveSceneRequest(String canvasUuid, String sceneName, String sceneUuid) {
        super("RemoveScene", new Data(canvasUuid, sceneName, sceneUuid));
    }

    /**
     * RemoveScene Request Data
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
         * Name of the scene to remove
         */
        @JsonProperty("sceneName")
        private String sceneName;

        /**
         * UUID of the scene to remove
         */
        @JsonProperty("sceneUuid")
        private String sceneUuid;
    }
}
