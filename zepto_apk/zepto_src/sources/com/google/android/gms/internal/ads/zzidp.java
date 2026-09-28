package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzidp extends zzido {
    public final String b(int i2, byte[] bArr, int i3) throws zzibg {
        int i4;
        int length = bArr.length;
        if ((((length - i2) - i3) | i2 | i3) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        int i5 = i2 + i3;
        char[] cArr = new char[i3];
        int i6 = 0;
        while (i2 < i5) {
            byte b2 = bArr[i2];
            if (b2 < 0) {
                break;
            }
            i2++;
            cArr[i6] = (char) b2;
            i6++;
        }
        int i7 = i6;
        while (i2 < i5) {
            int i8 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 >= 0) {
                cArr[i7] = (char) b3;
                i7++;
                i2 = i8;
                while (i2 < i5) {
                    byte b4 = bArr[i2];
                    if (b4 >= 0) {
                        i2++;
                        cArr[i7] = (char) b4;
                        i7++;
                    }
                }
            } else {
                if (b3 < -32) {
                    if (i8 >= i5) {
                        throw new zzibg("Protocol message had invalid UTF-8.");
                    }
                    i4 = i7 + 1;
                    i2 += 2;
                    zzidn.a(b3, bArr[i8], cArr, i7);
                } else if (b3 < -16) {
                    if (i8 >= i5 - 1) {
                        throw new zzibg("Protocol message had invalid UTF-8.");
                    }
                    i4 = i7 + 1;
                    int i9 = i2 + 2;
                    i2 += 3;
                    zzidn.b(b3, bArr[i8], bArr[i9], cArr, i7);
                } else {
                    if (i8 >= i5 - 2) {
                        throw new zzibg("Protocol message had invalid UTF-8.");
                    }
                    byte b5 = bArr[i8];
                    int i10 = i2 + 3;
                    byte b6 = bArr[i2 + 2];
                    i2 += 4;
                    zzidn.c(b3, b5, b6, bArr[i10], cArr, i7);
                    i7 += 2;
                }
                i7 = i4;
            }
        }
        return new String(cArr, 0, i7);
    }
}
