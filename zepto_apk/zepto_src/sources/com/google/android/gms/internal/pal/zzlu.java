package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzlu extends zzpa {
    public zzlu() {
        super(zzsk.class, new zzls(zzjt.class));
    }

    public static zzoy h(int i2, int i3) {
        zzsm zzsmVarQ = zzsn.q();
        if (zzsmVarQ.f37406c) {
            zzsmVarQ.k();
            zzsmVarQ.f37406c = false;
        }
        ((zzsn) zzsmVarQ.f37405b).zzf = i2;
        zzsp zzspVarQ = zzsq.q();
        if (zzspVarQ.f37406c) {
            zzspVarQ.k();
            zzspVarQ.f37406c = false;
        }
        ((zzsq) zzspVarQ.f37405b).zze = 16;
        zzsq zzsqVar = (zzsq) zzspVarQ.h();
        if (zzsmVarQ.f37406c) {
            zzsmVarQ.k();
            zzsmVarQ.f37406c = false;
        }
        ((zzsn) zzsmVarQ.f37405b).zze = zzsqVar;
        return new zzoy((zzsn) zzsmVarQ.h(), i3);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzoz a() {
        return new zzlt(zzsn.class);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzvn b() {
        return zzvn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* synthetic */ zzaef c(zzaby zzabyVar) {
        return zzsk.r(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final String d() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* bridge */ /* synthetic */ void e(zzaef zzaefVar) throws GeneralSecurityException {
        zzsk zzskVar = (zzsk) zzaefVar;
        zzys.b(zzskVar.p());
        zzys.a(zzskVar.t().f());
        if (zzskVar.s().p() != 12 && zzskVar.s().p() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
