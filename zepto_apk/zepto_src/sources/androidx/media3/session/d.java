package androidx.media3.session;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.session.ConnectedControllersManager;
import androidx.media3.session.ConnectionState.InProcessBinder;
import androidx.media3.session.MediaLibraryServiceLegacyStub;
import androidx.media3.session.MediaNotificationManager;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionStub;
import androidx.media3.session.legacy.MediaBrowserServiceCompat;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10338a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10339b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10340c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f10341d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f10342e;

    public /* synthetic */ d(ConnectedControllersManager connectedControllersManager, AtomicBoolean atomicBoolean, ConnectedControllersManager.ConnectedControllerRecord connectedControllerRecord, AtomicBoolean atomicBoolean2) {
        this.f10338a = 0;
        this.f10339b = connectedControllersManager;
        this.f10340c = atomicBoolean;
        this.f10342e = connectedControllerRecord;
        this.f10341d = atomicBoolean2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundleB;
        boolean z = false;
        boolean z2 = true;
        switch (this.f10338a) {
            case 0:
                ConnectedControllersManager connectedControllersManager = (ConnectedControllersManager) this.f10339b;
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.f10340c;
                ConnectedControllersManager.ConnectedControllerRecord connectedControllerRecord = (ConnectedControllersManager.ConnectedControllerRecord) this.f10342e;
                AtomicBoolean atomicBoolean2 = (AtomicBoolean) this.f10341d;
                synchronized (connectedControllersManager.f9885a) {
                    try {
                        if (atomicBoolean.get()) {
                            atomicBoolean2.set(true);
                        } else {
                            connectedControllersManager.c(connectedControllerRecord);
                        }
                    } finally {
                    }
                }
                return;
            case 1:
                int i2 = MediaLibraryServiceLegacyStub.o;
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = (MediaLibraryServiceLegacyStub) this.f10339b;
                ConnectedControllersManager connectedControllersManager2 = mediaLibraryServiceLegacyStub.f10156l;
                MediaSession.ControllerInfo controllerInfo = (MediaSession.ControllerInfo) this.f10340c;
                if (connectedControllersManager2.k(controllerInfo, 50001)) {
                    MediaLibrarySessionImpl mediaLibrarySessionImpl = mediaLibraryServiceLegacyStub.n;
                    mediaLibrarySessionImpl.A(controllerInfo, (String) this.f10342e, LegacyConversions.h(mediaLibrarySessionImpl.f10096f, (Bundle) this.f10341d));
                    return;
                }
                return;
            case 2:
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub2 = (MediaLibraryServiceLegacyStub) this.f10339b;
                MediaSession.ControllerInfo controllerInfo2 = (MediaSession.ControllerInfo) this.f10340c;
                MediaBrowserServiceCompat.Result result = (MediaBrowserServiceCompat.Result) this.f10341d;
                Bundle bundle = (Bundle) this.f10342e;
                int i3 = MediaLibraryServiceLegacyStub.o;
                if (!mediaLibraryServiceLegacyStub2.f10156l.k(controllerInfo2, 50005)) {
                    result.f(null);
                    return;
                }
                MediaSession.ControllerCb controllerCb = controllerInfo2.f10086e;
                Assertions.h(controllerCb);
                MediaLibraryServiceLegacyStub.BrowserLegacyCb browserLegacyCb = (MediaLibraryServiceLegacyStub.BrowserLegacyCb) controllerCb;
                synchronized (browserLegacyCb.f10036a) {
                    browserLegacyCb.f10038c.add(new MediaLibraryServiceLegacyStub.SearchRequest());
                }
                LegacyConversions.h(mediaLibraryServiceLegacyStub2.n.f10096f, bundle);
                mediaLibraryServiceLegacyStub2.n.u(controllerInfo2);
                throw null;
            case 3:
                int i4 = MediaLibrarySessionImpl.C;
                ((MediaLibrarySessionImpl) this.f10339b).getClass();
                LibraryResult libraryResult = (LibraryResult) MediaLibrarySessionImpl.B((ListenableFuture) this.f10340c);
                if (libraryResult == null || libraryResult.f9947a != 0) {
                    ((MediaSession.ControllerInfo) this.f10341d).f10086e.getClass();
                    throw null;
                }
                return;
            case 4:
                MediaNotificationManager mediaNotificationManager = (MediaNotificationManager) this.f10339b;
                DefaultMediaNotificationProvider defaultMediaNotificationProvider = mediaNotificationManager.f10046b;
                String str = (String) this.f10340c;
                defaultMediaNotificationProvider.getClass();
                mediaNotificationManager.f10049e.execute(new v0(mediaNotificationManager, (MediaController) this.f10342e, str, (Bundle) this.f10341d));
                return;
            case 5:
                ListenableFuture listenableFuture = (ListenableFuture) this.f10340c;
                MediaNotificationManager.MediaControllerListener mediaControllerListener = (MediaNotificationManager.MediaControllerListener) this.f10341d;
                MediaSession mediaSession = (MediaSession) this.f10342e;
                MediaNotificationManager mediaNotificationManager2 = (MediaNotificationManager) this.f10339b;
                mediaNotificationManager2.getClass();
                try {
                    MediaController mediaController = (MediaController) ((AbstractFuture) listenableFuture).get(0L, TimeUnit.MILLISECONDS);
                    MediaController mediaControllerA = mediaNotificationManager2.a(mediaSession);
                    if (mediaControllerA == null || mediaControllerA.F0().p() || mediaControllerA.u() == 1) {
                        z2 = false;
                    }
                    if (z2) {
                        mediaControllerListener.f10056a.g(mediaControllerListener.f10057b, false);
                    }
                    mediaController.D0(mediaControllerListener);
                    return;
                } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException unused) {
                    mediaNotificationManager2.f10045a.h(mediaSession);
                    return;
                }
            case 6:
                ((AtomicReference) this.f10340c).set(((MediaSessionServiceLegacyStub) this.f10339b).f10155k.m((MediaSession.ControllerInfo) this.f10341d));
                ((ConditionVariable) this.f10342e).e();
                return;
            case 7:
                MediaSession.ControllerInfo controllerInfo3 = (MediaSession.ControllerInfo) this.f10340c;
                MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.f10341d;
                IMediaController iMediaController = (IMediaController) this.f10342e;
                MediaSessionStub mediaSessionStub = (MediaSessionStub) this.f10339b;
                ConnectedControllersManager connectedControllersManager3 = mediaSessionStub.f10160d;
                try {
                    mediaSessionStub.f10161e.remove(controllerInfo3);
                    if (!mediaSessionImpl.j()) {
                        MediaSessionStub.Controller2Cb controller2Cb = (MediaSessionStub.Controller2Cb) controllerInfo3.f10086e;
                        Assertions.h(controller2Cb);
                        IBinder iBinderAsBinder = controller2Cb.f10164a.asBinder();
                        MediaSession.ConnectionResult connectionResultM = mediaSessionImpl.m(controllerInfo3);
                        boolean z3 = connectionResultM.f10074a;
                        if (z3 || controllerInfo3.f10085d) {
                            if (!z3) {
                                connectionResultM = new MediaSession.ConnectionResult(true, SessionCommands.f10236b, Player.Commands.f5430b, null, null);
                            }
                            if (connectedControllersManager3.i(controllerInfo3)) {
                                Log.h("MediaSessionStub", "Controller " + controllerInfo3 + " has sent connection request multiple times");
                            }
                            connectedControllersManager3.a(iBinderAsBinder, controllerInfo3, connectionResultM.f10075b, connectionResultM.f10076c);
                            SequencedFutureManager sequencedFutureManagerH = connectedControllersManager3.h(controllerInfo3);
                            if (sequencedFutureManagerH == null) {
                                Log.h("MediaSessionStub", "Ignoring connection request from unknown controller info");
                            } else {
                                PlayerWrapper playerWrapper = mediaSessionImpl.s;
                                PlayerInfo playerInfoJ1 = mediaSessionStub.j1(playerWrapper.l());
                                ImmutableList immutableList = connectionResultM.f10077d;
                                if (immutableList == null) {
                                    immutableList = mediaSessionImpl.z;
                                }
                                ImmutableList immutableList2 = immutableList;
                                SessionCommands sessionCommands = connectionResultM.f10075b;
                                Player.Commands commands = connectionResultM.f10076c;
                                Player.Commands commandsN0 = playerWrapper.N0();
                                Bundle extras = mediaSessionImpl.f10100j.f10269a.getExtras();
                                Bundle bundle2 = connectionResultM.f10078e;
                                if (bundle2 == null) {
                                    bundle2 = mediaSessionImpl.A;
                                }
                                ConnectionState connectionState = new ConnectionState(1004001300, 4, mediaSessionStub, null, immutableList2, sessionCommands, commands, commandsN0, extras, bundle2, playerInfoJ1);
                                if (!mediaSessionImpl.j()) {
                                    try {
                                        int iA = sequencedFutureManagerH.a();
                                        if (iMediaController instanceof MediaControllerStub) {
                                            bundleB = new Bundle();
                                            bundleB.putBinder(ConnectionState.w, connectionState.new InProcessBinder());
                                        } else {
                                            bundleB = connectionState.b(controllerInfo3.f10084c);
                                        }
                                        iMediaController.X2(iA, bundleB);
                                        z = true;
                                    } catch (RemoteException unused2) {
                                    }
                                    if (z && (!mediaSessionImpl.y || !MediaSessionImpl.k(controllerInfo3))) {
                                        mediaSessionImpl.f10095e.getClass();
                                    }
                                    if (z) {
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    try {
                        iMediaController.D();
                        return;
                    } catch (RemoteException unused3) {
                        return;
                    }
                } finally {
                    if (0 == 0) {
                        try {
                            iMediaController.D();
                        } catch (RemoteException unused4) {
                        }
                    }
                }
            case 8:
                Consumer consumer = (Consumer) this.f10341d;
                ListenableFuture listenableFuture2 = (ListenableFuture) this.f10342e;
                int i5 = MediaSessionStub.f10157h;
                boolean zJ = ((MediaSessionImpl) this.f10339b).j();
                SettableFuture settableFuture = (SettableFuture) this.f10340c;
                if (zJ) {
                    settableFuture.n(null);
                    return;
                }
                try {
                    consumer.accept(listenableFuture2);
                    settableFuture.n(null);
                    return;
                } catch (Throwable th) {
                    settableFuture.o(th);
                    return;
                }
            default:
                int i6 = MediaSessionStub.f10157h;
                MediaSessionImpl mediaSessionImpl2 = (MediaSessionImpl) this.f10339b;
                if (mediaSessionImpl2.j()) {
                    return;
                }
                ((MediaSessionStub.MediaItemPlayerTask) this.f10340c).e(mediaSessionImpl2.s, (MediaSession.ControllerInfo) this.f10341d, (List) this.f10342e);
                return;
        }
    }

    public /* synthetic */ d(MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub, MediaSession.ControllerInfo controllerInfo, MediaBrowserServiceCompat.Result result, Bundle bundle, String str) {
        this.f10338a = 2;
        this.f10339b = mediaLibraryServiceLegacyStub;
        this.f10340c = controllerInfo;
        this.f10341d = result;
        this.f10342e = bundle;
    }

    public /* synthetic */ d(MediaNotificationManager mediaNotificationManager, MediaSession mediaSession, String str, Bundle bundle, MediaController mediaController) {
        this.f10338a = 4;
        this.f10339b = mediaNotificationManager;
        this.f10340c = str;
        this.f10341d = bundle;
        this.f10342e = mediaController;
    }

    public /* synthetic */ d(Object obj, Object obj2, Object obj3, Object obj4, int i2) {
        this.f10338a = i2;
        this.f10339b = obj;
        this.f10340c = obj2;
        this.f10341d = obj3;
        this.f10342e = obj4;
    }
}
