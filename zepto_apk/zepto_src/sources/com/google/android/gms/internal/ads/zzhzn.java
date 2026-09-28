package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzhzn extends zzhzq {

    /* renamed from: d, reason: collision with root package name */
    public final Iterator f34566d;

    /* renamed from: e, reason: collision with root package name */
    public ByteBuffer f34567e;

    /* renamed from: f, reason: collision with root package name */
    public int f34568f;

    /* renamed from: g, reason: collision with root package name */
    public int f34569g;

    /* renamed from: i, reason: collision with root package name */
    public int f34571i;

    /* renamed from: k, reason: collision with root package name */
    public long f34573k;

    /* renamed from: l, reason: collision with root package name */
    public long f34574l;

    /* renamed from: m, reason: collision with root package name */
    public long f34575m;

    /* renamed from: h, reason: collision with root package name */
    public int f34570h = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: j, reason: collision with root package name */
    public int f34572j = 0;

    public /* synthetic */ zzhzn(int i2, ArrayList arrayList) {
        this.f34568f = i2;
        this.f34566d = arrayList.iterator();
        if (i2 != 0) {
            F();
            return;
        }
        this.f34567e = zzibe.f34662c;
        this.f34573k = 0L;
        this.f34574l = 0L;
        this.f34575m = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long A() {
        return zzhzq.g(J());
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int B(int i2) throws zzibg {
        if (i2 < 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int iC = i2 + c();
        int i3 = this.f34570h;
        if (iC > i3) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.f34570h = iC;
        int i4 = this.f34568f + this.f34569g;
        this.f34568f = i4;
        if (i4 <= iC) {
            this.f34569g = 0;
            return i3;
        }
        int i5 = i4 - iC;
        this.f34569g = i5;
        this.f34568f = i4 - i5;
        return i3;
    }

    public final byte C() throws zzibg {
        if (this.f34575m - this.f34573k == 0) {
            E();
        }
        long j2 = this.f34573k;
        this.f34573k = 1 + j2;
        return zzidm.f34769c.h(j2);
    }

    public final void D(int i2) throws zzibg {
        if (i2 >= 0) {
            if (i2 <= ((this.f34568f - this.f34572j) - this.f34573k) + this.f34574l) {
                while (i2 > 0) {
                    if (this.f34575m - this.f34573k == 0) {
                        E();
                    }
                    int iMin = Math.min(i2, (int) (this.f34575m - this.f34573k));
                    i2 -= iMin;
                    this.f34573k += iMin;
                }
                return;
            }
        }
        if (i2 >= 0) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final void E() throws zzibg {
        if (!this.f34566d.hasNext()) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        F();
    }

    public final void F() {
        ByteBuffer byteBuffer = (ByteBuffer) this.f34566d.next();
        this.f34567e = byteBuffer;
        this.f34572j += (int) (this.f34573k - this.f34574l);
        long jPosition = byteBuffer.position();
        this.f34573k = jPosition;
        this.f34574l = jPosition;
        this.f34575m = this.f34567e.limit();
        long jM = zzidm.m(this.f34567e);
        this.f34573k += jM;
        this.f34574l += jM;
        this.f34575m += jM;
    }

    public final void G(int i2, byte[] bArr) throws zzibg {
        if (i2 > H()) {
            if (i2 > 0) {
                throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            return;
        }
        int i3 = i2;
        while (i3 > 0) {
            if (this.f34575m - this.f34573k == 0) {
                E();
            }
            int iMin = Math.min(i3, (int) (this.f34575m - this.f34573k));
            long j2 = iMin;
            byte[] bArr2 = bArr;
            zzidm.f34769c.i(this.f34573k, bArr2, i2 - i3, j2);
            i3 -= iMin;
            this.f34573k += j2;
            bArr = bArr2;
        }
    }

    public final int H() {
        return (int) (((this.f34568f - this.f34572j) - this.f34573k) + this.f34574l);
    }

    public final int I() {
        int i2;
        long j2 = this.f34573k;
        if (this.f34575m != j2) {
            long j3 = j2 + 1;
            zzidl zzidlVar = zzidm.f34769c;
            byte bH = zzidlVar.h(j2);
            if (bH >= 0) {
                this.f34573k++;
                return bH;
            }
            if (this.f34575m - this.f34573k >= 10) {
                long j4 = 2 + j2;
                int iH = (zzidlVar.h(j3) << 7) ^ bH;
                if (iH < 0) {
                    i2 = iH ^ (-128);
                } else {
                    long j5 = 3 + j2;
                    int iH2 = (zzidlVar.h(j4) << 14) ^ iH;
                    if (iH2 >= 0) {
                        i2 = iH2 ^ 16256;
                    } else {
                        long j6 = 4 + j2;
                        int iH3 = iH2 ^ (zzidlVar.h(j5) << 21);
                        if (iH3 < 0) {
                            i2 = (-2080896) ^ iH3;
                        } else {
                            j5 = 5 + j2;
                            byte bH2 = zzidlVar.h(j6);
                            int i3 = (iH3 ^ (bH2 << 28)) ^ 266354560;
                            if (bH2 < 0) {
                                j6 = 6 + j2;
                                if (zzidlVar.h(j5) < 0) {
                                    j5 = 7 + j2;
                                    if (zzidlVar.h(j6) < 0) {
                                        j6 = 8 + j2;
                                        if (zzidlVar.h(j5) < 0) {
                                            j5 = 9 + j2;
                                            if (zzidlVar.h(j6) < 0) {
                                                long j7 = j2 + 10;
                                                if (zzidlVar.h(j5) >= 0) {
                                                    i2 = i3;
                                                    j4 = j7;
                                                }
                                            }
                                        }
                                    }
                                }
                                i2 = i3;
                            }
                            i2 = i3;
                        }
                        j4 = j6;
                    }
                    j4 = j5;
                }
                this.f34573k = j4;
                return i2;
            }
        }
        return (int) K();
    }

    public final long J() {
        long j2;
        long j3;
        long j4;
        long j5 = this.f34573k;
        if (this.f34575m != j5) {
            long j6 = j5 + 1;
            zzidl zzidlVar = zzidm.f34769c;
            byte bH = zzidlVar.h(j5);
            if (bH >= 0) {
                this.f34573k++;
                return bH;
            }
            if (this.f34575m - this.f34573k >= 10) {
                long j7 = 2 + j5;
                int iH = (zzidlVar.h(j6) << 7) ^ bH;
                if (iH < 0) {
                    j2 = iH ^ (-128);
                } else {
                    long j8 = 3 + j5;
                    int iH2 = (zzidlVar.h(j7) << 14) ^ iH;
                    if (iH2 >= 0) {
                        j2 = iH2 ^ 16256;
                    } else {
                        long j9 = 4 + j5;
                        int iH3 = iH2 ^ (zzidlVar.h(j8) << 21);
                        if (iH3 < 0) {
                            j2 = (-2080896) ^ iH3;
                            j7 = j9;
                        } else {
                            j8 = 5 + j5;
                            long jH = (zzidlVar.h(j9) << 28) ^ iH3;
                            if (jH >= 0) {
                                j4 = 266354560;
                            } else {
                                long j10 = 6 + j5;
                                long jH2 = jH ^ (zzidlVar.h(j8) << 35);
                                if (jH2 < 0) {
                                    j3 = -34093383808L;
                                } else {
                                    j8 = 7 + j5;
                                    jH = jH2 ^ (zzidlVar.h(j10) << 42);
                                    if (jH >= 0) {
                                        j4 = 4363953127296L;
                                    } else {
                                        j10 = 8 + j5;
                                        jH2 = jH ^ (zzidlVar.h(j8) << 49);
                                        if (jH2 < 0) {
                                            j3 = -558586000294016L;
                                        } else {
                                            j8 = 9 + j5;
                                            long jH3 = (jH2 ^ (zzidlVar.h(j10) << 56)) ^ 71499008037633920L;
                                            if (jH3 < 0) {
                                                long j11 = j5 + 10;
                                                if (zzidlVar.h(j8) >= 0) {
                                                    j7 = j11;
                                                    j2 = jH3;
                                                }
                                            } else {
                                                j2 = jH3;
                                            }
                                        }
                                    }
                                }
                                j2 = j3 ^ jH2;
                                j7 = j10;
                            }
                            j2 = j4 ^ jH;
                        }
                    }
                    j7 = j8;
                }
                this.f34573k = j7;
                return j2;
            }
        }
        return K();
    }

    public final long K() throws zzibg {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            j2 |= (r3 & 127) << i2;
            if ((C() & 128) == 0) {
                return j2;
            }
        }
        throw new zzibg("CodedInputStream encountered a malformed varint.");
    }

    public final int L() {
        long j2 = this.f34575m;
        long j3 = this.f34573k;
        if (j2 - j3 < 4) {
            int iC = C() & 255;
            int iC2 = (C() & 255) << 8;
            return iC | iC2 | ((C() & 255) << 16) | ((C() & 255) << 24);
        }
        this.f34573k = 4 + j3;
        zzidl zzidlVar = zzidm.f34769c;
        int iH = zzidlVar.h(j3) & 255;
        int iH2 = (zzidlVar.h(1 + j3) & 255) << 8;
        return ((zzidlVar.h(j3 + 3) & 255) << 24) | iH | iH2 | ((zzidlVar.h(2 + j3) & 255) << 16);
    }

    public final long M() {
        long j2 = this.f34575m;
        long j3 = this.f34573k;
        if (j2 - j3 < 8) {
            return ((C() & 255) << 56) | (C() & 255) | ((C() & 255) << 8) | ((C() & 255) << 16) | ((C() & 255) << 24) | ((C() & 255) << 32) | ((C() & 255) << 40) | ((C() & 255) << 48);
        }
        this.f34573k = 8 + j3;
        zzidl zzidlVar = zzidm.f34769c;
        return (zzidlVar.h(j3) & 255) | ((zzidlVar.h(j3 + 1) & 255) << 8) | ((zzidlVar.h(j3 + 2) & 255) << 16) | ((zzidlVar.h(j3 + 3) & 255) << 24) | ((zzidlVar.h(j3 + 4) & 255) << 32) | ((zzidlVar.h(j3 + 5) & 255) << 40) | ((zzidlVar.h(j3 + 6) & 255) << 48) | ((zzidlVar.h(j3 + 7) & 255) << 56);
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final void a(int i2) {
        this.f34570h = i2;
        int i3 = this.f34568f + this.f34569g;
        this.f34568f = i3;
        if (i3 <= i2) {
            this.f34569g = 0;
            return;
        }
        int i4 = i3 - i2;
        this.f34569g = i4;
        this.f34568f = i3 - i4;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final boolean b() {
        return (((long) this.f34572j) + this.f34573k) - this.f34574l == ((long) this.f34568f);
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int c() {
        return (int) ((this.f34572j + this.f34573k) - this.f34574l);
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int h() throws zzibg {
        if (b()) {
            this.f34571i = 0;
            return 0;
        }
        int I = I();
        this.f34571i = I;
        if ((I >>> 3) != 0) {
            return I;
        }
        throw new zzibg("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final void i(int i2) throws zzibg {
        if (this.f34571i != i2) {
            throw new zzibg("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final boolean j(int i2) throws zzibg {
        int i3 = i2 & 7;
        if (i3 == 0) {
            for (int i4 = 0; i4 < 10; i4++) {
                if (C() >= 0) {
                    return true;
                }
            }
            throw new zzibg("CodedInputStream encountered a malformed varint.");
        }
        if (i3 == 1) {
            D(8);
            return true;
        }
        if (i3 == 2) {
            D(I());
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
        D(4);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final double k() {
        return Double.longBitsToDouble(M());
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final float l() {
        return Float.intBitsToFloat(L());
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long m() {
        return J();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long n() {
        return J();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int o() {
        return I();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long p() {
        return M();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int q() {
        return L();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final boolean r() {
        return J() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final String s() throws zzibg {
        int I = I();
        if (I > 0) {
            long j2 = this.f34575m;
            long j3 = this.f34573k;
            long j4 = I;
            if (j4 <= j2 - j3) {
                byte[] bArr = new byte[I];
                zzidm.f34769c.i(j3, bArr, 0L, j4);
                String str = new String(bArr, zzibe.f34660a);
                this.f34573k += j4;
                return str;
            }
        }
        if (I > 0 && I <= H()) {
            byte[] bArr2 = new byte[I];
            G(I, bArr2);
            return new String(bArr2, zzibe.f34660a);
        }
        if (I == 0) {
            return "";
        }
        if (I < 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final String t() throws zzibg {
        int I = I();
        if (I > 0) {
            long j2 = this.f34575m;
            long j3 = this.f34573k;
            long j4 = I;
            if (j4 <= j2 - j3) {
                String strD = zzidr.d(this.f34567e, (int) (j3 - this.f34574l), I);
                this.f34573k += j4;
                return strD;
            }
        }
        if (I >= 0 && I <= H()) {
            byte[] bArr = new byte[I];
            G(I, bArr);
            return zzidr.f34775a.b(0, bArr, I);
        }
        if (I == 0) {
            return "";
        }
        if (I <= 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final zzhzl u() throws zzibg {
        int I = I();
        if (I > 0) {
            long j2 = this.f34575m;
            long j3 = this.f34573k;
            long j4 = I;
            if (j4 <= j2 - j3) {
                byte[] bArr = new byte[I];
                zzidm.f34769c.i(j3, bArr, 0L, j4);
                this.f34573k += j4;
                zzhzl zzhzlVar = zzhzl.f34557b;
                return new zzhzj(bArr);
            }
        }
        if (I > 0 && I <= H()) {
            byte[] bArr2 = new byte[I];
            G(I, bArr2);
            zzhzl zzhzlVar2 = zzhzl.f34557b;
            return new zzhzj(bArr2);
        }
        if (I == 0) {
            return zzhzl.f34557b;
        }
        if (I < 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int v() {
        return I();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int w() {
        return I();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int x() {
        return L();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long y() {
        return M();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int z() {
        return zzhzq.f(I());
    }
}
