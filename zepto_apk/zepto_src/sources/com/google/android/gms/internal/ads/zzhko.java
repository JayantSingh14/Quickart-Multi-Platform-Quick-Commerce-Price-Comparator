package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhko implements zzhjr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhko f33940a = new zzhko();

    @Override // com.google.android.gms.internal.ads.zzhjr
    public final Object a(zzgzx zzgzxVar) throws GeneralSecurityException {
        zzhkn zzhknVar = (zzhkn) zzgzxVar;
        zzhhz zzhhzVar = zzhkr.f33943a;
        if (zzhknVar.f33936a.f33955a != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
        }
        Provider providerA = zzhhf.a();
        if (providerA != null) {
            try {
                return zzhmc.a(zzhknVar, providerA);
            } catch (GeneralSecurityException unused) {
            }
        }
        return new zzhmd();
    }
}
