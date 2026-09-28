package androidx.media3.exoplayer.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Surface;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.video.VideoFrameReleaseHelper;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
/* loaded from: classes3.dex */
public final class VideoFrameReleaseControl {

    /* renamed from: a, reason: collision with root package name */
    public final MediaCodecVideoRenderer f8303a;

    /* renamed from: b, reason: collision with root package name */
    public final VideoFrameReleaseHelper f8304b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8305c;

    /* renamed from: f, reason: collision with root package name */
    public long f8308f;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8311i;

    /* renamed from: d, reason: collision with root package name */
    public int f8306d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f8307e = -9223372036854775807L;

    /* renamed from: g, reason: collision with root package name */
    public long f8309g = -9223372036854775807L;

    /* renamed from: h, reason: collision with root package name */
    public long f8310h = -9223372036854775807L;

    /* renamed from: j, reason: collision with root package name */
    public float f8312j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    public SystemClock f8313k = Clock.f5662a;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @UnstableApi
    public @interface FrameReleaseAction {
    }

    public static class FrameReleaseInfo {

        /* renamed from: a, reason: collision with root package name */
        public long f8314a = -9223372036854775807L;

        /* renamed from: b, reason: collision with root package name */
        public long f8315b = -9223372036854775807L;
    }

    public interface FrameTimingEvaluator {
    }

    public VideoFrameReleaseControl(Context context, MediaCodecVideoRenderer mediaCodecVideoRenderer) {
        this.f8303a = mediaCodecVideoRenderer;
        this.f8304b = new VideoFrameReleaseHelper(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(long r28, long r30, long r32, long r34, boolean r36, androidx.media3.exoplayer.video.VideoFrameReleaseControl.FrameReleaseInfo r37) {
        /*
            Method dump skipped, instructions count: 631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.VideoFrameReleaseControl.a(long, long, long, long, boolean, androidx.media3.exoplayer.video.VideoFrameReleaseControl$FrameReleaseInfo):int");
    }

    public final boolean b(boolean z) {
        if (z && this.f8306d == 3) {
            this.f8310h = -9223372036854775807L;
            return true;
        }
        if (this.f8310h == -9223372036854775807L) {
            return false;
        }
        this.f8313k.getClass();
        if (android.os.SystemClock.elapsedRealtime() < this.f8310h) {
            return true;
        }
        this.f8310h = -9223372036854775807L;
        return false;
    }

    public final void c(int i2) {
        this.f8306d = Math.min(this.f8306d, i2);
    }

    public final void d() {
        this.f8305c = true;
        this.f8313k.getClass();
        this.f8308f = Util.T(android.os.SystemClock.elapsedRealtime());
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.f8304b;
        videoFrameReleaseHelper.f8319d = true;
        videoFrameReleaseHelper.f8328m = 0L;
        videoFrameReleaseHelper.p = -1L;
        videoFrameReleaseHelper.n = -1L;
        VideoFrameReleaseHelper.DisplayHelper displayHelper = videoFrameReleaseHelper.f8317b;
        if (displayHelper != null) {
            VideoFrameReleaseHelper.VSyncSampler vSyncSampler = videoFrameReleaseHelper.f8318c;
            vSyncSampler.getClass();
            vSyncSampler.f8333b.sendEmptyMessage(2);
            Handler handlerO = Util.o(null);
            DisplayManager displayManager = displayHelper.f8329a;
            displayManager.registerDisplayListener(displayHelper, handlerO);
            VideoFrameReleaseHelper.a(VideoFrameReleaseHelper.this, displayManager.getDisplay(0));
        }
        videoFrameReleaseHelper.d(false);
    }

    public final void e() {
        this.f8305c = false;
        this.f8310h = -9223372036854775807L;
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.f8304b;
        videoFrameReleaseHelper.f8319d = false;
        VideoFrameReleaseHelper.DisplayHelper displayHelper = videoFrameReleaseHelper.f8317b;
        if (displayHelper != null) {
            displayHelper.f8329a.unregisterDisplayListener(displayHelper);
            VideoFrameReleaseHelper.VSyncSampler vSyncSampler = videoFrameReleaseHelper.f8318c;
            vSyncSampler.getClass();
            vSyncSampler.f8333b.sendEmptyMessage(3);
        }
        videoFrameReleaseHelper.b();
    }

    public final void f(float f2) {
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.f8304b;
        videoFrameReleaseHelper.f8321f = f2;
        FixedFrameRateEstimator fixedFrameRateEstimator = videoFrameReleaseHelper.f8316a;
        fixedFrameRateEstimator.f8260a.c();
        fixedFrameRateEstimator.f8261b.c();
        fixedFrameRateEstimator.f8262c = false;
        fixedFrameRateEstimator.f8263d = -9223372036854775807L;
        fixedFrameRateEstimator.f8264e = 0;
        videoFrameReleaseHelper.c();
    }

    public final void g(Surface surface) {
        VideoFrameReleaseHelper videoFrameReleaseHelper = this.f8304b;
        videoFrameReleaseHelper.getClass();
        if (surface instanceof PlaceholderSurface) {
            surface = null;
        }
        if (videoFrameReleaseHelper.f8320e != surface) {
            videoFrameReleaseHelper.b();
            videoFrameReleaseHelper.f8320e = surface;
            videoFrameReleaseHelper.d(true);
        }
        c(1);
    }
}
