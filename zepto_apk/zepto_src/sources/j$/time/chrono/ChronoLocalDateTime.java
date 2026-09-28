package j$.time.chrono;

import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDate;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import java.util.Objects;

/* loaded from: classes2.dex */
public interface ChronoLocalDateTime<D extends ChronoLocalDate> extends Temporal, j$.time.temporal.l, Comparable<ChronoLocalDateTime<?>> {
    InterfaceC0116h H(ZoneId zoneId);

    @Override // j$.time.temporal.Temporal
    ChronoLocalDateTime a(long j2, j$.time.temporal.n nVar);

    @Override // j$.time.temporal.Temporal
    ChronoLocalDateTime c(long j2, TemporalUnit temporalUnit);

    LocalTime o();

    ChronoLocalDate p();

    @Override // java.lang.Comparable
    /* bridge */ /* synthetic */ default int compareTo(ChronoLocalDateTime<?> chronoLocalDateTime) {
        return compareTo((ChronoLocalDateTime) chronoLocalDateTime);
    }

    default k i() {
        return p().i();
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: b */
    default ChronoLocalDateTime m(LocalDate localDate) {
        return C0113e.s(i(), localDate.f(this));
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    default ChronoLocalDateTime d(long j2, ChronoUnit chronoUnit) {
        return C0113e.s(i(), super.d(j2, chronoUnit));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.o.f53428a || temporalQuery == j$.time.temporal.o.f53432e || temporalQuery == j$.time.temporal.o.f53431d) {
            return null;
        }
        if (temporalQuery == j$.time.temporal.o.f53434g) {
            return o();
        }
        if (temporalQuery == j$.time.temporal.o.f53429b) {
            return i();
        }
        if (temporalQuery == j$.time.temporal.o.f53430c) {
            return ChronoUnit.NANOS;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // j$.time.temporal.l
    default Temporal f(Temporal temporal) {
        return temporal.a(p().toEpochDay(), j$.time.temporal.a.EPOCH_DAY).a(o().g0(), j$.time.temporal.a.NANO_OF_DAY);
    }

    default long b0(ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        return ((p().toEpochDay() * 86400) + o().toSecondOfDay()) - zoneOffset.getTotalSeconds();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    default int compareTo(ChronoLocalDateTime chronoLocalDateTime) {
        int iCompareTo = p().compareTo(chronoLocalDateTime.p());
        return (iCompareTo == 0 && (iCompareTo = o().compareTo(chronoLocalDateTime.o())) == 0) ? ((AbstractC0109a) i()).getId().compareTo(chronoLocalDateTime.i().getId()) : iCompareTo;
    }
}
