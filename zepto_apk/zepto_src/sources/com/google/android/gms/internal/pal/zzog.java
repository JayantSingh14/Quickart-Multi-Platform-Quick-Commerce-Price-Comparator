package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

/* loaded from: classes4.dex */
final class zzog extends zzpq {
    @Override // com.google.android.gms.internal.pal.zzpq
    public final Object a(zzaef zzaefVar) throws GeneralSecurityException {
        zzoe zzonVar;
        zzvg zzvgVar = (zzvg) zzaefVar;
        if (!zzvgVar.x()) {
            throw new IllegalArgumentException("HpkePrivateKey is missing public_key field.");
        }
        if (!zzvgVar.s().y()) {
            throw new IllegalArgumentException("HpkePrivateKey.public_key is missing params field.");
        }
        if (zzvgVar.t().f() == 0) {
            throw new IllegalArgumentException("HpkePrivateKey.private_key is empty.");
        }
        zzvd zzvdVarQ = zzvgVar.s().q();
        zzoc zzocVarB = zzof.b(zzvdVarQ);
        zzof.c(zzvdVarQ);
        zzny zznyVarA = zzof.a(zzvdVarQ);
        int iT = zzvdVarQ.t();
        int i2 = 1;
        if (iT - 2 != 1) {
            throw new IllegalArgumentException("Unable to determine KEM-encoding length for ".concat(zzux.a(iT)));
        }
        int iT2 = zzvgVar.s().q().t() - 2;
        if (iT2 == 1) {
            byte[] bArrR = zzvgVar.t().r();
            byte[] bArrC = zzyt.c(bArrR);
            zzop zzopVar = new zzop();
            zzyv.a(bArrR);
            zzyv.a(bArrC);
            zzonVar = zzopVar;
        } else {
            if (iT2 != 2 && iT2 != 3 && iT2 != 4) {
                throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
            }
            byte[] bArrR2 = zzvgVar.t().r();
            byte[] bArrR3 = zzvgVar.s().u().r();
            int iT3 = zzvgVar.s().q().t() - 2;
            if (iT3 != 2) {
                if (iT3 == 3) {
                    i2 = 2;
                } else {
                    if (iT3 != 4) {
                        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
                    }
                    i2 = 3;
                }
            }
            ECPublicKey eCPublicKeyF = zzxx.f(zzxx.g(i2), bArrR3);
            ECPrivateKey eCPrivateKeyE = zzxx.e(i2, bArrR2);
            zzxx.c(eCPrivateKeyE, eCPublicKeyF);
            zzxx.b(eCPublicKeyF.getW(), eCPrivateKeyE.getParams().getCurve());
            zzonVar = new zzon();
            zzyv.a(bArrR2);
            zzyv.a(bArrR3);
        }
        return new zzoa(zzonVar, zzocVarB, zznyVarA);
    }
}
