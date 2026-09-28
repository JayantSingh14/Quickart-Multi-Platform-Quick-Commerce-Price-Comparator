package androidx.media3.exoplayer.audio;

import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f6651a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6652b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f6653c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f6654d;

    public /* synthetic */ g(AudioRendererEventListener.EventDispatcher eventDispatcher, int i2, long j2, long j3) {
        this.f6651a = eventDispatcher;
        this.f6652b = i2;
        this.f6653c = j2;
        this.f6654d = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRendererEventListener.EventDispatcher eventDispatcher = this.f6651a;
        eventDispatcher.getClass();
        int i2 = Util.f5744a;
        eventDispatcher.f6524b.s(this.f6653c, this.f6654d, this.f6652b);
    }
}
