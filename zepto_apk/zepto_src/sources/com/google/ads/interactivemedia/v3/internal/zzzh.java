package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import androidx.fragment.app.e;

/* loaded from: classes3.dex */
final class zzzh implements zzuv {
    final /* synthetic */ Class zza;
    final /* synthetic */ Class zzb;
    final /* synthetic */ zzuu zzc;

    public zzzh(Class cls, Class cls2, zzuu zzuuVar) {
        this.zza = cls;
        this.zzb = cls2;
        this.zzc = zzuuVar;
    }

    public final String toString() {
        zzuu zzuuVar = this.zzc;
        Class cls = this.zzb;
        String name = this.zza.getName();
        String name2 = cls.getName();
        return b.r(e.v("Factory[type=", name, "+", name2, ",adapter="), zzuuVar.toString(), "]");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuv
    public final zzuu zza(zztx zztxVar, zzaao zzaaoVar) {
        Class clsZzc = zzaaoVar.zzc();
        if (clsZzc == this.zza || clsZzc == this.zzb) {
            return this.zzc;
        }
        return null;
    }
}
