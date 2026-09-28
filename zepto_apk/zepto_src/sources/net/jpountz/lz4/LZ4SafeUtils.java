package net.jpountz.lz4;

import android.support.v4.media.b;
import net.jpountz.util.SafeUtils;

/* loaded from: classes.dex */
enum LZ4SafeUtils {
    ;

    /* loaded from: classes3.dex */
    public static class Match {
        int len;
        int ref;
        int start;

        public int end() {
            return this.start + this.len;
        }

        public void fix(int i2) {
            this.start += i2;
            this.ref += i2;
            this.len -= i2;
        }
    }

    public static int commonBytes(byte[] bArr, int i2, int i3, int i4) {
        int i5 = 0;
        while (i3 < i4) {
            int i6 = i2 + 1;
            int i7 = i3 + 1;
            if (bArr[i2] != bArr[i3]) {
                break;
            }
            i5++;
            i2 = i6;
            i3 = i7;
        }
        return i5;
    }

    public static int commonBytesBackward(byte[] bArr, int i2, int i3, int i4, int i5) {
        int i6 = 0;
        while (i2 > i4 && i3 > i5) {
            i2--;
            i3--;
            if (bArr[i2] != bArr[i3]) {
                break;
            }
            i6++;
        }
        return i6;
    }

    public static void copy8Bytes(byte[] bArr, int i2, byte[] bArr2, int i3) {
        for (int i4 = 0; i4 < 8; i4++) {
            bArr2[i3 + i4] = bArr[i2 + i4];
        }
    }

    public static void copyTo(Match match, Match match2) {
        match2.len = match.len;
        match2.start = match.start;
        match2.ref = match.ref;
    }

    public static int encodeSequence(byte[] bArr, int i2, int i3, int i4, int i5, byte[] bArr2, int i6, int i7) {
        int i8;
        int i9;
        int i10 = i3 - i2;
        int iWriteLen = i6 + 1;
        if (iWriteLen + i10 + 8 + (i10 >>> 8) > i7) {
            throw new LZ4Exception("maxDestLen is too small");
        }
        if (i10 >= 15) {
            iWriteLen = writeLen(i10 - 15, bArr2, iWriteLen);
            i8 = -16;
        } else {
            i8 = i10 << 4;
        }
        wildArraycopy(bArr, i2, bArr2, iWriteLen, i10);
        int i11 = iWriteLen + i10;
        int i12 = i3 - i4;
        bArr2[i11] = (byte) i12;
        int iWriteLen2 = i11 + 2;
        bArr2[i11 + 1] = (byte) (i12 >>> 8);
        int i13 = i5 - 4;
        if (i11 + 8 + (i13 >>> 8) > i7) {
            throw new LZ4Exception("maxDestLen is too small");
        }
        if (i13 >= 15) {
            i9 = i8 | 15;
            iWriteLen2 = writeLen(i5 - 19, bArr2, iWriteLen2);
        } else {
            i9 = i13 | i8;
        }
        bArr2[i6] = (byte) i9;
        return iWriteLen2;
    }

    public static int hash(byte[] bArr, int i2) {
        return LZ4Utils.hash(SafeUtils.readInt(bArr, i2));
    }

    public static int hash64k(byte[] bArr, int i2) {
        return LZ4Utils.hash64k(SafeUtils.readInt(bArr, i2));
    }

    public static int lastLiterals(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        int iWriteLen;
        if (((i3 + 240) / 255) + i4 + i3 + 1 > i5) {
            throw new LZ4Exception();
        }
        if (i3 >= 15) {
            bArr2[i4] = -16;
            iWriteLen = writeLen(i3 - 15, bArr2, i4 + 1);
        } else {
            bArr2[i4] = (byte) (i3 << 4);
            iWriteLen = i4 + 1;
        }
        System.arraycopy(bArr, i2, bArr2, iWriteLen, i3);
        return iWriteLen + i3;
    }

    public static boolean readIntEquals(byte[] bArr, int i2, int i3) {
        return bArr[i2] == bArr[i3] && bArr[i2 + 1] == bArr[i3 + 1] && bArr[i2 + 2] == bArr[i3 + 2] && bArr[i2 + 3] == bArr[i3 + 3];
    }

    public static void safeArraycopy(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        System.arraycopy(bArr, i2, bArr2, i3, i4);
    }

    public static void safeIncrementalCopy(byte[] bArr, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[i3 + i5] = bArr[i2 + i5];
        }
    }

    public static void wildArraycopy(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5 += 8) {
            try {
                copy8Bytes(bArr, i2 + i5, bArr2, i3 + i5);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new LZ4Exception(b.f(i2, "Malformed input at offset "));
            }
        }
    }

    public static void wildIncrementalCopy(byte[] bArr, int i2, int i3, int i4) {
        do {
            copy8Bytes(bArr, i2, bArr, i3);
            i2 += 8;
            i3 += 8;
        } while (i3 < i4);
    }

    public static int writeLen(int i2, byte[] bArr, int i3) {
        while (i2 >= 255) {
            bArr[i3] = -1;
            i2 -= 255;
            i3++;
        }
        int i4 = i3 + 1;
        bArr[i3] = (byte) i2;
        return i4;
    }
}
