package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhew implements zzhjh {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhew f33686a = new zzhew();

    @Override // com.google.android.gms.internal.ads.zzhjh
    public final zzhan a(zzhka zzhkaVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhfa.f33696a;
        zzhpd zzhpdVar = zzhkaVar.f33917b;
        if (!zzhpdVar.C().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzhpdVar.C())));
        }
        try {
            zzhzl zzhzlVarD = zzhpdVar.D();
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhnc zzhncVarE = zzhnc.E(zzhzlVarD, zziab.f34621c);
            if (zzhncVarE.D().E() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhbq zzhbqVar = new zzhbq();
            zzhbqVar.a(zzhncVarE.C().D());
            zzhbqVar.b(zzhncVarE.D().D());
            zzhbqVar.c(zzhncVarE.C().C().C());
            zzhbqVar.d(zzhncVarE.D().C().D());
            zzhbqVar.f33471e = zzhfa.c(zzhncVarE.D().C().C());
            zzhbqVar.f33472f = zzhfa.b(zzhpdVar.E());
            return zzhbqVar.e();
        } catch (zzibg e2) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e2);
        }
    }
}
