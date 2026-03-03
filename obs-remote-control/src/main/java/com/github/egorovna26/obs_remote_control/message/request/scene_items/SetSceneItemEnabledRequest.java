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
 * Sets the enable state of a scene item.
 *
 * Scenes and Groups
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class SetSceneItemEnabledRequest extends Request<SetSceneItemEnabledRequest.Data> {
    /**
     * SetSceneItemEnabledRequest constructor
     */
    public SetSceneItemEnabledRequest(String canvasUuid, String sceneName, String sceneUuid,
            int sceneItemId, boolean sceneItemEnabled) {
        super("SetSceneItemEnabled", new Data(canvasUuid, sceneName, sceneUuid, sceneItemId, sceneItemEnabled));
    }

    /**
     * SetSceneItemEnabled Request Data
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
         * New enable state of the scene item
         */
        @JsonProperty("sceneItemEnabled")
        private boolean sceneItemEnabled;
    }
}
