package net.jpountz.xxhash;

import net.jpountz.util.SafeUtils;
import net.jpountz.xxhash.StreamingXXHash32;

/* loaded from: classes3.dex */
final class StreamingXXHash32JavaSafe extends AbstractStreamingXXHash32Java {

    public static class Factory implements StreamingXXHash32.Factory {
        public static final StreamingXXHash32.Factory INSTANCE = new Factory();

        @Override // net.jpountz.xxhash.StreamingXXHash32.Factory
        public StreamingXXHash32 newStreamingHash(int i2) {
            return new StreamingXXHash32JavaSafe(i2);
        }
    }

    public StreamingXXHash32JavaSafe(int i2) {
        super(i2);
    }

    @Override // net.jpountz.xxhash.StreamingXXHash32
    public int getValue() {
        int iRotateLeft;
        if (this.totalLen >= 16) {
            iRotateLeft = Integer.rotateLeft(this.v4, 18) + Integer.rotateLeft(this.v3, 12) + Integer.rotateLeft(this.v2, 7) + Integer.rotateLeft(this.v1, 1);
        } else {
            iRotateLeft = this.seed + 374761393;
        }
        int iRotateLeft2 = (int) (iRotateLeft + this.totalLen);
        int i2 = 0;
        while (i2 <= this.memSize - 4) {
            iRotateLeft2 = Integer.rotateLeft((SafeUtils.readIntLE(this.memory, i2) * (-1028477379)) + iRotateLeft2, 17) * 668265263;
            i2 += 4;
        }
        while (i2 < this.memSize) {
            iRotateLeft2 = Integer.rotateLeft(((SafeUtils.readByte(this.memory, i2) & 255) * 374761393) + iRotateLeft2, 11) * (-1640531535);
            i2++;
        }
        int i3 = (iRotateLeft2 ^ (iRotateLeft2 >>> 15)) * (-2048144777);
        int i4 = (i3 ^ (i3 >>> 13)) * (-1028477379);
        return i4 ^ (i4 >>> 16);
    }

    @Override // net.jpountz.xxhash.StreamingXXHash32
    public void update(byte[] bArr, int i2, int i3) {
        SafeUtils.checkRange(bArr, i2, i3);
        this.totalLen += i3;
        int i4 = this.memSize;
        if (i4 + i3 < 16) {
            System.arraycopy(bArr, i2, this.memory, i4, i3);
            this.memSize += i3;
            return;
        }
        int i5 = i3 + i2;
        if (i4 > 0) {
            System.arraycopy(bArr, i2, this.memory, i4, 16 - i4);
            int intLE = (SafeUtils.readIntLE(this.memory, 0) * (-2048144777)) + this.v1;
            this.v1 = intLE;
            this.v1 = Integer.rotateLeft(intLE, 13) * (-1640531535);
            int intLE2 = (SafeUtils.readIntLE(this.memory, 4) * (-2048144777)) + this.v2;
            this.v2 = intLE2;
            this.v2 = Integer.rotateLeft(intLE2, 13) * (-1640531535);
            int intLE3 = (SafeUtils.readIntLE(this.memory, 8) * (-2048144777)) + this.v3;
            this.v3 = intLE3;
            this.v3 = Integer.rotateLeft(intLE3, 13) * (-1640531535);
            int intLE4 = (SafeUtils.readIntLE(this.memory, 12) * (-2048144777)) + this.v4;
            this.v4 = intLE4;
            this.v4 = Integer.rotateLeft(intLE4, 13) * (-1640531535);
            i2 += 16 - this.memSize;
            this.memSize = 0;
        }
        int i6 = i5 - 16;
        int iRotateLeft = this.v1;
        int iRotateLeft2 = this.v2;
        int iRotateLeft3 = this.v3;
        int iRotateLeft4 = this.v4;
        while (i2 <= i6) {
            iRotateLeft = Integer.rotateLeft((SafeUtils.readIntLE(bArr, i2) * (-2048144777)) + iRotateLeft, 13) * (-1640531535);
            iRotateLeft2 = Integer.rotateLeft((SafeUtils.readIntLE(bArr, i2 + 4) * (-2048144777)) + iRotateLeft2, 13) * (-1640531535);
            iRotateLeft3 = Integer.rotateLeft((SafeUtils.readIntLE(bArr, i2 + 8) * (-2048144777)) + iRotateLeft3, 13) * (-1640531535);
            iRotateLeft4 = Integer.rotateLeft((SafeUtils.readIntLE(bArr, i2 + 12) * (-2048144777)) + iRotateLeft4, 13) * (-1640531535);
            i2 += 16;
        }
        this.v1 = iRotateLeft;
        this.v2 = iRotateLeft2;
        this.v3 = iRotateLeft3;
        this.v4 = iRotateLeft4;
        if (i2 < i5) {
            int i7 = i5 - i2;
            System.arraycopy(bArr, i2, this.memory, 0, i7);
            this.memSize = i7;
        }
    }
}
