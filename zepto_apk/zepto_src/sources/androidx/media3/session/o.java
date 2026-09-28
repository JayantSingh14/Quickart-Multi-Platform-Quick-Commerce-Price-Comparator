package androidx.media3.session;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.session.MediaControllerImplBase;

/* loaded from: classes3.dex */
public final /* synthetic */ class o implements MediaControllerImplBase.RemoteSessionTask, ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10719a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaControllerImplBase f10720b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10721c;

    public /* synthetic */ o(MediaControllerImplBase mediaControllerImplBase, int i2, int i3) {
        this.f10719a = i3;
        this.f10720b = mediaControllerImplBase;
        this.f10721c = i2;
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void d(IMediaSession iMediaSession, int i2) {
        switch (this.f10719a) {
            case 0:
                iMediaSession.t7(this.f10720b.f9972c, i2, this.f10721c);
                break;
            case 1:
                iMediaSession.T5(this.f10720b.f9972c, i2, this.f10721c);
                break;
            case 5:
                iMediaSession.Qa(this.f10720b.f9972c, i2, this.f10721c);
                break;
            case 7:
                iMediaSession.Z3(this.f10720b.f9972c, i2, this.f10721c);
                break;
            case 10:
                iMediaSession.h7(this.f10720b.f9972c, i2, this.f10721c);
                break;
            default:
                iMediaSession.g6(this.f10720b.f9972c, i2, this.f10721c);
                break;
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        Player.Listener listener = (Player.Listener) obj;
        switch (this.f10719a) {
            case 2:
                listener.m1(this.f10721c, this.f10720b.o.s);
                break;
            case 3:
                listener.m1(this.f10721c, this.f10720b.o.s);
                break;
            case 4:
                listener.m1(this.f10721c, this.f10720b.o.s);
                break;
            case 5:
            case 7:
            default:
                listener.m1(this.f10721c, this.f10720b.o.s);
                break;
            case 6:
                listener.m1(this.f10721c, this.f10720b.o.s);
                break;
            case 8:
                listener.m1(this.f10721c, this.f10720b.o.s);
                break;
        }
    }
}
