package org.apache.commons.lang3.mutable;

import org.apache.commons.lang3.math.NumberUtils;

/* loaded from: classes5.dex */
public class MutableLong extends Number implements Comparable<MutableLong>, Mutable<Number> {
    private static final long serialVersionUID = 62986528375L;
    private long value;

    public MutableLong() {
    }

    public void add(long j2) {
        this.value += j2;
    }

    public long addAndGet(long j2) {
        long j3 = this.value + j2;
        this.value = j3;
        return j3;
    }

    public void decrement() {
        this.value--;
    }

    public long decrementAndGet() {
        long j2 = this.value - 1;
        this.value = j2;
        return j2;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableLong) && this.value == ((MutableLong) obj).longValue();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    public long getAndAdd(long j2) {
        long j3 = this.value;
        this.value = j2 + j3;
        return j3;
    }

    public long getAndDecrement() {
        long j2 = this.value;
        this.value = j2 - 1;
        return j2;
    }

    public long getAndIncrement() {
        long j2 = this.value;
        this.value = 1 + j2;
        return j2;
    }

    public int hashCode() {
        long j2 = this.value;
        return (int) (j2 ^ (j2 >>> 32));
    }

    public void increment() {
        this.value++;
    }

    public long incrementAndGet() {
        long j2 = this.value + 1;
        this.value = j2;
        return j2;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public void subtract(long j2) {
        this.value -= j2;
    }

    public Long toLong() {
        return Long.valueOf(longValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableLong(long j2) {
        this.value = j2;
    }

    public void add(Number number) {
        this.value = number.longValue() + this.value;
    }

    public long addAndGet(Number number) {
        long jLongValue = number.longValue() + this.value;
        this.value = jLongValue;
        return jLongValue;
    }

    @Override // java.lang.Comparable
    public int compareTo(MutableLong mutableLong) {
        return NumberUtils.compare(this.value, mutableLong.value);
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    /* renamed from: getValue */
    public Number getValue2() {
        return Long.valueOf(this.value);
    }

    public void setValue(long j2) {
        this.value = j2;
    }

    public void subtract(Number number) {
        this.value -= number.longValue();
    }

    public long getAndAdd(Number number) {
        long j2 = this.value;
        this.value = number.longValue() + j2;
        return j2;
    }

    @Override // org.apache.commons.lang3.mutable.Mutable
    public void setValue(Number number) {
        this.value = number.longValue();
    }

    public MutableLong(Number number) {
        this.value = number.longValue();
    }

    public MutableLong(String str) throws NumberFormatException {
        this.value = Long.parseLong(str);
    }
}
