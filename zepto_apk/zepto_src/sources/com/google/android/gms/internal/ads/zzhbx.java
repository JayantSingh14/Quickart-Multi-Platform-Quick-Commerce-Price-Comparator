package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhbx implements zzhhz {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhbx f33497a = new zzhbx();

    @Override // com.google.android.gms.internal.ads.zzhhz
    public final zzgzx a(zzhan zzhanVar, Integer num) throws GeneralSecurityException {
        zzhcb zzhcbVar = (zzhcb) zzhanVar;
        zzhjs zzhjsVar = zzhby.f33498a;
        int i2 = zzhcbVar.f33510a;
        if (i2 == 24) {
            throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
        }
        zzhbu zzhbuVar = new zzhbu();
        zzhbuVar.f33489a = zzhcbVar;
        zzhbuVar.f33491c = num;
        zzhbuVar.f33490b = zzhxe.b(i2);
        return zzhbuVar.a();
    }
}
