package com.github.egorovna26.obs_remote_control.message.event;

import com.github.egorovna26.obs_remote_control.message.event.canvases.CanvasCreated;
import com.github.egorovna26.obs_remote_control.message.event.canvases.CanvasNameChanged;
import com.github.egorovna26.obs_remote_control.message.event.canvases.CanvasRemoved;
import com.github.egorovna26.obs_remote_control.message.event.config.CurrentProfileChanged;
import com.github.egorovna26.obs_remote_control.message.event.config.CurrentProfileChanging;
import com.github.egorovna26.obs_remote_control.message.event.config.CurrentSceneCollectionChanged;
import com.github.egorovna26.obs_remote_control.message.event.config.CurrentSceneCollectionChanging;
import com.github.egorovna26.obs_remote_control.message.event.config.ProfileListChanged;
import com.github.egorovna26.obs_remote_control.message.event.config.SceneCollectionListChanged;
import com.github.egorovna26.obs_remote_control.message.event.filters.SourceFilterCreated;
import com.github.egorovna26.obs_remote_control.message.event.filters.SourceFilterEnableStateChanged;
import com.github.egorovna26.obs_remote_control.message.event.filters.SourceFilterListReindexed;
import com.github.egorovna26.obs_remote_control.message.event.filters.SourceFilterNameChanged;
import com.github.egorovna26.obs_remote_control.message.event.filters.SourceFilterRemoved;
import com.github.egorovna26.obs_remote_control.message.event.filters.SourceFilterSettingsChanged;
import com.github.egorovna26.obs_remote_control.message.event.general.CustomEvent;
import com.github.egorovna26.obs_remote_control.message.event.general.ExitStarted;
import com.github.egorovna26.obs_remote_control.message.event.general.VendorEvent;
import com.github.egorovna26.obs_remote_control.message.event.inputs.InputActiveStateChanged;
import com.github.egorovna26.obs_remote_control.message.event.inputs.InputAudioBalanceChanged;
import com.github.egorovna26.obs_remote_control.message.event.inputs.InputAudioMonitorTypeChanged;
import com.github.egorovna26.obs_remote_control.message.event.inputs.InputAudioSyncOffsetChanged;
import com.github.egorovna26.obs_remote_control.message.event.inputs.InputAudioTracksChanged;
import com.github.egorovna26.obs_remote_control.message.event.inputs.InputCreated;
import com.github.egorovna26.obs_remote_control.message.event.inputs.InputMuteStateChanged;
import com.github.egorovna26.obs_remote_control.message.event.inputs.InputNameChanged;
import com.github.egorovna26.obs_remote_control.message.event.inputs.InputRemoved;
import com.github.egorovna26.obs_remote_control.message.event.inputs.InputSettingsChanged;
import com.github.egorovna26.obs_remote_control.message.event.inputs.InputShowStateChanged;
import com.github.egorovna26.obs_remote_control.message.event.inputs.InputVolumeChanged;
import com.github.egorovna26.obs_remote_control.message.event.inputs.InputVolumeMeters;
import com.github.egorovna26.obs_remote_control.message.event.media_inputs.MediaInputActionTriggered;
import com.github.egorovna26.obs_remote_control.message.event.media_inputs.MediaInputPlaybackEnded;
import com.github.egorovna26.obs_remote_control.message.event.media_inputs.MediaInputPlaybackStarted;
import com.github.egorovna26.obs_remote_control.message.event.outputs.RecordFileChanged;
import com.github.egorovna26.obs_remote_control.message.event.outputs.RecordStateChanged;
import com.github.egorovna26.obs_remote_control.message.event.outputs.ReplayBufferSaved;
import com.github.egorovna26.obs_remote_control.message.event.outputs.ReplayBufferStateChanged;
import com.github.egorovna26.obs_remote_control.message.event.outputs.StreamStateChanged;
import com.github.egorovna26.obs_remote_control.message.event.outputs.VirtualcamStateChanged;
import com.github.egorovna26.obs_remote_control.message.event.scene_items.SceneItemCreated;
import com.github.egorovna26.obs_remote_control.message.event.scene_items.SceneItemEnableStateChanged;
import com.github.egorovna26.obs_remote_control.message.event.scene_items.SceneItemListReindexed;
import com.github.egorovna26.obs_remote_control.message.event.scene_items.SceneItemLockStateChanged;
import com.github.egorovna26.obs_remote_control.message.event.scene_items.SceneItemRemoved;
import com.github.egorovna26.obs_remote_control.message.event.scene_items.SceneItemSelected;
import com.github.egorovna26.obs_remote_control.message.event.scene_items.SceneItemTransformChanged;
import com.github.egorovna26.obs_remote_control.message.event.scenes.CurrentPreviewSceneChanged;
import com.github.egorovna26.obs_remote_control.message.event.scenes.CurrentProgramSceneChanged;
import com.github.egorovna26.obs_remote_control.message.event.scenes.SceneCreated;
import com.github.egorovna26.obs_remote_control.message.event.scenes.SceneListChanged;
import com.github.egorovna26.obs_remote_control.message.event.scenes.SceneNameChanged;
import com.github.egorovna26.obs_remote_control.message.event.scenes.SceneRemoved;
import com.github.egorovna26.obs_remote_control.message.event.transitions.CurrentSceneTransitionChanged;
import com.github.egorovna26.obs_remote_control.message.event.transitions.CurrentSceneTransitionDurationChanged;
import com.github.egorovna26.obs_remote_control.message.event.transitions.SceneTransitionEnded;
import com.github.egorovna26.obs_remote_control.message.event.transitions.SceneTransitionStarted;
import com.github.egorovna26.obs_remote_control.message.event.transitions.SceneTransitionVideoEnded;
import com.github.egorovna26.obs_remote_control.message.event.ui.ScreenshotSaved;
import com.github.egorovna26.obs_remote_control.message.event.ui.StudioModeStateChanged;
import java.io.Serializable;
import java.lang.Class;
import java.lang.String;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * Event Types
 */
