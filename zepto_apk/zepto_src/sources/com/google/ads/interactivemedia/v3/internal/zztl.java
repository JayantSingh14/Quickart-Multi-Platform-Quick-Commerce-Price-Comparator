package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zztl extends zzsi implements RunnableFuture {

    @CheckForNull
    private volatile zzsy zza;

    public zztl(Callable callable) {
        this.zza = new zztk(this, callable);
    }

    public static zztl zzp(Runnable runnable, Object obj) {
        return new zztl(Executors.callable(runnable, obj));
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzsy zzsyVar = this.zza;
        if (zzsyVar != null) {
            zzsyVar.run();
        }
        this.zza = null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzrq
    @CheckForNull
    public final String zza() {
        zzsy zzsyVar = this.zza;
        return zzsyVar != null ? b.D("task=[", zzsyVar.toString(), "]") : super.zza();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzrq
    public final void zzb() {
        zzsy zzsyVar;
        if (zzo() && (zzsyVar = this.zza) != null) {
            zzsyVar.zzh();
        }
        this.zza = null;
    }
}
