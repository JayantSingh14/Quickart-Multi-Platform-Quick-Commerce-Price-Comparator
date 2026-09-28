package androidx.media3.exoplayer.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
/* loaded from: classes3.dex */
public final class VideoFrameReleaseHelper {

    /* renamed from: a, reason: collision with root package name */
    public final FixedFrameRateEstimator f8316a = new FixedFrameRateEstimator();

    /* renamed from: b, reason: collision with root package name */
    public final DisplayHelper f8317b;

    /* renamed from: c, reason: collision with root package name */
    public final VSyncSampler f8318c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8319d;

    /* renamed from: e, reason: collision with root package name */
    public Surface f8320e;

    /* renamed from: f, reason: collision with root package name */
    public float f8321f;

    /* renamed from: g, reason: collision with root package name */
    public float f8322g;

    /* renamed from: h, reason: collision with root package name */
    public float f8323h;

    /* renamed from: i, reason: collision with root package name */
    public float f8324i;

    /* renamed from: j, reason: collision with root package name */
    public int f8325j;

    /* renamed from: k, reason: collision with root package name */
    public long f8326k;

    /* renamed from: l, reason: collision with root package name */
    public long f8327l;

    /* renamed from: m, reason: collision with root package name */
    public long f8328m;
    public long n;
    public long o;
    public long p;
    public long q;

    @RequiresApi
    public static final class Api30 {
        @DoNotInline
        public static void a(Surface surface, float f2) {
            try {
                surface.setFrameRate(f2, f2 == 0.0f ? 0 : 1);
            } catch (IllegalStateException e2) {
                Log.e("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e2);
            }
        }
    }

    public final class DisplayHelper implements DisplayManager.DisplayListener {

        /* renamed from: a, reason: collision with root package name */
        public final DisplayManager f8329a;

        public DisplayHelper(DisplayManager displayManager) {
            this.f8329a = displayManager;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int i2) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int i2) {
            if (i2 == 0) {
                VideoFrameReleaseHelper.a(VideoFrameReleaseHelper.this, this.f8329a.getDisplay(0));
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int i2) {
        }
    }

    public static final class VSyncSampler implements Choreographer.FrameCallback, Handler.Callback {

        /* renamed from: e, reason: collision with root package name */
        public static final VSyncSampler f8331e = new VSyncSampler();

        /* renamed from: a, reason: collision with root package name */
        public volatile long f8332a = -9223372036854775807L;

        /* renamed from: b, reason: collision with root package name */
        public final Handler f8333b;

        /* renamed from: c, reason: collision with root package name */
        public Choreographer f8334c;

        /* renamed from: d, reason: collision with root package name */
        public int f8335d;

        public VSyncSampler() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            handlerThread.start();
            Looper looper = handlerThread.getLooper();
            int i2 = Util.f5744a;
            Handler handler = new Handler(looper, this);
            this.f8333b = handler;
            handler.sendEmptyMessage(1);
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j2) {
            this.f8332a = j2;
            Choreographer choreographer = this.f8334c;
            choreographer.getClass();
            choreographer.postFrameCallbackDelayed(this, 500L);
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                try {
                    this.f8334c = Choreographer.getInstance();
                } catch (RuntimeException e2) {
                    Log.i("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e2);
                }
                return true;
            }
            if (i2 == 2) {
                Choreographer choreographer = this.f8334c;
                if (choreographer != null) {
                    int i3 = this.f8335d + 1;
                    this.f8335d = i3;
                    if (i3 == 1) {
                        choreographer.postFrameCallback(this);
                    }
                }
                return true;
            }
            if (i2 != 3) {
                return false;
            }
            Choreographer choreographer2 = this.f8334c;
            if (choreographer2 != null) {
                int i4 = this.f8335d - 1;
                this.f8335d = i4;
                if (i4 == 0) {
                    choreographer2.removeFrameCallback(this);
                    this.f8332a = -9223372036854775807L;
                }
            }
            return true;
        }
    }

