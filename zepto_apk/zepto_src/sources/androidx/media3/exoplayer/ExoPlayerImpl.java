package androidx.media3.exoplayer;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.BasePlayer;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.AudioBecomingNoisyManager;
import androidx.media3.exoplayer.AudioFocusManager;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.ExoPlayerImplInternal;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.StreamVolumeManager;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.analytics.MediaMetricsListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.metadata.MetadataOutput;
import androidx.media3.exoplayer.source.MaskingMediaSource;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.source.TimelineWithUpdatedMediaItem;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelectionArray;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.util.EventLogger;
import androidx.media3.exoplayer.video.VideoDecoderOutputBufferRenderer;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.spherical.CameraMotionListener;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
final class ExoPlayerImpl extends BasePlayer implements ExoPlayer, ExoPlayer.AudioComponent, ExoPlayer.VideoComponent, ExoPlayer.TextComponent, ExoPlayer.DeviceComponent {
    public static final /* synthetic */ int n0 = 0;
    public final AudioBecomingNoisyManager A;
    public final AudioFocusManager B;
    public final WakeLockManager C;
    public final WifiLockManager D;
    public final long E;
    public int F;
    public boolean G;
    public int H;
    public int I;
    public boolean J;
    public ShuffleOrder K;
    public Player.Commands L;
    public MediaMetadata M;
    public MediaMetadata N;
    public Format O;
    public AudioTrack P;
    public Object Q;
    public Surface R;
    public SurfaceHolder S;
    public SphericalGLSurfaceView T;
    public boolean U;
    public TextureView V;
    public final int W;
    public Size X;
    public final int Y;
    public AudioAttributes Z;
    public float a0;

    /* renamed from: b, reason: collision with root package name */
    public final TrackSelectorResult f6197b;
    public boolean b0;

    /* renamed from: c, reason: collision with root package name */
    public final Player.Commands f6198c;
    public CueGroup c0;

    /* renamed from: d, reason: collision with root package name */
    public final ConditionVariable f6199d = new ConditionVariable();
    public final boolean d0;

    /* renamed from: e, reason: collision with root package name */
    public final Context f6200e;
    public boolean e0;

    /* renamed from: f, reason: collision with root package name */
    public final Player f6201f;
    public final int f0;

    /* renamed from: g, reason: collision with root package name */
    public final Renderer[] f6202g;
    public boolean g0;

    /* renamed from: h, reason: collision with root package name */
    public final TrackSelector f6203h;
    public final DeviceInfo h0;

    /* renamed from: i, reason: collision with root package name */
    public final HandlerWrapper f6204i;
    public VideoSize i0;

    /* renamed from: j, reason: collision with root package name */
    public final l f6205j;
    public MediaMetadata j0;

    /* renamed from: k, reason: collision with root package name */
    public final ExoPlayerImplInternal f6206k;
    public PlaybackInfo k0;

    /* renamed from: l, reason: collision with root package name */
    public final ListenerSet f6207l;
    public int l0;

    /* renamed from: m, reason: collision with root package name */
    public final CopyOnWriteArraySet f6208m;
    public long m0;
    public final Timeline.Period n;
    public final ArrayList o;
    public final boolean p;
    public final MediaSource.Factory q;
    public final AnalyticsCollector r;
    public final Looper s;
    public final BandwidthMeter t;
    public final long u;
    public final long v;
    public final long w;
    public final SystemClock x;
    public final ComponentListener y;
    public final FrameMetadataListener z;

    @RequiresApi
    public static final class Api23 {
        @DoNotInline
        public static boolean a(Context context, AudioDeviceInfo[] audioDeviceInfoArr) {
            int i2;
            if (Util.f5744a >= 20 && context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
                for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                    if (audioDeviceInfo.getType() != 8 && audioDeviceInfo.getType() != 5 && audioDeviceInfo.getType() != 6 && audioDeviceInfo.getType() != 11 && audioDeviceInfo.getType() != 4 && audioDeviceInfo.getType() != 3 && (((i2 = Util.f5744a) < 26 || audioDeviceInfo.getType() != 22) && ((i2 < 28 || audioDeviceInfo.getType() != 23) && ((i2 < 31 || (audioDeviceInfo.getType() != 26 && audioDeviceInfo.getType() != 27)) && (i2 < 33 || audioDeviceInfo.getType() != 30))))) {
                    }
                }
                return false;
            }
            return true;
        }

