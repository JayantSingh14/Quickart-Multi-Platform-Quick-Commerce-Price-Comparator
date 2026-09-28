package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final class zzor extends zzou {
    @Override // com.google.android.gms.internal.pal.zzou
    public final zzka a(zzps zzpsVar) throws GeneralSecurityException {
        zzqi zzqiVar;
        zzpp zzppVar = zzqo.f38030a;
        if (!zzpsVar.f38003a.equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters");
        }
        try {
            zzrm zzrmVarR = zzrm.r(zzpsVar.f38005c, zzacm.a());
            if (zzrmVarR.p() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzrs zzrsVarS = zzrmVarR.s();
            int i2 = zzpsVar.f38008f;
            int iP = zzrsVarS.p();
            int i3 = i2 - 2;
            if (i3 == 1) {
                zzqiVar = zzqi.f38023b;
            } else if (i3 == 2) {
                zzqiVar = zzqi.f38025d;
            } else if (i3 == 3) {
                zzqiVar = zzqi.f38026e;
            } else {
                if (i3 != 4) {
                    throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzwu.a(i2));
                }
                zzqiVar = zzqi.f38024c;
            }
            if (iP < 10 || iP > 16) {
                throw new GeneralSecurityException(android.support.v4.media.b.f(iP, "Invalid tag size for AesCmacParameters: "));
            }
            return zzqe.b(new zzqj(iP, zzqiVar), new zzyw(zzyv.a(zzrmVarR.t().r())), zzpsVar.f38007e);
        } catch (zzadi | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing AesCmacKey failed");
        }
    }
}
