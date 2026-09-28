package androidx.media3.exoplayer.video;

import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.exoplayer.video.CompositingVideoSinkProvider;
import androidx.media3.exoplayer.video.VideoFrameReleaseControl;

/* loaded from: classes3.dex */
final class VideoFrameRenderControl {

    /* renamed from: a, reason: collision with root package name */
    public final CompositingVideoSinkProvider.FrameRendererImpl f8336a;

    /* renamed from: b, reason: collision with root package name */
    public final VideoFrameReleaseControl f8337b;

    /* renamed from: g, reason: collision with root package name */
    public VideoSize f8342g;

    /* renamed from: i, reason: collision with root package name */
    public long f8344i;

    /* renamed from: c, reason: collision with root package name */
    public final VideoFrameReleaseControl.FrameReleaseInfo f8338c = new VideoFrameReleaseControl.FrameReleaseInfo();

    /* renamed from: d, reason: collision with root package name */
    public final TimedValueQueue f8339d = new TimedValueQueue();

    /* renamed from: e, reason: collision with root package name */
    public final TimedValueQueue f8340e = new TimedValueQueue();

    /* renamed from: f, reason: collision with root package name */
    public final LongArrayQueue f8341f = new LongArrayQueue();

    /* renamed from: h, reason: collision with root package name */
    public VideoSize f8343h = VideoSize.f5559e;

    /* renamed from: j, reason: collision with root package name */
    public long f8345j = -9223372036854775807L;

    public interface FrameRenderer {
    }

    public VideoFrameRenderControl(CompositingVideoSinkProvider.FrameRendererImpl frameRendererImpl, VideoFrameReleaseControl videoFrameReleaseControl) {
        this.f8336a = frameRendererImpl;
        this.f8337b = videoFrameReleaseControl;
    }

    public final void a() {
        LongArrayQueue longArrayQueue = this.f8341f;
        longArrayQueue.f5705a = 0;
        longArrayQueue.f5706b = 0;
        this.f8345j = -9223372036854775807L;
        TimedValueQueue timedValueQueue = this.f8340e;
        if (timedValueQueue.h() > 0) {
            Assertions.a(timedValueQueue.h() > 0);
            while (timedValueQueue.h() > 1) {
                timedValueQueue.e();
            }
            Object objE = timedValueQueue.e();
            objE.getClass();
            timedValueQueue.a(0L, (Long) objE);
        }
        VideoSize videoSize = this.f8342g;
        TimedValueQueue timedValueQueue2 = this.f8339d;
        if (videoSize != null) {
            timedValueQueue2.b();
            return;
        }
        if (timedValueQueue2.h() > 0) {
            Assertions.a(timedValueQueue2.h() > 0);
            while (timedValueQueue2.h() > 1) {
                timedValueQueue2.e();
            }
            Object objE2 = timedValueQueue2.e();
            objE2.getClass();
            this.f8342g = (VideoSize) objE2;
        }
    }
}
