package com.zeptoconsumerapp.modules.notification.factory;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.media3.session.e;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.utils.CancelWorkRunnable;
import com.bumptech.glide.load.resource.bitmap.a;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.zeptoconsumerapp.BuildConfig;
import com.zeptoconsumerapp.R;
import com.zeptoconsumerapp.modules.notification.constants.NotificationConfig;
import com.zeptoconsumerapp.modules.notification.constants.NotificationRequest;
import com.zeptoconsumerapp.modules.notification.constants.NotificationTemplateType;
import com.zeptoconsumerapp.modules.notification.factory.provider.NotificationTemplateProvider;
import com.zeptoconsumerapp.modules.notification.factory.templates.BasicTemplate;
import com.zeptoconsumerapp.modules.notification.factory.templates.ImageTemplate;
import com.zeptoconsumerapp.modules.notification.factory.templates.NormalTemplate;
import com.zeptoconsumerapp.modules.notification.model.NotificationMetadata;
import com.zeptoconsumerapp.modules.notification.model.NotificationMetadataKt;
import com.zeptoconsumerapp.modules.notification.service.NotificationDismissReceiver;
import com.zeptoconsumerapp.modules.notification.utils.NotificationDataUtils;
import com.zeptoconsumerapp.modules.notification.utils.NotificationUtils;
import com.zeptoconsumerapp.modules.notification.utils.NotificationUtilsKt;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;

@Metadata
/* loaded from: classes4.dex */
public final class NotificationTemplateFactory {

    @Metadata
    @SourceDebugExtension
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Context f47675a;

        /* renamed from: b, reason: collision with root package name */
        public Map f47676b;

        @Metadata
        public static final class Companion {
        }

        public final NotificationHandler a() throws Exception {
            try {
                Map map = this.f47676b;
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
                Context context = this.f47675a;
                if (context != null) {
                    return new NotificationHandler(context, notificationB, notificationMetadataA.f47686a);
                }
                Intrinsics.h("mContext");
                throw null;
            } catch (Exception e2) {
                FirebaseCrashlytics.getInstance().recordException(e2);
                throw e2;
            }
        }

