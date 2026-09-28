package com.brentvatne.exoplayer;

import android.content.Context;
import android.view.View;
import com.brentvatne.common.api.BufferingStrategy;
import com.brentvatne.common.api.ControlsConfig;
import com.brentvatne.common.api.Source;
import com.brentvatne.common.api.SubtitleStyle;
import com.brentvatne.common.react.EventTypes;
import com.brentvatne.common.toolbox.DebugLog;
import com.brentvatne.common.toolbox.ReactBridgeUtils;
import com.brentvatne.exoplayer.AudioOutput;
import com.brentvatne.react.ReactNativeVideoManager;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.zeptoconsumerapp.BuildConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.MissingResourceException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes.dex */
public final class ReactExoplayerViewManager extends ViewGroupManager<ReactExoplayerView> {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final String PROP_AUDIO_OUTPUT = "audioOutput";

    @NotNull
    private static final String PROP_BUFFERING_STRATEGY = "bufferingStrategy";

    @NotNull
    private static final String PROP_CONTROLS = "controls";

    @NotNull
    private static final String PROP_CONTROLS_STYLES = "controlsStyles";

    @NotNull
    private static final String PROP_DEBUG = "debug";

    @NotNull
    private static final String PROP_DISABLE_DISCONNECT_ERROR = "disableDisconnectError";

    @NotNull
    private static final String PROP_DISABLE_FOCUS = "disableFocus";

    @NotNull
    private static final String PROP_ENTER_PICTURE_IN_PICTURE_ON_LEAVE = "enterPictureInPictureOnLeave";

    @NotNull
    private static final String PROP_FOCUSABLE = "focusable";

    @NotNull
    private static final String PROP_FULLSCREEN = "fullscreen";

    @NotNull
    private static final String PROP_HIDE_SHUTTER_VIEW = "hideShutterView";

    @NotNull
    private static final String PROP_MAXIMUM_BIT_RATE = "maxBitRate";

    @NotNull
    private static final String PROP_MUTED = "muted";

    @NotNull
    private static final String PROP_PAUSED = "paused";

    @NotNull
    private static final String PROP_PLAY_IN_BACKGROUND = "playInBackground";

    @NotNull
    private static final String PROP_PREVENTS_DISPLAY_SLEEP_DURING_VIDEO_PLAYBACK = "preventsDisplaySleepDuringVideoPlayback";

    @NotNull
    private static final String PROP_PROGRESS_UPDATE_INTERVAL = "progressUpdateInterval";

    @NotNull
    private static final String PROP_RATE = "rate";

    @NotNull
    private static final String PROP_REPEAT = "repeat";

    @NotNull
    private static final String PROP_REPORT_BANDWIDTH = "reportBandwidth";

    @NotNull
    private static final String PROP_RESIZE_MODE = "resizeMode";

    @NotNull
    private static final String PROP_SELECTED_AUDIO_TRACK = "selectedAudioTrack";

    @NotNull
    private static final String PROP_SELECTED_AUDIO_TRACK_TYPE = "type";

    @NotNull
    private static final String PROP_SELECTED_AUDIO_TRACK_VALUE = "value";

    @NotNull
    private static final String PROP_SELECTED_TEXT_TRACK = "selectedTextTrack";

    @NotNull
    private static final String PROP_SELECTED_TEXT_TRACK_TYPE = "type";

    @NotNull
    private static final String PROP_SELECTED_TEXT_TRACK_VALUE = "value";

    @NotNull
    private static final String PROP_SELECTED_VIDEO_TRACK = "selectedVideoTrack";

    @NotNull
    private static final String PROP_SELECTED_VIDEO_TRACK_TYPE = "type";

    @NotNull
    private static final String PROP_SELECTED_VIDEO_TRACK_VALUE = "value";

    @NotNull
    private static final String PROP_SHOW_NOTIFICATION_CONTROLS = "showNotificationControls";

    @NotNull
    private static final String PROP_SHUTTER_COLOR = "shutterColor";

    @NotNull
    private static final String PROP_SRC = "src";

