package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Type;
import java.util.Collection;

/* loaded from: classes3.dex */
public final class zzxa implements zzuv {
    private final zzvw zza;

    public zzxa(zzvw zzvwVar) {
        this.zza = zzvwVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuv
    public final zzuu zza(zztx zztxVar, zzaao zzaaoVar) {
        Type typeZzd = zzaaoVar.zzd();
        Class clsZzc = zzaaoVar.zzc();
        if (!Collection.class.isAssignableFrom(clsZzc)) {
            return null;
        }
        Type typeZzd2 = zzvc.zzd(typeZzd, clsZzc);
        return new zzwz(zztxVar, typeZzd2, zztxVar.zza(zzaao.zzb(typeZzd2)), this.zza.zza(zzaaoVar));
    }
}
