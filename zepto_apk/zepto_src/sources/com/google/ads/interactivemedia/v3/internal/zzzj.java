package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;

/* loaded from: classes3.dex */
final class zzzj implements zzuv {
    final /* synthetic */ Class zza;
    final /* synthetic */ zzuu zzb;

    public zzzj(Class cls, zzuu zzuuVar) {
        this.zza = cls;
        this.zzb = zzuuVar;
    }

    public final String toString() {
        return b.m("Factory[typeHierarchy=", this.zza.getName(), ",adapter=", this.zzb.toString(), "]");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuv
    public final zzuu zza(zztx zztxVar, zzaao zzaaoVar) {
        Class cls = this.zza;
        Class<?> clsZzc = zzaaoVar.zzc();
        if (cls.isAssignableFrom(clsZzc)) {
            return new zzzi(this, clsZzc);
        }
        return null;
    }
}
