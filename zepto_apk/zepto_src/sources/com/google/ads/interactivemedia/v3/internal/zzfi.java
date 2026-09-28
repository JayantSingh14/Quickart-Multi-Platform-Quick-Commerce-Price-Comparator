package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public final class zzfi {
    private final Context zza;
    private final zztb zzb;
    private final zzel zzc;
    private final zzta zzd;

    public zzfi(final Context context, final zztb zztbVar, final zzel zzelVar) {
        this.zza = context;
        this.zzb = zztbVar;
        this.zzc = zzelVar;
        this.zzd = zztbVar.zza(new Callable() { // from class: com.google.ads.interactivemedia.v3.internal.zzfg
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzl zzlVarZza = zzm.zza();
                zzlVarZza.zzd(3);
                zzlVarZza.zzc("a.3.33.0");
                zzlVarZza.zza(false);
                zzlVarZza.zzb(false);
                try {
                    return zzoy.zzg(new zzkh(context, zztbVar, (zzm) zzlVarZza.zzan()));
                } catch (RuntimeException e2) {
                    zzelVar.zzd(com.google.ads.interactivemedia.v3.impl.data.zzbx.SPAM_MS_PARAMETER_LOADER, com.google.ads.interactivemedia.v3.impl.data.zzbz.SETUP_AD_SHIELD, e2);
                    return zzoy.zze();
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String zza(Integer num) {
        if (num == null || num.intValue() <= 0) {
            return zzb();
        }
        zzta zztaVarZza = this.zzb.zza(new Callable() { // from class: com.google.ads.interactivemedia.v3.internal.zzfh
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzb();
            }
        });
        try {
            return (String) zztaVarZza.get(num.intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            this.zzc.zzd(com.google.ads.interactivemedia.v3.impl.data.zzbx.SPAM_MS_PARAMETER_LOADER, com.google.ads.interactivemedia.v3.impl.data.zzbz.GET_SPAM_MS_PARAMETER, e2);
            String str = true != (e2 instanceof TimeoutException) ? "3" : "17";
            zztaVarZza.cancel(false);
            return str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @VisibleForTesting
    @WorkerThread
    public final String zzb() {
        zzoy zzoyVarZze = zzoy.zze();
        try {
            zzoyVarZze = (zzoy) this.zzd.get();
        } catch (InterruptedException | ExecutionException unused) {
        }
        if (!zzoyVarZze.zzd()) {
            return "3";
        }
        try {
            return ((zzkh) zzoyVarZze.zza()).zza(this.zza);
        } catch (RemoteException e2) {
            this.zzc.zzd(com.google.ads.interactivemedia.v3.impl.data.zzbx.SPAM_MS_PARAMETER_LOADER, com.google.ads.interactivemedia.v3.impl.data.zzbz.GET_SPAM_MS_PARAMETER_FROM_ADSHIELD, e2);
            return "3";
        }
    }
}
