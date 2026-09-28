package j$.time.format;

import j$.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class o extends i {

    /* renamed from: h, reason: collision with root package name */
    public static final LocalDate f53343h = LocalDate.of(2000, 1, 1);

    /* renamed from: g, reason: collision with root package name */
    public final LocalDate f53344g;

    @Override // j$.time.format.i
    public final boolean b(u uVar) {
        if (uVar.f53363c) {
            return super.b(uVar);
        }
        return false;
    }

    public o(j$.time.temporal.n nVar, int i2, int i3, LocalDate localDate, int i4) {
        super(nVar, i2, i3, D.NOT_NEGATIVE, i4);
        this.f53344g = localDate;
    }

    @Override // j$.time.format.i
    public final long a(w wVar, long j2) {
        long jAbs = Math.abs(j2);
        LocalDate localDate = this.f53344g;
        long j3 = localDate != null ? j$.time.chrono.k.E(wVar.f53370a).t(localDate).j(this.f53319a) : 0;
        long[] jArr = i.f53318f;
        if (j2 >= j3) {
            long j4 = jArr[this.f53320b];
            if (j2 < j3 + j4) {
                return jAbs % j4;
            }
        }
        return jAbs % jArr[this.f53321c];
    }

    @Override // j$.time.format.i
    public final int c(u uVar, long j2, int i2, int i3) {
        final o oVar;
        final u uVar2;
        final long j3;
        final int i4;
        final int i5;
        int iJ;
        long j4;
        LocalDate localDate = this.f53344g;
        if (localDate != null) {
            j$.time.chrono.k kVar = uVar.c().f53275c;
            if (kVar == null && (kVar = uVar.f53361a.f53290e) == null) {
                kVar = j$.time.chrono.r.f53253c;
            }
            iJ = kVar.t(localDate).j(this.f53319a);
            oVar = this;
            uVar2 = uVar;
            j3 = j2;
            i4 = i2;
            i5 = i3;
            Consumer consumer = new Consumer() { // from class: j$.time.format.n
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f53338a.c(uVar2, j3, i4, i5);
                }
            };
            if (uVar2.f53365e == null) {
                uVar2.f53365e = new ArrayList();
            }
            uVar2.f53365e.add(consumer);
        } else {
            oVar = this;
            uVar2 = uVar;
            j3 = j2;
            i4 = i2;
            i5 = i3;
            iJ = 0;
        }
        int i6 = i5 - i4;
        int i7 = oVar.f53320b;
        if (i6 != i7 || j3 < 0) {
            j4 = j3;
        } else {
            long j5 = i.f53318f[i7];
            long j6 = iJ;
            long j7 = j6 - (j6 % j5);
            long j8 = iJ > 0 ? j7 + j3 : j7 - j3;
            j4 = j8 < j6 ? j8 + j5 : j8;
        }
        return uVar2.f(oVar.f53319a, j4, i4, i5);
    }

    @Override // j$.time.format.i
    public final i d() {
        if (this.f53323e == -1) {
            return this;
        }
        return new o(this.f53319a, this.f53320b, this.f53321c, this.f53344g, -1);
    }

    @Override // j$.time.format.i
    public final i e(int i2) {
        int i3 = this.f53323e + i2;
        return new o(this.f53319a, this.f53320b, this.f53321c, this.f53344g, i3);
    }

    @Override // j$.time.format.i
    public final String toString() {
        Object obj = this.f53344g;
        return "ReducedValue(" + this.f53319a + "," + this.f53320b + "," + this.f53321c + "," + (obj != null ? obj : 0) + ")";
    }
}
