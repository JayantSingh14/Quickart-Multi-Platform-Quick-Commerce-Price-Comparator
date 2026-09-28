package androidx.media3.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionLegacyStub;
import androidx.media3.session.PlayerWrapper;
import androidx.media3.session.PlayerWrapper.AnonymousClass1;
import androidx.media3.session.legacy.MediaDescriptionCompat;
import androidx.media3.session.legacy.MediaSessionCompat;
import androidx.media3.session.legacy.MediaSessionManager;
import androidx.media3.session.legacy.RatingCompat;
import androidx.media3.session.legacy.VolumeProviderCompat;
import com.brentvatne.exoplayer.VideoPlaybackService;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.time.DateUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
class MediaSessionLegacyStub extends MediaSessionCompat.Callback {
    public static final int r;

    /* renamed from: f, reason: collision with root package name */
    public final ConnectedControllersManager f10114f;

    /* renamed from: g, reason: collision with root package name */
    public final MediaSessionImpl f10115g;

    /* renamed from: h, reason: collision with root package name */
    public final MediaSessionManager f10116h;

    /* renamed from: i, reason: collision with root package name */
    public final ControllerLegacyCbForBroadcast f10117i;

    /* renamed from: j, reason: collision with root package name */
    public final ConnectionTimeoutHandler f10118j;

    /* renamed from: k, reason: collision with root package name */
    public final MediaSessionCompat f10119k;

    /* renamed from: l, reason: collision with root package name */
    public final MediaButtonReceiver f10120l;

    /* renamed from: m, reason: collision with root package name */
    public final ComponentName f10121m;
    public VolumeProviderCompat n;
    public volatile long o;
    public FutureCallback p;
    public int q;

    /* renamed from: androidx.media3.session.MediaSessionLegacyStub$1, reason: invalid class name */
    class AnonymousClass1 implements FutureCallback<MediaSession.MediaItemsWithStartPosition> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaSession.ControllerInfo f10122a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f10123b;

        public AnonymousClass1(MediaSession.ControllerInfo controllerInfo, boolean z) {
            this.f10122a = controllerInfo;
            this.f10123b = z;
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public final void onFailure(Throwable th) {
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public final void onSuccess(Object obj) {
            MediaSessionImpl mediaSessionImpl = MediaSessionLegacyStub.this.f10115g;
            Handler handler = mediaSessionImpl.f10102l;
            MediaSession.ControllerInfo controllerInfo = this.f10122a;
            Util.X(handler, new l0(mediaSessionImpl, controllerInfo, new c1(this, (MediaSession.MediaItemsWithStartPosition) obj, this.f10123b, controllerInfo)));
        }
    }

    /* renamed from: androidx.media3.session.MediaSessionLegacyStub$2, reason: invalid class name */
    class AnonymousClass2 implements FutureCallback<List<MediaItem>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaSession.ControllerInfo f10125a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f10126b;

        public AnonymousClass2(MediaSession.ControllerInfo controllerInfo, int i2) {
            this.f10125a = controllerInfo;
            this.f10126b = i2;
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public final void onFailure(Throwable th) {
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public final void onSuccess(Object obj) {
            List list = (List) obj;
            MediaSessionImpl mediaSessionImpl = MediaSessionLegacyStub.this.f10115g;
            Handler handler = mediaSessionImpl.f10102l;
            MediaSession.ControllerInfo controllerInfo = this.f10125a;
            Util.X(handler, new l0(mediaSessionImpl, controllerInfo, new b1(this.f10126b, 1, this, list, controllerInfo)));
        }
    }

    @RequiresApi
    public static final class Api31 {
        @DoNotInline
        public static void a(MediaSessionCompat mediaSessionCompat, ComponentName componentName) {
            android.media.session.MediaSession mediaSessionC = mediaSessionCompat.c();
            mediaSessionC.getClass();
            mediaSessionC.setMediaButtonBroadcastReceiver(componentName);
        }
    }

    public static class ConnectionTimeoutHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final ConnectedControllersManager f10128a;

        public ConnectionTimeoutHandler(Looper looper, ConnectedControllersManager connectedControllersManager) {
            super(looper);
            this.f10128a = connectedControllersManager;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            MediaSession.ControllerInfo controllerInfo = (MediaSession.ControllerInfo) message.obj;
            ConnectedControllersManager connectedControllersManager = this.f10128a;
            if (connectedControllersManager.i(controllerInfo)) {
                try {
                    MediaSession.ControllerCb controllerCb = controllerInfo.f10086e;
                    Assertions.h(controllerCb);
                    controllerCb.D();
                } catch (RemoteException unused) {
                }
                connectedControllersManager.m(controllerInfo);
            }
        }
    }

    public static final class ControllerLegacyCb implements MediaSession.ControllerCb {

        /* renamed from: a, reason: collision with root package name */
        public final MediaSessionManager.RemoteUserInfo f10129a;

        public ControllerLegacyCb(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f10129a = remoteUserInfo;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != ControllerLegacyCb.class) {
                return false;
            }
            return Util.a(this.f10129a, ((ControllerLegacyCb) obj).f10129a);
        }

        public final int hashCode() {
            return Objects.hash(this.f10129a);
        }
    }

