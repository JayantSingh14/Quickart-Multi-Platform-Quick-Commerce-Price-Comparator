package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* loaded from: classes4.dex */
public final class zzfg {

    /* renamed from: a, reason: collision with root package name */
    public long f31047a;

    /* renamed from: b, reason: collision with root package name */
    public long f31048b;

    /* renamed from: c, reason: collision with root package name */
    public long f31049c;

    /* renamed from: d, reason: collision with root package name */
    public final ThreadLocal f31050d = new ThreadLocal();

    public zzfg() {
        b(0L);
    }

    public final synchronized long a() {
        long j2 = this.f31047a;
        if (j2 == Long.MAX_VALUE || j2 == 9223372036854775806L) {
            return -9223372036854775807L;
        }
        return j2;
    }

    public final synchronized void b(long j2) {
        this.f31047a = j2;
        this.f31048b = j2 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f31049c = -9223372036854775807L;
    }

    public final synchronized long c(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j3 = this.f31049c;
            if (j3 != -9223372036854775807L) {
                long jU = zzfj.u(j3, 90000L, 1000000L, RoundingMode.DOWN);
                long j4 = (4294967296L + jU) / 8589934592L;
                long j5 = (((-1) + j4) * 8589934592L) + j2;
                long j6 = (j4 * 8589934592L) + j2;
                j2 = Math.abs(j5 - jU) < Math.abs(j6 - jU) ? j5 : j6;
            }
            return e(zzfj.u(j2, 1000000L, 90000L, RoundingMode.DOWN));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long d(long j2) {
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j3 = this.f31049c;
            if (j3 != -9223372036854775807L) {
                long jU = zzfj.u(j3, 90000L, 1000000L, RoundingMode.DOWN);
                long j4 = jU / 8589934592L;
                long j5 = (j4 * 8589934592L) + j2;
                j2 = j5 >= jU ? j5 : ((j4 + 1) * 8589934592L) + j2;
            }
            return e(zzfj.u(j2, 1000000L, 90000L, RoundingMode.DOWN));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long e(long j2) {
        long j3;
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            synchronized (this) {
                if (!(this.f31048b != -9223372036854775807L)) {
                    long jLongValue = this.f31047a;
                    if (jLongValue == 9223372036854775806L) {
                        Long l2 = (Long) this.f31050d.get();
                        if (l2 == null) {
                            throw null;
                        }
                        jLongValue = l2.longValue();
                    }
                    this.f31048b = jLongValue - j2;
                    notifyAll();
                }
                this.f31049c = j2;
                j3 = j2 + this.f31048b;
            }
            return j3;
        } catch (Throwable th) {
            throw th;
        }
    }
}
