package com.google.android.gms.internal.ads;

import android.util.Pair;

/* loaded from: classes4.dex */
public abstract class zzbf {

    /* renamed from: a, reason: collision with root package name */
    public static final zzbf f24868a = new zzbc();

    static {
        String str = zzfj.f31254a;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
    }

    public abstract int a();

    public abstract zzbe b(int i2, zzbe zzbeVar, long j2);

    public abstract int c();

    public abstract zzbd d(int i2, zzbd zzbdVar, boolean z);

    public abstract int e(Object obj);

    public final boolean equals(Object obj) {
        int iJ;
        if (this != obj) {
            if (obj instanceof zzbf) {
                zzbf zzbfVar = (zzbf) obj;
                if (zzbfVar.a() == a() && zzbfVar.c() == c()) {
                    zzbe zzbeVar = new zzbe();
                    zzbd zzbdVar = new zzbd();
                    zzbe zzbeVar2 = new zzbe();
                    zzbd zzbdVar2 = new zzbd();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= a()) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= c()) {
                                    int iK = k(true);
                                    if (iK == zzbfVar.k(true) && (iJ = j(true)) == zzbfVar.j(true)) {
                                        while (iK != iJ) {
                                            int iH = h(iK, 0, true);
                                            if (iH == zzbfVar.h(iK, 0, true)) {
                                                iK = iH;
                                            }
                                        }
                                    }
                                } else {
                                    if (!d(i3, zzbdVar, true).equals(zzbfVar.d(i3, zzbdVar2, true))) {
                                        break;
                                    }
                                    i3++;
                                }
                            }
                        } else {
                            if (!b(i2, zzbeVar, 0L).equals(zzbfVar.b(i2, zzbeVar2, 0L))) {
                                break;
                            }
                            i2++;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public abstract Object f(int i2);

    public final boolean g() {
        return a() == 0;
    }

    public int h(int i2, int i3, boolean z) {
        if (i3 == 0) {
            if (i2 == j(z)) {
                return -1;
            }
            return i2 + 1;
        }
        if (i3 == 1) {
            return i2;
        }
        if (i3 == 2) {
            return i2 == j(z) ? k(z) : i2 + 1;
        }
        throw new IllegalStateException();
    }

    public final int hashCode() {
        int i2;
        zzbe zzbeVar = new zzbe();
        zzbd zzbdVar = new zzbd();
        int iA = a() + 217;
        int i3 = 0;
        while (true) {
            i2 = iA * 31;
            if (i3 >= a()) {
                break;
            }
            iA = i2 + b(i3, zzbeVar, 0L).hashCode();
            i3++;
        }
        int iC = c() + i2;
        for (int i4 = 0; i4 < c(); i4++) {
            iC = (iC * 31) + d(i4, zzbdVar, true).hashCode();
        }
        int iK = k(true);
        while (iK != -1) {
            iC = (iC * 31) + iK;
            iK = h(iK, 0, true);
        }
        return iC;
    }

    public int i(int i2) {
        if (i2 == k(false)) {
            return -1;
        }
        return i2 - 1;
    }

    public int j(boolean z) {
        if (g()) {
            return -1;
        }
        return a() - 1;
    }

    public int k(boolean z) {
        return g() ? -1 : 0;
    }

    public final int l(int i2, zzbd zzbdVar, zzbe zzbeVar, int i3, boolean z) {
        int i4 = d(i2, zzbdVar, false).f24739c;
        if (b(i4, zzbeVar, 0L).f24834l != i2) {
            return i2 + 1;
        }
        int iH = h(i4, i3, z);
        if (iH == -1) {
            return -1;
        }
        return b(iH, zzbeVar, 0L).f24833k;
    }

    public final Pair m(zzbe zzbeVar, zzbd zzbdVar, int i2, long j2) {
        Pair pairN = n(zzbeVar, zzbdVar, i2, j2, 0L);
        pairN.getClass();
        return pairN;
    }

    public final Pair n(zzbe zzbeVar, zzbd zzbdVar, int i2, long j2, long j3) {
        zzgqa.i(i2, a());
        b(i2, zzbeVar, j3);
        if (j2 == -9223372036854775807L) {
            zzbeVar.getClass();
            j2 = 0;
        }
        int i3 = zzbeVar.f24833k;
        d(i3, zzbdVar, false);
        while (i3 < zzbeVar.f24834l) {
            zzbdVar.getClass();
            if (j2 == 0) {
                break;
            }
            int i4 = i3 + 1;
            d(i4, zzbdVar, false).getClass();
            if (j2 < 0) {
                break;
            }
            i3 = i4;
        }
        d(i3, zzbdVar, true);
        zzbdVar.getClass();
        long j4 = zzbdVar.f24740d;
        if (j4 != -9223372036854775807L) {
            j2 = Math.min(j2, j4 - 1);
        }
        long jMax = Math.max(0L, j2);
        Object obj = zzbdVar.f24738b;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(jMax));
    }

    public zzbd o(Object obj, zzbd zzbdVar) {
        return d(e(obj), zzbdVar, true);
    }
}
