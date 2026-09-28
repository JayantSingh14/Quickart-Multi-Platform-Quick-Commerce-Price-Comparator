package androidx.media3.exoplayer.upstream;

import androidx.media3.exoplayer.upstream.BandwidthMeter;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener f8201a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f8202b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f8203c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f8204d;

    public /* synthetic */ a(BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener handlerAndListener, int i2, long j2, long j3) {
        this.f8201a = handlerAndListener;
        this.f8202b = i2;
        this.f8203c = j2;
        this.f8204d = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8201a.f8063b.z(this.f8203c, this.f8204d, this.f8202b);
    }
}
