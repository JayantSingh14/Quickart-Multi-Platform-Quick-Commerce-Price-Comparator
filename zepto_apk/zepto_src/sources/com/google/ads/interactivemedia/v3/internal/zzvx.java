package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
final class zzvx extends zzuu {
    final /* synthetic */ boolean zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zztx zzc;
    final /* synthetic */ zzaao zzd;
    final /* synthetic */ zzvy zze;
    private volatile zzuu zzf;

    public zzvx(zzvy zzvyVar, boolean z, boolean z2, zztx zztxVar, zzaao zzaaoVar) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = zztxVar;
        this.zzd = zzaaoVar;
        this.zze = zzvyVar;
    }

    private final zzuu zza() {
        zzuu zzuuVar = this.zzf;
        if (zzuuVar != null) {
            return zzuuVar;
        }
        zzuu zzuuVarZzb = this.zzc.zzb(this.zze, this.zzd);
        this.zzf = zzuuVarZzb;
        return zzuuVarZzb;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final Object read(zzaaq zzaaqVar) throws IOException {
        if (!this.zza) {
            return zza().read(zzaaqVar);
        }
        zzaaqVar.zzo();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final void write(zzaas zzaasVar, Object obj) throws IOException {
        if (this.zzb) {
            zzaasVar.zzg();
        } else {
            zza().write(zzaasVar, obj);
        }
    }
}
