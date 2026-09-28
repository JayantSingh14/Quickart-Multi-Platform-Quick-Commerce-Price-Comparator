package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzyf implements zzuv {
    private final zzaao zza;
    private final boolean zzb;
    private final zzuj zzc;
    private final zzub zzd;

    public zzyf(Object obj, zzaao zzaaoVar, boolean z, Class cls) {
        zzuj zzujVar = obj instanceof zzuj ? (zzuj) obj : null;
        this.zzc = zzujVar;
        zzub zzubVar = obj instanceof zzub ? (zzub) obj : null;
        this.zzd = zzubVar;
        boolean z2 = true;
        if (zzujVar == null && zzubVar == null) {
            z2 = false;
        }
        zzuy.zza(z2);
        this.zza = zzaaoVar;
        this.zzb = z;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuv
    public final zzuu zza(zztx zztxVar, zzaao zzaaoVar) {
        if (this.zza.equals(zzaaoVar) || (this.zzb && this.zza.zzd() == zzaaoVar.zzc())) {
            return new zzyg(this.zzc, this.zzd, zztxVar, zzaaoVar, this, true);
        }
        return null;
    }
}
