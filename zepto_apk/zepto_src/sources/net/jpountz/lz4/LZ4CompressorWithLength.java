package net.jpountz.lz4;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class LZ4CompressorWithLength {
    private final LZ4Compressor compressor;

    public LZ4CompressorWithLength(LZ4Compressor lZ4Compressor) {
        this.compressor = lZ4Compressor;
    }

    private void putOriginalLength(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) i3;
        bArr[i2 + 1] = (byte) (i3 >> 8);
        bArr[i2 + 2] = (byte) (i3 >> 16);
        bArr[i2 + 3] = (byte) (i3 >> 24);
    }

    public byte[] compress(byte[] bArr) {
        return compress(bArr, 0, bArr.length);
    }

    public int maxCompressedLength(int i2) {
        return this.compressor.maxCompressedLength(i2) + 4;
    }

    public byte[] compress(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[maxCompressedLength(i3)];
        return Arrays.copyOf(bArr2, compress(bArr, i2, i3, bArr2, 0));
    }

    private void putOriginalLength(ByteBuffer byteBuffer, int i2, int i3) {
        byteBuffer.put(i2, (byte) i3);
        byteBuffer.put(i2 + 1, (byte) (i3 >> 8));
        byteBuffer.put(i2 + 2, (byte) (i3 >> 16));
        byteBuffer.put(i2 + 3, (byte) (i3 >> 24));
    }

    public int compress(byte[] bArr, byte[] bArr2) {
        return compress(bArr, 0, bArr.length, bArr2, 0);
    }

    public int compress(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        return compress(bArr, i2, i3, bArr2, i4, bArr2.length - i4);
    }

    public int compress(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        int iCompress = this.compressor.compress(bArr, i2, i3, bArr2, i4 + 4, i5 - 4);
        putOriginalLength(bArr2, i4, i3);
        return iCompress + 4;
    }

    public void compress(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int iCompress = compress(byteBuffer, byteBuffer.position(), byteBuffer.remaining(), byteBuffer2, byteBuffer2.position(), byteBuffer2.remaining());
        byteBuffer.position(byteBuffer.limit());
        byteBuffer2.position(byteBuffer2.position() + iCompress);
    }

    public int compress(ByteBuffer byteBuffer, int i2, int i3, ByteBuffer byteBuffer2, int i4, int i5) {
        int iCompress = this.compressor.compress(byteBuffer, i2, i3, byteBuffer2, i4 + 4, i5 - 4);
        putOriginalLength(byteBuffer2, i4, i3);
        return iCompress + 4;
    }
}
