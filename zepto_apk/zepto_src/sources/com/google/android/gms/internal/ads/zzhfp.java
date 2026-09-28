package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhfp implements zzhjh {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhfp f33725a = new zzhfp();

    @Override // com.google.android.gms.internal.ads.zzhjh
    public final zzhan a(zzhka zzhkaVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhft.f33729a;
        zzhpd zzhpdVar = zzhkaVar.f33917b;
        if (!zzhpdVar.C().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: ".concat(String.valueOf(zzhpdVar.C())));
        }
        try {
            zzhzl zzhzlVarD = zzhpdVar.D();
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhnw zzhnwVarE = zzhnw.E(zzhzlVarD, zziab.f34621c);
            if (zzhnwVarE.D() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            zzhcr zzhcrVar = new zzhcr();
            zzhcrVar.a(zzhnwVarE.C());
            zzhcrVar.f33553b = zzhft.b(zzhpdVar.E());
            return zzhcrVar.b();
        } catch (zzibg e2) {
            throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e2);
        }
    }
}
