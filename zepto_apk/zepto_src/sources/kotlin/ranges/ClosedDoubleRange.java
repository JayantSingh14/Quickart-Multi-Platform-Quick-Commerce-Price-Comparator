package kotlin.ranges;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
final class ClosedDoubleRange implements ClosedFloatingPointRange<Double> {
    @Override // kotlin.ranges.ClosedRange
    public final /* bridge */ /* synthetic */ Comparable b() {
        return Double.valueOf(0.0d);
    }

    @Override // kotlin.ranges.ClosedRange
    public final /* bridge */ /* synthetic */ Comparable d() {
        return Double.valueOf(0.0d);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ClosedDoubleRange)) {
            return false;
        }
        ClosedDoubleRange closedDoubleRange = (ClosedDoubleRange) obj;
        closedDoubleRange.getClass();
        closedDoubleRange.getClass();
        return true;
    }

    public final int hashCode() {
        return Double.hashCode(0.0d) + (Double.hashCode(0.0d) * 31);
    }

    public final String toString() {
        return "0.0..0.0";
    }
}
