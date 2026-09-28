package j$.time;

import j$.time.format.D;
import j$.time.format.DateTimeFormatterBuilder;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import org.xbill.DNS.Flags;

/* loaded from: classes2.dex */
public final class s implements Temporal, j$.time.temporal.l, Comparable, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f53401b = 0;
    private static final long serialVersionUID = -23038383694477807L;

    /* renamed from: a, reason: collision with root package name */
    public final int f53402a;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f53402a - ((s) obj).f53402a;
    }

    static {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.l(j$.time.temporal.a.YEAR, 4, 10, D.EXCEEDS_PAD);
        dateTimeFormatterBuilder.toFormatter();
    }

    public static s s(int i2) {
        j$.time.temporal.a.YEAR.c0(i2);
        return new s(i2);
    }

    @Override // j$.time.temporal.Temporal
    public final long n(Temporal temporal, TemporalUnit temporalUnit) {
        s sVarS;
        if (temporal instanceof s) {
            sVarS = (s) temporal;
        } else {
            Objects.requireNonNull(temporal, "temporal");
            try {
                if (!j$.time.chrono.r.f53253c.equals(j$.time.chrono.k.E(temporal))) {
                    temporal = LocalDate.J(temporal);
                }
                sVarS = s(temporal.j(j$.time.temporal.a.YEAR));
            } catch (DateTimeException e2) {
                throw new DateTimeException("Unable to obtain Year from TemporalAccessor: " + temporal + " of type " + temporal.getClass().getName(), e2);
            }
        }
        if (temporalUnit instanceof ChronoUnit) {
            long j2 = sVarS.f53402a - this.f53402a;
            int i2 = r.f53400b[((ChronoUnit) temporalUnit).ordinal()];
            if (i2 == 1) {
                return j2;
            }
            if (i2 == 2) {
                return j2 / 10;
            }
            if (i2 == 3) {
                return j2 / 100;
            }
            if (i2 == 4) {
                return j2 / 1000;
            }
            if (i2 == 5) {
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return sVarS.h(aVar) - h(aVar);
            }
            throw new j$.time.temporal.p("Unsupported unit: " + temporalUnit);
        }
        return temporalUnit.s(this, sVarS);
    }

    public s(int i2) {
        this.f53402a = i2;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean g(j$.time.temporal.n nVar) {
        return nVar instanceof j$.time.temporal.a ? nVar == j$.time.temporal.a.YEAR || nVar == j$.time.temporal.a.YEAR_OF_ERA || nVar == j$.time.temporal.a.ERA : nVar != null && nVar.Z(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.q l(j$.time.temporal.n nVar) {
        if (nVar == j$.time.temporal.a.YEAR_OF_ERA) {
            return j$.time.temporal.q.f(1L, this.f53402a <= 0 ? 1000000000L : 999999999L);
        }
        return super.l(nVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int j(j$.time.temporal.n nVar) {
        return l(nVar).a(h(nVar), nVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long h(j$.time.temporal.n nVar) {
        if (!(nVar instanceof j$.time.temporal.a)) {
            return nVar.s(this);
        }
        int i2 = r.f53399a[((j$.time.temporal.a) nVar).ordinal()];
        int i3 = this.f53402a;
        if (i2 == 1) {
            if (i3 < 1) {
                i3 = 1 - i3;
            }
            return i3;
        }
        if (i2 == 2) {
            return i3;
        }
        if (i2 == 3) {
            return i3 < 1 ? 0 : 1;
        }
        throw new j$.time.temporal.p(b.a("Unsupported field: ", nVar));
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: b */
    public final Temporal m(LocalDate localDate) {
        return (s) localDate.f(this);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public final s a(long j2, j$.time.temporal.n nVar) {
        if (!(nVar instanceof j$.time.temporal.a)) {
            return (s) nVar.q(this, j2);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) nVar;
        aVar.c0(j2);
        int i2 = r.f53399a[aVar.ordinal()];
        int i3 = this.f53402a;
        if (i2 == 1) {
            if (i3 < 1) {
                j2 = 1 - j2;
            }
            return s((int) j2);
        }
        if (i2 == 2) {
            return s((int) j2);
        }
        if (i2 == 3) {
            return h(j$.time.temporal.a.ERA) == j2 ? this : s(1 - i3);
        }
        throw new j$.time.temporal.p(b.a("Unsupported field: ", nVar));
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final s c(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (s) temporalUnit.q(this, j2);
        }
        int i2 = r.f53400b[((ChronoUnit) temporalUnit).ordinal()];
        if (i2 == 1) {
            return J(j2);
        }
        if (i2 == 2) {
            return J(Math.multiplyExact(j2, 10));
        }
        if (i2 == 3) {
            return J(Math.multiplyExact(j2, 100));
        }
        if (i2 == 4) {
            return J(Math.multiplyExact(j2, 1000));
        }
        if (i2 == 5) {
            j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
            return a(Math.addExact(h(aVar), j2), aVar);
        }
        throw new j$.time.temporal.p("Unsupported unit: " + temporalUnit);
    }

    public final s J(long j2) {
        if (j2 == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return s(aVar.f53410b.a(this.f53402a + j2, aVar));
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal d(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? c(Long.MAX_VALUE, temporalUnit).c(1L, temporalUnit) : c(-j2, temporalUnit);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.o.f53429b) {
            return j$.time.chrono.r.f53253c;
        }
        if (temporalQuery == j$.time.temporal.o.f53430c) {
            return ChronoUnit.YEARS;
        }
        return super.e(temporalQuery);
    }

    @Override // j$.time.temporal.l
    public final Temporal f(Temporal temporal) {
        if (!j$.time.chrono.k.E(temporal).equals(j$.time.chrono.r.f53253c)) {
            throw new DateTimeException("Adjustment only supported on ISO date-time");
        }
        return temporal.a(this.f53402a, j$.time.temporal.a.YEAR);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s) {
            if (this.f53402a == ((s) obj).f53402a) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f53402a;
    }

    public final String toString() {
        return Integer.toString(this.f53402a);
    }

    private Object writeReplace() {
        return new q(Flags.CD, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
