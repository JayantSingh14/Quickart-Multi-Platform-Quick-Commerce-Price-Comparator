package com.google.android.gms.internal.pal;

import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zznd extends zzoz {
    @Override // com.google.android.gms.internal.pal.zzoz
    public final zzaef a(zzaef zzaefVar) {
        zzte zzteVarQ = zztf.q();
        byte[] bArrA = zzyq.a(((zzti) zzaefVar).p());
        zzaby zzabyVarQ = zzaby.q(0, bArrA, bArrA.length);
        if (zzteVarQ.f37406c) {
            zzteVarQ.k();
            zzteVarQ.f37406c = false;
        }
        ((zztf) zzteVarQ.f37405b).zzf = zzabyVarQ;
        if (zzteVarQ.f37406c) {
            zzteVarQ.k();
            zzteVarQ.f37406c = false;
        }
        ((zztf) zzteVarQ.f37405b).zze = 0;
        return (zztf) zzteVarQ.h();
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* synthetic */ zzaef b(zzaby zzabyVar) {
        return zzti.r(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final Map c() {
        HashMap map = new HashMap();
        zzth zzthVarQ = zzti.q();
        if (zzthVarQ.f37406c) {
            zzthVarQ.k();
            zzthVarQ.f37406c = false;
        }
        ((zzti) zzthVarQ.f37405b).zze = 64;
        map.put("AES256_SIV", new zzoy((zzti) zzthVarQ.h(), 1));
        zzth zzthVarQ2 = zzti.q();
        if (zzthVarQ2.f37406c) {
            zzthVarQ2.k();
            zzthVarQ2.f37406c = false;
        }
        ((zzti) zzthVarQ2.f37405b).zze = 64;
        map.put("AES256_SIV_RAW", new zzoy((zzti) zzthVarQ2.h(), 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* bridge */ /* synthetic */ void d(zzaef zzaefVar) throws InvalidAlgorithmParameterException {
        zzti zztiVar = (zzti) zzaefVar;
        if (zztiVar.p() != 64) {
            throw new InvalidAlgorithmParameterException(android.support.v4.media.b.g(zztiVar.p(), "invalid key size: ", ". Valid keys must have 64 bytes."));
        }
    }
}
