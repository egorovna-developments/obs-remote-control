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
 * A canvas has been removed.
 */
@NoArgsConstructor
@Getter
@Setter
@ToString(
        callSuper = true
)
public class CanvasRemoved extends Event<CanvasRemoved.Data> {
    /**
     * @return Name of the removed canvas
     */
    public String getCanvasName() {
        return getData().getEventData().getCanvasName();
    }

    /**
     * @return UUID of the removed canvas
     */
    public String getCanvasUuid() {
        return getData().getEventData().getCanvasUuid();
    }

    /**
     * CanvasRemoved Event Data
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
         * Name of the removed canvas
         */
        @JsonProperty("canvasName")
        private String canvasName;

        /**
         * UUID of the removed canvas
         */
        @JsonProperty("canvasUuid")
        private String canvasUuid;
    }
}
