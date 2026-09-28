package androidx.media3.session;

import android.view.Surface;
import androidx.media3.session.MediaControllerImplBase;

/* loaded from: classes3.dex */
public final /* synthetic */ class t implements MediaControllerImplBase.RemoteSessionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10753a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaControllerImplBase f10754b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Surface f10755c;

    public /* synthetic */ t(MediaControllerImplBase mediaControllerImplBase, Surface surface, int i2) {
        this.f10753a = i2;
        this.f10754b = mediaControllerImplBase;
        this.f10755c = surface;
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public final void d(IMediaSession iMediaSession, int i2) {
        switch (this.f10753a) {
            case 0:
                iMediaSession.j8(this.f10754b.f9972c, i2, this.f10755c);
                break;
            default:
                iMediaSession.j8(this.f10754b.f9972c, i2, this.f10755c);
                break;
        }
    }
}
