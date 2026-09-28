package androidx.media3.session;

import androidx.media3.common.FlagSet;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.session.MediaControllerImplBase;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements ListenerSet.IterationFinishedEvent, MediaControllerImplBase.RemoteSessionTask, ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10383a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaControllerImplBase f10384b;

    public /* synthetic */ i(MediaControllerImplBase mediaControllerImplBase, int i2) {
        this.f10383a = i2;
        this.f10384b = mediaControllerImplBase;
    }

    @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
    public void c(Object obj, FlagSet flagSet) {
        ((Player.Listener) obj).x1(this.f10384b.o(), new Player.Events(flagSet));
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void d(IMediaSession iMediaSession, int i2) {
        switch (this.f10383a) {
            case 1:
                iMediaSession.v5(this.f10384b.f9972c, i2);
                break;
            case 2:
                iMediaSession.u2(this.f10384b.f9972c, i2);
                break;
            case 3:
                iMediaSession.Va(this.f10384b.f9972c, i2);
                break;
            case 4:
                iMediaSession.K1(this.f10384b.f9972c, i2);
                break;
            case 5:
                iMediaSession.Ia(this.f10384b.f9972c, i2);
                break;
            case 6:
                iMediaSession.ga(this.f10384b.f9972c, i2);
                break;
            case 7:
                iMediaSession.s4(this.f10384b.f9972c, i2);
                break;
            case 8:
                iMediaSession.O8(this.f10384b.f9972c, i2);
                break;
            case 9:
                iMediaSession.j8(this.f10384b.f9972c, i2, null);
                break;
            case 10:
                MediaControllerImplBase mediaControllerImplBase = this.f10384b;
                iMediaSession.j8(mediaControllerImplBase.f9972c, i2, mediaControllerImplBase.v);
                break;
            case 11:
                iMediaSession.l4(this.f10384b.f9972c, i2);
                break;
            case 12:
                iMediaSession.j8(this.f10384b.f9972c, i2, null);
                break;
            case 13:
                iMediaSession.za(this.f10384b.f9972c, i2);
                break;
            case 14:
                iMediaSession.F1(this.f10384b.f9972c, i2);
                break;
            case 15:
                iMediaSession.h6(this.f10384b.f9972c, i2);
                break;
            case 16:
                iMediaSession.qb(this.f10384b.f9972c, i2);
                break;
            case 17:
                iMediaSession.j8(this.f10384b.f9972c, i2, null);
                break;
            default:
                iMediaSession.M5(this.f10384b.f9972c, i2);
                break;
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        Player.Listener listener = (Player.Listener) obj;
        switch (this.f10383a) {
            case 18:
                listener.t1(this.f10384b.u);
                break;
            default:
                listener.t1(this.f10384b.u);
                break;
        }
    }
}
