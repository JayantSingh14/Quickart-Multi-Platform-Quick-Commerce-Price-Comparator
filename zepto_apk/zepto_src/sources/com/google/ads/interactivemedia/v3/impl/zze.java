package com.google.ads.interactivemedia.v3.impl;

import android.support.v4.media.b;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.Ad;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.internal.zzox;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class zze implements AdEvent {
    private final AdEvent.AdEventType zza;

    @Nullable
    private final Ad zzb;
    private final Map zzc;

    public zze(AdEvent.AdEventType adEventType, @Nullable Ad ad, Map map) {
        this.zza = adEventType;
        this.zzb = ad;
        this.zzc = map;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zze)) {
            return false;
        }
        zze zzeVar = (zze) obj;
        return this.zza == zzeVar.zza && zzox.zza(this.zzb, zzeVar.zzb) && zzox.zza(this.zzc, zzeVar.zzc);
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdEvent
    public final Ad getAd() {
        return this.zzb;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdEvent
    public final Map<String, String> getAdData() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdEvent
    public final AdEvent.AdEventType getType() {
        return this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc});
    }

    public final String toString() {
        String str = String.format("AdEvent[type=%s, ad=%s", this.zza, this.zzb);
        String strD = "]";
        if (this.zzc != null) {
            StringBuilder sb = new StringBuilder("{");
            Iterator it = this.zzc.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                sb.append((String) entry.getKey());
                sb.append(": ");
                sb.append((String) entry.getValue());
                if (it.hasNext()) {
                    sb.append(", ");
                }
            }
            sb.append("}");
            strD = b.D(", adData=", sb.toString(), "]");
        }
        return str.concat(strD);
    }
}
