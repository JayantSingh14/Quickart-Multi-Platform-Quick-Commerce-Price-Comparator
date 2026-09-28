package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import com.google.common.base.Function;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements ListenerSet.Event, Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7194a;

    public /* synthetic */ i(int i2) {
        this.f7194a = i2;
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        return new DefaultAnalyticsCollector((Clock) obj);
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        Player.Listener listener = (Player.Listener) obj;
        switch (this.f7194a) {
            case 0:
                int i2 = ExoPlayerImpl.n0;
                listener.r1(new ExoPlaybackException(2, new ExoTimeoutException("Player release timed out."), 1003));
                break;
            default:
                listener.q1();
                break;
        }
    }
}
