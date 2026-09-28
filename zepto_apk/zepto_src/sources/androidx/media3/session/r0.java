package androidx.media3.session;

import android.os.Bundle;
import android.os.Looper;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaControllerStub;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionStub;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

/* loaded from: classes3.dex */
public final /* synthetic */ class r0 implements MediaControllerStub.ControllerTask, Consumer, MediaSessionStub.SessionTask, ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10741a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10742b;

    public /* synthetic */ r0(int i2, int i3) {
        this.f10741a = i3;
        this.f10742b = i2;
    }

    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
    public void a(MediaControllerImplBase mediaControllerImplBase) {
        int i2 = MediaControllerStub.f10021b;
        if (mediaControllerImplBase.isConnected()) {
            MediaController mediaControllerO = mediaControllerImplBase.o();
            mediaControllerO.getClass();
            Assertions.g(Looper.myLooper() == mediaControllerO.f9958e.getLooper());
            mediaControllerO.f9957d.getClass();
            ListenableFuture listenableFutureB = MediaController.Listener.B();
            listenableFutureB.q(new y0(mediaControllerImplBase, listenableFutureB, this.f10742b), MoreExecutors.a());
        }
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        int i2 = this.f10742b;
        PlayerWrapper playerWrapper = (PlayerWrapper) obj;
        switch (this.f10741a) {
            case 1:
                int i3 = MediaSessionStub.f10157h;
                playerWrapper.x0(i2);
                break;
            case 2:
                int i4 = MediaSessionStub.f10157h;
                playerWrapper.n0(i2);
                break;
            case 3:
                int i5 = MediaSessionStub.f10157h;
                playerWrapper.d0(i2);
                break;
            default:
                int i6 = MediaSessionStub.f10157h;
                playerWrapper.u1(i2);
                break;
        }
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object c(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
        MediaLibrarySessionImpl mediaLibrarySessionImpl = (MediaLibrarySessionImpl) mediaSessionImpl;
        int i3 = MediaSessionStub.f10157h;
        mediaLibrarySessionImpl.getClass();
        mediaLibrarySessionImpl.u(controllerInfo);
        throw null;
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        ((Player.Listener) obj).d1(this.f10742b);
    }

    public /* synthetic */ r0(int i2, SessionCommand sessionCommand, Bundle bundle) {
        this.f10741a = 0;
        this.f10742b = i2;
    }

    public /* synthetic */ r0(String str, int i2, int i3, MediaLibraryService.LibraryParams libraryParams) {
        this.f10741a = 4;
        this.f10742b = i3;
    }
}
