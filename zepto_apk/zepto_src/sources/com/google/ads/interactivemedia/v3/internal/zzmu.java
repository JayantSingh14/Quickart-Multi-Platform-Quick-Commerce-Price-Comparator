package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzmu extends zzmq {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;

    public /* synthetic */ zzmu(String str, boolean z, boolean z2, zzmt zzmtVar) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzmq) {
            zzmq zzmqVar = (zzmq) obj;
            if (this.zza.equals(zzmqVar.zzb()) && this.zzb == zzmqVar.zzd() && this.zzc == zzmqVar.zzc()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003) ^ (true != this.zzc ? 1237 : 1231);
    }

    public final String toString() {
        return "AdShield2Options{clientVersion=" + this.zza + ", shouldGetAdvertisingId=" + this.zzb + ", isGooglePlayServicesAvailable=" + this.zzc + "}";
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzmq
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzmq
    public final boolean zzc() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzmq
    public final boolean zzd() {
        return this.zzb;
    }
}
