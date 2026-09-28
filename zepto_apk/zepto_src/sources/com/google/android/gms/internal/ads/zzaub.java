package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaub {

    /* renamed from: a, reason: collision with root package name */
    public int f24383a;

    /* renamed from: b, reason: collision with root package name */
    public zzatw f24384b;

    /* renamed from: c, reason: collision with root package name */
    public zzatk f24385c;

    /* renamed from: d, reason: collision with root package name */
    public zzatn f24386d;

    public zzaub(zzatw zzatwVar, int i2, zzatk zzatkVar) {
        this.f24384b = zzatwVar;
        this.f24383a = i2;
        this.f24385c = zzatkVar;
    }

    public static final void g(long j2) throws zzatz {
        long[] jArr = {141540322, 456640674, 1141397064, 993500330, 1614820873, 3337980909L, 410218731, 1716462158, 477127367};
        long j3 = jArr[0];
        long j4 = jArr[1];
        long j5 = jArr[2];
        long j6 = jArr[3];
        long j7 = jArr[4];
        long j8 = jArr[5];
        if (j2 % (((((((~j3) & j4) | j5) + ((j3 & j6) | j7)) - j8) + jArr[6]) ^ (jArr[7] % 477127367)) != 0) {
            throw new zzatz();
        }
    }

    public final void a(long j2) {
        long[] jArr = {2139842053, 728564241, 750932242, 1403848321, 1892818418, 4558981222L, 1919655804, 1856374729, 899334107};
        long j3 = jArr[0];
        long j4 = jArr[1];
        long j5 = jArr[2];
        long j6 = jArr[3];
        long j7 = jArr[4];
        long j8 = jArr[5];
        long j9 = jArr[6];
        long j10 = jArr[7];
        g(j2);
        long j11 = j2 / (((((((~j3) & j4) | j5) + ((j3 & j6) | j7)) - j8) + j9) ^ (j10 % 899334107));
        if (j11 < 0 || j11 > this.f24384b.f24367a.length) {
            throw new zzaua();
        }
        this.f24383a = (int) j11;
    }

    public final long b() {
        long[] jArr = {491705403, 818579170, 1201981453, 810223590, 1243973916, 3701563257L, 554701476, 1889947178, 1780695788};
        long j2 = jArr[0];
        long j3 = jArr[1];
        long j4 = jArr[2];
        long j5 = jArr[3];
        long j6 = jArr[4];
        return this.f24383a * (((((((~j2) & j3) | j4) + ((j2 & j5) | j6)) - jArr[5]) + jArr[6]) ^ (jArr[7] % 1780695788));
    }

    public final long c() throws zzaua {
        try {
            zzatk zzatkVar = this.f24385c;
            zzatw zzatwVar = this.f24384b;
            this.f24383a = this.f24383a + 1;
            return zzatkVar.a(zzatwVar, r2);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzaua(e2);
        }
    }

    public final int d() {
        try {
            zzatk zzatkVar = this.f24385c;
            zzatw zzatwVar = this.f24384b;
            int i2 = this.f24383a;
            this.f24383a = i2 + 1;
            int iA = zzatkVar.a(zzatwVar, i2) & 255;
            zzatk zzatkVar2 = this.f24385c;
            zzatw zzatwVar2 = this.f24384b;
            int i3 = this.f24383a;
            this.f24383a = i3 + 1;
            int iA2 = iA | ((zzatkVar2.a(zzatwVar2, i3) & 255) << 8);
            zzatk zzatkVar3 = this.f24385c;
            zzatw zzatwVar3 = this.f24384b;
            int i4 = this.f24383a;
            this.f24383a = i4 + 1;
            int iA3 = iA2 | ((zzatkVar3.a(zzatwVar3, i4) & 255) << 16);
            zzatk zzatkVar4 = this.f24385c;
            zzatw zzatwVar4 = this.f24384b;
            int i5 = this.f24383a;
            this.f24383a = i5 + 1;
            return iA3 | (zzatkVar4.a(zzatwVar4, i5) << 24);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzaua(e2);
        }
    }

    public final long e() throws zzaty, zzaua {
        int i2 = 0;
        long j2 = 0;
        while (i2 < 64) {
            try {
                zzatk zzatkVar = this.f24385c;
                zzatw zzatwVar = this.f24384b;
                int i3 = this.f24383a;
                this.f24383a = i3 + 1;
                byte bA = zzatkVar.a(zzatwVar, i3);
                j2 |= (bA & 127) << i2;
                if (i2 == 63) {
                    if (bA > 1) {
                        throw new zzaty();
                    }
                    i2 = 63;
                }
                if ((bA & 128) == 0) {
                    return (-(j2 & 1)) ^ (j2 >>> 1);
                }
                i2 += 7;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzaua(e2);
            }
        }
        throw new zzaty();
    }

    public final zzatw f(long j2) throws zzatz, zzaua {
        int[] iArr = {1667674495, 1502201381, 1197125461, 478240810, 622476187, -1652496091, 840440151, 1203013321, 774318984};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        int iA = android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, i7, i8);
        g(b() + j2);
        int i10 = this.f24383a;
        long j3 = i10;
        zzatw zzatwVar = this.f24384b;
        long j4 = (j2 >> ((i9 % 774318984) ^ iA)) + j3;
        if (j4 > zzatwVar.f24367a.length || j4 < j3) {
            throw new zzaua();
        }
        try {
            int i11 = (int) j4;
            zzatw zzatwVarB = this.f24385c.b(zzatwVar, i10, i11);
            this.f24383a = i11;
            return zzatwVarB;
        } catch (IndexOutOfBoundsException e2) {
            throw new AssertionError(zzatu.a("CEiv6BFfPnitUE+D"), e2);
        }
    }

    public zzaub(zzatw zzatwVar, int i2, zzatk zzatkVar, zzatn zzatnVar) {
        this(zzatwVar, i2, zzatkVar);
        this.f24386d = zzatnVar;
    }
}
