package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzgbk implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32220a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32221b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijh f32222c;

    public zzgbk(zzijf zzijfVar, zzijf zzijfVar2, zzijh zzijhVar) {
        this.f32220a = zzijfVar;
        this.f32221b = zzijfVar2;
        this.f32222c = zzijhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzgbj zzgbjVar = ((zzgad) this.f32222c.f34899a).Z() ? (zzgbj) zzijf.b(this.f32220a).zzb() : (zzgbj) zzijf.b(this.f32221b).zzb();
        zzijo.a(zzgbjVar);
        return zzgbjVar;
    }
}