        public final Notification b(NotificationCompat.Builder builder) throws Throwable {
            String url;
            Bitmap bitmapDecodeStream;
            int i2;
            List listSplit$default;
            String str;
            Map map = this.f47676b;
            if (map == null) {
                Intrinsics.h("mData");
                throw null;
            }
            NotificationConfig[] notificationConfigArr = NotificationConfig.f47662a;
            String str2 = (String) map.get("z_t");
            NotificationTemplateType[] notificationTemplateTypeArr = NotificationTemplateType.f47673a;
            url = "";
            if (Intrinsics.b(str2, "i")) {
                Context context = this.f47675a;
                if (context == null) {
                    Intrinsics.h("mContext");
                    throw null;
                }
                Map map2 = this.f47676b;
                if (map2 == null) {
                    Intrinsics.h("mData");
                    throw null;
                }
                new ImageTemplate(context, builder, map2);
                NotificationMetadata notificationMetadataA = NotificationMetadataKt.a(map2);
                NotificationCompat.Builder builderA = new NotificationTemplateProvider(context, builder, map2).a();
                Pair pairB = NotificationUtilsKt.b(map2);
                CharSequence charSequence = (CharSequence) pairB.f53533a;
                CharSequence charSequence2 = (CharSequence) pairB.f53534b;
                String str3 = (String) map2.get("title_color");
                if (str3 == null) {
                    str3 = "";
                }
                int iA = NotificationUtils.Companion.a(context, str3);
                String str4 = (String) map2.get("message_color");
                if (str4 == null) {
                    str4 = "";
                }
                int iA2 = NotificationUtils.Companion.a(context, str4);
                boolean z = (charSequence2 == null || StringsKt.z(charSequence2) || StringsKt.b0(charSequence2.toString()).toString().length() <= 0) ? false : true;
                String str5 = (String) map2.get("z_sep");
                if (str5 == null) {
                    str5 = "$$";
                }
                String str6 = (String) map2.get("z_img");
                if (str6 != null && (listSplit$default = StringsKt__StringsKt.split$default(str6, new String[]{str5}, false, 0, 6, null)) != null && (str = (String) listSplit$default.get(1)) != null) {
                    url = str;
                }
                if (StringsKt.z(url)) {
                    bitmapDecodeStream = null;
                } else {
                    Intrinsics.checkNotNullParameter(url, "url");
                    try {
                        bitmapDecodeStream = BitmapFactory.decodeStream(new URL(url).openConnection().getInputStream());
                    } catch (IOException unused) {
                    }
                }
                boolean z2 = bitmapDecodeStream != null;
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), NotificationUtils.Companion.c(context));
                remoteViews.setTextViewText(R.id.title, charSequence);
                if (z) {
                    remoteViews.setTextViewText(R.id.message, charSequence2);
                    remoteViews.setTextColor(R.id.message, iA2);
                } else {
                    remoteViews.setViewVisibility(R.id.message, 8);
                }
                remoteViews.setTextColor(R.id.title, iA);
                boolean z3 = z2;
                RemoteViews remoteViews2 = new RemoteViews(context.getPackageName(), R.layout.image_layout_expanded);
                remoteViews2.setTextViewText(R.id.title, charSequence);
                if (z) {
                    remoteViews2.setTextViewText(R.id.message, charSequence2);
                    remoteViews2.setTextColor(R.id.message, iA2);
                    i2 = 8;
                } else {
                    i2 = 8;
                    remoteViews2.setViewVisibility(R.id.message, 8);
                }
                remoteViews2.setTextColor(R.id.title, iA);
                if (z3) {
                    remoteViews2.setImageViewBitmap(R.id.largeImage, bitmapDecodeStream);
                } else {
                    remoteViews2.setViewVisibility(R.id.largeImage, i2);
                }
                builderA.f2668e = NotificationCompat.Builder.c(charSequence);
                builderA.t = remoteViews;
                builderA.u = remoteViews2;
                Intrinsics.checkNotNullExpressionValue(builderA, "setCustomBigContentView(...)");
                NotificationUtilsKt.c(builderA, context, notificationMetadataA);
                Notification notificationB = builderA.b();
                Intrinsics.checkNotNullExpressionValue(notificationB, "build(...)");
                return notificationB;
            }
            if (!Intrinsics.b(str2, "b")) {
                Context context2 = this.f47675a;
                if (context2 == null) {
                    Intrinsics.h("mContext");
                    throw null;
                }
                Map map3 = this.f47676b;
                if (map3 == null) {
                    Intrinsics.h("mData");
                    throw null;
                }
                new NormalTemplate(context2, builder, map3);
                NotificationMetadata notificationMetadataA2 = NotificationMetadataKt.a(map3);
                int i3 = R.drawable.ic_notification_icon;
                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context2.getResources(), R.mipmap.ic_launcher);
                String str7 = (String) map3.get("cds_title");
                NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
                bigTextStyle.f2663b = NotificationCompat.Builder.c((CharSequence) map3.get("cds_body"));
                builder.y.icon = i3;
                builder.j(bitmapDecodeResource);
                builder.f2668e = NotificationCompat.Builder.c(str7);
                builder.o(bigTextStyle);
                builder.f2673j = 1;
                Intrinsics.checkNotNullExpressionValue(builder, "setPriority(...)");
                NotificationUtilsKt.c(builder, context2, notificationMetadataA2);
                Notification notificationB2 = builder.b();
                Intrinsics.checkNotNullExpressionValue(notificationB2, "build(...)");
                return notificationB2;
            }
            Context context3 = this.f47675a;
            if (context3 == null) {
                Intrinsics.h("mContext");
                throw null;
            }
            Map map4 = this.f47676b;
            if (map4 == null) {
                Intrinsics.h("mData");
                throw null;
            }
            new BasicTemplate(context3, builder, map4);
            NotificationMetadata notificationMetadataA3 = NotificationMetadataKt.a(map4);
            NotificationCompat.Builder builderA2 = new NotificationTemplateProvider(context3, builder, map4).a();
            Pair pairB2 = NotificationUtilsKt.b(map4);
            CharSequence charSequence3 = (CharSequence) pairB2.f53533a;
            CharSequence charSequence4 = (CharSequence) pairB2.f53534b;
            String str8 = (String) map4.get("title_color");
            if (str8 == null) {
                str8 = "";
            }
            int iA3 = NotificationUtils.Companion.a(context3, str8);
            String str9 = (String) map4.get("message_color");
            url = str9 != null ? str9 : "";
            int iA4 = NotificationUtils.Companion.a(context3, url);
            RemoteViews remoteViews3 = new RemoteViews(context3.getPackageName(), NotificationUtils.Companion.c(context3));
            remoteViews3.setTextViewText(R.id.title, charSequence3);
            remoteViews3.setTextViewText(R.id.message, charSequence4);
            remoteViews3.setTextColor(R.id.title, iA3);
            remoteViews3.setTextColor(R.id.message, iA4);
            RemoteViews remoteViews4 = new RemoteViews(context3.getPackageName(), R.layout.basic_layout_expanded);
            remoteViews4.setTextViewText(R.id.title, charSequence3);
            remoteViews4.setTextViewText(R.id.message, charSequence4);
            remoteViews4.setTextColor(R.id.title, iA3);
            remoteViews4.setTextColor(R.id.message, iA4);
            builderA2.f2668e = NotificationCompat.Builder.c(charSequence3);
            builderA2.f2669f = NotificationCompat.Builder.c(charSequence4);
            builderA2.t = remoteViews3;
            builderA2.u = remoteViews4;
            Intrinsics.checkNotNullExpressionValue(builderA2, "setCustomBigContentView(...)");
            NotificationUtilsKt.c(builderA2, context3, notificationMetadataA3);
            Notification notificationB3 = builderA2.b();
            Intrinsics.checkNotNullExpressionValue(notificationB3, "build(...)");
            return notificationB3;
        }

        public final NotificationCompat.Builder c(NotificationMetadata notificationMetadata) {
            NotificationCompat.Builder builder;
            if (Build.VERSION.SDK_INT >= 26) {
                Context context = this.f47675a;
                if (context == null) {
                    Intrinsics.h("mContext");
                    throw null;
                }
                NotificationConfig[] notificationConfigArr = NotificationConfig.f47662a;
                builder = new NotificationCompat.Builder(context, "default_channel_id");
            } else {
                Context context2 = this.f47675a;
                if (context2 == null) {
                    Intrinsics.h("mContext");
                    throw null;
                }
                builder = new NotificationCompat.Builder(context2, null);
            }
            Context context3 = this.f47675a;
            if (context3 == null) {
                Intrinsics.h("mContext");
                throw null;
            }
            NotificationRequest[] notificationRequestArr = NotificationRequest.f47671a;
            Map map = this.f47676b;
            if (map == null) {
                Intrinsics.h("mData");
                throw null;
            }
            NotificationConfig[] notificationConfigArr2 = NotificationConfig.f47662a;
            String str = (String) map.get("url");
            if (str == null) {
                str = BuildConfig.DEFAULT_DEEPLINK_URL;
            }
            Map map2 = this.f47676b;
            if (map2 == null) {
                Intrinsics.h("mData");
                throw null;
            }
            String string = new JSONObject(map2).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            Intent intent = new Intent("android.intent.action.VIEW");
            Context context4 = this.f47675a;
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
            Map map3 = this.f47676b;
            if (map3 == null) {
                Intrinsics.h("mData");
                throw null;
            }
            String string2 = new JSONObject(map3).toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            Context context5 = this.f47675a;
            if (context5 == null) {
                Intrinsics.h("mContext");
                throw null;
            }
            Intent intent2 = new Intent(context5, (Class<?>) NotificationDismissReceiver.class);
            intent2.setAction("com.zeptoconsumerapp.NOTIFICATION_DISMISSED");
            intent2.putExtra("notification_data", string2);
            int i2 = notificationMetadata.f47686a;
            intent2.putExtra("notification_id", i2);
            Context context6 = this.f47675a;
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
            int i2 = notificationMetadata.f47686a;
            Map data = this.f47676b;
            if (data == null) {
                Intrinsics.h("mData");
                throw null;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            NotificationConfig[] notificationConfigArr = NotificationConfig.f47662a;
            Long lC = NotificationDataUtils.c("z_ong_et", data);
            if (!NotificationDataUtils.a(data) || (lC != null && lC.longValue() > System.currentTimeMillis() + 10000)) {
                return null;
            }
            try {
                context = this.f47675a;
            } catch (Exception e2) {
                FirebaseCrashlytics.getInstance().recordException(e2);
            }
            if (context == null) {
                Intrinsics.h("mContext");
                throw null;
            }
            new NotificationManagerCompat(context).b(i2);
            Context context2 = this.f47675a;
            if (context2 != null) {
                return new NotificationHandler(context2, null, i2);
            }
            Intrinsics.h("mContext");
            throw null;
        }

        public final void e() {
            Context context = this.f47675a;
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
                NotificationConfig[] notificationConfigArr = NotificationConfig.f47662a;
                NotificationChannel notificationChannelB = a.b();
                notificationChannelB.setDescription("Default");
                Context context2 = this.f47675a;
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
        public final Context f47677a;

        /* renamed from: b, reason: collision with root package name */
        public final Notification f47678b;

        /* renamed from: c, reason: collision with root package name */
        public final int f47679c;

        public NotificationHandler(Context context, Notification notification, int i2) {
            this.f47677a = context;
            this.f47678b = notification;
            this.f47679c = i2;
        }
    }
}
