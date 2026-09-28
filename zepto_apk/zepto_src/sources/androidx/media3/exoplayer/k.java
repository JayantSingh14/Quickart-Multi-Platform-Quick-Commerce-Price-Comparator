package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* loaded from: classes3.dex */
public final /* synthetic */ class k implements ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7268a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f7269b;

    public /* synthetic */ k(boolean z, int i2) {
        this.f7268a = i2;
        this.f7269b = z;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public final void invoke(Object obj) {
        boolean z = this.f7269b;
        Player.Listener listener = (Player.Listener) obj;
        switch (this.f7268a) {
            case 0:
                int i2 = ExoPlayerImpl.n0;
                listener.k1(z);
                break;
            default:
                listener.d(z);
                break;
        }
    }
}
