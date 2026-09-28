package com.google.android.gms.internal.ads;

import android.os.Build;
import in.juspay.hypersdk.core.Constants;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.util.Objects;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhtb implements zzhjr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhtb f34219a = new zzhtb();

    @Override // com.google.android.gms.internal.ads.zzhjr
    public final Object a(zzgzx zzgzxVar) throws GeneralSecurityException {
        zzhsy zzhsyVar = (zzhsy) zzgzxVar;
        int i2 = zzhkl.f33932a;
        if (Objects.equals(System.getProperty("java.vendor"), "The Android Project")) {
            (!Objects.equals(System.getProperty("java.vendor"), "The Android Project") ? null : Integer.valueOf(Build.VERSION.SDK_INT)).getClass();
        }
        Provider providerA = zzhhf.a();
        KeyFactory keyFactory = providerA != null ? KeyFactory.getInstance(Constants.ALG_RSA, providerA) : (KeyFactory) zzhwc.f34419g.f34420a.a(Constants.ALG_RSA);
        zzhta zzhtaVar = zzhsyVar.f34203a;
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) keyFactory.generatePrivate(new RSAPrivateCrtKeySpec(zzhtaVar.f34216b, zzhtaVar.f34215a.f34193b, zzhsyVar.f34204b.f34462a, zzhsyVar.f34205c.f34462a, zzhsyVar.f34206d.f34462a, zzhsyVar.f34207e.f34462a, zzhsyVar.f34208f.f34462a, zzhsyVar.f34209g.f34462a));
        zzhta zzhtaVar2 = zzhsyVar.f34203a;
        zzhuw zzhuwVar = new zzhuw(rSAPrivateCrtKey, zzhtaVar2.f34215a.f34195d, zzhtaVar2.f34217c.b(), zzhtaVar2.f34215a.f34194c.equals(zzhsv.f34188d) ? zzhuw.f34342h : zzhuw.f34341g, providerA != null ? zzhux.b(zzhtaVar2, providerA) : zzhwu.a(zzhtaVar2), providerA);
        byte[] bArr = zzhuw.f34343i;
        Provider provider = zzhuwVar.f34349f;
        String str = zzhuwVar.f34345b;
        Signature signature = provider != null ? Signature.getInstance(str, provider) : (Signature) zzhwc.f34416d.f34420a.a(str);
        signature.initSign(zzhuwVar.f34344a);
        signature.update(bArr);
        byte[] bArr2 = zzhuwVar.f34347d;
        if (bArr2.length > 0) {
            signature.update(bArr2);
        }
        byte[] bArrSign = signature.sign();
        byte[] bArr3 = zzhuwVar.f34346c;
        if (bArr3.length > 0) {
            bArrSign = zzhvp.a(bArr3, bArrSign);
        }
        try {
            zzhuwVar.f34348e.zza(bArrSign, bArr);
            return zzhuwVar;
        } catch (GeneralSecurityException e2) {
            throw new IllegalStateException("RSA signature computation error", e2);
        }
    }
}
