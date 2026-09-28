package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhbh implements zzhjr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhbh f33446a = new zzhbh();

    @Override // com.google.android.gms.internal.ads.zzhjr
    public final Object a(zzgzx zzgzxVar) throws GeneralSecurityException {
        byte[] bArrB;
        zzhim zzhimVar = (zzhim) zzgzxVar;
        zzhjz zzhjzVar = zzhimVar.f33862a;
        zzhim.d(zzhjzVar);
        zzgzq zzgzqVar = (zzgzq) zzhia.f33848d.b(zzgzq.class, zzhjzVar.f33909a).a(zzhjzVar.f33911c);
        zzhpw zzhpwVar = zzhjzVar.f33913e;
        int iOrdinal = zzhpwVar.ordinal();
        zzhjz zzhjzVar2 = zzhimVar.f33862a;
        if (iOrdinal == 1) {
            bArrB = zzhjf.b(zzhjzVar2.f33914f.intValue()).b();
        } else if (iOrdinal == 2) {
            bArrB = zzhjf.a(zzhjzVar2.f33914f.intValue()).b();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type ".concat(String.valueOf(zzhpwVar)));
            }
            bArrB = zzhjf.a(zzhjzVar2.f33914f.intValue()).b();
        } else {
            bArrB = zzhjf.f33886a.b();
        }
        return new zzhgh(zzgzqVar, bArrB);
    }
}
