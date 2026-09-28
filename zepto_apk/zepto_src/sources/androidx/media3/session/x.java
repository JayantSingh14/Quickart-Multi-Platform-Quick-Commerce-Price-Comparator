package androidx.media3.session;

import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* loaded from: classes3.dex */
public final /* synthetic */ class x implements ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10789a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PlaybackException f10790b;

    public /* synthetic */ x(int i2, PlaybackException playbackException) {
        this.f10789a = i2;
        this.f10790b = playbackException;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public final void invoke(Object obj) {
        Player.Listener listener = (Player.Listener) obj;
        switch (this.f10789a) {
            case 0:
                listener.H1(this.f10790b);
                break;
            case 1:
                listener.r1(this.f10790b);
                break;
            case 2:
                listener.H1(this.f10790b);
                break;
            default:
                listener.r1(this.f10790b);
                break;
        }
    }
}
