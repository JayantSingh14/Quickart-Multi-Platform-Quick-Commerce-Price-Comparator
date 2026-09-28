package androidx.media3.session;

import androidx.media3.common.FlagSet;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* loaded from: classes3.dex */
public final /* synthetic */ class k0 implements ListenerSet.Event, ListenerSet.IterationFinishedEvent {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaControllerImplLegacy f10404a;

    public /* synthetic */ k0(MediaControllerImplLegacy mediaControllerImplLegacy) {
        this.f10404a = mediaControllerImplLegacy;
    }

    @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
    public void c(Object obj, FlagSet flagSet) {
        ((Player.Listener) obj).x1(this.f10404a.j(), new Player.Events(flagSet));
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        ((Player.Listener) obj).o1(this.f10404a.f10002m.f10007a.z);
    }
}
