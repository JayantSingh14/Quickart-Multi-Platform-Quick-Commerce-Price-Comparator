package androidx.media3.session;

import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionStub;
import java.util.List;

/* loaded from: classes3.dex */
public final /* synthetic */ class t1 implements MediaSessionStub.SessionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10760a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f10761b;

    public /* synthetic */ t1(List list, int i2) {
        this.f10760a = i2;
        this.f10761b = list;
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public final Object c(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
        List list = this.f10761b;
        switch (this.f10760a) {
            case 0:
                int i3 = MediaSessionStub.f10157h;
                break;
            default:
                int i4 = MediaSessionStub.f10157h;
                break;
        }
        return mediaSessionImpl.l(controllerInfo, list);
    }
}
