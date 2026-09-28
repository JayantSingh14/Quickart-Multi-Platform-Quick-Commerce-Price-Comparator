package com.google.android.gms.internal.pal;

import java.util.logging.Level;

/* loaded from: classes4.dex */
public final class zzna {
    public static boolean a(int i2) {
        Boolean bool;
        if (i2 - 1 == 0) {
            return !zznb.a();
        }
        if (zznb.a()) {
            try {
                bool = (Boolean) Class.forName("org.conscrypt.Conscrypt").getMethod("isBoringSslFIPSBuild", null).invoke(null, null);
            } catch (Exception unused) {
                zznb.f37938a.logp(Level.INFO, "com.google.crypto.tink.config.internal.TinkFipsUtil", "checkConscryptIsAvailableAndUsesFipsBoringSsl", "Conscrypt is not available or does not support checking for FIPS build.");
                bool = Boolean.FALSE;
            }
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }
}
