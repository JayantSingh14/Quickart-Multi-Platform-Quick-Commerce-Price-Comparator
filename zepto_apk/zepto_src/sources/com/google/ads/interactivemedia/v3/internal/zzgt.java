package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzgt implements zznh {
    final /* synthetic */ zzmo zza;

    public zzgt(zzmo zzmoVar) {
        this.zza = zzmoVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zznh
    public final void zza(int i2, long j2) {
        this.zza.zzd(i2, System.currentTimeMillis() - j2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zznh
    public final void zzb(int i2, long j2, String str) {
        this.zza.zze(i2, System.currentTimeMillis() - j2, str);
    }
}
