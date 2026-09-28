package androidx.media3.exoplayer.audio;

import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.video.VideoRendererEventListener;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6643a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f6644b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f6645c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f6646d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f6647e;

    public /* synthetic */ e(Object obj, String str, long j2, long j3, int i2) {
        this.f6643a = i2;
        this.f6647e = obj;
        this.f6644b = str;
        this.f6645c = j2;
        this.f6646d = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.f6647e;
        switch (this.f6643a) {
            case 0:
                AudioRendererEventListener.EventDispatcher eventDispatcher = (AudioRendererEventListener.EventDispatcher) obj;
                eventDispatcher.getClass();
                int i2 = Util.f5744a;
                eventDispatcher.f6524b.q(this.f6645c, this.f6646d, this.f6644b);
                break;
            default:
                VideoRendererEventListener.EventDispatcher eventDispatcher2 = (VideoRendererEventListener.EventDispatcher) obj;
                eventDispatcher2.getClass();
                int i3 = Util.f5744a;
                eventDispatcher2.f8347b.x(this.f6645c, this.f6646d, this.f6644b);
                break;
        }
    }
}
