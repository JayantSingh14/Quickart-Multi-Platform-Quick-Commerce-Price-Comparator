package net.jpountz.lz4;

import java.nio.ByteOrder;
import net.jpountz.util.UnsafeUtils;
import net.jpountz.util.Utils;

/* loaded from: classes.dex */
enum LZ4UnsafeUtils {
    ;

    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static int commonBytes(byte[] bArr, int i2, int i3, int i4) {
        int iNumberOfTrailingZeros;
        int i5 = 0;
        while (i3 <= i4 - 8) {
            if (UnsafeUtils.readLong(bArr, i3) != UnsafeUtils.readLong(bArr, i2)) {
                if (Utils.NATIVE_BYTE_ORDER == ByteOrder.BIG_ENDIAN) {
                    iNumberOfTrailingZeros = Long.numberOfLeadingZeros(UnsafeUtils.readLong(bArr, i2) ^ UnsafeUtils.readLong(bArr, i3));
                } else {
                    iNumberOfTrailingZeros = Long.numberOfTrailingZeros(UnsafeUtils.readLong(bArr, i2) ^ UnsafeUtils.readLong(bArr, i3));
                }
                return i5 + (iNumberOfTrailingZeros >>> 3);
            }
            i5 += 8;
            i2 += 8;
            i3 += 8;
        }
        while (i3 < i4) {
            int i6 = i2 + 1;
            int i7 = i3 + 1;
            if (UnsafeUtils.readByte(bArr, i2) != UnsafeUtils.readByte(bArr, i3)) {
                break;
            }
            i5++;
            i2 = i6;
            i3 = i7;
        }
        return i5;
    }

    public static int commonBytesBackward(byte[] bArr, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        while (i2 > i4 && i3 > i5) {
            i2--;
            i3--;
            if (UnsafeUtils.readByte(bArr, i2) != UnsafeUtils.readByte(bArr, i3)) {
                break;
            }
            i6++;
        }
        return i6;
    }

    public static int encodeSequence(byte[] bArr, int i2, int i3, int i4, int i5, byte[] bArr2, int i6, int i7) {
        int i8;
        int i9;
        int i10 = i3 - i2;
        int iWriteLen = i6 + 1;
        if (i10 >= 15) {
            iWriteLen = writeLen(i10 - 15, bArr2, iWriteLen);
            i8 = -16;
        } else {
            i8 = i10 << 4;
        }
        wildArraycopy(bArr, i2, bArr2, iWriteLen, i10);
        int i11 = iWriteLen + i10;
        int i12 = i3 - i4;
        bArr2[i11] = (byte) i12;
        int iWriteLen2 = i11 + 2;
        bArr2[i11 + 1] = (byte) (i12 >>> 8);
        int i13 = i5 - 4;
        if (i11 + 8 + (i13 >>> 8) > i7) {
            throw new LZ4Exception("maxDestLen is too small");
        }
        if (i13 >= 15) {
            i9 = i8 | 15;
            iWriteLen2 = writeLen(i5 - 19, bArr2, iWriteLen2);
        } else {
            i9 = i13 | i8;
        }
        bArr2[i6] = (byte) i9;
        return iWriteLen2;
    }

    public static int lastLiterals(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        return LZ4SafeUtils.lastLiterals(bArr, i2, i3, bArr2, i4, i5);
    }

    public static boolean readIntEquals(byte[] bArr, int i2, int i3) {
        return UnsafeUtils.readInt(bArr, i2) == UnsafeUtils.readInt(bArr, i3);
    }

    public static int readShortLittleEndian(byte[] bArr, int i2) {
        short sReverseBytes = UnsafeUtils.readShort(bArr, i2);
        if (Utils.NATIVE_BYTE_ORDER == ByteOrder.BIG_ENDIAN) {
            sReverseBytes = Short.reverseBytes(sReverseBytes);
        }
        return sReverseBytes & 65535;
    }

    public static void safeArraycopy(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int i5 = i4 & (-8);
        wildArraycopy(bArr, i2, bArr2, i3, i5);
        int i6 = i4 & 7;
        for (int i7 = 0; i7 < i6; i7++) {
            UnsafeUtils.writeByte(bArr2, i3 + i5 + i7, UnsafeUtils.readByte(bArr, i2 + i5 + i7));
        }
    }

    public static void safeIncrementalCopy(byte[] bArr, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i3 + i5;
            int i7 = i2 + i5;
            bArr[i6] = bArr[i7];
            UnsafeUtils.writeByte(bArr, i6, UnsafeUtils.readByte(bArr, i7));
        }
    }

    public static void wildArraycopy(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5 += 8) {
            UnsafeUtils.writeLong(bArr2, i3 + i5, UnsafeUtils.readLong(bArr, i2 + i5));
        }
    }

    public static void wildIncrementalCopy(byte[] bArr, int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if (i5 < 4) {
            int i6 = 0;
            for (int i7 = 0; i7 < 4; i7++) {
                UnsafeUtils.writeByte(bArr, i3 + i7, UnsafeUtils.readByte(bArr, i2 + i7));
            }
            int i8 = i3 + 4;
            int i9 = i2 + 4;
            int i10 = i8 - i9;
            if (i10 == 1) {
                i9 = i2 + 1;
            } else if (i10 == 2) {
                i9 = i2 + 2;
            } else if (i10 == 3) {
                i9 = i2 + 1;
                i6 = -1;
            } else if (i10 == 5) {
                i6 = 1;
            } else if (i10 == 6) {
                i6 = 2;
            } else if (i10 == 7) {
                i6 = 3;
            }
            UnsafeUtils.writeInt(bArr, i8, UnsafeUtils.readInt(bArr, i9));
            i3 += 8;
            i2 = i9 - i6;
        } else if (i5 < 8) {
            UnsafeUtils.writeLong(bArr, i3, UnsafeUtils.readLong(bArr, i2));
            i3 += i5;
        }
        while (i3 < i4) {
            UnsafeUtils.writeLong(bArr, i3, UnsafeUtils.readLong(bArr, i2));
            i3 += 8;
            i2 += 8;
        }
    }

    public static int writeLen(int i2, byte[] bArr, int i3) {
        while (i2 >= 255) {
            UnsafeUtils.writeByte(bArr, i3, 255);
            i2 -= 255;
            i3++;
        }
        int i4 = i3 + 1;
        UnsafeUtils.writeByte(bArr, i3, i2);
        return i4;
    }

    public static void writeShortLittleEndian(byte[] bArr, int i2, int i3) {
        short sReverseBytes = (short) i3;
        if (Utils.NATIVE_BYTE_ORDER == ByteOrder.BIG_ENDIAN) {
            sReverseBytes = Short.reverseBytes(sReverseBytes);
        }
        UnsafeUtils.writeShort(bArr, i2, sReverseBytes);
    }
}
