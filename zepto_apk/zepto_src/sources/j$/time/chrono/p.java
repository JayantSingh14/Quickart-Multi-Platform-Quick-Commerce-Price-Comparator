package j$.time.chrono;

import j$.time.DateTimeException;
import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class p extends AbstractC0111c {
    private static final long serialVersionUID = -5207853542612002020L;

    /* renamed from: a, reason: collision with root package name */
    public final transient n f53248a;

    /* renamed from: b, reason: collision with root package name */
    public final transient int f53249b;

    /* renamed from: c, reason: collision with root package name */
    public final transient int f53250c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f53251d;

    @Override // j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDateTime M(LocalTime localTime) {
        return new C0113e(this, localTime);
    }

    public p(n nVar, int i2, int i3, int i4) {
        nVar.e0(i2, i3, i4);
        this.f53248a = nVar;
        this.f53249b = i2;
        this.f53250c = i3;
        this.f53251d = i4;
    }

    public p(n nVar, long j2) {
        int i2 = (int) j2;
        nVar.Z();
        if (i2 < nVar.f53240e || i2 >= nVar.f53241f) {
            throw new DateTimeException("Hijrah date out of range");
        }
        int iBinarySearch = Arrays.binarySearch(nVar.f53239d, i2);
        iBinarySearch = iBinarySearch < 0 ? (-iBinarySearch) - 2 : iBinarySearch;
        int[] iArr = {nVar.d0(iBinarySearch), ((nVar.f53242g + iBinarySearch) % 12) + 1, (i2 - nVar.f53239d[iBinarySearch]) + 1};
        this.f53248a = nVar;
        this.f53249b = iArr[0];
        this.f53250c = iArr[1];
        this.f53251d = iArr[2];
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final k i() {
        return this.f53248a;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final l u() {
        return q.AH;
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate
    public final int hashCode() {
        this.f53248a.getClass();
        int i2 = this.f53249b;
        return (((i2 << 11) + (this.f53250c << 6)) + this.f53251d) ^ ((i2 & (-2048)) ^ 2100100019);
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
        int i2 = o.f53247a[aVar.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? this.f53248a.Y(aVar) : j$.time.temporal.q.f(1L, 5L) : j$.time.temporal.q.f(1L, L()) : j$.time.temporal.q.f(1L, r2.f0(this.f53249b, this.f53250c));
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long h(j$.time.temporal.n nVar) {
        if (!(nVar instanceof j$.time.temporal.a)) {
            return nVar.s(this);
        }
        int i2 = o.f53247a[((j$.time.temporal.a) nVar).ordinal()];
        int i3 = this.f53250c;
        int i4 = this.f53251d;
        int i5 = this.f53249b;
        switch (i2) {
            case 1:
                return i4;
            case 2:
                return Z();
            case 3:
                return ((i4 - 1) / 7) + 1;
            case 4:
                return ((int) Math.floorMod(toEpochDay() + 3, 7)) + 1;
            case 5:
                return ((i4 - 1) % 7) + 1;
            case 6:
                return ((Z() - 1) % 7) + 1;
            case 7:
                return toEpochDay();
            case 8:
                return ((Z() - 1) / 7) + 1;
            case 9:
                return i3;
            case 10:
                return ((i5 * 12) + i3) - 1;
            case 11:
                return i5;
            case 12:
                return i5;
            case 13:
                return i5 <= 1 ? 0 : 1;
            default:
                throw new j$.time.temporal.p(j$.time.b.a("Unsupported field: ", nVar));
        }
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public final p a(long j2, j$.time.temporal.n nVar) {
        if (!(nVar instanceof j$.time.temporal.a)) {
            return (p) super.a(j2, nVar);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) nVar;
        n nVar2 = this.f53248a;
        nVar2.Y(aVar).b(j2, aVar);
        int i2 = (int) j2;
        int i3 = o.f53247a[aVar.ordinal()];
        int i4 = this.f53251d;
        int i5 = this.f53250c;
        int i6 = this.f53249b;
        switch (i3) {
            case 1:
                return e0(i6, i5, i2);
            case 2:
                return J(Math.min(i2, L()) - Z());
            case 3:
                return J((j2 - h(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 4:
                return J(j2 - (((int) Math.floorMod(toEpochDay() + 3, 7)) + 1));
            case 5:
                return J(j2 - h(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 6:
                return J(j2 - h(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 7:
                return new p(nVar2, j2);
            case 8:
                return J((j2 - h(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 9:
                return e0(i6, i2, i4);
            case 10:
                return K(j2 - (((i6 * 12) + i5) - 1));
            case 11:
                if (i6 < 1) {
                    i2 = 1 - i2;
                }
                return e0(i2, i5, i4);
            case 12:
                return e0(i2, i5, i4);
            case 13:
                return e0(1 - i6, i5, i4);
            default:
                throw new j$.time.temporal.p(j$.time.b.a("Unsupported field: ", nVar));
        }
    }

    public final p e0(int i2, int i3, int i4) {
        n nVar = this.f53248a;
        int iF0 = nVar.f0(i2, i3);
        if (i4 > iF0) {
            i4 = iF0;
        }
        return new p(nVar, i2, i3, i4);
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    /* renamed from: b */
    public final Temporal m(LocalDate localDate) {
        return (p) super.m(localDate);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDate m(j$.time.temporal.l lVar) {
        return (p) super.m(lVar);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDate Q(TemporalAmount temporalAmount) {
        return (p) super.Q(temporalAmount);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final long toEpochDay() {
        return this.f53248a.e0(this.f53249b, this.f53250c, this.f53251d);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final boolean R() {
        return this.f53248a.C(this.f53249b);
    }

    @Override // j$.time.chrono.AbstractC0111c
    public final ChronoLocalDate X(long j2) {
        return j2 == 0 ? this : e0(Math.addExact(this.f53249b, (int) j2), this.f53250c, this.f53251d);
    }

    @Override // j$.time.chrono.AbstractC0111c
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public final p K(long j2) {
        if (j2 == 0) {
            return this;
        }
        long j3 = (this.f53249b * 12) + (this.f53250c - 1) + j2;
        long jFloorDiv = Math.floorDiv(j3, 12L);
        n nVar = this.f53248a;
        if (jFloorDiv >= nVar.d0(0) && jFloorDiv <= nVar.d0(nVar.f53239d.length - 1) - 1) {
            return e0((int) jFloorDiv, ((int) Math.floorMod(j3, 12L)) + 1, this.f53251d);
        }
        throw new DateTimeException("Invalid Hijrah year: " + jFloorDiv);
    }

    @Override // j$.time.chrono.AbstractC0111c
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public final p J(long j2) {
        return new p(this.f53248a, toEpochDay() + j2);
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final ChronoLocalDate c(long j2, TemporalUnit temporalUnit) {
        return (p) super.c(j2, temporalUnit);
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final Temporal c(long j2, TemporalUnit temporalUnit) {
        return (p) super.c(j2, temporalUnit);
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final ChronoLocalDate d(long j2, TemporalUnit temporalUnit) {
        return (p) super.d(j2, temporalUnit);
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final Temporal d(long j2, TemporalUnit temporalUnit) {
        return (p) super.d(j2, temporalUnit);
    }

    public final int Z() {
        return this.f53248a.h0(this.f53249b, this.f53250c - 1) + this.f53251d;
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.f53249b == pVar.f53249b && this.f53250c == pVar.f53250c && this.f53251d == pVar.f53251d && this.f53248a.equals(pVar.f53248a)) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final int L() {
        return this.f53248a.h0(this.f53249b, 12);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new D((byte) 6, this);
    }
}
