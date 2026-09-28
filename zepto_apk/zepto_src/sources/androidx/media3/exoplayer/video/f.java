package androidx.media3.exoplayer.video;

import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.video.VideoRendererEventListener;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8355a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f8356b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8357c;

    public /* synthetic */ f(VideoRendererEventListener.EventDispatcher eventDispatcher, Object obj, int i2) {
        this.f8355a = i2;
        this.f8356b = eventDispatcher;
        this.f8357c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = this.f8357c;
        VideoRendererEventListener.EventDispatcher eventDispatcher = this.f8356b;
        int i2 = this.f8355a;
        eventDispatcher.getClass();
        switch (i2) {
            case 0:
                int i3 = Util.f5744a;
                eventDispatcher.f8347b.b((VideoSize) obj);
                break;
            case 1:
                int i4 = Util.f5744a;
                eventDispatcher.f8347b.n((Exception) obj);
                break;
            default:
                int i5 = Util.f5744a;
                eventDispatcher.f8347b.f((String) obj);
                break;
        }
    }
}
