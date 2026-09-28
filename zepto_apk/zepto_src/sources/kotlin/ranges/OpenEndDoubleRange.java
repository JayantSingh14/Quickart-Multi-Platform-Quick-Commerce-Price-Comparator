package kotlin.ranges;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
final class OpenEndDoubleRange implements OpenEndRange<Double> {
    public final boolean equals(Object obj) {
        if (!(obj instanceof OpenEndDoubleRange)) {
            return false;
        }
        ((OpenEndDoubleRange) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return -1;
    }

    public final String toString() {
        return "0.0..<0.0";
    }
}
