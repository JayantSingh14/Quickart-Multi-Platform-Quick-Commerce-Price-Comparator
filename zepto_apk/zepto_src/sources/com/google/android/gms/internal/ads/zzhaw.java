package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhaw implements zzhjr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhaw f33437a = new zzhaw();

    @Override // com.google.android.gms.internal.ads.zzhjr
    public final Object a(zzgzx zzgzxVar) throws GeneralSecurityException {
        zzhep zzhepVar = (zzhep) zzgzxVar;
        zzhhv zzhhvVar = zzhbd.f33444a;
        try {
            zzhfu.a();
            return new zzhgp(zzhepVar.f33671b.f34463a.b(), zzhepVar.f33672c.b(), zzhfu.a().getProvider());
        } catch (GeneralSecurityException unused) {
            return new zzhxb(zzhepVar.f33671b.f34463a.b(), zzhepVar.f33672c.b());
        }
    }
}
