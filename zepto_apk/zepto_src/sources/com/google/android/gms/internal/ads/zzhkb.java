package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;

/* loaded from: classes4.dex */
final class zzhkb extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    public final Object initialValue() throws NoSuchAlgorithmException {
        SecureRandom secureRandom;
        ThreadLocal threadLocal = zzhkc.f33918a;
        Provider providerA = zzhhf.a();
        if (providerA != null) {
            try {
                secureRandom = SecureRandom.getInstance("SHA1PRNG", providerA);
            } catch (GeneralSecurityException unused) {
            }
        } else {
            Provider provider = null;
            try {
                provider = (Provider) Class.forName("org.conscrypt.Conscrypt").getMethod("newProvider", null).invoke(null, null);
            } catch (Throwable unused2) {
            }
            if (provider != null) {
                try {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG", provider);
                } catch (GeneralSecurityException unused3) {
                }
            } else {
                secureRandom = new SecureRandom();
            }
        }
        secureRandom.nextLong();
        return secureRandom;
    }
}
