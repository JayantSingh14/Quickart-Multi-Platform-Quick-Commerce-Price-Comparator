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
import org.apache.commons.codec.language.Soundex;

/* loaded from: classes2.dex */
public final class u implements Temporal, j$.time.temporal.l, Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f53456c = 0;
    private static final long serialVersionUID = 4183400860270640070L;

    /* renamed from: a, reason: collision with root package name */
    public final int f53457a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53458b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        u uVar = (u) obj;
        int i2 = this.f53457a - uVar.f53457a;
        return i2 == 0 ? this.f53458b - uVar.f53458b : i2;
    }

    static {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        dateTimeFormatterBuilder.l(j$.time.temporal.a.YEAR, 4, 10, D.EXCEEDS_PAD);
        dateTimeFormatterBuilder.d(Soundex.SILENT_MARKER);
        dateTimeFormatterBuilder.k(j$.time.temporal.a.MONTH_OF_YEAR, 2);
        dateTimeFormatterBuilder.toFormatter();
    }

    @Override // j$.time.temporal.Temporal
    public final long n(Temporal temporal, TemporalUnit temporalUnit) {
        u uVar;
        if (temporal instanceof u) {
            uVar = (u) temporal;
        } else {
            Objects.requireNonNull(temporal, "temporal");
            try {
                if (!j$.time.chrono.r.f53253c.equals(j$.time.chrono.k.E(temporal))) {
                    temporal = LocalDate.J(temporal);
                }
                j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
                int iJ = temporal.j(aVar);
                j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
                int iJ2 = temporal.j(aVar2);
                aVar.c0(iJ);
                aVar2.c0(iJ2);
                uVar = new u(iJ, iJ2);
            } catch (DateTimeException e2) {
                throw new DateTimeException("Unable to obtain YearMonth from TemporalAccessor: " + temporal + " of type " + temporal.getClass().getName(), e2);
            }
        }
        if (temporalUnit instanceof ChronoUnit) {
            long jS = uVar.s() - s();
            switch (t.f53404b[((ChronoUnit) temporalUnit).ordinal()]) {
                case 1:
                    return jS;
                case 2:
                    return jS / 12;
                case 3:
                    return jS / 120;
                case 4:
                    return jS / 1200;
                case 5:
                    return jS / 12000;
                case 6:
                    j$.time.temporal.a aVar3 = j$.time.temporal.a.ERA;
                    return uVar.h(aVar3) - h(aVar3);
                default:
                    throw new j$.time.temporal.p("Unsupported unit: " + temporalUnit);
            }
        }
        return temporalUnit.s(this, uVar);
    }

    public u(int i2, int i3) {
        this.f53457a = i2;
        this.f53458b = i3;
    }

    public final u X(int i2, int i3) {
        return (this.f53457a == i2 && this.f53458b == i3) ? this : new u(i2, i3);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean g(j$.time.temporal.n nVar) {
        return nVar instanceof j$.time.temporal.a ? nVar == j$.time.temporal.a.YEAR || nVar == j$.time.temporal.a.MONTH_OF_YEAR || nVar == j$.time.temporal.a.PROLEPTIC_MONTH || nVar == j$.time.temporal.a.YEAR_OF_ERA || nVar == j$.time.temporal.a.ERA : nVar != null && nVar.Z(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.q l(j$.time.temporal.n nVar) {
        if (nVar == j$.time.temporal.a.YEAR_OF_ERA) {
            return j$.time.temporal.q.f(1L, this.f53457a <= 0 ? 1000000000L : 999999999L);
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
        int i2 = t.f53403a[((j$.time.temporal.a) nVar).ordinal()];
        if (i2 == 1) {
            return this.f53458b;
        }
        if (i2 == 2) {
            return s();
        }
        int i3 = this.f53457a;
        if (i2 == 3) {
            if (i3 < 1) {
                i3 = 1 - i3;
            }
            return i3;
        }
        if (i2 == 4) {
            return i3;
        }
        if (i2 == 5) {
            return i3 < 1 ? 0 : 1;
        }
        throw new j$.time.temporal.p(b.a("Unsupported field: ", nVar));
    }

    public final long s() {
        return ((this.f53457a * 12) + this.f53458b) - 1;
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: b */
    public final Temporal m(LocalDate localDate) {
        return (u) localDate.f(this);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public final u a(long j2, j$.time.temporal.n nVar) {
        if (!(nVar instanceof j$.time.temporal.a)) {
            return (u) nVar.q(this, j2);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) nVar;
        aVar.c0(j2);
        int i2 = t.f53403a[aVar.ordinal()];
        int i3 = this.f53457a;
        if (i2 == 1) {
            int i4 = (int) j2;
            j$.time.temporal.a.MONTH_OF_YEAR.c0(i4);
            return X(i3, i4);
        }
        if (i2 == 2) {
            return J(j2 - s());
        }
        int i5 = this.f53458b;
        if (i2 == 3) {
            if (i3 < 1) {
                j2 = 1 - j2;
            }
            int i6 = (int) j2;
            j$.time.temporal.a.YEAR.c0(i6);
            return X(i6, i5);
        }
        if (i2 == 4) {
            int i7 = (int) j2;
            j$.time.temporal.a.YEAR.c0(i7);
            return X(i7, i5);
        }
        if (i2 != 5) {
            throw new j$.time.temporal.p(b.a("Unsupported field: ", nVar));
        }
        if (h(j$.time.temporal.a.ERA) == j2) {
            return this;
        }
        int i8 = 1 - i3;
        j$.time.temporal.a.YEAR.c0(i8);
        return X(i8, i5);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final u c(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (u) temporalUnit.q(this, j2);
        }
        switch (t.f53404b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return J(j2);
            case 2:
                return K(j2);
            case 3:
                return K(Math.multiplyExact(j2, 10));
            case 4:
                return K(Math.multiplyExact(j2, 100));
            case 5:
                return K(Math.multiplyExact(j2, 1000));
            case 6:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return a(Math.addExact(h(aVar), j2), aVar);
            default:
                throw new j$.time.temporal.p("Unsupported unit: " + temporalUnit);
        }
    }

    public final u K(long j2) {
        if (j2 == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return X(aVar.f53410b.a(this.f53457a + j2, aVar), this.f53458b);
    }

    public final u J(long j2) {
        if (j2 == 0) {
            return this;
        }
        long j3 = (this.f53457a * 12) + (this.f53458b - 1) + j2;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        long j4 = 12;
        return X(aVar.f53410b.a(Math.floorDiv(j3, j4), aVar), ((int) Math.floorMod(j3, j4)) + 1);
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
            return ChronoUnit.MONTHS;
        }
        return super.e(temporalQuery);
    }

    @Override // j$.time.temporal.l
    public final Temporal f(Temporal temporal) {
        if (!j$.time.chrono.k.E(temporal).equals(j$.time.chrono.r.f53253c)) {
            throw new DateTimeException("Adjustment only supported on ISO date-time");
        }
        return temporal.a(s(), j$.time.temporal.a.PROLEPTIC_MONTH);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.f53457a == uVar.f53457a && this.f53458b == uVar.f53458b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f53458b << 27) ^ this.f53457a;
    }

    public final String toString() {
        int i2 = this.f53457a;
        int iAbs = Math.abs(i2);
        StringBuilder sb = new StringBuilder(9);
        if (iAbs >= 1000) {
            sb.append(i2);
        } else if (i2 < 0) {
            sb.append(i2 - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i2 + 10000);
            sb.deleteCharAt(0);
        }
        int i3 = this.f53458b;
        sb.append(i3 < 10 ? "-0" : "-");
        sb.append(i3);
        return sb.toString();
    }

    private Object writeReplace() {
        return new q((byte) 12, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
