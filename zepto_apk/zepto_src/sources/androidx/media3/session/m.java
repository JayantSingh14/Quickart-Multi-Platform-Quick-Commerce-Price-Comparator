package androidx.media3.session;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.session.MediaControllerImplBase;

/* loaded from: classes3.dex */
public final /* synthetic */ class m implements MediaControllerImplBase.RemoteSessionTask, ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10699a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaControllerImplBase f10700b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f10701c;

    public /* synthetic */ m(MediaControllerImplBase mediaControllerImplBase, boolean z, int i2) {
        this.f10699a = i2;
        this.f10700b = mediaControllerImplBase;
        this.f10701c = z;
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void d(IMediaSession iMediaSession, int i2) {
        switch (this.f10699a) {
            case 0:
                iMediaSession.q3(this.f10700b.f9972c, i2, this.f10701c);
                break;
            case 1:
            default:
                iMediaSession.La(this.f10700b.f9972c, i2, this.f10701c);
                break;
            case 2:
                iMediaSession.d7(this.f10700b.f9972c, i2, this.f10701c);
                break;
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        Player.Listener listener = (Player.Listener) obj;
        switch (this.f10699a) {
            case 1:
                listener.m1(this.f10700b.o.r, this.f10701c);
                break;
            default:
                listener.m1(this.f10700b.o.r, this.f10701c);
                break;
        }
    }
}
