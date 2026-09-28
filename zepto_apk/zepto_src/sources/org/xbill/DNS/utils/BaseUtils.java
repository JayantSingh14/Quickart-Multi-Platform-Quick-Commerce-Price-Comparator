package org.xbill.DNS.utils;

import lombok.Generated;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
final class BaseUtils {
    @Generated
    private BaseUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static String wrapLines(String str, int i2, String str2, boolean z) {
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (i3 < str.length()) {
            sb.append(str2);
            int i4 = i3 + i2;
            if (i4 >= str.length()) {
                sb.append(str.substring(i3));
                if (z) {
                    sb.append(" )");
                }
            } else {
                sb.append((CharSequence) str, i3, i4);
                sb.append(StringUtils.LF);
            }
            i3 = i4;
        }
        return sb.toString();
    }
}
