package net.jpountz.xxhash;

import androidx.fragment.app.e;
import java.nio.ByteBuffer;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.UnsafeUtils;

/* loaded from: classes.dex */
final class XXHash64JavaUnsafe extends XXHash64 {
    public static final XXHash64 INSTANCE = new XXHash64JavaUnsafe();

    @Override // net.jpountz.xxhash.XXHash64
    public long hash(byte[] bArr, int i2, int i3, long j2) {
        long j3;
        int i4;
        char c2;
        long j4;
        long j5;
        long j6;
        long jH;
        int i5;
        long jRotateLeft;
        long j7;
        long jRotateLeft2;
        long j8;
        long j9;
        char c3;
        long jRotateLeft3;
        long j10;
        long jRotateLeft4;
        long j11;
        int i6;
        UnsafeUtils.checkRange(bArr, i2, i3);
        int i7 = i2 + i3;
        long j12 = -4417276706812531889L;
        int i8 = 31;
        long j13 = -7046029288634856825L;
        char c4 = ' ';
        if (i3 >= 32) {
            int i9 = i7 - 32;
            long j14 = j2 - 4417276706812531889L;
            long j15 = j2 - (-7046029288634856825L);
            long j16 = j2;
            long j17 = j2 + 6983438078262162902L;
            int i10 = i2;
            while (true) {
                j6 = 2870177450012600261L;
                jRotateLeft = Long.rotateLeft((UnsafeUtils.readLongLE(bArr, i10) * j12) + j17, i8);
                j5 = -8796714831421723037L;
                j7 = jRotateLeft * j13;
                j3 = j12;
                jRotateLeft2 = Long.rotateLeft((UnsafeUtils.readLongLE(bArr, i10 + 8) * j12) + j14, i8);
                j8 = j13;
                j9 = jRotateLeft2 * j8;
                c3 = c4;
                int i11 = i9;
                jRotateLeft3 = Long.rotateLeft((UnsafeUtils.readLongLE(bArr, i10 + 16) * j3) + j16, i8);
                j10 = jRotateLeft3 * j8;
                jRotateLeft4 = Long.rotateLeft((UnsafeUtils.readLongLE(bArr, i10 + 24) * j3) + j15, i8);
                j11 = jRotateLeft4 * j8;
                i6 = i10 + 32;
                if (i6 > i11) {
                    break;
                }
                j16 = j10;
                j13 = j8;
                j17 = j7;
                j15 = j11;
                i9 = i11;
                i10 = i6;
                c4 = c3;
                j14 = j9;
                i8 = 31;
                j12 = j3;
            }
            c2 = c3;
            i5 = i6;
            long jRotateLeft5 = ((((((((((Long.rotateLeft(j10, 12) + (Long.rotateLeft(j9, 7) + Long.rotateLeft(j7, 1))) + Long.rotateLeft(j11, 18)) ^ e.h(31, jRotateLeft, -2381459717836149591L, j8)) * j8) - 8796714831421723037L) ^ e.h(31, jRotateLeft2, -2381459717836149591L, j8)) * j8) - 8796714831421723037L) ^ e.h(31, jRotateLeft3, -2381459717836149591L, j8)) * j8) - 8796714831421723037L;
            i4 = 31;
            j4 = j8;
            jH = ((e.h(31, jRotateLeft4, -2381459717836149591L, j8) ^ jRotateLeft5) * j4) - 8796714831421723037L;
        } else {
            j3 = -4417276706812531889L;
            i4 = 31;
            c2 = ' ';
            j4 = -7046029288634856825L;
            j5 = -8796714831421723037L;
            j6 = 2870177450012600261L;
            jH = j2 + 2870177450012600261L;
            i5 = i2;
        }
        long jRotateLeft6 = jH + i3;
        int i12 = i5;
        while (i12 <= i7 - 8) {
            jRotateLeft6 = (Long.rotateLeft(jRotateLeft6 ^ (Long.rotateLeft(UnsafeUtils.readLongLE(bArr, i12) * j3, i4) * j4), 27) * j4) + j5;
            i12 += 8;
        }
        if (i12 <= i7 - 4) {
            jRotateLeft6 = (Long.rotateLeft(jRotateLeft6 ^ ((UnsafeUtils.readIntLE(bArr, i12) & 4294967295L) * j4), 23) * j3) + 1609587929392839161L;
            i12 += 4;
        }
        while (i12 < i7) {
            jRotateLeft6 = Long.rotateLeft(jRotateLeft6 ^ ((UnsafeUtils.readByte(bArr, i12) & 255) * j6), 11) * j4;
            i12++;
        }
        long j18 = ((jRotateLeft6 >>> 33) ^ jRotateLeft6) * j3;
        long j19 = (j18 ^ (j18 >>> 29)) * 1609587929392839161L;
        return j19 ^ (j19 >>> c2);
    }

