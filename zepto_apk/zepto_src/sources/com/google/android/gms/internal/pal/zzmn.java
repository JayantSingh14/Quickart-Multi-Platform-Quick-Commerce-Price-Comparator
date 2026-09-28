package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzmn extends zzpa {
    public zzmn() {
        super(zzxa.class, new zzml(zzjt.class));
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzoz a() {
        return new zzmm(zzxd.class);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzvn b() {
        return zzvn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* synthetic */ zzaef c(zzaby zzabyVar) {
        return zzxa.r(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final String d() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* bridge */ /* synthetic */ void e(zzaef zzaefVar) throws GeneralSecurityException {
        zzxa zzxaVar = (zzxa) zzaefVar;
        zzys.b(zzxaVar.p());
        if (zzxaVar.s().f() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }
}
