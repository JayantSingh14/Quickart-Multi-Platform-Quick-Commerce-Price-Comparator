package androidx.media3.session;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaNotification;
import com.google.common.util.concurrent.FutureCallback;

@UnstableApi
/* loaded from: classes3.dex */
public class DefaultMediaNotificationProvider implements MediaNotification.Provider {

    /* renamed from: f, reason: collision with root package name */
    public static final int f9922f = R.string.default_notification_channel_name;

    /* renamed from: a, reason: collision with root package name */
    public final Context f9923a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9924b;

    /* renamed from: c, reason: collision with root package name */
    public final NotificationManager f9925c;

    /* renamed from: d, reason: collision with root package name */
    public OnBitmapLoadedFutureCallback f9926d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9927e;

    @RequiresApi
    public static class Api26 {
        @DoNotInline
        public static void a(NotificationManager notificationManager, String str, String str2) {
            NotificationChannel notificationChannelD = e.d(str, str2);
            if (Util.f5744a <= 27) {
                notificationChannelD.setShowBadge(false);
            }
            notificationManager.createNotificationChannel(notificationChannelD);
        }
    }

    @RequiresApi
    public static class Api31 {
        @DoNotInline
        public static void a(NotificationCompat.Builder builder) {
            builder.w = 1;
        }
    }

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final Context f9928a;

        /* renamed from: b, reason: collision with root package name */
        public final o0 f9929b = new o0(29);

        /* renamed from: c, reason: collision with root package name */
        public final int f9930c = DefaultMediaNotificationProvider.f9922f;

        /* renamed from: d, reason: collision with root package name */
        public boolean f9931d;

        public Builder(Context context) {
            this.f9928a = context;
        }
    }

    public interface NotificationIdProvider {
    }

    public static class OnBitmapLoadedFutureCallback implements FutureCallback<Bitmap> {

        /* renamed from: a, reason: collision with root package name */
        public final int f9932a;

        /* renamed from: b, reason: collision with root package name */
        public final NotificationCompat.Builder f9933b;

        /* renamed from: c, reason: collision with root package name */
        public final l f9934c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f9935d;

        public OnBitmapLoadedFutureCallback(int i2, NotificationCompat.Builder builder, l lVar) {
            this.f9932a = i2;
            this.f9933b = builder;
            this.f9934c = lVar;
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public final void onFailure(Throwable th) {
            if (this.f9935d) {
                return;
            }
            int i2 = DefaultMediaNotificationProvider.f9922f;
            Log.h("NotificationProvider", "Failed to load bitmap: " + th.getMessage());
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public final void onSuccess(Object obj) throws Resources.NotFoundException {
            Bitmap bitmap = (Bitmap) obj;
            if (this.f9935d) {
                return;
            }
            NotificationCompat.Builder builder = this.f9933b;
            builder.j(bitmap);
            MediaNotification mediaNotification = new MediaNotification(this.f9932a, builder.b());
            l lVar = this.f9934c;
            MediaNotificationManager mediaNotificationManager = (MediaNotificationManager) lVar.f10409b;
            mediaNotificationManager.f10049e.execute(new b1(lVar.f10410c, 0, mediaNotificationManager, (MediaSession) lVar.f10411d, mediaNotification));
        }
    }

    public DefaultMediaNotificationProvider(Builder builder) {
        o0 o0Var = builder.f9929b;
        Context context = builder.f9928a;
        this.f9923a = context;
        this.f9924b = builder.f9930c;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Assertions.h(notificationManager);
        this.f9925c = notificationManager;
        this.f9927e = R.drawable.media3_notification_small_icon;
    }
}
