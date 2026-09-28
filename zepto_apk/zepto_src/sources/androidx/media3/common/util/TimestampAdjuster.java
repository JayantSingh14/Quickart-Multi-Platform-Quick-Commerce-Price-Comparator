package androidx.media3.common.util;

@UnstableApi
/* loaded from: classes3.dex */
public final class TimestampAdjuster {

    /* renamed from: a, reason: collision with root package name */
    public long f5740a;

    /* renamed from: b, reason: collision with root package name */
    public long f5741b;

    /* renamed from: c, reason: collision with root package name */
    public long f5742c;

    /* renamed from: d, reason: collision with root package name */
    public final ThreadLocal f5743d = new ThreadLocal();

    public TimestampAdjuster(long j2) {
        f(j2);
    }

    public final synchronized long a(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            if (!e()) {
                long jLongValue = this.f5740a;
                if (jLongValue == 9223372036854775806L) {
                    Long l2 = (Long) this.f5743d.get();
                    l2.getClass();
                    jLongValue = l2.longValue();
                }
                this.f5741b = jLongValue - j2;
                notifyAll();
            }
            this.f5742c = j2;
            return j2 + this.f5741b;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long b(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j3 = this.f5742c;
            if (j3 != -9223372036854775807L) {
                long j4 = (j3 * 90000) / 1000000;
                long j5 = (4294967296L + j4) / 8589934592L;
                long j6 = ((j5 - 1) * 8589934592L) + j2;
                long j7 = (j5 * 8589934592L) + j2;
                j2 = Math.abs(j6 - j4) < Math.abs(j7 - j4) ? j6 : j7;
            }
            return a((j2 * 1000000) / 90000);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long c(long j2) {
        long j3;
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j4 = this.f5742c;
            if (j4 != -9223372036854775807L) {
                long j5 = (j4 * 90000) / 1000000;
                long j6 = j5 / 8589934592L;
                long j7 = (j6 * 8589934592L) + j2;
                j3 = ((j6 + 1) * 8589934592L) + j2;
                if (j7 >= j5) {
                    j3 = j7;
                }
            } else {
                j3 = j2;
            }
            return a((j3 * 1000000) / 90000);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long d() {
        long j2;
        j2 = this.f5740a;
        if (j2 == Long.MAX_VALUE || j2 == 9223372036854775806L) {
            j2 = -9223372036854775807L;
        }
        return j2;
    }

    public final synchronized boolean e() {
        return this.f5741b != -9223372036854775807L;
    }

    public final synchronized void f(long j2) {
        this.f5740a = j2;
        this.f5741b = j2 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f5742c = -9223372036854775807L;
    }

    public final synchronized void g(long j2, boolean z) {
        try {
            Assertions.g(this.f5740a == 9223372036854775806L);
            if (e()) {
                return;
            }
            if (z) {
                this.f5743d.set(Long.valueOf(j2));
            } else {
                while (!e()) {
                    wait();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
