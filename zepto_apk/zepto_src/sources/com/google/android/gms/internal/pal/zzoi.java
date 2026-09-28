package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzoi extends zzpr {
    public zzoi() {
        super(zzvg.class, new zzog(zzjx.class));
    }

    public static zzoy h(int i2, int i3, int i4, int i5) {
        zzvc zzvcVarP = zzvd.p();
        if (zzvcVarP.f37406c) {
            zzvcVarP.k();
            zzvcVarP.f37406c = false;
        }
        ((zzvd) zzvcVarP.f37405b).zze = i2 - 2;
        if (zzvcVarP.f37406c) {
            zzvcVarP.k();
            zzvcVarP.f37406c = false;
        }
        ((zzvd) zzvcVarP.f37405b).zzf = i3 - 2;
        if (zzvcVarP.f37406c) {
            zzvcVarP.k();
            zzvcVarP.f37406c = false;
        }
        ((zzvd) zzvcVarP.f37405b).zzg = i4 - 2;
        zzvd zzvdVar = (zzvd) zzvcVarP.h();
        zzuz zzuzVarP = zzva.p();
        if (zzuzVarP.f37406c) {
            zzuzVarP.k();
            zzuzVarP.f37406c = false;
        }
        ((zzva) zzuzVarP.f37405b).zze = zzvdVar;
        return new zzoy((zzva) zzuzVarP.h(), i5);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzoz a() {
        return new zzoh(zzva.class);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzvn b() {
        return zzvn.ASYMMETRIC_PRIVATE;
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* synthetic */ zzaef c(zzaby zzabyVar) {
        return zzvg.r(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final String d() {
        return "type.googleapis.com/google.crypto.tink.HpkePrivateKey";
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final void e(zzaef zzaefVar) throws GeneralSecurityException {
        zzvg zzvgVar = (zzvg) zzaefVar;
        if (zzvgVar.t().f() == 0) {
            throw new GeneralSecurityException("Private key is empty.");
        }
        if (!zzvgVar.x()) {
            throw new GeneralSecurityException("Missing public key.");
        }
        zzys.b(zzvgVar.p());
        zzol.a(zzvgVar.s().q());
    }
}
