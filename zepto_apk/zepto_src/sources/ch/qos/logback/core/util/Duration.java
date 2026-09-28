package ch.qos.logback.core.util;

import android.support.v4.media.b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes3.dex */
public class Duration {

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f13803b = Pattern.compile("([0-9]*(.[0-9]+)?)\\s*(|milli(second)?|second(e)?|minute|hour|day)s?", 2);

    /* renamed from: a, reason: collision with root package name */
    public final long f13804a;

    public Duration(long j2) {
        this.f13804a = j2;
    }

    public static Duration a(String str) {
        Matcher matcher = f13803b.matcher(str);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(b.D("String value [", str, "] is not in the expected format."));
        }
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(3);
        double dDoubleValue = Double.valueOf(strGroup).doubleValue();
        if (strGroup2.equalsIgnoreCase("milli") || strGroup2.equalsIgnoreCase("millisecond") || strGroup2.length() == 0) {
            return new Duration((long) dDoubleValue);
        }
        if (strGroup2.equalsIgnoreCase("second") || strGroup2.equalsIgnoreCase("seconde")) {
            return new Duration((long) (dDoubleValue * 1000.0d));
        }
        if (strGroup2.equalsIgnoreCase("minute")) {
            return new Duration((long) (dDoubleValue * 60000.0d));
        }
        if (strGroup2.equalsIgnoreCase("hour")) {
            return new Duration((long) (dDoubleValue * 3600000.0d));
        }
        if (strGroup2.equalsIgnoreCase("day")) {
            return new Duration((long) (dDoubleValue * 8.64E7d));
        }
        throw new IllegalStateException("Unexpected ".concat(strGroup2));
    }

    public final String toString() {
        long j2 = this.f13804a;
        if (j2 >= 1000) {
            return j2 < DateUtils.MILLIS_PER_MINUTE ? b.p(new StringBuilder(), j2 / 1000, " seconds") : j2 < DateUtils.MILLIS_PER_HOUR ? b.p(new StringBuilder(), j2 / DateUtils.MILLIS_PER_MINUTE, " minutes") : b.p(new StringBuilder(), j2 / DateUtils.MILLIS_PER_HOUR, " hours");
        }
        return j2 + " milliseconds";
    }
}
