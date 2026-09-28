package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhdw implements zzhic {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhdw f33627a = new zzhdw();

    @Override // com.google.android.gms.internal.ads.zzhic
    public final zzgzx a(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhdy.f33629a;
        if (!zzhjzVar.f33909a.equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
        try {
            zzhzl zzhzlVar = zzhjzVar.f33911c;
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhpt zzhptVarE = zzhpt.E(zzhzlVar, zziab.f34621c);
            if (zzhptVarE.C() == 0) {
                return zzhdp.d(zzhdy.c(zzhptVarE.D(), zzhjzVar.f33913e), zzhjzVar.f33914f);
            }
            String strValueOf = String.valueOf(zzhptVarE);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 58);
            sb.append("KmsEnvelopeAeadKeys are only accepted with version 0, got ");
            sb.append(strValueOf);
            throw new GeneralSecurityException(sb.toString());
        } catch (zzibg e2) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e2);
        }
    }
}
