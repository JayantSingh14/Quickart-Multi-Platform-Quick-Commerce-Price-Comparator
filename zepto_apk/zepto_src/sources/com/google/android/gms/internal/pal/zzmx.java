package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzmx {
    public static long a(int i2, byte[] bArr) {
        return (((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16)) & 4294967295L;
    }

    public static void b(byte[] bArr, int i2, long j2) {
        int i3 = 0;
        while (i3 < 4) {
            bArr[i2 + i3] = (byte) (255 & j2);
            i3++;
            j2 >>= 8;
        }
    }
}
