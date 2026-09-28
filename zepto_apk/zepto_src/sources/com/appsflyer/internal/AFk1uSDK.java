package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class AFk1uSDK {
    private static byte[] component1 = new byte[256];
    static final byte[] getMonetizationNetwork = new byte[256];
    static final int[] getMediationNetwork = new int[256];
    static final int[] AFAdRevenueData = new int[256];
    static final int[] getCurrencyIso4217Code = new int[256];
    static final int[] getRevenue = new int[256];
    private static int[] areAllFieldsValid = new int[10];

    static {
        byte[] bArr;
        int i2;
        byte b2 = 1;
        byte b3 = 1;
        do {
            b2 = (byte) (((b2 & 128) != 0 ? 27 : 0) ^ ((b2 << 1) ^ b2));
            byte b4 = (byte) (b3 ^ (b3 << 1));
            byte b5 = (byte) (b4 ^ (b4 << 2));
            byte b6 = (byte) (b5 ^ (b5 << 4));
            b3 = (byte) (b6 ^ ((b6 & 128) != 0 ? (byte) 9 : (byte) 0));
            bArr = component1;
            i2 = b2 & 255;
            int i3 = b3 & 255;
            bArr[i2] = (byte) (((((b3 ^ 99) ^ ((i3 << 1) | (i3 >> 7))) ^ ((i3 << 2) | (i3 >> 6))) ^ ((i3 << 3) | (i3 >> 5))) ^ ((i3 >> 4) | (i3 << 4)));
        } while (i2 != 1);
        bArr[0] = 99;
        for (int i4 = 0; i4 < 256; i4++) {
            int i5 = component1[i4] & 255;
            getMonetizationNetwork[i5] = (byte) i4;
            int i6 = i4 << 1;
            if (i6 >= 256) {
                i6 ^= 283;
            }
            int i7 = i6 << 1;
            if (i7 >= 256) {
                i7 ^= 283;
            }
            int i8 = i7 << 1;
            if (i8 >= 256) {
                i8 ^= 283;
            }
            int i9 = i8 ^ i4;
            int i10 = ((i6 ^ (i7 ^ i8)) << 24) | (i9 << 16) | ((i9 ^ i7) << 8) | (i9 ^ i6);
            getMediationNetwork[i5] = i10;
            AFAdRevenueData[i5] = (i10 >>> 8) | (i10 << 24);
            getCurrencyIso4217Code[i5] = (i10 >>> 16) | (i10 << 16);
            getRevenue[i5] = (i10 << 8) | (i10 >>> 24);
        }
        areAllFieldsValid[0] = 16777216;
        int i11 = 1;
        for (int i12 = 1; i12 < 10; i12++) {
            i11 <<= 1;
            if (i11 >= 256) {
                i11 ^= 283;
            }
            areAllFieldsValid[i12] = i11 << 24;
        }
    }

    public static int[] getCurrencyIso4217Code(byte[] bArr, int i2) throws IllegalArgumentException {
        if (bArr.length != 16) {
            throw new IllegalArgumentException();
        }
        int i3 = 4;
        int i4 = (i2 + 1) * 4;
        int[] iArr = new int[i4];
        int i5 = 0;
        for (int i6 = 0; i6 < 4; i6++) {
            int i7 = i5 + 3;
            int i8 = ((bArr[i5 + 1] & 255) << 16) | (bArr[i5] << 24) | ((bArr[i5 + 2] & 255) << 8);
            i5 += 4;
            iArr[i6] = i8 | (bArr[i7] & 255);
        }
        int i9 = 4;
        int i10 = 0;
        int i11 = 0;
        while (i9 < i4) {
            int i12 = iArr[i9 - 1];
            if (i10 == 0) {
                byte[] bArr2 = component1;
                i12 = ((bArr2[i12 >>> 24] & 255) | (((bArr2[(i12 >>> 16) & 255] << 24) | ((bArr2[(i12 >>> 8) & 255] & 255) << 16)) | ((bArr2[i12 & 255] & 255) << 8))) ^ areAllFieldsValid[i11];
                i10 = 4;
                i11++;
            }
            iArr[i9] = i12 ^ iArr[i9 - 4];
            i9++;
            i10--;
        }
        if (bArr.length != 16) {
            throw new IllegalArgumentException();
        }
        int[] iArr2 = new int[i4];
        int i13 = i2 * 4;
        iArr2[0] = iArr[i13];
        int i14 = 1;
        iArr2[1] = iArr[i13 + 1];
        iArr2[2] = iArr[i13 + 2];
        char c2 = 3;
        iArr2[3] = iArr[i13 + 3];
        int i15 = i13 - 4;
        while (i14 < i2) {
            int i16 = iArr[i15];
            int[] iArr3 = getMediationNetwork;
            byte[] bArr3 = component1;
            int i17 = iArr3[bArr3[i16 >>> 24] & 255];
            int[] iArr4 = AFAdRevenueData;
            int i18 = i17 ^ iArr4[bArr3[(i16 >>> 16) & 255] & 255];
            int[] iArr5 = getCurrencyIso4217Code;
            int i19 = i18 ^ iArr5[bArr3[(i16 >>> 8) & 255] & 255];
            int[] iArr6 = getRevenue;
            iArr2[i3] = iArr6[bArr3[i16 & 255] & 255] ^ i19;
            int i20 = iArr[i15 + 1];
            char c3 = c2;
            int[] iArr7 = iArr2;
            iArr7[i3 + 1] = ((iArr4[bArr3[(i20 >>> 16) & 255] & 255] ^ iArr3[bArr3[i20 >>> 24] & 255]) ^ iArr5[bArr3[(i20 >>> 8) & 255] & 255]) ^ iArr6[bArr3[i20 & 255] & 255];
            int i21 = iArr[i15 + 2];
            int i22 = i3 + 3;
            iArr7[i3 + 2] = iArr6[bArr3[i21 & 255] & 255] ^ ((iArr3[bArr3[i21 >>> 24] & 255] ^ iArr4[bArr3[(i21 >>> 16) & 255] & 255]) ^ iArr5[bArr3[(i21 >>> 8) & 255] & 255]);
            int i23 = iArr[i15 + 3];
            i3 += 4;
            iArr7[i22] = iArr6[bArr3[i23 & 255] & 255] ^ ((iArr3[bArr3[i23 >>> 24] & 255] ^ iArr4[bArr3[(i23 >>> 16) & 255] & 255]) ^ iArr5[bArr3[(i23 >>> 8) & 255] & 255]);
            i15 -= 4;
            i14++;
            c2 = c3;
            iArr2 = iArr7;
        }
        int[] iArr8 = iArr2;
        iArr8[i3] = iArr[i15];
        iArr8[i3 + 1] = iArr[i15 + 1];
        iArr8[i3 + 2] = iArr[i15 + 2];
        iArr8[i3 + 3] = iArr[i15 + 3];
        return iArr8;
    }

    public static byte[][] getMediationNetwork(int i2) {
        byte[][] bArr = new byte[4][];
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = i2 >>> (i3 << 3);
            bArr[i3] = new byte[]{(byte) (i4 & 3), (byte) ((i4 >> 2) & 3), (byte) ((i4 >> 4) & 3), (byte) ((i4 >> 6) & 3)};
        }
        return bArr;
    }
}
