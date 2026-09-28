package com.falcon.notification.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.falcon.FalconContextContainer;
import com.falcon.notification.constants.NotificationConfig;
import com.falcon.notification.utils.JsonUtils;
import com.falcon.notification.utils.NotificationDataUtils;
import com.falcon.notification.utils.NotificationRepeatUtils;
import io.sentry.Sentry;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class NotificationDismissReceiver extends BroadcastReceiver {

    @Metadata
    public static final class Companion {
    }

    public static void a(Context context, HashMap map) throws Throwable {
        try {
            NotificationConfig[] notificationConfigArr = NotificationConfig.f20458a;
            boolean zContainsKey = map.containsKey("z_r_d");
            boolean zContainsKey2 = map.containsKey("z_r_t");
            if (zContainsKey && zContainsKey2) {
                Integer numB = NotificationDataUtils.b(map);
                Long lC = NotificationDataUtils.c("z_r_d", map);
                if (numB != null && lC != null && NotificationDataUtils.a(map)) {
                    Long lC2 = NotificationDataUtils.c("z_ong_et", map);
                    if ((lC2 == null || System.currentTimeMillis() < lC2.longValue()) && numB.intValue() > 0) {
                        if (map.containsKey("_isRepeated")) {
                            Intrinsics.b(map.get("_isRepeated"), "true");
                        }
                        NotificationRepeatUtils.a(context, map);
                    }
                }
            }
        } catch (Exception e2) {
            Sentry.a(e2);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) throws Throwable {
        if (context == null || intent == null || !Intrinsics.b(intent.getAction(), "com.zeptoconsumerapp.NOTIFICATION_DISMISSED")) {
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("notification_data");
            if (stringExtra != null && stringExtra.length() != 0) {
                HashMap data = JsonUtils.a(stringExtra);
                try {
                    Intrinsics.checkNotNullParameter(context, "context");
                    FalconContextContainer.f20435a = context;
                    new NotificationService();
                    Intrinsics.checkNotNullParameter(data, "data");
                    try {
                        NotificationService.c("STATUS_DISMISSED", data);
                    } catch (Exception e2) {
                        Sentry.a(e2);
                    }
                } catch (Exception e3) {
                    Sentry.a(e3);
                }
                a(context, data);
            }
        } catch (Exception e4) {
            Sentry.a(e4);
        }
    }
}
