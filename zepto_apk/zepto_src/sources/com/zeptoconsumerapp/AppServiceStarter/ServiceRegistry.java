package com.zeptoconsumerapp.AppServiceStarter;

import android.content.Intent;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.zeptoconsumerapp.services.GenericCleanupService;
import com.zeptoconsumerapp.services.OrderCleanupService;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class ServiceRegistry {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f47322a = MapsKt.h(new Pair(ServiceType.f47323a, OrderCleanupService.class), new Pair(ServiceType.f47324b, GenericCleanupService.class));

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.Map] */
    public static void a(ReactApplicationContext context, ServiceType type, ReadableMap readableMap) {
        HashMap<String, Object> hashMap;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        Class cls = (Class) f47322a.get(type);
        if (cls != null) {
            Intent intent = new Intent(context, (Class<?>) cls);
            if (readableMap != null && (hashMap = readableMap.toHashMap()) != null) {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        intent.putExtra(key, (String) value);
                    } else if (value instanceof Integer) {
                        intent.putExtra(key, ((Number) value).intValue());
                    } else if (value instanceof Double) {
                        intent.putExtra(key, ((Number) value).doubleValue());
                    } else if (value instanceof Boolean) {
                        intent.putExtra(key, ((Boolean) value).booleanValue());
                    }
                }
            }
            context.startService(intent);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.Map] */
    public static void b(ReactApplicationContext context, ServiceType type) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        Class cls = (Class) f47322a.get(type);
        if (cls != null) {
            context.stopService(new Intent(context, (Class<?>) cls));
        }
    }
}
