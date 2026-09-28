package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaeb {
    public static void a(long j2, zzer zzerVar, zzaga[] zzagaVarArr) {
        int i2;
        int iB;
        while (true) {
            if (zzerVar.B() <= 1) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (zzerVar.B() == 0) {
                    i2 = -1;
                    break;
                }
                int iK = zzerVar.K();
                i3 += iK;
                if (iK != 255) {
                    i2 = i3;
                    break;
                }
            }
            int i4 = 0;
            while (true) {
                if (zzerVar.B() == 0) {
                    i4 = -1;
                    break;
                }
                int iK2 = zzerVar.K();
                i4 += iK2;
                if (iK2 != 255) {
                    break;
                }
            }
            int i5 = zzerVar.f30145b + i4;
            if (i4 == -1 || i4 > zzerVar.B()) {
                zzee.c("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                i5 = zzerVar.f30146c;
            } else if (i2 == 4 && i4 >= 8) {
                int iK3 = zzerVar.K();
                int iL = zzerVar.L();
                if (iL == 49) {
                    iB = zzerVar.b();
                    iL = 49;
                } else {
                    iB = 0;
                }
                int iK4 = zzerVar.K();
                if (iL == 47) {
                    zzerVar.G(1);
                    iL = 47;
                }
                boolean z = iK3 == 181 && (iL == 49 || iL == 47) && iK4 == 3;
                if (iL == 49) {
                    z &= iB == 1195456820;
                }
                if (z) {
                    b(j2, zzerVar, zzagaVarArr);
                }
            }
            zzerVar.E(i5);
        }
    }

    public static void b(long j2, zzer zzerVar, zzaga[] zzagaVarArr) {
        int iK = zzerVar.K();
        if ((iK & 64) != 0) {
            int i2 = iK & 31;
            zzerVar.G(1);
            int i3 = zzerVar.f30145b;
            for (zzaga zzagaVar : zzagaVarArr) {
                int i4 = i2 * 3;
                zzerVar.E(i3);
                zzagaVar.b(i4, zzerVar);
                zzgqa.f(j2 != -9223372036854775807L);
                zzagaVar.e(j2, 1, i4, 0, null);
            }
        }
    }
}
