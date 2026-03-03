package com.github.egorovna26.obs_remote_control.message.request;

import com.github.egorovna26.obs_remote_control.message.request.canvases.GetCanvasListRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.CreateProfileRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.CreateSceneCollectionRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.GetPersistentDataRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.GetProfileListRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.GetProfileParameterRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.GetRecordDirectoryRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.GetSceneCollectionListRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.GetStreamServiceSettingsRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.GetVideoSettingsRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.RemoveProfileRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.SetCurrentProfileRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.SetCurrentSceneCollectionRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.SetPersistentDataRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.SetProfileParameterRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.SetRecordDirectoryRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.SetStreamServiceSettingsRequest;
import com.github.egorovna26.obs_remote_control.message.request.config.SetVideoSettingsRequest;
import com.github.egorovna26.obs_remote_control.message.request.filters.CreateSourceFilterRequest;
import com.github.egorovna26.obs_remote_control.message.request.filters.GetSourceFilterDefaultSettingsRequest;
import com.github.egorovna26.obs_remote_control.message.request.filters.GetSourceFilterKindListRequest;
import com.github.egorovna26.obs_remote_control.message.request.filters.GetSourceFilterListRequest;
import com.github.egorovna26.obs_remote_control.message.request.filters.GetSourceFilterRequest;
import com.github.egorovna26.obs_remote_control.message.request.filters.RemoveSourceFilterRequest;
import com.github.egorovna26.obs_remote_control.message.request.filters.SetSourceFilterEnabledRequest;
import com.github.egorovna26.obs_remote_control.message.request.filters.SetSourceFilterIndexRequest;
import com.github.egorovna26.obs_remote_control.message.request.filters.SetSourceFilterNameRequest;
import com.github.egorovna26.obs_remote_control.message.request.filters.SetSourceFilterSettingsRequest;
import com.github.egorovna26.obs_remote_control.message.request.general.BroadcastCustomEventRequest;
import com.github.egorovna26.obs_remote_control.message.request.general.CallVendorRequestRequest;
import com.github.egorovna26.obs_remote_control.message.request.general.GetHotkeyListRequest;
import com.github.egorovna26.obs_remote_control.message.request.general.GetStatsRequest;
import com.github.egorovna26.obs_remote_control.message.request.general.GetVersionRequest;
import com.github.egorovna26.obs_remote_control.message.request.general.SleepRequest;
import com.github.egorovna26.obs_remote_control.message.request.general.TriggerHotkeyByKeySequenceRequest;
import com.github.egorovna26.obs_remote_control.message.request.general.TriggerHotkeyByNameRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.CreateInputRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.GetInputAudioBalanceRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.GetInputAudioMonitorTypeRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.GetInputAudioSyncOffsetRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.GetInputAudioTracksRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.GetInputDefaultSettingsRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.GetInputDeinterlaceFieldOrderRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.GetInputDeinterlaceModeRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.GetInputKindListRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.GetInputListRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.GetInputMuteRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.GetInputPropertiesListPropertyItemsRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.GetInputSettingsRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.GetInputVolumeRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.GetSpecialInputsRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.PressInputPropertiesButtonRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.RemoveInputRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.SetInputAudioBalanceRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.SetInputAudioMonitorTypeRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.SetInputAudioSyncOffsetRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.SetInputAudioTracksRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.SetInputDeinterlaceFieldOrderRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.SetInputDeinterlaceModeRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.SetInputMuteRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.SetInputNameRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.SetInputSettingsRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.SetInputVolumeRequest;
import com.github.egorovna26.obs_remote_control.message.request.inputs.ToggleInputMuteRequest;
import com.github.egorovna26.obs_remote_control.message.request.media_inputs.GetMediaInputStatusRequest;
import com.github.egorovna26.obs_remote_control.message.request.media_inputs.OffsetMediaInputCursorRequest;
import com.github.egorovna26.obs_remote_control.message.request.media_inputs.SetMediaInputCursorRequest;
import com.github.egorovna26.obs_remote_control.message.request.media_inputs.TriggerMediaInputActionRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.GetLastReplayBufferReplayRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.GetOutputListRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.GetOutputSettingsRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.GetOutputStatusRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.GetReplayBufferStatusRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.GetVirtualCamStatusRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.SaveReplayBufferRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.SetOutputSettingsRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.StartOutputRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.StartReplayBufferRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.StartVirtualCamRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.StopOutputRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.StopReplayBufferRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.StopVirtualCamRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.ToggleOutputRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.ToggleReplayBufferRequest;
import com.github.egorovna26.obs_remote_control.message.request.outputs.ToggleVirtualCamRequest;
import com.github.egorovna26.obs_remote_control.message.request.record.CreateRecordChapterRequest;
import com.github.egorovna26.obs_remote_control.message.request.record.GetRecordStatusRequest;
import com.github.egorovna26.obs_remote_control.message.request.record.PauseRecordRequest;
import com.github.egorovna26.obs_remote_control.message.request.record.ResumeRecordRequest;
import com.github.egorovna26.obs_remote_control.message.request.record.SplitRecordFileRequest;
import com.github.egorovna26.obs_remote_control.message.request.record.StartRecordRequest;
import com.github.egorovna26.obs_remote_control.message.request.record.StopRecordRequest;
import com.github.egorovna26.obs_remote_control.message.request.record.ToggleRecordPauseRequest;
import com.github.egorovna26.obs_remote_control.message.request.record.ToggleRecordRequest;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.CreateSceneItemRequest;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.DuplicateSceneItemRequest;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.GetGroupSceneItemListRequest;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.GetSceneItemBlendModeRequest;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.GetSceneItemEnabledRequest;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.GetSceneItemIdRequest;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.GetSceneItemIndexRequest;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.GetSceneItemListRequest;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.GetSceneItemLockedRequest;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.GetSceneItemSourceRequest;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.GetSceneItemTransformRequest;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.RemoveSceneItemRequest;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.SetSceneItemBlendModeRequest;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.SetSceneItemEnabledRequest;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.SetSceneItemIndexRequest;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.SetSceneItemLockedRequest;
import com.github.egorovna26.obs_remote_control.message.request.scene_items.SetSceneItemTransformRequest;
import com.github.egorovna26.obs_remote_control.message.request.scenes.CreateSceneRequest;
import com.github.egorovna26.obs_remote_control.message.request.scenes.GetCurrentPreviewSceneRequest;
import com.github.egorovna26.obs_remote_control.message.request.scenes.GetCurrentProgramSceneRequest;
import com.github.egorovna26.obs_remote_control.message.request.scenes.GetGroupListRequest;
import com.github.egorovna26.obs_remote_control.message.request.scenes.GetSceneListRequest;
import com.github.egorovna26.obs_remote_control.message.request.scenes.GetSceneSceneTransitionOverrideRequest;
import com.github.egorovna26.obs_remote_control.message.request.scenes.RemoveSceneRequest;
import com.github.egorovna26.obs_remote_control.message.request.scenes.SetCurrentPreviewSceneRequest;
import com.github.egorovna26.obs_remote_control.message.request.scenes.SetCurrentProgramSceneRequest;
import com.github.egorovna26.obs_remote_control.message.request.scenes.SetSceneNameRequest;
import com.github.egorovna26.obs_remote_control.message.request.scenes.SetSceneSceneTransitionOverrideRequest;
import com.github.egorovna26.obs_remote_control.message.request.sources.GetSourceActiveRequest;
import com.github.egorovna26.obs_remote_control.message.request.sources.GetSourceScreenshotRequest;
import com.github.egorovna26.obs_remote_control.message.request.sources.SaveSourceScreenshotRequest;
import com.github.egorovna26.obs_remote_control.message.request.stream.GetStreamStatusRequest;
import com.github.egorovna26.obs_remote_control.message.request.stream.SendStreamCaptionRequest;
import com.github.egorovna26.obs_remote_control.message.request.stream.StartStreamRequest;
import com.github.egorovna26.obs_remote_control.message.request.stream.StopStreamRequest;
import com.github.egorovna26.obs_remote_control.message.request.stream.ToggleStreamRequest;
import com.github.egorovna26.obs_remote_control.message.request.transitions.GetCurrentSceneTransitionCursorRequest;
import com.github.egorovna26.obs_remote_control.message.request.transitions.GetCurrentSceneTransitionRequest;
import com.github.egorovna26.obs_remote_control.message.request.transitions.GetSceneTransitionListRequest;
import com.github.egorovna26.obs_remote_control.message.request.transitions.GetTransitionKindListRequest;
import com.github.egorovna26.obs_remote_control.message.request.transitions.SetCurrentSceneTransitionDurationRequest;
import com.github.egorovna26.obs_remote_control.message.request.transitions.SetCurrentSceneTransitionRequest;
import com.github.egorovna26.obs_remote_control.message.request.transitions.SetCurrentSceneTransitionSettingsRequest;
import com.github.egorovna26.obs_remote_control.message.request.transitions.SetTBarPositionRequest;
import com.github.egorovna26.obs_remote_control.message.request.transitions.TriggerStudioModeTransitionRequest;
import com.github.egorovna26.obs_remote_control.message.request.ui.GetMonitorListRequest;
import com.github.egorovna26.obs_remote_control.message.request.ui.GetStudioModeEnabledRequest;
import com.github.egorovna26.obs_remote_control.message.request.ui.OpenInputFiltersDialogRequest;
import com.github.egorovna26.obs_remote_control.message.request.ui.OpenInputInteractDialogRequest;
import com.github.egorovna26.obs_remote_control.message.request.ui.OpenInputPropertiesDialogRequest;
import com.github.egorovna26.obs_remote_control.message.request.ui.OpenSourceProjectorRequest;
import com.github.egorovna26.obs_remote_control.message.request.ui.OpenVideoMixProjectorRequest;
import com.github.egorovna26.obs_remote_control.message.request.ui.SetStudioModeEnabledRequest;
import com.github.egorovna26.obs_remote_control.message.requestresponse.RequestResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.canvases.GetCanvasListResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.CreateProfileResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.CreateSceneCollectionResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.GetPersistentDataResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.GetProfileListResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.GetProfileParameterResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.GetRecordDirectoryResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.GetSceneCollectionListResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.GetStreamServiceSettingsResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.GetVideoSettingsResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.RemoveProfileResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.SetCurrentProfileResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.SetCurrentSceneCollectionResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.SetPersistentDataResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.SetProfileParameterResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.SetRecordDirectoryResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.SetStreamServiceSettingsResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.config.SetVideoSettingsResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.filters.CreateSourceFilterResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.filters.GetSourceFilterDefaultSettingsResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.filters.GetSourceFilterKindListResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.filters.GetSourceFilterListResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.filters.GetSourceFilterResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.filters.RemoveSourceFilterResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.filters.SetSourceFilterEnabledResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.filters.SetSourceFilterIndexResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.filters.SetSourceFilterNameResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.filters.SetSourceFilterSettingsResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.general.BroadcastCustomEventResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.general.CallVendorRequestResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.general.GetHotkeyListResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.general.GetStatsResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.general.GetVersionResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.general.SleepResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.general.TriggerHotkeyByKeySequenceResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.general.TriggerHotkeyByNameResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.CreateInputResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.GetInputAudioBalanceResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.GetInputAudioMonitorTypeResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.GetInputAudioSyncOffsetResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.GetInputAudioTracksResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.GetInputDefaultSettingsResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.GetInputDeinterlaceFieldOrderResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.GetInputDeinterlaceModeResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.GetInputKindListResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.GetInputListResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.GetInputMuteResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.GetInputPropertiesListPropertyItemsResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.GetInputSettingsResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.GetInputVolumeResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.GetSpecialInputsResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.PressInputPropertiesButtonResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.RemoveInputResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.SetInputAudioBalanceResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.SetInputAudioMonitorTypeResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.SetInputAudioSyncOffsetResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.SetInputAudioTracksResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.SetInputDeinterlaceFieldOrderResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.SetInputDeinterlaceModeResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.SetInputMuteResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.SetInputNameResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.SetInputSettingsResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.SetInputVolumeResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.inputs.ToggleInputMuteResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.media_inputs.GetMediaInputStatusResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.media_inputs.OffsetMediaInputCursorResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.media_inputs.SetMediaInputCursorResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.media_inputs.TriggerMediaInputActionResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.GetLastReplayBufferReplayResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.GetOutputListResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.GetOutputSettingsResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.GetOutputStatusResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.GetReplayBufferStatusResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.GetVirtualCamStatusResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.SaveReplayBufferResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.SetOutputSettingsResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.StartOutputResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.StartReplayBufferResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.StartVirtualCamResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.StopOutputResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.StopReplayBufferResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.StopVirtualCamResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.ToggleOutputResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.ToggleReplayBufferResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.outputs.ToggleVirtualCamResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.record.CreateRecordChapterResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.record.GetRecordStatusResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.record.PauseRecordResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.record.ResumeRecordResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.record.SplitRecordFileResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.record.StartRecordResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.record.StopRecordResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.record.ToggleRecordPauseResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.record.ToggleRecordResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.CreateSceneItemResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.DuplicateSceneItemResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.GetGroupSceneItemListResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.GetSceneItemBlendModeResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.GetSceneItemEnabledResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.GetSceneItemIdResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.GetSceneItemIndexResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.GetSceneItemListResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.GetSceneItemLockedResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.GetSceneItemSourceResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.GetSceneItemTransformResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.RemoveSceneItemResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.SetSceneItemBlendModeResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.SetSceneItemEnabledResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.SetSceneItemIndexResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.SetSceneItemLockedResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scene_items.SetSceneItemTransformResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scenes.CreateSceneResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scenes.GetCurrentPreviewSceneResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scenes.GetCurrentProgramSceneResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scenes.GetGroupListResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scenes.GetSceneListResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scenes.GetSceneSceneTransitionOverrideResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scenes.RemoveSceneResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scenes.SetCurrentPreviewSceneResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scenes.SetCurrentProgramSceneResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scenes.SetSceneNameResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.scenes.SetSceneSceneTransitionOverrideResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.sources.GetSourceActiveResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.sources.GetSourceScreenshotResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.sources.SaveSourceScreenshotResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.stream.GetStreamStatusResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.stream.SendStreamCaptionResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.stream.StartStreamResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.stream.StopStreamResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.stream.ToggleStreamResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.transitions.GetCurrentSceneTransitionCursorResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.transitions.GetCurrentSceneTransitionResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.transitions.GetSceneTransitionListResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.transitions.GetTransitionKindListResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.transitions.SetCurrentSceneTransitionDurationResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.transitions.SetCurrentSceneTransitionResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.transitions.SetCurrentSceneTransitionSettingsResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.transitions.SetTBarPositionResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.transitions.TriggerStudioModeTransitionResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.ui.GetMonitorListResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.ui.GetStudioModeEnabledResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.ui.OpenInputFiltersDialogResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.ui.OpenInputInteractDialogResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.ui.OpenInputPropertiesDialogResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.ui.OpenSourceProjectorResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.ui.OpenVideoMixProjectorResponse;
import com.github.egorovna26.obs_remote_control.message.requestresponse.ui.SetStudioModeEnabledResponse;
import java.io.Serializable;
import java.lang.Class;
import java.lang.String;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * Request Types
 */
