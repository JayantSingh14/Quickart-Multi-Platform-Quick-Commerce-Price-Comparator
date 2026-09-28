package org.xbill.DNS.utils;

import java.io.ByteArrayOutputStream;

/* loaded from: classes5.dex */
public class base16 {
    private static final String BASE_16_CHARS = "0123456789ABCDEF";

    private base16() {
    }

    public static byte[] fromString(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if ((cCharAt >= '0' && cCharAt <= '9') || (cCharAt >= 'A' && cCharAt <= 'F')) {
                byteArrayOutputStream.write(cCharAt);
            } else if (cCharAt >= 'a' && cCharAt <= 'f') {
                byteArrayOutputStream.write(cCharAt - ' ');
            } else if (!Character.isWhitespace(cCharAt)) {
                return null;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if ((byteArray.length & 1) != 0) {
            return null;
        }
        byteArrayOutputStream.reset();
        for (int i3 = 0; i3 < byteArray.length; i3 += 2) {
            byteArrayOutputStream.write((((byte) BASE_16_CHARS.indexOf(byteArray[i3])) << 4) + (((byte) BASE_16_CHARS.indexOf(byteArray[i3 + 1])) & 15));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static String toString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            short s = (short) (b2 & 255);
            sb.append(BASE_16_CHARS.charAt((byte) (s >> 4)));
            sb.append(BASE_16_CHARS.charAt((byte) (s & 15)));
        }
        return sb.toString();
    }

    public static String toString(byte[] bArr, int i2, String str, boolean z) {
        return BaseUtils.wrapLines(toString(bArr), i2, str, z);
    }
}
