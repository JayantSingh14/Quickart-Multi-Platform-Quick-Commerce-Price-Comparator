package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzgkj implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32788a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32789b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijh f32790c;

    public zzgkj(zzijf zzijfVar, zzijf zzijfVar2, zzijh zzijhVar) {
        this.f32788a = zzijfVar;
        this.f32789b = zzijfVar2;
        this.f32790c = zzijhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzija zzijaVarB = zzijf.b(this.f32788a);
        zzija zzijaVarB2 = zzijf.b(this.f32789b);
        if (true == ((zzgad) this.f32790c.f34899a).Y()) {
            zzijaVarB = zzijaVarB2;
        }
        zzgjw zzgjwVar = (zzgjw) zzijaVarB.zzb();
        zzijo.a(zzgjwVar);
        return zzgjwVar;
    }
}