@RequiredArgsConstructor
@Getter
public enum EventType implements Serializable {
    /**
     * A new canvas has been created.
     */
    CANVAS_CREATED("CanvasCreated", CanvasCreated.class),

    /**
     * A canvas has been removed.
     */
    CANVAS_REMOVED("CanvasRemoved", CanvasRemoved.class),

    /**
     * The name of a canvas has changed.
     */
    CANVAS_NAME_CHANGED("CanvasNameChanged", CanvasNameChanged.class),

    /**
     * The current scene collection has begun changing.
     *
     * Note: We recommend using this event to trigger a pause of all polling requests, as performing any requests during a
     * scene collection change is considered undefined behavior and can cause crashes!
     */
    CURRENT_SCENE_COLLECTION_CHANGING("CurrentSceneCollectionChanging", CurrentSceneCollectionChanging.class),

    /**
     * The current scene collection has changed.
     *
     * Note: If polling has been paused during `CurrentSceneCollectionChanging`, this is the que to restart polling.
     */
    CURRENT_SCENE_COLLECTION_CHANGED("CurrentSceneCollectionChanged", CurrentSceneCollectionChanged.class),

    /**
     * The scene collection list has changed.
     */
    SCENE_COLLECTION_LIST_CHANGED("SceneCollectionListChanged", SceneCollectionListChanged.class),

    /**
     * The current profile has begun changing.
     */
    CURRENT_PROFILE_CHANGING("CurrentProfileChanging", CurrentProfileChanging.class),

    /**
     * The current profile has changed.
     */
    CURRENT_PROFILE_CHANGED("CurrentProfileChanged", CurrentProfileChanged.class),

    /**
     * The profile list has changed.
     */
    PROFILE_LIST_CHANGED("ProfileListChanged", ProfileListChanged.class),

    /**
     * A source's filter list has been reindexed.
     */
    SOURCE_FILTER_LIST_REINDEXED("SourceFilterListReindexed", SourceFilterListReindexed.class),

    /**
     * A filter has been added to a source.
     */
    SOURCE_FILTER_CREATED("SourceFilterCreated", SourceFilterCreated.class),

    /**
     * A filter has been removed from a source.
     */
    SOURCE_FILTER_REMOVED("SourceFilterRemoved", SourceFilterRemoved.class),

    /**
     * The name of a source filter has changed.
     */
    SOURCE_FILTER_NAME_CHANGED("SourceFilterNameChanged", SourceFilterNameChanged.class),

    /**
     * An source filter's settings have changed (been updated).
     */
    SOURCE_FILTER_SETTINGS_CHANGED("SourceFilterSettingsChanged", SourceFilterSettingsChanged.class),

    /**
     * A source filter's enable state has changed.
     */
    SOURCE_FILTER_ENABLE_STATE_CHANGED("SourceFilterEnableStateChanged", SourceFilterEnableStateChanged.class),

    /**
     * OBS has begun the shutdown process.
     */
    EXIT_STARTED("ExitStarted", ExitStarted.class),

    /**
     * An input has been created.
     */
    INPUT_CREATED("InputCreated", InputCreated.class),

