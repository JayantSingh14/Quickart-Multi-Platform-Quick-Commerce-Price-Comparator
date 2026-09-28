package com.google.android.gms.internal.pal;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;

/* loaded from: classes4.dex */
final class zznl extends zzpq {
    @Override // com.google.android.gms.internal.pal.zzpq
    public final Object a(zzaef zzaefVar) throws GeneralSecurityException {
        zzuf zzufVar = (zzuf) zzaefVar;
        zztz zztzVarQ = zzufVar.q();
        zzui zzuiVarS = zztzVarQ.s();
        int iC = zznt.c(zzuiVarS.t());
        byte[] bArrR = zzufVar.u().r();
        byte[] bArrR2 = zzufVar.v().r();
        ECParameterSpec eCParameterSpecG = zzxx.g(iC);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, bArrR), new BigInteger(1, bArrR2));
        zzxx.b(eCPoint, eCParameterSpecG.getCurve());
        return new zzxt((ECPublicKey) ((KeyFactory) zzxz.f38145i.a("EC")).generatePublic(new ECPublicKeySpec(eCPoint, eCParameterSpecG)), zzuiVarS.r().r(), zznt.b(zzuiVarS.u()), zznt.d(zztzVarQ.v()), new zznu(zztzVarQ.p().r()));
    }
}
