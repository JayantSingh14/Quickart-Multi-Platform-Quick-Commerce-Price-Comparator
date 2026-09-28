package androidx.media3.session;

import android.os.Bundle;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.session.MediaControllerImplLegacy;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionImpl;
import androidx.media3.session.MediaSessionLegacyStub;

/* loaded from: classes3.dex */
public final /* synthetic */ class j0 implements ListenerSet.Event, MediaSessionImpl.RemoteControllerTask, MediaSessionLegacyStub.SessionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f10393a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10394b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10395c;

    public /* synthetic */ j0(Object obj, Object obj2, Object obj3) {
        this.f10393a = obj;
        this.f10394b = obj2;
        this.f10395c = obj3;
    }

    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
    public void b(MediaSession.ControllerInfo controllerInfo) {
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.f10393a;
        Bundle bundle = (Bundle) this.f10395c;
        if (bundle == null) {
            int i2 = MediaSessionLegacyStub.r;
            mediaSessionLegacyStub.getClass();
            bundle = Bundle.EMPTY;
        }
        mediaSessionLegacyStub.f10115g.n(controllerInfo, (SessionCommand) this.f10394b, bundle);
    }

    @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
    public void d(MediaSession.ControllerCb controllerCb, int i2) {
        ((MediaLibrarySessionImpl) this.f10393a).getClass();
        throw null;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        ((Player.Listener) obj).v1(((Integer) this.f10395c).intValue(), ((MediaControllerImplLegacy.ControllerInfo) this.f10393a).f10007a.f10170c.f10249a, ((MediaControllerImplLegacy.ControllerInfo) this.f10394b).f10007a.f10170c.f10249a);
    }
}
