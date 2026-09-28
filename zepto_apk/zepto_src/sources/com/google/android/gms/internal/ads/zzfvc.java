package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzfvc {
    public static boolean a(zzbbq zzbbqVar) {
        int iOrdinal = zzbbqVar.ordinal();
        return iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 4 || iOrdinal == 5;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.google.android.gms.internal.ads.zzbbq b(android.content.Context r14, com.google.android.gms.internal.ads.zzfuf r15) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfvc.b(android.content.Context, com.google.android.gms.internal.ads.zzfuf):com.google.android.gms.internal.ads.zzbbq");
    }

    public static final void c(byte[] bArr, String str, zzfuf zzfufVar) {
        if (zzfufVar == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("os.arch:");
        sb.append(System.getProperty("os.arch"));
        sb.append(";");
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get(null);
            if (strArr != null) {
                sb.append("supported_abis:");
                sb.append(Arrays.toString(strArr));
                sb.append(";");
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        sb.append("CPU_ABI:");
        sb.append(Build.CPU_ABI);
        sb.append(";CPU_ABI2:");
        sb.append(Build.CPU_ABI2);
        sb.append(";");
        if (bArr != null) {
            sb.append("ELF:");
            sb.append(Arrays.toString(bArr));
            sb.append(";");
        }
        if (str != null) {
            android.support.v4.media.a.u(sb, "dbg:", str, ";");
        }
        zzfufVar.d(4007, sb.toString());
    }
}
