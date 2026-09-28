package j$.time.chrono;

import j$.time.DateTimeException;
import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* loaded from: classes2.dex */
public final class w extends AbstractC0111c {

    /* renamed from: d, reason: collision with root package name */
    public static final LocalDate f53258d = LocalDate.of(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;

    /* renamed from: a, reason: collision with root package name */
    public final transient LocalDate f53259a;

    /* renamed from: b, reason: collision with root package name */
    public final transient x f53260b;

    /* renamed from: c, reason: collision with root package name */
    public final transient int f53261c;

    @Override // j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDateTime M(LocalTime localTime) {
        return new C0113e(this, localTime);
    }

    public w(LocalDate localDate) {
        if (localDate.c0(f53258d)) {
            throw new DateTimeException("JapaneseDate before Meiji 6 is not supported");
        }
        x xVarR = x.r(localDate);
        this.f53260b = xVarR;
        this.f53261c = (localDate.getYear() - xVarR.f53265b.getYear()) + 1;
        this.f53259a = localDate;
    }

    public w(x xVar, int i2, LocalDate localDate) {
        if (localDate.c0(f53258d)) {
            throw new DateTimeException("JapaneseDate before Meiji 6 is not supported");
        }
        this.f53260b = xVar;
        this.f53261c = i2;
        this.f53259a = localDate;
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate
    public final int hashCode() {
        u.f53256c.getClass();
        return this.f53259a.hashCode() ^ (-688086063);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final k i() {
        return u.f53256c;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final l u() {
        return this.f53260b;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    @Override // j$.time.chrono.ChronoLocalDate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int L() {
        /*
            r6 = this;
            j$.time.chrono.x r0 = r6.f53260b
            j$.time.chrono.x r1 = r0.s()
            j$.time.LocalDate r2 = r6.f53259a
            r3 = 1
            if (r1 == 0) goto L1d
            j$.time.LocalDate r1 = r1.f53265b
            int r4 = r1.getYear()
            int r5 = r2.getYear()
            if (r4 != r5) goto L1d
            int r1 = r1.X()
            int r1 = r1 - r3
            goto L21
        L1d:
            int r1 = r2.L()
        L21:
            int r2 = r6.f53261c
            if (r2 != r3) goto L2d
            j$.time.LocalDate r0 = r0.f53265b
            int r0 = r0.X()
            int r0 = r0 - r3
            int r1 = r1 - r0
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.w.L():int");
    }

    @Override // j$.time.chrono.ChronoLocalDate, j$.time.temporal.TemporalAccessor
    public final boolean g(j$.time.temporal.n nVar) {
        if (nVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH || nVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR || nVar == j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH || nVar == j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        if (nVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) nVar).X();
        }
        return nVar != null && nVar.Z(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final j$.time.temporal.q l(j$.time.temporal.n nVar) {
        if (!(nVar instanceof j$.time.temporal.a)) {
            return nVar.K(this);
        }
        if (!g(nVar)) {
            throw new j$.time.temporal.p(j$.time.b.a("Unsupported field: ", nVar));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) nVar;
        int i2 = v.f53257a[aVar.ordinal()];
        if (i2 == 1) {
            return j$.time.temporal.q.f(1L, this.f53259a.d0());
        }
        if (i2 == 2) {
            return j$.time.temporal.q.f(1L, L());
        }
        if (i2 != 3) {
            return u.f53256c.Y(aVar);
        }
        x xVar = this.f53260b;
        int year = xVar.f53265b.getYear();
        return xVar.s() != null ? j$.time.temporal.q.f(1L, (r6.f53265b.getYear() - year) + 1) : j$.time.temporal.q.f(1L, 999999999 - year);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long h(j$.time.temporal.n nVar) {
        if (!(nVar instanceof j$.time.temporal.a)) {
            return nVar.s(this);
        }
        int i2 = v.f53257a[((j$.time.temporal.a) nVar).ordinal()];
        int i3 = this.f53261c;
        x xVar = this.f53260b;
        LocalDate localDate = this.f53259a;
        switch (i2) {
            case 2:
                return i3 == 1 ? (localDate.X() - xVar.f53265b.X()) + 1 : localDate.X();
            case 3:
                return i3;
            case 4:
            case 5:
            case 6:
            case 7:
                throw new j$.time.temporal.p(j$.time.b.a("Unsupported field: ", nVar));
            case 8:
                return xVar.f53264a;
            default:
                return localDate.h(nVar);
        }
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public final w a(long j2, j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) nVar;
            if (h(aVar) == j2) {
                return this;
            }
            int[] iArr = v.f53257a;
            int i2 = iArr[aVar.ordinal()];
            LocalDate localDate = this.f53259a;
            if (i2 == 3 || i2 == 8 || i2 == 9) {
                u uVar = u.f53256c;
                int iA = uVar.Y(aVar).a(j2, aVar);
                int i3 = iArr[aVar.ordinal()];
                if (i3 == 3) {
                    return e0(localDate.q0(uVar.v(this.f53260b, iA)));
                }
                if (i3 == 8) {
                    return e0(localDate.q0(uVar.v(x.t(iA), this.f53261c)));
                }
                if (i3 == 9) {
                    return e0(localDate.q0(iA));
                }
            }
            return e0(localDate.a(j2, nVar));
        }
        return (w) super.a(j2, nVar);
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    /* renamed from: b */
    public final Temporal m(LocalDate localDate) {
        return (w) super.m(localDate);
    }

    public final w d0(j$.time.f fVar) {
        return (w) super.m(fVar);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDate m(j$.time.temporal.l lVar) {
        return (w) super.m(lVar);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDate Q(TemporalAmount temporalAmount) {
        return (w) super.Q(temporalAmount);
    }

    @Override // j$.time.chrono.AbstractC0111c
    public final ChronoLocalDate X(long j2) {
        return e0(this.f53259a.m0(j2));
    }

    @Override // j$.time.chrono.AbstractC0111c
    public final ChronoLocalDate K(long j2) {
        return e0(this.f53259a.k0(j2));
    }

    @Override // j$.time.chrono.AbstractC0111c
    public final ChronoLocalDate J(long j2) {
        return e0(this.f53259a.j0(j2));
    }

    public final w Z(long j2, ChronoUnit chronoUnit) {
        return (w) super.c(j2, (TemporalUnit) chronoUnit);
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final ChronoLocalDate c(long j2, TemporalUnit temporalUnit) {
        return (w) super.c(j2, temporalUnit);
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final Temporal c(long j2, TemporalUnit temporalUnit) {
        return (w) super.c(j2, temporalUnit);
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final ChronoLocalDate d(long j2, TemporalUnit temporalUnit) {
        return (w) super.d(j2, temporalUnit);
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final Temporal d(long j2, TemporalUnit temporalUnit) {
        return (w) super.d(j2, temporalUnit);
    }

    public final w e0(LocalDate localDate) {
        return localDate.equals(this.f53259a) ? this : new w(localDate);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final long toEpochDay() {
        return this.f53259a.toEpochDay();
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w) {
            return this.f53259a.equals(((w) obj).f53259a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new D((byte) 4, this);
    }
}
