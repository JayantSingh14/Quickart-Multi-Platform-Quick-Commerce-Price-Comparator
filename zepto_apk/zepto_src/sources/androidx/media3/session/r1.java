package androidx.media3.session;

import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;

/* loaded from: classes3.dex */
public final /* synthetic */ class r1 implements Consumer, ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10743a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PlaybackParameters f10744b;

    public /* synthetic */ r1(PlaybackParameters playbackParameters, int i2) {
        this.f10743a = i2;
        this.f10744b = playbackParameters;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        int i2 = MediaSessionStub.f10157h;
        ((PlayerWrapper) obj).D(this.f10744b);
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        Player.Listener listener = (Player.Listener) obj;
        switch (this.f10743a) {
            case 1:
                listener.l1(this.f10744b);
                break;
            default:
                listener.l1(this.f10744b);
                break;
        }
    }
}
