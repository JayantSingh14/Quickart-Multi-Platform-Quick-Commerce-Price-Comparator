package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.interfaces.RSAPrivateCrtKey;

/* loaded from: classes4.dex */
public final class zzhuw implements zzhap {

    /* renamed from: g, reason: collision with root package name */
    public static final byte[] f34341g = new byte[0];

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f34342h = {0};

    /* renamed from: i, reason: collision with root package name */
    public static final byte[] f34343i = {1, 2, 3};

    /* renamed from: a, reason: collision with root package name */
    public final RSAPrivateCrtKey f34344a;

    /* renamed from: b, reason: collision with root package name */
    public final String f34345b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f34346c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f34347d;

    /* renamed from: e, reason: collision with root package name */
    public final zzhaq f34348e;

    /* renamed from: f, reason: collision with root package name */
    public final Provider f34349f;

    public zzhuw(RSAPrivateCrtKey rSAPrivateCrtKey, zzhsu zzhsuVar, byte[] bArr, byte[] bArr2, zzhaq zzhaqVar, Provider provider) throws GeneralSecurityException {
        if (!zzhhb.a(2)) {
            throw new GeneralSecurityException("Can not use RSA PKCS1.5 in FIPS-mode, as BoringCrypto module is not available.");
        }
        if (zzhsuVar != zzhsu.f34182b && zzhsuVar != zzhsu.f34183c && zzhsuVar != zzhsu.f34184d) {
            throw new GeneralSecurityException("Unsupported hash: ".concat(String.valueOf(zzhsuVar)));
        }
        zzhxa.c(rSAPrivateCrtKey.getModulus().bitLength());
        zzhxa.d(rSAPrivateCrtKey.getPublicExponent());
        this.f34344a = rSAPrivateCrtKey;
        this.f34345b = zzhux.a(zzhsuVar);
        this.f34346c = bArr;
        this.f34347d = bArr2;
        this.f34348e = zzhaqVar;
        this.f34349f = provider;
    }
}
