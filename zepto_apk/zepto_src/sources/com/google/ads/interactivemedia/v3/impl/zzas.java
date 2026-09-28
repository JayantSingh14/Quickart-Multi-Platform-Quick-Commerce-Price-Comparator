package com.google.ads.interactivemedia.v3.impl;

import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.AdProgressInfo;
import com.google.ads.interactivemedia.v3.internal.zzagh;
import com.google.ads.interactivemedia.v3.internal.zzagk;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class zzas {
    public final AdEvent.AdEventType zza;

    @Nullable
    public final com.google.ads.interactivemedia.v3.impl.data.zzc zzb;

    @Nullable
    public Map zzc;
    public List zzd = new ArrayList();

    @Nullable
    AdProgressInfo zze;

    @Nullable
    public List zzf;
    public double zzg;

    public zzas(AdEvent.AdEventType adEventType, @Nullable com.google.ads.interactivemedia.v3.impl.data.zzc zzcVar) {
        this.zza = adEventType;
        this.zzb = zzcVar;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        return zzagh.zzf(this, obj, false, null, false, new String[0]);
    }

    public final int hashCode() {
        return zzagk.zza(this, new String[0]);
    }
}
