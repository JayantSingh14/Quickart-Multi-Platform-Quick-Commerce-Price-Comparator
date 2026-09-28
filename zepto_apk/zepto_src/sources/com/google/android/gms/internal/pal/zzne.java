package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: classes4.dex */
public final class zzne extends zzpa {
    public zzne() {
        super(zztf.class, new zznc(zzjw.class));
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzoz a() {
        return new zznd(zzti.class);
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final zzvn b() {
        return zzvn.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* synthetic */ zzaef c(zzaby zzabyVar) {
        return zztf.r(zzabyVar, zzacm.a());
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final String d() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    @Override // com.google.android.gms.internal.pal.zzpa
    public final /* bridge */ /* synthetic */ void e(zzaef zzaefVar) throws GeneralSecurityException {
        zztf zztfVar = (zztf) zzaefVar;
        zzys.b(zztfVar.p());
        if (zztfVar.s().f() != 64) {
            throw new InvalidKeyException(android.support.v4.media.b.g(zztfVar.s().f(), "invalid key size: ", ". Valid keys must have 64 bytes."));
        }
    }
}
