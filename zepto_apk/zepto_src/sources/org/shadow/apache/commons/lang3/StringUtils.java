package org.shadow.apache.commons.lang3;

/* loaded from: classes5.dex */
public class StringUtils {
    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static String b(String str, int i2, char c2) {
        if (str == null) {
            return null;
        }
        int length = i2 - str.length();
        if (length > 0) {
            if (length <= 8192) {
                return c(c2, length).concat(str);
            }
            String strValueOf = String.valueOf(c2);
            if (a(strValueOf)) {
                strValueOf = org.apache.commons.lang3.StringUtils.SPACE;
            }
            int length2 = strValueOf.length();
            int length3 = i2 - str.length();
            if (length3 > 0) {
                if (length2 == 1 && length3 <= 8192) {
                    return b(str, i2, strValueOf.charAt(0));
                }
                if (length3 == length2) {
                    return strValueOf.concat(str);
                }
                if (length3 < length2) {
                    return strValueOf.substring(0, length3).concat(str);
                }
                char[] cArr = new char[length3];
                char[] charArray = strValueOf.toCharArray();
                for (int i3 = 0; i3 < length3; i3++) {
                    cArr[i3] = charArray[i3 % length2];
                }
                return new String(cArr).concat(str);
            }
        }
        return str;
    }

    public static String c(char c2, int i2) {
        char[] cArr = new char[i2];
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            cArr[i3] = c2;
        }
        return new String(cArr);
    }
}
