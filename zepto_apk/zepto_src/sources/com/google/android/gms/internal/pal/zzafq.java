package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
final class zzafq extends zzafr {
    @Override // com.google.android.gms.internal.pal.zzafr
    public final double a(Object obj, long j2) {
        return Double.longBitsToDouble(k(j2, obj));
    }

    @Override // com.google.android.gms.internal.pal.zzafr
    public final float b(Object obj, long j2) {
        return Float.intBitsToFloat(j(j2, obj));
    }

    @Override // com.google.android.gms.internal.pal.zzafr
    public final void c(Object obj, long j2, boolean z) {
        if (zzafs.f37504g) {
            zzafs.b(obj, j2, z ? (byte) 1 : (byte) 0);
        } else {
            zzafs.c(obj, j2, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzafr
    public final void d(Object obj, long j2, byte b2) {
        if (zzafs.f37504g) {
            zzafs.b(obj, j2, b2);
        } else {
            zzafs.c(obj, j2, b2);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzafr
    public final void e(Object obj, long j2, double d2) {
        o(obj, j2, Double.doubleToLongBits(d2));
    }

    @Override // com.google.android.gms.internal.pal.zzafr
    public final void f(Object obj, long j2, float f2) {
        n(obj, Float.floatToIntBits(f2), j2);
    }

    @Override // com.google.android.gms.internal.pal.zzafr
    public final boolean g(Object obj, long j2) {
        return zzafs.f37504g ? zzafs.i(obj, j2) : zzafs.j(obj, j2);
    }
}
