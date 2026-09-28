package androidx.media3.session;

import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.session.DefaultMediaNotificationProvider;
import androidx.media3.session.MediaControllerStub;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionImpl;
import androidx.media3.session.MediaSessionStub;
import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public final /* synthetic */ class o0 implements MediaControllerStub.ControllerTask, MediaSessionImpl.RemoteControllerTask, Consumer, MediaSessionStub.SessionTask, MediaSessionStub.MediaItemPlayerTask, MediaSessionStub.MediaItemsWithStartPositionPlayerTask, Function, DefaultMediaNotificationProvider.NotificationIdProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10722a;

    public /* synthetic */ o0(int i2) {
        this.f10722a = i2;
    }

    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
    public void a(MediaControllerImplBase mediaControllerImplBase) {
        int i2 = 2;
        switch (this.f10722a) {
            case 0:
                int i3 = MediaControllerStub.f10021b;
                if (mediaControllerImplBase.isConnected()) {
                    MediaController mediaControllerO = mediaControllerImplBase.o();
                    mediaControllerO.getClass();
                    Assertions.g(Looper.myLooper() == mediaControllerO.f9958e.getLooper());
                    mediaControllerO.f9957d.getClass();
                    break;
                }
                break;
            case 1:
                mediaControllerImplBase.f9978i.f(26, new androidx.media3.exoplayer.i(i2));
                break;
            case 2:
                int i4 = MediaControllerStub.f10021b;
                MediaController mediaControllerO2 = mediaControllerImplBase.o();
                MediaController mediaControllerO3 = mediaControllerImplBase.o();
                Objects.requireNonNull(mediaControllerO3);
                mediaControllerO2.l(new a0(mediaControllerO3, 2));
                break;
            case 3:
                int i5 = MediaControllerStub.f10021b;
                if (mediaControllerImplBase.isConnected()) {
                    MediaController mediaControllerO4 = mediaControllerImplBase.o();
                    mediaControllerO4.getClass();
                    Assertions.g(Looper.myLooper() == mediaControllerO4.f9958e.getLooper());
                    mediaControllerO4.f9957d.getClass();
                    break;
                }
                break;
            default:
                int i6 = MediaControllerStub.f10021b;
                if (mediaControllerImplBase.isConnected()) {
                    MediaController mediaControllerO5 = mediaControllerImplBase.o();
                    mediaControllerO5.getClass();
                    Assertions.g(Looper.myLooper() == mediaControllerO5.f9958e.getLooper());
                    mediaControllerO5.f9957d.getClass();
                    break;
                }
                break;
        }
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        PlayerWrapper playerWrapper = (PlayerWrapper) obj;
        switch (this.f10722a) {
            case 8:
                playerWrapper.pause();
                break;
            case 9:
                playerWrapper.w0();
                break;
            case 10:
                int i2 = MediaSessionStub.f10157h;
                playerWrapper.G0();
                break;
            case 11:
                playerWrapper.w1();
                break;
            case 12:
                playerWrapper.t0();
                break;
            case 13:
                playerWrapper.j0();
                break;
            case 14:
            case 17:
            case 18:
            case 20:
            default:
                playerWrapper.h0();
                break;
            case 15:
                playerWrapper.v1();
                break;
            case 16:
                playerWrapper.I0();
                break;
            case 19:
                int i3 = MediaSessionStub.f10157h;
                playerWrapper.m0();
                break;
            case 21:
                playerWrapper.stop();
                break;
            case 22:
                playerWrapper.p();
                break;
            case 23:
                int i4 = MediaSessionStub.f10157h;
                playerWrapper.k0();
                break;
        }
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        CommandButton commandButton = (CommandButton) obj;
        commandButton.getClass();
        Bundle bundle = new Bundle();
        SessionCommand sessionCommand = commandButton.f9869a;
        if (sessionCommand != null) {
            bundle.putBundle(CommandButton.f9864i, sessionCommand.b());
        }
        int i2 = commandButton.f9870b;
        if (i2 != -1) {
            bundle.putInt(CommandButton.f9865j, i2);
        }
        int i3 = commandButton.f9871c;
        if (i3 != 0) {
            bundle.putInt(CommandButton.p, i3);
        }
        int i4 = commandButton.f9872d;
        if (i4 != 0) {
            bundle.putInt(CommandButton.f9866k, i4);
        }
        CharSequence charSequence = commandButton.f9874f;
        if (charSequence != "") {
            bundle.putCharSequence(CommandButton.f9867l, charSequence);
        }
        Bundle bundle2 = commandButton.f9875g;
        if (!bundle2.isEmpty()) {
            bundle.putBundle(CommandButton.f9868m, bundle2);
        }
        Uri uri = commandButton.f9873e;
        if (uri != null) {
            bundle.putParcelable(CommandButton.o, uri);
        }
        boolean z = commandButton.f9876h;
        if (!z) {
            bundle.putBoolean(CommandButton.n, z);
        }
        return bundle;
    }

    @Override // androidx.media3.session.MediaSessionStub.MediaItemsWithStartPositionPlayerTask
    public void b(PlayerWrapper playerWrapper, MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) {
        MediaUtils.f(playerWrapper, mediaItemsWithStartPosition);
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object c(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
        switch (this.f10722a) {
            case 14:
                int i3 = MediaSessionStub.f10157h;
                ((MediaLibrarySessionImpl) mediaSessionImpl).u(controllerInfo);
                throw null;
            case 17:
                int i4 = MediaSessionStub.f10157h;
                mediaSessionImpl.u(controllerInfo);
                mediaSessionImpl.f10095e.getClass();
                return Futures.d(new SessionResult(-6));
            case 25:
                int i5 = MediaSessionStub.f10157h;
                ((MediaLibrarySessionImpl) mediaSessionImpl).u(controllerInfo);
                throw null;
            default:
                int i6 = MediaSessionStub.f10157h;
                MediaSession mediaSession = mediaSessionImpl.f10101k;
                mediaSessionImpl.u(controllerInfo);
                mediaSessionImpl.f10095e.getClass();
                return Futures.d(new SessionResult(-6));
        }
    }

    @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
    public void d(MediaSession.ControllerCb controllerCb, int i2) {
        switch (this.f10722a) {
            case 5:
                controllerCb.getClass();
                break;
            case 6:
                controllerCb.getClass();
                break;
            default:
                controllerCb.S0(i2);
                break;
        }
    }

    @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
    public void e(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
        switch (this.f10722a) {
            case 18:
                int i2 = MediaSessionStub.f10157h;
                playerWrapper.q1(list);
                break;
            default:
                int i3 = MediaSessionStub.f10157h;
                playerWrapper.q1(list);
                break;
        }
    }

    public /* synthetic */ o0(int i2, int i3, Object obj) {
        this.f10722a = i3;
    }

    public /* synthetic */ o0(Object obj, int i2) {
        this.f10722a = i2;
    }

    public /* synthetic */ o0(String str, Object obj, int i2) {
        this.f10722a = i2;
    }
}
