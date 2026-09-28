package kotlin.ranges;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.LongProgression;
import org.apache.commons.lang3.ClassUtils;

@Metadata
/* loaded from: classes.dex */
public final class RangesKt extends RangesKt___RangesKt {
    public static int b(int i2, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException(b.g(i3, "Cannot coerce value to an empty range: maximum ", " is less than minimum 0."));
        }
        if (i2 < 0) {
            return 0;
        }
        return i2 > i3 ? i3 : i2;
    }

    public static long c(long j2, long j3, long j4) {
        if (j3 <= j4) {
            return j2 < j3 ? j3 : j2 > j4 ? j4 : j2;
        }
        StringBuilder sbV = b.v(j4, "Cannot coerce value to an empty range: maximum ", " is less than minimum ");
        sbV.append(j3);
        sbV.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        throw new IllegalArgumentException(sbV.toString());
    }

    public static IntProgression d(IntRange intRange, int i2) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        RangesKt__RangesKt.a(i2 > 0, Integer.valueOf(i2));
        IntProgression.Companion companion = IntProgression.f53837d;
        int i3 = intRange.f53838a;
        if (intRange.f53840c <= 0) {
            i2 = -i2;
        }
        companion.getClass();
        return new IntProgression(i3, intRange.f53839b, i2);
    }

    public static LongProgression e(LongRange longRange, long j2) {
        Intrinsics.checkNotNullParameter(longRange, "<this>");
        RangesKt__RangesKt.a(j2 > 0, Long.valueOf(j2));
        LongProgression.Companion companion = LongProgression.f53847d;
        long jF = longRange.f();
        long jG = longRange.g();
        if (longRange.i() <= 0) {
            j2 = -j2;
        }
        long j3 = j2;
        companion.getClass();
        return LongProgression.Companion.a(jF, jG, j3);
    }

    public static IntRange f(int i2, int i3) {
        if (i3 > Integer.MIN_VALUE) {
            return new IntRange(i2, i3 - 1, 1);
        }
        IntRange.f53845e.getClass();
        return IntRange.f53846f;
    }
}
