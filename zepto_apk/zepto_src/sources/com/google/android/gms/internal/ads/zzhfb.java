package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhfb implements zzhjh {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhfb f33700a = new zzhfb();

    @Override // com.google.android.gms.internal.ads.zzhjh
    public final zzhan a(zzhka zzhkaVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhff.f33704a;
        zzhpd zzhpdVar = zzhkaVar.f33917b;
        if (!zzhpdVar.C().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: ".concat(String.valueOf(zzhpdVar.C())));
        }
        try {
            zzhzl zzhzlVarD = zzhpdVar.D();
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhnm zzhnmVarE = zzhnm.E(zzhzlVarD, zziab.f34621c);
            zzhbz zzhbzVar = new zzhbz();
            zzhbzVar.a(zzhnmVarE.D());
            zzhbzVar.b(zzhnmVarE.C().C());
            zzhbzVar.c();
            zzhbzVar.f33504d = zzhff.b(zzhpdVar.E());
            return zzhbzVar.d();
        } catch (zzibg e2) {
            throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e2);
        }
    }
}
