package androidx.media3.session;

import androidx.media3.common.Player;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.session.MediaBrowser;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements Consumer, ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10357a;

    public /* synthetic */ f() {
        this.f10357a = 2;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        MediaBrowser.Listener listener = (MediaBrowser.Listener) obj;
        switch (this.f10357a) {
            case 0:
                listener.getClass();
                break;
            default:
                listener.getClass();
                break;
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        ((Player.Listener) obj).i1(1);
    }
}
