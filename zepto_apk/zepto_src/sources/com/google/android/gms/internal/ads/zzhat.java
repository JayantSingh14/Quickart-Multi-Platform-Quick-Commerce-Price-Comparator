package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhat {
    public static zzhan a(byte[] bArr) {
        try {
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhpd zzhpdVarF = zzhpd.F(bArr, zziab.f34621c);
            zzhje zzhjeVar = zzhje.f33884b;
            zzhxc zzhxcVarB = zzhkl.b(zzhpdVarF.C());
            zzhka zzhkaVar = new zzhka(zzhpdVarF, zzhxcVarB);
            zzhki zzhkiVar = (zzhki) zzhjeVar.f33885a.get();
            zzhkiVar.getClass();
            return !zzhkiVar.f33931d.containsKey(new zzhkg(zzhka.class, zzhxcVarB)) ? new zzhin(zzhkaVar) : zzhjeVar.g(zzhkaVar);
        } catch (IOException e2) {
            throw new GeneralSecurityException("Failed to parse proto", e2);
        }
    }
}
