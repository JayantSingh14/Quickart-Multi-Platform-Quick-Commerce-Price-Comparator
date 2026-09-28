package com.google.common.hash;

import java.io.Serializable;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class LongAdder extends Striped64 implements Serializable, LongAddable {
    @Override // java.lang.Number
    public final double doubleValue() {
        return this.f43219a;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return this.f43219a;
    }

    @Override // java.lang.Number
    public final int intValue() {
        return (int) this.f43219a;
    }

    @Override // java.lang.Number
    public final long longValue() {
        return this.f43219a;
    }

    public final String toString() {
        return Long.toString(this.f43219a);
    }
}
