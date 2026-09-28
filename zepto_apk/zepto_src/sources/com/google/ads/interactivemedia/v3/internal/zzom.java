package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzom extends zzrq {
    Object zza;

    public zzom(Object obj, Runnable runnable) {
        this.zza = obj;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzrq
    public final String zza() {
        Object obj = this.zza;
        return obj == null ? "" : obj.toString();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzrq
    public final void zzb() {
        this.zza = null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzrq
    public final boolean zzc(Object obj) {
        return super.zzc(obj);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzrq
    public final boolean zzd(Throwable th) {
        return super.zzd(th);
    }
}
