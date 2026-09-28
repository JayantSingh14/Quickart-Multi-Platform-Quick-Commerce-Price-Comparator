package androidx.media3.exoplayer.offline;

import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class DownloadNotificationHelper {

    @RequiresApi
    public static final class Api31 {
        @DoNotInline
        @SuppressLint({"WrongConstant"})
        public static void a(NotificationCompat.Builder builder) {
            builder.w = 1;
        }
    }
}
