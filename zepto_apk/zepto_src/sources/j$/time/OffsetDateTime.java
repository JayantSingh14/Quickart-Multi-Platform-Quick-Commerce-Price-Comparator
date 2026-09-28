package j$.time;

import j$.time.chrono.ChronoLocalDateTime;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class OffsetDateTime implements Temporal, j$.time.temporal.l, Comparable<OffsetDateTime>, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f53194c = 0;
    private static final long serialVersionUID = 2287754244819255394L;

    /* renamed from: a, reason: collision with root package name */
    public final LocalDateTime f53195a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset f53196b;

    @Override // java.lang.Comparable
    public final int compareTo(OffsetDateTime offsetDateTime) {
        int nano;
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        ZoneOffset zoneOffset = offsetDateTime2.f53196b;
        ZoneOffset zoneOffset2 = this.f53196b;
        if (zoneOffset2.equals(zoneOffset)) {
            nano = toLocalDateTime().compareTo((ChronoLocalDateTime<?>) offsetDateTime2.toLocalDateTime());
        } else {
            LocalDateTime localDateTime = this.f53195a;
            long jB0 = localDateTime.b0(zoneOffset2);
            ZoneOffset zoneOffset3 = offsetDateTime2.f53196b;
            LocalDateTime localDateTime2 = offsetDateTime2.f53195a;
            int iCompare = Long.compare(jB0, localDateTime2.b0(zoneOffset3));
            nano = iCompare == 0 ? localDateTime.f53185b.getNano() - localDateTime2.f53185b.getNano() : iCompare;
        }
        return nano == 0 ? toLocalDateTime().compareTo((ChronoLocalDateTime<?>) offsetDateTime2.toLocalDateTime()) : nano;
    }

    static {
        LocalDateTime localDateTime = LocalDateTime.MIN;
        ZoneOffset zoneOffset = ZoneOffset.f53201g;
        localDateTime.getClass();
        new OffsetDateTime(localDateTime, zoneOffset);
        LocalDateTime localDateTime2 = LocalDateTime.MAX;
        ZoneOffset zoneOffset2 = ZoneOffset.f53200f;
        localDateTime2.getClass();
        new OffsetDateTime(localDateTime2, zoneOffset2);
    }

    public static OffsetDateTime s(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        ZoneOffset zoneOffsetD = zoneId.getRules().d(instant);
        return new OffsetDateTime(LocalDateTime.K(instant.getEpochSecond(), instant.getNano(), zoneOffsetD), zoneOffsetD);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v15, types: [j$.time.OffsetDateTime] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    @Override // j$.time.temporal.Temporal
    public final long n(Temporal temporal, TemporalUnit temporalUnit) {
        if (temporal instanceof OffsetDateTime) {
            temporal = (OffsetDateTime) temporal;
        } else {
            try {
                ZoneOffset zoneOffsetFrom = ZoneOffset.from(temporal);
                LocalDate localDate = (LocalDate) temporal.e(j$.time.temporal.o.f53433f);
                LocalTime localTime = (LocalTime) temporal.e(j$.time.temporal.o.f53434g);
                if (localDate != null && localTime != null) {
                    temporal = new OffsetDateTime(LocalDateTime.of(localDate, localTime), zoneOffsetFrom);
                } else {
                    temporal = s(Instant.from(temporal), zoneOffsetFrom);
                }
            } catch (DateTimeException e2) {
                throw new DateTimeException("Unable to obtain OffsetDateTime from TemporalAccessor: " + temporal + " of type " + temporal.getClass().getName(), e2);
            }
        }
        if (temporalUnit instanceof ChronoUnit) {
            ZoneOffset zoneOffset = temporal.f53196b;
            ZoneOffset zoneOffset2 = this.f53196b;
            OffsetDateTime offsetDateTime = temporal;
            if (!zoneOffset2.equals(zoneOffset)) {
                offsetDateTime = new OffsetDateTime(temporal.f53195a.Z(zoneOffset2.getTotalSeconds() - zoneOffset.getTotalSeconds()), zoneOffset2);
            }
            return this.f53195a.n(offsetDateTime.f53195a, temporalUnit);
        }
        return temporalUnit.s(this, temporal);
    }

    public OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "dateTime");
        this.f53195a = localDateTime;
        Objects.requireNonNull(zoneOffset, "offset");
        this.f53196b = zoneOffset;
    }

    public final OffsetDateTime J(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.f53195a == localDateTime && this.f53196b.equals(zoneOffset)) ? this : new OffsetDateTime(localDateTime, zoneOffset);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean g(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            return true;
        }
        return nVar != null && nVar.Z(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.q l(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            if (nVar != j$.time.temporal.a.INSTANT_SECONDS && nVar != j$.time.temporal.a.OFFSET_SECONDS) {
                return this.f53195a.l(nVar);
            }
            return ((j$.time.temporal.a) nVar).f53410b;
        }
        return nVar.K(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int j(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            int i2 = m.f53388a[((j$.time.temporal.a) nVar).ordinal()];
            if (i2 == 1) {
                throw new j$.time.temporal.p("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i2 == 2) {
                return this.f53196b.getTotalSeconds();
            }
            return this.f53195a.j(nVar);
        }
        return super.j(nVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long h(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            int i2 = m.f53388a[((j$.time.temporal.a) nVar).ordinal()];
            ZoneOffset zoneOffset = this.f53196b;
            LocalDateTime localDateTime = this.f53195a;
            if (i2 == 1) {
                return localDateTime.b0(zoneOffset);
            }
            if (i2 == 2) {
                return zoneOffset.getTotalSeconds();
            }
            return localDateTime.h(nVar);
        }
        return nVar.s(this);
    }

    public LocalDateTime toLocalDateTime() {
        return this.f53195a;
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: b */
    public final Temporal m(LocalDate localDate) {
        LocalDateTime localDateTime = this.f53195a;
        ZoneOffset zoneOffset = this.f53196b;
        if (localDate != null) {
            return J(localDateTime.m(localDate), zoneOffset);
        }
        return (OffsetDateTime) localDate.f(this);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal a(long j2, j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) nVar;
            int i2 = m.f53388a[aVar.ordinal()];
            ZoneOffset zoneOffset = this.f53196b;
            LocalDateTime localDateTime = this.f53195a;
            if (i2 == 1) {
                return s(Instant.ofEpochSecond(j2, localDateTime.getNano()), zoneOffset);
            }
            if (i2 == 2) {
                return J(localDateTime, ZoneOffset.ofTotalSeconds(aVar.f53410b.a(j2, aVar)));
            }
            return J(localDateTime.a(j2, nVar), zoneOffset);
        }
        return (OffsetDateTime) nVar.q(this, j2);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final OffsetDateTime c(long j2, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return J(this.f53195a.c(j2, temporalUnit), this.f53196b);
        }
        return (OffsetDateTime) temporalUnit.q(this, j2);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal d(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? c(Long.MAX_VALUE, temporalUnit).c(1L, temporalUnit) : c(-j2, temporalUnit);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.o.f53431d || temporalQuery == j$.time.temporal.o.f53432e) {
            return this.f53196b;
        }
        if (temporalQuery == j$.time.temporal.o.f53428a) {
            return null;
        }
        f fVar = j$.time.temporal.o.f53433f;
        LocalDateTime localDateTime = this.f53195a;
        if (temporalQuery == fVar) {
            return localDateTime.f53184a;
        }
        if (temporalQuery == j$.time.temporal.o.f53434g) {
            return localDateTime.f53185b;
        }
        if (temporalQuery == j$.time.temporal.o.f53429b) {
            return j$.time.chrono.r.f53253c;
        }
        if (temporalQuery == j$.time.temporal.o.f53430c) {
            return ChronoUnit.NANOS;
        }
        return temporalQuery.queryFrom(this);
    }

    @Override // j$.time.temporal.l
    public final Temporal f(Temporal temporal) {
        j$.time.temporal.a aVar = j$.time.temporal.a.EPOCH_DAY;
        LocalDateTime localDateTime = this.f53195a;
        return temporal.a(localDateTime.f53184a.toEpochDay(), aVar).a(localDateTime.f53185b.g0(), j$.time.temporal.a.NANO_OF_DAY).a(this.f53196b.getTotalSeconds(), j$.time.temporal.a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetDateTime) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
            if (this.f53195a.equals(offsetDateTime.f53195a) && this.f53196b.equals(offsetDateTime.f53196b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f53195a.hashCode() ^ this.f53196b.hashCode();
    }

    public final String toString() {
        return this.f53195a.toString() + this.f53196b.toString();
    }

    private Object writeReplace() {
        return new q((byte) 10, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
