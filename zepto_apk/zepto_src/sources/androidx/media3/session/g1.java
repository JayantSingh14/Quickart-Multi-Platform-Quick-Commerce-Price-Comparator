package androidx.media3.session;

import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionLegacyStub;

/* loaded from: classes3.dex */
public final /* synthetic */ class g1 implements MediaSessionLegacyStub.SessionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10373a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaSessionLegacyStub f10374b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f10375c;

    public /* synthetic */ g1(MediaSessionLegacyStub mediaSessionLegacyStub, long j2, int i2) {
        this.f10373a = i2;
        this.f10374b = mediaSessionLegacyStub;
        this.f10375c = j2;
    }

    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
    public final void b(MediaSession.ControllerInfo controllerInfo) {
        switch (this.f10373a) {
            case 0:
                this.f10374b.f10115g.s.d1((int) this.f10375c);
                break;
            default:
                this.f10374b.f10115g.s.X(this.f10375c);
                break;
        }
    }
}
