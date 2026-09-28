package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzzc implements zzuv {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuv
    public final zzuu zza(zztx zztxVar, zzaao zzaaoVar) {
        Class clsZzc = zzaaoVar.zzc();
        if (!Enum.class.isAssignableFrom(clsZzc) || clsZzc == Enum.class) {
            return null;
        }
        if (!clsZzc.isEnum()) {
            clsZzc = clsZzc.getSuperclass();
        }
        return new zzzs(clsZzc);
    }
}
