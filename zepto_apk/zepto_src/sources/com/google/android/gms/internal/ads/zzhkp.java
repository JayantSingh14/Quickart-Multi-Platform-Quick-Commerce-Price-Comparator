package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhkp implements zzhjr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhkp f33941a = new zzhkp();

    @Override // com.google.android.gms.internal.ads.zzhjr
    public final Object a(zzgzx zzgzxVar) throws GeneralSecurityException {
        zzhkn zzhknVar = (zzhkn) zzgzxVar;
        zzhhz zzhhzVar = zzhkr.f33943a;
        if (zzhknVar.f33936a.f33955a == 32) {
            return new zzhws(zzhknVar);
        }
        throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
    }
}
