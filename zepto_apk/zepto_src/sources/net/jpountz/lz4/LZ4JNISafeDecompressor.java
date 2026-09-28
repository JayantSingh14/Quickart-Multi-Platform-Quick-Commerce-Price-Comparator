package net.jpountz.lz4;

import java.nio.ByteBuffer;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.SafeUtils;

/* loaded from: classes3.dex */
final class LZ4JNISafeDecompressor extends LZ4SafeDecompressor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final LZ4JNISafeDecompressor INSTANCE = new LZ4JNISafeDecompressor();
    private static LZ4SafeDecompressor SAFE_INSTANCE;

    @Override // net.jpountz.lz4.LZ4SafeDecompressor, net.jpountz.lz4.LZ4UnknownSizeDecompressor
    public final int decompress(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        SafeUtils.checkRange(bArr, i2, i3);
        SafeUtils.checkRange(bArr2, i4, i5);
        int iLZ4_decompress_safe = LZ4JNI.LZ4_decompress_safe(bArr, null, i2, i3, bArr2, null, i4, i5);
        if (iLZ4_decompress_safe >= 0) {
            return iLZ4_decompress_safe;
        }
        throw new LZ4Exception("Error decoding offset " + (i2 - iLZ4_decompress_safe) + " of input buffer");
    }

    @Override // net.jpountz.lz4.LZ4SafeDecompressor
    public int decompress(ByteBuffer byteBuffer, int i2, int i3, ByteBuffer byteBuffer2, int i4, int i5) {
        byte[] bArrArray;
        ByteBuffer byteBuffer3;
        int iArrayOffset;
        int i6;
        byte[] bArr;
        ByteBufferUtils.checkNotReadOnly(byteBuffer2);
        ByteBufferUtils.checkRange(byteBuffer, i2, i3);
        ByteBufferUtils.checkRange(byteBuffer2, i4, i5);
        if ((!byteBuffer.hasArray() && !byteBuffer.isDirect()) || (!byteBuffer2.hasArray() && !byteBuffer2.isDirect())) {
            LZ4SafeDecompressor lZ4SafeDecompressorSafeDecompressor = SAFE_INSTANCE;
            if (lZ4SafeDecompressorSafeDecompressor == null) {
                lZ4SafeDecompressorSafeDecompressor = LZ4Factory.safeInstance().safeDecompressor();
                SAFE_INSTANCE = lZ4SafeDecompressorSafeDecompressor;
            }
            return lZ4SafeDecompressorSafeDecompressor.decompress(byteBuffer, i2, i3, byteBuffer2, i4, i5);
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
        int iLZ4_decompress_safe = LZ4JNI.LZ4_decompress_safe(bArrArray, byteBuffer3, iArrayOffset, i6, bArr, byteBuffer4, i7, i5);
        if (iLZ4_decompress_safe >= 0) {
            return iLZ4_decompress_safe;
        }
        throw new LZ4Exception("Error decoding offset " + (iArrayOffset - iLZ4_decompress_safe) + " of input buffer");
    }
}