    @Override // net.jpountz.xxhash.XXHash64
    public long hash(ByteBuffer byteBuffer, int i2, int i3, long j2) {
        char c2;
        long j3;
        int i4;
        long j4;
        long j5;
        long j6;
        long jRotateLeft;
        int i5;
        long jRotateLeft2;
        long j7;
        long jRotateLeft3;
        long j8;
        long jRotateLeft4;
        long j9;
        if (byteBuffer.hasArray()) {
            return hash(byteBuffer.array(), byteBuffer.arrayOffset() + i2, i3, j2);
        }
        ByteBufferUtils.checkRange(byteBuffer, i2, i3);
        ByteBuffer byteBufferInLittleEndianOrder = ByteBufferUtils.inLittleEndianOrder(byteBuffer);
        int i6 = i2 + i3;
        char c3 = ' ';
        long j10 = -4417276706812531889L;
        int i7 = 31;
        long j11 = -7046029288634856825L;
        if (i3 >= 32) {
            int i8 = i6 - 32;
            long j12 = j2 - (-7046029288634856825L);
            long j13 = j2 - 4417276706812531889L;
            long j14 = j2 + 6983438078262162902L;
            int i9 = i2;
            long jRotateLeft5 = j2;
            while (true) {
                j6 = 2870177450012600261L;
                jRotateLeft2 = Long.rotateLeft((ByteBufferUtils.readLongLE(byteBufferInLittleEndianOrder, i9) * j10) + j14, i7);
                j5 = -8796714831421723037L;
                j7 = jRotateLeft2 * j11;
                c2 = c3;
                j3 = j10;
                jRotateLeft3 = Long.rotateLeft((ByteBufferUtils.readLongLE(byteBufferInLittleEndianOrder, i9 + 8) * j10) + j13, i7);
                int i10 = i8;
                j8 = jRotateLeft3 * j11;
                jRotateLeft5 = Long.rotateLeft((ByteBufferUtils.readLongLE(byteBufferInLittleEndianOrder, i9 + 16) * j3) + jRotateLeft5, 31) * j11;
                j4 = j11;
                jRotateLeft4 = Long.rotateLeft((ByteBufferUtils.readLongLE(byteBufferInLittleEndianOrder, i9 + 24) * j3) + j12, 31);
                j9 = jRotateLeft4 * j4;
                i9 += 32;
                if (i9 > i10) {
                    break;
                }
                j12 = j9;
                j14 = j7;
                j10 = j3;
                c3 = c2;
                j13 = j8;
                i8 = i10;
                j11 = j4;
                i7 = 31;
            }
            i5 = i9;
            i4 = 31;
            jRotateLeft = ((((((((((((Long.rotateLeft(j9, 18) + (Long.rotateLeft(jRotateLeft5, 12) + (Long.rotateLeft(j8, 7) + Long.rotateLeft(j7, 1)))) ^ e.h(31, jRotateLeft2, -2381459717836149591L, j4)) * j4) - 8796714831421723037L) ^ e.h(31, jRotateLeft3, -2381459717836149591L, j4)) * j4) - 8796714831421723037L) ^ e.h(31, r23, -2381459717836149591L, j4)) * j4) - 8796714831421723037L) ^ e.h(31, jRotateLeft4, -2381459717836149591L, j4)) * j4) - 8796714831421723037L;
        } else {
            c2 = ' ';
            j3 = -4417276706812531889L;
            i4 = 31;
            j4 = -7046029288634856825L;
            j5 = -8796714831421723037L;
            j6 = 2870177450012600261L;
            jRotateLeft = j2 + 2870177450012600261L;
            i5 = i2;
        }
        long jRotateLeft6 = jRotateLeft + i3;
        int i11 = i5;
        while (i11 <= i6 - 8) {
            jRotateLeft6 = (Long.rotateLeft(jRotateLeft6 ^ (Long.rotateLeft(ByteBufferUtils.readLongLE(byteBufferInLittleEndianOrder, i11) * j3, i4) * j4), 27) * j4) + j5;
            i11 += 8;
        }
        if (i11 <= i6 - 4) {
            jRotateLeft6 = (Long.rotateLeft(jRotateLeft6 ^ ((ByteBufferUtils.readIntLE(byteBufferInLittleEndianOrder, i11) & 4294967295L) * j4), 23) * j3) + 1609587929392839161L;
            i11 += 4;
        }
        while (i11 < i6) {
            jRotateLeft6 = Long.rotateLeft(jRotateLeft6 ^ ((ByteBufferUtils.readByte(byteBufferInLittleEndianOrder, i11) & 255) * j6), 11) * j4;
            i11++;
        }
        long j15 = ((jRotateLeft6 >>> 33) ^ jRotateLeft6) * j3;
        long j16 = (j15 ^ (j15 >>> 29)) * 1609587929392839161L;
        return j16 ^ (j16 >>> c2);
    }
}
