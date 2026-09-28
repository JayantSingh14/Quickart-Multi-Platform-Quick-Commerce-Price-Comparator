package androidx.media3.exoplayer.source.ads;

import androidx.media3.exoplayer.source.ads.AdsMediaSource;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7815a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AdsMediaSource f7816b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AdsMediaSource.ComponentListener f7817c;

    public /* synthetic */ a(AdsMediaSource adsMediaSource, AdsMediaSource.ComponentListener componentListener, int i2) {
        this.f7815a = i2;
        this.f7816b = adsMediaSource;
        this.f7817c = componentListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7815a) {
            case 0:
                AdsMediaSource adsMediaSource = this.f7816b;
                adsMediaSource.n.a(adsMediaSource, adsMediaSource.p, adsMediaSource.q, adsMediaSource.o, this.f7817c);
                break;
            default:
                AdsMediaSource adsMediaSource2 = this.f7816b;
                adsMediaSource2.n.b(adsMediaSource2, this.f7817c);
                break;
        }
    }
}
