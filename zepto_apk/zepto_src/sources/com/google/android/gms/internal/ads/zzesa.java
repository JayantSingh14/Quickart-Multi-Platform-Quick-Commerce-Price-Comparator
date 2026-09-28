package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzesa implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzdab f30203a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30204b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f30205c;

    public zzesa(zzdab zzdabVar, zzijf zzijfVar, zzijf zzijfVar2) {
        this.f30203a = zzdabVar;
        this.f30204b = zzijfVar;
        this.f30205c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzery zzb() {
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        zzfik zzfikVarA = this.f30203a.a();
        return new zzery(zzgywVar, zzfikVarA, ((Integer) this.f30205c.zzb()).intValue());
    }
}
