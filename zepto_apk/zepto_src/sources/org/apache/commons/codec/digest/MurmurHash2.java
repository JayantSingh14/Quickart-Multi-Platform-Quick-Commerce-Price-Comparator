package org.apache.commons.codec.digest;

import org.apache.commons.codec.binary.StringUtils;

/* loaded from: classes5.dex */
public final class MurmurHash2 {
    private static final int M32 = 1540483477;
    private static final long M64 = -4132994306676758123L;
    private static final int R32 = 24;
    private static final int R64 = 47;

    private MurmurHash2() {
    }

    private static int getLittleEndianInt(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    private static long getLittleEndianLong(byte[] bArr, int i2) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    public static int hash32(byte[] bArr, int i2, int i3) {
        int i4 = i3 ^ i2;
        int i5 = i2 >> 2;
        for (int i6 = 0; i6 < i5; i6++) {
            int littleEndianInt = getLittleEndianInt(bArr, i6 << 2) * M32;
            i4 = (i4 * M32) ^ ((littleEndianInt ^ (littleEndianInt >>> 24)) * M32);
        }
        int i7 = i5 << 2;
        int i8 = i2 - i7;
        if (i8 == 1) {
            i4 = ((bArr[i7] & 255) ^ i4) * M32;
        } else {
            if (i8 != 2) {
                if (i8 == 3) {
                    i4 ^= (bArr[i7 + 2] & 255) << 16;
                }
            }
            i4 ^= (bArr[i7 + 1] & 255) << 8;
            i4 = ((bArr[i7] & 255) ^ i4) * M32;
        }
        int i9 = ((i4 >>> 13) ^ i4) * M32;
        return i9 ^ (i9 >>> 15);
    }

    public static long hash64(byte[] bArr, int i2, int i3) {
        long j2 = (i3 & 4294967295L) ^ (i2 * M64);
        int i4 = i2 >> 3;
        for (int i5 = 0; i5 < i4; i5++) {
            long littleEndianLong = getLittleEndianLong(bArr, i5 << 3) * M64;
            j2 = (j2 ^ ((littleEndianLong ^ (littleEndianLong >>> 47)) * M64)) * M64;
        }
        switch (i2 - (i4 << 3)) {
            case 7:
                j2 ^= (bArr[r12 + 6] & 255) << 48;
            case 6:
                j2 ^= (bArr[r12 + 5] & 255) << 40;
            case 5:
                j2 ^= (bArr[r12 + 4] & 255) << 32;
            case 4:
                j2 ^= (bArr[r12 + 3] & 255) << 24;
            case 3:
                j2 ^= (bArr[r12 + 2] & 255) << 16;
            case 2:
                j2 ^= (bArr[r12 + 1] & 255) << 8;
            case 1:
                j2 = ((bArr[r12] & 255) ^ j2) * M64;
                break;
        }
        long j3 = ((j2 >>> 47) ^ j2) * M64;
        return j3 ^ (j3 >>> 47);
    }

    public static int hash32(byte[] bArr, int i2) {
        return hash32(bArr, i2, -1756908916);
    }

    public static int hash32(String str) {
        byte[] bytesUtf8 = StringUtils.getBytesUtf8(str);
        return hash32(bytesUtf8, bytesUtf8.length);
    }

    public static int hash32(String str, int i2, int i3) {
        return hash32(str.substring(i2, i3 + i2));
    }

    public static long hash64(byte[] bArr, int i2) {
        return hash64(bArr, i2, -512093083);
    }

    public static long hash64(String str) {
        byte[] bytesUtf8 = StringUtils.getBytesUtf8(str);
        return hash64(bytesUtf8, bytesUtf8.length);
    }

    public static long hash64(String str, int i2, int i3) {
        return hash64(str.substring(i2, i3 + i2));
    }
}
