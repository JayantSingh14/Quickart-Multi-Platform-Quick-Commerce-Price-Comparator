package com.google.android.gms.internal.ads;

import in.juspay.hypersdk.core.Constants;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchProviderException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhtp implements zzhjr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhtp f34275a = new zzhtp();

    @Override // com.google.android.gms.internal.ads.zzhjr
    public final Object a(zzgzx zzgzxVar) {
        zzhtm zzhtmVar = (zzhtm) zzgzxVar;
        zzhhs zzhhsVar = zzhwy.f34450a;
        try {
            return zzhvg.c(zzhtmVar);
        } catch (NoSuchProviderException unused) {
            KeyFactory keyFactory = (KeyFactory) zzhwc.f34419g.f34420a.a(Constants.ALG_RSA);
            BigInteger bigInteger = zzhtmVar.f34270b;
            zzhti zzhtiVar = zzhtmVar.f34269a;
            RSAPublicKey rSAPublicKey = (RSAPublicKey) keyFactory.generatePublic(new RSAPublicKeySpec(bigInteger, zzhtiVar.f34247b));
            zzhhs zzhhsVar2 = zzhwy.f34450a;
            return new zzhwx(rSAPublicKey, (zzhwl) zzhhsVar2.a(zzhtiVar.f34249d), (zzhwl) zzhhsVar2.a(zzhtiVar.f34250e), zzhtiVar.f34251f, zzhtmVar.f34271c.b(), zzhtiVar.f34248c.equals(zzhth.f34242d) ? zzhwy.f34452c : zzhwy.f34451b);
        }
    }
}
