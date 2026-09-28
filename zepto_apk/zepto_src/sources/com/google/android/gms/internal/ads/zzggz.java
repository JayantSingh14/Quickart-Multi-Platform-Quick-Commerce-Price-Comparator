package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzggz implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32564a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32565b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32566c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijh f32567d;

    public zzggz(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijh zzijhVar) {
        this.f32564a = zzijfVar;
        this.f32565b = zzijfVar2;
        this.f32566c = zzijfVar3;
        this.f32567d = zzijhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzija zzijaVarB = zzijf.b(this.f32564a);
        zzija zzijaVarB2 = zzijf.b(this.f32565b);
        zzija zzijaVarB3 = zzijf.b(this.f32566c);
        zzgad zzgadVar = (zzgad) this.f32567d.f34899a;
        return new zzggy(zzijaVarB, zzijaVarB2, zzijaVarB3, zzgadVar.O().C(), zzgadVar.O().F());
    }
}
