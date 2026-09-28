package com.google.android.gms.internal.ads;

import in.juspay.hypersdk.core.Constants;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAKeyGenParameterSpec;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhtc implements zzhhz {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhtc f34220a = new zzhtc();

    @Override // com.google.android.gms.internal.ads.zzhhz
    public final zzgzx a(zzhan zzhanVar, Integer num) throws GeneralSecurityException {
        zzhsw zzhswVar = (zzhsw) zzhanVar;
        zzhjs zzhjsVar = zzhte.f34222a;
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzhwc.f34418f.f34420a.a(Constants.ALG_RSA);
        keyPairGenerator.initialize(new RSAKeyGenParameterSpec(zzhswVar.f34192a, new BigInteger(1, zzhswVar.f34193b.toByteArray())));
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) keyPairGenerateKeyPair.getPublic();
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) keyPairGenerateKeyPair.getPrivate();
        zzhsz zzhszVar = new zzhsz();
        zzhszVar.f34210a = zzhswVar;
        zzhszVar.f34211b = rSAPublicKey.getModulus();
        zzhszVar.f34212c = num;
        zzhta zzhtaVarA = zzhszVar.a();
        zzhsx zzhsxVar = new zzhsx();
        zzhsxVar.f34196a = zzhtaVarA;
        zzhxd zzhxdVar = new zzhxd(rSAPrivateCrtKey.getPrimeP());
        zzhxd zzhxdVar2 = new zzhxd(rSAPrivateCrtKey.getPrimeQ());
        zzhsxVar.f34198c = zzhxdVar;
        zzhsxVar.f34199d = zzhxdVar2;
        zzhsxVar.f34197b = new zzhxd(rSAPrivateCrtKey.getPrivateExponent());
        zzhxd zzhxdVar3 = new zzhxd(rSAPrivateCrtKey.getPrimeExponentP());
        zzhxd zzhxdVar4 = new zzhxd(rSAPrivateCrtKey.getPrimeExponentQ());
        zzhsxVar.f34200e = zzhxdVar3;
        zzhsxVar.f34201f = zzhxdVar4;
        zzhsxVar.f34202g = new zzhxd(rSAPrivateCrtKey.getCrtCoefficient());
        return zzhsxVar.a();
    }
}
