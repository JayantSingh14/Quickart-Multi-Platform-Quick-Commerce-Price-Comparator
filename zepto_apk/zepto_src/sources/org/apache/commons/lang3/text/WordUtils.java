package org.apache.commons.lang3.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

@Deprecated
/* loaded from: classes5.dex */
public class WordUtils {
    public static String capitalize(String str) {
        return capitalize(str, null);
    }

    public static String capitalizeFully(String str) {
        return capitalizeFully(str, null);
    }

    public static boolean containsAllWords(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (StringUtils.isEmpty(charSequence) || ArrayUtils.isEmpty(charSequenceArr)) {
            return false;
        }
        for (CharSequence charSequence2 : charSequenceArr) {
            if (StringUtils.isBlank(charSequence2)) {
                return false;
            }
            if (!Pattern.compile(".*\\b" + ((Object) charSequence2) + "\\b.*").matcher(charSequence).matches()) {
                return false;
            }
        }
        return true;
    }

    public static String initials(String str) {
        return initials(str, null);
    }

    private static boolean isDelimiter(char c2, char[] cArr) {
        if (cArr == null) {
            return Character.isWhitespace(c2);
        }
        for (char c3 : cArr) {
            if (c2 == c3) {
                return true;
            }
        }
        return false;
    }

    public static String swapCase(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean zIsWhitespace = true;
        int i2 = 0;
        while (i2 < charArray.length) {
            char c2 = charArray[i2];
            if (Character.isUpperCase(c2) || Character.isTitleCase(c2)) {
                charArray[i2] = Character.toLowerCase(c2);
            } else {
                if (!Character.isLowerCase(c2)) {
                    zIsWhitespace = Character.isWhitespace(c2);
                } else if (zIsWhitespace) {
                    charArray[i2] = Character.toTitleCase(c2);
                } else {
                    charArray[i2] = Character.toUpperCase(c2);
                }
                i2++;
            }
            zIsWhitespace = false;
            i2++;
        }
        return new String(charArray);
    }

    public static String uncapitalize(String str) {
        return uncapitalize(str, null);
    }

    public static String wrap(String str, int i2) {
        return wrap(str, i2, null, false);
    }

    public static String capitalize(String str, char... cArr) {
        int length = cArr == null ? -1 : cArr.length;
        if (StringUtils.isEmpty(str) || length == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z = true;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c2 = charArray[i2];
            if (isDelimiter(c2, cArr)) {
                z = true;
            } else if (z) {
                charArray[i2] = Character.toTitleCase(c2);
                z = false;
            }
        }
        return new String(charArray);
    }

    public static String capitalizeFully(String str, char... cArr) {
        return (StringUtils.isEmpty(str) || (cArr == null ? -1 : cArr.length) == 0) ? str : capitalize(str.toLowerCase(), cArr);
    }

    public static String initials(String str, char... cArr) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        if (cArr != null && cArr.length == 0) {
            return "";
        }
        int length = str.length();
        char[] cArr2 = new char[(length / 2) + 1];
        boolean z = true;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (isDelimiter(cCharAt, cArr)) {
                z = true;
            } else if (z) {
                cArr2[i2] = cCharAt;
                i2++;
                z = false;
            }
        }
        return new String(cArr2, 0, i2);
    }

    public static String uncapitalize(String str, char... cArr) {
        int length = cArr == null ? -1 : cArr.length;
        if (StringUtils.isEmpty(str) || length == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        boolean z = true;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c2 = charArray[i2];
            if (isDelimiter(c2, cArr)) {
                z = true;
            } else if (z) {
                charArray[i2] = Character.toLowerCase(c2);
                z = false;
            }
        }
        return new String(charArray);
    }

    public static String wrap(String str, int i2, String str2, boolean z) {
        return wrap(str, i2, str2, z, StringUtils.SPACE);
    }

    public static String wrap(String str, int i2, String str2, boolean z, String str3) {
        int iStart;
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = System.lineSeparator();
        }
        if (i2 < 1) {
            i2 = 1;
        }
        if (StringUtils.isBlank(str3)) {
            str3 = StringUtils.SPACE;
        }
        Pattern patternCompile = Pattern.compile(str3);
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 32);
        int iEnd = 0;
        while (iEnd < length) {
            int i3 = iEnd + i2;
            Matcher matcher = patternCompile.matcher(str.substring(iEnd, Math.min(i3 + 1, length)));
            if (!matcher.find()) {
                iStart = -1;
            } else if (matcher.start() == 0) {
                iEnd += matcher.end();
            } else {
                iStart = matcher.start() + iEnd;
            }
            if (length - iEnd <= i2) {
                break;
            }
            while (matcher.find()) {
                iStart = matcher.start() + iEnd;
            }
            if (iStart >= iEnd) {
                sb.append((CharSequence) str, iEnd, iStart);
                sb.append(str2);
            } else if (z) {
                sb.append((CharSequence) str, iEnd, i3);
                sb.append(str2);
                iEnd = i3;
            } else {
                Matcher matcher2 = patternCompile.matcher(str.substring(i3));
                if (matcher2.find()) {
                    iStart = matcher2.start() + iEnd + i2;
                }
                if (iStart >= 0) {
                    sb.append((CharSequence) str, iEnd, iStart);
                    sb.append(str2);
                } else {
                    sb.append((CharSequence) str, iEnd, str.length());
                    iEnd = length;
                }
            }
            iEnd = iStart + 1;
        }
        sb.append((CharSequence) str, iEnd, str.length());
        return sb.toString();
    }
}
