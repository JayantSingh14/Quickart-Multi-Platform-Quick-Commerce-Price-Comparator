package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class zzec {
    private final Map zza = new LinkedHashMap();
    private final List zzb = new ArrayList();
    private int zzc = 0;

    public final zzoy zza(String str) {
        return !this.zza.containsKey(str) ? zzoy.zze() : zzoy.zzg((zzeb) this.zza.get(str));
    }

    public final List zzb() {
        return this.zzb;
    }

    public final void zzc() {
        this.zza.clear();
        this.zzb.clear();
        this.zzc = 0;
    }

    public final void zzd(String str) {
        this.zza.remove(str);
    }

    public final void zze(com.google.ads.interactivemedia.v3.impl.data.zzby zzbyVar) {
        this.zzb.add(zzea.zzc(zzbyVar, System.currentTimeMillis()));
    }

    public final void zzf(com.google.ads.interactivemedia.v3.impl.data.zzby zzbyVar, String str) {
        if (!this.zza.containsKey(str)) {
            Map map = this.zza;
            int i2 = this.zzc;
            this.zzc = i2 + 1;
            map.put(str, new zzeb(Integer.valueOf(i2)));
        }
        ((zzeb) this.zza.get(str)).zza.add(zzea.zzc(zzbyVar, System.currentTimeMillis()));
    }
}
