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
final /* synthetic */ class zzhto implements zzhhz {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhto f34274a = new zzhto();

    @Override // com.google.android.gms.internal.ads.zzhhz
    public final zzgzx a(zzhan zzhanVar, Integer num) throws GeneralSecurityException {
        zzhti zzhtiVar = (zzhti) zzhanVar;
        zzhjs zzhjsVar = zzhtq.f34276a;
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzhwc.f34418f.f34420a.a(Constants.ALG_RSA);
        keyPairGenerator.initialize(new RSAKeyGenParameterSpec(zzhtiVar.f34246a, new BigInteger(1, zzhtiVar.f34247b.toByteArray())));
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rSAPublicKey = (RSAPublicKey) keyPairGenerateKeyPair.getPublic();
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) keyPairGenerateKeyPair.getPrivate();
        zzhtl zzhtlVar = new zzhtl();
        zzhtlVar.f34266a = zzhtiVar;
        zzhtlVar.f34267b = rSAPublicKey.getModulus();
        zzhtlVar.f34268c = num;
        zzhtm zzhtmVarA = zzhtlVar.a();
        zzhtj zzhtjVar = new zzhtj();
        zzhtjVar.f34252a = zzhtmVarA;
        zzhxd zzhxdVar = new zzhxd(rSAPrivateCrtKey.getPrimeP());
        zzhxd zzhxdVar2 = new zzhxd(rSAPrivateCrtKey.getPrimeQ());
        zzhtjVar.f34254c = zzhxdVar;
        zzhtjVar.f34255d = zzhxdVar2;
        zzhtjVar.f34253b = new zzhxd(rSAPrivateCrtKey.getPrivateExponent());
        zzhxd zzhxdVar3 = new zzhxd(rSAPrivateCrtKey.getPrimeExponentP());
        zzhxd zzhxdVar4 = new zzhxd(rSAPrivateCrtKey.getPrimeExponentQ());
        zzhtjVar.f34256e = zzhxdVar3;
        zzhtjVar.f34257f = zzhxdVar4;
        zzhtjVar.f34258g = new zzhxd(rSAPrivateCrtKey.getCrtCoefficient());
        return zzhtjVar.a();
    }
}
