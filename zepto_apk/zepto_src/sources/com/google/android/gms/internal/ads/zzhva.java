package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhva implements zzhic {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhva f34361a = new zzhva();

    @Override // com.google.android.gms.internal.ads.zzhic
    public final zzgzx a(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhve.f34365a;
        String str = zzhjzVar.f33909a;
        if (!str.equals("type.googleapis.com/google.crypto.tink.RsaSsaPssPublicKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to RsaSsaPssProtoSerialization.parsePublicKey: ".concat(String.valueOf(str)));
        }
        try {
            zzhzl zzhzlVar = zzhjzVar.f33911c;
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhqo zzhqoVarG = zzhqo.G(zzhzlVar, zziab.f34621c);
            if (zzhqoVarG.C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            BigInteger bigInteger = new BigInteger(1, zzhqoVarG.E().z());
            int iBitLength = bigInteger.bitLength();
            BigInteger bigInteger2 = zzhti.f34245g;
            zzhtf zzhtfVar = new zzhtf();
            zzhhs zzhhsVar = zzhve.f34372h;
            zzhtfVar.f34232c = (zzhtg) zzhhsVar.b(zzhqoVarG.D().C());
            zzhtfVar.f34233d = (zzhtg) zzhhsVar.b(zzhqoVarG.D().D());
            zzhtfVar.f34231b = new BigInteger(1, zzhqoVarG.F().z());
            zzhtfVar.a(iBitLength);
            zzhtfVar.b(zzhqoVarG.D().E());
            zzhtfVar.f34235f = (zzhth) zzhve.f34371g.b(zzhjzVar.f33913e);
            zzhti zzhtiVarC = zzhtfVar.c();
            zzhtl zzhtlVar = new zzhtl();
            zzhtlVar.f34266a = zzhtiVarC;
            zzhtlVar.f34267b = bigInteger;
            zzhtlVar.f34268c = zzhjzVar.f33914f;
            return zzhtlVar.a();
        } catch (zzibg | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing RsaSsaPssPublicKey failed");
        }
    }
}
