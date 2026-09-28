package io.ktor.util.date;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.time.TimeZones;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class GMTDateParser {

    /* renamed from: a, reason: collision with root package name */
    public final String f50550a;

    @Metadata
    public static final class Companion {
    }

    public GMTDateParser(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        this.f50550a = pattern;
        if (pattern.length() <= 0) {
            throw new IllegalStateException("Date parser pattern shouldn't be empty.");
        }
    }

    public static void a(GMTDateBuilder gMTDateBuilder, char c2, String value) {
        Month month;
        if (c2 == 's') {
            gMTDateBuilder.f50544a = Integer.valueOf(Integer.parseInt(value));
            return;
        }
        if (c2 == 'm') {
            gMTDateBuilder.f50545b = Integer.valueOf(Integer.parseInt(value));
            return;
        }
        if (c2 == 'h') {
            gMTDateBuilder.f50546c = Integer.valueOf(Integer.parseInt(value));
            return;
        }
        if (c2 == 'd') {
            gMTDateBuilder.f50547d = Integer.valueOf(Integer.parseInt(value));
            return;
        }
        int i2 = 0;
        if (c2 != 'M') {
            if (c2 == 'Y') {
                gMTDateBuilder.f50549f = Integer.valueOf(Integer.parseInt(value));
                return;
            }
            if (c2 == 'z') {
                if (!Intrinsics.b(value, TimeZones.GMT_ID)) {
                    throw new IllegalStateException("Check failed.");
                }
                return;
            } else {
                if (c2 != '*') {
                    while (i2 < value.length()) {
                        if (value.charAt(i2) != c2) {
                            throw new IllegalStateException("Check failed.");
                        }
                        i2++;
                    }
                    return;
                }
                return;
            }
        }
        Intrinsics.checkNotNullParameter(value, "value");
        Month[] monthArrValues = Month.values();
        int length = monthArrValues.length;
        while (true) {
            if (i2 >= length) {
                month = null;
                break;
            }
            month = monthArrValues[i2];
            if (month.f50552a.equals(value)) {
                break;
            } else {
                i2++;
            }
        }
        if (month != null) {
            Intrinsics.checkNotNullParameter(month, "<set-?>");
            gMTDateBuilder.f50548e = month;
        } else {
            throw new IllegalStateException(("Invalid month: " + value).toString());
        }
    }

    public final GMTDate b(String data) {
        Intrinsics.checkNotNullParameter(data, "dateString");
        GMTDateBuilder gMTDateBuilder = new GMTDateBuilder();
        String pattern = this.f50550a;
        char cCharAt = pattern.charAt(0);
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i3 < pattern.length()) {
            try {
                if (pattern.charAt(i3) == cCharAt) {
                    i3++;
                } else {
                    int i5 = (i2 + i3) - i4;
                    String strSubstring = data.substring(i2, i5);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    a(gMTDateBuilder, cCharAt, strSubstring);
                    try {
                        cCharAt = pattern.charAt(i3);
                        i4 = i3;
                        i3++;
                        i2 = i5;
                    } catch (Throwable unused) {
                        i2 = i5;
                        Intrinsics.checkNotNullParameter(data, "data");
                        Intrinsics.checkNotNullParameter(pattern, "pattern");
                        StringBuilder sb = new StringBuilder("Failed to parse date string: \"");
                        sb.append(data);
                        sb.append("\" at index ");
                        sb.append(i2);
                        sb.append(". Pattern: \"");
                        throw new InvalidDateStringException(e.t(sb, pattern, '\"'));
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        if (i2 < data.length()) {
            String strSubstring2 = data.substring(i2);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            a(gMTDateBuilder, cCharAt, strSubstring2);
        }
        Integer num = gMTDateBuilder.f50544a;
        Intrinsics.c(num);
        int iIntValue = num.intValue();
        Integer num2 = gMTDateBuilder.f50545b;
        Intrinsics.c(num2);
        int iIntValue2 = num2.intValue();
        Integer num3 = gMTDateBuilder.f50546c;
        Intrinsics.c(num3);
        int iIntValue3 = num3.intValue();
        Integer num4 = gMTDateBuilder.f50547d;
        Intrinsics.c(num4);
        int iIntValue4 = num4.intValue();
        Month month = gMTDateBuilder.f50548e;
        if (month == null) {
            Intrinsics.h("month");
            throw null;
        }
        Integer num5 = gMTDateBuilder.f50549f;
        Intrinsics.c(num5);
        return DateJvmKt.a(iIntValue, iIntValue2, iIntValue3, iIntValue4, month, num5.intValue());
    }
}
