package androidx.media3.exoplayer;

import androidx.media3.common.FlagSet;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.ExoPlayerImplInternal;

/* loaded from: classes3.dex */
public final /* synthetic */ class l implements ListenerSet.Event, ListenerSet.IterationFinishedEvent, ExoPlayerImplInternal.PlaybackInfoUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7270a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl f7271b;

    public /* synthetic */ l(ExoPlayerImpl exoPlayerImpl, int i2) {
        this.f7270a = i2;
        this.f7271b = exoPlayerImpl;
    }

    public void a(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        int i2 = ExoPlayerImpl.n0;
        ExoPlayerImpl exoPlayerImpl = this.f7271b;
        exoPlayerImpl.getClass();
        exoPlayerImpl.f6204i.i(new m(0, exoPlayerImpl, playbackInfoUpdate));
    }

    @Override // androidx.media3.common.util.ListenerSet.IterationFinishedEvent
    public void c(Object obj, FlagSet flagSet) {
        int i2 = ExoPlayerImpl.n0;
        ExoPlayerImpl exoPlayerImpl = this.f7271b;
        exoPlayerImpl.getClass();
        ((Player.Listener) obj).x1(exoPlayerImpl.f6201f, new Player.Events(flagSet));
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        Player.Listener listener = (Player.Listener) obj;
        switch (this.f7270a) {
            case 0:
                listener.C1(this.f7271b.N);
                break;
            default:
                listener.t1(this.f7271b.L);
                break;
        }
    }
}