        @DoNotInline
        public static void b(AudioManager audioManager, AudioDeviceCallback audioDeviceCallback, Handler handler) {
            audioManager.registerAudioDeviceCallback(audioDeviceCallback, handler);
        }
    }

    @RequiresApi
    public static final class Api31 {
        @DoNotInline
        public static PlayerId a(Context context, ExoPlayerImpl exoPlayerImpl, boolean z, String str) {
            MediaMetricsManager mediaMetricsManagerF = androidx.core.os.a.f(context.getSystemService("media_metrics"));
            MediaMetricsListener mediaMetricsListener = mediaMetricsManagerF == null ? null : new MediaMetricsListener(context, mediaMetricsManagerF.createPlaybackSession());
            if (mediaMetricsListener == null) {
                Log.h("ExoPlayerImpl", "MediaMetricsService unavailable.");
                return new PlayerId(LogSessionId.LOG_SESSION_ID_NONE, str);
            }
            if (z) {
                exoPlayerImpl.getClass();
                exoPlayerImpl.r.P(mediaMetricsListener);
            }
            return new PlayerId(mediaMetricsListener.f6414c.getSessionId(), str);
        }
    }

    public final class ComponentListener implements VideoRendererEventListener, AudioRendererEventListener, TextOutput, MetadataOutput, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.VideoSurfaceListener, AudioFocusManager.PlayerControl, AudioBecomingNoisyManager.EventListener, StreamVolumeManager.Listener, ExoPlayer.AudioOffloadListener {
        public ComponentListener() {
        }

        @Override // androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView.VideoSurfaceListener
        public final void A() {
            int i2 = ExoPlayerImpl.n0;
            ExoPlayerImpl.this.P(null);
        }

        @Override // androidx.media3.exoplayer.AudioFocusManager.PlayerControl
        public final void B(int i2) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            exoPlayerImpl.S(i2, i2 == -1 ? 2 : 1, exoPlayerImpl.O0());
        }

        @Override // androidx.media3.exoplayer.AudioFocusManager.PlayerControl
        public final void C() {
            int i2 = ExoPlayerImpl.n0;
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            exoPlayerImpl.M(1, 2, Float.valueOf(exoPlayerImpl.a0 * exoPlayerImpl.B.f6108g));
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public final void a(AudioSink.AudioTrackConfig audioTrackConfig) {
            ExoPlayerImpl.this.r.a(audioTrackConfig);
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public final void b(VideoSize videoSize) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            exoPlayerImpl.i0 = videoSize;
            exoPlayerImpl.f6207l.f(25, new e(videoSize, 8));
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public final void c(AudioSink.AudioTrackConfig audioTrackConfig) {
            ExoPlayerImpl.this.r.c(audioTrackConfig);
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public final void d(boolean z) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            if (exoPlayerImpl.b0 == z) {
                return;
            }
            exoPlayerImpl.b0 = z;
            exoPlayerImpl.f6207l.f(23, new k(z, 1));
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public final void e(Exception exc) {
            ExoPlayerImpl.this.r.e(exc);
        }

        @Override // androidx.media3.exoplayer.text.TextOutput
        public final void e1(CueGroup cueGroup) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            exoPlayerImpl.c0 = cueGroup;
            exoPlayerImpl.f6207l.f(27, new e(cueGroup, 5));
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public final void f(String str) {
            ExoPlayerImpl.this.r.f(str);
        }

        @Override // androidx.media3.exoplayer.metadata.MetadataOutput
        public final void f1(Metadata metadata) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            MediaMetadata.Builder builderA = exoPlayerImpl.j0.a();
            int i2 = 0;
            while (true) {
                Metadata.Entry[] entryArr = metadata.f5405a;
                if (i2 >= entryArr.length) {
                    break;
                }
                entryArr[i2].A4(builderA);
                i2++;
            }
            exoPlayerImpl.j0 = new MediaMetadata(builderA);
            MediaMetadata mediaMetadataS = exoPlayerImpl.s();
            boolean zEquals = mediaMetadataS.equals(exoPlayerImpl.M);
            ListenerSet listenerSet = exoPlayerImpl.f6207l;
            if (!zEquals) {
                exoPlayerImpl.M = mediaMetadataS;
                listenerSet.c(14, new e(this, 3));
            }
            listenerSet.c(28, new e(metadata, 6));
            listenerSet.b();
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public final void g(String str) {
            ExoPlayerImpl.this.r.g(str);
        }

        @Override // androidx.media3.exoplayer.AudioBecomingNoisyManager.EventListener
        public final void h() {
            int i2 = ExoPlayerImpl.n0;
            ExoPlayerImpl.this.S(-1, 3, false);
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public final void i(DecoderCounters decoderCounters) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            exoPlayerImpl.getClass();
            exoPlayerImpl.r.i(decoderCounters);
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public final void j(DecoderCounters decoderCounters) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            exoPlayerImpl.getClass();
            exoPlayerImpl.r.j(decoderCounters);
        }

        @Override // androidx.media3.exoplayer.text.TextOutput
        public final void k(List list) {
            ExoPlayerImpl.this.f6207l.f(27, new e(list, 7));
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public final void l(long j2) {
            ExoPlayerImpl.this.r.l(j2);
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public final void m(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            exoPlayerImpl.getClass();
            exoPlayerImpl.r.m(format, decoderReuseEvaluation);
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public final void n(Exception exc) {
            ExoPlayerImpl.this.r.n(exc);
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public final void o(long j2, Object obj) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            exoPlayerImpl.r.o(j2, obj);
            if (exoPlayerImpl.Q == obj) {
                exoPlayerImpl.f6207l.f(26, new i(2));
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            int i4 = ExoPlayerImpl.n0;
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            exoPlayerImpl.getClass();
            Surface surface = new Surface(surfaceTexture);
            exoPlayerImpl.P(surface);
            exoPlayerImpl.R = surface;
            exoPlayerImpl.J(i2, i3);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            int i2 = ExoPlayerImpl.n0;
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            exoPlayerImpl.P(null);
            exoPlayerImpl.J(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            int i4 = ExoPlayerImpl.n0;
            ExoPlayerImpl.this.J(i2, i3);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public final void p(DecoderCounters decoderCounters) {
            ExoPlayerImpl.this.r.p(decoderCounters);
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public final void q(long j2, long j3, String str) {
            ExoPlayerImpl.this.r.q(j2, j3, str);
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public final void r(int i2, long j2) {
            ExoPlayerImpl.this.r.r(i2, j2);
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public final void s(long j2, long j3, int i2) {
            ExoPlayerImpl.this.r.s(j2, j3, i2);
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            int i5 = ExoPlayerImpl.n0;
            ExoPlayerImpl.this.J(i3, i4);
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            if (exoPlayerImpl.U) {
                exoPlayerImpl.P(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            if (exoPlayerImpl.U) {
                exoPlayerImpl.P(null);
            }
            exoPlayerImpl.J(0, 0);
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public final void t(int i2, long j2) {
            ExoPlayerImpl.this.r.t(i2, j2);
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public final void u(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            exoPlayerImpl.O = format;
            exoPlayerImpl.r.u(format, decoderReuseEvaluation);
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public final void v(DecoderCounters decoderCounters) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            exoPlayerImpl.r.v(decoderCounters);
            exoPlayerImpl.O = null;
        }

        @Override // androidx.media3.exoplayer.audio.AudioRendererEventListener
        public final void w(Exception exc) {
            ExoPlayerImpl.this.r.w(exc);
        }

        @Override // androidx.media3.exoplayer.video.VideoRendererEventListener
        public final void x(long j2, long j3, String str) {
            ExoPlayerImpl.this.r.x(j2, j3, str);
        }

        @Override // androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView.VideoSurfaceListener
        public final void y(Surface surface) {
            int i2 = ExoPlayerImpl.n0;
            ExoPlayerImpl.this.P(surface);
        }

        @Override // androidx.media3.exoplayer.ExoPlayer.AudioOffloadListener
        public final void z() {
            int i2 = ExoPlayerImpl.n0;
            ExoPlayerImpl.this.U();
        }
    }

    public static final class FrameMetadataListener implements VideoFrameMetadataListener, CameraMotionListener, PlayerMessage.Target {

        /* renamed from: a, reason: collision with root package name */
        public VideoFrameMetadataListener f6210a;

        /* renamed from: b, reason: collision with root package name */
        public CameraMotionListener f6211b;

        /* renamed from: c, reason: collision with root package name */
        public VideoFrameMetadataListener f6212c;

        /* renamed from: d, reason: collision with root package name */
        public CameraMotionListener f6213d;

        @Override // androidx.media3.exoplayer.video.spherical.CameraMotionListener
        public final void b(long j2, float[] fArr) {
            CameraMotionListener cameraMotionListener = this.f6213d;
            if (cameraMotionListener != null) {
                cameraMotionListener.b(j2, fArr);
            }
            CameraMotionListener cameraMotionListener2 = this.f6211b;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.b(j2, fArr);
            }
        }

        @Override // androidx.media3.exoplayer.video.spherical.CameraMotionListener
        public final void d() {
            CameraMotionListener cameraMotionListener = this.f6213d;
            if (cameraMotionListener != null) {
                cameraMotionListener.d();
            }
            CameraMotionListener cameraMotionListener2 = this.f6211b;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.d();
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoFrameMetadataListener
        public final void e(long j2, long j3, Format format, MediaFormat mediaFormat) {
            long j4;
            long j5;
            Format format2;
            MediaFormat mediaFormat2;
            VideoFrameMetadataListener videoFrameMetadataListener = this.f6212c;
            if (videoFrameMetadataListener != null) {
                videoFrameMetadataListener.e(j2, j3, format, mediaFormat);
                mediaFormat2 = mediaFormat;
                format2 = format;
                j5 = j3;
                j4 = j2;
            } else {
                j4 = j2;
                j5 = j3;
                format2 = format;
                mediaFormat2 = mediaFormat;
            }
            VideoFrameMetadataListener videoFrameMetadataListener2 = this.f6210a;
            if (videoFrameMetadataListener2 != null) {
                videoFrameMetadataListener2.e(j4, j5, format2, mediaFormat2);
            }
        }

        @Override // androidx.media3.exoplayer.PlayerMessage.Target
        public final void o(int i2, Object obj) {
            if (i2 == 7) {
                this.f6210a = (VideoFrameMetadataListener) obj;
                return;
            }
            if (i2 == 8) {
                this.f6211b = (CameraMotionListener) obj;
                return;
            }
            if (i2 != 10000) {
                return;
            }
            SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
            if (sphericalGLSurfaceView == null) {
                this.f6212c = null;
                this.f6213d = null;
            } else {
                this.f6212c = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.f6213d = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }
    }

    public static final class MediaSourceHolderSnapshot implements MediaSourceInfoHolder {

        /* renamed from: a, reason: collision with root package name */
        public final Object f6214a;

        /* renamed from: b, reason: collision with root package name */
        public final MaskingMediaSource f6215b;

        /* renamed from: c, reason: collision with root package name */
        public Timeline f6216c;

        public MediaSourceHolderSnapshot(Object obj, MaskingMediaSource maskingMediaSource) {
            this.f6214a = obj;
            this.f6215b = maskingMediaSource;
            this.f6216c = maskingMediaSource.o;
        }

        @Override // androidx.media3.exoplayer.MediaSourceInfoHolder
        public final Object a() {
            return this.f6214a;
        }

        @Override // androidx.media3.exoplayer.MediaSourceInfoHolder
        public final Timeline b() {
            return this.f6216c;
        }
    }

    @RequiresApi
    public final class NoSuitableOutputPlaybackSuppressionAudioDeviceCallback extends AudioDeviceCallback {
        @Override // android.media.AudioDeviceCallback
        public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            int i2 = ExoPlayerImpl.n0;
            throw null;
        }

        @Override // android.media.AudioDeviceCallback
        public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            int i2 = ExoPlayerImpl.n0;
            throw null;
        }
    }

    static {
        MediaLibraryInfo.a("media3.exoplayer");
    }

    public ExoPlayerImpl(ExoPlayer.Builder builder) {
        int i2 = 2;
        try {
            Log.g("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.4.1] [" + Util.f5748e + "]");
            Context context = builder.f6183a;
            Context applicationContext = context.getApplicationContext();
            this.f6200e = applicationContext;
            SystemClock systemClock = builder.f6184b;
            DefaultAnalyticsCollector defaultAnalyticsCollector = new DefaultAnalyticsCollector(systemClock);
            this.r = defaultAnalyticsCollector;
            this.f0 = builder.f6191i;
            this.Z = builder.f6192j;
            this.W = builder.f6193k;
            this.b0 = false;
            this.E = builder.s;
            ComponentListener componentListener = new ComponentListener();
            this.y = componentListener;
            this.z = new FrameMetadataListener();
            Handler handler = new Handler(builder.f6190h);
            Renderer[] rendererArrA = ((DefaultRenderersFactory) builder.f6185c.f7366b).a(handler, componentListener, componentListener, componentListener, componentListener);
            this.f6202g = rendererArrA;
            Assertions.g(rendererArrA.length > 0);
            TrackSelector trackSelector = (TrackSelector) builder.f6187e.get();
            this.f6203h = trackSelector;
            this.q = (MediaSource.Factory) builder.f6186d.get();
            BandwidthMeter bandwidthMeter = (BandwidthMeter) builder.f6189g.get();
            this.t = bandwidthMeter;
            this.p = builder.f6194l;
            SeekParameters seekParameters = builder.f6195m;
            this.u = builder.n;
            this.v = builder.o;
            this.w = builder.p;
            Looper looper = builder.f6190h;
            this.s = looper;
            this.x = systemClock;
            this.f6201f = this;
            this.f6207l = new ListenerSet(looper, systemClock, new l(this, i2));
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.f6208m = copyOnWriteArraySet;
            this.o = new ArrayList();
            this.K = new ShuffleOrder.DefaultShuffleOrder();
            TrackSelectorResult trackSelectorResult = new TrackSelectorResult(new RendererConfiguration[rendererArrA.length], new ExoTrackSelection[rendererArrA.length], Tracks.f5546b, null);
            this.f6197b = trackSelectorResult;
            this.n = new Timeline.Period();
            Player.Commands.Builder builder2 = new Player.Commands.Builder();
            builder2.f5434a.b(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32);
            trackSelector.getClass();
            builder2.c(29, trackSelector instanceof DefaultTrackSelector);
            builder2.c(23, false);
            builder2.c(25, false);
            builder2.c(33, false);
            builder2.c(26, false);
            builder2.c(34, false);
            Player.Commands commandsD = builder2.d();
            this.f6198c = commandsD;
            Player.Commands.Builder builder3 = new Player.Commands.Builder();
            FlagSet.Builder builder4 = builder3.f5434a;
            builder3.b(commandsD);
            builder4.a(4);
            builder4.a(10);
            this.L = builder3.d();
            this.f6204i = systemClock.a(looper, null);
            l lVar = new l(this, 3);
            this.f6205j = lVar;
            this.k0 = PlaybackInfo.i(trackSelectorResult);
            defaultAnalyticsCollector.b0(this, looper);
            int i3 = Util.f5744a;
            String str = builder.v;
            this.f6206k = new ExoPlayerImplInternal(rendererArrA, trackSelector, trackSelectorResult, (LoadControl) builder.f6188f.get(), bandwidthMeter, this.F, this.G, defaultAnalyticsCollector, seekParameters, builder.q, builder.r, looper, systemClock, lVar, i3 < 31 ? new PlayerId(str) : Api31.a(applicationContext, this, builder.t, str));
            this.a0 = 1.0f;
            this.F = 0;
            MediaMetadata mediaMetadata = MediaMetadata.J;
            this.M = mediaMetadata;
            this.N = mediaMetadata;
            this.j0 = mediaMetadata;
            this.l0 = -1;
            if (i3 < 21) {
                AudioTrack audioTrack = this.P;
                if (audioTrack != null && audioTrack.getAudioSessionId() != 0) {
                    this.P.release();
                    this.P = null;
                }
                if (this.P == null) {
                    this.P = new AudioTrack(3, 4000, 4, 2, 2, 0, 0);
                }
                this.Y = this.P.getAudioSessionId();
            } else {
                AudioManager audioManager = (AudioManager) this.f6200e.getSystemService("audio");
                this.Y = audioManager == null ? -1 : audioManager.generateAudioSessionId();
            }
            this.c0 = CueGroup.f5638c;
            this.d0 = true;
            D0(defaultAnalyticsCollector);
            bandwidthMeter.d(new Handler(looper), defaultAnalyticsCollector);
            copyOnWriteArraySet.add(componentListener);
            AudioBecomingNoisyManager audioBecomingNoisyManager = new AudioBecomingNoisyManager(context, handler, componentListener);
            this.A = audioBecomingNoisyManager;
            audioBecomingNoisyManager.a();
            AudioFocusManager audioFocusManager = new AudioFocusManager(context, handler, componentListener);
            this.B = audioFocusManager;
            audioFocusManager.b(null);
            WakeLockManager wakeLockManager = new WakeLockManager();
            context.getApplicationContext();
            this.C = wakeLockManager;
            WifiLockManager wifiLockManager = new WifiLockManager();
            context.getApplicationContext();
            this.D = wifiLockManager;
            DeviceInfo.Builder builder5 = new DeviceInfo.Builder(0);
            builder5.f5198b = 0;
            builder5.f5199c = 0;
            this.h0 = builder5.a();
            this.i0 = VideoSize.f5559e;
            this.X = Size.f5730c;
            this.f6203h.g(this.Z);
            M(1, 10, Integer.valueOf(this.Y));
            M(2, 10, Integer.valueOf(this.Y));
            M(1, 3, this.Z);
            M(2, 4, Integer.valueOf(this.W));
            M(2, 5, 0);
            M(1, 9, Boolean.valueOf(this.b0));
            M(2, 7, this.z);
            M(6, 8, this.z);
            M(-1, 16, Integer.valueOf(this.f0));
            this.f6199d.e();
        } catch (Throwable th) {
            this.f6199d.e();
            throw th;
        }
    }

    public static long B(PlaybackInfo playbackInfo) {
        Timeline.Window window = new Timeline.Window();
        Timeline.Period period = new Timeline.Period();
        playbackInfo.f6327a.g(playbackInfo.f6328b.f7609a, period);
        long j2 = playbackInfo.f6329c;
        if (j2 != -9223372036854775807L) {
            return period.f5479e + j2;
        }
        return playbackInfo.f6327a.m(period.f5477c, window, 0L).f5497l;
    }

    public final Pair A(Timeline timeline, Timeline timeline2, int i2, long j2) {
        if (timeline.p() || timeline2.p()) {
            boolean z = !timeline.p() && timeline2.p();
            return I(timeline2, z ? -1 : i2, z ? -9223372036854775807L : j2);
        }
        Pair pairI = timeline.i(this.f5161a, this.n, i2, Util.T(j2));
        Object obj = pairI.first;
        if (timeline2.b(obj) != -1) {
            return pairI;
        }
        int iK = ExoPlayerImplInternal.K(this.f5161a, this.n, this.F, this.G, obj, timeline, timeline2);
        if (iK == -1) {
            return I(timeline2, -1, -9223372036854775807L);
        }
        Timeline.Window window = this.f5161a;
        timeline2.m(iK, window, 0L);
        return I(timeline2, iK, Util.j0(window.f5497l));
    }

    @Override // androidx.media3.common.Player
    public final void A0(Player.Listener listener) {
        V();
        listener.getClass();
        this.f6207l.e(listener);
    }

    @Override // androidx.media3.common.Player
    public final long A1() {
        V();
        return this.u;
    }

    @Override // androidx.media3.common.Player
    public final int B0() {
        V();
        if (f0()) {
            return this.k0.f6328b.f7610b;
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public final void C0(boolean z) {
        V();
    }

    @Override // androidx.media3.common.Player
    public final void D(PlaybackParameters playbackParameters) {
        V();
        if (this.k0.o.equals(playbackParameters)) {
            return;
        }
        PlaybackInfo playbackInfoF = this.k0.f(playbackParameters);
        this.H++;
        this.f6206k.f6224h.e(4, playbackParameters).a();
        T(playbackInfoF, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // androidx.media3.common.Player
    public final void D0(Player.Listener listener) {
        listener.getClass();
        this.f6207l.a(listener);
    }

    @Override // androidx.media3.common.Player
    public final int E0() {
        V();
        return this.k0.n;
    }

    @Override // androidx.media3.common.Player
    public final PlaybackParameters F() {
        V();
        return this.k0.o;
    }

    @Override // androidx.media3.common.Player
    public final Timeline F0() {
        V();
        return this.k0.f6327a;
    }

    @Override // androidx.media3.common.Player
    public final Looper F1() {
        return this.s;
    }

    @Override // androidx.media3.common.Player
    public final int G() {
        V();
        return this.F;
    }

    @Override // androidx.media3.common.Player
    public final void G0() {
        V();
    }

    public final PlaybackInfo H(PlaybackInfo playbackInfo, Timeline timeline, Pair pair) {
        Assertions.a(timeline.p() || pair != null);
        Timeline timeline2 = playbackInfo.f6327a;
        long jX = x(playbackInfo);
        PlaybackInfo playbackInfoH = playbackInfo.h(timeline);
        if (timeline.p()) {
            MediaSource.MediaPeriodId mediaPeriodId = PlaybackInfo.u;
            long jT = Util.T(this.m0);
            PlaybackInfo playbackInfoB = playbackInfoH.c(mediaPeriodId, jT, jT, jT, 0L, TrackGroupArray.f7769d, this.f6197b, ImmutableList.r()).b(mediaPeriodId);
            playbackInfoB.q = playbackInfoB.s;
            return playbackInfoB;
        }
        Object obj = playbackInfoH.f6328b.f7609a;
        int i2 = Util.f5744a;
        boolean zEquals = obj.equals(pair.first);
        MediaSource.MediaPeriodId mediaPeriodId2 = !zEquals ? new MediaSource.MediaPeriodId(pair.first) : playbackInfoH.f6328b;
        long jLongValue = ((Long) pair.second).longValue();
        long jT2 = Util.T(jX);
        if (!timeline2.p()) {
            jT2 -= timeline2.g(obj, this.n).f5479e;
        }
        if (!zEquals || jLongValue < jT2) {
            MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodId2;
            Assertions.g(!mediaPeriodId3.b());
            PlaybackInfo playbackInfoB2 = playbackInfoH.c(mediaPeriodId3, jLongValue, jLongValue, jLongValue, 0L, !zEquals ? TrackGroupArray.f7769d : playbackInfoH.f6334h, !zEquals ? this.f6197b : playbackInfoH.f6335i, !zEquals ? ImmutableList.r() : playbackInfoH.f6336j).b(mediaPeriodId3);
            playbackInfoB2.q = jLongValue;
            return playbackInfoB2;
        }
        if (jLongValue != jT2) {
            MediaSource.MediaPeriodId mediaPeriodId4 = mediaPeriodId2;
            Assertions.g(!mediaPeriodId4.b());
            long jMax = Math.max(0L, playbackInfoH.r - (jLongValue - jT2));
            long j2 = playbackInfoH.q;
            if (playbackInfoH.f6337k.equals(playbackInfoH.f6328b)) {
                j2 = jLongValue + jMax;
            }
            PlaybackInfo playbackInfoC = playbackInfoH.c(mediaPeriodId4, jLongValue, jLongValue, jLongValue, jMax, playbackInfoH.f6334h, playbackInfoH.f6335i, playbackInfoH.f6336j);
            playbackInfoC.q = j2;
            return playbackInfoC;
        }
        int iB = timeline.b(playbackInfoH.f6337k.f7609a);
        if (iB != -1 && timeline.f(iB, this.n, false).f5477c == timeline.g(mediaPeriodId2.f7609a, this.n).f5477c) {
            return playbackInfoH;
        }
        timeline.g(mediaPeriodId2.f7609a, this.n);
        long jA = mediaPeriodId2.b() ? this.n.a(mediaPeriodId2.f7610b, mediaPeriodId2.f7611c) : this.n.f5478d;
        MediaSource.MediaPeriodId mediaPeriodId5 = mediaPeriodId2;
        PlaybackInfo playbackInfoB3 = playbackInfoH.c(mediaPeriodId5, playbackInfoH.s, playbackInfoH.s, playbackInfoH.f6330d, jA - playbackInfoH.s, playbackInfoH.f6334h, playbackInfoH.f6335i, playbackInfoH.f6336j).b(mediaPeriodId5);
        playbackInfoB3.q = jA;
        return playbackInfoB3;
    }

    @Override // androidx.media3.common.Player
    public final TrackSelectionParameters H0() {
        V();
        return this.f6203h.b();
    }

    public final Pair I(Timeline timeline, int i2, long j2) {
        if (timeline.p()) {
            this.l0 = i2;
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            this.m0 = j2;
            return null;
        }
        if (i2 == -1 || i2 >= timeline.o()) {
            i2 = timeline.a(this.G);
            j2 = Util.j0(timeline.m(i2, this.f5161a, 0L).f5497l);
        }
        return timeline.i(this.f5161a, this.n, i2, Util.T(j2));
    }

    public final void J(final int i2, final int i3) {
        Size size = this.X;
        if (i2 == size.f5731a && i3 == size.f5732b) {
            return;
        }
        this.X = new Size(i2, i3);
        this.f6207l.f(24, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.h
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                int i4 = ExoPlayerImpl.n0;
                ((Player.Listener) obj).s1(i2, i3);
            }
        });
        M(2, 14, new Size(i2, i3));
    }

    @Override // androidx.media3.common.Player
    public final void J0(TextureView textureView) {
        V();
        if (textureView == null) {
            t();
            return;
        }
        L();
        this.V = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            Log.h("ExoPlayerImpl", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.y);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            P(null);
            J(0, 0);
        } else {
            Surface surface = new Surface(surfaceTexture);
            P(surface);
            this.R = surface;
            J(textureView.getWidth(), textureView.getHeight());
        }
    }

    public final PlaybackInfo K(PlaybackInfo playbackInfo, int i2, int i3) {
        int iZ = z(playbackInfo);
        long jX = x(playbackInfo);
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        this.H++;
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            arrayList.remove(i4);
        }
        this.K = this.K.a(i2, i3);
        PlaylistTimeline playlistTimeline = new PlaylistTimeline(arrayList, this.K);
        PlaybackInfo playbackInfoH = H(playbackInfo, playlistTimeline, A(playbackInfo.f6327a, playlistTimeline, iZ, jX));
        int i5 = playbackInfoH.f6331e;
        if (i5 != 1 && i5 != 4 && i2 < i3 && i3 == size && iZ >= playbackInfoH.f6327a.o()) {
            playbackInfoH = playbackInfoH.g(4);
        }
        this.f6206k.f6224h.b(this.K, 20, i2, i3).a();
        return playbackInfoH;
    }

    @Override // androidx.media3.common.Player
    public final int K0() {
        V();
        return 0;
    }

    public final void L() {
        SphericalGLSurfaceView sphericalGLSurfaceView = this.T;
        ComponentListener componentListener = this.y;
        if (sphericalGLSurfaceView != null) {
            PlayerMessage playerMessageW = w(this.z);
            Assertions.g(!playerMessageW.f6346g);
            playerMessageW.f6343d = 10000;
            Assertions.g(!playerMessageW.f6346g);
            playerMessageW.f6344e = null;
            playerMessageW.c();
            this.T.f8418a.remove(componentListener);
            this.T = null;
        }
        TextureView textureView = this.V;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != componentListener) {
                Log.h("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.V.setSurfaceTextureListener(null);
            }
            this.V = null;
        }
        SurfaceHolder surfaceHolder = this.S;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(componentListener);
            this.S = null;
        }
    }

    public final void M(int i2, int i3, Object obj) {
        for (Renderer renderer : this.f6202g) {
            if (i2 == -1 || renderer.g() == i2) {
                PlayerMessage playerMessageW = w(renderer);
                Assertions.g(!playerMessageW.f6346g);
                playerMessageW.f6343d = i3;
                Assertions.g(!playerMessageW.f6346g);
                playerMessageW.f6344e = obj;
                playerMessageW.c();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void N(java.util.List r16, int r17, long r18, boolean r20) {
        /*
            r15 = this;
            r1 = r17
            androidx.media3.exoplayer.PlaybackInfo r2 = r15.k0
            int r2 = r15.z(r2)
            long r3 = r15.z1()
            int r5 = r15.H
            r6 = 1
            int r5 = r5 + r6
            r15.H = r5
            java.util.ArrayList r5 = r15.o
            boolean r7 = r5.isEmpty()
            r8 = 0
            if (r7 != 0) goto L31
            int r7 = r5.size()
            int r9 = r7 + (-1)
        L21:
            if (r9 < 0) goto L29
            r5.remove(r9)
            int r9 = r9 + (-1)
            goto L21
        L29:
            androidx.media3.exoplayer.source.ShuffleOrder r9 = r15.K
            androidx.media3.exoplayer.source.ShuffleOrder r7 = r9.a(r8, r7)
            r15.K = r7
        L31:
            r7 = r16
            java.util.ArrayList r10 = r15.q(r8, r7)
            androidx.media3.exoplayer.PlaylistTimeline r7 = new androidx.media3.exoplayer.PlaylistTimeline
            androidx.media3.exoplayer.source.ShuffleOrder r9 = r15.K
            r7.<init>(r5, r9)
            boolean r5 = r7.p()
            int r9 = r7.f6349h
            if (r5 != 0) goto L4f
            if (r1 >= r9) goto L49
            goto L4f
        L49:
            androidx.media3.common.IllegalSeekPositionException r1 = new androidx.media3.common.IllegalSeekPositionException
            r1.<init>()
            throw r1
        L4f:
            r5 = -1
            if (r20 == 0) goto L5f
            boolean r1 = r15.G
            int r1 = r7.a(r1)
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L5d:
            r12 = r1
            goto L67
        L5f:
            if (r1 != r5) goto L64
            r12 = r2
            r2 = r3
            goto L67
        L64:
            r2 = r18
            goto L5d
        L67:
            androidx.media3.exoplayer.PlaybackInfo r1 = r15.k0
            android.util.Pair r4 = r15.I(r7, r12, r2)
            androidx.media3.exoplayer.PlaybackInfo r1 = r15.H(r1, r7, r4)
            int r4 = r1.f6331e
            if (r12 == r5) goto L83
            if (r4 == r6) goto L83
            boolean r4 = r7.p()
            if (r4 != 0) goto L82
            if (r12 < r9) goto L80
            goto L82
        L80:
            r4 = 2
            goto L83
        L82:
            r4 = 4
        L83:
            androidx.media3.exoplayer.PlaybackInfo r1 = r1.g(r4)
            long r13 = androidx.media3.common.util.Util.T(r2)
            androidx.media3.exoplayer.source.ShuffleOrder r11 = r15.K
            androidx.media3.exoplayer.ExoPlayerImplInternal r2 = r15.f6206k
            r2.getClass()
            androidx.media3.exoplayer.ExoPlayerImplInternal$MediaSourceListUpdateMessage r9 = new androidx.media3.exoplayer.ExoPlayerImplInternal$MediaSourceListUpdateMessage
            r9.<init>(r10, r11, r12, r13)
            androidx.media3.common.util.HandlerWrapper r2 = r2.f6224h
            r3 = 17
            androidx.media3.common.util.HandlerWrapper$Message r2 = r2.e(r3, r9)
            r2.a()
            androidx.media3.exoplayer.PlaybackInfo r2 = r15.k0
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r2.f6328b
            java.lang.Object r2 = r2.f7609a
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = r1.f6328b
            java.lang.Object r3 = r3.f7609a
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto Lbe
            androidx.media3.exoplayer.PlaybackInfo r2 = r15.k0
            androidx.media3.common.Timeline r2 = r2.f6327a
            boolean r2 = r2.p()
            if (r2 != 0) goto Lbe
            r3 = r6
            goto Lbf
        Lbe:
            r3 = r8
        Lbf:
            long r5 = r15.y(r1)
            r2 = 0
            r4 = 4
            r7 = -1
            r8 = 0
            r0 = r15
            r0.T(r1, r2, r3, r4, r5, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImpl.N(java.util.List, int, long, boolean):void");
    }

    @Override // androidx.media3.common.Player
    public final Player.Commands N0() {
        V();
        return this.L;
    }

    public final void O(SurfaceHolder surfaceHolder) {
        this.U = false;
        this.S = surfaceHolder;
        surfaceHolder.addCallback(this.y);
        Surface surface = this.S.getSurface();
        if (surface == null || !surface.isValid()) {
            J(0, 0);
        } else {
            Rect surfaceFrame = this.S.getSurfaceFrame();
            J(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // androidx.media3.common.Player
    public final boolean O0() {
        V();
        return this.k0.f6338l;
    }

    public final void P(Object obj) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (Renderer renderer : this.f6202g) {
            if (renderer.g() == 2) {
                PlayerMessage playerMessageW = w(renderer);
                Assertions.g(!playerMessageW.f6346g);
                playerMessageW.f6343d = 1;
                Assertions.g(true ^ playerMessageW.f6346g);
                playerMessageW.f6344e = obj;
                playerMessageW.c();
                arrayList.add(playerMessageW);
            }
        }
        Object obj2 = this.Q;
        if (obj2 != null && obj2 != obj) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((PlayerMessage) it.next()).a(this.E);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z = true;
            }
            Object obj3 = this.Q;
            Surface surface = this.R;
            if (obj3 == surface) {
                surface.release();
                this.R = null;
            }
        }
        this.Q = obj;
        if (z) {
            Q(new ExoPlaybackException(2, new ExoTimeoutException("Detaching surface timed out."), 1003));
        }
    }

    @Override // androidx.media3.common.Player
    public final void P0(boolean z) {
        V();
        if (this.G != z) {
            this.G = z;
            this.f6206k.f6224h.g(12, z ? 1 : 0, 0).a();
            k kVar = new k(z, 0);
            ListenerSet listenerSet = this.f6207l;
            listenerSet.c(9, kVar);
            R();
            listenerSet.b();
        }
    }

    public final void Q(ExoPlaybackException exoPlaybackException) {
        PlaybackInfo playbackInfo = this.k0;
        PlaybackInfo playbackInfoB = playbackInfo.b(playbackInfo.f6328b);
        playbackInfoB.q = playbackInfoB.s;
        playbackInfoB.r = 0L;
        PlaybackInfo playbackInfoG = playbackInfoB.g(1);
        if (exoPlaybackException != null) {
            playbackInfoG = playbackInfoG.e(exoPlaybackException);
        }
        this.H++;
        this.f6206k.f6224h.c(6).a();
        T(playbackInfoG, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // androidx.media3.common.Player
    public final long Q0() {
        V();
        return this.w;
    }

    public final void R() {
        int i2 = 1;
        Player.Commands commands = this.L;
        int i3 = Util.f5744a;
        ExoPlayerImpl exoPlayerImpl = (ExoPlayerImpl) this.f6201f;
        boolean zF0 = exoPlayerImpl.f0();
        boolean zG1 = exoPlayerImpl.G1();
        boolean zL = exoPlayerImpl.l();
        boolean zK = exoPlayerImpl.k();
        boolean zH1 = exoPlayerImpl.H1();
        boolean zE1 = exoPlayerImpl.E1();
        boolean zP = exoPlayerImpl.F0().p();
        Player.Commands.Builder builder = new Player.Commands.Builder();
        builder.b(this.f6198c);
        boolean z = !zF0;
        builder.c(4, z);
        boolean z2 = false;
        builder.c(5, zG1 && !zF0);
        builder.c(6, zL && !zF0);
        builder.c(7, !zP && (zL || !zH1 || zG1) && !zF0);
        builder.c(8, zK && !zF0);
        builder.c(9, !zP && (zK || (zH1 && zE1)) && !zF0);
        builder.c(10, z);
        builder.c(11, zG1 && !zF0);
        if (zG1 && !zF0) {
            z2 = true;
        }
        builder.c(12, z2);
        Player.Commands commandsD = builder.d();
        this.L = commandsD;
        if (commandsD.equals(commands)) {
            return;
        }
        this.f6207l.c(13, new l(this, i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v4 */
    public final void S(int i2, int i3, boolean z) {
        ?? r14 = (!z || i2 == -1) ? 0 : 1;
        int i4 = i2 == 0 ? 1 : 0;
        PlaybackInfo playbackInfo = this.k0;
        if (playbackInfo.f6338l == r14 && playbackInfo.n == i4 && playbackInfo.f6339m == i3) {
            return;
        }
        this.H++;
        boolean z2 = playbackInfo.p;
        PlaybackInfo playbackInfoA = playbackInfo;
        if (z2) {
            playbackInfoA = playbackInfo.a();
        }
        PlaybackInfo playbackInfoD = playbackInfoA.d(i3, i4, r14);
        this.f6206k.f6224h.g(1, r14, (i4 << 4) | i3).a();
        T(playbackInfoD, 0, false, 5, -9223372036854775807L, -1, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03c6 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T(final androidx.media3.exoplayer.PlaybackInfo r34, final int r35, boolean r36, final int r37, long r38, int r40, boolean r41) {
        /*
            Method dump skipped, instructions count: 967
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImpl.T(androidx.media3.exoplayer.PlaybackInfo, int, boolean, int, long, int, boolean):void");
    }

    @Override // androidx.media3.common.Player
    public final int T0() {
        V();
        if (this.k0.f6327a.p()) {
            return 0;
        }
        PlaybackInfo playbackInfo = this.k0;
        return playbackInfo.f6327a.b(playbackInfo.f6328b.f7609a);
    }

    public final void U() {
        int iU = u();
        WifiLockManager wifiLockManager = this.D;
        WakeLockManager wakeLockManager = this.C;
        if (iU != 1) {
            if (iU == 2 || iU == 3) {
                V();
                boolean z = this.k0.p;
                O0();
                wakeLockManager.getClass();
                O0();
                wifiLockManager.getClass();
                return;
            }
            if (iU != 4) {
                throw new IllegalStateException();
            }
        }
        wakeLockManager.getClass();
        wifiLockManager.getClass();
    }

    @Override // androidx.media3.common.Player
    public final void U0(TextureView textureView) {
        V();
        if (textureView == null || textureView != this.V) {
            return;
        }
        t();
    }

    public final void V() {
        ConditionVariable conditionVariable = this.f6199d;
        synchronized (conditionVariable) {
            boolean z = false;
            while (!conditionVariable.f5670b) {
                try {
                    conditionVariable.wait();
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
        Thread threadCurrentThread = Thread.currentThread();
        Looper looper = this.s;
        if (threadCurrentThread != looper.getThread()) {
            String name = Thread.currentThread().getName();
            String name2 = looper.getThread().getName();
            int i2 = Util.f5744a;
            Locale locale = Locale.US;
            String strM = android.support.v4.media.b.m("Player is accessed on the wrong thread.\nCurrent thread: '", name, "'\nExpected thread: '", name2, "'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread");
            if (this.d0) {
                throw new IllegalStateException(strM);
            }
            Log.i("ExoPlayerImpl", strM, this.e0 ? null : new IllegalStateException());
            this.e0 = true;
        }
    }

    @Override // androidx.media3.common.Player
    public final VideoSize V0() {
        V();
        return this.i0;
    }

    @Override // androidx.media3.common.Player
    public final void W0(AudioAttributes audioAttributes, boolean z) {
        V();
        if (this.g0) {
            return;
        }
        boolean zA = Util.a(this.Z, audioAttributes);
        ListenerSet listenerSet = this.f6207l;
        if (!zA) {
            this.Z = audioAttributes;
            M(1, 3, audioAttributes);
            listenerSet.c(20, new e(audioAttributes, 1));
        }
        AudioAttributes audioAttributes2 = z ? audioAttributes : null;
        AudioFocusManager audioFocusManager = this.B;
        audioFocusManager.b(audioAttributes2);
        this.f6203h.g(audioAttributes);
        boolean zO0 = O0();
        int iD = audioFocusManager.d(u(), zO0);
        S(iD, iD == -1 ? 2 : 1, zO0);
        listenerSet.b();
    }

    @Override // androidx.media3.common.Player
    public final AudioAttributes X0() {
        V();
        return this.Z;
    }

    @Override // androidx.media3.common.Player
    public final DeviceInfo Y0() {
        V();
        return this.h0;
    }

    @Override // androidx.media3.common.Player
    public final void Z0(int i2, int i3) {
        V();
    }

    @Override // androidx.media3.common.Player
    public final int a1() {
        V();
        if (f0()) {
            return this.k0.f6328b.f7611c;
        }
        return -1;
    }

    @Override // androidx.media3.common.Player
    public final boolean b() {
        V();
        return this.k0.f6333g;
    }

    @Override // androidx.media3.common.Player
    public final void b1(float f2) {
        V();
        final float fJ = Util.j(f2, 0.0f, 1.0f);
        if (this.a0 == fJ) {
            return;
        }
        this.a0 = fJ;
        M(1, 2, Float.valueOf(this.B.f6108g * fJ));
        this.f6207l.f(22, new ListenerSet.Event() { // from class: androidx.media3.exoplayer.g
            @Override // androidx.media3.common.util.ListenerSet.Event
            public final void invoke(Object obj) {
                int i2 = ExoPlayerImpl.n0;
                ((Player.Listener) obj).z1(fJ);
            }
        });
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final void c(MediaSource mediaSource, boolean z) {
        V();
        List listSingletonList = Collections.singletonList(mediaSource);
        V();
        N(listSingletonList, -1, -9223372036854775807L, z);
    }

    @Override // androidx.media3.common.Player
    public final void c1(List list, int i2, long j2) {
        V();
        ArrayList arrayListV = v(list);
        V();
        N(arrayListV, i2, j2, false);
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final void d(MediaSource mediaSource, long j2) {
        V();
        List listSingletonList = Collections.singletonList(mediaSource);
        V();
        N(listSingletonList, 0, j2, false);
    }

    @Override // androidx.media3.common.Player
    public final void d0(final int i2) {
        V();
        if (this.F != i2) {
            this.F = i2;
            this.f6206k.f6224h.g(11, i2, 0).a();
            ListenerSet.Event event = new ListenerSet.Event() { // from class: androidx.media3.exoplayer.j
                @Override // androidx.media3.common.util.ListenerSet.Event
                public final void invoke(Object obj) {
                    int i3 = ExoPlayerImpl.n0;
                    ((Player.Listener) obj).d1(i2);
                }
            };
            ListenerSet listenerSet = this.f6207l;
            listenerSet.c(8, event);
            R();
            listenerSet.b();
        }
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final void e(AnalyticsListener analyticsListener) {
        V();
        analyticsListener.getClass();
        this.r.Y(analyticsListener);
    }

    @Override // androidx.media3.common.Player
    public final void e0(Surface surface) {
        V();
        L();
        P(surface);
        int i2 = surface == null ? 0 : -1;
        J(i2, i2);
    }

    @Override // androidx.media3.common.Player
    public final long e1() {
        V();
        return this.v;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final Format f() {
        V();
        return this.O;
    }

    @Override // androidx.media3.common.Player
    public final boolean f0() {
        V();
        return this.k0.f6328b.b();
    }

    @Override // androidx.media3.common.Player
    public final long f1() {
        V();
        return x(this.k0);
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final TrackSelectionArray g() {
        V();
        return new TrackSelectionArray(this.k0.f6335i.f8041c);
    }

    @Override // androidx.media3.common.Player
    public final long g0() {
        V();
        return Util.j0(this.k0.r);
    }

    @Override // androidx.media3.common.Player
    public final void g1(int i2, List list) {
        V();
        ArrayList arrayListV = v(list);
        V();
        Assertions.a(i2 >= 0);
        ArrayList arrayList = this.o;
        int iMin = Math.min(i2, arrayList.size());
        if (!arrayList.isEmpty()) {
            T(r(this.k0, iMin, arrayListV), 0, false, 5, -9223372036854775807L, -1, false);
            return;
        }
        boolean z = this.l0 == -1;
        V();
        N(arrayListV, -1, -9223372036854775807L, z);
    }

    @Override // androidx.media3.common.Player
    public final long getDuration() {
        V();
        if (!f0()) {
            return S0();
        }
        PlaybackInfo playbackInfo = this.k0;
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.f6328b;
        Object obj = mediaPeriodId.f7609a;
        Timeline timeline = playbackInfo.f6327a;
        Timeline.Period period = this.n;
        timeline.g(obj, period);
        return Util.j0(period.a(mediaPeriodId.f7610b, mediaPeriodId.f7611c));
    }

    @Override // androidx.media3.common.Player
    public final float getVolume() {
        V();
        return this.a0;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final int h(int i2) {
        V();
        return this.f6202g[i2].g();
    }

    @Override // androidx.media3.common.Player
    public final long h1() {
        V();
        if (!f0()) {
            return t1();
        }
        PlaybackInfo playbackInfo = this.k0;
        return playbackInfo.f6337k.equals(playbackInfo.f6328b) ? Util.j0(this.k0.q) : getDuration();
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final int i() {
        V();
        return this.f6202g.length;
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata i1() {
        V();
        return this.N;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final void j(EventLogger eventLogger) {
        this.r.P(eventLogger);
    }

    @Override // androidx.media3.common.Player
    public final void l0(int i2, boolean z) {
        V();
    }

    @Override // androidx.media3.common.Player
    public final int l1() {
        V();
        int iZ = z(this.k0);
        if (iZ == -1) {
            return 0;
        }
        return iZ;
    }

    @Override // androidx.media3.common.Player
    public final void m0() {
        V();
    }

    @Override // androidx.media3.common.Player
    public final void m1(TrackSelectionParameters trackSelectionParameters) {
        V();
        TrackSelector trackSelector = this.f6203h;
        trackSelector.getClass();
        if (!(trackSelector instanceof DefaultTrackSelector) || trackSelectionParameters.equals(trackSelector.b())) {
            return;
        }
        trackSelector.h(trackSelectionParameters);
        this.f6207l.f(19, new e(trackSelectionParameters, 2));
    }

    @Override // androidx.media3.common.BasePlayer
    public final void n(int i2, long j2, boolean z) {
        V();
        if (i2 == -1) {
            return;
        }
        Assertions.a(i2 >= 0);
        Timeline timeline = this.k0.f6327a;
        if (timeline.p() || i2 < timeline.o()) {
            this.r.A();
            this.H++;
            if (f0()) {
                Log.h("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate = new ExoPlayerImplInternal.PlaybackInfoUpdate(this.k0);
                playbackInfoUpdate.a(1);
                this.f6205j.a(playbackInfoUpdate);
                return;
            }
            PlaybackInfo playbackInfoG = this.k0;
            int i3 = playbackInfoG.f6331e;
            if (i3 == 3 || (i3 == 4 && !timeline.p())) {
                playbackInfoG = this.k0.g(2);
            }
            int iL1 = l1();
            PlaybackInfo playbackInfoH = H(playbackInfoG, timeline, I(timeline, i2, j2));
            long jT = Util.T(j2);
            ExoPlayerImplInternal exoPlayerImplInternal = this.f6206k;
            exoPlayerImplInternal.getClass();
            exoPlayerImplInternal.f6224h.e(3, new ExoPlayerImplInternal.SeekPosition(timeline, i2, jT)).a();
            T(playbackInfoH, 0, true, 1, y(playbackInfoH), iL1, z);
        }
    }

    @Override // androidx.media3.common.Player
    public final void n0(int i2) {
        V();
    }

    @Override // androidx.media3.common.Player
    public final void n1(SurfaceView surfaceView) {
        V();
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        V();
        if (holder == null || holder != this.S) {
            return;
        }
        t();
    }

    @Override // androidx.media3.common.Player
    public final void o0(SurfaceView surfaceView) {
        V();
        if (surfaceView instanceof VideoDecoderOutputBufferRenderer) {
            L();
            P(surfaceView);
            O(surfaceView.getHolder());
            return;
        }
        boolean z = surfaceView instanceof SphericalGLSurfaceView;
        ComponentListener componentListener = this.y;
        if (z) {
            L();
            this.T = (SphericalGLSurfaceView) surfaceView;
            PlayerMessage playerMessageW = w(this.z);
            Assertions.g(!playerMessageW.f6346g);
            playerMessageW.f6343d = 10000;
            SphericalGLSurfaceView sphericalGLSurfaceView = this.T;
            Assertions.g(true ^ playerMessageW.f6346g);
            playerMessageW.f6344e = sphericalGLSurfaceView;
            playerMessageW.c();
            this.T.f8418a.add(componentListener);
            P(this.T.getVideoSurface());
            O(surfaceView.getHolder());
            return;
        }
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        V();
        if (holder == null) {
            t();
            return;
        }
        L();
        this.U = true;
        this.S = holder;
        holder.addCallback(componentListener);
        Surface surface = holder.getSurface();
        if (surface == null || !surface.isValid()) {
            P(null);
            J(0, 0);
        } else {
            P(surface);
            Rect surfaceFrame = holder.getSurfaceFrame();
            J(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // androidx.media3.common.Player
    public final void p() {
        V();
        boolean zO0 = O0();
        int iD = this.B.d(2, zO0);
        S(iD, iD == -1 ? 2 : 1, zO0);
        PlaybackInfo playbackInfo = this.k0;
        if (playbackInfo.f6331e != 1) {
            return;
        }
        PlaybackInfo playbackInfoE = playbackInfo.e(null);
        PlaybackInfo playbackInfoG = playbackInfoE.g(playbackInfoE.f6327a.p() ? 4 : 2);
        this.H++;
        this.f6206k.f6224h.c(29).a();
        T(playbackInfoG, 1, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // androidx.media3.common.Player
    public final void p0(int i2, int i3, List list) {
        V();
        Assertions.a(i2 >= 0 && i3 >= i2);
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        if (i2 > size) {
            return;
        }
        int iMin = Math.min(i3, size);
        if (iMin - i2 == list.size()) {
            for (int i4 = i2; i4 < iMin; i4++) {
                if (((MediaSourceHolderSnapshot) arrayList.get(i4)).f6215b.f7774k.c0((MediaItem) list.get(i4 - i2))) {
                }
            }
            this.H++;
            this.f6206k.f6224h.b(list, 27, i2, iMin).a();
            for (int i5 = i2; i5 < iMin; i5++) {
                MediaSourceHolderSnapshot mediaSourceHolderSnapshot = (MediaSourceHolderSnapshot) arrayList.get(i5);
                mediaSourceHolderSnapshot.f6216c = new TimelineWithUpdatedMediaItem(mediaSourceHolderSnapshot.f6216c, (MediaItem) list.get(i5 - i2));
            }
            T(this.k0.h(new PlaylistTimeline(arrayList, this.K)), 0, false, 4, -9223372036854775807L, -1, false);
            return;
        }
        ArrayList arrayListV = v(list);
        if (!arrayList.isEmpty()) {
            PlaybackInfo playbackInfoK = K(r(this.k0, iMin, arrayListV), i2, iMin);
            T(playbackInfoK, 0, !playbackInfoK.f6328b.f7609a.equals(this.k0.f6328b.f7609a), 4, y(playbackInfoK), -1, false);
        } else {
            boolean z = this.l0 == -1;
            V();
            N(arrayListV, -1, -9223372036854775807L, z);
        }
    }

    @Override // androidx.media3.common.Player
    public final void p1(int i2, int i3, int i4) {
        V();
        Assertions.a(i2 >= 0 && i2 <= i3 && i4 >= 0);
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        int iMin = Math.min(i3, size);
        int iMin2 = Math.min(i4, size - (iMin - i2));
        if (i2 >= size || i2 == iMin || i2 == iMin2) {
            return;
        }
        Timeline timelineF0 = F0();
        this.H++;
        Util.S(arrayList, i2, iMin, iMin2);
        PlaylistTimeline playlistTimeline = new PlaylistTimeline(arrayList, this.K);
        PlaybackInfo playbackInfo = this.k0;
        PlaybackInfo playbackInfoH = H(playbackInfo, playlistTimeline, A(timelineF0, playlistTimeline, z(playbackInfo), x(this.k0)));
        ShuffleOrder shuffleOrder = this.K;
        ExoPlayerImplInternal exoPlayerImplInternal = this.f6206k;
        exoPlayerImplInternal.getClass();
        exoPlayerImplInternal.f6224h.e(19, new ExoPlayerImplInternal.MoveMediaItemsMessage(i2, iMin, iMin2, shuffleOrder)).a();
        T(playbackInfoH, 0, false, 5, -9223372036854775807L, -1, false);
    }

    public final ArrayList q(int i2, List list) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            MediaSourceList.MediaSourceHolder mediaSourceHolder = new MediaSourceList.MediaSourceHolder((MediaSource) list.get(i3), this.p);
            arrayList.add(mediaSourceHolder);
            this.o.add(i3 + i2, new MediaSourceHolderSnapshot(mediaSourceHolder.f6320b, mediaSourceHolder.f6319a));
        }
        this.K = this.K.g(i2, arrayList.size());
        return arrayList;
    }

    @Override // androidx.media3.common.Player
    public final void q0(MediaMetadata mediaMetadata) {
        V();
        if (mediaMetadata.equals(this.N)) {
            return;
        }
        this.N = mediaMetadata;
        this.f6207l.f(15, new l(this, 0));
    }

    public final PlaybackInfo r(PlaybackInfo playbackInfo, int i2, ArrayList arrayList) {
        Timeline timeline = playbackInfo.f6327a;
        this.H++;
        ArrayList arrayListQ = q(i2, arrayList);
        PlaylistTimeline playlistTimeline = new PlaylistTimeline(this.o, this.K);
        PlaybackInfo playbackInfoH = H(playbackInfo, playlistTimeline, A(timeline, playlistTimeline, z(playbackInfo), x(playbackInfo)));
        ShuffleOrder shuffleOrder = this.K;
        ExoPlayerImplInternal exoPlayerImplInternal = this.f6206k;
        exoPlayerImplInternal.getClass();
        exoPlayerImplInternal.f6224h.b(new ExoPlayerImplInternal.MediaSourceListUpdateMessage(arrayListQ, shuffleOrder, -1, -9223372036854775807L), 18, i2, 0).a();
        return playbackInfoH;
    }

    @Override // androidx.media3.common.Player
    public final boolean r1() {
        V();
        return false;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final void release() {
        String str;
        boolean z;
        AudioTrack audioTrack;
        int i2 = 0;
        StringBuilder sb = new StringBuilder("Release ");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" [AndroidXMedia3/1.4.1] [");
        sb.append(Util.f5748e);
        sb.append("] [");
        HashSet hashSet = MediaLibraryInfo.f5377a;
        synchronized (MediaLibraryInfo.class) {
            str = MediaLibraryInfo.f5378b;
        }
        sb.append(str);
        sb.append("]");
        Log.g("ExoPlayerImpl", sb.toString());
        V();
        if (Util.f5744a < 21 && (audioTrack = this.P) != null) {
            audioTrack.release();
            this.P = null;
        }
        this.A.a();
        this.C.getClass();
        this.D.getClass();
        AudioFocusManager audioFocusManager = this.B;
        audioFocusManager.f6104c = null;
        audioFocusManager.a();
        audioFocusManager.c(0);
        ExoPlayerImplInternal exoPlayerImplInternal = this.f6206k;
        synchronized (exoPlayerImplInternal) {
            if (exoPlayerImplInternal.A || !exoPlayerImplInternal.f6226j.getThread().isAlive()) {
                z = true;
            } else {
                exoPlayerImplInternal.f6224h.k(7);
                exoPlayerImplInternal.m0(new o(exoPlayerImplInternal, i2), exoPlayerImplInternal.v);
                z = exoPlayerImplInternal.A;
            }
        }
        if (!z) {
            this.f6207l.f(10, new i(i2));
        }
        this.f6207l.d();
        this.f6204i.d();
        this.t.a(this.r);
        PlaybackInfo playbackInfo = this.k0;
        if (playbackInfo.p) {
            this.k0 = playbackInfo.a();
        }
        PlaybackInfo playbackInfoG = this.k0.g(1);
        this.k0 = playbackInfoG;
        PlaybackInfo playbackInfoB = playbackInfoG.b(playbackInfoG.f6328b);
        this.k0 = playbackInfoB;
        playbackInfoB.q = playbackInfoB.s;
        this.k0.r = 0L;
        this.r.release();
        this.f6203h.e();
        L();
        Surface surface = this.R;
        if (surface != null) {
            surface.release();
            this.R = null;
        }
        this.c0 = CueGroup.f5638c;
        this.g0 = true;
    }

    public final MediaMetadata s() {
        Timeline timelineF0 = F0();
        if (timelineF0.p()) {
            return this.j0;
        }
        MediaItem mediaItem = timelineF0.m(l1(), this.f5161a, 0L).f5488c;
        MediaMetadata.Builder builderA = this.j0.a();
        MediaMetadata mediaMetadata = mediaItem.f5260d;
        builderA.getClass();
        if (mediaMetadata != null) {
            CharSequence charSequence = mediaMetadata.f5379a;
            if (charSequence != null) {
                builderA.f5392a = charSequence;
            }
            CharSequence charSequence2 = mediaMetadata.f5380b;
            if (charSequence2 != null) {
                builderA.f5393b = charSequence2;
            }
            CharSequence charSequence3 = mediaMetadata.f5381c;
            if (charSequence3 != null) {
                builderA.f5394c = charSequence3;
            }
            CharSequence charSequence4 = mediaMetadata.f5382d;
            if (charSequence4 != null) {
                builderA.f5395d = charSequence4;
            }
            CharSequence charSequence5 = mediaMetadata.f5383e;
            if (charSequence5 != null) {
                builderA.f5396e = charSequence5;
            }
            CharSequence charSequence6 = mediaMetadata.f5384f;
            if (charSequence6 != null) {
                builderA.f5397f = charSequence6;
            }
            CharSequence charSequence7 = mediaMetadata.f5385g;
            if (charSequence7 != null) {
                builderA.f5398g = charSequence7;
            }
            Long l2 = mediaMetadata.f5386h;
            if (l2 != null) {
                builderA.c(l2);
            }
            Rating rating = mediaMetadata.f5387i;
            if (rating != null) {
                builderA.f5400i = rating;
            }
            Rating rating2 = mediaMetadata.f5388j;
            if (rating2 != null) {
                builderA.f5401j = rating2;
            }
            byte[] bArr = mediaMetadata.f5389k;
            Uri uri = mediaMetadata.f5391m;
            if (uri != null || bArr != null) {
                builderA.f5404m = uri;
                builderA.b(bArr, mediaMetadata.f5390l);
            }
            Integer num = mediaMetadata.n;
            if (num != null) {
                builderA.n = num;
            }
            Integer num2 = mediaMetadata.o;
            if (num2 != null) {
                builderA.o = num2;
            }
            Integer num3 = mediaMetadata.p;
            if (num3 != null) {
                builderA.p = num3;
            }
            Boolean bool = mediaMetadata.q;
            if (bool != null) {
                builderA.q = bool;
            }
            Boolean bool2 = mediaMetadata.r;
            if (bool2 != null) {
                builderA.r = bool2;
            }
            Integer num4 = mediaMetadata.s;
            if (num4 != null) {
                builderA.s = num4;
            }
            Integer num5 = mediaMetadata.t;
            if (num5 != null) {
                builderA.s = num5;
            }
            Integer num6 = mediaMetadata.u;
            if (num6 != null) {
                builderA.t = num6;
            }
            Integer num7 = mediaMetadata.v;
            if (num7 != null) {
                builderA.u = num7;
            }
            Integer num8 = mediaMetadata.w;
            if (num8 != null) {
                builderA.v = num8;
            }
            Integer num9 = mediaMetadata.x;
            if (num9 != null) {
                builderA.w = num9;
            }
            Integer num10 = mediaMetadata.y;
            if (num10 != null) {
                builderA.x = num10;
            }
            CharSequence charSequence8 = mediaMetadata.z;
            if (charSequence8 != null) {
                builderA.y = charSequence8;
            }
            CharSequence charSequence9 = mediaMetadata.A;
            if (charSequence9 != null) {
                builderA.z = charSequence9;
            }
            CharSequence charSequence10 = mediaMetadata.B;
            if (charSequence10 != null) {
                builderA.A = charSequence10;
            }
            Integer num11 = mediaMetadata.C;
            if (num11 != null) {
                builderA.B = num11;
            }
            Integer num12 = mediaMetadata.D;
            if (num12 != null) {
                builderA.C = num12;
            }
            CharSequence charSequence11 = mediaMetadata.E;
            if (charSequence11 != null) {
                builderA.D = charSequence11;
            }
            CharSequence charSequence12 = mediaMetadata.F;
            if (charSequence12 != null) {
                builderA.E = charSequence12;
            }
            CharSequence charSequence13 = mediaMetadata.G;
            if (charSequence13 != null) {
                builderA.F = charSequence13;
            }
            Integer num13 = mediaMetadata.H;
            if (num13 != null) {
                builderA.G = num13;
            }
            Bundle bundle = mediaMetadata.I;
            if (bundle != null) {
                builderA.H = bundle;
            }
        }
        return new MediaMetadata(builderA);
    }

    @Override // androidx.media3.common.Player
    public final void s0(int i2, int i3) {
        V();
        Assertions.a(i2 >= 0 && i3 >= i2);
        int size = this.o.size();
        int iMin = Math.min(i3, size);
        if (i2 >= size || i2 == iMin) {
            return;
        }
        PlaybackInfo playbackInfoK = K(this.k0, i2, iMin);
        T(playbackInfoK, 0, !playbackInfoK.f6328b.f7609a.equals(this.k0.f6328b.f7609a), 4, y(playbackInfoK), -1, false);
    }

    @Override // androidx.media3.common.Player
    public final boolean s1() {
        V();
        return this.G;
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public final void setImageOutput(ImageOutput imageOutput) {
        V();
        M(4, 15, imageOutput);
    }

    @Override // androidx.media3.common.Player
    public final void stop() {
        V();
        this.B.d(1, O0());
        Q(null);
        this.c0 = new CueGroup(this.k0.s, ImmutableList.r());
    }

    public final void t() {
        V();
        L();
        P(null);
        J(0, 0);
    }

    @Override // androidx.media3.common.Player
    public final long t1() {
        V();
        if (this.k0.f6327a.p()) {
            return this.m0;
        }
        PlaybackInfo playbackInfo = this.k0;
        if (playbackInfo.f6337k.f7612d != playbackInfo.f6328b.f7612d) {
            return Util.j0(playbackInfo.f6327a.m(l1(), this.f5161a, 0L).f5498m);
        }
        long j2 = playbackInfo.q;
        if (this.k0.f6337k.b()) {
            PlaybackInfo playbackInfo2 = this.k0;
            Timeline.Period periodG = playbackInfo2.f6327a.g(playbackInfo2.f6337k.f7609a, this.n);
            long jB = periodG.b(this.k0.f6337k.f7610b);
            j2 = jB == Long.MIN_VALUE ? periodG.f5478d : jB;
        }
        PlaybackInfo playbackInfo3 = this.k0;
        Timeline timeline = playbackInfo3.f6327a;
        Object obj = playbackInfo3.f6337k.f7609a;
        Timeline.Period period = this.n;
        timeline.g(obj, period);
        return Util.j0(j2 + period.f5479e);
    }

    @Override // androidx.media3.common.Player
    public final int u() {
        V();
        return this.k0.f6331e;
    }

    @Override // androidx.media3.common.Player
    public final void u0(boolean z) {
        V();
        int iD = this.B.d(u(), z);
        S(iD, iD == -1 ? 2 : 1, z);
    }

    @Override // androidx.media3.common.Player
    public final void u1(int i2) {
        V();
    }

    public final ArrayList v(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(this.q.a((MediaItem) list.get(i2)));
        }
        return arrayList;
    }

    public final PlayerMessage w(PlayerMessage.Target target) {
        int iZ = z(this.k0);
        Timeline timeline = this.k0.f6327a;
        if (iZ == -1) {
            iZ = 0;
        }
        ExoPlayerImplInternal exoPlayerImplInternal = this.f6206k;
        return new PlayerMessage(exoPlayerImplInternal, target, timeline, iZ, this.x, exoPlayerImplInternal.f6226j);
    }

    public final long x(PlaybackInfo playbackInfo) {
        if (!playbackInfo.f6328b.b()) {
            return Util.j0(y(playbackInfo));
        }
        Object obj = playbackInfo.f6328b.f7609a;
        Timeline timeline = playbackInfo.f6327a;
        Timeline.Period period = this.n;
        timeline.g(obj, period);
        long j2 = playbackInfo.f6329c;
        if (j2 == -9223372036854775807L) {
            return Util.j0(timeline.m(z(playbackInfo), this.f5161a, 0L).f5497l);
        }
        return Util.j0(j2) + Util.j0(period.f5479e);
    }

    @Override // androidx.media3.common.Player
    public final void x0(int i2) {
        V();
    }

    @Override // androidx.media3.common.Player
    public final MediaMetadata x1() {
        V();
        return this.M;
    }

    public final long y(PlaybackInfo playbackInfo) {
        if (playbackInfo.f6327a.p()) {
            return Util.T(this.m0);
        }
        long j2 = playbackInfo.p ? playbackInfo.j() : playbackInfo.s;
        if (playbackInfo.f6328b.b()) {
            return j2;
        }
        Timeline timeline = playbackInfo.f6327a;
        Object obj = playbackInfo.f6328b.f7609a;
        Timeline.Period period = this.n;
        timeline.g(obj, period);
        return j2 + period.f5479e;
    }

    @Override // androidx.media3.common.Player
    public final Tracks y0() {
        V();
        return this.k0.f6335i.f8042d;
    }

    @Override // androidx.media3.common.Player
    public final void y1(List list) {
        V();
        ArrayList arrayListV = v(list);
        V();
        N(arrayListV, -1, -9223372036854775807L, true);
    }

    public final int z(PlaybackInfo playbackInfo) {
        if (playbackInfo.f6327a.p()) {
            return this.l0;
        }
        return playbackInfo.f6327a.g(playbackInfo.f6328b.f7609a, this.n).f5477c;
    }

    @Override // androidx.media3.common.Player
    public final CueGroup z0() {
        V();
        return this.c0;
    }

    @Override // androidx.media3.common.Player
    public final long z1() {
        V();
        return Util.j0(y(this.k0));
    }

    @Override // androidx.media3.common.Player
    public final ExoPlaybackException a() {
        V();
        return this.k0.f6332f;
    }
}
