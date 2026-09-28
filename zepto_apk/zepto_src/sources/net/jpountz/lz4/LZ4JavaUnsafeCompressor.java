package net.jpountz.lz4;

/* loaded from: classes.dex */
final class LZ4JavaUnsafeCompressor extends LZ4Compressor {
    public static final LZ4Compressor INSTANCE = new LZ4JavaUnsafeCompressor();

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004a, code lost:
    
        r4 = net.jpountz.lz4.LZ4UnsafeUtils.commonBytesBackward(r17, r15, r8, r1, r9);
        r8 = r8 - r4;
        r15 = r15 - r4;
        r4 = r8 - r9;
        r11 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005d, code lost:
    
        if ((((r11 + r4) + 8) + (r4 >>> 8)) > r22) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0061, code lost:
    
        if (r4 < 15) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0063, code lost:
    
        net.jpountz.util.UnsafeUtils.writeByte(r20, r10, 240);
        r11 = net.jpountz.lz4.LZ4UnsafeUtils.writeLen(r4 - 15, r20, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006f, code lost:
    
        net.jpountz.util.UnsafeUtils.writeByte(r20, r10, r4 << 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
    
        net.jpountz.lz4.LZ4UnsafeUtils.wildArraycopy(r17, r9, r20, r11, r4);
        r11 = r11 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0078, code lost:
    
        net.jpountz.util.UnsafeUtils.writeShortLE(r20, r11, (short) (r8 - r15));
        r4 = r11 + 2;
        r8 = r8 + 4;
        r9 = net.jpountz.lz4.LZ4UnsafeUtils.commonBytes(r17, r15 + 4, r8, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008d, code lost:
    
        if (((r11 + 8) + (r9 >>> 8)) > r22) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008f, code lost:
    
        r8 = r8 + r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0090, code lost:
    
        if (r9 < 15) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0092, code lost:
    
        net.jpountz.util.UnsafeUtils.writeByte(r20, r10, net.jpountz.util.UnsafeUtils.readByte(r20, r10) | 15);
        r4 = net.jpountz.lz4.LZ4UnsafeUtils.writeLen(r9 - 15, r20, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a0, code lost:
    
        r10 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a2, code lost:
    
        net.jpountz.util.UnsafeUtils.writeByte(r20, r10, r9 | net.jpountz.util.UnsafeUtils.readByte(r20, r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ab, code lost:
    
        if (r8 <= r7) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ad, code lost:
    
        r1 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b0, code lost:
    
        r4 = r8 - 2;
        net.jpountz.util.UnsafeUtils.writeShort(r2, net.jpountz.lz4.LZ4Utils.hash64k(net.jpountz.util.UnsafeUtils.readInt(r17, r4)), r4 - r1);
        r4 = net.jpountz.lz4.LZ4Utils.hash64k(net.jpountz.util.UnsafeUtils.readInt(r17, r8));
        r15 = net.jpountz.util.UnsafeUtils.readShort(r2, r4) + r1;
        net.jpountz.util.UnsafeUtils.writeShort(r2, r4, r8 - r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d5, code lost:
    
        if (net.jpountz.lz4.LZ4UnsafeUtils.readIntEquals(r17, r8, r15) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00df, code lost:
    
        r11 = r10 + 1;
        net.jpountz.util.UnsafeUtils.writeByte(r20, r10, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00eb, code lost:
    
        throw new net.jpountz.lz4.LZ4Exception("maxDestLen is too small");
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f1, code lost:
    
        throw new net.jpountz.lz4.LZ4Exception("maxDestLen is too small");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int compress64k(byte[] r17, int r18, int r19, byte[] r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: net.jpountz.lz4.LZ4JavaUnsafeCompressor.compress64k(byte[], int, int, byte[], int, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0065, code lost:
    
        r11 = net.jpountz.lz4.LZ4UnsafeUtils.commonBytesBackward(r18, r15, r9, r19, r7);
        r9 = r9 - r11;
        r15 = r15 - r11;
        r11 = r9 - r7;
        r12 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0079, code lost:
    
        if ((((r12 + r11) + 8) + (r11 >>> 8)) > r5) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007d, code lost:
    
        if (r11 < 15) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007f, code lost:
    
        net.jpountz.util.UnsafeUtils.writeByte(r21, r10, 240);
        r12 = net.jpountz.lz4.LZ4UnsafeUtils.writeLen(r11 - 15, r21, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008b, code lost:
    
        net.jpountz.util.UnsafeUtils.writeByte(r21, r10, r11 << 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0090, code lost:
    
        net.jpountz.lz4.LZ4UnsafeUtils.wildArraycopy(r18, r7, r21, r12, r11);
        r12 = r12 + r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0094, code lost:
    
        net.jpountz.util.UnsafeUtils.writeShortLE(r21, r12, r2);
        r2 = r12 + 2;
        r9 = r9 + 4;
        r7 = net.jpountz.lz4.LZ4UnsafeUtils.commonBytes(r18, r15 + 4, r9, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a6, code lost:
    
        if (((r12 + 8) + (r7 >>> 8)) > r5) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a8, code lost:
    
        r9 = r9 + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ab, code lost:
    
        if (r7 < 15) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ad, code lost:
    
        net.jpountz.util.UnsafeUtils.writeByte(r21, r10, net.jpountz.util.UnsafeUtils.readByte(r21, r10) | 15);
        r2 = net.jpountz.lz4.LZ4UnsafeUtils.writeLen(r7 - 15, r21, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bb, code lost:
    
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bd, code lost:
    
        net.jpountz.util.UnsafeUtils.writeByte(r21, r10, r7 | net.jpountz.util.UnsafeUtils.readByte(r21, r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c6, code lost:
    
        if (r9 <= r6) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c8, code lost:
    
        r1 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d4, code lost:
    
        r2 = r9 - 2;
        net.jpountz.util.UnsafeUtils.writeInt(r8, net.jpountz.lz4.LZ4Utils.hash(net.jpountz.util.UnsafeUtils.readInt(r18, r2)), r2);
        r2 = net.jpountz.lz4.LZ4Utils.hash(net.jpountz.util.UnsafeUtils.readInt(r18, r9));
        r15 = net.jpountz.util.UnsafeUtils.readInt(r8, r2);
        net.jpountz.util.UnsafeUtils.writeInt(r8, r2, r9);
        r2 = r9 - r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f4, code lost:
    
        if (r2 >= 65536) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fa, code lost:
    
        if (net.jpountz.lz4.LZ4UnsafeUtils.readIntEquals(r18, r15, r9) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00fd, code lost:
    
        r12 = r10 + 1;
        net.jpountz.util.UnsafeUtils.writeByte(r21, r10, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0111, code lost:
    
        throw new net.jpountz.lz4.LZ4Exception("maxDestLen is too small");
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0117, code lost:
    
        throw new net.jpountz.lz4.LZ4Exception("maxDestLen is too small");
     */
    @Override // net.jpountz.lz4.LZ4Compressor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compress(byte[] r18, int r19, int r20, byte[] r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: net.jpountz.lz4.LZ4JavaUnsafeCompressor.compress(byte[], int, int, byte[], int, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004a, code lost:
    
        r4 = net.jpountz.lz4.LZ4ByteBufferUtils.commonBytesBackward(r17, r15, r8, r1, r9);
        r8 = r8 - r4;
        r15 = r15 - r4;
        r4 = r8 - r9;
        r11 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005d, code lost:
    
        if ((((r11 + r4) + 8) + (r4 >>> 8)) > r22) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0061, code lost:
    
        if (r4 < 15) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0063, code lost:
    
        net.jpountz.util.ByteBufferUtils.writeByte(r20, r10, 240);
        r11 = net.jpountz.lz4.LZ4ByteBufferUtils.writeLen(r4 - 15, r20, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006f, code lost:
    
        net.jpountz.util.ByteBufferUtils.writeByte(r20, r10, r4 << 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
    
        net.jpountz.lz4.LZ4ByteBufferUtils.wildArraycopy(r17, r9, r20, r11, r4);
        r11 = r11 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0078, code lost:
    
        net.jpountz.util.ByteBufferUtils.writeShortLE(r20, r11, (short) (r8 - r15));
        r4 = r11 + 2;
        r8 = r8 + 4;
        r9 = net.jpountz.lz4.LZ4ByteBufferUtils.commonBytes(r17, r15 + 4, r8, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008d, code lost:
    
        if (((r11 + 8) + (r9 >>> 8)) > r22) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008f, code lost:
    
        r8 = r8 + r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0090, code lost:
    
        if (r9 < 15) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0092, code lost:
    
        net.jpountz.util.ByteBufferUtils.writeByte(r20, r10, net.jpountz.util.ByteBufferUtils.readByte(r20, r10) | 15);
        r4 = net.jpountz.lz4.LZ4ByteBufferUtils.writeLen(r9 - 15, r20, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a0, code lost:
    
        r10 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a2, code lost:
    
        net.jpountz.util.ByteBufferUtils.writeByte(r20, r10, r9 | net.jpountz.util.ByteBufferUtils.readByte(r20, r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ab, code lost:
    
        if (r8 <= r7) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ad, code lost:
    
        r1 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b0, code lost:
    
        r4 = r8 - 2;
        net.jpountz.util.UnsafeUtils.writeShort(r2, net.jpountz.lz4.LZ4Utils.hash64k(net.jpountz.util.ByteBufferUtils.readInt(r17, r4)), r4 - r1);
        r4 = net.jpountz.lz4.LZ4Utils.hash64k(net.jpountz.util.ByteBufferUtils.readInt(r17, r8));
        r15 = net.jpountz.util.UnsafeUtils.readShort(r2, r4) + r1;
        net.jpountz.util.UnsafeUtils.writeShort(r2, r4, r8 - r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d5, code lost:
    
        if (net.jpountz.lz4.LZ4ByteBufferUtils.readIntEquals(r17, r8, r15) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00df, code lost:
    
        r11 = r10 + 1;
        net.jpountz.util.ByteBufferUtils.writeByte(r20, r10, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00eb, code lost:
    
        throw new net.jpountz.lz4.LZ4Exception("maxDestLen is too small");
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f1, code lost:
    
        throw new net.jpountz.lz4.LZ4Exception("maxDestLen is too small");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int compress64k(java.nio.ByteBuffer r17, int r18, int r19, java.nio.ByteBuffer r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: net.jpountz.lz4.LZ4JavaUnsafeCompressor.compress64k(java.nio.ByteBuffer, int, int, java.nio.ByteBuffer, int, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a1, code lost:
    
        r11 = net.jpountz.lz4.LZ4ByteBufferUtils.commonBytesBackward(r1, r15, r10, r20, r7);
        r10 = r10 - r11;
        r15 = r15 - r11;
        r11 = r10 - r7;
        r12 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b5, code lost:
    
        if ((((r12 + r11) + 8) + (r11 >>> 8)) > r5) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b9, code lost:
    
        if (r11 < 15) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00bb, code lost:
    
        net.jpountz.util.ByteBufferUtils.writeByte(r4, r9, 240);
        r12 = net.jpountz.lz4.LZ4ByteBufferUtils.writeLen(r11 - 15, r4, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c7, code lost:
    
        net.jpountz.util.ByteBufferUtils.writeByte(r4, r9, r11 << 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00cc, code lost:
    
        net.jpountz.lz4.LZ4ByteBufferUtils.wildArraycopy(r1, r7, r4, r12, r11);
        r12 = r12 + r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d0, code lost:
    
        net.jpountz.util.ByteBufferUtils.writeShortLE(r4, r12, r2);
        r2 = r12 + 2;
        r10 = r10 + 4;
        r7 = net.jpountz.lz4.LZ4ByteBufferUtils.commonBytes(r1, r15 + 4, r10, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00e2, code lost:
    
        if (((r12 + 8) + (r7 >>> 8)) > r5) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e4, code lost:
    
        r10 = r10 + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e7, code lost:
    
        if (r7 < 15) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e9, code lost:
    
        net.jpountz.util.ByteBufferUtils.writeByte(r4, r9, net.jpountz.util.ByteBufferUtils.readByte(r4, r9) | 15);
        r2 = net.jpountz.lz4.LZ4ByteBufferUtils.writeLen(r7 - 15, r4, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00f7, code lost:
    
        r9 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f9, code lost:
    
        net.jpountz.util.ByteBufferUtils.writeByte(r4, r9, r7 | net.jpountz.util.ByteBufferUtils.readByte(r4, r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0102, code lost:
    
        if (r10 <= r6) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0104, code lost:
    
        r1 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0110, code lost:
    
        r2 = r10 - 2;
        net.jpountz.util.UnsafeUtils.writeInt(r8, net.jpountz.lz4.LZ4Utils.hash(net.jpountz.util.ByteBufferUtils.readInt(r1, r2)), r2);
        r2 = net.jpountz.lz4.LZ4Utils.hash(net.jpountz.util.ByteBufferUtils.readInt(r1, r10));
        r15 = net.jpountz.util.UnsafeUtils.readInt(r8, r2);
        net.jpountz.util.UnsafeUtils.writeInt(r8, r2, r10);
        r2 = r10 - r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0130, code lost:
    
        if (r2 >= 65536) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0136, code lost:
    
        if (net.jpountz.lz4.LZ4ByteBufferUtils.readIntEquals(r1, r15, r10) != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0139, code lost:
    
        r12 = r9 + 1;
        net.jpountz.util.ByteBufferUtils.writeByte(r4, r9, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x014d, code lost:
    
        throw new net.jpountz.lz4.LZ4Exception("maxDestLen is too small");
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0153, code lost:
    
        throw new net.jpountz.lz4.LZ4Exception("maxDestLen is too small");
     */
    @Override // net.jpountz.lz4.LZ4Compressor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compress(java.nio.ByteBuffer r19, int r20, int r21, java.nio.ByteBuffer r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: net.jpountz.lz4.LZ4JavaUnsafeCompressor.compress(java.nio.ByteBuffer, int, int, java.nio.ByteBuffer, int, int):int");
    }
}
