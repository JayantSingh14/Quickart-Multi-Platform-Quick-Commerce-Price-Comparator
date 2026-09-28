package org.apache.commons.codec.binary;

import android.support.v4.media.b;
import org.apache.commons.codec.binary.BaseNCodec;
import org.xbill.DNS.Flags;

/* loaded from: classes5.dex */
public class Base32 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 5;
    private static final int BYTES_PER_ENCODED_BLOCK = 8;
    private static final int BYTES_PER_UNENCODED_BLOCK = 5;
    private static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Flags.CD, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Flags.CD, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    private static final byte[] ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
    private static final byte[] HEX_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, Flags.CD, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, Flags.CD, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    private static final byte[] HEX_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86};
    private static final long MASK_1BITS = 1;
    private static final long MASK_2BITS = 3;
    private static final long MASK_3BITS = 7;
    private static final long MASK_4BITS = 15;
    private static final int MASK_5BITS = 31;
    private static final long MASK_6BITS = 63;
    private static final long MASK_7BITS = 127;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    public Base32() {
        this(false);
    }

    private static void validateCharacter(long j2, BaseNCodec.Context context) {
        if ((j2 & context.lbitWorkArea) != 0) {
            throw new IllegalArgumentException("Last encoded character (before the paddings if any) is a valid base 32 alphabet but not a possible value. Expected the discarded bits to be zero.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0092  */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v25 */
    @Override // org.apache.commons.codec.binary.BaseNCodec
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void decode(byte[] r23, int r24, int r25, org.apache.commons.codec.binary.BaseNCodec.Context r26) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.binary.Base32.decode(byte[], int, int, org.apache.commons.codec.binary.BaseNCodec$Context):void");
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void encode(byte[] bArr, int i2, int i3, BaseNCodec.Context context) {
        int i4;
        if (context.eof) {
            return;
        }
        int i5 = 1;
        if (i3 >= 0) {
            int i6 = i2;
            int i7 = 0;
            while (i7 < i3) {
                byte[] bArrEnsureBufferSize = ensureBufferSize(this.encodeSize, context);
                int i8 = (context.modulus + i5) % 5;
                context.modulus = i8;
                int i9 = i6 + 1;
                int i10 = bArr[i6];
                if (i10 < 0) {
                    i10 += 256;
                }
                long j2 = (context.lbitWorkArea << 8) + i10;
                context.lbitWorkArea = j2;
                if (i8 == 0) {
                    int i11 = context.pos;
                    int i12 = i11 + 1;
                    context.pos = i12;
                    byte[] bArr2 = this.encodeTable;
                    bArrEnsureBufferSize[i11] = bArr2[((int) (j2 >> 35)) & 31];
                    int i13 = i11 + 2;
                    context.pos = i13;
                    i4 = i9;
                    bArrEnsureBufferSize[i12] = bArr2[((int) (j2 >> 30)) & 31];
                    int i14 = i11 + 3;
                    context.pos = i14;
                    bArrEnsureBufferSize[i13] = bArr2[((int) (j2 >> 25)) & 31];
                    int i15 = i11 + 4;
                    context.pos = i15;
                    bArrEnsureBufferSize[i14] = bArr2[((int) (j2 >> 20)) & 31];
                    int i16 = i11 + 5;
                    context.pos = i16;
                    bArrEnsureBufferSize[i15] = bArr2[((int) (j2 >> MASK_4BITS)) & 31];
                    int i17 = i11 + 6;
                    context.pos = i17;
                    bArrEnsureBufferSize[i16] = bArr2[((int) (j2 >> 10)) & 31];
                    int i18 = i11 + 7;
                    context.pos = i18;
                    bArrEnsureBufferSize[i17] = bArr2[((int) (j2 >> 5)) & 31];
                    int i19 = i11 + 8;
                    context.pos = i19;
                    bArrEnsureBufferSize[i18] = bArr2[((int) j2) & 31];
                    int i20 = context.currentLinePos + 8;
                    context.currentLinePos = i20;
                    int i21 = this.lineLength;
                    if (i21 > 0 && i21 <= i20) {
                        byte[] bArr3 = this.lineSeparator;
                        System.arraycopy(bArr3, 0, bArrEnsureBufferSize, i19, bArr3.length);
                        context.pos += this.lineSeparator.length;
                        context.currentLinePos = 0;
                    }
                } else {
                    i4 = i9;
                }
                i7++;
                i6 = i4;
                i5 = 1;
            }
            return;
        }
        context.eof = true;
        if (context.modulus == 0 && this.lineLength == 0) {
            return;
        }
        byte[] bArrEnsureBufferSize2 = ensureBufferSize(this.encodeSize, context);
        int i22 = context.pos;
        int i23 = context.modulus;
        if (i23 != 0) {
            if (i23 == 1) {
                int i24 = i22 + 1;
                context.pos = i24;
                byte[] bArr4 = this.encodeTable;
                long j3 = context.lbitWorkArea;
                bArrEnsureBufferSize2[i22] = bArr4[((int) (j3 >> MASK_2BITS)) & 31];
                int i25 = i22 + 2;
                context.pos = i25;
                bArrEnsureBufferSize2[i24] = bArr4[((int) (j3 << 2)) & 31];
                int i26 = i22 + 3;
                context.pos = i26;
                byte b2 = this.pad;
                bArrEnsureBufferSize2[i25] = b2;
                int i27 = i22 + 4;
                context.pos = i27;
                bArrEnsureBufferSize2[i26] = b2;
                int i28 = i22 + 5;
                context.pos = i28;
                bArrEnsureBufferSize2[i27] = b2;
                int i29 = i22 + 6;
                context.pos = i29;
                bArrEnsureBufferSize2[i28] = b2;
                int i30 = i22 + 7;
                context.pos = i30;
                bArrEnsureBufferSize2[i29] = b2;
                context.pos = i22 + 8;
                bArrEnsureBufferSize2[i30] = b2;
            } else if (i23 == 2) {
                int i31 = i22 + 1;
                context.pos = i31;
                byte[] bArr5 = this.encodeTable;
                long j4 = context.lbitWorkArea;
                bArrEnsureBufferSize2[i22] = bArr5[((int) (j4 >> 11)) & 31];
                int i32 = i22 + 2;
                context.pos = i32;
                bArrEnsureBufferSize2[i31] = bArr5[((int) (j4 >> 6)) & 31];
                int i33 = i22 + 3;
                context.pos = i33;
                bArrEnsureBufferSize2[i32] = bArr5[((int) (j4 >> MASK_1BITS)) & 31];
                int i34 = i22 + 4;
                context.pos = i34;
                bArrEnsureBufferSize2[i33] = bArr5[((int) (j4 << 4)) & 31];
                int i35 = i22 + 5;
                context.pos = i35;
                byte b3 = this.pad;
                bArrEnsureBufferSize2[i34] = b3;
                int i36 = i22 + 6;
                context.pos = i36;
                bArrEnsureBufferSize2[i35] = b3;
                int i37 = i22 + 7;
                context.pos = i37;
                bArrEnsureBufferSize2[i36] = b3;
                context.pos = i22 + 8;
                bArrEnsureBufferSize2[i37] = b3;
            } else if (i23 == 3) {
                int i38 = i22 + 1;
                context.pos = i38;
                byte[] bArr6 = this.encodeTable;
                long j5 = context.lbitWorkArea;
                bArrEnsureBufferSize2[i22] = bArr6[((int) (j5 >> 19)) & 31];
                int i39 = i22 + 2;
                context.pos = i39;
                bArrEnsureBufferSize2[i38] = bArr6[((int) (j5 >> 14)) & 31];
                int i40 = i22 + 3;
                context.pos = i40;
                bArrEnsureBufferSize2[i39] = bArr6[((int) (j5 >> 9)) & 31];
                int i41 = i22 + 4;
                context.pos = i41;
                bArrEnsureBufferSize2[i40] = bArr6[((int) (j5 >> 4)) & 31];
                int i42 = i22 + 5;
                context.pos = i42;
                bArrEnsureBufferSize2[i41] = bArr6[((int) (j5 << MASK_1BITS)) & 31];
                int i43 = i22 + 6;
                context.pos = i43;
                byte b4 = this.pad;
                bArrEnsureBufferSize2[i42] = b4;
                int i44 = i22 + 7;
                context.pos = i44;
                bArrEnsureBufferSize2[i43] = b4;
                context.pos = i22 + 8;
                bArrEnsureBufferSize2[i44] = b4;
            } else {
                if (i23 != 4) {
                    throw new IllegalStateException("Impossible modulus " + context.modulus);
                }
                int i45 = i22 + 1;
                context.pos = i45;
                byte[] bArr7 = this.encodeTable;
                long j6 = context.lbitWorkArea;
                bArrEnsureBufferSize2[i22] = bArr7[((int) (j6 >> 27)) & 31];
                int i46 = i22 + 2;
                context.pos = i46;
                bArrEnsureBufferSize2[i45] = bArr7[((int) (j6 >> 22)) & 31];
                int i47 = i22 + 3;
                context.pos = i47;
                bArrEnsureBufferSize2[i46] = bArr7[((int) (j6 >> 17)) & 31];
                int i48 = i22 + 4;
                context.pos = i48;
                bArrEnsureBufferSize2[i47] = bArr7[((int) (j6 >> 12)) & 31];
                int i49 = i22 + 5;
                context.pos = i49;
                bArrEnsureBufferSize2[i48] = bArr7[((int) (j6 >> MASK_3BITS)) & 31];
                int i50 = i22 + 6;
                context.pos = i50;
                bArrEnsureBufferSize2[i49] = bArr7[((int) (j6 >> 2)) & 31];
                int i51 = i22 + 7;
                context.pos = i51;
                bArrEnsureBufferSize2[i50] = bArr7[((int) (j6 << MASK_2BITS)) & 31];
                context.pos = i22 + 8;
                bArrEnsureBufferSize2[i51] = this.pad;
            }
        }
        int i52 = context.currentLinePos;
        int i53 = context.pos;
        int i54 = (i53 - i22) + i52;
        context.currentLinePos = i54;
        if (this.lineLength <= 0 || i54 <= 0) {
            return;
        }
        byte[] bArr8 = this.lineSeparator;
        System.arraycopy(bArr8, 0, bArrEnsureBufferSize2, i53, bArr8.length);
        context.pos += this.lineSeparator.length;
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public boolean isInAlphabet(byte b2) {
        if (b2 < 0) {
            return false;
        }
        byte[] bArr = this.decodeTable;
        return b2 < bArr.length && bArr[b2] != -1;
    }

    public Base32(byte b2) {
        this(false, b2);
    }

    public Base32(boolean z) {
        this(0, null, z, (byte) 61);
    }

    public Base32(boolean z, byte b2) {
        this(0, null, z, b2);
    }

    public Base32(int i2) {
        this(i2, CHUNK_SEPARATOR);
    }

    public Base32(int i2, byte[] bArr) {
        this(i2, bArr, false, (byte) 61);
    }

    public Base32(int i2, byte[] bArr, boolean z) {
        this(i2, bArr, z, (byte) 61);
    }

    public Base32(int i2, byte[] bArr, boolean z, byte b2) {
        super(5, 8, i2, bArr == null ? 0 : bArr.length, b2);
        if (z) {
            this.encodeTable = HEX_ENCODE_TABLE;
            this.decodeTable = HEX_DECODE_TABLE;
        } else {
            this.encodeTable = ENCODE_TABLE;
            this.decodeTable = DECODE_TABLE;
        }
        if (i2 <= 0) {
            this.encodeSize = 8;
            this.lineSeparator = null;
        } else if (bArr != null) {
            if (!containsAlphabetOrPad(bArr)) {
                this.encodeSize = bArr.length + 8;
                byte[] bArr2 = new byte[bArr.length];
                this.lineSeparator = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                throw new IllegalArgumentException(b.D("lineSeparator must not contain Base32 characters: [", StringUtils.newStringUtf8(bArr), "]"));
            }
        } else {
            throw new IllegalArgumentException(b.g(i2, "lineLength ", " > 0, but lineSeparator is null"));
        }
        this.decodeSize = this.encodeSize - 1;
        if (isInAlphabet(b2) || BaseNCodec.isWhiteSpace(b2)) {
            throw new IllegalArgumentException("pad must not be in alphabet or whitespace");
        }
    }
}
