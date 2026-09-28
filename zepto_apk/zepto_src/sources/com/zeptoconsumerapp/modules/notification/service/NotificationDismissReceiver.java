package com.zeptoconsumerapp.modules.notification.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.zeptoconsumerapp.modules.base.ContextProvider;
import com.zeptoconsumerapp.modules.notification.constants.NotificationConfig;
import com.zeptoconsumerapp.modules.notification.utils.NotificationDataUtils;
import com.zeptoconsumerapp.modules.notification.utils.NotificationRepeatUtils;
import com.zeptoconsumerapp.modules.utils.JsonUtils;
import io.sentry.Sentry;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class NotificationDismissReceiver extends BroadcastReceiver {

    @Metadata
    public static final class Companion {
    }

    public static void a(Context context, HashMap map) {
        try {
            NotificationConfig[] notificationConfigArr = NotificationConfig.f47662a;
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
    public final void onReceive(Context context, Intent intent) {
        if (context == null || intent == null || !Intrinsics.b(intent.getAction(), "com.zeptoconsumerapp.NOTIFICATION_DISMISSED")) {
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("notification_data");
            if (stringExtra != null && stringExtra.length() != 0) {
                HashMap data = JsonUtils.a(stringExtra);
                try {
                    ContextProvider.f47615b.a().b(context);
                    new NotificationService();
                    Intrinsics.checkNotNullParameter(data, "data");
                    try {
                        NotificationService.b("STATUS_DISMISSED", data);
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
