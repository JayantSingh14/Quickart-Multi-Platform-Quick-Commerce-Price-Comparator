package org.shadow.apache.commons.lang3.mutable;

/* loaded from: classes5.dex */
public class MutableFloat extends Number implements Comparable<MutableFloat>, Mutable<Number> {
    @Override // java.lang.Comparable
    public final int compareTo(MutableFloat mutableFloat) {
        mutableFloat.getClass();
        return Float.compare(0.0f, 0.0f);
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return 0.0f;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof MutableFloat)) {
            return false;
        }
        ((MutableFloat) obj).getClass();
        return Float.floatToIntBits(0.0f) == Float.floatToIntBits(0.0f);
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return 0.0f;
    }

    public final int hashCode() {
        return Float.floatToIntBits(0.0f);
    }

    @Override // java.lang.Number
    public final int intValue() {
        return (int) 0.0f;
    }

    @Override // java.lang.Number
    public final long longValue() {
        return (long) 0.0f;
    }

    public final String toString() {
        return String.valueOf(0.0f);
    }
}
