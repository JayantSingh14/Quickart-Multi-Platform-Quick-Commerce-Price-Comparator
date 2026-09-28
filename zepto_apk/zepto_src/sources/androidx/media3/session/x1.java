package androidx.media3.session;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Player;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;

/* loaded from: classes3.dex */
public final /* synthetic */ class x1 implements Consumer, ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaMetadata f10794a;

    public /* synthetic */ x1(MediaMetadata mediaMetadata) {
        this.f10794a = mediaMetadata;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        int i2 = MediaSessionStub.f10157h;
        ((PlayerWrapper) obj).q0(this.f10794a);
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        ((Player.Listener) obj).C1(this.f10794a);
    }
}
