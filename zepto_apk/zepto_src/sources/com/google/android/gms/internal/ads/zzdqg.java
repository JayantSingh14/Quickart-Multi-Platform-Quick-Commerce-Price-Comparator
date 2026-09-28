package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzdqg implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzdqv f28247a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdra f28248b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f28249c;

    public zzdqg(zzdqv zzdqvVar, zzdra zzdraVar, zzijf zzijfVar) {
        this.f28247a = zzdqvVar;
        this.f28248b = zzdraVar;
        this.f28249c = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzdqf zzb() {
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        zzdqu zzdquVarZzb = this.f28247a.zzb();
        zzdra zzdraVar = this.f28248b;
        zzijo.a(zzgywVar);
        return new zzdqf(zzgywVar, zzdquVarZzb, new zzdqz(zzgywVar, zzdraVar.f28311a.zzb(), (zzdwy) zzdraVar.f28312b.zzb()), (zzdwy) this.f28249c.zzb());
    }
}
