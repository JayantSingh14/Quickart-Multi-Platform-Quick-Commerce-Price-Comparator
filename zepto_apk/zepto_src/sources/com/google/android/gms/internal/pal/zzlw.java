package com.google.android.gms.internal.pal;

import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzlw extends zzoz {
    @Override // com.google.android.gms.internal.pal.zzoz
    public final zzaef a(zzaef zzaefVar) {
        zzss zzssVarQ = zzst.q();
        byte[] bArrA = zzyq.a(((zzsw) zzaefVar).p());
        zzaby zzabyVarQ = zzaby.q(0, bArrA, bArrA.length);
        if (zzssVarQ.f37406c) {
            zzssVarQ.k();
            zzssVarQ.f37406c = false;
        }
        ((zzst) zzssVarQ.f37405b).zzf = zzabyVarQ;
        if (zzssVarQ.f37406c) {
            zzssVarQ.k();
            zzssVarQ.f37406c = false;
        }
        ((zzst) zzssVarQ.f37405b).zze = 0;
        return (zzst) zzssVarQ.h();
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* synthetic */ zzaef b(zzaby zzabyVar) {
        return zzsw.r(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final Map c() {
        HashMap map = new HashMap();
        map.put("AES128_GCM", zzlx.h(16, 1));
        map.put("AES128_GCM_RAW", zzlx.h(16, 3));
        map.put("AES256_GCM", zzlx.h(32, 1));
        map.put("AES256_GCM_RAW", zzlx.h(32, 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* synthetic */ void d(zzaef zzaefVar) throws InvalidAlgorithmParameterException {
        zzys.a(((zzsw) zzaefVar).p());
    }
}
