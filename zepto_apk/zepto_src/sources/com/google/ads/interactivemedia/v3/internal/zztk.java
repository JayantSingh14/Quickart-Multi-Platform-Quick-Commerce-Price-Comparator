package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
final class zztk extends zzsy {
    final /* synthetic */ zztl zza;
    private final Callable zzb;

    public zztk(zztl zztlVar, Callable callable) {
        this.zza = zztlVar;
        callable.getClass();
        this.zzb = callable;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzsy
    public final Object zza() throws Exception {
        return this.zzb.call();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzsy
    public final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzsy
    public final void zzd(Throwable th) {
        this.zza.zzd(th);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzsy
    public final void zze(Object obj) {
        this.zza.zzc(obj);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzsy
    public final boolean zzg() {
        return this.zza.isDone();
    }
}
