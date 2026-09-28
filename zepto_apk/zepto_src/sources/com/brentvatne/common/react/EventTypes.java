package com.brentvatne.common.react;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class EventTypes {
    public static final EventTypes A;
    public static final EventTypes B;
    public static final EventTypes C;
    public static final /* synthetic */ EventTypes[] D;
    public static final /* synthetic */ EnumEntries E;

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f15429b;

    /* renamed from: c, reason: collision with root package name */
    public static final EventTypes f15430c;

    /* renamed from: d, reason: collision with root package name */
    public static final EventTypes f15431d;

    /* renamed from: e, reason: collision with root package name */
    public static final EventTypes f15432e;

    /* renamed from: f, reason: collision with root package name */
    public static final EventTypes f15433f;

    /* renamed from: g, reason: collision with root package name */
    public static final EventTypes f15434g;

    /* renamed from: h, reason: collision with root package name */
    public static final EventTypes f15435h;

    /* renamed from: i, reason: collision with root package name */
    public static final EventTypes f15436i;

    /* renamed from: j, reason: collision with root package name */
    public static final EventTypes f15437j;

    /* renamed from: k, reason: collision with root package name */
    public static final EventTypes f15438k;

    /* renamed from: l, reason: collision with root package name */
    public static final EventTypes f15439l;

    /* renamed from: m, reason: collision with root package name */
    public static final EventTypes f15440m;
    public static final EventTypes n;
    public static final EventTypes o;
    public static final EventTypes p;
    public static final EventTypes q;
    public static final EventTypes r;
    public static final EventTypes s;
    public static final EventTypes t;
    public static final EventTypes u;
    public static final EventTypes v;
    public static final EventTypes w;
    public static final EventTypes x;
    public static final EventTypes y;
    public static final EventTypes z;

    /* renamed from: a, reason: collision with root package name */
    public final String f15441a;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
    }

    static {
        EventTypes eventTypes = new EventTypes("EVENT_LOAD_START", 0, "onVideoLoadStart");
        f15430c = eventTypes;
        EventTypes eventTypes2 = new EventTypes("EVENT_LOAD", 1, "onVideoLoad");
        f15431d = eventTypes2;
        EventTypes eventTypes3 = new EventTypes("EVENT_ERROR", 2, "onVideoError");
        f15432e = eventTypes3;
        EventTypes eventTypes4 = new EventTypes("EVENT_PROGRESS", 3, "onVideoProgress");
        f15433f = eventTypes4;
        EventTypes eventTypes5 = new EventTypes("EVENT_BANDWIDTH", 4, "onVideoBandwidthUpdate");
        f15434g = eventTypes5;
        EventTypes eventTypes6 = new EventTypes("EVENT_CONTROLS_VISIBILITY_CHANGE", 5, "onControlsVisibilityChange");
        f15435h = eventTypes6;
        EventTypes eventTypes7 = new EventTypes("EVENT_SEEK", 6, "onVideoSeek");
        f15436i = eventTypes7;
        EventTypes eventTypes8 = new EventTypes("EVENT_END", 7, "onVideoEnd");
        f15437j = eventTypes8;
        EventTypes eventTypes9 = new EventTypes("EVENT_FULLSCREEN_WILL_PRESENT", 8, "onVideoFullscreenPlayerWillPresent");
        f15438k = eventTypes9;
        EventTypes eventTypes10 = new EventTypes("EVENT_FULLSCREEN_DID_PRESENT", 9, "onVideoFullscreenPlayerDidPresent");
        f15439l = eventTypes10;
        EventTypes eventTypes11 = new EventTypes("EVENT_FULLSCREEN_WILL_DISMISS", 10, "onVideoFullscreenPlayerWillDismiss");
        f15440m = eventTypes11;
        EventTypes eventTypes12 = new EventTypes("EVENT_FULLSCREEN_DID_DISMISS", 11, "onVideoFullscreenPlayerDidDismiss");
        n = eventTypes12;
        EventTypes eventTypes13 = new EventTypes("EVENT_READY", 12, "onReadyForDisplay");
        o = eventTypes13;
        EventTypes eventTypes14 = new EventTypes("EVENT_BUFFER", 13, "onVideoBuffer");
        p = eventTypes14;
        EventTypes eventTypes15 = new EventTypes("EVENT_PLAYBACK_STATE_CHANGED", 14, "onVideoPlaybackStateChanged");
        q = eventTypes15;
        EventTypes eventTypes16 = new EventTypes("EVENT_IDLE", 15, "onVideoIdle");
        r = eventTypes16;
        EventTypes eventTypes17 = new EventTypes("EVENT_TIMED_METADATA", 16, "onTimedMetadata");
        s = eventTypes17;
        EventTypes eventTypes18 = new EventTypes("EVENT_AUDIO_BECOMING_NOISY", 17, "onVideoAudioBecomingNoisy");
        t = eventTypes18;
        EventTypes eventTypes19 = new EventTypes("EVENT_AUDIO_FOCUS_CHANGE", 18, "onAudioFocusChanged");
        u = eventTypes19;
        EventTypes eventTypes20 = new EventTypes("EVENT_PLAYBACK_RATE_CHANGE", 19, "onPlaybackRateChange");
        v = eventTypes20;
        EventTypes eventTypes21 = new EventTypes("EVENT_VOLUME_CHANGE", 20, "onVolumeChange");
        w = eventTypes21;
        EventTypes eventTypes22 = new EventTypes("EVENT_AUDIO_TRACKS", 21, "onAudioTracks");
        x = eventTypes22;
        EventTypes eventTypes23 = new EventTypes("EVENT_TEXT_TRACKS", 22, "onTextTracks");
        y = eventTypes23;
        EventTypes eventTypes24 = new EventTypes("EVENT_TEXT_TRACK_DATA_CHANGED", 23, "onTextTrackDataChanged");
        z = eventTypes24;
        EventTypes eventTypes25 = new EventTypes("EVENT_VIDEO_TRACKS", 24, "onVideoTracks");
        A = eventTypes25;
        EventTypes eventTypes26 = new EventTypes("EVENT_ON_RECEIVE_AD_EVENT", 25, "onReceiveAdEvent");
        B = eventTypes26;
        EventTypes eventTypes27 = new EventTypes("EVENT_PICTURE_IN_PICTURE_STATUS_CHANGED", 26, "onPictureInPictureStatusChanged");
        C = eventTypes27;
        EventTypes[] eventTypesArr = {eventTypes, eventTypes2, eventTypes3, eventTypes4, eventTypes5, eventTypes6, eventTypes7, eventTypes8, eventTypes9, eventTypes10, eventTypes11, eventTypes12, eventTypes13, eventTypes14, eventTypes15, eventTypes16, eventTypes17, eventTypes18, eventTypes19, eventTypes20, eventTypes21, eventTypes22, eventTypes23, eventTypes24, eventTypes25, eventTypes26, eventTypes27};
        D = eventTypesArr;
        E = EnumEntriesKt.a(eventTypesArr);
        f15429b = new Companion();
    }

    public EventTypes(String str, int i2, String str2) {
        this.f15441a = str2;
    }

    public static EventTypes valueOf(String str) {
        return (EventTypes) Enum.valueOf(EventTypes.class, str);
    }

    public static EventTypes[] values() {
        return (EventTypes[]) D.clone();
    }
}
