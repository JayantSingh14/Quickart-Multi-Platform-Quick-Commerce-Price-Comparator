package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class zzda {
    private final zzcc zza;
    private final ArrayList zzb;

    public zzda(zzcc zzccVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.zzb = arrayList;
        this.zza = zzccVar;
        arrayList.add(str);
    }

    public final zzcc zza() {
        return this.zza;
    }

    public final ArrayList zzb() {
        return this.zzb;
    }

    public final void zzc(String str) {
        this.zzb.add(str);
    }
}