    @NotNull
    private static final String PROP_SUBTITLE_STYLE = "subtitleStyle";

    @NotNull
    private static final String PROP_VIEW_TYPE = "viewType";

    @NotNull
    private static final String PROP_VOLUME = "volume";

    @NotNull
    private static final String REACT_CLASS = "RCTVideo";

    @NotNull
    private static final String TAG = "ExoViewManager";

    @NotNull
    private final ReactExoplayerConfig config;

    @Metadata
    public static final class Companion {
    }

    public ReactExoplayerViewManager(@NotNull ReactExoplayerConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        EventTypes.f15429b.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (EventTypes eventTypes : ArraysKt.F(EventTypes.values())) {
            linkedHashMap.put(android.support.v4.media.b.C("top", StringsKt.F(eventTypes.f15441a, "on")), MapsKt.e(new Pair("registrationName", eventTypes.f15441a)));
        }
        return linkedHashMap;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(name = PROP_AUDIO_OUTPUT)
    public final void setAudioOutput(@NotNull ReactExoplayerView videoView, @NotNull String audioOutput) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        Intrinsics.checkNotNullParameter(audioOutput, "audioOutput");
        AudioOutput.f15513c.getClass();
        videoView.setAudioOutput(AudioOutput.Companion.a(audioOutput));
    }

