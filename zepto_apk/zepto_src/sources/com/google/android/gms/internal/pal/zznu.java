package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final class zznu implements zzxr {

    /* renamed from: a, reason: collision with root package name */
    public final String f37947a;

    /* renamed from: b, reason: collision with root package name */
    public final int f37948b;

    /* renamed from: c, reason: collision with root package name */
    public final zzst f37949c;

    /* renamed from: d, reason: collision with root package name */
    public final zzrv f37950d;

    /* renamed from: e, reason: collision with root package name */
    public final int f37951e;

    /* renamed from: f, reason: collision with root package name */
    public final zztf f37952f;

    public zznu(zzvt zzvtVar) throws GeneralSecurityException {
        String strS = zzvtVar.s();
        this.f37947a = strS;
        if (strS.equals(zzli.f37920b)) {
            try {
                zzsw zzswVarR = zzsw.r(zzvtVar.r(), zzacm.a());
                this.f37949c = (zzst) zzlf.b(zzvtVar);
                this.f37948b = zzswVarR.p();
                return;
            } catch (zzadi e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e2);
            }
        }
        if (strS.equals(zzli.f37919a)) {
            try {
                zzry zzryVarQ = zzry.q(zzvtVar.r(), zzacm.a());
                this.f37950d = (zzrv) zzlf.b(zzvtVar);
                int iP = zzryVarQ.r().p();
                this.f37951e = iP;
                this.f37948b = iP + zzryVarQ.s().p();
                return;
            } catch (zzadi e3) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
            }
        }
        if (!strS.equals(zznf.f37940a)) {
            throw new GeneralSecurityException("unsupported AEAD DEM key type: ".concat(String.valueOf(strS)));
        }
        try {
            zzti zztiVarR = zzti.r(zzvtVar.r(), zzacm.a());
            this.f37952f = (zztf) zzlf.b(zzvtVar);
            this.f37948b = zztiVarR.p();
        } catch (zzadi e4) {
            throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e4);
        }
    }
}
