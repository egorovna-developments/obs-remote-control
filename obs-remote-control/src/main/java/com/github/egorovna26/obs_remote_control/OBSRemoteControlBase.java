package com.github.egorovna26.obs_remote_control;

import com.github.egorovna26.obs_remote_control.message.request.Request;
import com.github.egorovna26.obs_remote_control.message.request.canvases.GetCanvasListRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.*;
import com.github.egorovna26.obs_remote_control.message.request.filters.*;
import com.github.egorovna26.obs_remote_control.message.request.general.*;
import com.github.egorovna26.obs_remote_control.message.request.inputs.*;
import com.github.egorovna26.obs_remote_control.message.request.media_inputs.GetMediaInputStatusRequest;
import com.github.egorovna26.obs_remote_control.message.request.media_inputs.OffsetMediaInputCursorRequest;
import com.github.egorovna26.obs_remote_control.message.request.media_inputs.SetMediaInputCursorRequest;
import com.github.egorovna26.obs_remote_control.message.request.media_inputs.TriggerMediaInputActionRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.*;
import com.github.egorovna26.obs_remote_control.message.request.record.*;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.*;
import com.github.egorovna26.obs_remote_control.message.request.scenes.*;
import com.github.egorovna26.obs_remote_control.message.request.sources.GetSourceActiveRequest;
import com.github.egorovna26.obs_remote_control.message.request.sources.GetSourceScreenshotRequest;
import com.github.egorovna26.obs_remote_control.message.request.sources.SaveSourceScreenshotRequest;
import com.github.egorovna26.obs_remote_control.message.request.stream.*;
import com.github.egorovna26.obs_remote_control.message.request.transitions.*;
import com.github.egorovna26.obs_remote_control.message.request.ui.*;
import com.github.egorovna26.obs_remote_control.message.requestresponse.RequestResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.canvases.GetCanvasListResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.*;
import com.github.egorovna26.obs_remote_control.message.requestresponse.filters.*;
import com.github.egorovna26.obs_remote_control.message.requestresponse.general.*;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.*;
import com.github.egorovna26.obs_remote_control.message.requestresponse.media_inputs.GetMediaInputStatusResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.media_inputs.OffsetMediaInputCursorResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.media_inputs.SetMediaInputCursorResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.media_inputs.TriggerMediaInputActionResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.*;
import com.github.egorovna26.obs_remote_control.message.requestresponse.record.*;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.*;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scenes.*;
import com.github.egorovna26.obs_remote_control.message.requestresponse.sources.GetSourceActiveResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.sources.GetSourceScreenshotResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.sources.SaveSourceScreenshotResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.stream.*;
import com.github.egorovna26.obs_remote_control.message.requestresponse.transitions.*;
import com.github.egorovna26.obs_remote_control.message.requestresponse.ui.*;
import com.github.egorovna26.obs_remote_control.session.BlockingConsumer;
import com.github.egorovna26.obs_remote_control.session.OBSRemoteSession;
import lombok.CustomLog;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@CustomLog
public abstract class OBSRemoteControlBase {
    private static final int DEFAULT_TIMEOUT = 2000;

    protected final OBSRemoteSession session = new OBSRemoteSession();

    @Getter
    @Setter
    protected int timeout = DEFAULT_TIMEOUT;

    /**
     * Gets an array of canvases in OBS.
     */
    public GetCanvasListResponse getCanvasList() {
        return send(new GetCanvasListRequest());
    }

    /**
     * Gets the value of a "slot" from the selected persistent data realm.
     */
    public GetPersistentDataResponse getPersistentData(String realm, String slotName) {
        return send(new GetPersistentDataRequest(realm, slotName));
    }

    /**
     * Sets the value of a "slot" from the selected persistent data realm.
     */
    public SetPersistentDataResponse setPersistentData(String realm, String slotName,
                                                       Object slotValue) {
        return send(new SetPersistentDataRequest(realm, slotName, slotValue));
    }

    /**
     * Gets an array of all scene collections
     */
    public GetSceneCollectionListResponse getSceneCollectionList() {
        return send(new GetSceneCollectionListRequest());
    }

    /**
     * Switches to a scene collection.
     * <p>
     * Note: This will block until the collection has finished changing.
     */
    public SetCurrentSceneCollectionResponse setCurrentSceneCollection(String sceneCollectionName) {
        return send(new SetCurrentSceneCollectionRequest(sceneCollectionName));
    }

    /**
     * Creates a new scene collection, switching to it in the process.
     * <p>
     * Note: This will block until the collection has finished changing.
     */
    public CreateSceneCollectionResponse createSceneCollection(String sceneCollectionName) {
        return send(new CreateSceneCollectionRequest(sceneCollectionName));
    }

    /**
     * Gets an array of all profiles
     */
    public GetProfileListResponse getProfileList() {
        return send(new GetProfileListRequest());
    }

    /**
     * Switches to a profile.
     */
    public SetCurrentProfileResponse setCurrentProfile(String profileName) {
        return send(new SetCurrentProfileRequest(profileName));
    }

    /**
     * Creates a new profile, switching to it in the process
     */
    public CreateProfileResponse createProfile(String profileName) {
        return send(new CreateProfileRequest(profileName));
    }

    /**
     * Removes a profile. If the current profile is chosen, it will change to a different profile first.
     */
    public RemoveProfileResponse removeProfile(String profileName) {
        return send(new RemoveProfileRequest(profileName));
    }

    /**
     * Gets a parameter from the current profile's configuration.
     */
    public GetProfileParameterResponse getProfileParameter(String parameterCategory,
                                                           String parameterName) {
        return send(new GetProfileParameterRequest(parameterCategory, parameterName));
    }

    /**
     * Sets the value of a parameter in the current profile's configuration.
     */
    public SetProfileParameterResponse setProfileParameter(String parameterCategory,
                                                           String parameterName, String parameterValue) {
        return send(new SetProfileParameterRequest(parameterCategory, parameterName, parameterValue));
    }

    /**
     * Gets the current video settings.
     * <p>
     * Note: To get the true FPS value, divide the FPS numerator by the FPS denominator. Example: `60000/1001`
     */
    public GetVideoSettingsResponse getVideoSettings() {
        return send(new GetVideoSettingsRequest());
    }

