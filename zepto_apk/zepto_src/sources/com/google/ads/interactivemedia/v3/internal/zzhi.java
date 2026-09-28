package com.google.ads.interactivemedia.v3.internal;

import java.util.HashMap;

/* loaded from: classes3.dex */
public final class zzhi extends zzfn {
    public Long zza;
    public Long zzb;
    public Long zzc;

    public zzhi() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzfn
    public final HashMap zzb() {
        HashMap map = new HashMap();
        map.put(0, this.zza);
        map.put(1, this.zzb);
        map.put(2, this.zzc);
        return map;
    }

    public zzhi(String str) {
        HashMap mapZza = zzfn.zza(str);
        if (mapZza != null) {
            this.zza = (Long) mapZza.get(0);
            this.zzb = (Long) mapZza.get(1);
            this.zzc = (Long) mapZza.get(2);
        }
    }
}
