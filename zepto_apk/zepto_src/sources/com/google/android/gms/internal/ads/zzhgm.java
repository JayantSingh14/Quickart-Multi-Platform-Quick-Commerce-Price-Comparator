package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhgm implements zzhic {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhgm f33761a = new zzhgm();

    @Override // com.google.android.gms.internal.ads.zzhic
    public final zzgzx a(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhgo.f33763a;
        if (!zzhjzVar.f33909a.equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to XAesGcmProtoSerialization.parseKey");
        }
        try {
            zzhzl zzhzlVar = zzhjzVar.f33911c;
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhqq zzhqqVarF = zzhqq.F(zzhzlVar, zziab.f34621c);
            if (zzhqqVarF.C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (zzhqqVarF.E().i() == 32) {
                return zzhej.d(zzheo.b(zzhgo.b(zzhjzVar.f33913e), zzhqqVarF.D().C()), zzhxe.a(zzhqqVarF.E().z()), zzhjzVar.f33914f);
            }
            throw new GeneralSecurityException("Only 32 byte key size is accepted");
        } catch (zzibg unused) {
            throw new GeneralSecurityException("Parsing XAesGcmKey failed");
        }
    }
}
