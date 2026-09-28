package androidx.media3.session;

import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class e {
    public static /* synthetic */ void C() {
    }

    public static /* synthetic */ NotificationChannel b() {
        return new NotificationChannel("RNVIDEO_SESSION_NOTIFICATION", "RNVIDEO_SESSION_NOTIFICATION", 2);
    }

    public static /* synthetic */ NotificationChannel d(String str, String str2) {
        return new NotificationChannel(str, str2, 2);
    }

    public static /* synthetic */ PictureInPictureParams.Builder g() {
        return new PictureInPictureParams.Builder();
    }

    public static /* synthetic */ RemoteAction i(Icon icon, String str, String str2, PendingIntent pendingIntent) {
        return new RemoteAction(icon, str, str2, pendingIntent);
    }

    public static /* synthetic */ void o() {
    }
}
