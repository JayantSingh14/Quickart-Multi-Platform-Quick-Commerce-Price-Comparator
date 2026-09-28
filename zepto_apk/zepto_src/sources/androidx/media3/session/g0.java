package androidx.media3.session;

import androidx.media3.session.MediaControllerImplBase;

/* loaded from: classes3.dex */
public final /* synthetic */ class g0 implements MediaControllerImplBase.RemoteSessionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10371a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaControllerImplBase.SurfaceCallback f10372b;

    public /* synthetic */ g0(MediaControllerImplBase.SurfaceCallback surfaceCallback, int i2) {
        this.f10371a = i2;
        this.f10372b = surfaceCallback;
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public final void d(IMediaSession iMediaSession, int i2) {
        switch (this.f10371a) {
            case 0:
                MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
                iMediaSession.j8(mediaControllerImplBase.f9972c, i2, mediaControllerImplBase.v);
                break;
            case 1:
                iMediaSession.j8(MediaControllerImplBase.this.f9972c, i2, null);
                break;
            case 2:
                MediaControllerImplBase mediaControllerImplBase2 = MediaControllerImplBase.this;
                iMediaSession.j8(mediaControllerImplBase2.f9972c, i2, mediaControllerImplBase2.v);
                break;
            default:
                iMediaSession.j8(MediaControllerImplBase.this.f9972c, i2, null);
                break;
        }
    }
}
