package com.github.egorovna26.obs_remote_control.message.request.sources;

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
 * Gets the active and show state of a source.
 *
 * **Compatible with inputs and scenes.**
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class GetSourceActiveRequest extends Request<GetSourceActiveRequest.Data> {
    /**
     * GetSourceActiveRequest constructor
     */
    public GetSourceActiveRequest(String canvasUuid, String sourceName, String sourceUuid) {
        super("GetSourceActive", new Data(canvasUuid, sourceName, sourceUuid));
    }

    /**
     * GetSourceActive Request Data
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
         * UUID of the canvas the source is in, if using sourceName field
         */
        @JsonProperty("canvasUuid")
        private String canvasUuid;

        /**
         * Name of the source to get the active state of
         */
        @JsonProperty("sourceName")
        private String sourceName;

        /**
         * UUID of the source to get the active state of
         */
        @JsonProperty("sourceUuid")
        private String sourceUuid;
    }
}
