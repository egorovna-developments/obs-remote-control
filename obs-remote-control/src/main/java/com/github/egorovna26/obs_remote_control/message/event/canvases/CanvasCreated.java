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
 * A new canvas has been created.
 */
@NoArgsConstructor
@Getter
@Setter
@ToString(
        callSuper = true
)
public class CanvasCreated extends Event<CanvasCreated.Data> {
    /**
     * @return Name of the new canvas
     */
    public String getCanvasName() {
        return getData().getEventData().getCanvasName();
    }

    /**
     * @return UUID of the new canvas
     */
    public String getCanvasUuid() {
        return getData().getEventData().getCanvasUuid();
    }

    /**
     * CanvasCreated Event Data
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
         * Name of the new canvas
         */
        @JsonProperty("canvasName")
        private String canvasName;

        /**
         * UUID of the new canvas
         */
        @JsonProperty("canvasUuid")
        private String canvasUuid;
    }
}
