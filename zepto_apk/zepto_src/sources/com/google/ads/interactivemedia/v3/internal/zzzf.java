package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;

/* loaded from: classes3.dex */
final class zzzf implements zzuv {
    final /* synthetic */ Class zza;
    final /* synthetic */ zzuu zzb;

    public zzzf(Class cls, zzuu zzuuVar) {
        this.zza = cls;
        this.zzb = zzuuVar;
    }

    public final String toString() {
        return b.m("Factory[type=", this.zza.getName(), ",adapter=", this.zzb.toString(), "]");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuv
    public final zzuu zza(zztx zztxVar, zzaao zzaaoVar) {
        if (zzaaoVar.zzc() == this.zza) {
            return this.zzb;
        }
        return null;
    }
}
