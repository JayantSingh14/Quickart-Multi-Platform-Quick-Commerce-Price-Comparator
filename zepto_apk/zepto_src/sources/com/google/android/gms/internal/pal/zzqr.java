package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzqr extends zzpa {
    public zzqr() {
        super(zzup.class, new zzqp(zzkq.class));
    }

    public static final void h(zzup zzupVar) throws GeneralSecurityException {
        zzys.b(zzupVar.p());
        if (zzupVar.u().f() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        j(zzupVar.t());
    }

    public static zzoy i(int i2, int i3, int i4, int i5) {
        zzur zzurVarQ = zzus.q();
        zzuu zzuuVarQ = zzuv.q();
        if (zzuuVarQ.f37406c) {
            zzuuVarQ.k();
            zzuuVarQ.f37406c = false;
        }
        zzuv.u((zzuv) zzuuVarQ.f37405b, i4);
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
        ((zzus) zzurVarQ.f37405b).zzf = i2;
        return new zzoy((zzus) zzurVarQ.h(), i5);
    }

    public static void j(zzuv zzuvVar) {
        if (zzuvVar.p() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int iT = zzuvVar.t() - 2;
        if (iT == 1) {
            if (zzuvVar.p() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (iT == 2) {
            if (zzuvVar.p() > 48) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (iT == 3) {
            if (zzuvVar.p() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (iT == 4) {
            if (zzuvVar.p() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (iT != 5) {
                throw new GeneralSecurityException("unknown hash type");
            }
            if (zzuvVar.p() > 28) {
                throw new GeneralSecurityException("tag size too big");
            }
        }
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzoz a() {
        return new zzqq(zzus.class);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzvn b() {
        return zzvn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* synthetic */ zzaef c(zzaby zzabyVar) {
        return zzup.s(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final String d() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* bridge */ /* synthetic */ void e(zzaef zzaefVar) throws GeneralSecurityException {
        h((zzup) zzaefVar);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final int f() {
        return 2;
    }
}
