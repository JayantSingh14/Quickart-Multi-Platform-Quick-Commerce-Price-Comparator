package androidx.media3.session;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceBitmapLoader;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaNotificationManager;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionImpl;
import androidx.media3.session.MediaSessionService.MediaSessionListener;
import androidx.media3.session.MediaSessionStub;
import androidx.media3.session.legacy.MediaBrowserServiceCompat;
import androidx.media3.session.legacy.MediaSessionManager;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* loaded from: classes3.dex */
public final /* synthetic */ class v0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10772a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10773b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10774c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f10775d;

    public /* synthetic */ v0(MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub, MediaSession.ControllerInfo controllerInfo, MediaBrowserServiceCompat.Result result, String str) {
        this.f10772a = 1;
        this.f10773b = mediaLibraryServiceLegacyStub;
        this.f10774c = controllerInfo;
        this.f10775d = result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        final String str;
        Bitmap bitmap = null;
        Object obj = this.f10775d;
        Object obj2 = this.f10774c;
        Object obj3 = this.f10773b;
        switch (this.f10772a) {
            case 0:
                ListenableFuture listenableFuture = (ListenableFuture) obj3;
                int i2 = MediaLibraryServiceLegacyStub.o;
                try {
                    bitmap = (Bitmap) Futures.b(listenableFuture);
                } catch (CancellationException | ExecutionException e2) {
                    Log.c("MLSLegacyStub", "failed to get bitmap", e2);
                }
                ((SettableFuture) obj2).n(LegacyConversions.a((MediaItem) obj, bitmap));
                return;
            case 1:
                int i3 = MediaLibraryServiceLegacyStub.o;
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = (MediaLibraryServiceLegacyStub) obj3;
                MediaSession.ControllerInfo controllerInfo = (MediaSession.ControllerInfo) obj2;
                MediaBrowserServiceCompat.Result result = (MediaBrowserServiceCompat.Result) obj;
                if (mediaLibraryServiceLegacyStub.f10156l.k(controllerInfo, 50004)) {
                    mediaLibraryServiceLegacyStub.n.u(controllerInfo);
                    throw null;
                }
                result.f(null);
                return;
            case 2:
                int i4 = MediaLibraryServiceLegacyStub.o;
                MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub2 = (MediaLibraryServiceLegacyStub) obj3;
                MediaSession.ControllerInfo controllerInfo2 = (MediaSession.ControllerInfo) obj2;
                if (mediaLibraryServiceLegacyStub2.f10156l.k(controllerInfo2, 50002)) {
                    mediaLibraryServiceLegacyStub2.n.u(controllerInfo2);
                    throw null;
                }
                return;
            case 3:
                int i5 = MediaLibrarySessionImpl.C;
                ((MediaLibrarySessionImpl) obj3).getClass();
                ((MediaSession.ControllerInfo) obj2).f10086e.getClass();
                throw null;
            case 4:
                MediaController mediaController = (MediaController) obj3;
                mediaController.m();
                MediaController.MediaControllerImpl mediaControllerImpl = mediaController.f9956c;
                UnmodifiableIterator it = (!mediaControllerImpl.isConnected() ? SessionCommands.f10236b : mediaControllerImpl.c()).f10238a.iterator();
                while (true) {
                    str = (String) obj2;
                    if (it.hasNext()) {
                        SessionCommand sessionCommand = (SessionCommand) it.next();
                        if (sessionCommand.f10233a == 0 && sessionCommand.f10234b.equals(str)) {
                            bitmap = sessionCommand;
                        }
                    }
                }
                if (bitmap != null) {
                    mediaController.m();
                    SessionCommands sessionCommandsC = !mediaControllerImpl.isConnected() ? SessionCommands.f10236b : mediaControllerImpl.c();
                    sessionCommandsC.getClass();
                    if (sessionCommandsC.f10238a.contains(bitmap)) {
                        SessionCommand sessionCommand2 = new SessionCommand(str, (Bundle) obj);
                        Bundle bundle = Bundle.EMPTY;
                        mediaController.m();
                        Futures.a(mediaControllerImpl.isConnected() ? mediaControllerImpl.d(sessionCommand2) : Futures.d(new SessionResult(-100)), new FutureCallback<SessionResult>() { // from class: androidx.media3.session.MediaNotificationManager.1

                            /* renamed from: a */
                            public final /* synthetic */ String f10055a;

                            public AnonymousClass1(final String str2) {
                                str = str2;
                            }

                            @Override // com.google.common.util.concurrent.FutureCallback
                            public final void onFailure(Throwable th) {
                                Log.i("MediaNtfMng", "custom command " + str + " produced an error: " + th.getMessage(), th);
                            }

                            @Override // com.google.common.util.concurrent.FutureCallback
                            public final /* bridge */ /* synthetic */ void onSuccess(Object obj4) {
                            }
                        }, MoreExecutors.a());
                        return;
                    }
                    return;
                }
                return;
            case 5:
                int i6 = MediaSessionImpl.B;
                MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) obj3;
                mediaSessionImpl.getClass();
                ((Runnable) obj2).run();
                mediaSessionImpl.f10097g.f10160d.d((MediaSession.ControllerInfo) obj);
                return;
            case 6:
                MediaSessionImpl.MediaPlayPauseKeyHandler mediaPlayPauseKeyHandler = (MediaSessionImpl.MediaPlayPauseKeyHandler) obj3;
                MediaSessionImpl mediaSessionImpl2 = MediaSessionImpl.this;
                MediaSession.ControllerInfo controllerInfo3 = (MediaSession.ControllerInfo) obj2;
                if (mediaSessionImpl2.i(controllerInfo3)) {
                    mediaSessionImpl2.a((KeyEvent) obj, false);
                } else {
                    MediaSessionManager.RemoteUserInfo remoteUserInfo = controllerInfo3.f10082a;
                    remoteUserInfo.getClass();
                    MediaSessionLegacyStub mediaSessionLegacyStub = mediaSessionImpl2.f10098h;
                    mediaSessionLegacyStub.getClass();
                    mediaSessionLegacyStub.D(1, new h1(mediaSessionLegacyStub, 7), remoteUserInfo, true);
                }
                mediaPlayPauseKeyHandler.f10107a = null;
                return;
            case 7:
                int i7 = MediaSessionService.f10141h;
                MediaSessionService mediaSessionService = (MediaSessionService) obj3;
                mediaSessionService.getClass();
                MediaNotificationManager mediaNotificationManager = (MediaNotificationManager) obj2;
                HashMap map = mediaNotificationManager.f10051g;
                MediaSession mediaSession = (MediaSession) obj;
                boolean zContainsKey = map.containsKey(mediaSession);
                MediaSessionImpl mediaSessionImpl3 = mediaSession.f10060a;
                if (!zContainsKey) {
                    MediaSessionService mediaSessionService2 = mediaNotificationManager.f10045a;
                    MediaNotificationManager.MediaControllerListener mediaControllerListener = new MediaNotificationManager.MediaControllerListener(mediaSessionService2, mediaSession);
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("androidx.media3.session.MediaNotificationManager", true);
                    SessionToken sessionToken = mediaSessionImpl3.f10100j;
                    MediaController.Builder builder = new MediaController.Builder();
                    mediaSessionService2.getClass();
                    sessionToken.getClass();
                    builder.f9962a = Bundle.EMPTY;
                    builder.f9963b = new MediaController.Builder.AnonymousClass1();
                    int i8 = Util.f5744a;
                    Looper looperMyLooper = Looper.myLooper();
                    if (looperMyLooper == null) {
                        looperMyLooper = Looper.getMainLooper();
                    }
                    builder.f9964c = looperMyLooper;
                    builder.f9962a = new Bundle(bundle2);
                    builder.f9963b = mediaControllerListener;
                    Looper mainLooper = Looper.getMainLooper();
                    mainLooper.getClass();
                    builder.f9964c = mainLooper;
                    MediaControllerHolder mediaControllerHolder = new MediaControllerHolder(builder.f9964c);
                    if (sessionToken.f10269a.g() && builder.f9965d == null) {
                        builder.f9965d = new CacheBitmapLoader(new DataSourceBitmapLoader(mediaSessionService2));
                    }
                    Util.X(new Handler(builder.f9964c), new g(mediaControllerHolder, new MediaController(mediaSessionService2, sessionToken, builder.f9962a, builder.f9963b, builder.f9964c, mediaControllerHolder, builder.f9965d), 0));
                    map.put(mediaSession, mediaControllerHolder);
                    mediaControllerHolder.q(new d(mediaNotificationManager, mediaControllerHolder, mediaControllerListener, mediaSession, 5), mediaNotificationManager.f10049e);
                }
                mediaSessionImpl3.u = mediaSessionService.new MediaSessionListener();
                return;
            default:
                int i9 = MediaSessionStub.f10157h;
                MediaSessionImpl mediaSessionImpl4 = (MediaSessionImpl) obj3;
                if (mediaSessionImpl4.j()) {
                    return;
                }
                ((MediaSessionStub.MediaItemsWithStartPositionPlayerTask) obj2).b(mediaSessionImpl4.s, (MediaSession.MediaItemsWithStartPosition) obj);
                return;
        }
    }

    public /* synthetic */ v0(MediaNotificationManager mediaNotificationManager, MediaController mediaController, String str, Bundle bundle) {
        this.f10772a = 4;
        this.f10773b = mediaController;
        this.f10774c = str;
        this.f10775d = bundle;
    }

    public /* synthetic */ v0(Object obj, Object obj2, Object obj3, int i2) {
        this.f10772a = i2;
        this.f10773b = obj;
        this.f10774c = obj2;
        this.f10775d = obj3;
    }
}
