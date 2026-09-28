package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Type;
import java.util.Map;

/* loaded from: classes3.dex */
public final class zzxo implements zzuv {
    private final zzvw zza;

    public zzxo(zzvw zzvwVar, boolean z) {
        this.zza = zzvwVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuv
    public final zzuu zza(zztx zztxVar, zzaao zzaaoVar) {
        Type typeZzd = zzaaoVar.zzd();
        Class clsZzc = zzaaoVar.zzc();
        if (!Map.class.isAssignableFrom(clsZzc)) {
            return null;
        }
        Type[] typeArrZzh = zzvc.zzh(typeZzd, clsZzc);
        Type type = typeArrZzh[0];
        return new zzxn(this, zztxVar, typeArrZzh[0], (type == Boolean.TYPE || type == Boolean.class) ? zzzt.zzf : zztxVar.zza(zzaao.zzb(type)), typeArrZzh[1], zztxVar.zza(zzaao.zzb(typeArrZzh[1])), this.zza.zza(zzaaoVar));
    }
}
