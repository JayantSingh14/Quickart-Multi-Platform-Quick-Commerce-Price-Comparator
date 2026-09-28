package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class zzja implements Callable {
    private final zzih zza;
    private final zzaf zzb;

    public zzja(zzih zzihVar, zzaf zzafVar) {
        this.zza = zzihVar;
        this.zzb = zzafVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        if (this.zza.zzl() != null) {
            this.zza.zzl().get();
        }
        zzbc zzbcVarZzc = this.zza.zzc();
        if (zzbcVarZzc == null) {
            return null;
        }
        try {
            synchronized (this.zzb) {
                zzaf zzafVar = this.zzb;
                byte[] bArrZzav = zzbcVarZzc.zzav();
                zzafVar.zzak(bArrZzav, 0, bArrZzav.length, zzacb.zza());
            }
            return null;
        } catch (zzacz | NullPointerException unused) {
            return null;
        }
    }
}
