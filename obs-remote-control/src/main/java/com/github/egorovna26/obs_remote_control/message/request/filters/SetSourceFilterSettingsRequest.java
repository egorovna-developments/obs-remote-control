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
 * Sets the settings of a source filter.
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class SetSourceFilterSettingsRequest extends Request<SetSourceFilterSettingsRequest.Data> {
    /**
     * SetSourceFilterSettingsRequest constructor
     */
    public SetSourceFilterSettingsRequest(String canvasUuid, String sourceName, String sourceUuid,
            String filterName, Object filterSettings, boolean overlay) {
        super("SetSourceFilterSettings", new Data(canvasUuid, sourceName, sourceUuid, filterName, filterSettings, overlay));
    }

    /**
     * SetSourceFilterSettings Request Data
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
         * Name of the filter to set the settings of
         */
        @JsonProperty("filterName")
        private String filterName;

        /**
         * Object of settings to apply
         */
        @JsonProperty("filterSettings")
        private Object filterSettings;

        /**
         * True == apply the settings on top of existing ones, False == reset the input to its defaults, then apply settings.
         */
        @JsonProperty("overlay")
        private boolean overlay;
    }
}
