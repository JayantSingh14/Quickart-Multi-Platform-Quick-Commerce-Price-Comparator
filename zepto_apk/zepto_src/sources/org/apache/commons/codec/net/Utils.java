package org.apache.commons.codec.net;

import android.support.v4.media.b;
import org.apache.commons.codec.DecoderException;

/* loaded from: classes5.dex */
class Utils {
    private static final int RADIX = 16;

    public static int digit16(byte b2) throws DecoderException {
        int iDigit = Character.digit((char) b2, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new DecoderException(b.f(b2, "Invalid URL encoding: not a valid digit (radix 16): "));
    }

    public static char hexDigit(int i2) {
        return Character.toUpperCase(Character.forDigit(i2 & 15, 16));
    }
}
