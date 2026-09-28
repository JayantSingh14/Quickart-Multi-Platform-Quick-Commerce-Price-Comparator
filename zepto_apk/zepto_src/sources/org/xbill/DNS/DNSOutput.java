package org.xbill.DNS;

/* loaded from: classes5.dex */
public class DNSOutput {
    private byte[] array;
    private int pos;
    private int savedPos;

    public DNSOutput(int i2) {
        this.array = new byte[i2];
        this.pos = 0;
        this.savedPos = -1;
    }

    private void check(long j2, int i2) {
        long j3 = 1 << i2;
        if (j2 < 0 || j2 > j3) {
            throw new IllegalArgumentException(j2 + " out of range for " + i2 + " bit value");
        }
    }

    private void need(int i2) {
        byte[] bArr = this.array;
        int length = bArr.length;
        int i3 = this.pos;
        if (length - i3 >= i2) {
            return;
        }
        int length2 = bArr.length * 2;
        if (length2 < i3 + i2) {
            length2 = i3 + i2;
        }
        byte[] bArr2 = new byte[length2];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        this.array = bArr2;
    }

    public static byte[] toU16(int i2) {
        return new byte[]{(byte) ((i2 >>> 8) & 255), (byte) (i2 & 255)};
    }

    public int current() {
        return this.pos;
    }

    public void jump(int i2) {
        if (i2 > this.pos) {
            throw new IllegalArgumentException("cannot jump past end of data");
        }
        this.pos = i2;
    }

    public void restore() {
        int i2 = this.savedPos;
        if (i2 < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.pos = i2;
        this.savedPos = -1;
    }

    public void save() {
        this.savedPos = this.pos;
    }

    public byte[] toByteArray() {
        int i2 = this.pos;
        byte[] bArr = new byte[i2];
        System.arraycopy(this.array, 0, bArr, 0, i2);
        return bArr;
    }

    public void writeByteArray(byte[] bArr, int i2, int i3) {
        need(i3);
        System.arraycopy(bArr, i2, this.array, this.pos, i3);
        this.pos += i3;
    }

    public void writeCountedString(byte[] bArr) {
        if (bArr.length > 255) {
            throw new IllegalArgumentException("Invalid counted string");
        }
        need(bArr.length + 1);
        byte[] bArr2 = this.array;
        int i2 = this.pos;
        this.pos = i2 + 1;
        bArr2[i2] = (byte) (255 & bArr.length);
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeU16(int i2) {
        check(i2, 16);
        need(2);
        byte[] bArr = this.array;
        int i3 = this.pos;
        int i4 = i3 + 1;
        this.pos = i4;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        this.pos = i3 + 2;
        bArr[i4] = (byte) (i2 & 255);
    }

    public void writeU16At(int i2, int i3) {
        check(i2, 16);
        if (i3 > this.pos - 2) {
            throw new IllegalArgumentException("cannot write past end of data");
        }
        byte[] bArr = this.array;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i3 + 1] = (byte) (i2 & 255);
    }

    public void writeU32(long j2) {
        check(j2, 32);
        need(4);
        byte[] bArr = this.array;
        int i2 = this.pos;
        int i3 = i2 + 1;
        this.pos = i3;
        bArr[i2] = (byte) ((j2 >>> 24) & 255);
        int i4 = i2 + 2;
        this.pos = i4;
        bArr[i3] = (byte) ((j2 >>> 16) & 255);
        int i5 = i2 + 3;
        this.pos = i5;
        bArr[i4] = (byte) ((j2 >>> 8) & 255);
        this.pos = i2 + 4;
        bArr[i5] = (byte) (j2 & 255);
    }

    public void writeU8(int i2) {
        check(i2, 8);
        need(1);
        byte[] bArr = this.array;
        int i3 = this.pos;
        this.pos = i3 + 1;
        bArr[i3] = (byte) (i2 & 255);
    }

    public void writeByteArray(byte[] bArr) {
        writeByteArray(bArr, 0, bArr.length);
    }

    public DNSOutput() {
        this(32);
    }
}
