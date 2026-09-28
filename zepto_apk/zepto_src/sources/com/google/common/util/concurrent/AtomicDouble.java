package com.google.common.util.concurrent;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public class AtomicDouble extends Number implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final transient AtomicLong f43429a = new AtomicLong(Double.doubleToRawLongBits(0.0d));

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.longBitsToDouble(this.f43429a.get());
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return (float) Double.longBitsToDouble(this.f43429a.get());
    }

    @Override // java.lang.Number
    public final int intValue() {
        return (int) Double.longBitsToDouble(this.f43429a.get());
    }

    @Override // java.lang.Number
    public final long longValue() {
        return (long) Double.longBitsToDouble(this.f43429a.get());
    }

    public final String toString() {
        return Double.toString(Double.longBitsToDouble(this.f43429a.get()));
    }
}
