package org.apache.commons.lang3.time;

import android.support.v4.media.b;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.Validate;

/* loaded from: classes5.dex */
public class DateUtils {
    public static final long MILLIS_PER_DAY = 86400000;
    public static final long MILLIS_PER_HOUR = 3600000;
    public static final long MILLIS_PER_MINUTE = 60000;
    public static final long MILLIS_PER_SECOND = 1000;
    public static final int RANGE_MONTH_MONDAY = 6;
    public static final int RANGE_MONTH_SUNDAY = 5;
    public static final int RANGE_WEEK_CENTER = 4;
    public static final int RANGE_WEEK_MONDAY = 2;
    public static final int RANGE_WEEK_RELATIVE = 3;
    public static final int RANGE_WEEK_SUNDAY = 1;
    public static final int SEMI_MONTH = 1001;
    private static final int[][] fields = {new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, SEMI_MONTH}, new int[]{1}, new int[]{0}};

    public static class DateIterator implements Iterator<Calendar> {
        private final Calendar endFinal;
        private final Calendar spot;

        public DateIterator(Calendar calendar, Calendar calendar2) {
            this.endFinal = calendar2;
            this.spot = calendar;
            calendar.add(5, -1);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.spot.before(this.endFinal);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public Calendar next() {
            if (this.spot.equals(this.endFinal)) {
                throw new NoSuchElementException();
            }
            this.spot.add(5, 1);
            return (Calendar) this.spot.clone();
        }
    }

    public enum ModifyType {
        TRUNCATE,
        ROUND,
        CEILING
    }

    private static Date add(Date date, int i2, int i3) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(i2, i3);
        return calendar.getTime();
    }

    public static Date addDays(Date date, int i2) {
        return add(date, 5, i2);
    }

    public static Date addHours(Date date, int i2) {
        return add(date, 11, i2);
    }

    public static Date addMilliseconds(Date date, int i2) {
        return add(date, 14, i2);
    }

    public static Date addMinutes(Date date, int i2) {
        return add(date, 12, i2);
    }

    public static Date addMonths(Date date, int i2) {
        return add(date, 2, i2);
    }

    public static Date addSeconds(Date date, int i2) {
        return add(date, 13, i2);
    }

    public static Date addWeeks(Date date, int i2) {
        return add(date, 3, i2);
    }

    public static Date addYears(Date date, int i2) {
        return add(date, 1, i2);
    }

    public static Date ceiling(Date date, int i2) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        modify(calendar, i2, ModifyType.CEILING);
        return calendar.getTime();
    }

    private static long getFragment(Date date, int i2, TimeUnit timeUnit) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getFragment(calendar, i2, timeUnit);
    }

    public static long getFragmentInDays(Date date, int i2) {
        return getFragment(date, i2, TimeUnit.DAYS);
    }

    public static long getFragmentInHours(Date date, int i2) {
        return getFragment(date, i2, TimeUnit.HOURS);
    }

    public static long getFragmentInMilliseconds(Date date, int i2) {
        return getFragment(date, i2, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInMinutes(Date date, int i2) {
        return getFragment(date, i2, TimeUnit.MINUTES);
    }

    public static long getFragmentInSeconds(Date date, int i2) {
        return getFragment(date, i2, TimeUnit.SECONDS);
    }

    public static boolean isSameDay(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return isSameDay(calendar, calendar2);
    }

    public static boolean isSameInstant(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return date.getTime() == date2.getTime();
    }

    public static boolean isSameLocalTime(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return calendar.get(14) == calendar2.get(14) && calendar.get(13) == calendar2.get(13) && calendar.get(12) == calendar2.get(12) && calendar.get(11) == calendar2.get(11) && calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1) && calendar.get(0) == calendar2.get(0) && calendar.getClass() == calendar2.getClass();
    }

    public static Iterator<Calendar> iterator(Date date, int i2) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return iterator(calendar, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void modify(java.util.Calendar r17, int r18, org.apache.commons.lang3.time.DateUtils.ModifyType r19) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DateUtils.modify(java.util.Calendar, int, org.apache.commons.lang3.time.DateUtils$ModifyType):void");
    }

    public static Date parseDate(String str, String... strArr) throws ParseException {
        return parseDate(str, null, strArr);
    }

    public static Date parseDateStrictly(String str, String... strArr) throws ParseException {
        return parseDateStrictly(str, null, strArr);
    }

    private static Date parseDateWithLeniency(String str, Locale locale, String[] strArr, boolean z) throws ParseException {
        if (str == null || strArr == null) {
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }
        TimeZone timeZone = TimeZone.getDefault();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Calendar calendar = Calendar.getInstance(timeZone, locale);
        calendar.setLenient(z);
        for (String str2 : strArr) {
            FastDateParser fastDateParser = new FastDateParser(str2, timeZone, locale);
            calendar.clear();
            if (fastDateParser.parse(str, parsePosition, calendar) && parsePosition.getIndex() == str.length()) {
                return calendar.getTime();
            }
            parsePosition.setIndex(0);
        }
        throw new ParseException("Unable to parse the date: ".concat(str), -1);
    }

    public static Date round(Date date, int i2) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        modify(calendar, i2, ModifyType.ROUND);
        return calendar.getTime();
    }

    private static Date set(Date date, int i2, int i3) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        calendar.setTime(date);
        calendar.set(i2, i3);
        return calendar.getTime();
    }

    public static Date setDays(Date date, int i2) {
        return set(date, 5, i2);
    }

    public static Date setHours(Date date, int i2) {
        return set(date, 11, i2);
    }

    public static Date setMilliseconds(Date date, int i2) {
        return set(date, 14, i2);
    }

    public static Date setMinutes(Date date, int i2) {
        return set(date, 12, i2);
    }

    public static Date setMonths(Date date, int i2) {
        return set(date, 2, i2);
    }

    public static Date setSeconds(Date date, int i2) {
        return set(date, 13, i2);
    }

    public static Date setYears(Date date, int i2) {
        return set(date, 1, i2);
    }

    public static Calendar toCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Date truncate(Date date, int i2) {
        validateDateNotNull(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        modify(calendar, i2, ModifyType.TRUNCATE);
        return calendar.getTime();
    }

    public static int truncatedCompareTo(Calendar calendar, Calendar calendar2, int i2) {
        return truncate(calendar, i2).compareTo(truncate(calendar2, i2));
    }

    public static boolean truncatedEquals(Calendar calendar, Calendar calendar2, int i2) {
        return truncatedCompareTo(calendar, calendar2, i2) == 0;
    }

    private static void validateDateNotNull(Date date) {
        Validate.isTrue(date != null, "The date must not be null", new Object[0]);
    }

    public static long getFragmentInDays(Calendar calendar, int i2) {
        return getFragment(calendar, i2, TimeUnit.DAYS);
    }

    public static long getFragmentInHours(Calendar calendar, int i2) {
        return getFragment(calendar, i2, TimeUnit.HOURS);
    }

    public static long getFragmentInMilliseconds(Calendar calendar, int i2) {
        return getFragment(calendar, i2, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInMinutes(Calendar calendar, int i2) {
        return getFragment(calendar, i2, TimeUnit.MINUTES);
    }

    public static long getFragmentInSeconds(Calendar calendar, int i2) {
        return getFragment(calendar, i2, TimeUnit.SECONDS);
    }

    public static Date parseDate(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, locale, strArr, true);
    }

    public static Date parseDateStrictly(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, locale, strArr, false);
    }

    public static boolean truncatedEquals(Date date, Date date2, int i2) {
        return truncatedCompareTo(date, date2, i2) == 0;
    }

    public static boolean isSameInstant(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return calendar.getTime().getTime() == calendar2.getTime().getTime();
    }

    public static Calendar toCalendar(Date date, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(date);
        return calendar;
    }

    public static int truncatedCompareTo(Date date, Date date2, int i2) {
        return truncate(date, i2).compareTo(truncate(date2, i2));
    }

    private static long getFragment(Calendar calendar, int i2, TimeUnit timeUnit) {
        long jConvert;
        if (calendar != null) {
            TimeUnit timeUnit2 = TimeUnit.DAYS;
            int i3 = timeUnit == timeUnit2 ? 0 : 1;
            if (i2 != 1) {
                jConvert = i2 != 2 ? 0L : timeUnit.convert(calendar.get(5) - i3, timeUnit2);
            } else {
                jConvert = timeUnit.convert(calendar.get(6) - i3, timeUnit2);
            }
            if (i2 == 1 || i2 == 2 || i2 == 5 || i2 == 6) {
                jConvert += timeUnit.convert(calendar.get(11), TimeUnit.HOURS);
            } else {
                switch (i2) {
                    case 11:
                        break;
                    case 12:
                        jConvert += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
                    case 13:
                        return timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS) + jConvert;
                    case 14:
                        return jConvert;
                    default:
                        throw new IllegalArgumentException(b.g(i2, "The fragment ", " is not supported"));
                }
            }
            jConvert += timeUnit.convert(calendar.get(12), TimeUnit.MINUTES);
            jConvert += timeUnit.convert(calendar.get(13), TimeUnit.SECONDS);
            return timeUnit.convert(calendar.get(14), TimeUnit.MILLISECONDS) + jConvert;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006e A[LOOP:0: B:30:0x0068->B:32:0x006e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0078 A[LOOP:1: B:33:0x0072->B:35:0x0078, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Iterator<java.util.Calendar> iterator(java.util.Calendar r8, int r9) {
        /*
            if (r8 == 0) goto L82
            r0 = -1
            r1 = 5
            r2 = 2
            r3 = 1
            r4 = 7
            switch(r9) {
                case 1: goto L34;
                case 2: goto L34;
                case 3: goto L34;
                case 4: goto L34;
                case 5: goto L18;
                case 6: goto L18;
                default: goto La;
            }
        La:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "The range style "
            java.lang.String r1 = " is not valid."
            java.lang.String r9 = android.support.v4.media.b.g(r9, r0, r1)
            r8.<init>(r9)
            throw r8
        L18:
            java.util.Calendar r8 = truncate(r8, r2)
            java.lang.Object r5 = r8.clone()
            java.util.Calendar r5 = (java.util.Calendar) r5
            r5.add(r2, r3)
            r5.add(r1, r0)
            r6 = 6
            if (r9 != r6) goto L2f
            r6 = r5
            r5 = r8
        L2d:
            r8 = r3
            goto L58
        L2f:
            r2 = r3
            r6 = r5
            r5 = r8
        L32:
            r8 = r4
            goto L58
        L34:
            java.util.Calendar r5 = truncate(r8, r1)
            java.util.Calendar r6 = truncate(r8, r1)
            if (r9 == r2) goto L2d
            r2 = 3
            if (r9 == r2) goto L52
            r7 = 4
            if (r9 == r7) goto L46
            r2 = r3
            goto L32
        L46:
            int r9 = r8.get(r4)
            int r9 = r9 - r2
            int r8 = r8.get(r4)
            int r8 = r8 + r2
            r2 = r9
            goto L58
        L52:
            int r2 = r8.get(r4)
            int r8 = r2 + (-1)
        L58:
            if (r2 >= r3) goto L5c
            int r2 = r2 + 7
        L5c:
            if (r2 <= r4) goto L60
            int r2 = r2 + (-7)
        L60:
            if (r8 >= r3) goto L64
            int r8 = r8 + 7
        L64:
            if (r8 <= r4) goto L68
            int r8 = r8 + (-7)
        L68:
            int r9 = r5.get(r4)
            if (r9 == r2) goto L72
            r5.add(r1, r0)
            goto L68
        L72:
            int r9 = r6.get(r4)
            if (r9 == r8) goto L7c
            r6.add(r1, r3)
            goto L72
        L7c:
            org.apache.commons.lang3.time.DateUtils$DateIterator r8 = new org.apache.commons.lang3.time.DateUtils$DateIterator
            r8.<init>(r5, r6)
            return r8
        L82:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "The date must not be null"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DateUtils.iterator(java.util.Calendar, int):java.util.Iterator");
    }

    public static Calendar ceiling(Calendar calendar, int i2) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i2, ModifyType.CEILING);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar round(Calendar calendar, int i2) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i2, ModifyType.ROUND);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Calendar truncate(Calendar calendar, int i2) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i2, ModifyType.TRUNCATE);
            return calendar2;
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static Date ceiling(Object obj, int i2) {
        if (obj != null) {
            if (obj instanceof Date) {
                return ceiling((Date) obj, i2);
            }
            if (obj instanceof Calendar) {
                return ceiling((Calendar) obj, i2).getTime();
            }
            throw new ClassCastException("Could not find ceiling of for type: " + obj.getClass());
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date round(Object obj, int i2) {
        if (obj != null) {
            if (obj instanceof Date) {
                return round((Date) obj, i2);
            }
            if (obj instanceof Calendar) {
                return round((Calendar) obj, i2).getTime();
            }
            throw new ClassCastException(b.j(obj, "Could not round "));
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Date truncate(Object obj, int i2) {
        if (obj != null) {
            if (obj instanceof Date) {
                return truncate((Date) obj, i2);
            }
            if (obj instanceof Calendar) {
                return truncate((Calendar) obj, i2).getTime();
            }
            throw new ClassCastException(b.j(obj, "Could not truncate "));
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static Iterator<?> iterator(Object obj, int i2) {
        if (obj != null) {
            if (obj instanceof Date) {
                return iterator((Date) obj, i2);
            }
            if (obj instanceof Calendar) {
                return iterator((Calendar) obj, i2);
            }
            throw new ClassCastException(b.j(obj, "Could not iterate based on "));
        }
        throw new IllegalArgumentException("The date must not be null");
    }
}
