package j$.time.chrono;

import j$.time.DateTimeException;
import j$.time.DayOfWeek;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalUnit;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;

/* renamed from: j$.time.chrono.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0109a implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f53220a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f53221b = new ConcurrentHashMap();

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return getId().compareTo(((k) obj).getId());
    }

    static {
        new Locale("ja", "JP", "JP");
    }

    public static k s(AbstractC0109a abstractC0109a, String str) {
        String strW;
        k kVar = (k) f53220a.putIfAbsent(str, abstractC0109a);
        if (kVar == null && (strW = abstractC0109a.W()) != null) {
            f53221b.putIfAbsent(strW, abstractC0109a);
        }
        return kVar;
    }

    @Override // j$.time.chrono.k
    public ChronoLocalDate U(Map map, j$.time.format.C c2) {
        j$.time.temporal.a aVar = j$.time.temporal.a.EPOCH_DAY;
        if (map.containsKey(aVar)) {
            return r(((Long) map.remove(aVar)).longValue());
        }
        J(map, c2);
        ChronoLocalDate chronoLocalDateX = X(map, c2);
        if (chronoLocalDateX != null) {
            return chronoLocalDateX;
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
        if (!map.containsKey(aVar2)) {
            return null;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.MONTH_OF_YEAR;
        if (map.containsKey(aVar3)) {
            if (map.containsKey(j$.time.temporal.a.DAY_OF_MONTH)) {
                return K(map, c2);
            }
            j$.time.temporal.a aVar4 = j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH;
            if (map.containsKey(aVar4)) {
                j$.time.temporal.a aVar5 = j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH;
                if (!map.containsKey(aVar5)) {
                    j$.time.temporal.a aVar6 = j$.time.temporal.a.DAY_OF_WEEK;
                    if (map.containsKey(aVar6)) {
                        int iA = Y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                        if (c2 == j$.time.format.C.LENIENT) {
                            return A(F(iA, 1, 1), Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar6)).longValue(), 1L));
                        }
                        int iA2 = Y(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                        ChronoLocalDate chronoLocalDateM = F(iA, iA2, 1).c((Y(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4) - 1) * 7, (TemporalUnit) ChronoUnit.DAYS).m(new j$.time.temporal.m(DayOfWeek.s(Y(aVar6).a(((Long) map.remove(aVar6)).longValue(), aVar6)).q(), 0));
                        if (c2 != j$.time.format.C.STRICT || chronoLocalDateM.j(aVar3) == iA2) {
                            return chronoLocalDateM;
                        }
                        throw new DateTimeException("Strict mode rejected resolved date as it is in a different month");
                    }
                } else {
                    int iA3 = Y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                    if (c2 == j$.time.format.C.LENIENT) {
                        long jSubtractExact = Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L);
                        return F(iA3, 1, 1).c(jSubtractExact, (TemporalUnit) ChronoUnit.MONTHS).c(Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).c(Math.subtractExact(((Long) map.remove(aVar5)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
                    }
                    int iA4 = Y(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                    int iA5 = Y(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4);
                    ChronoLocalDate chronoLocalDateC = F(iA3, iA4, 1).c((Y(aVar5).a(((Long) map.remove(aVar5)).longValue(), aVar5) - 1) + ((iA5 - 1) * 7), (TemporalUnit) ChronoUnit.DAYS);
                    if (c2 != j$.time.format.C.STRICT || chronoLocalDateC.j(aVar3) == iA4) {
                        return chronoLocalDateC;
                    }
                    throw new DateTimeException("Strict mode rejected resolved date as it is in a different month");
                }
            }
        }
        j$.time.temporal.a aVar7 = j$.time.temporal.a.DAY_OF_YEAR;
        if (!map.containsKey(aVar7)) {
            j$.time.temporal.a aVar8 = j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR;
            if (!map.containsKey(aVar8)) {
                return null;
            }
            j$.time.temporal.a aVar9 = j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR;
            if (!map.containsKey(aVar9)) {
                j$.time.temporal.a aVar10 = j$.time.temporal.a.DAY_OF_WEEK;
                if (!map.containsKey(aVar10)) {
                    return null;
                }
                int iA6 = Y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
                if (c2 == j$.time.format.C.LENIENT) {
                    return A(y(iA6, 1), 0L, Math.subtractExact(((Long) map.remove(aVar8)).longValue(), 1L), Math.subtractExact(((Long) map.remove(aVar10)).longValue(), 1L));
                }
                ChronoLocalDate chronoLocalDateM2 = y(iA6, 1).c((Y(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8) - 1) * 7, (TemporalUnit) ChronoUnit.DAYS).m(new j$.time.temporal.m(DayOfWeek.s(Y(aVar10).a(((Long) map.remove(aVar10)).longValue(), aVar10)).q(), 0));
                if (c2 != j$.time.format.C.STRICT || chronoLocalDateM2.j(aVar2) == iA6) {
                    return chronoLocalDateM2;
                }
                throw new DateTimeException("Strict mode rejected resolved date as it is in a different year");
            }
            int iA7 = Y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
            if (c2 == j$.time.format.C.LENIENT) {
                return y(iA7, 1).c(Math.subtractExact(((Long) map.remove(aVar8)).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).c(Math.subtractExact(((Long) map.remove(aVar9)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
            }
            int iA8 = Y(aVar8).a(((Long) map.remove(aVar8)).longValue(), aVar8);
            ChronoLocalDate chronoLocalDateC2 = y(iA7, 1).c((Y(aVar9).a(((Long) map.remove(aVar9)).longValue(), aVar9) - 1) + ((iA8 - 1) * 7), (TemporalUnit) ChronoUnit.DAYS);
            if (c2 != j$.time.format.C.STRICT || chronoLocalDateC2.j(aVar2) == iA7) {
                return chronoLocalDateC2;
            }
            throw new DateTimeException("Strict mode rejected resolved date as it is in a different year");
        }
        int iA9 = Y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
        if (c2 == j$.time.format.C.LENIENT) {
            return y(iA9, 1).c(Math.subtractExact(((Long) map.remove(aVar7)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        return y(iA9, Y(aVar7).a(((Long) map.remove(aVar7)).longValue(), aVar7));
    }

    public void J(Map map, j$.time.format.C c2) {
        j$.time.temporal.a aVar = j$.time.temporal.a.PROLEPTIC_MONTH;
        Long l2 = (Long) map.remove(aVar);
        if (l2 != null) {
            if (c2 != j$.time.format.C.LENIENT) {
                aVar.c0(l2.longValue());
            }
            ChronoLocalDate chronoLocalDateA = O().a(1L, (j$.time.temporal.n) j$.time.temporal.a.DAY_OF_MONTH).a(l2.longValue(), (j$.time.temporal.n) aVar);
            q(map, j$.time.temporal.a.MONTH_OF_YEAR, chronoLocalDateA.j(r0));
            q(map, j$.time.temporal.a.YEAR, chronoLocalDateA.j(r0));
        }
    }

    public ChronoLocalDate X(Map map, j$.time.format.C c2) {
        int intExact;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR_OF_ERA;
        Long l2 = (Long) map.remove(aVar);
        if (l2 != null) {
            Long l3 = (Long) map.remove(j$.time.temporal.a.ERA);
            if (c2 != j$.time.format.C.LENIENT) {
                intExact = Y(aVar).a(l2.longValue(), aVar);
            } else {
                intExact = Math.toIntExact(l2.longValue());
            }
            if (l3 != null) {
                q(map, j$.time.temporal.a.YEAR, v(S(Y(r2).a(l3.longValue(), r2)), intExact));
                return null;
            }
            j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR;
            if (map.containsKey(aVar2)) {
                q(map, aVar2, v(y(Y(aVar2).a(((Long) map.get(aVar2)).longValue(), aVar2), 1).u(), intExact));
                return null;
            }
            if (c2 == j$.time.format.C.STRICT) {
                map.put(aVar, l2);
                return null;
            }
            if (B().isEmpty()) {
                q(map, aVar2, intExact);
                return null;
            }
            q(map, aVar2, v((l) r9.get(r9.size() - 1), intExact));
            return null;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.ERA;
        if (!map.containsKey(aVar3)) {
            return null;
        }
        Y(aVar3).b(((Long) map.get(aVar3)).longValue(), aVar3);
        return null;
    }

    public ChronoLocalDate K(Map map, j$.time.format.C c2) {
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        int iA = Y(aVar).a(((Long) map.remove(aVar)).longValue(), aVar);
        if (c2 == j$.time.format.C.LENIENT) {
            long jSubtractExact = Math.subtractExact(((Long) map.remove(j$.time.temporal.a.MONTH_OF_YEAR)).longValue(), 1L);
            return F(iA, 1, 1).c(jSubtractExact, (TemporalUnit) ChronoUnit.MONTHS).c(Math.subtractExact(((Long) map.remove(j$.time.temporal.a.DAY_OF_MONTH)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        j$.time.temporal.a aVar2 = j$.time.temporal.a.MONTH_OF_YEAR;
        int iA2 = Y(aVar2).a(((Long) map.remove(aVar2)).longValue(), aVar2);
        j$.time.temporal.a aVar3 = j$.time.temporal.a.DAY_OF_MONTH;
        int iA3 = Y(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
        if (c2 != j$.time.format.C.SMART) {
            return F(iA, iA2, iA3);
        }
        try {
            return F(iA, iA2, iA3);
        } catch (DateTimeException unused) {
            return F(iA, iA2, 1).m(new j$.time.f(4));
        }
    }

    public static ChronoLocalDate A(ChronoLocalDate chronoLocalDate, long j2, long j3, long j4) {
        long j5;
        ChronoLocalDate chronoLocalDateC = chronoLocalDate.c(j2, (TemporalUnit) ChronoUnit.MONTHS);
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        ChronoLocalDate chronoLocalDateC2 = chronoLocalDateC.c(j3, (TemporalUnit) chronoUnit);
        if (j4 > 7) {
            long j6 = j4 - 1;
            chronoLocalDateC2 = chronoLocalDateC2.c(j6 / 7, (TemporalUnit) chronoUnit);
            j5 = j6 % 7;
        } else {
            if (j4 < 1) {
                chronoLocalDateC2 = chronoLocalDateC2.c(Math.subtractExact(j4, 7L) / 7, (TemporalUnit) chronoUnit);
                j5 = (j4 + 6) % 7;
            }
            return chronoLocalDateC2.m(new j$.time.temporal.m(DayOfWeek.s((int) j4).q(), 0));
        }
        j4 = j5 + 1;
        return chronoLocalDateC2.m(new j$.time.temporal.m(DayOfWeek.s((int) j4).q(), 0));
    }

    public static void q(Map map, j$.time.temporal.a aVar, long j2) {
        Long l2 = (Long) map.get(aVar);
        if (l2 != null && l2.longValue() != j2) {
            throw new DateTimeException("Conflict found: " + aVar + StringUtils.SPACE + l2 + " differs from " + aVar + StringUtils.SPACE + j2);
        }
        map.put(aVar, Long.valueOf(j2));
    }

    @Override // j$.time.chrono.k
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbstractC0109a) && getId().compareTo(((AbstractC0109a) obj).getId()) == 0;
    }

    @Override // j$.time.chrono.k
    public final int hashCode() {
        return getClass().hashCode() ^ getId().hashCode();
    }

    @Override // j$.time.chrono.k
    public final String toString() {
        return getId();
    }
}
