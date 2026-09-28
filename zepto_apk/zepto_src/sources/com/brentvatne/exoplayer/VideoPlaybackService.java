package com.brentvatne.exoplayer;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.session.CacheBitmapLoader;
import androidx.media3.session.CommandButton;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionService;
import androidx.media3.session.MediaStyleNotificationHelper;
import androidx.media3.session.SessionCommand;
import androidx.media3.ui.R;
import com.brentvatne.common.toolbox.DebugLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.Util;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class VideoPlaybackService extends MediaSessionService {
    public static final /* synthetic */ int n = 0;

    /* renamed from: i, reason: collision with root package name */
    public final LinkedHashMap f15588i = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    public final PlaybackServiceBinder f15589j = new PlaybackServiceBinder(this);

    /* renamed from: k, reason: collision with root package name */
    public Class f15590k;

    /* renamed from: l, reason: collision with root package name */
    public final CommandButton f15591l;

    /* renamed from: m, reason: collision with root package name */
    public final CommandButton f15592m;

    @Metadata
    public static final class Companion {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata
        public static final class COMMAND {

            /* renamed from: a, reason: collision with root package name */
            public static final COMMAND f15593a;

            /* renamed from: b, reason: collision with root package name */
            public static final COMMAND f15594b;

            /* renamed from: c, reason: collision with root package name */
            public static final COMMAND f15595c;

            /* renamed from: d, reason: collision with root package name */
            public static final COMMAND f15596d;

            /* renamed from: e, reason: collision with root package name */
            public static final COMMAND f15597e;

            /* renamed from: f, reason: collision with root package name */
            public static final COMMAND f15598f;

            /* renamed from: g, reason: collision with root package name */
            public static final /* synthetic */ COMMAND[] f15599g;

            /* renamed from: h, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f15600h;

            static {
                COMMAND command = new COMMAND("NONE", 0);
                f15593a = command;
                COMMAND command2 = new COMMAND("SEEK_FORWARD", 1);
                f15594b = command2;
                COMMAND command3 = new COMMAND("SEEK_BACKWARD", 2);
                f15595c = command3;
                COMMAND command4 = new COMMAND("TOGGLE_PLAY", 3);
                f15596d = command4;
                COMMAND command5 = new COMMAND("PLAY", 4);
                f15597e = command5;
                COMMAND command6 = new COMMAND("PAUSE", 5);
                f15598f = command6;
                COMMAND[] commandArr = {command, command2, command3, command4, command5, command6};
                f15599g = commandArr;
                f15600h = EnumEntriesKt.a(commandArr);
            }

            public static COMMAND valueOf(String str) {
                return (COMMAND) Enum.valueOf(COMMAND.class, str);
            }

            public static COMMAND[] values() {
                return (COMMAND[]) f15599g.clone();
            }
        }

        @Metadata
        public /* synthetic */ class WhenMappings {
            static {
                int[] iArr = new int[COMMAND.values().length];
                try {
                    iArr[2] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    COMMAND command = COMMAND.f15593a;
                    iArr[1] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    COMMAND command2 = COMMAND.f15593a;
                    iArr[3] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    COMMAND command3 = COMMAND.f15593a;
                    iArr[4] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    COMMAND command4 = COMMAND.f15593a;
                    iArr[5] = 5;
                } catch (NoSuchFieldError unused5) {
                }
            }
        }

        public static COMMAND a(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            COMMAND command = COMMAND.f15594b;
            if (Intrinsics.b(value, "COMMAND_SEEK_FORWARD")) {
                return command;
            }
            COMMAND command2 = COMMAND.f15595c;
            if (Intrinsics.b(value, "COMMAND_SEEK_BACKWARD")) {
                return command2;
            }
            COMMAND command3 = COMMAND.f15596d;
            if (Intrinsics.b(value, "COMMAND_TOGGLE_PLAY")) {
                return command3;
            }
            COMMAND command4 = COMMAND.f15597e;
            if (Intrinsics.b(value, "COMMAND_PLAY")) {
                return command4;
            }
            return Intrinsics.b(value, "COMMAND_PAUSE") ? COMMAND.f15598f : COMMAND.f15593a;
        }

        public static void b(COMMAND command, MediaSession session) {
            Intrinsics.checkNotNullParameter(command, "command");
            Intrinsics.checkNotNullParameter(session, "session");
            int iOrdinal = command.ordinal();
            if (iOrdinal == 1) {
                session.c().X(session.c().f1() + 10000);
                return;
            }
            if (iOrdinal == 2) {
                session.c().X(session.c().f1() - 10000);
                return;
            }
            if (iOrdinal == 3) {
                b(session.c().j1() ? COMMAND.f15598f : COMMAND.f15597e, session);
                return;
            }
            if (iOrdinal == 4) {
                session.c().E();
            } else if (iOrdinal != 5) {
                DebugLog.e("VideoPlaybackService", "Received COMMAND.NONE - was there an error?");
            } else {
                session.c().pause();
            }
        }
    }

    public VideoPlaybackService() {
        Companion.COMMAND command = Companion.COMMAND.f15593a;
        Bundle bundle = Bundle.EMPTY;
        SessionCommand sessionCommand = new SessionCommand("COMMAND_SEEK_FORWARD", bundle);
        SessionCommand sessionCommand2 = new SessionCommand("COMMAND_SEEK_BACKWARD", bundle);
        CommandButton.Builder builder = new CommandButton.Builder();
        builder.f9882f = "forward";
        builder.c(sessionCommand);
        builder.f9880d = R.drawable.exo_notification_fastforward;
        CommandButton commandButtonA = builder.a();
        Intrinsics.checkNotNullExpressionValue(commandButtonA, "build(...)");
        this.f15591l = commandButtonA;
        CommandButton.Builder builder2 = new CommandButton.Builder();
        builder2.f9882f = "backward";
        builder2.c(sessionCommand2);
        builder2.f9880d = R.drawable.exo_notification_rewind;
        CommandButton commandButtonA2 = builder2.a();
        Intrinsics.checkNotNullExpressionValue(commandButtonA2, "build(...)");
        this.f15592m = commandButtonA2;
    }

    @Override // androidx.media3.session.MediaSessionService
    public final MediaSession e(MediaSession.ControllerInfo controllerInfo) {
        Intrinsics.checkNotNullParameter(controllerInfo, "controllerInfo");
        return null;
    }

    @Override // androidx.media3.session.MediaSessionService
    public final void f(MediaSession session, boolean z) throws Resources.NotFoundException {
        Intrinsics.checkNotNullParameter(session, "session");
        Object systemService = getSystemService("notification");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            androidx.media3.session.e.C();
            notificationManager.createNotificationChannel(androidx.media3.session.e.b());
        }
        if (session.c().B1() == null) {
            notificationManager.cancel(session.c().hashCode());
        } else {
            notificationManager.notify(session.c().hashCode(), i(session));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Notification i(MediaSession mediaSession) throws Resources.NotFoundException {
        Class cls = this.f15590k;
        if (cls == null) {
            cls = VideoPlaybackService.class;
        }
        Intent intent = new Intent(this, (Class<?>) cls);
        intent.setFlags(603979776);
        if (Build.VERSION.SDK_INT >= 33) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "RNVIDEO_SESSION_NOTIFICATION");
            builder.y.icon = androidx.media3.session.R.drawable.media3_icon_circular_play;
            builder.o(new MediaStyleNotificationHelper.MediaStyle(mediaSession));
            builder.f2670g = PendingIntent.getActivity(this, 0, intent, 201326592);
            Notification notificationB = builder.b();
            Intrinsics.c(notificationB);
            return notificationB;
        }
        int iHashCode = mediaSession.c().hashCode();
        Intent intent2 = new Intent(this, (Class<?>) VideoPlaybackService.class);
        intent2.putExtra("PLAYER_ID", iHashCode);
        Companion.COMMAND command = Companion.COMMAND.f15593a;
        intent2.putExtra("ACTION", "COMMAND_SEEK_BACKWARD");
        int i2 = iHashCode * 10;
        PendingIntent service = PendingIntent.getService(this, i2, intent2, 167772160);
        Intent intent3 = new Intent(this, (Class<?>) VideoPlaybackService.class);
        intent3.putExtra("PLAYER_ID", iHashCode);
        intent3.putExtra("ACTION", "COMMAND_TOGGLE_PLAY");
        PendingIntent service2 = PendingIntent.getService(this, i2 + 1, intent3, 167772160);
        Intent intent4 = new Intent(this, (Class<?>) VideoPlaybackService.class);
        intent4.putExtra("PLAYER_ID", iHashCode);
        intent4.putExtra("ACTION", "COMMAND_SEEK_FORWARD");
        PendingIntent service3 = PendingIntent.getService(this, i2 + 2, intent4, 167772160);
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this, "RNVIDEO_SESSION_NOTIFICATION");
        builder2.s = 1;
        builder2.y.icon = androidx.media3.session.R.drawable.media3_icon_circular_play;
        builder2.a(androidx.media3.session.R.drawable.media3_icon_rewind, "Seek Backward", service);
        builder2.a(mediaSession.c().j1() ? androidx.media3.session.R.drawable.media3_icon_pause : androidx.media3.session.R.drawable.media3_icon_play, "Toggle Play", service2);
        builder2.a(androidx.media3.session.R.drawable.media3_icon_fast_forward, "Seek Forward", service3);
        MediaStyleNotificationHelper.MediaStyle mediaStyle = new MediaStyleNotificationHelper.MediaStyle(mediaSession);
        mediaStyle.f10166c = new int[]{0, 1, 2};
        builder2.o(mediaStyle);
        builder2.f2668e = NotificationCompat.Builder.c(mediaSession.c().x1().f5379a);
        builder2.f2669f = NotificationCompat.Builder.c(mediaSession.c().x1().f5385g);
        builder2.f2670g = PendingIntent.getActivity(this, 0, intent, 201326592);
        Uri uri = mediaSession.c().x1().f5391m;
        builder2.j(uri != null ? (Bitmap) ((CacheBitmapLoader) mediaSession.a()).b(uri).get() : null);
        builder2.i(2, true);
        Notification notificationB2 = builder2.b();
        Intrinsics.c(notificationB2);
        return notificationB2;
    }

    public final void j() {
        Object systemService = getSystemService("notification");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancelAll();
        LinkedHashMap linkedHashMap = this.f15588i;
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            ((MediaSession) ((Map.Entry) it.next()).getValue()).d();
        }
        linkedHashMap.clear();
    }

    public final void k(ExoPlayer player, Class from) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(from, "from");
        LinkedHashMap linkedHashMap = this.f15588i;
        if (linkedHashMap.containsKey(player)) {
            return;
        }
        this.f15590k = from;
        MediaSession.Builder builder = new MediaSession.Builder(this, player);
        builder.d("RNVideoPlaybackService_" + player.hashCode());
        builder.b(new VideoPlaybackCallback());
        builder.c(Util.l(this.f15591l, this.f15592m));
        MediaSession mediaSessionA = builder.a();
        Intrinsics.checkNotNullExpressionValue(mediaSessionA, "build(...)");
        linkedHashMap.put(player, mediaSessionA);
        a(mediaSessionA);
        startForeground(player.hashCode(), i(mediaSessionA));
    }

    public final void l(ExoPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        Object systemService = getSystemService("notification");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(player.hashCode());
        LinkedHashMap linkedHashMap = this.f15588i;
        MediaSession mediaSession = (MediaSession) linkedHashMap.remove(player);
        if (mediaSession != null) {
            mediaSession.d();
        }
        if (linkedHashMap.isEmpty()) {
            j();
            stopSelf();
        }
    }

    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    public final IBinder onBind(Intent intent) {
        super.onBind(intent);
        return this.f15589j;
    }

    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    public final void onDestroy() {
        j();
        Object systemService = getSystemService("notification");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.deleteNotificationChannel("RNVIDEO_SESSION_NOTIFICATION");
        }
        super.onDestroy();
    }

    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        Object next;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            Object systemService = getSystemService("notification");
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            if (i4 >= 26) {
                androidx.media3.session.e.C();
                notificationManager.createNotificationChannel(androidx.media3.session.e.b());
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "RNVIDEO_SESSION_NOTIFICATION");
            builder.y.icon = androidx.media3.session.R.drawable.media3_icon_circular_play;
            builder.f2668e = NotificationCompat.Builder.c(getString(com.brentvatne.react.R.string.media_playback_notification_title));
            builder.f2669f = NotificationCompat.Builder.c(getString(com.brentvatne.react.R.string.media_playback_notification_text));
            Notification notificationB = builder.b();
            Intrinsics.checkNotNullExpressionValue(notificationB, "build(...)");
            startForeground(9999, notificationB);
        }
        if (intent != null) {
            int intExtra = intent.getIntExtra("PLAYER_ID", -1);
            String stringExtra = intent.getStringExtra("ACTION");
            if (intExtra < 0) {
                DebugLog.e("VideoPlaybackService", "Received Command without playerId");
                super.onStartCommand(intent, i2, i3);
                return 1;
            }
            if (stringExtra == null) {
                DebugLog.e("VideoPlaybackService", "Received Command without action command");
                super.onStartCommand(intent, i2, i3);
                return 1;
            }
            Iterator it = this.f15588i.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((MediaSession) next).c().hashCode() == intExtra) {
                    break;
                }
            }
            MediaSession mediaSession = (MediaSession) next;
            if (mediaSession == null) {
                super.onStartCommand(intent, i2, i3);
                return 1;
            }
            Companion.b(Companion.a(stringExtra), mediaSession);
        }
        super.onStartCommand(intent, i2, i3);
        return 1;
    }

    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    public final void onTaskRemoved(Intent intent) {
        j();
        stopSelf();
    }
}
