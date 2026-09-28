package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;

/* loaded from: classes5.dex */
public class MutableInt extends Number implements Comparable<MutableInt>, Mutable<Number> {
    private static final long serialVersionUID = 512176391864L;
    private int value;

    public MutableInt() {
    }

    public void add(int i2) {
        this.value += i2;
    }

    public int addAndGet(int i2) {
        int i3 = this.value + i2;
        this.value = i3;
        return i3;
    }

    public void decrement() {
        this.value--;
    }

    public int decrementAndGet() {
        int i2 = this.value - 1;
        this.value = i2;
        return i2;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableInt) && this.value == ((MutableInt) obj).intValue();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    public int getAndAdd(int i2) {
        int i3 = this.value;
        this.value = i2 + i3;
        return i3;
    }

    public int getAndDecrement() {
        int i2 = this.value;
        this.value = i2 - 1;
        return i2;
    }

    public int getAndIncrement() {
        int i2 = this.value;
        this.value = i2 + 1;
        return i2;
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value++;
    }

    public int incrementAndGet() {
        int i2 = this.value + 1;
        this.value = i2;
        return i2;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public void subtract(int i2) {
        this.value -= i2;
    }

    public Integer toInteger() {
        return Integer.valueOf(intValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableInt(int i2) {
        this.value = i2;
    }

    public void add(Number number) {
        this.value = number.intValue() + this.value;
    }

    public int addAndGet(Number number) {
        int iIntValue = number.intValue() + this.value;
        this.value = iIntValue;
        return iIntValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(MutableInt mutableInt) {
        return NumberUtils.compare(this.value, mutableInt.value);
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public Number getValue2() {
        return Integer.valueOf(this.value);
    }

    public void setValue(int i2) {
        this.value = i2;
    }

    public void subtract(Number number) {
        this.value -= number.intValue();
    }

    public int getAndAdd(Number number) {
        int i2 = this.value;
        this.value = number.intValue() + i2;
        return i2;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.intValue();
    }

    public MutableInt(Number number) {
        this.value = number.intValue();
    }

    public MutableInt(String str) throws NumberFormatException {
        this.value = Integer.parseInt(str);
    }
}
