package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhlm implements zzhjr {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhlm f33996a = new zzhlm();

    @Override // com.google.android.gms.internal.ads.zzhjr
    public final Object a(zzgzx zzgzxVar) throws GeneralSecurityException {
        zzhim zzhimVar = (zzhim) zzgzxVar;
        zzhjz zzhjzVar = zzhimVar.f33862a;
        zzhim.d(zzhjzVar);
        int iOrdinal = zzhjzVar.f33913e.ordinal();
        zzhjz zzhjzVar2 = zzhimVar.f33862a;
        if (iOrdinal == 1) {
            zzhjf.b(zzhjzVar2.f33914f.intValue()).b();
        } else if (iOrdinal == 2) {
            zzhjf.a(zzhjzVar2.f33914f.intValue()).b();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            zzhjf.a(zzhjzVar2.f33914f.intValue()).b();
        } else {
            zzhjf.f33886a.b();
        }
        return new zzhmk();
    }
}
