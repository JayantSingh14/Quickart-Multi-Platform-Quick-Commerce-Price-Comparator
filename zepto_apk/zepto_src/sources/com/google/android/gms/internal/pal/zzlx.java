package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzlx extends zzpa {
    public zzlx() {
        super(zzst.class, new zzlv(zzjt.class));
    }

    public static zzoy h(int i2, int i3) {
        zzsv zzsvVarQ = zzsw.q();
        if (zzsvVarQ.f37406c) {
            zzsvVarQ.k();
            zzsvVarQ.f37406c = false;
        }
        ((zzsw) zzsvVarQ.f37405b).zze = i2;
        return new zzoy((zzsw) zzsvVarQ.h(), i3);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzoz a() {
        return new zzlw(zzsw.class);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzvn b() {
        return zzvn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* synthetic */ zzaef c(zzaby zzabyVar) {
        return zzst.r(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final String d() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* bridge */ /* synthetic */ void e(zzaef zzaefVar) throws GeneralSecurityException {
        zzst zzstVar = (zzst) zzaefVar;
        zzys.b(zzstVar.p());
        zzys.a(zzstVar.s().f());
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final int f() {
        return 2;
    }
}
