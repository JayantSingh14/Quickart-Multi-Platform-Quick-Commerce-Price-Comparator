package io.sentry.util;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class Platform {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f53129a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f53130b;

    static {
        try {
            f53129a = "The Android Project".equals(System.getProperty("java.vendor"));
        } catch (Throwable unused) {
            f53129a = false;
        }
        try {
            String property = System.getProperty("java.specification.version");
            if (property != null) {
                f53130b = Double.valueOf(property).doubleValue() >= 9.0d;
            } else {
                f53130b = false;
            }
        } catch (Throwable unused2) {
            f53130b = false;
        }
    }
}
