package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public class zzhij implements zzgzy {

    /* renamed from: a, reason: collision with root package name */
    public final String f33855a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f33856b;

    /* renamed from: c, reason: collision with root package name */
    public final zzhoz f33857c;

    public zzhij(String str, Class cls, zzhoz zzhozVar) {
        this.f33855a = str;
        this.f33856b = cls;
        this.f33857c = zzhozVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzy
    public final Object a(zzhzl zzhzlVar) throws GeneralSecurityException {
        zzgzx zzgzxVarE = zzhje.f33884b.e(zzhjz.a(this.f33855a, zzhzlVar, this.f33857c, zzhpw.RAW, null));
        zzhjb zzhjbVar = zzhjb.f33880b;
        return ((zzhjw) zzhjbVar.f33881a.get()).a(zzgzxVarE, this.f33856b);
    }

    @Override // com.google.android.gms.internal.ads.zzgzy
    public final zzhpa b(zzhzl zzhzlVar) throws GeneralSecurityException {
        zzhpc zzhpcVarG = zzhpd.G();
        zzhpcVarG.n(this.f33855a);
        zzhpcVarG.o(zzhzlVar);
        zzhpcVarG.p(zzhpw.RAW);
        zzhpd zzhpdVar = (zzhpd) zzhpcVarG.l();
        zzhka zzhkaVar = new zzhka(zzhpdVar, zzhkl.b(zzhpdVar.C()));
        zzhje zzhjeVar = zzhje.f33884b;
        zzhjz zzhjzVar = (zzhjz) zzhjeVar.f(zzhiv.f33870c.b(zzhjeVar.g(zzhkaVar), null));
        zzhoy zzhoyVarF = zzhpa.F();
        String str = zzhjzVar.f33909a;
        zzhoyVarF.j();
        ((zzhpa) zzhoyVarF.f34638b).H(str);
        zzhoyVarF.j();
        ((zzhpa) zzhoyVarF.f34638b).I(zzhjzVar.f33911c);
        zzhoz zzhozVar = zzhjzVar.f33912d;
        zzhoyVarF.j();
        ((zzhpa) zzhoyVarF.f34638b).J(zzhozVar);
        return (zzhpa) zzhoyVarF.l();
    }

    @Override // com.google.android.gms.internal.ads.zzgzy
    public final String zzb() {
        return this.f33855a;
    }

    @Override // com.google.android.gms.internal.ads.zzgzy
    public final Class zzc() {
        return this.f33856b;
    }
}
