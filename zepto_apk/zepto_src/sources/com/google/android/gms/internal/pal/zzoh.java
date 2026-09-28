package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzoh extends zzoz {
    @Override // com.google.android.gms.internal.pal.zzoz
    public final zzaef a(zzaef zzaefVar) throws InvalidKeyException {
        zzva zzvaVar = (zzva) zzaefVar;
        byte[] bArrB = zzyt.b();
        byte[] bArrC = zzyt.c(bArrB);
        zzvi zzviVarR = zzvj.r();
        if (zzviVarR.f37406c) {
            zzviVarR.k();
            zzviVarR.f37406c = false;
        }
        ((zzvj) zzviVarR.f37405b).zze = 0;
        zzvd zzvdVarR = zzvaVar.r();
        if (zzviVarR.f37406c) {
            zzviVarR.k();
            zzviVarR.f37406c = false;
        }
        zzvj.w((zzvj) zzviVarR.f37405b, zzvdVarR);
        zzaby zzabyVarQ = zzaby.q(0, bArrC, 32);
        if (zzviVarR.f37406c) {
            zzviVarR.k();
            zzviVarR.f37406c = false;
        }
        ((zzvj) zzviVarR.f37405b).zzg = zzabyVarQ;
        zzvj zzvjVar = (zzvj) zzviVarR.h();
        zzvf zzvfVarQ = zzvg.q();
        if (zzvfVarQ.f37406c) {
            zzvfVarQ.k();
            zzvfVarQ.f37406c = false;
        }
        ((zzvg) zzvfVarQ.f37405b).zze = 0;
        if (zzvfVarQ.f37406c) {
            zzvfVarQ.k();
            zzvfVarQ.f37406c = false;
        }
        ((zzvg) zzvfVarQ.f37405b).zzf = zzvjVar;
        zzaby zzabyVarQ2 = zzaby.q(0, bArrB, bArrB.length);
        if (zzvfVarQ.f37406c) {
            zzvfVarQ.k();
            zzvfVarQ.f37406c = false;
        }
        ((zzvg) zzvfVarQ.f37405b).zzg = zzabyVarQ2;
        return (zzvg) zzvfVarQ.h();
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* synthetic */ zzaef b(zzaby zzabyVar) {
        return zzva.q(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final Map c() {
        HashMap map = new HashMap();
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzoi.h(3, 3, 3, 1));
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzoi.h(3, 3, 3, 3));
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzoi.h(3, 3, 4, 1));
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzoi.h(3, 3, 4, 3));
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", zzoi.h(3, 3, 5, 1));
        map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", zzoi.h(3, 3, 5, 3));
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zzoi.h(4, 3, 3, 1));
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzoi.h(4, 3, 3, 3));
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzoi.h(4, 3, 4, 1));
        map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzoi.h(4, 3, 4, 3));
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", zzoi.h(5, 4, 3, 1));
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", zzoi.h(5, 4, 3, 3));
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", zzoi.h(5, 4, 4, 1));
        map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", zzoi.h(5, 4, 4, 3));
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", zzoi.h(6, 5, 3, 1));
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", zzoi.h(6, 5, 3, 3));
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", zzoi.h(6, 5, 4, 1));
        map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", zzoi.h(6, 5, 4, 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* synthetic */ void d(zzaef zzaefVar) throws GeneralSecurityException {
        zzol.a(((zzva) zzaefVar).r());
    }
}
