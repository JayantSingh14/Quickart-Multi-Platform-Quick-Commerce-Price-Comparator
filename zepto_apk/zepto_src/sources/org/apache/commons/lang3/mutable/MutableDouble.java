package org.apache.commons.lang3.mutable;

/* loaded from: classes5.dex */
public class MutableDouble extends Number implements Comparable<MutableDouble>, Mutable<Number> {
    private static final long serialVersionUID = 1587163916;
    private double value;

    public MutableDouble() {
    }

    public void add(double d2) {
        this.value += d2;
    }

    public double addAndGet(double d2) {
        double d3 = this.value + d2;
        this.value = d3;
        return d3;
    }

    public void decrement() {
        this.value -= 1.0d;
    }

    public double decrementAndGet() {
        double d2 = this.value - 1.0d;
        this.value = d2;
        return d2;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableDouble) && Double.doubleToLongBits(((MutableDouble) obj).value) == Double.doubleToLongBits(this.value);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) this.value;
    }

    public double getAndAdd(double d2) {
        double d3 = this.value;
        this.value = d2 + d3;
        return d3;
    }

    public double getAndDecrement() {
        double d2 = this.value;
        this.value = d2 - 1.0d;
        return d2;
    }

    public double getAndIncrement() {
        double d2 = this.value;
        this.value = 1.0d + d2;
        return d2;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.value);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public void increment() {
        this.value += 1.0d;
    }

    public double incrementAndGet() {
        double d2 = this.value + 1.0d;
        this.value = d2;
        return d2;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return Double.isInfinite(this.value);
    }

    public boolean isNaN() {
        return Double.isNaN(this.value);
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) this.value;
    }

    public void subtract(double d2) {
        this.value -= d2;
    }

    public Double toDouble() {
        return Double.valueOf(doubleValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableDouble(double d2) {
        this.value = d2;
    }

    public void add(Number number) {
        this.value = number.doubleValue() + this.value;
    }

    public double addAndGet(Number number) {
        double dDoubleValue = number.doubleValue() + this.value;
        this.value = dDoubleValue;
        return dDoubleValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(MutableDouble mutableDouble) {
        return Double.compare(this.value, mutableDouble.value);
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public Number getValue2() {
        return Double.valueOf(this.value);
    }

    public void setValue(double d2) {
        this.value = d2;
    }

    public void subtract(Number number) {
        this.value -= number.doubleValue();
    }

    public double getAndAdd(Number number) {
        double d2 = this.value;
        this.value = number.doubleValue() + d2;
        return d2;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.doubleValue();
    }

    public MutableDouble(Number number) {
        this.value = number.doubleValue();
    }

    public MutableDouble(String str) throws NumberFormatException {
        this.value = Double.parseDouble(str);
    }
}
