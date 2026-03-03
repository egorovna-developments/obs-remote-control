package com.github.egorovna26.obs_remote_control.message.request.filters;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.egorovna26.obs_remote_control.message.request.Request;
import java.io.Serializable;
import java.lang.Object;
import java.lang.String;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Creates a new filter, adding it to the specified source.
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class CreateSourceFilterRequest extends Request<CreateSourceFilterRequest.Data> {
    /**
     * CreateSourceFilterRequest constructor
     */
    public CreateSourceFilterRequest(String canvasUuid, String sourceName, String sourceUuid,
            String filterName, String filterKind, Object filterSettings) {
        super("CreateSourceFilter", new Data(canvasUuid, sourceName, sourceUuid, filterName, filterKind, filterSettings));
    }

    /**
     * CreateSourceFilter Request Data
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
         * Name of the source to add the filter to
         */
        @JsonProperty("sourceName")
        private String sourceName;

        /**
         * UUID of the source to add the filter to
         */
        @JsonProperty("sourceUuid")
        private String sourceUuid;

        /**
         * Name of the new filter to be created
         */
        @JsonProperty("filterName")
        private String filterName;

        /**
         * The kind of filter to be created
         */
        @JsonProperty("filterKind")
        private String filterKind;

        /**
         * Settings object to initialize the filter with
         */
        @JsonProperty("filterSettings")
        private Object filterSettings;
    }
}
