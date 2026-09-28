package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhax implements zzhjr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhax f33438a = new zzhax();

    @Override // com.google.android.gms.internal.ads.zzhjr
    public final Object a(zzgzx zzgzxVar) throws GeneralSecurityException {
        zzhcu zzhcuVar = (zzhcu) zzgzxVar;
        zzhhv zzhhvVar = zzhbd.f33444a;
        try {
            zzhfu.a();
            return new zzhfu(zzhcuVar.f33561b.f34463a.b(), zzhcuVar.f33562c.b(), zzhfu.a().getProvider());
        } catch (GeneralSecurityException unused) {
            return new zzhvq(zzhcuVar.f33561b.f34463a.b(), zzhcuVar.f33562c.b());
        }
    }
}
