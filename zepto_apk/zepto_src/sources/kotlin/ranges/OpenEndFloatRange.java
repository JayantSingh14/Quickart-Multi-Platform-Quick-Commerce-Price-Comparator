package kotlin.ranges;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
final class OpenEndFloatRange implements OpenEndRange<Float> {
    public final boolean equals(Object obj) {
        if (!(obj instanceof OpenEndFloatRange)) {
            return false;
        }
        ((OpenEndFloatRange) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return -1;
    }

    public final String toString() {
        return "0.0..<0.0";
    }
}
