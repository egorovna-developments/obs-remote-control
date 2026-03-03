package com.github.egorovna26.obs_remote_control.message.requestresponse.canvases;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.egorovna26.obs_remote_control.message.requestresponse.RequestResponse;
import java.io.Serializable;
import java.lang.Object;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Gets an array of canvases in OBS.
 */
@NoArgsConstructor
@Getter
@Setter
@ToString(
        callSuper = true
)
public class GetCanvasListResponse extends RequestResponse<GetCanvasListResponse.Data> {
    /**
     * @return Array of canvases
     */
    public Object getCanvases() {
        return getData().getResponseData().getCanvases();
    }

    /**
     * GetCanvasList Request Response Data
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
         * Array of canvases
         */
        @JsonProperty("canvases")
        private Object canvases;
    }
}
