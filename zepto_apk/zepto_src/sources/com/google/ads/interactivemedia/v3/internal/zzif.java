package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.content.pm.PackageInfo;

/* loaded from: classes3.dex */
final class zzif implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzih zzb;

    public zzif(zzih zzihVar, int i2, boolean z) {
        this.zza = i2;
        this.zzb = zzihVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException {
        zzbc zzbcVarZza;
        int i2 = this.zza;
        zzih zzihVar = this.zzb;
        if (i2 > 0) {
            try {
                Thread.sleep(i2 * 1000);
            } catch (InterruptedException unused) {
            }
        }
        try {
            PackageInfo packageInfo = zzihVar.zza.getPackageManager().getPackageInfo(zzihVar.zza.getPackageName(), 0);
            Context context = zzihVar.zza;
            zzbcVarZza = zzmw.zza(context, context.getPackageName(), Integer.toString(packageInfo.versionCode));
        } catch (Throwable unused2) {
            zzbcVarZza = null;
        }
        this.zzb.zzm = zzbcVarZza;
        if (this.zza < 4) {
            if (zzbcVarZza != null && zzbcVarZza.zzaj() && !zzbcVarZza.zzg().equals("0000000000000000000000000000000000000000000000000000000000000000") && zzbcVarZza.zzak() && zzbcVarZza.zze().zzd() && zzbcVarZza.zze().zza() != -2) {
                return;
            }
            this.zzb.zzo(this.zza + 1, true);
        }
    }
}
