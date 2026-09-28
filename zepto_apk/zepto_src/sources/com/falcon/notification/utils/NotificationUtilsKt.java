package com.falcon.notification.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.impl.WorkManagerImpl;
import com.falcon.notification.constants.NotificationConfig;
import com.falcon.notification.model.NotificationMetadata;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class NotificationUtilsKt {
    public static final Pair a(Map data) {
        Intrinsics.checkNotNullParameter(data, "data");
        NotificationConfig[] notificationConfigArr = NotificationConfig.f20458a;
        String str = (String) data.get("z_ti");
        NotificationConfig[] notificationConfigArr2 = NotificationConfig.f20458a;
        String str2 = (String) data.get("z_b");
        NotificationConfig[] notificationConfigArr3 = NotificationConfig.f20458a;
        Object objFromHtml = (String) data.get("cds_title");
        NotificationConfig[] notificationConfigArr4 = NotificationConfig.f20458a;
        Object objFromHtml2 = (String) data.get("cds_body");
        if (str != null && str.length() != 0) {
            objFromHtml = Html.fromHtml(str, 0);
        }
        if (str2 != null && str2.length() != 0) {
            objFromHtml2 = Html.fromHtml(str2, 0);
        }
        return new Pair(objFromHtml, objFromHtml2);
    }

    public static final void b(NotificationCompat.Builder builder, Context context, NotificationMetadata metadata) throws Throwable {
        Long l2;
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        if (!metadata.f20486b || (l2 = metadata.f20487c) == null) {
            builder.i(16, true);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bundle bundle = new Bundle();
        NotificationConfig[] notificationConfigArr = NotificationConfig.f20458a;
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
        int i2 = metadata.f20485a;
        map.put("notification_id", Integer.valueOf(i2));
        map.put("time_of_creation", Long.valueOf(jCurrentTimeMillis));
        Data dataA = builder2.a();
        Intrinsics.checkNotNullExpressionValue(dataA, "build(...)");
        Intrinsics.checkNotNullParameter(NotificationRemovalWorker.class, "workerClass");
        WorkManagerImpl.f(context).b((OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(NotificationRemovalWorker.class).f(jCurrentTimeMillis2, TimeUnit.MILLISECONDS)).g(dataA)).a("notification_removal")).a("notification_" + i2)).b());
    }
}
