package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzln extends zzoz {
    @Override // com.google.android.gms.internal.pal.zzoz
    public final zzaef a(zzaef zzaefVar) {
        zzry zzryVar = (zzry) zzaefVar;
        new zzlr();
        zzsb zzsbVarE = zzlq.e(zzryVar.r());
        zzaef zzaefVarA = new zzqr().a().a(zzryVar.s());
        zzru zzruVarQ = zzrv.q();
        if (zzruVarQ.f37406c) {
            zzruVarQ.k();
            zzruVarQ.f37406c = false;
        }
        ((zzrv) zzruVarQ.f37405b).zzf = zzsbVarE;
        zzup zzupVar = (zzup) zzaefVarA;
        if (zzruVarQ.f37406c) {
            zzruVarQ.k();
            zzruVarQ.f37406c = false;
        }
        zzrv.w((zzrv) zzruVarQ.f37405b, zzupVar);
        if (zzruVarQ.f37406c) {
            zzruVarQ.k();
            zzruVarQ.f37406c = false;
        }
        ((zzrv) zzruVarQ.f37405b).zze = 0;
        return (zzrv) zzruVarQ.h();
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* synthetic */ zzaef b(zzaby zzabyVar) {
        return zzry.q(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final Map c() {
        HashMap map = new HashMap();
        map.put("AES128_CTR_HMAC_SHA256", zzlo.h(16, 16, 1));
        map.put("AES128_CTR_HMAC_SHA256_RAW", zzlo.h(16, 16, 3));
        map.put("AES256_CTR_HMAC_SHA256", zzlo.h(32, 32, 1));
        map.put("AES256_CTR_HMAC_SHA256_RAW", zzlo.h(32, 32, 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final void d(zzaef zzaefVar) throws GeneralSecurityException {
        zzry zzryVar = (zzry) zzaefVar;
        new zzlr();
        zzse zzseVarR = zzryVar.r();
        zzys.a(zzseVarR.p());
        zzsh zzshVarT = zzseVarR.t();
        if (zzshVarT.p() < 12 || zzshVarT.p() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
        new zzqr().a().d(zzryVar.s());
        zzys.a(zzryVar.r().p());
    }
}
