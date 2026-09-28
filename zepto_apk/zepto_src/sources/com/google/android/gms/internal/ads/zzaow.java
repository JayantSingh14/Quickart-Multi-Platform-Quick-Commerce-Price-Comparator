package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzaow {
    public static void a(zzeq zzeqVar) {
        int iH;
        int iH2 = zzeqVar.h(2);
        if (iH2 == 0) {
            zzeqVar.f(6);
            return;
        }
        int iC = c(zzeqVar, 5, 8, 16) + 1;
        if (iH2 == 1) {
            zzeqVar.f(iC * 7);
            return;
        }
        if (iH2 == 2) {
            boolean zG = zzeqVar.g();
            int i2 = true != zG ? 5 : 1;
            int i3 = true == zG ? 7 : 5;
            int i4 = true == zG ? 8 : 6;
            int i5 = 0;
            while (i5 < iC) {
                if (zzeqVar.g()) {
                    zzeqVar.f(7);
                    iH = 0;
                } else {
                    if (zzeqVar.h(2) == 3 && zzeqVar.h(i3) * i2 != 0) {
                        zzeqVar.e();
                    }
                    iH = zzeqVar.h(i4) * i2;
                    if (iH != 0 && iH != 180) {
                        zzeqVar.e();
                    }
                    zzeqVar.e();
                }
                if (iH != 0 && iH != 180 && zzeqVar.g()) {
                    i5++;
                }
                i5++;
            }
        }
    }

    public static void b(zzeq zzeqVar) {
        zzeqVar.f(3);
        zzeqVar.f(8);
        boolean zG = zzeqVar.g();
        boolean zG2 = zzeqVar.g();
        if (zG) {
            zzeqVar.f(5);
        }
        if (zG2) {
            zzeqVar.f(6);
        }
    }

    public static int c(zzeq zzeqVar, int i2, int i3, int i4) {
        zzgqa.a(Math.max(Math.max(i2, i3), i4) <= 31);
        int i5 = (1 << i2) - 1;
        int i6 = (1 << i3) - 1;
        Math.addExact(Math.addExact(i5, i6), 1 << i4);
        if (zzeqVar.b() >= i2) {
            int iH = zzeqVar.h(i2);
            if (iH == i5) {
                if (zzeqVar.b() >= i3) {
                    int iH2 = zzeqVar.h(i3);
                    iH += iH2;
                    if (iH2 == i6) {
                        if (zzeqVar.b() >= i4) {
                            return zzeqVar.h(i4) + iH;
                        }
                    }
                }
            }
            return iH;
        }
        return -1;
    }
}
