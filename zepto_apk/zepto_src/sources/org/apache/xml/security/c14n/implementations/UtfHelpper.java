package org.apache.xml.security.c14n.implementations;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/* loaded from: classes5.dex */
public class UtfHelpper {
    public static final void a(char c2, OutputStream outputStream) throws IOException {
        int i2;
        char c3;
        if (c2 < 128) {
            outputStream.write(c2);
            return;
        }
        if ((c2 >= 55296 && c2 <= 56319) || (c2 >= 56320 && c2 <= 57343)) {
            outputStream.write(63);
            return;
        }
        if (c2 > 2047) {
            char c4 = (char) (c2 >>> '\f');
            outputStream.write(c4 > 0 ? 224 | (c4 & 15) : 224);
            i2 = 128;
            c3 = '?';
        } else {
            i2 = 192;
            c3 = 31;
        }
        char c5 = (char) (c2 >>> 6);
        if (c5 > 0) {
            i2 |= c3 & c5;
        }
        outputStream.write(i2);
        outputStream.write((c2 & 63) | 128);
    }

    public static final void a(String str, OutputStream outputStream) throws IOException {
        int i2;
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            int iCharAt = str.charAt(i3);
            if (iCharAt < 128) {
                outputStream.write(iCharAt);
            } else {
                char c2 = '?';
                if ((iCharAt < 55296 || iCharAt > 56319) && (iCharAt < 56320 || iCharAt > 57343)) {
                    if (iCharAt > 2047) {
                        char c3 = (char) (iCharAt >>> 12);
                        outputStream.write(c3 > 0 ? 224 | (c3 & 15) : 224);
                        i2 = 128;
                    } else {
                        i2 = 192;
                        c2 = 31;
                    }
                    char c4 = (char) (iCharAt >>> 6);
                    if (c4 > 0) {
                        i2 |= c2 & c4;
                    }
                    outputStream.write(i2);
                    iCharAt = (iCharAt & 63) | 128;
                    outputStream.write(iCharAt);
                } else {
                    outputStream.write(63);
                }
            }
            i3 = i4;
        }
    }

    public static final void a(String str, OutputStream outputStream, Map map) throws IOException {
        byte[] bArrA = (byte[]) map.get(str);
        if (bArrA == null) {
            bArrA = a(str);
            map.put(str, bArrA);
        }
        outputStream.write(bArrA);
    }

    public static final byte[] a(String str) {
        int i2;
        int i3;
        byte b2;
        int length = str.length();
        byte[] bArr = new byte[length];
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        while (i4 < length) {
            int i6 = i4 + 1;
            char cCharAt = str.charAt(i4);
            if (cCharAt < 128) {
                i2 = i5 + 1;
                bArr[i5] = (byte) cCharAt;
            } else {
                char c2 = '?';
                if ((cCharAt < 55296 || cCharAt > 56319) && (cCharAt < 56320 || cCharAt > 57343)) {
                    if (!z) {
                        byte[] bArr2 = new byte[length * 3];
                        System.arraycopy(bArr, 0, bArr2, 0, i5);
                        z = true;
                        bArr = bArr2;
                    }
                    if (cCharAt > 2047) {
                        char c3 = (char) (cCharAt >>> '\f');
                        byte b3 = c3 > 0 ? (byte) ((c3 & 15) | (-32)) : (byte) -32;
                        i3 = i5 + 1;
                        bArr[i5] = b3;
                        b2 = -128;
                    } else {
                        c2 = 31;
                        i3 = i5;
                        b2 = -64;
                    }
                    char c4 = (char) (cCharAt >>> 6);
                    if (c4 > 0) {
                        b2 = (byte) (b2 | (c2 & c4));
                    }
                    bArr[i3] = b2;
                    i5 = i3 + 2;
                    bArr[i3 + 1] = (byte) ((cCharAt & '?') | 128);
                    i4 = i6;
                } else {
                    i2 = i5 + 1;
                    bArr[i5] = 63;
                }
            }
            i4 = i6;
            i5 = i2;
        }
        if (!z) {
            return bArr;
        }
        byte[] bArr3 = new byte[i5];
        System.arraycopy(bArr, 0, bArr3, 0, i5);
        return bArr3;
    }
}
