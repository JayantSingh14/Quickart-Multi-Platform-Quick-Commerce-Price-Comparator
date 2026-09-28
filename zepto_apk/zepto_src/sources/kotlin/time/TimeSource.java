package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;
import org.jetbrains.annotations.NotNull;

@SinceKotlin
@Metadata
@WasExperimental
/* loaded from: classes3.dex */
public interface TimeSource {

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class Monotonic implements WithComparableMarks {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final Monotonic f54030a = new Monotonic();

        @SinceKotlin
        @Metadata
        @JvmInline
        @WasExperimental
        public static final class ValueTimeMark implements ComparableTimeMark {
            @Override // java.lang.Comparable
            public final int compareTo(ComparableTimeMark comparableTimeMark) {
                return ComparableTimeMark.DefaultImpls.a(this, comparableTimeMark);
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof ValueTimeMark)) {
                    return false;
                }
                ((ValueTimeMark) obj).getClass();
                return true;
            }

            public final int hashCode() {
                return Long.hashCode(0L);
            }

            @Override // kotlin.time.ComparableTimeMark
            public final long j(ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                Intrinsics.checkNotNullParameter(other, "other");
                if (other instanceof ValueTimeMark) {
                    ((ValueTimeMark) other).getClass();
                    MonotonicTimeSource.f54029a.getClass();
                    return LongSaturatedMathKt.b(0L, 0L, DurationUnit.f54019b);
                }
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: ValueTimeMark(reading=0) and " + other);
            }

            public final String toString() {
                return "ValueTimeMark(reading=0)";
            }
        }

        public final String toString() {
            MonotonicTimeSource.f54029a.getClass();
            return "TimeSource(System.nanoTime())";
        }
    }

    @SinceKotlin
    @Metadata
    @WasExperimental
    public interface WithComparableMarks extends TimeSource {
    }
}