    /**
     * Sets the current video settings.
     * <p>
     * Note: Fields must be specified in pairs. For example, you cannot set only `baseWidth` without needing to specify `baseHeight`.
     */
    public SetVideoSettingsResponse setVideoSettings(int fpsNumerator, int fpsDenominator,
                                                     int baseWidth, int baseHeight, int outputWidth, int outputHeight) {
        return send(new SetVideoSettingsRequest(fpsNumerator, fpsDenominator, baseWidth, baseHeight, outputWidth, outputHeight));
    }

    /**
     * Gets the current stream service settings (stream destination).
     */
    public GetStreamServiceSettingsResponse getStreamServiceSettings() {
        return send(new GetStreamServiceSettingsRequest());
    }

    /**
     * Sets the current stream service settings (stream destination).
     * <p>
     * Note: Simple RTMP settings can be set with type `rtmp_custom` and the settings fields `server` and `key`.
     */
    public SetStreamServiceSettingsResponse setStreamServiceSettings(String streamServiceType,
                                                                     Object streamServiceSettings) {
        return send(new SetStreamServiceSettingsRequest(streamServiceType, streamServiceSettings));
    }

    /**
     * Gets the current directory that the record output is set to.
     */
    public GetRecordDirectoryResponse getRecordDirectory() {
        return send(new GetRecordDirectoryRequest());
    }

    /**
     * Sets the current directory that the record output writes files to.
     */
    public SetRecordDirectoryResponse setRecordDirectory(String recordDirectory) {
        return send(new SetRecordDirectoryRequest(recordDirectory));
    }

    /**
     * Gets an array of all available source filter kinds.
     * <p>
     * Similar to `GetInputKindList`
     */
    public GetSourceFilterKindListResponse getSourceFilterKindList() {
        return send(new GetSourceFilterKindListRequest());
    }

    /**
     * Gets an array of all of a source's filters.
     */
    public GetSourceFilterListResponse getSourceFilterList(String canvasUuid, String sourceName,
                                                           String sourceUuid) {
        return send(new GetSourceFilterListRequest(canvasUuid, sourceName, sourceUuid));
    }

    /**
     * Gets the default settings for a filter kind.
     */
    public GetSourceFilterDefaultSettingsResponse getSourceFilterDefaultSettings(
            String filterKind) {
        return send(new GetSourceFilterDefaultSettingsRequest(filterKind));
    }

    /**
     * Creates a new filter, adding it to the specified source.
     */
    public CreateSourceFilterResponse createSourceFilter(String canvasUuid, String sourceName,
                                                         String sourceUuid, String filterName, String filterKind, Object filterSettings) {
        return send(new CreateSourceFilterRequest(canvasUuid, sourceName, sourceUuid, filterName, filterKind, filterSettings));
    }

    /**
     * Removes a filter from a source.
     */
    public RemoveSourceFilterResponse removeSourceFilter(String canvasUuid, String sourceName,
                                                         String sourceUuid, String filterName) {
        return send(new RemoveSourceFilterRequest(canvasUuid, sourceName, sourceUuid, filterName));
    }

    /**
     * Sets the name of a source filter (rename).
     */
    public SetSourceFilterNameResponse setSourceFilterName(String canvasUuid, String sourceName,
                                                           String sourceUuid, String filterName, String newFilterName) {
        return send(new SetSourceFilterNameRequest(canvasUuid, sourceName, sourceUuid, filterName, newFilterName));
    }

    /**
     * Gets the info for a specific source filter.
     */
    public GetSourceFilterResponse getSourceFilter(String canvasUuid, String sourceName,
                                                   String sourceUuid, String filterName) {
        return send(new GetSourceFilterRequest(canvasUuid, sourceName, sourceUuid, filterName));
    }

    /**
     * Sets the index position of a filter on a source.
     */
    public SetSourceFilterIndexResponse setSourceFilterIndex(String canvasUuid, String sourceName,
                                                             String sourceUuid, String filterName, int filterIndex) {
        return send(new SetSourceFilterIndexRequest(canvasUuid, sourceName, sourceUuid, filterName, filterIndex));
    }

    /**
     * Sets the settings of a source filter.
     */
    public SetSourceFilterSettingsResponse setSourceFilterSettings(String canvasUuid,
                                                                   String sourceName, String sourceUuid, String filterName, Object filterSettings,
                                                                   boolean overlay) {
        return send(new SetSourceFilterSettingsRequest(canvasUuid, sourceName, sourceUuid, filterName, filterSettings, overlay));
    }

    /**
     * Sets the enable state of a source filter.
     */
    public SetSourceFilterEnabledResponse setSourceFilterEnabled(String canvasUuid,
                                                                 String sourceName, String sourceUuid, String filterName, boolean filterEnabled) {
        return send(new SetSourceFilterEnabledRequest(canvasUuid, sourceName, sourceUuid, filterName, filterEnabled));
    }

    /**
     * Gets data about the current plugin and RPC version.
     */
    public GetVersionResponse getVersion() {
        return send(new GetVersionRequest());
    }

    /**
     * Gets statistics about OBS, obs-websocket, and the current session.
     */
    public GetStatsResponse getStats() {
        return send(new GetStatsRequest());
    }

    /**
     * Broadcasts a `CustomEvent` to all WebSocket clients. Receivers are clients which are identified and subscribed.
     */
    public BroadcastCustomEventResponse broadcastCustomEvent(Object eventData) {
        return send(new BroadcastCustomEventRequest(eventData));
    }

    /**
     * Call a request registered to a vendor.
     * <p>
     * A vendor is a unique name registered by a third-party plugin or script, which allows for custom requests and events to be added to obs-websocket.
     * If a plugin or script implements vendor requests or events, documentation is expected to be provided with them.
     */
    public CallVendorRequestResponse callVendorRequest(String vendorName, String requestType,
                                                       Object requestData) {
        return send(new CallVendorRequestRequest(vendorName, requestType, requestData));
    }

