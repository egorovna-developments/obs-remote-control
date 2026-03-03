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
 * Removes a filter from a source.
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class RemoveSourceFilterRequest extends Request<RemoveSourceFilterRequest.Data> {
    /**
     * RemoveSourceFilterRequest constructor
     */
    public RemoveSourceFilterRequest(String canvasUuid, String sourceName, String sourceUuid,
            String filterName) {
        super("RemoveSourceFilter", new Data(canvasUuid, sourceName, sourceUuid, filterName));
    }

    /**
     * RemoveSourceFilter Request Data
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
         * Name of the source the filter is on
         */
        @JsonProperty("sourceName")
        private String sourceName;

        /**
         * UUID of the source the filter is on
         */
        @JsonProperty("sourceUuid")
        private String sourceUuid;

        /**
         * Name of the filter to remove
         */
        @JsonProperty("filterName")
        private String filterName;
    }
}
