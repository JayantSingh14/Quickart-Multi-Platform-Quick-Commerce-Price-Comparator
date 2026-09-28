package net.jpountz.lz4;

import java.nio.ByteBuffer;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.SafeUtils;

/* loaded from: classes3.dex */
final class LZ4JNIFastDecompressor extends LZ4FastDecompressor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final LZ4JNIFastDecompressor INSTANCE = new LZ4JNIFastDecompressor();
    private static LZ4FastDecompressor SAFE_INSTANCE;

    @Override // net.jpountz.lz4.LZ4FastDecompressor, net.jpountz.lz4.LZ4Decompressor
    public final int decompress(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        SafeUtils.checkRange(bArr, i2);
        SafeUtils.checkRange(bArr2, i3, i4);
        int iLZ4_decompress_fast = LZ4JNI.LZ4_decompress_fast(bArr, null, i2, bArr2, null, i3, i4);
        if (iLZ4_decompress_fast >= 0) {
            return iLZ4_decompress_fast;
        }
        throw new LZ4Exception("Error decoding offset " + (i2 - iLZ4_decompress_fast) + " of input buffer");
    }

    @Override // net.jpountz.lz4.LZ4FastDecompressor
    public int decompress(ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, int i4) {
        byte[] bArrArray;
        ByteBuffer byteBuffer3;
        int iArrayOffset;
        byte[] bArr;
        ByteBufferUtils.checkNotReadOnly(byteBuffer2);
        ByteBufferUtils.checkRange(byteBuffer, i2);
        ByteBufferUtils.checkRange(byteBuffer2, i3, i4);
        if ((!byteBuffer.hasArray() && !byteBuffer.isDirect()) || (!byteBuffer2.hasArray() && !byteBuffer2.isDirect())) {
            LZ4FastDecompressor lZ4FastDecompressorFastDecompressor = SAFE_INSTANCE;
            if (lZ4FastDecompressorFastDecompressor == null) {
                lZ4FastDecompressorFastDecompressor = LZ4Factory.safeInstance().fastDecompressor();
                SAFE_INSTANCE = lZ4FastDecompressorFastDecompressor;
            }
            return lZ4FastDecompressorFastDecompressor.decompress(byteBuffer, i2, byteBuffer2, i3, i4);
        }
        ByteBuffer byteBuffer4 = byteBuffer2;
        int i5 = i3;
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
            int iArrayOffset2 = byteBuffer4.arrayOffset() + i5;
            bArr = bArrArray2;
            byteBuffer4 = null;
            i5 = iArrayOffset2;
        } else {
            bArr = null;
        }
        int iLZ4_decompress_fast = LZ4JNI.LZ4_decompress_fast(bArrArray, byteBuffer3, iArrayOffset, bArr, byteBuffer4, i5, i4);
        if (iLZ4_decompress_fast >= 0) {
            return iLZ4_decompress_fast;
        }
        throw new LZ4Exception("Error decoding offset " + (iArrayOffset - iLZ4_decompress_fast) + " of input buffer");
    }
}
