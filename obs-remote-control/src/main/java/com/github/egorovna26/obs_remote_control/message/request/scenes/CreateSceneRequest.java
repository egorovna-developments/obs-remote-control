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
 * Creates a new scene in OBS.
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class CreateSceneRequest extends Request<CreateSceneRequest.Data> {
    /**
     * CreateSceneRequest constructor
     */
    public CreateSceneRequest(String canvasUuid, String sceneName) {
        super("CreateScene", new Data(canvasUuid, sceneName));
    }

    /**
     * CreateScene Request Data
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
         * UUID of the canvas to create the new scene in. Leave default to assume main canvas
         */
        @JsonProperty("canvasUuid")
        private String canvasUuid;

        /**
         * Name for the new scene
         */
        @JsonProperty("sceneName")
        private String sceneName;
    }
}
