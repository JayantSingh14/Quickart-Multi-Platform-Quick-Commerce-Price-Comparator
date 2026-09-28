package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhmh implements zzhic {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhmh f34026a = new zzhmh();

    @Override // com.google.android.gms.internal.ads.zzhic
    public final zzgzx a(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhhs zzhhsVar = zzhmj.f34028a;
        if (!zzhjzVar.f33909a.equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
        try {
            zzhzl zzhzlVar = zzhjzVar.f33911c;
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhot zzhotVarF = zzhot.F(zzhzlVar, zziab.f34621c);
            if (zzhotVarF.C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhlf zzhlfVar = new zzhlf();
            zzhlfVar.a(zzhotVarF.E().i());
            zzhlfVar.b(zzhotVarF.D().D());
            zzhlfVar.f33979c = (zzhlg) zzhmj.f34029b.b(zzhotVarF.D().C());
            zzhlfVar.f33980d = (zzhlh) zzhmj.f34028a.b(zzhjzVar.f33913e);
            zzhli zzhliVarC = zzhlfVar.c();
            zzhky zzhkyVar = new zzhky();
            zzhkyVar.f33959a = zzhliVarC;
            zzhkyVar.f33960b = zzhxe.a(zzhotVarF.E().z());
            zzhkyVar.f33961c = zzhjzVar.f33914f;
            return zzhkyVar.a();
        } catch (zzibg | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }
}
