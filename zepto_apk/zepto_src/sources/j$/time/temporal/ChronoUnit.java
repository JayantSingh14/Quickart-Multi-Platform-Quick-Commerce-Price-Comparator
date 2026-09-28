package j$.time.temporal;

import j$.time.Duration;

/* loaded from: classes2.dex */
public enum ChronoUnit implements TemporalUnit {
    NANOS("Nanos", Duration.J(1)),
    MICROS("Micros", Duration.J(1000)),
    MILLIS("Millis", Duration.J(1000000)),
    SECONDS("Seconds", Duration.ofSeconds(1)),
    MINUTES("Minutes", Duration.ofSeconds(60)),
    HOURS("Hours", Duration.ofSeconds(3600)),
    HALF_DAYS("HalfDays", Duration.ofSeconds(43200)),
    DAYS("Days", Duration.ofSeconds(86400)),
    WEEKS("Weeks", Duration.ofSeconds(604800)),
    MONTHS("Months", Duration.ofSeconds(2629746)),
    YEARS("Years", Duration.ofSeconds(31556952)),
    DECADES("Decades", Duration.ofSeconds(315569520)),
    CENTURIES("Centuries", Duration.ofSeconds(3155695200L)),
    MILLENNIA("Millennia", Duration.ofSeconds(31556952000L)),
    ERAS("Eras", Duration.ofSeconds(31556952000000000L)),
    FOREVER("Forever", Duration.K(Long.MAX_VALUE, 999999999));


    /* renamed from: a, reason: collision with root package name */
    public final String f53406a;

    /* renamed from: b, reason: collision with root package name */
    public final Duration f53407b;

    ChronoUnit(String str, Duration duration) {
        this.f53406a = str;
        this.f53407b = duration;
    }

    @Override // j$.time.temporal.TemporalUnit
    public final Duration J() {
        return this.f53407b;
    }

    @Override // j$.time.temporal.TemporalUnit
    public final boolean A() {
        return compareTo(DAYS) >= 0;
    }

    @Override // j$.time.temporal.TemporalUnit
    public final Temporal q(Temporal temporal, long j2) {
        return temporal.c(j2, this);
    }

    @Override // j$.time.temporal.TemporalUnit
    public final long s(Temporal temporal, Temporal temporal2) {
        return temporal.n(temporal2, this);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f53406a;
    }
}
