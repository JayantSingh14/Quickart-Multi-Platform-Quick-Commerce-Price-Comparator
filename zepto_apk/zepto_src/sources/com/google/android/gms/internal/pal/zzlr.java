package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzlr extends zzpa {
    public zzlr() {
        super(zzsb.class, new zzlp(zzyk.class));
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzoz a() {
        return new zzlq(zzse.class);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzvn b() {
        return zzvn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* synthetic */ zzaef c(zzaby zzabyVar) {
        return zzsb.s(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final String d() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final void e(zzaef zzaefVar) throws GeneralSecurityException {
        zzsb zzsbVar = (zzsb) zzaefVar;
        zzys.b(zzsbVar.p());
        zzys.a(zzsbVar.u().f());
        zzsh zzshVarT = zzsbVar.t();
        if (zzshVarT.p() < 12 || zzshVarT.p() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }
}
