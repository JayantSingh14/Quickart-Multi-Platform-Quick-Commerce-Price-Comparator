package androidx.media3.session;

import androidx.media3.common.Player;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;

/* loaded from: classes3.dex */
public final /* synthetic */ class p1 implements Consumer, ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10732a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f10733b;

    public /* synthetic */ p1(float f2, int i2) {
        this.f10732a = i2;
        this.f10733b = f2;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        float f2 = this.f10733b;
        PlayerWrapper playerWrapper = (PlayerWrapper) obj;
        switch (this.f10732a) {
            case 0:
                int i2 = MediaSessionStub.f10157h;
                playerWrapper.C(f2);
                break;
            default:
                int i3 = MediaSessionStub.f10157h;
                playerWrapper.b1(f2);
                break;
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        ((Player.Listener) obj).z1(this.f10733b);
    }
}
