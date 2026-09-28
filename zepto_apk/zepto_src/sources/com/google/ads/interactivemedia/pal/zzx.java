package com.google.ads.interactivemedia.pal;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.pal.zzjb;
import com.google.android.gms.internal.pal.zzjc;
import java.util.Random;

/* loaded from: classes3.dex */
public final class zzx {

    @VisibleForTesting
    static final boolean zza;
    private final zzs zzb;
    private final boolean zzc;

    static {
        zza = new Random().nextInt(100) <= 0;
    }

    @VisibleForTesting
    public zzx(zzs zzsVar, boolean z) {
        this.zzb = zzsVar;
        this.zzc = z;
    }

    public final void zza(int i2) {
        if (this.zzc) {
            this.zzb.zza("pal_native", zzt.ERROR_EVENT.zza(), zzjc.c(String.valueOf(i2), zzu.ERROR_CODE.zza()));
        }
    }

    public final void zzb(zzw zzwVar) {
        if (this.zzc) {
            zzjb zzjbVar = new zzjb();
            zzjbVar.a(zzu.NONCE_LOADER_INIT_TIME.zza(), String.valueOf(zzwVar.zzc().f37520a));
            zzjbVar.a(zzu.NONCE_REQUESTED_TIME.zza(), String.valueOf(zzwVar.zzd().f37520a));
            zzjbVar.a(zzu.NONCE_LOADED_TIME.zza(), String.valueOf(zzwVar.zzb().f37520a));
            zzjbVar.a(zzu.SERVICE_START_TIME.zza(), String.valueOf(zzwVar.zzf().f37520a));
            zzjbVar.a(zzu.SERVICE_END_TIME.zza(), String.valueOf(zzwVar.zze().f37520a));
            zzjbVar.a(zzu.NONCE_LENGTH.zza(), String.valueOf(zzwVar.zza()));
            this.zzb.zza("pal_native", zzt.NONCE_LOADED.zza(), zzjbVar.c());
        }
    }
}
