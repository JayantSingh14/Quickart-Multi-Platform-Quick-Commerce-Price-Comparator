package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzhzo extends zzhzq {

    /* renamed from: d, reason: collision with root package name */
    public final InputStream f34576d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f34577e;

    /* renamed from: f, reason: collision with root package name */
    public int f34578f;

    /* renamed from: g, reason: collision with root package name */
    public int f34579g;

    /* renamed from: h, reason: collision with root package name */
    public int f34580h;

    /* renamed from: i, reason: collision with root package name */
    public int f34581i;

    /* renamed from: j, reason: collision with root package name */
    public int f34582j;

    /* renamed from: k, reason: collision with root package name */
    public int f34583k = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public /* synthetic */ zzhzo(InputStream inputStream) {
        Charset charset = zzibe.f34660a;
        this.f34576d = inputStream;
        this.f34577e = new byte[4096];
        this.f34578f = 0;
        this.f34580h = 0;
        this.f34582j = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long A() {
        return zzhzq.g(K());
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int B(int i2) throws zzibg {
        if (i2 < 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i3 = this.f34582j + this.f34580h + i2;
        if (i3 < 0) {
            throw new zzibg("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i4 = this.f34583k;
        if (i3 > i4) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.f34583k = i3;
        D();
        return i4;
    }

    public final void C(int i2) throws zzibg {
        InputStream inputStream = this.f34576d;
        int i3 = this.f34578f;
        int i4 = this.f34580h;
        int i5 = i3 - i4;
        if (i2 <= i5 && i2 >= 0) {
            this.f34580h = i4 + i2;
            return;
        }
        if (i2 < 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i6 = this.f34582j;
        int i7 = i6 + i4;
        int i8 = this.f34583k;
        if (i7 + i2 > i8) {
            C((i8 - i6) - i4);
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.f34582j = i7;
        this.f34578f = 0;
        this.f34580h = 0;
        while (i5 < i2) {
            long j2 = i2 - i5;
            try {
                try {
                    long jSkip = inputStream.skip(j2);
                    if (jSkip < 0 || jSkip > j2) {
                        String strValueOf = String.valueOf(inputStream.getClass());
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 31 + String.valueOf(jSkip).length() + 41);
                        sb.append(strValueOf);
                        sb.append("#skip returned invalid result: ");
                        sb.append(jSkip);
                        sb.append("\nThe InputStream implementation is buggy.");
                        throw new IllegalStateException(sb.toString());
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i5 += (int) jSkip;
                    }
                } catch (zzibg e2) {
                    e2.f34663a = true;
                    throw e2;
                }
            } catch (Throwable th) {
                this.f34582j += i5;
                D();
                throw th;
            }
        }
        this.f34582j += i5;
        D();
        if (i5 >= i2) {
            return;
        }
        int i9 = this.f34578f;
        int i10 = i9 - this.f34580h;
        this.f34580h = i9;
        E(1);
        while (true) {
            int i11 = i2 - i10;
            int i12 = this.f34578f;
            if (i11 <= i12) {
                this.f34580h = i11;
                return;
            } else {
                i10 += i12;
                this.f34580h = i12;
                E(1);
            }
        }
    }

    public final void D() {
        int i2 = this.f34578f + this.f34579g;
        this.f34578f = i2;
        int i3 = this.f34582j + i2;
        int i4 = this.f34583k;
        if (i3 <= i4) {
            this.f34579g = 0;
            return;
        }
        int i5 = i3 - i4;
        this.f34579g = i5;
        this.f34578f = i2 - i5;
    }

    public final void E(int i2) throws zzibg {
        if (F(i2)) {
            return;
        }
        if (i2 <= (Api.BaseClientBuilder.API_PRIORITY_OTHER - this.f34582j) - this.f34580h) {
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzibg("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
    }

    public final boolean F(int i2) throws IOException {
        InputStream inputStream = this.f34576d;
        int i3 = this.f34580h;
        int i4 = i3 + i2;
        int i5 = this.f34578f;
        if (i4 <= i5) {
            throw new IllegalStateException(androidx.fragment.app.e.u(new StringBuilder(String.valueOf(i2).length() + 66), "refillBuffer() called when ", i2, " bytes were already available in buffer"));
        }
        int i6 = this.f34582j;
        if (i2 > (Api.BaseClientBuilder.API_PRIORITY_OTHER - i6) - i3 || i6 + i3 + i2 > this.f34583k) {
            return false;
        }
        byte[] bArr = this.f34577e;
        if (i3 > 0) {
            if (i5 > i3) {
                System.arraycopy(bArr, i3, bArr, 0, i5 - i3);
            }
            i6 = this.f34582j + i3;
            this.f34582j = i6;
            i5 = this.f34578f - i3;
            this.f34578f = i5;
            this.f34580h = 0;
        }
        try {
            int i7 = inputStream.read(bArr, i5, Math.min(4096 - i5, (Api.BaseClientBuilder.API_PRIORITY_OTHER - i6) - i5));
            if (i7 != 0 && i7 >= -1 && i7 <= 4096) {
                if (i7 <= 0) {
                    return false;
                }
                this.f34578f += i7;
                D();
                return this.f34578f >= i2 || F(i2);
            }
            String strValueOf = String.valueOf(inputStream.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(i7).length() + strValueOf.length() + 39 + 41);
            sb.append(strValueOf);
            sb.append("#read(byte[]) returned invalid result: ");
            sb.append(i7);
            sb.append("\nThe InputStream implementation is buggy.");
            throw new IllegalStateException(sb.toString());
        } catch (zzibg e2) {
            e2.f34663a = true;
            throw e2;
        }
    }

    public final byte[] G(int i2) throws IOException {
        byte[] bArrH = H(i2);
        if (bArrH != null) {
            return bArrH;
        }
        int i3 = this.f34580h;
        int i4 = this.f34578f;
        int i5 = i4 - i3;
        this.f34582j += i4;
        this.f34580h = 0;
        this.f34578f = 0;
        ArrayList arrayListI = I(i2 - i5);
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f34577e, i3, bArr, 0, i5);
        Iterator it = arrayListI.iterator();
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) it.next();
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i5, length);
            i5 += length;
        }
        return bArr;
    }

    public final byte[] H(int i2) throws IOException {
        if (i2 == 0) {
            return zzibe.f34661b;
        }
        int i3 = this.f34582j;
        int i4 = this.f34580h;
        int i5 = i3 + i4 + i2;
        if ((-2147483647) + i5 > 0) {
            throw new zzibg("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i6 = this.f34583k;
        if (i5 > i6) {
            C((i6 - i3) - i4);
            throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i7 = this.f34578f - i4;
        int i8 = i2 - i7;
        InputStream inputStream = this.f34576d;
        if (i8 >= 4096) {
            try {
                if (i8 > inputStream.available()) {
                    return null;
                }
            } catch (zzibg e2) {
                e2.f34663a = true;
                throw e2;
            }
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f34577e, this.f34580h, bArr, 0, i7);
        this.f34582j += this.f34578f;
        this.f34580h = 0;
        this.f34578f = 0;
        while (i7 < i2) {
            try {
                int i9 = inputStream.read(bArr, i7, i2 - i7);
                if (i9 == -1) {
                    throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.f34582j += i9;
                i7 += i9;
            } catch (zzibg e3) {
                e3.f34663a = true;
                throw e3;
            }
        }
        return bArr;
    }

    public final ArrayList I(int i2) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i2 > 0) {
            int iMin = Math.min(i2, 4096);
            byte[] bArr = new byte[iMin];
            int i3 = 0;
            while (i3 < iMin) {
                int i4 = this.f34576d.read(bArr, i3, iMin - i3);
                if (i4 == -1) {
                    throw new zzibg("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.f34582j += i4;
                i3 += i4;
            }
            i2 -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final int J() {
        int i2;
        int i3 = this.f34580h;
        int i4 = this.f34578f;
        if (i4 != i3) {
            int i5 = i3 + 1;
            byte[] bArr = this.f34577e;
            byte b2 = bArr[i3];
            if (b2 >= 0) {
                this.f34580h = i5;
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
                this.f34580h = i6;
                return i2;
            }
        }
        return (int) L();
    }

    public final long K() {
        long j2;
        long j3;
        long j4;
        int i2 = this.f34580h;
        int i3 = this.f34578f;
        if (i3 != i2) {
            int i4 = i2 + 1;
            byte[] bArr = this.f34577e;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.f34580h = i4;
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
                this.f34580h = i5;
                return j2;
            }
        }
        return L();
    }

    public final long L() throws zzibg {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            if (this.f34580h == this.f34578f) {
                E(1);
            }
            int i3 = this.f34580h;
            this.f34580h = i3 + 1;
            j2 |= (r3 & 127) << i2;
            if ((this.f34577e[i3] & 128) == 0) {
                return j2;
            }
        }
        throw new zzibg("CodedInputStream encountered a malformed varint.");
    }

    public final int M() throws zzibg {
        int i2 = this.f34580h;
        if (this.f34578f - i2 < 4) {
            E(4);
            i2 = this.f34580h;
        }
        this.f34580h = i2 + 4;
        byte[] bArr = this.f34577e;
        int i3 = bArr[i2] & 255;
        int i4 = bArr[i2 + 1] & 255;
        int i5 = bArr[i2 + 2] & 255;
        return ((bArr[i2 + 3] & 255) << 24) | (i4 << 8) | i3 | (i5 << 16);
    }

    public final long N() throws zzibg {
        int i2 = this.f34580h;
        if (this.f34578f - i2 < 8) {
            E(8);
            i2 = this.f34580h;
        }
        this.f34580h = i2 + 8;
        byte[] bArr = this.f34577e;
        long j2 = bArr[i2];
        long j3 = bArr[i2 + 2];
        long j4 = bArr[i2 + 3];
        return ((bArr[i2 + 6] & 255) << 48) | (j2 & 255) | ((bArr[i2 + 1] & 255) << 8) | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 7] & 255) << 56);
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final void a(int i2) {
        this.f34583k = i2;
        D();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final boolean b() {
        return this.f34580h == this.f34578f && !F(1);
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int c() {
        return this.f34582j + this.f34580h;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int h() throws zzibg {
        if (b()) {
            this.f34581i = 0;
            return 0;
        }
        int iJ = J();
        this.f34581i = iJ;
        if ((iJ >>> 3) != 0) {
            return iJ;
        }
        throw new zzibg("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final void i(int i2) throws zzibg {
        if (this.f34581i != i2) {
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
                C(J());
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
        int i5 = this.f34578f - this.f34580h;
        byte[] bArr = this.f34577e;
        if (i5 >= 10) {
            while (i4 < 10) {
                int i6 = this.f34580h;
                this.f34580h = i6 + 1;
                if (bArr[i6] < 0) {
                    i4++;
                }
            }
            throw new zzibg("CodedInputStream encountered a malformed varint.");
        }
        while (i4 < 10) {
            if (this.f34580h == this.f34578f) {
                E(1);
            }
            int i7 = this.f34580h;
            this.f34580h = i7 + 1;
            if (bArr[i7] < 0) {
                i4++;
            }
        }
        throw new zzibg("CodedInputStream encountered a malformed varint.");
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final double k() {
        return Double.longBitsToDouble(N());
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final float l() {
        return Float.intBitsToFloat(M());
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long m() {
        return K();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long n() {
        return K();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int o() {
        return J();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long p() {
        return N();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int q() {
        return M();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final boolean r() {
        return K() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final String s() throws zzibg {
        int iJ = J();
        byte[] bArr = this.f34577e;
        if (iJ > 0) {
            int i2 = this.f34578f;
            int i3 = this.f34580h;
            if (iJ <= i2 - i3) {
                String str = new String(bArr, i3, iJ, zzibe.f34660a);
                this.f34580h += iJ;
                return str;
            }
        }
        if (iJ == 0) {
            return "";
        }
        if (iJ < 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (iJ > this.f34578f) {
            return new String(G(iJ), zzibe.f34660a);
        }
        E(iJ);
        String str2 = new String(bArr, this.f34580h, iJ, zzibe.f34660a);
        this.f34580h += iJ;
        return str2;
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final String t() throws IOException {
        int iJ = J();
        int i2 = this.f34580h;
        int i3 = this.f34578f;
        int i4 = i3 - i2;
        byte[] bArrG = this.f34577e;
        if (iJ <= i4 && iJ > 0) {
            this.f34580h = i2 + iJ;
        } else {
            if (iJ == 0) {
                return "";
            }
            if (iJ < 0) {
                throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            i2 = 0;
            if (iJ <= i3) {
                E(iJ);
                this.f34580h = iJ;
            } else {
                bArrG = G(iJ);
            }
        }
        return zzidr.f34775a.b(i2, bArrG, iJ);
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final zzhzl u() throws IOException {
        int iJ = J();
        int i2 = this.f34578f;
        int i3 = this.f34580h;
        int i4 = i2 - i3;
        byte[] bArr = this.f34577e;
        if (iJ <= i4 && iJ > 0) {
            zzhzl zzhzlVarW = zzhzl.w(i3, bArr, iJ);
            this.f34580h += iJ;
            return zzhzlVarW;
        }
        if (iJ == 0) {
            return zzhzl.f34557b;
        }
        if (iJ < 0) {
            throw new zzibg("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        byte[] bArrH = H(iJ);
        if (bArrH != null) {
            return zzhzl.w(0, bArrH, bArrH.length);
        }
        int i5 = this.f34580h;
        int i6 = this.f34578f;
        int i7 = i6 - i5;
        this.f34582j += i6;
        this.f34580h = 0;
        this.f34578f = 0;
        ArrayList arrayListI = I(iJ - i7);
        byte[] bArr2 = new byte[iJ];
        System.arraycopy(bArr, i5, bArr2, 0, i7);
        Iterator it = arrayListI.iterator();
        while (it.hasNext()) {
            byte[] bArr3 = (byte[]) it.next();
            int length = bArr3.length;
            System.arraycopy(bArr3, 0, bArr2, i7, length);
            i7 += length;
        }
        zzhzl zzhzlVar = zzhzl.f34557b;
        try {
            return new zzhzj(bArr2);
        } catch (zzibg e2) {
            throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int v() {
        return J();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int w() {
        return J();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int x() {
        return M();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final long y() {
        return N();
    }

    @Override // com.google.android.gms.internal.ads.zzhzq
    public final int z() {
        return zzhzq.f(J());
    }
}
