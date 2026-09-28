package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.spec.PKCS8EncodedKeySpec;

/* loaded from: classes4.dex */
public final class zzhul implements zzhap {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f34318a = {48, 46, 2, 1, 0, 48, 5, 6, 3, 43, 101, 112, 4, 34, 4, 32};

    public static zzhul a(zzhrp zzhrpVar) throws GeneralSecurityException {
        Provider providerA = zzhhf.a();
        if (providerA == null) {
            throw new NoSuchProviderException("Ed25519SignJce requires the Conscrypt provider.");
        }
        byte[] bArrB = zzhrpVar.f34126b.f34463a.b();
        zzhrv zzhrvVar = zzhrpVar.f34125a;
        zzhrvVar.f34139c.b();
        zzhrvVar.f34137a.f34124a.getClass();
        zzhul zzhulVar = new zzhul();
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
        }
        if (bArrB.length != 32) {
            throw new IllegalArgumentException("Given private key's length is not 32");
        }
        KeyFactory.getInstance("Ed25519", providerA).generatePrivate(new PKCS8EncodedKeySpec(zzhvp.a(f34318a, bArrB)));
        return zzhulVar;
    }
}
