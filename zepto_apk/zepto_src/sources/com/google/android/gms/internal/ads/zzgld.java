package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgld implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f32842a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijh f32843b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32844c;

    public zzgld(zzijf zzijfVar, zzijf zzijfVar2, zzijh zzijhVar) {
        this.f32842a = zzijfVar;
        this.f32843b = zzijhVar;
        this.f32844c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzglc((zzgib) this.f32842a.zzb(), (ExecutorService) this.f32843b.f34899a, (zzgnc) this.f32844c.zzb());
    }
}
