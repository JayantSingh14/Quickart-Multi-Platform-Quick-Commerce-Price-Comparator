package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzghw implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f32619a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32620b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32621c;

    public zzghw(zzijf zzijfVar, zzijf zzijfVar2, zzijh zzijhVar) {
        this.f32619a = zzijhVar;
        this.f32620b = zzijfVar;
        this.f32621c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context context = (Context) this.f32619a.f34899a;
        return new zzgib(context, context.getSharedPreferences("pcvmspf2", 0), zzijf.b(this.f32620b), (zzgnc) this.f32621c.zzb());
    }
}
