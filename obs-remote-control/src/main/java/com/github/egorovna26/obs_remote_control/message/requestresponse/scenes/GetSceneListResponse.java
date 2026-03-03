package com.github.egorovna26.obs_remote_control.message.requestresponse.scenes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.egorovna26.obs_remote_control.message.requestresponse.RequestResponse;
import java.io.Serializable;
import java.lang.Object;
import java.lang.String;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Gets an array of scenes in OBS.
 */
@NoArgsConstructor
@Getter
@Setter
@ToString(
        callSuper = true
)
public class GetSceneListResponse extends RequestResponse<GetSceneListResponse.Data> {
    /**
     * @return Current program scene name. Can be `null` if non-main canvas or internal state desync
     */
    public String getCurrentProgramSceneName() {
        return getData().getResponseData().getCurrentProgramSceneName();
    }

    /**
     * @return Current program scene UUID. Can be `null` if non-main canvas or internal state desync
     */
    public String getCurrentProgramSceneUuid() {
        return getData().getResponseData().getCurrentProgramSceneUuid();
    }

    /**
     * @return Current preview scene name. `null` if not in studio mode or non-main canvas
     */
    public String getCurrentPreviewSceneName() {
        return getData().getResponseData().getCurrentPreviewSceneName();
    }

    /**
     * @return Current preview scene UUID. `null` if not in studio mode or non-main canvas
     */
    public String getCurrentPreviewSceneUuid() {
        return getData().getResponseData().getCurrentPreviewSceneUuid();
    }

    /**
     * @return Array of scenes
     */
    public Object getScenes() {
        return getData().getResponseData().getScenes();
    }

    /**
     * GetSceneList Request Response Data
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
         * Current program scene name. Can be `null` if non-main canvas or internal state desync
         */
        @JsonProperty("currentProgramSceneName")
        private String currentProgramSceneName;

        /**
         * Current program scene UUID. Can be `null` if non-main canvas or internal state desync
         */
        @JsonProperty("currentProgramSceneUuid")
        private String currentProgramSceneUuid;

        /**
         * Current preview scene name. `null` if not in studio mode or non-main canvas
         */
        @JsonProperty("currentPreviewSceneName")
        private String currentPreviewSceneName;

        /**
         * Current preview scene UUID. `null` if not in studio mode or non-main canvas
         */
        @JsonProperty("currentPreviewSceneUuid")
        private String currentPreviewSceneUuid;

        /**
         * Array of scenes
         */
        @JsonProperty("scenes")
        private Object scenes;
    }
}