    /**
     * Gets an array of all hotkey names in OBS.
     * <p>
     * Note: Hotkey functionality in obs-websocket comes as-is, and we do not guarantee support if things are broken. In 9/10 usages of hotkey requests, there exists a better, more reliable method via other requests.
     */
    public GetHotkeyListResponse getHotkeyList() {
        return send(new GetHotkeyListRequest());
    }

    /**
     * Triggers a hotkey using its name. See `GetHotkeyList`.
     * <p>
     * Note: Hotkey functionality in obs-websocket comes as-is, and we do not guarantee support if things are broken. In 9/10 usages of hotkey requests, there exists a better, more reliable method via other requests.
     */
    public TriggerHotkeyByNameResponse triggerHotkeyByName(String hotkeyName, String contextName) {
        return send(new TriggerHotkeyByNameRequest(hotkeyName, contextName));
    }

    /**
     * Triggers a hotkey using a sequence of keys.
     * <p>
     * Note: Hotkey functionality in obs-websocket comes as-is, and we do not guarantee support if things are broken. In 9/10 usages of hotkey requests, there exists a better, more reliable method via other requests.
     */
    public TriggerHotkeyByKeySequenceResponse triggerHotkeyByKeySequence(String keyId,
                                                                         Object keyModifiers) {
        return send(new TriggerHotkeyByKeySequenceRequest(keyId, keyModifiers));
    }

    /**
     * Sleeps for a time duration or number of frames. Only available in request batches with types `SERIAL_REALTIME` or `SERIAL_FRAME`.
     */
    public SleepResponse sleep(int sleepMillis, int sleepFrames) {
        return send(new SleepRequest(sleepMillis, sleepFrames));
    }

    /**
     * Gets an array of all inputs in OBS.
     */
    public GetInputListResponse getInputList(String inputKind) {
        return send(new GetInputListRequest(inputKind));
    }

    /**
     * Gets an array of all available input kinds in OBS.
     */
    public GetInputKindListResponse getInputKindList(boolean unversioned) {
        return send(new GetInputKindListRequest(unversioned));
    }

    /**
     * Gets the names of all special inputs.
     */
    public GetSpecialInputsResponse getSpecialInputs() {
        return send(new GetSpecialInputsRequest());
    }

    /**
     * Creates a new input, adding it as a scene item to the specified scene.
     */
    public CreateInputResponse createInput(String canvasUuid, String sceneName, String sceneUuid,
                                           String inputName, String inputKind, Object inputSettings, boolean sceneItemEnabled) {
        return send(new CreateInputRequest(canvasUuid, sceneName, sceneUuid, inputName, inputKind, inputSettings, sceneItemEnabled));
    }

    /**
     * Removes an existing input.
     * <p>
     * Note: Will immediately remove all associated scene items.
     */
    public RemoveInputResponse removeInput(String inputName, String inputUuid) {
        return send(new RemoveInputRequest(inputName, inputUuid));
    }

    /**
     * Sets the name of an input (rename).
     */
    public SetInputNameResponse setInputName(String inputName, String inputUuid,
                                             String newInputName) {
        return send(new SetInputNameRequest(inputName, inputUuid, newInputName));
    }

    /**
     * Gets the default settings for an input kind.
     */
    public GetInputDefaultSettingsResponse getInputDefaultSettings(String inputKind) {
        return send(new GetInputDefaultSettingsRequest(inputKind));
    }

    /**
     * Gets the settings of an input.
     * <p>
     * Note: Does not include defaults. To create the entire settings object, overlay `inputSettings` over the `defaultInputSettings` provided by `GetInputDefaultSettings`.
     */
    public GetInputSettingsResponse getInputSettings(String inputName, String inputUuid) {
        return send(new GetInputSettingsRequest(inputName, inputUuid));
    }

    /**
     * Sets the settings of an input.
     */
    public SetInputSettingsResponse setInputSettings(String inputName, String inputUuid,
                                                     Object inputSettings, boolean overlay) {
        return send(new SetInputSettingsRequest(inputName, inputUuid, inputSettings, overlay));
    }

    /**
     * Gets the audio mute state of an input.
     */
    public GetInputMuteResponse getInputMute(String inputName, String inputUuid) {
        return send(new GetInputMuteRequest(inputName, inputUuid));
    }

    /**
     * Sets the audio mute state of an input.
     */
    public SetInputMuteResponse setInputMute(String inputName, String inputUuid,
                                             boolean inputMuted) {
        return send(new SetInputMuteRequest(inputName, inputUuid, inputMuted));
    }

    /**
     * Toggles the audio mute state of an input.
     */
    public ToggleInputMuteResponse toggleInputMute(String inputName, String inputUuid) {
        return send(new ToggleInputMuteRequest(inputName, inputUuid));
    }

    /**
     * Gets the current volume setting of an input.
     */
    public GetInputVolumeResponse getInputVolume(String inputName, String inputUuid) {
        return send(new GetInputVolumeRequest(inputName, inputUuid));
    }

    /**
     * Sets the volume setting of an input.
     */
    public SetInputVolumeResponse setInputVolume(String inputName, String inputUuid,
                                                 int inputVolumeMul, int inputVolumeDb) {
        return send(new SetInputVolumeRequest(inputName, inputUuid, inputVolumeMul, inputVolumeDb));
    }

    /**
     * Gets the audio balance of an input.
     */
    public GetInputAudioBalanceResponse getInputAudioBalance(String inputName, String inputUuid) {
        return send(new GetInputAudioBalanceRequest(inputName, inputUuid));
    }

    /**
     * Sets the audio balance of an input.
     */
    public SetInputAudioBalanceResponse setInputAudioBalance(String inputName, String inputUuid,
                                                             int inputAudioBalance) {
        return send(new SetInputAudioBalanceRequest(inputName, inputUuid, inputAudioBalance));
    }

    /**
     * Gets the audio sync offset of an input.
     * <p>
     * Note: The audio sync offset can be negative too!
     */
    public GetInputAudioSyncOffsetResponse getInputAudioSyncOffset(String inputName,
                                                                   String inputUuid) {
        return send(new GetInputAudioSyncOffsetRequest(inputName, inputUuid));
    }

