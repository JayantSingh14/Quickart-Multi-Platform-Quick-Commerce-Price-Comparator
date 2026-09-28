package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhrs implements zzhjr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhrs f34129a = new zzhrs();

    @Override // com.google.android.gms.internal.ads.zzhjr
    public final Object a(zzgzx zzgzxVar) throws GeneralSecurityException {
        zzhrp zzhrpVar = (zzhrp) zzgzxVar;
        if (!zzhhb.a(1)) {
            throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
        }
        try {
            return zzhul.a(zzhrpVar);
        } catch (GeneralSecurityException unused) {
            byte[] bArrB = zzhrpVar.f34126b.f34463a.b();
            zzhrv zzhrvVar = zzhrpVar.f34125a;
            zzhrvVar.f34139c.b();
            zzhrvVar.f34137a.f34124a.getClass();
            zzhvs zzhvsVar = new zzhvs();
            if (!zzhhb.a(1)) {
                throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
            }
            if (bArrB.length != 32) {
                throw new IllegalArgumentException("Given private key's length is not 32");
            }
            zzhhm.a(zzhhm.b(bArrB));
            return zzhvsVar;
        }
    }
}
