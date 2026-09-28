package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
class ComparableOpenEndRange<T extends Comparable<? super T>> implements OpenEndRange<T> {
    public final boolean equals(Object obj) {
        if (obj instanceof ComparableOpenEndRange) {
            throw null;
        }
        return false;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "null..<null";
    }
}
