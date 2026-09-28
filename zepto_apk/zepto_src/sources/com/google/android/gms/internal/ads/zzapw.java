package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzapw {
    public static long a(zzer zzerVar, int i2, int i3) {
        zzerVar.E(i2);
        if (zzerVar.B() < 5) {
            return -9223372036854775807L;
        }
        int iB = zzerVar.b();
        if ((8388608 & iB) != 0 || ((iB >> 8) & 8191) != i3 || (iB & 32) == 0 || zzerVar.K() < 7 || zzerVar.B() < 7 || (zzerVar.K() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        zzerVar.H(0, bArr, 6);
        long j2 = bArr[0];
        long j3 = bArr[1];
        long j4 = bArr[2];
        long j5 = bArr[3] & 255;
        return ((j2 & 255) << 25) | ((j3 & 255) << 17) | ((j4 & 255) << 9) | (j5 + j5) | ((bArr[4] & 255) >> 7);
    }
}
