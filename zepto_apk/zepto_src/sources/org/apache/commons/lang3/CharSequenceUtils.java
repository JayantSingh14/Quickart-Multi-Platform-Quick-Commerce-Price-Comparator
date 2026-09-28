package org.apache.commons.lang3;

/* loaded from: classes5.dex */
public class CharSequenceUtils {
    private static final int NOT_FOUND = -1;

    public static int indexOf(CharSequence charSequence, int i2, int i3) {
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(i2, i3);
        }
        int length = charSequence.length();
        if (i3 < 0) {
            i3 = 0;
        }
        if (i2 < 65536) {
            for (int i4 = i3; i4 < length; i4++) {
                if (charSequence.charAt(i4) == i2) {
                    return i4;
                }
            }
        }
        if (i2 > 1114111) {
            return -1;
        }
        char[] chars = Character.toChars(i2);
        while (i3 < length - 1) {
            char cCharAt = charSequence.charAt(i3);
            int i5 = i3 + 1;
            char cCharAt2 = charSequence.charAt(i5);
            if (cCharAt == chars[0] && cCharAt2 == chars[1]) {
                return i3;
            }
            i3 = i5;
        }
        return -1;
    }

    public static int lastIndexOf(CharSequence charSequence, int i2, int i3) {
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(i2, i3);
        }
        int length = charSequence.length();
        if (i3 < 0) {
            return -1;
        }
        if (i3 >= length) {
            i3 = length - 1;
        }
        if (i2 < 65536) {
            for (int i4 = i3; i4 >= 0; i4--) {
                if (charSequence.charAt(i4) == i2) {
                    return i4;
                }
            }
        }
        if (i2 <= 1114111) {
            char[] chars = Character.toChars(i2);
            if (i3 == length - 1) {
                return -1;
            }
            while (i3 >= 0) {
                char cCharAt = charSequence.charAt(i3);
                char cCharAt2 = charSequence.charAt(i3 + 1);
                if (chars[0] == cCharAt && chars[1] == cCharAt2) {
                    return i3;
                }
                i3--;
            }
        }
        return -1;
    }

    public static boolean regionMatches(CharSequence charSequence, boolean z, int i2, CharSequence charSequence2, int i3, int i4) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z, i2, (String) charSequence2, i3, i4);
        }
        int length = charSequence.length() - i2;
        int length2 = charSequence2.length() - i3;
        if (i2 < 0 || i3 < 0 || i4 < 0 || length < i4 || length2 < i4) {
            return false;
        }
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return true;
            }
            int i6 = i2 + 1;
            char cCharAt = charSequence.charAt(i2);
            int i7 = i3 + 1;
            char cCharAt2 = charSequence2.charAt(i3);
            if (cCharAt != cCharAt2) {
                if (!z) {
                    return false;
                }
                if (Character.toUpperCase(cCharAt) != Character.toUpperCase(cCharAt2) && Character.toLowerCase(cCharAt) != Character.toLowerCase(cCharAt2)) {
                    return false;
                }
            }
            i2 = i6;
            i4 = i5;
            i3 = i7;
        }
    }

    public static CharSequence subSequence(CharSequence charSequence, int i2) {
        if (charSequence == null) {
            return null;
        }
        return charSequence.subSequence(i2, charSequence.length());
    }

    public static char[] toCharArray(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return ((String) charSequence).toCharArray();
        }
        int length = charSequence.length();
        char[] cArr = new char[charSequence.length()];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = charSequence.charAt(i2);
        }
        return cArr;
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        return charSequence.toString().indexOf(charSequence2.toString(), i2);
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        return charSequence.toString().lastIndexOf(charSequence2.toString(), i2);
    }
}
