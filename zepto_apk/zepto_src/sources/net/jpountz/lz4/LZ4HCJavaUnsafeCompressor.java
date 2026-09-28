package net.jpountz.lz4;

import java.nio.ByteBuffer;
import java.util.Arrays;
import net.jpountz.lz4.LZ4Utils;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.UnsafeUtils;

/* loaded from: classes.dex */
final class LZ4HCJavaUnsafeCompressor extends LZ4Compressor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final LZ4Compressor INSTANCE = new LZ4HCJavaUnsafeCompressor();
    final int compressionLevel;
    private final int maxAttempts;

    public LZ4HCJavaUnsafeCompressor() {
        this(9);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0066, code lost:
    
        r18 = r2;
        r17 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01f8, code lost:
    
        r4 = net.jpountz.lz4.LZ4UnsafeUtils.encodeSequence(r21, r0, r13.start, r13.ref, r13.len, r24, r15, r9);
        r0 = r13.end();
        r3 = r0;
        r8 = r14;
        r14 = r16;
     */
    @Override // net.jpountz.lz4.LZ4Compressor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compress(byte[] r21, int r22, int r23, byte[] r24, int r25, int r26) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: net.jpountz.lz4.LZ4HCJavaUnsafeCompressor.compress(byte[], int, int, byte[], int, int):int");
    }

    public class HashTable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final int MASK = 65535;
        private final int base;
        private final short[] chainTable;
        private final int[] hashTable;
        int nextToUpdate;

        public HashTable(int i2) {
            this.base = i2;
            this.nextToUpdate = i2;
            int[] iArr = new int[32768];
            this.hashTable = iArr;
            Arrays.fill(iArr, -1);
            this.chainTable = new short[65536];
        }

        private void addHash(byte[] bArr, int i2) {
            addHash(UnsafeUtils.readInt(bArr, i2), i2);
        }

        private int hashPointer(byte[] bArr, int i2) {
            return hashPointer(UnsafeUtils.readInt(bArr, i2));
        }

        private int next(int i2) {
            return i2 - (this.chainTable[i2 & 65535] & 65535);
        }

        public void insert(int i2, byte[] bArr) {
            while (true) {
                int i3 = this.nextToUpdate;
                if (i3 >= i2) {
                    return;
                }
                addHash(bArr, i3);
                this.nextToUpdate++;
            }
        }

        public boolean insertAndFindBestMatch(byte[] bArr, int i2, int i3, LZ4Utils.Match match) {
            int i4;
            int iCommonBytes;
            int iCommonBytes2;
            match.start = i2;
            match.len = 0;
            insert(i2, bArr);
            int iHashPointer = hashPointer(bArr, i2);
            if (iHashPointer < i2 - 4 || iHashPointer > i2 || iHashPointer < this.base) {
                i4 = 0;
                iCommonBytes = 0;
            } else {
                if (LZ4UnsafeUtils.readIntEquals(bArr, iHashPointer, i2)) {
                    i4 = i2 - iHashPointer;
                    iCommonBytes = LZ4UnsafeUtils.commonBytes(bArr, iHashPointer + 4, i2 + 4, i3) + 4;
                    match.len = iCommonBytes;
                    match.ref = iHashPointer;
                } else {
                    i4 = 0;
                    iCommonBytes = 0;
                }
                iHashPointer = next(iHashPointer);
            }
            for (int i5 = 0; i5 < LZ4HCJavaUnsafeCompressor.this.maxAttempts && iHashPointer >= Math.max(this.base, i2 - 65535) && iHashPointer <= i2; i5++) {
                if (LZ4UnsafeUtils.readIntEquals(bArr, iHashPointer, i2) && (iCommonBytes2 = LZ4UnsafeUtils.commonBytes(bArr, iHashPointer + 4, i2 + 4, i3) + 4) > match.len) {
                    match.ref = iHashPointer;
                    match.len = iCommonBytes2;
                }
                iHashPointer = next(iHashPointer);
            }
            if (iCommonBytes != 0) {
                int i6 = (iCommonBytes + i2) - 3;
                while (i2 < i6 - i4) {
                    this.chainTable[i2 & 65535] = (short) i4;
                    i2++;
                }
                do {
                    this.chainTable[i2 & 65535] = (short) i4;
                    this.hashTable[LZ4Utils.hashHC(UnsafeUtils.readInt(bArr, i2))] = i2;
                    i2++;
                } while (i2 < i6);
                this.nextToUpdate = i6;
            }
            return match.len != 0;
        }

        public boolean insertAndFindWiderMatch(byte[] bArr, int i2, int i3, int i4, int i5, LZ4Utils.Match match) {
            match.len = i5;
            insert(i2, bArr);
            int iHashPointer = hashPointer(bArr, i2);
            for (int i6 = 0; i6 < LZ4HCJavaUnsafeCompressor.this.maxAttempts && iHashPointer >= Math.max(this.base, i2 - 65535) && iHashPointer <= i2; i6++) {
                if (LZ4UnsafeUtils.readIntEquals(bArr, iHashPointer, i2)) {
                    int iCommonBytes = LZ4UnsafeUtils.commonBytes(bArr, iHashPointer + 4, i2 + 4, i4) + 4;
                    int iCommonBytesBackward = LZ4UnsafeUtils.commonBytesBackward(bArr, iHashPointer, i2, this.base, i3);
                    int i7 = iCommonBytes + iCommonBytesBackward;
                    if (i7 > match.len) {
                        match.len = i7;
                        match.ref = iHashPointer - iCommonBytesBackward;
                        match.start = i2 - iCommonBytesBackward;
                    }
                }
                iHashPointer = next(iHashPointer);
            }
            return match.len > i5;
        }

        private void addHash(ByteBuffer byteBuffer, int i2) {
            addHash(ByteBufferUtils.readInt(byteBuffer, i2), i2);
        }

        private int hashPointer(ByteBuffer byteBuffer, int i2) {
            return hashPointer(ByteBufferUtils.readInt(byteBuffer, i2));
        }

        public void insert(int i2, ByteBuffer byteBuffer) {
            while (true) {
                int i3 = this.nextToUpdate;
                if (i3 >= i2) {
                    return;
                }
                addHash(byteBuffer, i3);
                this.nextToUpdate++;
            }
        }

        private void addHash(int i2, int i3) {
            int iHashHC = LZ4Utils.hashHC(i2);
            int[] iArr = this.hashTable;
            int i4 = i3 - iArr[iHashHC];
            if (i4 >= 65536) {
                i4 = 65535;
            }
            this.chainTable[65535 & i3] = (short) i4;
            iArr[iHashHC] = i3;
        }

        private int hashPointer(int i2) {
            return this.hashTable[LZ4Utils.hashHC(i2)];
        }

        public boolean insertAndFindWiderMatch(ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, LZ4Utils.Match match) {
            match.len = i5;
            insert(i2, byteBuffer);
            int iHashPointer = hashPointer(byteBuffer, i2);
            for (int i6 = 0; i6 < LZ4HCJavaUnsafeCompressor.this.maxAttempts && iHashPointer >= Math.max(this.base, i2 - 65535) && iHashPointer <= i2; i6++) {
                if (LZ4ByteBufferUtils.readIntEquals(byteBuffer, iHashPointer, i2)) {
                    int iCommonBytes = LZ4ByteBufferUtils.commonBytes(byteBuffer, iHashPointer + 4, i2 + 4, i4) + 4;
                    int iCommonBytesBackward = LZ4ByteBufferUtils.commonBytesBackward(byteBuffer, iHashPointer, i2, this.base, i3);
                    int i7 = iCommonBytes + iCommonBytesBackward;
                    if (i7 > match.len) {
                        match.len = i7;
                        match.ref = iHashPointer - iCommonBytesBackward;
                        match.start = i2 - iCommonBytesBackward;
                    }
                }
                iHashPointer = next(iHashPointer);
            }
            return match.len > i5;
        }

        public boolean insertAndFindBestMatch(ByteBuffer byteBuffer, int i2, int i3, LZ4Utils.Match match) {
            int i4;
            int iCommonBytes;
            int iCommonBytes2;
            match.start = i2;
            match.len = 0;
            insert(i2, byteBuffer);
            int iHashPointer = hashPointer(byteBuffer, i2);
            if (iHashPointer < i2 - 4 || iHashPointer > i2 || iHashPointer < this.base) {
                i4 = 0;
                iCommonBytes = 0;
            } else {
                if (LZ4ByteBufferUtils.readIntEquals(byteBuffer, iHashPointer, i2)) {
                    i4 = i2 - iHashPointer;
                    iCommonBytes = LZ4ByteBufferUtils.commonBytes(byteBuffer, iHashPointer + 4, i2 + 4, i3) + 4;
                    match.len = iCommonBytes;
                    match.ref = iHashPointer;
                } else {
                    i4 = 0;
                    iCommonBytes = 0;
                }
                iHashPointer = next(iHashPointer);
            }
            for (int i5 = 0; i5 < LZ4HCJavaUnsafeCompressor.this.maxAttempts && iHashPointer >= Math.max(this.base, i2 - 65535) && iHashPointer <= i2; i5++) {
                if (LZ4ByteBufferUtils.readIntEquals(byteBuffer, iHashPointer, i2) && (iCommonBytes2 = LZ4ByteBufferUtils.commonBytes(byteBuffer, iHashPointer + 4, i2 + 4, i3) + 4) > match.len) {
                    match.ref = iHashPointer;
                    match.len = iCommonBytes2;
                }
                iHashPointer = next(iHashPointer);
            }
            if (iCommonBytes != 0) {
                int i6 = (iCommonBytes + i2) - 3;
                while (i2 < i6 - i4) {
                    this.chainTable[i2 & 65535] = (short) i4;
                    i2++;
                }
                do {
                    this.chainTable[i2 & 65535] = (short) i4;
                    this.hashTable[LZ4Utils.hashHC(ByteBufferUtils.readInt(byteBuffer, i2))] = i2;
                    i2++;
                } while (i2 < i6);
                this.nextToUpdate = i6;
            }
            return match.len != 0;
        }
    }

    public LZ4HCJavaUnsafeCompressor(int i2) {
        this.maxAttempts = 1 << (i2 - 1);
        this.compressionLevel = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x009a, code lost:
    
        r8 = r1;
        r18 = r7;
        r1 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0241, code lost:
    
        r6 = net.jpountz.lz4.LZ4ByteBufferUtils.encodeSequence(r3, r4, r15.start, r15.ref, r15.len, r8, r17, r10);
        r5 = r15.end();
     */
    @Override // net.jpountz.lz4.LZ4Compressor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compress(java.nio.ByteBuffer r21, int r22, int r23, java.nio.ByteBuffer r24, int r25, int r26) {
        /*
            Method dump skipped, instructions count: 609
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: net.jpountz.lz4.LZ4HCJavaUnsafeCompressor.compress(java.nio.ByteBuffer, int, int, java.nio.ByteBuffer, int, int):int");
    }
}
