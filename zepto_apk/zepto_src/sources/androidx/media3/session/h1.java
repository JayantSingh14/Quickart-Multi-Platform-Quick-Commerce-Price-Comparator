package androidx.media3.session;

import androidx.media3.common.Rating;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionLegacyStub;
import com.google.common.util.concurrent.Futures;

/* loaded from: classes3.dex */
public final /* synthetic */ class h1 implements MediaSessionLegacyStub.SessionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10381a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaSessionLegacyStub f10382b;

    public /* synthetic */ h1(MediaSessionLegacyStub mediaSessionLegacyStub, int i2) {
        this.f10381a = i2;
        this.f10382b = mediaSessionLegacyStub;
    }

    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
    public final void b(MediaSession.ControllerInfo controllerInfo) {
        switch (this.f10381a) {
            case 0:
                MediaSessionImpl mediaSessionImpl = this.f10382b.f10115g;
                if (mediaSessionImpl.s.o() != null) {
                    mediaSessionImpl.u(controllerInfo);
                    mediaSessionImpl.f10095e.getClass();
                    Futures.d(new SessionResult(-6));
                    break;
                }
                break;
            case 1:
                this.f10382b.f10115g.s.t0();
                break;
            case 2:
                this.f10382b.f10115g.s.j0();
                break;
            case 3:
                this.f10382b.f10115g.s.w1();
                break;
            case 4:
                this.f10382b.f10115g.s.p();
                break;
            case 5:
                this.f10382b.f10115g.s.v1();
                break;
            case 6:
                this.f10382b.f10115g.s.stop();
                break;
            case 7:
                MediaSessionImpl mediaSessionImpl2 = this.f10382b.f10115g;
                Util.K(mediaSessionImpl2.s, mediaSessionImpl2.p);
                break;
            case 8:
                this.f10382b.f10115g.s.I0();
                break;
            case 9:
                this.f10382b.f10115g.s.w0();
                break;
            case 10:
                this.f10382b.f10115g.g(controllerInfo, true);
                break;
            default:
                Util.I(this.f10382b.f10115g.s);
                break;
        }
    }

    public /* synthetic */ h1(MediaSessionLegacyStub mediaSessionLegacyStub, Rating rating) {
        this.f10381a = 0;
        this.f10382b = mediaSessionLegacyStub;
    }
}
