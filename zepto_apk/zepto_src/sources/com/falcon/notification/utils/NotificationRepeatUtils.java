package com.falcon.notification.utils;

import android.content.Context;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.impl.WorkManagerImpl;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.falcon.notification.constants.NotificationConfig;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class NotificationRepeatUtils {
    public static void a(Context context, HashMap originalData) throws Throwable {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(originalData, "originalData");
        try {
            LinkedHashMap linkedHashMapN = MapsKt.n(originalData);
            NotificationConfig[] notificationConfigArr = NotificationConfig.f20458a;
            Long lC = NotificationDataUtils.c("z_r_d", linkedHashMapN);
            Integer numB = NotificationDataUtils.b(linkedHashMapN);
            if (lC != null && numB != null && NotificationDataUtils.a(linkedHashMapN)) {
                Long lC2 = NotificationDataUtils.c("z_ong_et", linkedHashMapN);
                if (lC2 == null || System.currentTimeMillis() < lC2.longValue()) {
                    int i2 = Integer.parseInt("2");
                    long j2 = Long.parseLong("7200000");
                    if (numB.intValue() <= i2 && lC.longValue() >= j2 && numB.intValue() > 0) {
                        String strJ = new Gson().j(linkedHashMapN);
                        Data.Builder builder = new Data.Builder();
                        HashMap map = builder.f12511a;
                        builder.c("notification_data", strJ);
                        map.put("repeat_delay", lC);
                        map.put("repeat_times", numB);
                        Data dataA = builder.a();
                        Intrinsics.checkNotNullExpressionValue(dataA, "build(...)");
                        Object obj = linkedHashMapN.get("communication_id");
                        if (obj == null || (string = obj.toString()) == null) {
                            string = zzck.UNKNOWN_CONTENT_TYPE;
                        }
                        String str = "notification_repeat_" + string + Attributes.PREDEFINED_ATTRIBUTE_PREFIX + System.currentTimeMillis();
                        Intrinsics.checkNotNullParameter(NotificationRepeatWorker.class, "workerClass");
                        WorkManagerImpl.f(context).b((OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(NotificationRepeatWorker.class).f(lC.longValue(), TimeUnit.MILLISECONDS)).g(dataA)).a("notification_repeat")).a(str)).b());
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
