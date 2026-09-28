package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final class zzmj extends zzoz {
    @Override // com.google.android.gms.internal.pal.zzoz
    public final zzaef a(zzaef zzaefVar) {
        zzws zzwsVar = (zzws) zzaefVar;
        zzwo zzwoVarQ = zzwp.q();
        if (zzwoVarQ.f37406c) {
            zzwoVarQ.k();
            zzwoVarQ.f37406c = false;
        }
        zzwp.u((zzwp) zzwoVarQ.f37405b, zzwsVar);
        if (zzwoVarQ.f37406c) {
            zzwoVarQ.k();
            zzwoVarQ.f37406c = false;
        }
        ((zzwp) zzwoVarQ.f37405b).zze = 0;
        return (zzwp) zzwoVarQ.h();
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* synthetic */ zzaef b(zzaby zzabyVar) {
        return zzws.r(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzoz
    public final /* bridge */ /* synthetic */ void d(zzaef zzaefVar) throws GeneralSecurityException {
        zzws zzwsVar = (zzws) zzaefVar;
        if (zzwsVar.s().isEmpty() || !zzwsVar.t()) {
            throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
        }
    }
}
