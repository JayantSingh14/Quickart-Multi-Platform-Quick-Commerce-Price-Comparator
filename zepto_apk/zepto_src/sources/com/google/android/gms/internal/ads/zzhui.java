package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhui implements zzhic {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhui f34309a = new zzhui();

    @Override // com.google.android.gms.internal.ads.zzhic
    public final zzgzx a(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhuk.f34311a;
        String str = zzhjzVar.f33909a;
        if (!str.equals("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to Ed25519ProtoSerialization.parsePrivateKey: ".concat(String.valueOf(str)));
        }
        try {
            zzhzl zzhzlVar = zzhjzVar.f33911c;
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhon zzhonVarF = zzhon.F(zzhzlVar, zziab.f34621c);
            if (zzhonVarF.C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhop zzhopVarE = zzhonVarF.E();
            if (zzhopVarE.C() == 0) {
                return zzhrp.d(zzhrv.d((zzhrn) zzhuk.f34317g.b(zzhjzVar.f33913e), zzhxc.a(zzhopVarE.D().z()), zzhjzVar.f33914f), zzhxe.a(zzhonVarF.D().z()));
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzibg unused) {
            throw new GeneralSecurityException("Parsing Ed25519PrivateKey failed");
        }
    }
}
