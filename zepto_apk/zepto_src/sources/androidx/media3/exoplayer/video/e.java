package androidx.media3.exoplayer.video;

import androidx.media3.common.VideoSize;
import androidx.media3.exoplayer.video.CompositingVideoSinkProvider;
import androidx.media3.exoplayer.video.VideoSink;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8352a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CompositingVideoSinkProvider.VideoSinkImpl f8353b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ VideoSink.Listener f8354c;

    public /* synthetic */ e(CompositingVideoSinkProvider.VideoSinkImpl videoSinkImpl, VideoSink.Listener listener, int i2) {
        this.f8352a = i2;
        this.f8353b = videoSinkImpl;
        this.f8354c = listener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8352a) {
            case 0:
                this.f8353b.getClass();
                this.f8354c.getClass();
                break;
            case 1:
                this.f8353b.getClass();
                this.f8354c.h();
                break;
            default:
                this.f8353b.getClass();
                this.f8354c.e();
                break;
        }
    }

    public /* synthetic */ e(CompositingVideoSinkProvider.VideoSinkImpl videoSinkImpl, VideoSink.Listener listener, VideoSize videoSize) {
        this.f8352a = 0;
        this.f8353b = videoSinkImpl;
        this.f8354c = listener;
    }
}
