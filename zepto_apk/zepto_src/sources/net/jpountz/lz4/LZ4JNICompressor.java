package net.jpountz.lz4;

import java.nio.ByteBuffer;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.SafeUtils;

/* loaded from: classes3.dex */
final class LZ4JNICompressor extends LZ4Compressor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final LZ4Compressor INSTANCE = new LZ4JNICompressor();
    private static LZ4Compressor SAFE_INSTANCE;

    @Override // net.jpountz.lz4.LZ4Compressor
    public int compress(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        SafeUtils.checkRange(bArr, i2, i3);
        SafeUtils.checkRange(bArr2, i4, i5);
        int iLZ4_compress_limitedOutput = LZ4JNI.LZ4_compress_limitedOutput(bArr, null, i2, i3, bArr2, null, i4, i5);
        if (iLZ4_compress_limitedOutput > 0) {
            return iLZ4_compress_limitedOutput;
        }
        throw new LZ4Exception("maxDestLen is too small");
    }

    @Override // net.jpountz.lz4.LZ4Compressor
    public int compress(ByteBuffer byteBuffer, int i2, int i3, ByteBuffer byteBuffer2, int i4, int i5) {
        byte[] bArrArray;
        ByteBuffer byteBuffer3;
        int iArrayOffset;
        int i6;
        byte[] bArr;
        ByteBufferUtils.checkNotReadOnly(byteBuffer2);
        ByteBufferUtils.checkRange(byteBuffer, i2, i3);
        ByteBufferUtils.checkRange(byteBuffer2, i4, i5);
        if ((!byteBuffer.hasArray() && !byteBuffer.isDirect()) || (!byteBuffer2.hasArray() && !byteBuffer2.isDirect())) {
            LZ4Compressor lZ4CompressorFastCompressor = SAFE_INSTANCE;
            if (lZ4CompressorFastCompressor == null) {
                lZ4CompressorFastCompressor = LZ4Factory.safeInstance().fastCompressor();
                SAFE_INSTANCE = lZ4CompressorFastCompressor;
            }
            return lZ4CompressorFastCompressor.compress(byteBuffer, i2, i3, byteBuffer2, i4, i5);
        }
        ByteBuffer byteBuffer4 = byteBuffer2;
        int i7 = i4;
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
            int iArrayOffset2 = byteBuffer4.arrayOffset() + i7;
            byteBuffer4 = null;
            i7 = iArrayOffset2;
            i6 = i3;
            bArr = bArrArray2;
        } else {
            i6 = i3;
            bArr = null;
        }
        int iLZ4_compress_limitedOutput = LZ4JNI.LZ4_compress_limitedOutput(bArrArray, byteBuffer3, iArrayOffset, i6, bArr, byteBuffer4, i7, i5);
        if (iLZ4_compress_limitedOutput > 0) {
            return iLZ4_compress_limitedOutput;
        }
        throw new LZ4Exception("maxDestLen is too small");
    }
}
