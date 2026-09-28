package androidx.media3.session;

import android.content.Intent;
import android.media.session.MediaSession;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.media3.common.Player;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaNotification;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/* loaded from: classes3.dex */
final class MediaNotificationManager {

    /* renamed from: a, reason: collision with root package name */
    public final MediaSessionService f10045a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultMediaNotificationProvider f10046b;

    /* renamed from: c, reason: collision with root package name */
    public final MediaNotification.ActionFactory f10047c;

    /* renamed from: d, reason: collision with root package name */
    public final NotificationManagerCompat f10048d;

    /* renamed from: f, reason: collision with root package name */
    public final Intent f10050f;

    /* renamed from: h, reason: collision with root package name */
    public int f10052h;

    /* renamed from: i, reason: collision with root package name */
    public MediaNotification f10053i;

    /* renamed from: e, reason: collision with root package name */
    public final h f10049e = new h(new Handler(Looper.getMainLooper()), 3);

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f10051g = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public boolean f10054j = false;

    @RequiresApi
    public static class Api24 {
        @DoNotInline
        public static void a(MediaSessionService mediaSessionService, boolean z) {
            mediaSessionService.stopForeground(z ? 1 : 2);
        }
    }

    public static final class MediaControllerListener implements MediaController.Listener, Player.Listener {

        /* renamed from: a, reason: collision with root package name */
        public final MediaSessionService f10056a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaSession f10057b;

        public MediaControllerListener(MediaSessionService mediaSessionService, MediaSession mediaSession) {
            this.f10056a = mediaSessionService;
            this.f10057b = mediaSession;
        }

        @Override // androidx.media3.session.MediaController.Listener
        public final void C() {
            this.f10056a.g(this.f10057b, false);
        }

        @Override // androidx.media3.session.MediaController.Listener
        public final void D() {
            MediaSession mediaSession = this.f10057b;
            MediaSessionService mediaSessionService = this.f10056a;
            if (mediaSessionService.d(mediaSession)) {
                mediaSessionService.h(mediaSession);
            }
            mediaSessionService.g(mediaSession, false);
        }

        @Override // androidx.media3.session.MediaController.Listener
        public final void h() {
            this.f10056a.g(this.f10057b, false);
        }

        @Override // androidx.media3.common.Player.Listener
        public final void x1(Player player, Player.Events events) {
            if (events.f5435a.a(4, 5, 14, 0)) {
                this.f10056a.g(this.f10057b, false);
            }
        }
    }

    public MediaNotificationManager(MediaSessionService mediaSessionService, DefaultMediaNotificationProvider defaultMediaNotificationProvider, MediaNotification.ActionFactory actionFactory) {
        this.f10045a = mediaSessionService;
        this.f10046b = defaultMediaNotificationProvider;
        this.f10047c = actionFactory;
        this.f10048d = new NotificationManagerCompat(mediaSessionService);
        this.f10050f = new Intent(mediaSessionService, mediaSessionService.getClass());
    }

    public final MediaController a(MediaSession mediaSession) {
        ListenableFuture listenableFuture = (ListenableFuture) this.f10051g.get(mediaSession);
        if (listenableFuture == null || !listenableFuture.isDone()) {
            return null;
        }
        try {
            return (MediaController) Futures.b(listenableFuture);
        } catch (ExecutionException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public final void b(boolean z) {
        ArrayList arrayList;
        MediaNotification mediaNotification;
        MediaSessionService mediaSessionService = this.f10045a;
        synchronized (mediaSessionService.f10142a) {
            arrayList = new ArrayList(mediaSessionService.f10144c.values());
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (c((MediaSession) arrayList.get(i2), false)) {
                return;
            }
        }
        int i3 = Util.f5744a;
        MediaSessionService mediaSessionService2 = this.f10045a;
        if (i3 >= 24) {
            Api24.a(mediaSessionService2, z);
        } else {
            mediaSessionService2.stopForeground(z || i3 < 21);
        }
        this.f10054j = false;
        if (!z || (mediaNotification = this.f10053i) == null) {
            return;
        }
        this.f10048d.b(mediaNotification.f10043a);
        this.f10052h++;
        this.f10053i = null;
    }

    public final boolean c(MediaSession mediaSession, boolean z) {
        MediaController mediaControllerA = a(mediaSession);
        if (mediaControllerA == null) {
            return false;
        }
        if (mediaControllerA.O0() || z) {
            return mediaControllerA.u() == 3 || mediaControllerA.u() == 2;
        }
        return false;
    }

    public final void d(MediaSession mediaSession, MediaNotification mediaNotification, boolean z) {
        if (Util.f5744a >= 21) {
            mediaNotification.f10044b.extras.putParcelable("android.mediaSession", (MediaSession.Token) mediaSession.f10060a.f10098h.f10119k.d().f10639b);
        }
        this.f10053i = mediaNotification;
        if (!z) {
            this.f10048d.d(mediaNotification.f10043a, mediaNotification.f10044b);
            b(false);
            return;
        }
        Intent intent = this.f10050f;
        MediaSessionService mediaSessionService = this.f10045a;
        ContextCompat.f(mediaSessionService, intent);
        Util.d0(mediaSessionService, mediaNotification.f10043a, mediaNotification.f10044b);
        this.f10054j = true;
    }
}
