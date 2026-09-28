package androidx.media.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;

/* loaded from: classes3.dex */
public class NotificationCompat {

    @RequiresApi
    public static class Api15Impl {
        @DoNotInline
        public static void a(RemoteViews remoteViews, int i2, CharSequence charSequence) {
            remoteViews.setContentDescription(i2, charSequence);
        }
    }

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static Notification.MediaStyle a() {
            return new Notification.MediaStyle();
        }

        @DoNotInline
        public static Notification.MediaStyle b(Notification.MediaStyle mediaStyle, int[] iArr, MediaSessionCompat.Token token) {
            if (iArr != null) {
                e(mediaStyle, iArr);
            }
            if (token != null) {
                c(mediaStyle, (MediaSession.Token) token.f90b);
            }
            return mediaStyle;
        }

        @DoNotInline
        public static void c(Notification.MediaStyle mediaStyle, MediaSession.Token token) {
            mediaStyle.setMediaSession(token);
        }

        @DoNotInline
        public static void d(Notification.Builder builder, Notification.MediaStyle mediaStyle) {
            builder.setStyle(mediaStyle);
        }

        @DoNotInline
        public static void e(Notification.MediaStyle mediaStyle, int... iArr) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static Notification.MediaStyle a() {
            return new Notification.DecoratedMediaCustomViewStyle();
        }
    }

    @RequiresApi
    public static class Api34Impl {
        @DoNotInline
        @SuppressLint({"MissingPermission"})
        public static Notification.MediaStyle a(Notification.MediaStyle mediaStyle, @NonNull CharSequence charSequence, @DrawableRes int i2, @Nullable PendingIntent pendingIntent, Boolean bool) {
            if (bool.booleanValue()) {
                mediaStyle.setRemotePlaybackInfo(charSequence, i2, pendingIntent);
            }
            return mediaStyle;
        }
    }

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public final void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 34) {
                Api21Impl.d(notificationBuilderWithBuilderAccessor.a(), Api21Impl.b(Api34Impl.a(Api24Impl.a(), null, 0, null, Boolean.FALSE), null, null));
            } else {
                Api21Impl.d(notificationBuilderWithBuilderAccessor.a(), Api21Impl.b(Api24Impl.a(), null, null));
            }
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public final RemoteViews h() {
            return null;
        }

        @Override // androidx.media.app.NotificationCompat.MediaStyle, androidx.core.app.NotificationCompat.Style
        public final RemoteViews i() {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public final RemoteViews j() {
            return null;
        }
    }

    public static class MediaStyle extends NotificationCompat.Style {
        @Override // androidx.core.app.NotificationCompat.Style
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 34) {
                Api21Impl.d(notificationBuilderWithBuilderAccessor.a(), Api21Impl.b(Api34Impl.a(Api21Impl.a(), null, 0, null, Boolean.FALSE), null, null));
            } else {
                Api21Impl.d(notificationBuilderWithBuilderAccessor.a(), Api21Impl.b(Api21Impl.a(), null, null));
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews h() {
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews i() {
            return null;
        }
    }
}
