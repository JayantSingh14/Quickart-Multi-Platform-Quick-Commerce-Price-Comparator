package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzaey {
    public static zzafa a(zzer zzerVar) {
        zzerVar.G(1);
        int iO = zzerVar.O();
        long j2 = zzerVar.f30145b;
        long j3 = iO;
        int i2 = iO / 18;
        long[] jArrCopyOf = new long[i2];
        long[] jArrCopyOf2 = new long[i2];
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            long jD = zzerVar.d();
            if (jD == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i3);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i3);
                break;
            }
            jArrCopyOf[i3] = jD;
            jArrCopyOf2[i3] = zzerVar.d();
            zzerVar.G(2);
            i3++;
        }
        zzerVar.G((int) ((j2 + j3) - zzerVar.f30145b));
        return new zzafa(jArrCopyOf, jArrCopyOf2);
    }
}
