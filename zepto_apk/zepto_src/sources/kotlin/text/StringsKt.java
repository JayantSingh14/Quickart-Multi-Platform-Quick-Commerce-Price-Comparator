package kotlin.text;

import com.brentvatne.common.react.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SlidingWindowKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes.dex */
public final class StringsKt extends StringsKt___StringsKt {
    private StringsKt() {
    }

    public static char A(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(v(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static int B(CharSequence charSequence, char c2, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i2 = v(charSequence);
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(c2, i2);
        }
        char[] chars = {c2};
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (charSequence instanceof String) {
            return ((String) charSequence).lastIndexOf(ArraysKt.D(chars), i2);
        }
        int iV = v(charSequence);
        if (i2 > iV) {
            i2 = iV;
        }
        while (-1 < i2) {
            if (CharsKt.a(chars[0], charSequence.charAt(i2), false)) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static int C(CharSequence charSequence, String string, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i2 = v(charSequence);
        }
        int i4 = i2;
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        return !(charSequence instanceof String) ? StringsKt__StringsKt.e(charSequence, string, i4, 0, false, true) : ((String) charSequence).lastIndexOf(string, i4);
    }

    public static String D(int i2, String str) {
        CharSequence charSequenceSubSequence;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.b.g(i2, "Desired length ", " is less than zero."));
        }
        if (i2 <= str.length()) {
            charSequenceSubSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb = new StringBuilder(i2);
            int length = i2 - str.length();
            int i3 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append('0');
                    if (i3 == length) {
                        break;
                    }
                    i3++;
                }
            }
            sb.append((CharSequence) str);
            charSequenceSubSequence = sb;
        }
        return charSequenceSubSequence.toString();
    }

    public static boolean E(int i2, int i3, int i4, String str, String other, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return !z ? str.regionMatches(i2, other, i3, i4) : str.regionMatches(z, i2, other, i3, i4);
    }

    public static String F(String str, String prefix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!StringsKt__StringsKt.j(str, prefix)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String G(String str, String suffix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (!StringsKt__StringsKt.b(str, suffix)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - suffix.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String H(String str, String suffix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "delimiter");
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (str.length() < suffix.length() + suffix.length() || !StringsKt__StringsKt.j(str, suffix) || !StringsKt__StringsKt.b(str, suffix)) {
            return str;
        }
        String strSubstring = str.substring(suffix.length(), str.length() - suffix.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String I(String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i2 + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
        }
        if (i2 == 0) {
            return "";
        }
        int i3 = 1;
        if (i2 == 1) {
            return str.toString();
        }
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = str.charAt(0);
            char[] cArr = new char[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                cArr[i4] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(str.length() * i2);
        if (1 <= i2) {
            while (true) {
                sb.append((CharSequence) str);
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
        }
        String string = sb.toString();
        Intrinsics.c(string);
        return string;
    }

    public static String J(String str, char c2, char c3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String strReplace = str.replace(c2, c3);
        Intrinsics.checkNotNullExpressionValue(strReplace, "replace(...)");
        return strReplace;
    }

    public static String K(String str, String oldValue, String newValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        int iD = StringsKt__StringsKt.d(0, str, oldValue, false);
        if (iD < 0) {
            return str;
        }
        int length = oldValue.length();
        int i2 = length >= 1 ? length : 1;
        int length2 = newValue.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i3 = 0;
        do {
            sb.append((CharSequence) str, i3, iD);
            sb.append(newValue);
            i3 = iD + length;
            if (iD >= str.length()) {
                break;
            }
            iD = StringsKt__StringsKt.d(iD + i2, str, oldValue, false);
        } while (iD > 0);
        sb.append((CharSequence) str, i3, str.length());
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static List M(String str, final char[] delimiters) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return StringsKt__StringsKt.i(0, str, String.valueOf(delimiters[0]), false);
        }
        StringsKt__StringsKt.h(0);
        DelimitedRangesSequence delimitedRangesSequence = new DelimitedRangesSequence(str, 0, new Function2() { // from class: kotlin.text.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                CharSequence DelimitedRangesSequence = (CharSequence) obj;
                int iIntValue = ((Integer) obj2).intValue();
                Intrinsics.checkNotNullParameter(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
                int iF = StringsKt__StringsKt.f(DelimitedRangesSequence, delimiters, iIntValue, false);
                if (iF < 0) {
                    return null;
                }
                return new Pair(Integer.valueOf(iF), 1);
            }
        });
        Intrinsics.checkNotNullParameter(delimitedRangesSequence, "<this>");
        SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 = new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(delimitedRangesSequence);
        ArrayList arrayList = new ArrayList(CollectionsKt.r(sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1, 10));
        Iterator<Object> it = sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1.iterator();
        while (it.hasNext()) {
            IntRange range = (IntRange) it.next();
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(range, "range");
            arrayList.add(str.subSequence(range.f53838a, range.f53839b + 1).toString());
        }
        return arrayList;
    }

    public static boolean N(String str, int i2, String prefix, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return !z ? str.startsWith(prefix, i2) : E(i2, 0, prefix.length(), str, prefix, z);
    }

    public static boolean O(String str, String prefix, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return !z ? str.startsWith(prefix) : E(0, 0, prefix.length(), str, prefix, z);
    }

    public static boolean P(int i2, String str, String prefix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return (str == null || prefix == null) ? StringsKt__StringsKt.g(str, i2, prefix, 0, prefix.length(), false) : N(str, i2, prefix, false);
    }

    public static boolean Q(String str, char c2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.length() > 0 && CharsKt.a(str.charAt(0), c2, false);
    }

    public static String R(char c2, String str, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iW = w(str, c2, 0, 6);
        if (iW == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iW + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String S(String missingDelimiterValue, String delimiter) {
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iX = x(missingDelimiterValue, delimiter, 0, false, 6);
        if (iX == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(delimiter.length() + iX, missingDelimiterValue.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String T(char c2, String str, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iB = B(str, c2, 0, 6);
        if (iB == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iB + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String U(String missingDelimiterValue, char c2) {
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iW = w(missingDelimiterValue, c2, 0, 6);
        if (iW == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(0, iW);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String V(String missingDelimiterValue, char c2) {
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iB = B(missingDelimiterValue, c2, 0, 6);
        if (iB == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = missingDelimiterValue.substring(0, iB);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String W(int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.b.g(i2, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i2 > length) {
            i2 = length;
        }
        String strSubstring = str.substring(0, i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String X(int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.b.g(i2, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i2 > length) {
            i2 = length;
        }
        String strSubstring = str.substring(length - i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static Double Y(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (ScreenFloatValueRegEx.f54000b.c(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Float Z(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (ScreenFloatValueRegEx.f54000b.c(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Long a0(String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt__CharJVMKt.checkRadix(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        long j2 = -9223372036854775807L;
        if (Intrinsics.e(cCharAt, 48) < 0) {
            z = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z = false;
                i2 = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j2 = Long.MIN_VALUE;
                i2 = 1;
            }
        } else {
            z = false;
        }
        long j3 = 0;
        long j4 = -256204778801521550L;
        while (i2 < length) {
            int iDigit = Character.digit((int) str.charAt(i2), 10);
            if (iDigit < 0) {
                return null;
            }
            if (j3 < j4) {
                if (j4 != -256204778801521550L) {
                    return null;
                }
                j4 = j2 / 10;
                if (j3 < j4) {
                    return null;
                }
            }
            long j5 = j3 * 10;
            long j6 = iDigit;
            if (j5 < j2 + j6) {
                return null;
            }
            j3 = j5 - j6;
            i2++;
        }
        return z ? Long.valueOf(j3) : Long.valueOf(-j3);
    }

    public static CharSequence b0(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean zB = CharsKt.b(str.charAt(!z ? i2 : length));
            if (z) {
                if (!zB) {
                    break;
                }
                length--;
            } else if (zB) {
                i2++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i2, length + 1);
    }

    public static String c0(String str, char... chars) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean zE = ArraysKt.e(chars, str.charAt(!z ? i2 : length));
            if (z) {
                if (!zE) {
                    break;
                }
                length--;
            } else if (zE) {
                i2++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i2, length + 1).toString();
    }

    public static String d0(String str, char... chars) {
        CharSequence charSequenceSubSequence;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (!ArraysKt.e(chars, str.charAt(length))) {
                    charSequenceSubSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
            charSequenceSubSequence = "";
        } else {
            charSequenceSubSequence = "";
        }
        return charSequenceSubSequence.toString();
    }

    public static String e0(String str) {
        int length;
        Comparable comparable;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter("", "newIndent");
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str, "<this>");
        List listQ = SequencesKt.q(new StringsKt__StringsKt$lineSequence$$inlined$Sequence$1(str));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listQ) {
            if (!z((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.r(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (true) {
            length = 0;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            int length2 = str2.length();
            while (true) {
                if (length >= length2) {
                    length = -1;
                    break;
                }
                if (!CharsKt.b(str2.charAt(length))) {
                    break;
                }
                length++;
            }
            if (length == -1) {
                length = str2.length();
            }
            arrayList2.add(Integer.valueOf(length));
        }
        Intrinsics.checkNotNullParameter(arrayList2, "<this>");
        Iterator it2 = arrayList2.iterator();
        if (it2.hasNext()) {
            comparable = (Comparable) it2.next();
            while (it2.hasNext()) {
                Comparable comparable2 = (Comparable) it2.next();
                if (comparable.compareTo(comparable2) > 0) {
                    comparable = comparable2;
                }
            }
        } else {
            comparable = null;
        }
        Integer num = (Integer) comparable;
        int iIntValue = num != null ? num.intValue() : 0;
        int length3 = str.length();
        listQ.size();
        int iB = CollectionsKt.B(listQ);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listQ) {
            int i2 = length + 1;
            if (length < 0) {
                CollectionsKt.b0();
                throw null;
            }
            String str3 = (String) obj2;
            if ((length == 0 || length == iB) && z(str3)) {
                str3 = null;
            } else {
                String line = p(iIntValue, str3);
                if (line != null) {
                    Intrinsics.checkNotNullParameter(line, "line");
                    str3 = line;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            length = i2;
        }
        StringBuilder sb = new StringBuilder(length3);
        CollectionsKt.D(arrayList3, sb, StringUtils.LF, null, 124);
        return sb.toString();
    }

    public static String f0(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(CLConstants.SALT_DELIMETER, "marginPrefix");
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter("", "newIndent");
        Intrinsics.checkNotNullParameter(CLConstants.SALT_DELIMETER, "marginPrefix");
        if (z(CLConstants.SALT_DELIMETER)) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str, "<this>");
        List listQ = SequencesKt.q(new StringsKt__StringsKt$lineSequence$$inlined$Sequence$1(str));
        int length = str.length();
        listQ.size();
        int iB = CollectionsKt.B(listQ);
        ArrayList arrayList = new ArrayList();
        Iterator it = listQ.iterator();
        int i2 = 0;
        while (true) {
            String line = null;
            if (!it.hasNext()) {
                StringBuilder sb = new StringBuilder(length);
                CollectionsKt.D(arrayList, sb, StringUtils.LF, null, 124);
                return sb.toString();
            }
            Object next = it.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.b0();
                throw null;
            }
            String str2 = (String) next;
            if ((i2 != 0 && i2 != iB) || !z(str2)) {
                int length2 = str2.length();
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        i4 = -1;
                        break;
                    }
                    if (!CharsKt.b(str2.charAt(i4))) {
                        break;
                    }
                    i4++;
                }
                if (i4 != -1 && N(str2, i4, CLConstants.SALT_DELIMETER, false)) {
                    line = str2.substring(CLConstants.SALT_DELIMETER.length() + i4);
                    Intrinsics.checkNotNullExpressionValue(line, "substring(...)");
                }
                if (line != null) {
                    Intrinsics.checkNotNullParameter(line, "line");
                } else {
                    line = str2;
                }
            }
            if (line != null) {
                arrayList.add(line);
            }
            i2 = i3;
        }
    }

    public static void k(StringBuilder sb, Object obj, Function1 function1) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        if (function1 != null) {
            sb.append((CharSequence) function1.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) obj.toString());
        }
    }

    public static ArrayList l(int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str, "<this>");
        r transform = new r(16);
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        SlidingWindowKt.a(i2, i2);
        int length = str.length();
        int i3 = 0;
        ArrayList arrayList = new ArrayList((length / i2) + (length % i2 == 0 ? 0 : 1));
        while (i3 >= 0 && i3 < length) {
            int i4 = i3 + i2;
            arrayList.add(transform.invoke(str.subSequence(i3, (i4 < 0 || i4 > length) ? length : i4)));
            i3 = i4;
        }
        return arrayList;
    }

    public static String m(char[] cArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        AbstractList.Companion companion = AbstractList.f53584a;
        int length = cArr.length;
        companion.getClass();
        AbstractList.Companion.a(i2, i3, length);
        return new String(cArr, i2, i3 - i2);
    }

    public static boolean n(CharSequence charSequence, String other, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (other != null) {
            if (x(charSequence, other, 0, z, 2) >= 0) {
                return true;
            }
        } else if (StringsKt__StringsKt.e(charSequence, other, 0, charSequence.length(), z, false) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean o(CharSequence charSequence, char c2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return w(charSequence, c2, 0, 2) >= 0;
    }

    public static String p(int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.b.g(i2, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i2 > length) {
            i2 = length;
        }
        String strSubstring = str.substring(i2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static byte[] q(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    public static boolean r(String str, String suffix, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return !z ? str.endsWith(suffix) : E(str.length() - suffix.length(), 0, suffix.length(), str, suffix, true);
    }

    public static boolean s(CharSequence charSequence, char c2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() > 0 && CharsKt.a(charSequence.charAt(v(charSequence)), c2, false);
    }

    public static boolean t(String str, String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static Pair u(String str, Set strings, int i2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(strings, "strings");
        return StringsKt__StringsKt.c(str, strings, i2, true);
    }

    public static int v(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static int w(CharSequence charSequence, char c2, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return !(charSequence instanceof String) ? StringsKt__StringsKt.f(charSequence, new char[]{c2}, i2, false) : ((String) charSequence).indexOf(c2, i2);
    }

    public static /* synthetic */ int x(CharSequence charSequence, String str, int i2, boolean z, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return StringsKt__StringsKt.d(i2, charSequence, str, z);
    }

    public static boolean z(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (!CharsKt.b(charSequence.charAt(i2))) {
                return false;
            }
        }
        return true;
    }
}
