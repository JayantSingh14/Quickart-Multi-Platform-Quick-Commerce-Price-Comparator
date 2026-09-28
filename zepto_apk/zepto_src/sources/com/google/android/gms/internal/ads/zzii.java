package com.google.android.gms.internal.ads;

import android.util.Pair;

/* loaded from: classes4.dex */
public abstract class zzii extends zzbf {

    /* renamed from: b, reason: collision with root package name */
    public final int f34838b;

    /* renamed from: c, reason: collision with root package name */
    public final zzxz f34839c;

    public zzii(zzxz zzxzVar) {
        this.f34839c = zzxzVar;
        this.f34838b = zzxzVar.f35885b.length;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final zzbe b(int i2, zzbe zzbeVar, long j2) {
        int iQ = q(i2);
        int iU = u(iQ);
        int iT = t(iQ);
        s(iQ).b(i2 - iU, zzbeVar, j2);
        Object objV = v(iQ);
        if (!zzbe.f24822m.equals(zzbeVar.f24823a)) {
            objV = Pair.create(objV, zzbeVar.f24823a);
        }
        zzbeVar.f24823a = objV;
        zzbeVar.f24833k += iT;
        zzbeVar.f24834l += iT;
        return zzbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final zzbd d(int i2, zzbd zzbdVar, boolean z) {
        int iP = p(i2);
        int iU = u(iP);
        s(iP).d(i2 - t(iP), zzbdVar, z);
        zzbdVar.f24739c += iU;
        if (z) {
            Object objV = v(iP);
            Object obj = zzbdVar.f24738b;
            obj.getClass();
            zzbdVar.f24738b = Pair.create(objV, obj);
        }
        return zzbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int e(Object obj) {
        int iE;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            int iR = r(obj2);
            if (iR != -1 && (iE = s(iR).e(obj3)) != -1) {
                return t(iR) + iE;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final Object f(int i2) {
        int iP = p(i2);
        return Pair.create(v(iP), s(iP).f(i2 - t(iP)));
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int h(int i2, int i3, boolean z) {
        int iQ = q(i2);
        int iU = u(iQ);
        int iH = s(iQ).h(i2 - iU, i3 == 2 ? 0 : i3, z);
        if (iH != -1) {
            return iU + iH;
        }
        int iW = w(iQ, z);
        while (iW != -1 && s(iW).g()) {
            iW = w(iW, z);
        }
        if (iW != -1) {
            return s(iW).k(z) + u(iW);
        }
        if (i3 == 2) {
            return k(z);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int i(int i2) {
        int iQ = q(i2);
        int iU = u(iQ);
        int i3 = s(iQ).i(i2 - iU);
        if (i3 != -1) {
            return iU + i3;
        }
        int iX = x(iQ, false);
        while (iX != -1 && s(iX).g()) {
            iX = x(iX, false);
        }
        if (iX == -1) {
            return -1;
        }
        return s(iX).j(false) + u(iX);
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int j(boolean z) {
        int iX;
        int i2 = this.f34838b;
        if (i2 != 0) {
            if (z) {
                int[] iArr = this.f34839c.f35885b;
                int length = iArr.length;
                iX = length > 0 ? iArr[length - 1] : -1;
            } else {
                iX = i2 - 1;
            }
            while (s(iX).g()) {
                iX = x(iX, z);
                if (iX == -1) {
                }
            }
            return s(iX).j(z) + u(iX);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int k(boolean z) {
        if (this.f34838b != 0) {
            int iW = 0;
            if (z) {
                int[] iArr = this.f34839c.f35885b;
                iW = iArr.length > 0 ? iArr[0] : -1;
            }
            while (s(iW).g()) {
                iW = w(iW, z);
                if (iW == -1) {
                }
            }
            return s(iW).k(z) + u(iW);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final zzbd o(Object obj, zzbd zzbdVar) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int iR = r(obj2);
        int iU = u(iR);
        s(iR).o(obj3, zzbdVar);
        zzbdVar.f24739c += iU;
        zzbdVar.f24738b = obj;
        return zzbdVar;
    }

    public abstract int p(int i2);

    public abstract int q(int i2);

    public abstract int r(Object obj);

    public abstract zzbf s(int i2);

    public abstract int t(int i2);

    public abstract int u(int i2);

    public abstract Object v(int i2);

    public final int w(int i2, boolean z) {
        if (!z) {
            if (i2 >= this.f34838b - 1) {
                return -1;
            }
            return i2 + 1;
        }
        zzxz zzxzVar = this.f34839c;
        int i3 = zzxzVar.f35886c[i2] + 1;
        int[] iArr = zzxzVar.f35885b;
        if (i3 < iArr.length) {
            return iArr[i3];
        }
        return -1;
    }

    public final int x(int i2, boolean z) {
        if (!z) {
            if (i2 <= 0) {
                return -1;
            }
            return i2 - 1;
        }
        zzxz zzxzVar = this.f34839c;
        int i3 = zzxzVar.f35886c[i2] - 1;
        if (i3 >= 0) {
            return zzxzVar.f35885b[i3];
        }
        return -1;
    }
}
