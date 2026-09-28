package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhrt implements zzhjr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhrt f34130a = new zzhrt();

    @Override // com.google.android.gms.internal.ads.zzhjr
    public final Object a(zzgzx zzgzxVar) throws GeneralSecurityException {
        zzhrv zzhrvVar = (zzhrv) zzgzxVar;
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
        }
        try {
            return zzhum.a(zzhrvVar);
        } catch (GeneralSecurityException unused) {
            return new zzhvt(zzhrvVar.f34138b.b(), zzhrvVar.f34139c.b(), zzhrvVar.f34137a.f34124a.equals(zzhrn.f34121d) ? new byte[]{0} : new byte[0]);
        }
    }
}