    /**
     * Sets the audio sync offset of an input.
     */
    public SetInputAudioSyncOffsetResponse setInputAudioSyncOffset(String inputName,
                                                                   String inputUuid, int inputAudioSyncOffset) {
        return send(new SetInputAudioSyncOffsetRequest(inputName, inputUuid, inputAudioSyncOffset));
    }

    /**
     * Gets the audio monitor type of an input.
     * <p>
     * The available audio monitor types are:
     * <p>
     * - `OBS_MONITORING_TYPE_NONE`
     * - `OBS_MONITORING_TYPE_MONITOR_ONLY`
     * - `OBS_MONITORING_TYPE_MONITOR_AND_OUTPUT`
     */
    public GetInputAudioMonitorTypeResponse getInputAudioMonitorType(String inputName,
                                                                     String inputUuid) {
        return send(new GetInputAudioMonitorTypeRequest(inputName, inputUuid));
    }

    /**
     * Sets the audio monitor type of an input.
     */
    public SetInputAudioMonitorTypeResponse setInputAudioMonitorType(String inputName,
                                                                     String inputUuid, String monitorType) {
        return send(new SetInputAudioMonitorTypeRequest(inputName, inputUuid, monitorType));
    }

    /**
     * Gets the enable state of all audio tracks of an input.
     */
    public GetInputAudioTracksResponse getInputAudioTracks(String inputName, String inputUuid) {
        return send(new GetInputAudioTracksRequest(inputName, inputUuid));
    }

    /**
     * Sets the enable state of audio tracks of an input.
     */
    public SetInputAudioTracksResponse setInputAudioTracks(String inputName, String inputUuid,
                                                           Object inputAudioTracks) {
        return send(new SetInputAudioTracksRequest(inputName, inputUuid, inputAudioTracks));
    }

    /**
     * Gets the deinterlace mode of an input.
     * <p>
     * Deinterlace Modes:
     * <p>
     * - `OBS_DEINTERLACE_MODE_DISABLE`
     * - `OBS_DEINTERLACE_MODE_DISCARD`
     * - `OBS_DEINTERLACE_MODE_RETRO`
     * - `OBS_DEINTERLACE_MODE_BLEND`
     * - `OBS_DEINTERLACE_MODE_BLEND_2X`
     * - `OBS_DEINTERLACE_MODE_LINEAR`
     * - `OBS_DEINTERLACE_MODE_LINEAR_2X`
     * - `OBS_DEINTERLACE_MODE_YADIF`
     * - `OBS_DEINTERLACE_MODE_YADIF_2X`
     * <p>
     * Note: Deinterlacing functionality is restricted to async inputs only.
     */
    public GetInputDeinterlaceModeResponse getInputDeinterlaceMode(String inputName,
                                                                   String inputUuid) {
        return send(new GetInputDeinterlaceModeRequest(inputName, inputUuid));
    }

    /**
     * Sets the deinterlace mode of an input.
     * <p>
     * Note: Deinterlacing functionality is restricted to async inputs only.
     */
    public SetInputDeinterlaceModeResponse setInputDeinterlaceMode(String inputName,
                                                                   String inputUuid, String inputDeinterlaceMode) {
        return send(new SetInputDeinterlaceModeRequest(inputName, inputUuid, inputDeinterlaceMode));
    }

    /**
     * Gets the deinterlace field order of an input.
     * <p>
     * Deinterlace Field Orders:
     * <p>
     * - `OBS_DEINTERLACE_FIELD_ORDER_TOP`
     * - `OBS_DEINTERLACE_FIELD_ORDER_BOTTOM`
     * <p>
     * Note: Deinterlacing functionality is restricted to async inputs only.
     */
    public GetInputDeinterlaceFieldOrderResponse getInputDeinterlaceFieldOrder(String inputName,
                                                                               String inputUuid) {
        return send(new GetInputDeinterlaceFieldOrderRequest(inputName, inputUuid));
    }

    /**
     * Sets the deinterlace field order of an input.
     * <p>
     * Note: Deinterlacing functionality is restricted to async inputs only.
     */
    public SetInputDeinterlaceFieldOrderResponse setInputDeinterlaceFieldOrder(String inputName,
                                                                               String inputUuid, String inputDeinterlaceFieldOrder) {
        return send(new SetInputDeinterlaceFieldOrderRequest(inputName, inputUuid, inputDeinterlaceFieldOrder));
    }

    /**
     * Gets the items of a list property from an input's properties.
     * <p>
     * Note: Use this in cases where an input provides a dynamic, selectable list of items. For example, display capture, where it provides a list of available displays.
     */
    public GetInputPropertiesListPropertyItemsResponse getInputPropertiesListPropertyItems(
            String inputName, String inputUuid, String propertyName) {
        return send(new GetInputPropertiesListPropertyItemsRequest(inputName, inputUuid, propertyName));
    }

    /**
     * Presses a button in the properties of an input.
     * <p>
     * Some known `propertyName` values are:
     * <p>
     * - `refreshnocache` - Browser source reload button
     * <p>
     * Note: Use this in cases where there is a button in the properties of an input that cannot be accessed in any other way. For example, browser sources, where there is a refresh button.
     */
    public PressInputPropertiesButtonResponse pressInputPropertiesButton(String inputName,
                                                                         String inputUuid, String propertyName) {
        return send(new PressInputPropertiesButtonRequest(inputName, inputUuid, propertyName));
    }

    /**
     * Gets the status of a media input.
     * <p>
     * Media States:
     * <p>
     * - `OBS_MEDIA_STATE_NONE`
     * - `OBS_MEDIA_STATE_PLAYING`
     * - `OBS_MEDIA_STATE_OPENING`
     * - `OBS_MEDIA_STATE_BUFFERING`
     * - `OBS_MEDIA_STATE_PAUSED`
     * - `OBS_MEDIA_STATE_STOPPED`
     * - `OBS_MEDIA_STATE_ENDED`
     * - `OBS_MEDIA_STATE_ERROR`
     */
    public GetMediaInputStatusResponse getMediaInputStatus(String inputName, String inputUuid) {
        return send(new GetMediaInputStatusRequest(inputName, inputUuid));
    }

