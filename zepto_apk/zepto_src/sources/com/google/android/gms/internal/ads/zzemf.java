package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzemf implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f29729a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdls f29730b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdac f29731c;

    /* renamed from: d, reason: collision with root package name */
    public final zzdhf f29732d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f29733e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f29734f;

    public zzemf(zzijh zzijhVar, zzdls zzdlsVar, zzdac zzdacVar, zzdhf zzdhfVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f29729a = zzijhVar;
        this.f29730b = zzdlsVar;
        this.f29731c = zzdacVar;
        this.f29732d = zzdhfVar;
        this.f29733e = zzijfVar;
        this.f29734f = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzclg zzclgVar = (zzclg) this.f29729a.f34899a;
        zzdls zzdlsVar = this.f29730b;
        zzczs zzczsVarA = this.f29731c.f27542a.a();
        zzdhf zzdhfVar = this.f29732d;
        return new zzeme(zzclgVar, zzdlsVar.f27912a, zzczsVarA, zzdhfVar.f27765a, (zzemr) this.f29733e.zzb(), (zzejl) this.f29734f.zzb());
    }
}
