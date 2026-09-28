package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhue implements zzhjh {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhue f34305a = new zzhue();

    @Override // com.google.android.gms.internal.ads.zzhjh
    public final zzhan a(zzhka zzhkaVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhuk.f34311a;
        zzhpd zzhpdVar = zzhkaVar.f33917b;
        if (!zzhpdVar.C().equals("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to Ed25519ProtoSerialization.parseParameters: ".concat(String.valueOf(zzhpdVar.C())));
        }
        try {
            zzhzl zzhzlVarD = zzhpdVar.D();
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            if (zzhol.D(zzhzlVarD, zziab.f34621c).C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            return new zzhro((zzhrn) zzhuk.f34317g.b(zzhpdVar.E()));
        } catch (zzibg e2) {
            throw new GeneralSecurityException("Parsing Ed25519Parameters failed: ", e2);
        }
    }
}
