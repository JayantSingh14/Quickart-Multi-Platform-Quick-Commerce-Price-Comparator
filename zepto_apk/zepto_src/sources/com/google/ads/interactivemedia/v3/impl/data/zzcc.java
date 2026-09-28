package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.internal.zzea;
import com.google.ads.interactivemedia.v3.internal.zzqf;

/* loaded from: classes3.dex */
public abstract class zzcc {
    public static zzcb builder() {
        return new zzah();
    }

    public static zzcc create(zzbn zzbnVar, zzqf<zzea> zzqfVar, zzqf<zzea> zzqfVar2) {
        zzcb zzcbVarBuilder = builder();
        zzcbVarBuilder.metadata(zzbnVar);
        zzcbVarBuilder.requestEvents(zzqfVar);
        zzcbVarBuilder.globalEvents(zzqfVar2);
        return zzcbVarBuilder.build();
    }

    public abstract zzqf<zzea> globalEvents();

    public abstract zzbn metadata();

    public abstract zzqf<zzea> requestEvents();
}
