package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzgv implements Runnable {
    final /* synthetic */ zzgw zza;

    public zzgv(zzgw zzgwVar) {
        this.zza = zzgwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza.zzo) {
            if (this.zza.zzp) {
                return;
            }
            this.zza.zzp = true;
            try {
                zzgw.zzj(this.zza);
            } catch (Exception e2) {
                this.zza.zzh.zzc(2023, -1L, e2);
            }
            synchronized (this.zza.zzo) {
                this.zza.zzp = false;
            }
        }
    }
}
