package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.RendererConfiguration;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.video.CompositingVideoSinkProvider;
import androidx.media3.exoplayer.video.VideoFrameReleaseControl;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.VideoSink;
import com.google.android.gms.common.Scopes;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import org.xbill.DNS.SimpleResolver;

@UnstableApi
/* loaded from: classes3.dex */
public class MediaCodecVideoRenderer extends MediaCodecRenderer implements VideoFrameReleaseControl.FrameTimingEvaluator {
    public static final int[] U1 = {1920, 1600, 1440, SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE, 960, 854, 640, 540, 480};
    public static boolean V1;
    public static boolean W1;
    public List A1;
    public Surface B1;
    public PlaceholderSurface C1;
    public Size D1;
    public boolean E1;
    public int F1;
    public long G1;
    public int H1;
    public int I1;
    public int J1;
    public long K1;
    public int L1;
    public long M1;
    public VideoSize N1;
    public VideoSize O1;
    public int P1;
    public boolean Q1;
    public int R1;
    public OnFrameRenderedListenerV23 S1;
    public VideoFrameMetadataListener T1;
    public final Context o1;
    public final boolean p1;
    public final VideoRendererEventListener.EventDispatcher q1;
    public final int r1;
    public final boolean s1;
    public final VideoFrameReleaseControl t1;
    public final VideoFrameReleaseControl.FrameReleaseInfo u1;
    public CodecMaxValues v1;
    public boolean w1;
    public boolean x1;
    public VideoSink y1;
    public boolean z1;

