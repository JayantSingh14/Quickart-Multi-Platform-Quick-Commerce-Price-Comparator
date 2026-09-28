package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhhd {
    public static zzgzu a() throws GeneralSecurityException {
        try {
            zzhhv zzhhvVar = zzhbd.f33444a;
            if (zzhhc.a()) {
                throw new GeneralSecurityException("Cannot use non-FIPS-compliant AeadConfigurationV1 in FIPS mode");
            }
            return zzhbd.f33444a;
        } catch (GeneralSecurityException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
