package com.github.egorovna26.obs_remote_control.message.request.scene_items;

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
 * Creates a new scene item using a source.
 *
 * Scenes only
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class CreateSceneItemRequest extends Request<CreateSceneItemRequest.Data> {
    /**
     * CreateSceneItemRequest constructor
     */
    public CreateSceneItemRequest(String canvasUuid, String sceneName, String sceneUuid,
            String sourceName, String sourceUuid, boolean sceneItemEnabled) {
        super("CreateSceneItem", new Data(canvasUuid, sceneName, sceneUuid, sourceName, sourceUuid, sceneItemEnabled));
    }

    /**
     * CreateSceneItem Request Data
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
         * Name of the scene to create the new item in
         */
        @JsonProperty("sceneName")
        private String sceneName;

        /**
         * UUID of the scene to create the new item in
         */
        @JsonProperty("sceneUuid")
        private String sceneUuid;

        /**
         * Name of the source to add to the scene
         */
        @JsonProperty("sourceName")
        private String sourceName;

        /**
         * UUID of the source to add to the scene
         */
        @JsonProperty("sourceUuid")
        private String sourceUuid;

        /**
         * Enable state to apply to the scene item on creation
         */
        @JsonProperty("sceneItemEnabled")
        private boolean sceneItemEnabled;
    }
}
