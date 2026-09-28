package io.sentry;

import io.sentry.vendor.gson.internal.bind.util.ISO8601Utils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class DateUtils {
    public static Date a() {
        return Calendar.getInstance(ISO8601Utils.f53145a).getTime();
    }

    public static Date b(long j2) {
        Calendar calendar = Calendar.getInstance(ISO8601Utils.f53145a);
        calendar.setTimeInMillis(j2);
        return calendar.getTime();
    }

    public static Date c(String str) {
        try {
            return ISO8601Utils.c(str, new ParsePosition(0));
        } catch (ParseException unused) {
            throw new IllegalArgumentException(android.support.v4.media.b.C("timestamp is not ISO format ", str));
        }
    }

    public static Date d(String str) {
        try {
            return b(new BigDecimal(str).setScale(3, RoundingMode.DOWN).movePointRight(3).longValue());
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException(android.support.v4.media.b.C("timestamp is not millis format ", str));
        }
    }

    public static String e(Date date) {
        TimeZone timeZone = ISO8601Utils.f53145a;
        Locale locale = Locale.US;
        TimeZone timeZone2 = ISO8601Utils.f53145a;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone2, locale);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(23 + (timeZone2.getRawOffset() == 0 ? 1 : 6));
        ISO8601Utils.b(sb, gregorianCalendar.get(1), 4);
        char c2 = Soundex.SILENT_MARKER;
        sb.append(Soundex.SILENT_MARKER);
        ISO8601Utils.b(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append(Soundex.SILENT_MARKER);
        ISO8601Utils.b(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        ISO8601Utils.b(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        ISO8601Utils.b(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        ISO8601Utils.b(sb, gregorianCalendar.get(13), 2);
        sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        ISO8601Utils.b(sb, gregorianCalendar.get(14), 3);
        int offset = timeZone2.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i2 = offset / 60000;
            int iAbs = Math.abs(i2 / 60);
            int iAbs2 = Math.abs(i2 % 60);
            if (offset >= 0) {
                c2 = '+';
            }
            sb.append(c2);
            ISO8601Utils.b(sb, iAbs, 2);
            sb.append(':');
            ISO8601Utils.b(sb, iAbs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }
}
