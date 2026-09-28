package j$.time;

import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.InterfaceC0116h;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.zone.ZoneRules;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ZonedDateTime implements Temporal, InterfaceC0116h, Serializable {
    private static final long serialVersionUID = -6260982410461394882L;

    /* renamed from: a, reason: collision with root package name */
    public final LocalDateTime f53204a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset f53205b;

    /* renamed from: c, reason: collision with root package name */
    public final ZoneId f53206c;

    @Override // j$.time.temporal.Temporal
    public final Temporal d(long j2, TemporalUnit temporalUnit) {
        ChronoUnit chronoUnit = (ChronoUnit) temporalUnit;
        return j2 == Long.MIN_VALUE ? c(Long.MAX_VALUE, chronoUnit).c(1L, chronoUnit) : c(-j2, chronoUnit);
    }

    public static ZonedDateTime J(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, zoneId, (ZoneOffset) zoneId);
        }
        ZoneRules rules = zoneId.getRules();
        List listF = rules.f(localDateTime);
        if (listF.size() == 1) {
            zoneOffset = (ZoneOffset) listF.get(0);
        } else if (listF.size() != 0) {
            if (zoneOffset == null || !listF.contains(zoneOffset)) {
                zoneOffset = (ZoneOffset) listF.get(0);
                Objects.requireNonNull(zoneOffset, "offset");
            }
        } else {
            Object objE = rules.e(localDateTime);
            j$.time.zone.b bVar = objE instanceof j$.time.zone.b ? (j$.time.zone.b) objE : null;
            localDateTime = localDateTime.Z(Duration.ofSeconds(bVar.f53480d.getTotalSeconds() - bVar.f53479c.getTotalSeconds()).getSeconds());
            zoneOffset = bVar.f53480d;
        }
        return new ZonedDateTime(localDateTime, zoneId, zoneOffset);
    }

    public static ZonedDateTime s(long j2, int i2, ZoneId zoneId) {
        ZoneOffset zoneOffsetD = zoneId.getRules().d(Instant.ofEpochSecond(j2, i2));
        return new ZonedDateTime(LocalDateTime.K(j2, i2, zoneOffsetD), zoneId, zoneOffsetD);
    }

    public static ZonedDateTime A(Temporal temporal) {
        if (temporal instanceof ZonedDateTime) {
            return (ZonedDateTime) temporal;
        }
        try {
            ZoneId zoneIdS = ZoneId.s(temporal);
            j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
            if (!temporal.g(aVar)) {
                return J(LocalDateTime.of(LocalDate.J(temporal), LocalTime.A(temporal)), zoneIdS, null);
            }
            return s(temporal.h(aVar), temporal.j(j$.time.temporal.a.NANO_OF_SECOND), zoneIdS);
        } catch (DateTimeException e2) {
            throw new DateTimeException("Unable to obtain ZonedDateTime from TemporalAccessor: " + temporal + " of type " + temporal.getClass().getName(), e2);
        }
    }

    public ZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        this.f53204a = localDateTime;
        this.f53205b = zoneOffset;
        this.f53206c = zoneId;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean g(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            return true;
        }
        return nVar != null && nVar.Z(this);
    }

    @Override // j$.time.chrono.InterfaceC0116h
    public final ChronoLocalDate p() {
        return this.f53204a.f53184a;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.q l(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            if (nVar == j$.time.temporal.a.INSTANT_SECONDS || nVar == j$.time.temporal.a.OFFSET_SECONDS) {
                return ((j$.time.temporal.a) nVar).f53410b;
            }
            return this.f53204a.l(nVar);
        }
        return nVar.K(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int j(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            int i2 = w.f53462a[((j$.time.temporal.a) nVar).ordinal()];
            if (i2 == 1) {
                throw new j$.time.temporal.p("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i2 == 2) {
                return this.f53205b.getTotalSeconds();
            }
            return this.f53204a.j(nVar);
        }
        return super.j(nVar);
    }

    @Override // j$.time.chrono.InterfaceC0116h
    public final LocalTime o() {
        return this.f53204a.f53185b;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long h(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            int i2 = w.f53462a[((j$.time.temporal.a) nVar).ordinal()];
            if (i2 == 1) {
                return T();
            }
            if (i2 == 2) {
                return this.f53205b.getTotalSeconds();
            }
            return this.f53204a.h(nVar);
        }
        return nVar.s(this);
    }

    @Override // j$.time.chrono.InterfaceC0116h
    public final ZoneOffset D() {
        return this.f53205b;
    }

    @Override // j$.time.chrono.InterfaceC0116h
    public final ZoneId V() {
        return this.f53206c;
    }

    @Override // j$.time.chrono.InterfaceC0116h
    public final InterfaceC0116h I(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        return this.f53206c.equals(zoneId) ? this : J(this.f53204a, zoneId, this.f53205b);
    }

    @Override // j$.time.chrono.InterfaceC0116h
    public final InterfaceC0116h G(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        if (this.f53206c.equals(zoneId)) {
            return this;
        }
        ZoneOffset zoneOffset = this.f53205b;
        LocalDateTime localDateTime = this.f53204a;
        return s(localDateTime.b0(zoneOffset), localDateTime.getNano(), zoneId);
    }

    @Override // j$.time.chrono.InterfaceC0116h
    public final ChronoLocalDateTime z() {
        return this.f53204a;
    }

    @Override // j$.time.chrono.InterfaceC0116h
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime m(LocalDate localDate) {
        ZoneOffset zoneOffset = this.f53205b;
        ZoneId zoneId = this.f53206c;
        LocalDateTime localDateTime = this.f53204a;
        if (localDate != null) {
            return J(LocalDateTime.of(localDate, localDateTime.f53185b), zoneId, zoneOffset);
        }
        return (ZonedDateTime) localDate.f(this);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal a(long j2, j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) nVar;
            int i2 = w.f53462a[aVar.ordinal()];
            LocalDateTime localDateTime = this.f53204a;
            ZoneId zoneId = this.f53206c;
            if (i2 == 1) {
                return s(j2, localDateTime.getNano(), zoneId);
            }
            ZoneOffset zoneOffset = this.f53205b;
            if (i2 != 2) {
                return J(localDateTime.a(j2, nVar), zoneId, zoneOffset);
            }
            ZoneOffset zoneOffsetOfTotalSeconds = ZoneOffset.ofTotalSeconds(aVar.f53410b.a(j2, aVar));
            return (zoneOffsetOfTotalSeconds.equals(zoneOffset) || !zoneId.getRules().f(localDateTime).contains(zoneOffsetOfTotalSeconds)) ? this : new ZonedDateTime(localDateTime, zoneId, zoneOffsetOfTotalSeconds);
        }
        return (ZonedDateTime) nVar.q(this, j2);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime c(long j2, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            ChronoUnit chronoUnit = (ChronoUnit) temporalUnit;
            boolean z = chronoUnit.compareTo(ChronoUnit.DAYS) >= 0 && chronoUnit != ChronoUnit.FOREVER;
            ZoneOffset zoneOffset = this.f53205b;
            ZoneId zoneId = this.f53206c;
            LocalDateTime localDateTime = this.f53204a;
            if (z) {
                return J(localDateTime.c(j2, temporalUnit), zoneId, zoneOffset);
            }
            LocalDateTime localDateTimeC = localDateTime.c(j2, temporalUnit);
            Objects.requireNonNull(localDateTimeC, "localDateTime");
            Objects.requireNonNull(zoneOffset, "offset");
            Objects.requireNonNull(zoneId, "zone");
            if (zoneId.getRules().f(localDateTimeC).contains(zoneOffset)) {
                return new ZonedDateTime(localDateTimeC, zoneId, zoneOffset);
            }
            return s(localDateTimeC.b0(zoneOffset), localDateTimeC.getNano(), zoneId);
        }
        return (ZonedDateTime) temporalUnit.q(this, j2);
    }

    @Override // j$.time.chrono.InterfaceC0116h
    /* renamed from: k */
    public final InterfaceC0116h d(long j2, ChronoUnit chronoUnit) {
        return j2 == Long.MIN_VALUE ? c(Long.MAX_VALUE, chronoUnit).c(1L, chronoUnit) : c(-j2, chronoUnit);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.o.f53433f) {
            return this.f53204a.f53184a;
        }
        return super.e(temporalQuery);
    }

    @Override // j$.time.temporal.Temporal
    public final long n(Temporal temporal, TemporalUnit temporalUnit) {
        ZonedDateTime zonedDateTimeA = A(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            zonedDateTimeA.getClass();
            ZoneId zoneId = this.f53206c;
            Objects.requireNonNull(zoneId, "zone");
            if (!zonedDateTimeA.f53206c.equals(zoneId)) {
                ZoneOffset zoneOffset = zonedDateTimeA.f53205b;
                LocalDateTime localDateTime = zonedDateTimeA.f53204a;
                zonedDateTimeA = s(localDateTime.b0(zoneOffset), localDateTime.getNano(), zoneId);
            }
            ChronoUnit chronoUnit = (ChronoUnit) temporalUnit;
            int iCompareTo = chronoUnit.compareTo(ChronoUnit.DAYS);
            LocalDateTime localDateTime2 = this.f53204a;
            LocalDateTime localDateTime3 = zonedDateTimeA.f53204a;
            if (iCompareTo >= 0 && chronoUnit != ChronoUnit.FOREVER) {
                return localDateTime2.n(localDateTime3, temporalUnit);
            }
            return new OffsetDateTime(localDateTime2, this.f53205b).n(new OffsetDateTime(localDateTime3, zonedDateTimeA.f53205b), temporalUnit);
        }
        return temporalUnit.s(this, zonedDateTimeA);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZonedDateTime) {
            ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
            if (this.f53204a.equals(zonedDateTime.f53204a) && this.f53205b.equals(zonedDateTime.f53205b) && this.f53206c.equals(zonedDateTime.f53206c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f53204a.hashCode() ^ this.f53205b.hashCode()) ^ Integer.rotateLeft(this.f53206c.hashCode(), 3);
    }

    public final String toString() {
        String string = this.f53204a.toString();
        ZoneOffset zoneOffset = this.f53205b;
        String str = string + zoneOffset.toString();
        ZoneId zoneId = this.f53206c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    private Object writeReplace() {
        return new q((byte) 6, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
