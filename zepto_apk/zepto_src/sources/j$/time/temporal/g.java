package j$.time.temporal;

import j$.time.DateTimeException;
import j$.time.DayOfWeek;
import j$.time.LocalDate;
import j$.time.format.B;
import j$.time.format.C;
import java.util.HashMap;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public abstract class g implements n {
    public static final g DAY_OF_QUARTER;
    public static final g QUARTER_OF_YEAR;
    public static final g WEEK_BASED_YEAR;
    public static final g WEEK_OF_WEEK_BASED_YEAR;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f53412a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ g[] f53413b;

    @Override // j$.time.temporal.n
    public final boolean X() {
        return true;
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) f53413b.clone();
    }

    static {
        g gVar = new g() { // from class: j$.time.temporal.c
            @Override // j$.time.temporal.n
            public final q A() {
                return q.g(1L, 90L, 92L);
            }

            @Override // j$.time.temporal.n
            public final boolean Z(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.g(a.DAY_OF_YEAR) || !temporalAccessor.g(a.MONTH_OF_YEAR) || !temporalAccessor.g(a.YEAR)) {
                    return false;
                }
                g gVar2 = i.f53417a;
                return j$.time.chrono.k.E(temporalAccessor).equals(j$.time.chrono.r.f53253c);
            }

            @Override // j$.time.temporal.n
            public final q K(TemporalAccessor temporalAccessor) {
                if (!Z(temporalAccessor)) {
                    throw new p("Unsupported field: DayOfQuarter");
                }
                long jH = temporalAccessor.h(g.QUARTER_OF_YEAR);
                if (jH == 1) {
                    return j$.time.chrono.r.f53253c.C(temporalAccessor.h(a.YEAR)) ? q.f(1L, 91L) : q.f(1L, 90L);
                }
                if (jH == 2) {
                    return q.f(1L, 91L);
                }
                if (jH == 3 || jH == 4) {
                    return q.f(1L, 92L);
                }
                return A();
            }

            @Override // j$.time.temporal.n
            public final long s(TemporalAccessor temporalAccessor) {
                if (!Z(temporalAccessor)) {
                    throw new p("Unsupported field: DayOfQuarter");
                }
                return temporalAccessor.j(a.DAY_OF_YEAR) - g.f53412a[((temporalAccessor.j(a.MONTH_OF_YEAR) - 1) / 3) + (j$.time.chrono.r.f53253c.C(temporalAccessor.h(a.YEAR)) ? 4 : 0)];
            }

            @Override // j$.time.temporal.n
            public final Temporal q(Temporal temporal, long j2) {
                long jS = s(temporal);
                A().b(j2, this);
                a aVar = a.DAY_OF_YEAR;
                return temporal.a((j2 - jS) + temporal.h(aVar), aVar);
            }

            @Override // j$.time.temporal.n
            public final TemporalAccessor J(HashMap map, B b2, C c2) {
                long jSubtractExact;
                LocalDate localDateK0;
                a aVar = a.YEAR;
                Long l2 = (Long) map.get(aVar);
                n nVar = g.QUARTER_OF_YEAR;
                Long l3 = (Long) map.get(nVar);
                if (l2 == null || l3 == null) {
                    return null;
                }
                int iA = aVar.f53410b.a(l2.longValue(), aVar);
                long jLongValue = ((Long) map.get(g.DAY_OF_QUARTER)).longValue();
                g gVar2 = i.f53417a;
                if (!j$.time.chrono.k.E(b2).equals(j$.time.chrono.r.f53253c)) {
                    throw new DateTimeException("Resolve requires IsoChronology");
                }
                if (c2 == C.LENIENT) {
                    localDateK0 = LocalDate.of(iA, 1, 1).k0(Math.multiplyExact(Math.subtractExact(l3.longValue(), 1L), 3));
                    jSubtractExact = Math.subtractExact(jLongValue, 1L);
                } else {
                    LocalDate localDateOf = LocalDate.of(iA, ((nVar.A().a(l3.longValue(), nVar) - 1) * 3) + 1, 1);
                    if (jLongValue < 1 || jLongValue > 90) {
                        if (c2 == C.STRICT) {
                            K(localDateOf).b(jLongValue, this);
                        } else {
                            A().b(jLongValue, this);
                        }
                    }
                    jSubtractExact = jLongValue - 1;
                    localDateK0 = localDateOf;
                }
                map.remove(this);
                map.remove(aVar);
                map.remove(nVar);
                return localDateK0.j0(jSubtractExact);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "DayOfQuarter";
            }
        };
        DAY_OF_QUARTER = gVar;
        g gVar2 = new g() { // from class: j$.time.temporal.d
            @Override // j$.time.temporal.n
            public final q A() {
                return q.f(1L, 4L);
            }

            @Override // j$.time.temporal.n
            public final boolean Z(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.g(a.MONTH_OF_YEAR)) {
                    return false;
                }
                g gVar3 = i.f53417a;
                return j$.time.chrono.k.E(temporalAccessor).equals(j$.time.chrono.r.f53253c);
            }

            @Override // j$.time.temporal.n
            public final long s(TemporalAccessor temporalAccessor) {
                if (!Z(temporalAccessor)) {
                    throw new p("Unsupported field: QuarterOfYear");
                }
                return (temporalAccessor.h(a.MONTH_OF_YEAR) + 2) / 3;
            }

            @Override // j$.time.temporal.n
            public final q K(TemporalAccessor temporalAccessor) {
                if (!Z(temporalAccessor)) {
                    throw new p("Unsupported field: QuarterOfYear");
                }
                return A();
            }

            @Override // j$.time.temporal.n
            public final Temporal q(Temporal temporal, long j2) {
                long jS = s(temporal);
                A().b(j2, this);
                a aVar = a.MONTH_OF_YEAR;
                return temporal.a(((j2 - jS) * 3) + temporal.h(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "QuarterOfYear";
            }
        };
        QUARTER_OF_YEAR = gVar2;
        g gVar3 = new g() { // from class: j$.time.temporal.e
            @Override // j$.time.temporal.n
            public final q A() {
                return q.g(1L, 52L, 53L);
            }

            @Override // j$.time.temporal.n
            public final boolean Z(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.g(a.EPOCH_DAY)) {
                    return false;
                }
                g gVar4 = i.f53417a;
                return j$.time.chrono.k.E(temporalAccessor).equals(j$.time.chrono.r.f53253c);
            }

            @Override // j$.time.temporal.n
            public final q K(TemporalAccessor temporalAccessor) {
                if (Z(temporalAccessor)) {
                    return g.f0(LocalDate.J(temporalAccessor));
                }
                throw new p("Unsupported field: WeekOfWeekBasedYear");
            }

            @Override // j$.time.temporal.n
            public final long s(TemporalAccessor temporalAccessor) {
                if (!Z(temporalAccessor)) {
                    throw new p("Unsupported field: WeekOfWeekBasedYear");
                }
                return g.c0(LocalDate.J(temporalAccessor));
            }

            @Override // j$.time.temporal.n
            public final Temporal q(Temporal temporal, long j2) {
                A().b(j2, this);
                return temporal.c(Math.subtractExact(j2, s(temporal)), ChronoUnit.WEEKS);
            }

            @Override // j$.time.temporal.n
            public final TemporalAccessor J(HashMap map, B b2, C c2) {
                LocalDate localDateA;
                long j2;
                long j3;
                n nVar = g.WEEK_BASED_YEAR;
                Long l2 = (Long) map.get(nVar);
                a aVar = a.DAY_OF_WEEK;
                Long l3 = (Long) map.get(aVar);
                if (l2 == null || l3 == null) {
                    return null;
                }
                int iA = nVar.A().a(l2.longValue(), nVar);
                long jLongValue = ((Long) map.get(g.WEEK_OF_WEEK_BASED_YEAR)).longValue();
                g gVar4 = i.f53417a;
                if (!j$.time.chrono.k.E(b2).equals(j$.time.chrono.r.f53253c)) {
                    throw new DateTimeException("Resolve requires IsoChronology");
                }
                LocalDate localDateOf = LocalDate.of(iA, 1, 4);
                if (c2 == C.LENIENT) {
                    long jLongValue2 = l3.longValue();
                    if (jLongValue2 > 7) {
                        long j4 = jLongValue2 - 1;
                        j2 = 1;
                        localDateOf = localDateOf.l0(j4 / 7);
                        j3 = j4 % 7;
                    } else {
                        j2 = 1;
                        if (jLongValue2 < 1) {
                            localDateOf = localDateOf.l0(Math.subtractExact(jLongValue2, 7L) / 7);
                            j3 = (jLongValue2 + 6) % 7;
                        }
                        localDateA = localDateOf.l0(Math.subtractExact(jLongValue, j2)).a(jLongValue2, aVar);
                    }
                    jLongValue2 = j3 + j2;
                    localDateA = localDateOf.l0(Math.subtractExact(jLongValue, j2)).a(jLongValue2, aVar);
                } else {
                    int iA2 = aVar.f53410b.a(l3.longValue(), aVar);
                    if (jLongValue < 1 || jLongValue > 52) {
                        if (c2 == C.STRICT) {
                            g.f0(localDateOf).b(jLongValue, this);
                        } else {
                            A().b(jLongValue, this);
                        }
                    }
                    localDateA = localDateOf.l0(jLongValue - 1).a(iA2, aVar);
                }
                map.remove(this);
                map.remove(nVar);
                map.remove(aVar);
                return localDateA;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekOfWeekBasedYear";
            }
        };
        WEEK_OF_WEEK_BASED_YEAR = gVar3;
        g gVar4 = new g() { // from class: j$.time.temporal.f
            @Override // j$.time.temporal.n
            public final q A() {
                return a.YEAR.f53410b;
            }

            @Override // j$.time.temporal.n
            public final boolean Z(TemporalAccessor temporalAccessor) {
                if (!temporalAccessor.g(a.EPOCH_DAY)) {
                    return false;
                }
                g gVar5 = i.f53417a;
                return j$.time.chrono.k.E(temporalAccessor).equals(j$.time.chrono.r.f53253c);
            }

            @Override // j$.time.temporal.n
            public final long s(TemporalAccessor temporalAccessor) {
                if (Z(temporalAccessor)) {
                    return g.d0(LocalDate.J(temporalAccessor));
                }
                throw new p("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.n
            public final q K(TemporalAccessor temporalAccessor) {
                if (!Z(temporalAccessor)) {
                    throw new p("Unsupported field: WeekBasedYear");
                }
                return A();
            }

            @Override // j$.time.temporal.n
            public final Temporal q(Temporal temporal, long j2) {
                if (!Z(temporal)) {
                    throw new p("Unsupported field: WeekBasedYear");
                }
                int iA = a.YEAR.f53410b.a(j2, g.WEEK_BASED_YEAR);
                LocalDate localDateJ = LocalDate.J(temporal);
                int iJ = localDateJ.j(a.DAY_OF_WEEK);
                int iC0 = g.c0(localDateJ);
                if (iC0 == 53 && g.e0(iA) == 52) {
                    iC0 = 52;
                }
                return temporal.m(LocalDate.of(iA, 1, 4).j0(((iC0 - 1) * 7) + (iJ - r6.j(r0))));
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }
        };
        WEEK_BASED_YEAR = gVar4;
        f53413b = new g[]{gVar, gVar2, gVar3, gVar4};
        f53412a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    public static q f0(LocalDate localDate) {
        return q.f(1L, e0(d0(localDate)));
    }

    public static int e0(int i2) {
        LocalDate localDateOf = LocalDate.of(i2, 1, 1);
        if (localDateOf.getDayOfWeek() != DayOfWeek.THURSDAY) {
            return (localDateOf.getDayOfWeek() == DayOfWeek.WEDNESDAY && localDateOf.R()) ? 53 : 52;
        }
        return 53;
    }

    public static int c0(LocalDate localDate) {
        int iOrdinal = localDate.getDayOfWeek().ordinal();
        int iX = localDate.X() - 1;
        int i2 = (3 - iOrdinal) + iX;
        int i3 = i2 - ((i2 / 7) * 7);
        int i4 = i3 - 3;
        if (i4 < -3) {
            i4 = i3 + 4;
        }
        if (iX >= i4) {
            int i5 = ((iX - i4) / 7) + 1;
            if (i5 != 53 || i4 == -3 || (i4 == -2 && localDate.R())) {
                return i5;
            }
            return 1;
        }
        if (localDate.X() != 180) {
            localDate = LocalDate.h0(localDate.f53181a, 180);
        }
        return (int) f0(localDate.m0(-1L)).f53438d;
    }

    public static int d0(LocalDate localDate) {
        int year = localDate.getYear();
        int iX = localDate.X();
        if (iX <= 3) {
            return iX - localDate.getDayOfWeek().ordinal() < -2 ? year - 1 : year;
        }
        if (iX >= 363) {
            return ((iX - 363) - (localDate.R() ? 1 : 0)) - localDate.getDayOfWeek().ordinal() >= 0 ? year + 1 : year;
        }
        return year;
    }
}
