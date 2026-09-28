package com.google.android.gms.internal.pal;

import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzlz extends zzoz {
    @Override // com.google.android.gms.internal.pal.zzoz
    public final zzaef a(zzaef zzaefVar) {
        zzsy zzsyVarQ = zzsz.q();
        byte[] bArrA = zzyq.a(((zztc) zzaefVar).p());
        zzaby zzabyVarQ = zzaby.q(0, bArrA, bArrA.length);
        if (zzsyVarQ.f37406c) {
            zzsyVarQ.k();
            zzsyVarQ.f37406c = false;
        }
        ((zzsz) zzsyVarQ.f37405b).zzf = zzabyVarQ;
        if (zzsyVarQ.f37406c) {
            zzsyVarQ.k();
            zzsyVarQ.f37406c = false;
        }
        ((zzsz) zzsyVarQ.f37405b).zze = 0;
        return (zzsz) zzsyVarQ.h();
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* synthetic */ zzaef b(zzaby zzabyVar) {
        return zztc.r(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final Map c() {
        HashMap map = new HashMap();
        map.put("AES128_GCM_SIV", zzma.h(16, 1));
        map.put("AES128_GCM_SIV_RAW", zzma.h(16, 3));
        map.put("AES256_GCM_SIV", zzma.h(32, 1));
        map.put("AES256_GCM_SIV_RAW", zzma.h(32, 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* synthetic */ void d(zzaef zzaefVar) throws InvalidAlgorithmParameterException {
        zzys.a(((zztc) zzaefVar).p());
    }
}
