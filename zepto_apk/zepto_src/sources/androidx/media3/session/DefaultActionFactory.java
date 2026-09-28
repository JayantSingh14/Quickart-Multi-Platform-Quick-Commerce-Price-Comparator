package androidx.media3.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.view.KeyEvent;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaNotification;

/* loaded from: classes3.dex */
final class DefaultActionFactory implements MediaNotification.ActionFactory {

    /* renamed from: a, reason: collision with root package name */
    public final MediaSessionService f9920a;

    /* renamed from: b, reason: collision with root package name */
    public int f9921b = 0;

    @RequiresApi
    public static final class Api26 {
    }

    public DefaultActionFactory(MediaSessionService mediaSessionService) {
        this.f9920a = mediaSessionService;
    }

    public final PendingIntent a(MediaSession mediaSession, long j2) {
        int i2 = (j2 == 8 || j2 == 9) ? 87 : (j2 == 6 || j2 == 7) ? 88 : j2 == 3 ? 86 : j2 == 12 ? 90 : j2 == 11 ? 89 : j2 == 1 ? 85 : 0;
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setData(mediaSession.b().f10092b);
        MediaSessionService mediaSessionService = this.f9920a;
        intent.setComponent(new ComponentName(mediaSessionService, mediaSessionService.getClass()));
        intent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, i2));
        int i3 = Util.f5744a;
        if (i3 < 26 || j2 != 1 || mediaSession.c().O0()) {
            return PendingIntent.getService(mediaSessionService, i2, intent, i3 >= 23 ? 67108864 : 0);
        }
        return PendingIntent.getForegroundService(mediaSessionService, i2, intent, 67108864);
    }
}
