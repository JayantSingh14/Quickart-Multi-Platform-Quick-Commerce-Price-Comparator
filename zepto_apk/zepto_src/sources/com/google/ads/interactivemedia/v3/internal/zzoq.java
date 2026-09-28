package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzoq implements zzuv {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuv
    public final zzuu zza(zztx zztxVar, zzaao zzaaoVar) {
        Class clsZzc = zzaaoVar.zzc();
        zzoo zzooVar = (zzoo) clsZzc.getAnnotation(zzoo.class);
        if (zzooVar == null || clsZzc == zzooVar.zza()) {
            return null;
        }
        return zztxVar.zza(zzaao.zza(zzooVar.zza()));
    }
}
