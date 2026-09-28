package net.jpountz.lz4;

import android.support.v4.media.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import net.jpountz.util.ByteBufferUtils;

/* loaded from: classes3.dex */
enum LZ4ByteBufferUtils {
    ;

    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static class Match {
        int len;
        int ref;
        int start;

        public int end() {
            return this.start + this.len;
        }

        public void fix(int i2) {
            this.start += i2;
            this.ref += i2;
            this.len -= i2;
        }
    }

    public static int commonBytes(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        int iNumberOfTrailingZeros;
        int i5 = 0;
        while (i3 <= i4 - 8) {
            if (ByteBufferUtils.readLong(byteBuffer, i3) != ByteBufferUtils.readLong(byteBuffer, i2)) {
                if (byteBuffer.order() == ByteOrder.BIG_ENDIAN) {
                    iNumberOfTrailingZeros = Long.numberOfLeadingZeros(ByteBufferUtils.readLong(byteBuffer, i2) ^ ByteBufferUtils.readLong(byteBuffer, i3));
                } else {
                    iNumberOfTrailingZeros = Long.numberOfTrailingZeros(ByteBufferUtils.readLong(byteBuffer, i2) ^ ByteBufferUtils.readLong(byteBuffer, i3));
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
            if (ByteBufferUtils.readByte(byteBuffer, i2) != ByteBufferUtils.readByte(byteBuffer, i3)) {
                break;
            }
            i5++;
            i2 = i6;
            i3 = i7;
        }
        return i5;
    }

    public static int commonBytesBackward(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        while (i2 > i4 && i3 > i5) {
            i2--;
            i3--;
            if (byteBuffer.get(i2) != byteBuffer.get(i3)) {
                break;
            }
            i6++;
        }
        return i6;
    }

    public static void copyTo(Match match, Match match2) {
        match2.len = match.len;
        match2.start = match.start;
        match2.ref = match.ref;
    }

    public static int encodeSequence(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, ByteBuffer byteBuffer2, int i6, int i7) {
        int i8;
        int i9;
        int i10 = i3 - i2;
        int iWriteLen = i6 + 1;
        if (iWriteLen + i10 + 8 + (i10 >>> 8) > i7) {
            throw new LZ4Exception("maxDestLen is too small");
        }
        if (i10 >= 15) {
            iWriteLen = writeLen(i10 - 15, byteBuffer2, iWriteLen);
            i8 = -16;
        } else {
            i8 = i10 << 4;
        }
        wildArraycopy(byteBuffer, i2, byteBuffer2, iWriteLen, i10);
        int i11 = iWriteLen + i10;
        int i12 = i3 - i4;
        byteBuffer2.put(i11, (byte) i12);
        int iWriteLen2 = i11 + 2;
        byteBuffer2.put(i11 + 1, (byte) (i12 >>> 8));
        int i13 = i5 - 4;
        if (i11 + 8 + (i13 >>> 8) > i7) {
            throw new LZ4Exception("maxDestLen is too small");
        }
        if (i13 >= 15) {
            i9 = i8 | 15;
            iWriteLen2 = writeLen(i5 - 19, byteBuffer2, iWriteLen2);
        } else {
            i9 = i13 | i8;
        }
        byteBuffer2.put(i6, (byte) i9);
        return iWriteLen2;
    }

    public static int hash(ByteBuffer byteBuffer, int i2) {
        return LZ4Utils.hash(ByteBufferUtils.readInt(byteBuffer, i2));
    }

    public static int hash64k(ByteBuffer byteBuffer, int i2) {
        return LZ4Utils.hash64k(ByteBufferUtils.readInt(byteBuffer, i2));
    }

    public static int lastLiterals(ByteBuffer byteBuffer, int i2, int i3, ByteBuffer byteBuffer2, int i4, int i5) {
        int iWriteLen;
        if (((i3 + 240) / 255) + i4 + i3 + 1 > i5) {
            throw new LZ4Exception();
        }
        if (i3 >= 15) {
            byteBuffer2.put(i4, (byte) -16);
            iWriteLen = writeLen(i3 - 15, byteBuffer2, i4 + 1);
        } else {
            byteBuffer2.put(i4, (byte) (i3 << 4));
            iWriteLen = i4 + 1;
        }
        safeArraycopy(byteBuffer, i2, byteBuffer2, iWriteLen, i3);
        return iWriteLen + i3;
    }

    public static boolean readIntEquals(ByteBuffer byteBuffer, int i2, int i3) {
        return byteBuffer.getInt(i2) == byteBuffer.getInt(i3);
    }

    public static void safeArraycopy(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            byteBuffer2.put(i3 + i5, byteBuffer.get(i2 + i5));
        }
    }

    public static void safeIncrementalCopy(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            byteBuffer.put(i3 + i5, byteBuffer.get(i2 + i5));
        }
    }

    public static void wildArraycopy(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5 += 8) {
            try {
                byteBuffer2.putLong(i3 + i5, byteBuffer.getLong(i2 + i5));
            } catch (IndexOutOfBoundsException unused) {
                throw new LZ4Exception(b.f(i2, "Malformed input at offset "));
            }
        }
    }

    public static void wildIncrementalCopy(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if (i5 < 4) {
            int i6 = 0;
            for (int i7 = 0; i7 < 4; i7++) {
                ByteBufferUtils.writeByte(byteBuffer, i3 + i7, ByteBufferUtils.readByte(byteBuffer, i2 + i7));
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
            ByteBufferUtils.writeInt(byteBuffer, i8, ByteBufferUtils.readInt(byteBuffer, i9));
            i3 += 8;
            i2 = i9 - i6;
        } else if (i5 < 8) {
            ByteBufferUtils.writeLong(byteBuffer, i3, ByteBufferUtils.readLong(byteBuffer, i2));
            i3 += i5;
        }
        while (i3 < i4) {
            ByteBufferUtils.writeLong(byteBuffer, i3, ByteBufferUtils.readLong(byteBuffer, i2));
            i3 += 8;
            i2 += 8;
        }
    }

    public static int writeLen(int i2, ByteBuffer byteBuffer, int i3) {
        while (i2 >= 255) {
            byteBuffer.put(i3, (byte) -1);
            i2 -= 255;
            i3++;
        }
        int i4 = i3 + 1;
        byteBuffer.put(i3, (byte) i2);
        return i4;
    }
}
