package net.jpountz.xxhash;

import java.nio.ByteBuffer;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.UnsafeUtils;

/* loaded from: classes.dex */
final class XXHash32JavaUnsafe extends XXHash32 {
    public static final XXHash32 INSTANCE = new XXHash32JavaUnsafe();

    @Override // net.jpountz.xxhash.XXHash32
    public int hash(byte[] bArr, int i2, int i3, int i4) {
        int iRotateLeft;
        int iRotateLeft2;
        UnsafeUtils.checkRange(bArr, i2, i3);
        int i5 = i2 + i3;
        if (i3 >= 16) {
            int i6 = i5 - 16;
            int i7 = 606290984 + i4;
            int iRotateLeft3 = i4 - 2048144777;
            int iRotateLeft4 = i4 - (-1640531535);
            while (true) {
                iRotateLeft2 = Integer.rotateLeft((UnsafeUtils.readIntLE(bArr, i2) * (-2048144777)) + i7, 13) * (-1640531535);
                iRotateLeft3 = Integer.rotateLeft((UnsafeUtils.readIntLE(bArr, i2 + 4) * (-2048144777)) + iRotateLeft3, 13) * (-1640531535);
                i4 = Integer.rotateLeft((UnsafeUtils.readIntLE(bArr, i2 + 8) * (-2048144777)) + i4, 13) * (-1640531535);
                iRotateLeft4 = Integer.rotateLeft((UnsafeUtils.readIntLE(bArr, i2 + 12) * (-2048144777)) + iRotateLeft4, 13) * (-1640531535);
                i2 += 16;
                if (i2 > i6) {
                    break;
                }
                i7 = iRotateLeft2;
            }
            iRotateLeft = Integer.rotateLeft(iRotateLeft4, 18) + Integer.rotateLeft(i4, 12) + Integer.rotateLeft(iRotateLeft3, 7) + Integer.rotateLeft(iRotateLeft2, 1);
        } else {
            iRotateLeft = i4 + 374761393;
        }
        int iRotateLeft5 = iRotateLeft + i3;
        while (i2 <= i5 - 4) {
            iRotateLeft5 = Integer.rotateLeft((UnsafeUtils.readIntLE(bArr, i2) * (-1028477379)) + iRotateLeft5, 17) * 668265263;
            i2 += 4;
        }
        while (i2 < i5) {
            iRotateLeft5 = Integer.rotateLeft(((UnsafeUtils.readByte(bArr, i2) & 255) * 374761393) + iRotateLeft5, 11) * (-1640531535);
            i2++;
        }
        int i8 = ((iRotateLeft5 >>> 15) ^ iRotateLeft5) * (-2048144777);
        int i9 = (i8 ^ (i8 >>> 13)) * (-1028477379);
        return i9 ^ (i9 >>> 16);
    }

    @Override // net.jpountz.xxhash.XXHash32
    public int hash(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        int iRotateLeft;
        int iRotateLeft2;
        if (byteBuffer.hasArray()) {
            return hash(byteBuffer.array(), byteBuffer.arrayOffset() + i2, i3, i4);
        }
        ByteBufferUtils.checkRange(byteBuffer, i2, i3);
        ByteBuffer byteBufferInLittleEndianOrder = ByteBufferUtils.inLittleEndianOrder(byteBuffer);
        int i5 = i2 + i3;
        if (i3 >= 16) {
            int i6 = i5 - 16;
            int i7 = 606290984 + i4;
            int iRotateLeft3 = i4 - 2048144777;
            int iRotateLeft4 = i4 - (-1640531535);
            while (true) {
                iRotateLeft2 = Integer.rotateLeft((ByteBufferUtils.readIntLE(byteBufferInLittleEndianOrder, i2) * (-2048144777)) + i7, 13) * (-1640531535);
                iRotateLeft3 = Integer.rotateLeft((ByteBufferUtils.readIntLE(byteBufferInLittleEndianOrder, i2 + 4) * (-2048144777)) + iRotateLeft3, 13) * (-1640531535);
                i4 = Integer.rotateLeft((ByteBufferUtils.readIntLE(byteBufferInLittleEndianOrder, i2 + 8) * (-2048144777)) + i4, 13) * (-1640531535);
                iRotateLeft4 = Integer.rotateLeft((ByteBufferUtils.readIntLE(byteBufferInLittleEndianOrder, i2 + 12) * (-2048144777)) + iRotateLeft4, 13) * (-1640531535);
                i2 += 16;
                if (i2 > i6) {
                    break;
                }
                i7 = iRotateLeft2;
            }
            iRotateLeft = Integer.rotateLeft(iRotateLeft4, 18) + Integer.rotateLeft(i4, 12) + Integer.rotateLeft(iRotateLeft3, 7) + Integer.rotateLeft(iRotateLeft2, 1);
        } else {
            iRotateLeft = i4 + 374761393;
        }
        int iRotateLeft5 = iRotateLeft + i3;
        while (i2 <= i5 - 4) {
            iRotateLeft5 = Integer.rotateLeft((ByteBufferUtils.readIntLE(byteBufferInLittleEndianOrder, i2) * (-1028477379)) + iRotateLeft5, 17) * 668265263;
            i2 += 4;
        }
        while (i2 < i5) {
            iRotateLeft5 = Integer.rotateLeft(((ByteBufferUtils.readByte(byteBufferInLittleEndianOrder, i2) & 255) * 374761393) + iRotateLeft5, 11) * (-1640531535);
            i2++;
        }
        int i8 = ((iRotateLeft5 >>> 15) ^ iRotateLeft5) * (-2048144777);
        int i9 = (i8 ^ (i8 >>> 13)) * (-1028477379);
        return i9 ^ (i9 >>> 16);
    }
}
