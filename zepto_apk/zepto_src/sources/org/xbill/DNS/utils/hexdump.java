package org.xbill.DNS.utils;

import android.support.v4.media.a;

/* loaded from: classes5.dex */
public class hexdump {
    private static final char[] hex = "0123456789ABCDEF".toCharArray();

    public static String dump(String str, byte[] bArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(i3);
        sb.append("b");
        if (str != null) {
            a.u(sb, " (", str, ")");
        }
        sb.append(':');
        int length = (sb.toString().length() + 8) & (-8);
        sb.append('\t');
        int i4 = (80 - length) / 3;
        for (int i5 = 0; i5 < i3; i5++) {
            if (i5 != 0 && i5 % i4 == 0) {
                sb.append('\n');
                for (int i6 = 0; i6 < length / 8; i6++) {
                    sb.append('\t');
                }
            }
            byte b2 = bArr[i5 + i2];
            char[] cArr = hex;
            sb.append(cArr[(b2 & 255) >> 4]);
            sb.append(cArr[b2 & 15]);
            sb.append(' ');
        }
        sb.append('\n');
        return sb.toString();
    }

    public static String dump(String str, byte[] bArr) {
        return dump(str, bArr, 0, bArr.length);
    }
}
