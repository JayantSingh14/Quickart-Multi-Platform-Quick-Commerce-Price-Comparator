package androidx.media3.exoplayer.video;

import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.video.VideoRendererEventListener;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8366a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f8367b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f8368c;

    public /* synthetic */ i(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters, int i2) {
        this.f8366a = i2;
        this.f8367b = eventDispatcher;
        this.f8368c = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8366a) {
            case 0:
                VideoRendererEventListener.EventDispatcher eventDispatcher = this.f8367b;
                eventDispatcher.getClass();
                int i2 = Util.f5744a;
                eventDispatcher.f8347b.j(this.f8368c);
                break;
            default:
                VideoRendererEventListener.EventDispatcher eventDispatcher2 = this.f8367b;
                DecoderCounters decoderCounters = this.f8368c;
                eventDispatcher2.getClass();
                synchronized (decoderCounters) {
                }
                VideoRendererEventListener videoRendererEventListener = eventDispatcher2.f8347b;
                int i3 = Util.f5744a;
                videoRendererEventListener.v(decoderCounters);
                break;
        }
    }
}
