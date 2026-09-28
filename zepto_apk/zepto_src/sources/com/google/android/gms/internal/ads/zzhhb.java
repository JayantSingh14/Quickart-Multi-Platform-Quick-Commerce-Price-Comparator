package com.google.android.gms.internal.ads;

import java.util.logging.Level;

/* loaded from: classes4.dex */
public final class zzhhb {
    public static boolean a(int i2) {
        Boolean bool;
        if (i2 - 1 == 0) {
            return !zzhhc.a();
        }
        if (!zzhhc.a()) {
            return true;
        }
        try {
            bool = (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", null).invoke(null, null);
        } catch (Exception unused) {
            zzhhc.f33793a.logp(Level.INFO, "com.google.crypto.tink.config.internal.TinkFipsUtil", "checkConscryptIsAvailableAndUsesFipsBoringSsl", "Conscrypt is not available or does not support checking for FIPS build.");
            bool = Boolean.FALSE;
        }
        return bool.booleanValue();
    }
}
