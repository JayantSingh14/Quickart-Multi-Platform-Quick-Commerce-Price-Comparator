package j$.time.format;

import j$.time.DateTimeException;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDate;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public final class B implements TemporalAccessor {

    /* renamed from: b, reason: collision with root package name */
    public ZoneId f53274b;

    /* renamed from: c, reason: collision with root package name */
    public j$.time.chrono.k f53275c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f53276d;

    /* renamed from: e, reason: collision with root package name */
    public C f53277e;

    /* renamed from: f, reason: collision with root package name */
    public ChronoLocalDate f53278f;

    /* renamed from: g, reason: collision with root package name */
    public LocalTime f53279g;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f53273a = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    public j$.time.p f53280h = j$.time.p.f53393d;

    @Override // j$.time.temporal.TemporalAccessor
    public final boolean g(j$.time.temporal.n nVar) {
        if (this.f53273a.containsKey(nVar)) {
            return true;
        }
        ChronoLocalDate chronoLocalDate = this.f53278f;
        if (chronoLocalDate != null && chronoLocalDate.g(nVar)) {
            return true;
        }
        LocalTime localTime = this.f53279g;
        if (localTime == null || !localTime.g(nVar)) {
            return (nVar == null || (nVar instanceof j$.time.temporal.a) || !nVar.Z(this)) ? false : true;
        }
        return true;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long h(j$.time.temporal.n nVar) {
        Objects.requireNonNull(nVar, "field");
        Long l2 = (Long) this.f53273a.get(nVar);
        if (l2 != null) {
            return l2.longValue();
        }
        ChronoLocalDate chronoLocalDate = this.f53278f;
        if (chronoLocalDate != null && chronoLocalDate.g(nVar)) {
            return this.f53278f.h(nVar);
        }
        LocalTime localTime = this.f53279g;
        if (localTime != null && localTime.g(nVar)) {
            return this.f53279g.h(nVar);
        }
        if (nVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.p(j$.time.b.a("Unsupported field: ", nVar));
        }
        return nVar.s(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final Object e(TemporalQuery temporalQuery) {
        if (temporalQuery == j$.time.temporal.o.f53428a) {
            return this.f53274b;
        }
        if (temporalQuery == j$.time.temporal.o.f53429b) {
            return this.f53275c;
        }
        if (temporalQuery == j$.time.temporal.o.f53433f) {
            ChronoLocalDate chronoLocalDate = this.f53278f;
            if (chronoLocalDate != null) {
                return LocalDate.J(chronoLocalDate);
            }
            return null;
        }
        if (temporalQuery == j$.time.temporal.o.f53434g) {
            return this.f53279g;
        }
        if (temporalQuery == j$.time.temporal.o.f53431d) {
            Long l2 = (Long) this.f53273a.get(j$.time.temporal.a.OFFSET_SECONDS);
            if (l2 != null) {
                return ZoneOffset.ofTotalSeconds(l2.intValue());
            }
            ZoneId zoneId = this.f53274b;
            return zoneId instanceof ZoneOffset ? zoneId : temporalQuery.queryFrom(this);
        }
        if (temporalQuery == j$.time.temporal.o.f53432e) {
            return temporalQuery.queryFrom(this);
        }
        if (temporalQuery == j$.time.temporal.o.f53430c) {
            return null;
        }
        return temporalQuery.queryFrom(this);
    }

    public final void B(j$.time.temporal.n nVar, j$.time.temporal.a aVar, Long l2) {
        Long l3 = (Long) this.f53273a.put(aVar, l2);
        if (l3 == null || l3.longValue() == l2.longValue()) {
            return;
        }
        throw new DateTimeException("Conflict found: " + aVar + StringUtils.SPACE + l3 + " differs from " + aVar + StringUtils.SPACE + l2 + " while resolving  " + nVar);
    }

    public final void s() {
        HashMap map = this.f53273a;
        if (map.containsKey(j$.time.temporal.a.INSTANT_SECONDS)) {
            ZoneId zoneId = this.f53274b;
            if (zoneId != null) {
                t(zoneId);
                return;
            }
            Long l2 = (Long) map.get(j$.time.temporal.a.OFFSET_SECONDS);
            if (l2 != null) {
                t(ZoneOffset.ofTotalSeconds(l2.intValue()));
            }
        }
    }

    public final void t(ZoneId zoneId) {
        HashMap map = this.f53273a;
        j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
        A(this.f53275c.w(Instant.ofEpochSecond(((Long) map.remove(aVar)).longValue()), zoneId).p());
        B(aVar, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(r5.o().toSecondOfDay()));
    }

    public final void A(ChronoLocalDate chronoLocalDate) {
        ChronoLocalDate chronoLocalDate2 = this.f53278f;
        if (chronoLocalDate2 != null) {
            if (chronoLocalDate == null || chronoLocalDate2.equals(chronoLocalDate)) {
                return;
            }
            throw new DateTimeException("Conflict found: Fields resolved to two different dates: " + this.f53278f + StringUtils.SPACE + chronoLocalDate);
        }
        if (chronoLocalDate != null) {
            if (!this.f53275c.equals(chronoLocalDate.i())) {
                throw new DateTimeException("ChronoLocalDate must use the effective parsed chronology: " + this.f53275c);
            }
            this.f53278f = chronoLocalDate;
        }
    }

    public final void w() {
        HashMap map = this.f53273a;
        j$.time.temporal.a aVar = j$.time.temporal.a.CLOCK_HOUR_OF_DAY;
        if (map.containsKey(aVar)) {
            long jLongValue = ((Long) map.remove(aVar)).longValue();
            C c2 = this.f53277e;
            if (c2 == C.STRICT || (c2 == C.SMART && jLongValue != 0)) {
                aVar.c0(jLongValue);
            }
            j$.time.temporal.a aVar2 = j$.time.temporal.a.HOUR_OF_DAY;
            if (jLongValue == 24) {
                jLongValue = 0;
            }
            B(aVar, aVar2, Long.valueOf(jLongValue));
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.CLOCK_HOUR_OF_AMPM;
        if (map.containsKey(aVar3)) {
            long jLongValue2 = ((Long) map.remove(aVar3)).longValue();
            C c3 = this.f53277e;
            if (c3 == C.STRICT || (c3 == C.SMART && jLongValue2 != 0)) {
                aVar3.c0(jLongValue2);
            }
            B(aVar3, j$.time.temporal.a.HOUR_OF_AMPM, Long.valueOf(jLongValue2 != 12 ? jLongValue2 : 0L));
        }
        j$.time.temporal.a aVar4 = j$.time.temporal.a.AMPM_OF_DAY;
        if (map.containsKey(aVar4)) {
            j$.time.temporal.a aVar5 = j$.time.temporal.a.HOUR_OF_AMPM;
            if (map.containsKey(aVar5)) {
                long jLongValue3 = ((Long) map.remove(aVar4)).longValue();
                long jLongValue4 = ((Long) map.remove(aVar5)).longValue();
                if (this.f53277e == C.LENIENT) {
                    B(aVar4, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(Math.addExact(Math.multiplyExact(jLongValue3, 12), jLongValue4)));
                } else {
                    aVar4.c0(jLongValue3);
                    aVar5.c0(jLongValue3);
                    B(aVar4, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf((jLongValue3 * 12) + jLongValue4));
                }
            }
        }
        j$.time.temporal.a aVar6 = j$.time.temporal.a.NANO_OF_DAY;
        if (map.containsKey(aVar6)) {
            long jLongValue5 = ((Long) map.remove(aVar6)).longValue();
            if (this.f53277e != C.LENIENT) {
                aVar6.c0(jLongValue5);
            }
            B(aVar6, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(jLongValue5 / 3600000000000L));
            B(aVar6, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf((jLongValue5 / 60000000000L) % 60));
            B(aVar6, j$.time.temporal.a.SECOND_OF_MINUTE, Long.valueOf((jLongValue5 / 1000000000) % 60));
            B(aVar6, j$.time.temporal.a.NANO_OF_SECOND, Long.valueOf(jLongValue5 % 1000000000));
        }
        j$.time.temporal.a aVar7 = j$.time.temporal.a.MICRO_OF_DAY;
        if (map.containsKey(aVar7)) {
            long jLongValue6 = ((Long) map.remove(aVar7)).longValue();
            if (this.f53277e != C.LENIENT) {
                aVar7.c0(jLongValue6);
            }
            B(aVar7, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(jLongValue6 / 1000000));
            B(aVar7, j$.time.temporal.a.MICRO_OF_SECOND, Long.valueOf(jLongValue6 % 1000000));
        }
        j$.time.temporal.a aVar8 = j$.time.temporal.a.MILLI_OF_DAY;
        if (map.containsKey(aVar8)) {
            long jLongValue7 = ((Long) map.remove(aVar8)).longValue();
            if (this.f53277e != C.LENIENT) {
                aVar8.c0(jLongValue7);
            }
            B(aVar8, j$.time.temporal.a.SECOND_OF_DAY, Long.valueOf(jLongValue7 / 1000));
            B(aVar8, j$.time.temporal.a.MILLI_OF_SECOND, Long.valueOf(jLongValue7 % 1000));
        }
        j$.time.temporal.a aVar9 = j$.time.temporal.a.SECOND_OF_DAY;
        if (map.containsKey(aVar9)) {
            long jLongValue8 = ((Long) map.remove(aVar9)).longValue();
            if (this.f53277e != C.LENIENT) {
                aVar9.c0(jLongValue8);
            }
            B(aVar9, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(jLongValue8 / 3600));
            B(aVar9, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf((jLongValue8 / 60) % 60));
            B(aVar9, j$.time.temporal.a.SECOND_OF_MINUTE, Long.valueOf(jLongValue8 % 60));
        }
        j$.time.temporal.a aVar10 = j$.time.temporal.a.MINUTE_OF_DAY;
        if (map.containsKey(aVar10)) {
            long jLongValue9 = ((Long) map.remove(aVar10)).longValue();
            if (this.f53277e != C.LENIENT) {
                aVar10.c0(jLongValue9);
            }
            B(aVar10, j$.time.temporal.a.HOUR_OF_DAY, Long.valueOf(jLongValue9 / 60));
            B(aVar10, j$.time.temporal.a.MINUTE_OF_HOUR, Long.valueOf(jLongValue9 % 60));
        }
        j$.time.temporal.a aVar11 = j$.time.temporal.a.NANO_OF_SECOND;
        if (map.containsKey(aVar11)) {
            long jLongValue10 = ((Long) map.get(aVar11)).longValue();
            C c4 = this.f53277e;
            C c5 = C.LENIENT;
            if (c4 != c5) {
                aVar11.c0(jLongValue10);
            }
            j$.time.temporal.a aVar12 = j$.time.temporal.a.MICRO_OF_SECOND;
            if (map.containsKey(aVar12)) {
                long jLongValue11 = ((Long) map.remove(aVar12)).longValue();
                if (this.f53277e != c5) {
                    aVar12.c0(jLongValue11);
                }
                jLongValue10 = (jLongValue10 % 1000) + (jLongValue11 * 1000);
                B(aVar12, aVar11, Long.valueOf(jLongValue10));
            }
            j$.time.temporal.a aVar13 = j$.time.temporal.a.MILLI_OF_SECOND;
            if (map.containsKey(aVar13)) {
                long jLongValue12 = ((Long) map.remove(aVar13)).longValue();
                if (this.f53277e != c5) {
                    aVar13.c0(jLongValue12);
                }
                B(aVar13, aVar11, Long.valueOf((jLongValue10 % 1000000) + (jLongValue12 * 1000000)));
            }
        }
        j$.time.temporal.a aVar14 = j$.time.temporal.a.HOUR_OF_DAY;
        if (map.containsKey(aVar14)) {
            j$.time.temporal.a aVar15 = j$.time.temporal.a.MINUTE_OF_HOUR;
            if (map.containsKey(aVar15)) {
                j$.time.temporal.a aVar16 = j$.time.temporal.a.SECOND_OF_MINUTE;
                if (map.containsKey(aVar16) && map.containsKey(aVar11)) {
                    v(((Long) map.remove(aVar14)).longValue(), ((Long) map.remove(aVar15)).longValue(), ((Long) map.remove(aVar16)).longValue(), ((Long) map.remove(aVar11)).longValue());
                }
            }
        }
    }

    public final void v(long j2, long j3, long j4, long j5) {
        if (this.f53277e == C.LENIENT) {
            long jAddExact = Math.addExact(Math.addExact(Math.addExact(Math.multiplyExact(j2, 3600000000000L), Math.multiplyExact(j3, 60000000000L)), Math.multiplyExact(j4, 1000000000L)), j5);
            y(LocalTime.K(Math.floorMod(jAddExact, 86400000000000L)), j$.time.p.a(0, 0, (int) Math.floorDiv(jAddExact, 86400000000000L)));
            return;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.MINUTE_OF_HOUR;
        int iA = aVar.f53410b.a(j3, aVar);
        j$.time.temporal.a aVar2 = j$.time.temporal.a.NANO_OF_SECOND;
        int iA2 = aVar2.f53410b.a(j5, aVar2);
        if (this.f53277e == C.SMART && j2 == 24 && iA == 0 && j4 == 0 && iA2 == 0) {
            y(LocalTime.f53186e, j$.time.p.a(0, 0, 1));
            return;
        }
        j$.time.temporal.a aVar3 = j$.time.temporal.a.HOUR_OF_DAY;
        int iA3 = aVar3.f53410b.a(j2, aVar3);
        j$.time.temporal.a aVar4 = j$.time.temporal.a.SECOND_OF_MINUTE;
        y(LocalTime.of(iA3, iA, aVar4.f53410b.a(j4, aVar4), iA2), j$.time.p.f53393d);
    }

    public final void y(LocalTime localTime, j$.time.p pVar) {
        LocalTime localTime2 = this.f53279g;
        if (localTime2 != null) {
            if (!localTime2.equals(localTime)) {
                throw new DateTimeException("Conflict found: Fields resolved to different times: " + this.f53279g + StringUtils.SPACE + localTime);
            }
            j$.time.p pVar2 = this.f53280h;
            pVar2.getClass();
            j$.time.p pVar3 = j$.time.p.f53393d;
            if (pVar2 != pVar3 && pVar != pVar3 && !this.f53280h.equals(pVar)) {
                throw new DateTimeException("Conflict found: Fields resolved to different excess periods: " + this.f53280h + StringUtils.SPACE + pVar);
            }
            this.f53280h = pVar;
            return;
        }
        this.f53279g = localTime;
        this.f53280h = pVar;
    }

    public final void r(TemporalAccessor temporalAccessor) {
        Iterator it = this.f53273a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            j$.time.temporal.n nVar = (j$.time.temporal.n) entry.getKey();
            if (temporalAccessor.g(nVar)) {
                try {
                    long jH = temporalAccessor.h(nVar);
                    long jLongValue = ((Long) entry.getValue()).longValue();
                    if (jH != jLongValue) {
                        throw new DateTimeException("Conflict found: Field " + nVar + StringUtils.SPACE + jH + " differs from " + nVar + StringUtils.SPACE + jLongValue + " derived from " + temporalAccessor);
                    }
                    it.remove();
                } catch (RuntimeException unused) {
                    continue;
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(this.f53273a);
        sb.append(',');
        sb.append(this.f53275c);
        if (this.f53274b != null) {
            sb.append(',');
            sb.append(this.f53274b);
        }
        if (this.f53278f != null || this.f53279g != null) {
            sb.append(" resolved to ");
            ChronoLocalDate chronoLocalDate = this.f53278f;
            if (chronoLocalDate != null) {
                sb.append(chronoLocalDate);
                if (this.f53279g != null) {
                    sb.append('T');
                    sb.append(this.f53279g);
                }
            } else {
                sb.append(this.f53279g);
            }
        }
        return sb.toString();
    }
}
