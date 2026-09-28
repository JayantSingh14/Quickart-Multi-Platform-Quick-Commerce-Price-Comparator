package androidx.media3.session;

import androidx.media3.common.Timeline;

/* loaded from: classes3.dex */
public final /* synthetic */ class k1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10405a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaSessionLegacyStub f10406b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PlayerWrapper f10407c;

    public /* synthetic */ k1(MediaSessionLegacyStub mediaSessionLegacyStub, PlayerWrapper playerWrapper, int i2) {
        this.f10405a = i2;
        this.f10406b = mediaSessionLegacyStub;
        this.f10407c = playerWrapper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PlayerWrapper playerWrapper = this.f10407c;
        MediaSessionLegacyStub mediaSessionLegacyStub = this.f10406b;
        switch (this.f10405a) {
            case 0:
                int i2 = MediaSessionLegacyStub.r;
                mediaSessionLegacyStub.getClass();
                mediaSessionLegacyStub.f10119k.l(playerWrapper.k());
                break;
            default:
                int i3 = MediaSessionLegacyStub.r;
                mediaSessionLegacyStub.getClass();
                mediaSessionLegacyStub.f10119k.l(playerWrapper.k());
                mediaSessionLegacyStub.f10117i.o(playerWrapper.N0().a(17) ? playerWrapper.F0() : Timeline.f5466a);
                break;
        }
    }
}
