package j$.time.temporal;

import j$.time.Duration;

/* loaded from: classes2.dex */
public enum h implements TemporalUnit {
    WEEK_BASED_YEARS("WeekBasedYears", Duration.ofSeconds(31556952)),
    QUARTER_YEARS("QuarterYears", Duration.ofSeconds(7889238));


    /* renamed from: a, reason: collision with root package name */
    public final String f53415a;

    /* renamed from: b, reason: collision with root package name */
    public final Duration f53416b;

    @Override // j$.time.temporal.TemporalUnit
    public final boolean A() {
        return true;
    }

    h(String str, Duration duration) {
        this.f53415a = str;
        this.f53416b = duration;
    }

    @Override // j$.time.temporal.TemporalUnit
    public final Duration J() {
        return this.f53416b;
    }

    @Override // j$.time.temporal.TemporalUnit
    public final Temporal q(Temporal temporal, long j2) {
        int i2 = b.f53411a[ordinal()];
        if (i2 == 1) {
            return temporal.a(Math.addExact(temporal.j(r0), j2), i.f53419c);
        }
        if (i2 == 2) {
            return temporal.c(j2 / 4, ChronoUnit.YEARS).c((j2 % 4) * 3, ChronoUnit.MONTHS);
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // j$.time.temporal.TemporalUnit
    public final long s(Temporal temporal, Temporal temporal2) {
        if (temporal.getClass() != temporal2.getClass()) {
            return temporal.n(temporal2, this);
        }
        int i2 = b.f53411a[ordinal()];
        if (i2 == 1) {
            g gVar = i.f53419c;
            return Math.subtractExact(temporal2.h(gVar), temporal.h(gVar));
        }
        if (i2 == 2) {
            return temporal.n(temporal2, ChronoUnit.MONTHS) / 3;
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f53415a;
    }
}
