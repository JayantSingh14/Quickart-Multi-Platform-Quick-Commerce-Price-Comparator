package androidx.media3.exoplayer.video;

import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.video.VideoRendererEventListener;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8358a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f8359b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f8360c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f8361d;

    public /* synthetic */ g(VideoRendererEventListener.EventDispatcher eventDispatcher, int i2, long j2) {
        this.f8359b = eventDispatcher;
        this.f8361d = i2;
        this.f8360c = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f8361d;
        long j2 = this.f8360c;
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.f8359b;
        int i3 = this.f8358a;
        eventDispatcher.getClass();
        switch (i3) {
            case 0:
                int i4 = Util.f5744a;
                eventDispatcher.f8347b.t(i2, j2);
                break;
            default:
                int i5 = Util.f5744a;
                eventDispatcher.f8347b.r(i2, j2);
                break;
        }
    }

    public /* synthetic */ g(VideoRendererEventListener.EventDispatcher eventDispatcher, long j2, int i2) {
        this.f8359b = eventDispatcher;
        this.f8360c = j2;
        this.f8361d = i2;
    }
}
