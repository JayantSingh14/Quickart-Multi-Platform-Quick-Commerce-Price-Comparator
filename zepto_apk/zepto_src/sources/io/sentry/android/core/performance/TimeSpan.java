package io.sentry.android.core.performance;

import android.os.SystemClock;
import io.sentry.SentryLongDate;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public class TimeSpan implements Comparable<TimeSpan> {

    /* renamed from: a, reason: collision with root package name */
    public String f52380a;

    /* renamed from: b, reason: collision with root package name */
    public long f52381b;

    /* renamed from: c, reason: collision with root package name */
    public long f52382c;

    /* renamed from: d, reason: collision with root package name */
    public long f52383d;

    public final long a() {
        if (d()) {
            return this.f52383d - this.f52382c;
        }
        return 0L;
    }

    public final SentryLongDate b() {
        if (c()) {
            return new SentryLongDate(this.f52381b * 1000000);
        }
        return null;
    }

    public final boolean c() {
        return this.f52382c != 0;
    }

    @Override // java.lang.Comparable
    public final int compareTo(TimeSpan timeSpan) {
        return Long.compare(this.f52381b, timeSpan.f52381b);
    }

    public final boolean d() {
        return this.f52383d != 0;
    }

    public final void e(long j2) {
        this.f52382c = j2;
        long jUptimeMillis = SystemClock.uptimeMillis() - this.f52382c;
        this.f52381b = System.currentTimeMillis() - jUptimeMillis;
        System.nanoTime();
        TimeUnit.MILLISECONDS.toNanos(jUptimeMillis);
    }

    public final void g() {
        this.f52383d = SystemClock.uptimeMillis();
    }
}
