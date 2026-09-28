package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
public final class zzyg<T> extends zzyc<T> {
    final zztx zza;
    private final zzuj zzb;
    private final zzub zzc;
    private final zzaao zzd;
    private final zzuv zze;
    private final zzye zzf = new zzye(this, null);
    private final boolean zzg;
    private volatile zzuu zzh;

    public zzyg(zzuj zzujVar, zzub zzubVar, zztx zztxVar, zzaao zzaaoVar, zzuv zzuvVar, boolean z) {
        this.zzb = zzujVar;
        this.zzc = zzubVar;
        this.zza = zztxVar;
        this.zzd = zzaaoVar;
        this.zze = zzuvVar;
        this.zzg = z;
    }

    public static zzuv zzb(zzaao zzaaoVar, Object obj) {
        return new zzyf(obj, zzaaoVar, zzaaoVar.zzd() == zzaaoVar.zzc(), null);
    }

    private final zzuu zzc() {
        zzuu zzuuVar = this.zzh;
        if (zzuuVar != null) {
            return zzuuVar;
        }
        zzuu zzuuVarZzb = this.zza.zzb(this.zze, this.zzd);
        this.zzh = zzuuVarZzb;
        return zzuuVarZzb;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final T read(zzaaq zzaaqVar) throws zzug, IOException {
        if (this.zzc == null) {
            return (T) zzc().read(zzaaqVar);
        }
        zzuc zzucVarZza = zzwr.zza(zzaaqVar);
        if (this.zzg && (zzucVarZza instanceof zzue)) {
            return null;
        }
        zzub zzubVar = this.zzc;
        this.zzd.zzd();
        return (T) zzubVar.zza();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final void write(zzaas zzaasVar, T t) throws IOException {
        zzuj zzujVar = this.zzb;
        if (zzujVar == null) {
            zzc().write(zzaasVar, t);
            return;
        }
        if (this.zzg && t == null) {
            zzaasVar.zzg();
            return;
        }
        zzaao zzaaoVar = this.zzd;
        ((zzzb) zzzt.zzV).write(zzaasVar, zzujVar.zza(t, zzaaoVar.zzd(), this.zzf));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzyc
    public final zzuu zza() {
        return this.zzb != null ? this : zzc();
    }
}
