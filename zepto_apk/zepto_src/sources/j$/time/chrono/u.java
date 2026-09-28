package j$.time.chrono;

import j$.time.Clock;
import j$.time.DateTimeException;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.ZoneId;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalAccessor;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public final class u extends AbstractC0109a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final u f53256c = new u();
    private static final long serialVersionUID = 459996390165777884L;

    @Override // j$.time.chrono.k
    public final String getId() {
        return "Japanese";
    }

    @Override // j$.time.chrono.k
    public final String W() {
        return "japanese";
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate F(int i2, int i3, int i4) {
        return new w(LocalDate.of(i2, i3, i4));
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate y(int i2, int i3) {
        return new w(LocalDate.h0(i2, i3));
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate r(long j2) {
        return new w(LocalDate.ofEpochDay(j2));
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate O() {
        return new w(LocalDate.J(LocalDate.g0(Clock.b())));
    }

    @Override // j$.time.chrono.k
    public final ChronoLocalDate t(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof w) {
            return (w) temporalAccessor;
        }
        return new w(LocalDate.J(temporalAccessor));
    }

    @Override // j$.time.chrono.k
    public final List B() {
        x[] xVarArr = x.f53263e;
        return j$.time.d.c((x[]) Arrays.copyOf(xVarArr, xVarArr.length));
    }

    @Override // j$.time.chrono.k
    public final boolean C(long j2) {
        return r.f53253c.C(j2);
    }

    private u() {
    }

    @Override // j$.time.chrono.k
    public final int v(l lVar, int i2) {
        if (!(lVar instanceof x)) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        x xVar = (x) lVar;
        int year = (xVar.f53265b.getYear() + i2) - 1;
        if (i2 != 1 && (year < -999999999 || year > 999999999 || year < xVar.f53265b.getYear() || lVar != x.r(LocalDate.of(year, 1, 1)))) {
            throw new DateTimeException("Invalid yearOfEra value");
        }
        return year;
    }

    @Override // j$.time.chrono.k
    public final l S(int i2) {
        return x.t(i2);
    }

    @Override // j$.time.chrono.k
    public final j$.time.temporal.q Y(j$.time.temporal.a aVar) {
        switch (t.f53255a[aVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                throw new j$.time.temporal.p("Unsupported field: " + aVar);
            case 5:
                x[] xVarArr = x.f53263e;
                int year = xVarArr[xVarArr.length - 1].f53265b.getYear();
                int year2 = 1000000000 - xVarArr[xVarArr.length - 1].f53265b.getYear();
                int year3 = xVarArr[0].f53265b.getYear();
                for (int i2 = 1; i2 < xVarArr.length; i2++) {
                    x xVar = xVarArr[i2];
                    year2 = Math.min(year2, (xVar.f53265b.getYear() - year3) + 1);
                    year3 = xVar.f53265b.getYear();
                }
                return j$.time.temporal.q.g(1L, year2, 999999999 - year);
            case 6:
                x xVar2 = x.f53262d;
                j$.time.temporal.q qVar = j$.time.temporal.a.DAY_OF_YEAR.f53410b;
                x[] xVarArr2 = x.f53263e;
                long j2 = qVar.f53437c;
                for (x xVar3 : xVarArr2) {
                    long jMin = Math.min(j2, (xVar3.f53265b.L() - xVar3.f53265b.X()) + 1);
                    if (xVar3.s() != null) {
                        jMin = Math.min(jMin, xVar3.s().f53265b.X() - 1);
                    }
                    j2 = jMin;
                }
                return j$.time.temporal.q.g(1L, j2, j$.time.temporal.a.DAY_OF_YEAR.f53410b.f53438d);
            case 7:
                return j$.time.temporal.q.f(w.f53258d.getYear(), 999999999L);
            case 8:
                long j3 = x.f53262d.f53264a;
                x[] xVarArr3 = x.f53263e;
                return j$.time.temporal.q.f(j3, xVarArr3[xVarArr3.length - 1].f53264a);
            default:
                return aVar.f53410b;
        }
    }

    @Override // j$.time.chrono.AbstractC0109a, j$.time.chrono.k
    public final ChronoLocalDate U(Map map, j$.time.format.C c2) {
        return (w) super.U(map, c2);
    }

    @Override // j$.time.chrono.AbstractC0109a
    public final ChronoLocalDate X(Map map, j$.time.format.C c2) {
        w wVarD0;
        j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
        Long l2 = (Long) map.get(aVar);
        x xVarT = l2 != null ? x.t(Y(aVar).a(l2.longValue(), aVar)) : null;
        j$.time.temporal.a aVar2 = j$.time.temporal.a.YEAR_OF_ERA;
        Long l3 = (Long) map.get(aVar2);
        int iA = l3 != null ? Y(aVar2).a(l3.longValue(), aVar2) : 0;
        if (xVarT == null && l3 != null && !map.containsKey(j$.time.temporal.a.YEAR) && c2 != j$.time.format.C.STRICT) {
            x[] xVarArr = x.f53263e;
            xVarT = ((x[]) Arrays.copyOf(xVarArr, xVarArr.length))[((x[]) Arrays.copyOf(xVarArr, xVarArr.length)).length - 1];
        }
        if (l3 != null && xVarT != null) {
            j$.time.temporal.a aVar3 = j$.time.temporal.a.MONTH_OF_YEAR;
            boolean zContainsKey = map.containsKey(aVar3);
            LocalDate localDate = xVarT.f53265b;
            if (zContainsKey) {
                j$.time.temporal.a aVar4 = j$.time.temporal.a.DAY_OF_MONTH;
                if (map.containsKey(aVar4)) {
                    map.remove(aVar);
                    map.remove(aVar2);
                    if (c2 == j$.time.format.C.LENIENT) {
                        return new w(LocalDate.of((localDate.getYear() + iA) - 1, 1, 1)).Z(Math.subtractExact(((Long) map.remove(aVar3)).longValue(), 1L), ChronoUnit.MONTHS).Z(Math.subtractExact(((Long) map.remove(aVar4)).longValue(), 1L), ChronoUnit.DAYS);
                    }
                    int iA2 = Y(aVar3).a(((Long) map.remove(aVar3)).longValue(), aVar3);
                    int iA3 = Y(aVar4).a(((Long) map.remove(aVar4)).longValue(), aVar4);
                    if (c2 != j$.time.format.C.SMART) {
                        LocalDate localDate2 = w.f53258d;
                        LocalDate localDateOf = LocalDate.of((localDate.getYear() + iA) - 1, iA2, iA3);
                        if (localDateOf.c0(localDate) || xVarT != x.r(localDateOf)) {
                            throw new DateTimeException("year, month, and day not valid for Era");
                        }
                        return new w(xVarT, iA, localDateOf);
                    }
                    if (iA < 1) {
                        throw new DateTimeException("Invalid YearOfEra: " + iA);
                    }
                    int year = (localDate.getYear() + iA) - 1;
                    try {
                        wVarD0 = new w(LocalDate.of(year, iA2, iA3));
                    } catch (DateTimeException unused) {
                        wVarD0 = new w(LocalDate.of(year, iA2, 1)).d0(new j$.time.f(4));
                    }
                    if (wVarD0.f53260b == xVarT || wVarD0.j(j$.time.temporal.a.YEAR_OF_ERA) <= 1 || iA <= 1) {
                        return wVarD0;
                    }
                    throw new DateTimeException("Invalid YearOfEra for Era: " + xVarT + StringUtils.SPACE + iA);
                }
            }
            j$.time.temporal.a aVar5 = j$.time.temporal.a.DAY_OF_YEAR;
            if (map.containsKey(aVar5)) {
                map.remove(aVar);
                map.remove(aVar2);
                if (c2 == j$.time.format.C.LENIENT) {
                    return new w(LocalDate.h0((localDate.getYear() + iA) - 1, 1)).Z(Math.subtractExact(((Long) map.remove(aVar5)).longValue(), 1L), ChronoUnit.DAYS);
                }
                int iA4 = Y(aVar5).a(((Long) map.remove(aVar5)).longValue(), aVar5);
                LocalDate localDate3 = w.f53258d;
                LocalDate localDateH0 = iA == 1 ? LocalDate.h0(localDate.getYear(), (localDate.X() + iA4) - 1) : LocalDate.h0((localDate.getYear() + iA) - 1, iA4);
                if (localDateH0.c0(localDate) || xVarT != x.r(localDateH0)) {
                    throw new DateTimeException("Invalid parameters");
                }
                return new w(xVarT, iA, localDateH0);
            }
        }
        return null;
    }

    @Override // j$.time.chrono.k
    public final InterfaceC0116h w(Instant instant, ZoneId zoneId) {
        return j.J(this, instant, zoneId);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new D((byte) 1, this);
    }
}
