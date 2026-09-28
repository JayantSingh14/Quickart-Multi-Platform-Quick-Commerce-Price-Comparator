package j$.time.chrono;

import j$.time.LocalDate;
import j$.time.LocalTime;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.TemporalUnit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class H extends AbstractC0111c {
    private static final long serialVersionUID = -8722293800195731463L;

    /* renamed from: a, reason: collision with root package name */
    public final transient LocalDate f53218a;

    @Override // j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDateTime M(LocalTime localTime) {
        return new C0113e(this, localTime);
    }

    public H(LocalDate localDate) {
        Objects.requireNonNull(localDate, "isoDate");
        this.f53218a = localDate;
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate
    public final int hashCode() {
        F.f53216c.getClass();
        return this.f53218a.hashCode() ^ 146118545;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final k i() {
        return F.f53216c;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final l u() {
        return Z() >= 1 ? I.BE : I.BEFORE_BE;
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
        int i2 = G.f53217a[aVar.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return this.f53218a.l(nVar);
        }
        if (i2 != 4) {
            return F.f53216c.Y(aVar);
        }
        j$.time.temporal.q qVar = j$.time.temporal.a.YEAR.f53410b;
        return j$.time.temporal.q.f(1L, Z() <= 0 ? (-(qVar.f53435a + 543)) + 1 : 543 + qVar.f53438d);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public final long h(j$.time.temporal.n nVar) {
        if (nVar instanceof j$.time.temporal.a) {
            int i2 = G.f53217a[((j$.time.temporal.a) nVar).ordinal()];
            if (i2 == 4) {
                int iZ = Z();
                if (iZ < 1) {
                    iZ = 1 - iZ;
                }
                return iZ;
            }
            LocalDate localDate = this.f53218a;
            if (i2 == 5) {
                return ((Z() * 12) + localDate.getMonthValue()) - 1;
            }
            if (i2 == 6) {
                return Z();
            }
            if (i2 != 7) {
                return localDate.h(nVar);
            }
            return Z() < 1 ? 0 : 1;
        }
        return nVar.s(this);
    }

    public final int Z() {
        return this.f53218a.getYear() + 543;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.chrono.H a(long r9, j$.time.temporal.n r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof j$.time.temporal.a
            if (r0 == 0) goto L99
            r0 = r11
            j$.time.temporal.a r0 = (j$.time.temporal.a) r0
            long r1 = r8.h(r0)
            int r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r1 != 0) goto L10
            return r8
        L10:
            int[] r1 = j$.time.chrono.G.f53217a
            int r2 = r0.ordinal()
            r2 = r1[r2]
            j$.time.LocalDate r3 = r8.f53218a
            r4 = 7
            r5 = 6
            r6 = 4
            if (r2 == r6) goto L4b
            r7 = 5
            if (r2 == r7) goto L27
            if (r2 == r5) goto L4b
            if (r2 == r4) goto L4b
            goto L61
        L27:
            j$.time.chrono.F r11 = j$.time.chrono.F.f53216c
            j$.time.temporal.q r11 = r11.Y(r0)
            r11.b(r9, r0)
            int r11 = r8.Z()
            long r0 = (long) r11
            r4 = 12
            long r0 = r0 * r4
            int r11 = r3.getMonthValue()
            long r4 = (long) r11
            long r0 = r0 + r4
            r4 = 1
            long r0 = r0 - r4
            long r9 = r9 - r0
            j$.time.LocalDate r9 = r3.k0(r9)
            j$.time.chrono.H r9 = r8.d0(r9)
            return r9
        L4b:
            j$.time.chrono.F r2 = j$.time.chrono.F.f53216c
            j$.time.temporal.q r2 = r2.Y(r0)
            int r2 = r2.a(r9, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r6) goto L84
            if (r0 == r5) goto L79
            if (r0 == r4) goto L6a
        L61:
            j$.time.LocalDate r9 = r3.a(r9, r11)
            j$.time.chrono.H r9 = r8.d0(r9)
            return r9
        L6a:
            int r9 = r8.Z()
            int r9 = (-542) - r9
            j$.time.LocalDate r9 = r3.q0(r9)
            j$.time.chrono.H r9 = r8.d0(r9)
            return r9
        L79:
            int r2 = r2 + (-543)
            j$.time.LocalDate r9 = r3.q0(r2)
            j$.time.chrono.H r9 = r8.d0(r9)
            return r9
        L84:
            int r9 = r8.Z()
            r10 = 1
            if (r9 < r10) goto L8c
            goto L8e
        L8c:
            int r2 = 1 - r2
        L8e:
            int r2 = r2 + (-543)
            j$.time.LocalDate r9 = r3.q0(r2)
            j$.time.chrono.H r9 = r8.d0(r9)
            return r9
        L99:
            j$.time.chrono.ChronoLocalDate r9 = super.a(r9, r11)
            j$.time.chrono.H r9 = (j$.time.chrono.H) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.H.a(long, j$.time.temporal.n):j$.time.chrono.H");
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    /* renamed from: b */
    public final Temporal m(LocalDate localDate) {
        return (H) super.m(localDate);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDate m(j$.time.temporal.l lVar) {
        return (H) super.m(lVar);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final ChronoLocalDate Q(TemporalAmount temporalAmount) {
        return (H) super.Q(temporalAmount);
    }

    @Override // j$.time.chrono.AbstractC0111c
    public final ChronoLocalDate X(long j2) {
        return d0(this.f53218a.m0(j2));
    }

    @Override // j$.time.chrono.AbstractC0111c
    public final ChronoLocalDate K(long j2) {
        return d0(this.f53218a.k0(j2));
    }

    @Override // j$.time.chrono.AbstractC0111c
    public final ChronoLocalDate J(long j2) {
        return d0(this.f53218a.j0(j2));
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final ChronoLocalDate c(long j2, TemporalUnit temporalUnit) {
        return (H) super.c(j2, temporalUnit);
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final Temporal c(long j2, TemporalUnit temporalUnit) {
        return (H) super.c(j2, temporalUnit);
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final ChronoLocalDate d(long j2, TemporalUnit temporalUnit) {
        return (H) super.d(j2, temporalUnit);
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate, j$.time.temporal.Temporal
    public final Temporal d(long j2, TemporalUnit temporalUnit) {
        return (H) super.d(j2, temporalUnit);
    }

    public final H d0(LocalDate localDate) {
        return localDate.equals(this.f53218a) ? this : new H(localDate);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public final long toEpochDay() {
        return this.f53218a.toEpochDay();
    }

    @Override // j$.time.chrono.AbstractC0111c, j$.time.chrono.ChronoLocalDate
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof H) {
            return this.f53218a.equals(((H) obj).f53218a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new D((byte) 8, this);
    }
}
