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
 * Sets the name of a source filter (rename).
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class SetSourceFilterNameRequest extends Request<SetSourceFilterNameRequest.Data> {
    /**
     * SetSourceFilterNameRequest constructor
     */
    public SetSourceFilterNameRequest(String canvasUuid, String sourceName, String sourceUuid,
            String filterName, String newFilterName) {
        super("SetSourceFilterName", new Data(canvasUuid, sourceName, sourceUuid, filterName, newFilterName));
    }

    /**
     * SetSourceFilterName Request Data
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
         * Current name of the filter
         */
        @JsonProperty("filterName")
        private String filterName;

        /**
         * New name for the filter
         */
        @JsonProperty("newFilterName")
        private String newFilterName;
    }
}
