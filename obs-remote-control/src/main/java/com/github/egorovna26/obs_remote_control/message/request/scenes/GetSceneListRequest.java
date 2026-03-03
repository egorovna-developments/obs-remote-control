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
 * Gets an array of scenes in OBS.
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class GetSceneListRequest extends Request<GetSceneListRequest.Data> {
    /**
     * GetSceneListRequest constructor
     */
    public GetSceneListRequest(String canvasUuid) {
        super("GetSceneList", new Data(canvasUuid));
    }

    /**
     * GetSceneList Request Data
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
         * UUID of the canvas the scenes are in
         */
        @JsonProperty("canvasUuid")
        private String canvasUuid;
    }
}
