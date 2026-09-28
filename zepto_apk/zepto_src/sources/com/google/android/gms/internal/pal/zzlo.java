package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzlo extends zzpa {
    public zzlo() {
        super(zzrv.class, new zzlm(zzjt.class));
    }

    public static zzoy h(int i2, int i3, int i4) {
        zzsd zzsdVarQ = zzse.q();
        zzsg zzsgVarQ = zzsh.q();
        if (zzsgVarQ.f37406c) {
            zzsgVarQ.k();
            zzsgVarQ.f37406c = false;
        }
        ((zzsh) zzsgVarQ.f37405b).zze = 16;
        zzsh zzshVar = (zzsh) zzsgVarQ.h();
        if (zzsdVarQ.f37406c) {
            zzsdVarQ.k();
            zzsdVarQ.f37406c = false;
        }
        ((zzse) zzsdVarQ.f37405b).zze = zzshVar;
        if (zzsdVarQ.f37406c) {
            zzsdVarQ.k();
            zzsdVarQ.f37406c = false;
        }
        ((zzse) zzsdVarQ.f37405b).zzf = i2;
        zzse zzseVar = (zzse) zzsdVarQ.h();
        zzur zzurVarQ = zzus.q();
        zzuu zzuuVarQ = zzuv.q();
        if (zzuuVarQ.f37406c) {
            zzuuVarQ.k();
            zzuuVarQ.f37406c = false;
        }
        zzuv.u((zzuv) zzuuVarQ.f37405b, 5);
        if (zzuuVarQ.f37406c) {
            zzuuVarQ.k();
            zzuuVarQ.f37406c = false;
        }
        ((zzuv) zzuuVarQ.f37405b).zzf = i3;
        zzuv zzuvVar = (zzuv) zzuuVarQ.h();
        if (zzurVarQ.f37406c) {
            zzurVarQ.k();
            zzurVarQ.f37406c = false;
        }
        ((zzus) zzurVarQ.f37405b).zze = zzuvVar;
        if (zzurVarQ.f37406c) {
            zzurVarQ.k();
            zzurVarQ.f37406c = false;
        }
        ((zzus) zzurVarQ.f37405b).zzf = 32;
        zzus zzusVar = (zzus) zzurVarQ.h();
        zzrx zzrxVarP = zzry.p();
        if (zzrxVarP.f37406c) {
            zzrxVarP.k();
            zzrxVarP.f37406c = false;
        }
        ((zzry) zzrxVarP.f37405b).zze = zzseVar;
        if (zzrxVarP.f37406c) {
            zzrxVarP.k();
            zzrxVarP.f37406c = false;
        }
        ((zzry) zzrxVarP.f37405b).zzf = zzusVar;
        return new zzoy((zzry) zzrxVarP.h(), i4);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzoz a() {
        return new zzln(zzry.class);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzvn b() {
        return zzvn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* synthetic */ zzaef c(zzaby zzabyVar) {
        return zzrv.r(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final String d() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final void e(zzaef zzaefVar) throws GeneralSecurityException {
        zzrv zzrvVar = (zzrv) zzaefVar;
        zzys.b(zzrvVar.p());
        new zzlr();
        zzsb zzsbVarS = zzrvVar.s();
        zzys.b(zzsbVarS.p());
        zzys.a(zzsbVarS.u().f());
        zzsh zzshVarT = zzsbVarS.t();
        if (zzshVarT.p() < 12 || zzshVarT.p() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
        new zzqr();
        zzqr.h(zzrvVar.t());
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final int f() {
        return 2;
    }
}
