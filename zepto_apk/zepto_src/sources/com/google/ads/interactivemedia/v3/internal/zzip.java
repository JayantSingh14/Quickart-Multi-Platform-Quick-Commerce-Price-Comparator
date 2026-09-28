package com.google.ads.interactivemedia.v3.internal;

import android.app.AppOpsManager$OnOpActiveChangedListener;

/* loaded from: classes3.dex */
final class zzip implements AppOpsManager$OnOpActiveChangedListener {
    final /* synthetic */ zziq zza;

    public zzip(zziq zziqVar) {
        this.zza = zziqVar;
    }

    public final void onOpActiveChanged(String str, int i2, String str2, boolean z) {
        if (z) {
            this.zza.zzb = System.currentTimeMillis();
            this.zza.zze = true;
            return;
        }
        zziq zziqVar = this.zza;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (zziqVar.zzc > 0) {
            zziq zziqVar2 = this.zza;
            if (jCurrentTimeMillis >= zziqVar2.zzc) {
                zziqVar2.zzd = jCurrentTimeMillis - zziqVar2.zzc;
            }
        }
        this.zza.zze = false;
    }
}
