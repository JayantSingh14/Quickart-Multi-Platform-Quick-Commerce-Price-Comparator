package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
final class zznj extends zzoz {
    @Override // com.google.android.gms.internal.pal.zzoz
    public final zzaef a(zzaef zzaefVar) throws InvalidAlgorithmParameterException {
        zztw zztwVar = (zztw) zzaefVar;
        ECParameterSpec eCParameterSpecG = zzxx.g(zznt.c(zztwVar.r().s().t()));
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzxz.f38144h.a("EC");
        keyPairGenerator.initialize(eCParameterSpecG);
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        ECPublicKey eCPublicKey = (ECPublicKey) keyPairGenerateKeyPair.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairGenerateKeyPair.getPrivate();
        ECPoint w = eCPublicKey.getW();
        zzue zzueVarR = zzuf.r();
        if (zzueVarR.f37406c) {
            zzueVarR.k();
            zzueVarR.f37406c = false;
        }
        ((zzuf) zzueVarR.f37405b).zze = 0;
        zztz zztzVarR = zztwVar.r();
        if (zzueVarR.f37406c) {
            zzueVarR.k();
            zzueVarR.f37406c = false;
        }
        zzuf.x((zzuf) zzueVarR.f37405b, zztzVarR);
        byte[] byteArray = w.getAffineX().toByteArray();
        zzaby zzabyVarQ = zzaby.q(0, byteArray, byteArray.length);
        if (zzueVarR.f37406c) {
            zzueVarR.k();
            zzueVarR.f37406c = false;
        }
        ((zzuf) zzueVarR.f37405b).zzg = zzabyVarQ;
        byte[] byteArray2 = w.getAffineY().toByteArray();
        zzaby zzabyVarQ2 = zzaby.q(0, byteArray2, byteArray2.length);
        if (zzueVarR.f37406c) {
            zzueVarR.k();
            zzueVarR.f37406c = false;
        }
        ((zzuf) zzueVarR.f37405b).zzh = zzabyVarQ2;
        zzuf zzufVar = (zzuf) zzueVarR.h();
        zzub zzubVarQ = zzuc.q();
        if (zzubVarQ.f37406c) {
            zzubVarQ.k();
            zzubVarQ.f37406c = false;
        }
        ((zzuc) zzubVarQ.f37405b).zze = 0;
        if (zzubVarQ.f37406c) {
            zzubVarQ.k();
            zzubVarQ.f37406c = false;
        }
        ((zzuc) zzubVarQ.f37405b).zzf = zzufVar;
        byte[] byteArray3 = eCPrivateKey.getS().toByteArray();
        zzaby zzabyVarQ3 = zzaby.q(0, byteArray3, byteArray3.length);
        if (zzubVarQ.f37406c) {
            zzubVarQ.k();
            zzubVarQ.f37406c = false;
        }
        ((zzuc) zzubVarQ.f37405b).zzg = zzabyVarQ3;
        return (zzuc) zzubVarQ.h();
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* synthetic */ zzaef b(zzaby zzabyVar) {
        return zztw.q(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final Map c() throws GeneralSecurityException {
        HashMap map = new HashMap();
        zzkk zzkkVarA = zzkl.a("AES128_GCM");
        byte[] bArr = zznk.f37944d;
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zznk.h(3, zzkkVarA, bArr, 1));
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zznk.h(3, zzkl.a("AES128_GCM"), bArr, 3));
        map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zznk.h(4, zzkl.a("AES128_GCM"), bArr, 1));
        map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zznk.h(4, zzkl.a("AES128_GCM"), bArr, 3));
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zznk.h(4, zzkl.a("AES128_GCM"), bArr, 3));
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zznk.h(3, zzkl.a("AES128_CTR_HMAC_SHA256"), bArr, 1));
        map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zznk.h(3, zzkl.a("AES128_CTR_HMAC_SHA256"), bArr, 3));
        map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zznk.h(4, zzkl.a("AES128_CTR_HMAC_SHA256"), bArr, 1));
        map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zznk.h(4, zzkl.a("AES128_CTR_HMAC_SHA256"), bArr, 3));
        return Collections.unmodifiableMap(map);
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* synthetic */ void d(zzaef zzaefVar) throws GeneralSecurityException {
        zznt.a(((zztw) zzaefVar).r());
    }
}
