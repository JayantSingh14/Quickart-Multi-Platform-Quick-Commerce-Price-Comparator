package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzglu implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32875a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32876b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32877c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijh f32878d;

    public zzglu(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijh zzijhVar) {
        this.f32875a = zzijfVar;
        this.f32876b = zzijfVar2;
        this.f32877c = zzijfVar3;
        this.f32878d = zzijhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzija zzijaVarB = zzijf.b(this.f32875a);
        zzgnc zzgncVar = (zzgnc) this.f32876b.zzb();
        return new zzglt(zzijaVarB, zzgncVar, ((zzgad) this.f32878d.f34899a).O().D());
    }
}
