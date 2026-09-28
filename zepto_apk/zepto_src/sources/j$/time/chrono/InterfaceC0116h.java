package j$.time.chrono;

import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalQuery;

/* renamed from: j$.time.chrono.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC0116h extends Temporal, Comparable {
    ZoneOffset D();

    InterfaceC0116h G(ZoneId zoneId);

    InterfaceC0116h I(ZoneId zoneId);

    ZoneId V();

    ChronoLocalDateTime z();

    @Override // j$.time.temporal.TemporalAccessor
    default j$.time.temporal.q l(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            if (nVar != j$.time.temporal.a.INSTANT_SECONDS && nVar != j$.time.temporal.a.OFFSET_SECONDS) {
                return z().l(nVar);
            }
            return ((j$.time.temporal.a) nVar).f53410b;
        }
        return nVar.K(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default int j(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            int i2 = AbstractC0115g.f53231a[((j$.time.temporal.a) nVar).ordinal()];
            if (i2 == 1) {
                throw new j$.time.temporal.p("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i2 == 2) {
                return D().getTotalSeconds();
            }
            return z().j(nVar);
        }
        return super.j(nVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default long h(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            int i2 = AbstractC0115g.f53231a[((j$.time.temporal.a) nVar).ordinal()];
            if (i2 == 1) {
                return T();
            }
            if (i2 == 2) {
                return D().getTotalSeconds();
            }
            return z().h(nVar);
        }
        return nVar.s(this);
    }

    default ChronoLocalDate p() {
        return z().p();
    }

    default LocalTime o() {
        return z().o();
    }

    default k i() {
        return p().i();
    }

    @Override // j$.time.temporal.Temporal
    default InterfaceC0116h m(j$.time.temporal.l lVar) {
        return j.s(i(), lVar.f(this));
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    default InterfaceC0116h d(long j2, ChronoUnit chronoUnit) {
        return j.s(i(), super.d(j2, chronoUnit));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.o.f53432e || temporalQuery == j$.time.temporal.o.f53428a) {
            return V();
        }
        if (temporalQuery == j$.time.temporal.o.f53431d) {
            return D();
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

    default long T() {
        return ((p().toEpochDay() * 86400) + o().toSecondOfDay()) - D().getTotalSeconds();
    }

    @Override // java.lang.Comparable
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    default int compareTo(InterfaceC0116h interfaceC0116h) {
        int iCompare = Long.compare(T(), interfaceC0116h.T());
        return (iCompare == 0 && (iCompare = o().getNano() - interfaceC0116h.o().getNano()) == 0 && (iCompare = z().compareTo(interfaceC0116h.z())) == 0 && (iCompare = V().getId().compareTo(interfaceC0116h.V().getId())) == 0) ? ((AbstractC0109a) i()).getId().compareTo(interfaceC0116h.i().getId()) : iCompare;
    }
}
