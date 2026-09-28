package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzsg extends zzrx {

    @CheckForNull
    private zzsf zza;

    public zzsg(zzqb zzqbVar, boolean z, Executor executor, Callable callable) {
        super(zzqbVar, false, false);
        this.zza = new zzse(this, callable, executor);
        zzq();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzrq
    public final void zzn() {
        zzsf zzsfVar = this.zza;
        if (zzsfVar != null) {
            zzsfVar.zzh();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzrx
    public final void zzp() {
        zzsf zzsfVar = this.zza;
        if (zzsfVar != null) {
            zzsfVar.zzf();
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzrx
    public final void zzr(int i2) {
        super.zzr(i2);
        if (i2 == 1) {
            this.zza = null;
        }
    }
}
