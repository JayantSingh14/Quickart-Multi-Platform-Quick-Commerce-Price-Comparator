package com.zeptoconsumerapp.modules.notification.utils;

import android.content.Context;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.impl.WorkManagerImpl;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.zeptoconsumerapp.modules.notification.constants.NotificationCategory;
import com.zeptoconsumerapp.modules.notification.constants.NotificationConfig;
import com.zeptoconsumerapp.modules.notification.constants.NotificationDataMap;
import com.zeptoconsumerapp.modules.notification.model.NotificationMetadata;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class NotificationUtilsKt {
    public static final void a(ReactApplicationContext context, ReadableMap data, String category) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationCategory[] notificationCategoryArr = NotificationCategory.f47660a;
        if (Intrinsics.b(category, "PROMO_CASH_ONGOING")) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                NotificationDataMap[] notificationDataMapArr = NotificationDataMap.f47664a;
                String string = data.getString("orderPlaceTime");
                Object obj = null;
                Long lValueOf = string != null ? Long.valueOf(Long.parseLong(string)) : null;
                if (lValueOf == null) {
                    return;
                }
                NotificationManagerCompat notificationManagerCompat = new NotificationManagerCompat(context);
                StatusBarNotification[] activeNotifications = notificationManagerCompat.f2692b.getActiveNotifications();
                Iterable arrayList = activeNotifications == null ? new ArrayList() : Arrays.asList(activeNotifications);
                Intrinsics.checkNotNullExpressionValue(arrayList, "getActiveNotifications(...)");
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    Bundle bundle = ((StatusBarNotification) next).getNotification().extras;
                    NotificationConfig[] notificationConfigArr = NotificationConfig.f47662a;
                    long j2 = bundle.getLong("sticky_notification_creation_time");
                    if (j2 > 0 && j2 < lValueOf.longValue()) {
                        obj = next;
                        break;
                    }
                }
                StatusBarNotification statusBarNotification = (StatusBarNotification) obj;
                if (statusBarNotification != null) {
                    notificationManagerCompat.b(statusBarNotification.getId());
                }
            } catch (Exception unused) {
            }
        }
    }

    public static final Pair b(Map data) {
        Intrinsics.checkNotNullParameter(data, "data");
        NotificationConfig[] notificationConfigArr = NotificationConfig.f47662a;
        String str = (String) data.get("z_ti");
        NotificationConfig[] notificationConfigArr2 = NotificationConfig.f47662a;
        String str2 = (String) data.get("z_b");
        NotificationConfig[] notificationConfigArr3 = NotificationConfig.f47662a;
        Object objFromHtml = (String) data.get("cds_title");
        NotificationConfig[] notificationConfigArr4 = NotificationConfig.f47662a;
        Object objFromHtml2 = (String) data.get("cds_body");
        if (str != null && str.length() != 0) {
            objFromHtml = Html.fromHtml(str, 0);
        }
        if (str2 != null && str2.length() != 0) {
            objFromHtml2 = Html.fromHtml(str2, 0);
        }
        return new Pair(objFromHtml, objFromHtml2);
    }

    public static final void c(NotificationCompat.Builder builder, Context context, NotificationMetadata metadata) throws Throwable {
        Long l2;
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        if (!metadata.f47687b || (l2 = metadata.f47688c) == null) {
            builder.d(true);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bundle bundle = new Bundle();
        NotificationConfig[] notificationConfigArr = NotificationConfig.f47662a;
        bundle.putLong("sticky_notification_creation_time", jCurrentTimeMillis);
        builder.i(2, true);
        builder.i(16, false);
        builder.q = bundle;
        long jLongValue = l2.longValue();
        Intrinsics.checkNotNullParameter(context, "context");
        long jCurrentTimeMillis2 = jLongValue - System.currentTimeMillis();
        if (jCurrentTimeMillis2 < 0) {
            return;
        }
        Data.Builder builder2 = new Data.Builder();
        HashMap map = builder2.f12511a;
        int i2 = metadata.f47686a;
        map.put("notification_id", Integer.valueOf(i2));
        map.put("time_of_creation", Long.valueOf(jCurrentTimeMillis));
        Data dataA = builder2.a();
        Intrinsics.checkNotNullExpressionValue(dataA, "build(...)");
        Intrinsics.checkNotNullParameter(NotificationRemovalWorker.class, "workerClass");
        WorkManagerImpl.f(context).b((OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(NotificationRemovalWorker.class).f(jCurrentTimeMillis2, TimeUnit.MILLISECONDS)).g(dataA)).a("notification_removal")).a("notification_" + i2)).b());
    }
}
