package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzgx implements Runnable {
    final /* synthetic */ zzgy zza;

    public zzgx(zzgy zzgyVar) {
        this.zza = zzgyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zBooleanValue;
        if (this.zza.zzb != null) {
            return;
        }
        synchronized (zzgy.zzc) {
            if (this.zza.zzb != null) {
                return;
            }
            boolean z = false;
            try {
                zBooleanValue = ((Boolean) zzlg.zzct.zzb()).booleanValue();
            } catch (IllegalStateException unused) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                try {
                    zzgy.zza = zzoe.zzb(this.zza.zze.zza, "ADSHIELD", null);
                    z = zBooleanValue;
                } catch (Throwable unused2) {
                }
            } else {
                z = zBooleanValue;
            }
            this.zza.zzb = Boolean.valueOf(z);
            zzgy.zzc.open();
        }
    }
}
