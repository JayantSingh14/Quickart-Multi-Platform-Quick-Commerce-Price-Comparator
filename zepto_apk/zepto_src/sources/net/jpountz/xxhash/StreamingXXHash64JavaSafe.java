package net.jpountz.xxhash;

import androidx.fragment.app.e;
import net.jpountz.util.SafeUtils;
import net.jpountz.xxhash.StreamingXXHash64;

/* loaded from: classes3.dex */
final class StreamingXXHash64JavaSafe extends AbstractStreamingXXHash64Java {

    public static class Factory implements StreamingXXHash64.Factory {
        public static final StreamingXXHash64.Factory INSTANCE = new Factory();

        @Override // net.jpountz.xxhash.StreamingXXHash64.Factory
        public StreamingXXHash64 newStreamingHash(long j2) {
            return new StreamingXXHash64JavaSafe(j2);
        }
    }

    public StreamingXXHash64JavaSafe(long j2) {
        super(j2);
    }

    @Override // net.jpountz.xxhash.StreamingXXHash64
    public long getValue() {
        long j2;
        long j3;
        long jH;
        int i2;
        if (this.totalLen >= 32) {
            long j4 = this.v1;
            long j5 = this.v2;
            j2 = 2870177450012600261L;
            long j6 = this.v3;
            j3 = -8796714831421723037L;
            jH = (((((e.h(31, j6, -4417276706812531889L, -7046029288634856825L) ^ (((((((Long.rotateLeft(r4, 18) + (Long.rotateLeft(j6, 12) + (Long.rotateLeft(j5, 7) + Long.rotateLeft(j4, 1)))) ^ e.h(31, j4, -4417276706812531889L, -7046029288634856825L)) * (-7046029288634856825L)) - 8796714831421723037L) ^ e.h(31, j5, -4417276706812531889L, -7046029288634856825L)) * (-7046029288634856825L)) - 8796714831421723037L)) * (-7046029288634856825L)) - 8796714831421723037L) ^ e.h(31, this.v4, -4417276706812531889L, -7046029288634856825L)) * (-7046029288634856825L)) - 8796714831421723037L;
        } else {
            j2 = 2870177450012600261L;
            j3 = -8796714831421723037L;
            jH = this.seed + 2870177450012600261L;
        }
        long jRotateLeft = jH + this.totalLen;
        int i3 = 0;
        while (true) {
            i2 = this.memSize;
            if (i3 > i2 - 8) {
                break;
            }
            jRotateLeft = (Long.rotateLeft(jRotateLeft ^ (Long.rotateLeft(SafeUtils.readLongLE(this.memory, i3) * (-4417276706812531889L), 31) * (-7046029288634856825L)), 27) * (-7046029288634856825L)) + j3;
            i3 += 8;
        }
        if (i3 <= i2 - 4) {
            jRotateLeft = (Long.rotateLeft(jRotateLeft ^ ((SafeUtils.readIntLE(this.memory, i3) & 4294967295L) * (-7046029288634856825L)), 23) * (-4417276706812531889L)) + 1609587929392839161L;
            i3 += 4;
        }
        while (i3 < this.memSize) {
            jRotateLeft = Long.rotateLeft(jRotateLeft ^ ((this.memory[i3] & 255) * j2), 11) * (-7046029288634856825L);
            i3++;
        }
        long j7 = (jRotateLeft ^ (jRotateLeft >>> 33)) * (-4417276706812531889L);
        long j8 = (j7 ^ (j7 >>> 29)) * 1609587929392839161L;
        return j8 ^ (j8 >>> 32);
    }

    @Override // net.jpountz.xxhash.StreamingXXHash64
    public void update(byte[] bArr, int i2, int i3) {
        int i4 = i2;
        SafeUtils.checkRange(bArr, i2, i3);
        this.totalLen += i3;
        int i5 = this.memSize;
        if (i5 + i3 < 32) {
            System.arraycopy(bArr, i4, this.memory, i5, i3);
            this.memSize += i3;
            return;
        }
        int i6 = i3 + i4;
        if (i5 > 0) {
            System.arraycopy(bArr, i4, this.memory, i5, 32 - i5);
            long longLE = (SafeUtils.readLongLE(this.memory, 0) * (-4417276706812531889L)) + this.v1;
            this.v1 = longLE;
            this.v1 = Long.rotateLeft(longLE, 31) * (-7046029288634856825L);
            long longLE2 = (SafeUtils.readLongLE(this.memory, 8) * (-4417276706812531889L)) + this.v2;
            this.v2 = longLE2;
            this.v2 = Long.rotateLeft(longLE2, 31) * (-7046029288634856825L);
            long longLE3 = (SafeUtils.readLongLE(this.memory, 16) * (-4417276706812531889L)) + this.v3;
            this.v3 = longLE3;
            this.v3 = Long.rotateLeft(longLE3, 31) * (-7046029288634856825L);
            long longLE4 = (SafeUtils.readLongLE(this.memory, 24) * (-4417276706812531889L)) + this.v4;
            this.v4 = longLE4;
            this.v4 = Long.rotateLeft(longLE4, 31) * (-7046029288634856825L);
            i4 += 32 - this.memSize;
            this.memSize = 0;
        }
        int i7 = i6 - 32;
        long jRotateLeft = this.v1;
        long jRotateLeft2 = this.v2;
        long jRotateLeft3 = this.v3;
        long jRotateLeft4 = this.v4;
        while (i4 <= i7) {
            jRotateLeft = Long.rotateLeft((SafeUtils.readLongLE(bArr, i4) * (-4417276706812531889L)) + jRotateLeft, 31) * (-7046029288634856825L);
            jRotateLeft2 = Long.rotateLeft((SafeUtils.readLongLE(bArr, i4 + 8) * (-4417276706812531889L)) + jRotateLeft2, 31) * (-7046029288634856825L);
            jRotateLeft3 = Long.rotateLeft((SafeUtils.readLongLE(bArr, i4 + 16) * (-4417276706812531889L)) + jRotateLeft3, 31) * (-7046029288634856825L);
            jRotateLeft4 = Long.rotateLeft((SafeUtils.readLongLE(bArr, i4 + 24) * (-4417276706812531889L)) + jRotateLeft4, 31) * (-7046029288634856825L);
            i4 += 32;
        }
        this.v1 = jRotateLeft;
        this.v2 = jRotateLeft2;
        this.v3 = jRotateLeft3;
        this.v4 = jRotateLeft4;
        if (i4 < i6) {
            int i8 = i6 - i4;
            System.arraycopy(bArr, i4, this.memory, 0, i8);
            this.memSize = i8;
        }
    }
}
