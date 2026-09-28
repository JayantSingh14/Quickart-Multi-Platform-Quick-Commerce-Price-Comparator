package j$.time;

import com.tencent.mmkv.MMKV;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.ChronoLocalDateTime;
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
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public final class LocalDate implements Temporal, j$.time.temporal.l, ChronoLocalDate, Serializable {
    private static final long serialVersionUID = 2942565459149668126L;

    /* renamed from: a, reason: collision with root package name */
    public final int f53181a;

    /* renamed from: b, reason: collision with root package name */
    public final short f53182b;

    /* renamed from: c, reason: collision with root package name */
    public final short f53183c;
    public static final LocalDate MIN = of(-999999999, 1, 1);
    public static final LocalDate MAX = of(999999999, 12, 31);

    static {
        of(1970, 1, 1);
    }

    public static LocalDate g0(a aVar) {
        Instant instant = aVar.instant();
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(aVar.f53208a, "zone");
        return ofEpochDay(Math.floorDiv(instant.getEpochSecond() + r4.getRules().d(instant).getTotalSeconds(), MMKV.ExpireInDay));
    }

    public static LocalDate of(int i2, int i3, int i4) {
        j$.time.temporal.a.YEAR.c0(i2);
        j$.time.temporal.a.MONTH_OF_YEAR.c0(i3);
        j$.time.temporal.a.DAY_OF_MONTH.c0(i4);
        return A(i2, i3, i4);
    }

    public static LocalDate h0(int i2, int i3) {
        long j2 = i2;
        j$.time.temporal.a.YEAR.c0(j2);
        j$.time.temporal.a.DAY_OF_YEAR.c0(i3);
        boolean zC = j$.time.chrono.r.f53253c.C(j2);
        if (i3 == 366 && !zC) {
            throw new DateTimeException("Invalid date 'DayOfYear 366' as '" + i2 + "' is not a leap year");
        }
        Month monthK = Month.K(((i3 - 1) / 31) + 1);
        if (i3 > (monthK.A(zC) + monthK.s(zC)) - 1) {
            monthK = Month.f53192a[((((int) 1) + 12) + monthK.ordinal()) % 12];
        }
        return new LocalDate(i2, monthK.q(), (i3 - monthK.s(zC)) + 1);
    }

    public static LocalDate ofEpochDay(long j2) {
        long j3;
        j$.time.temporal.a.EPOCH_DAY.c0(j2);
        long j4 = 719468 + j2;
        if (j4 < 0) {
            long j5 = ((j2 + 719469) / 146097) - 1;
            j3 = j5 * 400;
            j4 += (-j5) * 146097;
        } else {
            j3 = 0;
        }
        long j6 = ((j4 * 400) + 591) / 146097;
        long j7 = j4 - ((j6 / 400) + (((j6 / 4) + (j6 * 365)) - (j6 / 100)));
        if (j7 < 0) {
            j6--;
            j7 = j4 - ((j6 / 400) + (((j6 / 4) + (365 * j6)) - (j6 / 100)));
        }
        int i2 = (int) j7;
        int i3 = ((i2 * 5) + 2) / 153;
        int i4 = ((i3 + 2) % 12) + 1;
        int i5 = (i2 - (((i3 * 306) + 5) / 10)) + 1;
        long j8 = j6 + j3 + (i3 / 10);
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return new LocalDate(aVar.f53410b.a(j8, aVar), i4, i5);
    }

    public static LocalDate J(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        LocalDate localDate = (LocalDate) temporalAccessor.e(j$.time.temporal.o.f53433f);
        if (localDate != null) {
            return localDate;
        }
        throw new DateTimeException("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    public static LocalDate parse(CharSequence charSequence) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDate) dateTimeFormatter.parse(charSequence, new f(0));
    }

    public static LocalDate A(int i2, int i3, int i4) {
        int i5 = 28;
        if (i4 > 28) {
            if (i3 != 2) {
                i5 = (i3 == 4 || i3 == 6 || i3 == 9 || i3 == 11) ? 30 : 31;
            } else if (j$.time.chrono.r.f53253c.C(i2)) {
                i5 = 29;
            }
            if (i4 > i5) {
                if (i4 == 29) {
                    throw new DateTimeException("Invalid date 'February 29' as '" + i2 + "' is not a leap year");
                }
                throw new DateTimeException("Invalid date '" + Month.K(i3).name() + StringUtils.SPACE + i4 + "'");
            }
        }
        return new LocalDate(i2, i3, i4);
    }

    public static LocalDate n0(int i2, int i3, int i4) {
        if (i3 == 2) {
            i4 = Math.min(i4, j$.time.chrono.r.f53253c.C((long) i2) ? 29 : 28);
        } else if (i3 == 4 || i3 == 6 || i3 == 9 || i3 == 11) {
            i4 = Math.min(i4, 30);
        }
        return new LocalDate(i2, i3, i4);
    }

    public LocalDate(int i2, int i3, int i4) {
        this.f53181a = i2;
        this.f53182b = (short) i3;
        this.f53183c = (short) i4;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.q l(j$.time.temporal.n nVar) {
        if (!(nVar instanceof j$.time.temporal.a)) {
            return nVar.K(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) nVar;
        if (!aVar.X()) {
            throw new j$.time.temporal.p(b.a("Unsupported field: ", nVar));
        }
        int i2 = g.f53378a[aVar.ordinal()];
        if (i2 == 1) {
            return j$.time.temporal.q.f(1L, d0());
        }
        if (i2 == 2) {
            return j$.time.temporal.q.f(1L, L());
        }
        if (i2 != 3) {
            return i2 != 4 ? ((j$.time.temporal.a) nVar).f53410b : getYear() <= 0 ? j$.time.temporal.q.f(1L, 1000000000L) : j$.time.temporal.q.f(1L, 999999999L);
        }
        return j$.time.temporal.q.f(1L, (getMonth() != Month.FEBRUARY || R()) ? 5L : 4L);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final int j(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            return K(nVar);
        }
        return super.j(nVar);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long h(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            if (nVar == j$.time.temporal.a.EPOCH_DAY) {
                return toEpochDay();
            }
            if (nVar == j$.time.temporal.a.PROLEPTIC_MONTH) {
                return Z();
            }
            return K(nVar);
        }
        return nVar.s(this);
    }

    public final int K(j$.time.temporal.n nVar) {
        int i2;
        int i3 = g.f53378a[((j$.time.temporal.a) nVar).ordinal()];
        short s = this.f53183c;
        int i4 = this.f53181a;
        switch (i3) {
            case 1:
                return s;
            case 2:
                return X();
            case 3:
                i2 = (s - 1) / 7;
                break;
            case 4:
                return i4 >= 1 ? i4 : 1 - i4;
            case 5:
                return getDayOfWeek().q();
            case 6:
                i2 = (s - 1) % 7;
                break;
            case 7:
                return ((X() - 1) % 7) + 1;
            case 8:
                throw new j$.time.temporal.p("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((X() - 1) / 7) + 1;
            case 10:
                return this.f53182b;
            case 11:
                throw new j$.time.temporal.p("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return i4;
            case 13:
                return i4 >= 1 ? 1 : 0;
            default:
                throw new j$.time.temporal.p(b.a("Unsupported field: ", nVar));
        }
        return i2 + 1;
    }

    public final long Z() {
        return ((this.f53181a * 12) + this.f53182b) - 1;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final j$.time.chrono.k i() {
        return j$.time.chrono.r.f53253c;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final j$.time.chrono.l u() {
        return getYear() >= 1 ? j$.time.chrono.s.CE : j$.time.chrono.s.BCE;
    }

    public int getYear() {
        return this.f53181a;
    }

    public int getMonthValue() {
        return this.f53182b;
    }

    public Month getMonth() {
        return Month.K(this.f53182b);
    }

    public int getDayOfMonth() {
        return this.f53183c;
    }

    public final int X() {
        return (getMonth().s(R()) + this.f53183c) - 1;
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.s(((int) Math.floorMod(toEpochDay() + 3, 7)) + 1);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final boolean R() {
        return j$.time.chrono.r.f53253c.C(this.f53181a);
    }

    public final int d0() {
        short s = this.f53182b;
        return s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : R() ? 29 : 28;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final int L() {
        return R() ? 366 : 365;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    /* renamed from: p0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final LocalDate m(j$.time.temporal.l lVar) {
        if (lVar instanceof LocalDate) {
            return (LocalDate) lVar;
        }
        return (LocalDate) lVar.f(this);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public final LocalDate a(long j2, j$.time.temporal.n nVar) {
        if (!(nVar instanceof j$.time.temporal.a)) {
            return (LocalDate) nVar.q(this, j2);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) nVar;
        aVar.c0(j2);
        int i2 = g.f53378a[aVar.ordinal()];
        int i3 = this.f53181a;
        short s = this.f53183c;
        short s2 = this.f53182b;
        switch (i2) {
            case 1:
                int i4 = (int) j2;
                if (s != i4) {
                    return of(i3, s2, i4);
                }
                return this;
            case 2:
                int i5 = (int) j2;
                if (X() != i5) {
                    return h0(i3, i5);
                }
                return this;
            case 3:
                return l0(j2 - h(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH));
            case 4:
                if (i3 < 1) {
                    j2 = 1 - j2;
                }
                return q0((int) j2);
            case 5:
                return j0(j2 - getDayOfWeek().q());
            case 6:
                return j0(j2 - h(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return j0(j2 - h(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return ofEpochDay(j2);
            case 9:
                return l0(j2 - h(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR));
            case 10:
                int i6 = (int) j2;
                if (s2 != i6) {
                    j$.time.temporal.a.MONTH_OF_YEAR.c0(i6);
                    return n0(i3, i6, s);
                }
                return this;
            case 11:
                return k0(j2 - Z());
            case 12:
                return q0((int) j2);
            case 13:
                if (h(j$.time.temporal.a.ERA) != j2) {
                    return q0(1 - i3);
                }
                return this;
            default:
                throw new j$.time.temporal.p(b.a("Unsupported field: ", nVar));
        }
    }

    public final LocalDate q0(int i2) {
        if (this.f53181a == i2) {
            return this;
        }
        j$.time.temporal.a.YEAR.c0(i2);
        return n0(i2, this.f53182b, this.f53183c);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDate Q(TemporalAmount temporalAmount) {
        if (temporalAmount != null) {
            p pVar = (p) temporalAmount;
            return k0((pVar.f53394a * 12) + pVar.f53395b).j0(pVar.f53396c);
        }
        Objects.requireNonNull(temporalAmount, "amountToAdd");
        return (LocalDate) ((p) temporalAmount).q(this);
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public final LocalDate c(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDate) temporalUnit.q(this, j2);
        }
        switch (g.f53379b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return j0(j2);
            case 2:
                return l0(j2);
            case 3:
                return k0(j2);
            case 4:
                return m0(j2);
            case 5:
                return m0(Math.multiplyExact(j2, 10));
            case 6:
                return m0(Math.multiplyExact(j2, 100));
            case 7:
                return m0(Math.multiplyExact(j2, 1000));
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return a(Math.addExact(h(aVar), j2), aVar);
            default:
                throw new j$.time.temporal.p("Unsupported unit: " + temporalUnit);
        }
    }

    public final LocalDate m0(long j2) {
        if (j2 == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return n0(aVar.f53410b.a(this.f53181a + j2, aVar), this.f53182b, this.f53183c);
    }

    public final LocalDate k0(long j2) {
        if (j2 == 0) {
            return this;
        }
        long j3 = (this.f53181a * 12) + (this.f53182b - 1) + j2;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        long j4 = 12;
        return n0(aVar.f53410b.a(Math.floorDiv(j3, j4), aVar), ((int) Math.floorMod(j3, j4)) + 1, this.f53183c);
    }

    public final LocalDate l0(long j2) {
        return j0(Math.multiplyExact(j2, 7));
    }

    public final LocalDate j0(long j2) {
        if (j2 == 0) {
            return this;
        }
        long j3 = this.f53183c + j2;
        if (j3 > 0) {
            short s = this.f53182b;
            int i2 = this.f53181a;
            if (j3 <= 28) {
                return new LocalDate(i2, s, (int) j3);
            }
            if (j3 <= 59) {
                long jD0 = d0();
                if (j3 <= jD0) {
                    return new LocalDate(i2, s, (int) j3);
                }
                if (s < 12) {
                    return new LocalDate(i2, s + 1, (int) (j3 - jD0));
                }
                int i3 = i2 + 1;
                j$.time.temporal.a.YEAR.c0(i3);
                return new LocalDate(i3, 1, (int) (j3 - jD0));
            }
        }
        return ofEpochDay(Math.addExact(toEpochDay(), j2));
    }

    @Override // j$.time.temporal.Temporal
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public final LocalDate d(long j2, ChronoUnit chronoUnit) {
        return j2 == Long.MIN_VALUE ? c(Long.MAX_VALUE, chronoUnit).c(1L, chronoUnit) : c(-j2, chronoUnit);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object e(TemporalQuery temporalQuery) {
        return temporalQuery == j$.time.temporal.o.f53433f ? this : super.e(temporalQuery);
    }

    @Override // j$.time.temporal.Temporal
    public final long n(Temporal temporal, TemporalUnit temporalUnit) {
        LocalDate localDateJ = J(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.s(this, localDateJ);
        }
        switch (g.f53379b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return localDateJ.toEpochDay() - toEpochDay();
            case 2:
                return (localDateJ.toEpochDay() - toEpochDay()) / 7;
            case 3:
                return f0(localDateJ);
            case 4:
                return f0(localDateJ) / 12;
            case 5:
                return f0(localDateJ) / 120;
            case 6:
                return f0(localDateJ) / 1200;
            case 7:
                return f0(localDateJ) / 12000;
            case 8:
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return localDateJ.h(aVar) - h(aVar);
            default:
                throw new j$.time.temporal.p("Unsupported unit: " + temporalUnit);
        }
    }

    public final long f0(LocalDate localDate) {
        return (((localDate.Z() * 32) + localDate.getDayOfMonth()) - ((Z() * 32) + getDayOfMonth())) / 32;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDateTime M(LocalTime localTime) {
        return LocalDateTime.of(this, localTime);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public long toEpochDay() {
        long j2 = this.f53181a;
        long j3 = this.f53182b;
        long j4 = 365 * j2;
        long j5 = (((367 * j3) - 362) / 12) + (j2 >= 0 ? ((j2 + 399) / 400) + (((3 + j2) / 4) - ((99 + j2) / 100)) + j4 : j4 - ((j2 / (-400)) + ((j2 / (-4)) - (j2 / (-100))))) + (this.f53183c - 1);
        if (j3 > 2) {
            j5 = !R() ? j5 - 2 : j5 - 1;
        }
        return j5 - 719528;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // j$.time.chrono.ChronoLocalDate, java.lang.Comparable
    public int compareTo(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return s((LocalDate) chronoLocalDate);
        }
        return super.compareTo(chronoLocalDate);
    }

    public final int s(LocalDate localDate) {
        int i2 = this.f53181a - localDate.f53181a;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.f53182b - localDate.f53182b;
        return i3 == 0 ? this.f53183c - localDate.f53183c : i3;
    }

    public final boolean c0(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? s((LocalDate) chronoLocalDate) < 0 : toEpochDay() < chronoLocalDate.toEpochDay();
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalDate) && s((LocalDate) obj) == 0;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public int hashCode() {
        int i2 = this.f53181a;
        return (((i2 << 11) + (this.f53182b << 6)) + this.f53183c) ^ (i2 & (-2048));
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public String toString() {
        int i2 = this.f53181a;
        int iAbs = Math.abs(i2);
        StringBuilder sb = new StringBuilder(10);
        if (iAbs >= 1000) {
            if (i2 > 9999) {
                sb.append('+');
            }
            sb.append(i2);
        } else if (i2 < 0) {
            sb.append(i2 - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i2 + 10000);
            sb.deleteCharAt(0);
        }
        short s = this.f53182b;
        sb.append(s < 10 ? "-0" : "-");
        sb.append((int) s);
        short s2 = this.f53183c;
        sb.append(s2 < 10 ? "-0" : "-");
        sb.append((int) s2);
        return sb.toString();
    }

    private Object writeReplace() {
        return new q((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
