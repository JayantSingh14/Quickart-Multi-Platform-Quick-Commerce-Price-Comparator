package com.google.android.gms.internal.pal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzmc extends zzoz {
    @Override // com.google.android.gms.internal.pal.zzoz
    public final zzaef a(zzaef zzaefVar) {
        zztk zztkVarQ = zztl.q();
        if (zztkVarQ.f37406c) {
            zztkVarQ.k();
            zztkVarQ.f37406c = false;
        }
        ((zztl) zztkVarQ.f37405b).zze = 0;
        byte[] bArrA = zzyq.a(32);
        zzaby zzabyVarQ = zzaby.q(0, bArrA, bArrA.length);
        if (zztkVarQ.f37406c) {
            zztkVarQ.k();
            zztkVarQ.f37406c = false;
        }
        ((zztl) zztkVarQ.f37405b).zzf = zzabyVarQ;
        return (zztl) zztkVarQ.h();
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* synthetic */ zzaef b(zzaby zzabyVar) {
        return zzto.q(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final Map c() {
        HashMap map = new HashMap();
        map.put("CHACHA20_POLY1305", new zzoy(zzto.p(), 1));
        map.put("CHACHA20_POLY1305_RAW", new zzoy(zzto.p(), 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* bridge */ /* synthetic */ void d(zzaef zzaefVar) {
    }
}
