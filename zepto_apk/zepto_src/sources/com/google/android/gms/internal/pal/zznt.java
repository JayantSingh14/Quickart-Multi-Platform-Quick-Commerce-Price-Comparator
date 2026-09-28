package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
final class zznt {
    public static void a(zztz zztzVar) throws GeneralSecurityException {
        zzxx.g(c(zztzVar.s().t()));
        b(zztzVar.s().u());
        if (zztzVar.v() == 2) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        zzvt zzvtVarR = zztzVar.p().r();
        Logger logger = zzlf.f37911a;
        synchronized (zzlf.class) {
            zzkb zzkbVarZzb = ((zzki) zzlf.f37912b.get()).d(zzvtVarR.s()).zzb();
            if (!((Boolean) zzlf.f37914d.get(zzvtVarR.s())).booleanValue()) {
                throw new GeneralSecurityException("newKey-operation not permitted for key type ".concat(String.valueOf(zzvtVarR.s())));
            }
            zzkbVarZzb.c(zzvtVarR.r());
        }
    }

    public static String b(int i2) throws NoSuchAlgorithmException {
        int i3 = i2 - 2;
        if (i3 == 1) {
            return "HmacSha1";
        }
        if (i3 == 2) {
            return "HmacSha384";
        }
        if (i3 == 3) {
            return "HmacSha256";
        }
        if (i3 == 4) {
            return "HmacSha512";
        }
        if (i3 == 5) {
            return "HmacSha224";
        }
        if (i2 != 1) {
            throw new NoSuchAlgorithmException("hash unsupported for HMAC: ".concat(Integer.toString(i3)));
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static int c(int i2) throws GeneralSecurityException {
        int i3 = i2 - 2;
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 3) {
            return 2;
        }
        if (i3 == 4) {
            return 3;
        }
        if (i2 != 1) {
            throw new GeneralSecurityException("unknown curve type: ".concat(Integer.toString(i3)));
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static int d(int i2) throws GeneralSecurityException {
        int i3 = i2 - 2;
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2) {
            return 2;
        }
        if (i3 == 3) {
            return 3;
        }
        if (i2 != 1) {
            throw new GeneralSecurityException("unknown point format: ".concat(Integer.toString(i3)));
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
