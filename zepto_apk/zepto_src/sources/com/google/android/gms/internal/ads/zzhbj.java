package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhbj implements zzhjy {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhbj f33448a = new zzhbj();

    /* renamed from: b, reason: collision with root package name */
    public static final zzhjs f33449b = new zzhjq(zzhim.class, zzgzq.class, zzhbh.f33446a);

    @Override // com.google.android.gms.internal.ads.zzhjy
    public final Object a(zzhai zzhaiVar, zzhip zzhipVar, zzhjx zzhjxVar) throws GeneralSecurityException {
        zzhxc zzhxcVarC;
        zzhjn zzhjnVar = new zzhjn();
        for (int i2 = 0; i2 < zzhaiVar.f33432a.size(); i2++) {
            zzhag zzhagVarD = zzhaiVar.d(i2);
            if (zzhagVarD.f33426b.equals(zzgzz.f33407b)) {
                zzgzx zzgzxVarA = zzhagVarD.a();
                if (zzgzxVarA instanceof zzhbe) {
                    zzhxcVarC = ((zzhbe) zzgzxVarA).c();
                } else {
                    if (!(zzgzxVarA instanceof zzhim)) {
                        String name = zzgzxVarA.getClass().getName();
                        String strValueOf = String.valueOf(zzgzxVarA.a());
                        throw new GeneralSecurityException(android.support.v4.media.a.n(new StringBuilder(name.length() + 59 + strValueOf.length()), "Cannot get output prefix for key of class ", name, " with parameters ", strValueOf));
                    }
                    zzhxcVarC = ((zzhim) zzgzxVarA).c();
                }
                zzhjnVar.a(zzhxcVarC, new zzhbg((zzgzq) ((zzhjv) zzhjxVar).a(zzhagVarD), zzhagVarD.f33427c));
            }
        }
        if (!zzhipVar.f33866a.isEmpty()) {
            zzhiz.f33874b.a().getClass();
        }
        zzhaiVar.c();
        return new zzhbi(new zzhjp(zzhjnVar.f33893a));
    }

    @Override // com.google.android.gms.internal.ads.zzhjy
    public final Class zza() {
        return zzgzq.class;
    }

    @Override // com.google.android.gms.internal.ads.zzhjy
    public final Class zzb() {
        return zzgzq.class;
    }
}
