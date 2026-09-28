package io.sentry.vendor.gson.internal.bind.util;

import j$.util.DesugarTimeZone;
import java.util.TimeZone;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public class ISO8601Utils {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeZone f53145a = DesugarTimeZone.getTimeZone("UTC");

    public static boolean a(String str, int i2, char c2) {
        return i2 < str.length() && str.charAt(i2) == c2;
    }

    public static void b(StringBuilder sb, int i2, int i3) {
        String string = Integer.toString(i2);
        for (int length = i3 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f6 A[Catch: IllegalArgumentException -> 0x00d5, NumberFormatException -> 0x00d8, IndexOutOfBoundsException -> 0x00db, TRY_LEAVE, TryCatch #2 {IllegalArgumentException -> 0x00d5, IndexOutOfBoundsException -> 0x00db, NumberFormatException -> 0x00d8, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0036, B:13:0x003c, B:17:0x0051, B:19:0x0061, B:20:0x0063, B:22:0x006f, B:23:0x0072, B:25:0x0078, B:29:0x0082, B:34:0x0092, B:36:0x009a, B:37:0x009e, B:39:0x00a4, B:44:0x00b1, B:46:0x00bb, B:63:0x00f0, B:65:0x00f6, B:91:0x01a8, B:73:0x0108, B:74:0x0123, B:75:0x0124, B:79:0x0141, B:81:0x014e, B:84:0x0157, B:86:0x0176, B:89:0x0185, B:90:0x01a7, B:78:0x0130, B:93:0x01d9, B:94:0x01e0, B:50:0x00cb, B:51:0x00ce, B:45:0x00b6), top: B:105:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d9 A[Catch: IllegalArgumentException -> 0x00d5, NumberFormatException -> 0x00d8, IndexOutOfBoundsException -> 0x00db, TryCatch #2 {IllegalArgumentException -> 0x00d5, IndexOutOfBoundsException -> 0x00db, NumberFormatException -> 0x00d8, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0036, B:13:0x003c, B:17:0x0051, B:19:0x0061, B:20:0x0063, B:22:0x006f, B:23:0x0072, B:25:0x0078, B:29:0x0082, B:34:0x0092, B:36:0x009a, B:37:0x009e, B:39:0x00a4, B:44:0x00b1, B:46:0x00bb, B:63:0x00f0, B:65:0x00f6, B:91:0x01a8, B:73:0x0108, B:74:0x0123, B:75:0x0124, B:79:0x0141, B:81:0x014e, B:84:0x0157, B:86:0x0176, B:89:0x0185, B:90:0x01a7, B:78:0x0130, B:93:0x01d9, B:94:0x01e0, B:50:0x00cb, B:51:0x00ce, B:45:0x00b6), top: B:105:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date c(java.lang.String r17, java.text.ParsePosition r18) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 553
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.internal.bind.util.ISO8601Utils.c(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static int d(int i2, int i3, String str) {
        int i4;
        int i5;
        if (i2 < 0 || i3 > str.length() || i2 > i3) {
            throw new NumberFormatException(str);
        }
        if (i2 < i3) {
            i5 = i2 + 1;
            int iDigit = Character.digit(str.charAt(i2), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i4 = -iDigit;
        } else {
            i4 = 0;
            i5 = i2;
        }
        while (i5 < i3) {
            int i6 = i5 + 1;
            int iDigit2 = Character.digit(str.charAt(i5), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i4 = (i4 * 10) - iDigit2;
            i5 = i6;
        }
        return -i4;
    }
}
