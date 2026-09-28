package com.appsflyer.internal;

import com.google.android.gms.common.api.Api;
import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class AFk1oSDK extends FilterInputStream implements AutoCloseable {
    private int AFInAppEventType;
    private int AFLogger;
    private final byte[][] areAllFieldsValid;
    private final byte[] component1;
    private final int[] component2;
    private final int component3;
    private final int[] component4;
    private int copy;
    private final int copydefault;
    private final byte[] equals;
    private final int hashCode;
    private int toString;
    private static final byte[] getMonetizationNetwork = AFk1uSDK.getMonetizationNetwork;
    private static final int[] getRevenue = AFk1uSDK.getMediationNetwork;
    private static final int[] getMediationNetwork = AFk1uSDK.AFAdRevenueData;
    private static final int[] getCurrencyIso4217Code = AFk1uSDK.getCurrencyIso4217Code;
    private static final int[] AFAdRevenueData = AFk1uSDK.getRevenue;

    public AFk1oSDK(InputStream inputStream, int i2, byte[] bArr, byte[][] bArr2) {
        this(inputStream, i2, bArr, bArr2, (byte) 0);
    }

    private void AFAdRevenueData(byte[] bArr, byte[] bArr2) {
        int[] iArr = this.component4;
        boolean z = true;
        char c2 = 2;
        char c3 = '\b';
        char c4 = 3;
        int i2 = (bArr[0] << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        int[] iArr2 = this.component2;
        iArr[0] = i2 ^ iArr2[0];
        char c5 = 5;
        char c6 = 6;
        iArr[1] = ((((bArr[4] << 24) | ((bArr[5] & 255) << 16)) | ((bArr[6] & 255) << 8)) | (bArr[7] & 255)) ^ iArr2[1];
        iArr[2] = ((bArr[11] & 255) | (((bArr[8] << 24) | ((bArr[9] & 255) << 16)) | ((bArr[10] & 255) << 8))) ^ iArr2[2];
        char c7 = 14;
        iArr[3] = (((((bArr[13] & 255) << 16) | (bArr[12] << 24)) | ((bArr[14] & 255) << 8)) | (bArr[15] & 255)) ^ iArr2[3];
        int i3 = 1;
        int i4 = 4;
        while (i3 < this.component3) {
            int[] iArr3 = getRevenue;
            int[] iArr4 = this.component4;
            boolean z2 = z;
            byte[][] bArr3 = this.areAllFieldsValid;
            byte[] bArr4 = bArr3[0];
            int i5 = iArr3[iArr4[bArr4[0]] >>> 24];
            int[] iArr5 = getMediationNetwork;
            byte[] bArr5 = bArr3[z2 ? 1 : 0];
            char c8 = c2;
            int i6 = i5 ^ iArr5[(iArr4[bArr5[0]] >>> 16) & 255];
            int[] iArr6 = getCurrencyIso4217Code;
            byte[] bArr6 = bArr3[c8];
            char c9 = c4;
            int i7 = i6 ^ iArr6[(iArr4[bArr6[0]] >>> 8) & 255];
            int[] iArr7 = AFAdRevenueData;
            byte[] bArr7 = bArr3[c9];
            char c10 = c3;
            int i8 = i7 ^ iArr7[iArr4[bArr7[0]] & 255];
            int[] iArr8 = this.component2;
            int i9 = i8 ^ iArr8[i4];
            char c11 = c7;
            char c12 = c5;
            int i10 = (((iArr3[iArr4[bArr4[z2 ? 1 : 0]] >>> 24] ^ iArr5[(iArr4[bArr5[z2 ? 1 : 0]] >>> 16) & 255]) ^ iArr6[(iArr4[bArr6[z2 ? 1 : 0]] >>> 8) & 255]) ^ iArr7[iArr4[bArr7[z2 ? 1 : 0]] & 255]) ^ iArr8[i4 + 1];
            int i11 = (((iArr3[iArr4[bArr4[c8]] >>> 24] ^ iArr5[(iArr4[bArr5[c8]] >>> 16) & 255]) ^ iArr6[(iArr4[bArr6[c8]] >>> 8) & 255]) ^ iArr7[iArr4[bArr7[c8]] & 255]) ^ iArr8[i4 + 2];
            int i12 = (((iArr3[iArr4[bArr4[c9]] >>> 24] ^ iArr5[(iArr4[bArr5[c9]] >>> 16) & 255]) ^ iArr6[(iArr4[bArr6[c9]] >>> 8) & 255]) ^ iArr7[iArr4[bArr7[c9]] & 255]) ^ iArr8[i4 + 3];
            iArr4[0] = i9;
            iArr4[z2 ? 1 : 0] = i10;
            iArr4[c8] = i11;
            iArr4[c9] = i12;
            i3++;
            i4 += 4;
            z = z2 ? 1 : 0;
            c2 = c8;
            c4 = c9;
            c3 = c10;
            c5 = c12;
            c7 = c11;
            c6 = c6;
        }
        boolean z3 = z;
        char c13 = c2;
        char c14 = c4;
        char c15 = c3;
        char c16 = c7;
        int[] iArr9 = this.component2;
        int i13 = iArr9[i4];
        byte[] bArr8 = getMonetizationNetwork;
        int[] iArr10 = this.component4;
        byte[][] bArr9 = this.areAllFieldsValid;
        byte[] bArr10 = bArr9[0];
        bArr2[0] = (byte) (bArr8[iArr10[bArr10[0]] >>> 24] ^ (i13 >>> 24));
        byte[] bArr11 = bArr9[z3 ? 1 : 0];
        bArr2[z3 ? 1 : 0] = (byte) (bArr8[(iArr10[bArr11[0]] >>> 16) & 255] ^ (i13 >>> 16));
        byte[] bArr12 = bArr9[c13];
        bArr2[c13] = (byte) (bArr8[(iArr10[bArr12[0]] >>> 8) & 255] ^ (i13 >>> 8));
        byte[] bArr13 = bArr9[c14];
        bArr2[c14] = (byte) (i13 ^ bArr8[iArr10[bArr13[0]] & 255]);
        int i14 = iArr9[i4 + 1];
        bArr2[4] = (byte) (bArr8[iArr10[bArr10[z3 ? 1 : 0]] >>> 24] ^ (i14 >>> 24));
        bArr2[c5] = (byte) (bArr8[(iArr10[bArr11[z3 ? 1 : 0]] >>> 16) & 255] ^ (i14 >>> 16));
        bArr2[c6] = (byte) (bArr8[(iArr10[bArr12[z3 ? 1 : 0]] >>> 8) & 255] ^ (i14 >>> 8));
        bArr2[7] = (byte) (i14 ^ bArr8[iArr10[bArr13[z3 ? 1 : 0]] & 255]);
        int i15 = iArr9[i4 + 2];
        bArr2[c15] = (byte) (bArr8[iArr10[bArr10[c13]] >>> 24] ^ (i15 >>> 24));
        bArr2[9] = (byte) (bArr8[(iArr10[bArr11[c13]] >>> 16) & 255] ^ (i15 >>> 16));
        bArr2[10] = (byte) (bArr8[(iArr10[bArr12[c13]] >>> 8) & 255] ^ (i15 >>> 8));
        bArr2[11] = (byte) (i15 ^ bArr8[iArr10[bArr13[c13]] & 255]);
        int i16 = iArr9[i4 + 3];
        bArr2[12] = (byte) (bArr8[iArr10[bArr10[c14]] >>> 24] ^ (i16 >>> 24));
        bArr2[13] = (byte) (bArr8[(iArr10[bArr11[c14]] >>> 16) & 255] ^ (i16 >>> 16));
        bArr2[c16] = (byte) (bArr8[(iArr10[bArr12[c14]] >>> 8) & 255] ^ (i16 >>> 8));
        bArr2[15] = (byte) (i16 ^ bArr8[iArr10[bArr13[c14]] & 255]);
    }

    private int getMediationNetwork() throws IOException {
        if (this.toString == Integer.MAX_VALUE) {
            this.toString = ((FilterInputStream) this).in.read();
        }
        if (this.AFInAppEventType == 16) {
            byte[] bArr = this.component1;
            int i2 = this.toString;
            bArr[0] = (byte) i2;
            if (i2 < 0) {
                throw new IllegalStateException("unexpected block size");
            }
            int i3 = 1;
            do {
                int i4 = ((FilterInputStream) this).in.read(this.component1, i3, 16 - i3);
                if (i4 <= 0) {
                    break;
                }
                i3 += i4;
            } while (i3 < 16);
            if (i3 < 16) {
                throw new IllegalStateException("unexpected block size");
            }
            int i5 = this.copydefault;
            if (i5 == this.hashCode) {
                AFAdRevenueData(this.component1, this.equals);
            } else {
                if (this.copy <= i5) {
                    AFAdRevenueData(this.component1, this.equals);
                } else {
                    byte[] bArr2 = this.component1;
                    System.arraycopy(bArr2, 0, this.equals, 0, bArr2.length);
                }
                int i6 = this.copy;
                if (i6 < this.hashCode) {
                    this.copy = i6 + 1;
                } else {
                    this.copy = 1;
                }
            }
            int i7 = ((FilterInputStream) this).in.read();
            this.toString = i7;
            this.AFInAppEventType = 0;
            this.AFLogger = i7 < 0 ? 16 - (this.equals[15] & 255) : 16;
        }
        return this.AFLogger;
    }

    private static byte[][] getRevenue(byte[][] bArr) {
        byte[][] bArr2 = new byte[bArr.length][];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = new byte[bArr[i2].length];
            int i3 = 0;
            while (true) {
                byte[] bArr3 = bArr[i2];
                if (i3 < bArr3.length) {
                    bArr2[i2][bArr3[i3]] = (byte) i3;
                    i3++;
                }
            }
        }
        return bArr2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        getMediationNetwork();
        return this.AFLogger - this.AFInAppEventType;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i2) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        getMediationNetwork();
        int i2 = this.AFInAppEventType;
        if (i2 >= this.AFLogger) {
            return -1;
        }
        byte[] bArr = this.equals;
        this.AFInAppEventType = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j2) throws IOException {
        long j3 = 0;
        while (j3 < j2 && read() != -1) {
            j3++;
        }
        return j3;
    }

    private AFk1oSDK(InputStream inputStream, int i2, byte[] bArr, byte[][] bArr2, byte b2) {
        super(new BufferedInputStream(inputStream, 4096));
        this.component4 = new int[4];
        this.component1 = new byte[16];
        this.equals = new byte[16];
        this.copy = 1;
        this.toString = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.AFInAppEventType = 16;
        this.AFLogger = 16;
        this.component3 = i2;
        this.component2 = AFk1uSDK.getCurrencyIso4217Code(bArr, i2);
        this.areAllFieldsValid = getRevenue(bArr2);
        this.copydefault = 100;
        this.hashCode = 100;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = i2 + i3;
        for (int i5 = i2; i5 < i4; i5++) {
            getMediationNetwork();
            int i6 = this.AFInAppEventType;
            if (i6 >= this.AFLogger) {
                if (i5 == i2) {
                    return -1;
                }
                return i3 - (i4 - i5);
            }
            byte[] bArr2 = this.equals;
            this.AFInAppEventType = i6 + 1;
            bArr[i5] = bArr2[i6];
        }
        return i3;
    }
}