    /**
     * Sets the cursor position of a media input.
     * <p>
     * This request does not perform bounds checking of the cursor position.
     */
    public SetMediaInputCursorResponse setMediaInputCursor(String inputName, String inputUuid,
                                                           int mediaCursor) {
        return send(new SetMediaInputCursorRequest(inputName, inputUuid, mediaCursor));
    }

    /**
     * Offsets the current cursor position of a media input by the specified value.
     * <p>
     * This request does not perform bounds checking of the cursor position.
     */
    public OffsetMediaInputCursorResponse offsetMediaInputCursor(String inputName, String inputUuid,
                                                                 int mediaCursorOffset) {
        return send(new OffsetMediaInputCursorRequest(inputName, inputUuid, mediaCursorOffset));
    }

    /**
     * Triggers an action on a media input.
     */
    public TriggerMediaInputActionResponse triggerMediaInputAction(String inputName,
                                                                   String inputUuid, String mediaAction) {
        return send(new TriggerMediaInputActionRequest(inputName, inputUuid, mediaAction));
    }

    /**
     * Gets the status of the virtualcam output.
     */
    public GetVirtualCamStatusResponse getVirtualCamStatus() {
        return send(new GetVirtualCamStatusRequest());
    }

    /**
     * Toggles the state of the virtualcam output.
     */
    public ToggleVirtualCamResponse toggleVirtualCam() {
        return send(new ToggleVirtualCamRequest());
    }

    /**
     * Starts the virtualcam output.
     */
    public StartVirtualCamResponse startVirtualCam() {
        return send(new StartVirtualCamRequest());
    }

    /**
     * Stops the virtualcam output.
     */
    public StopVirtualCamResponse stopVirtualCam() {
        return send(new StopVirtualCamRequest());
    }

    /**
     * Gets the status of the replay buffer output.
     */
    public GetReplayBufferStatusResponse getReplayBufferStatus() {
        return send(new GetReplayBufferStatusRequest());
    }

    /**
     * Toggles the state of the replay buffer output.
     */
    public ToggleReplayBufferResponse toggleReplayBuffer() {
        return send(new ToggleReplayBufferRequest());
    }

    /**
     * Starts the replay buffer output.
     */
    public StartReplayBufferResponse startReplayBuffer() {
        return send(new StartReplayBufferRequest());
    }

    /**
     * Stops the replay buffer output.
     */
    public StopReplayBufferResponse stopReplayBuffer() {
        return send(new StopReplayBufferRequest());
    }

    /**
     * Saves the contents of the replay buffer output.
     */
    public SaveReplayBufferResponse saveReplayBuffer() {
        return send(new SaveReplayBufferRequest());
    }

    /**
     * Gets the filename of the last replay buffer save file.
     */
    public GetLastReplayBufferReplayResponse getLastReplayBufferReplay() {
        return send(new GetLastReplayBufferReplayRequest());
    }

    /**
     * Gets the list of available outputs.
     */
    public GetOutputListResponse getOutputList() {
        return send(new GetOutputListRequest());
    }

    /**
     * Gets the status of an output.
     */
    public GetOutputStatusResponse getOutputStatus(String outputName) {
        return send(new GetOutputStatusRequest(outputName));
    }

    /**
     * Toggles the status of an output.
     */
    public ToggleOutputResponse toggleOutput(String outputName) {
        return send(new ToggleOutputRequest(outputName));
    }

    /**
     * Starts an output.
     */
    public StartOutputResponse startOutput(String outputName) {
        return send(new StartOutputRequest(outputName));
    }

    /**
     * Stops an output.
     */
    public StopOutputResponse stopOutput(String outputName) {
        return send(new StopOutputRequest(outputName));
    }

    /**
     * Gets the settings of an output.
     */
    public GetOutputSettingsResponse getOutputSettings(String outputName) {
        return send(new GetOutputSettingsRequest(outputName));
    }

    /**
     * Sets the settings of an output.
     */
    public SetOutputSettingsResponse setOutputSettings(String outputName, Object outputSettings) {
        return send(new SetOutputSettingsRequest(outputName, outputSettings));
    }

    /**
     * Gets the status of the record output.
     */
    public GetRecordStatusResponse getRecordStatus() {
        return send(new GetRecordStatusRequest());
    }

    /**
     * Toggles the status of the record output.
     */
    public ToggleRecordResponse toggleRecord() {
        return send(new ToggleRecordRequest());
    }

    /**
     * Starts the record output.
     */
    public StartRecordResponse startRecord() {
        return send(new StartRecordRequest());
    }

    /**
     * Stops the record output.
     */
    public StopRecordResponse stopRecord() {
        return send(new StopRecordRequest());
    }

    /**
     * Toggles pause on the record output.
     */
    public ToggleRecordPauseResponse toggleRecordPause() {
        return send(new ToggleRecordPauseRequest());
    }

    /**
     * Pauses the record output.
     */
    public PauseRecordResponse pauseRecord() {
        return send(new PauseRecordRequest());
    }

    /**
     * Resumes the record output.
     */
    public ResumeRecordResponse resumeRecord() {
        return send(new ResumeRecordRequest());
    }

    /**
     * Splits the current file being recorded into a new file.
     */
    public SplitRecordFileResponse splitRecordFile() {
        return send(new SplitRecordFileRequest());
    }

    /**
     * Adds a new chapter marker to the file currently being recorded.
     * <p>
     * Note: As of OBS 30.2.0, the only file format supporting this feature is Hybrid MP4.
     */
    public CreateRecordChapterResponse createRecordChapter(String chapterName) {
        return send(new CreateRecordChapterRequest(chapterName));
    }

    /**
     * Gets a list of all scene items in a scene.
     * <p>
     * Scenes only
     */
    public GetSceneItemListResponse getSceneItemList(String canvasUuid, String sceneName,
                                                     String sceneUuid) {
        return send(new GetSceneItemListRequest(canvasUuid, sceneName, sceneUuid));
    }

    /**
     * Basically GetSceneItemList, but for groups.
     * <p>
     * Using groups at all in OBS is discouraged, as they are very broken under the hood. Please use nested scenes instead.
     * <p>
     * Groups only
     */
    public GetGroupSceneItemListResponse getGroupSceneItemList(String canvasUuid, String sceneName,
                                                               String sceneUuid) {
        return send(new GetGroupSceneItemListRequest(canvasUuid, sceneName, sceneUuid));
    }

