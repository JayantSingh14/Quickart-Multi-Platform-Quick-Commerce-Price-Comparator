package org.apache.commons.lang3;

/* loaded from: classes5.dex */
public class CharUtils {
    public static final char CR = '\r';
    public static final char LF = '\n';
    public static final char NUL = 0;
    private static final String[] CHAR_STRING_ARRAY = new String[128];
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    static {
        char c2 = 0;
        while (true) {
            String[] strArr = CHAR_STRING_ARRAY;
            if (c2 >= strArr.length) {
                return;
            }
            strArr[c2] = String.valueOf(c2);
            c2 = (char) (c2 + 1);
        }
    }

    public static int compare(char c2, char c3) {
        return c2 - c3;
    }

    public static boolean isAscii(char c2) {
        return c2 < 128;
    }

    public static boolean isAsciiAlpha(char c2) {
        return isAsciiAlphaUpper(c2) || isAsciiAlphaLower(c2);
    }

    public static boolean isAsciiAlphaLower(char c2) {
        return c2 >= 'a' && c2 <= 'z';
    }

    public static boolean isAsciiAlphaUpper(char c2) {
        return c2 >= 'A' && c2 <= 'Z';
    }

    public static boolean isAsciiAlphanumeric(char c2) {
        return isAsciiAlpha(c2) || isAsciiNumeric(c2);
    }

    public static boolean isAsciiControl(char c2) {
        return c2 < ' ' || c2 == 127;
    }

    public static boolean isAsciiNumeric(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean isAsciiPrintable(char c2) {
        return c2 >= ' ' && c2 < 127;
    }

    public static char toChar(Character ch2) {
        Validate.isTrue(ch2 != null, "The Character must not be null", new Object[0]);
        return ch2.charValue();
    }

    @Deprecated
    public static Character toCharacterObject(char c2) {
        return Character.valueOf(c2);
    }

    public static int toIntValue(char c2) {
        if (isAsciiNumeric(c2)) {
            return c2 - '0';
        }
        throw new IllegalArgumentException("The character " + c2 + " is not in the range '0' - '9'");
    }

    public static String toString(char c2) {
        return c2 < 128 ? CHAR_STRING_ARRAY[c2] : new String(new char[]{c2});
    }

    public static String unicodeEscaped(char c2) {
        StringBuilder sb = new StringBuilder("\\u");
        char[] cArr = HEX_DIGITS;
        sb.append(cArr[(c2 >> '\f') & 15]);
        sb.append(cArr[(c2 >> '\b') & 15]);
        sb.append(cArr[(c2 >> 4) & 15]);
        sb.append(cArr[c2 & 15]);
        return sb.toString();
    }

    public static Character toCharacterObject(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return Character.valueOf(str.charAt(0));
    }

    public static String unicodeEscaped(Character ch2) {
        if (ch2 == null) {
            return null;
        }
        return unicodeEscaped(ch2.charValue());
    }

    public static char toChar(Character ch2, char c2) {
        return ch2 == null ? c2 : ch2.charValue();
    }

    public static int toIntValue(char c2, int i2) {
        return !isAsciiNumeric(c2) ? i2 : c2 - '0';
    }

    public static String toString(Character ch2) {
        if (ch2 == null) {
            return null;
        }
        return toString(ch2.charValue());
    }

    public static char toChar(String str) {
        Validate.isTrue(StringUtils.isNotEmpty(str), "The String must not be empty", new Object[0]);
        return str.charAt(0);
    }

    public static int toIntValue(Character ch2) {
        Validate.isTrue(ch2 != null, "The character must not be null", new Object[0]);
        return toIntValue(ch2.charValue());
    }

    public static char toChar(String str, char c2) {
        return StringUtils.isEmpty(str) ? c2 : str.charAt(0);
    }

    public static int toIntValue(Character ch2, int i2) {
        return ch2 == null ? i2 : toIntValue(ch2.charValue(), i2);
    }
}
