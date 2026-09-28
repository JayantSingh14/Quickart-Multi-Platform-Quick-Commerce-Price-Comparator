package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;

/* loaded from: classes3.dex */
public final class zzbs {
    private boolean zza;

    public final void zza(Context context) {
        zzcy.zzb(context, "Application Context cannot be null");
        if (this.zza) {
            return;
        }
        this.zza = true;
        zzch.zzb().zzd(context);
        zzby.zza().zzd(context);
        zzcs.zzb(context);
        zzct.zzd(context);
        zzcw.zza(context);
        zzce.zzb().zzc(context);
        zzbx.zza().zzd(context);
    }

    public final boolean zzb() {
        return this.zza;
    }
}
