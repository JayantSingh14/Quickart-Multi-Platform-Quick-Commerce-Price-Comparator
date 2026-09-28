package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzggd implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f32530a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32531b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijh f32532c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f32533d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f32534e;

    public zzggd(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijh zzijhVar, zzijh zzijhVar2) {
        this.f32530a = zzijhVar;
        this.f32531b = zzijfVar;
        this.f32532c = zzijhVar2;
        this.f32533d = zzijfVar2;
        this.f32534e = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzggc((zzavs) this.f32530a.f34899a, (zzgev) this.f32531b.zzb(), (Map) this.f32532c.f34899a, (DisplayMetrics) this.f32533d.zzb(), (zzgnc) this.f32534e.zzb());
    }
}
