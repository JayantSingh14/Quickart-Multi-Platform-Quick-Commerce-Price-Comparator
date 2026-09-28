package androidx.media3.session;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.session.DefaultMediaNotificationProvider;
import androidx.media3.session.IMediaSessionService;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaSession;
import androidx.media3.session.legacy.MediaSessionManager;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* loaded from: classes3.dex */
public abstract class MediaSessionService extends Service {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f10141h = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Object f10142a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final Handler f10143b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public final ArrayMap f10144c = new ArrayMap();

    /* renamed from: d, reason: collision with root package name */
    public MediaSessionServiceStub f10145d;

    /* renamed from: e, reason: collision with root package name */
    public MediaNotificationManager f10146e;

    /* renamed from: f, reason: collision with root package name */
    public DefaultMediaNotificationProvider f10147f;

    /* renamed from: g, reason: collision with root package name */
    public DefaultActionFactory f10148g;

    @RequiresApi
    public static final class Api31 {
        @DoNotInline
        public static boolean a(IllegalStateException illegalStateException) {
            return androidx.core.os.a.y(illegalStateException);
        }
    }

    @UnstableApi
    public interface Listener {
    }

    public final class MediaSessionListener implements MediaSession.Listener {
        public MediaSessionListener() {
        }
    }

    public static final class MediaSessionServiceStub extends IMediaSessionService.Stub {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f10150a;

        /* renamed from: b, reason: collision with root package name */
        public final Handler f10151b;

        /* renamed from: c, reason: collision with root package name */
        public final MediaSessionManager f10152c;

        /* renamed from: d, reason: collision with root package name */
        public final Set f10153d;

        public MediaSessionServiceStub(MediaSessionService mediaSessionService) {
            this.f10150a = new WeakReference(mediaSessionService);
            Context applicationContext = mediaSessionService.getApplicationContext();
            this.f10151b = new Handler(applicationContext.getMainLooper());
            this.f10152c = MediaSessionManager.a(applicationContext);
            this.f10153d = Collections.synchronizedSet(new HashSet());
        }

        @Override // androidx.media3.session.IMediaSessionService
        public final void G7(IMediaController iMediaController, Bundle bundle) {
            if (iMediaController == null || bundle == null) {
                return;
            }
            try {
                ConnectionRequest connectionRequestA = ConnectionRequest.a(bundle);
                if (this.f10150a.get() == null) {
                    try {
                        iMediaController.D();
                        return;
                    } catch (RemoteException unused) {
                        return;
                    }
                }
                int callingPid = Binder.getCallingPid();
                int callingUid = Binder.getCallingUid();
                long jClearCallingIdentity = Binder.clearCallingIdentity();
                if (callingPid == 0) {
                    callingPid = connectionRequestA.f9904d;
                }
                MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo(connectionRequestA.f9903c, callingPid, callingUid);
                boolean zB = this.f10152c.b(remoteUserInfo);
                this.f10153d.add(iMediaController);
                try {
                    this.f10151b.post(new a1(this, iMediaController, remoteUserInfo, connectionRequestA, zB, 1));
                } finally {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                }
            } catch (RuntimeException e2) {
                Log.i("MSessionService", "Ignoring malformed Bundle for ConnectionRequest", e2);
            }
        }
    }

    public final void a(MediaSession mediaSession) {
        MediaSession mediaSession2;
        boolean z = true;
        Assertions.b(!mediaSession.f10060a.j(), "session is already released");
        synchronized (this.f10142a) {
            mediaSession2 = (MediaSession) this.f10144c.get(mediaSession.f10060a.f10099i);
            if (mediaSession2 != null && mediaSession2 != mediaSession) {
                z = false;
            }
            Assertions.b(z, "Session ID should be unique");
            this.f10144c.put(mediaSession.f10060a.f10099i, mediaSession);
        }
        if (mediaSession2 == null) {
            Util.X(this.f10143b, new v0(this, c(), mediaSession, 7));
        }
    }

