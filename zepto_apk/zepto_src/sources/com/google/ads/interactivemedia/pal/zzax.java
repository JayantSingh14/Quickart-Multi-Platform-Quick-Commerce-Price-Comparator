package com.google.ads.interactivemedia.pal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.pal.zzjb;

/* loaded from: classes3.dex */
public final class zzax {
    private final zzs zza;
    private final String zzb;

    public zzax(@NonNull zzs zzsVar, @NonNull String str) {
        this.zza = zzsVar;
        this.zzb = str;
    }

    public final void zza(@NonNull int i2, @Nullable String str) {
        if (str == null) {
            str = "null";
        }
        zzjb zzjbVar = new zzjb();
        zzjbVar.a(zzaw.DEVICE_TYPE.zza(), String.valueOf(4));
        zzjbVar.a(zzaw.EVENT_TYPE.zza(), String.valueOf(i2 - 1));
        zzjbVar.a(zzaw.SPAM_CORRELATOR.zza(), this.zzb);
        zzjbVar.a(zzaw.SPAM_SIGNAL.zza(), str);
        this.zza.zza("asscs", "116", zzjbVar.c());
    }
}
