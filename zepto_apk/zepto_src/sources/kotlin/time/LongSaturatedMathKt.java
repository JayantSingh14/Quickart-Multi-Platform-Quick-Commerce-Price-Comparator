package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class LongSaturatedMathKt {
    public static final long a(long j2) {
        if (j2 < 0) {
            Duration.f54014b.getClass();
            return Duration.f54016d;
        }
        Duration.f54014b.getClass();
        return Duration.f54015c;
    }

    public static final long b(long j2, long j3, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (((j3 - 1) | 1) == Long.MAX_VALUE) {
            if (j2 != j3) {
                return Duration.l(a(j3));
            }
            Duration.f54014b.getClass();
            return 0L;
        }
        if (((j2 - 1) | 1) == Long.MAX_VALUE) {
            return a(j2);
        }
        long j4 = j2 - j3;
        if (((j4 ^ j2) & (~(j4 ^ j3))) >= 0) {
            return DurationKt.h(j4, unit);
        }
        DurationUnit durationUnit = DurationUnit.f54021d;
        if (unit.compareTo(durationUnit) >= 0) {
            return Duration.l(a(j4));
        }
        long jB = DurationUnitKt__DurationUnitJvmKt.b(1L, durationUnit, unit);
        long j5 = (j2 / jB) - (j3 / jB);
        long j6 = (j2 % jB) - (j3 % jB);
        Duration.Companion companion = Duration.f54014b;
        return Duration.g(DurationKt.h(j5, durationUnit), DurationKt.h(j6, unit));
    }
}
