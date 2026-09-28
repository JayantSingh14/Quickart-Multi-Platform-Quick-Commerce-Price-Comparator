package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzgmf implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f32903a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32904b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijh f32905c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f32906d;

    public zzgmf(zzijf zzijfVar, zzijf zzijfVar2, zzijh zzijhVar, zzijh zzijhVar2) {
        this.f32903a = zzijhVar;
        this.f32904b = zzijfVar;
        this.f32905c = zzijhVar2;
        this.f32906d = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzgme((Context) this.f32903a.f34899a, (zzgad) this.f32905c.f34899a, (zzgnc) this.f32904b.zzb(), (zzgyw) this.f32906d.zzb());
    }
}
