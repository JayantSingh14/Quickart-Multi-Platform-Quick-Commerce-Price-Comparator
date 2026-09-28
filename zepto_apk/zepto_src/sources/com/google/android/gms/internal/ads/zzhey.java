package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhey implements zzhic {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhey f33688a = new zzhey();

    @Override // com.google.android.gms.internal.ads.zzhic
    public final zzgzx a(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhfa.f33696a;
        if (!zzhjzVar.f33909a.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
        try {
            zzhzl zzhzlVar = zzhjzVar.f33911c;
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhna zzhnaVarF = zzhna.F(zzhzlVar, zziab.f34621c);
            if (zzhnaVarF.C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (zzhnaVarF.D().C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
            }
            if (zzhnaVarF.E().C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
            }
            zzhbq zzhbqVar = new zzhbq();
            zzhbqVar.a(zzhnaVarF.D().E().i());
            zzhbqVar.b(zzhnaVarF.E().E().i());
            zzhbqVar.c(zzhnaVarF.D().D().C());
            zzhbqVar.d(zzhnaVarF.E().D().D());
            zzhbqVar.f33471e = zzhfa.c(zzhnaVarF.E().D().C());
            zzhbqVar.f33472f = zzhfa.b(zzhjzVar.f33913e);
            zzhbt zzhbtVarE = zzhbqVar.e();
            zzhbk zzhbkVar = new zzhbk();
            zzhbkVar.f33450a = zzhbtVarE;
            zzhbkVar.f33451b = zzhxe.a(zzhnaVarF.D().E().z());
            zzhbkVar.f33452c = zzhxe.a(zzhnaVarF.E().E().z());
            zzhbkVar.f33453d = zzhjzVar.f33914f;
            return zzhbkVar.a();
        } catch (zzibg unused) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
        }
    }
}
