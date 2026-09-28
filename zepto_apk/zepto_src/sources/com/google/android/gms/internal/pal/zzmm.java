package com.google.android.gms.internal.pal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzmm extends zzoz {
    @Override // com.google.android.gms.internal.pal.zzoz
    public final zzaef a(zzaef zzaefVar) {
        zzwz zzwzVarQ = zzxa.q();
        if (zzwzVarQ.f37406c) {
            zzwzVarQ.k();
            zzwzVarQ.f37406c = false;
        }
        ((zzxa) zzwzVarQ.f37405b).zze = 0;
        byte[] bArrA = zzyq.a(32);
        zzaby zzabyVarQ = zzaby.q(0, bArrA, bArrA.length);
        if (zzwzVarQ.f37406c) {
            zzwzVarQ.k();
            zzwzVarQ.f37406c = false;
        }
        ((zzxa) zzwzVarQ.f37405b).zzf = zzabyVarQ;
        return (zzxa) zzwzVarQ.h();
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* synthetic */ zzaef b(zzaby zzabyVar) {
        return zzxd.q(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final Map c() {
        HashMap map = new HashMap();
        map.put("XCHACHA20_POLY1305", new zzoy(zzxd.p(), 1));
        map.put("XCHACHA20_POLY1305_RAW", new zzoy(zzxd.p(), 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* bridge */ /* synthetic */ void d(zzaef zzaefVar) {
    }
}
