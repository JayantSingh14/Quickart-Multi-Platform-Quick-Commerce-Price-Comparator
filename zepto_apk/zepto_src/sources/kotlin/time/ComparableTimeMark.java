package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;

@SinceKotlin
@Metadata
@WasExperimental
/* loaded from: classes3.dex */
public interface ComparableTimeMark extends TimeMark, Comparable<ComparableTimeMark> {

    @Metadata
    public static final class DefaultImpls {
        public static int a(ComparableTimeMark comparableTimeMark, ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            long j2 = comparableTimeMark.j(other);
            Duration.f54014b.getClass();
            return Duration.c(j2, 0L);
        }
    }

    long j(ComparableTimeMark comparableTimeMark);
}
