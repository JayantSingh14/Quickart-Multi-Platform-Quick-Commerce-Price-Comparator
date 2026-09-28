package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zznk extends zzpr {

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f37944d = new byte[0];

    public zznk() {
        super(zzuc.class, new zzni(zzjx.class));
    }

    public static zzoy h(int i2, zzkk zzkkVar, byte[] bArr, int i3) {
        int i4;
        zztv zztvVarP = zztw.p();
        zzuh zzuhVarP = zzui.p();
        if (zzuhVarP.f37406c) {
            zzuhVarP.k();
            zzuhVarP.f37406c = false;
        }
        zzui.v((zzui) zzuhVarP.f37405b);
        if (zzuhVarP.f37406c) {
            zzuhVarP.k();
            zzuhVarP.f37406c = false;
        }
        zzui.w((zzui) zzuhVarP.f37405b);
        zzaby zzabyVarQ = zzaby.q(0, bArr, bArr.length);
        if (zzuhVarP.f37406c) {
            zzuhVarP.k();
            zzuhVarP.f37406c = false;
        }
        ((zzui) zzuhVarP.f37405b).zzg = zzabyVarQ;
        zzui zzuiVar = (zzui) zzuhVarP.h();
        zzvs zzvsVarP = zzvt.p();
        zzvt zzvtVar = zzkkVar.f37891a;
        String strS = zzvtVar.s();
        if (zzvsVarP.f37406c) {
            zzvsVarP.k();
            zzvsVarP.f37406c = false;
        }
        zzvt.t((zzvt) zzvsVarP.f37405b, strS);
        byte[] bArrR = zzvtVar.r().r();
        zzaby zzabyVarQ2 = zzaby.q(0, bArrR, bArrR.length);
        if (zzvsVarP.f37406c) {
            zzvsVarP.k();
            zzvsVarP.f37406c = false;
        }
        ((zzvt) zzvsVarP.f37405b).zzf = zzabyVarQ2;
        int iV = zzvtVar.v() - 2;
        int i5 = 4;
        if (iV == 1) {
            i4 = 1;
        } else if (iV == 2) {
            i4 = 2;
        } else if (iV == 3) {
            i4 = 3;
        } else {
            if (iV != 4) {
                throw new IllegalArgumentException("Unknown output prefix type");
            }
            i4 = 4;
        }
        int i6 = i4 - 1;
        if (i6 == 0) {
            i5 = 3;
        } else if (i6 != 1) {
            i5 = i6 != 2 ? 6 : 5;
        }
        if (zzvsVarP.f37406c) {
            zzvsVarP.k();
            zzvsVarP.f37406c = false;
        }
        ((zzvt) zzvsVarP.f37405b).zzg = zzwu.a(i5);
        zzvt zzvtVar2 = (zzvt) zzvsVarP.h();
        zzts zztsVarP = zztt.p();
        if (zztsVarP.f37406c) {
            zztsVarP.k();
            zztsVarP.f37406c = false;
        }
        ((zztt) zztsVarP.f37405b).zze = zzvtVar2;
        zztt zzttVar = (zztt) zztsVarP.h();
        zzty zztyVarQ = zztz.q();
        if (zztyVarQ.f37406c) {
            zztyVarQ.k();
            zztyVarQ.f37406c = false;
        }
        ((zztz) zztyVarQ.f37405b).zze = zzuiVar;
        if (zztyVarQ.f37406c) {
            zztyVarQ.k();
            zztyVarQ.f37406c = false;
        }
        ((zztz) zztyVarQ.f37405b).zzf = zzttVar;
        if (zztyVarQ.f37406c) {
            zztyVarQ.k();
            zztyVarQ.f37406c = false;
        }
        zztz.w((zztz) zztyVarQ.f37405b, i2);
        zztz zztzVar = (zztz) zztyVarQ.h();
        if (zztvVarP.f37406c) {
            zztvVarP.k();
            zztvVarP.f37406c = false;
        }
        ((zztw) zztvVarP.f37405b).zze = zztzVar;
        return new zzoy((zztw) zztvVarP.h(), i3);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzoz a() {
        return new zznj(zztw.class);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzvn b() {
        return zzvn.ASYMMETRIC_PRIVATE;
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* synthetic */ zzaef c(zzaby zzabyVar) {
        return zzuc.r(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final String d() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final void e(zzaef zzaefVar) throws GeneralSecurityException {
        zzuc zzucVar = (zzuc) zzaefVar;
        if (zzucVar.t().f() == 0) {
            throw new GeneralSecurityException("invalid ECIES private key");
        }
        zzys.b(zzucVar.p());
        zznt.a(zzucVar.s().q());
    }
}
