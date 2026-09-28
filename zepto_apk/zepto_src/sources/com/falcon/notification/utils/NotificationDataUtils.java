package com.falcon.notification.utils;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes3.dex */
public final class NotificationDataUtils {
    public static boolean a(Map data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter("z_ong", "key");
        Object obj = data.get("z_ong");
        if (obj instanceof String) {
            return Boolean.parseBoolean((String) obj);
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static Integer b(HashMap data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter("z_r_t", "key");
        Object obj = data.get("z_r_t");
        if (obj instanceof String) {
            return StringsKt.toIntOrNull((String) obj);
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        return null;
    }

    public static Long c(String key, Map data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(key, "key");
        Object obj = data.get(key);
        if (obj instanceof String) {
            return StringsKt.a0((String) obj);
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        return null;
    }
}
