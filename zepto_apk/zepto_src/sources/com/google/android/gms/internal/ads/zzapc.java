package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzapc {

    /* renamed from: c, reason: collision with root package name */
    public boolean f24037c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f24038d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f24039e;

    /* renamed from: a, reason: collision with root package name */
    public final zzfg f24035a = new zzfg();

    /* renamed from: f, reason: collision with root package name */
    public long f24040f = -9223372036854775807L;

    /* renamed from: g, reason: collision with root package name */
    public long f24041g = -9223372036854775807L;

    /* renamed from: h, reason: collision with root package name */
    public long f24042h = -9223372036854775807L;

    /* renamed from: b, reason: collision with root package name */
    public final zzer f24036b = new zzer();

    public static long a(zzer zzerVar) {
        int i2 = zzerVar.f30145b;
        if (zzerVar.B() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        zzerVar.H(0, bArr, 9);
        zzerVar.E(i2);
        byte b2 = bArr[0];
        if ((b2 & 196) != 68) {
            return -9223372036854775807L;
        }
        byte b3 = bArr[2];
        if ((b3 & 4) != 4) {
            return -9223372036854775807L;
        }
        byte b4 = bArr[4];
        if ((b4 & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return -9223372036854775807L;
        }
        long j2 = b2;
        long j3 = b3;
        long j4 = (248 & j3) >> 3;
        long j5 = (j3 & 3) << 13;
        return j5 | ((bArr[1] & 255) << 20) | ((j2 & 3) << 28) | (((j2 & 56) >> 3) << 30) | (j4 << 15) | ((bArr[3] & 255) << 5) | ((b4 & 248) >> 3);
    }

    public static final int b(int i2, byte[] bArr) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }
}
