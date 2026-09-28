package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzpq extends zzpk {
    final zzpy zza;
    final Object zzb;
    int zzc;

    public zzpq(zzpy zzpyVar, int i2) {
        this.zza = zzpyVar;
        this.zzb = zzpyVar.zzb[i2];
        this.zzc = i2;
    }

    private final void zza() {
        int i2 = this.zzc;
        if (i2 != -1) {
            zzpy zzpyVar = this.zza;
            if (i2 <= zzpyVar.zzc && zzox.zza(this.zzb, zzpyVar.zzb[i2])) {
                return;
            }
        }
        zzpy zzpyVar2 = this.zza;
        Object obj = this.zzb;
        this.zzc = zzpyVar2.zzd(obj, zzpz.zzc(obj));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzpk, java.util.Map.Entry
    public final Object getKey() {
        return this.zzb;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzpk, java.util.Map.Entry
    public final Object getValue() {
        zza();
        int i2 = this.zzc;
        if (i2 == -1) {
            return null;
        }
        return this.zza.zza[i2];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzpk, java.util.Map.Entry
    public final Object setValue(Object obj) {
        zza();
        int i2 = this.zzc;
        if (i2 == -1) {
            this.zza.zzh(this.zzb, obj, false);
            return null;
        }
        Object obj2 = this.zza.zza[i2];
        if (zzox.zza(obj2, obj)) {
            return obj;
        }
        this.zza.zzv(this.zzc, obj, false);
        return obj2;
    }
}
