package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhly implements zzhic {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhly f34009a = new zzhly();

    @Override // com.google.android.gms.internal.ads.zzhic
    public final zzgzx a(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhma.f34020a;
        if (!zzhjzVar.f33909a.equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
        try {
            zzhzl zzhzlVar = zzhjzVar.f33911c;
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhmu zzhmuVarF = zzhmu.F(zzhzlVar, zziab.f34621c);
            if (zzhmuVarF.C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhks zzhksVar = new zzhks();
            zzhksVar.a(zzhmuVarF.D().i());
            zzhksVar.b(zzhmuVarF.E().C());
            zzhksVar.f33949c = zzhma.b(zzhjzVar.f33913e);
            zzhku zzhkuVarC = zzhksVar.c();
            zzhkm zzhkmVar = new zzhkm();
            zzhkmVar.f33933a = zzhkuVarC;
            zzhkmVar.f33934b = zzhxe.a(zzhmuVarF.D().z());
            zzhkmVar.f33935c = zzhjzVar.f33914f;
            return zzhkmVar.a();
        } catch (zzibg | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing AesCmacKey failed");
        }
    }
}
