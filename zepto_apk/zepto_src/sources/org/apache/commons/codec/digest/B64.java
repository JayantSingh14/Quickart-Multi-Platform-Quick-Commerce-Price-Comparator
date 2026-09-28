package org.apache.commons.codec.digest;

import java.security.SecureRandom;
import java.util.Random;
import org.xbill.DNS.Message;

/* loaded from: classes5.dex */
class B64 {
    static final String B64T_STRING = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static final char[] B64T_ARRAY = B64T_STRING.toCharArray();

    public static void b64from24bit(byte b2, byte b3, byte b4, int i2, StringBuilder sb) {
        int i3 = ((b2 << 16) & 16777215) | ((b3 << 8) & Message.MAXLENGTH) | (b4 & 255);
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                return;
            }
            sb.append(B64T_ARRAY[i3 & 63]);
            i3 >>= 6;
            i2 = i4;
        }
    }

    public static String getRandomSalt(int i2) {
        return getRandomSalt(i2, new SecureRandom());
    }

    public static String getRandomSalt(int i2, Random random) {
        StringBuilder sb = new StringBuilder(i2);
        for (int i3 = 1; i3 <= i2; i3++) {
            sb.append(B64T_STRING.charAt(random.nextInt(64)));
        }
        return sb.toString();
    }
}