@RequiredArgsConstructor
@Getter
public enum RequestType implements Serializable {
    /**
     * Gets an array of canvases in OBS.
     */
    GET_CANVAS_LIST("GetCanvasList", GetCanvasListRequest.class, GetCanvasListResponse.class),

    /**
     * Gets the value of a "slot" from the selected persistent data realm.
     */
    GET_PERSISTENT_DATA("GetPersistentData", GetPersistentDataRequest.class, GetPersistentDataResponse.class),

    /**
     * Sets the value of a "slot" from the selected persistent data realm.
     */
    SET_PERSISTENT_DATA("SetPersistentData", SetPersistentDataRequest.class, SetPersistentDataResponse.class),

    /**
     * Gets an array of all scene collections
     */
    GET_SCENE_COLLECTION_LIST("GetSceneCollectionList", GetSceneCollectionListRequest.class, GetSceneCollectionListResponse.class),

    /**
     * Switches to a scene collection.
     *
     * Note: This will block until the collection has finished changing.
     */
    SET_CURRENT_SCENE_COLLECTION("SetCurrentSceneCollection", SetCurrentSceneCollectionRequest.class, SetCurrentSceneCollectionResponse.class),

    /**
     * Creates a new scene collection, switching to it in the process.
     *
     * Note: This will block until the collection has finished changing.
     */
    CREATE_SCENE_COLLECTION("CreateSceneCollection", CreateSceneCollectionRequest.class, CreateSceneCollectionResponse.class),

