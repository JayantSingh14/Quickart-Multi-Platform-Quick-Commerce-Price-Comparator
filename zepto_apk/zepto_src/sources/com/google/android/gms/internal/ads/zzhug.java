package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhug implements zzhic {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhug f34307a = new zzhug();

    @Override // com.google.android.gms.internal.ads.zzhic
    public final zzgzx a(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhuk.f34311a;
        String str = zzhjzVar.f33909a;
        if (!str.equals("type.googleapis.com/google.crypto.tink.Ed25519PublicKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to Ed25519ProtoSerialization.parsePublicKey: ".concat(String.valueOf(str)));
        }
        try {
            zzhzl zzhzlVar = zzhjzVar.f33911c;
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhop zzhopVarE = zzhop.E(zzhzlVar, zziab.f34621c);
            if (zzhopVarE.C() == 0) {
                return zzhrv.d((zzhrn) zzhuk.f34317g.b(zzhjzVar.f33913e), zzhxc.a(zzhopVarE.D().z()), zzhjzVar.f33914f);
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzibg unused) {
            throw new GeneralSecurityException("Parsing Ed25519PublicKey failed");
        }
    }
}
