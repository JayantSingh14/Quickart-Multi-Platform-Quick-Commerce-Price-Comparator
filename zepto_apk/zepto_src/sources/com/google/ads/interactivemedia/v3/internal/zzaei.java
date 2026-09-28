package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
final class zzaei {
    private static final zzaei zza = new zzaei();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzaeu zzb = new zzadr();

    private zzaei() {
    }

    public static zzaei zza() {
        return zza;
    }

    public final zzaet zzb(Class cls) {
        zzacx.zzc(cls, "messageType");
        zzaet zzaetVar = (zzaet) this.zzc.get(cls);
        if (zzaetVar != null) {
            return zzaetVar;
        }
        zzaet zzaetVarZza = this.zzb.zza(cls);
        zzacx.zzc(cls, "messageType");
        zzaet zzaetVar2 = (zzaet) this.zzc.putIfAbsent(cls, zzaetVarZza);
        return zzaetVar2 == null ? zzaetVarZza : zzaetVar2;
    }
}
