package com.falcon.notification.factory;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.media3.session.e;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.CancelWorkRunnable;
import com.bumptech.glide.load.resource.bitmap.a;
import com.falcon.FalconConfig;
import com.falcon.notification.constants.NotificationConfig;
import com.falcon.notification.constants.NotificationRequest;
import com.falcon.notification.model.NotificationMetadata;
import com.falcon.notification.model.NotificationMetadataKt;
import com.falcon.notification.service.NotificationDismissReceiver;
import com.falcon.notification.utils.NotificationDataUtils;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.zeptoconsumerapp.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata
/* loaded from: classes3.dex */
public final class NotificationTemplateFactory {

    @Metadata
    @SourceDebugExtension
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Context f20471a;

        /* renamed from: b, reason: collision with root package name */
        public Map f20472b;

        @Metadata
        public static final class Companion {
        }

        public final NotificationHandler a() {
            try {
                Map map = this.f20472b;
                if (map == null) {
                    Intrinsics.h("mData");
                    throw null;
                }
                NotificationMetadata notificationMetadataA = NotificationMetadataKt.a(map);
                NotificationHandler notificationHandlerD = d(notificationMetadataA);
                if (notificationHandlerD != null) {
                    return notificationHandlerD;
                }
                e();
                Notification notificationB = b(c(notificationMetadataA));
                Context context = this.f20471a;
                if (context != null) {
                    return new NotificationHandler(context, notificationB, notificationMetadataA.f20485a);
                }
                Intrinsics.h("mContext");
                throw null;
            } catch (Exception e2) {
                FirebaseCrashlytics.getInstance().recordException(e2);
                throw e2;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:153:0x02f1  */
        /* JADX WARN: Removed duplicated region for block: B:154:0x02fb  */
        /* JADX WARN: Removed duplicated region for block: B:203:0x02ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00a6  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final android.app.Notification b(androidx.core.app.NotificationCompat.Builder r29) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 1041
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.falcon.notification.factory.NotificationTemplateFactory.Builder.b(androidx.core.app.NotificationCompat$Builder):android.app.Notification");
        }

        public final NotificationCompat.Builder c(NotificationMetadata notificationMetadata) {
            NotificationCompat.Builder builder;
            if (Build.VERSION.SDK_INT >= 26) {
                Context context = this.f20471a;
                if (context == null) {
                    Intrinsics.h("mContext");
                    throw null;
                }
                NotificationConfig[] notificationConfigArr = NotificationConfig.f20458a;
                builder = new NotificationCompat.Builder(context, "default_channel_id");
            } else {
                Context context2 = this.f20471a;
                if (context2 == null) {
                    Intrinsics.h("mContext");
                    throw null;
                }
                builder = new NotificationCompat.Builder(context2, null);
            }
            Context context3 = this.f20471a;
            if (context3 == null) {
                Intrinsics.h("mContext");
                throw null;
            }
            NotificationRequest[] notificationRequestArr = NotificationRequest.f20467a;
            if (FalconConfig.f20434b == null) {
                throw new IllegalStateException("FalconConfig is not initialized. Call FalconConfig.init() first.");
            }
            Map map = this.f20472b;
            if (map == null) {
                Intrinsics.h("mData");
                throw null;
            }
            NotificationConfig[] notificationConfigArr2 = NotificationConfig.f20458a;
            Object obj = map.get("url");
            String str = obj instanceof String ? (String) obj : null;
            if (str == null || StringsKt.z(str)) {
                str = BuildConfig.DEFAULT_DEEPLINK_URL;
            }
            Map map2 = this.f20472b;
            if (map2 == null) {
                Intrinsics.h("mData");
                throw null;
            }
            String string = new JSONObject(map2).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            Intent intent = new Intent("android.intent.action.VIEW");
            Context context4 = this.f20471a;
            if (context4 == null) {
                Intrinsics.h("mContext");
                throw null;
            }
            intent.setPackage(context4.getPackageName());
            intent.addFlags(67108864);
            intent.putExtra("android.intent.extra.INTENT", "launched_from_notification_service");
            intent.putExtra("notification_data", string);
            intent.putExtra("launched_from_notification_service", "true");
            intent.setData(Uri.parse(str));
            PendingIntent activity = PendingIntent.getActivity(context3, 1000, intent, 201326592);
            Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
            builder.f2670g = activity;
            int i2 = notificationMetadata.f20485a;
            Map map3 = this.f20472b;
            if (map3 == null) {
                Intrinsics.h("mData");
                throw null;
            }
            String string2 = new JSONObject(map3).toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            Context context5 = this.f20471a;
            if (context5 == null) {
                Intrinsics.h("mContext");
                throw null;
            }
            Intent intent2 = new Intent(context5, (Class<?>) NotificationDismissReceiver.class);
            intent2.setAction("com.zeptoconsumerapp.NOTIFICATION_DISMISSED");
            intent2.putExtra("notification_data", string2);
            intent2.putExtra("notification_id", i2);
            Context context6 = this.f20471a;
            if (context6 == null) {
                Intrinsics.h("mContext");
                throw null;
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(context6, i2, intent2, 201326592);
            Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
            builder.y.deleteIntent = broadcast;
            return builder;
        }

        public final NotificationHandler d(NotificationMetadata notificationMetadata) {
            Context context;
            int i2 = notificationMetadata.f20485a;
            Map data = this.f20472b;
            if (data == null) {
                Intrinsics.h("mData");
                throw null;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            NotificationConfig[] notificationConfigArr = NotificationConfig.f20458a;
            Long lC = NotificationDataUtils.c("z_ong_et", data);
            if (!NotificationDataUtils.a(data) || (lC != null && lC.longValue() > System.currentTimeMillis() + 10000)) {
                return null;
            }
            try {
                context = this.f20471a;
            } catch (Exception e2) {
                FirebaseCrashlytics.getInstance().recordException(e2);
            }
            if (context == null) {
                Intrinsics.h("mContext");
                throw null;
            }
            NotificationManagerCompat notificationManagerCompat = new NotificationManagerCompat(context);
            Intrinsics.checkNotNullExpressionValue(notificationManagerCompat, "from(...)");
            notificationManagerCompat.b(i2);
            Context context2 = this.f20471a;
            if (context2 != null) {
                return new NotificationHandler(context2, null, i2);
            }
            Intrinsics.h("mContext");
            throw null;
        }

        public final void e() {
            Context context = this.f20471a;
            if (context == null) {
                Intrinsics.h("mContext");
                throw null;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                WorkManagerImpl workManagerImplF = WorkManagerImpl.f(context);
                workManagerImplF.getClass();
                workManagerImplF.f12656d.c(CancelWorkRunnable.d(workManagerImplF, "notification_repeat"));
            } catch (Exception unused) {
            }
            if (Build.VERSION.SDK_INT >= 26) {
                e.C();
                NotificationConfig[] notificationConfigArr = NotificationConfig.f20458a;
                NotificationChannel notificationChannelB = a.b();
                notificationChannelB.setDescription("Default");
                Context context2 = this.f20471a;
                if (context2 != null) {
                    ((NotificationManager) context2.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannelB);
                } else {
                    Intrinsics.h("mContext");
                    throw null;
                }
            }
        }
    }

    @Metadata
    public static final class NotificationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final Context f20473a;

        /* renamed from: b, reason: collision with root package name */
        public final Notification f20474b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20475c;

        public NotificationHandler(Context context, Notification notification, int i2) {
            this.f20473a = context;
            this.f20474b = notification;
            this.f20475c = i2;
        }
    }
}
