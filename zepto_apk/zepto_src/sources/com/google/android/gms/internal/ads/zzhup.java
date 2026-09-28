package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhup implements zzhjh {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhup f34327a = new zzhup();

    @Override // com.google.android.gms.internal.ads.zzhjh
    public final zzhan a(zzhka zzhkaVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhuv.f34333a;
        zzhpd zzhpdVar = zzhkaVar.f33917b;
        if (!zzhpdVar.C().equals("type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to RsaSsaPkcs1ProtoSerialization.parseParameters: ".concat(String.valueOf(zzhpdVar.C())));
        }
        try {
            zzhzl zzhzlVarD = zzhpdVar.D();
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhqa zzhqaVarF = zzhqa.F(zzhzlVarD, zziab.f34621c);
            BigInteger bigInteger = zzhsw.f34191e;
            zzhst zzhstVar = new zzhst();
            zzhstVar.f34180c = (zzhsu) zzhuv.f34340h.b(zzhqaVarF.C().C());
            zzhstVar.f34179b = new BigInteger(1, zzhqaVarF.E().z());
            zzhstVar.a(zzhqaVarF.D());
            zzhstVar.f34181d = (zzhsv) zzhuv.f34339g.b(zzhpdVar.E());
            return zzhstVar.b();
        } catch (zzibg e2) {
            throw new GeneralSecurityException("Parsing RsaSsaPkcs1Parameters failed: ", e2);
        }
    }
}
