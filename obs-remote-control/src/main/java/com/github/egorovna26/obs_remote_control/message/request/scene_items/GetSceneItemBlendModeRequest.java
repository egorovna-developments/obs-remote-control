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
 * Gets the blend mode of a scene item.
 *
 * Blend modes:
 *
 * - `OBS_BLEND_NORMAL`
 * - `OBS_BLEND_ADDITIVE`
 * - `OBS_BLEND_SUBTRACT`
 * - `OBS_BLEND_SCREEN`
 * - `OBS_BLEND_MULTIPLY`
 * - `OBS_BLEND_LIGHTEN`
 * - `OBS_BLEND_DARKEN`
 *
 * Scenes and Groups
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class GetSceneItemBlendModeRequest extends Request<GetSceneItemBlendModeRequest.Data> {
    /**
     * GetSceneItemBlendModeRequest constructor
     */
    public GetSceneItemBlendModeRequest(String canvasUuid, String sceneName, String sceneUuid,
            int sceneItemId) {
        super("GetSceneItemBlendMode", new Data(canvasUuid, sceneName, sceneUuid, sceneItemId));
    }

    /**
     * GetSceneItemBlendMode Request Data
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
    }
}