    /**
     * Gets an array of all profiles
     */
    GET_PROFILE_LIST("GetProfileList", GetProfileListRequest.class, GetProfileListResponse.class),

    /**
     * Switches to a profile.
     */
    SET_CURRENT_PROFILE("SetCurrentProfile", SetCurrentProfileRequest.class, SetCurrentProfileResponse.class),

    /**
     * Creates a new profile, switching to it in the process
     */
    CREATE_PROFILE("CreateProfile", CreateProfileRequest.class, CreateProfileResponse.class),

    /**
     * Removes a profile. If the current profile is chosen, it will change to a different profile first.
     */
    REMOVE_PROFILE("RemoveProfile", RemoveProfileRequest.class, RemoveProfileResponse.class),

    /**
     * Gets a parameter from the current profile's configuration.
     */
    GET_PROFILE_PARAMETER("GetProfileParameter", GetProfileParameterRequest.class, GetProfileParameterResponse.class),

    /**
     * Sets the value of a parameter in the current profile's configuration.
     */
    SET_PROFILE_PARAMETER("SetProfileParameter", SetProfileParameterRequest.class, SetProfileParameterResponse.class),

    /**
     * Gets the current video settings.
     *
     * Note: To get the true FPS value, divide the FPS numerator by the FPS denominator. Example: `60000/1001`
     */
    GET_VIDEO_SETTINGS("GetVideoSettings", GetVideoSettingsRequest.class, GetVideoSettingsResponse.class),

    /**
     * Sets the current video settings.
     *
     * Note: Fields must be specified in pairs. For example, you cannot set only `baseWidth` without needing to specify `baseHeight`.
     */
    SET_VIDEO_SETTINGS("SetVideoSettings", SetVideoSettingsRequest.class, SetVideoSettingsResponse.class),

    /**
     * Gets the current stream service settings (stream destination).
     */
    GET_STREAM_SERVICE_SETTINGS("GetStreamServiceSettings", GetStreamServiceSettingsRequest.class, GetStreamServiceSettingsResponse.class),

    /**
     * Sets the current stream service settings (stream destination).
     *
     * Note: Simple RTMP settings can be set with type `rtmp_custom` and the settings fields `server` and `key`.
     */
    SET_STREAM_SERVICE_SETTINGS("SetStreamServiceSettings", SetStreamServiceSettingsRequest.class, SetStreamServiceSettingsResponse.class),

    /**
     * Gets the current directory that the record output is set to.
     */
    GET_RECORD_DIRECTORY("GetRecordDirectory", GetRecordDirectoryRequest.class, GetRecordDirectoryResponse.class),

    /**
     * Sets the current directory that the record output writes files to.
     */
    SET_RECORD_DIRECTORY("SetRecordDirectory", SetRecordDirectoryRequest.class, SetRecordDirectoryResponse.class),

    /**
     * Gets an array of all available source filter kinds.
     *
     * Similar to `GetInputKindList`
     */
    GET_SOURCE_FILTER_KIND_LIST("GetSourceFilterKindList", GetSourceFilterKindListRequest.class, GetSourceFilterKindListResponse.class),

    /**
     * Gets an array of all of a source's filters.
     */
    GET_SOURCE_FILTER_LIST("GetSourceFilterList", GetSourceFilterListRequest.class, GetSourceFilterListResponse.class),

