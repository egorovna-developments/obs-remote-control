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
 * Gets the info for a specific source filter.
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class GetSourceFilterRequest extends Request<GetSourceFilterRequest.Data> {
    /**
     * GetSourceFilterRequest constructor
     */
    public GetSourceFilterRequest(String canvasUuid, String sourceName, String sourceUuid,
            String filterName) {
        super("GetSourceFilter", new Data(canvasUuid, sourceName, sourceUuid, filterName));
    }

    /**
     * GetSourceFilter Request Data
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

        /**
         * Name of the filter
         */
        @JsonProperty("filterName")
        private String filterName;
    }
}
