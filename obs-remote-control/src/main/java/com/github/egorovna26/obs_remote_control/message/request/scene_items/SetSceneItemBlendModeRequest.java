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
 * Sets the blend mode of a scene item.
 *
 * Scenes and Groups
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class SetSceneItemBlendModeRequest extends Request<SetSceneItemBlendModeRequest.Data> {
    /**
     * SetSceneItemBlendModeRequest constructor
     */
    public SetSceneItemBlendModeRequest(String canvasUuid, String sceneName, String sceneUuid,
            int sceneItemId, String sceneItemBlendMode) {
        super("SetSceneItemBlendMode", new Data(canvasUuid, sceneName, sceneUuid, sceneItemId, sceneItemBlendMode));
    }

    /**
     * SetSceneItemBlendMode Request Data
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
         * New blend mode
         */
        @JsonProperty("sceneItemBlendMode")
        private String sceneItemBlendMode;
    }
}
