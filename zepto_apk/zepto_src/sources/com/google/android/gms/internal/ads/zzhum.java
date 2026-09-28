package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: classes4.dex */
public final class zzhum implements zzhaq {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f34319e = {48, 42, 48, 5, 6, 3, 43, 101, 112, 3, 33, 0};

    /* renamed from: a, reason: collision with root package name */
    public final PublicKey f34320a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f34321b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f34322c;

    /* renamed from: d, reason: collision with root package name */
    public final Provider f34323d;

    public zzhum(byte[] bArr, byte[] bArr2, byte[] bArr3, Provider provider) throws GeneralSecurityException {
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
        }
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Given public key's length is not 32.");
        }
        this.f34320a = KeyFactory.getInstance("Ed25519", provider).generatePublic(new X509EncodedKeySpec(zzhvp.a(f34319e, bArr)));
        this.f34321b = bArr2;
        this.f34322c = bArr3;
        this.f34323d = provider;
    }

    public static zzhum a(zzhrv zzhrvVar) throws GeneralSecurityException {
        Provider providerA = zzhhf.a();
        if (providerA == null) {
            throw new NoSuchProviderException("Ed25519VerifyJce requires the Conscrypt provider.");
        }
        if (zzhhb.a(1)) {
            return new zzhum(zzhrvVar.f34138b.b(), zzhrvVar.f34139c.b(), zzhrvVar.f34137a.f34124a.equals(zzhrn.f34121d) ? new byte[]{0} : new byte[0], providerA);
        }
        throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
    }

    @Override // com.google.android.gms.internal.ads.zzhaq
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.f34321b;
        int length = bArr3.length;
        if (bArr.length != length + 64) {
            throw new GeneralSecurityException("Invalid signature length: 64");
        }
        if (!zzhkl.c(bArr3, bArr)) {
            throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
        }
        Signature signature = Signature.getInstance("Ed25519", this.f34323d);
        signature.initVerify(this.f34320a);
        signature.update(bArr2);
        signature.update(this.f34322c);
        try {
            if (signature.verify(bArr, length, 64)) {
                return;
            }
        } catch (RuntimeException unused) {
        }
        throw new GeneralSecurityException("Signature check failed.");
    }
}
