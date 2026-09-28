package androidx.media3.session;

import androidx.media3.common.Player;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;

/* loaded from: classes3.dex */
public final /* synthetic */ class v1 implements Consumer, ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10776a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10777b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10778c;

    public /* synthetic */ v1(int i2, int i3, int i4) {
        this.f10776a = i4;
        this.f10777b = i2;
        this.f10778c = i3;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        int i2 = this.f10778c;
        int i3 = this.f10777b;
        PlayerWrapper playerWrapper = (PlayerWrapper) obj;
        switch (this.f10776a) {
            case 0:
                int i4 = MediaSessionStub.f10157h;
                playerWrapper.Z0(i3, i2);
                break;
            default:
                int i5 = MediaSessionStub.f10157h;
                playerWrapper.o1(i3, i2);
                break;
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        ((Player.Listener) obj).s1(this.f10777b, this.f10778c);
    }
}
