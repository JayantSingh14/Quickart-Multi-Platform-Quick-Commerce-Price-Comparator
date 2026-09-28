package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhcf implements zzhhz {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhcf f33521a = new zzhcf();

    @Override // com.google.android.gms.internal.ads.zzhhz
    public final zzgzx a(zzhan zzhanVar, Integer num) throws GeneralSecurityException {
        zzhck zzhckVar = (zzhck) zzhanVar;
        zzhjs zzhjsVar = zzhch.f33523a;
        int i2 = zzhckVar.f33536a;
        if (i2 == 24) {
            throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
        }
        zzhcc zzhccVar = new zzhcc();
        zzhccVar.f33513a = zzhckVar;
        zzhccVar.f33515c = num;
        zzhccVar.f33514b = zzhxe.b(i2);
        return zzhccVar.a();
    }
}
