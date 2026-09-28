package net.jpountz.lz4;

import android.support.v4.media.b;
import java.nio.ByteBuffer;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.SafeUtils;

/* loaded from: classes3.dex */
final class LZ4JavaSafeFastDecompressor extends LZ4FastDecompressor {
    public static final LZ4FastDecompressor INSTANCE = new LZ4JavaSafeFastDecompressor();

    @Override // net.jpountz.lz4.LZ4FastDecompressor, net.jpountz.lz4.LZ4Decompressor
    public int decompress(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        byte b2;
        int i6;
        byte b3;
        SafeUtils.checkRange(bArr, i2);
        SafeUtils.checkRange(bArr2, i3, i4);
        if (i4 == 0) {
            if (SafeUtils.readByte(bArr, i2) == 0) {
                return 1;
            }
            throw new LZ4Exception(b.f(i2, "Malformed input at "));
        }
        int i7 = i4 + i3;
        int i8 = i2;
        int i9 = i3;
        while (true) {
            byte b4 = SafeUtils.readByte(bArr, i8);
            int i10 = i8 + 1;
            int i11 = (b4 & 255) >>> 4;
            if (i11 == 15) {
                while (true) {
                    i6 = i10 + 1;
                    b3 = SafeUtils.readByte(bArr, i10);
                    if (b3 != -1) {
                        break;
                    }
                    i11 += 255;
                    i10 = i6;
                }
                i11 += b3 & 255;
                i10 = i6;
            }
            int i12 = i9 + i11;
            int i13 = i7 - 8;
            if (i12 > i13) {
                if (i12 != i7) {
                    throw new LZ4Exception(b.f(i10, "Malformed input at "));
                }
                LZ4SafeUtils.safeArraycopy(bArr, i10, bArr2, i9, i11);
                return (i10 + i11) - i2;
            }
            LZ4SafeUtils.wildArraycopy(bArr, i10, bArr2, i9, i11);
            int i14 = i10 + i11;
            int shortLE = SafeUtils.readShortLE(bArr, i14);
            i8 = i14 + 2;
            int i15 = i12 - shortLE;
            if (i15 < i3) {
                throw new LZ4Exception(b.f(i8, "Malformed input at "));
            }
            int i16 = b4 & 15;
            if (i16 == 15) {
                while (true) {
                    i5 = i8 + 1;
                    b2 = SafeUtils.readByte(bArr, i8);
                    if (b2 != -1) {
                        break;
                    }
                    i16 += 255;
                    i8 = i5;
                }
                i16 += b2 & 255;
                i8 = i5;
            }
            int i17 = i16 + 4;
            int i18 = i12 + i17;
            if (i18 <= i13) {
                LZ4SafeUtils.wildIncrementalCopy(bArr2, i15, i12, i18);
            } else {
                if (i18 > i7) {
                    throw new LZ4Exception(b.f(i8, "Malformed input at "));
                }
                LZ4SafeUtils.safeIncrementalCopy(bArr2, i15, i12, i17);
            }
            i9 = i18;
        }
    }

    @Override // net.jpountz.lz4.LZ4FastDecompressor
    public int decompress(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, int i4) {
        int i5;
        byte b2;
        int i6;
        byte b3;
        if (byteBuffer.hasArray() && byteBuffer2.hasArray()) {
            return decompress(byteBuffer.array(), byteBuffer.arrayOffset() + i2, byteBuffer2.array(), byteBuffer2.arrayOffset() + i3, i4);
        }
        ByteBuffer byteBufferInNativeByteOrder = ByteBufferUtils.inNativeByteOrder(byteBuffer);
        ByteBuffer byteBufferInNativeByteOrder2 = ByteBufferUtils.inNativeByteOrder(byteBuffer2);
        ByteBufferUtils.checkRange(byteBufferInNativeByteOrder, i2);
        ByteBufferUtils.checkRange(byteBufferInNativeByteOrder2, i3, i4);
        if (i4 == 0) {
            if (ByteBufferUtils.readByte(byteBufferInNativeByteOrder, i2) == 0) {
                return 1;
            }
            throw new LZ4Exception(b.f(i2, "Malformed input at "));
        }
        int i7 = i3 + i4;
        int i8 = i2;
        int i9 = i3;
        while (true) {
            byte b4 = ByteBufferUtils.readByte(byteBufferInNativeByteOrder, i8);
            int i10 = i8 + 1;
            int i11 = (b4 & 255) >>> 4;
            if (i11 == 15) {
                while (true) {
                    i6 = i10 + 1;
                    b3 = ByteBufferUtils.readByte(byteBufferInNativeByteOrder, i10);
                    if (b3 != -1) {
                        break;
                    }
                    i11 += 255;
                    i10 = i6;
                }
                i11 += b3 & 255;
                i10 = i6;
            }
            int i12 = i9 + i11;
            int i13 = i7 - 8;
            if (i12 > i13) {
                if (i12 == i7) {
                    LZ4ByteBufferUtils.safeArraycopy(byteBufferInNativeByteOrder, i10, byteBufferInNativeByteOrder2, i9, i11);
                    return (i10 + i11) - i2;
                }
                throw new LZ4Exception(b.f(i10, "Malformed input at "));
            }
            LZ4ByteBufferUtils.wildArraycopy(byteBufferInNativeByteOrder, i10, byteBufferInNativeByteOrder2, i9, i11);
            int i14 = i10 + i11;
            int shortLE = ByteBufferUtils.readShortLE(byteBufferInNativeByteOrder, i14);
            i8 = i14 + 2;
            int i15 = i12 - shortLE;
            if (i15 < i3) {
                throw new LZ4Exception(b.f(i8, "Malformed input at "));
            }
            int i16 = b4 & 15;
            if (i16 == 15) {
                while (true) {
                    i5 = i8 + 1;
                    b2 = ByteBufferUtils.readByte(byteBufferInNativeByteOrder, i8);
                    if (b2 != -1) {
                        break;
                    }
                    i16 += 255;
                    i8 = i5;
                }
                i16 += b2 & 255;
                i8 = i5;
            }
            int i17 = i16 + 4;
            int i18 = i12 + i17;
            if (i18 <= i13) {
                LZ4ByteBufferUtils.wildIncrementalCopy(byteBufferInNativeByteOrder2, i15, i12, i18);
            } else if (i18 <= i7) {
                LZ4ByteBufferUtils.safeIncrementalCopy(byteBufferInNativeByteOrder2, i15, i12, i17);
            } else {
                throw new LZ4Exception(b.f(i8, "Malformed input at "));
            }
            i9 = i18;
        }
    }
}
