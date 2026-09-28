package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;

/* loaded from: classes3.dex */
final class zzdw extends zzea {
    private final Integer zza;
    private final long zzb;

    public zzdw(Integer num, long j2) {
        this.zza = num;
        this.zzb = j2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzea) {
            zzea zzeaVar = (zzea) obj;
            if (this.zza.equals(zzeaVar.zzb()) && this.zzb == zzeaVar.zza()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() ^ 1000003;
        long j2 = this.zzb;
        return (iHashCode * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EventTimestamp{eventNumber=");
        sb.append(this.zza);
        sb.append(", timestampMs=");
        return b.p(sb, this.zzb, "}");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzea
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzea
    public final Integer zzb() {
        return this.zza;
    }
}
