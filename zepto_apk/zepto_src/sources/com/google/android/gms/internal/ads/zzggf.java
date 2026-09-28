package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;

/* loaded from: classes4.dex */
public final class zzggf implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f32537a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32538b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f32539c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijh f32540d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f32541e;

    public zzggf(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijh zzijhVar, zzijh zzijhVar2) {
        this.f32537a = zzijhVar;
        this.f32538b = zzijfVar;
        this.f32539c = zzijfVar2;
        this.f32540d = zzijhVar2;
        this.f32541e = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzgge((zzavs) this.f32537a.f34899a, (zzgev) this.f32538b.zzb(), (DisplayMetrics) this.f32539c.zzb(), (View) this.f32540d.f34899a, (zzgnc) this.f32541e.zzb());
    }
}
