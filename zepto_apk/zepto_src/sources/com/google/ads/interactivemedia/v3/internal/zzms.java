package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzms extends zzmp {
    private String zza;
    private boolean zzb;
    private boolean zzc;
    private byte zzd;

    @Override // com.google.ads.interactivemedia.v3.internal.zzmp
    public final zzmp zza(String str) {
        if (str == null) {
            throw new NullPointerException("Null clientVersion");
        }
        this.zza = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzmp
    public final zzmp zzb(boolean z) {
        this.zzc = true;
        this.zzd = (byte) (this.zzd | 2);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzmp
    public final zzmp zzc(boolean z) {
        this.zzb = z;
        this.zzd = (byte) (this.zzd | 1);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzmp
    public final zzmq zzd() {
        String str;
        if (this.zzd == 3 && (str = this.zza) != null) {
            return new zzmu(str, this.zzb, this.zzc, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" clientVersion");
        }
        if ((this.zzd & 1) == 0) {
            sb.append(" shouldGetAdvertisingId");
        }
        if ((this.zzd & 2) == 0) {
            sb.append(" isGooglePlayServicesAvailable");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
