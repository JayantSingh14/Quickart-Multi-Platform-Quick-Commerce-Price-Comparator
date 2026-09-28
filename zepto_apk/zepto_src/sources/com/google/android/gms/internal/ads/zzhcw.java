package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhcw implements zzhjr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhcw f33565a = new zzhcw();

    @Override // com.google.android.gms.internal.ads.zzhjr
    public final Object a(zzgzx zzgzxVar) throws GeneralSecurityException {
        zzhcu zzhcuVar = (zzhcu) zzgzxVar;
        zzhjs zzhjsVar = zzhcx.f33566a;
        try {
            zzhfu.a();
            return new zzhfu(zzhcuVar.f33561b.f34463a.b(), zzhcuVar.f33562c.b(), zzhfu.a().getProvider());
        } catch (GeneralSecurityException unused) {
            return new zzhvq(zzhcuVar.f33561b.f34463a.b(), zzhcuVar.f33562c.b());
        }
    }
}
