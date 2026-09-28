package androidx.media3.session;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.session.MediaBrowser;
import androidx.media3.session.MediaControllerStub;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionImpl;
import androidx.media3.session.legacy.MediaBrowserServiceCompat;
import androidx.media3.session.legacy.MediaControllerCompat;
import androidx.media3.session.legacy.MediaSessionCompat;
import androidx.media3.session.legacy.MediaSessionManager;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* loaded from: classes3.dex */
public final /* synthetic */ class l0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10412a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10413b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10414c;

    public /* synthetic */ l0(int i2, Object obj, Object obj2) {
        this.f10412a = i2;
        this.f10413b = obj;
        this.f10414c = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        SessionResult sessionResult;
        Object obj = this.f10414c;
        Object obj2 = this.f10413b;
        switch (this.f10412a) {
            case 0:
                MediaControllerImplLegacy mediaControllerImplLegacy = (MediaControllerImplLegacy) obj2;
                MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(mediaControllerImplLegacy.f9990a, (MediaSessionCompat.Token) obj);
                mediaControllerImplLegacy.f9996g = mediaControllerCompat;
                mediaControllerCompat.s(mediaControllerImplLegacy.f9994e, mediaControllerImplLegacy.j().f9958e);
                break;
            case 1:
                int i2 = MediaControllerStub.f10021b;
                MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) obj2;
                if (!mediaControllerImplBase.n) {
                    ((MediaControllerStub.ControllerTask) obj).a(mediaControllerImplBase);
                    break;
                }
                break;
            case 2:
                ListenableFuture listenableFuture = (ListenableFuture) obj2;
                MediaBrowserServiceCompat.Result result = (MediaBrowserServiceCompat.Result) obj;
                int i3 = MediaLibraryServiceLegacyStub.o;
                try {
                    SessionResult sessionResult2 = (SessionResult) listenableFuture.get();
                    Assertions.e(sessionResult2, "SessionResult must not be null");
                    result.f(sessionResult2.f10264b);
                    break;
                } catch (InterruptedException | CancellationException | ExecutionException e2) {
                    Log.i("MLSLegacyStub", "Custom action failed", e2);
                    result.e();
                    return;
                }
            case 3:
                int i4 = MediaLibraryServiceLegacyStub.o;
                if (((SettableFuture) obj2).isCancelled()) {
                    ((ListenableFuture) obj).cancel(false);
                    break;
                }
                break;
            case 4:
                int i5 = MediaLibraryServiceLegacyStub.o;
                if (((SettableFuture) obj2).isCancelled()) {
                    int i6 = 0;
                    while (true) {
                        ArrayList arrayList = (ArrayList) obj;
                        if (i6 >= arrayList.size()) {
                            break;
                        } else {
                            if (arrayList.get(i6) != null) {
                                ((ListenableFuture) arrayList.get(i6)).cancel(false);
                            }
                            i6++;
                        }
                    }
                }
                break;
            case 5:
                int i7 = MediaSessionImpl.B;
                ((MediaSessionImpl) obj2).getClass();
                ((Runnable) obj).run();
                break;
            case 6:
                int i8 = MediaSessionImpl.B;
                ((SettableFuture) obj).n(Boolean.valueOf(((MediaSessionImpl) obj2).q()));
                break;
            case 7:
                MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) obj2;
                MediaSessionLegacyStub mediaSessionLegacyStub = mediaSessionImpl.f10098h;
                PlayerWrapper playerWrapper = (PlayerWrapper) obj;
                mediaSessionImpl.s = playerWrapper;
                MediaSessionImpl.PlayerListener playerListener = new MediaSessionImpl.PlayerListener(mediaSessionImpl, playerWrapper);
                playerWrapper.D0(playerListener);
                mediaSessionImpl.t = playerListener;
                try {
                    mediaSessionLegacyStub.f10117i.i(0, playerWrapper);
                } catch (RemoteException e3) {
                    Log.e("MediaSessionImpl", "Exception in using media1 API", e3);
                }
                mediaSessionLegacyStub.f10119k.g();
                mediaSessionImpl.r = playerWrapper.l();
                mediaSessionImpl.f(playerWrapper.N0());
                break;
            case 8:
                ListenableFuture listenableFuture2 = (ListenableFuture) obj2;
                int i9 = MediaSessionLegacyStub.r;
                try {
                    sessionResult = (SessionResult) listenableFuture2.get();
                    Assertions.e(sessionResult, "SessionResult must not be null");
                } catch (InterruptedException e4) {
                    e = e4;
                    Log.i("MediaSessionLegacyStub", "Custom command failed", e);
                    sessionResult = new SessionResult(-1);
                } catch (CancellationException e5) {
                    Log.i("MediaSessionLegacyStub", "Custom command cancelled", e5);
                    sessionResult = new SessionResult(1);
                } catch (ExecutionException e6) {
                    e = e6;
                    Log.i("MediaSessionLegacyStub", "Custom command failed", e);
                    sessionResult = new SessionResult(-1);
                }
                ((ResultReceiver) obj).send(sessionResult.f10263a, sessionResult.f10264b);
                break;
            case 9:
                int i10 = MediaSessionService.f10141h;
                MediaSessionImpl mediaSessionImpl2 = (MediaSessionImpl) obj2;
                MediaSession.ControllerInfo controllerInfoE = mediaSessionImpl2.e();
                Intent intent = (Intent) obj;
                if (controllerInfoE == null) {
                    ComponentName component = intent.getComponent();
                    controllerInfoE = new MediaSession.ControllerInfo(new MediaSessionManager.RemoteUserInfo(component != null ? component.getPackageName() : "androidx.media3.session.MediaSessionService", -1, -1), 1004001300, 6, false, null, Bundle.EMPTY);
                }
                if (!mediaSessionImpl2.p(controllerInfoE, intent)) {
                    Log.b("MSessionService", "Ignored unrecognized media button intent.");
                    break;
                }
                break;
            case 10:
                int i11 = MediaSessionService.f10141h;
                MediaSession mediaSession = (MediaSession) obj;
                ListenableFuture listenableFuture3 = (ListenableFuture) ((MediaNotificationManager) obj2).f10051g.remove(mediaSession);
                if (listenableFuture3 != null && !listenableFuture3.cancel(false)) {
                    try {
                        ((MediaController) Futures.b(listenableFuture3)).release();
                    } catch (CancellationException | ExecutionException e7) {
                        Log.i("MediaController", "MediaController future failed (so we couldn't release it)", e7);
                    }
                }
                mediaSession.f10060a.u = null;
                break;
            case 11:
                int i12 = MediaSessionStub.f10157h;
                MediaSessionStub mediaSessionStub = (MediaSessionStub) obj2;
                mediaSessionStub.getClass();
                IBinder iBinderAsBinder = ((IMediaController) obj).asBinder();
                ConnectedControllersManager connectedControllersManager = mediaSessionStub.f10160d;
                MediaSession.ControllerInfo controllerInfoG = connectedControllersManager.g(iBinderAsBinder);
                if (controllerInfoG != null) {
                    connectedControllersManager.m(controllerInfoG);
                    break;
                }
                break;
            case 12:
                ((MediaSessionStub) obj2).f10160d.d((MediaSession.ControllerInfo) obj);
                break;
            default:
                ((Consumer) obj2).accept((MediaBrowser.Listener) obj);
                break;
        }
    }

    public /* synthetic */ l0(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, Runnable runnable) {
        this.f10412a = 5;
        this.f10413b = mediaSessionImpl;
        this.f10414c = runnable;
    }
}
