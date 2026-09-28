package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhfk implements zzhic {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhfk f33711a = new zzhfk();

    @Override // com.google.android.gms.internal.ads.zzhic
    public final zzgzx a(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhfm.f33713a;
        if (!zzhjzVar.f33909a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
        try {
            zzhzl zzhzlVar = zzhjzVar.f33911c;
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhnq zzhnqVarE = zzhnq.E(zzhzlVar, zziab.f34621c);
            if (zzhnqVarE.C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhci zzhciVar = new zzhci();
            zzhciVar.a(zzhnqVarE.D().i());
            zzhciVar.b();
            zzhciVar.c();
            zzhciVar.f33531d = zzhfm.b(zzhjzVar.f33913e);
            zzhck zzhckVarD = zzhciVar.d();
            zzhcc zzhccVar = new zzhcc();
            zzhccVar.f33513a = zzhckVarD;
            zzhccVar.f33514b = zzhxe.a(zzhnqVarE.D().z());
            zzhccVar.f33515c = zzhjzVar.f33914f;
            return zzhccVar.a();
        } catch (zzibg unused) {
            throw new GeneralSecurityException("Parsing AesGcmKey failed");
        }
    }
}
