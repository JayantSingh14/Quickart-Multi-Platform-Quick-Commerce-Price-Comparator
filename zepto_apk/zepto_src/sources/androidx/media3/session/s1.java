package androidx.media3.session;

import androidx.media3.common.AudioAttributes;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Consumer;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionStub;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* loaded from: classes3.dex */
public final /* synthetic */ class s1 implements MediaSessionStub.SessionTask, Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10750a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f10751b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10752c;

    public /* synthetic */ s1(Object obj, boolean z, int i2) {
        this.f10750a = i2;
        this.f10752c = obj;
        this.f10751b = z;
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        int i2 = MediaSessionStub.f10157h;
        ((PlayerWrapper) obj).W0((AudioAttributes) this.f10752c, this.f10751b);
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object c(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
        Object obj = this.f10752c;
        boolean z = this.f10751b;
        switch (this.f10750a) {
            case 0:
                int i3 = MediaSessionStub.f10157h;
                return mediaSessionImpl.s(controllerInfo, ImmutableList.t((MediaItem) obj), z ? -1 : mediaSessionImpl.s.l1(), z ? -9223372036854775807L : mediaSessionImpl.s.z1());
            default:
                int i4 = MediaSessionStub.f10157h;
                return mediaSessionImpl.s(controllerInfo, (List) obj, z ? -1 : mediaSessionImpl.s.l1(), z ? -9223372036854775807L : mediaSessionImpl.s.z1());
        }
    }
}
