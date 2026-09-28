package com.google.ads.interactivemedia.v3.internal;

import java.util.HashMap;

/* loaded from: classes3.dex */
public final class zzhn extends zzfn {
    public long zza;
    public long zzb;

    public zzhn() {
        this.zza = -1L;
        this.zzb = -1L;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzfn
    public final HashMap zzb() {
        HashMap map = new HashMap();
        map.put(0, Long.valueOf(this.zza));
        map.put(1, Long.valueOf(this.zzb));
        return map;
    }

    public zzhn(String str) {
        this.zza = -1L;
        this.zzb = -1L;
        HashMap mapZza = zzfn.zza(str);
        if (mapZza != null) {
            this.zza = ((Long) mapZza.get(0)).longValue();
            this.zzb = ((Long) mapZza.get(1)).longValue();
        }
    }
}
