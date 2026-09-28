package com.google.ads.interactivemedia.v3.internal;

import sun.misc.Unsafe;

/* loaded from: classes3.dex */
final class zzafr extends zzaft {
    public zzafr(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaft
    public final double zza(Object obj, long j2) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j2));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaft
    public final float zzb(Object obj, long j2) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j2));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaft
    public final void zzc(Object obj, long j2, boolean z) {
        if (zzafu.zzb) {
            zzafu.zzD(obj, j2, z ? (byte) 1 : (byte) 0);
        } else {
            zzafu.zzE(obj, j2, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaft
    public final void zzd(Object obj, long j2, byte b2) {
        if (zzafu.zzb) {
            zzafu.zzD(obj, j2, b2);
        } else {
            zzafu.zzE(obj, j2, b2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaft
    public final void zze(Object obj, long j2, double d2) {
        this.zza.putLong(obj, j2, Double.doubleToLongBits(d2));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaft
    public final void zzf(Object obj, long j2, float f2) {
        this.zza.putInt(obj, j2, Float.floatToIntBits(f2));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzaft
    public final boolean zzg(Object obj, long j2) {
        return zzafu.zzb ? zzafu.zzt(obj, j2) : zzafu.zzu(obj, j2);
    }
}
