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
 * Searches a scene for a source, and returns its id.
 *
 * Scenes and Groups
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class GetSceneItemIdRequest extends Request<GetSceneItemIdRequest.Data> {
    /**
     * GetSceneItemIdRequest constructor
     */
    public GetSceneItemIdRequest(String canvasUuid, String sceneName, String sceneUuid,
            String sourceName, int searchOffset) {
        super("GetSceneItemId", new Data(canvasUuid, sceneName, sceneUuid, sourceName, searchOffset));
    }

    /**
     * GetSceneItemId Request Data
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
         * UUID of the canvas the scene or group is in, if using the sceneName field
         */
        @JsonProperty("canvasUuid")
        private String canvasUuid;

        /**
         * Name of the scene or group to search in
         */
        @JsonProperty("sceneName")
        private String sceneName;

        /**
         * UUID of the scene or group to search in
         */
        @JsonProperty("sceneUuid")
        private String sceneUuid;

        /**
         * Name of the source to find
         */
        @JsonProperty("sourceName")
        private String sourceName;

        /**
         * Number of matches to skip during search. &gt;= 0 means first forward. -1 means last (top) item
         */
        @JsonProperty("searchOffset")
        private int searchOffset;
    }
}
