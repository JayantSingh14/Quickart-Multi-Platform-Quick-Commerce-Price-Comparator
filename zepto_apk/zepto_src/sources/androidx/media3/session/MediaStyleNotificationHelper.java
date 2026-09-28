package androidx.media3.session;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.res.Resources;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@UnstableApi
/* loaded from: classes3.dex */
public class MediaStyleNotificationHelper {

    @RequiresApi
    public static class Api21Impl {
        @DoNotInline
        public static Notification.MediaStyle a() {
            return new Notification.MediaStyle();
        }

        @DoNotInline
        public static Notification.MediaStyle b(Notification.MediaStyle mediaStyle, @Nullable int[] iArr, MediaSession mediaSession) {
            mediaStyle.getClass();
            mediaSession.getClass();
            if (iArr != null) {
                d(mediaStyle, iArr);
            }
            mediaStyle.setMediaSession((MediaSession.Token) mediaSession.f10060a.f10098h.f10119k.d().f10639b);
            return mediaStyle;
        }

        @DoNotInline
        public static void c(Notification.Builder builder, Notification.MediaStyle mediaStyle) {
            builder.setStyle(mediaStyle);
        }

        @DoNotInline
        public static void d(Notification.MediaStyle mediaStyle, int... iArr) {
            mediaStyle.setShowActionsInCompactView(iArr);
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static Notification.DecoratedMediaCustomViewStyle a() {
            return new Notification.DecoratedMediaCustomViewStyle();
        }
    }

    @RequiresApi
    public static class Api34Impl {
        @CanIgnoreReturnValue
        @DoNotInline
        @SuppressLint({"MissingPermission"})
        public static Notification.MediaStyle a(Notification.MediaStyle mediaStyle, CharSequence charSequence, @DrawableRes int i2, @Nullable PendingIntent pendingIntent) {
            mediaStyle.setRemotePlaybackInfo(charSequence, i2, pendingIntent);
            return mediaStyle;
        }
    }

    public static class DecoratedMediaCustomViewStyle extends MediaStyle {
        @Override // androidx.media3.session.MediaStyleNotificationHelper.MediaStyle, androidx.core.app.NotificationCompat.Style
        public final void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Util.f5744a < 24) {
                super.b(notificationBuilderWithBuilderAccessor);
                return;
            }
            Notification.Builder builderA = notificationBuilderWithBuilderAccessor.a();
            Notification.DecoratedMediaCustomViewStyle decoratedMediaCustomViewStyleA = Api24Impl.a();
            int[] iArr = this.f10166c;
            MediaSession mediaSession = this.f10165b;
            Api21Impl.c(builderA, Api21Impl.b(decoratedMediaCustomViewStyleA, iArr, mediaSession));
            Bundle bundle = new Bundle();
            bundle.putBundle("androidx.media3.session", mediaSession.f10060a.f10100j.a());
            notificationBuilderWithBuilderAccessor.a().addExtras(bundle);
        }

        @Override // androidx.media3.session.MediaStyleNotificationHelper.MediaStyle, androidx.core.app.NotificationCompat.Style
        public final RemoteViews h() throws Resources.NotFoundException {
            int i2 = Util.f5744a;
            if (i2 >= 24) {
                return null;
            }
            NotificationCompat.Builder builder = this.f2679a;
            RemoteViews remoteViews = builder.u;
            if (remoteViews == null) {
                remoteViews = builder.t;
            }
            if (remoteViews == null) {
                return null;
            }
            RemoteViews remoteViewsK = k();
            d(remoteViewsK, remoteViews);
            if (i2 >= 21) {
                p(remoteViewsK);
            }
            return remoteViewsK;
        }

        @Override // androidx.media3.session.MediaStyleNotificationHelper.MediaStyle, androidx.core.app.NotificationCompat.Style
        public final RemoteViews i() throws Resources.NotFoundException {
            int i2 = Util.f5744a;
            if (i2 >= 24) {
                return null;
            }
            NotificationCompat.Builder builder = this.f2679a;
            boolean z = builder.t != null;
            if (i2 < 21) {
                RemoteViews remoteViewsL = l();
                if (!z) {
                    return null;
                }
                d(remoteViewsL, this.f2679a.t);
                return remoteViewsL;
            }
            if (!z && builder.u == null) {
                return null;
            }
            RemoteViews remoteViewsL2 = l();
            if (z) {
                d(remoteViewsL2, this.f2679a.t);
            }
            p(remoteViewsL2);
            return remoteViewsL2;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public final RemoteViews j() throws Resources.NotFoundException {
            int i2 = Util.f5744a;
            if (i2 >= 24) {
                return null;
            }
            this.f2679a.getClass();
            RemoteViews remoteViews = this.f2679a.t;
            if (remoteViews == null) {
                return null;
            }
            RemoteViews remoteViewsK = k();
            d(remoteViewsK, remoteViews);
            if (i2 >= 21) {
                p(remoteViewsK);
            }
            return remoteViewsK;
        }

        @Override // androidx.media3.session.MediaStyleNotificationHelper.MediaStyle
        public final int n(int i2) {
            return i2 <= 3 ? R.layout.media3_notification_template_big_media_narrow_custom : R.layout.media3_notification_template_big_media_custom;
        }

        @Override // androidx.media3.session.MediaStyleNotificationHelper.MediaStyle
        public final int o() {
            return this.f2679a.t != null ? R.layout.media3_notification_template_media_custom : R.layout.media3_notification_template_media;
        }

        public final void p(RemoteViews remoteViews) throws Resources.NotFoundException {
            NotificationCompat.Builder builder = this.f2679a;
            int color = builder.r;
            if (color == 0) {
                color = builder.f2664a.getResources().getColor(R.color.notification_material_background_media_default_color);
            }
            remoteViews.setInt(R.id.status_bar_latest_event_content, "setBackgroundColor", color);
        }
    }

