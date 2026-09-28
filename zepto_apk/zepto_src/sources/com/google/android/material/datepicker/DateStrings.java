package com.google.android.material.datepicker;

import androidx.core.util.Pair;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes4.dex */
class DateStrings {
    public static Pair a(Long l2, Long l3) {
        if (l2 == null && l3 == null) {
            return new Pair(null, null);
        }
        if (l2 == null) {
            return new Pair(null, b(l3.longValue()));
        }
        if (l3 == null) {
            return new Pair(b(l2.longValue()), null);
        }
        Calendar calendarF = UtcDates.f();
        Calendar calendarG = UtcDates.g(null);
        calendarG.setTimeInMillis(l2.longValue());
        Calendar calendarG2 = UtcDates.g(null);
        calendarG2.setTimeInMillis(l3.longValue());
        return calendarG.get(1) == calendarG2.get(1) ? calendarG.get(1) == calendarF.get(1) ? new Pair(c(l2.longValue(), Locale.getDefault()), c(l3.longValue(), Locale.getDefault())) : new Pair(c(l2.longValue(), Locale.getDefault()), d(l3.longValue(), Locale.getDefault())) : new Pair(d(l2.longValue(), Locale.getDefault()), d(l3.longValue(), Locale.getDefault()));
    }

    public static String b(long j2) {
        Calendar calendarF = UtcDates.f();
        Calendar calendarG = UtcDates.g(null);
        calendarG.setTimeInMillis(j2);
        return calendarF.get(1) == calendarG.get(1) ? c(j2, Locale.getDefault()) : d(j2, Locale.getDefault());
    }

    public static String c(long j2, Locale locale) {
        return UtcDates.b("MMMd", locale).format(new Date(j2));
    }

    public static String d(long j2, Locale locale) {
        return UtcDates.b("yMMMd", locale).format(new Date(j2));
    }
}
