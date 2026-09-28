package kotlin.time;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;
import kotlin.time.TimeSource;

@SinceKotlin
@Metadata
@Deprecated
@ExperimentalTime
/* loaded from: classes3.dex */
public abstract class AbstractDoubleTimeSource implements TimeSource.WithComparableMarks {

    @Metadata
    public static final class DoubleTimeMark implements ComparableTimeMark {
        @Override // java.lang.Comparable
        public final int compareTo(ComparableTimeMark comparableTimeMark) {
            return ComparableTimeMark.DefaultImpls.a(this, comparableTimeMark);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof DoubleTimeMark)) {
                return false;
            }
            ((DoubleTimeMark) obj).getClass();
            j((ComparableTimeMark) obj);
            Duration.f54014b.getClass();
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        @Override // kotlin.time.ComparableTimeMark
        public final long j(ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (!(other instanceof DoubleTimeMark)) {
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
            }
            ((DoubleTimeMark) other).getClass();
            if (Duration.e(0L)) {
                Duration.f54014b.getClass();
                return 0L;
            }
            Duration.g(0L, Duration.l(0L));
            throw null;
        }

        public final String toString() {
            throw null;
        }
    }
}
