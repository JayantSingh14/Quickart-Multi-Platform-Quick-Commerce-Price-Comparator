package com.google.android.gms.internal.atv_ads_framework;

/* loaded from: classes4.dex */
final class zzfx extends zzfy {
    @Override // com.google.android.gms.internal.atv_ads_framework.zzfy
    public final double a(Object obj, long j2) {
        return Double.longBitsToDouble(this.f36209a.getLong(obj, j2));
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzfy
    public final float b(Object obj, long j2) {
        return Float.intBitsToFloat(this.f36209a.getInt(obj, j2));
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzfy
    public final void c(Object obj, long j2, boolean z) {
        if (zzfz.f36216g) {
            zzfz.b(obj, j2, z ? (byte) 1 : (byte) 0);
        } else {
            zzfz.c(obj, j2, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzfy
    public final void d(Object obj, long j2, byte b2) {
        if (zzfz.f36216g) {
            zzfz.b(obj, j2, b2);
        } else {
            zzfz.c(obj, j2, b2);
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzfy
    public final void e(Object obj, long j2, double d2) {
        this.f36209a.putLong(obj, j2, Double.doubleToLongBits(d2));
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzfy
    public final void f(Object obj, long j2, float f2) {
        this.f36209a.putInt(obj, j2, Float.floatToIntBits(f2));
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzfy
    public final boolean g(Object obj, long j2) {
        return zzfz.f36216g ? zzfz.l(obj, j2) : zzfz.m(obj, j2);
    }
}
