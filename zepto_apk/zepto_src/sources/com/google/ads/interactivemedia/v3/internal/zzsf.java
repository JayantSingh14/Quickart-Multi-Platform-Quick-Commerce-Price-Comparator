package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes3.dex */
abstract class zzsf extends zzsy {
    private final Executor zza;
    final /* synthetic */ zzsg zzb;

    public zzsf(zzsg zzsgVar, Executor executor) {
        this.zzb = zzsgVar;
        executor.getClass();
        this.zza = executor;
    }

    public abstract void zzc(Object obj);

    @Override // com.google.ads.interactivemedia.v3.internal.zzsy
    public final void zzd(Throwable th) {
        this.zzb.zza = null;
        if (th instanceof ExecutionException) {
            this.zzb.zzd(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            this.zzb.cancel(false);
        } else {
            this.zzb.zzd(th);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzsy
    public final void zze(Object obj) {
        this.zzb.zza = null;
        zzc(obj);
    }

    public final void zzf() {
        try {
            this.zza.execute(this);
        } catch (RejectedExecutionException e2) {
            this.zzb.zzd(e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzsy
    public final boolean zzg() {
        return this.zzb.isDone();
    }
}
