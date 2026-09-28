package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzpp extends zzpk {
    final Object zza;
    int zzb;
    final /* synthetic */ zzpy zzc;

    public zzpp(zzpy zzpyVar, int i2) {
        this.zzc = zzpyVar;
        this.zza = zzpyVar.zza[i2];
        this.zzb = i2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzpk, java.util.Map.Entry
    public final Object getKey() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzpk, java.util.Map.Entry
    public final Object getValue() {
        zza();
        int i2 = this.zzb;
        if (i2 == -1) {
            return null;
        }
        return this.zzc.zzb[i2];
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzpk, java.util.Map.Entry
    public final Object setValue(Object obj) {
        zza();
        int i2 = this.zzb;
        if (i2 == -1) {
            this.zzc.zzg(this.zza, obj, false);
            return null;
        }
        Object obj2 = this.zzc.zzb[i2];
        if (zzox.zza(obj2, obj)) {
            return obj;
        }
        this.zzc.zzw(this.zzb, obj, false);
        return obj2;
    }

    public final void zza() {
        int i2 = this.zzb;
        if (i2 != -1) {
            zzpy zzpyVar = this.zzc;
            if (i2 <= zzpyVar.zzc && zzox.zza(zzpyVar.zza[i2], this.zza)) {
                return;
            }
        }
        zzpy zzpyVar2 = this.zzc;
        Object obj = this.zza;
        this.zzb = zzpyVar2.zzc(obj, zzpz.zzc(obj));
    }
}
