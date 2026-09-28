package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzhzm extends zzhzq {

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f34559d;

    /* renamed from: e, reason: collision with root package name */
    public int f34560e;

    /* renamed from: f, reason: collision with root package name */
    public int f34561f;

    /* renamed from: g, reason: collision with root package name */
    public int f34562g;

    /* renamed from: h, reason: collision with root package name */
    public final int f34563h;

    /* renamed from: i, reason: collision with root package name */
    public int f34564i;

    /* renamed from: j, reason: collision with root package name */
    public int f34565j = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public /* synthetic */ zzhzm(byte[] bArr, int i2, int i3) {
        this.f34559d = bArr;
        this.f34560e = i3 + i2;
        this.f34562g = i2;
        this.f34563h = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long A() {
        return zzhzq.g(F());
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int B(int i2) {
        if (i2 < 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i3 = (this.f34562g - this.f34563h) + i2;
        if (i3 < 0) {
            throw new zzibg("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i4 = this.f34565j;
        if (i3 > i4) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.f34565j = i3;
        D();
        return i4;
    }

    public final void C(int i2) throws zzibg {
        if (i2 >= 0) {
            int i3 = this.f34560e;
            int i4 = this.f34562g;
            if (i2 <= i3 - i4) {
                this.f34562g = i4 + i2;
                return;
            }
        }
        if (i2 >= 0) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final void D() {
        int i2 = this.f34560e + this.f34561f;
        this.f34560e = i2;
        int i3 = i2 - this.f34563h;
        int i4 = this.f34565j;
        if (i3 <= i4) {
            this.f34561f = 0;
            return;
        }
        int i5 = i3 - i4;
        this.f34561f = i5;
        this.f34560e = i2 - i5;
    }

    public final int E() {
        int i2;
        int i3 = this.f34562g;
        int i4 = this.f34560e;
        if (i4 != i3) {
            int i5 = i3 + 1;
            byte[] bArr = this.f34559d;
            byte b2 = bArr[i3];
            if (b2 >= 0) {
                this.f34562g = i5;
                return b2;
            }
            if (i4 - i5 >= 9) {
                int i6 = i3 + 2;
                int i7 = (bArr[i5] << 7) ^ b2;
                if (i7 < 0) {
                    i2 = i7 ^ (-128);
                } else {
                    int i8 = i3 + 3;
                    int i9 = (bArr[i6] << 14) ^ i7;
                    if (i9 >= 0) {
                        i2 = i9 ^ 16256;
                    } else {
                        int i10 = i3 + 4;
                        int i11 = i9 ^ (bArr[i8] << 21);
                        if (i11 < 0) {
                            i2 = (-2080896) ^ i11;
                        } else {
                            i8 = i3 + 5;
                            byte b3 = bArr[i10];
                            int i12 = (i11 ^ (b3 << 28)) ^ 266354560;
                            if (b3 < 0) {
                                i10 = i3 + 6;
                                if (bArr[i8] < 0) {
                                    i8 = i3 + 7;
                                    if (bArr[i10] < 0) {
                                        i10 = i3 + 8;
                                        if (bArr[i8] < 0) {
                                            i8 = i3 + 9;
                                            if (bArr[i10] < 0) {
                                                int i13 = i3 + 10;
                                                if (bArr[i8] >= 0) {
                                                    i6 = i13;
                                                    i2 = i12;
                                                }
                                            }
                                        }
                                    }
                                }
                                i2 = i12;
                            }
                            i2 = i12;
                        }
                        i6 = i10;
                    }
                    i6 = i8;
                }
                this.f34562g = i6;
                return i2;
            }
        }
        return (int) G();
    }

    public final long F() {
        long j2;
        long j3;
        long j4;
        int i2 = this.f34562g;
        int i3 = this.f34560e;
        if (i3 != i2) {
            int i4 = i2 + 1;
            byte[] bArr = this.f34559d;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.f34562g = i4;
                return b2;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b2;
                if (i6 < 0) {
                    j2 = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        j2 = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            long j5 = (-2080896) ^ i10;
                            i5 = i9;
                            j2 = j5;
                        } else {
                            i7 = i2 + 5;
                            long j6 = i10 ^ (bArr[i9] << 28);
                            if (j6 >= 0) {
                                j4 = 266354560;
                            } else {
                                int i11 = i2 + 6;
                                long j7 = j6 ^ (bArr[i7] << 35);
                                if (j7 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    i7 = i2 + 7;
                                    j6 = j7 ^ (bArr[i11] << 42);
                                    if (j6 >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        i11 = i2 + 8;
                                        j7 = j6 ^ (bArr[i7] << 49);
                                        if (j7 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            i7 = i2 + 9;
                                            long j8 = (j7 ^ (bArr[i11] << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    j2 = j8;
                                                    i5 = i12;
                                                }
                                            } else {
                                                j2 = j8;
                                            }
                                        }
                                    }
                                }
                                j2 = j7 ^ j3;
                                i5 = i11;
                            }
                            j2 = j6 ^ j4;
                        }
                    }
                    i5 = i7;
                }
                this.f34562g = i5;
                return j2;
            }
        }
        return G();
    }

    public final long G() throws zzibg {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            int i3 = this.f34562g;
            if (i3 == this.f34560e) {
                throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            this.f34562g = i3 + 1;
            j2 |= (r3 & 127) << i2;
            if ((this.f34559d[i3] & 128) == 0) {
                return j2;
            }
        }
        throw new zzibg("CodedInputStream encountered a malformed varint.");
    }

    public final int H() throws zzibg {
        int i2 = this.f34562g;
        if (this.f34560e - i2 < 4) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.f34562g = i2 + 4;
        byte[] bArr = this.f34559d;
        int i3 = bArr[i2] & 255;
        int i4 = bArr[i2 + 1] & 255;
        int i5 = bArr[i2 + 2] & 255;
        return ((bArr[i2 + 3] & 255) << 24) | (i4 << 8) | i3 | (i5 << 16);
    }

    public final long I() throws zzibg {
        int i2 = this.f34562g;
        if (this.f34560e - i2 < 8) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.f34562g = i2 + 8;
        byte[] bArr = this.f34559d;
        long j2 = bArr[i2];
        long j3 = bArr[i2 + 2];
        long j4 = bArr[i2 + 3];
        return ((bArr[i2 + 6] & 255) << 48) | (j2 & 255) | ((bArr[i2 + 1] & 255) << 8) | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 7] & 255) << 56);
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final void a(int i2) {
        this.f34565j = i2;
        D();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final boolean b() {
        return this.f34562g == this.f34560e;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int c() {
        return this.f34562g - this.f34563h;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int h() throws zzibg {
        if (b()) {
            this.f34564i = 0;
            return 0;
        }
        int iE = E();
        this.f34564i = iE;
        if ((iE >>> 3) != 0) {
            return iE;
        }
        throw new zzibg("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final void i(int i2) throws zzibg {
        if (this.f34564i != i2) {
            throw new zzibg("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final boolean j(int i2) throws zzibg {
        int i3 = i2 & 7;
        int i4 = 0;
        if (i3 != 0) {
            if (i3 == 1) {
                C(8);
                return true;
            }
            if (i3 == 2) {
                C(E());
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
        int i5 = this.f34560e - this.f34562g;
        byte[] bArr = this.f34559d;
        if (i5 >= 10) {
            while (i4 < 10) {
                int i6 = this.f34562g;
                this.f34562g = i6 + 1;
                if (bArr[i6] < 0) {
                    i4++;
                }
            }
            throw new zzibg("CodedInputStream encountered a malformed varint.");
        }
        while (i4 < 10) {
            int i7 = this.f34562g;
            if (i7 == this.f34560e) {
                throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            this.f34562g = i7 + 1;
            if (bArr[i7] < 0) {
                i4++;
            }
        }
        throw new zzibg("CodedInputStream encountered a malformed varint.");
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final double k() {
        return Double.longBitsToDouble(I());
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final float l() {
        return Float.intBitsToFloat(H());
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long m() {
        return F();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long n() {
        return F();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int o() {
        return E();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long p() {
        return I();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int q() {
        return H();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final boolean r() {
        return F() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final String s() throws zzibg {
        int iE = E();
        if (iE > 0) {
            int i2 = this.f34560e;
            int i3 = this.f34562g;
            if (iE <= i2 - i3) {
                String str = new String(this.f34559d, i3, iE, zzibe.f34660a);
                this.f34562g += iE;
                return str;
            }
        }
        if (iE == 0) {
            return "";
        }
        if (iE < 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final String t() throws zzibg {
        int iE = E();
        if (iE > 0) {
            int i2 = this.f34560e;
            int i3 = this.f34562g;
            if (iE <= i2 - i3) {
                String strB = zzidr.f34775a.b(i3, this.f34559d, iE);
                this.f34562g += iE;
                return strB;
            }
        }
        if (iE == 0) {
            return "";
        }
        if (iE <= 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final zzhzl u() throws zzibg {
        int iE = E();
        byte[] bArr = this.f34559d;
        if (iE > 0) {
            int i2 = this.f34560e;
            int i3 = this.f34562g;
            if (iE <= i2 - i3) {
                zzhzl zzhzlVarW = zzhzl.w(i3, bArr, iE);
                this.f34562g += iE;
                return zzhzlVarW;
            }
        }
        if (iE == 0) {
            return zzhzl.f34557b;
        }
        if (iE > 0) {
            int i4 = this.f34560e;
            int i5 = this.f34562g;
            if (iE <= i4 - i5) {
                int i6 = iE + i5;
                this.f34562g = i6;
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i5, i6);
                zzhzl zzhzlVar = zzhzl.f34557b;
                return new zzhzj(bArrCopyOfRange);
            }
        }
        if (iE <= 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int v() {
        return E();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int w() {
        return E();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int x() {
        return H();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long y() {
        return I();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int z() {
        return zzhzq.f(E());
    }
}
