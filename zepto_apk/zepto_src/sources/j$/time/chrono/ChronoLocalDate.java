package j$.time.chrono;

import j$.time.LocalTime;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;

/* loaded from: classes2.dex */
public interface ChronoLocalDate extends Temporal, j$.time.temporal.l, Comparable<ChronoLocalDate> {
    boolean equals(Object obj);

    int hashCode();

    k i();

    @Override // j$.time.temporal.Temporal
    long n(Temporal temporal, TemporalUnit temporalUnit);

    String toString();

    default ChronoLocalDateTime M(LocalTime localTime) {
        return new C0113e(this, localTime);
    }

    default l u() {
        return i().S(j(j$.time.temporal.a.ERA));
    }

    default boolean R() {
        return i().C(h(j$.time.temporal.a.YEAR));
    }

    default int L() {
        return R() ? 366 : 365;
    }

    @Override // j$.time.temporal.TemporalAccessor
    default boolean g(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) nVar).X();
        }
        return nVar != null && nVar.Z(this);
    }

    @Override // j$.time.temporal.Temporal
    default ChronoLocalDate m(j$.time.temporal.l lVar) {
        return AbstractC0111c.s(i(), lVar.f(this));
    }

    @Override // j$.time.temporal.Temporal
    default ChronoLocalDate a(long j2, j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.p(j$.time.b.a("Unsupported field: ", nVar));
        }
        return AbstractC0111c.s(i(), nVar.q(this, j2));
    }

    default ChronoLocalDate Q(TemporalAmount temporalAmount) {
        return AbstractC0111c.s(i(), temporalAmount.q(this));
    }

    @Override // j$.time.temporal.Temporal
    default ChronoLocalDate c(long j2, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            throw new j$.time.temporal.p("Unsupported unit: " + temporalUnit);
        }
        return AbstractC0111c.s(i(), temporalUnit.q(this, j2));
    }

    @Override // j$.time.temporal.Temporal
    default ChronoLocalDate d(long j2, TemporalUnit temporalUnit) {
        return AbstractC0111c.s(i(), super.d(j2, temporalUnit));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.o.f53428a || temporalQuery == j$.time.temporal.o.f53432e || temporalQuery == j$.time.temporal.o.f53431d || temporalQuery == j$.time.temporal.o.f53434g) {
            return null;
        }
        if (temporalQuery == j$.time.temporal.o.f53429b) {
            return i();
        }
        if (temporalQuery == j$.time.temporal.o.f53430c) {
            return ChronoUnit.DAYS;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // j$.time.temporal.l
    default Temporal f(Temporal temporal) {
        return temporal.a(toEpochDay(), j$.time.temporal.a.EPOCH_DAY);
    }

    default long toEpochDay() {
        return h(j$.time.temporal.a.EPOCH_DAY);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Comparable
    default int compareTo(ChronoLocalDate chronoLocalDate) {
        int iCompare = Long.compare(toEpochDay(), chronoLocalDate.toEpochDay());
        if (iCompare != 0) {
            return iCompare;
        }
        return ((AbstractC0109a) i()).getId().compareTo(chronoLocalDate.i().getId());
    }
}
