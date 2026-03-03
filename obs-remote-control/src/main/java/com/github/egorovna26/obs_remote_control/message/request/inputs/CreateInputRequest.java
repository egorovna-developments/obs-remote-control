package com.github.egorovna26.obs_remote_control.message.request.inputs;

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
 * Creates a new input, adding it as a scene item to the specified scene.
 */
@Getter
@Setter
@ToString(
        callSuper = true
)
public class CreateInputRequest extends Request<CreateInputRequest.Data> {
    /**
     * CreateInputRequest constructor
     */
    public CreateInputRequest(String canvasUuid, String sceneName, String sceneUuid,
            String inputName, String inputKind, Object inputSettings, boolean sceneItemEnabled) {
        super("CreateInput", new Data(canvasUuid, sceneName, sceneUuid, inputName, inputKind, inputSettings, sceneItemEnabled));
    }

    /**
     * CreateInput Request Data
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
         * UUID of the canvas the scene is in, if using the sceneName field
         */
        @JsonProperty("canvasUuid")
        private String canvasUuid;

        /**
         * Name of the scene to add the input to as a scene item
         */
        @JsonProperty("sceneName")
        private String sceneName;

        /**
         * UUID of the scene to add the input to as a scene item
         */
        @JsonProperty("sceneUuid")
        private String sceneUuid;

        /**
         * Name of the new input to created
         */
        @JsonProperty("inputName")
        private String inputName;

        /**
         * The kind of input to be created
         */
        @JsonProperty("inputKind")
        private String inputKind;

        /**
         * Settings object to initialize the input with
         */
        @JsonProperty("inputSettings")
        private Object inputSettings;

        /**
         * Whether to set the created scene item to enabled or disabled
         */
        @JsonProperty("sceneItemEnabled")
        private boolean sceneItemEnabled;
    }
}
