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
 * Gets a list of all scene items in a scene.
 *
 * Scenes only
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class GetSceneItemListRequest extends Request<GetSceneItemListRequest.Data> {
    /**
     * GetSceneItemListRequest constructor
     */
    public GetSceneItemListRequest(String canvasUuid, String sceneName, String sceneUuid) {
        super("GetSceneItemList", new Data(canvasUuid, sceneName, sceneUuid));
    }

    /**
     * GetSceneItemList Request Data
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
         * Name of the scene to get the items of
         */
        @JsonProperty("sceneName")
        private String sceneName;

        /**
         * UUID of the scene to get the items of
         */
        @JsonProperty("sceneUuid")
        private String sceneUuid;
    }
}
