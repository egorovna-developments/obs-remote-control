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
 * Gets a Base64-encoded screenshot of a source.
 *
 * The `imageWidth` and `imageHeight` parameters are treated as "scale to inner", meaning the smallest ratio will be used and the aspect ratio of the original resolution is kept.
 * If `imageWidth` and `imageHeight` are not specified, the compressed image will use the full resolution of the source.
 *
 * **Compatible with inputs and scenes.**
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class GetSourceScreenshotRequest extends Request<GetSourceScreenshotRequest.Data> {
    /**
     * GetSourceScreenshotRequest constructor
     */
    public GetSourceScreenshotRequest(String canvasUuid, String sourceName, String sourceUuid,
            String imageFormat, int imageWidth, int imageHeight, int imageCompressionQuality) {
        super("GetSourceScreenshot", new Data(canvasUuid, sourceName, sourceUuid, imageFormat, imageWidth, imageHeight, imageCompressionQuality));
    }

    /**
     * GetSourceScreenshot Request Data
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
         * Name of the source to take a screenshot of
         */
        @JsonProperty("sourceName")
        private String sourceName;

        /**
         * UUID of the source to take a screenshot of
         */
        @JsonProperty("sourceUuid")
        private String sourceUuid;

        /**
         * Image compression format to use. Use `GetVersion` to get compatible image formats
         */
        @JsonProperty("imageFormat")
        private String imageFormat;

        /**
         * Width to scale the screenshot to
         */
        @JsonProperty("imageWidth")
        private int imageWidth;

        /**
         * Height to scale the screenshot to
         */
        @JsonProperty("imageHeight")
        private int imageHeight;

        /**
         * Compression quality to use. 0 for high compression, 100 for uncompressed. -1 to use "default" (whatever that means, idk)
         */
        @JsonProperty("imageCompressionQuality")
        private int imageCompressionQuality;
    }
}
