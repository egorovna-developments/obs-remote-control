package com.github.egorovna26.obs_remote_control.message.request.ui;

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
 * Opens a projector for a source.
 *
 * Note: This request serves to provide feature parity with 4.x. It is very likely to be changed/deprecated in a future release.
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class OpenSourceProjectorRequest extends Request<OpenSourceProjectorRequest.Data> {
    /**
     * OpenSourceProjectorRequest constructor
     */
    public OpenSourceProjectorRequest(String canvasUuid, String sourceName, String sourceUuid,
            int monitorIndex, String projectorGeometry) {
        super("OpenSourceProjector", new Data(canvasUuid, sourceName, sourceUuid, monitorIndex, projectorGeometry));
    }

    /**
     * OpenSourceProjector Request Data
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
         * Name of the source to open a projector for
         */
        @JsonProperty("sourceName")
        private String sourceName;

        /**
         * UUID of the source to open a projector for
         */
        @JsonProperty("sourceUuid")
        private String sourceUuid;

        /**
         * Monitor index, use `GetMonitorList` to obtain index
         */
        @JsonProperty("monitorIndex")
        private int monitorIndex;

        /**
         * Size/Position data for a windowed projector, in Qt Base64 encoded format. Mutually exclusive with `monitorIndex`
         */
        @JsonProperty("projectorGeometry")
        private String projectorGeometry;
    }
}
