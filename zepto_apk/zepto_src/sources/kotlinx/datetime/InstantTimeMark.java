package kotlinx.datetime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;
import kotlin.time.Duration;
import kotlin.time.ExperimentalTime;

@Metadata
@ExperimentalTime
/* loaded from: classes3.dex */
final class InstantTimeMark implements ComparableTimeMark {
    @Override // java.lang.Comparable
    public final int compareTo(ComparableTimeMark comparableTimeMark) {
        return ComparableTimeMark.DefaultImpls.a(this, comparableTimeMark);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof InstantTimeMark)) {
            return false;
        }
        InstantTimeMark instantTimeMark = (InstantTimeMark) obj;
        instantTimeMark.getClass();
        instantTimeMark.getClass();
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    @Override // kotlin.time.ComparableTimeMark
    public final long j(ComparableTimeMark other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof InstantTimeMark) {
            ((InstantTimeMark) other).getClass();
            Duration.f54014b.getClass();
            return 0L;
        }
        throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
    }

    public final String toString() {
        return "InstantTimeMark(null, null)";
    }
}
