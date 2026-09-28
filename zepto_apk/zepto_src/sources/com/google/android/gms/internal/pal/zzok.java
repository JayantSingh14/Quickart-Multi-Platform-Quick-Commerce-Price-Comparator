package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzok extends zzpa {
    public zzok() {
        super(zzvj.class, new zzoj(zzjy.class));
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzvn b() {
        return zzvn.ASYMMETRIC_PUBLIC;
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* synthetic */ zzaef c(zzaby zzabyVar) {
        return zzvj.t(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final String d() {
        return "type.googleapis.com/google.crypto.tink.HpkePublicKey";
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* bridge */ /* synthetic */ void e(zzaef zzaefVar) throws GeneralSecurityException {
        zzvj zzvjVar = (zzvj) zzaefVar;
        zzys.b(zzvjVar.p());
        if (!zzvjVar.y()) {
            throw new GeneralSecurityException("Missing HPKE key params.");
        }
        zzol.a(zzvjVar.q());
    }
}
