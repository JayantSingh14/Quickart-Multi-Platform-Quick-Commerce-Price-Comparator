package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final class zzlq extends zzoz {
    public static final zzsb e(zzse zzseVar) {
        zzsa zzsaVarQ = zzsb.q();
        zzsh zzshVarT = zzseVar.t();
        if (zzsaVarQ.f37406c) {
            zzsaVarQ.k();
            zzsaVarQ.f37406c = false;
        }
        zzsb.w((zzsb) zzsaVarQ.f37405b, zzshVarT);
        byte[] bArrA = zzyq.a(zzseVar.p());
        zzaby zzabyVarQ = zzaby.q(0, bArrA, bArrA.length);
        if (zzsaVarQ.f37406c) {
            zzsaVarQ.k();
            zzsaVarQ.f37406c = false;
        }
        ((zzsb) zzsaVarQ.f37405b).zzg = zzabyVarQ;
        if (zzsaVarQ.f37406c) {
            zzsaVarQ.k();
            zzsaVarQ.f37406c = false;
        }
        ((zzsb) zzsaVarQ.f37405b).zze = 0;
        return (zzsb) zzsaVarQ.h();
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* bridge */ /* synthetic */ zzaef a(zzaef zzaefVar) {
        return e((zzse) zzaefVar);
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* synthetic */ zzaef b(zzaby zzabyVar) {
        return zzse.s(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final void d(zzaef zzaefVar) throws GeneralSecurityException {
        zzse zzseVar = (zzse) zzaefVar;
        zzys.a(zzseVar.p());
        zzsh zzshVarT = zzseVar.t();
        if (zzshVarT.p() < 12 || zzshVarT.p() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }
}
