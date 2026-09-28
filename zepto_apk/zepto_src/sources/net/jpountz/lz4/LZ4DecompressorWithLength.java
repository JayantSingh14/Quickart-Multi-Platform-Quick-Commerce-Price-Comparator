package net.jpountz.lz4;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class LZ4DecompressorWithLength {
    private final LZ4FastDecompressor fastDecompressor;
    private final LZ4SafeDecompressor safeDecompressor;

    public LZ4DecompressorWithLength(LZ4FastDecompressor lZ4FastDecompressor) {
        this.fastDecompressor = lZ4FastDecompressor;
        this.safeDecompressor = null;
    }

    public static int getDecompressedLength(byte[] bArr) {
        return getDecompressedLength(bArr, 0);
    }

    public int decompress(byte[] bArr, byte[] bArr2) {
        return decompress(bArr, 0, bArr2, 0);
    }

    public static int getDecompressedLength(byte[] bArr, int i2) {
        return (bArr[i2 + 3] << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public int decompress(byte[] bArr, int i2, byte[] bArr2, int i3) {
        if (this.safeDecompressor != null) {
            return decompress(bArr, i2, bArr.length - i2, bArr2, i3);
        }
        return this.fastDecompressor.decompress(bArr, i2 + 4, bArr2, i3, getDecompressedLength(bArr, i2)) + 4;
    }

    public static int getDecompressedLength(ByteBuffer byteBuffer) {
        return getDecompressedLength(byteBuffer, byteBuffer.position());
    }

    public LZ4DecompressorWithLength(LZ4SafeDecompressor lZ4SafeDecompressor) {
        this.fastDecompressor = null;
        this.safeDecompressor = lZ4SafeDecompressor;
    }

    public static int getDecompressedLength(ByteBuffer byteBuffer, int i2) {
        return (byteBuffer.get(i2 + 3) << 24) | (byteBuffer.get(i2) & 255) | ((byteBuffer.get(i2 + 1) & 255) << 8) | ((byteBuffer.get(i2 + 2) & 255) << 16);
    }

    public int decompress(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        if (this.safeDecompressor == null) {
            return decompress(bArr, i2, bArr2, i4);
        }
        return this.safeDecompressor.decompress(bArr, i2 + 4, i3 - 4, bArr2, i4, getDecompressedLength(bArr, i2));
    }

    public byte[] decompress(byte[] bArr) {
        return decompress(bArr, 0);
    }

    public byte[] decompress(byte[] bArr, int i2) {
        if (this.safeDecompressor != null) {
            return decompress(bArr, i2, bArr.length - i2);
        }
        return this.fastDecompressor.decompress(bArr, i2 + 4, getDecompressedLength(bArr, i2));
    }

    public byte[] decompress(byte[] bArr, int i2, int i3) {
        if (this.safeDecompressor == null) {
            return decompress(bArr, i2);
        }
        return this.safeDecompressor.decompress(bArr, i2 + 4, i3 - 4, getDecompressedLength(bArr, i2));
    }

    public void decompress(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int decompressedLength = getDecompressedLength(byteBuffer, byteBuffer.position());
        LZ4SafeDecompressor lZ4SafeDecompressor = this.safeDecompressor;
        if (lZ4SafeDecompressor == null) {
            byteBuffer.position(byteBuffer.position() + 4 + this.fastDecompressor.decompress(byteBuffer, byteBuffer.position() + 4, byteBuffer2, byteBuffer2.position(), decompressedLength));
            byteBuffer2.position(byteBuffer2.position() + decompressedLength);
        } else {
            int iDecompress = lZ4SafeDecompressor.decompress(byteBuffer, byteBuffer.position() + 4, byteBuffer.remaining() - 4, byteBuffer2, byteBuffer2.position(), decompressedLength);
            byteBuffer.position(byteBuffer.limit());
            byteBuffer2.position(byteBuffer2.position() + iDecompress);
        }
    }

    public int decompress(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3) {
        if (this.safeDecompressor != null) {
            return decompress(byteBuffer, i2, byteBuffer.remaining() - i2, byteBuffer2, i3);
        }
        return this.fastDecompressor.decompress(byteBuffer, i2 + 4, byteBuffer2, i3, getDecompressedLength(byteBuffer, i2)) + 4;
    }

    public int decompress(ByteBuffer byteBuffer, int i2, int i3, ByteBuffer byteBuffer2, int i4) {
        if (this.safeDecompressor == null) {
            return decompress(byteBuffer, i2, byteBuffer2, i4);
        }
        return this.safeDecompressor.decompress(byteBuffer, i2 + 4, i3 - 4, byteBuffer2, i4, getDecompressedLength(byteBuffer, i2));
    }
}
