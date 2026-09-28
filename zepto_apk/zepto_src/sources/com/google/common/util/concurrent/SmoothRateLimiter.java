package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.concurrent.TimeUnit;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes4.dex */
abstract class SmoothRateLimiter extends RateLimiter {

    public static final class SmoothBursty extends SmoothRateLimiter {
    }

    public static final class SmoothWarmingUp extends SmoothRateLimiter {
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    public final double a() {
        return TimeUnit.SECONDS.toMicros(1L) / 0.0d;
    }
}
