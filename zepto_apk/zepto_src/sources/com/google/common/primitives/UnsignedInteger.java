package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {

    /* renamed from: a, reason: collision with root package name */
    public final int f43335a;

    static {
        new UnsignedInteger(0);
        new UnsignedInteger(1);
        new UnsignedInteger(-1);
    }

    public UnsignedInteger(int i2) {
        this.f43335a = i2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(UnsignedInteger unsignedInteger) {
        UnsignedInteger unsignedInteger2 = unsignedInteger;
        unsignedInteger2.getClass();
        int i2 = this.f43335a ^ Integer.MIN_VALUE;
        int i3 = unsignedInteger2.f43335a ^ Integer.MIN_VALUE;
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return longValue();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof UnsignedInteger) && this.f43335a == ((UnsignedInteger) obj).f43335a;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return longValue();
    }

    public final int hashCode() {
        return this.f43335a;
    }

    @Override // java.lang.Number
    public final int intValue() {
        return this.f43335a;
    }

    @Override // java.lang.Number
    public final long longValue() {
        return this.f43335a & 4294967295L;
    }

    public final String toString() {
        return Long.toString(this.f43335a & 4294967295L, 10);
    }
}
