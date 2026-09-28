package j$.time;

import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class o implements Temporal, j$.time.temporal.l, Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f53390c = 0;
    private static final long serialVersionUID = 7264499704384272492L;

    /* renamed from: a, reason: collision with root package name */
    public final LocalTime f53391a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset f53392b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        o oVar = (o) obj;
        boolean zEquals = this.f53392b.equals(oVar.f53392b);
        LocalTime localTime = this.f53391a;
        LocalTime localTime2 = oVar.f53391a;
        if (zEquals) {
            return localTime.compareTo(localTime2);
        }
        int iCompare = Long.compare(A(), oVar.A());
        return iCompare == 0 ? localTime.compareTo(localTime2) : iCompare;
    }

    static {
        LocalTime localTime = LocalTime.MIN;
        ZoneOffset zoneOffset = ZoneOffset.f53201g;
        localTime.getClass();
        new o(localTime, zoneOffset);
        LocalTime localTime2 = LocalTime.MAX;
        ZoneOffset zoneOffset2 = ZoneOffset.f53200f;
        localTime2.getClass();
        new o(localTime2, zoneOffset2);
    }

    @Override // j$.time.temporal.Temporal
    public final long n(Temporal temporal, TemporalUnit temporalUnit) {
        o oVar;
        if (temporal instanceof o) {
            oVar = (o) temporal;
        } else {
            try {
                oVar = new o(LocalTime.A(temporal), ZoneOffset.from(temporal));
            } catch (DateTimeException e2) {
                throw new DateTimeException("Unable to obtain OffsetTime from TemporalAccessor: " + temporal + " of type " + temporal.getClass().getName(), e2);
            }
        }
        if (temporalUnit instanceof ChronoUnit) {
            long jA = oVar.A() - A();
            switch (n.f53389a[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return jA;
                case 2:
                    return jA / 1000;
                case 3:
                    return jA / 1000000;
                case 4:
                    return jA / 1000000000;
                case 5:
                    return jA / 60000000000L;
                case 6:
                    return jA / 3600000000000L;
                case 7:
                    return jA / 43200000000000L;
                default:
                    throw new j$.time.temporal.p("Unsupported unit: " + temporalUnit);
            }
        }
        return temporalUnit.s(this, oVar);
    }

    public o(LocalTime localTime, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localTime, "time");
        this.f53391a = localTime;
        Objects.requireNonNull(zoneOffset, "offset");
        this.f53392b = zoneOffset;
    }

    public final o J(LocalTime localTime, ZoneOffset zoneOffset) {
        return (this.f53391a == localTime && this.f53392b.equals(zoneOffset)) ? this : new o(localTime, zoneOffset);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean g(j$.time.temporal.n nVar) {
        return nVar instanceof j$.time.temporal.a ? ((j$.time.temporal.a) nVar).d0() || nVar == j$.time.temporal.a.OFFSET_SECONDS : nVar != null && nVar.Z(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.q l(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            if (nVar != j$.time.temporal.a.OFFSET_SECONDS) {
                return this.f53391a.l(nVar);
            }
            return ((j$.time.temporal.a) nVar).f53410b;
        }
        return nVar.K(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long h(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            if (nVar == j$.time.temporal.a.OFFSET_SECONDS) {
                return this.f53392b.getTotalSeconds();
            }
            return this.f53391a.h(nVar);
        }
        return nVar.s(this);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: b */
    public final Temporal m(LocalDate localDate) {
        return (o) localDate.f(this);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal a(long j2, j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = j$.time.temporal.a.OFFSET_SECONDS;
            LocalTime localTime = this.f53391a;
            if (nVar == aVar) {
                j$.time.temporal.a aVar2 = (j$.time.temporal.a) nVar;
                return J(localTime, ZoneOffset.ofTotalSeconds(aVar2.f53410b.a(j2, aVar2)));
            }
            return J(localTime.a(j2, nVar), this.f53392b);
        }
        return (o) nVar.q(this, j2);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final o c(long j2, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return J(this.f53391a.c(j2, temporalUnit), this.f53392b);
        }
        return (o) temporalUnit.q(this, j2);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal d(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? c(Long.MAX_VALUE, temporalUnit).c(1L, temporalUnit) : c(-j2, temporalUnit);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.o.f53431d || temporalQuery == j$.time.temporal.o.f53432e) {
            return this.f53392b;
        }
        if (((temporalQuery == j$.time.temporal.o.f53428a) || (temporalQuery == j$.time.temporal.o.f53429b)) || temporalQuery == j$.time.temporal.o.f53433f) {
            return null;
        }
        if (temporalQuery == j$.time.temporal.o.f53434g) {
            return this.f53391a;
        }
        if (temporalQuery == j$.time.temporal.o.f53430c) {
            return ChronoUnit.NANOS;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // j$.time.temporal.l
    public final Temporal f(Temporal temporal) {
        return temporal.a(this.f53391a.g0(), j$.time.temporal.a.NANO_OF_DAY).a(this.f53392b.getTotalSeconds(), j$.time.temporal.a.OFFSET_SECONDS);
    }

    public final long A() {
        return this.f53391a.g0() - (this.f53392b.getTotalSeconds() * 1000000000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.f53391a.equals(oVar.f53391a) && this.f53392b.equals(oVar.f53392b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f53391a.hashCode() ^ this.f53392b.hashCode();
    }

    public final String toString() {
        return this.f53391a.toString() + this.f53392b.toString();
    }

    private Object writeReplace() {
        return new q((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
