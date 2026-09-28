package org.shadow.apache.commons.lang3.mutable;

/* loaded from: classes5.dex */
public class MutableDouble extends Number implements Comparable<MutableDouble>, Mutable<Number> {
    @Override // java.lang.Comparable
    public final int compareTo(MutableDouble mutableDouble) {
        mutableDouble.getClass();
        return Double.compare(0.0d, 0.0d);
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return 0.0d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof MutableDouble)) {
            return false;
        }
        ((MutableDouble) obj).getClass();
        return Double.doubleToLongBits(0.0d) == Double.doubleToLongBits(0.0d);
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return (float) 0.0d;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(0.0d);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    @Override // java.lang.Number
    public final int intValue() {
        return (int) 0.0d;
    }

    @Override // java.lang.Number
    public final long longValue() {
        return (long) 0.0d;
    }

    public final String toString() {
        return String.valueOf(0.0d);
    }
}