    public VideoFrameReleaseHelper(Context context) {
        DisplayManager displayManager;
        DisplayHelper displayHelper = (context == null || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : new DisplayHelper(displayManager);
        this.f8317b = displayHelper;
        this.f8318c = displayHelper != null ? VSyncSampler.f8331e : null;
        this.f8326k = -9223372036854775807L;
        this.f8327l = -9223372036854775807L;
        this.f8321f = -1.0f;
        this.f8324i = 1.0f;
        this.f8325j = 0;
    }

    public static void a(VideoFrameReleaseHelper videoFrameReleaseHelper, Display display) {
        videoFrameReleaseHelper.getClass();
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            videoFrameReleaseHelper.f8326k = refreshRate;
            videoFrameReleaseHelper.f8327l = (refreshRate * 80) / 100;
        } else {
            Log.h("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            videoFrameReleaseHelper.f8326k = -9223372036854775807L;
            videoFrameReleaseHelper.f8327l = -9223372036854775807L;
        }
    }

    public final void b() {
        Surface surface;
        if (Util.f5744a < 30 || (surface = this.f8320e) == null || this.f8325j == Integer.MIN_VALUE || this.f8323h == 0.0f) {
            return;
        }
        this.f8323h = 0.0f;
        Api30.a(surface, 0.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            r9 = this;
            int r0 = androidx.media3.common.util.Util.f5744a
            r1 = 30
            if (r0 < r1) goto L8d
            android.view.Surface r0 = r9.f8320e
            if (r0 != 0) goto Lc
            goto L8d
        Lc:
            androidx.media3.exoplayer.video.FixedFrameRateEstimator r0 = r9.f8316a
            androidx.media3.exoplayer.video.FixedFrameRateEstimator$Matcher r2 = r0.f8260a
            boolean r2 = r2.a()
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r2 == 0) goto L39
            androidx.media3.exoplayer.video.FixedFrameRateEstimator$Matcher r2 = r0.f8260a
            boolean r2 = r2.a()
            if (r2 == 0) goto L37
            androidx.media3.exoplayer.video.FixedFrameRateEstimator$Matcher r2 = r0.f8260a
            long r4 = r2.f8269e
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L2b
            goto L2e
        L2b:
            long r6 = r2.f8270f
            long r6 = r6 / r4
        L2e:
            double r4 = (double) r6
            r6 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            double r6 = r6 / r4
            float r2 = (float) r6
            goto L3b
        L37:
            r2 = r3
            goto L3b
        L39:
            float r2 = r9.f8321f
        L3b:
            float r4 = r9.f8322g
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 != 0) goto L42
            goto L8d
        L42:
            int r5 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r5 == 0) goto L80
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 == 0) goto L80
            androidx.media3.exoplayer.video.FixedFrameRateEstimator$Matcher r1 = r0.f8260a
            boolean r1 = r1.a()
            if (r1 == 0) goto L71
            androidx.media3.exoplayer.video.FixedFrameRateEstimator$Matcher r1 = r0.f8260a
            boolean r1 = r1.a()
            if (r1 == 0) goto L5f
            androidx.media3.exoplayer.video.FixedFrameRateEstimator$Matcher r0 = r0.f8260a
            long r0 = r0.f8270f
            goto L64
        L5f:
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L64:
            r3 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 < 0) goto L71
            r0 = 1017370378(0x3ca3d70a, float:0.02)
            goto L73
        L71:
            r0 = 1065353216(0x3f800000, float:1.0)
        L73:
            float r1 = r9.f8322g
            float r1 = r2 - r1
            float r1 = java.lang.Math.abs(r1)
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 < 0) goto L8d
            goto L87
        L80:
            if (r5 == 0) goto L83
            goto L87
        L83:
            int r0 = r0.f8264e
            if (r0 < r1) goto L8d
        L87:
            r9.f8322g = r2
            r0 = 0
            r9.d(r0)
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.VideoFrameReleaseHelper.c():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(boolean r4) {
        /*
            r3 = this;
            int r0 = androidx.media3.common.util.Util.f5744a
            r1 = 30
            if (r0 < r1) goto L30
            android.view.Surface r0 = r3.f8320e
            if (r0 == 0) goto L30
            int r1 = r3.f8325j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r2) goto L11
            goto L30
        L11:
            boolean r1 = r3.f8319d
            if (r1 == 0) goto L21
            float r1 = r3.f8322g
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L21
            float r2 = r3.f8324i
            float r1 = r1 * r2
            goto L22
        L21:
            r1 = 0
        L22:
            if (r4 != 0) goto L2b
            float r4 = r3.f8323h
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 != 0) goto L2b
            goto L30
        L2b:
            r3.f8323h = r1
            androidx.media3.exoplayer.video.VideoFrameReleaseHelper.Api30.a(r0, r1)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.VideoFrameReleaseHelper.d(boolean):void");
    }
}
