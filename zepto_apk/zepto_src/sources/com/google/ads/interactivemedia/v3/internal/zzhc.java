package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzhc implements zznh {
    final /* synthetic */ zzhd zza;

    public zzhc(zzhd zzhdVar) {
        this.zza = zzhdVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zznh
    public final void zza(int i2, long j2) {
        this.zza.zzd.zzd(i2, System.currentTimeMillis() - j2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zznh
    public final void zzb(int i2, long j2, String str) {
        this.zza.zzd.zze(i2, System.currentTimeMillis() - j2, str);
    }
}
