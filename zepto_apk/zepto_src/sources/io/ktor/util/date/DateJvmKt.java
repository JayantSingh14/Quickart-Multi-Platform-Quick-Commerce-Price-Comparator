package io.ktor.util.date;

import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.time.TimeZones;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DateJvmKt {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeZone f50534a = DesugarTimeZone.getTimeZone(TimeZones.GMT_ID);

    public static final GMTDate a(int i2, int i3, int i4, int i5, Month month, int i6) {
        Intrinsics.checkNotNullParameter(month, "month");
        Calendar calendar = Calendar.getInstance(f50534a, Locale.ROOT);
        Intrinsics.c(calendar);
        calendar.set(1, i6);
        calendar.set(2, month.ordinal());
        calendar.set(5, i5);
        calendar.set(11, i4);
        calendar.set(12, i3);
        calendar.set(13, i2);
        calendar.set(14, 0);
        return c(calendar, null);
    }

    public static final GMTDate b(Long l2) {
        Calendar calendar = Calendar.getInstance(f50534a, Locale.ROOT);
        Intrinsics.c(calendar);
        return c(calendar, l2);
    }

    public static final GMTDate c(Calendar calendar, Long l2) {
        Intrinsics.checkNotNullParameter(calendar, "<this>");
        if (l2 != null) {
            calendar.setTimeInMillis(l2.longValue());
        }
        return new GMTDate(calendar.get(13), calendar.get(12), calendar.get(11), WeekDay.values()[(calendar.get(7) + 5) % 7], calendar.get(5), calendar.get(6), Month.values()[calendar.get(2)], calendar.get(1), calendar.getTimeInMillis() + calendar.get(16) + calendar.get(15));
    }
}
