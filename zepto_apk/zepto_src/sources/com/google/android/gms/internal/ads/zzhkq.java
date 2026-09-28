package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhkq implements zzhhz {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhkq f33942a = new zzhkq();

    @Override // com.google.android.gms.internal.ads.zzhhz
    public final zzgzx a(zzhan zzhanVar, Integer num) throws GeneralSecurityException {
        zzhku zzhkuVar = (zzhku) zzhanVar;
        zzhhz zzhhzVar = zzhkr.f33943a;
        int i2 = zzhkuVar.f33955a;
        if (i2 != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
        zzhkm zzhkmVar = new zzhkm();
        zzhkmVar.f33933a = zzhkuVar;
        zzhkmVar.f33934b = zzhxe.b(i2);
        zzhkmVar.f33935c = num;
        return zzhkmVar.a();
    }
}
