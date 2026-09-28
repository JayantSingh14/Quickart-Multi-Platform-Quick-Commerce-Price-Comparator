package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* loaded from: classes4.dex */
final class zzol extends zzon {
    public zzol(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void a(Object obj, long j2, byte b2) {
        if (zzoo.f37200g) {
            zzoo.b(obj, j2, b2);
        } else {
            zzoo.c(obj, j2, b2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final boolean b(long j2, Object obj) {
        return zzoo.f37200g ? zzoo.m(obj, j2) : zzoo.n(j2, obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void c(Object obj, long j2, boolean z) {
        if (zzoo.f37200g) {
            zzoo.b(obj, j2, z ? (byte) 1 : (byte) 0);
        } else {
            zzoo.c(obj, j2, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final float d(long j2, Object obj) {
        return Float.intBitsToFloat(this.f37193a.getInt(obj, j2));
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void e(Object obj, long j2, float f2) {
        this.f37193a.putInt(obj, j2, Float.floatToIntBits(f2));
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final double f(long j2, Object obj) {
        return Double.longBitsToDouble(this.f37193a.getLong(obj, j2));
    }

    @Override // com.google.android.gms.internal.measurement.zzon
    public final void g(Object obj, long j2, double d2) {
        this.f37193a.putLong(obj, j2, Double.doubleToLongBits(d2));
    }
}
