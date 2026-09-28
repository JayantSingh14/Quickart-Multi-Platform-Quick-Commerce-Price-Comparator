package com.facebook.common.time;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe
/* loaded from: classes.dex */
public interface MonotonicClock {

    /* loaded from: classes3.dex */
    public static final class MonotonicClockWrapper implements MonotonicClock {
        @Override // com.facebook.common.time.MonotonicClock
        public final long now() {
            throw null;
        }

        @Override // com.facebook.common.time.MonotonicClock
        public final long nowNanos() {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            throw null;
        }
    }

    @DoNotStrip
    default long now() {
        return TimeUnit.NANOSECONDS.toMillis(nowNanos());
    }

    @DoNotStrip
    long nowNanos();
}
