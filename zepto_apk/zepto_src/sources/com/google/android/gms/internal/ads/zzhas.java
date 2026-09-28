package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhas {
    public static zzhai a(String str) {
        try {
            try {
                byte[] bArrG = new zzgzw(new ByteArrayInputStream(str.getBytes(zzgzw.f33405b))).a().g();
                try {
                    zziab zziabVar = zziab.f34620b;
                    int i2 = zzhyy.f34536a;
                    zzhpj zzhpjVarG = zzhpj.G(bArrG, zziab.f34621c);
                    for (zzhpi zzhpiVar : zzhpjVarG.D()) {
                        if (zzhpiVar.D().E() == zzhoz.UNKNOWN_KEYMATERIAL || zzhpiVar.D().E() == zzhoz.SYMMETRIC || zzhpiVar.D().E() == zzhoz.ASYMMETRIC_PRIVATE) {
                            throw new GeneralSecurityException("keyset contains key material of type " + zzhpiVar.D().E().name() + " for type url " + zzhpiVar.D().C());
                        }
                    }
                    return zzhai.a(zzhpjVarG);
                } catch (zzibg unused) {
                    throw new GeneralSecurityException("invalid keyset");
                }
            } catch (zzibg unused2) {
                throw new GeneralSecurityException("invalid keyset");
            }
        } catch (IOException unused3) {
            throw new GeneralSecurityException("Parse keyset failed");
        }
    }
}
