package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhgk implements zzhjh {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhgk f33759a = new zzhgk();

    @Override // com.google.android.gms.internal.ads.zzhjh
    public final zzhan a(zzhka zzhkaVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhgo.f33763a;
        zzhpd zzhpdVar = zzhkaVar.f33917b;
        if (!zzhpdVar.C().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to XAesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(zzhpdVar.C())));
        }
        try {
            zzhzl zzhzlVarD = zzhpdVar.D();
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhqs zzhqsVarE = zzhqs.E(zzhzlVarD, zziab.f34621c);
            if (zzhqsVarE.C() == 0) {
                return zzheo.b(zzhgo.b(zzhpdVar.E()), zzhqsVarE.D().C());
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzibg e2) {
            throw new GeneralSecurityException("Parsing XAesGcmParameters failed: ", e2);
        }
    }
}
