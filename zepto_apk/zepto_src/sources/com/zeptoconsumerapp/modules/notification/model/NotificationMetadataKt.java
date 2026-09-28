package com.zeptoconsumerapp.modules.notification.model;

import com.zeptoconsumerapp.modules.notification.constants.NotificationConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class NotificationMetadataKt {
    public static final NotificationMetadata a(Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        NotificationConfig[] notificationConfigArr = NotificationConfig.f47662a;
        String str = (String) map.get("z_n_id");
        String str2 = (String) map.get("z_ong");
        boolean z = str2 != null ? Boolean.parseBoolean(str2) : false;
        String str3 = (String) map.get("z_ong_et");
        return new NotificationMetadata(z ? -426453834 : (str == null || str.length() == 0) ? (int) System.currentTimeMillis() : str.hashCode(), z, str3 != null ? Long.valueOf(Long.parseLong(str3)) : null);
    }
}
