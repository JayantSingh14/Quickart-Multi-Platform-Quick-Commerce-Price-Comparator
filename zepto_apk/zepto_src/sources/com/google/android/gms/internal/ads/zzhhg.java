package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhhg {
    public static void a(int i2, long[] jArr, long[] jArr2) {
        for (int i3 = 0; i3 < 10; i3++) {
            int i4 = (int) jArr[i3];
            jArr[i3] = ((-i2) & (((int) jArr2[i3]) ^ i4)) ^ i4;
        }
    }
}
