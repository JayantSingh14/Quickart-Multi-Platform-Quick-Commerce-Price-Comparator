package com.brentvatne.exoplayer;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.PictureInPictureParams;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.BasePlayer;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.Tracks;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.dash.manifest.AdaptationSet;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.dash.manifest.DashManifestParser;
import androidx.media3.exoplayer.dash.manifest.Period;
import androidx.media3.exoplayer.dash.manifest.Representation;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.UnsupportedDrmException;
import androidx.media3.exoplayer.ima.ImaAdsLoader;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelection;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.DefaultAllocator;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.exoplayer.util.EventLogger;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import androidx.media3.extractor.metadata.id3.Id3Frame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import androidx.media3.ui.LegacyPlayerControlView;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.brentvatne.common.api.BufferConfig;
import com.brentvatne.common.api.BufferingStrategy;
import com.brentvatne.common.api.ControlsConfig;
import com.brentvatne.common.api.DRMProps;
import com.brentvatne.common.api.Source;
import com.brentvatne.common.api.SubtitleStyle;
import com.brentvatne.common.api.TimedMetadata;
import com.brentvatne.common.api.Track;
import com.brentvatne.common.api.VideoTrack;
import com.brentvatne.common.react.VideoEventEmitter;
import com.brentvatne.common.toolbox.DebugLog;
import com.brentvatne.react.ReactNativeVideoManager;
import com.brentvatne.receiver.AudioBecomingNoisyReceiver;
import com.brentvatne.receiver.BecomingNoisyListener;
import com.brentvatne.receiver.PictureInPictureReceiver;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import com.google.android.gms.common.api.Api;
import com.google.common.collect.ImmutableList;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class ReactExoplayerView extends FrameLayout implements LifecycleEventListener, Player.Listener, BandwidthMeter.EventListener, BecomingNoisyListener, DrmSessionEventListener, AdEvent.AdEventListener, AdErrorEvent.AdErrorListener {
    public static final CookieManager j1;
    public final PictureInPictureParams.Builder A;
    public ControlsConfig A0;
    public boolean B;
    public final ArrayList B0;
    public float C;
    public boolean C0;
    public AudioOutput D;
    public long D0;
    public float E;
    public Source E0;
    public int F;
    public boolean F0;
    public boolean G;
    public String G0;
    public boolean H;
    public String H0;
    public boolean I;
    public String I0;
    public final Handler J;
    public String J0;
    public e K;
    public String K0;
    public androidx.media3.common.util.e L;
    public String L0;
    public boolean M;
    public boolean M0;
    public boolean N0;
    public BufferingStrategy.BufferingStrategyEnum O0;
    public boolean P0;
    public boolean Q;
    public boolean Q0;
    public float R0;
    public boolean S0;
    public boolean T0;
    public boolean U0;
    public boolean V0;
    public final ThemedReactContext W0;
    public final AudioManager X0;
    public final AudioBecomingNoisyReceiver Y0;
    public final PictureInPictureReceiver Z0;

    /* renamed from: a, reason: collision with root package name */
    public final VideoEventEmitter f15560a;
    public final AudioManager.OnAudioFocusChangeListener a1;

    /* renamed from: b, reason: collision with root package name */
    public final ReactExoplayerConfig f15561b;
    public long b1;

    /* renamed from: c, reason: collision with root package name */
    public DefaultBandwidthMeter f15562c;
    public long c1;

    /* renamed from: d, reason: collision with root package name */
    public LegacyPlayerControlView f15563d;
    public long d1;

    /* renamed from: e, reason: collision with root package name */
    public View f15564e;
    public boolean e1;

    /* renamed from: f, reason: collision with root package name */
    public Player.Listener f15565f;
    public int f1;

    /* renamed from: g, reason: collision with root package name */
    public final ExoPlayerView f15566g;
    public final String g1;

    /* renamed from: h, reason: collision with root package name */
    public FullScreenPlayerView f15567h;
    public CmcdConfiguration.Factory h1;

    /* renamed from: i, reason: collision with root package name */
    public ImaAdsLoader f15568i;
    public final Handler i1;

    /* renamed from: j, reason: collision with root package name */
    public DataSource.Factory f15569j;

    /* renamed from: k, reason: collision with root package name */
    public ExoPlayer f15570k;

    /* renamed from: l, reason: collision with root package name */
    public DefaultTrackSelector f15571l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f15572m;
    public ServiceConnection n;
    public PlaybackServiceBinder o;
    public EventLogger p;
    public boolean q;
    public int r;
    public long s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public static class OnAudioFocusChangedListener implements AudioManager.OnAudioFocusChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final ReactExoplayerView f15583a;

        /* renamed from: b, reason: collision with root package name */
        public final ThemedReactContext f15584b;

        public OnAudioFocusChangedListener(ThemedReactContext themedReactContext, ReactExoplayerView reactExoplayerView) {
            this.f15583a = reactExoplayerView;
            this.f15584b = themedReactContext;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int i2) {
            Activity currentActivity = this.f15584b.f19479a.getCurrentActivity();
            ReactExoplayerView reactExoplayerView = this.f15583a;
            if (i2 == -2) {
                reactExoplayerView.f15560a.s.invoke(Boolean.FALSE);
            } else if (i2 == -1) {
                reactExoplayerView.B = false;
                reactExoplayerView.f15560a.s.invoke(Boolean.FALSE);
                if (currentActivity != null) {
                    currentActivity.runOnUiThread(new d(reactExoplayerView, 3));
                }
                reactExoplayerView.X0.abandonAudioFocus(this);
            } else if (i2 == 1) {
                reactExoplayerView.B = true;
                reactExoplayerView.f15560a.s.invoke(Boolean.TRUE);
            }
            if (reactExoplayerView.f15570k == null || currentActivity == null) {
                return;
            }
            if (i2 == -3) {
                if (reactExoplayerView.y) {
                    return;
                }
                currentActivity.runOnUiThread(new k(this, 0));
            } else {
                if (i2 != 1 || reactExoplayerView.y) {
                    return;
                }
                currentActivity.runOnUiThread(new k(this, 1));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class RNVLoadControl extends DefaultLoadControl {

        /* renamed from: k, reason: collision with root package name */
        public final int f15585k;

        /* renamed from: l, reason: collision with root package name */
        public final Runtime f15586l;

        /* JADX WARN: Illegal instructions before constructor call */
        public RNVLoadControl(DefaultAllocator defaultAllocator, BufferConfig bufferConfig) {
            int i2 = bufferConfig.f15343b;
            int i3 = i2 != -1 ? i2 : 50000;
            int i4 = bufferConfig.f15344c;
            int i5 = i4 != -1 ? i4 : 50000;
            int i6 = bufferConfig.f15345d;
            int i7 = i6 == -1 ? 2500 : i6;
            int i8 = bufferConfig.f15346e;
            int i9 = i8 == -1 ? 5000 : i8;
            int i10 = bufferConfig.f15347f;
            super(defaultAllocator, i3, i5, i7, i9, true, i10 == -1 ? 0 : i10);
            this.f15586l = Runtime.getRuntime();
            ActivityManager activityManager = (ActivityManager) ReactExoplayerView.this.W0.getSystemService("activity");
            double d2 = bufferConfig.f15348g;
            this.f15585k = (int) Math.floor(activityManager.getMemoryClass() * (d2 == -1.0d ? 1.0d : d2) * 1024.0d * 1024.0d);
        }

        @Override // androidx.media3.exoplayer.LoadControl
        public final boolean j(long j2, long j3, float f2) {
            ReactExoplayerView reactExoplayerView = ReactExoplayerView.this;
            BufferingStrategy.BufferingStrategyEnum bufferingStrategyEnum = reactExoplayerView.O0;
            if (bufferingStrategyEnum != BufferingStrategy.BufferingStrategyEnum.f15359b) {
                if (bufferingStrategyEnum == BufferingStrategy.BufferingStrategyEnum.f15360c) {
                    int iF = this.f6158a.f();
                    int i2 = this.f15585k;
                    if (i2 <= 0 || iF < i2) {
                        Runtime runtime = this.f15586l;
                        long jMaxMemory = runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory());
                        double d2 = reactExoplayerView.E0.q.f15350i;
                        if (d2 == -1.0d) {
                            d2 = 0.0d;
                        }
                        long jMaxMemory2 = runtime.maxMemory() * ((long) d2);
                        long j4 = j3 / 1000;
                        if (jMaxMemory2 <= jMaxMemory || j4 <= 2000) {
                            if (runtime.freeMemory() == 0) {
                                DebugLog.e("ReactExoplayerView", "Free memory reached 0, forcing garbage collection");
                                runtime.gc();
                                return false;
                            }
                        }
                    }
                }
                super.j(j2, j3, f2);
                throw null;
            }
            return false;
        }
    }

    static {
        CookieManager cookieManager = new CookieManager();
        j1 = cookieManager;
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
    }

    public ReactExoplayerView(ThemedReactContext themedReactContext, ReactExoplayerConfig reactExoplayerConfig) {
        super(themedReactContext);
        this.p = null;
        this.q = false;
        this.y = false;
        this.z = false;
        this.B = false;
        this.C = 1.0f;
        this.D = AudioOutput.f15514d;
        this.E = 1.0f;
        this.F = 0;
        this.G = false;
        this.H = false;
        this.I = false;
        this.M = false;
        this.Q = false;
        this.A0 = new ControlsConfig();
        this.B0 = new ArrayList();
        this.C0 = false;
        this.D0 = -1L;
        this.E0 = new Source();
        this.K0 = "disabled";
        this.N0 = true;
        this.Q0 = true;
        this.R0 = 250.0f;
        this.S0 = false;
        this.T0 = false;
        this.V0 = false;
        this.b1 = -1L;
        this.c1 = -1L;
        this.d1 = -1L;
        this.e1 = false;
        this.f1 = 1;
        this.g1 = String.valueOf(UUID.randomUUID());
        this.i1 = new Handler(Looper.getMainLooper()) { // from class: com.brentvatne.exoplayer.ReactExoplayerView.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what == 1) {
                    CookieManager cookieManager = ReactExoplayerView.j1;
                    ReactExoplayerView.this.j0();
                    sendMessageDelayed(obtainMessage(1), Math.round(r4.R0));
                }
            }
        };
        this.W0 = themedReactContext;
        this.f15560a = new VideoEventEmitter();
        this.f15561b = reactExoplayerConfig;
        this.f15562c = reactExoplayerConfig.c();
        if (Build.VERSION.SDK_INT >= 26 && this.A == null) {
            this.A = androidx.media3.session.e.g();
        }
        this.J = new Handler();
        CookieHandler cookieHandler = CookieHandler.getDefault();
        CookieManager cookieManager = j1;
        if (cookieHandler != cookieManager) {
            CookieHandler.setDefault(cookieManager);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        ExoPlayerView exoPlayerView = new ExoPlayerView(getContext());
        this.f15566g = exoPlayerView;
        exoPlayerView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.brentvatne.exoplayer.j
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                ReactExoplayerView reactExoplayerView = this.f15627a;
                PictureInPictureParams.Builder builder = reactExoplayerView.A;
                ExoPlayerView playerView = reactExoplayerView.f15566g;
                ThemedReactContext context = reactExoplayerView.W0;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(playerView, "playerView");
                if (builder == null || Build.VERSION.SDK_INT < 26) {
                    return;
                }
                Rect rect = new Rect();
                View surfaceView = playerView.getSurfaceView();
                if (surfaceView != null) {
                    surfaceView.getGlobalVisibleRect(rect);
                }
                int[] iArr = new int[2];
                View surfaceView2 = playerView.getSurfaceView();
                if (surfaceView2 != null) {
                    surfaceView2.getLocationOnScreen(iArr);
                }
                int i10 = rect.bottom - rect.top;
                int i11 = iArr[1];
                rect.top = i11;
                rect.bottom = i11 + i10;
                builder.setSourceRectHint(rect);
                PictureInPictureParams pictureInPictureParamsBuild = builder.build();
                Intrinsics.checkNotNullExpressionValue(pictureInPictureParamsBuild, "build(...)");
                PictureInPictureUtil.g(context, pictureInPictureParamsBuild);
            }
        });
        this.f15566g.setLayoutParams(layoutParams);
        addView(this.f15566g, 0, layoutParams);
        this.f15566g.setFocusable(this.N0);
        this.X0 = (AudioManager) themedReactContext.getSystemService("audio");
        themedReactContext.addLifecycleEventListener(this);
        this.Y0 = new AudioBecomingNoisyReceiver(themedReactContext);
        this.a1 = new OnAudioFocusChangedListener(themedReactContext, this);
        this.Z0 = new PictureInPictureReceiver(themedReactContext, this);
    }

    public static /* synthetic */ void B(ReactExoplayerView reactExoplayerView, long j2, long j3, int i2, int i3, ArrayList arrayList, ArrayList arrayList2, String str) {
        ArrayList<VideoTrack> videoTrackInfoFromManifest = reactExoplayerView.getVideoTrackInfoFromManifest();
        if (videoTrackInfoFromManifest != null) {
            reactExoplayerView.H = true;
        }
        reactExoplayerView.f15560a.f15443b.a(Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3), arrayList, arrayList2, videoTrackInfoFromManifest, str);
    }

    public static Track L(Format format, int i2, TrackSelection trackSelection, TrackGroup trackGroup) {
        Track track = new Track();
        String str = format.f5225m;
        if (str != null) {
            track.c(str);
        }
        String str2 = format.f5216d;
        if (str2 != null) {
            track.b(str2);
        }
        String str3 = format.f5214b;
        if (str3 != null) {
            track.e(str3);
        }
        track.d((trackSelection == null || trackSelection.m() != trackGroup || trackSelection.l(i2) == -1) ? false : true);
        return track;
    }

    public static VideoTrack M(Format format, int i2) {
        VideoTrack videoTrack = new VideoTrack();
        int i3 = format.s;
        if (i3 == -1) {
            i3 = 0;
        }
        videoTrack.g(i3);
        int i4 = format.t;
        if (i4 == -1) {
            i4 = 0;
        }
        videoTrack.c(i4);
        int i5 = format.f5221i;
        videoTrack.a(i5 != -1 ? i5 : 0);
        videoTrack.e(format.v);
        String str = format.f5222j;
        if (str != null) {
            videoTrack.b(str);
        }
        String strValueOf = format.f5213a;
        if (strValueOf == null) {
            strValueOf = String.valueOf(i2);
        }
        videoTrack.f(strValueOf);
        videoTrack.d(i2);
        return videoTrack;
    }

    public static int N(TrackGroupArray trackGroupArray) throws MissingResourceException {
        if (trackGroupArray.f7771a == 0) {
            return -1;
        }
        String language = Locale.getDefault().getLanguage();
        String iSO3Language = Locale.getDefault().getISO3Language();
        for (int i2 = 0; i2 < trackGroupArray.f7771a; i2++) {
            String str = trackGroupArray.a(i2).b(0).f5216d;
            if (str != null && (str.equals(language) || str.equals(iSO3Language))) {
                return i2;
            }
        }
        return 0;
    }

    public static boolean V(Format format) {
        int i2 = format.s;
        if (i2 == -1) {
            i2 = 0;
        }
        int i3 = format.t;
        int i4 = i3 != -1 ? i3 : 0;
        float f2 = format.u;
        if (f2 == -1.0f) {
            f2 = 0.0f;
        }
        String str = format.f5225m;
        if (str == null) {
            return true;
        }
        try {
            return MediaCodecUtil.e(str).f(i2, i4, f2);
        } catch (Exception unused) {
            return true;
        }
    }

    private ArrayList<Track> getAudioTrackInfo() {
        ArrayList<Track> arrayList = new ArrayList<>();
        DefaultTrackSelector defaultTrackSelector = this.f15571l;
        if (defaultTrackSelector != null) {
            MappingTrackSelector.MappedTrackInfo mappedTrackInfoI = defaultTrackSelector.i();
            int iO = O(1);
            if (mappedTrackInfoI != null && iO != -1) {
                TrackGroupArray trackGroupArrayA = mappedTrackInfoI.a(iO);
                TrackSelection trackSelectionA = this.f15570k.g().a(1);
                for (int i2 = 0; i2 < trackGroupArrayA.f7771a; i2++) {
                    TrackGroup trackGroupA = trackGroupArrayA.a(i2);
                    Format formatB = trackGroupA.b(0);
                    Track trackL = L(formatB, i2, trackSelectionA, trackGroupA);
                    int i3 = formatB.f5221i;
                    if (i3 == -1) {
                        i3 = 0;
                    }
                    trackL.a(i3);
                    arrayList.add(trackL);
                }
            }
        }
        return arrayList;
    }

    private ArrayList<Track> getTextTrackInfo() {
        ArrayList<Track> arrayList = new ArrayList<>();
        DefaultTrackSelector defaultTrackSelector = this.f15571l;
        if (defaultTrackSelector != null) {
            MappingTrackSelector.MappedTrackInfo mappedTrackInfoI = defaultTrackSelector.i();
            int iO = O(3);
            if (mappedTrackInfoI != null && iO != -1) {
                TrackSelection trackSelectionA = this.f15570k.g().a(2);
                TrackGroupArray trackGroupArrayA = mappedTrackInfoI.a(iO);
                for (int i2 = 0; i2 < trackGroupArrayA.f7771a; i2++) {
                    TrackGroup trackGroupA = trackGroupArrayA.a(i2);
                    arrayList.add(L(trackGroupA.b(0), i2, trackSelectionA, trackGroupA));
                }
            }
        }
        return arrayList;
    }

    private ArrayList<VideoTrack> getVideoTrackInfo() {
        ArrayList<VideoTrack> arrayList = new ArrayList<>();
        DefaultTrackSelector defaultTrackSelector = this.f15571l;
        if (defaultTrackSelector != null) {
            MappingTrackSelector.MappedTrackInfo mappedTrackInfoI = defaultTrackSelector.i();
            int iO = O(2);
            if (mappedTrackInfoI != null && iO != -1) {
                TrackGroupArray trackGroupArrayA = mappedTrackInfoI.a(iO);
                for (int i2 = 0; i2 < trackGroupArrayA.f7771a; i2++) {
                    TrackGroup trackGroupA = trackGroupArrayA.a(i2);
                    for (int i3 = 0; i3 < trackGroupA.f5501a; i3++) {
                        Format formatB = trackGroupA.b(i3);
                        if (V(formatB)) {
                            arrayList.add(M(formatB, i3));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private ArrayList<VideoTrack> getVideoTrackInfoFromManifest() {
        return Q(0);
    }

    public static void l0(int i2, View view, boolean z) {
        if (z) {
            view.setVisibility(i2);
        } else if (view.getVisibility() == i2) {
            view.setVisibility(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setPlayWhenReady(boolean r5) {
        /*
            r4 = this;
            androidx.media3.exoplayer.ExoPlayer r0 = r4.f15570k
            if (r0 != 0) goto L5
            goto L2f
        L5:
            r1 = 0
            if (r5 == 0) goto L30
            boolean r5 = r4.M0
            r0 = 1
            if (r5 != 0) goto L25
            com.brentvatne.common.api.Source r5 = r4.E0
            android.net.Uri r5 = r5.o()
            if (r5 == 0) goto L25
            boolean r5 = r4.B
            if (r5 == 0) goto L1a
            goto L25
        L1a:
            android.media.AudioManager$OnAudioFocusChangeListener r5 = r4.a1
            r2 = 3
            android.media.AudioManager r3 = r4.X0
            int r5 = r3.requestAudioFocus(r5, r2, r0)
            if (r5 != r0) goto L26
        L25:
            r1 = r0
        L26:
            r4.B = r1
            if (r1 == 0) goto L2f
            androidx.media3.exoplayer.ExoPlayer r5 = r4.f15570k
            r5.u0(r0)
        L2f:
            return
        L30:
            r0.u0(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.brentvatne.exoplayer.ReactExoplayerView.setPlayWhenReady(boolean):void");
    }

    @Override // androidx.media3.common.Player.Listener
    public final void B1(Timeline timeline, int i2) {
    }

    public final DrmSessionManager C(UUID uuid, DRMProps dRMProps) throws UnsupportedDrmException {
        VideoEventEmitter videoEventEmitter = this.f15560a;
        if (Util.f5744a < 18) {
            return null;
        }
        try {
            ReactNativeVideoManager.Companion companion = ReactNativeVideoManager.f15630c;
            companion.a();
            DrmSessionManager drmSessionManagerA = new DRMManager(D(false)).a(uuid, dRMProps);
            if (drmSessionManagerA == null) {
                videoEventEmitter.f15444c.invoke("Failed to build DRM session manager", new Exception("DRM session manager is null"), "3007");
            }
            DrmSessionManager drmSessionManagerC = companion.a().c(this.E0, drmSessionManagerA);
            return drmSessionManagerC != null ? drmSessionManagerC : drmSessionManagerA;
        } catch (UnsupportedDrmException e2) {
            throw e2;
        } catch (Exception e3) {
            videoEventEmitter.f15444c.invoke(e3.toString(), e3, "3006");
            return null;
        }
    }

    public final HttpDataSource.Factory D(boolean z) {
        return DataSourceUtil.d(this.W0, z ? this.f15562c : null, this.E0.i());
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void E(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        DebugLog.a("DRM Info", "onDrmKeysLoaded");
    }

    @Override // androidx.media3.common.Player.Listener
    public final void E1(Tracks tracks) {
        VideoEventEmitter videoEventEmitter = this.f15560a;
        videoEventEmitter.w.invoke(getTextTrackInfo());
        videoEventEmitter.v.invoke(getAudioTrackInfo());
        videoEventEmitter.x.invoke(getVideoTrackInfo());
    }

    public final void F(AudioOutput audioOutput) {
        if (this.f15570k != null) {
            int iA = audioOutput.a();
            int i2 = Util.f5744a;
            int i3 = 4;
            int i4 = iA != 0 ? iA != 1 ? iA != 2 ? iA != 4 ? iA != 5 ? iA != 8 ? 1 : 3 : 5 : 4 : 6 : 13 : 2;
            if (iA == 0) {
                i3 = 1;
            } else if (iA != 1 && iA != 2 && iA != 4 && iA != 5 && iA != 8) {
                i3 = 2;
            }
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            builder.c(i4);
            builder.b(i3);
            this.f15570k.W0(builder.a(), false);
            AudioManager audioManager = (AudioManager) this.W0.getSystemService("audio");
            boolean z = audioOutput == AudioOutput.f15514d;
            audioManager.setMode(z ? 0 : 3);
            audioManager.setSpeakerphoneOn(z);
        }
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void G(int i2, MediaSource.MediaPeriodId mediaPeriodId, int i3) {
        DebugLog.a("DRM Info", "onDrmSessionAcquired");
    }

    public final void H() {
        PlaybackServiceBinder playbackServiceBinder;
        try {
            if (this.f15570k != null && (playbackServiceBinder = this.o) != null) {
                playbackServiceBinder.a().l(this.f15570k);
            }
            this.o = null;
            ServiceConnection serviceConnection = this.n;
            if (serviceConnection != null) {
                this.W0.unbindService(serviceConnection);
            }
        } catch (Exception unused) {
            DebugLog.e("ReactExoplayerView", "Cloud not cleanup playback service");
        }
    }

    public final void I() {
        PictureInPictureParams pictureInPictureParamsBuild;
        int i2 = Build.VERSION.SDK_INT;
        ThemedReactContext themedReactContext = this.W0;
        if (i2 >= 26) {
            this.A.setActions(PictureInPictureUtil.e(themedReactContext, this.w, this.Z0));
            if (this.f15570k.u() == 3) {
                this.A.setAspectRatio(PictureInPictureUtil.c(this.f15570k));
            }
            pictureInPictureParamsBuild = this.A.build();
        } else {
            pictureInPictureParamsBuild = null;
        }
        PictureInPictureUtil.d(themedReactContext, pictureInPictureParamsBuild);
    }

    public final void J() {
        Activity currentActivity = this.W0.f19479a.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView().findViewById(R.id.content);
        ArrayList arrayList = this.B0;
        if (!arrayList.isEmpty()) {
            if (this.f15566g.getParent().equals(viewGroup)) {
                viewGroup.removeView(this.f15566g);
            }
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                viewGroup.getChildAt(i2).setVisibility(((Integer) arrayList.get(i2)).intValue());
            }
            arrayList.clear();
        }
        if (currentActivity.isInPictureInPictureMode()) {
            currentActivity.moveTaskToBack(false);
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public final void J1(boolean z) {
        VideoEventEmitter videoEventEmitter = this.f15560a;
        if (z && this.C0) {
            videoEventEmitter.f15448g.invoke(Long.valueOf(this.f15570k.z1()), Long.valueOf(this.D0));
        }
        PictureInPictureUtil.b(this.W0, this.A, this.Z0, !z);
        videoEventEmitter.f15447f.invoke(Boolean.valueOf(z), Boolean.valueOf(this.C0));
        if (z) {
            this.C0 = false;
        }
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void K(int i2, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        DebugLog.a("DRM Info", "onDrmSessionManagerError");
        this.f15560a.f15444c.invoke("onDrmSessionManagerError", exc, "3002");
    }

    public final int O(int i2) {
        ExoPlayer exoPlayer = this.f15570k;
        if (exoPlayer == null) {
            return -1;
        }
        int i3 = exoPlayer.i();
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.f15570k.h(i4) == i2) {
                return i4;
            }
        }
        return -1;
    }

    public final ArrayList Q(int i2) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        try {
            ArrayList arrayList = (ArrayList) executorServiceNewSingleThreadExecutor.submit(new Callable(this.f15569j.a(), this.E0.o(), (this.E0.d() * 1000) - 100) { // from class: com.brentvatne.exoplayer.ReactExoplayerView.5

                /* renamed from: a, reason: collision with root package name */
                public final DataSource f15577a;

                /* renamed from: b, reason: collision with root package name */
                public final Uri f15578b;

                /* renamed from: c, reason: collision with root package name */
                public final long f15579c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ DataSource f15580d;

                {
                    this.f15580d = dataSource;
                    this.f15577a = dataSource;
                    this.f15578b = uri;
                    this.f15579c = j * 1000;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    int i3;
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        ParsingLoadable parsingLoadable = new ParsingLoadable(this.f15577a, this.f15578b, 4, new DashManifestParser());
                        parsingLoadable.a();
                        Object obj = parsingLoadable.f8188f;
                        obj.getClass();
                        DashManifest dashManifest = (DashManifest) obj;
                        int size = dashManifest.f6801m.size();
                        int i4 = 0;
                        while (i4 < size) {
                            Period periodB = dashManifest.b(i4);
                            int i5 = 0;
                            while (i5 < periodB.f6824c.size()) {
                                AdaptationSet adaptationSet = (AdaptationSet) periodB.f6824c.get(i5);
                                if (adaptationSet.f6780b != 2) {
                                    i3 = i4;
                                } else {
                                    int i6 = 0;
                                    boolean z = false;
                                    while (true) {
                                        if (i6 >= adaptationSet.f6781c.size()) {
                                            i3 = i4;
                                            break;
                                        }
                                        Representation representation = (Representation) adaptationSet.f6781c.get(i6);
                                        Format format = representation.f6835a;
                                        ReactExoplayerView reactExoplayerView = ReactExoplayerView.this;
                                        CookieManager cookieManager = ReactExoplayerView.j1;
                                        reactExoplayerView.getClass();
                                        if (ReactExoplayerView.V(format)) {
                                            i3 = i4;
                                            if (representation.f6837c <= this.f15579c) {
                                                break;
                                            }
                                            ReactExoplayerView.this.getClass();
                                            arrayList2.add(ReactExoplayerView.M(format, i6));
                                            z = true;
                                        } else {
                                            i3 = i4;
                                        }
                                        i6++;
                                        i4 = i3;
                                    }
                                    if (z) {
                                        return arrayList2;
                                    }
                                }
                                i5++;
                                i4 = i3;
                            }
                            i4++;
                        }
                        return null;
                    } catch (Exception e2) {
                        DebugLog.e("ReactExoplayerView", "error in getVideoTrackInfoFromManifest:" + e2.getMessage());
                        return null;
                    }
                }
            }).get(3000L, TimeUnit.MILLISECONDS);
            if (arrayList == null && i2 < 1) {
                return Q(i2 + 1);
            }
            executorServiceNewSingleThreadExecutor.shutdown();
            return arrayList;
        } catch (Exception e2) {
            DebugLog.e("ReactExoplayerView", "error in getVideoTrackInfoFromManifest handling request:" + e2.getMessage());
            return null;
        }
    }

    public final void R() {
        this.Q = ReactNativeVideoManager.f15630c.a().f(this.E0);
        e eVar = new e(this, this.E0, this, this.W0.f19479a.getCurrentActivity());
        this.K = eVar;
        this.J.postDelayed(eVar, 1L);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void S(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        DebugLog.a("DRM Info", "onDrmKeysRestored");
    }

    public final void T(ReactExoplayerView reactExoplayerView) {
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(getContext(), new AdaptiveTrackSelection.Factory());
        reactExoplayerView.f15571l = defaultTrackSelector;
        DefaultTrackSelector.Parameters.Builder builderK = this.f15571l.k();
        int i2 = this.F;
        if (i2 == 0) {
            i2 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        builderK.s(i2);
        defaultTrackSelector.s(builderK);
        RNVLoadControl rNVLoadControl = new RNVLoadControl(new DefaultAllocator(), this.E0.b());
        long jA = this.E0.b().a();
        if (jA > 0) {
            ReactExoplayerConfig reactExoplayerConfig = this.f15561b;
            reactExoplayerConfig.d(jA);
            this.f15562c = reactExoplayerConfig.c();
        }
        DefaultRenderersFactory defaultRenderersFactory = new DefaultRenderersFactory(getContext());
        defaultRenderersFactory.c();
        defaultRenderersFactory.b();
        DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory(this.f15569j);
        if (this.M && !this.Q) {
            defaultMediaSourceFactory.i(RNVSimpleCache.a(D(true)));
        }
        defaultMediaSourceFactory.j(new f(this, 0), this.f15566g);
        ExoPlayer.Builder builder = new ExoPlayer.Builder(getContext(), defaultRenderersFactory);
        builder.e(reactExoplayerView.f15571l);
        builder.b(this.f15562c);
        builder.c(rNVLoadControl);
        builder.d(defaultMediaSourceFactory);
        this.f15570k = builder.a();
        ReactNativeVideoManager.f15630c.a().b(this.f15570k, this.g1);
        d0();
        this.f15570k.D0(reactExoplayerView);
        this.f15570k.b1(this.y ? 0.0f : this.E * 1.0f);
        this.f15566g.setPlayer(this.f15570k);
        this.Y0.b(reactExoplayerView);
        this.Z0.b();
        this.f15562c.d(new Handler(), reactExoplayerView);
        setPlayWhenReady(!this.w);
        this.f15572m = true;
        this.f15570k.D(new PlaybackParameters(this.C, 1.0f));
        F(this.D);
        if (this.V0) {
            g0();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x039b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03af A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U(com.brentvatne.common.api.Source r29) {
        /*
            Method dump skipped, instructions count: 1242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.brentvatne.exoplayer.ReactExoplayerView.U(com.brentvatne.common.api.Source):void");
    }

    public final void W(boolean z) {
        if (this.x == z) {
            return;
        }
        boolean z2 = this.w;
        VideoEventEmitter videoEventEmitter = this.f15560a;
        if (z2 && this.C0 && !z) {
            videoEventEmitter.f15448g.invoke(Long.valueOf(this.f15570k.z1()), Long.valueOf(this.D0));
            this.C0 = false;
        }
        this.x = z;
        videoEventEmitter.n.invoke(Boolean.valueOf(z));
    }

    public final void X() {
        ExoPlayer exoPlayer = this.f15570k;
        if (exoPlayer != null && exoPlayer.O0()) {
            setPlayWhenReady(false);
        }
        setKeepScreenOn(false);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionEventListener
    public final void Z(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        DebugLog.a("DRM Info", "onDrmSessionReleased");
    }

    public final void a0(View view) {
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        view.layout(view.getLeft(), view.getTop(), view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public final void c0() {
        boolean zA;
        LegacyPlayerControlView legacyPlayerControlView = this.f15563d;
        if (legacyPlayerControlView == null || this.f15570k == null || !this.U0) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) legacyPlayerControlView.findViewById(com.brentvatne.react.R.id.exo_live_container);
        TextView textView = (TextView) this.f15563d.findViewById(com.brentvatne.react.R.id.exo_live_label);
        Timeline timelineF0 = this.f15570k.F0();
        if (timelineF0.p()) {
            zA = false;
        } else {
            Timeline.Window window = new Timeline.Window();
            timelineF0.n(this.f15570k.l1(), window);
            zA = window.a();
        }
        if (!zA || this.A0.k() == null) {
            linearLayout.setVisibility(8);
        } else {
            textView.setText(this.A0.k());
            linearLayout.setVisibility(0);
        }
        ImageButton imageButton = (ImageButton) this.f15563d.findViewById(com.brentvatne.react.R.id.exo_play);
        ImageButton imageButton2 = (ImageButton) this.f15563d.findViewById(com.brentvatne.react.R.id.exo_pause);
        if (this.A0.e()) {
            this.f15564e.setAlpha(0.0f);
            imageButton.setClickable(false);
            imageButton2.setClickable(false);
        } else {
            this.f15564e.setAlpha(1.0f);
            imageButton.setClickable(true);
            imageButton2.setClickable(true);
        }
        h0(com.brentvatne.react.R.id.exo_ffwd, this.A0.b());
        h0(com.brentvatne.react.R.id.exo_rew, this.A0.h());
        h0(com.brentvatne.react.R.id.exo_next, this.A0.d());
        h0(com.brentvatne.react.R.id.exo_prev, this.A0.g());
        l0(8, this.f15563d.findViewById(com.brentvatne.react.R.id.exo_fullscreen), this.A0.c());
        l0(8, this.f15563d.findViewById(com.brentvatne.react.R.id.exo_position), this.A0.f());
        l0(4, this.f15563d.findViewById(com.brentvatne.react.R.id.exo_progress), this.A0.i());
        l0(8, this.f15563d.findViewById(com.brentvatne.react.R.id.exo_duration), this.A0.a());
        l0(8, this.f15563d.findViewById(com.brentvatne.react.R.id.exo_settings), this.A0.j());
    }

    public final void d0() {
        ExoPlayer exoPlayer = this.f15570k;
        if (exoPlayer == null) {
            return;
        }
        if (this.q) {
            EventLogger eventLogger = new EventLogger("RNVExoplayer");
            this.p = eventLogger;
            this.f15570k.j(eventLogger);
        } else {
            EventLogger eventLogger2 = this.p;
            if (eventLogger2 != null) {
                exoPlayer.e(eventLogger2);
                this.p = null;
            }
        }
    }

    public final void e0() throws JSONException, IllegalAccessException, InstantiationException {
        e eVar;
        if (this.f15570k != null) {
            PlaybackServiceBinder playbackServiceBinder = this.o;
            ThemedReactContext themedReactContext = this.W0;
            if (playbackServiceBinder != null) {
                playbackServiceBinder.a().l(this.f15570k);
                themedReactContext.unbindService(this.n);
            }
            k0();
            this.f15570k.release();
            this.f15570k.A0(this);
            PictureInPictureUtil.a(themedReactContext, this.A, false);
            androidx.media3.common.util.e eVar2 = this.L;
            if (eVar2 != null) {
                eVar2.run();
            }
            this.f15571l = null;
            ReactNativeVideoManager.f15630c.a().d(this.f15570k, this.g1);
            this.f15570k = null;
        }
        ImaAdsLoader imaAdsLoader = this.f15568i;
        if (imaAdsLoader != null) {
            imaAdsLoader.h();
            this.f15568i = null;
        }
        this.i1.removeMessages(1);
        this.Y0.a();
        this.Z0.a();
        this.f15562c.a(this);
        Handler handler = this.J;
        if (handler == null || (eVar = this.K) == null) {
            return;
        }
        handler.removeCallbacks(eVar);
        this.K = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.common.Player.Listener
    public final void e1(CueGroup cueGroup) {
        if (cueGroup.f5641a.isEmpty()) {
            return;
        }
        ImmutableList immutableList = cueGroup.f5641a;
        if (((Cue) immutableList.get(0)).f5612a != null) {
            this.f15560a.y.invoke(((Cue) immutableList.get(0)).f5612a.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f0(int r18, java.lang.String r19, java.lang.String r20) throws java.util.MissingResourceException {
        /*
            Method dump skipped, instructions count: 601
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.brentvatne.exoplayer.ReactExoplayerView.f0(int, java.lang.String, java.lang.String):void");
    }

    @Override // androidx.media3.common.Player.Listener
    public final void f1(Metadata metadata) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < metadata.d(); i2++) {
            Metadata.Entry entryC = metadata.c(i2);
            if (entryC instanceof Id3Frame) {
                Id3Frame id3Frame = (Id3Frame) metadata.c(i2);
                arrayList.add(new TimedMetadata(id3Frame.f8828a, id3Frame instanceof TextInformationFrame ? ((TextInformationFrame) id3Frame).f8841c : ""));
            } else if (entryC instanceof EventMessage) {
                EventMessage eventMessage = (EventMessage) entryC;
                arrayList.add(new TimedMetadata(eventMessage.f8770a, eventMessage.f8771b));
            } else {
                DebugLog.a("ReactExoplayerView", "unhandled metadata " + entryC);
            }
        }
        this.f15560a.q.invoke(arrayList);
    }

    public final void g0() {
        if (!this.V0 || this.f15570k == null) {
            return;
        }
        this.n = new ServiceConnection() { // from class: com.brentvatne.exoplayer.ReactExoplayerView.4
            @Override // android.content.ServiceConnection
            public final void onNullBinding(ComponentName componentName) {
                DebugLog.b("ReactExoplayerView", "Could not register ExoPlayer");
            }

            @Override // android.content.ServiceConnection
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                ReactExoplayerView reactExoplayerView = ReactExoplayerView.this;
                reactExoplayerView.o = (PlaybackServiceBinder) iBinder;
                try {
                    Activity currentActivity = reactExoplayerView.W0.f19479a.getCurrentActivity();
                    if (currentActivity != null) {
                        reactExoplayerView.o.f15557a.k(reactExoplayerView.f15570k, currentActivity.getClass());
                    } else {
                        DebugLog.e("ReactExoplayerView", "Could not register ExoPlayer: currentActivity is null");
                    }
                } catch (Exception e2) {
                    DebugLog.b("ReactExoplayerView", "Could not register ExoPlayer: " + e2.getMessage());
                }
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName componentName) {
                ReactExoplayerView reactExoplayerView = ReactExoplayerView.this;
                try {
                    PlaybackServiceBinder playbackServiceBinder = reactExoplayerView.o;
                    if (playbackServiceBinder != null) {
                        playbackServiceBinder.f15557a.l(reactExoplayerView.f15570k);
                    }
                } catch (Exception unused) {
                }
                reactExoplayerView.o = null;
            }
        };
        ThemedReactContext themedReactContext = this.W0;
        Intent intent = new Intent(themedReactContext, (Class<?>) VideoPlaybackService.class);
        intent.setAction("androidx.media3.session.MediaSessionService");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            themedReactContext.startForegroundService(intent);
        } else {
            themedReactContext.startService(intent);
        }
        themedReactContext.bindService(intent, this.n, i2 >= 29 ? 4097 : 1);
    }

    public boolean getPreventsDisplaySleepDuringVideoPlayback() {
        return this.Q0;
    }

    @Override // com.brentvatne.receiver.BecomingNoisyListener
    public final void h() {
        this.f15560a.r.invoke();
    }

    public final void h0(int i2, boolean z) {
        ImageButton imageButton = (ImageButton) this.f15563d.findViewById(i2);
        if (z) {
            imageButton.setImageAlpha(0);
            imageButton.setClickable(false);
        } else {
            imageButton.setImageAlpha(255);
            imageButton.setClickable(true);
        }
    }

    public final void i0() {
        FullScreenPlayerView fullScreenPlayerView;
        LegacyPlayerControlView legacyPlayerControlView = this.f15563d;
        if (legacyPlayerControlView != null) {
            ImageButton imageButton = (ImageButton) legacyPlayerControlView.findViewById(com.brentvatne.react.R.id.exo_fullscreen);
            if (!this.u || (fullScreenPlayerView = this.f15567h) == null || fullScreenPlayerView.isShowing()) {
                imageButton.setVisibility(0);
            } else {
                imageButton.setVisibility(8);
            }
        }
    }

    public final void j0() {
        ExoPlayer exoPlayer = this.f15570k;
        if (exoPlayer != null) {
            if (this.f15563d != null && exoPlayer != null && exoPlayer.f0() && this.U0) {
                this.f15563d.b();
            }
            long duration = (this.f15570k.getDuration() * ((BasePlayer) this.f15570k).i0()) / 100;
            long duration2 = this.f15570k.getDuration();
            long jZ1 = this.f15570k.z1();
            if (jZ1 > duration2) {
                jZ1 = duration2;
            }
            if (this.b1 == jZ1 && this.c1 == duration && this.d1 == duration2) {
                return;
            }
            this.b1 = jZ1;
            this.c1 = duration;
            this.d1 = duration2;
            com.brentvatne.common.react.g gVar = this.f15560a.f15445d;
            Long lValueOf = Long.valueOf(jZ1);
            Long lValueOf2 = Long.valueOf(duration);
            Long lValueOf3 = Long.valueOf(this.f15570k.getDuration());
            Timeline.Window window = new Timeline.Window();
            if (!this.f15570k.F0().p()) {
                this.f15570k.F0().n(this.f15570k.l1(), window);
            }
            gVar.d(lValueOf, lValueOf2, lValueOf3, Double.valueOf(window.f5491f + jZ1));
        }
    }

    public final void k0() {
        this.r = this.f15570k.l1();
        this.s = ((BasePlayer) this.f15570k).G1() ? Math.max(0L, this.f15570k.z1()) : -9223372036854775807L;
    }

    @Override // androidx.media3.common.Player.Listener
    public final void l1(PlaybackParameters playbackParameters) {
        this.f15560a.t.invoke(Float.valueOf(playbackParameters.f5427a));
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdErrorEvent.AdErrorListener
    public final void onAdError(AdErrorEvent adErrorEvent) {
        AdError error = adErrorEvent.getError();
        this.f15560a.z.invoke(MerchantConstants.ERROR, android.support.v4.media.a.o(error.getMessage(), String.valueOf(error.getErrorCode()), String.valueOf(error.getErrorType())));
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener
    public final void onAdEvent(AdEvent adEvent) {
        Map<String, String> adData = adEvent.getAdData();
        VideoEventEmitter videoEventEmitter = this.f15560a;
        if (adData != null) {
            videoEventEmitter.z.invoke(adEvent.getType().name(), adEvent.getAdData());
        } else {
            videoEventEmitter.z.invoke(adEvent.getType().name(), null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        H();
        super.onDetachedFromWindow();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostDestroy() throws JSONException, IllegalAccessException, InstantiationException {
        this.X0.abandonAudioFocus(this.a1);
        e0();
        this.W0.removeLifecycleEventListener(this);
        e0();
        this.e1 = true;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostPause() {
        this.v = true;
        Activity currentActivity = this.W0.f19479a.getCurrentActivity();
        int i2 = Util.f5744a;
        boolean z = i2 >= 24 && currentActivity != null && currentActivity.isInPictureInPictureMode();
        boolean z2 = i2 >= 24 && currentActivity != null && currentActivity.isInMultiWindowMode();
        if (this.S0 || z || z2) {
            return;
        }
        setPlayWhenReady(false);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public final void onHostResume() {
        if (!this.S0 || !this.v) {
            setPlayWhenReady(!this.w);
        }
        this.v = false;
    }

    @Override // androidx.media3.common.Player.Listener
    public final void r1(PlaybackException playbackException) {
        String strConcat = "ExoPlaybackException: ".concat(PlaybackException.b(playbackException.f5421a));
        StringBuilder sb = new StringBuilder("2");
        int i2 = playbackException.f5421a;
        sb.append(i2);
        String string = sb.toString();
        if ((i2 == 6000 || i2 == 6002 || i2 == 6004 || i2 == 6006 || i2 == 6007) && !this.G) {
            this.G = true;
            this.f15572m = true;
            k0();
            R();
            setPlayWhenReady(true);
            return;
        }
        this.f15560a.f15444c.invoke(strConcat, playbackException, string);
        this.f15572m = true;
        if (i2 != 1002) {
            k0();
            return;
        }
        this.r = -1;
        this.s = -9223372036854775807L;
        Player player = this.f15570k;
        if (player != null) {
            ((BasePlayer) player).k0();
            this.f15570k.p();
        }
    }

    public void setAudioOutput(AudioOutput audioOutput) {
        if (this.D != audioOutput) {
            this.D = audioOutput;
            F(audioOutput);
        }
    }

    public void setBufferingStrategy(BufferingStrategy.BufferingStrategyEnum bufferingStrategyEnum) {
        this.O0 = bufferingStrategyEnum;
    }

    public void setCmcdConfigurationFactory(CmcdConfiguration.Factory factory) {
        this.h1 = factory;
    }

    public void setControls(boolean z) {
        this.U0 = z;
        if (z) {
            if (this.f15563d != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                this.f15563d.setLayoutParams(layoutParams);
                int iIndexOfChild = indexOfChild(this.f15563d);
                if (iIndexOfChild != -1) {
                    removeViewAt(iIndexOfChild);
                }
                addView(this.f15563d, 1, layoutParams);
                a0(this.f15563d);
            }
            i0();
        } else {
            int iIndexOfChild2 = indexOfChild(this.f15563d);
            if (iIndexOfChild2 != -1) {
                removeViewAt(iIndexOfChild2);
            }
        }
        c0();
    }

    public void setControlsStyles(ControlsConfig controlsConfig) {
        this.A0 = controlsConfig;
        c0();
    }

    public void setDebug(boolean z) {
        this.q = z;
        d0();
    }

    public void setDisableDisconnectError(boolean z) {
        this.P0 = z;
    }

    public void setDisableFocus(boolean z) {
        this.M0 = z;
    }

    public void setEnterPictureInPictureOnLeave(boolean z) {
        this.z = z;
        if (this.f15570k != null) {
            PictureInPictureUtil.a(this.W0, this.A, z);
        }
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        this.N0 = z;
        this.f15566g.setFocusable(z);
    }

    public void setFullscreen(boolean z) {
        if (z == this.u) {
            return;
        }
        this.u = z;
        if (this.W0.f19479a.getCurrentActivity() == null) {
            return;
        }
        boolean z2 = this.u;
        VideoEventEmitter videoEventEmitter = this.f15560a;
        if (z2) {
            this.f15567h = new FullScreenPlayerView(getContext(), this.f15566g, this, this.f15563d, new OnBackPressedCallback() { // from class: com.brentvatne.exoplayer.ReactExoplayerView.6
                @Override // androidx.activity.OnBackPressedCallback
                public final void handleOnBackPressed() {
                    ReactExoplayerView.this.setFullscreen(false);
                }
            }, this.A0);
            videoEventEmitter.f15450i.invoke();
            FullScreenPlayerView fullScreenPlayerView = this.f15567h;
            if (fullScreenPlayerView != null) {
                fullScreenPlayerView.show();
            }
            UiThreadUtil.runOnUiThread(new d(this, 1));
        } else {
            videoEventEmitter.f15452k.invoke();
            FullScreenPlayerView fullScreenPlayerView2 = this.f15567h;
            if (fullScreenPlayerView2 != null) {
                fullScreenPlayerView2.dismiss();
                a0(this.f15566g);
                a0(this.f15563d);
                setControls(this.U0);
            }
            UiThreadUtil.runOnUiThread(new d(this, 2));
        }
        i0();
    }

    public void setHideShutterView(boolean z) {
        this.f15566g.setHideShutterView(z);
    }

    public void setIsInPictureInPicture(boolean z) {
        this.f15560a.A.invoke(Boolean.valueOf(z));
        FullScreenPlayerView fullScreenPlayerView = this.f15567h;
        if (fullScreenPlayerView != null && fullScreenPlayerView.isShowing()) {
            if (z) {
                this.f15567h.b();
                return;
            }
            return;
        }
        Activity currentActivity = this.W0.f19479a.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView().findViewById(R.id.content);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        ArrayList arrayList = this.B0;
        if (!z) {
            viewGroup.removeView(this.f15566g);
            if (arrayList.isEmpty()) {
                return;
            }
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                viewGroup.getChildAt(i2).setVisibility(((Integer) arrayList.get(i2)).intValue());
            }
            addView(this.f15566g, 0, layoutParams);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f15566g.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.f15566g);
        }
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            if (viewGroup.getChildAt(i3) != this.f15566g) {
                arrayList.add(Integer.valueOf(viewGroup.getChildAt(i3).getVisibility()));
                viewGroup.getChildAt(i3).setVisibility(8);
            }
        }
        viewGroup.addView(this.f15566g, layoutParams);
    }

    public void setMaxBitRateModifier(int i2) {
        this.F = i2;
        if (this.f15570k != null) {
            String str = this.I0;
            if (str == null || "auto".equals(str)) {
                DefaultTrackSelector defaultTrackSelector = this.f15571l;
                DefaultTrackSelector.Parameters.Builder builderK = defaultTrackSelector.k();
                int i3 = this.F;
                if (i3 == 0) {
                    i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                }
                builderK.s(i3);
                defaultTrackSelector.s(builderK);
            }
        }
    }

    public void setMutedModifier(boolean z) {
        this.y = z;
        ExoPlayer exoPlayer = this.f15570k;
        if (exoPlayer != null) {
            exoPlayer.b1(z ? 0.0f : this.E);
        }
    }

    public void setPausedModifier(boolean z) {
        this.w = z;
        ExoPlayer exoPlayer = this.f15570k;
        if (exoPlayer != null) {
            if (z) {
                X();
                return;
            }
            if (!exoPlayer.O0()) {
                setPlayWhenReady(true);
            }
            setKeepScreenOn(this.Q0);
        }
    }

    public void setPlayInBackground(boolean z) {
        this.S0 = z;
    }

    public void setPreventsDisplaySleepDuringVideoPlayback(boolean z) {
        this.Q0 = z;
    }

    public void setProgressUpdateInterval(float f2) {
        this.R0 = f2;
    }

    public void setRateModifier(float f2) {
        if (f2 <= 0.0f) {
            DebugLog.e("ReactExoplayerView", "cannot set rate <= 0");
            return;
        }
        this.C = f2;
        if (this.f15570k != null) {
            this.f15570k.D(new PlaybackParameters(this.C, 1.0f));
        }
    }

    public void setRepeatModifier(boolean z) {
        ExoPlayer exoPlayer = this.f15570k;
        if (exoPlayer != null) {
            if (z) {
                exoPlayer.d0(1);
            } else {
                exoPlayer.d0(0);
            }
        }
        this.F0 = z;
    }

    public void setReportBandwidth(boolean z) {
        this.T0 = z;
    }

    public void setResizeModeModifier(int i2) {
        ExoPlayerView exoPlayerView = this.f15566g;
        if (exoPlayerView != null) {
            exoPlayerView.setResizeMode(i2);
        }
    }

    public void setShowNotificationControls(boolean z) {
        this.V0 = z;
        ServiceConnection serviceConnection = this.n;
        if (serviceConnection == null && z) {
            g0();
        } else {
            if (z || serviceConnection == null) {
                return;
            }
            H();
        }
    }

    public void setShutterColor(Integer num) {
        this.f15566g.setShutterColor(num.intValue());
    }

    public void setSrc(Source source) {
        ExoPlayer exoPlayer;
        if (source.o() == null) {
            if (this.E0.o() != null && (exoPlayer = this.f15570k) != null) {
                exoPlayer.stop();
                ((BasePlayer) this.f15570k).h0();
            }
            this.f15566g.b();
            this.E0 = new Source();
            this.f15569j = null;
            this.r = -1;
            this.s = -9223372036854775807L;
            return;
        }
        this.r = -1;
        this.s = -9223372036854775807L;
        boolean zP = source.p(this.E0);
        this.G = false;
        this.E0 = source;
        DataSource.Factory factoryC = DataSourceUtil.c(this.W0, this.f15562c, source.i());
        this.f15569j = (DataSource.Factory) android.support.v4.media.a.i(ReactNativeVideoManager.f15630c.a().a(source, factoryC), factoryC);
        if (source.c() != null) {
            setCmcdConfigurationFactory(new CMCDConfig(source.c()).b());
        } else {
            setCmcdConfigurationFactory(null);
        }
        if (zP) {
            return;
        }
        this.f15572m = true;
        R();
    }

    public void setSubtitleStyle(SubtitleStyle subtitleStyle) {
        this.f15566g.setSubtitleStyle(subtitleStyle);
    }

    public void setViewType(int i2) {
        this.f15566g.f(i2);
    }

    public void setVolumeModifier(float f2) {
        this.E = f2;
        ExoPlayer exoPlayer = this.f15570k;
        if (exoPlayer != null) {
            exoPlayer.b1(f2);
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public final void v1(int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) throws MissingResourceException {
        if (i2 == 1) {
            this.C0 = true;
            this.D0 = positionInfo2.f5445f;
            if (this.H) {
                f0(2, this.I0, this.J0);
            }
        }
        if (this.f15572m) {
            k0();
        }
        if (this.H) {
            f0(2, this.I0, this.J0);
            this.I = true;
        }
        if (i2 == 0 && this.f15570k.G() == 1) {
            j0();
            this.f15560a.f15449h.invoke();
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public final void w1(boolean z) {
    }

    @Override // androidx.media3.common.Player.Listener
    public final void x1(Player player, Player.Events events) throws MissingResourceException {
        String strK;
        final int i2;
        int i3;
        if (events.a(4) || events.a(5)) {
            int iU = player.u();
            boolean zO0 = player.O0();
            String str = "onStateChanged: playWhenReady=" + zO0 + ", playbackState=";
            VideoEventEmitter videoEventEmitter = this.f15560a;
            videoEventEmitter.t.invoke(Float.valueOf((zO0 && iU == 3) ? 1.0f : 0.0f));
            Handler handler = this.i1;
            boolean z = true;
            if (iU == 1) {
                strK = android.support.v4.media.b.k(str, "idle");
                videoEventEmitter.p.invoke();
                handler.removeMessages(1);
                if (!player.O0()) {
                    setKeepScreenOn(false);
                }
            } else if (iU == 2) {
                strK = str + "buffering";
                W(true);
                handler.removeMessages(1);
                setKeepScreenOn(this.Q0);
            } else if (iU == 3) {
                String strK2 = android.support.v4.media.b.k(str, "ready");
                videoEventEmitter.f15454m.invoke();
                W(false);
                handler.removeMessages(1);
                handler.sendEmptyMessage(1);
                if (!this.f15570k.f0() && this.t) {
                    this.t = false;
                    String str2 = this.G0;
                    if (str2 != null) {
                        String str3 = this.H0;
                        this.G0 = str2;
                        this.H0 = str3;
                        f0(1, str2, str3);
                    }
                    String str4 = this.I0;
                    if (str4 != null) {
                        String str5 = this.J0;
                        this.I0 = str4;
                        this.J0 = str5;
                        if (!this.t) {
                            f0(2, str4, str5);
                        }
                    }
                    String str6 = this.K0;
                    if (str6 != null) {
                        String str7 = this.L0;
                        this.K0 = str6;
                        this.L0 = str7;
                        f0(3, str6, str7);
                    }
                    Format formatF = this.f15570k.f();
                    if (formatF == null || ((i3 = formatF.v) != 90 && i3 != 270)) {
                        z = false;
                    }
                    int i4 = formatF != null ? z ? formatF.t : formatF.s : 0;
                    if (formatF != null) {
                        i2 = z ? formatF.s : formatF.t;
                    } else {
                        i2 = 0;
                    }
                    final String str8 = formatF != null ? formatF.f5213a : null;
                    final long duration = this.f15570k.getDuration();
                    final long jZ1 = this.f15570k.z1();
                    final ArrayList<Track> audioTrackInfo = getAudioTrackInfo();
                    final ArrayList<Track> textTrackInfo = getTextTrackInfo();
                    if (this.E0.d() != -1) {
                        final int i5 = i4;
                        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.brentvatne.exoplayer.g
                            @Override // java.lang.Runnable
                            public final void run() {
                                ReactExoplayerView.B(this.f15615a, duration, jZ1, i5, i2, audioTrackInfo, textTrackInfo, str8);
                            }
                        });
                    } else {
                        videoEventEmitter.f15443b.a(Long.valueOf(duration), Long.valueOf(jZ1), Integer.valueOf(i4), Integer.valueOf(i2), audioTrackInfo, textTrackInfo, getVideoTrackInfo(), str8);
                        c0();
                    }
                }
                if (this.I && this.H) {
                    this.I = false;
                    f0(2, this.I0, this.J0);
                }
                LegacyPlayerControlView legacyPlayerControlView = this.f15563d;
                if (legacyPlayerControlView != null) {
                    legacyPlayerControlView.f();
                }
                setKeepScreenOn(this.Q0);
                strK = strK2;
            } else if (iU != 4) {
                strK = android.support.v4.media.b.k(str, zzck.UNKNOWN_CONTENT_TYPE);
            } else {
                strK = str + "ended";
                j0();
                videoEventEmitter.f15449h.invoke();
                this.X0.abandonAudioFocus(this.a1);
                setKeepScreenOn(false);
            }
            DebugLog.a("ReactExoplayerView", strK);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter.EventListener
    public final void z(long j2, long j3, int i2) {
        int i3;
        if (this.T0) {
            ExoPlayer exoPlayer = this.f15570k;
            VideoEventEmitter videoEventEmitter = this.f15560a;
            if (exoPlayer == null) {
                videoEventEmitter.f15446e.d(Long.valueOf(j3), 0, 0, null);
                return;
            }
            Format formatF = exoPlayer.f();
            boolean z = formatF != null && ((i3 = formatF.v) == 90 || i3 == 270);
            videoEventEmitter.f15446e.d(Long.valueOf(j3), Integer.valueOf(formatF != null ? z ? formatF.s : formatF.t : 0), Integer.valueOf(formatF != null ? z ? formatF.t : formatF.s : 0), formatF != null ? formatF.f5213a : null);
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public final void z1(float f2) {
        this.f15560a.u.invoke(Float.valueOf(f2));
    }
}
