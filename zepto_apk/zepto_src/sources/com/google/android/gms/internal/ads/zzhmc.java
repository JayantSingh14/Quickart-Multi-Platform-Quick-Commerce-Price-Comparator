package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzhmc implements zzhkv {
    public static zzhmc a(zzhkn zzhknVar, Provider provider) throws GeneralSecurityException {
        zzhmc zzhmcVar = new zzhmc();
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
        }
        try {
            Mac.getInstance("AESCMAC", provider);
            zzhknVar.f33938c.b();
            new SecretKeySpec(zzhknVar.f33937b.f34463a.b(), CLConstants.AES_KEY_VAULT_KEY);
            return zzhmcVar;
        } catch (NoSuchAlgorithmException e2) {
            throw new GeneralSecurityException("AES-CMAC not available.", e2);
        }
    }
}
