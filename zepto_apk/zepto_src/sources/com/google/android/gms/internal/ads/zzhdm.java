package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhdm implements zzhic {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhdm f33598a = new zzhdm();

    @Override // com.google.android.gms.internal.ads.zzhic
    public final zzgzx a(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhdo.f33600a;
        if (!zzhjzVar.f33909a.equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
        }
        try {
            zzhzl zzhzlVar = zzhjzVar.f33911c;
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhpp zzhppVarE = zzhpp.E(zzhzlVar, zziab.f34621c);
            if (zzhppVarE.C() == 0) {
                return zzhdh.d(new zzhdj(zzhppVarE.D().C(), zzhdo.b(zzhjzVar.f33913e)), zzhjzVar.f33914f);
            }
            String strValueOf = String.valueOf(zzhppVarE);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 49);
            sb.append("KmsAeadKey are only accepted with version 0, got ");
            sb.append(strValueOf);
            throw new GeneralSecurityException(sb.toString());
        } catch (zzibg e2) {
            throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e2);
        }
    }
}