    /**
     * Gets the default settings for a filter kind.
     */
    GET_SOURCE_FILTER_DEFAULT_SETTINGS("GetSourceFilterDefaultSettings", GetSourceFilterDefaultSettingsRequest.class, GetSourceFilterDefaultSettingsResponse.class),

    /**
     * Creates a new filter, adding it to the specified source.
     */
    CREATE_SOURCE_FILTER("CreateSourceFilter", CreateSourceFilterRequest.class, CreateSourceFilterResponse.class),

    /**
     * Removes a filter from a source.
     */
    REMOVE_SOURCE_FILTER("RemoveSourceFilter", RemoveSourceFilterRequest.class, RemoveSourceFilterResponse.class),

    /**
     * Sets the name of a source filter (rename).
     */
    SET_SOURCE_FILTER_NAME("SetSourceFilterName", SetSourceFilterNameRequest.class, SetSourceFilterNameResponse.class),

    /**
     * Gets the info for a specific source filter.
     */
    GET_SOURCE_FILTER("GetSourceFilter", GetSourceFilterRequest.class, GetSourceFilterResponse.class),

    /**
     * Sets the index position of a filter on a source.
     */
    SET_SOURCE_FILTER_INDEX("SetSourceFilterIndex", SetSourceFilterIndexRequest.class, SetSourceFilterIndexResponse.class),

    /**
     * Sets the settings of a source filter.
     */
    SET_SOURCE_FILTER_SETTINGS("SetSourceFilterSettings", SetSourceFilterSettingsRequest.class, SetSourceFilterSettingsResponse.class),

    /**
     * Sets the enable state of a source filter.
     */
    SET_SOURCE_FILTER_ENABLED("SetSourceFilterEnabled", SetSourceFilterEnabledRequest.class, SetSourceFilterEnabledResponse.class),

    /**
     * Gets data about the current plugin and RPC version.
     */
    GET_VERSION("GetVersion", GetVersionRequest.class, GetVersionResponse.class),

    /**
     * Gets statistics about OBS, obs-websocket, and the current session.
     */
    GET_STATS("GetStats", GetStatsRequest.class, GetStatsResponse.class),

    /**
     * Broadcasts a `CustomEvent` to all WebSocket clients. Receivers are clients which are identified and subscribed.
     */
    BROADCAST_CUSTOM_EVENT("BroadcastCustomEvent", BroadcastCustomEventRequest.class, BroadcastCustomEventResponse.class),

    /**
     * Call a request registered to a vendor.
     *
     * A vendor is a unique name registered by a third-party plugin or script, which allows for custom requests and events to be added to obs-websocket.
     * If a plugin or script implements vendor requests or events, documentation is expected to be provided with them.
     */
    CALL_VENDOR_REQUEST("CallVendorRequest", CallVendorRequestRequest.class, CallVendorRequestResponse.class),

    /**
     * Gets an array of all hotkey names in OBS.
     *
     * Note: Hotkey functionality in obs-websocket comes as-is, and we do not guarantee support if things are broken. In 9/10 usages of hotkey requests, there exists a better, more reliable method via other requests.
     */
    GET_HOTKEY_LIST("GetHotkeyList", GetHotkeyListRequest.class, GetHotkeyListResponse.class),

    /**
     * Triggers a hotkey using its name. See `GetHotkeyList`.
     *
     * Note: Hotkey functionality in obs-websocket comes as-is, and we do not guarantee support if things are broken. In 9/10 usages of hotkey requests, there exists a better, more reliable method via other requests.
     */
    TRIGGER_HOTKEY_BY_NAME("TriggerHotkeyByName", TriggerHotkeyByNameRequest.class, TriggerHotkeyByNameResponse.class),

    /**
     * Triggers a hotkey using a sequence of keys.
     *
     * Note: Hotkey functionality in obs-websocket comes as-is, and we do not guarantee support if things are broken. In 9/10 usages of hotkey requests, there exists a better, more reliable method via other requests.
     */
    TRIGGER_HOTKEY_BY_KEY_SEQUENCE("TriggerHotkeyByKeySequence", TriggerHotkeyByKeySequenceRequest.class, TriggerHotkeyByKeySequenceResponse.class),

    /**
     * Sleeps for a time duration or number of frames. Only available in request batches with types `SERIAL_REALTIME` or `SERIAL_FRAME`.
     */
    SLEEP("Sleep", SleepRequest.class, SleepResponse.class),

    /**
     * Gets an array of all inputs in OBS.
     */
    GET_INPUT_LIST("GetInputList", GetInputListRequest.class, GetInputListResponse.class),

    /**
     * Gets an array of all available input kinds in OBS.
     */
    GET_INPUT_KIND_LIST("GetInputKindList", GetInputKindListRequest.class, GetInputKindListResponse.class),

    /**
     * Gets the names of all special inputs.
     */
    GET_SPECIAL_INPUTS("GetSpecialInputs", GetSpecialInputsRequest.class, GetSpecialInputsResponse.class),

    /**
     * Creates a new input, adding it as a scene item to the specified scene.
     */
    CREATE_INPUT("CreateInput", CreateInputRequest.class, CreateInputResponse.class),

    /**
     * Removes an existing input.
     *
     * Note: Will immediately remove all associated scene items.
     */
    REMOVE_INPUT("RemoveInput", RemoveInputRequest.class, RemoveInputResponse.class),

    /**
     * Sets the name of an input (rename).
     */
    SET_INPUT_NAME("SetInputName", SetInputNameRequest.class, SetInputNameResponse.class),

    /**
     * Gets the default settings for an input kind.
     */
    GET_INPUT_DEFAULT_SETTINGS("GetInputDefaultSettings", GetInputDefaultSettingsRequest.class, GetInputDefaultSettingsResponse.class),

    /**
     * Gets the settings of an input.
     *
     * Note: Does not include defaults. To create the entire settings object, overlay `inputSettings` over the `defaultInputSettings` provided by `GetInputDefaultSettings`.
     */
    GET_INPUT_SETTINGS("GetInputSettings", GetInputSettingsRequest.class, GetInputSettingsResponse.class),

    /**
     * Sets the settings of an input.
     */
    SET_INPUT_SETTINGS("SetInputSettings", SetInputSettingsRequest.class, SetInputSettingsResponse.class),

    /**
     * Gets the audio mute state of an input.
     */
    GET_INPUT_MUTE("GetInputMute", GetInputMuteRequest.class, GetInputMuteResponse.class),

    /**
     * Sets the audio mute state of an input.
     */
    SET_INPUT_MUTE("SetInputMute", SetInputMuteRequest.class, SetInputMuteResponse.class),

    /**
     * Toggles the audio mute state of an input.
     */
    TOGGLE_INPUT_MUTE("ToggleInputMute", ToggleInputMuteRequest.class, ToggleInputMuteResponse.class),

    /**
     * Gets the current volume setting of an input.
     */
    GET_INPUT_VOLUME("GetInputVolume", GetInputVolumeRequest.class, GetInputVolumeResponse.class),

