package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhut implements zzhic {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhut f34331a = new zzhut();

    @Override // com.google.android.gms.internal.ads.zzhic
    public final zzgzx a(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhuv.f34333a;
        String str = zzhjzVar.f33909a;
        if (!str.equals("type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to RsaSsaPkcs1ProtoSerialization.parsePrivateKey: ".concat(String.valueOf(str)));
        }
        try {
            zzhzl zzhzlVar = zzhjzVar.f33911c;
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhqe zzhqeVarK = zzhqe.K(zzhzlVar, zziab.f34621c);
            if (zzhqeVarK.C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhqg zzhqgVarD = zzhqeVarK.D();
            if (zzhqgVarD.C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            BigInteger bigInteger = new BigInteger(1, zzhqgVarD.E().z());
            int iBitLength = bigInteger.bitLength();
            BigInteger bigInteger2 = new BigInteger(1, zzhqgVarD.F().z());
            BigInteger bigInteger3 = zzhsw.f34191e;
            zzhst zzhstVar = new zzhst();
            zzhstVar.f34180c = (zzhsu) zzhuv.f34340h.b(zzhqgVarD.D().C());
            zzhstVar.f34179b = bigInteger2;
            zzhstVar.a(iBitLength);
            zzhstVar.f34181d = (zzhsv) zzhuv.f34339g.b(zzhjzVar.f33913e);
            zzhsw zzhswVarB = zzhstVar.b();
            zzhsz zzhszVar = new zzhsz();
            zzhszVar.f34210a = zzhswVarB;
            zzhszVar.f34211b = bigInteger;
            zzhszVar.f34212c = zzhjzVar.f33914f;
            zzhta zzhtaVarA = zzhszVar.a();
            zzhsx zzhsxVar = new zzhsx();
            zzhsxVar.f34196a = zzhtaVarA;
            zzhxd zzhxdVarB = zzhuv.b(zzhqeVarK.F());
            zzhxd zzhxdVarB2 = zzhuv.b(zzhqeVarK.G());
            zzhsxVar.f34198c = zzhxdVarB;
            zzhsxVar.f34199d = zzhxdVarB2;
            zzhsxVar.f34197b = zzhuv.b(zzhqeVarK.E());
            zzhxd zzhxdVarB3 = zzhuv.b(zzhqeVarK.H());
            zzhxd zzhxdVarB4 = zzhuv.b(zzhqeVarK.I());
            zzhsxVar.f34200e = zzhxdVarB3;
            zzhsxVar.f34201f = zzhxdVarB4;
            zzhsxVar.f34202g = zzhuv.b(zzhqeVarK.J());
            return zzhsxVar.a();
        } catch (zzibg | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing RsaSsaPkcs1PrivateKey failed");
        }
    }
}
