package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdqi implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcdt f28251a;

    public zzdqi(zzdqu zzdquVar, zzcdt zzcdtVar) {
        this.f28251a = zzcdtVar;
        Objects.requireNonNull(zzdquVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.c("Failed to load media data due to video view load failure.");
        this.f28251a.c(th);
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        zzcir zzcirVar = (zzcir) obj;
        zzcdt zzcdtVar = this.f28251a;
        if (zzcirVar == null) {
            zzcdtVar.c(new zzemv(1, "Missing webview from video view future."));
        } else {
            zzcirVar.k0("/video", new zzcgj(new zzdqh(zzcdtVar)));
            zzcirVar.H();
        }
    }
}
