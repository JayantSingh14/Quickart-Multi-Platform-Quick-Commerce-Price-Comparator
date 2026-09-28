package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgce implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijs f32250a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijs f32251b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijh f32252c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f32253d;

    public zzgce(zzijs zzijsVar, zzijs zzijsVar2, zzijh zzijhVar, zzijf zzijfVar) {
        this.f32250a = zzijsVar;
        this.f32251b = zzijsVar2;
        this.f32252c = zzijhVar;
        this.f32253d = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzgcd(zzijf.b(this.f32250a), zzijf.b(this.f32251b), (ExecutorService) this.f32252c.f34899a, zzijf.b(this.f32253d));
    }
}
