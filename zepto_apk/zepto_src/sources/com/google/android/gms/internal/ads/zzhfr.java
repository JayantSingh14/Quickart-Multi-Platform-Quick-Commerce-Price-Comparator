package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhfr implements zzhic {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhfr f33727a = new zzhfr();

    @Override // com.google.android.gms.internal.ads.zzhic
    public final zzgzx a(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhft.f33729a;
        if (!zzhjzVar.f33909a.equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
        try {
            zzhzl zzhzlVar = zzhjzVar.f33911c;
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhnu zzhnuVarE = zzhnu.E(zzhzlVar, zziab.f34621c);
            if (zzhnuVarE.C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhcr zzhcrVar = new zzhcr();
            zzhcrVar.a(zzhnuVarE.D().i());
            zzhcrVar.f33553b = zzhft.b(zzhjzVar.f33913e);
            zzhct zzhctVarB = zzhcrVar.b();
            zzhcl zzhclVar = new zzhcl();
            zzhclVar.f33538a = zzhctVarB;
            zzhclVar.f33539b = zzhxe.a(zzhnuVarE.D().z());
            zzhclVar.f33540c = zzhjzVar.f33914f;
            return zzhclVar.a();
        } catch (zzibg unused) {
            throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
        }
    }
}