    /**
     * An input has been removed.
     */
    INPUT_REMOVED("InputRemoved", InputRemoved.class),

    /**
     * The name of an input has changed.
     */
    INPUT_NAME_CHANGED("InputNameChanged", InputNameChanged.class),

    /**
     * An input's settings have changed (been updated).
     *
     * Note: On some inputs, changing values in the properties dialog will cause an immediate update. Pressing the "Cancel" button will revert the settings, resulting in another event being fired.
     */
    INPUT_SETTINGS_CHANGED("InputSettingsChanged", InputSettingsChanged.class),

    /**
     * An input's active state has changed.
     *
     * When an input is active, it means it's being shown by the program feed.
     */
    INPUT_ACTIVE_STATE_CHANGED("InputActiveStateChanged", InputActiveStateChanged.class),

    /**
     * An input's show state has changed.
     *
     * When an input is showing, it means it's being shown by the preview or a dialog.
     */
    INPUT_SHOW_STATE_CHANGED("InputShowStateChanged", InputShowStateChanged.class),

    /**
     * An input's mute state has changed.
     */
    INPUT_MUTE_STATE_CHANGED("InputMuteStateChanged", InputMuteStateChanged.class),

    /**
     * An input's volume level has changed.
     */
    INPUT_VOLUME_CHANGED("InputVolumeChanged", InputVolumeChanged.class),

    /**
     * The audio balance value of an input has changed.
     */
    INPUT_AUDIO_BALANCE_CHANGED("InputAudioBalanceChanged", InputAudioBalanceChanged.class),

    /**
     * The sync offset of an input has changed.
     */
    INPUT_AUDIO_SYNC_OFFSET_CHANGED("InputAudioSyncOffsetChanged", InputAudioSyncOffsetChanged.class),

    /**
     * The audio tracks of an input have changed.
     */
    INPUT_AUDIO_TRACKS_CHANGED("InputAudioTracksChanged", InputAudioTracksChanged.class),

    /**
     * The monitor type of an input has changed.
     *
     * Available types are:
     *
     * - `OBS_MONITORING_TYPE_NONE`
     * - `OBS_MONITORING_TYPE_MONITOR_ONLY`
     * - `OBS_MONITORING_TYPE_MONITOR_AND_OUTPUT`
     */
    INPUT_AUDIO_MONITOR_TYPE_CHANGED("InputAudioMonitorTypeChanged", InputAudioMonitorTypeChanged.class),

    /**
     * A high-volume event providing volume levels of all active inputs every 50 milliseconds.
     */
    INPUT_VOLUME_METERS("InputVolumeMeters", InputVolumeMeters.class),

    /**
     * A media input has started playing.
     */
    MEDIA_INPUT_PLAYBACK_STARTED("MediaInputPlaybackStarted", MediaInputPlaybackStarted.class),

    /**
     * A media input has finished playing.
     */
    MEDIA_INPUT_PLAYBACK_ENDED("MediaInputPlaybackEnded", MediaInputPlaybackEnded.class),

    /**
     * An action has been performed on an input.
     */
    MEDIA_INPUT_ACTION_TRIGGERED("MediaInputActionTriggered", MediaInputActionTriggered.class),

    /**
     * The state of the stream output has changed.
     */
    STREAM_STATE_CHANGED("StreamStateChanged", StreamStateChanged.class),

    /**
     * The state of the record output has changed.
     */
    RECORD_STATE_CHANGED("RecordStateChanged", RecordStateChanged.class),

    /**
     * The record output has started writing to a new file. For example, when a file split happens.
     */
    RECORD_FILE_CHANGED("RecordFileChanged", RecordFileChanged.class),

    /**
     * The state of the replay buffer output has changed.
     */
    REPLAY_BUFFER_STATE_CHANGED("ReplayBufferStateChanged", ReplayBufferStateChanged.class),

    /**
     * The state of the virtualcam output has changed.
     */
    VIRTUALCAM_STATE_CHANGED("VirtualcamStateChanged", VirtualcamStateChanged.class),

    /**
     * The replay buffer has been saved.
     */
    REPLAY_BUFFER_SAVED("ReplayBufferSaved", ReplayBufferSaved.class),

    /**
     * A scene item has been created.
     */
    SCENE_ITEM_CREATED("SceneItemCreated", SceneItemCreated.class),

    /**
     * A scene item has been removed.
     *
     * This event is not emitted when the scene the item is in is removed.
     */
    SCENE_ITEM_REMOVED("SceneItemRemoved", SceneItemRemoved.class),

