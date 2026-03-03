package com.github.egorovna26.obs_remote_control.message.request.filters;

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
 * Gets an array of all of a source's filters.
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class GetSourceFilterListRequest extends Request<GetSourceFilterListRequest.Data> {
    /**
     * GetSourceFilterListRequest constructor
     */
    public GetSourceFilterListRequest(String canvasUuid, String sourceName, String sourceUuid) {
        super("GetSourceFilterList", new Data(canvasUuid, sourceName, sourceUuid));
    }

    /**
     * GetSourceFilterList Request Data
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
         * UUID of the canvas the source is in, if using the sourceName field
         */
        @JsonProperty("canvasUuid")
        private String canvasUuid;

        /**
         * Name of the source
         */
        @JsonProperty("sourceName")
        private String sourceName;

        /**
         * UUID of the source
         */
        @JsonProperty("sourceUuid")
        private String sourceUuid;
    }
}
