package io.sentry.android.core.internal.util;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public class Debouncer {

    /* renamed from: a, reason: collision with root package name */
    public final long f52311a;

    /* renamed from: b, reason: collision with root package name */
    public final AndroidCurrentDateProvider f52312b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicInteger f52313c;

    /* renamed from: d, reason: collision with root package name */
    public final int f52314d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicLong f52315e;

    public Debouncer(long j2, int i2) {
        AndroidCurrentDateProvider androidCurrentDateProvider = AndroidCurrentDateProvider.f52306a;
        this.f52313c = new AtomicInteger(0);
        this.f52315e = new AtomicLong(0L);
        this.f52312b = androidCurrentDateProvider;
        this.f52311a = j2;
        this.f52314d = i2 <= 0 ? 1 : i2;
    }

    public final boolean a() {
        this.f52312b.getClass();
        long jUptimeMillis = SystemClock.uptimeMillis();
        AtomicLong atomicLong = this.f52315e;
        long j2 = atomicLong.get();
        AtomicInteger atomicInteger = this.f52313c;
        if (j2 == 0 || atomicLong.get() + this.f52311a <= jUptimeMillis) {
            atomicInteger.set(0);
            atomicLong.set(jUptimeMillis);
            return false;
        }
        if (atomicInteger.incrementAndGet() < this.f52314d) {
            return false;
        }
        atomicInteger.set(0);
        return true;
    }
}
