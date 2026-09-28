package com.facebook.hermes.intl;

/* loaded from: classes3.dex */
public class IntlTextUtils {
    public static boolean a(char c2) {
        if (c2 < 'a' || c2 > 'z') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    public static boolean b(int i2, int i3, int i4, int i5, String str) {
        int i6;
        if (i3 >= str.length() || (i6 = (i3 - i2) + 1) < i4 || i6 > i5) {
            return false;
        }
        while (i2 <= i3) {
            if (!a(str.charAt(i2))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public static boolean c(int i2, int i3, CharSequence charSequence, int i4, int i5) {
        int i6;
        if (i3 >= charSequence.length() || (i6 = (i3 - i2) + 1) < i4 || i6 > i5) {
            return false;
        }
        while (i2 <= i3) {
            char cCharAt = charSequence.charAt(i2);
            if (!a(cCharAt) && (cCharAt < '0' || cCharAt > '9')) {
                return false;
            }
            i2++;
        }
        return true;
    }
}
