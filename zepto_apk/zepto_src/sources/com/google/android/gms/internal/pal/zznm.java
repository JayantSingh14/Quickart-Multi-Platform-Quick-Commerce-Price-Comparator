package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final class zznm extends zzpa {
    public zznm() {
        super(zzuf.class, new zznl(zzjy.class));
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzvn b() {
        return zzvn.ASYMMETRIC_PUBLIC;
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* synthetic */ zzaef c(zzaby zzabyVar) {
        return zzuf.t(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final String d() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* bridge */ /* synthetic */ void e(zzaef zzaefVar) throws GeneralSecurityException {
        zzuf zzufVar = (zzuf) zzaefVar;
        zzys.b(zzufVar.p());
        zznt.a(zzufVar.q());
    }
}
