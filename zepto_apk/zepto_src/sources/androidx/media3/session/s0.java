package androidx.media3.session;

import android.os.RemoteException;
import android.view.Surface;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Player;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.session.MediaControllerStub;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionStub;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;

/* loaded from: classes3.dex */
public final /* synthetic */ class s0 implements MediaControllerStub.ControllerTask, MediaSessionStub.SessionTask, Consumer, MediaSessionStub.ControllerPlayerTask, ListenerSet.Event {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10748a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10749b;

    public /* synthetic */ s0(Object obj, int i2) {
        this.f10748a = i2;
        this.f10749b = obj;
    }

    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
    public void a(MediaControllerImplBase mediaControllerImplBase) throws RemoteException {
        Object obj = this.f10749b;
        switch (this.f10748a) {
            case 0:
                int i2 = MediaControllerStub.f10021b;
                if (mediaControllerImplBase.z != null) {
                    Log.d("MCImplBase", "Cannot be notified about the connection result many times. Probably a bug or malicious app.");
                    mediaControllerImplBase.o().release();
                    break;
                } else {
                    ConnectionState connectionState = (ConnectionState) obj;
                    mediaControllerImplBase.z = connectionState.f9910c;
                    mediaControllerImplBase.r = connectionState.f9912e;
                    Player.Commands commands = connectionState.f9913f;
                    mediaControllerImplBase.s = commands;
                    Player.Commands commands2 = connectionState.f9914g;
                    mediaControllerImplBase.t = commands2;
                    Player.Commands commandsI = MediaControllerImplBase.i(commands, commands2);
                    mediaControllerImplBase.u = commandsI;
                    ImmutableList immutableList = connectionState.f9918k;
                    mediaControllerImplBase.p = immutableList;
                    mediaControllerImplBase.q = CommandButton.a(immutableList, mediaControllerImplBase.r, commandsI);
                    mediaControllerImplBase.o = connectionState.f9917j;
                    try {
                        connectionState.f9910c.asBinder().linkToDeath(mediaControllerImplBase.f9976g, 0);
                        SessionToken sessionToken = mediaControllerImplBase.f9974e;
                        mediaControllerImplBase.f9981l = new SessionToken(sessionToken.f10269a.a(), connectionState.f9908a, connectionState.f9909b, sessionToken.f10269a.V(), connectionState.f9910c, connectionState.f9915h);
                        mediaControllerImplBase.o().k();
                        break;
                    } catch (RemoteException unused) {
                        mediaControllerImplBase.o().release();
                        return;
                    }
                }
            default:
                int i3 = MediaControllerStub.f10021b;
                if (mediaControllerImplBase.isConnected() && mediaControllerImplBase.f9980k.isEmpty()) {
                    SessionPositionInfo sessionPositionInfo = mediaControllerImplBase.o.f10170c;
                    SessionPositionInfo sessionPositionInfo2 = (SessionPositionInfo) obj;
                    if (sessionPositionInfo.f10251c < sessionPositionInfo2.f10251c && MediaUtils.a(sessionPositionInfo2, sessionPositionInfo)) {
                        mediaControllerImplBase.o = mediaControllerImplBase.o.e(sessionPositionInfo2);
                        break;
                    }
                }
                break;
        }
    }

    @Override // androidx.media3.common.util.Consumer
    public void accept(Object obj) {
        int i2 = MediaSessionStub.f10157h;
        ((PlayerWrapper) obj).e0((Surface) this.f10749b);
    }

    @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
    public void b(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
        int i2 = MediaSessionStub.f10157h;
        ((Consumer) this.f10749b).accept(playerWrapper);
    }

    @Override // androidx.media3.session.MediaSessionStub.SessionTask
    public Object c(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
        Object obj = this.f10749b;
        switch (this.f10748a) {
            case 2:
                int i3 = MediaSessionStub.f10157h;
                ((MediaLibrarySessionImpl) mediaSessionImpl).u(controllerInfo);
                throw null;
            case 3:
                int i4 = MediaSessionStub.f10157h;
                return mediaSessionImpl.l(controllerInfo, (ImmutableList) obj);
            case 4:
            default:
                int i5 = MediaSessionStub.f10157h;
                if (mediaSessionImpl.j()) {
                    return Futures.e();
                }
                ((MediaSessionStub.ControllerPlayerTask) obj).b(mediaSessionImpl.s, controllerInfo);
                MediaSessionStub.A4(controllerInfo, i2, new SessionResult(0));
                return Futures.e();
            case 5:
                int i6 = MediaSessionStub.f10157h;
                return ((MediaLibrarySessionImpl) mediaSessionImpl).z(controllerInfo, (MediaLibraryService.LibraryParams) obj);
        }
    }

    @Override // androidx.media3.common.util.ListenerSet.Event
    public void invoke(Object obj) {
        Player.Listener listener = (Player.Listener) obj;
        switch (this.f10748a) {
            case 8:
                listener.p1((TrackSelectionParameters) this.f10749b);
                break;
            default:
                listener.A1((AudioAttributes) this.f10749b);
                break;
        }
    }
}
