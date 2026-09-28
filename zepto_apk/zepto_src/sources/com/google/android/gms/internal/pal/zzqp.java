package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
final class zzqp extends zzpq {
    @Override // com.google.android.gms.internal.pal.zzpq
    public final /* bridge */ /* synthetic */ Object a(zzaef zzaefVar) throws GeneralSecurityException {
        zzup zzupVar = (zzup) zzaefVar;
        int iT = zzupVar.t().t();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzupVar.u().r(), "HMAC");
        int iP = zzupVar.t().p();
        int i2 = iT - 2;
        if (i2 == 1) {
            return new zzyo(new zzyn("HMACSHA1", secretKeySpec), iP);
        }
        if (i2 == 2) {
            return new zzyo(new zzyn("HMACSHA384", secretKeySpec), iP);
        }
        if (i2 == 3) {
            return new zzyo(new zzyn("HMACSHA256", secretKeySpec), iP);
        }
        if (i2 == 4) {
            return new zzyo(new zzyn("HMACSHA512", secretKeySpec), iP);
        }
        if (i2 == 5) {
            return new zzyo(new zzyn("HMACSHA224", secretKeySpec), iP);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}