    public static class MediaStyle extends NotificationCompat.Style {

        /* renamed from: b, reason: collision with root package name */
        public final MediaSession f10165b;

        /* renamed from: c, reason: collision with root package name */
        public int[] f10166c;

        public MediaStyle(MediaSession mediaSession) {
            this.f10165b = mediaSession;
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public void b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Util.f5744a >= 21) {
                Notification.Builder builderA = notificationBuilderWithBuilderAccessor.a();
                Notification.MediaStyle mediaStyleA = Api21Impl.a();
                int[] iArr = this.f10166c;
                MediaSession mediaSession = this.f10165b;
                Api21Impl.c(builderA, Api21Impl.b(mediaStyleA, iArr, mediaSession));
                Bundle bundle = new Bundle();
                bundle.putBundle("androidx.media3.session", mediaSession.f10060a.f10100j.a());
                notificationBuilderWithBuilderAccessor.a().addExtras(bundle);
            }
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews h() {
            if (Util.f5744a >= 21) {
                return null;
            }
            return k();
        }

        @Override // androidx.core.app.NotificationCompat.Style
        public RemoteViews i() {
            if (Util.f5744a >= 21) {
                return null;
            }
            return l();
        }

        public final RemoteViews k() throws Resources.NotFoundException {
            int iMin = Math.min(this.f2679a.f2665b.size(), 5);
            RemoteViews remoteViewsC = c(n(iMin), false, false);
            remoteViewsC.removeAllViews(R.id.media_actions);
            if (iMin > 0) {
                for (int i2 = 0; i2 < iMin; i2++) {
                    remoteViewsC.addView(R.id.media_actions, m((NotificationCompat.Action) this.f2679a.f2665b.get(i2)));
                }
            }
            remoteViewsC.setViewVisibility(R.id.cancel_action, 8);
            return remoteViewsC;
        }

        public final RemoteViews l() throws Resources.NotFoundException {
            RemoteViews remoteViewsC = c(o(), false, true);
            int size = this.f2679a.f2665b.size();
            int[] iArr = this.f10166c;
            if (iArr != null) {
                int iMin = Math.min(iArr.length, 3);
                remoteViewsC.removeAllViews(R.id.media_actions);
                if (iMin > 0) {
                    for (int i2 = 0; i2 < iMin; i2++) {
                        if (i2 >= size) {
                            throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", Integer.valueOf(i2), Integer.valueOf(size - 1)));
                        }
                        remoteViewsC.addView(R.id.media_actions, m((NotificationCompat.Action) this.f2679a.f2665b.get(iArr[i2])));
                    }
                }
            }
            remoteViewsC.setViewVisibility(R.id.end_padder, 0);
            remoteViewsC.setViewVisibility(R.id.cancel_action, 8);
            return remoteViewsC;
        }

        public final RemoteViews m(NotificationCompat.Action action) {
            boolean z = action.f2654h == null;
            RemoteViews remoteViews = new RemoteViews(this.f2679a.f2664a.getPackageName(), R.layout.media3_notification_media_action);
            IconCompat iconCompatA = action.a();
            if (iconCompatA != null) {
                remoteViews.setImageViewResource(R.id.action0, iconCompatA.e());
            }
            if (!z) {
                remoteViews.setOnClickPendingIntent(R.id.action0, action.f2654h);
            }
            remoteViews.setContentDescription(R.id.action0, action.f2653g);
            return remoteViews;
        }

        public int n(int i2) {
            return i2 <= 3 ? R.layout.media3_notification_template_big_media_narrow : R.layout.media3_notification_template_big_media;
        }

        public int o() {
            return R.layout.media3_notification_template_media;
        }
    }
}
