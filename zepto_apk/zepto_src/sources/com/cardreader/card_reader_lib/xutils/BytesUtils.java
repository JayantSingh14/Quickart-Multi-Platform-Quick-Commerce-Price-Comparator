package com.cardreader.card_reader_lib.xutils;

import android.support.v4.media.b;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public final class BytesUtils {
    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "!!!EMPTY BYTES!!!";
        }
        char[] charArray = "0123456789ABCDEF".toCharArray();
        char[] cArr = new char[bArr.length * 2];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2];
            int i3 = i2 * 2;
            cArr[i3] = charArray[(b2 & 255) >>> 4];
            cArr[i3 + 1] = charArray[b2 & 15];
        }
        return new String(cArr);
    }

    public static byte[] b(String str) {
        String strReplace = str.replace(StringUtils.SPACE, "");
        if (strReplace.length() % 2 != 0) {
            throw new IllegalArgumentException("Hex binary needs to be even-length :".concat(str));
        }
        byte[] bArr = new byte[Math.round(strReplace.length() / 2.0f)];
        int i2 = 0;
        int i3 = 0;
        while (i2 < strReplace.length()) {
            int i4 = i2 + 2;
            bArr[i3] = Integer.valueOf(Integer.parseInt(strReplace.substring(i2, i4), 16)).byteValue();
            i2 = i4;
            i3++;
        }
        return bArr;
    }

    public static boolean c(int i2, int i3) {
        if (i3 < 0 || i3 > 31) {
            throw new IllegalArgumentException(b.f(i3, "parameter 'pBitIndex' must be between 0 and 31. pBitIndex="));
        }
        return (i2 & (1 << i3)) != 0;
    }

    public static byte d(int i2, byte b2) {
        if (i2 < 0 || i2 > 7) {
            throw new IllegalArgumentException(b.f(i2, "parameter 'pBitIndex' must be between 0 and 7. pBitIndex="));
        }
        return (byte) ((1 << i2) | b2);
    }
}
