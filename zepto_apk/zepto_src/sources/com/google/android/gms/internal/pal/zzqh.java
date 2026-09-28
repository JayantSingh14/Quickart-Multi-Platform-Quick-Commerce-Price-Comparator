package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzqh extends zzpa {
    public static void h(zzrs zzrsVar) throws GeneralSecurityException {
        if (zzrsVar.p() < 10) {
            throw new GeneralSecurityException("tag size too short");
        }
        if (zzrsVar.p() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzoz a() {
        return new zzqg(zzrp.class);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzvn b() {
        return zzvn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* synthetic */ zzaef c(zzaby zzabyVar) {
        return zzrm.r(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final String d() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final void e(zzaef zzaefVar) throws GeneralSecurityException {
        zzrm zzrmVar = (zzrm) zzaefVar;
        zzys.b(zzrmVar.p());
        if (zzrmVar.t().f() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
        h(zzrmVar.s());
    }
}