    /**
     * Sets the volume setting of an input.
     */
    SET_INPUT_VOLUME("SetInputVolume", SetInputVolumeRequest.class, SetInputVolumeResponse.class),

    /**
     * Gets the audio balance of an input.
     */
    GET_INPUT_AUDIO_BALANCE("GetInputAudioBalance", GetInputAudioBalanceRequest.class, GetInputAudioBalanceResponse.class),

    /**
     * Sets the audio balance of an input.
     */
    SET_INPUT_AUDIO_BALANCE("SetInputAudioBalance", SetInputAudioBalanceRequest.class, SetInputAudioBalanceResponse.class),

    /**
     * Gets the audio sync offset of an input.
     *
     * Note: The audio sync offset can be negative too!
     */
    GET_INPUT_AUDIO_SYNC_OFFSET("GetInputAudioSyncOffset", GetInputAudioSyncOffsetRequest.class, GetInputAudioSyncOffsetResponse.class),

    /**
     * Sets the audio sync offset of an input.
     */
    SET_INPUT_AUDIO_SYNC_OFFSET("SetInputAudioSyncOffset", SetInputAudioSyncOffsetRequest.class, SetInputAudioSyncOffsetResponse.class),

    /**
     * Gets the audio monitor type of an input.
     *
     * The available audio monitor types are:
     *
     * - `OBS_MONITORING_TYPE_NONE`
     * - `OBS_MONITORING_TYPE_MONITOR_ONLY`
     * - `OBS_MONITORING_TYPE_MONITOR_AND_OUTPUT`
     */
    GET_INPUT_AUDIO_MONITOR_TYPE("GetInputAudioMonitorType", GetInputAudioMonitorTypeRequest.class, GetInputAudioMonitorTypeResponse.class),

    /**
     * Sets the audio monitor type of an input.
     */
    SET_INPUT_AUDIO_MONITOR_TYPE("SetInputAudioMonitorType", SetInputAudioMonitorTypeRequest.class, SetInputAudioMonitorTypeResponse.class),

    /**
     * Gets the enable state of all audio tracks of an input.
     */
    GET_INPUT_AUDIO_TRACKS("GetInputAudioTracks", GetInputAudioTracksRequest.class, GetInputAudioTracksResponse.class),

    /**
     * Sets the enable state of audio tracks of an input.
     */
    SET_INPUT_AUDIO_TRACKS("SetInputAudioTracks", SetInputAudioTracksRequest.class, SetInputAudioTracksResponse.class),

    /**
     * Gets the deinterlace mode of an input.
     *
     * Deinterlace Modes:
     *
     * - `OBS_DEINTERLACE_MODE_DISABLE`
     * - `OBS_DEINTERLACE_MODE_DISCARD`
     * - `OBS_DEINTERLACE_MODE_RETRO`
     * - `OBS_DEINTERLACE_MODE_BLEND`
     * - `OBS_DEINTERLACE_MODE_BLEND_2X`
     * - `OBS_DEINTERLACE_MODE_LINEAR`
     * - `OBS_DEINTERLACE_MODE_LINEAR_2X`
     * - `OBS_DEINTERLACE_MODE_YADIF`
     * - `OBS_DEINTERLACE_MODE_YADIF_2X`
     *
     * Note: Deinterlacing functionality is restricted to async inputs only.
     */
    GET_INPUT_DEINTERLACE_MODE("GetInputDeinterlaceMode", GetInputDeinterlaceModeRequest.class, GetInputDeinterlaceModeResponse.class),

    /**
     * Sets the deinterlace mode of an input.
     *
     * Note: Deinterlacing functionality is restricted to async inputs only.
     */
    SET_INPUT_DEINTERLACE_MODE("SetInputDeinterlaceMode", SetInputDeinterlaceModeRequest.class, SetInputDeinterlaceModeResponse.class),

    /**
     * Gets the deinterlace field order of an input.
     *
     * Deinterlace Field Orders:
     *
     * - `OBS_DEINTERLACE_FIELD_ORDER_TOP`
     * - `OBS_DEINTERLACE_FIELD_ORDER_BOTTOM`
     *
     * Note: Deinterlacing functionality is restricted to async inputs only.
     */
    GET_INPUT_DEINTERLACE_FIELD_ORDER("GetInputDeinterlaceFieldOrder", GetInputDeinterlaceFieldOrderRequest.class, GetInputDeinterlaceFieldOrderResponse.class),

    /**
     * Sets the deinterlace field order of an input.
     *
     * Note: Deinterlacing functionality is restricted to async inputs only.
     */
    SET_INPUT_DEINTERLACE_FIELD_ORDER("SetInputDeinterlaceFieldOrder", SetInputDeinterlaceFieldOrderRequest.class, SetInputDeinterlaceFieldOrderResponse.class),

    /**
     * Gets the items of a list property from an input's properties.
     *
     * Note: Use this in cases where an input provides a dynamic, selectable list of items. For example, display capture, where it provides a list of available displays.
     */
    GET_INPUT_PROPERTIES_LIST_PROPERTY_ITEMS("GetInputPropertiesListPropertyItems", GetInputPropertiesListPropertyItemsRequest.class, GetInputPropertiesListPropertyItemsResponse.class),

    /**
     * Presses a button in the properties of an input.
     *
     * Some known `propertyName` values are:
     *
     * - `refreshnocache` - Browser source reload button
     *
     * Note: Use this in cases where there is a button in the properties of an input that cannot be accessed in any other way. For example, browser sources, where there is a refresh button.
     */
    PRESS_INPUT_PROPERTIES_BUTTON("PressInputPropertiesButton", PressInputPropertiesButtonRequest.class, PressInputPropertiesButtonResponse.class),

    /**
     * Gets the status of a media input.
     *
     * Media States:
     *
     * - `OBS_MEDIA_STATE_NONE`
     * - `OBS_MEDIA_STATE_PLAYING`
     * - `OBS_MEDIA_STATE_OPENING`
     * - `OBS_MEDIA_STATE_BUFFERING`
     * - `OBS_MEDIA_STATE_PAUSED`
     * - `OBS_MEDIA_STATE_STOPPED`
     * - `OBS_MEDIA_STATE_ENDED`
     * - `OBS_MEDIA_STATE_ERROR`
     */
    GET_MEDIA_INPUT_STATUS("GetMediaInputStatus", GetMediaInputStatusRequest.class, GetMediaInputStatusResponse.class),

    /**
     * Sets the cursor position of a media input.
     *
     * This request does not perform bounds checking of the cursor position.
     */
    SET_MEDIA_INPUT_CURSOR("SetMediaInputCursor", SetMediaInputCursorRequest.class, SetMediaInputCursorResponse.class),

    /**
     * Offsets the current cursor position of a media input by the specified value.
     *
     * This request does not perform bounds checking of the cursor position.
     */
    OFFSET_MEDIA_INPUT_CURSOR("OffsetMediaInputCursor", OffsetMediaInputCursorRequest.class, OffsetMediaInputCursorResponse.class),