    @ReactProp(name = PROP_BUFFERING_STRATEGY)
    public final void setBufferingStrategy(@NotNull ReactExoplayerView videoView, @NotNull String bufferingStrategy) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        Intrinsics.checkNotNullParameter(bufferingStrategy, "bufferingStrategy");
        videoView.setBufferingStrategy(BufferingStrategy.Companion.a(bufferingStrategy));
    }

    @ReactProp(defaultBoolean = false, name = "controls")
    public final void setControls(@NotNull ReactExoplayerView videoView, boolean z) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setControls(z);
    }

    @ReactProp(name = PROP_CONTROLS_STYLES)
    public final void setControlsStyles(@NotNull ReactExoplayerView videoView, @Nullable ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setControlsStyles(ControlsConfig.Companion.a(readableMap));
    }

    @ReactProp(defaultBoolean = false, name = "debug")
    public final void setDebug(@NotNull ReactExoplayerView videoView, @Nullable ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        boolean zB = ReactBridgeUtils.b(readableMap, "enable", false);
        boolean zB2 = ReactBridgeUtils.b(readableMap, "thread", false);
        if (zB) {
            DebugLog.d(2, zB2);
        } else {
            DebugLog.d(5, zB2);
        }
        videoView.setDebug(zB);
    }

    @ReactProp(defaultBoolean = false, name = PROP_DISABLE_DISCONNECT_ERROR)
    public final void setDisableDisconnectError(@NotNull ReactExoplayerView videoView, boolean z) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setDisableDisconnectError(z);
    }

    @ReactProp(defaultBoolean = false, name = PROP_DISABLE_FOCUS)
    public final void setDisableFocus(@NotNull ReactExoplayerView videoView, boolean z) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setDisableFocus(z);
    }

    @ReactProp(defaultBoolean = false, name = PROP_ENTER_PICTURE_IN_PICTURE_ON_LEAVE)
    public final void setEnterPictureInPictureOnLeave(@NotNull ReactExoplayerView videoView, boolean z) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setEnterPictureInPictureOnLeave(z);
    }

    @ReactProp(defaultBoolean = BuildConfig.IS_HERMES_ENABLED, name = PROP_FOCUSABLE)
    public final void setFocusable(@NotNull ReactExoplayerView videoView, boolean z) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setFocusable(z);
    }

    @ReactProp(defaultBoolean = false, name = PROP_FULLSCREEN)
    public final void setFullscreen(@NotNull ReactExoplayerView videoView, boolean z) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setFullscreen(z);
    }

    @ReactProp(defaultBoolean = false, name = PROP_HIDE_SHUTTER_VIEW)
    public final void setHideShutterView(@NotNull ReactExoplayerView videoView, boolean z) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setHideShutterView(z);
    }

    @ReactProp(name = PROP_MAXIMUM_BIT_RATE)
    public final void setMaxBitRate(@NotNull ReactExoplayerView videoView, float f2) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setMaxBitRateModifier((int) f2);
    }

    @ReactProp(defaultBoolean = false, name = PROP_MUTED)
    public final void setMuted(@NotNull ReactExoplayerView videoView, boolean z) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setMutedModifier(z);
    }

    @ReactProp(defaultBoolean = false, name = PROP_PAUSED)
    public final void setPaused(@NotNull ReactExoplayerView videoView, boolean z) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setPausedModifier(z);
    }

    @ReactProp(defaultBoolean = false, name = PROP_PLAY_IN_BACKGROUND)
    public final void setPlayInBackground(@NotNull ReactExoplayerView videoView, boolean z) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setPlayInBackground(z);
    }

    @ReactProp(defaultBoolean = false, name = PROP_PREVENTS_DISPLAY_SLEEP_DURING_VIDEO_PLAYBACK)
    public final void setPreventsDisplaySleepDuringVideoPlayback(@NotNull ReactExoplayerView videoView, boolean z) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setPreventsDisplaySleepDuringVideoPlayback(z);
    }

    @ReactProp(defaultFloat = 250.0f, name = PROP_PROGRESS_UPDATE_INTERVAL)
    public final void setProgressUpdateInterval(@NotNull ReactExoplayerView videoView, float f2) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setProgressUpdateInterval(f2);
    }

    @ReactProp(name = PROP_RATE)
    public final void setRate(@NotNull ReactExoplayerView videoView, float f2) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setRateModifier(f2);
    }

    @ReactProp(defaultBoolean = false, name = PROP_REPEAT)
    public final void setRepeat(@NotNull ReactExoplayerView videoView, boolean z) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setRepeatModifier(z);
    }

    @ReactProp(defaultBoolean = false, name = PROP_REPORT_BANDWIDTH)
    public final void setReportBandwidth(@NotNull ReactExoplayerView videoView, boolean z) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setReportBandwidth(z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
    
        if (r5.equals("none") != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        r4.setResizeModeModifier(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:
    
        if (r5.equals("contain") == false) goto L19;
     */
    @com.facebook.react.uimanager.annotations.ReactProp(name = com.brentvatne.exoplayer.ReactExoplayerViewManager.PROP_RESIZE_MODE)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setResizeMode(@org.jetbrains.annotations.NotNull com.brentvatne.exoplayer.ReactExoplayerView r4, @org.jetbrains.annotations.NotNull java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = "videoView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "resizeMode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            int r0 = r5.hashCode()
            r1 = 0
            switch(r0) {
                case -1881872635: goto L36;
                case 3387192: goto L2a;
                case 94852023: goto L1c;
                case 951526612: goto L13;
                default: goto L12;
            }
        L12:
            goto L3e
        L13:
            java.lang.String r0 = "contain"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L32
            goto L3e
        L1c:
            java.lang.String r0 = "cover"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L25
            goto L3e
        L25:
            r5 = 4
            r4.setResizeModeModifier(r5)
            return
        L2a:
            java.lang.String r0 = "none"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L3e
        L32:
            r4.setResizeModeModifier(r1)
            return
        L36:
            java.lang.String r0 = "stretch"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L5a
        L3e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Unsupported resize mode: "
            r0.<init>(r2)
            r0.append(r5)
            java.lang.String r5 = " - falling back to fit"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "ExoViewManager"
            com.brentvatne.common.toolbox.DebugLog.e(r0, r5)
            r4.setResizeModeModifier(r1)
            return
        L5a:
            r5 = 3
            r4.setResizeModeModifier(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.brentvatne.exoplayer.ReactExoplayerViewManager.setResizeMode(com.brentvatne.exoplayer.ReactExoplayerView, java.lang.String):void");
    }

    @ReactProp(name = PROP_SELECTED_AUDIO_TRACK)
    public final void setSelectedAudioTrack(@NotNull ReactExoplayerView videoView, @Nullable ReadableMap readableMap) throws MissingResourceException {
        String strG;
        String strG2;
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        if (readableMap != null) {
            strG = ReactBridgeUtils.g(readableMap, "type");
            strG2 = ReactBridgeUtils.g(readableMap, CLConstants.FIELD_PAY_INFO_VALUE);
        } else {
            strG = null;
            strG2 = null;
        }
        videoView.G0 = strG;
        videoView.H0 = strG2;
        videoView.f0(1, strG, strG2);
    }

    @ReactProp(name = PROP_SELECTED_TEXT_TRACK)
    public final void setSelectedTextTrack(@NotNull ReactExoplayerView videoView, @Nullable ReadableMap readableMap) throws MissingResourceException {
        String strG;
        String strG2;
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        if (readableMap != null) {
            strG = ReactBridgeUtils.g(readableMap, "type");
            strG2 = ReactBridgeUtils.g(readableMap, CLConstants.FIELD_PAY_INFO_VALUE);
        } else {
            strG = null;
            strG2 = null;
        }
        videoView.K0 = strG;
        videoView.L0 = strG2;
        videoView.f0(3, strG, strG2);
    }

    @ReactProp(name = PROP_SELECTED_VIDEO_TRACK)
    public final void setSelectedVideoTrack(@NotNull ReactExoplayerView videoView, @Nullable ReadableMap readableMap) throws MissingResourceException {
        String strG;
        String strG2;
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        if (readableMap != null) {
            strG = ReactBridgeUtils.g(readableMap, "type");
            strG2 = ReactBridgeUtils.g(readableMap, CLConstants.FIELD_PAY_INFO_VALUE);
        } else {
            strG = null;
            strG2 = null;
        }
        videoView.I0 = strG;
        videoView.J0 = strG2;
        if (videoView.t) {
            return;
        }
        videoView.f0(2, strG, strG2);
    }

    @ReactProp(name = PROP_SHOW_NOTIFICATION_CONTROLS)
    public final void setShowNotificationControls(@NotNull ReactExoplayerView videoView, boolean z) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setShowNotificationControls(z);
    }

    @ReactProp(defaultInt = -16777216, name = PROP_SHUTTER_COLOR)
    public final void setShutterColor(@NotNull ReactExoplayerView videoView, int i2) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setShutterColor(Integer.valueOf(i2));
    }

    @ReactProp(name = PROP_SRC)
    public final void setSrc(@NotNull ReactExoplayerView videoView, @Nullable ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        Context applicationContext = videoView.getContext().getApplicationContext();
        Intrinsics.c(applicationContext);
        videoView.setSrc(Source.Companion.a(applicationContext, readableMap));
    }

    @ReactProp(name = PROP_SUBTITLE_STYLE)
    public final void setSubtitleStyle(@NotNull ReactExoplayerView videoView, @Nullable ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setSubtitleStyle(SubtitleStyle.Companion.a(readableMap));
    }

    @ReactProp(defaultInt = 1, name = PROP_VIEW_TYPE)
    public final void setViewType(@NotNull ReactExoplayerView videoView, int i2) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setViewType(i2);
    }

    @ReactProp(defaultFloat = 1.0f, name = PROP_VOLUME)
    public final void setVolume(@NotNull ReactExoplayerView videoView, float f2) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        videoView.setVolumeModifier(f2);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(@NotNull ThemedReactContext reactContext, @NotNull ReactExoplayerView view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        super.addEventEmitters(reactContext, (ThemedReactContext) view);
        view.f15560a.a(reactContext, view);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ReactExoplayerView createViewInstance(@NotNull ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "themedReactContext");
        ReactNativeVideoManager.f15630c.a().g(this);
        return new ReactExoplayerView(themedReactContext, this.config);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(@NotNull ReactExoplayerView view) throws JSONException, IllegalAccessException, InstantiationException {
        Intrinsics.checkNotNullParameter(view, "view");
        view.X0.abandonAudioFocus(view.a1);
        view.e0();
        view.W0.removeLifecycleEventListener(view);
        view.e0();
        view.e1 = true;
        view.J();
        ReactNativeVideoManager.f15630c.a().h(this);
    }
}
