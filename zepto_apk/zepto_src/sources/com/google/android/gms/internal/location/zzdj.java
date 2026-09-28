package com.google.android.gms.internal.location;

import java.text.SimpleDateFormat;
import java.util.Locale;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes4.dex */
public final class zzdj {

    /* renamed from: a, reason: collision with root package name */
    public static final StringBuilder f36693a;

    static {
        Locale locale = Locale.ROOT;
        new SimpleDateFormat("MM-dd HH:mm:ss.SSS", locale);
        new SimpleDateFormat("MM-dd HH:mm:ss", locale);
        f36693a = new StringBuilder(33);
    }

    public static void a(long j2, StringBuilder sb) {
        if (j2 == 0) {
            sb.append("0s");
            return;
        }
        sb.ensureCapacity(sb.length() + 27);
        boolean z = false;
        if (j2 < 0) {
            sb.append("-");
            if (j2 != Long.MIN_VALUE) {
                j2 = -j2;
            } else {
                j2 = Long.MAX_VALUE;
                z = true;
            }
        }
        if (j2 >= DateUtils.MILLIS_PER_DAY) {
            sb.append(j2 / DateUtils.MILLIS_PER_DAY);
            sb.append("d");
            j2 %= DateUtils.MILLIS_PER_DAY;
        }
        if (true == z) {
            j2 = 25975808;
        }
        if (j2 >= DateUtils.MILLIS_PER_HOUR) {
            sb.append(j2 / DateUtils.MILLIS_PER_HOUR);
            sb.append("h");
            j2 %= DateUtils.MILLIS_PER_HOUR;
        }
        if (j2 >= DateUtils.MILLIS_PER_MINUTE) {
            sb.append(j2 / DateUtils.MILLIS_PER_MINUTE);
            sb.append("m");
            j2 %= DateUtils.MILLIS_PER_MINUTE;
        }
        if (j2 >= 1000) {
            sb.append(j2 / 1000);
            sb.append("s");
            j2 %= 1000;
        }
        if (j2 > 0) {
            sb.append(j2);
            sb.append("ms");
        }
    }
}
