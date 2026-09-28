package com.google.ads.interactivemedia.v3.impl;

import android.support.v4.media.b;
import com.google.ads.interactivemedia.v3.internal.zzoy;
import com.google.ads.interactivemedia.v3.internal.zzqf;
import com.google.ads.interactivemedia.v3.internal.zzqi;

/* loaded from: classes3.dex */
final class zzz extends zzt {
    private final zzoy zza;
    private final String zzb;
    private final zzqf zzc;
    private final zzqi zzd;

    public zzz(zzoy zzoyVar, String str, zzqf zzqfVar, zzqi zzqiVar) {
        this.zza = zzoyVar;
        if (str == null) {
            throw new NullPointerException("Null spamMsParameter");
        }
        this.zzb = str;
        if (zzqfVar == null) {
            throw new NullPointerException("Null secureSignals");
        }
        this.zzc = zzqfVar;
        this.zzd = zzqiVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzt) {
            zzt zztVar = (zzt) obj;
            if (this.zza.equals(zztVar.zzb()) && this.zzb.equals(zztVar.zze()) && this.zzc.equals(zztVar.zzc()) && this.zzd.equals(zztVar.zzd())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003) ^ this.zzc.hashCode()) * 1000003) ^ this.zzd.hashCode();
    }

    public final String toString() {
        zzqi zzqiVar = this.zzd;
        zzqf zzqfVar = this.zzc;
        String string = this.zza.toString();
        String string2 = zzqfVar.toString();
        String string3 = zzqiVar.toString();
        StringBuilder sbY = b.y("RequestSignals{identifierInfo=", string, ", spamMsParameter=");
        b.B(sbY, this.zzb, ", secureSignals=", string2, ", platformSignals=");
        return b.r(sbY, string3, "}");
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzt
    public final zzoy zzb() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzt
    public final zzqf zzc() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzt
    public final zzqi zzd() {
        return this.zzd;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzt
    public final String zze() {
        return this.zzb;
    }
}
