package j$.time.chrono;

import j$.time.Clock;
import j$.time.DateTimeException;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.Month;
import j$.time.ZoneId;
import j$.time.ZonedDateTime;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class r extends AbstractC0109a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final r f53253c = new r();
    private static final long serialVersionUID = -1440403870442975015L;

    @Override // j$.time.chrono.k
    public final l S(int i2) {
        if (i2 == 0) {
            return s.BCE;
        }
        if (i2 == 1) {
            return s.CE;
        }
        throw new DateTimeException("Invalid era: " + i2);
    }

    @Override // j$.time.chrono.k
    public final String getId() {
        return "ISO";
    }

    @Override // j$.time.chrono.k
    public final String W() {
        return "iso8601";
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate F(int i2, int i3, int i4) {
        return LocalDate.of(i2, i3, i4);
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate y(int i2, int i3) {
        return LocalDate.h0(i2, i3);
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate r(long j2) {
        return LocalDate.ofEpochDay(j2);
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate t(TemporalAccessor temporalAccessor) {
        return LocalDate.J(temporalAccessor);
    }

    private r() {
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDateTime a0(Temporal temporal) {
        return LocalDateTime.A(temporal);
    }

    @Override // j$.time.chrono.k
    public final InterfaceC0116h N(Temporal temporal) {
        return ZonedDateTime.A(temporal);
    }

    @Override // j$.time.chrono.k
    public final InterfaceC0116h w(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return ZonedDateTime.s(instant.getEpochSecond(), instant.getNano(), zoneId);
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate O() {
        return LocalDate.J(LocalDate.g0(Clock.b()));
    }

    @Override // j$.time.chrono.k
    public final boolean C(long j2) {
        if ((3 & j2) == 0) {
            return j2 % 100 != 0 || j2 % 400 == 0;
        }
        return false;
    }

    @Override // j$.time.chrono.k
    public final int v(l lVar, int i2) {
        if (lVar instanceof s) {
            return lVar == s.CE ? i2 : 1 - i2;
        }
        throw new ClassCastException("Era must be IsoEra");
    }

    @Override // j$.time.chrono.k
    public final List B() {
        return j$.time.d.c(s.values());
    }

    @Override // j$.time.chrono.AbstractC0109a, j$.time.chrono.k
    public final ChronoLocalDate U(Map map, j$.time.format.C c2) {
        return (LocalDate) super.U(map, c2);
    }

    @Override // j$.time.chrono.AbstractC0109a
    public final void J(Map map, j$.time.format.C c2) {
        j$.time.temporal.a aVar = j$.time.temporal.a.PROLEPTIC_MONTH;
        Long l2 = (Long) map.remove(aVar);
        if (l2 != null) {
            if (c2 != j$.time.format.C.LENIENT) {
                aVar.c0(l2.longValue());
            }
            AbstractC0109a.q(map, j$.time.temporal.a.MONTH_OF_YEAR, ((int) Math.floorMod(l2.longValue(), r4)) + 1);
            AbstractC0109a.q(map, j$.time.temporal.a.YEAR, Math.floorDiv(l2.longValue(), 12));
        }
    }

    @Override // j$.time.chrono.AbstractC0109a
    public final ChronoLocalDate X(Map map, j$.time.format.C c2) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR_OF_ERA;
        Long l2 = (Long) map.remove(aVar);
        if (l2 != null) {
            if (c2 != j$.time.format.C.LENIENT) {
                aVar.c0(l2.longValue());
            }
            Long l3 = (Long) map.remove(j$.time.temporal.a.ERA);
            if (l3 != null) {
                if (l3.longValue() == 1) {
                    AbstractC0109a.q(map, j$.time.temporal.a.YEAR, l2.longValue());
                    return null;
                }
                if (l3.longValue() == 0) {
                    AbstractC0109a.q(map, j$.time.temporal.a.YEAR, Math.subtractExact(1L, l2.longValue()));
                    return null;
                }
                throw new DateTimeException("Invalid value for era: " + l3);
            }
            j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
            Long l4 = (Long) map.get(aVar2);
            if (c2 != j$.time.format.C.STRICT) {
                AbstractC0109a.q(map, aVar2, (l4 == null || l4.longValue() > 0) ? l2.longValue() : Math.subtractExact(1L, l2.longValue()));
                return null;
            }
            if (l4 != null) {
                long jLongValue = l4.longValue();
                long jLongValue2 = l2.longValue();
                if (jLongValue <= 0) {
                    jLongValue2 = Math.subtractExact(1L, jLongValue2);
                }
                AbstractC0109a.q(map, aVar2, jLongValue2);
                return null;
            }
            map.put(aVar, l2);
            return null;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.ERA;
        if (!map.containsKey(aVar3)) {
            return null;
        }
        aVar3.c0(((Long) map.get(aVar3)).longValue());
        return null;
    }

    @Override // j$.time.chrono.AbstractC0109a
    public final ChronoLocalDate K(Map map, j$.time.format.C c2) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        int iA = aVar.f53410b.a(((Long) map.remove(aVar)).longValue(), aVar);
        boolean z = true;
        if (c2 == j$.time.format.C.LENIENT) {
            return LocalDate.of(iA, 1, 1).k0(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.MONTH_OF_YEAR)).longValue(), 1L)).j0(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.DAY_OF_MONTH)).longValue(), 1L));
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        int iA2 = aVar2.f53410b.a(((Long) map.remove(aVar2)).longValue(), aVar2);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        int iA3 = aVar3.f53410b.a(((Long) map.remove(aVar3)).longValue(), aVar3);
        if (c2 == j$.time.format.C.SMART) {
            if (iA2 == 4 || iA2 == 6 || iA2 == 9 || iA2 == 11) {
                iA3 = Math.min(iA3, 30);
            } else if (iA2 == 2) {
                Month month = Month.FEBRUARY;
                long j2 = iA;
                int i2 = j$.time.s.f53401b;
                if ((3 & j2) != 0 || (j2 % 100 == 0 && j2 % 400 != 0)) {
                    z = false;
                }
                iA3 = Math.min(iA3, month.A(z));
            }
        }
        return LocalDate.of(iA, iA2, iA3);
    }

    @Override // j$.time.chrono.k
    public final j$.time.temporal.q Y(j$.time.temporal.a aVar) {
        return aVar.f53410b;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new D((byte) 1, this);
    }
}
