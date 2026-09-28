package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.ranges.ClosedRange;

@Metadata
/* loaded from: classes3.dex */
class ComparableRange<T extends Comparable<? super T>> implements ClosedRange<T> {
    @Override // kotlin.ranges.ClosedRange
    public final Comparable b() {
        return null;
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable d() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ComparableRange)) {
            return false;
        }
        if (ClosedRange.DefaultImpls.a(this)) {
            ComparableRange comparableRange = (ComparableRange) obj;
            comparableRange.getClass();
            if (ClosedRange.DefaultImpls.a(comparableRange)) {
                return true;
            }
        }
        ComparableRange comparableRange2 = (ComparableRange) obj;
        comparableRange2.getClass();
        comparableRange2.getClass();
        return true;
    }

    public final int hashCode() {
        if (ClosedRange.DefaultImpls.a(this)) {
            return -1;
        }
        throw null;
    }

    public final String toString() {
        return "null..null";
    }
}
