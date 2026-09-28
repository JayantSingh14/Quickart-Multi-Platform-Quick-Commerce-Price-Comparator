package j$.time.chrono;

import com.tencent.mmkv.MMKV;
import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang3.time.DateUtils;

/* renamed from: j$.time.chrono.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0113e implements ChronoLocalDateTime, Temporal, j$.time.temporal.l, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;

    /* renamed from: a, reason: collision with root package name */
    public final transient ChronoLocalDate f53224a;

    /* renamed from: b, reason: collision with root package name */
    public final transient LocalTime f53225b;

    public static C0113e s(k kVar, Temporal temporal) {
        C0113e c0113e = (C0113e) temporal;
        if (kVar.equals(c0113e.i())) {
            return c0113e;
        }
        throw new ClassCastException("Chronology mismatch, required: " + kVar.getId() + ", actual: " + c0113e.i().getId());
    }

    public C0113e(ChronoLocalDate chronoLocalDate, LocalTime localTime) {
        Objects.requireNonNull(localTime, "time");
        this.f53224a = chronoLocalDate;
        this.f53225b = localTime;
    }

    public final C0113e Z(Temporal temporal, LocalTime localTime) {
        ChronoLocalDate chronoLocalDate = this.f53224a;
        return (chronoLocalDate == temporal && this.f53225b == localTime) ? this : new C0113e(AbstractC0111c.s(chronoLocalDate.i(), temporal), localTime);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final ChronoLocalDate p() {
        return this.f53224a;
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final LocalTime o() {
        return this.f53225b;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean g(j$.time.temporal.n nVar) {
        if (!(nVar instanceof j$.time.temporal.a)) {
            return nVar != null && nVar.Z(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) nVar;
        return aVar.X() || aVar.d0();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.q l(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            return (((j$.time.temporal.a) nVar).d0() ? this.f53225b : this.f53224a).l(nVar);
        }
        return nVar.K(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int j(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) nVar).d0() ? this.f53225b.j(nVar) : this.f53224a.j(nVar);
        }
        return l(nVar).a(h(nVar), nVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long h(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) nVar).d0() ? this.f53225b.h(nVar) : this.f53224a.h(nVar);
        }
        return nVar.s(this);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime, j$.time.temporal.Temporal
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public final C0113e m(LocalDate localDate) {
        if (localDate != null) {
            return Z(localDate, this.f53225b);
        }
        return s(this.f53224a.i(), (C0113e) localDate.f(this));
    }

    @Override // j$.time.chrono.ChronoLocalDateTime, j$.time.temporal.Temporal
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public final C0113e a(long j2, j$.time.temporal.n nVar) {
        boolean z = nVar instanceof j$.time.temporal.a;
        ChronoLocalDate chronoLocalDate = this.f53224a;
        if (z) {
            boolean zD0 = ((j$.time.temporal.a) nVar).d0();
            LocalTime localTime = this.f53225b;
            if (zD0) {
                return Z(chronoLocalDate, localTime.a(j2, nVar));
            }
            return Z(chronoLocalDate.a(j2, nVar), localTime);
        }
        return s(chronoLocalDate.i(), nVar.q(this, j2));
    }

    @Override // j$.time.chrono.ChronoLocalDateTime, j$.time.temporal.Temporal
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final C0113e c(long j2, TemporalUnit temporalUnit) {
        boolean z = temporalUnit instanceof ChronoUnit;
        ChronoLocalDate chronoLocalDate = this.f53224a;
        if (z) {
            int i2 = AbstractC0112d.f53223a[((ChronoUnit) temporalUnit).ordinal()];
            LocalTime localTime = this.f53225b;
            switch (i2) {
                case 1:
                    return J(this.f53224a, 0L, 0L, 0L, j2);
                case 2:
                    C0113e c0113eZ = Z(chronoLocalDate.c(j2 / 86400000000L, (TemporalUnit) ChronoUnit.DAYS), localTime);
                    return c0113eZ.J(c0113eZ.f53224a, 0L, 0L, 0L, (j2 % 86400000000L) * 1000);
                case 3:
                    C0113e c0113eZ2 = Z(chronoLocalDate.c(j2 / DateUtils.MILLIS_PER_DAY, (TemporalUnit) ChronoUnit.DAYS), localTime);
                    return c0113eZ2.J(c0113eZ2.f53224a, 0L, 0L, 0L, (j2 % DateUtils.MILLIS_PER_DAY) * 1000000);
                case 4:
                    return J(this.f53224a, 0L, 0L, j2, 0L);
                case 5:
                    return J(this.f53224a, 0L, j2, 0L, 0L);
                case 6:
                    return J(this.f53224a, j2, 0L, 0L, 0L);
                case 7:
                    C0113e c0113eZ3 = Z(chronoLocalDate.c(j2 / 256, (TemporalUnit) ChronoUnit.DAYS), localTime);
                    return c0113eZ3.J(c0113eZ3.f53224a, (j2 % 256) * 12, 0L, 0L, 0L);
                default:
                    return Z(chronoLocalDate.c(j2, temporalUnit), localTime);
            }
        }
        return s(chronoLocalDate.i(), temporalUnit.q(this, j2));
    }

    public final C0113e J(ChronoLocalDate chronoLocalDate, long j2, long j3, long j4, long j5) {
        long j6 = j2 | j3 | j4 | j5;
        LocalTime localTimeK = this.f53225b;
        if (j6 == 0) {
            return Z(chronoLocalDate, localTimeK);
        }
        long j7 = j3 / 1440;
        long j8 = j2 / 24;
        long j9 = (j3 % 1440) * 60000000000L;
        long j10 = ((j2 % 24) * 3600000000000L) + j9 + ((j4 % 86400) * 1000000000) + (j5 % 86400000000000L);
        long jG0 = localTimeK.g0();
        long j11 = j10 + jG0;
        long jFloorDiv = Math.floorDiv(j11, 86400000000000L) + j8 + j7 + (j4 / 86400) + (j5 / 86400000000000L);
        long jFloorMod = Math.floorMod(j11, 86400000000000L);
        if (jFloorMod != jG0) {
            localTimeK = LocalTime.K(jFloorMod);
        }
        return Z(chronoLocalDate.c(jFloorDiv, (TemporalUnit) ChronoUnit.DAYS), localTimeK);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final InterfaceC0116h H(ZoneId zoneId) {
        return j.A(zoneId, null, this);
    }

    @Override // j$.time.temporal.Temporal
    public final long n(Temporal temporal, TemporalUnit temporalUnit) {
        Objects.requireNonNull(temporal, "endExclusive");
        ChronoLocalDateTime chronoLocalDateTimeA0 = i().a0(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            Objects.requireNonNull(temporalUnit, "unit");
            return temporalUnit.s(this, chronoLocalDateTimeA0);
        }
        ChronoUnit chronoUnit = ChronoUnit.DAYS;
        boolean z = ((ChronoUnit) temporalUnit).compareTo(chronoUnit) < 0;
        LocalTime localTime = this.f53225b;
        ChronoLocalDate chronoLocalDate = this.f53224a;
        if (!z) {
            ChronoLocalDate chronoLocalDateP = chronoLocalDateTimeA0.p();
            if (chronoLocalDateTimeA0.o().compareTo(localTime) < 0) {
                chronoLocalDateP = chronoLocalDateP.d(1L, (TemporalUnit) chronoUnit);
            }
            return chronoLocalDate.n(chronoLocalDateP, temporalUnit);
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.EPOCH_DAY;
        long jH = chronoLocalDateTimeA0.h(aVar) - chronoLocalDate.h(aVar);
        switch (AbstractC0112d.f53223a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                jH = Math.multiplyExact(jH, 86400000000000L);
                break;
            case 2:
                jH = Math.multiplyExact(jH, 86400000000L);
                break;
            case 3:
                jH = Math.multiplyExact(jH, DateUtils.MILLIS_PER_DAY);
                break;
            case 4:
                jH = Math.multiplyExact(jH, MMKV.ExpireInDay);
                break;
            case 5:
                jH = Math.multiplyExact(jH, 1440);
                break;
            case 6:
                jH = Math.multiplyExact(jH, 24);
                break;
            case 7:
                jH = Math.multiplyExact(jH, 2);
                break;
        }
        return Math.addExact(jH, localTime.n(chronoLocalDateTimeA0.o(), temporalUnit));
    }

    private Object writeReplace() {
        return new D((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoLocalDateTime) && compareTo((ChronoLocalDateTime) obj) == 0;
    }

    public final int hashCode() {
        return this.f53224a.hashCode() ^ this.f53225b.hashCode();
    }

    public final String toString() {
        return this.f53224a.toString() + "T" + this.f53225b.toString();
    }
}
