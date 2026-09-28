package kotlin.ranges;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
final class ClosedFloatRange implements ClosedFloatingPointRange<Float> {
    @Override // kotlin.ranges.ClosedRange
    public final /* bridge */ /* synthetic */ Comparable b() {
        return Float.valueOf(0.0f);
    }

    @Override // kotlin.ranges.ClosedRange
    public final /* bridge */ /* synthetic */ Comparable d() {
        return Float.valueOf(0.0f);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ClosedFloatRange)) {
            return false;
        }
        ClosedFloatRange closedFloatRange = (ClosedFloatRange) obj;
        closedFloatRange.getClass();
        closedFloatRange.getClass();
        return true;
    }

    public final int hashCode() {
        return Float.hashCode(0.0f) + (Float.hashCode(0.0f) * 31);
    }

    public final String toString() {
        return "0.0..0.0";
    }
}
