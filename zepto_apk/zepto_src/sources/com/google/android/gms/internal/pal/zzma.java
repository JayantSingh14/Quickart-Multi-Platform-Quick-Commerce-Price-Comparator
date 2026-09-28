package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzma extends zzpa {
    public zzma() {
        super(zzsz.class, new zzly(zzjt.class));
    }

    public static zzoy h(int i2, int i3) {
        zztb zztbVarQ = zztc.q();
        if (zztbVarQ.f37406c) {
            zztbVarQ.k();
            zztbVarQ.f37406c = false;
        }
        ((zztc) zztbVarQ.f37405b).zze = i2;
        return new zzoy((zztc) zztbVarQ.h(), i3);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzoz a() {
        return new zzlz(zztc.class);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzvn b() {
        return zzvn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* synthetic */ zzaef c(zzaby zzabyVar) {
        return zzsz.r(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final String d() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* bridge */ /* synthetic */ void e(zzaef zzaefVar) throws GeneralSecurityException {
        zzsz zzszVar = (zzsz) zzaefVar;
        zzys.b(zzszVar.p());
        zzys.a(zzszVar.s().f());
    }
}