    /**
     * Searches a scene for a source, and returns its id.
     * <p>
     * Scenes and Groups
     */
    public GetSceneItemIdResponse getSceneItemId(String canvasUuid, String sceneName,
                                                 String sceneUuid, String sourceName, int searchOffset) {
        return send(new GetSceneItemIdRequest(canvasUuid, sceneName, sceneUuid, sourceName, searchOffset));
    }

    /**
     * Gets the source associated with a scene item.
     */
    public GetSceneItemSourceResponse getSceneItemSource(String canvasUuid, String sceneName,
                                                         String sceneUuid, int sceneItemId) {
        return send(new GetSceneItemSourceRequest(canvasUuid, sceneName, sceneUuid, sceneItemId));
    }

    /**
     * Creates a new scene item using a source.
     * <p>
     * Scenes only
     */
    public CreateSceneItemResponse createSceneItem(String canvasUuid, String sceneName,
                                                   String sceneUuid, String sourceName, String sourceUuid, boolean sceneItemEnabled) {
        return send(new CreateSceneItemRequest(canvasUuid, sceneName, sceneUuid, sourceName, sourceUuid, sceneItemEnabled));
    }

    /**
     * Removes a scene item from a scene.
     * <p>
     * Scenes only
     */
    public RemoveSceneItemResponse removeSceneItem(String canvasUuid, String sceneName,
                                                   String sceneUuid, int sceneItemId) {
        return send(new RemoveSceneItemRequest(canvasUuid, sceneName, sceneUuid, sceneItemId));
    }

    /**
     * Duplicates a scene item, copying all transform and crop info.
     * <p>
     * Scenes only
     */
    public DuplicateSceneItemResponse duplicateSceneItem(String canvasUuid, String sceneName,
                                                         String sceneUuid, int sceneItemId, String destinationSceneName,
                                                         String destinationSceneUuid) {
        return send(new DuplicateSceneItemRequest(canvasUuid, sceneName, sceneUuid, sceneItemId, destinationSceneName, destinationSceneUuid));
    }

    /**
     * Gets the transform and crop info of a scene item.
     * <p>
     * Scenes and Groups
     */
    public GetSceneItemTransformResponse getSceneItemTransform(String canvasUuid, String sceneName,
                                                               String sceneUuid, int sceneItemId) {
        return send(new GetSceneItemTransformRequest(canvasUuid, sceneName, sceneUuid, sceneItemId));
    }

    /**
     * Sets the transform and crop info of a scene item.
     */
    public SetSceneItemTransformResponse setSceneItemTransform(String canvasUuid, String sceneName,
                                                               String sceneUuid, int sceneItemId, Object sceneItemTransform) {
        return send(new SetSceneItemTransformRequest(canvasUuid, sceneName, sceneUuid, sceneItemId, sceneItemTransform));
    }

    /**
     * Gets the enable state of a scene item.
     * <p>
     * Scenes and Groups
     */
    public GetSceneItemEnabledResponse getSceneItemEnabled(String canvasUuid, String sceneName,
                                                           String sceneUuid, int sceneItemId) {
        return send(new GetSceneItemEnabledRequest(canvasUuid, sceneName, sceneUuid, sceneItemId));
    }

    /**
     * Sets the enable state of a scene item.
     * <p>
     * Scenes and Groups
     */
    public SetSceneItemEnabledResponse setSceneItemEnabled(String canvasUuid, String sceneName,
                                                           String sceneUuid, int sceneItemId, boolean sceneItemEnabled) {
        return send(new SetSceneItemEnabledRequest(canvasUuid, sceneName, sceneUuid, sceneItemId, sceneItemEnabled));
    }

    /**
     * Gets the lock state of a scene item.
     * <p>
     * Scenes and Groups
     */
    public GetSceneItemLockedResponse getSceneItemLocked(String canvasUuid, String sceneName,
                                                         String sceneUuid, int sceneItemId) {
        return send(new GetSceneItemLockedRequest(canvasUuid, sceneName, sceneUuid, sceneItemId));
    }

    /**
     * Sets the lock state of a scene item.
     * <p>
     * Scenes and Group
     */
    public SetSceneItemLockedResponse setSceneItemLocked(String canvasUuid, String sceneName,
                                                         String sceneUuid, int sceneItemId, boolean sceneItemLocked) {
        return send(new SetSceneItemLockedRequest(canvasUuid, sceneName, sceneUuid, sceneItemId, sceneItemLocked));
    }

    /**
     * Gets the index position of a scene item in a scene.
     * <p>
     * An index of 0 is at the bottom of the source list in the UI.
     * <p>
     * Scenes and Groups
     */
    public GetSceneItemIndexResponse getSceneItemIndex(String canvasUuid, String sceneName,
                                                       String sceneUuid, int sceneItemId) {
        return send(new GetSceneItemIndexRequest(canvasUuid, sceneName, sceneUuid, sceneItemId));
    }

    /**
     * Sets the index position of a scene item in a scene.
     * <p>
     * Scenes and Groups
     */
    public SetSceneItemIndexResponse setSceneItemIndex(String canvasUuid, String sceneName,
                                                       String sceneUuid, int sceneItemId, int sceneItemIndex) {
        return send(new SetSceneItemIndexRequest(canvasUuid, sceneName, sceneUuid, sceneItemId, sceneItemIndex));
    }

    /**
     * Gets the blend mode of a scene item.
     * <p>
     * Blend modes:
     * <p>
     * - `OBS_BLEND_NORMAL`
     * - `OBS_BLEND_ADDITIVE`
     * - `OBS_BLEND_SUBTRACT`
     * - `OBS_BLEND_SCREEN`
     * - `OBS_BLEND_MULTIPLY`
     * - `OBS_BLEND_LIGHTEN`
     * - `OBS_BLEND_DARKEN`
     * <p>
     * Scenes and Groups
     */
    public GetSceneItemBlendModeResponse getSceneItemBlendMode(String canvasUuid, String sceneName,
                                                               String sceneUuid, int sceneItemId) {
        return send(new GetSceneItemBlendModeRequest(canvasUuid, sceneName, sceneUuid, sceneItemId));
    }

