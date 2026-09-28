package j$.time;

import com.tencent.mmkv.MMKV;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.chrono.InterfaceC0116h;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang3.time.DateUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes2.dex */
public final class LocalDateTime implements Temporal, j$.time.temporal.l, ChronoLocalDateTime<LocalDate>, Serializable {
    private static final long serialVersionUID = 6207766400415563566L;

    /* renamed from: a, reason: collision with root package name */
    public final LocalDate f53184a;

    /* renamed from: b, reason: collision with root package name */
    public final LocalTime f53185b;
    public static final LocalDateTime MIN = of(LocalDate.MIN, LocalTime.MIN);
    public static final LocalDateTime MAX = of(LocalDate.MAX, LocalTime.MAX);

    @Override // j$.time.temporal.Temporal
    public final Temporal d(long j2, TemporalUnit temporalUnit) {
        ChronoUnit chronoUnit = (ChronoUnit) temporalUnit;
        return j2 == Long.MIN_VALUE ? c(Long.MAX_VALUE, chronoUnit).c(1L, chronoUnit) : c(-j2, chronoUnit);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final InterfaceC0116h H(ZoneId zoneId) {
        return ZonedDateTime.J(this, zoneId, null);
    }

    public static LocalDateTime of(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return new LocalDateTime(LocalDate.of(i2, i3, i4), LocalTime.of(i5, i6, i7, i8));
    }

    public static LocalDateTime of(LocalDate localDate, LocalTime localTime) {
        Objects.requireNonNull(localDate, CLConstants.SHARED_PREFERENCE_ITEM_DATE);
        Objects.requireNonNull(localTime, "time");
        return new LocalDateTime(localDate, localTime);
    }

    public static LocalDateTime K(long j2, int i2, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        long j3 = i2;
        j$.time.temporal.a.NANO_OF_SECOND.c0(j3);
        return new LocalDateTime(LocalDate.ofEpochDay(Math.floorDiv(j2 + zoneOffset.getTotalSeconds(), MMKV.ExpireInDay)), LocalTime.K((((int) Math.floorMod(r5, r7)) * 1000000000) + j3));
    }

    public static LocalDateTime A(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (!(temporalAccessor instanceof ZonedDateTime)) {
            if (temporalAccessor instanceof OffsetDateTime) {
                return ((OffsetDateTime) temporalAccessor).toLocalDateTime();
            }
            try {
                return new LocalDateTime(LocalDate.J(temporalAccessor), LocalTime.A(temporalAccessor));
            } catch (DateTimeException e2) {
                throw new DateTimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e2);
            }
        }
        return ((ZonedDateTime) temporalAccessor).f53204a;
    }

