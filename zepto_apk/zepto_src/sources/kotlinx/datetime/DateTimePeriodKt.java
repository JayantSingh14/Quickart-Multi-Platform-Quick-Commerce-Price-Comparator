package kotlinx.datetime;

import android.support.v4.media.b;
import kotlin.Metadata;
import org.xbill.DNS.TTL;

@Metadata
/* loaded from: classes3.dex */
public final class DateTimePeriodKt {
    public static final DateTimePeriod a(int i2, int i3, int i4, int i5, int i6, int i7, long j2) {
        int iB = b(i2, i3);
        long j3 = 60;
        long j4 = ((i5 * j3) + i6) * j3;
        long j5 = 1000000000;
        long j6 = (j2 / j5) + j4 + i7;
        try {
            long j7 = j2 % j5;
            if (j6 > 0 && j7 < 0) {
                j6--;
                j7 += 1000000000;
            } else if (j6 < 0 && j7 > 0) {
                j6++;
                j7 -= 1000000000;
            }
            long jAddExact = Math.addExact(Math.multiplyExact(j6, 1000000000L), j7);
            return jAddExact != 0 ? new DateTimePeriodImpl(iB, i4, jAddExact) : new DatePeriod(iB, i4);
        } catch (ArithmeticException unused) {
            StringBuilder sbT = b.t(i5, i6, "The total number of nanoseconds in ", " hours, ", " minutes, ");
            sbT.append(i7);
            sbT.append(" seconds, and ");
            sbT.append(j2);
            sbT.append(" nanoseconds overflows a Long");
            throw new IllegalArgumentException(sbT.toString());
        }
    }

    public static final int b(int i2, int i3) {
        long j2 = (i2 * 12) + i3;
        if (-2147483648L > j2 || j2 > TTL.MAX_VALUE) {
            throw new IllegalArgumentException(b.e(i2, i3, "The total number of months in ", " years and ", " months overflows an Int"));
        }
        return (int) j2;
    }
}