    /**
     * Triggers an action on a media input.
     */
    TRIGGER_MEDIA_INPUT_ACTION("TriggerMediaInputAction", TriggerMediaInputActionRequest.class, TriggerMediaInputActionResponse.class),

    /**
     * Gets the status of the virtualcam output.
     */
    GET_VIRTUAL_CAM_STATUS("GetVirtualCamStatus", GetVirtualCamStatusRequest.class, GetVirtualCamStatusResponse.class),

    /**
     * Toggles the state of the virtualcam output.
     */
    TOGGLE_VIRTUAL_CAM("ToggleVirtualCam", ToggleVirtualCamRequest.class, ToggleVirtualCamResponse.class),

    /**
     * Starts the virtualcam output.
     */
    START_VIRTUAL_CAM("StartVirtualCam", StartVirtualCamRequest.class, StartVirtualCamResponse.class),

    /**
     * Stops the virtualcam output.
     */
    STOP_VIRTUAL_CAM("StopVirtualCam", StopVirtualCamRequest.class, StopVirtualCamResponse.class),

    /**
     * Gets the status of the replay buffer output.
     */
    GET_REPLAY_BUFFER_STATUS("GetReplayBufferStatus", GetReplayBufferStatusRequest.class, GetReplayBufferStatusResponse.class),

    /**
     * Toggles the state of the replay buffer output.
     */
    TOGGLE_REPLAY_BUFFER("ToggleReplayBuffer", ToggleReplayBufferRequest.class, ToggleReplayBufferResponse.class),

    /**
     * Starts the replay buffer output.
     */
    START_REPLAY_BUFFER("StartReplayBuffer", StartReplayBufferRequest.class, StartReplayBufferResponse.class),

    /**
     * Stops the replay buffer output.
     */
    STOP_REPLAY_BUFFER("StopReplayBuffer", StopReplayBufferRequest.class, StopReplayBufferResponse.class),

    /**
     * Saves the contents of the replay buffer output.
     */
    SAVE_REPLAY_BUFFER("SaveReplayBuffer", SaveReplayBufferRequest.class, SaveReplayBufferResponse.class),

    /**
     * Gets the filename of the last replay buffer save file.
     */
    GET_LAST_REPLAY_BUFFER_REPLAY("GetLastReplayBufferReplay", GetLastReplayBufferReplayRequest.class, GetLastReplayBufferReplayResponse.class),

    /**
     * Gets the list of available outputs.
     */
    GET_OUTPUT_LIST("GetOutputList", GetOutputListRequest.class, GetOutputListResponse.class),

    /**
     * Gets the status of an output.
     */
    GET_OUTPUT_STATUS("GetOutputStatus", GetOutputStatusRequest.class, GetOutputStatusResponse.class),

    /**
     * Toggles the status of an output.
     */
    TOGGLE_OUTPUT("ToggleOutput", ToggleOutputRequest.class, ToggleOutputResponse.class),

    /**
     * Starts an output.
     */
    START_OUTPUT("StartOutput", StartOutputRequest.class, StartOutputResponse.class),

    /**
     * Stops an output.
     */
    STOP_OUTPUT("StopOutput", StopOutputRequest.class, StopOutputResponse.class),

    /**
     * Gets the settings of an output.
     */
    GET_OUTPUT_SETTINGS("GetOutputSettings", GetOutputSettingsRequest.class, GetOutputSettingsResponse.class),

    /**
     * Sets the settings of an output.
     */
    SET_OUTPUT_SETTINGS("SetOutputSettings", SetOutputSettingsRequest.class, SetOutputSettingsResponse.class),

    /**
     * Gets the status of the record output.
     */
    GET_RECORD_STATUS("GetRecordStatus", GetRecordStatusRequest.class, GetRecordStatusResponse.class),

    /**
     * Toggles the status of the record output.
     */
    TOGGLE_RECORD("ToggleRecord", ToggleRecordRequest.class, ToggleRecordResponse.class),

    /**
     * Starts the record output.
     */
    START_RECORD("StartRecord", StartRecordRequest.class, StartRecordResponse.class),

    /**
     * Stops the record output.
     */
    STOP_RECORD("StopRecord", StopRecordRequest.class, StopRecordResponse.class),

    /**
     * Toggles pause on the record output.
     */
    TOGGLE_RECORD_PAUSE("ToggleRecordPause", ToggleRecordPauseRequest.class, ToggleRecordPauseResponse.class),

    /**
     * Pauses the record output.
     */
    PAUSE_RECORD("PauseRecord", PauseRecordRequest.class, PauseRecordResponse.class),

    /**
     * Resumes the record output.
     */
    RESUME_RECORD("ResumeRecord", ResumeRecordRequest.class, ResumeRecordResponse.class),

    /**
     * Splits the current file being recorded into a new file.
     */
    SPLIT_RECORD_FILE("SplitRecordFile", SplitRecordFileRequest.class, SplitRecordFileResponse.class),

    /**
     * Adds a new chapter marker to the file currently being recorded.
     *
     * Note: As of OBS 30.2.0, the only file format supporting this feature is Hybrid MP4.
     */
    CREATE_RECORD_CHAPTER("CreateRecordChapter", CreateRecordChapterRequest.class, CreateRecordChapterResponse.class),

    /**
     * Gets a list of all scene items in a scene.
     *
     * Scenes only
     */
    GET_SCENE_ITEM_LIST("GetSceneItemList", GetSceneItemListRequest.class, GetSceneItemListResponse.class),

    /**
     * Basically GetSceneItemList, but for groups.
     *
     * Using groups at all in OBS is discouraged, as they are very broken under the hood. Please use nested scenes instead.
     *
     * Groups only
     */
    GET_GROUP_SCENE_ITEM_LIST("GetGroupSceneItemList", GetGroupSceneItemListRequest.class, GetGroupSceneItemListResponse.class),

    /**
     * Searches a scene for a source, and returns its id.
     *
     * Scenes and Groups
     */
    GET_SCENE_ITEM_ID("GetSceneItemId", GetSceneItemIdRequest.class, GetSceneItemIdResponse.class),

    /**
     * Gets the source associated with a scene item.
     */
    GET_SCENE_ITEM_SOURCE("GetSceneItemSource", GetSceneItemSourceRequest.class, GetSceneItemSourceResponse.class),

    /**
     * Creates a new scene item using a source.
     *
     * Scenes only
     */
    CREATE_SCENE_ITEM("CreateSceneItem", CreateSceneItemRequest.class, CreateSceneItemResponse.class),

    /**
     * Removes a scene item from a scene.
     *
     * Scenes only
     */
    REMOVE_SCENE_ITEM("RemoveSceneItem", RemoveSceneItemRequest.class, RemoveSceneItemResponse.class),

