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
 * Sets the index position of a filter on a source.
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class SetSourceFilterIndexRequest extends Request<SetSourceFilterIndexRequest.Data> {
    /**
     * SetSourceFilterIndexRequest constructor
     */
    public SetSourceFilterIndexRequest(String canvasUuid, String sourceName, String sourceUuid,
            String filterName, int filterIndex) {
        super("SetSourceFilterIndex", new Data(canvasUuid, sourceName, sourceUuid, filterName, filterIndex));
    }

    /**
     * SetSourceFilterIndex Request Data
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
         * Name of the filter
         */
        @JsonProperty("filterName")
        private String filterName;

        /**
         * New index position of the filter
         */
        @JsonProperty("filterIndex")
        private int filterIndex;
    }
}
