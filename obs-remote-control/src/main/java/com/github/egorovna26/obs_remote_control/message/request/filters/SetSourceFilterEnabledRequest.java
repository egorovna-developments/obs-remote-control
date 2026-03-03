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
 * Sets the enable state of a source filter.
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class SetSourceFilterEnabledRequest extends Request<SetSourceFilterEnabledRequest.Data> {
    /**
     * SetSourceFilterEnabledRequest constructor
     */
    public SetSourceFilterEnabledRequest(String canvasUuid, String sourceName, String sourceUuid,
            String filterName, boolean filterEnabled) {
        super("SetSourceFilterEnabled", new Data(canvasUuid, sourceName, sourceUuid, filterName, filterEnabled));
    }

    /**
     * SetSourceFilterEnabled Request Data
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
         * New enable state of the filter
         */
        @JsonProperty("filterEnabled")
        private boolean filterEnabled;
    }
}
