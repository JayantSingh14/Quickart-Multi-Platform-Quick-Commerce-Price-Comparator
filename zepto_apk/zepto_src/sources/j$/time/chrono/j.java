package j$.time.chrono;

import j$.time.Duration;
import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalUnit;
import j$.time.zone.ZoneRules;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class j implements InterfaceC0116h, Serializable {
    private static final long serialVersionUID = -5261813987200935591L;

    /* renamed from: a, reason: collision with root package name */
    public final transient C0113e f53233a;

    /* renamed from: b, reason: collision with root package name */
    public final transient ZoneOffset f53234b;

    /* renamed from: c, reason: collision with root package name */
    public final transient ZoneId f53235c;

    public static j A(ZoneId zoneId, ZoneOffset zoneOffset, C0113e c0113e) {
        Objects.requireNonNull(c0113e, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new j(zoneId, (ZoneOffset) zoneId, c0113e);
        }
        ZoneRules rules = zoneId.getRules();
        LocalDateTime localDateTimeA = LocalDateTime.A(c0113e);
        List listF = rules.f(localDateTimeA);
        if (listF.size() == 1) {
            zoneOffset = (ZoneOffset) listF.get(0);
        } else if (listF.size() != 0) {
            if (zoneOffset == null || !listF.contains(zoneOffset)) {
                zoneOffset = (ZoneOffset) listF.get(0);
            }
            c0113e = c0113e;
        } else {
            Object objE = rules.e(localDateTimeA);
            j$.time.zone.b bVar = objE instanceof j$.time.zone.b ? (j$.time.zone.b) objE : null;
            c0113e = c0113e.J(c0113e.f53224a, 0L, 0L, Duration.ofSeconds(bVar.f53480d.getTotalSeconds() - bVar.f53479c.getTotalSeconds()).getSeconds(), 0L);
            zoneOffset = bVar.f53480d;
        }
        Objects.requireNonNull(zoneOffset, "offset");
        return new j(zoneId, zoneOffset, c0113e);
    }

    public static j J(k kVar, Instant instant, ZoneId zoneId) {
        ZoneOffset zoneOffsetD = zoneId.getRules().d(instant);
        Objects.requireNonNull(zoneOffsetD, "offset");
        return new j(zoneId, zoneOffsetD, (C0113e) kVar.a0(LocalDateTime.K(instant.getEpochSecond(), instant.getNano(), zoneOffsetD)));
    }

    public static j s(k kVar, Temporal temporal) {
        j jVar = (j) temporal;
        if (kVar.equals(jVar.i())) {
            return jVar;
        }
        throw new ClassCastException("Chronology mismatch, required: " + kVar.getId() + ", actual: " + jVar.i().getId());
    }

    public j(ZoneId zoneId, ZoneOffset zoneOffset, C0113e c0113e) {
        Objects.requireNonNull(c0113e, "dateTime");
        this.f53233a = c0113e;
        Objects.requireNonNull(zoneOffset, "offset");
        this.f53234b = zoneOffset;
        Objects.requireNonNull(zoneId, "zone");
        this.f53235c = zoneId;
    }

    @Override // j$.time.chrono.InterfaceC0116h
    public final ZoneOffset D() {
        return this.f53234b;
    }

    @Override // j$.time.chrono.InterfaceC0116h
    public final ChronoLocalDateTime z() {
        return this.f53233a;
    }

    @Override // j$.time.chrono.InterfaceC0116h
    public final ZoneId V() {
        return this.f53235c;
    }

    @Override // j$.time.chrono.InterfaceC0116h
    public final InterfaceC0116h I(ZoneId zoneId) {
        return A(zoneId, this.f53234b, this.f53233a);
    }

    @Override // j$.time.chrono.InterfaceC0116h
    public final InterfaceC0116h G(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        if (this.f53235c.equals(zoneId)) {
            return this;
        }
        return J(i(), Instant.ofEpochSecond(this.f53233a.b0(this.f53234b), r0.o().getNano()), zoneId);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean g(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            return true;
        }
        return nVar != null && nVar.Z(this);
    }

    @Override // j$.time.temporal.Temporal
    public final Temporal a(long j2, j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) nVar;
            int i2 = AbstractC0117i.f53232a[aVar.ordinal()];
            if (i2 == 1) {
                return c(j2 - T(), ChronoUnit.SECONDS);
            }
            ZoneId zoneId = this.f53235c;
            C0113e c0113e = this.f53233a;
            if (i2 != 2) {
                return A(zoneId, this.f53234b, c0113e.a(j2, nVar));
            }
            return J(i(), Instant.ofEpochSecond(c0113e.b0(ZoneOffset.ofTotalSeconds(aVar.f53410b.a(j2, aVar))), c0113e.o().getNano()), zoneId);
        }
        return s(i(), nVar.q(this, j2));
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public final j c(long j2, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return (j) m(this.f53233a.c(j2, temporalUnit));
        }
        return s(i(), temporalUnit.q(this, j2));
    }

    @Override // j$.time.temporal.Temporal
    public final long n(Temporal temporal, TemporalUnit temporalUnit) {
        Objects.requireNonNull(temporal, "endExclusive");
        InterfaceC0116h interfaceC0116hN = i().N(temporal);
        if (temporalUnit instanceof ChronoUnit) {
            return this.f53233a.n(interfaceC0116hN.G(this.f53234b).z(), temporalUnit);
        }
        Objects.requireNonNull(temporalUnit, "unit");
        return temporalUnit.s(this, interfaceC0116hN);
    }

    private Object writeReplace() {
        return new D((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InterfaceC0116h) && compareTo((InterfaceC0116h) obj) == 0;
    }

    public final int hashCode() {
        return (this.f53233a.hashCode() ^ this.f53234b.hashCode()) ^ Integer.rotateLeft(this.f53235c.hashCode(), 3);
    }

    public final String toString() {
        String string = this.f53233a.toString();
        ZoneOffset zoneOffset = this.f53234b;
        String str = string + zoneOffset.toString();
        ZoneId zoneId = this.f53235c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }
}
