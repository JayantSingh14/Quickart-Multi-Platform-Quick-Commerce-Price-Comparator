package org.apache.commons.codec.digest;

import androidx.fragment.app.e;
import org.apache.commons.codec.binary.StringUtils;

/* loaded from: classes5.dex */
public final class MurmurHash3 {
    private static final long C1 = -8663945395140668459L;
    private static final int C1_32 = -862048943;
    private static final long C2 = 5545529020109919103L;
    private static final int C2_32 = 461845907;
    public static final int DEFAULT_SEED = 104729;
    static final int INTEGER_BYTES = 4;
    static final int LONG_BYTES = 8;
    private static final int M = 5;
    private static final int M_32 = 5;
    private static final int N1 = 1390208809;
    private static final int N2 = 944331445;

    @Deprecated
    public static final long NULL_HASHCODE = 2862933555777941757L;
    private static final int N_32 = -430675100;
    private static final int R1 = 31;
    private static final int R1_32 = 15;
    private static final int R2 = 27;
    private static final int R2_32 = 13;
    private static final int R3 = 33;
    static final int SHORT_BYTES = 2;

    @Deprecated
    public static class IncrementalHash32 extends IncrementalHash32x86 {
        @Override // org.apache.commons.codec.digest.MurmurHash3.IncrementalHash32x86
        @Deprecated
        public int finalise(int i2, int i3, byte[] bArr, int i4) {
            int i5;
            int i6;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        i6 = bArr[2] << 16;
                    }
                    return MurmurHash3.fmix32(i2 ^ i4);
                }
                i6 = 0;
                i5 = i6 ^ (bArr[1] << 8);
            } else {
                i5 = 0;
            }
            i2 ^= Integer.rotateLeft((i5 ^ bArr[0]) * MurmurHash3.C1_32, 15) * MurmurHash3.C2_32;
            return MurmurHash3.fmix32(i2 ^ i4);
        }
    }

    public static class IncrementalHash32x86 {
        private static final int BLOCK_SIZE = 4;
        private int hash;
        private int totalLen;
        private final byte[] unprocessed = new byte[3];
        private int unprocessedLength;

        private static int orBytes(byte b2, byte b3, byte b4, byte b5) {
            return (b2 & 255) | ((b3 & 255) << 8) | ((b4 & 255) << 16) | ((b5 & 255) << 24);
        }

        public final void add(byte[] bArr, int i2, int i3) {
            int iOrBytes;
            if (i3 <= 0) {
                return;
            }
            this.totalLen += i3;
            int i4 = this.unprocessedLength;
            if ((i4 + i3) - 4 < 0) {
                System.arraycopy(bArr, i2, this.unprocessed, i4, i3);
                this.unprocessedLength += i3;
                return;
            }
            if (i4 > 0) {
                if (i4 == 1) {
                    iOrBytes = orBytes(this.unprocessed[0], bArr[i2], bArr[i2 + 1], bArr[i2 + 2]);
                } else if (i4 == 2) {
                    byte[] bArr2 = this.unprocessed;
                    iOrBytes = orBytes(bArr2[0], bArr2[1], bArr[i2], bArr[i2 + 1]);
                } else {
                    if (i4 != 3) {
                        throw new IllegalStateException("Unprocessed length should be 1, 2, or 3: " + this.unprocessedLength);
                    }
                    byte[] bArr3 = this.unprocessed;
                    iOrBytes = orBytes(bArr3[0], bArr3[1], bArr3[2], bArr[i2]);
                }
                this.hash = MurmurHash3.mix32(iOrBytes, this.hash);
                int i5 = 4 - this.unprocessedLength;
                i2 += i5;
                i3 -= i5;
            }
            int i6 = i3 >> 2;
            for (int i7 = 0; i7 < i6; i7++) {
                this.hash = MurmurHash3.mix32(MurmurHash3.getLittleEndianInt(bArr, (i7 << 2) + i2), this.hash);
            }
            int i8 = i6 << 2;
            int i9 = i3 - i8;
            this.unprocessedLength = i9;
            if (i9 != 0) {
                System.arraycopy(bArr, i2 + i8, this.unprocessed, 0, i9);
            }
        }

        public final int end() {
            return finalise(this.hash, this.unprocessedLength, this.unprocessed, this.totalLen);
        }

        public int finalise(int i2, int i3, byte[] bArr, int i4) {
            int i5;
            int i6;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        i6 = (bArr[2] & 255) << 16;
                    }
                    return MurmurHash3.fmix32(i2 ^ i4);
                }
                i6 = 0;
                i5 = i6 ^ ((bArr[1] & 255) << 8);
            } else {
                i5 = 0;
            }
            i2 ^= Integer.rotateLeft((i5 ^ (bArr[0] & 255)) * MurmurHash3.C1_32, 15) * MurmurHash3.C2_32;
            return MurmurHash3.fmix32(i2 ^ i4);
        }

        public final void start(int i2) {
            this.totalLen = 0;
            this.unprocessedLength = 0;
            this.hash = i2;
        }
    }

    private MurmurHash3() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int fmix32(int i2) {
        int i3 = (i2 ^ (i2 >>> 16)) * (-2048144789);
        int i4 = (i3 ^ (i3 >>> 13)) * (-1028477387);
        return i4 ^ (i4 >>> 16);
    }

    private static long fmix64(long j2) {
        long j3 = (j2 ^ (j2 >>> 33)) * (-49064778989728563L);
        long j4 = (j3 ^ (j3 >>> 33)) * (-4265267296055464877L);
        return j4 ^ (j4 >>> 33);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getLittleEndianInt(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    private static long getLittleEndianLong(byte[] bArr, int i2) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    public static long[] hash128(byte[] bArr) {
        return hash128(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    public static long[] hash128x64(byte[] bArr) {
        return hash128x64(bArr, 0, bArr.length, 0);
    }

    public static int hash32(long j2, long j3) {
        return hash32(j2, j3, DEFAULT_SEED);
    }

    public static int hash32x86(byte[] bArr) {
        return hash32x86(bArr, 0, bArr.length, 0);
    }

    @Deprecated
    public static long hash64(short s) {
        return fmix64(e.h(31, ((s & 255) << 8) ^ (255 & ((s & 65280) >> 8)), C1, C2) ^ 104731);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mix32(int i2, int i3) {
        return (Integer.rotateLeft((Integer.rotateLeft(i2 * C1_32, 15) * C2_32) ^ i3, 13) * 5) + N_32;
    }

    @Deprecated
    public static long[] hash128(String str) {
        byte[] bytesUtf8 = StringUtils.getBytesUtf8(str);
        return hash128(bytesUtf8, 0, bytesUtf8.length, DEFAULT_SEED);
    }

    public static long[] hash128x64(byte[] bArr, int i2, int i3, int i4) {
        return hash128x64(bArr, i2, i3, i4 & 4294967295L);
    }

    public static int hash32(long j2, long j3, int i2) {
        long jReverseBytes = Long.reverseBytes(j2);
        long jReverseBytes2 = Long.reverseBytes(j3);
        int i3 = (int) jReverseBytes2;
        return fmix32(mix32((int) (jReverseBytes2 >>> 32), mix32(i3, mix32((int) (jReverseBytes >>> 32), mix32((int) jReverseBytes, i2)))) ^ 16);
    }

    public static int hash32x86(byte[] bArr, int i2, int i3, int i4) {
        int i5 = i3 >> 2;
        for (int i6 = 0; i6 < i5; i6++) {
            i4 = mix32(getLittleEndianInt(bArr, (i6 << 2) + i2), i4);
        }
        int i7 = (i5 << 2) + i2;
        int i8 = (i2 + i3) - i7;
        if (i8 == 1) {
            i4 ^= Integer.rotateLeft(((bArr[i7] & 255) ^ i) * C1_32, 15) * C2_32;
        } else {
            if (i8 != 2) {
                i = i8 == 3 ? (bArr[i7 + 2] & 255) << 16 : 0;
            }
            i ^= (bArr[i7 + 1] & 255) << 8;
            i4 ^= Integer.rotateLeft(((bArr[i7] & 255) ^ i) * C1_32, 15) * C2_32;
        }
        return fmix32(i4 ^ i3);
    }

    private static long[] hash128x64(byte[] bArr, int i2, int i3, long j2) {
        char c2;
        int i4 = i3 >> 4;
        long jH = j2;
        long jH2 = jH;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i2 + (i5 << 4);
            long littleEndianLong = getLittleEndianLong(bArr, i6);
            long littleEndianLong2 = getLittleEndianLong(bArr, i6 + 8);
            jH = ((Long.rotateLeft(jH ^ e.h(31, littleEndianLong, C1, C2), 27) + jH2) * 5) + 1390208809;
            jH2 = ((Long.rotateLeft(jH2 ^ e.h(33, littleEndianLong2, C2, C1), 31) + jH) * 5) + 944331445;
        }
        long j3 = 5545529020109919103L;
        long j4 = -8663945395140668459L;
        long j5 = 0;
        switch ((i2 + i3) - (i2 + (i4 << 4))) {
            case 1:
                c2 = 1;
                jH ^= e.h(31, j5 ^ (bArr[r5] & 255), j4, j3);
                break;
            case 2:
                c2 = 1;
                j5 ^= (bArr[r5 + 1] & 255) << 8;
                jH ^= e.h(31, j5 ^ (bArr[r5] & 255), j4, j3);
                break;
            case 3:
                c2 = 1;
                j5 ^= (bArr[r5 + 2] & 255) << 16;
                j5 ^= (bArr[r5 + 1] & 255) << 8;
                jH ^= e.h(31, j5 ^ (bArr[r5] & 255), j4, j3);
                break;
            case 4:
                c2 = 1;
                j5 ^= (bArr[r5 + 3] & 255) << 24;
                j5 ^= (bArr[r5 + 2] & 255) << 16;
                j5 ^= (bArr[r5 + 1] & 255) << 8;
                jH ^= e.h(31, j5 ^ (bArr[r5] & 255), j4, j3);
                break;
            case 5:
                c2 = 1;
                j5 ^= (bArr[r5 + 4] & 255) << 32;
                j5 ^= (bArr[r5 + 3] & 255) << 24;
                j5 ^= (bArr[r5 + 2] & 255) << 16;
                j5 ^= (bArr[r5 + 1] & 255) << 8;
                jH ^= e.h(31, j5 ^ (bArr[r5] & 255), j4, j3);
                break;
            case 6:
                c2 = 1;
                j5 ^= (bArr[r5 + 5] & 255) << 40;
                j5 ^= (bArr[r5 + 4] & 255) << 32;
                j5 ^= (bArr[r5 + 3] & 255) << 24;
                j5 ^= (bArr[r5 + 2] & 255) << 16;
                j5 ^= (bArr[r5 + 1] & 255) << 8;
                jH ^= e.h(31, j5 ^ (bArr[r5] & 255), j4, j3);
                break;
            case 7:
                c2 = 1;
                j5 ^= (bArr[r5 + 6] & 255) << 48;
                j5 ^= (bArr[r5 + 5] & 255) << 40;
                j5 ^= (bArr[r5 + 4] & 255) << 32;
                j5 ^= (bArr[r5 + 3] & 255) << 24;
                j5 ^= (bArr[r5 + 2] & 255) << 16;
                j5 ^= (bArr[r5 + 1] & 255) << 8;
                jH ^= e.h(31, j5 ^ (bArr[r5] & 255), j4, j3);
                break;
            case 8:
                c2 = 1;
                j5 = (bArr[r5 + 7] & 255) << 56;
                j5 ^= (bArr[r5 + 6] & 255) << 48;
                j5 ^= (bArr[r5 + 5] & 255) << 40;
                j5 ^= (bArr[r5 + 4] & 255) << 32;
                j5 ^= (bArr[r5 + 3] & 255) << 24;
                j5 ^= (bArr[r5 + 2] & 255) << 16;
                j5 ^= (bArr[r5 + 1] & 255) << 8;
                jH ^= e.h(31, j5 ^ (bArr[r5] & 255), j4, j3);
                break;
            case 9:
                c2 = 1;
                j3 = 5545529020109919103L;
                j4 = -8663945395140668459L;
                jH2 ^= e.h(33, j5 ^ (bArr[r5 + 8] & 255), C2, C1);
                j5 = (bArr[r5 + 7] & 255) << 56;
                j5 ^= (bArr[r5 + 6] & 255) << 48;
                j5 ^= (bArr[r5 + 5] & 255) << 40;
                j5 ^= (bArr[r5 + 4] & 255) << 32;
                j5 ^= (bArr[r5 + 3] & 255) << 24;
                j5 ^= (bArr[r5 + 2] & 255) << 16;
                j5 ^= (bArr[r5 + 1] & 255) << 8;
                jH ^= e.h(31, j5 ^ (bArr[r5] & 255), j4, j3);
                break;
            case 10:
                c2 = 1;
                j5 ^= (bArr[r5 + 9] & 255) << 8;
                j3 = 5545529020109919103L;
                j4 = -8663945395140668459L;
                jH2 ^= e.h(33, j5 ^ (bArr[r5 + 8] & 255), C2, C1);
                j5 = (bArr[r5 + 7] & 255) << 56;
                j5 ^= (bArr[r5 + 6] & 255) << 48;
                j5 ^= (bArr[r5 + 5] & 255) << 40;
                j5 ^= (bArr[r5 + 4] & 255) << 32;
                j5 ^= (bArr[r5 + 3] & 255) << 24;
                j5 ^= (bArr[r5 + 2] & 255) << 16;
                j5 ^= (bArr[r5 + 1] & 255) << 8;
                jH ^= e.h(31, j5 ^ (bArr[r5] & 255), j4, j3);
                break;
            case 11:
                c2 = 1;
                j5 ^= (bArr[r5 + 10] & 255) << 16;
                j5 ^= (bArr[r5 + 9] & 255) << 8;
                j3 = 5545529020109919103L;
                j4 = -8663945395140668459L;
                jH2 ^= e.h(33, j5 ^ (bArr[r5 + 8] & 255), C2, C1);
                j5 = (bArr[r5 + 7] & 255) << 56;
                j5 ^= (bArr[r5 + 6] & 255) << 48;
                j5 ^= (bArr[r5 + 5] & 255) << 40;
                j5 ^= (bArr[r5 + 4] & 255) << 32;
                j5 ^= (bArr[r5 + 3] & 255) << 24;
                j5 ^= (bArr[r5 + 2] & 255) << 16;
                j5 ^= (bArr[r5 + 1] & 255) << 8;
                jH ^= e.h(31, j5 ^ (bArr[r5] & 255), j4, j3);
                break;
            case 12:
                c2 = 1;
                j5 ^= (bArr[r5 + 11] & 255) << 24;
                j5 ^= (bArr[r5 + 10] & 255) << 16;
                j5 ^= (bArr[r5 + 9] & 255) << 8;
                j3 = 5545529020109919103L;
                j4 = -8663945395140668459L;
                jH2 ^= e.h(33, j5 ^ (bArr[r5 + 8] & 255), C2, C1);
                j5 = (bArr[r5 + 7] & 255) << 56;
                j5 ^= (bArr[r5 + 6] & 255) << 48;
                j5 ^= (bArr[r5 + 5] & 255) << 40;
                j5 ^= (bArr[r5 + 4] & 255) << 32;
                j5 ^= (bArr[r5 + 3] & 255) << 24;
                j5 ^= (bArr[r5 + 2] & 255) << 16;
                j5 ^= (bArr[r5 + 1] & 255) << 8;
                jH ^= e.h(31, j5 ^ (bArr[r5] & 255), j4, j3);
                break;
            case 13:
                c2 = 1;
                j5 ^= (bArr[r5 + 12] & 255) << 32;
                j5 ^= (bArr[r5 + 11] & 255) << 24;
                j5 ^= (bArr[r5 + 10] & 255) << 16;
                j5 ^= (bArr[r5 + 9] & 255) << 8;
                j3 = 5545529020109919103L;
                j4 = -8663945395140668459L;
                jH2 ^= e.h(33, j5 ^ (bArr[r5 + 8] & 255), C2, C1);
                j5 = (bArr[r5 + 7] & 255) << 56;
                j5 ^= (bArr[r5 + 6] & 255) << 48;
                j5 ^= (bArr[r5 + 5] & 255) << 40;
                j5 ^= (bArr[r5 + 4] & 255) << 32;
                j5 ^= (bArr[r5 + 3] & 255) << 24;
                j5 ^= (bArr[r5 + 2] & 255) << 16;
                j5 ^= (bArr[r5 + 1] & 255) << 8;
                jH ^= e.h(31, j5 ^ (bArr[r5] & 255), j4, j3);
                break;
            case 15:
                j5 = (bArr[r5 + 14] & 255) << 48;
            case 14:
                c2 = 1;
                j5 ^= (bArr[r5 + 13] & 255) << 40;
                j5 ^= (bArr[r5 + 12] & 255) << 32;
                j5 ^= (bArr[r5 + 11] & 255) << 24;
                j5 ^= (bArr[r5 + 10] & 255) << 16;
                j5 ^= (bArr[r5 + 9] & 255) << 8;
                j3 = 5545529020109919103L;
                j4 = -8663945395140668459L;
                jH2 ^= e.h(33, j5 ^ (bArr[r5 + 8] & 255), C2, C1);
                j5 = (bArr[r5 + 7] & 255) << 56;
                j5 ^= (bArr[r5 + 6] & 255) << 48;
                j5 ^= (bArr[r5 + 5] & 255) << 40;
                j5 ^= (bArr[r5 + 4] & 255) << 32;
                j5 ^= (bArr[r5 + 3] & 255) << 24;
                j5 ^= (bArr[r5 + 2] & 255) << 16;
                j5 ^= (bArr[r5 + 1] & 255) << 8;
                jH ^= e.h(31, j5 ^ (bArr[r5] & 255), j4, j3);
                break;
            default:
                c2 = 1;
                break;
        }
        long j6 = i3;
        long j7 = jH ^ j6;
        long j8 = j6 ^ jH2;
        long j9 = j7 + j8;
        long j10 = j8 + j9;
        long jFmix64 = fmix64(j9);
        long jFmix642 = fmix64(j10);
        long j11 = jFmix64 + jFmix642;
        long[] jArr = new long[2];
        jArr[0] = j11;
        jArr[c2] = jFmix642 + j11;
        return jArr;
    }

    @Deprecated
    public static long[] hash128(byte[] bArr, int i2, int i3, int i4) {
        return hash128x64(bArr, i2, i3, i4);
    }

    @Deprecated
    public static long hash64(long j2) {
        return fmix64(((Long.rotateLeft((Long.rotateLeft(Long.reverseBytes(j2) * C1, 31) * C2) ^ 104729, 27) * 5) + 1390208809) ^ 8);
    }

    @Deprecated
    public static long hash64(int i2) {
        return fmix64(e.h(31, Integer.reverseBytes(i2) & 4294967295L, C1, C2) ^ 104733);
    }

    public static int hash32(long j2) {
        return hash32(j2, DEFAULT_SEED);
    }

    public static int hash32(long j2, int i2) {
        long jReverseBytes = Long.reverseBytes(j2);
        return fmix32(mix32((int) (jReverseBytes >>> 32), mix32((int) jReverseBytes, i2)) ^ 8);
    }

    @Deprecated
    public static long hash64(byte[] bArr) {
        return hash64(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    @Deprecated
    public static long hash64(byte[] bArr, int i2, int i3) {
        return hash64(bArr, i2, i3, DEFAULT_SEED);
    }

    @Deprecated
    public static int hash32(byte[] bArr) {
        return hash32(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0040. Please report as an issue. */
    @Deprecated
    public static long hash64(byte[] bArr, int i2, int i3, int i4) {
        long j2;
        long jH = i4;
        int i5 = i3 >> 3;
        for (int i6 = 0; i6 < i5; i6++) {
            jH = (Long.rotateLeft(jH ^ e.h(31, getLittleEndianLong(bArr, i2 + (i6 << 3)), C1, C2), 27) * 5) + 1390208809;
        }
        long j3 = 0;
        switch ((i2 + i3) - (i2 + (i5 << 3))) {
            case 1:
                j2 = 255;
                jH ^= e.h(31, j3 ^ (bArr[r4] & j2), C1, C2);
                break;
            case 2:
                j2 = 255;
                j3 ^= (bArr[r4 + 1] & j2) << 8;
                jH ^= e.h(31, j3 ^ (bArr[r4] & j2), C1, C2);
                break;
            case 3:
                j2 = 255;
                j3 ^= (bArr[r4 + 2] & j2) << 16;
                j3 ^= (bArr[r4 + 1] & j2) << 8;
                jH ^= e.h(31, j3 ^ (bArr[r4] & j2), C1, C2);
                break;
            case 4:
                j2 = 255;
                j3 ^= (bArr[r4 + 3] & j2) << 24;
                j3 ^= (bArr[r4 + 2] & j2) << 16;
                j3 ^= (bArr[r4 + 1] & j2) << 8;
                jH ^= e.h(31, j3 ^ (bArr[r4] & j2), C1, C2);
                break;
            case 5:
                j2 = 255;
                j3 ^= (bArr[r4 + 4] & j2) << 32;
                j3 ^= (bArr[r4 + 3] & j2) << 24;
                j3 ^= (bArr[r4 + 2] & j2) << 16;
                j3 ^= (bArr[r4 + 1] & j2) << 8;
                jH ^= e.h(31, j3 ^ (bArr[r4] & j2), C1, C2);
                break;
            case 7:
                j3 = (bArr[r4 + 6] & 255) << 48;
            case 6:
                j2 = 255;
                j3 ^= (bArr[r4 + 5] & 255) << 40;
                j3 ^= (bArr[r4 + 4] & j2) << 32;
                j3 ^= (bArr[r4 + 3] & j2) << 24;
                j3 ^= (bArr[r4 + 2] & j2) << 16;
                j3 ^= (bArr[r4 + 1] & j2) << 8;
                jH ^= e.h(31, j3 ^ (bArr[r4] & j2), C1, C2);
                break;
        }
        return fmix64(i3 ^ jH);
    }

    @Deprecated
    public static int hash32(String str) {
        byte[] bytesUtf8 = StringUtils.getBytesUtf8(str);
        return hash32(bytesUtf8, 0, bytesUtf8.length, DEFAULT_SEED);
    }

    @Deprecated
    public static int hash32(byte[] bArr, int i2) {
        return hash32(bArr, i2, DEFAULT_SEED);
    }

    @Deprecated
    public static int hash32(byte[] bArr, int i2, int i3) {
        return hash32(bArr, 0, i2, i3);
    }

    @Deprecated
    public static int hash32(byte[] bArr, int i2, int i3, int i4) {
        int i5 = i3 >> 2;
        for (int i6 = 0; i6 < i5; i6++) {
            i4 = mix32(getLittleEndianInt(bArr, (i6 << 2) + i2), i4);
        }
        int i7 = (i5 << 2) + i2;
        int i8 = (i2 + i3) - i7;
        if (i8 != 1) {
            if (i8 != 2) {
                i = i8 == 3 ? bArr[i7 + 2] << 16 : 0;
            }
            i ^= bArr[i7 + 1] << 8;
            i4 ^= Integer.rotateLeft((bArr[i7] ^ i) * C1_32, 15) * C2_32;
        } else {
            i4 ^= Integer.rotateLeft((bArr[i7] ^ i) * C1_32, 15) * C2_32;
        }
        return fmix32(i4 ^ i3);
    }
}
