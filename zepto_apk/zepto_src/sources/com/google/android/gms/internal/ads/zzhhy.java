package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.StringReader;

/* loaded from: classes4.dex */
public final class zzhhy {
    public static boolean a(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 != length) {
            char cCharAt = str.charAt(i2);
            int i3 = i2 + 1;
            if (!Character.isSurrogate(cCharAt)) {
                i2 = i3;
            } else {
                if (Character.isLowSurrogate(cCharAt) || i3 == length || !Character.isLowSurrogate(str.charAt(i3))) {
                    return false;
                }
                i2 += 2;
            }
        }
        return true;
    }

    public static zzhxj b(String str) throws IOException {
        try {
            return zzhhw.b(new zzhyo(new StringReader(str)));
        } catch (NumberFormatException e2) {
            throw new IOException(e2);
        }
    }
}
