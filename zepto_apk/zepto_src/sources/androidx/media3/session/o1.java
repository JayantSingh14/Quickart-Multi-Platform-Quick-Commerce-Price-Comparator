package androidx.media3.session;

import androidx.media3.common.Player;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;

/* loaded from: classes3.dex */
public final /* synthetic */ class o1 implements Consumer, ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10723a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f10724b;

    public /* synthetic */ o1(boolean z, int i2) {
        this.f10723a = i2;
        this.f10724b = z;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        boolean z = this.f10724b;
        PlayerWrapper playerWrapper = (PlayerWrapper) obj;
        switch (this.f10723a) {
            case 0:
                int i2 = MediaSessionStub.f10157h;
                playerWrapper.u0(z);
                break;
            case 1:
                int i3 = MediaSessionStub.f10157h;
                playerWrapper.C0(z);
                break;
            default:
                int i4 = MediaSessionStub.f10157h;
                playerWrapper.P0(z);
                break;
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        ((Player.Listener) obj).k1(this.f10724b);
    }
}