    public final DefaultActionFactory b() {
        DefaultActionFactory defaultActionFactory;
        synchronized (this.f10142a) {
            try {
                if (this.f10148g == null) {
                    this.f10148g = new DefaultActionFactory(this);
                }
                defaultActionFactory = this.f10148g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return defaultActionFactory;
    }

    public final MediaNotificationManager c() {
        MediaNotificationManager mediaNotificationManager;
        synchronized (this.f10142a) {
            try {
                if (this.f10146e == null) {
                    if (this.f10147f == null) {
                        DefaultMediaNotificationProvider.Builder builder = new DefaultMediaNotificationProvider.Builder(getApplicationContext());
                        Assertions.g(!builder.f9931d);
                        DefaultMediaNotificationProvider defaultMediaNotificationProvider = new DefaultMediaNotificationProvider(builder);
                        builder.f9931d = true;
                        this.f10147f = defaultMediaNotificationProvider;
                    }
                    this.f10146e = new MediaNotificationManager(this, this.f10147f, b());
                }
                mediaNotificationManager = this.f10146e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaNotificationManager;
    }

    public final boolean d(MediaSession mediaSession) {
        boolean zContainsKey;
        synchronized (this.f10142a) {
            zContainsKey = this.f10144c.containsKey(mediaSession.f10060a.f10099i);
        }
        return zContainsKey;
    }

    public abstract MediaSession e(MediaSession.ControllerInfo controllerInfo);

    public void f(MediaSession mediaSession, boolean z) {
        MediaController mediaControllerA;
        MediaController mediaController;
        ImmutableList immutableListR;
        MediaNotificationManager mediaNotificationManagerC = c();
        if (!mediaNotificationManagerC.f10045a.d(mediaSession) || (mediaControllerA = mediaNotificationManagerC.a(mediaSession)) == null || mediaControllerA.F0().p() || mediaControllerA.u() == 1) {
            mediaNotificationManagerC.b(true);
            return;
        }
        int i2 = mediaNotificationManagerC.f10052h + 1;
        mediaNotificationManagerC.f10052h = i2;
        ListenableFuture listenableFuture = (ListenableFuture) mediaNotificationManagerC.f10051g.get(mediaSession);
        if (listenableFuture == null || !listenableFuture.isDone()) {
            mediaController = null;
        } else {
            try {
                mediaController = (MediaController) Futures.b(listenableFuture);
            } catch (ExecutionException unused) {
            }
        }
        if (mediaController != null) {
            mediaController.m();
            MediaController.MediaControllerImpl mediaControllerImpl = mediaController.f9956c;
            immutableListR = mediaControllerImpl.isConnected() ? mediaControllerImpl.e() : ImmutableList.r();
        } else {
            immutableListR = ImmutableList.r();
        }
        Util.X(new Handler(mediaSession.c().F1()), new a1(mediaNotificationManagerC, mediaSession, immutableListR, new l(mediaNotificationManagerC, i2, mediaSession, 2), z, 0));
    }

    public final boolean g(MediaSession mediaSession, boolean z) {
        try {
            f(mediaSession, c().c(mediaSession, z));
            return true;
        } catch (IllegalStateException e2) {
            if (Util.f5744a < 31 || !Api31.a(e2)) {
                throw e2;
            }
            Log.e("MSessionService", "Failed to start foreground", e2);
            this.f10143b.post(new a0(this, 3));
            return false;
        }
    }

    public final void h(MediaSession mediaSession) {
        synchronized (this.f10142a) {
            Assertions.b(this.f10144c.containsKey(mediaSession.f10060a.f10099i), "session not found");
            this.f10144c.remove(mediaSession.f10060a.f10099i);
        }
        Util.X(this.f10143b, new l0(10, c(), mediaSession));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String action;
        MediaSessionServiceStub mediaSessionServiceStub;
        MediaSession mediaSessionE;
        MediaSessionServiceLegacyStub mediaSessionServiceLegacyStub;
        if (intent == null || (action = intent.getAction()) == null) {
            return null;
        }
        if (action.equals("androidx.media3.session.MediaSessionService")) {
            synchronized (this.f10142a) {
                mediaSessionServiceStub = this.f10145d;
                Assertions.h(mediaSessionServiceStub);
            }
            return mediaSessionServiceStub;
        }
        if (!action.equals("android.media.browse.MediaBrowserService") || (mediaSessionE = e(new MediaSession.ControllerInfo(new MediaSessionManager.RemoteUserInfo("android.media.session.MediaController", -1, -1), 0, 0, false, null, Bundle.EMPTY))) == null) {
            return null;
        }
        a(mediaSessionE);
        MediaSessionImpl mediaSessionImpl = mediaSessionE.f10060a;
        synchronized (mediaSessionImpl.f10091a) {
            try {
                if (mediaSessionImpl.v == null) {
                    mediaSessionImpl.v = mediaSessionImpl.b(mediaSessionImpl.f10101k.f10060a.f10098h.f10119k.d());
                }
                mediaSessionServiceLegacyStub = mediaSessionImpl.v;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaSessionServiceLegacyStub.onBind(new Intent("android.media.browse.MediaBrowserService"));
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        synchronized (this.f10142a) {
            this.f10145d = new MediaSessionServiceStub(this);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        synchronized (this.f10142a) {
            try {
                MediaSessionServiceStub mediaSessionServiceStub = this.f10145d;
                if (mediaSessionServiceStub != null) {
                    mediaSessionServiceStub.f10150a.clear();
                    mediaSessionServiceStub.f10151b.removeCallbacksAndMessages(null);
                    Iterator it = mediaSessionServiceStub.f10153d.iterator();
                    while (it.hasNext()) {
                        try {
                            ((IMediaController) it.next()).D();
                        } catch (RemoteException unused) {
                        }
                    }
                    this.f10145d = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        MediaSession mediaSessionE;
        MediaSession mediaSession;
        if (intent != null) {
            DefaultActionFactory defaultActionFactoryB = b();
            Uri data = intent.getData();
            if (data != null) {
                synchronized (MediaSession.f10058b) {
                    try {
                        Iterator it = MediaSession.f10059c.values().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                mediaSession = null;
                                break;
                            }
                            mediaSession = (MediaSession) it.next();
                            if (Util.a(mediaSession.f10060a.f10092b, data)) {
                            }
                        }
                    } finally {
                    }
                }
                mediaSessionE = mediaSession;
            } else {
                mediaSessionE = null;
            }
            defaultActionFactoryB.getClass();
            if ("android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) {
                if (mediaSessionE == null) {
                    mediaSessionE = e(new MediaSession.ControllerInfo(new MediaSessionManager.RemoteUserInfo("android.media.session.MediaController", -1, -1), 0, 0, false, null, Bundle.EMPTY));
                    if (mediaSessionE != null) {
                        a(mediaSessionE);
                    }
                }
                MediaSessionImpl mediaSessionImplB = mediaSessionE.b();
                mediaSessionImplB.f10102l.post(new l0(9, mediaSessionImplB, intent));
                return 1;
            }
            if (mediaSessionE != null && "androidx.media3.session.CUSTOM_NOTIFICATION_ACTION".equals(intent.getAction())) {
                Bundle extras = intent.getExtras();
                Object obj = extras != null ? extras.get("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION") : null;
                String str = obj instanceof String ? (String) obj : null;
                if (str != null) {
                    Bundle extras2 = intent.getExtras();
                    Object obj2 = extras2 != null ? extras2.get("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION_EXTRAS") : null;
                    Bundle bundle = obj2 instanceof Bundle ? (Bundle) obj2 : Bundle.EMPTY;
                    MediaNotificationManager mediaNotificationManagerC = c();
                    MediaController mediaControllerA = mediaNotificationManagerC.a(mediaSessionE);
                    if (mediaControllerA != null) {
                        Util.X(new Handler(mediaSessionE.c().F1()), new d(mediaNotificationManagerC, mediaSessionE, str, bundle, mediaControllerA));
                    }
                }
            }
        }
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        if (c().f10054j) {
            return;
        }
        stopSelf();
    }
}
