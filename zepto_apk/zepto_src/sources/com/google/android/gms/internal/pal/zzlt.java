package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzlt extends zzoz {
    @Override // com.google.android.gms.internal.pal.zzoz
    public final zzaef a(zzaef zzaefVar) {
        zzsn zzsnVar = (zzsn) zzaefVar;
        zzsj zzsjVarQ = zzsk.q();
        byte[] bArrA = zzyq.a(zzsnVar.p());
        zzaby zzabyVarQ = zzaby.q(0, bArrA, bArrA.length);
        if (zzsjVarQ.f37406c) {
            zzsjVarQ.k();
            zzsjVarQ.f37406c = false;
        }
        ((zzsk) zzsjVarQ.f37405b).zzg = zzabyVarQ;
        zzsq zzsqVarS = zzsnVar.s();
        if (zzsjVarQ.f37406c) {
            zzsjVarQ.k();
            zzsjVarQ.f37406c = false;
        }
        zzsk.v((zzsk) zzsjVarQ.f37405b, zzsqVarS);
        if (zzsjVarQ.f37406c) {
            zzsjVarQ.k();
            zzsjVarQ.f37406c = false;
        }
        ((zzsk) zzsjVarQ.f37405b).zze = 0;
        return (zzsk) zzsjVarQ.h();
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* synthetic */ zzaef b(zzaby zzabyVar) {
        return zzsn.r(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final Map c() {
        HashMap map = new HashMap();
        map.put("AES128_EAX", zzlu.h(16, 1));
        map.put("AES128_EAX_RAW", zzlu.h(16, 3));
        map.put("AES256_EAX", zzlu.h(32, 1));
        map.put("AES256_EAX_RAW", zzlu.h(32, 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* bridge */ /* synthetic */ void d(zzaef zzaefVar) throws GeneralSecurityException {
        zzsn zzsnVar = (zzsn) zzaefVar;
        zzys.a(zzsnVar.p());
        if (zzsnVar.s().p() != 12 && zzsnVar.s().p() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