    public final class MediaButtonReceiver extends BroadcastReceiver {
        public MediaButtonReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            KeyEvent keyEvent;
            if (Util.a(intent.getAction(), "android.intent.action.MEDIA_BUTTON")) {
                Uri data = intent.getData();
                if (Util.a(data, data) && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null) {
                    MediaSessionLegacyStub.this.f10119k.f10611b.c(keyEvent);
                }
            }
        }
    }

    public interface SessionTask {
        void b(MediaSession.ControllerInfo controllerInfo);
    }

    static {
        r = Util.f5744a >= 31 ? 33554432 : 0;
    }

    public MediaSessionLegacyStub(MediaSessionImpl mediaSessionImpl, Uri uri, Handler handler) {
        ComponentName componentName;
        ComponentName componentNameF;
        PendingIntent foregroundService;
        this.f10115g = mediaSessionImpl;
        VideoPlaybackService videoPlaybackService = mediaSessionImpl.f10096f;
        this.f10116h = MediaSessionManager.a(videoPlaybackService);
        this.f10117i = new ControllerLegacyCbForBroadcast();
        ConnectedControllersManager connectedControllersManager = new ConnectedControllersManager(mediaSessionImpl);
        this.f10114f = connectedControllersManager;
        this.o = 300000L;
        this.f10118j = new ConnectionTimeoutHandler(mediaSessionImpl.f10102l.getLooper(), connectedControllersManager);
        PackageManager packageManager = videoPlaybackService.getPackageManager();
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(videoPlaybackService.getPackageName());
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        boolean z = true;
        if (listQueryBroadcastReceivers.size() == 1) {
            ActivityInfo activityInfo = listQueryBroadcastReceivers.get(0).activityInfo;
            componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
        } else {
            if (!listQueryBroadcastReceivers.isEmpty()) {
                throw new IllegalStateException("Expected 1 broadcast receiver that handles android.intent.action.MEDIA_BUTTON, found " + listQueryBroadcastReceivers.size());
            }
            componentName = null;
        }
        this.f10121m = componentName;
        if (componentName == null || Util.f5744a < 31) {
            componentNameF = F(videoPlaybackService, "androidx.media3.session.MediaLibraryService");
            componentNameF = componentNameF == null ? F(videoPlaybackService, "androidx.media3.session.MediaSessionService") : componentNameF;
            if (componentNameF == null || componentNameF.equals(componentName)) {
                z = false;
            }
        } else {
            z = false;
            componentNameF = componentName;
        }
        Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON", uri);
        if (componentNameF == null) {
            MediaButtonReceiver mediaButtonReceiver = new MediaButtonReceiver();
            this.f10120l = mediaButtonReceiver;
            IntentFilter intentFilter = new IntentFilter("android.intent.action.MEDIA_BUTTON");
            intentFilter.addDataScheme(uri.getScheme());
            if (Util.f5744a < 33) {
                videoPlaybackService.registerReceiver(mediaButtonReceiver, intentFilter);
            } else {
                videoPlaybackService.registerReceiver(mediaButtonReceiver, intentFilter, 4);
            }
            intent2.setPackage(videoPlaybackService.getPackageName());
            foregroundService = PendingIntent.getBroadcast(videoPlaybackService, 0, intent2, r);
            componentNameF = new ComponentName(videoPlaybackService, (Class<?>) VideoPlaybackService.class);
        } else {
            intent2.setComponent(componentNameF);
            foregroundService = z ? Util.f5744a >= 26 ? PendingIntent.getForegroundService(videoPlaybackService, 0, intent2, r) : PendingIntent.getService(videoPlaybackService, 0, intent2, r) : PendingIntent.getBroadcast(videoPlaybackService, 0, intent2, r);
            this.f10120l = null;
        }
        String strJoin = TextUtils.join(CLConstants.DOT_SALT_DELIMETER, new String[]{"androidx.media3.session.id", mediaSessionImpl.f10099i});
        ComponentName componentName2 = componentNameF;
        int i2 = Util.f5744a;
        MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(videoPlaybackService, strJoin, i2 >= 31 ? null : componentName2, i2 < 31 ? foregroundService : null, mediaSessionImpl.f10100j.f10269a.getExtras());
        this.f10119k = mediaSessionCompat;
        if (i2 >= 31 && componentName != null) {
            Api31.a(mediaSessionCompat, componentName);
        }
        mediaSessionCompat.h(this, handler);
    }

    public static MediaItem C(String str, Uri uri, String str2, Bundle bundle) {
        MediaItem.Builder builder = new MediaItem.Builder();
        if (str == null) {
            str = "";
        }
        builder.f5266a = str;
        MediaItem.RequestMetadata.Builder builder2 = new MediaItem.RequestMetadata.Builder();
        builder2.f5354a = uri;
        builder2.f5355b = str2;
        builder2.f5356c = bundle;
        builder.f5278m = new MediaItem.RequestMetadata(builder2);
        return builder.a();
    }

    public static ComponentName F(VideoPlaybackService videoPlaybackService, String str) {
        PackageManager packageManager = videoPlaybackService.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(videoPlaybackService.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            return null;
        }
        ServiceInfo serviceInfo = listQueryIntentServices.get(0).serviceInfo;
        return new ComponentName(serviceInfo.packageName, serviceInfo.name);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void A(long j2) {
        if (j2 < 0) {
            return;
        }
        D(10, new g1(this, j2, 0), this.f10119k.b(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void B() {
        D(3, new h1(this, 6), this.f10119k.b(), true);
    }

    public final void D(final int i2, final SessionTask sessionTask, final MediaSessionManager.RemoteUserInfo remoteUserInfo, final boolean z) {
        MediaSessionImpl mediaSessionImpl = this.f10115g;
        if (mediaSessionImpl.j()) {
            return;
        }
        if (remoteUserInfo != null) {
            Util.X(mediaSessionImpl.f10102l, new Runnable() { // from class: androidx.media3.session.l1
                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionLegacyStub mediaSessionLegacyStub = this.f10415a;
                    MediaSessionImpl mediaSessionImpl2 = mediaSessionLegacyStub.f10115g;
                    if (mediaSessionImpl2.j()) {
                        return;
                    }
                    boolean zE = mediaSessionLegacyStub.f10119k.e();
                    int i3 = i2;
                    MediaSessionManager.RemoteUserInfo remoteUserInfo2 = remoteUserInfo;
                    if (!zE) {
                        StringBuilder sbU = android.support.v4.media.b.u(i3, "Ignore incoming player command before initialization. command=", ", pid=");
                        sbU.append(remoteUserInfo2.b());
                        Log.h("MediaSessionLegacyStub", sbU.toString());
                        return;
                    }
                    MediaSession.ControllerInfo controllerInfoH = mediaSessionLegacyStub.H(remoteUserInfo2);
                    if (controllerInfoH == null) {
                        return;
                    }
                    if (!mediaSessionLegacyStub.f10114f.j(controllerInfoH, i3)) {
                        if (i3 != 1 || mediaSessionImpl2.s.O0()) {
                            return;
                        }
                        Log.h("MediaSessionLegacyStub", "Calling play() omitted due to COMMAND_PLAY_PAUSE not being available. If this play command has started the service for instance for playback resumption, this may prevent the service from being started into the foreground.");
                        return;
                    }
                    mediaSessionImpl2.u(controllerInfoH);
                    mediaSessionImpl2.f10095e.getClass();
                    MediaSessionLegacyStub.SessionTask sessionTask2 = sessionTask;
                    int i4 = MediaSessionImpl.B;
                    int i5 = MediaSessionLegacyStub.r;
                    try {
                        sessionTask2.b(controllerInfoH);
                    } catch (RemoteException e2) {
                        Log.i("MediaSessionLegacyStub", "Exception in " + controllerInfoH, e2);
                    }
                    if (z) {
                        Player.Commands.Builder builder = new Player.Commands.Builder();
                        builder.f5434a.a(i3);
                        builder.d();
                        mediaSessionImpl2.r(controllerInfoH);
                    }
                }
            });
            return;
        }
        Log.b("MediaSessionLegacyStub", "RemoteUserInfo is null, ignoring command=" + i2);
    }

    public final void E(SessionCommand sessionCommand, int i2, SessionTask sessionTask, MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo != null) {
            Util.X(this.f10115g.f10102l, new n0(this, sessionCommand, i2, remoteUserInfo, sessionTask));
            return;
        }
        StringBuilder sb = new StringBuilder("RemoteUserInfo is null, ignoring command=");
        Object objValueOf = sessionCommand;
        if (sessionCommand == null) {
            objValueOf = Integer.valueOf(i2);
        }
        sb.append(objValueOf);
        Log.b("MediaSessionLegacyStub", sb.toString());
    }

    public final void G(MediaItem mediaItem, boolean z) {
        D(31, new e0(this, mediaItem, z), this.f10119k.b(), false);
    }

    public final MediaSession.ControllerInfo H(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        MediaSession.ControllerInfo controllerInfoG = this.f10114f.g(remoteUserInfo);
        if (controllerInfoG == null) {
            MediaSession.ControllerInfo controllerInfo = new MediaSession.ControllerInfo(remoteUserInfo, 0, 0, this.f10116h.b(remoteUserInfo), new ControllerLegacyCb(remoteUserInfo), Bundle.EMPTY);
            MediaSession.ConnectionResult connectionResultM = this.f10115g.m(controllerInfo);
            if (!connectionResultM.f10074a) {
                return null;
            }
            this.f10114f.a(remoteUserInfo, controllerInfo, connectionResultM.f10075b, connectionResultM.f10076c);
            controllerInfoG = controllerInfo;
        }
        ConnectionTimeoutHandler connectionTimeoutHandler = this.f10118j;
        long j2 = this.o;
        connectionTimeoutHandler.removeMessages(DateUtils.SEMI_MONTH, controllerInfoG);
        connectionTimeoutHandler.sendMessageDelayed(connectionTimeoutHandler.obtainMessage(DateUtils.SEMI_MONTH, controllerInfoG), j2);
        return controllerInfoG;
    }

    public final void I(PlayerWrapper playerWrapper) {
        Util.X(this.f10115g.f10102l, new k1(this, playerWrapper, 0));
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void b(MediaDescriptionCompat mediaDescriptionCompat) {
        if (mediaDescriptionCompat != null) {
            D(20, new l(this, mediaDescriptionCompat, -1), this.f10119k.b(), false);
        }
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void c(MediaDescriptionCompat mediaDescriptionCompat, int i2) {
        if (mediaDescriptionCompat != null) {
            if (i2 == -1 || i2 >= 0) {
                D(20, new l(this, mediaDescriptionCompat, i2), this.f10119k.b(), false);
            }
        }
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void d(String str, final Bundle bundle, final ResultReceiver resultReceiver) {
        Assertions.h(str);
        if (TextUtils.equals("androidx.media3.session.SESSION_COMMAND_REQUEST_SESSION3_TOKEN", str) && resultReceiver != null) {
            resultReceiver.send(0, this.f10115g.f10100j.a());
        } else {
            final SessionCommand sessionCommand = new SessionCommand(str, Bundle.EMPTY);
            E(sessionCommand, 0, new SessionTask() { // from class: androidx.media3.session.j1
                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void b(MediaSession.ControllerInfo controllerInfo) {
                    MediaSessionLegacyStub mediaSessionLegacyStub = this.f10396a;
                    Bundle bundle2 = bundle;
                    if (bundle2 == null) {
                        int i2 = MediaSessionLegacyStub.r;
                        mediaSessionLegacyStub.getClass();
                        bundle2 = Bundle.EMPTY;
                    }
                    ListenableFuture listenableFutureN = mediaSessionLegacyStub.f10115g.n(controllerInfo, sessionCommand, bundle2);
                    ResultReceiver resultReceiver2 = resultReceiver;
                    if (resultReceiver2 != null) {
                        listenableFutureN.q(new l0(8, listenableFutureN, resultReceiver2), MoreExecutors.a());
                    }
                }
            }, this.f10119k.b());
        }
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void e(String str, Bundle bundle) {
        SessionCommand sessionCommand = new SessionCommand(str, Bundle.EMPTY);
        E(sessionCommand, 0, new j0(this, sessionCommand, bundle), this.f10119k.b());
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void f() {
        D(12, new h1(this, 5), this.f10119k.b(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final boolean g(Intent intent) {
        MediaSessionManager.RemoteUserInfo remoteUserInfoB = this.f10119k.b();
        remoteUserInfoB.getClass();
        return this.f10115g.p(new MediaSession.ControllerInfo(remoteUserInfoB, 0, 0, false, null, Bundle.EMPTY), intent);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void h() {
        D(1, new h1(this, 11), this.f10119k.b(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void i() {
        D(1, new h1(this, 10), this.f10119k.b(), false);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void j(String str, Bundle bundle) {
        G(C(str, null, null, bundle), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void k(String str, Bundle bundle) {
        G(C(null, null, str, bundle), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void l(Uri uri, Bundle bundle) {
        G(C(null, uri, null, bundle), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void m() {
        D(2, new h1(this, 4), this.f10119k.b(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void n(String str, Bundle bundle) {
        G(C(str, null, null, bundle), false);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void o(String str, Bundle bundle) {
        G(C(null, null, str, bundle), false);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void p(Uri uri, Bundle bundle) {
        G(C(null, uri, null, bundle), false);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void q(MediaDescriptionCompat mediaDescriptionCompat) {
        if (mediaDescriptionCompat == null) {
            return;
        }
        D(20, new s(8, this, mediaDescriptionCompat), this.f10119k.b(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void r() {
        D(11, new h1(this, 3), this.f10119k.b(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void s(long j2) {
        D(5, new g1(this, j2, 1), this.f10119k.b(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void t(float f2) {
        if (f2 <= 0.0f) {
            return;
        }
        D(13, new z(this, f2, 2), this.f10119k.b(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void u(RatingCompat ratingCompat) {
        v(ratingCompat);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void v(RatingCompat ratingCompat) {
        Rating ratingQ = LegacyConversions.q(ratingCompat);
        if (ratingQ != null) {
            E(null, 40010, new h1(this, ratingQ), this.f10119k.b());
            return;
        }
        Log.h("MediaSessionLegacyStub", "Ignoring invalid RatingCompat " + ratingCompat);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void w(int i2) {
        D(15, new i1(this, i2, 0), this.f10119k.b(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void x(int i2) {
        D(14, new i1(this, i2, 1), this.f10119k.b(), true);
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void y() {
        boolean zD1 = this.f10115g.s.D1(9);
        MediaSessionCompat mediaSessionCompat = this.f10119k;
        if (zD1) {
            D(9, new h1(this, 8), mediaSessionCompat.b(), true);
        } else {
            D(8, new h1(this, 9), mediaSessionCompat.b(), true);
        }
    }

    @Override // androidx.media3.session.legacy.MediaSessionCompat.Callback
    public final void z() {
        boolean zD1 = this.f10115g.s.D1(7);
        MediaSessionCompat mediaSessionCompat = this.f10119k;
        if (zD1) {
            D(7, new h1(this, 1), mediaSessionCompat.b(), true);
        } else {
            D(6, new h1(this, 2), mediaSessionCompat.b(), true);
        }
    }

    public final class ControllerLegacyCbForBroadcast implements MediaSession.ControllerCb {

        /* renamed from: c, reason: collision with root package name */
        public Uri f10132c;

        /* renamed from: a, reason: collision with root package name */
        public MediaMetadata f10130a = MediaMetadata.J;

        /* renamed from: b, reason: collision with root package name */
        public String f10131b = "";

        /* renamed from: d, reason: collision with root package name */
        public long f10133d = -9223372036854775807L;

        public ControllerLegacyCbForBroadcast() {
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public final void a(int i2, SessionPositionInfo sessionPositionInfo, boolean z, boolean z2, int i3) {
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            mediaSessionLegacyStub.I(mediaSessionLegacyStub.f10115g.s);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public final void e(int i2, Player.Commands commands) {
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            PlayerWrapper playerWrapper = mediaSessionLegacyStub.f10115g.s;
            int i3 = playerWrapper.D1(20) ? 4 : 0;
            if (mediaSessionLegacyStub.q != i3) {
                mediaSessionLegacyStub.q = i3;
                mediaSessionLegacyStub.f10119k.i(i3);
            }
            mediaSessionLegacyStub.I(playerWrapper);
        }

        public final void g() {
            int i2;
            PlayerWrapper.AnonymousClass1 anonymousClass1;
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            PlayerWrapper playerWrapper = mediaSessionLegacyStub.f10115g.s;
            if (playerWrapper.Y0().f5193a == 0) {
                anonymousClass1 = null;
            } else {
                Player.Commands commandsN0 = playerWrapper.N0();
                if (commandsN0.f5432a.a(26, 34)) {
                    i2 = commandsN0.f5432a.a(25, 33) ? 2 : 1;
                } else {
                    i2 = 0;
                }
                Handler handler = new Handler(playerWrapper.f5239a.F1());
                int iK0 = playerWrapper.D1(23) ? playerWrapper.K0() : 0;
                DeviceInfo deviceInfoY0 = playerWrapper.Y0();
                anonymousClass1 = playerWrapper.new AnonymousClass1(i2, deviceInfoY0.f5195c, iK0, deviceInfoY0.f5196d, handler);
            }
            mediaSessionLegacyStub.n = anonymousClass1;
            MediaSessionCompat mediaSessionCompat = mediaSessionLegacyStub.f10119k;
            if (anonymousClass1 == null) {
                mediaSessionCompat.m(LegacyConversions.w(playerWrapper.D1(21) ? playerWrapper.X0() : AudioAttributes.f5143g));
            } else {
                mediaSessionCompat.n(anonymousClass1);
            }
        }

        public final void h(MediaItem mediaItem) {
            n();
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            if (mediaItem == null) {
                mediaSessionLegacyStub.f10119k.q(0);
            } else {
                mediaSessionLegacyStub.f10119k.q(LegacyConversions.x(mediaItem.f5260d.f5387i));
            }
            mediaSessionLegacyStub.I(mediaSessionLegacyStub.f10115g.s);
        }

        public final void i(int i2, PlayerWrapper playerWrapper) {
            m(playerWrapper.q());
            j(playerWrapper.D1(18) ? playerWrapper.i1() : MediaMetadata.J);
            playerWrapper.r();
            n();
            l(playerWrapper.s1());
            k(playerWrapper.G());
            playerWrapper.Y0();
            g();
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            mediaSessionLegacyStub.getClass();
            int i3 = playerWrapper.D1(20) ? 4 : 0;
            if (mediaSessionLegacyStub.q != i3) {
                mediaSessionLegacyStub.q = i3;
                mediaSessionLegacyStub.f10119k.i(i3);
            }
            h(playerWrapper.o());
        }

        public final void j(MediaMetadata mediaMetadata) {
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            CharSequence charSequenceL = mediaSessionLegacyStub.f10119k.f10611b.l();
            CharSequence charSequence = mediaMetadata.f5379a;
            if (TextUtils.equals(charSequenceL, charSequence)) {
                return;
            }
            PlayerWrapper playerWrapper = mediaSessionLegacyStub.f10115g.s;
            if (!playerWrapper.f10204f.a(17) || !playerWrapper.N0().a(17)) {
                charSequence = null;
            }
            mediaSessionLegacyStub.f10119k.p(charSequence);
        }

        public final void k(int i2) {
            MediaSessionLegacyStub.this.f10119k.r(LegacyConversions.p(i2));
        }

        public final void l(boolean z) {
            MediaSessionCompat mediaSessionCompat = MediaSessionLegacyStub.this.f10119k;
            ImmutableSet immutableSet = LegacyConversions.f9940a;
            mediaSessionCompat.s(z ? 1 : 0);
        }

        public final void m(Timeline timeline) {
            o(timeline);
            n();
        }

        public final void n() {
            final long j2;
            final Uri uri;
            final MediaMetadata mediaMetadata;
            Bitmap bitmap;
            MediaItem.LocalConfiguration localConfiguration;
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            PlayerWrapper playerWrapper = mediaSessionLegacyStub.f10115g.s;
            MediaItem mediaItemO = playerWrapper.o();
            MediaMetadata mediaMetadataR = playerWrapper.r();
            long duration = -9223372036854775807L;
            if ((!playerWrapper.D1(16) || !playerWrapper.H1()) && playerWrapper.D1(16)) {
                duration = playerWrapper.getDuration();
            }
            final String str = mediaItemO != null ? mediaItemO.f5257a : "";
            Uri uri2 = (mediaItemO == null || (localConfiguration = mediaItemO.f5258b) == null) ? null : localConfiguration.f5339a;
            if (Objects.equals(this.f10130a, mediaMetadataR) && Objects.equals(this.f10131b, str) && Objects.equals(this.f10132c, uri2) && this.f10133d == duration) {
                return;
            }
            this.f10131b = str;
            this.f10132c = uri2;
            this.f10130a = mediaMetadataR;
            this.f10133d = duration;
            MediaSessionImpl mediaSessionImpl = mediaSessionLegacyStub.f10115g;
            ListenableFuture listenableFutureA = mediaSessionImpl.f10103m.a(mediaMetadataR);
            if (listenableFutureA != null) {
                mediaSessionLegacyStub.p = null;
                if (listenableFutureA.isDone()) {
                    try {
                        bitmap = (Bitmap) Futures.b(listenableFutureA);
                    } catch (CancellationException | ExecutionException e2) {
                        Log.h("MediaSessionLegacyStub", "Failed to load bitmap: " + e2.getMessage());
                    }
                } else {
                    j2 = duration;
                    uri = uri2;
                    mediaMetadata = mediaMetadataR;
                    FutureCallback<Bitmap> futureCallback = new FutureCallback<Bitmap>() { // from class: androidx.media3.session.MediaSessionLegacyStub.ControllerLegacyCbForBroadcast.1
                        @Override // com.google.common.util.concurrent.FutureCallback
                        public final void onFailure(Throwable th) {
                            if (this != MediaSessionLegacyStub.this.p) {
                                return;
                            }
                            Log.h("MediaSessionLegacyStub", "Failed to load bitmap: " + th.getMessage());
                        }

                        @Override // com.google.common.util.concurrent.FutureCallback
                        public final void onSuccess(Object obj) {
                            Bitmap bitmap2 = (Bitmap) obj;
                            ControllerLegacyCbForBroadcast controllerLegacyCbForBroadcast = ControllerLegacyCbForBroadcast.this;
                            MediaSessionLegacyStub mediaSessionLegacyStub2 = MediaSessionLegacyStub.this;
                            if (this != mediaSessionLegacyStub2.p) {
                                return;
                            }
                            mediaSessionLegacyStub2.f10119k.k(LegacyConversions.n(mediaMetadata, str, uri, j2, bitmap2));
                            MediaSessionImpl mediaSessionImpl2 = MediaSessionLegacyStub.this.f10115g;
                            Util.X(mediaSessionImpl2.o, new e1(mediaSessionImpl2, 1));
                        }
                    };
                    str = str;
                    mediaSessionLegacyStub.p = futureCallback;
                    Handler handler = mediaSessionImpl.f10102l;
                    Objects.requireNonNull(handler);
                    Futures.a(listenableFutureA, futureCallback, new androidx.media3.exoplayer.audio.m(handler));
                    mediaMetadataR = mediaMetadata;
                    uri2 = uri;
                    duration = j2;
                    bitmap = null;
                }
            } else {
                j2 = duration;
                uri = uri2;
                mediaMetadata = mediaMetadataR;
                mediaMetadataR = mediaMetadata;
                uri2 = uri;
                duration = j2;
                bitmap = null;
            }
            mediaSessionLegacyStub.f10119k.k(LegacyConversions.n(mediaMetadataR, str, uri2, duration, bitmap));
        }

        public final void o(Timeline timeline) {
            int i2 = MediaSessionLegacyStub.r;
            MediaSessionLegacyStub mediaSessionLegacyStub = MediaSessionLegacyStub.this;
            PlayerWrapper playerWrapper = mediaSessionLegacyStub.f10115g.s;
            if (!(playerWrapper.f10204f.a(17) && playerWrapper.N0().a(17)) || timeline.p()) {
                mediaSessionLegacyStub.f10119k.o(null);
                return;
            }
            ImmutableSet immutableSet = LegacyConversions.f9940a;
            ArrayList arrayList = new ArrayList();
            Timeline.Window window = new Timeline.Window();
            for (int i3 = 0; i3 < timeline.o(); i3++) {
                arrayList.add(timeline.m(i3, window, 0L).f5488c);
            }
            ArrayList arrayList2 = new ArrayList();
            c cVar = new c(this, new AtomicInteger(0), arrayList, arrayList2, timeline, 3);
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                byte[] bArr = ((MediaItem) arrayList.get(i4)).f5260d.f5389k;
                if (bArr == null) {
                    arrayList2.add(null);
                    cVar.run();
                } else {
                    MediaSessionImpl mediaSessionImpl = mediaSessionLegacyStub.f10115g;
                    ListenableFuture listenableFutureC = mediaSessionImpl.f10103m.c(bArr);
                    arrayList2.add(listenableFutureC);
                    Handler handler = mediaSessionImpl.f10102l;
                    Objects.requireNonNull(handler);
                    listenableFutureC.q(cVar, new androidx.media3.exoplayer.audio.m(handler));
                }
            }
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public final void D() {
        }
    }
}
