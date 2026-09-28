package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzhzp extends zzhzq {

    /* renamed from: d, reason: collision with root package name */
    public long f34584d;

    /* renamed from: e, reason: collision with root package name */
    public long f34585e;

    /* renamed from: f, reason: collision with root package name */
    public int f34586f;

    /* renamed from: g, reason: collision with root package name */
    public int f34587g;

    /* renamed from: h, reason: collision with root package name */
    public int f34588h;

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long A() {
        return zzhzq.g(E());
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int B(int i2) throws zzibg {
        if (i2 < 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i3 = i2 + ((int) this.f34585e);
        int i4 = this.f34588h;
        if (i3 > i4) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.f34588h = i3;
        long j2 = this.f34584d + this.f34586f;
        this.f34584d = j2;
        int i5 = (int) j2;
        if (i5 <= i3) {
            this.f34586f = 0;
            return i4;
        }
        int i6 = i5 - i3;
        this.f34586f = i6;
        this.f34584d = j2 - i6;
        return i4;
    }

    public final void C(int i2) throws zzibg {
        if (i2 >= 0) {
            long j2 = this.f34584d;
            long j3 = this.f34585e;
            if (i2 <= ((int) (j2 - j3))) {
                this.f34585e = j3 + i2;
                return;
            }
        }
        if (i2 >= 0) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x008f, code lost:
    
        if (r4.h(r8) >= 0) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0091 A[PHI: r6
      0x0091: PHI (r6v7 long) = (r6v6 long), (r6v8 long), (r6v10 long) binds: [B:24:0x006b, B:28:0x007e, B:32:0x008f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int D() {
        /*
            r12 = this;
            long r0 = r12.f34585e
            long r2 = r12.f34584d
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 != 0) goto La
            goto L9b
        La:
            r2 = 1
            long r2 = r2 + r0
            com.google.android.gms.internal.ads.zzidl r4 = com.google.android.gms.internal.ads.zzidm.f34769c
            byte r5 = r4.h(r0)
            if (r5 < 0) goto L18
            r12.f34585e = r2
            return r5
        L18:
            long r6 = r12.f34584d
            long r6 = r6 - r2
            r8 = 9
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 < 0) goto L9b
            r6 = 2
            long r6 = r6 + r0
            byte r2 = r4.h(r2)
            int r2 = r2 << 7
            r2 = r2 ^ r5
            if (r2 >= 0) goto L31
            r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L98
        L31:
            r10 = 3
            long r10 = r10 + r0
            byte r3 = r4.h(r6)
            int r3 = r3 << 14
            r2 = r2 ^ r3
            if (r2 < 0) goto L41
            r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
        L3f:
            r6 = r10
            goto L98
        L41:
            r5 = 4
            long r6 = r0 + r5
            byte r3 = r4.h(r10)
            int r3 = r3 << 21
            r2 = r2 ^ r3
            if (r2 >= 0) goto L53
            r0 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L98
        L53:
            r10 = 5
            long r10 = r10 + r0
            byte r3 = r4.h(r6)
            int r5 = r3 << 28
            r2 = r2 ^ r5
            r5 = 266354560(0xfe03f80, float:2.2112565E-29)
            r2 = r2 ^ r5
            if (r3 >= 0) goto L96
            r5 = 6
            long r6 = r0 + r5
            byte r3 = r4.h(r10)
            if (r3 >= 0) goto L91
            r10 = 7
            long r10 = r10 + r0
            byte r3 = r4.h(r6)
            if (r3 >= 0) goto L96
            r5 = 8
            long r6 = r0 + r5
            byte r3 = r4.h(r10)
            if (r3 >= 0) goto L91
            long r8 = r8 + r0
            byte r3 = r4.h(r6)
            if (r3 >= 0) goto L93
            r5 = 10
            long r6 = r0 + r5
            byte r0 = r4.h(r8)
            if (r0 < 0) goto L9b
        L91:
            r0 = r2
            goto L98
        L93:
            r0 = r2
            r6 = r8
            goto L98
        L96:
            r0 = r2
            goto L3f
        L98:
            r12.f34585e = r6
            return r0
        L9b:
            long r0 = r12.F()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhzp.D():int");
    }

    public final long E() {
        long j2;
        long j3;
        long j4;
        int i2;
        long j5 = this.f34585e;
        if (this.f34584d != j5) {
            long j6 = 1 + j5;
            zzidl zzidlVar = zzidm.f34769c;
            byte bH = zzidlVar.h(j5);
            if (bH >= 0) {
                this.f34585e = j6;
                return bH;
            }
            if (this.f34584d - j6 >= 9) {
                long j7 = 2 + j5;
                int iH = (zzidlVar.h(j6) << 7) ^ bH;
                if (iH >= 0) {
                    long j8 = 3 + j5;
                    int iH2 = iH ^ (zzidlVar.h(j7) << 14);
                    if (iH2 >= 0) {
                        j2 = iH2 ^ 16256;
                    } else {
                        j7 = j5 + 4;
                        int iH3 = iH2 ^ (zzidlVar.h(j8) << 21);
                        if (iH3 < 0) {
                            i2 = (-2080896) ^ iH3;
                        } else {
                            j8 = 5 + j5;
                            long jH = iH3 ^ (zzidlVar.h(j7) << 28);
                            if (jH < 0) {
                                long j9 = 6 + j5;
                                long jH2 = jH ^ (zzidlVar.h(j8) << 35);
                                if (jH2 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    j8 = 7 + j5;
                                    jH = jH2 ^ (zzidlVar.h(j9) << 42);
                                    if (jH >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        j9 = 8 + j5;
                                        jH2 = jH ^ (zzidlVar.h(j8) << 49);
                                        if (jH2 >= 0) {
                                            long j10 = j5 + 9;
                                            long jH3 = (jH2 ^ (zzidlVar.h(j9) << 56)) ^ 71499008037633920L;
                                            if (jH3 < 0) {
                                                long j11 = j5 + 10;
                                                if (zzidlVar.h(j10) >= 0) {
                                                    j7 = j11;
                                                    j2 = jH3;
                                                }
                                            } else {
                                                j2 = jH3;
                                                j7 = j10;
                                            }
                                            this.f34585e = j7;
                                            return j2;
                                        }
                                        j3 = -558586000294016L;
                                    }
                                }
                                j2 = j3 ^ jH2;
                                j7 = j9;
                                this.f34585e = j7;
                                return j2;
                            }
                            j4 = 266354560;
                            j2 = j4 ^ jH;
                        }
                    }
                    j7 = j8;
                    this.f34585e = j7;
                    return j2;
                }
                i2 = iH ^ (-128);
                j2 = i2;
                this.f34585e = j7;
                return j2;
            }
        }
        return F();
    }

    public final long F() throws zzibg {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            long j3 = this.f34585e;
            if (j3 == this.f34584d) {
                throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            this.f34585e = 1 + j3;
            j2 |= (r3 & 127) << i2;
            if ((zzidm.f34769c.h(j3) & 128) == 0) {
                return j2;
            }
        }
        throw new zzibg("CodedInputStream encountered a malformed varint.");
    }

    public final int G() throws zzibg {
        long j2 = this.f34585e;
        if (this.f34584d - j2 < 4) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.f34585e = 4 + j2;
        zzidl zzidlVar = zzidm.f34769c;
        int iH = zzidlVar.h(j2) & 255;
        int iH2 = zzidlVar.h(1 + j2) & 255;
        int iH3 = zzidlVar.h(2 + j2) & 255;
        return ((zzidlVar.h(j2 + 3) & 255) << 24) | (iH2 << 8) | iH | (iH3 << 16);
    }

    public final long H() throws zzibg {
        long j2 = this.f34585e;
        if (this.f34584d - j2 < 8) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.f34585e = 8 + j2;
        zzidl zzidlVar = zzidm.f34769c;
        long jH = zzidlVar.h(j2);
        long jH2 = zzidlVar.h(1 + j2);
        long jH3 = zzidlVar.h(2 + j2);
        long jH4 = zzidlVar.h(3 + j2);
        long jH5 = zzidlVar.h(4 + j2);
        return ((zzidlVar.h(j2 + 7) & 255) << 56) | ((zzidlVar.h(j2 + 6) & 255) << 48) | (jH & 255) | ((jH2 & 255) << 8) | ((jH3 & 255) << 16) | ((jH4 & 255) << 24) | ((jH5 & 255) << 32) | ((zzidlVar.h(5 + j2) & 255) << 40);
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final void a(int i2) {
        this.f34588h = i2;
        long j2 = this.f34584d + this.f34586f;
        this.f34584d = j2;
        int i3 = (int) j2;
        if (i3 <= i2) {
            this.f34586f = 0;
            return;
        }
        int i4 = i3 - i2;
        this.f34586f = i4;
        this.f34584d = j2 - i4;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final boolean b() {
        return this.f34585e == this.f34584d;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int c() {
        return (int) this.f34585e;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int h() throws zzibg {
        if (b()) {
            this.f34587g = 0;
            return 0;
        }
        int iD = D();
        this.f34587g = iD;
        if ((iD >>> 3) != 0) {
            return iD;
        }
        throw new zzibg("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final void i(int i2) throws zzibg {
        if (this.f34587g != i2) {
            throw new zzibg("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final boolean j(int i2) throws zzibg {
        int i3 = i2 & 7;
        int i4 = 0;
        if (i3 == 0) {
            if (((int) (this.f34584d - this.f34585e)) >= 10) {
                while (i4 < 10) {
                    long j2 = this.f34585e;
                    this.f34585e = j2 + 1;
                    if (zzidm.f34769c.h(j2) < 0) {
                        i4++;
                    }
                }
                throw new zzibg("CodedInputStream encountered a malformed varint.");
            }
            while (i4 < 10) {
                long j3 = this.f34585e;
                if (j3 == this.f34584d) {
                    throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.f34585e = j3 + 1;
                if (zzidm.f34769c.h(j3) < 0) {
                    i4++;
                }
            }
            throw new zzibg("CodedInputStream encountered a malformed varint.");
            return true;
        }
        if (i3 == 1) {
            C(8);
            return true;
        }
        if (i3 == 2) {
            C(D());
            return true;
        }
        if (i3 == 3) {
            e();
            i(((i2 >>> 3) << 3) | 4);
            return true;
        }
        if (i3 == 4) {
            if (this.f34590b == 0) {
                i(0);
            }
            return false;
        }
        if (i3 != 5) {
            throw new zzibf();
        }
        C(4);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final double k() {
        return Double.longBitsToDouble(H());
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final float l() {
        return Float.intBitsToFloat(G());
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long m() {
        return E();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long n() {
        return E();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int o() {
        return D();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long p() {
        return H();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int q() {
        return G();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final boolean r() {
        return E() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final String s() throws zzibg {
        int iD = D();
        if (iD > 0) {
            long j2 = this.f34584d;
            long j3 = this.f34585e;
            if (iD <= ((int) (j2 - j3))) {
                byte[] bArr = new byte[iD];
                long j4 = iD;
                zzidm.f34769c.i(j3, bArr, 0L, j4);
                String str = new String(bArr, zzibe.f34660a);
                this.f34585e += j4;
                return str;
            }
        }
        if (iD == 0) {
            return "";
        }
        if (iD < 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final String t() throws zzibg {
        int iD = D();
        if (iD > 0) {
            long j2 = this.f34584d;
            long j3 = this.f34585e;
            if (iD <= ((int) (j2 - j3))) {
                zzidr.d(null, (int) j3, iD);
                throw null;
            }
        }
        if (iD == 0) {
            return "";
        }
        if (iD <= 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final zzhzl u() throws zzibg {
        int iD = D();
        if (iD > 0) {
            long j2 = this.f34584d;
            long j3 = this.f34585e;
            if (iD <= ((int) (j2 - j3))) {
                byte[] bArr = new byte[iD];
                long j4 = iD;
                zzidm.f34769c.i(j3, bArr, 0L, j4);
                this.f34585e += j4;
                zzhzl zzhzlVar = zzhzl.f34557b;
                return new zzhzj(bArr);
            }
        }
        if (iD == 0) {
            return zzhzl.f34557b;
        }
        if (iD < 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int v() {
        return D();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int w() {
        return D();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int x() {
        return G();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long y() {
        return H();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int z() {
        return zzhzq.f(D());
    }
}
