package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhrj implements zzhjr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhrj f34110a = new zzhrj();

    @Override // com.google.android.gms.internal.ads.zzhjr
    public final Object a(zzgzx zzgzxVar) throws GeneralSecurityException {
        zzhrg zzhrgVar = (zzhrg) zzgzxVar;
        Provider providerA = zzhhf.a();
        zzhwl zzhwlVar = (zzhwl) zzhud.f34296i.a(zzhrgVar.f34101a.f34106a.f34097c);
        zzhhs zzhhsVar = zzhud.f34297j;
        zzhri zzhriVar = zzhrgVar.f34101a;
        zzhhs zzhhsVar2 = zzhud.f34298k;
        zzhre zzhreVar = zzhriVar.f34106a;
        zzhriVar.f34108c.b();
        zzhreVar.f34098d.getClass();
        zzhuc zzhucVar = new zzhuc();
        if (!zzhhb.a(2)) {
            throw new GeneralSecurityException("Can not use ECDSA in FIPS-mode, as BoringCrypto is not available.");
        }
        zzhxa.b(zzhwlVar);
        zzhwlVar.toString().concat("withECDSA");
        return zzhucVar;
    }
}
