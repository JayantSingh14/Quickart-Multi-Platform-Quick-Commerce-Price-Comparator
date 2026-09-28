package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgmz implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f32954a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f32955b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijh f32956c;

    public zzgmz(zzijf zzijfVar, zzijh zzijhVar, zzijh zzijhVar2) {
        this.f32954a = zzijhVar;
        this.f32955b = zzijfVar;
        this.f32956c = zzijhVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context context = (Context) this.f32954a.f34899a;
        return new zzgmy(context, (ExecutorService) this.f32956c.f34899a, zzgmy.f32946h);
    }
}
