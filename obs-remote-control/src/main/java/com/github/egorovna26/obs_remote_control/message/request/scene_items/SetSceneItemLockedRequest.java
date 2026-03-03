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
 * Sets the lock state of a scene item.
 *
 * Scenes and Group
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class SetSceneItemLockedRequest extends Request<SetSceneItemLockedRequest.Data> {
    /**
     * SetSceneItemLockedRequest constructor
     */
    public SetSceneItemLockedRequest(String canvasUuid, String sceneName, String sceneUuid,
            int sceneItemId, boolean sceneItemLocked) {
        super("SetSceneItemLocked", new Data(canvasUuid, sceneName, sceneUuid, sceneItemId, sceneItemLocked));
    }

    /**
     * SetSceneItemLocked Request Data
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
         * New lock state of the scene item
         */
        @JsonProperty("sceneItemLocked")
        private boolean sceneItemLocked;
    }
}
