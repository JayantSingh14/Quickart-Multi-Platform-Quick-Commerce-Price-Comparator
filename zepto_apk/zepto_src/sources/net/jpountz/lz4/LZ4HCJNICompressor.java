package net.jpountz.lz4;

import java.nio.ByteBuffer;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.SafeUtils;

/* loaded from: classes3.dex */
final class LZ4HCJNICompressor extends LZ4Compressor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final LZ4HCJNICompressor INSTANCE = new LZ4HCJNICompressor();
    private static LZ4Compressor SAFE_INSTANCE;
    private final int compressionLevel;

    public LZ4HCJNICompressor() {
        this(9);
    }

    @Override // net.jpountz.lz4.LZ4Compressor
    public int compress(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        SafeUtils.checkRange(bArr, i2, i3);
        SafeUtils.checkRange(bArr2, i4, i5);
        int iLZ4_compressHC = LZ4JNI.LZ4_compressHC(bArr, null, i2, i3, bArr2, null, i4, i5, this.compressionLevel);
        if (iLZ4_compressHC > 0) {
            return iLZ4_compressHC;
        }
        throw new LZ4Exception();
    }

    public LZ4HCJNICompressor(int i2) {
        this.compressionLevel = i2;
    }

    @Override // net.jpountz.lz4.LZ4Compressor
    public int compress(ByteBuffer byteBuffer, int i2, int i3, ByteBuffer byteBuffer2, int i4, int i5) {
        byte[] bArrArray;
        ByteBuffer byteBuffer3;
        int iArrayOffset;
        ByteBufferUtils.checkNotReadOnly(byteBuffer2);
        ByteBufferUtils.checkRange(byteBuffer, i2, i3);
        ByteBufferUtils.checkRange(byteBuffer2, i4, i5);
        if ((!byteBuffer.hasArray() && !byteBuffer.isDirect()) || (!byteBuffer2.hasArray() && !byteBuffer2.isDirect())) {
            LZ4Compressor lZ4CompressorHighCompressor = SAFE_INSTANCE;
            if (lZ4CompressorHighCompressor == null) {
                lZ4CompressorHighCompressor = LZ4Factory.safeInstance().highCompressor(this.compressionLevel);
                SAFE_INSTANCE = lZ4CompressorHighCompressor;
            }
            return lZ4CompressorHighCompressor.compress(byteBuffer, i2, i3, byteBuffer2, i4, i5);
        }
        ByteBuffer byteBuffer4 = byteBuffer2;
        int i6 = i4;
        byte[] bArr = null;
        if (byteBuffer.hasArray()) {
            bArrArray = byteBuffer.array();
            byteBuffer3 = null;
            iArrayOffset = byteBuffer.arrayOffset() + i2;
        } else {
            bArrArray = null;
            byteBuffer3 = byteBuffer;
            iArrayOffset = i2;
        }
        if (byteBuffer4.hasArray()) {
            byte[] bArrArray2 = byteBuffer4.array();
            int iArrayOffset2 = byteBuffer4.arrayOffset() + i6;
            byteBuffer4 = null;
            i6 = iArrayOffset2;
            bArr = bArrArray2;
        }
        int iLZ4_compressHC = LZ4JNI.LZ4_compressHC(bArrArray, byteBuffer3, iArrayOffset, i3, bArr, byteBuffer4, i6, i5, this.compressionLevel);
        if (iLZ4_compressHC > 0) {
            return iLZ4_compressHC;
        }
        throw new LZ4Exception();
    }
}
