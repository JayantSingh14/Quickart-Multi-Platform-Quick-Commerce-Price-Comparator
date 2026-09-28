package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhdk implements zzhjh {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhdk f33596a = new zzhdk();

    @Override // com.google.android.gms.internal.ads.zzhjh
    public final zzhan a(zzhka zzhkaVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhdo.f33600a;
        zzhpd zzhpdVar = zzhkaVar.f33917b;
        if (!zzhpdVar.C().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzhpdVar.C())));
        }
        try {
            zzhzl zzhzlVarD = zzhpdVar.D();
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            return new zzhdj(zzhpr.D(zzhzlVarD, zziab.f34621c).C(), zzhdo.b(zzhpdVar.E()));
        } catch (zzibg e2) {
            throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e2);
        }
    }
}