    /**
     * Sets the blend mode of a scene item.
     * <p>
     * Scenes and Groups
     */
    public SetSceneItemBlendModeResponse setSceneItemBlendMode(String canvasUuid, String sceneName,
                                                               String sceneUuid, int sceneItemId, String sceneItemBlendMode) {
        return send(new SetSceneItemBlendModeRequest(canvasUuid, sceneName, sceneUuid, sceneItemId, sceneItemBlendMode));
    }

    /**
     * Gets an array of scenes in OBS.
     */
    public GetSceneListResponse getSceneList(String canvasUuid) {
        return send(new GetSceneListRequest(canvasUuid));
    }

    /**
     * Gets an array of all groups in OBS.
     * <p>
     * Groups in OBS are actually scenes, but renamed and modified. In obs-websocket, we treat them as scenes where we can.
     */
    public GetGroupListResponse getGroupList() {
        return send(new GetGroupListRequest());
    }

    /**
     * Gets the current program scene.
     * <p>
     * Note 1: This request is slated to have the `currentProgram`-prefixed fields removed from in an upcoming RPC version.
     * <p>
     * Note 2: Canvases do not have any concept of a program or preview scene, so this request does not support canvases.
     */
    public GetCurrentProgramSceneResponse getCurrentProgramScene() {
        return send(new GetCurrentProgramSceneRequest());
    }

    /**
     * Sets the current program scene.
     */
    public SetCurrentProgramSceneResponse setCurrentProgramScene(String sceneName,
                                                                 String sceneUuid) {
        return send(new SetCurrentProgramSceneRequest(sceneName, sceneUuid));
    }

    /**
     * Gets the current preview scene.
     * <p>
     * Only available when studio mode is enabled.
     * <p>
     * Note: This request is slated to have the `currentPreview`-prefixed fields removed from in an upcoming RPC version.
     */
    public GetCurrentPreviewSceneResponse getCurrentPreviewScene() {
        return send(new GetCurrentPreviewSceneRequest());
    }

    /**
     * Sets the current preview scene.
     * <p>
     * Only available when studio mode is enabled.
     */
    public SetCurrentPreviewSceneResponse setCurrentPreviewScene(String sceneName,
                                                                 String sceneUuid) {
        return send(new SetCurrentPreviewSceneRequest(sceneName, sceneUuid));
    }

    /**
     * Creates a new scene in OBS.
     */
    public CreateSceneResponse createScene(String canvasUuid, String sceneName) {
        return send(new CreateSceneRequest(canvasUuid, sceneName));
    }

    /**
     * Removes a scene from OBS.
     */
    public RemoveSceneResponse removeScene(String canvasUuid, String sceneName, String sceneUuid) {
        return send(new RemoveSceneRequest(canvasUuid, sceneName, sceneUuid));
    }

    /**
     * Sets the name of a scene (rename).
     */
    public SetSceneNameResponse setSceneName(String canvasUuid, String sceneName, String sceneUuid,
                                             String newSceneName) {
        return send(new SetSceneNameRequest(canvasUuid, sceneName, sceneUuid, newSceneName));
    }

    /**
     * Gets the scene transition overridden for a scene.
     * <p>
     * Note: A transition UUID response field is not currently able to be implemented as of 2024-1-18.
     */
    public GetSceneSceneTransitionOverrideResponse getSceneSceneTransitionOverride(
            String canvasUuid, String sceneName, String sceneUuid) {
        return send(new GetSceneSceneTransitionOverrideRequest(canvasUuid, sceneName, sceneUuid));
    }

    /**
     * Sets the scene transition overridden for a scene.
     */
    public SetSceneSceneTransitionOverrideResponse setSceneSceneTransitionOverride(
            String canvasUuid, String sceneName, String sceneUuid, String transitionName,
            int transitionDuration) {
        return send(new SetSceneSceneTransitionOverrideRequest(canvasUuid, sceneName, sceneUuid, transitionName, transitionDuration));
    }

    /**
     * Gets the active and show state of a source.
     * <p>
     * **Compatible with inputs and scenes.**
     */
    public GetSourceActiveResponse getSourceActive(String canvasUuid, String sourceName,
                                                   String sourceUuid) {
        return send(new GetSourceActiveRequest(canvasUuid, sourceName, sourceUuid));
    }

    /**
     * Gets a Base64-encoded screenshot of a source.
     * <p>
     * The `imageWidth` and `imageHeight` parameters are treated as "scale to inner", meaning the smallest ratio will be used and the aspect ratio of the original resolution is kept.
     * If `imageWidth` and `imageHeight` are not specified, the compressed image will use the full resolution of the source.
     * <p>
     * **Compatible with inputs and scenes.**
     */
    public GetSourceScreenshotResponse getSourceScreenshot(String canvasUuid, String sourceName,
                                                           String sourceUuid, String imageFormat, int imageWidth, int imageHeight,
                                                           int imageCompressionQuality) {
        return send(new GetSourceScreenshotRequest(canvasUuid, sourceName, sourceUuid, imageFormat, imageWidth, imageHeight, imageCompressionQuality));
    }

    /**
     * Saves a screenshot of a source to the filesystem.
     * <p>
     * The `imageWidth` and `imageHeight` parameters are treated as "scale to inner", meaning the smallest ratio will be used and the aspect ratio of the original resolution is kept.
     * If `imageWidth` and `imageHeight` are not specified, the compressed image will use the full resolution of the source.
     * <p>
     * **Compatible with inputs and scenes.**
     */
    public SaveSourceScreenshotResponse saveSourceScreenshot(String canvasUuid, String sourceName,
                                                             String sourceUuid, String imageFormat, String imageFilePath, int imageWidth,
                                                             int imageHeight, int imageCompressionQuality) {
        return send(new SaveSourceScreenshotRequest(canvasUuid, sourceName, sourceUuid, imageFormat, imageFilePath, imageWidth, imageHeight, imageCompressionQuality));
    }

    /**
     * Gets the status of the stream output.
     */
    public GetStreamStatusResponse getStreamStatus() {
        return send(new GetStreamStatusRequest());
    }

