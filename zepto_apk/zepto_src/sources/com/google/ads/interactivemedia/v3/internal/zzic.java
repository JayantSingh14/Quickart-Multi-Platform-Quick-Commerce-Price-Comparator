package com.google.ads.interactivemedia.v3.internal;

import java.util.HashMap;

/* loaded from: classes3.dex */
public final class zzic extends zzfn {
    public Long zza;
    public Long zzb;

    public zzic() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzfn
    public final HashMap zzb() {
        HashMap map = new HashMap();
        map.put(0, this.zza);
        map.put(1, this.zzb);
        return map;
    }

    public zzic(String str) {
        HashMap mapZza = zzfn.zza(str);
        if (mapZza != null) {
            this.zza = (Long) mapZza.get(0);
            this.zzb = (Long) mapZza.get(1);
        }
    }
}
