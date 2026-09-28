package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhgs implements zzhic {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhgs f33772a = new zzhgs();

    @Override // com.google.android.gms.internal.ads.zzhic
    public final zzgzx a(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhgu.f33774a;
        if (!zzhjzVar.f33909a.equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzhzl zzhzlVar = zzhjzVar.f33911c;
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhqw zzhqwVarE = zzhqw.E(zzhzlVar, zziab.f34621c);
            if (zzhqwVarE.C() == 0) {
                return zzhep.d(zzhgu.b(zzhjzVar.f33913e), zzhxe.a(zzhqwVarE.D().z()), zzhjzVar.f33914f);
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzibg unused) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
        }
    }
}
