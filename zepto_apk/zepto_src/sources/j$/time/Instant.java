package j$.time;

import com.tencent.mmkv.MMKV;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class Instant implements Temporal, j$.time.temporal.l, Comparable<Instant>, Serializable {
    private static final long serialVersionUID = -665713676816604388L;

    /* renamed from: a, reason: collision with root package name */
    public final long f53179a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53180b;
    public static final Instant EPOCH = new Instant(0, 0);
    public static final Instant MIN = ofEpochSecond(-31557014167219200L, 0);
    public static final Instant MAX = ofEpochSecond(31556889864403199L, 999999999);

    public static Instant now() {
        return Clock.systemUTC().instant();
    }

    public static Instant ofEpochSecond(long j2) {
        return s(j2, 0);
    }

    public static Instant ofEpochSecond(long j2, long j3) {
        return s(Math.addExact(j2, Math.floorDiv(j3, 1000000000L)), (int) Math.floorMod(j3, 1000000000L));
    }

    public static Instant A(long j2) {
        long j3 = 1000;
        return s(Math.floorDiv(j2, j3), ((int) Math.floorMod(j2, j3)) * 1000000);
    }

    public static Instant from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Instant) {
            return (Instant) temporalAccessor;
        }
        Objects.requireNonNull(temporalAccessor, "temporal");
        try {
            return ofEpochSecond(temporalAccessor.h(j$.time.temporal.a.INSTANT_SECONDS), temporalAccessor.j(j$.time.temporal.a.NANO_OF_SECOND));
        } catch (DateTimeException e2) {
            throw new DateTimeException("Unable to obtain Instant from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e2);
        }
    }

    public static Instant s(long j2, int i2) {
        if ((i2 | j2) == 0) {
            return EPOCH;
        }
        if (j2 < -31557014167219200L || j2 > 31556889864403199L) {
            throw new DateTimeException("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j2, i2);
    }

    public Instant(long j2, int i2) {
        this.f53179a = j2;
        this.f53180b = i2;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean g(j$.time.temporal.n nVar) {
        return nVar instanceof j$.time.temporal.a ? nVar == j$.time.temporal.a.INSTANT_SECONDS || nVar == j$.time.temporal.a.NANO_OF_SECOND || nVar == j$.time.temporal.a.MICRO_OF_SECOND || nVar == j$.time.temporal.a.MILLI_OF_SECOND : nVar != null && nVar.Z(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int j(j$.time.temporal.n nVar) {
        if (!(nVar instanceof j$.time.temporal.a)) {
            return super.l(nVar).a(nVar.s(this), nVar);
        }
        int i2 = e.f53269a[((j$.time.temporal.a) nVar).ordinal()];
        int i3 = this.f53180b;
        if (i2 == 1) {
            return i3;
        }
        if (i2 == 2) {
            return i3 / 1000;
        }
        if (i2 == 3) {
            return i3 / 1000000;
        }
        if (i2 == 4) {
            j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
            aVar.f53410b.a(this.f53179a, aVar);
        }
        throw new j$.time.temporal.p(b.a("Unsupported field: ", nVar));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long h(j$.time.temporal.n nVar) {
        int i2;
        if (!(nVar instanceof j$.time.temporal.a)) {
            return nVar.s(this);
        }
        int i3 = e.f53269a[((j$.time.temporal.a) nVar).ordinal()];
        int i4 = this.f53180b;
        if (i3 == 1) {
            return i4;
        }
        if (i3 == 2) {
            i2 = i4 / 1000;
        } else {
            if (i3 != 3) {
                if (i3 == 4) {
                    return this.f53179a;
                }
                throw new j$.time.temporal.p(b.a("Unsupported field: ", nVar));
            }
            i2 = i4 / 1000000;
        }
        return i2;
    }

    public long getEpochSecond() {
        return this.f53179a;
    }

    public int getNano() {
        return this.f53180b;
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: b */
    public final Temporal m(LocalDate localDate) {
        return (Instant) localDate.f(this);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal a(long j2, j$.time.temporal.n nVar) {
        if (!(nVar instanceof j$.time.temporal.a)) {
            return (Instant) nVar.q(this, j2);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) nVar;
        aVar.c0(j2);
        int i2 = e.f53269a[aVar.ordinal()];
        int i3 = this.f53180b;
        long j3 = this.f53179a;
        if (i2 != 1) {
            if (i2 == 2) {
                int i4 = ((int) j2) * 1000;
                if (i4 != i3) {
                    return s(j3, i4);
                }
            } else if (i2 == 3) {
                int i5 = ((int) j2) * 1000000;
                if (i5 != i3) {
                    return s(j3, i5);
                }
            } else {
                if (i2 != 4) {
                    throw new j$.time.temporal.p(b.a("Unsupported field: ", nVar));
                }
                if (j2 != j3) {
                    return s(j2, i3);
                }
            }
        } else if (j2 != i3) {
            return s(j3, (int) j2);
        }
        return this;
    }

    public Instant plus(TemporalAmount temporalAmount) {
        return (Instant) temporalAmount.q(this);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: plus, reason: merged with bridge method [inline-methods] */
    public Instant c(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (Instant) temporalUnit.q(this, j2);
        }
        switch (e.f53270b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return J(0L, j2);
            case 2:
                return J(j2 / 1000000, (j2 % 1000000) * 1000);
            case 3:
                return J(j2 / 1000, (j2 % 1000) * 1000000);
            case 4:
                return J(j2, 0L);
            case 5:
                return J(Math.multiplyExact(j2, 60), 0L);
            case 6:
                return J(Math.multiplyExact(j2, MMKV.ExpireInHour), 0L);
            case 7:
                return J(Math.multiplyExact(j2, 43200), 0L);
            case 8:
                return J(Math.multiplyExact(j2, MMKV.ExpireInDay), 0L);
            default:
                throw new j$.time.temporal.p("Unsupported unit: " + temporalUnit);
        }
    }

    public final Instant J(long j2, long j3) {
        if ((j2 | j3) == 0) {
            return this;
        }
        return ofEpochSecond(Math.addExact(Math.addExact(this.f53179a, j2), j3 / 1000000000), this.f53180b + (j3 % 1000000000));
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal d(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? c(Long.MAX_VALUE, temporalUnit).c(1L, temporalUnit) : c(-j2, temporalUnit);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.o.f53430c) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == j$.time.temporal.o.f53429b || temporalQuery == j$.time.temporal.o.f53428a || temporalQuery == j$.time.temporal.o.f53432e || temporalQuery == j$.time.temporal.o.f53431d || temporalQuery == j$.time.temporal.o.f53433f || temporalQuery == j$.time.temporal.o.f53434g) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // j$.time.temporal.l
    public final Temporal f(Temporal temporal) {
        return temporal.a(this.f53179a, j$.time.temporal.a.INSTANT_SECONDS).a(this.f53180b, j$.time.temporal.a.NANO_OF_SECOND);
    }

    @Override // j$.time.temporal.Temporal
    public final long n(Temporal temporal, TemporalUnit temporalUnit) {
        Instant instantFrom = from(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            int i2 = e.f53270b[((ChronoUnit) temporalUnit).ordinal()];
            int i3 = this.f53180b;
            long j2 = this.f53179a;
            switch (i2) {
                case 1:
                    return Math.addExact(Math.multiplyExact(Math.subtractExact(instantFrom.f53179a, j2), 1000000000L), instantFrom.f53180b - i3);
                case 2:
                    return Math.addExact(Math.multiplyExact(Math.subtractExact(instantFrom.f53179a, j2), 1000000000L), instantFrom.f53180b - i3) / 1000;
                case 3:
                    return Math.subtractExact(instantFrom.toEpochMilli(), toEpochMilli());
                case 4:
                    return K(instantFrom);
                case 5:
                    return K(instantFrom) / 60;
                case 6:
                    return K(instantFrom) / 3600;
                case 7:
                    return K(instantFrom) / 43200;
                case 8:
                    return K(instantFrom) / 86400;
                default:
                    throw new j$.time.temporal.p("Unsupported unit: " + temporalUnit);
            }
        }
        return temporalUnit.s(this, instantFrom);
    }

    public final long K(Instant instant) {
        long jSubtractExact = Math.subtractExact(instant.f53179a, this.f53179a);
        long j2 = instant.f53180b - this.f53180b;
        return (jSubtractExact <= 0 || j2 >= 0) ? (jSubtractExact >= 0 || j2 <= 0) ? jSubtractExact : jSubtractExact + 1 : jSubtractExact - 1;
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.s(this, zoneOffset);
    }

    public long toEpochMilli() {
        long j2 = this.f53179a;
        return (j2 >= 0 || this.f53180b <= 0) ? Math.addExact(Math.multiplyExact(j2, 1000), r5 / 1000000) : Math.addExact(Math.multiplyExact(j2 + 1, 1000), (r5 / 1000000) - 1000);
    }

    @Override // java.lang.Comparable
    public int compareTo(Instant instant) {
        int iCompare = Long.compare(this.f53179a, instant.f53179a);
        return iCompare != 0 ? iCompare : this.f53180b - instant.f53180b;
    }

    public boolean isAfter(Instant instant) {
        return compareTo(instant) > 0;
    }

    public boolean isBefore(Instant instant) {
        return compareTo(instant) < 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            Instant instant = (Instant) obj;
            if (this.f53179a == instant.f53179a && this.f53180b == instant.f53180b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f53179a;
        return (this.f53180b * 51) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return DateTimeFormatter.f53285i.format(this);
    }

    private Object writeReplace() {
        return new q((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