    /**
     * Toggles the status of the stream output.
     */
    public ToggleStreamResponse toggleStream() {
        return send(new ToggleStreamRequest());
    }

    /**
     * Starts the stream output.
     */
    public StartStreamResponse startStream() {
        return send(new StartStreamRequest());
    }

    /**
     * Stops the stream output.
     */
    public StopStreamResponse stopStream() {
        return send(new StopStreamRequest());
    }

    /**
     * Sends CEA-608 caption text over the stream output.
     */
    public SendStreamCaptionResponse sendStreamCaption(String captionText) {
        return send(new SendStreamCaptionRequest(captionText));
    }

    /**
     * Gets an array of all available transition kinds.
     * <p>
     * Similar to `GetInputKindList`
     */
    public GetTransitionKindListResponse getTransitionKindList() {
        return send(new GetTransitionKindListRequest());
    }

    /**
     * Gets an array of all scene transitions in OBS.
     */
    public GetSceneTransitionListResponse getSceneTransitionList() {
        return send(new GetSceneTransitionListRequest());
    }

    /**
     * Gets information about the current scene transition.
     */
    public GetCurrentSceneTransitionResponse getCurrentSceneTransition() {
        return send(new GetCurrentSceneTransitionRequest());
    }

    /**
     * Sets the current scene transition.
     * <p>
     * Small note: While the namespace of scene transitions is generally unique, that uniqueness is not a guarantee as it is with other resources like inputs.
     */
    public SetCurrentSceneTransitionResponse setCurrentSceneTransition(String transitionName) {
        return send(new SetCurrentSceneTransitionRequest(transitionName));
    }

    /**
     * Sets the duration of the current scene transition, if it is not fixed.
     */
    public SetCurrentSceneTransitionDurationResponse setCurrentSceneTransitionDuration(
            int transitionDuration) {
        return send(new SetCurrentSceneTransitionDurationRequest(transitionDuration));
    }

    /**
     * Sets the settings of the current scene transition.
     */
    public SetCurrentSceneTransitionSettingsResponse setCurrentSceneTransitionSettings(
            Object transitionSettings, boolean overlay) {
        return send(new SetCurrentSceneTransitionSettingsRequest(transitionSettings, overlay));
    }

    /**
     * Gets the cursor position of the current scene transition.
     * <p>
     * Note: `transitionCursor` will return 1.0 when the transition is inactive.
     */
    public GetCurrentSceneTransitionCursorResponse getCurrentSceneTransitionCursor() {
        return send(new GetCurrentSceneTransitionCursorRequest());
    }

    /**
     * Triggers the current scene transition. Same functionality as the `Transition` button in studio mode.
     */
    public TriggerStudioModeTransitionResponse triggerStudioModeTransition() {
        return send(new TriggerStudioModeTransitionRequest());
    }

    /**
     * Sets the position of the TBar.
     * <p>
     * **Very important note**: This will be deprecated and replaced in a future version of obs-websocket.
     */
    public SetTBarPositionResponse setTBarPosition(int position, boolean release) {
        return send(new SetTBarPositionRequest(position, release));
    }

    /**
     * Gets whether studio is enabled.
     */
    public GetStudioModeEnabledResponse getStudioModeEnabled() {
        return send(new GetStudioModeEnabledRequest());
    }

    /**
     * Enables or disables studio mode
     */
    public SetStudioModeEnabledResponse setStudioModeEnabled(boolean studioModeEnabled) {
        return send(new SetStudioModeEnabledRequest(studioModeEnabled));
    }

    /**
     * Opens the properties dialog of an input.
     */
    public OpenInputPropertiesDialogResponse openInputPropertiesDialog(String inputName,
                                                                       String inputUuid) {
        return send(new OpenInputPropertiesDialogRequest(inputName, inputUuid));
    }

    /**
     * Opens the filters dialog of an input.
     */
    public OpenInputFiltersDialogResponse openInputFiltersDialog(String inputName,
                                                                 String inputUuid) {
        return send(new OpenInputFiltersDialogRequest(inputName, inputUuid));
    }

    /**
     * Opens the interact dialog of an input.
     */
    public OpenInputInteractDialogResponse openInputInteractDialog(String inputName,
                                                                   String inputUuid) {
        return send(new OpenInputInteractDialogRequest(inputName, inputUuid));
    }

    /**
     * Gets a list of connected monitors and information about them.
     */
    public GetMonitorListResponse getMonitorList() {
        return send(new GetMonitorListRequest());
    }

    /**
     * Opens a projector for a specific output video mix.
     * <p>
     * Mix types:
     * <p>
     * - `OBS_WEBSOCKET_VIDEO_MIX_TYPE_PREVIEW`
     * - `OBS_WEBSOCKET_VIDEO_MIX_TYPE_PROGRAM`
     * - `OBS_WEBSOCKET_VIDEO_MIX_TYPE_MULTIVIEW`
     * <p>
     * Note: This request serves to provide feature parity with 4.x. It is very likely to be changed/deprecated in a future release.
     */
    public OpenVideoMixProjectorResponse openVideoMixProjector(String videoMixType,
                                                               int monitorIndex, String projectorGeometry) {
        return send(new OpenVideoMixProjectorRequest(videoMixType, monitorIndex, projectorGeometry));
    }

    /**
     * Opens a projector for a source.
     * <p>
     * Note: This request serves to provide feature parity with 4.x. It is very likely to be changed/deprecated in a future release.
     */
    public OpenSourceProjectorResponse openSourceProjector(String canvasUuid, String sourceName,
                                                           String sourceUuid, int monitorIndex, String projectorGeometry) {
        return send(new OpenSourceProjectorRequest(canvasUuid, sourceName, sourceUuid, monitorIndex, projectorGeometry));
    }

    /**
     * Send blocking request
     */
    private <R extends Request, RR extends RequestResponse> RR send(R request) {
        BlockingConsumer<RR> blockingConsumer = new BlockingConsumer<>();
        session.sendRequest(request.getRequestId(), request, blockingConsumer);
        try {
            return blockingConsumer.get(timeout);
        } catch (Exception e) {
            log.error("Send error", e);
        }
        return null;
    }
}
