package com.google.android.gms.internal.atv_ads_framework;

/* loaded from: classes4.dex */
final class zzes implements zzey {

    /* renamed from: a, reason: collision with root package name */
    public final zzeo f36166a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfp f36167b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f36168c;

    /* renamed from: d, reason: collision with root package name */
    public final zzcy f36169d;

    public zzes(zzfp zzfpVar, zzcy zzcyVar, zzeo zzeoVar) {
        this.f36167b = zzfpVar;
        this.f36168c = zzcyVar.c(zzeoVar);
        this.f36169d = zzcyVar;
        this.f36166a = zzeoVar;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzey
    public final void a(Object obj) {
        this.f36167b.e(obj);
        this.f36169d.b(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzey
    public final void b(Object obj, zzgg zzggVar) {
        this.f36169d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzey
    public final int c(zzdh zzdhVar) {
        this.f36167b.c(zzdhVar).getClass();
        if (!this.f36168c) {
            return 506991;
        }
        this.f36169d.a(zzdhVar);
        throw null;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzey
    public final int d(zzdh zzdhVar) {
        zzfp zzfpVar = this.f36167b;
        int iB = zzfpVar.b(zzfpVar.c(zzdhVar));
        if (!this.f36168c) {
            return iB;
        }
        this.f36169d.a(zzdhVar);
        throw null;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzey
    public final void e(Object obj, Object obj2) {
        Class cls = zzfa.f36181a;
        zzfp zzfpVar = this.f36167b;
        zzfpVar.f(obj, zzfpVar.d(zzfpVar.c(obj), zzfpVar.c(obj2)));
        if (this.f36168c) {
            this.f36169d.a(obj2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzey
    public final boolean f(zzdh zzdhVar, zzdh zzdhVar2) {
        zzfp zzfpVar = this.f36167b;
        if (!zzfpVar.c(zzdhVar).equals(zzfpVar.c(zzdhVar2))) {
            return false;
        }
        if (!this.f36168c) {
            return true;
        }
        this.f36169d.a(zzdhVar);
        throw null;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzey
    public final boolean g(Object obj) {
        this.f36169d.a(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzey
    public final Object zzc() {
        zzeo zzeoVar = this.f36166a;
        return zzeoVar instanceof zzdh ? (zzdh) ((zzdh) zzeoVar).d(4) : zzeoVar.zzs().c();
    }
}
