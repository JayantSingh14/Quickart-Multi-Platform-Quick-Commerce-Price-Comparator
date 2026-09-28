package org.apache.commons.lang3;

import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class StringUtils {
    public static final String CR = "\r";
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;
    public static final String LF = "\n";
    private static final int PAD_LIMIT = 8192;
    public static final String SPACE = " ";

    public static String abbreviate(String str, int i2) {
        return abbreviate(str, "...", 0, i2);
    }

    public static String abbreviateMiddle(String str, String str2, int i2) {
        if (isEmpty(str) || isEmpty(str2) || i2 >= str.length() || i2 < str2.length() + 2) {
            return str;
        }
        int length = i2 - str2.length();
        int i3 = length / 2;
        return str.substring(0, (length % 2) + i3) + str2 + str.substring(str.length() - i3);
    }

    private static String appendIfMissing(String str, CharSequence charSequence, boolean z, CharSequence... charSequenceArr) {
        if (str == null || isEmpty(charSequence) || endsWith(str, charSequence, z)) {
            return str;
        }
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (endsWith(str, charSequence2, z)) {
                    return str;
                }
            }
        }
        StringBuilder sbW = b.w(str);
        sbW.append(charSequence.toString());
        return sbW.toString();
    }

    public static String appendIfMissingIgnoreCase(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return appendIfMissing(str, charSequence, true, charSequenceArr);
    }

    public static String capitalize(String str) {
        int length;
        int iCodePointAt;
        int titleCase;
        if (str == null || (length = str.length()) == 0 || iCodePointAt == (titleCase = Character.toTitleCase((iCodePointAt = str.codePointAt(0))))) {
            return str;
        }
        int[] iArr = new int[length];
        iArr[0] = titleCase;
        int iCharCount = Character.charCount(iCodePointAt);
        int i2 = 1;
        while (iCharCount < length) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            iArr[i2] = iCodePointAt2;
            iCharCount += Character.charCount(iCodePointAt2);
            i2++;
        }
        return new String(iArr, 0, i2);
    }

    public static String center(String str, int i2) {
        return center(str, i2, ' ');
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String chomp(java.lang.String r6) {
        /*
            boolean r0 = isEmpty(r6)
            if (r0 == 0) goto L7
            return r6
        L7:
            int r0 = r6.length()
            r1 = 10
            r2 = 0
            r3 = 1
            r4 = 13
            if (r0 != r3) goto L20
            char r0 = r6.charAt(r2)
            if (r0 == r4) goto L1d
            if (r0 != r1) goto L1c
            goto L1d
        L1c:
            return r6
        L1d:
            java.lang.String r6 = ""
            return r6
        L20:
            int r0 = r6.length()
            int r3 = r0 + (-1)
            char r5 = r6.charAt(r3)
            if (r5 != r1) goto L37
            int r1 = r0 + (-2)
            char r1 = r6.charAt(r1)
            if (r1 != r4) goto L3a
            int r0 = r0 + (-2)
            goto L3b
        L37:
            if (r5 == r4) goto L3a
            goto L3b
        L3a:
            r0 = r3
        L3b:
            java.lang.String r6 = r6.substring(r2, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.chomp(java.lang.String):java.lang.String");
    }

    public static String chop(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length < 2) {
            return "";
        }
        int i2 = length - 1;
        String strSubstring = str.substring(0, i2);
        if (str.charAt(i2) == '\n') {
            int i3 = length - 2;
            if (strSubstring.charAt(i3) == '\r') {
                return strSubstring.substring(0, i3);
            }
        }
        return strSubstring;
    }

    public static int compare(String str, String str2) {
        return compare(str, str2, true);
    }

    public static int compareIgnoreCase(String str, String str2) {
        return compareIgnoreCase(str, str2, true);
    }

    public static boolean contains(CharSequence charSequence, int i2) {
        return !isEmpty(charSequence) && CharSequenceUtils.indexOf(charSequence, i2, 0) >= 0;
    }

    public static boolean containsAny(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int length2 = cArr.length;
            int i2 = length - 1;
            int i3 = length2 - 1;
            for (int i4 = 0; i4 < length; i4++) {
                char cCharAt = charSequence.charAt(i4);
                for (int i5 = 0; i5 < length2; i5++) {
                    if (cArr[i5] == cCharAt) {
                        if (!Character.isHighSurrogate(cCharAt) || i5 == i3) {
                            return true;
                        }
                        if (i4 < i2 && cArr[i5 + 1] == charSequence.charAt(i4 + 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean containsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            int length = charSequence2.length();
            int length2 = charSequence.length() - length;
            int i2 = 0;
            while (i2 <= length2) {
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                if (CharSequenceUtils.regionMatches(charSequence3, true, i2, charSequence4, 0, length)) {
                    return true;
                }
                i2++;
                charSequence = charSequence3;
                charSequence2 = charSequence4;
            }
        }
        return false;
    }

    public static boolean containsNone(CharSequence charSequence, char... cArr) {
        if (charSequence != null && cArr != null) {
            int length = charSequence.length();
            int i2 = length - 1;
            int length2 = cArr.length;
            int i3 = length2 - 1;
            for (int i4 = 0; i4 < length; i4++) {
                char cCharAt = charSequence.charAt(i4);
                for (int i5 = 0; i5 < length2; i5++) {
                    if (cArr[i5] == cCharAt) {
                        if (!Character.isHighSurrogate(cCharAt) || i5 == i3) {
                            return false;
                        }
                        if (i4 < i2 && cArr[i5 + 1] == charSequence.charAt(i4 + 1)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean containsOnly(CharSequence charSequence, char... cArr) {
        if (cArr != null && charSequence != null) {
            if (charSequence.length() == 0) {
                return true;
            }
            if (cArr.length != 0 && indexOfAnyBut(charSequence, cArr) == -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsWhitespace(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (Character.isWhitespace(charSequence.charAt(i2))) {
                return true;
            }
        }
        return false;
    }

    private static void convertRemainingAccentCharacters(StringBuilder sb) {
        for (int i2 = 0; i2 < sb.length(); i2++) {
            if (sb.charAt(i2) == 321) {
                sb.deleteCharAt(i2);
                sb.insert(i2, 'L');
            } else if (sb.charAt(i2) == 322) {
                sb.deleteCharAt(i2);
                sb.insert(i2, 'l');
            }
        }
    }

    public static int countMatches(CharSequence charSequence, CharSequence charSequence2) {
        int length = 0;
        if (isEmpty(charSequence) || isEmpty(charSequence2)) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int iIndexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, length);
            if (iIndexOf == -1) {
                return i2;
            }
            i2++;
            length = iIndexOf + charSequence2.length();
        }
    }

    public static <T extends CharSequence> T defaultIfBlank(T t, T t2) {
        return isBlank(t) ? t2 : t;
    }

    public static <T extends CharSequence> T defaultIfEmpty(T t, T t2) {
        return isEmpty(t) ? t2 : t;
    }

    public static String defaultString(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static String deleteWhitespace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (!Character.isWhitespace(str.charAt(i3))) {
                cArr[i2] = str.charAt(i3);
                i2++;
            }
        }
        return i2 == length ? str : new String(cArr, 0, i2);
    }

    public static String difference(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        int iIndexOfDifference = indexOfDifference(str, str2);
        return iIndexOfDifference == -1 ? "" : str2.substring(iIndexOfDifference);
    }

    public static boolean endsWith(CharSequence charSequence, CharSequence charSequence2) {
        return endsWith(charSequence, charSequence2, false);
    }

    public static boolean endsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (endsWith(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean endsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return endsWith(charSequence, charSequence2, true);
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        return ((charSequence instanceof String) && (charSequence2 instanceof String)) ? charSequence.equals(charSequence2) : CharSequenceUtils.regionMatches(charSequence, false, 0, charSequence2, 0, charSequence.length());
    }

    public static boolean equalsAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (ArrayUtils.isNotEmpty(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (equals(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean equalsAnyIgnoreCase(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (ArrayUtils.isNotEmpty(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (equalsIgnoreCase(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence.length() != charSequence2.length()) {
            return false;
        }
        return CharSequenceUtils.regionMatches(charSequence, true, 0, charSequence2, 0, charSequence.length());
    }

    public static String getCommonPrefix(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        int iIndexOfDifference = indexOfDifference(strArr);
        if (iIndexOfDifference != -1) {
            return iIndexOfDifference == 0 ? "" : strArr[0].substring(0, iIndexOfDifference);
        }
        String str = strArr[0];
        return str == null ? "" : str;
    }

    public static String getDigits(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    @Deprecated
    public static int getFuzzyDistance(CharSequence charSequence, CharSequence charSequence2, Locale locale) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        if (locale == null) {
            throw new IllegalArgumentException("Locale must not be null");
        }
        String lowerCase = charSequence.toString().toLowerCase(locale);
        String lowerCase2 = charSequence2.toString().toLowerCase(locale);
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < lowerCase2.length(); i5++) {
            char cCharAt = lowerCase2.charAt(i5);
            boolean z = false;
            while (i4 < lowerCase.length() && !z) {
                if (cCharAt == lowerCase.charAt(i4)) {
                    int i6 = i3 + 1;
                    if (i2 + 1 == i4) {
                        i6 = i3 + 3;
                    }
                    i3 = i6;
                    z = true;
                    i2 = i4;
                }
                i4++;
            }
        }
        return i3;
    }

    @Deprecated
    public static double getJaroWinklerDistance(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        double d2 = matches(charSequence, charSequence2)[0];
        if (d2 == 0.0d) {
            return 0.0d;
        }
        double length = (((d2 - r0[1]) / d2) + ((d2 / charSequence2.length()) + (d2 / charSequence.length()))) / 3.0d;
        if (length >= 0.7d) {
            length += (1.0d - length) * Math.min(0.1d, 1.0d / r0[3]) * r0[2];
        }
        return Math.round(length * 100.0d) / 100.0d;
    }

    @Deprecated
    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int length = charSequence.length();
        int length2 = charSequence2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        if (length > length2) {
            length2 = charSequence.length();
            length = length2;
        } else {
            charSequence2 = charSequence;
            charSequence = charSequence2;
        }
        int[] iArr = new int[length + 1];
        for (int i2 = 0; i2 <= length; i2++) {
            iArr[i2] = i2;
        }
        for (int i3 = 1; i3 <= length2; i3++) {
            int i4 = iArr[0];
            char cCharAt = charSequence.charAt(i3 - 1);
            iArr[0] = i3;
            int i5 = 1;
            while (i5 <= length) {
                int i6 = iArr[i5];
                int i7 = i5 - 1;
                iArr[i5] = Math.min(Math.min(iArr[i7] + 1, iArr[i5] + 1), i4 + (charSequence2.charAt(i7) == cCharAt ? 0 : 1));
                i5++;
                i4 = i6;
            }
        }
        return iArr[length];
    }

    public static int indexOf(CharSequence charSequence, int i2) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, i2, 0);
    }

    public static int indexOfAny(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int i2 = length - 1;
            int length2 = cArr.length;
            int i3 = length2 - 1;
            for (int i4 = 0; i4 < length; i4++) {
                char cCharAt = charSequence.charAt(i4);
                for (int i5 = 0; i5 < length2; i5++) {
                    if (cArr[i5] == cCharAt && (i4 >= i2 || i5 >= i3 || !Character.isHighSurrogate(cCharAt) || cArr[i5 + 1] == charSequence.charAt(i4 + 1))) {
                        return i4;
                    }
                }
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003c, code lost:
    
        r6 = r6 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int indexOfAnyBut(java.lang.CharSequence r11, char... r12) {
        /*
            boolean r0 = isEmpty(r11)
            r1 = -1
            if (r0 != 0) goto L43
            boolean r0 = org.apache.commons.lang3.ArrayUtils.isEmpty(r12)
            if (r0 == 0) goto Le
            goto L43
        Le:
            int r0 = r11.length()
            int r2 = r0 + (-1)
            int r3 = r12.length
            int r4 = r3 + (-1)
            r5 = 0
            r6 = r5
        L19:
            if (r6 >= r0) goto L43
            char r7 = r11.charAt(r6)
            r8 = r5
        L20:
            if (r8 >= r3) goto L42
            char r9 = r12[r8]
            if (r9 != r7) goto L3f
            if (r6 >= r2) goto L3c
            if (r8 >= r4) goto L3c
            boolean r9 = java.lang.Character.isHighSurrogate(r7)
            if (r9 == 0) goto L3c
            int r9 = r8 + 1
            char r9 = r12[r9]
            int r10 = r6 + 1
            char r10 = r11.charAt(r10)
            if (r9 != r10) goto L3f
        L3c:
            int r6 = r6 + 1
            goto L19
        L3f:
            int r8 = r8 + 1
            goto L20
        L42:
            return r6
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.indexOfAnyBut(java.lang.CharSequence, char[]):int");
    }

    public static int indexOfDifference(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return -1;
        }
        int i2 = 0;
        if (charSequence != null && charSequence2 != null) {
            while (i2 < charSequence.length() && i2 < charSequence2.length() && charSequence.charAt(i2) == charSequence2.charAt(i2)) {
                i2++;
            }
            if (i2 >= charSequence2.length() && i2 >= charSequence.length()) {
                return -1;
            }
        }
        return i2;
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return indexOfIgnoreCase(charSequence, charSequence2, 0);
    }

    public static boolean isAllBlank(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty(charSequenceArr)) {
            return true;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (isNotBlank(charSequence)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllEmpty(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty(charSequenceArr)) {
            return true;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (isNotEmpty(charSequence)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllLowerCase(CharSequence charSequence) {
        if (charSequence == null || isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isLowerCase(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllUpperCase(CharSequence charSequence) {
        if (charSequence == null || isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isUpperCase(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlpha(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isLetter(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphaSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isLetter(charSequence.charAt(i2)) && charSequence.charAt(i2) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumeric(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i2)) && charSequence.charAt(i2) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnyBlank(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty(charSequenceArr)) {
            return false;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (isBlank(charSequence)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAnyEmpty(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty(charSequenceArr)) {
            return false;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (isEmpty(charSequence)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAsciiPrintable(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!CharUtils.isAsciiPrintable(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBlank(CharSequence charSequence) {
        int length;
        if (charSequence != null && (length = charSequence.length()) != 0) {
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isWhitespace(charSequence.charAt(i2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isMixedCase(CharSequence charSequence) {
        if (!isEmpty(charSequence) && charSequence.length() != 1) {
            int length = charSequence.length();
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < length; i2++) {
                if (z && z2) {
                    return true;
                }
                if (Character.isUpperCase(charSequence.charAt(i2))) {
                    z = true;
                } else if (Character.isLowerCase(charSequence.charAt(i2))) {
                    z2 = true;
                }
            }
            if (z && z2) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNoneBlank(CharSequence... charSequenceArr) {
        return !isAnyBlank(charSequenceArr);
    }

    public static boolean isNoneEmpty(CharSequence... charSequenceArr) {
        return !isAnyEmpty(charSequenceArr);
    }

    public static boolean isNotBlank(CharSequence charSequence) {
        return !isBlank(charSequence);
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static boolean isNumeric(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isDigit(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isDigit(charSequence.charAt(i2)) && charSequence.charAt(i2) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static boolean isWhitespace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    @SafeVarargs
    public static <T> String join(T... tArr) {
        return join(tArr, (String) null);
    }

    public static String joinWith(String str, Object... objArr) {
        if (objArr == null) {
            throw new IllegalArgumentException("Object varargs must not be null");
        }
        String strDefaultString = defaultString(str, "");
        StringBuilder sb = new StringBuilder();
        Iterator it = Arrays.asList(objArr).iterator();
        while (it.hasNext()) {
            sb.append(Objects.toString(it.next(), ""));
            if (it.hasNext()) {
                sb.append(strDefaultString);
            }
        }
        return sb.toString();
    }

    public static int lastIndexOf(CharSequence charSequence, int i2) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, i2, charSequence.length());
    }

    public static int lastIndexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int iLastIndexOf;
        int i2 = -1;
        if (charSequence != null && charSequenceArr != null) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (charSequence2 != null && (iLastIndexOf = CharSequenceUtils.lastIndexOf(charSequence, charSequence2, charSequence.length())) > i2) {
                    i2 = iLastIndexOf;
                }
            }
        }
        return i2;
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return lastIndexOfIgnoreCase(charSequence, charSequence2, charSequence.length());
    }

    public static int lastOrdinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        return ordinalIndexOf(charSequence, charSequence2, i2, true);
    }

    public static String left(String str, int i2) {
        if (str == null) {
            return null;
        }
        return i2 < 0 ? "" : str.length() <= i2 ? str : str.substring(0, i2);
    }

    public static String leftPad(String str, int i2) {
        return leftPad(str, i2, ' ');
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static String lowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    private static int[] matches(CharSequence charSequence, CharSequence charSequence2) {
        CharSequence charSequence3;
        CharSequence charSequence4;
        if (charSequence.length() > charSequence2.length()) {
            charSequence4 = charSequence;
            charSequence3 = charSequence2;
        } else {
            charSequence3 = charSequence;
            charSequence4 = charSequence2;
        }
        int iMax = Math.max((charSequence4.length() / 2) - 1, 0);
        int[] iArr = new int[charSequence3.length()];
        Arrays.fill(iArr, -1);
        boolean[] zArr = new boolean[charSequence4.length()];
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence3.length(); i3++) {
            char cCharAt = charSequence3.charAt(i3);
            int iMax2 = Math.max(i3 - iMax, 0);
            int iMin = Math.min(i3 + iMax + 1, charSequence4.length());
            while (true) {
                if (iMax2 >= iMin) {
                    break;
                }
                if (!zArr[iMax2] && cCharAt == charSequence4.charAt(iMax2)) {
                    iArr[i3] = iMax2;
                    zArr[iMax2] = true;
                    i2++;
                    break;
                }
                iMax2++;
            }
        }
        char[] cArr = new char[i2];
        char[] cArr2 = new char[i2];
        int i4 = 0;
        for (int i5 = 0; i5 < charSequence3.length(); i5++) {
            if (iArr[i5] != -1) {
                cArr[i4] = charSequence3.charAt(i5);
                i4++;
            }
        }
        int i6 = 0;
        for (int i7 = 0; i7 < charSequence4.length(); i7++) {
            if (zArr[i7]) {
                cArr2[i6] = charSequence4.charAt(i7);
                i6++;
            }
        }
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            if (cArr[i9] != cArr2[i9]) {
                i8++;
            }
        }
        int i10 = 0;
        for (int i11 = 0; i11 < charSequence3.length() && charSequence.charAt(i11) == charSequence2.charAt(i11); i11++) {
            i10++;
        }
        return new int[]{i2, i8 / 2, i10, charSequence4.length()};
    }

    public static String mid(String str, int i2, int i3) {
        if (str == null) {
            return null;
        }
        if (i3 < 0 || i2 > str.length()) {
            return "";
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int i4 = i3 + i2;
        return str.length() <= i4 ? str.substring(i2) : str.substring(i2, i4);
    }

    public static String normalizeSpace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        boolean z = true;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = str.charAt(i4);
            if (Character.isWhitespace(cCharAt)) {
                if (i3 == 0 && !z) {
                    cArr[i2] = SPACE.charAt(0);
                    i2++;
                }
                i3++;
            } else {
                int i5 = i2 + 1;
                if (cCharAt == 160) {
                    cCharAt = ' ';
                }
                cArr[i2] = cCharAt;
                i3 = 0;
                i2 = i5;
                z = false;
            }
        }
        if (z) {
            return "";
        }
        return new String(cArr, 0, i2 - (i3 <= 0 ? 0 : 1)).trim();
    }

    public static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        return ordinalIndexOf(charSequence, charSequence2, i2, false);
    }

    public static String overlay(String str, String str2, int i2, int i3) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        int length = str.length();
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > length) {
            i2 = length;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 <= length) {
            length = i3;
        }
        if (i2 > length) {
            int i4 = length;
            length = i2;
            i2 = i4;
        }
        return str.substring(0, i2) + str2 + str.substring(length);
    }

    private static String prependIfMissing(String str, CharSequence charSequence, boolean z, CharSequence... charSequenceArr) {
        if (str == null || isEmpty(charSequence) || startsWith(str, charSequence, z)) {
            return str;
        }
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (startsWith(str, charSequence2, z)) {
                    return str;
                }
            }
        }
        return charSequence.toString() + str;
    }

    public static String prependIfMissingIgnoreCase(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return prependIfMissing(str, charSequence, true, charSequenceArr);
    }

    public static String remove(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : replace(str, str2, "", -1);
    }

    public static String removeAll(String str, String str2) {
        return replaceAll(str, str2, "");
    }

    public static String removeEnd(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !str.endsWith(str2)) ? str : str.substring(0, str.length() - str2.length());
    }

    public static String removeEndIgnoreCase(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !endsWithIgnoreCase(str, str2)) ? str : str.substring(0, str.length() - str2.length());
    }

    public static String removeFirst(String str, String str2) {
        return replaceFirst(str, str2, "");
    }

    public static String removeIgnoreCase(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : replaceIgnoreCase(str, str2, "", -1);
    }

    public static String removePattern(String str, String str2) {
        return replacePattern(str, str2, "");
    }

    public static String removeStart(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !str.startsWith(str2)) ? str : str.substring(str2.length());
    }

    public static String removeStartIgnoreCase(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2) || !startsWithIgnoreCase(str, str2)) ? str : str.substring(str2.length());
    }

    public static String repeat(String str, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 <= 0) {
            return "";
        }
        int length = str.length();
        if (i2 == 1 || length == 0) {
            return str;
        }
        if (length == 1 && i2 <= 8192) {
            return repeat(str.charAt(0), i2);
        }
        int i3 = length * i2;
        if (length == 1) {
            return repeat(str.charAt(0), i2);
        }
        if (length != 2) {
            StringBuilder sb = new StringBuilder(i3);
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(str);
            }
            return sb.toString();
        }
        char cCharAt = str.charAt(0);
        char cCharAt2 = str.charAt(1);
        char[] cArr = new char[i3];
        for (int i5 = (i2 * 2) - 2; i5 >= 0; i5 -= 2) {
            cArr[i5] = cCharAt;
            cArr[i5 + 1] = cCharAt2;
        }
        return new String(cArr);
    }

    public static String replace(String str, String str2, String str3) {
        return replace(str, str2, str3, -1);
    }

    public static String replaceAll(String str, String str2, String str3) {
        return (str == null || str2 == null || str3 == null) ? str : str.replaceAll(str2, str3);
    }

    public static String replaceChars(String str, char c2, char c3) {
        if (str == null) {
            return null;
        }
        return str.replace(c2, c3);
    }

    public static String replaceEach(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, false, 0);
    }

    public static String replaceEachRepeatedly(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, true, strArr == null ? 0 : strArr.length);
    }

    public static String replaceFirst(String str, String str2, String str3) {
        return (str == null || str2 == null || str3 == null) ? str : str.replaceFirst(str2, str3);
    }

    public static String replaceIgnoreCase(String str, String str2, String str3) {
        return replaceIgnoreCase(str, str2, str3, -1);
    }

    public static String replaceOnce(String str, String str2, String str3) {
        return replace(str, str2, str3, 1);
    }

    public static String replaceOnceIgnoreCase(String str, String str2, String str3) {
        return replaceIgnoreCase(str, str2, str3, 1);
    }

    public static String replacePattern(String str, String str2, String str3) {
        return (str == null || str2 == null || str3 == null) ? str : Pattern.compile(str2, 32).matcher(str).replaceAll(str3);
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseDelimited(String str, char c2) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = split(str, c2);
        ArrayUtils.reverse(strArrSplit);
        return join(strArrSplit, c2);
    }

    public static String right(String str, int i2) {
        if (str == null) {
            return null;
        }
        return i2 < 0 ? "" : str.length() <= i2 ? str : str.substring(str.length() - i2);
    }

    public static String rightPad(String str, int i2) {
        return rightPad(str, i2, ' ');
    }

    public static String rotate(String str, int i2) {
        int i3;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (i2 == 0 || length == 0 || (i3 = i2 % length) == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(length);
        int i4 = -i3;
        sb.append(substring(str, i4));
        sb.append(substring(str, 0, i4));
        return sb.toString();
    }

    public static String[] split(String str) {
        return split(str, null, -1);
    }

    public static String[] splitByCharacterType(String str) {
        return splitByCharacterType(str, false);
    }

    public static String[] splitByCharacterTypeCamelCase(String str) {
        return splitByCharacterType(str, true);
    }

    public static String[] splitByWholeSeparator(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, true);
    }

    private static String[] splitByWholeSeparatorWorker(String str, String str2, int i2, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        if (str2 == null || "".equals(str2)) {
            return splitWorker(str, null, i2, z);
        }
        int length2 = str2.length();
        ArrayList arrayList = new ArrayList();
        int iIndexOf = 0;
        int i3 = 0;
        int i4 = 0;
        while (iIndexOf < length) {
            iIndexOf = str.indexOf(str2, i3);
            if (iIndexOf > -1) {
                if (iIndexOf > i3) {
                    i4++;
                    if (i4 == i2) {
                        arrayList.add(str.substring(i3));
                    } else {
                        arrayList.add(str.substring(i3, iIndexOf));
                    }
                } else if (z) {
                    i4++;
                    if (i4 == i2) {
                        arrayList.add(str.substring(i3));
                        iIndexOf = length;
                    } else {
                        arrayList.add("");
                    }
                }
                i3 = iIndexOf + length2;
            } else {
                arrayList.add(str.substring(i3));
            }
            iIndexOf = length;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitPreserveAllTokens(String str) {
        return splitWorker(str, null, -1, true);
    }

    private static String[] splitWorker(String str, char c2, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i3 = 0;
        while (i2 < length) {
            if (str.charAt(i2) == c2) {
                if (z2 || z) {
                    arrayList.add(str.substring(i3, i2));
                    z2 = false;
                    z3 = true;
                }
                i3 = i2 + 1;
                i2 = i3;
            } else {
                i2++;
                z3 = false;
                z2 = true;
            }
        }
        if (z2 || (z && z3)) {
            arrayList.add(str.substring(i3, i2));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean startsWith(CharSequence charSequence, CharSequence charSequence2) {
        return startsWith(charSequence, charSequence2, false);
    }

    public static boolean startsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (startsWith(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean startsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return startsWith(charSequence, charSequence2, true);
    }

    public static String strip(String str) {
        return strip(str, null);
    }

    public static String stripAccents(String str) {
        if (str == null) {
            return null;
        }
        Pattern patternCompile = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        StringBuilder sb = new StringBuilder(Normalizer.normalize(str, Normalizer.Form.NFD));
        convertRemainingAccentCharacters(sb);
        return patternCompile.matcher(sb).replaceAll("");
    }

    public static String[] stripAll(String... strArr) {
        return stripAll(strArr, null);
    }

    public static String stripEnd(String str, String str2) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        if (str2 == null) {
            while (length != 0 && Character.isWhitespace(str.charAt(length - 1))) {
                length--;
            }
        } else {
            if (str2.isEmpty()) {
                return str;
            }
            while (length != 0 && str2.indexOf(str.charAt(length - 1)) != -1) {
                length--;
            }
        }
        return str.substring(0, length);
    }

    public static String stripStart(String str, String str2) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        int i2 = 0;
        if (str2 == null) {
            while (i2 != length && Character.isWhitespace(str.charAt(i2))) {
                i2++;
            }
        } else {
            if (str2.isEmpty()) {
                return str;
            }
            while (i2 != length && str2.indexOf(str.charAt(i2)) != -1) {
                i2++;
            }
        }
        return str.substring(i2);
    }

    public static String stripToEmpty(String str) {
        return str == null ? "" : strip(str, null);
    }

    public static String stripToNull(String str) {
        if (str == null) {
            return null;
        }
        String strStrip = strip(str, null);
        if (strStrip.isEmpty()) {
            return null;
        }
        return strStrip;
    }

    public static String substring(String str, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0) {
            i2 += str.length();
        }
        if (i2 < 0) {
            i2 = 0;
        }
        return i2 > str.length() ? "" : str.substring(i2);
    }

    public static String substringAfter(String str, String str2) {
        int iIndexOf;
        return isEmpty(str) ? str : (str2 == null || (iIndexOf = str.indexOf(str2)) == -1) ? "" : str.substring(str2.length() + iIndexOf);
    }

    public static String substringAfterLast(String str, String str2) {
        int iLastIndexOf;
        return isEmpty(str) ? str : (isEmpty(str2) || (iLastIndexOf = str.lastIndexOf(str2)) == -1 || iLastIndexOf == str.length() - str2.length()) ? "" : str.substring(str2.length() + iLastIndexOf);
    }

    public static String substringBefore(String str, String str2) {
        if (isEmpty(str) || str2 == null) {
            return str;
        }
        if (str2.isEmpty()) {
            return "";
        }
        int iIndexOf = str.indexOf(str2);
        return iIndexOf == -1 ? str : str.substring(0, iIndexOf);
    }

    public static String substringBeforeLast(String str, String str2) {
        int iLastIndexOf;
        return (isEmpty(str) || isEmpty(str2) || (iLastIndexOf = str.lastIndexOf(str2)) == -1) ? str : str.substring(0, iLastIndexOf);
    }

    public static String substringBetween(String str, String str2) {
        return substringBetween(str, str2, str2);
    }

    public static String[] substringsBetween(String str, String str2, String str3) {
        int iIndexOf;
        int i2;
        int iIndexOf2;
        if (str == null || isEmpty(str2) || isEmpty(str3)) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        int length2 = str3.length();
        int length3 = str2.length();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (i3 < length - length2 && (iIndexOf = str.indexOf(str2, i3)) >= 0 && (iIndexOf2 = str.indexOf(str3, (i2 = iIndexOf + length3))) >= 0) {
            arrayList.add(str.substring(i2, iIndexOf2));
            i3 = iIndexOf2 + length2;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String swapCase(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int[] iArr = new int[length];
        int iCharCount = 0;
        int i2 = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (Character.isUpperCase(iCodePointAt)) {
                iCodePointAt = Character.toLowerCase(iCodePointAt);
            } else if (Character.isTitleCase(iCodePointAt)) {
                iCodePointAt = Character.toLowerCase(iCodePointAt);
            } else if (Character.isLowerCase(iCodePointAt)) {
                iCodePointAt = Character.toUpperCase(iCodePointAt);
            }
            iArr[i2] = iCodePointAt;
            iCharCount += Character.charCount(iCodePointAt);
            i2++;
        }
        return new String(iArr, 0, i2);
    }

    public static int[] toCodePoints(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        if (charSequence.length() == 0) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        String string = charSequence.toString();
        int iCodePointCount = string.codePointCount(0, string.length());
        int[] iArr = new int[iCodePointCount];
        int iCharCount = 0;
        for (int i2 = 0; i2 < iCodePointCount; i2++) {
            int iCodePointAt = string.codePointAt(iCharCount);
            iArr[i2] = iCodePointAt;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return iArr;
    }

    public static String toEncodedString(byte[] bArr, Charset charset) {
        if (charset == null) {
            charset = Charset.defaultCharset();
        }
        return new String(bArr, charset);
    }

    @Deprecated
    public static String toString(byte[] bArr, String str) throws UnsupportedEncodingException {
        return str != null ? new String(bArr, str) : new String(bArr, Charset.defaultCharset());
    }

    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    public static String trimToNull(String str) {
        String strTrim = trim(str);
        if (isEmpty(strTrim)) {
            return null;
        }
        return strTrim;
    }

    public static String truncate(String str, int i2) {
        return truncate(str, 0, i2);
    }

    public static String uncapitalize(String str) {
        int length;
        int iCodePointAt;
        int lowerCase;
        if (str == null || (length = str.length()) == 0 || iCodePointAt == (lowerCase = Character.toLowerCase((iCodePointAt = str.codePointAt(0))))) {
            return str;
        }
        int[] iArr = new int[length];
        iArr[0] = lowerCase;
        int iCharCount = Character.charCount(iCodePointAt);
        int i2 = 1;
        while (iCharCount < length) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            iArr[i2] = iCodePointAt2;
            iCharCount += Character.charCount(iCodePointAt2);
            i2++;
        }
        return new String(iArr, 0, i2);
    }

    public static String unwrap(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2) || !startsWith(str, str2) || !endsWith(str, str2)) {
            return str;
        }
        int iIndexOf = str.indexOf(str2);
        int iLastIndexOf = str.lastIndexOf(str2);
        return (iIndexOf == -1 || iLastIndexOf == -1) ? str : str.substring(iIndexOf + str2.length(), iLastIndexOf);
    }

    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public static String wrap(String str, char c2) {
        if (isEmpty(str) || c2 == 0) {
            return str;
        }
        return c2 + str + c2;
    }

    public static String wrapIfMissing(String str, char c2) {
        if (isEmpty(str) || c2 == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        if (str.charAt(0) != c2) {
            sb.append(c2);
        }
        sb.append(str);
        if (str.charAt(str.length() - 1) != c2) {
            sb.append(c2);
        }
        return sb.toString();
    }

    public static String abbreviate(String str, int i2, int i3) {
        return abbreviate(str, "...", i2, i3);
    }

    public static String center(String str, int i2, char c2) {
        int length;
        int length2;
        return (str == null || i2 <= 0 || (length2 = i2 - (length = str.length())) <= 0) ? str : rightPad(leftPad(str, (length2 / 2) + length, c2), i2, c2);
    }

    public static int compare(String str, String str2, boolean z) {
        if (str == str2) {
            return 0;
        }
        return str == null ? z ? -1 : 1 : str2 == null ? z ? 1 : -1 : str.compareTo(str2);
    }

    public static int compareIgnoreCase(String str, String str2, boolean z) {
        if (str == str2) {
            return 0;
        }
        return str == null ? z ? -1 : 1 : str2 == null ? z ? 1 : -1 : str.compareToIgnoreCase(str2);
    }

    public static String defaultString(String str) {
        return str == null ? "" : str;
    }

    private static boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == null && charSequence2 == null;
        }
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        return CharSequenceUtils.regionMatches(charSequence, z, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length());
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i2) {
        if (charSequence != null && charSequence2 != null) {
            if (i2 < 0) {
                i2 = 0;
            }
            int length = (charSequence.length() - charSequence2.length()) + 1;
            if (i2 > length) {
                return -1;
            }
            if (charSequence2.length() == 0) {
                return i2;
            }
            int i3 = i2;
            while (i3 < length) {
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                if (CharSequenceUtils.regionMatches(charSequence3, true, i3, charSequence4, 0, charSequence2.length())) {
                    return i3;
                }
                i3++;
                charSequence = charSequence3;
                charSequence2 = charSequence4;
            }
        }
        return -1;
    }

    public static String join(Object[] objArr, char c2) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, c2, 0, objArr.length);
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i2) {
        if (charSequence != null && charSequence2 != null) {
            if (i2 > charSequence.length() - charSequence2.length()) {
                i2 = charSequence.length() - charSequence2.length();
            }
            if (i2 < 0) {
                return -1;
            }
            if (charSequence2.length() == 0) {
                return i2;
            }
            int i3 = i2;
            while (i3 >= 0) {
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                if (CharSequenceUtils.regionMatches(charSequence3, true, i3, charSequence4, 0, charSequence2.length())) {
                    return i3;
                }
                i3--;
                charSequence = charSequence3;
                charSequence2 = charSequence4;
            }
        }
        return -1;
    }

    public static String leftPad(String str, int i2, char c2) {
        if (str == null) {
            return null;
        }
        int length = i2 - str.length();
        return length <= 0 ? str : length > 8192 ? leftPad(str, i2, String.valueOf(c2)) : repeat(c2, length).concat(str);
    }

    public static String lowerCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(locale);
    }

    private static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i2, boolean z) {
        if (charSequence != null && charSequence2 != null && i2 > 0) {
            int i3 = 0;
            if (charSequence2.length() == 0) {
                if (z) {
                    return charSequence.length();
                }
                return 0;
            }
            length = z ? charSequence.length() : -1;
            do {
                length = z ? CharSequenceUtils.lastIndexOf(charSequence, charSequence2, length - 1) : CharSequenceUtils.indexOf(charSequence, charSequence2, length + 1);
                if (length < 0) {
                    break;
                }
                i3++;
            } while (i3 < i2);
        }
        return length;
    }

    public static String replace(String str, String str2, String str3, int i2) {
        return replace(str, str2, str3, i2, false);
    }

    public static String replaceChars(String str, String str2, String str3) {
        if (isEmpty(str) || isEmpty(str2)) {
            return str;
        }
        if (str3 == null) {
            str3 = "";
        }
        int length = str3.length();
        int length2 = str.length();
        StringBuilder sb = new StringBuilder(length2);
        boolean z = false;
        for (int i2 = 0; i2 < length2; i2++) {
            char cCharAt = str.charAt(i2);
            int iIndexOf = str2.indexOf(cCharAt);
            if (iIndexOf >= 0) {
                if (iIndexOf < length) {
                    sb.append(str3.charAt(iIndexOf));
                }
                z = true;
            } else {
                sb.append(cCharAt);
            }
        }
        return z ? sb.toString() : str;
    }

    private static String replaceEach(String str, String[] strArr, String[] strArr2, boolean z, int i2) {
        String str2;
        String str3;
        int length;
        String str4;
        if (str == null || str.isEmpty() || strArr == null || strArr.length == 0 || strArr2 == null || strArr2.length == 0) {
            return str;
        }
        if (i2 < 0) {
            throw new IllegalStateException("Aborting to protect against StackOverflowError - output of one loop is the input of another");
        }
        int length2 = strArr.length;
        int length3 = strArr2.length;
        if (length2 != length3) {
            throw new IllegalArgumentException(b.d(length2, length3, "Search and Replace array lengths don't match: ", " vs "));
        }
        boolean[] zArr = new boolean[length2];
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < length2; i5++) {
            if (!zArr[i5] && (str4 = strArr[i5]) != null && !str4.isEmpty() && strArr2[i5] != null) {
                int iIndexOf = str.indexOf(strArr[i5]);
                if (iIndexOf == -1) {
                    zArr[i5] = true;
                } else if (i3 == -1 || iIndexOf < i3) {
                    i4 = i5;
                    i3 = iIndexOf;
                }
            }
        }
        if (i3 == -1) {
            return str;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < strArr.length; i7++) {
            if (strArr[i7] != null && (str3 = strArr2[i7]) != null && (length = str3.length() - strArr[i7].length()) > 0) {
                i6 += length * 3;
            }
        }
        StringBuilder sb = new StringBuilder(str.length() + Math.min(i6, str.length() / 5));
        int length4 = 0;
        while (i3 != -1) {
            while (length4 < i3) {
                sb.append(str.charAt(length4));
                length4++;
            }
            sb.append(strArr2[i4]);
            length4 = strArr[i4].length() + i3;
            i3 = -1;
            i4 = -1;
            for (int i8 = 0; i8 < length2; i8++) {
                if (!zArr[i8] && (str2 = strArr[i8]) != null && !str2.isEmpty() && strArr2[i8] != null) {
                    int iIndexOf2 = str.indexOf(strArr[i8], length4);
                    if (iIndexOf2 == -1) {
                        zArr[i8] = true;
                    } else if (i3 == -1 || iIndexOf2 < i3) {
                        i4 = i8;
                        i3 = iIndexOf2;
                    }
                }
            }
        }
        int length5 = str.length();
        while (length4 < length5) {
            sb.append(str.charAt(length4));
            length4++;
        }
        String string = sb.toString();
        return !z ? string : replaceEach(string, strArr, strArr2, z, i2 - 1);
    }

    public static String replaceIgnoreCase(String str, String str2, String str3, int i2) {
        return replace(str, str2, str3, i2, true);
    }

    public static String rightPad(String str, int i2, char c2) {
        if (str == null) {
            return null;
        }
        int length = i2 - str.length();
        return length <= 0 ? str : length > 8192 ? rightPad(str, i2, String.valueOf(c2)) : str.concat(repeat(c2, length));
    }

    public static String[] split(String str, char c2) {
        return splitWorker(str, c2, false);
    }

    private static String[] splitByCharacterType(String str, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int type = Character.getType(charArray[0]);
        for (int i3 = 1; i3 < charArray.length; i3++) {
            int type2 = Character.getType(charArray[i3]);
            if (type2 != type) {
                if (z && type2 == 2 && type == 1) {
                    int i4 = i3 - 1;
                    if (i4 != i2) {
                        arrayList.add(new String(charArray, i2, i4 - i2));
                        i2 = i4;
                    }
                } else {
                    arrayList.add(new String(charArray, i2, i3 - i2));
                    i2 = i3;
                }
                type = type2;
            }
        }
        arrayList.add(new String(charArray, i2, charArray.length - i2));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] splitByWholeSeparator(String str, String str2, int i2) {
        return splitByWholeSeparatorWorker(str, str2, i2, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2, int i2) {
        return splitByWholeSeparatorWorker(str, str2, i2, true);
    }

    public static String[] splitPreserveAllTokens(String str, char c2) {
        return splitWorker(str, c2, true);
    }

    private static boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == null && charSequence2 == null;
        }
        if (charSequence2.length() > charSequence.length()) {
            return false;
        }
        return CharSequenceUtils.regionMatches(charSequence, z, 0, charSequence2, 0, charSequence2.length());
    }

    public static String strip(String str, String str2) {
        return isEmpty(str) ? str : stripEnd(stripStart(str, str2), str2);
    }

    public static String[] stripAll(String[] strArr, String str) {
        int length;
        if (strArr == null || (length = strArr.length) == 0) {
            return strArr;
        }
        String[] strArr2 = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            strArr2[i2] = strip(strArr[i2], str);
        }
        return strArr2;
    }

    public static String substringBetween(String str, String str2, String str3) {
        int iIndexOf;
        int iIndexOf2;
        if (str == null || str2 == null || str3 == null || (iIndexOf = str.indexOf(str2)) == -1 || (iIndexOf2 = str.indexOf(str3, str2.length() + iIndexOf)) == -1) {
            return null;
        }
        return str.substring(str2.length() + iIndexOf, iIndexOf2);
    }

    public static String truncate(String str, int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("offset cannot be negative");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("maxWith cannot be negative");
        }
        if (str == null) {
            return null;
        }
        if (i2 > str.length()) {
            return "";
        }
        if (str.length() <= i3) {
            return str.substring(i2);
        }
        int length = i3 + i2;
        if (length > str.length()) {
            length = str.length();
        }
        return str.substring(i2, length);
    }

    public static String upperCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(locale);
    }

    public static String abbreviate(String str, String str2, int i2) {
        return abbreviate(str, str2, 0, i2);
    }

    public static boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return (charSequence == null || charSequence2 == null || CharSequenceUtils.indexOf(charSequence, charSequence2, 0) < 0) ? false : true;
    }

    public static int indexOf(CharSequence charSequence, int i2, int i3) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, i2, i3);
    }

    public static String join(long[] jArr, char c2) {
        if (jArr == null) {
            return null;
        }
        return join(jArr, c2, 0, jArr.length);
    }

    public static int lastIndexOf(CharSequence charSequence, int i2, int i3) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, i2, i3);
    }

    public static String remove(String str, char c2) {
        if (isEmpty(str) || str.indexOf(c2) == -1) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i2 = 0;
        for (char c3 : charArray) {
            if (c3 != c2) {
                charArray[i2] = c3;
                i2++;
            }
        }
        return new String(charArray, 0, i2);
    }

    private static String replace(String str, String str2, String str3, int i2, boolean z) {
        String lowerCase;
        int i3;
        if (isEmpty(str) || isEmpty(str2) || str3 == null || i2 == 0) {
            return str;
        }
        if (z) {
            lowerCase = str.toLowerCase();
            str2 = str2.toLowerCase();
        } else {
            lowerCase = str;
        }
        int i4 = 0;
        int iIndexOf = lowerCase.indexOf(str2, 0);
        if (iIndexOf == -1) {
            return str;
        }
        int length = str2.length();
        int length2 = str3.length() - length;
        if (length2 < 0) {
            length2 = 0;
        }
        if (i2 < 0) {
            i3 = 16;
        } else {
            i3 = 64;
            if (i2 <= 64) {
                i3 = i2;
            }
        }
        StringBuilder sb = new StringBuilder(str.length() + (length2 * i3));
        while (iIndexOf != -1) {
            sb.append((CharSequence) str, i4, iIndexOf);
            sb.append(str3);
            i4 = iIndexOf + length;
            i2--;
            if (i2 == 0) {
                break;
            }
            iIndexOf = lowerCase.indexOf(str2, i4);
        }
        sb.append((CharSequence) str, i4, str.length());
        return sb.toString();
    }

    public static String[] split(String str, String str2) {
        return splitWorker(str, str2, -1, false);
    }

    public static String[] splitPreserveAllTokens(String str, String str2) {
        return splitWorker(str, str2, -1, true);
    }

    public static String wrap(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : str2.concat(str).concat(str2);
    }

    public static String abbreviate(String str, String str2, int i2, int i3) {
        if (isEmpty(str) || isEmpty(str2)) {
            return str;
        }
        int length = str2.length();
        int i4 = length + 1;
        int i5 = length + length + 1;
        if (i3 >= i4) {
            if (str.length() <= i3) {
                return str;
            }
            if (i2 > str.length()) {
                i2 = str.length();
            }
            int i6 = i3 - length;
            if (str.length() - i2 < i6) {
                i2 = str.length() - i6;
            }
            if (i2 <= i4) {
                return str.substring(0, i6) + str2;
            }
            if (i3 >= i5) {
                if ((i3 + i2) - length < str.length()) {
                    StringBuilder sbW = b.w(str2);
                    sbW.append(abbreviate(str.substring(i2), str2, i6));
                    return sbW.toString();
                }
                StringBuilder sbW2 = b.w(str2);
                sbW2.append(str.substring(str.length() - i6));
                return sbW2.toString();
            }
            throw new IllegalArgumentException(String.format("Minimum abbreviation width with offset is %d", Integer.valueOf(i5)));
        }
        throw new IllegalArgumentException(String.format("Minimum abbreviation width is %d", Integer.valueOf(i4)));
    }

    public static boolean containsOnly(CharSequence charSequence, String str) {
        if (charSequence == null || str == null) {
            return false;
        }
        return containsOnly(charSequence, str.toCharArray());
    }

    public static int countMatches(CharSequence charSequence, char c2) {
        if (isEmpty(charSequence)) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (c2 == charSequence.charAt(i3)) {
                i2++;
            }
        }
        return i2;
    }

    public static int indexOfDifference(CharSequence... charSequenceArr) {
        if (charSequenceArr != null && charSequenceArr.length > 1) {
            int length = charSequenceArr.length;
            int iMin = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            boolean z = true;
            int iMax = 0;
            boolean z2 = false;
            for (CharSequence charSequence : charSequenceArr) {
                if (charSequence == null) {
                    z2 = true;
                    iMin = 0;
                } else {
                    iMin = Math.min(charSequence.length(), iMin);
                    iMax = Math.max(charSequence.length(), iMax);
                    z = false;
                }
            }
            if (!z && (iMax != 0 || z2)) {
                if (iMin == 0) {
                    return 0;
                }
                int i2 = -1;
                for (int i3 = 0; i3 < iMin; i3++) {
                    char cCharAt = charSequenceArr[0].charAt(i3);
                    int i4 = 1;
                    while (true) {
                        if (i4 >= length) {
                            break;
                        }
                        if (charSequenceArr[i4].charAt(i3) != cCharAt) {
                            i2 = i3;
                            break;
                        }
                        i4++;
                    }
                    if (i2 != -1) {
                        break;
                    }
                }
                return (i2 != -1 || iMin == iMax) ? i2 : iMin;
            }
        }
        return -1;
    }

    public static String join(int[] iArr, char c2) {
        if (iArr == null) {
            return null;
        }
        return join(iArr, c2, 0, iArr.length);
    }

    public static String[] split(String str, String str2, int i2) {
        return splitWorker(str, str2, i2, false);
    }

    public static String[] splitPreserveAllTokens(String str, String str2, int i2) {
        return splitWorker(str, str2, i2, true);
    }

    public static String center(String str, int i2, String str2) {
        if (str == null || i2 <= 0) {
            return str;
        }
        if (isEmpty(str2)) {
            str2 = SPACE;
        }
        int length = str.length();
        int i3 = i2 - length;
        return i3 <= 0 ? str : rightPad(leftPad(str, (i3 / 2) + length, str2), i2, str2);
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, charSequence2, 0);
    }

    public static String join(short[] sArr, char c2) {
        if (sArr == null) {
            return null;
        }
        return join(sArr, c2, 0, sArr.length);
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, charSequence2, charSequence.length());
    }

    public static String leftPad(String str, int i2, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = SPACE;
        }
        int length = str2.length();
        int length2 = i2 - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return leftPad(str, i2, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i3 = 0; i3 < length2; i3++) {
            cArr[i3] = charArray[i3 % length];
        }
        return new String(cArr).concat(str);
    }

    public static String rightPad(String str, int i2, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = SPACE;
        }
        int length = str2.length();
        int length2 = i2 - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return rightPad(str, i2, str2.charAt(0));
        }
        if (length2 == length) {
            return str.concat(str2);
        }
        if (length2 < length) {
            return str.concat(str2.substring(0, length2));
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i3 = 0; i3 < length2; i3++) {
            cArr[i3] = charArray[i3 % length];
        }
        return str.concat(new String(cArr));
    }

    public static String substring(String str, int i2, int i3) {
        if (str == null) {
            return null;
        }
        if (i3 < 0) {
            i3 += str.length();
        }
        if (i2 < 0) {
            i2 += str.length();
        }
        if (i3 > str.length()) {
            i3 = str.length();
        }
        if (i2 > i3) {
            return "";
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        return str.substring(i2, i3);
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, charSequence2, i2);
    }

    public static String join(byte[] bArr, char c2) {
        if (bArr == null) {
            return null;
        }
        return join(bArr, c2, 0, bArr.length);
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, charSequence2, i2);
    }

    public static String prependIfMissing(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return prependIfMissing(str, charSequence, false, charSequenceArr);
    }

    public static boolean containsNone(CharSequence charSequence, String str) {
        if (charSequence == null || str == null) {
            return true;
        }
        return containsNone(charSequence, str.toCharArray());
    }

    public static String join(char[] cArr, char c2) {
        if (cArr == null) {
            return null;
        }
        return join(cArr, c2, 0, cArr.length);
    }

    public static String unwrap(String str, char c2) {
        int length;
        return (isEmpty(str) || c2 == 0 || str.charAt(0) != c2 || str.charAt(str.length() - 1) != c2 || (length = str.length() - 1) == -1) ? str : str.substring(1, length);
    }

    public static boolean containsAny(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2 == null) {
            return false;
        }
        return containsAny(charSequence, CharSequenceUtils.toCharArray(charSequence2));
    }

    public static int indexOfAny(CharSequence charSequence, String str) {
        if (isEmpty(charSequence) || isEmpty(str)) {
            return -1;
        }
        return indexOfAny(charSequence, str.toCharArray());
    }

    public static int indexOfAnyBut(CharSequence charSequence, CharSequence charSequence2) {
        if (!isEmpty(charSequence) && !isEmpty(charSequence2)) {
            int length = charSequence.length();
            int i2 = 0;
            while (i2 < length) {
                char cCharAt = charSequence.charAt(i2);
                boolean z = CharSequenceUtils.indexOf(charSequence2, cCharAt, 0) >= 0;
                int i3 = i2 + 1;
                if (i3 < length && Character.isHighSurrogate(cCharAt)) {
                    char cCharAt2 = charSequence.charAt(i3);
                    if (z && CharSequenceUtils.indexOf(charSequence2, cCharAt2, 0) < 0) {
                        return i2;
                    }
                    i2 = i3;
                } else {
                    if (!z) {
                        return i2;
                    }
                    i2 = i3;
                }
            }
        }
        return -1;
    }

    public static String join(float[] fArr, char c2) {
        if (fArr == null) {
            return null;
        }
        return join(fArr, c2, 0, fArr.length);
    }

    private static String[] splitWorker(String str, String str2, int i2, boolean z) {
        int i3;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        boolean z4;
        boolean z5;
        int i6;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        if (str2 == null) {
            i5 = 0;
            z4 = false;
            z5 = false;
            i6 = 0;
            int i7 = 1;
            while (i5 < length) {
                if (Character.isWhitespace(str.charAt(i5))) {
                    if (z4 || z) {
                        int i8 = i7 + 1;
                        if (i7 == i2) {
                            i5 = length;
                            z5 = false;
                        } else {
                            z5 = true;
                        }
                        arrayList.add(str.substring(i6, i5));
                        i7 = i8;
                        z4 = false;
                    }
                    i6 = i5 + 1;
                    i5 = i6;
                } else {
                    i5++;
                    z5 = false;
                    z4 = true;
                }
            }
        } else {
            if (str2.length() == 1) {
                char cCharAt = str2.charAt(0);
                i3 = 0;
                z2 = false;
                z3 = false;
                i4 = 0;
                int i9 = 1;
                while (i3 < length) {
                    if (str.charAt(i3) == cCharAt) {
                        if (z2 || z) {
                            int i10 = i9 + 1;
                            if (i9 == i2) {
                                i3 = length;
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            arrayList.add(str.substring(i4, i3));
                            i9 = i10;
                            z2 = false;
                        }
                        i4 = i3 + 1;
                        i3 = i4;
                    } else {
                        i3++;
                        z3 = false;
                        z2 = true;
                    }
                }
            } else {
                i3 = 0;
                z2 = false;
                z3 = false;
                i4 = 0;
                int i11 = 1;
                while (i3 < length) {
                    if (str2.indexOf(str.charAt(i3)) >= 0) {
                        if (z2 || z) {
                            int i12 = i11 + 1;
                            if (i11 == i2) {
                                i3 = length;
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            arrayList.add(str.substring(i4, i3));
                            i11 = i12;
                            z2 = false;
                        }
                        i4 = i3 + 1;
                        i3 = i4;
                    } else {
                        i3++;
                        z3 = false;
                        z2 = true;
                    }
                }
            }
            i5 = i3;
            z4 = z2;
            z5 = z3;
            i6 = i4;
        }
        if (z4 || (z && z5)) {
            arrayList.add(str.substring(i6, i5));
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Deprecated
    public static String chomp(String str, String str2) {
        return removeEnd(str, str2);
    }

    public static boolean containsAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(charSequenceArr)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (contains(charSequence, charSequence2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String join(double[] dArr, char c2) {
        if (dArr == null) {
            return null;
        }
        return join(dArr, c2, 0, dArr.length);
    }

    public static String wrapIfMissing(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str2.length() + str2.length() + str.length());
        if (!str.startsWith(str2)) {
            sb.append(str2);
        }
        sb.append(str);
        if (!str.endsWith(str2)) {
            sb.append(str2);
        }
        return sb.toString();
    }

    public static String appendIfMissing(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return appendIfMissing(str, charSequence, false, charSequenceArr);
    }

    public static int indexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int iIndexOf;
        if (charSequence == null || charSequenceArr == null) {
            return -1;
        }
        int i2 = Integer.MAX_VALUE;
        for (CharSequence charSequence2 : charSequenceArr) {
            if (charSequence2 != null && (iIndexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, 0)) != -1 && iIndexOf < i2) {
                i2 = iIndexOf;
            }
        }
        if (i2 == Integer.MAX_VALUE) {
            return -1;
        }
        return i2;
    }

    public static String join(Object[] objArr, char c2, int i2, int i3) {
        if (objArr == null) {
            return null;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(c2);
            }
            Object obj = objArr[i5];
            if (obj != null) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    @Deprecated
    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2, int i2) {
        int i3;
        int length;
        CharSequence charSequence3;
        CharSequence charSequence4;
        int i4;
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        if (i2 >= 0) {
            int length2 = charSequence.length();
            int length3 = charSequence2.length();
            int i5 = -1;
            if (length2 == 0) {
                if (length3 <= i2) {
                    return length3;
                }
                return -1;
            }
            if (length3 == 0) {
                if (length2 <= i2) {
                    return length2;
                }
                return -1;
            }
            if (Math.abs(length2 - length3) > i2) {
                return -1;
            }
            if (length2 > length3) {
                length = charSequence.length();
                i3 = length3;
                charSequence4 = charSequence;
                charSequence3 = charSequence2;
            } else {
                i3 = length2;
                length = length3;
                charSequence3 = charSequence;
                charSequence4 = charSequence2;
            }
            int i6 = i3 + 1;
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            int i7 = 1;
            int iMin = Math.min(i3, i2) + 1;
            for (int i8 = 0; i8 < iMin; i8++) {
                iArr[i8] = i8;
            }
            Arrays.fill(iArr, iMin, i6, Api.BaseClientBuilder.API_PRIORITY_OTHER);
            Arrays.fill(iArr2, Api.BaseClientBuilder.API_PRIORITY_OTHER);
            int i9 = 1;
            while (i9 <= length) {
                char cCharAt = charSequence4.charAt(i9 - 1);
                iArr2[0] = i9;
                int iMax = Math.max(i7, i9 - i2);
                int iMin2 = i9 > Api.BaseClientBuilder.API_PRIORITY_OTHER - i2 ? i3 : Math.min(i3, i9 + i2);
                if (iMax > iMin2) {
                    return i5;
                }
                if (iMax > i7) {
                    iArr2[iMax - 1] = Integer.MAX_VALUE;
                }
                while (iMax <= iMin2) {
                    int i10 = iMax - 1;
                    int i11 = i5;
                    if (charSequence3.charAt(i10) == cCharAt) {
                        iArr2[iMax] = iArr[i10];
                        i4 = i7;
                    } else {
                        i4 = i7;
                        iArr2[iMax] = Math.min(Math.min(iArr2[i10], iArr[iMax]), iArr[i10]) + 1;
                    }
                    iMax++;
                    i7 = i4;
                    i5 = i11;
                }
                int i12 = i5;
                i9++;
                int[] iArr3 = iArr2;
                iArr2 = iArr;
                iArr = iArr3;
                i5 = i12;
            }
            int i13 = i5;
            int i14 = iArr[i3];
            return i14 <= i2 ? i14 : i13;
        }
        throw new IllegalArgumentException("Threshold must not be negative");
    }

    public static String repeat(String str, String str2, int i2) {
        if (str != null && str2 != null) {
            return removeEnd(repeat(str.concat(str2), i2), str2);
        }
        return repeat(str, i2);
    }

    public static String join(long[] jArr, char c2, int i2, int i3) {
        if (jArr == null) {
            return null;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(c2);
            }
            sb.append(jArr[i5]);
        }
        return sb.toString();
    }

    public static String repeat(char c2, int i2) {
        if (i2 <= 0) {
            return "";
        }
        char[] cArr = new char[i2];
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            cArr[i3] = c2;
        }
        return new String(cArr);
    }

    public static String join(int[] iArr, char c2, int i2, int i3) {
        if (iArr == null) {
            return null;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(c2);
            }
            sb.append(iArr[i5]);
        }
        return sb.toString();
    }

    public static String join(byte[] bArr, char c2, int i2, int i3) {
        if (bArr == null) {
            return null;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(c2);
            }
            sb.append((int) bArr[i5]);
        }
        return sb.toString();
    }

    public static String join(short[] sArr, char c2, int i2, int i3) {
        if (sArr == null) {
            return null;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(c2);
            }
            sb.append((int) sArr[i5]);
        }
        return sb.toString();
    }

    public static String join(char[] cArr, char c2, int i2, int i3) {
        if (cArr == null) {
            return null;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(c2);
            }
            sb.append(cArr[i5]);
        }
        return sb.toString();
    }

    public static String join(double[] dArr, char c2, int i2, int i3) {
        if (dArr == null) {
            return null;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(c2);
            }
            sb.append(dArr[i5]);
        }
        return sb.toString();
    }

    public static String join(float[] fArr, char c2, int i2, int i3) {
        if (fArr == null) {
            return null;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(c2);
            }
            sb.append(fArr[i5]);
        }
        return sb.toString();
    }

    public static String join(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, str, 0, objArr.length);
    }

    public static String join(Object[] objArr, String str, int i2, int i3) {
        if (objArr == null) {
            return null;
        }
        if (str == null) {
            str = "";
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i4 * 16);
        for (int i5 = i2; i5 < i3; i5++) {
            if (i5 > i2) {
                sb.append(str);
            }
            Object obj = objArr[i5];
            if (obj != null) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    public static String join(Iterator<?> it, char c2) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return Objects.toString(next, "");
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            sb.append(c2);
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }

    public static String join(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return Objects.toString(next, "");
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                sb.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }

    public static String join(Iterable<?> iterable, char c2) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), c2);
    }

    public static String join(Iterable<?> iterable, String str) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), str);
    }
}
