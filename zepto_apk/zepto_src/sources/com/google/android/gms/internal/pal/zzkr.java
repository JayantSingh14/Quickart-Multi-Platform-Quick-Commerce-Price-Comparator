package com.google.android.gms.internal.pal;

import java.security.GeneralSecurityException;

@Deprecated
/* loaded from: classes4.dex */
public final class zzkr {
    public static final zzkm a(byte[] bArr) {
        try {
            zzwb zzwbVarS = zzwb.s(bArr, zzacm.a());
            for (zzwa zzwaVar : zzwbVarS.t()) {
                if (zzwaVar.q().q() == zzvn.UNKNOWN_KEYMATERIAL || zzwaVar.q().q() == zzvn.SYMMETRIC || zzwaVar.q().q() == zzvn.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            if (zzwbVarS.p() > 0) {
                return new zzkm(zzwbVarS);
            }
            throw new GeneralSecurityException("empty keyset");
        } catch (zzadi unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
