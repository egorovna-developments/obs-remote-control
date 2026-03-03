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
 * Duplicates a scene item, copying all transform and crop info.
 *
 * Scenes only
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class DuplicateSceneItemRequest extends Request<DuplicateSceneItemRequest.Data> {
    /**
     * DuplicateSceneItemRequest constructor
     */
    public DuplicateSceneItemRequest(String canvasUuid, String sceneName, String sceneUuid,
            int sceneItemId, String destinationSceneName, String destinationSceneUuid) {
        super("DuplicateSceneItem", new Data(canvasUuid, sceneName, sceneUuid, sceneItemId, destinationSceneName, destinationSceneUuid));
    }

    /**
     * DuplicateSceneItem Request Data
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
         * Name of the scene the item is in
         */
        @JsonProperty("sceneName")
        private String sceneName;

        /**
         * UUID of the scene the item is in
         */
        @JsonProperty("sceneUuid")
        private String sceneUuid;

        /**
         * Numeric ID of the scene item
         */
        @JsonProperty("sceneItemId")
        private int sceneItemId;

        /**
         * Name of the scene to create the duplicated item in
         */
        @JsonProperty("destinationSceneName")
        private String destinationSceneName;

        /**
         * UUID of the scene to create the duplicated item in
         */
        @JsonProperty("destinationSceneUuid")
        private String destinationSceneUuid;
    }
}
