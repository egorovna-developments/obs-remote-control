package com.github.egorovna26.obs_remote_control.message.request.canvases;

import com.github.egorovna26.obs_remote_control.message.request.Request;
import java.lang.Void;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Gets an array of canvases in OBS.
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class GetCanvasListRequest extends Request<Void> {
    /**
     * GetCanvasListRequest constructor
     */
    public GetCanvasListRequest() {
        super("GetCanvasList", null);
    }
}
