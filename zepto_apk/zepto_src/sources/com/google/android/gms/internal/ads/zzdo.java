package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import java.util.Locale;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
/* loaded from: classes4.dex */
public final class zzdo {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f28067a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f28068b = {"", "A", "B", "C"};

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f28069c = Pattern.compile("^\\D?(\\d+)$");

    public static String a(int i2, boolean z, int i3, int i4, int[] iArr, int i5) {
        int i6;
        Object[] objArr = {f28068b[i2], Integer.valueOf(i3), Integer.valueOf(i4), Character.valueOf(true != z ? 'L' : 'H'), Integer.valueOf(i5)};
        String str = zzfj.f31254a;
        StringBuilder sb = new StringBuilder(String.format(Locale.US, "hvc1.%s%d.%X.%c%d", objArr));
        int i7 = 6;
        while (true) {
            if (i7 <= 0) {
                break;
            }
            int i8 = i7 - 1;
            if (iArr[i8] != 0) {
                break;
            }
            i7 = i8;
        }
        for (i6 = 0; i6 < i7; i6++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i6])));
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:145:0x026c A[PHI: r20
      0x026c: PHI (r20v13 int) = 
      (r20v1 int)
      (r20v2 int)
      (r20v3 int)
      (r20v4 int)
      (r20v5 int)
      (r20v6 int)
      (r20v7 int)
      (r20v8 int)
      (r20v9 int)
      (r20v10 int)
      (r20v11 int)
      (r20v14 int)
     binds: [B:143:0x0267, B:140:0x025b, B:137:0x024f, B:134:0x0243, B:131:0x0237, B:128:0x022b, B:125:0x021f, B:122:0x0212, B:119:0x0205, B:116:0x01f8, B:113:0x01eb, B:111:0x01df] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair b(com.google.android.gms.internal.ads.zzv r21) {
        /*
            Method dump skipped, instructions count: 2124
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdo.b(com.google.android.gms.internal.ads.zzv):android.util.Pair");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair c(java.lang.String r10, java.lang.String[] r11, com.google.android.gms.internal.ads.zzi r12) {
        /*
            Method dump skipped, instructions count: 762
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdo.c(java.lang.String, java.lang.String[], com.google.android.gms.internal.ads.zzi):android.util.Pair");
    }
}
