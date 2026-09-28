package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhuy implements zzhjh {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhuy f34357a = new zzhuy();

    @Override // com.google.android.gms.internal.ads.zzhjh
    public final zzhan a(zzhka zzhkaVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhve.f34365a;
        zzhpd zzhpdVar = zzhkaVar.f33917b;
        if (!zzhpdVar.C().equals("type.googleapis.com/google.crypto.tink.RsaSsaPssPrivateKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to RsaSsaPssProtoSerialization.parseParameters: ".concat(String.valueOf(zzhpdVar.C())));
        }
        try {
            zzhzl zzhzlVarD = zzhpdVar.D();
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhqi zzhqiVarF = zzhqi.F(zzhzlVarD, zziab.f34621c);
            BigInteger bigInteger = zzhti.f34245g;
            zzhtf zzhtfVar = new zzhtf();
            zzhor zzhorVarC = zzhqiVarF.C().C();
            zzhhs zzhhsVar = zzhve.f34372h;
            zzhtfVar.f34232c = (zzhtg) zzhhsVar.b(zzhorVarC);
            zzhtfVar.f34233d = (zzhtg) zzhhsVar.b(zzhqiVarF.C().D());
            zzhtfVar.f34231b = new BigInteger(1, zzhqiVarF.E().z());
            zzhtfVar.a(zzhqiVarF.D());
            zzhtfVar.b(zzhqiVarF.C().E());
            zzhtfVar.f34235f = (zzhth) zzhve.f34371g.b(zzhpdVar.E());
            return zzhtfVar.c();
        } catch (zzibg e2) {
            throw new GeneralSecurityException("Parsing RsaSsaPssParameters failed: ", e2);
        }
    }
}
