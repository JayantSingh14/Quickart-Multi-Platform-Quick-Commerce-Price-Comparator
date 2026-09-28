package com.google.android.gms.internal.ads;

import android.os.Build;
import in.juspay.hypersdk.core.Constants;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhwu implements zzhaq {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f34441a = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f34442b = {0};

    /* renamed from: c, reason: collision with root package name */
    public static final zzhhs f34443c;

    static {
        zzhhr zzhhrVar = new zzhhr();
        zzhhrVar.a(zzhwl.f34421a, zzhsu.f34182b);
        zzhhrVar.a(zzhwl.f34422b, zzhsu.f34183c);
        zzhhrVar.a(zzhwl.f34423c, zzhsu.f34184d);
        f34443c = zzhhrVar.b();
    }

    public static zzhaq a(zzhta zzhtaVar) throws NoSuchProviderException {
        try {
            int i2 = zzhkl.f33932a;
            if (Objects.equals(System.getProperty("java.vendor"), "The Android Project")) {
                (!Objects.equals(System.getProperty("java.vendor"), "The Android Project") ? null : Integer.valueOf(Build.VERSION.SDK_INT)).getClass();
            }
            Provider providerA = zzhhf.a();
            if (providerA != null) {
                return zzhux.b(zzhtaVar, providerA);
            }
            throw new NoSuchProviderException("RSA-PKCS1.5 using Conscrypt is not supported.");
        } catch (NoSuchProviderException unused) {
            KeyFactory keyFactory = (KeyFactory) zzhwc.f34419g.f34420a.a(Constants.ALG_RSA);
            BigInteger bigInteger = zzhtaVar.f34216b;
            zzhsw zzhswVar = zzhtaVar.f34215a;
            return new zzhwt((RSAPublicKey) keyFactory.generatePublic(new RSAPublicKeySpec(bigInteger, zzhswVar.f34193b)), (zzhwl) f34443c.a(zzhswVar.f34195d), zzhtaVar.f34217c.b(), zzhswVar.f34194c.equals(zzhsv.f34188d) ? f34442b : f34441a);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhaq
    public final void zza(byte[] bArr, byte[] bArr2) {
        throw null;
    }
}
