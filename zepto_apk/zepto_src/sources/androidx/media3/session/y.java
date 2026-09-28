package androidx.media3.session;

import androidx.media3.session.MediaControllerImplBase;

/* loaded from: classes3.dex */
public final /* synthetic */ class y implements MediaControllerImplBase.RemoteSessionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10795a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaControllerImplBase f10796b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10797c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f10798d;

    public /* synthetic */ y(MediaControllerImplBase mediaControllerImplBase, int i2, int i3, int i4) {
        this.f10795a = i4;
        this.f10796b = mediaControllerImplBase;
        this.f10797c = i2;
        this.f10798d = i3;
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public final void d(IMediaSession iMediaSession, int i2) {
        switch (this.f10795a) {
            case 0:
                iMediaSession.b7(this.f10796b.f9972c, i2, this.f10797c, this.f10798d);
                break;
            case 1:
                iMediaSession.B6(this.f10796b.f9972c, i2, this.f10797c, this.f10798d);
                break;
            default:
                iMediaSession.u9(this.f10796b.f9972c, i2, this.f10797c, this.f10798d);
                break;
        }
    }
}
