package com.facebook.common.time;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.TimeUnit;

@DoNotStrip
@Nullsafe
/* loaded from: classes.dex */
public class RealtimeSinceBootClock implements MonotonicClock {

    /* renamed from: a, reason: collision with root package name */
    public static final RealtimeSinceBootClock f17137a = new RealtimeSinceBootClock();

    private RealtimeSinceBootClock() {
    }

    @DoNotStrip
    public static RealtimeSinceBootClock get() {
        return f17137a;
    }

    @Override // com.facebook.common.time.MonotonicClock
    public final long now() {
        return android.os.SystemClock.elapsedRealtime();
    }

    @Override // com.facebook.common.time.MonotonicClock
    public final long nowNanos() {
        return TimeUnit.MILLISECONDS.toNanos(android.os.SystemClock.elapsedRealtime());
    }
}
