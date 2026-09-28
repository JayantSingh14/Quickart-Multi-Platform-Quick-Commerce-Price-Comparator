package androidx.media3.session;

import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionLegacyStub;

/* loaded from: classes3.dex */
public final /* synthetic */ class z implements MediaControllerImplBase.RemoteSessionTask, MediaSessionLegacyStub.SessionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10804a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10805b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f10806c;

    public /* synthetic */ z(Object obj, float f2, int i2) {
        this.f10804a = i2;
        this.f10805b = obj;
        this.f10806c = f2;
    }

    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
    public void b(MediaSession.ControllerInfo controllerInfo) {
        ((MediaSessionLegacyStub) this.f10805b).f10115g.s.C(this.f10806c);
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void d(IMediaSession iMediaSession, int i2) {
        switch (this.f10804a) {
            case 0:
                iMediaSession.E6(((MediaControllerImplBase) this.f10805b).f9972c, i2, this.f10806c);
                break;
            default:
                iMediaSession.y6(((MediaControllerImplBase) this.f10805b).f9972c, i2, this.f10806c);
                break;
        }
    }
}
