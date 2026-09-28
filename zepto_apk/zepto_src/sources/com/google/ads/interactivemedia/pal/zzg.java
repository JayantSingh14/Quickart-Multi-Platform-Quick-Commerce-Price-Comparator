package com.google.ads.interactivemedia.pal;

import android.support.v4.media.b;
import androidx.fragment.app.e;

/* loaded from: classes3.dex */
final class zzg extends zzq {
    private final String zza;
    private final String zzb;
    private final String zzc;

    public /* synthetic */ zzg(String str, String str2, String str3, zzf zzfVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzq) {
            zzq zzqVar = (zzq) obj;
            if (this.zza.equals(zzqVar.zzb()) && this.zzb.equals(zzqVar.zzc()) && this.zzc.equals(zzqVar.zza())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode();
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        return b.r(e.v("Gen204LoggerData{palVersion=", str, ", sdkVersion=", str2, ", correlator="), this.zzc, "}");
    }

    @Override // com.google.ads.interactivemedia.pal.zzq
    public final String zza() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.pal.zzq
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.pal.zzq
    public final String zzc() {
        return this.zzb;
    }
}
