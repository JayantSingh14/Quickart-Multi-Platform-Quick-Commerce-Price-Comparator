package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
abstract class zzido {
    public static final String a(ByteBuffer byteBuffer, int i2, int i3) throws zzibg {
        int i4;
        if ((((byteBuffer.limit() - i2) - i3) | i2 | i3) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        int i5 = i2 + i3;
        char[] cArr = new char[i3];
        int i6 = 0;
        while (i2 < i5) {
            byte b2 = byteBuffer.get(i2);
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
            byte b3 = byteBuffer.get(i2);
            if (b3 >= 0) {
                cArr[i7] = (char) b3;
                i7++;
                i2 = i8;
                while (i2 < i5) {
                    byte b4 = byteBuffer.get(i2);
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
                    zzidn.a(b3, byteBuffer.get(i8), cArr, i7);
                } else if (b3 < -16) {
                    if (i8 >= i5 - 1) {
                        throw new zzibg("Protocol message had invalid UTF-8.");
                    }
                    i4 = i7 + 1;
                    int i9 = i2 + 2;
                    i2 += 3;
                    zzidn.b(b3, byteBuffer.get(i8), byteBuffer.get(i9), cArr, i7);
                } else {
                    if (i8 >= i5 - 2) {
                        throw new zzibg("Protocol message had invalid UTF-8.");
                    }
                    byte b5 = byteBuffer.get(i8);
                    int i10 = i2 + 3;
                    byte b6 = byteBuffer.get(i2 + 2);
                    i2 += 4;
                    zzidn.c(b3, b5, b6, byteBuffer.get(i10), cArr, i7);
                    i7 += 2;
                }
                i7 = i4;
            }
        }
        return new String(cArr, 0, i7);
    }
}
