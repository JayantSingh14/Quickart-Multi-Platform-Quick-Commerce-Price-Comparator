package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhtv implements zzhjh {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhtv f34282a = new zzhtv();

    @Override // com.google.android.gms.internal.ads.zzhjh
    public final zzhan a(zzhka zzhkaVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhub.f34288a;
        zzhpd zzhpdVar = zzhkaVar.f33917b;
        if (!zzhpdVar.C().equals("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parseParameters: ".concat(String.valueOf(zzhpdVar.C())));
        }
        try {
            zzhzl zzhzlVarD = zzhpdVar.D();
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhoc zzhocVarD = zzhoc.D(zzhzlVarD, zziab.f34621c);
            zzhqz zzhqzVar = new zzhqz();
            zzhqzVar.f34076c = zzhub.b(zzhocVarD.C().C());
            zzhqzVar.f34074a = zzhub.h(zzhocVarD.C().H());
            zzhqzVar.f34075b = zzhub.g(zzhocVarD.C().G());
            zzhqzVar.f34077d = zzhub.c(zzhpdVar.E());
            return zzhqzVar.a();
        } catch (zzibg e2) {
            throw new GeneralSecurityException("Parsing EcdsaParameters failed: ", e2);
        }
    }
}
