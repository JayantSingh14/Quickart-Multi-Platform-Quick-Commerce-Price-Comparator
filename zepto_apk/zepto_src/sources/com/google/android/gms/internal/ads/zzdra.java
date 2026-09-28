package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzdra implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzdqv f28311a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f28312b;

    public zzdra(zzdqv zzdqvVar, zzijf zzijfVar) {
        this.f28311a = zzdqvVar;
        this.f28312b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzdqz(zzgywVar, this.f28311a.zzb(), (zzdwy) this.f28312b.zzb());
    }
}
