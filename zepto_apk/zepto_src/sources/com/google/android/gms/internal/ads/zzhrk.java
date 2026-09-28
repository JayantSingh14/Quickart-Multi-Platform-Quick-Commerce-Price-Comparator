package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhrk implements zzhhz {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhrk f34111a = new zzhrk();

    @Override // com.google.android.gms.internal.ads.zzhhz
    public final zzgzx a(zzhan zzhanVar, Integer num) throws GeneralSecurityException {
        zzhre zzhreVar = (zzhre) zzhanVar;
        zzhjs zzhjsVar = zzhrm.f34113a;
        ECParameterSpec eCParameterSpec = zzhreVar.f34096b.f34082b;
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzhwc.f34418f.f34420a.a("EC");
        keyPairGenerator.initialize(eCParameterSpec);
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        ECPublicKey eCPublicKey = (ECPublicKey) keyPairGenerateKeyPair.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairGenerateKeyPair.getPrivate();
        zzhrh zzhrhVar = new zzhrh();
        zzhrhVar.f34103a = zzhreVar;
        zzhrhVar.f34105c = num;
        zzhrhVar.f34104b = eCPublicKey.getW();
        zzhri zzhriVarA = zzhrhVar.a();
        zzhrf zzhrfVar = new zzhrf();
        zzhrfVar.f34099a = zzhriVarA;
        zzhrfVar.f34100b = new zzhxd(eCPrivateKey.getS());
        return zzhrfVar.a();
    }
}
