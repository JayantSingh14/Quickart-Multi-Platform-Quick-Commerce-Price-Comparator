package j$.time.temporal;

import j$.time.LocalDate;

/* loaded from: classes2.dex */
public interface Temporal extends TemporalAccessor {
    Temporal a(long j2, n nVar);

    Temporal c(long j2, TemporalUnit temporalUnit);

    long n(Temporal temporal, TemporalUnit temporalUnit);

    /* renamed from: b */
    default Temporal m(LocalDate localDate) {
        return localDate.f(this);
    }

    default Temporal d(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? c(Long.MAX_VALUE, temporalUnit).c(1L, temporalUnit) : c(-j2, temporalUnit);
    }
}
