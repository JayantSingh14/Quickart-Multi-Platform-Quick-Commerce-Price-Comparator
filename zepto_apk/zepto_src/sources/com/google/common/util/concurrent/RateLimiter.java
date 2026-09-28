package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.util.Locale;

@Beta
@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
/* loaded from: classes4.dex */
public abstract class RateLimiter {

    public static abstract class SleepingStopwatch {

        /* renamed from: com.google.common.util.concurrent.RateLimiter$SleepingStopwatch$1, reason: invalid class name */
        class AnonymousClass1 extends SleepingStopwatch {
        }
    }

    public abstract double a();

    public final String toString() {
        Locale locale = Locale.ROOT;
        throw null;
    }
}
