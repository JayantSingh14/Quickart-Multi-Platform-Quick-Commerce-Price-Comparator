package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaew {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055 A[PHI: r25
      0x0055: PHI (r25v1 long) = (r25v0 long), (r25v2 long) binds: [B:17:0x0053, B:12:0x004a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(com.google.android.gms.internal.ads.zzer r27, com.google.android.gms.internal.ads.zzafb r28, int r29, com.google.android.gms.internal.ads.zzaev r30) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaew.a(com.google.android.gms.internal.ads.zzer, com.google.android.gms.internal.ads.zzafb, int, com.google.android.gms.internal.ads.zzaev):boolean");
    }

    public static int b(int i2, zzer zzerVar) {
        switch (i2) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i2 - 2);
            case 6:
                return zzerVar.K() + 1;
            case 7:
                return zzerVar.L() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i2 - 8);
            default:
                return -1;
        }
    }

    public static boolean c(zzer zzerVar, zzafb zzafbVar, boolean z, zzaev zzaevVar) {
        try {
            long jO = zzerVar.o();
            if (!z) {
                jO *= zzafbVar.f22905b;
            }
            long j2 = zzafbVar.f22913j;
            if (j2 != 0 && jO > j2) {
                return false;
            }
            zzaevVar.f22898a = jO;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
