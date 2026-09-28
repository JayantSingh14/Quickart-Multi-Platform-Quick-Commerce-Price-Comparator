package com.amazon.apay.hardened.manager;

import com.amazon.apay.instrumentation.logger.CrashEventsLogger;
import com.amazon.apay.instrumentation.logger.KuberMetricEventsLogger;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static KuberMetricEventsLogger f15004a;

    /* renamed from: b, reason: collision with root package name */
    public static CrashEventsLogger f15005b;

    public static void a(String str, String str2) {
        if (f15004a != null) {
            f15004a.addMetricEvent(str, str2);
        }
    }
}
