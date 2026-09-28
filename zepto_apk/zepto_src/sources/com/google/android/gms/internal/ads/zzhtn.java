package com.google.android.gms.internal.ads;

import in.juspay.hypersdk.core.Constants;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchProviderException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhtn implements zzhjr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhtn f34273a = new zzhtn();

    @Override // com.google.android.gms.internal.ads.zzhjr
    public final Object a(zzgzx zzgzxVar) throws GeneralSecurityException {
        zzhtk zzhtkVar = (zzhtk) zzgzxVar;
        try {
            return zzhvf.a(zzhtkVar);
        } catch (NoSuchProviderException unused) {
            KeyFactory keyFactory = (KeyFactory) zzhwc.f34419g.f34420a.a(Constants.ALG_RSA);
            BigInteger bigInteger = zzhtkVar.f34259a.f34270b;
            zzhtm zzhtmVar = zzhtkVar.f34259a;
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) keyFactory.generatePrivate(new RSAPrivateCrtKeySpec(bigInteger, zzhtmVar.f34269a.f34247b, zzhtkVar.f34260b.f34462a, zzhtkVar.f34261c.f34462a, zzhtkVar.f34262d.f34462a, zzhtkVar.f34263e.f34462a, zzhtkVar.f34264f.f34462a, zzhtkVar.f34265g.f34462a));
            zzhhs zzhhsVar = zzhwy.f34450a;
            zzhti zzhtiVar = zzhtmVar.f34269a;
            zzhwl zzhwlVar = (zzhwl) zzhhsVar.a(zzhtiVar.f34249d);
            zzhwl zzhwlVar2 = (zzhwl) zzhhsVar.a(zzhtiVar.f34250e);
            zzhtmVar.f34271c.b();
            zzhtiVar.f34248c.getClass();
            zzhwv zzhwvVar = new zzhwv();
            if (zzhhc.a()) {
                throw new GeneralSecurityException("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
            }
            zzhxa.b(zzhwlVar);
            if (!zzhwlVar.equals(zzhwlVar2)) {
                throw new GeneralSecurityException("sigHash and mgf1Hash must be the same");
            }
            zzhxa.c(rSAPrivateCrtKey.getModulus().bitLength());
            zzhxa.d(rSAPrivateCrtKey.getPublicExponent());
            return zzhwvVar;
        }
    }
}
