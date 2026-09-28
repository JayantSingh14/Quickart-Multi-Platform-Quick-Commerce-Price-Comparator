package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhim extends zzgzx {

    /* renamed from: a, reason: collision with root package name */
    public final zzhjz f33862a;

    public zzhim(zzhjz zzhjzVar) {
        d(zzhjzVar);
        this.f33862a = zzhjzVar;
    }

    public static void d(zzhjz zzhjzVar) {
        int i2 = zzhik.f33859b[zzhjzVar.f33912d.ordinal()];
    }

    @Override // com.google.android.gms.internal.ads.zzgzx
    public final zzhan a() {
        zzhjz zzhjzVar = this.f33862a;
        return new zzhil(zzhjzVar.f33909a, zzhjzVar.f33913e);
    }

    @Override // com.google.android.gms.internal.ads.zzgzx
    public final Integer b() {
        return this.f33862a.f33914f;
    }

    public final zzhxc c() throws GeneralSecurityException {
        zzhjz zzhjzVar = this.f33862a;
        if (zzhjzVar.f33913e.equals(zzhpw.RAW)) {
            return zzhxc.a(new byte[0]);
        }
        zzhpw zzhpwVar = zzhpw.TINK;
        zzhpw zzhpwVar2 = zzhjzVar.f33913e;
        boolean zEquals = zzhpwVar2.equals(zzhpwVar);
        Integer num = zzhjzVar.f33914f;
        if (zEquals) {
            return zzhjf.b(num.intValue());
        }
        if (zzhpwVar2.equals(zzhpw.LEGACY) || zzhpwVar2.equals(zzhpw.CRUNCHY)) {
            return zzhjf.a(num.intValue());
        }
        throw new GeneralSecurityException("Unknown output prefix type");
    }
}
