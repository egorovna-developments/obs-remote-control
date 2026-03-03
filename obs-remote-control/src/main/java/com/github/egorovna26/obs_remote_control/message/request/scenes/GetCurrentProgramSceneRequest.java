package com.github.egorovna26.obs_remote_control.message.request.scenes;

import com.github.egorovna26.obs_remote_control.message.request.Request;
import java.lang.Void;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Gets the current program scene.
 *
 * Note 1: This request is slated to have the `currentProgram`-prefixed fields removed from in an upcoming RPC version.
 *
 * Note 2: Canvases do not have any concept of a program or preview scene, so this request does not support canvases.
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class GetCurrentProgramSceneRequest extends Request<Void> {
    /**
     * GetCurrentProgramSceneRequest constructor
     */
    public GetCurrentProgramSceneRequest() {
        super("GetCurrentProgramScene", null);
    }
}
