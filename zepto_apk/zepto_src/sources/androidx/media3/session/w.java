package androidx.media3.session;

import androidx.media3.common.MediaItem;
import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionStub;
import com.google.common.collect.ImmutableList;

/* loaded from: classes3.dex */
public final /* synthetic */ class w implements MediaControllerImplBase.RemoteSessionTask, MediaSessionStub.SessionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f10779a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10780b;

    public /* synthetic */ w(long j2, Object obj) {
        this.f10780b = obj;
        this.f10779a = j2;
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object c(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
        int i3 = MediaSessionStub.f10157h;
        return mediaSessionImpl.s(controllerInfo, ImmutableList.t((MediaItem) this.f10780b), 0, this.f10779a);
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void d(IMediaSession iMediaSession, int i2) {
        iMediaSession.i6(((MediaControllerImplBase) this.f10780b).f9972c, i2, this.f10779a);
    }
}
