package com.google.android.gms.internal.ads;

import in.juspay.hypersdk.core.Constants;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzhux implements zzhaq {

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f34350f = new byte[0];

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f34351g = {0};

    /* renamed from: a, reason: collision with root package name */
    public final RSAPublicKey f34352a;

    /* renamed from: b, reason: collision with root package name */
    public final String f34353b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f34354c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f34355d;

    /* renamed from: e, reason: collision with root package name */
    public final Provider f34356e;

    public zzhux(RSAPublicKey rSAPublicKey, zzhsu zzhsuVar, byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!zzhhb.a(2)) {
            throw new GeneralSecurityException("Can not use RSA-PKCS1.5 in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzhxa.c(rSAPublicKey.getModulus().bitLength());
        zzhxa.d(rSAPublicKey.getPublicExponent());
        this.f34352a = rSAPublicKey;
        this.f34353b = a(zzhsuVar);
        this.f34354c = bArr;
        this.f34355d = bArr2;
        this.f34356e = provider;
    }

    public static String a(zzhsu zzhsuVar) throws GeneralSecurityException {
        if (zzhsuVar == zzhsu.f34182b) {
            return "SHA256withRSA";
        }
        if (zzhsuVar == zzhsu.f34183c) {
            return "SHA384withRSA";
        }
        if (zzhsuVar == zzhsu.f34184d) {
            return "SHA512withRSA";
        }
        throw new GeneralSecurityException("unknown hash type");
    }

    public static zzhux b(zzhta zzhtaVar, Provider provider) throws NoSuchAlgorithmException {
        KeyFactory keyFactory = KeyFactory.getInstance(Constants.ALG_RSA, provider);
        BigInteger bigInteger = zzhtaVar.f34216b;
        zzhsw zzhswVar = zzhtaVar.f34215a;
        return new zzhux((RSAPublicKey) keyFactory.generatePublic(new RSAPublicKeySpec(bigInteger, zzhswVar.f34193b)), zzhswVar.f34195d, zzhtaVar.f34217c.b(), zzhswVar.f34194c.equals(zzhsv.f34188d) ? f34351g : f34350f, provider);
    }

    @Override // com.google.android.gms.internal.ads.zzhaq
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.f34354c;
        if (!zzhkl.c(bArr3, bArr)) {
            throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
        }
        Signature signature = Signature.getInstance(this.f34353b, this.f34356e);
        signature.initVerify(this.f34352a);
        signature.update(bArr2);
        byte[] bArr4 = this.f34355d;
        if (bArr4.length > 0) {
            signature.update(bArr4);
        }
        try {
            if (signature.verify(Arrays.copyOfRange(bArr, bArr3.length, bArr.length))) {
                return;
            }
        } catch (RuntimeException unused) {
        }
        throw new GeneralSecurityException("Invalid signature");
    }
}
