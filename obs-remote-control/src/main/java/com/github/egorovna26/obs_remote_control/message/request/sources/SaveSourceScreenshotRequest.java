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
 * Saves a screenshot of a source to the filesystem.
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
public class SaveSourceScreenshotRequest extends Request<SaveSourceScreenshotRequest.Data> {
    /**
     * SaveSourceScreenshotRequest constructor
     */
    public SaveSourceScreenshotRequest(String canvasUuid, String sourceName, String sourceUuid,
            String imageFormat, String imageFilePath, int imageWidth, int imageHeight,
            int imageCompressionQuality) {
        super("SaveSourceScreenshot", new Data(canvasUuid, sourceName, sourceUuid, imageFormat, imageFilePath, imageWidth, imageHeight, imageCompressionQuality));
    }

    /**
     * SaveSourceScreenshot Request Data
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
         * Path to save the screenshot file to. Eg. `C:\\Users\\user\\Desktop\\screenshot.png`
         */
        @JsonProperty("imageFilePath")
        private String imageFilePath;

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
