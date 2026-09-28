package com.google.android.gms.internal.ads;

import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes4.dex */
public final class zzads {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f22821a = {2002, 2000, 1920, 1601, 1600, DateUtils.SEMI_MONTH, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX WARN: Removed duplicated region for block: B:41:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzadr a(com.google.android.gms.internal.ads.zzeq r10) {
        /*
            r0 = 16
            int r1 = r10.h(r0)
            int r0 = r10.h(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r10.h(r0)
            r2 = 7
            goto L19
        L18:
            r2 = r3
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r1 = 2
            int r2 = r10.h(r1)
            r4 = 3
            if (r2 != r4) goto L32
        L29:
            r10.h(r1)
            boolean r2 = r10.g()
            if (r2 != 0) goto L29
        L32:
            r2 = 10
            int r2 = r10.h(r2)
            boolean r5 = r10.g()
            if (r5 == 0) goto L47
            int r5 = r10.h(r4)
            if (r5 <= 0) goto L47
            r10.f(r1)
        L47:
            boolean r5 = r10.g()
            r6 = 1
            r7 = 48000(0xbb80, float:6.7262E-41)
            r8 = 44100(0xac44, float:6.1797E-41)
            if (r6 == r5) goto L56
            r5 = r8
            goto L57
        L56:
            r5 = r7
        L57:
            int r10 = r10.h(r3)
            int[] r9 = com.google.android.gms.internal.ads.zzads.f22821a
            if (r5 != r8) goto L66
            r8 = 13
            if (r10 != r8) goto L66
            r10 = r9[r8]
            goto L94
        L66:
            r8 = 0
            if (r5 != r7) goto L93
            r7 = 14
            if (r10 >= r7) goto L93
            r7 = r9[r10]
            int r2 = r2 % 5
            r8 = 8
            if (r2 == r6) goto L8c
            r6 = 11
            if (r2 == r1) goto L87
            if (r2 == r4) goto L8c
            if (r2 == r3) goto L7e
            goto L91
        L7e:
            if (r10 == r4) goto L84
            if (r10 == r8) goto L84
            if (r10 != r6) goto L91
        L84:
            int r10 = r7 + 1
            goto L94
        L87:
            if (r10 == r8) goto L84
            if (r10 != r6) goto L91
            goto L84
        L8c:
            if (r10 == r4) goto L84
            if (r10 != r8) goto L91
            goto L84
        L91:
            r10 = r7
            goto L94
        L93:
            r10 = r8
        L94:
            com.google.android.gms.internal.ads.zzadr r1 = new com.google.android.gms.internal.ads.zzadr
            r1.<init>(r5, r0, r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzads.a(com.google.android.gms.internal.ads.zzeq):com.google.android.gms.internal.ads.zzadr");
    }

    public static void b(int i2, zzer zzerVar) {
        zzerVar.y(7);
        byte[] bArr = zzerVar.f30144a;
        bArr[0] = -84;
        bArr[1] = 64;
        bArr[2] = -1;
        bArr[3] = -1;
        bArr[4] = (byte) ((i2 >> 16) & 255);
        bArr[5] = (byte) ((i2 >> 8) & 255);
        bArr[6] = (byte) (i2 & 255);
    }

    public static void c(zzeq zzeqVar, zzadq zzadqVar) throws zzat {
        int iH = zzeqVar.h(5);
        zzeqVar.f(2);
        if (zzeqVar.g()) {
            zzeqVar.f(5);
        }
        if (iH >= 7 && iH <= 10) {
            zzeqVar.e();
        }
        if (zzeqVar.g()) {
            int iH2 = zzeqVar.h(3);
            if (zzadqVar.f22812b == -1 && iH >= 0 && iH <= 15 && (iH2 == 0 || iH2 == 1)) {
                zzadqVar.f22812b = iH;
            }
            if (zzeqVar.g()) {
                e(zzeqVar);
            }
        }
    }

    public static void d(zzeq zzeqVar, zzadq zzadqVar) throws zzat {
        zzeqVar.f(2);
        boolean zG = zzeqVar.g();
        int iH = zzeqVar.h(8);
        for (int i2 = 0; i2 < iH; i2++) {
            zzeqVar.f(2);
            if (zzeqVar.g()) {
                zzeqVar.f(5);
            }
            if (zG) {
                zzeqVar.f(24);
            } else {
                if (zzeqVar.g()) {
                    if (!zzeqVar.g()) {
                        zzeqVar.f(4);
                    }
                    zzadqVar.f22813c = zzeqVar.h(6) + 1;
                }
                zzeqVar.f(4);
            }
        }
        if (zzeqVar.g()) {
            zzeqVar.f(3);
            if (zzeqVar.g()) {
                e(zzeqVar);
            }
        }
    }

    public static void e(zzeq zzeqVar) throws zzat {
        int iH = zzeqVar.h(6);
        if (iH < 2 || iH > 42) {
            throw zzat.b(String.format("Invalid language tag bytes number: %d. Must be between 2 and 42.", Integer.valueOf(iH)));
        }
        zzeqVar.f(iH * 8);
    }
}