    @RequiresApi
    public static final class Api26 {
        @DoNotInline
        public static boolean a(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display != null && display.isHdr()) {
                for (int i2 : display.getHdrCapabilities().getSupportedHdrTypes()) {
                    if (i2 == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static final class CodecMaxValues {

        /* renamed from: a, reason: collision with root package name */
        public final int f8274a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8275b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8276c;

        public CodecMaxValues(int i2, int i3, int i4) {
            this.f8274a = i2;
            this.f8275b = i3;
            this.f8276c = i4;
        }
    }

    @RequiresApi
    public final class OnFrameRenderedListenerV23 implements MediaCodecAdapter.OnFrameRenderedListener, Handler.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f8277a;

        public OnFrameRenderedListenerV23(MediaCodecAdapter mediaCodecAdapter) {
            Handler handlerO = Util.o(this);
            this.f8277a = handlerO;
            mediaCodecAdapter.e(this, handlerO);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.OnFrameRenderedListener
        public final void a(long j2) {
            if (Util.f5744a >= 30) {
                b(j2);
            } else {
                Handler handler = this.f8277a;
                handler.sendMessageAtFrontOfQueue(Message.obtain(handler, 0, (int) (j2 >> 32), (int) j2));
            }
        }

        public final void b(long j2) {
            Surface surface;
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this != mediaCodecVideoRenderer.S1 || mediaCodecVideoRenderer.L == null) {
                return;
            }
            if (j2 == Long.MAX_VALUE) {
                mediaCodecVideoRenderer.h1 = true;
                return;
            }
            try {
                mediaCodecVideoRenderer.J0(j2);
                mediaCodecVideoRenderer.P0(mediaCodecVideoRenderer.N1);
                mediaCodecVideoRenderer.j1.f6129e++;
                VideoFrameReleaseControl videoFrameReleaseControl = mediaCodecVideoRenderer.t1;
                boolean z = videoFrameReleaseControl.f8306d != 3;
                videoFrameReleaseControl.f8306d = 3;
                videoFrameReleaseControl.f8313k.getClass();
                videoFrameReleaseControl.f8308f = Util.T(SystemClock.elapsedRealtime());
                if (z && (surface = mediaCodecVideoRenderer.B1) != null) {
                    VideoRendererEventListener.EventDispatcher eventDispatcher = mediaCodecVideoRenderer.q1;
                    Handler handler = eventDispatcher.f8346a;
                    if (handler != null) {
                        handler.post(new h(eventDispatcher, surface, SystemClock.elapsedRealtime()));
                    }
                    mediaCodecVideoRenderer.E1 = true;
                }
                mediaCodecVideoRenderer.r0(j2);
            } catch (ExoPlaybackException e2) {
                mediaCodecVideoRenderer.i1 = e2;
            }
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            int i2 = message.arg1;
            int i3 = message.arg2;
            int i4 = Util.f5744a;
            b(((i2 & 4294967295L) << 32) | (4294967295L & i3));
            return true;
        }
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener) {
        super(2, factory, z, 30.0f);
        Context applicationContext = context.getApplicationContext();
        this.o1 = applicationContext;
        this.r1 = 50;
        this.q1 = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.p1 = true;
        this.t1 = new VideoFrameReleaseControl(applicationContext, this);
        this.u1 = new VideoFrameReleaseControl.FrameReleaseInfo();
        this.s1 = "NVIDIA".equals(Util.f5746c);
        this.D1 = Size.f5730c;
        this.F1 = 1;
        this.N1 = VideoSize.f5559e;
        this.R1 = 0;
        this.O1 = null;
        this.P1 = -1000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008f A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean K0(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 3206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.K0(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int L0(androidx.media3.exoplayer.mediacodec.MediaCodecInfo r11, androidx.media3.common.Format r12) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.L0(androidx.media3.exoplayer.mediacodec.MediaCodecInfo, androidx.media3.common.Format):int");
    }

    public static List M0(Context context, androidx.media3.exoplayer.mediacodec.d dVar, Format format, boolean z, boolean z2) {
        List listF;
        String str = format.f5225m;
        if (str == null) {
            return ImmutableList.r();
        }
        if (Util.f5744a >= 26 && "video/dolby-vision".equals(str) && !Api26.a(context)) {
            String strB = MediaCodecUtil.b(format);
            if (strB == null) {
                listF = ImmutableList.r();
            } else {
                dVar.getClass();
                listF = MediaCodecUtil.f(strB, z, z2);
            }
            if (!listF.isEmpty()) {
                return listF;
            }
        }
        return MediaCodecUtil.h(dVar, format, z, z2);
    }

    public static int N0(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.n == -1) {
            return L0(mediaCodecInfo, format);
        }
        List list = format.p;
        int size = list.size();
        int length = 0;
        for (int i2 = 0; i2 < size; i2++) {
            length += ((byte[]) list.get(i2)).length;
        }
        return format.n + length;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void A0() {
        super.A0();
        this.J1 = 0;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final boolean E0(MediaCodecInfo mediaCodecInfo) {
        return this.B1 != null || U0(mediaCodecInfo);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void G() {
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.q1;
        this.O1 = null;
        VideoSink videoSink = this.y1;
        if (videoSink != null) {
            videoSink.u();
        } else {
            this.t1.c(0);
        }
        Q0();
        this.E1 = false;
        this.S1 = null;
        try {
            super.G();
            DecoderCounters decoderCounters = this.j1;
            eventDispatcher.getClass();
            synchronized (decoderCounters) {
            }
            Handler handler = eventDispatcher.f8346a;
            if (handler != null) {
                handler.post(new i(eventDispatcher, decoderCounters, 1));
            }
            eventDispatcher.a(VideoSize.f5559e);
        } catch (Throwable th) {
            DecoderCounters decoderCounters2 = this.j1;
            eventDispatcher.getClass();
            synchronized (decoderCounters2) {
                Handler handler2 = eventDispatcher.f8346a;
                if (handler2 != null) {
                    handler2.post(new i(eventDispatcher, decoderCounters2, 1));
                }
                eventDispatcher.a(VideoSize.f5559e);
                throw th;
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final int G0(androidx.media3.exoplayer.mediacodec.d dVar, Format format) {
        boolean z;
        int i2 = 0;
        if (!MimeTypes.o(format.f5225m)) {
            return RendererCapabilities.h(0, 0, 0, 0);
        }
        boolean z2 = format.q != null;
        Context context = this.o1;
        List listM0 = M0(context, dVar, format, z2, false);
        if (z2 && listM0.isEmpty()) {
            listM0 = M0(context, dVar, format, false, false);
        }
        if (listM0.isEmpty()) {
            return RendererCapabilities.h(1, 0, 0, 0);
        }
        int i3 = format.J;
        if (i3 != 0 && i3 != 2) {
            return RendererCapabilities.h(2, 0, 0, 0);
        }
        MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) listM0.get(0);
        boolean zD = mediaCodecInfo.d(format);
        if (zD) {
            z = true;
        } else {
            for (int i4 = 1; i4 < listM0.size(); i4++) {
                MediaCodecInfo mediaCodecInfo2 = (MediaCodecInfo) listM0.get(i4);
                if (mediaCodecInfo2.d(format)) {
                    zD = true;
                    z = false;
                    mediaCodecInfo = mediaCodecInfo2;
                    break;
                }
            }
            z = true;
        }
        int i5 = zD ? 4 : 3;
        int i6 = mediaCodecInfo.e(format) ? 16 : 8;
        int i7 = mediaCodecInfo.f7326g ? 64 : 0;
        int i8 = z ? 128 : 0;
        if (Util.f5744a >= 26 && "video/dolby-vision".equals(format.f5225m) && !Api26.a(context)) {
            i8 = 256;
        }
        if (zD) {
            List listM02 = M0(context, dVar, format, z2, true);
            if (!listM02.isEmpty()) {
                Pattern pattern = MediaCodecUtil.f7340a;
                ArrayList arrayList = new ArrayList(listM02);
                Collections.sort(arrayList, new androidx.media3.exoplayer.mediacodec.f(new androidx.media3.exoplayer.mediacodec.e(format)));
                MediaCodecInfo mediaCodecInfo3 = (MediaCodecInfo) arrayList.get(0);
                if (mediaCodecInfo3.d(format) && mediaCodecInfo3.e(format)) {
                    i2 = 32;
                }
            }
        }
        return i5 | i6 | i2 | i7 | i8;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void H(boolean z, boolean z2) {
        super.H(z, z2);
        RendererConfiguration rendererConfiguration = this.f6115d;
        rendererConfiguration.getClass();
        boolean z3 = rendererConfiguration.f6358b;
        Assertions.g((z3 && this.R1 == 0) ? false : true);
        if (this.Q1 != z3) {
            this.Q1 = z3;
            y0();
        }
        DecoderCounters decoderCounters = this.j1;
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.q1;
        Handler handler = eventDispatcher.f8346a;
        if (handler != null) {
            handler.post(new i(eventDispatcher, decoderCounters, 0));
        }
        boolean z4 = this.z1;
        VideoFrameReleaseControl videoFrameReleaseControl = this.t1;
        if (!z4) {
            if ((this.A1 != null || !this.p1) && this.y1 == null) {
                CompositingVideoSinkProvider.Builder builder = new CompositingVideoSinkProvider.Builder(this.o1, videoFrameReleaseControl);
                androidx.media3.common.util.SystemClock systemClock = this.f6118g;
                systemClock.getClass();
                builder.f8239e = systemClock;
                Assertions.g(!builder.f8240f);
                if (builder.f8238d == null) {
                    if (builder.f8237c == null) {
                        builder.f8237c = new CompositingVideoSinkProvider.ReflectiveDefaultVideoFrameProcessorFactory();
                    }
                    builder.f8238d = new CompositingVideoSinkProvider.ReflectivePreviewingSingleInputVideoGraphFactory(builder.f8237c);
                }
                CompositingVideoSinkProvider compositingVideoSinkProvider = new CompositingVideoSinkProvider(builder);
                builder.f8240f = true;
                this.y1 = compositingVideoSinkProvider.f8223b;
            }
            this.z1 = true;
        }
        VideoSink videoSink = this.y1;
        if (videoSink == null) {
            androidx.media3.common.util.SystemClock systemClock2 = this.f6118g;
            systemClock2.getClass();
            videoFrameReleaseControl.f8313k = systemClock2;
            videoFrameReleaseControl.f8306d = z2 ? 1 : 0;
            return;
        }
        videoSink.x(new VideoSink.Listener() { // from class: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.1
            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public final void e() {
                MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
                Assertions.h(mediaCodecVideoRenderer.B1);
                Surface surface = mediaCodecVideoRenderer.B1;
                VideoRendererEventListener.EventDispatcher eventDispatcher2 = mediaCodecVideoRenderer.q1;
                Handler handler2 = eventDispatcher2.f8346a;
                if (handler2 != null) {
                    handler2.post(new h(eventDispatcher2, surface, SystemClock.elapsedRealtime()));
                }
                mediaCodecVideoRenderer.E1 = true;
            }

            @Override // androidx.media3.exoplayer.video.VideoSink.Listener
            public final void h() {
                MediaCodecVideoRenderer.this.W0(0, 1);
            }
        }, MoreExecutors.a());
        VideoFrameMetadataListener videoFrameMetadataListener = this.T1;
        if (videoFrameMetadataListener != null) {
            this.y1.j(videoFrameMetadataListener);
        }
        if (this.B1 != null && !this.D1.equals(Size.f5730c)) {
            this.y1.s(this.B1, this.D1);
        }
        this.y1.C(this.J);
        List list = this.A1;
        if (list != null) {
            this.y1.m(list);
        }
        this.y1.q(z2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void I(long j2, boolean z) {
        VideoSink videoSink = this.y1;
        if (videoSink != null) {
            videoSink.w(true);
            this.y1.t(e0());
        }
        super.I(j2, z);
        VideoSink videoSink2 = this.y1;
        VideoFrameReleaseControl videoFrameReleaseControl = this.t1;
        if (videoSink2 == null) {
            VideoFrameReleaseHelper videoFrameReleaseHelper = videoFrameReleaseControl.f8304b;
            videoFrameReleaseHelper.f8328m = 0L;
            videoFrameReleaseHelper.p = -1L;
            videoFrameReleaseHelper.n = -1L;
            videoFrameReleaseControl.f8309g = -9223372036854775807L;
            videoFrameReleaseControl.f8307e = -9223372036854775807L;
            videoFrameReleaseControl.c(1);
            videoFrameReleaseControl.f8310h = -9223372036854775807L;
        }
        if (z) {
            videoFrameReleaseControl.f8311i = false;
            videoFrameReleaseControl.f8313k.getClass();
            videoFrameReleaseControl.f8310h = SystemClock.elapsedRealtime() + 5000;
        }
        Q0();
        this.I1 = 0;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void J() {
        VideoSink videoSink = this.y1;
        if (videoSink == null || !this.p1) {
            return;
        }
        videoSink.release();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void K() {
        try {
            super.K();
        } finally {
            this.z1 = false;
            if (this.C1 != null) {
                R0();
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void L() {
        this.H1 = 0;
        this.f6118g.getClass();
        this.G1 = SystemClock.elapsedRealtime();
        this.K1 = 0L;
        this.L1 = 0;
        VideoSink videoSink = this.y1;
        if (videoSink != null) {
            videoSink.r();
        } else {
            this.t1.d();
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer
    public final void M() {
        O0();
        int i2 = this.L1;
        if (i2 != 0) {
            long j2 = this.K1;
            VideoRendererEventListener.EventDispatcher eventDispatcher = this.q1;
            Handler handler = eventDispatcher.f8346a;
            if (handler != null) {
                handler.post(new g(eventDispatcher, j2, i2));
            }
            this.K1 = 0L;
            this.L1 = 0;
        }
        VideoSink videoSink = this.y1;
        if (videoSink != null) {
            videoSink.l();
        } else {
            this.t1.e();
        }
    }

    public final void O0() {
        if (this.H1 > 0) {
            this.f6118g.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = jElapsedRealtime - this.G1;
            int i2 = this.H1;
            VideoRendererEventListener.EventDispatcher eventDispatcher = this.q1;
            Handler handler = eventDispatcher.f8346a;
            if (handler != null) {
                handler.post(new g(eventDispatcher, i2, j2));
            }
            this.H1 = 0;
            this.G1 = jElapsedRealtime;
        }
    }

    public final void P0(VideoSize videoSize) {
        if (videoSize.equals(VideoSize.f5559e) || videoSize.equals(this.O1)) {
            return;
        }
        this.O1 = videoSize;
        this.q1.a(videoSize);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final DecoderReuseEvaluation Q(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        DecoderReuseEvaluation decoderReuseEvaluationB = mediaCodecInfo.b(format, format2);
        CodecMaxValues codecMaxValues = this.v1;
        codecMaxValues.getClass();
        int i2 = format2.s;
        int i3 = codecMaxValues.f8274a;
        int i4 = decoderReuseEvaluationB.f6141e;
        if (i2 > i3 || format2.t > codecMaxValues.f8275b) {
            i4 |= 256;
        }
        if (N0(mediaCodecInfo, format2) > codecMaxValues.f8276c) {
            i4 |= 64;
        }
        int i5 = i4;
        return new DecoderReuseEvaluation(mediaCodecInfo.f7320a, format, format2, i5 != 0 ? 0 : decoderReuseEvaluationB.f6140d, i5);
    }

    public final void Q0() {
        int i2;
        MediaCodecAdapter mediaCodecAdapter;
        if (!this.Q1 || (i2 = Util.f5744a) < 23 || (mediaCodecAdapter = this.L) == null) {
            return;
        }
        this.S1 = new OnFrameRenderedListenerV23(mediaCodecAdapter);
        if (i2 >= 33) {
            Bundle bundle = new Bundle();
            bundle.putInt("tunnel-peek", 1);
            mediaCodecAdapter.b(bundle);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final MediaCodecDecoderException R(IllegalStateException illegalStateException, MediaCodecInfo mediaCodecInfo) {
        Surface surface = this.B1;
        MediaCodecVideoDecoderException mediaCodecVideoDecoderException = new MediaCodecVideoDecoderException(illegalStateException, mediaCodecInfo);
        System.identityHashCode(surface);
        if (surface != null) {
            surface.isValid();
        }
        return mediaCodecVideoDecoderException;
    }

    public final void R0() {
        Surface surface = this.B1;
        PlaceholderSurface placeholderSurface = this.C1;
        if (surface == placeholderSurface) {
            this.B1 = null;
        }
        if (placeholderSurface != null) {
            placeholderSurface.release();
            this.C1 = null;
        }
    }

    public final void S0(MediaCodecAdapter mediaCodecAdapter, int i2) {
        Surface surface;
        Trace.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.m(i2, true);
        Trace.endSection();
        this.j1.f6129e++;
        this.I1 = 0;
        if (this.y1 == null) {
            P0(this.N1);
            VideoFrameReleaseControl videoFrameReleaseControl = this.t1;
            boolean z = videoFrameReleaseControl.f8306d != 3;
            videoFrameReleaseControl.f8306d = 3;
            videoFrameReleaseControl.f8313k.getClass();
            videoFrameReleaseControl.f8308f = Util.T(SystemClock.elapsedRealtime());
            if (!z || (surface = this.B1) == null) {
                return;
            }
            VideoRendererEventListener.EventDispatcher eventDispatcher = this.q1;
            Handler handler = eventDispatcher.f8346a;
            if (handler != null) {
                handler.post(new h(eventDispatcher, surface, SystemClock.elapsedRealtime()));
            }
            this.E1 = true;
        }
    }

    public final void T0(MediaCodecAdapter mediaCodecAdapter, int i2, long j2) {
        Surface surface;
        Trace.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.j(i2, j2);
        Trace.endSection();
        this.j1.f6129e++;
        this.I1 = 0;
        if (this.y1 == null) {
            P0(this.N1);
            VideoFrameReleaseControl videoFrameReleaseControl = this.t1;
            boolean z = videoFrameReleaseControl.f8306d != 3;
            videoFrameReleaseControl.f8306d = 3;
            videoFrameReleaseControl.f8313k.getClass();
            videoFrameReleaseControl.f8308f = Util.T(SystemClock.elapsedRealtime());
            if (!z || (surface = this.B1) == null) {
                return;
            }
            VideoRendererEventListener.EventDispatcher eventDispatcher = this.q1;
            Handler handler = eventDispatcher.f8346a;
            if (handler != null) {
                handler.post(new h(eventDispatcher, surface, SystemClock.elapsedRealtime()));
            }
            this.E1 = true;
        }
    }

    public final boolean U0(MediaCodecInfo mediaCodecInfo) {
        if (Util.f5744a < 23 || this.Q1 || K0(mediaCodecInfo.f7320a)) {
            return false;
        }
        return !mediaCodecInfo.f7325f || PlaceholderSurface.a(this.o1);
    }

    public final void V0(MediaCodecAdapter mediaCodecAdapter, int i2) {
        Trace.beginSection("skipVideoBuffer");
        mediaCodecAdapter.m(i2, false);
        Trace.endSection();
        this.j1.f6130f++;
    }

    public final void W0(int i2, int i3) {
        DecoderCounters decoderCounters = this.j1;
        decoderCounters.f6132h += i2;
        int i4 = i2 + i3;
        decoderCounters.f6131g += i4;
        this.H1 += i4;
        int i5 = this.I1 + i4;
        this.I1 = i5;
        decoderCounters.f6133i = Math.max(i5, decoderCounters.f6133i);
        int i6 = this.r1;
        if (i6 <= 0 || this.H1 < i6) {
            return;
        }
        O0();
    }

    public final void X0(long j2) {
        DecoderCounters decoderCounters = this.j1;
        decoderCounters.f6135k += j2;
        decoderCounters.f6136l++;
        this.K1 += j2;
        this.L1++;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final int Z(DecoderInputBuffer decoderInputBuffer) {
        return (Util.f5744a < 34 || !this.Q1 || decoderInputBuffer.f6073f >= this.f6123l) ? 0 : 32;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public final boolean a() {
        PlaceholderSurface placeholderSurface;
        VideoSink videoSink;
        boolean z = super.a() && ((videoSink = this.y1) == null || videoSink.a());
        if (z && (((placeholderSurface = this.C1) != null && this.B1 == placeholderSurface) || this.L == null || this.Q1)) {
            return true;
        }
        return this.t1.b(z);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final boolean a0() {
        return this.Q1 && Util.f5744a < 23;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final float b0(float f2, Format[] formatArr) {
        float fMax = -1.0f;
        for (Format format : formatArr) {
            float f3 = format.u;
            if (f3 != -1.0f) {
                fMax = Math.max(fMax, f3);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f2;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.Renderer
    public final boolean c() {
        if (!this.f1) {
            return false;
        }
        VideoSink videoSink = this.y1;
        return videoSink == null || videoSink.c();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final ArrayList c0(androidx.media3.exoplayer.mediacodec.d dVar, Format format, boolean z) {
        List listM0 = M0(this.o1, dVar, format, z, this.Q1);
        Pattern pattern = MediaCodecUtil.f7340a;
        ArrayList arrayList = new ArrayList(listM0);
        Collections.sort(arrayList, new androidx.media3.exoplayer.mediacodec.f(new androidx.media3.exoplayer.mediacodec.e(format)));
        return arrayList;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final MediaCodecAdapter.Configuration d0(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f2) {
        boolean z;
        ColorInfo colorInfo;
        int i2;
        int iMax;
        CodecMaxValues codecMaxValues;
        Point point;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int i3;
        int i4;
        char c2;
        boolean z2;
        Pair pairD;
        int iL0;
        PlaceholderSurface placeholderSurface = this.C1;
        boolean z3 = mediaCodecInfo.f7325f;
        if (placeholderSurface != null && placeholderSurface.f8281a != z3) {
            R0();
        }
        String str = mediaCodecInfo.f7322c;
        Format[] formatArr = this.f6121j;
        formatArr.getClass();
        int iMax2 = format.s;
        int iN0 = N0(mediaCodecInfo, format);
        int length = formatArr.length;
        float f3 = format.u;
        int i5 = format.s;
        ColorInfo colorInfo2 = format.z;
        int i6 = format.t;
        if (length == 1) {
            if (iN0 != -1 && (iL0 = L0(mediaCodecInfo, format)) != -1) {
                iN0 = Math.min((int) (iN0 * 1.5f), iL0);
            }
            z = z3;
            codecMaxValues = new CodecMaxValues(iMax2, i6, iN0);
            colorInfo = colorInfo2;
            i2 = i6;
        } else {
            int length2 = formatArr.length;
            int iMax3 = i6;
            int i7 = 0;
            boolean z4 = false;
            while (i7 < length2) {
                Format format2 = formatArr[i7];
                Format[] formatArr2 = formatArr;
                if (colorInfo2 != null && format2.z == null) {
                    Format.Builder builderA = format2.a();
                    builderA.y = colorInfo2;
                    format2 = new Format(builderA);
                }
                if (mediaCodecInfo.b(format, format2).f6140d != 0) {
                    int i8 = format2.t;
                    i3 = length2;
                    int i9 = format2.s;
                    i4 = i7;
                    c2 = 65535;
                    z4 |= i9 == -1 || i8 == -1;
                    iMax2 = Math.max(iMax2, i9);
                    iMax3 = Math.max(iMax3, i8);
                    iN0 = Math.max(iN0, N0(mediaCodecInfo, format2));
                } else {
                    i3 = length2;
                    i4 = i7;
                    c2 = 65535;
                }
                length2 = i3;
                i7 = i4 + 1;
                formatArr = formatArr2;
            }
            int i10 = iMax3;
            if (z4) {
                Log.h("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax2 + "x" + i10);
                boolean z5 = i6 > i5;
                boolean z6 = z5;
                int i11 = z5 ? i6 : i5;
                z = z3;
                int i12 = z6 ? i5 : i6;
                float f4 = i12 / i11;
                int[] iArr = U1;
                colorInfo = colorInfo2;
                int i13 = 0;
                while (i13 < 9) {
                    int i14 = iArr[i13];
                    int i15 = i13;
                    int i16 = (int) (i14 * f4);
                    if (i14 <= i11 || i16 <= i12) {
                        break;
                    }
                    int i17 = i12;
                    int i18 = i11;
                    if (Util.f5744a >= 21) {
                        int i19 = z6 ? i16 : i14;
                        if (!z6) {
                            i14 = i16;
                        }
                        MediaCodecInfo.CodecCapabilities codecCapabilities = mediaCodecInfo.f7323d;
                        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
                            point = null;
                        } else {
                            int widthAlignment = videoCapabilities.getWidthAlignment();
                            int heightAlignment = videoCapabilities.getHeightAlignment();
                            point = new Point(Util.g(i19, widthAlignment) * widthAlignment, Util.g(i14, heightAlignment) * heightAlignment);
                        }
                        if (point != null) {
                            i2 = i6;
                            if (mediaCodecInfo.f(point.x, point.y, f3)) {
                                break;
                            }
                        } else {
                            i2 = i6;
                        }
                        i13 = i15 + 1;
                        i6 = i2;
                        i12 = i17;
                        i11 = i18;
                    } else {
                        i2 = i6;
                        try {
                            int iG = Util.g(i14, 16) * 16;
                            int iG2 = Util.g(i16, 16) * 16;
                            if (iG * iG2 <= MediaCodecUtil.k()) {
                                int i20 = z6 ? iG2 : iG;
                                if (!z6) {
                                    iG = iG2;
                                }
                                point = new Point(i20, iG);
                            } else {
                                i13 = i15 + 1;
                                i6 = i2;
                                i12 = i17;
                                i11 = i18;
                            }
                        } catch (MediaCodecUtil.DecoderQueryException unused) {
                        }
                    }
                }
                i2 = i6;
                point = null;
                if (point != null) {
                    iMax2 = Math.max(iMax2, point.x);
                    iMax = Math.max(i10, point.y);
                    Format.Builder builderA2 = format.a();
                    builderA2.r = iMax2;
                    builderA2.s = iMax;
                    iN0 = Math.max(iN0, L0(mediaCodecInfo, new Format(builderA2)));
                    Log.h("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax2 + "x" + iMax);
                }
                codecMaxValues = new CodecMaxValues(iMax2, iMax, iN0);
            } else {
                z = z3;
                colorInfo = colorInfo2;
                i2 = i6;
            }
            iMax = i10;
            codecMaxValues = new CodecMaxValues(iMax2, iMax, iN0);
        }
        this.v1 = codecMaxValues;
        int i21 = this.Q1 ? this.R1 : 0;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger(Snapshot.WIDTH, i5);
        mediaFormat.setInteger(Snapshot.HEIGHT, i2);
        MediaFormatUtil.b(mediaFormat, format.p);
        if (f3 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f3);
        }
        MediaFormatUtil.a(mediaFormat, "rotation-degrees", format.v);
        if (colorInfo != null) {
            ColorInfo colorInfo3 = colorInfo;
            MediaFormatUtil.a(mediaFormat, "color-transfer", colorInfo3.f5177c);
            MediaFormatUtil.a(mediaFormat, "color-standard", colorInfo3.f5175a);
            MediaFormatUtil.a(mediaFormat, "color-range", colorInfo3.f5176b);
            byte[] bArr = colorInfo3.f5178d;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(format.f5225m) && (pairD = MediaCodecUtil.d(format)) != null) {
            MediaFormatUtil.a(mediaFormat, Scopes.PROFILE, ((Integer) pairD.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues.f8274a);
        mediaFormat.setInteger("max-height", codecMaxValues.f8275b);
        MediaFormatUtil.a(mediaFormat, "max-input-size", codecMaxValues.f8276c);
        int i22 = Util.f5744a;
        if (i22 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f2 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f2);
            }
        }
        if (this.s1) {
            z2 = true;
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        } else {
            z2 = true;
        }
        if (i21 != 0) {
            mediaFormat.setFeatureEnabled("tunneled-playback", z2);
            mediaFormat.setInteger("audio-session-id", i21);
        }
        if (i22 >= 35) {
            mediaFormat.setInteger("importance", Math.max(0, -this.P1));
        }
        if (this.B1 == null) {
            if (!U0(mediaCodecInfo)) {
                throw new IllegalStateException();
            }
            if (this.C1 == null) {
                this.C1 = PlaceholderSurface.b(this.o1, z);
            }
            this.B1 = this.C1;
        }
        VideoSink videoSink = this.y1;
        if (videoSink != null && !videoSink.n()) {
            mediaFormat.setInteger("allow-frame-drop", 0);
        }
        VideoSink videoSink2 = this.y1;
        return new MediaCodecAdapter.Configuration(mediaCodecInfo, mediaFormat, format, videoSink2 != null ? videoSink2.g() : this.B1, mediaCrypto);
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void f() {
        VideoSink videoSink = this.y1;
        if (videoSink != null) {
            videoSink.f();
            return;
        }
        VideoFrameReleaseControl videoFrameReleaseControl = this.t1;
        if (videoFrameReleaseControl.f8306d == 0) {
            videoFrameReleaseControl.f8306d = 1;
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void g0(DecoderInputBuffer decoderInputBuffer) {
        if (this.x1) {
            ByteBuffer byteBuffer = decoderInputBuffer.f6074g;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b2 = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b3 = byteBuffer.get();
                byte b4 = byteBuffer.get();
                byteBuffer.position(0);
                if (b2 == -75 && s == 60 && s2 == 1 && b3 == 4) {
                    if (b4 == 0 || b4 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        MediaCodecAdapter mediaCodecAdapter = this.L;
                        mediaCodecAdapter.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        mediaCodecAdapter.b(bundle);
                    }
                }
            }
        }
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public final String getName() {
        return "MediaCodecVideoRenderer";
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public final void i(long j2, long j3) throws MediaCryptoException, ExoPlaybackException {
        super.i(j2, j3);
        VideoSink videoSink = this.y1;
        if (videoSink != null) {
            try {
                videoSink.i(j2, j3);
            } catch (VideoSink.VideoSinkException e2) {
                throw C(e2, e2.f8349a, false, 7001);
            }
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void l0(Exception exc) {
        Log.e("MediaCodecVideoRenderer", "Video codec error", exc);
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.q1;
        Handler handler = eventDispatcher.f8346a;
        if (handler != null) {
            handler.post(new f(eventDispatcher, exc, 1));
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void m0(long j2, long j3, String str) {
        String str2;
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.q1;
        Handler handler = eventDispatcher.f8346a;
        if (handler != null) {
            str2 = str;
            handler.post(new androidx.media3.exoplayer.audio.e(eventDispatcher, str2, j2, j3, 1));
        } else {
            str2 = str;
        }
        this.w1 = K0(str2);
        androidx.media3.exoplayer.mediacodec.MediaCodecInfo mediaCodecInfo = this.B0;
        mediaCodecInfo.getClass();
        boolean z = false;
        if (Util.f5744a >= 29 && "video/x-vnd.on2.vp9".equals(mediaCodecInfo.f7321b)) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = mediaCodecInfo.f7323d;
            if (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) {
                codecProfileLevelArr = new MediaCodecInfo.CodecProfileLevel[0];
            }
            int length = codecProfileLevelArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (codecProfileLevelArr[i2].profile == 16384) {
                    z = true;
                    break;
                }
                i2++;
            }
        }
        this.x1 = z;
        Q0();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void n0(String str) {
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.q1;
        Handler handler = eventDispatcher.f8346a;
        if (handler != null) {
            handler.post(new f(eventDispatcher, str, 2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v11, types: [android.view.Surface] */
    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.PlayerMessage.Target
    public final void o(int i2, Object obj) {
        Handler handler;
        VideoFrameReleaseControl videoFrameReleaseControl = this.t1;
        if (i2 == 1) {
            PlaceholderSurface placeholderSurfaceB = obj instanceof Surface ? (Surface) obj : null;
            if (placeholderSurfaceB == null) {
                PlaceholderSurface placeholderSurface = this.C1;
                if (placeholderSurface != null) {
                    placeholderSurfaceB = placeholderSurface;
                } else {
                    androidx.media3.exoplayer.mediacodec.MediaCodecInfo mediaCodecInfo = this.B0;
                    if (mediaCodecInfo != null && U0(mediaCodecInfo)) {
                        placeholderSurfaceB = PlaceholderSurface.b(this.o1, mediaCodecInfo.f7325f);
                        this.C1 = placeholderSurfaceB;
                    }
                }
            }
            Surface surface = this.B1;
            VideoRendererEventListener.EventDispatcher eventDispatcher = this.q1;
            if (surface == placeholderSurfaceB) {
                if (placeholderSurfaceB == null || placeholderSurfaceB == this.C1) {
                    return;
                }
                VideoSize videoSize = this.O1;
                if (videoSize != null) {
                    eventDispatcher.a(videoSize);
                }
                Surface surface2 = this.B1;
                if (surface2 == null || !this.E1 || (handler = eventDispatcher.f8346a) == null) {
                    return;
                }
                handler.post(new h(eventDispatcher, surface2, SystemClock.elapsedRealtime()));
                return;
            }
            this.B1 = placeholderSurfaceB;
            if (this.y1 == null) {
                videoFrameReleaseControl.g(placeholderSurfaceB);
            }
            this.E1 = false;
            int i3 = this.f6119h;
            MediaCodecAdapter mediaCodecAdapter = this.L;
            if (mediaCodecAdapter != null && this.y1 == null) {
                if (Util.f5744a < 23 || placeholderSurfaceB == null || this.w1) {
                    y0();
                    j0();
                } else {
                    mediaCodecAdapter.i(placeholderSurfaceB);
                }
            }
            if (placeholderSurfaceB == null || placeholderSurfaceB == this.C1) {
                this.O1 = null;
                VideoSink videoSink = this.y1;
                if (videoSink != null) {
                    videoSink.v();
                }
            } else {
                VideoSize videoSize2 = this.O1;
                if (videoSize2 != null) {
                    eventDispatcher.a(videoSize2);
                }
                if (i3 == 2) {
                    videoFrameReleaseControl.f8311i = true;
                    videoFrameReleaseControl.f8313k.getClass();
                    videoFrameReleaseControl.f8310h = SystemClock.elapsedRealtime() + 5000;
                }
            }
            Q0();
            return;
        }
        if (i2 == 7) {
            obj.getClass();
            VideoFrameMetadataListener videoFrameMetadataListener = (VideoFrameMetadataListener) obj;
            this.T1 = videoFrameMetadataListener;
            VideoSink videoSink2 = this.y1;
            if (videoSink2 != null) {
                videoSink2.j(videoFrameMetadataListener);
                return;
            }
            return;
        }
        if (i2 == 10) {
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            if (this.R1 != iIntValue) {
                this.R1 = iIntValue;
                if (this.Q1) {
                    y0();
                    return;
                }
                return;
            }
            return;
        }
        if (i2 == 16) {
            obj.getClass();
            this.P1 = ((Integer) obj).intValue();
            MediaCodecAdapter mediaCodecAdapter2 = this.L;
            if (mediaCodecAdapter2 != null && Util.f5744a >= 35) {
                Bundle bundle = new Bundle();
                bundle.putInt("importance", Math.max(0, -this.P1));
                mediaCodecAdapter2.b(bundle);
                return;
            }
            return;
        }
        if (i2 == 4) {
            obj.getClass();
            int iIntValue2 = ((Integer) obj).intValue();
            this.F1 = iIntValue2;
            MediaCodecAdapter mediaCodecAdapter3 = this.L;
            if (mediaCodecAdapter3 != null) {
                mediaCodecAdapter3.g(iIntValue2);
                return;
            }
            return;
        }
        if (i2 == 5) {
            obj.getClass();
            int iIntValue3 = ((Integer) obj).intValue();
            VideoFrameReleaseHelper videoFrameReleaseHelper = videoFrameReleaseControl.f8304b;
            if (videoFrameReleaseHelper.f8325j == iIntValue3) {
                return;
            }
            videoFrameReleaseHelper.f8325j = iIntValue3;
            videoFrameReleaseHelper.d(true);
            return;
        }
        if (i2 == 13) {
            obj.getClass();
            List list = (List) obj;
            this.A1 = list;
            VideoSink videoSink3 = this.y1;
            if (videoSink3 != null) {
                videoSink3.m(list);
                return;
            }
            return;
        }
        if (i2 != 14) {
            super.o(i2, obj);
            return;
        }
        obj.getClass();
        Size size = (Size) obj;
        if (size.f5731a == 0 || size.f5732b == 0) {
            return;
        }
        this.D1 = size;
        VideoSink videoSink4 = this.y1;
        if (videoSink4 != null) {
            Surface surface3 = this.B1;
            Assertions.h(surface3);
            videoSink4.s(surface3, size);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final DecoderReuseEvaluation o0(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation decoderReuseEvaluationO0 = super.o0(formatHolder);
        Format format = formatHolder.f6254b;
        format.getClass();
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.q1;
        Handler handler = eventDispatcher.f8346a;
        if (handler != null) {
            handler.post(new androidx.media3.common.util.e(eventDispatcher, format, decoderReuseEvaluationO0, 5));
        }
        return decoderReuseEvaluationO0;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void p0(Format format, MediaFormat mediaFormat) {
        int integer;
        int i2;
        MediaCodecAdapter mediaCodecAdapter = this.L;
        if (mediaCodecAdapter != null) {
            mediaCodecAdapter.g(this.F1);
        }
        int i3 = 0;
        if (this.Q1) {
            i2 = format.s;
            integer = format.t;
        } else {
            mediaFormat.getClass();
            boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            int integer2 = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger(Snapshot.WIDTH);
            integer = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger(Snapshot.HEIGHT);
            i2 = integer2;
        }
        float f2 = format.w;
        int i4 = Util.f5744a;
        int i5 = format.v;
        if (i4 >= 21) {
            if (i5 == 90 || i5 == 270) {
                f2 = 1.0f / f2;
                int i6 = integer;
                integer = i2;
                i2 = i6;
            }
        } else if (this.y1 == null) {
            i3 = i5;
        }
        this.N1 = new VideoSize(f2, i2, integer, i3);
        VideoSink videoSink = this.y1;
        if (videoSink == null) {
            this.t1.f(format.u);
            return;
        }
        Format.Builder builderA = format.a();
        builderA.r = i2;
        builderA.s = integer;
        builderA.u = i3;
        builderA.v = f2;
        videoSink.o(new Format(builderA));
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void r0(long j2) {
        super.r0(j2);
        if (this.Q1) {
            return;
        }
        this.J1--;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void s0() {
        VideoSink videoSink = this.y1;
        if (videoSink != null) {
            videoSink.t(e0());
        } else {
            this.t1.c(2);
        }
        Q0();
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void t0(DecoderInputBuffer decoderInputBuffer) {
        Surface surface;
        boolean z = this.Q1;
        if (!z) {
            this.J1++;
        }
        if (Util.f5744a >= 23 || !z) {
            return;
        }
        long j2 = decoderInputBuffer.f6073f;
        J0(j2);
        P0(this.N1);
        this.j1.f6129e++;
        VideoFrameReleaseControl videoFrameReleaseControl = this.t1;
        boolean z2 = videoFrameReleaseControl.f8306d != 3;
        videoFrameReleaseControl.f8306d = 3;
        videoFrameReleaseControl.f8313k.getClass();
        videoFrameReleaseControl.f8308f = Util.T(SystemClock.elapsedRealtime());
        if (z2 && (surface = this.B1) != null) {
            VideoRendererEventListener.EventDispatcher eventDispatcher = this.q1;
            Handler handler = eventDispatcher.f8346a;
            if (handler != null) {
                handler.post(new h(eventDispatcher, surface, SystemClock.elapsedRealtime()));
            }
            this.E1 = true;
        }
        r0(j2);
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final void u0(Format format) throws ExoPlaybackException {
        VideoSink videoSink = this.y1;
        if (videoSink == null || videoSink.d()) {
            return;
        }
        try {
            this.y1.p(format);
        } catch (VideoSink.VideoSinkException e2) {
            throw C(e2, format, false, 7000);
        }
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer
    public final boolean w0(long j2, long j3, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i2, int i3, int i4, long j4, boolean z, boolean z2, Format format) throws ExoPlaybackException, InterruptedException {
        VideoFrameReleaseControl.FrameReleaseInfo frameReleaseInfo;
        long j5;
        mediaCodecAdapter.getClass();
        long jE0 = j4 - e0();
        int iA = this.t1.a(j4, j2, j3, f0(), z2, this.u1);
        if (iA != 4) {
            if (z && !z2) {
                V0(mediaCodecAdapter, i2);
                return true;
            }
            Surface surface = this.B1;
            PlaceholderSurface placeholderSurface = this.C1;
            VideoFrameReleaseControl.FrameReleaseInfo frameReleaseInfo2 = this.u1;
            if (surface != placeholderSurface || this.y1 != null) {
                VideoSink videoSink = this.y1;
                if (videoSink != null) {
                    try {
                        videoSink.i(j2, j3);
                        long jK = this.y1.k(j4, z2);
                        if (jK != -9223372036854775807L) {
                            if (Util.f5744a >= 21) {
                                T0(mediaCodecAdapter, i2, jK);
                                return true;
                            }
                            S0(mediaCodecAdapter, i2);
                            return true;
                        }
                    } catch (VideoSink.VideoSinkException e2) {
                        throw C(e2, e2.f8349a, false, 7001);
                    }
                } else {
                    if (iA == 0) {
                        this.f6118g.getClass();
                        long jNanoTime = System.nanoTime();
                        VideoFrameMetadataListener videoFrameMetadataListener = this.T1;
                        if (videoFrameMetadataListener != null) {
                            frameReleaseInfo = frameReleaseInfo2;
                            videoFrameMetadataListener.e(jE0, jNanoTime, format, this.Q);
                        } else {
                            frameReleaseInfo = frameReleaseInfo2;
                        }
                        if (Util.f5744a >= 21) {
                            T0(mediaCodecAdapter, i2, jNanoTime);
                        } else {
                            S0(mediaCodecAdapter, i2);
                        }
                        X0(frameReleaseInfo.f8314a);
                        return true;
                    }
                    if (iA == 1) {
                        long j6 = frameReleaseInfo2.f8315b;
                        long j7 = frameReleaseInfo2.f8314a;
                        if (Util.f5744a >= 21) {
                            if (j6 == this.M1) {
                                V0(mediaCodecAdapter, i2);
                                j5 = j6;
                            } else {
                                VideoFrameMetadataListener videoFrameMetadataListener2 = this.T1;
                                if (videoFrameMetadataListener2 != null) {
                                    j5 = j6;
                                    videoFrameMetadataListener2.e(jE0, j5, format, this.Q);
                                } else {
                                    j5 = j6;
                                }
                                T0(mediaCodecAdapter, i2, j5);
                            }
                            X0(j7);
                            this.M1 = j5;
                            return true;
                        }
                        if (j7 < 30000) {
                            if (j7 > 11000) {
                                try {
                                    Thread.sleep((j7 - 10000) / 1000);
                                } catch (InterruptedException unused) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                            VideoFrameMetadataListener videoFrameMetadataListener3 = this.T1;
                            if (videoFrameMetadataListener3 != null) {
                                videoFrameMetadataListener3.e(jE0, j6, format, this.Q);
                            }
                            S0(mediaCodecAdapter, i2);
                            X0(j7);
                            return true;
                        }
                    } else {
                        if (iA == 2) {
                            Trace.beginSection("dropVideoBuffer");
                            mediaCodecAdapter.m(i2, false);
                            Trace.endSection();
                            W0(0, 1);
                            X0(frameReleaseInfo2.f8314a);
                            return true;
                        }
                        if (iA == 3) {
                            V0(mediaCodecAdapter, i2);
                            X0(frameReleaseInfo2.f8314a);
                            return true;
                        }
                        if (iA != 5) {
                            throw new IllegalStateException(String.valueOf(iA));
                        }
                    }
                }
            } else if (frameReleaseInfo2.f8314a < 30000) {
                V0(mediaCodecAdapter, i2);
                X0(frameReleaseInfo2.f8314a);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.mediacodec.MediaCodecRenderer, androidx.media3.exoplayer.Renderer
    public final void x(float f2, float f3) {
        super.x(f2, f3);
        VideoSink videoSink = this.y1;
        if (videoSink != null) {
            videoSink.C(f2);
            return;
        }
        VideoFrameReleaseControl videoFrameReleaseControl = this.t1;
        if (f2 == videoFrameReleaseControl.f8312j) {
            return;
        }
        videoFrameReleaseControl.f8312j = f2;
        VideoFrameReleaseHelper videoFrameReleaseHelper = videoFrameReleaseControl.f8304b;
        videoFrameReleaseHelper.f8324i = f2;
        videoFrameReleaseHelper.f8328m = 0L;
        videoFrameReleaseHelper.p = -1L;
        videoFrameReleaseHelper.n = -1L;
        videoFrameReleaseHelper.d(false);
    }
}
