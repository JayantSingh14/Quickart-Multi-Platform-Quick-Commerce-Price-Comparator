package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhvc implements zzhic {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhvc f34363a = new zzhvc();

    @Override // com.google.android.gms.internal.ads.zzhic
    public final zzgzx a(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhve.f34365a;
        String str = zzhjzVar.f33909a;
        if (!str.equals("type.googleapis.com/google.crypto.tink.RsaSsaPssPrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to RsaSsaPssProtoSerialization.parsePrivateKey: ".concat(String.valueOf(str)));
        }
        try {
            zzhzl zzhzlVar = zzhjzVar.f33911c;
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhqm zzhqmVarK = zzhqm.K(zzhzlVar, zziab.f34621c);
            if (zzhqmVarK.C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhqo zzhqoVarD = zzhqmVarK.D();
            if (zzhqoVarD.C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            BigInteger bigInteger = new BigInteger(1, zzhqoVarD.E().z());
            int iBitLength = bigInteger.bitLength();
            BigInteger bigInteger2 = new BigInteger(1, zzhqoVarD.F().z());
            BigInteger bigInteger3 = zzhti.f34245g;
            zzhtf zzhtfVar = new zzhtf();
            zzhhs zzhhsVar = zzhve.f34372h;
            zzhtfVar.f34232c = (zzhtg) zzhhsVar.b(zzhqoVarD.D().C());
            zzhtfVar.f34233d = (zzhtg) zzhhsVar.b(zzhqoVarD.D().D());
            zzhtfVar.f34231b = bigInteger2;
            zzhtfVar.a(iBitLength);
            zzhtfVar.b(zzhqoVarD.D().E());
            zzhtfVar.f34235f = (zzhth) zzhve.f34371g.b(zzhjzVar.f33913e);
            zzhti zzhtiVarC = zzhtfVar.c();
            zzhtl zzhtlVar = new zzhtl();
            zzhtlVar.f34266a = zzhtiVarC;
            zzhtlVar.f34267b = bigInteger;
            zzhtlVar.f34268c = zzhjzVar.f33914f;
            zzhtm zzhtmVarA = zzhtlVar.a();
            zzhtj zzhtjVar = new zzhtj();
            zzhtjVar.f34252a = zzhtmVarA;
            zzhxd zzhxdVarC = zzhve.c(zzhqmVarK.F());
            zzhxd zzhxdVarC2 = zzhve.c(zzhqmVarK.G());
            zzhtjVar.f34254c = zzhxdVarC;
            zzhtjVar.f34255d = zzhxdVarC2;
            zzhtjVar.f34253b = zzhve.c(zzhqmVarK.E());
            zzhxd zzhxdVarC3 = zzhve.c(zzhqmVarK.H());
            zzhxd zzhxdVarC4 = zzhve.c(zzhqmVarK.I());
            zzhtjVar.f34256e = zzhxdVarC3;
            zzhtjVar.f34257f = zzhxdVarC4;
            zzhtjVar.f34258g = zzhve.c(zzhqmVarK.J());
            return zzhtjVar.a();
        } catch (zzibg | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing RsaSsaPssPrivateKey failed");
        }
    }
}
