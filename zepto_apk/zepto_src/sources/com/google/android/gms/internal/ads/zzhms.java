package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzhms implements zzhmn {

    /* renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f34041a;

    /* renamed from: b, reason: collision with root package name */
    public final Provider f34042b;

    public zzhms(byte[] bArr, Provider provider) throws GeneralSecurityException {
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode, as BoringCrypto module is not available");
        }
        this.f34041a = new SecretKeySpec(bArr, CLConstants.AES_KEY_VAULT_KEY);
        this.f34042b = provider;
    }

    @Override // com.google.android.gms.internal.ads.zzhmn
    public final byte[] a(int i2, byte[] bArr) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (i2 > 16) {
            throw new InvalidAlgorithmParameterException("outputLength must not be larger than 16");
        }
        SecretKeySpec secretKeySpec = this.f34041a;
        Mac mac = Mac.getInstance("AESCMAC", this.f34042b);
        mac.init(secretKeySpec);
        byte[] bArrDoFinal = mac.doFinal(bArr);
        return i2 == bArrDoFinal.length ? bArrDoFinal : Arrays.copyOf(bArrDoFinal, i2);
    }
}
