package androidx.media3.session;

import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionStub;
import java.util.List;

/* loaded from: classes3.dex */
public final /* synthetic */ class n implements MediaControllerImplBase.RemoteSessionTask, MediaSessionStub.ControllerPlayerTask, MediaSessionStub.SessionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10707a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f10708b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10709c;

    public /* synthetic */ n(Object obj, int i2, long j2) {
        this.f10709c = obj;
        this.f10707a = i2;
        this.f10708b = j2;
    }

    @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
    public void b(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
        int i2 = MediaSessionStub.f10157h;
        playerWrapper.M0(((MediaSessionStub) this.f10709c).V2(controllerInfo, playerWrapper, this.f10707a), this.f10708b);
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object c(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
        int i3 = MediaSessionStub.f10157h;
        int i4 = this.f10707a;
        return mediaSessionImpl.s(controllerInfo, (List) this.f10709c, i4 == -1 ? mediaSessionImpl.s.l1() : i4, i4 == -1 ? mediaSessionImpl.s.z1() : this.f10708b);
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void d(IMediaSession iMediaSession, int i2) {
        iMediaSession.q7(((MediaControllerImplBase) this.f10709c).f9972c, i2, this.f10707a, this.f10708b);
    }
}
