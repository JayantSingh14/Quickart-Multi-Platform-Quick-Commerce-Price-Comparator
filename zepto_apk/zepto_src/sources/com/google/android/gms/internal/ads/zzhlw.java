package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhlw implements zzhjh {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhlw f34007a = new zzhlw();

    @Override // com.google.android.gms.internal.ads.zzhjh
    public final zzhan a(zzhka zzhkaVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhma.f34020a;
        zzhpd zzhpdVar = zzhkaVar.f33917b;
        if (!zzhpdVar.C().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzhpdVar.C())));
        }
        try {
            zzhzl zzhzlVarD = zzhpdVar.D();
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhmw zzhmwVarE = zzhmw.E(zzhzlVarD, zziab.f34621c);
            zzhks zzhksVar = new zzhks();
            zzhksVar.a(zzhmwVarE.C());
            zzhksVar.b(zzhmwVarE.D().C());
            zzhksVar.f33949c = zzhma.b(zzhpdVar.E());
            return zzhksVar.c();
        } catch (zzibg e2) {
            throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e2);
        }
    }
}
