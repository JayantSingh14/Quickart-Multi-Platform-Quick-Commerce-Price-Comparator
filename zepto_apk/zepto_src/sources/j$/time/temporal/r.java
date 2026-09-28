package j$.time.temporal;

import j$.time.DateTimeException;
import j$.time.chrono.ChronoLocalDate;
import j$.time.format.B;
import j$.time.format.C;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class r implements n {

    /* renamed from: f, reason: collision with root package name */
    public static final q f53439f = q.f(1, 7);

    /* renamed from: g, reason: collision with root package name */
    public static final q f53440g = q.g(0, 4, 6);

    /* renamed from: h, reason: collision with root package name */
    public static final q f53441h = q.g(0, 52, 54);

    /* renamed from: i, reason: collision with root package name */
    public static final q f53442i = q.g(1, 52, 53);

    /* renamed from: a, reason: collision with root package name */
    public final String f53443a;

    /* renamed from: b, reason: collision with root package name */
    public final s f53444b;

    /* renamed from: c, reason: collision with root package name */
    public final Enum f53445c;

    /* renamed from: d, reason: collision with root package name */
    public final Enum f53446d;

    /* renamed from: e, reason: collision with root package name */
    public final q f53447e;

    @Override // j$.time.temporal.n
    public final boolean X() {
        return true;
    }

    public final int b(TemporalAccessor temporalAccessor) {
        return Math.floorMod(temporalAccessor.j(a.DAY_OF_WEEK) - this.f53444b.f53450a.q(), 7) + 1;
    }

    public final ChronoLocalDate e(j$.time.chrono.k kVar, int i2, int i3, int i4) {
        ChronoLocalDate chronoLocalDateF = kVar.F(i2, 1, 1);
        int iH = h(1, b(chronoLocalDateF));
        int i5 = i4 - 1;
        return chronoLocalDateF.c(((Math.min(i3, a(iH, chronoLocalDateF.L() + this.f53444b.f53451b) - 1) - 1) * 7) + i5 + (-iH), (TemporalUnit) ChronoUnit.DAYS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(String str, s sVar, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, q qVar) {
        this.f53443a = str;
        this.f53444b = sVar;
        this.f53445c = (Enum) temporalUnit;
        this.f53446d = (Enum) temporalUnit2;
        this.f53447e = qVar;
    }

    @Override // j$.time.temporal.n
    public final long s(TemporalAccessor temporalAccessor) {
        int iC;
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        Enum r1 = this.f53446d;
        if (r1 == chronoUnit) {
            iC = b(temporalAccessor);
        } else if (r1 != ChronoUnit.MONTHS) {
            if (r1 != ChronoUnit.YEARS) {
                if (r1 == s.f53449h) {
                    iC = d(temporalAccessor);
                } else if (r1 == ChronoUnit.FOREVER) {
                    iC = c(temporalAccessor);
                } else {
                    throw new IllegalStateException("unreachable, rangeUnit: " + r1 + ", this: " + this);
                }
            } else {
                int iB = b(temporalAccessor);
                int iJ = temporalAccessor.j(a.DAY_OF_YEAR);
                iC = a(h(iJ, iB), iJ);
            }
        } else {
            int iB2 = b(temporalAccessor);
            int iJ2 = temporalAccessor.j(a.DAY_OF_MONTH);
            iC = a(h(iJ2, iB2), iJ2);
        }
        return iC;
    }

    public final int c(TemporalAccessor temporalAccessor) {
        int iB = b(temporalAccessor);
        int iJ = temporalAccessor.j(a.YEAR);
        a aVar = a.DAY_OF_YEAR;
        int iJ2 = temporalAccessor.j(aVar);
        int iH = h(iJ2, iB);
        int iA = a(iH, iJ2);
        return iA == 0 ? iJ - 1 : iA >= a(iH, ((int) temporalAccessor.l(aVar).f53438d) + this.f53444b.f53451b) ? iJ + 1 : iJ;
    }

    public final int d(TemporalAccessor temporalAccessor) {
        int iA;
        int iB = b(temporalAccessor);
        a aVar = a.DAY_OF_YEAR;
        int iJ = temporalAccessor.j(aVar);
        int iH = h(iJ, iB);
        int iA2 = a(iH, iJ);
        if (iA2 == 0) {
            return d(j$.time.chrono.k.E(temporalAccessor).t(temporalAccessor).d(iJ, (TemporalUnit) ChronoUnit.DAYS));
        }
        return (iA2 <= 50 || iA2 < (iA = a(iH, ((int) temporalAccessor.l(aVar).f53438d) + this.f53444b.f53451b))) ? iA2 : (iA2 - iA) + 1;
    }

    public final int h(int i2, int i3) {
        int iFloorMod = Math.floorMod(i2 - i3, 7);
        return iFloorMod + 1 > this.f53444b.f53451b ? 7 - iFloorMod : -iFloorMod;
    }

    public static int a(int i2, int i3) {
        return ((i3 - 1) + (i2 + 7)) / 7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [j$.time.temporal.TemporalUnit, java.lang.Enum] */
    @Override // j$.time.temporal.n
    public final Temporal q(Temporal temporal, long j2) {
        if (this.f53447e.a(j2, this) == temporal.j(this)) {
            return temporal;
        }
        if (this.f53446d != ChronoUnit.FOREVER) {
            return temporal.c(r0 - r1, this.f53445c);
        }
        s sVar = this.f53444b;
        return e(j$.time.chrono.k.E(temporal), (int) j2, temporal.j(sVar.f53454e), temporal.j(sVar.f53452c));
    }

    @Override // j$.time.temporal.n
    public final TemporalAccessor J(HashMap map, B b2, C c2) {
        ChronoLocalDate chronoLocalDateC;
        ChronoLocalDate chronoLocalDateC2;
        ChronoLocalDate chronoLocalDateC3;
        long jLongValue = ((Long) map.get(this)).longValue();
        int intExact = Math.toIntExact(jLongValue);
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        Enum r7 = this.f53446d;
        q qVar = this.f53447e;
        s sVar = this.f53444b;
        if (r7 == chronoUnit) {
            long jFloorMod = Math.floorMod((qVar.a(jLongValue, this) - 1) + (sVar.f53450a.q() - 1), 7) + 1;
            map.remove(this);
            map.put(a.DAY_OF_WEEK, Long.valueOf(jFloorMod));
            return null;
        }
        a aVar = a.DAY_OF_WEEK;
        if (!map.containsKey(aVar)) {
            return null;
        }
        int iFloorMod = Math.floorMod(aVar.f53410b.a(((Long) map.get(aVar)).longValue(), aVar) - sVar.f53450a.q(), 7) + 1;
        j$.time.chrono.k kVarE = j$.time.chrono.k.E(b2);
        a aVar2 = a.YEAR;
        if (!map.containsKey(aVar2)) {
            if (r7 != s.f53449h && r7 != ChronoUnit.FOREVER) {
                return null;
            }
            r rVar = sVar.f53455f;
            if (!map.containsKey(rVar)) {
                return null;
            }
            r rVar2 = sVar.f53454e;
            if (!map.containsKey(rVar2)) {
                return null;
            }
            int iA = rVar.f53447e.a(((Long) map.get(rVar)).longValue(), rVar);
            if (c2 == C.LENIENT) {
                chronoLocalDateC = e(kVarE, iA, 1, iFloorMod).c(Math.subtractExact(((Long) map.get(rVar2)).longValue(), 1L), (TemporalUnit) chronoUnit);
            } else {
                ChronoLocalDate chronoLocalDateE = e(kVarE, iA, rVar2.f53447e.a(((Long) map.get(rVar2)).longValue(), rVar2), iFloorMod);
                if (c2 == C.STRICT && c(chronoLocalDateE) != iA) {
                    throw new DateTimeException("Strict mode rejected resolved date as it is in a different week-based-year");
                }
                chronoLocalDateC = chronoLocalDateE;
            }
            map.remove(this);
            map.remove(rVar);
            map.remove(rVar2);
            map.remove(aVar);
            return chronoLocalDateC;
        }
        int iA2 = aVar2.f53410b.a(((Long) map.get(aVar2)).longValue(), aVar2);
        ChronoUnit chronoUnit2 = ChronoUnit.MONTHS;
        if (r7 == chronoUnit2) {
            a aVar3 = a.MONTH_OF_YEAR;
            if (map.containsKey(aVar3)) {
                long jLongValue2 = ((Long) map.get(aVar3)).longValue();
                long j2 = intExact;
                if (c2 == C.LENIENT) {
                    ChronoLocalDate chronoLocalDateC4 = kVarE.F(iA2, 1, 1).c(Math.subtractExact(jLongValue2, 1L), (TemporalUnit) chronoUnit2);
                    int iB = b(chronoLocalDateC4);
                    int iJ = chronoLocalDateC4.j(a.DAY_OF_MONTH);
                    chronoLocalDateC3 = chronoLocalDateC4.c(Math.addExact(Math.multiplyExact(Math.subtractExact(j2, a(h(iJ, iB), iJ)), 7), iFloorMod - b(chronoLocalDateC4)), (TemporalUnit) ChronoUnit.DAYS);
                } else {
                    ChronoLocalDate chronoLocalDateF = kVarE.F(iA2, aVar3.f53410b.a(jLongValue2, aVar3), 1);
                    long jA = qVar.a(j2, this);
                    int iB2 = b(chronoLocalDateF);
                    int iJ2 = chronoLocalDateF.j(a.DAY_OF_MONTH);
                    ChronoLocalDate chronoLocalDateC5 = chronoLocalDateF.c((((int) (jA - a(h(iJ2, iB2), iJ2))) * 7) + (iFloorMod - b(chronoLocalDateF)), (TemporalUnit) ChronoUnit.DAYS);
                    if (c2 == C.STRICT && chronoLocalDateC5.h(aVar3) != jLongValue2) {
                        throw new DateTimeException("Strict mode rejected resolved date as it is in a different month");
                    }
                    chronoLocalDateC3 = chronoLocalDateC5;
                }
                map.remove(this);
                map.remove(aVar2);
                map.remove(aVar3);
                map.remove(aVar);
                return chronoLocalDateC3;
            }
        }
        if (r7 != ChronoUnit.YEARS) {
            return null;
        }
        long j3 = intExact;
        ChronoLocalDate chronoLocalDateF2 = kVarE.F(iA2, 1, 1);
        if (c2 == C.LENIENT) {
            int iB3 = b(chronoLocalDateF2);
            int iJ3 = chronoLocalDateF2.j(a.DAY_OF_YEAR);
            chronoLocalDateC2 = chronoLocalDateF2.c(Math.addExact(Math.multiplyExact(Math.subtractExact(j3, a(h(iJ3, iB3), iJ3)), 7), iFloorMod - b(chronoLocalDateF2)), (TemporalUnit) ChronoUnit.DAYS);
        } else {
            long jA2 = qVar.a(j3, this);
            int iB4 = b(chronoLocalDateF2);
            int iJ4 = chronoLocalDateF2.j(a.DAY_OF_YEAR);
            ChronoLocalDate chronoLocalDateC6 = chronoLocalDateF2.c((((int) (jA2 - a(h(iJ4, iB4), iJ4))) * 7) + (iFloorMod - b(chronoLocalDateF2)), (TemporalUnit) ChronoUnit.DAYS);
            if (c2 == C.STRICT && chronoLocalDateC6.h(aVar2) != iA2) {
                throw new DateTimeException("Strict mode rejected resolved date as it is in a different year");
            }
            chronoLocalDateC2 = chronoLocalDateC6;
        }
        map.remove(this);
        map.remove(aVar2);
        map.remove(aVar);
        return chronoLocalDateC2;
    }

    @Override // j$.time.temporal.n
    public final q A() {
        return this.f53447e;
    }

    @Override // j$.time.temporal.n
    public final boolean Z(TemporalAccessor temporalAccessor) {
        if (!temporalAccessor.g(a.DAY_OF_WEEK)) {
            return false;
        }
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        Enum r1 = this.f53446d;
        if (r1 == chronoUnit) {
            return true;
        }
        if (r1 == ChronoUnit.MONTHS) {
            return temporalAccessor.g(a.DAY_OF_MONTH);
        }
        if (r1 == ChronoUnit.YEARS) {
            return temporalAccessor.g(a.DAY_OF_YEAR);
        }
        if (r1 == s.f53449h) {
            return temporalAccessor.g(a.DAY_OF_YEAR);
        }
        if (r1 == ChronoUnit.FOREVER) {
            return temporalAccessor.g(a.YEAR);
        }
        return false;
    }

    @Override // j$.time.temporal.n
    public final q K(TemporalAccessor temporalAccessor) {
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        Enum r1 = this.f53446d;
        if (r1 == chronoUnit) {
            return this.f53447e;
        }
        if (r1 == ChronoUnit.MONTHS) {
            return f(temporalAccessor, a.DAY_OF_MONTH);
        }
        if (r1 == ChronoUnit.YEARS) {
            return f(temporalAccessor, a.DAY_OF_YEAR);
        }
        if (r1 == s.f53449h) {
            return g(temporalAccessor);
        }
        if (r1 == ChronoUnit.FOREVER) {
            return a.YEAR.f53410b;
        }
        throw new IllegalStateException("unreachable, rangeUnit: " + r1 + ", this: " + this);
    }

    public final q f(TemporalAccessor temporalAccessor, a aVar) {
        int iH = h(temporalAccessor.j(aVar), b(temporalAccessor));
        q qVarL = temporalAccessor.l(aVar);
        return q.f(a(iH, (int) qVarL.f53435a), a(iH, (int) qVarL.f53438d));
    }

    public final q g(TemporalAccessor temporalAccessor) {
        a aVar = a.DAY_OF_YEAR;
        if (!temporalAccessor.g(aVar)) {
            return f53441h;
        }
        int iB = b(temporalAccessor);
        int iJ = temporalAccessor.j(aVar);
        int iH = h(iJ, iB);
        int iA = a(iH, iJ);
        if (iA != 0) {
            if (iA >= a(iH, this.f53444b.f53451b + ((int) temporalAccessor.l(aVar).f53438d))) {
                return g(j$.time.chrono.k.E(temporalAccessor).t(temporalAccessor).c((r0 - iJ) + 8, (TemporalUnit) ChronoUnit.DAYS));
            }
            return q.f(1L, r1 - 1);
        }
        return g(j$.time.chrono.k.E(temporalAccessor).t(temporalAccessor).d(iJ + 7, (TemporalUnit) ChronoUnit.DAYS));
    }

    public final String toString() {
        return this.f53443a + "[" + this.f53444b.toString() + "]";
    }
}
