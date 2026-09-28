package org.apache.commons.lang3.mutable;

/* loaded from: classes5.dex */
public class MutableFloat extends Number implements Comparable<MutableFloat>, Mutable<Number> {
    private static final long serialVersionUID = 5787169186L;
    private float value;

    public MutableFloat() {
    }

    public void add(float f2) {
        this.value += f2;
    }

    public float addAndGet(float f2) {
        float f3 = this.value + f2;
        this.value = f3;
        return f3;
    }

    public void decrement() {
        this.value -= 1.0f;
    }

    public float decrementAndGet() {
        float f2 = this.value - 1.0f;
        this.value = f2;
        return f2;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableFloat) && Float.floatToIntBits(((MutableFloat) obj).value) == Float.floatToIntBits(this.value);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    public float getAndAdd(float f2) {
        float f3 = this.value;
        this.value = f2 + f3;
        return f3;
    }

    public float getAndDecrement() {
        float f2 = this.value;
        this.value = f2 - 1.0f;
        return f2;
    }

    public float getAndIncrement() {
        float f2 = this.value;
        this.value = 1.0f + f2;
        return f2;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value);
    }

    public void increment() {
        this.value += 1.0f;
    }

    public float incrementAndGet() {
        float f2 = this.value + 1.0f;
        this.value = f2;
        return f2;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return Float.isInfinite(this.value);
    }

    public boolean isNaN() {
        return Float.isNaN(this.value);
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) this.value;
    }

    public void subtract(float f2) {
        this.value -= f2;
    }

    public Float toFloat() {
        return Float.valueOf(floatValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableFloat(float f2) {
        this.value = f2;
    }

    public void add(Number number) {
        this.value = number.floatValue() + this.value;
    }

    public float addAndGet(Number number) {
        float fFloatValue = number.floatValue() + this.value;
        this.value = fFloatValue;
        return fFloatValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(MutableFloat mutableFloat) {
        return Float.compare(this.value, mutableFloat.value);
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue, reason: merged with bridge method [inline-methods] */
    public Number getValue2() {
        return Float.valueOf(this.value);
    }

    public void setValue(float f2) {
        this.value = f2;
    }

    public void subtract(Number number) {
        this.value -= number.floatValue();
    }

    public float getAndAdd(Number number) {
        float f2 = this.value;
        this.value = number.floatValue() + f2;
        return f2;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.floatValue();
    }

    public MutableFloat(Number number) {
        this.value = number.floatValue();
    }

    public MutableFloat(String str) throws NumberFormatException {
        this.value = Float.parseFloat(str);
    }
}
