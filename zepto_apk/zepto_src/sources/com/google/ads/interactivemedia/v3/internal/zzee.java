package com.google.ads.interactivemedia.v3.internal;

import androidx.annotation.Nullable;
import java.util.List;

/* loaded from: classes3.dex */
public final class zzee {
    public final boolean zza;
    public final long zzb;
    public final List zzc;

    @Nullable
    public final List zzd;
    public final int zze;

    public zzee(com.google.ads.interactivemedia.v3.impl.data.zzcf zzcfVar) {
        this.zza = zzcfVar.disableAppSetId;
        this.zzb = zzcfVar.appSetIdTimeoutMs;
        this.zzc = zzcfVar.gksFirstPartyAdServers;
        this.zzd = zzcfVar.gksDaiNativeXhrApps;
        this.zze = zzcfVar.gksTimeoutMs;
    }
}
