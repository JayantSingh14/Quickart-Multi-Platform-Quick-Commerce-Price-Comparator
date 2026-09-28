package net.jpountz.lz4;

/* loaded from: classes.dex */
final class LZ4JavaUnsafeSafeDecompressor extends LZ4SafeDecompressor {
    public static final LZ4SafeDecompressor INSTANCE = new LZ4JavaUnsafeSafeDecompressor();

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ae, code lost:
    
        if (r12 > r5) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b2, code lost:
    
        if ((r6 + r9) != r1) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b4, code lost:
    
        net.jpountz.lz4.LZ4UnsafeUtils.safeArraycopy(r18, r6, r21, r7, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b8, code lost:
    
        return r12 - r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c2, code lost:
    
        throw new net.jpountz.lz4.LZ4Exception(android.support.v4.media.b.f(r6, "Malformed input at "));
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c8, code lost:
    
        throw new net.jpountz.lz4.LZ4Exception();
     */
    @Override // net.jpountz.lz4.LZ4SafeDecompressor, net.jpountz.lz4.LZ4UnknownSizeDecompressor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int decompress(byte[] r18, int r19, int r20, byte[] r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: net.jpountz.lz4.LZ4JavaUnsafeSafeDecompressor.decompress(byte[], int, int, byte[], int, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00df, code lost:
    
        if (r12 > r6) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e3, code lost:
    
        if ((r0 + r9) != r3) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e5, code lost:
    
        net.jpountz.lz4.LZ4ByteBufferUtils.safeArraycopy(r1, r0, r4, r7, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00e9, code lost:
    
        return r12 - r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00f3, code lost:
    
        throw new net.jpountz.lz4.LZ4Exception(android.support.v4.media.b.f(r0, "Malformed input at "));
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f9, code lost:
    
        throw new net.jpountz.lz4.LZ4Exception();
     */
    @Override // net.jpountz.lz4.LZ4SafeDecompressor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int decompress(java.nio.ByteBuffer r18, int r19, int r20, java.nio.ByteBuffer r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: net.jpountz.lz4.LZ4JavaUnsafeSafeDecompressor.decompress(java.nio.ByteBuffer, int, int, java.nio.ByteBuffer, int, int):int");
    }
}
