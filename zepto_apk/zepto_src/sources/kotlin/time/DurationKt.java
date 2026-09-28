package kotlin.time;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.lang3.ClassUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DurationKt {
    public static final long a(String str, boolean z) {
        long jG;
        char cCharAt;
        char cCharAt2;
        char cCharAt3;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        Duration.f54014b.getClass();
        char cCharAt4 = str.charAt(0);
        int i2 = (cCharAt4 == '+' || cCharAt4 == '-') ? 1 : 0;
        boolean z2 = i2 > 0;
        boolean z3 = z2 && StringsKt.Q(str, Soundex.SILENT_MARKER);
        if (length <= i2) {
            throw new IllegalArgumentException("No components");
        }
        char cCharAt5 = str.charAt(i2);
        int i3 = 6;
        char c2 = ClassUtils.PACKAGE_SEPARATOR_CHAR;
        DurationUnit durationUnit = null;
        char c3 = ':';
        char c4 = '0';
        if (cCharAt5 == 'P') {
            int i4 = i2 + 1;
            if (i4 == length) {
                throw new IllegalArgumentException();
            }
            boolean z4 = false;
            jG = 0;
            while (i4 < length) {
                if (str.charAt(i4) != 'T') {
                    int i5 = i4;
                    while (i5 < str.length() && ((c4 <= (cCharAt3 = str.charAt(i5)) && cCharAt3 < c3) || StringsKt.o("+-.", cCharAt3))) {
                        i5++;
                        c3 = ':';
                    }
                    String strSubstring = str.substring(i4, i5);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    if (strSubstring.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length2 = strSubstring.length() + i4;
                    if (length2 < 0 || length2 >= str.length()) {
                        throw new IllegalArgumentException("Missing unit for value ".concat(strSubstring));
                    }
                    char cCharAt6 = str.charAt(length2);
                    int i6 = length2 + 1;
                    DurationUnit durationUnitD = DurationUnitKt__DurationUnitKt.d(cCharAt6, z4);
                    if (durationUnit != null && durationUnit.compareTo(durationUnitD) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int iW = StringsKt.w(strSubstring, c2, 0, i3);
                    if (durationUnitD != DurationUnit.f54022e || iW <= 0) {
                        jG = Duration.g(jG, h(e(strSubstring), durationUnitD));
                    } else {
                        String strSubstring2 = strSubstring.substring(0, iW);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        long jG2 = Duration.g(jG, h(e(strSubstring2), durationUnitD));
                        String strSubstring3 = strSubstring.substring(iW);
                        Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                        jG = Duration.g(jG2, f(Double.parseDouble(strSubstring3), durationUnitD));
                    }
                    durationUnit = durationUnitD;
                    i4 = i6;
                    c3 = ':';
                    c4 = '0';
                    i3 = 6;
                    c2 = ClassUtils.PACKAGE_SEPARATOR_CHAR;
                } else {
                    if (z4 || (i4 = i4 + 1) == length) {
                        throw new IllegalArgumentException();
                    }
                    z4 = true;
                }
            }
        } else {
            if (z) {
                throw new IllegalArgumentException();
            }
            char c5 = ':';
            char c6 = '0';
            if (StringsKt.E(i2, 0, Math.max(length - i2, 8), str, "Infinity", true)) {
                jG = Duration.f54015c;
            } else {
                boolean z5 = !z2;
                if (z2 && str.charAt(i2) == '(' && StringsKt.A(str) == ')') {
                    i2++;
                    length--;
                    if (i2 == length) {
                        throw new IllegalArgumentException("No components");
                    }
                    z5 = true;
                }
                long jG3 = 0;
                boolean z6 = false;
                while (i2 < length) {
                    if (z6 && z5) {
                        while (i2 < str.length() && str.charAt(i2) == ' ') {
                            i2++;
                        }
                    }
                    int i7 = i2;
                    while (i7 < str.length() && ((c6 <= (cCharAt2 = str.charAt(i7)) && cCharAt2 < c5) || cCharAt2 == '.')) {
                        i7++;
                    }
                    String strSubstring4 = str.substring(i2, i7);
                    Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
                    if (strSubstring4.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length3 = strSubstring4.length() + i2;
                    int i8 = length3;
                    while (i8 < str.length() && 'a' <= (cCharAt = str.charAt(i8)) && cCharAt < '{') {
                        i8++;
                    }
                    String strSubstring5 = str.substring(length3, i8);
                    Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
                    int length4 = length3 + strSubstring5.length();
                    DurationUnit durationUnitE = DurationUnitKt__DurationUnitKt.e(strSubstring5);
                    if (durationUnit != null && durationUnit.compareTo(durationUnitE) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int iW2 = StringsKt.w(strSubstring4, ClassUtils.PACKAGE_SEPARATOR_CHAR, 0, 6);
                    if (iW2 > 0) {
                        String strSubstring6 = strSubstring4.substring(0, iW2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring6, "substring(...)");
                        long jG4 = Duration.g(jG3, h(Long.parseLong(strSubstring6), durationUnitE));
                        String strSubstring7 = strSubstring4.substring(iW2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring7, "substring(...)");
                        jG3 = Duration.g(jG4, f(Double.parseDouble(strSubstring7), durationUnitE));
                        if (length4 < length) {
                            throw new IllegalArgumentException("Fractional component must be last");
                        }
                    } else {
                        jG3 = Duration.g(jG3, h(Long.parseLong(strSubstring4), durationUnitE));
                    }
                    durationUnit = durationUnitE;
                    i2 = length4;
                    z6 = true;
                    c5 = ':';
                    c6 = '0';
                }
                jG = jG3;
            }
        }
        return z3 ? Duration.l(jG) : jG;
    }

    public static final long b(long j2) {
        long j3 = (j2 << 1) + 1;
        Duration.Companion companion = Duration.f54014b;
        int i2 = DurationJvmKt.f54018a;
        return j3;
    }

    public static final long c(long j2) {
        return (-4611686018426L > j2 || j2 >= 4611686018427L) ? b(RangesKt.c(j2, -4611686018427387903L, 4611686018427387903L)) : d(j2 * 1000000);
    }

    public static final long d(long j2) {
        long j3 = j2 << 1;
        Duration.Companion companion = Duration.f54014b;
        int i2 = DurationJvmKt.f54018a;
        return j3;
    }

    public static final long e(String str) {
        int length = str.length();
        int i2 = (length <= 0 || !StringsKt.o("+-", str.charAt(0))) ? 0 : 1;
        if (length - i2 > 16) {
            Iterable intRange = new IntRange(i2, StringsKt.v(str), 1);
            if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
                Iterator<Integer> it = intRange.iterator();
                while (((IntProgressionIterator) it).f53843c) {
                    char cCharAt = str.charAt(((IntIterator) it).a());
                    if ('0' > cCharAt || cCharAt >= ':') {
                    }
                }
            }
            return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        return StringsKt.O(str, "+", false) ? Long.parseLong(StringsKt.p(1, str)) : Long.parseLong(str);
    }

    public static final long f(double d2, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        double dA = DurationUnitKt__DurationUnitJvmKt.a(d2, unit, DurationUnit.f54019b);
        if (Double.isNaN(dA)) {
            throw new IllegalArgumentException("Duration value cannot be NaN.");
        }
        if (Double.isNaN(dA)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        long jRound = Math.round(dA);
        if (-4611686018426999999L <= jRound && jRound < 4611686018427000000L) {
            return d(jRound);
        }
        double dA2 = DurationUnitKt__DurationUnitJvmKt.a(d2, unit, DurationUnit.f54021d);
        if (Double.isNaN(dA2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return c(Math.round(dA2));
    }

    public static final long g(int i2, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return unit.compareTo(DurationUnit.f54022e) <= 0 ? d(DurationUnitKt__DurationUnitJvmKt.c(i2, unit, DurationUnit.f54019b)) : h(i2, unit);
    }

    public static final long h(long j2, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit durationUnit = DurationUnit.f54019b;
        long jC = DurationUnitKt__DurationUnitJvmKt.c(4611686018426999999L, durationUnit, unit);
        return ((-jC) > j2 || j2 > jC) ? b(RangesKt.c(DurationUnitKt__DurationUnitJvmKt.b(j2, unit, DurationUnit.f54021d), -4611686018427387903L, 4611686018427387903L)) : d(DurationUnitKt__DurationUnitJvmKt.c(j2, unit, durationUnit));
    }
}
