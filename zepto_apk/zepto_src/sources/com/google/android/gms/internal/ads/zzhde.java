package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhde implements zzhjr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhde f33583a = new zzhde();

    @Override // com.google.android.gms.internal.ads.zzhjr
    public final Object a(zzgzx zzgzxVar) throws GeneralSecurityException {
        zzhdp zzhdpVar = (zzhdp) zzgzxVar;
        zzhij zzhijVar = zzhdg.f33585a;
        zzhdt zzhdtVar = zzhdpVar.f33604a;
        String str = zzhdtVar.f33622b;
        zzhbf zzhbfVar = zzhdtVar.f33624d;
        zzgzq zzgzqVarZzb = zzhal.a(str).zzb();
        byte[] bArr = zzhdd.f33579c;
        try {
            byte[] bArrG = ((zzhka) zzhje.f33884b.h(zzhbfVar)).f33917b.g();
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            return new zzhgh(new zzhdd(zzhpd.F(bArrG, zziab.f34621c), zzgzqVarZzb), zzhdpVar.f33605b.b());
        } catch (zzibg e2) {
            throw new GeneralSecurityException(e2);
        }
    }
}
