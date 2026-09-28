package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Mac;

/* loaded from: classes4.dex */
public final class zzhwp implements zzhmn {
    public static zzhmn b(zzhml zzhmlVar) throws GeneralSecurityException {
        zzhxe zzhxeVar = zzhmlVar.f34035b;
        zzhmr zzhmrVar = new zzhmr(zzhxeVar.f34463a.b());
        try {
            Provider providerA = zzhhf.a();
            if (providerA == null) {
                throw new GeneralSecurityException("Conscrypt not available");
            }
            Mac.getInstance("AESCMAC", providerA);
            return new zzhwo(zzhmrVar, new zzhms(zzhxeVar.f34463a.b(), providerA));
        } catch (GeneralSecurityException unused) {
            return zzhmrVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhmn
    public final byte[] a(int i2, byte[] bArr) {
        throw null;
    }
}
