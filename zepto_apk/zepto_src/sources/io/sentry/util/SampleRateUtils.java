package io.sentry.util;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SampleRateUtils {
    public static boolean a(boolean z, Double d2) {
        return d2 == null ? z : !d2.isNaN() && d2.doubleValue() >= 0.0d && d2.doubleValue() <= 1.0d;
    }
}