    /**
     * A scene's item list has been reindexed.
     */
    SCENE_ITEM_LIST_REINDEXED("SceneItemListReindexed", SceneItemListReindexed.class),

    /**
     * A scene item's enable state has changed.
     */
    SCENE_ITEM_ENABLE_STATE_CHANGED("SceneItemEnableStateChanged", SceneItemEnableStateChanged.class),

    /**
     * A scene item's lock state has changed.
     */
    SCENE_ITEM_LOCK_STATE_CHANGED("SceneItemLockStateChanged", SceneItemLockStateChanged.class),

    /**
     * A scene item has been selected in the Ui.
     */
    SCENE_ITEM_SELECTED("SceneItemSelected", SceneItemSelected.class),

    /**
     * The transform/crop of a scene item has changed.
     */
    SCENE_ITEM_TRANSFORM_CHANGED("SceneItemTransformChanged", SceneItemTransformChanged.class),

    /**
     * A new scene has been created.
     */
    SCENE_CREATED("SceneCreated", SceneCreated.class),

    /**
     * A scene has been removed.
     */
    SCENE_REMOVED("SceneRemoved", SceneRemoved.class),

    /**
     * The name of a scene has changed.
     */
    SCENE_NAME_CHANGED("SceneNameChanged", SceneNameChanged.class),

    /**
     * The current program scene has changed.
     */
    CURRENT_PROGRAM_SCENE_CHANGED("CurrentProgramSceneChanged", CurrentProgramSceneChanged.class),

    /**
     * The current preview scene has changed.
     */
    CURRENT_PREVIEW_SCENE_CHANGED("CurrentPreviewSceneChanged", CurrentPreviewSceneChanged.class),

    /**
     * The list of scenes has changed.
     *
     * TODO: Make OBS fire this event when scenes are reordered.
     */
    SCENE_LIST_CHANGED("SceneListChanged", SceneListChanged.class),

    /**
     * The current scene transition has changed.
     */
    CURRENT_SCENE_TRANSITION_CHANGED("CurrentSceneTransitionChanged", CurrentSceneTransitionChanged.class),

    /**
     * The current scene transition duration has changed.
     */
    CURRENT_SCENE_TRANSITION_DURATION_CHANGED("CurrentSceneTransitionDurationChanged", CurrentSceneTransitionDurationChanged.class),

    /**
     * A scene transition has started.
     */
    SCENE_TRANSITION_STARTED("SceneTransitionStarted", SceneTransitionStarted.class),

    /**
     * A scene transition has completed fully.
     *
     * Note: Does not appear to trigger when the transition is interrupted by the user.
     */
    SCENE_TRANSITION_ENDED("SceneTransitionEnded", SceneTransitionEnded.class),

    /**
     * A scene transition's video has completed fully.
     *
     * Useful for stinger transitions to tell when the video *actually* ends.
     * `SceneTransitionEnded` only signifies the cut point, not the completion of transition playback.
     *
     * Note: Appears to be called by every transition, regardless of relevance.
     */
    SCENE_TRANSITION_VIDEO_ENDED("SceneTransitionVideoEnded", SceneTransitionVideoEnded.class),

    /**
     * Studio mode has been enabled or disabled.
     */
    STUDIO_MODE_STATE_CHANGED("StudioModeStateChanged", StudioModeStateChanged.class),

    /**
     * A screenshot has been saved.
     *
     * Note: Triggered for the screenshot feature available in `Settings -&gt; Hotkeys -&gt; Screenshot Output` ONLY.
     * Applications using `Get/SaveSourceScreenshot` should implement a `CustomEvent` if this kind of inter-client
     * communication is desired.
     */
    SCREENSHOT_SAVED("ScreenshotSaved", ScreenshotSaved.class),

    /**
     * An event has been emitted from a vendor.
     *
     * A vendor is a unique name registered by a third-party plugin or script, which allows for custom requests and events to be added to obs-websocket.
     * If a plugin or script implements vendor requests or events, documentation is expected to be provided with them.
     */
    VENDOR_EVENT("VendorEvent", VendorEvent.class),

    /**
     * Custom event emitted by `BroadcastCustomEvent`.
     */
    CUSTOM_EVENT("CustomEvent", CustomEvent.class);

    private final String eventType;

    private final Class<? extends Event> eventClass;

    public static EventType find(String eventType) {
        for (EventType value : EventType.values()) {
            if (StringUtils.equalsIgnoreCase(eventType, value.getEventType())) {
                return value;
            }
        }
        return null;
    }
}
