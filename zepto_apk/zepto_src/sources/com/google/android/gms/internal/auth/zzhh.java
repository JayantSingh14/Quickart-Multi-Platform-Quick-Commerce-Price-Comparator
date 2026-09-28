package com.google.android.gms.internal.auth;

/* loaded from: classes4.dex */
final class zzhh extends zzhi {
    @Override // com.google.android.gms.internal.auth.zzhi
    public final double a(Object obj, long j2) {
        return Double.longBitsToDouble(this.f36423a.getLong(obj, j2));
    }

    @Override // com.google.android.gms.internal.auth.zzhi
    public final float b(Object obj, long j2) {
        return Float.intBitsToFloat(this.f36423a.getInt(obj, j2));
    }

    @Override // com.google.android.gms.internal.auth.zzhi
    public final void c(Object obj, long j2, boolean z) {
        if (zzhj.f36429f) {
            zzhj.f(obj, j2, z);
        } else {
            zzhj.g(obj, j2, z);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzhi
    public final void d(Object obj, long j2, double d2) {
        this.f36423a.putLong(obj, j2, Double.doubleToLongBits(d2));
    }

    @Override // com.google.android.gms.internal.auth.zzhi
    public final void e(Object obj, long j2, float f2) {
        this.f36423a.putInt(obj, j2, Float.floatToIntBits(f2));
    }

    @Override // com.google.android.gms.internal.auth.zzhi
    public final boolean f(long j2, Object obj) {
        return zzhj.f36429f ? zzhj.k(j2, obj) : zzhj.l(j2, obj);
    }
}
