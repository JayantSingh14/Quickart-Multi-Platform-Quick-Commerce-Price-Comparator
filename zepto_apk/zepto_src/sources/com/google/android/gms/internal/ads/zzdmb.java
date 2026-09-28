package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzdmb implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f27923a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdac f27924b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdhf f27925c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdls f27926d;

    /* renamed from: e, reason: collision with root package name */
    public final zzctb f27927e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f27928f;

    public zzdmb(zzijh zzijhVar, zzdac zzdacVar, zzdhf zzdhfVar, zzdls zzdlsVar, zzctb zzctbVar, zzijf zzijfVar) {
        this.f27923a = zzijhVar;
        this.f27924b = zzdacVar;
        this.f27925c = zzdhfVar;
        this.f27926d = zzdlsVar;
        this.f27927e = zzctbVar;
        this.f27928f = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzclg zzclgVar = (zzclg) this.f27923a.f34899a;
        zzczs zzczsVarA = this.f27924b.f27542a.a();
        zzdhf zzdhfVar = this.f27925c;
        zzdls zzdlsVar = this.f27926d;
        zzddl zzddlVarZzb = this.f27927e.zzb();
        zzemr zzemrVar = (zzemr) this.f27928f.zzb();
        zzcug zzcugVarL = zzclgVar.l();
        ((zzcnc) zzcugVarL).f26641e = new zzczt(zzczsVarA);
        zzcnc zzcncVar = (zzcnc) zzcugVarL;
        zzcncVar.f26640d = zzdhfVar.f27765a;
        zzcncVar.f26646j = zzdlsVar.f27912a;
        zzcncVar.f26642f = new zzeow(null);
        zzcncVar.f26643g = new zzcvc(zzddlVarZzb, null);
        zzcncVar.f26645i = new zzcsz(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.n4)).booleanValue()) {
            zzena zzenaVar = new zzena();
            zzenaVar.f29848a = zzemrVar;
            zzcncVar.f26644h = zzenaVar;
        }
        zzcvn zzcvnVar = (zzcvn) ((zzcnd) zzcncVar.zzh()).D0.zzb();
        zzijo.a(zzcvnVar);
        return zzcvnVar;
    }
}
