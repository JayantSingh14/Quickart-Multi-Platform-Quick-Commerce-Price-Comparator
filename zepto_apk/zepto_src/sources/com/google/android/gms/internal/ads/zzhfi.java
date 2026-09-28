package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhfi implements zzhjh {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhfi f33709a = new zzhfi();

    @Override // com.google.android.gms.internal.ads.zzhjh
    public final zzhan a(zzhka zzhkaVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhfm.f33713a;
        zzhpd zzhpdVar = zzhkaVar.f33917b;
        if (!zzhpdVar.C().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(zzhpdVar.C())));
        }
        try {
            zzhzl zzhzlVarD = zzhpdVar.D();
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhns zzhnsVarE = zzhns.E(zzhzlVarD, zziab.f34621c);
            if (zzhnsVarE.D() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            zzhci zzhciVar = new zzhci();
            zzhciVar.a(zzhnsVarE.C());
            zzhciVar.b();
            zzhciVar.c();
            zzhciVar.f33531d = zzhfm.b(zzhpdVar.E());
            return zzhciVar.d();
        } catch (zzibg e2) {
            throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e2);
        }
    }
}