    public static LocalDateTime parse(CharSequence charSequence) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.f53284h;
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDateTime) dateTimeFormatter.parse(charSequence, new f(1));
    }

    public LocalDateTime(LocalDate localDate, LocalTime localTime) {
        this.f53184a = localDate;
        this.f53185b = localTime;
    }

    public final LocalDateTime f0(LocalDate localDate, LocalTime localTime) {
        return (this.f53184a == localDate && this.f53185b == localTime) ? this : new LocalDateTime(localDate, localTime);
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
            return ((j$.time.temporal.a) nVar).d0() ? this.f53185b.l(nVar) : this.f53184a.l(nVar);
        }
        return nVar.K(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int j(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) nVar).d0() ? this.f53185b.j(nVar) : this.f53184a.j(nVar);
        }
        return super.j(nVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long h(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) nVar).d0() ? this.f53185b.h(nVar) : this.f53184a.h(nVar);
        }
        return nVar.s(this);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final ChronoLocalDate p() {
        return this.f53184a;
    }

    public final int s(LocalDateTime localDateTime) {
        int iS = this.f53184a.s(localDateTime.f53184a);
        return iS == 0 ? this.f53185b.compareTo(localDateTime.f53185b) : iS;
    }

    public int getYear() {
        return this.f53184a.getYear();
    }

    public int getMonthValue() {
        return this.f53184a.getMonthValue();
    }

    public int getDayOfMonth() {
        return this.f53184a.getDayOfMonth();
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public final LocalTime o() {
        return this.f53185b;
    }

    public int getHour() {
        return this.f53185b.getHour();
    }

    public int getMinute() {
        return this.f53185b.getMinute();
    }

    public int getSecond() {
        return this.f53185b.getSecond();
    }

    public int getNano() {
        return this.f53185b.getNano();
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime m(LocalDate localDate) {
        if (localDate != null) {
            return f0(localDate, this.f53185b);
        }
        return (LocalDateTime) localDate.f(this);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime a(long j2, j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            boolean zD0 = ((j$.time.temporal.a) nVar).d0();
            LocalTime localTime = this.f53185b;
            LocalDate localDate = this.f53184a;
            if (zD0) {
                return f0(localDate, localTime.a(j2, nVar));
            }
            return f0(localDate.a(j2, nVar), localTime);
        }
        return (LocalDateTime) nVar.q(this, j2);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime c(long j2, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            int i2 = h.f53380a[((ChronoUnit) temporalUnit).ordinal()];
            LocalTime localTime = this.f53185b;
            LocalDate localDate = this.f53184a;
            switch (i2) {
                case 1:
                    return c0(this.f53184a, 0L, 0L, 0L, j2);
                case 2:
                    LocalDateTime localDateTimeF0 = f0(localDate.j0(j2 / 86400000000L), localTime);
                    return localDateTimeF0.c0(localDateTimeF0.f53184a, 0L, 0L, 0L, (j2 % 86400000000L) * 1000);
                case 3:
                    LocalDateTime localDateTimeF02 = f0(localDate.j0(j2 / DateUtils.MILLIS_PER_DAY), localTime);
                    return localDateTimeF02.c0(localDateTimeF02.f53184a, 0L, 0L, 0L, (j2 % DateUtils.MILLIS_PER_DAY) * 1000000);
                case 4:
                    return Z(j2);
                case 5:
                    return c0(this.f53184a, 0L, j2, 0L, 0L);
                case 6:
                    return c0(this.f53184a, j2, 0L, 0L, 0L);
                case 7:
                    LocalDateTime localDateTimeF03 = f0(localDate.j0(j2 / 256), localTime);
                    return localDateTimeF03.c0(localDateTimeF03.f53184a, (j2 % 256) * 12, 0L, 0L, 0L);
                default:
                    return f0(localDate.c(j2, temporalUnit), localTime);
            }
        }
        return (LocalDateTime) temporalUnit.q(this, j2);
    }

    public final LocalDateTime Z(long j2) {
        return c0(this.f53184a, 0L, 0L, j2, 0L);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    /* renamed from: k */
    public final ChronoLocalDateTime d(long j2, ChronoUnit chronoUnit) {
        return j2 == Long.MIN_VALUE ? c(Long.MAX_VALUE, chronoUnit).c(1L, chronoUnit) : c(-j2, chronoUnit);
    }

    public final LocalDateTime c0(LocalDate localDate, long j2, long j3, long j4, long j5) {
        long j6 = j2 | j3 | j4 | j5;
        LocalTime localTimeK = this.f53185b;
        if (j6 == 0) {
            return f0(localDate, localTimeK);
        }
        long j7 = j2 / 24;
        long j8 = j7 + (j3 / 1440) + (j4 / 86400) + (j5 / 86400000000000L);
        long j9 = 1;
        long j10 = ((j2 % 24) * 3600000000000L) + ((j3 % 1440) * 60000000000L) + ((j4 % 86400) * 1000000000) + (j5 % 86400000000000L);
        long jG0 = localTimeK.g0();
        long j11 = (j10 * j9) + jG0;
        long jFloorDiv = Math.floorDiv(j11, 86400000000000L) + (j8 * j9);
        long jFloorMod = Math.floorMod(j11, 86400000000000L);
        if (jFloorMod != jG0) {
            localTimeK = LocalTime.K(jFloorMod);
        }
        return f0(localDate.j0(jFloorDiv), localTimeK);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.o.f53433f) {
            return this.f53184a;
        }
        return super.e(temporalQuery);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00dd  */
    @Override // j$.time.temporal.Temporal
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long n(j$.time.temporal.Temporal r10, j$.time.temporal.TemporalUnit r11) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.LocalDateTime.n(j$.time.temporal.Temporal, j$.time.temporal.TemporalUnit):long");
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // j$.time.chrono.ChronoLocalDateTime, java.lang.Comparable
    public int compareTo(ChronoLocalDateTime<?> chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return s((LocalDateTime) chronoLocalDateTime);
        }
        return super.compareTo((ChronoLocalDateTime) chronoLocalDateTime);
    }

    public final boolean J(ChronoLocalDateTime chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return s((LocalDateTime) chronoLocalDateTime) < 0;
        }
        long epochDay = this.f53184a.toEpochDay();
        long epochDay2 = chronoLocalDateTime.p().toEpochDay();
        if (epochDay >= epochDay2) {
            return epochDay == epochDay2 && this.f53185b.g0() < chronoLocalDateTime.o().g0();
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            if (this.f53184a.equals(localDateTime.f53184a) && this.f53185b.equals(localDateTime.f53185b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f53184a.hashCode() ^ this.f53185b.hashCode();
    }

    public String toString() {
        return this.f53184a.toString() + "T" + this.f53185b.toString();
    }

    private Object writeReplace() {
        return new q((byte) 5, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
