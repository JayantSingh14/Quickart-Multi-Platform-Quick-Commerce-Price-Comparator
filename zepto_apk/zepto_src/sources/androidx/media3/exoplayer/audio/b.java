package androidx.media3.exoplayer.audio;

import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6634a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f6635b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f6636c;

    public /* synthetic */ b(AudioRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters, int i2) {
        this.f6634a = i2;
        this.f6635b = eventDispatcher;
        this.f6636c = decoderCounters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6634a) {
            case 0:
                AudioRendererEventListener.EventDispatcher eventDispatcher = this.f6635b;
                eventDispatcher.getClass();
                int i2 = Util.f5744a;
                eventDispatcher.f6524b.i(this.f6636c);
                break;
            default:
                AudioRendererEventListener.EventDispatcher eventDispatcher2 = this.f6635b;
                DecoderCounters decoderCounters = this.f6636c;
                eventDispatcher2.getClass();
                synchronized (decoderCounters) {
                }
                AudioRendererEventListener audioRendererEventListener = eventDispatcher2.f6524b;
                int i3 = Util.f5744a;
                audioRendererEventListener.p(decoderCounters);
                break;
        }
    }
}