    /**
     * Duplicates a scene item, copying all transform and crop info.
     *
     * Scenes only
     */
    DUPLICATE_SCENE_ITEM("DuplicateSceneItem", DuplicateSceneItemRequest.class, DuplicateSceneItemResponse.class),

    /**
     * Gets the transform and crop info of a scene item.
     *
     * Scenes and Groups
     */
    GET_SCENE_ITEM_TRANSFORM("GetSceneItemTransform", GetSceneItemTransformRequest.class, GetSceneItemTransformResponse.class),

    /**
     * Sets the transform and crop info of a scene item.
     */
    SET_SCENE_ITEM_TRANSFORM("SetSceneItemTransform", SetSceneItemTransformRequest.class, SetSceneItemTransformResponse.class),

    /**
     * Gets the enable state of a scene item.
     *
     * Scenes and Groups
     */
    GET_SCENE_ITEM_ENABLED("GetSceneItemEnabled", GetSceneItemEnabledRequest.class, GetSceneItemEnabledResponse.class),

    /**
     * Sets the enable state of a scene item.
     *
     * Scenes and Groups
     */
    SET_SCENE_ITEM_ENABLED("SetSceneItemEnabled", SetSceneItemEnabledRequest.class, SetSceneItemEnabledResponse.class),

    /**
     * Gets the lock state of a scene item.
     *
     * Scenes and Groups
     */
    GET_SCENE_ITEM_LOCKED("GetSceneItemLocked", GetSceneItemLockedRequest.class, GetSceneItemLockedResponse.class),

    /**
     * Sets the lock state of a scene item.
     *
     * Scenes and Group
     */
    SET_SCENE_ITEM_LOCKED("SetSceneItemLocked", SetSceneItemLockedRequest.class, SetSceneItemLockedResponse.class),

    /**
     * Gets the index position of a scene item in a scene.
     *
     * An index of 0 is at the bottom of the source list in the UI.
     *
     * Scenes and Groups
     */
    GET_SCENE_ITEM_INDEX("GetSceneItemIndex", GetSceneItemIndexRequest.class, GetSceneItemIndexResponse.class),

    /**
     * Sets the index position of a scene item in a scene.
     *
     * Scenes and Groups
     */
    SET_SCENE_ITEM_INDEX("SetSceneItemIndex", SetSceneItemIndexRequest.class, SetSceneItemIndexResponse.class),

    /**
     * Gets the blend mode of a scene item.
     *
     * Blend modes:
     *
     * - `OBS_BLEND_NORMAL`
     * - `OBS_BLEND_ADDITIVE`
     * - `OBS_BLEND_SUBTRACT`
     * - `OBS_BLEND_SCREEN`
     * - `OBS_BLEND_MULTIPLY`
     * - `OBS_BLEND_LIGHTEN`
     * - `OBS_BLEND_DARKEN`
     *
     * Scenes and Groups
     */
    GET_SCENE_ITEM_BLEND_MODE("GetSceneItemBlendMode", GetSceneItemBlendModeRequest.class, GetSceneItemBlendModeResponse.class),

    /**
     * Sets the blend mode of a scene item.
     *
     * Scenes and Groups
     */
    SET_SCENE_ITEM_BLEND_MODE("SetSceneItemBlendMode", SetSceneItemBlendModeRequest.class, SetSceneItemBlendModeResponse.class),

    /**
     * Gets an array of scenes in OBS.
     */
    GET_SCENE_LIST("GetSceneList", GetSceneListRequest.class, GetSceneListResponse.class),

    /**
     * Gets an array of all groups in OBS.
     *
     * Groups in OBS are actually scenes, but renamed and modified. In obs-websocket, we treat them as scenes where we can.
     */
    GET_GROUP_LIST("GetGroupList", GetGroupListRequest.class, GetGroupListResponse.class),

    /**
     * Gets the current program scene.
     *
     * Note 1: This request is slated to have the `currentProgram`-prefixed fields removed from in an upcoming RPC version.
     *
     * Note 2: Canvases do not have any concept of a program or preview scene, so this request does not support canvases.
     */
    GET_CURRENT_PROGRAM_SCENE("GetCurrentProgramScene", GetCurrentProgramSceneRequest.class, GetCurrentProgramSceneResponse.class),

    /**
     * Sets the current program scene.
     */
    SET_CURRENT_PROGRAM_SCENE("SetCurrentProgramScene", SetCurrentProgramSceneRequest.class, SetCurrentProgramSceneResponse.class),

    /**
     * Gets the current preview scene.
     *
     * Only available when studio mode is enabled.
     *
     * Note: This request is slated to have the `currentPreview`-prefixed fields removed from in an upcoming RPC version.
     */
    GET_CURRENT_PREVIEW_SCENE("GetCurrentPreviewScene", GetCurrentPreviewSceneRequest.class, GetCurrentPreviewSceneResponse.class),

    /**
     * Sets the current preview scene.
     *
     * Only available when studio mode is enabled.
     */
    SET_CURRENT_PREVIEW_SCENE("SetCurrentPreviewScene", SetCurrentPreviewSceneRequest.class, SetCurrentPreviewSceneResponse.class),

    /**
     * Creates a new scene in OBS.
     */
    CREATE_SCENE("CreateScene", CreateSceneRequest.class, CreateSceneResponse.class),

    /**
     * Removes a scene from OBS.
     */
    REMOVE_SCENE("RemoveScene", RemoveSceneRequest.class, RemoveSceneResponse.class),

    /**
     * Sets the name of a scene (rename).
     */
    SET_SCENE_NAME("SetSceneName", SetSceneNameRequest.class, SetSceneNameResponse.class),

    /**
     * Gets the scene transition overridden for a scene.
     *
     * Note: A transition UUID response field is not currently able to be implemented as of 2024-1-18.
     */
    GET_SCENE_SCENE_TRANSITION_OVERRIDE("GetSceneSceneTransitionOverride", GetSceneSceneTransitionOverrideRequest.class, GetSceneSceneTransitionOverrideResponse.class),

    /**
     * Sets the scene transition overridden for a scene.
     */
    SET_SCENE_SCENE_TRANSITION_OVERRIDE("SetSceneSceneTransitionOverride", SetSceneSceneTransitionOverrideRequest.class, SetSceneSceneTransitionOverrideResponse.class),

    /**
     * Gets the active and show state of a source.
     *
     * **Compatible with inputs and scenes.**
     */
    GET_SOURCE_ACTIVE("GetSourceActive", GetSourceActiveRequest.class, GetSourceActiveResponse.class),

    /**
     * Gets a Base64-encoded screenshot of a source.
     *
     * The `imageWidth` and `imageHeight` parameters are treated as "scale to inner", meaning the smallest ratio will be used and the aspect ratio of the original resolution is kept.
     * If `imageWidth` and `imageHeight` are not specified, the compressed image will use the full resolution of the source.
     *
     * **Compatible with inputs and scenes.**
     */
    GET_SOURCE_SCREENSHOT("GetSourceScreenshot", GetSourceScreenshotRequest.class, GetSourceScreenshotResponse.class),

