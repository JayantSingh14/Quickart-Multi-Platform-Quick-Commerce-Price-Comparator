package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhur implements zzhic {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhur f34329a = new zzhur();

    @Override // com.google.android.gms.internal.ads.zzhic
    public final zzgzx a(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhuv.f34333a;
        String str = zzhjzVar.f33909a;
        if (!str.equals("type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PublicKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to RsaSsaPkcs1ProtoSerialization.parsePublicKey: ".concat(String.valueOf(str)));
        }
        try {
            zzhzl zzhzlVar = zzhjzVar.f33911c;
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhqg zzhqgVarG = zzhqg.G(zzhzlVar, zziab.f34621c);
            if (zzhqgVarG.C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            BigInteger bigInteger = new BigInteger(1, zzhqgVarG.E().z());
            int iBitLength = bigInteger.bitLength();
            BigInteger bigInteger2 = zzhsw.f34191e;
            zzhst zzhstVar = new zzhst();
            zzhstVar.f34180c = (zzhsu) zzhuv.f34340h.b(zzhqgVarG.D().C());
            zzhstVar.f34179b = new BigInteger(1, zzhqgVarG.F().z());
            zzhstVar.a(iBitLength);
            zzhstVar.f34181d = (zzhsv) zzhuv.f34339g.b(zzhjzVar.f33913e);
            zzhsw zzhswVarB = zzhstVar.b();
            zzhsz zzhszVar = new zzhsz();
            zzhszVar.f34210a = zzhswVarB;
            zzhszVar.f34211b = bigInteger;
            zzhszVar.f34212c = zzhjzVar.f33914f;
            return zzhszVar.a();
        } catch (zzibg | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing RsaSsaPkcs1PublicKey failed");
        }
    }
}
