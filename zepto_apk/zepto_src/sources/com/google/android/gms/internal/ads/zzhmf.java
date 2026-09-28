package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhmf implements zzhjh {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhmf f34024a = new zzhmf();

    @Override // com.google.android.gms.internal.ads.zzhjh
    public final zzhan a(zzhka zzhkaVar) throws GeneralSecurityException {
        zzhhs zzhhsVar = zzhmj.f34028a;
        zzhpd zzhpdVar = zzhkaVar.f33917b;
        if (!zzhpdVar.C().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzhpdVar.C())));
        }
        try {
            zzhzl zzhzlVarD = zzhpdVar.D();
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhov zzhovVarF = zzhov.F(zzhzlVarD, zziab.f34621c);
            if (zzhovVarF.E() != 0) {
                int iE = zzhovVarF.E();
                throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iE).length() + 47), iE, "Parsing HmacParameters failed: unknown Version "));
            }
            zzhlf zzhlfVar = new zzhlf();
            zzhlfVar.a(zzhovVarF.D());
            zzhlfVar.b(zzhovVarF.C().D());
            zzhlfVar.f33979c = (zzhlg) zzhmj.f34029b.b(zzhovVarF.C().C());
            zzhlfVar.f33980d = (zzhlh) zzhmj.f34028a.b(zzhpdVar.E());
            return zzhlfVar.c();
        } catch (zzibg e2) {
            throw new GeneralSecurityException("Parsing HmacParameters failed: ", e2);
        }
    }
}
