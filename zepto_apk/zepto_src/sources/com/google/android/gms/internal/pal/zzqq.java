package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzqq extends zzoz {
    @Override // com.google.android.gms.internal.pal.zzoz
    public final zzaef a(zzaef zzaefVar) {
        zzus zzusVar = (zzus) zzaefVar;
        zzuo zzuoVarQ = zzup.q();
        if (zzuoVarQ.f37406c) {
            zzuoVarQ.k();
            zzuoVarQ.f37406c = false;
        }
        ((zzup) zzuoVarQ.f37405b).zze = 0;
        zzuv zzuvVarT = zzusVar.t();
        if (zzuoVarQ.f37406c) {
            zzuoVarQ.k();
            zzuoVarQ.f37406c = false;
        }
        zzup.w((zzup) zzuoVarQ.f37405b, zzuvVarT);
        byte[] bArrA = zzyq.a(zzusVar.p());
        zzaby zzabyVarQ = zzaby.q(0, bArrA, bArrA.length);
        if (zzuoVarQ.f37406c) {
            zzuoVarQ.k();
            zzuoVarQ.f37406c = false;
        }
        ((zzup) zzuoVarQ.f37405b).zzg = zzabyVarQ;
        return (zzup) zzuoVarQ.h();
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* synthetic */ zzaef b(zzaby zzabyVar) {
        return zzus.s(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final Map c() {
        HashMap map = new HashMap();
        map.put("HMAC_SHA256_128BITTAG", zzqr.i(32, 16, 5, 1));
        map.put("HMAC_SHA256_128BITTAG_RAW", zzqr.i(32, 16, 5, 3));
        map.put("HMAC_SHA256_256BITTAG", zzqr.i(32, 32, 5, 1));
        map.put("HMAC_SHA256_256BITTAG_RAW", zzqr.i(32, 32, 5, 3));
        map.put("HMAC_SHA512_128BITTAG", zzqr.i(64, 16, 6, 1));
        map.put("HMAC_SHA512_128BITTAG_RAW", zzqr.i(64, 16, 6, 3));
        map.put("HMAC_SHA512_256BITTAG", zzqr.i(64, 32, 6, 1));
        map.put("HMAC_SHA512_256BITTAG_RAW", zzqr.i(64, 32, 6, 3));
        map.put("HMAC_SHA512_512BITTAG", zzqr.i(64, 64, 6, 1));
        map.put("HMAC_SHA512_512BITTAG_RAW", zzqr.i(64, 64, 6, 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* bridge */ /* synthetic */ void d(zzaef zzaefVar) throws GeneralSecurityException {
        zzus zzusVar = (zzus) zzaefVar;
        if (zzusVar.p() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        zzqr.j(zzusVar.t());
    }
}