    /**
     * Saves a screenshot of a source to the filesystem.
     *
     * The `imageWidth` and `imageHeight` parameters are treated as "scale to inner", meaning the smallest ratio will be used and the aspect ratio of the original resolution is kept.
     * If `imageWidth` and `imageHeight` are not specified, the compressed image will use the full resolution of the source.
     *
     * **Compatible with inputs and scenes.**
     */
    SAVE_SOURCE_SCREENSHOT("SaveSourceScreenshot", SaveSourceScreenshotRequest.class, SaveSourceScreenshotResponse.class),

    /**
     * Gets the status of the stream output.
     */
    GET_STREAM_STATUS("GetStreamStatus", GetStreamStatusRequest.class, GetStreamStatusResponse.class),

    /**
     * Toggles the status of the stream output.
     */
    TOGGLE_STREAM("ToggleStream", ToggleStreamRequest.class, ToggleStreamResponse.class),

    /**
     * Starts the stream output.
     */
    START_STREAM("StartStream", StartStreamRequest.class, StartStreamResponse.class),

    /**
     * Stops the stream output.
     */
    STOP_STREAM("StopStream", StopStreamRequest.class, StopStreamResponse.class),

    /**
     * Sends CEA-608 caption text over the stream output.
     */
    SEND_STREAM_CAPTION("SendStreamCaption", SendStreamCaptionRequest.class, SendStreamCaptionResponse.class),

    /**
     * Gets an array of all available transition kinds.
     *
     * Similar to `GetInputKindList`
     */
    GET_TRANSITION_KIND_LIST("GetTransitionKindList", GetTransitionKindListRequest.class, GetTransitionKindListResponse.class),

    /**
     * Gets an array of all scene transitions in OBS.
     */
    GET_SCENE_TRANSITION_LIST("GetSceneTransitionList", GetSceneTransitionListRequest.class, GetSceneTransitionListResponse.class),

    /**
     * Gets information about the current scene transition.
     */
    GET_CURRENT_SCENE_TRANSITION("GetCurrentSceneTransition", GetCurrentSceneTransitionRequest.class, GetCurrentSceneTransitionResponse.class),

    /**
     * Sets the current scene transition.
     *
     * Small note: While the namespace of scene transitions is generally unique, that uniqueness is not a guarantee as it is with other resources like inputs.
     */
    SET_CURRENT_SCENE_TRANSITION("SetCurrentSceneTransition", SetCurrentSceneTransitionRequest.class, SetCurrentSceneTransitionResponse.class),

    /**
     * Sets the duration of the current scene transition, if it is not fixed.
     */
    SET_CURRENT_SCENE_TRANSITION_DURATION("SetCurrentSceneTransitionDuration", SetCurrentSceneTransitionDurationRequest.class, SetCurrentSceneTransitionDurationResponse.class),

    /**
     * Sets the settings of the current scene transition.
     */
    SET_CURRENT_SCENE_TRANSITION_SETTINGS("SetCurrentSceneTransitionSettings", SetCurrentSceneTransitionSettingsRequest.class, SetCurrentSceneTransitionSettingsResponse.class),

    /**
     * Gets the cursor position of the current scene transition.
     *
     * Note: `transitionCursor` will return 1.0 when the transition is inactive.
     */
    GET_CURRENT_SCENE_TRANSITION_CURSOR("GetCurrentSceneTransitionCursor", GetCurrentSceneTransitionCursorRequest.class, GetCurrentSceneTransitionCursorResponse.class),

    /**
     * Triggers the current scene transition. Same functionality as the `Transition` button in studio mode.
     */
    TRIGGER_STUDIO_MODE_TRANSITION("TriggerStudioModeTransition", TriggerStudioModeTransitionRequest.class, TriggerStudioModeTransitionResponse.class),

    /**
     * Sets the position of the TBar.
     *
     * **Very important note**: This will be deprecated and replaced in a future version of obs-websocket.
     */
    SET_T_BAR_POSITION("SetTBarPosition", SetTBarPositionRequest.class, SetTBarPositionResponse.class),

    /**
     * Gets whether studio is enabled.
     */
    GET_STUDIO_MODE_ENABLED("GetStudioModeEnabled", GetStudioModeEnabledRequest.class, GetStudioModeEnabledResponse.class),

    /**
     * Enables or disables studio mode
     */
    SET_STUDIO_MODE_ENABLED("SetStudioModeEnabled", SetStudioModeEnabledRequest.class, SetStudioModeEnabledResponse.class),

    /**
     * Opens the properties dialog of an input.
     */
    OPEN_INPUT_PROPERTIES_DIALOG("OpenInputPropertiesDialog", OpenInputPropertiesDialogRequest.class, OpenInputPropertiesDialogResponse.class),

    /**
     * Opens the filters dialog of an input.
     */
    OPEN_INPUT_FILTERS_DIALOG("OpenInputFiltersDialog", OpenInputFiltersDialogRequest.class, OpenInputFiltersDialogResponse.class),

    /**
     * Opens the interact dialog of an input.
     */
    OPEN_INPUT_INTERACT_DIALOG("OpenInputInteractDialog", OpenInputInteractDialogRequest.class, OpenInputInteractDialogResponse.class),

    /**
     * Gets a list of connected monitors and information about them.
     */
    GET_MONITOR_LIST("GetMonitorList", GetMonitorListRequest.class, GetMonitorListResponse.class),

    /**
     * Opens a projector for a specific output video mix.
     *
     * Mix types:
     *
     * - `OBS_WEBSOCKET_VIDEO_MIX_TYPE_PREVIEW`
     * - `OBS_WEBSOCKET_VIDEO_MIX_TYPE_PROGRAM`
     * - `OBS_WEBSOCKET_VIDEO_MIX_TYPE_MULTIVIEW`
     *
     * Note: This request serves to provide feature parity with 4.x. It is very likely to be changed/deprecated in a future release.
     */
    OPEN_VIDEO_MIX_PROJECTOR("OpenVideoMixProjector", OpenVideoMixProjectorRequest.class, OpenVideoMixProjectorResponse.class),

    /**
     * Opens a projector for a source.
     *
     * Note: This request serves to provide feature parity with 4.x. It is very likely to be changed/deprecated in a future release.
     */
    OPEN_SOURCE_PROJECTOR("OpenSourceProjector", OpenSourceProjectorRequest.class, OpenSourceProjectorResponse.class);

    private final String requestType;

    private final Class<? extends Request> requestClass;

    private final Class<? extends RequestResponse> responseClass;

    public static RequestType find(String requestType) {
        for (RequestType value : RequestType.values()) {
            if (StringUtils.equalsIgnoreCase(requestType, value.getRequestType())) {
                return value;
            }
        }
        return null;
    }
}
