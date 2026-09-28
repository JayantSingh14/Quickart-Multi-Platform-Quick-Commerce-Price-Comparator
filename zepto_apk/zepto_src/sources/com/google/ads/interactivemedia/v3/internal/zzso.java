package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
final class zzso implements Runnable {
    final Future zza;
    final zzsn zzb;

    public zzso(Future future, zzsn zzsnVar) {
        this.zza = future;
        this.zzb = zzsnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable thZza;
        Object obj = this.zza;
        if ((obj instanceof zztm) && (thZza = zztn.zza((zztm) obj)) != null) {
            this.zzb.zza(thZza);
            return;
        }
        try {
            this.zzb.zzb(zzsr.zzb(this.zza));
        } catch (ExecutionException e2) {
            this.zzb.zza(e2.getCause());
        } catch (Throwable th) {
            this.zzb.zza(th);
        }
    }

    public final String toString() {
        zzov zzovVarZza = zzow.zza(this);
        zzovVarZza.zzb(this.zzb);
        return zzovVarZza.toString();
    }
}
