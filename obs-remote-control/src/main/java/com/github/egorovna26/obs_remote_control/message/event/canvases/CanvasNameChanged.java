package com.github.egorovna26.obs_remote_control.message.event.canvases;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.egorovna26.obs_remote_control.message.event.Event;
import java.io.Serializable;
import java.lang.String;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The name of a canvas has changed.
 */
@NoArgsConstructor
@Getter
@Setter
@ToString(
        callSuper = true
)
public class CanvasNameChanged extends Event<CanvasNameChanged.Data> {
    /**
     * @return UUID of the canvas
     */
    public String getCanvasUuid() {
        return getData().getEventData().getCanvasUuid();
    }

    /**
     * @return Old name of the canvas
     */
    public String getOldCanvasName() {
        return getData().getEventData().getOldCanvasName();
    }

    /**
     * @return New name of the canvas
     */
    public String getCanvasName() {
        return getData().getEventData().getCanvasName();
    }

    /**
     * CanvasNameChanged Event Data
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
         * UUID of the canvas
         */
        @JsonProperty("canvasUuid")
        private String canvasUuid;

        /**
         * Old name of the canvas
         */
        @JsonProperty("oldCanvasName")
        private String oldCanvasName;

        /**
         * New name of the canvas
         */
        @JsonProperty("canvasName")
        private String canvasName;
    }
}
