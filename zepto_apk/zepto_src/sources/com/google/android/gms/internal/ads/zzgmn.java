package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgmn implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f32924a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijh f32925b;

    public zzgmn(zzijh zzijhVar, zzijh zzijhVar2) {
        this.f32924a = zzijhVar;
        this.f32925b = zzijhVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzgmm((Context) this.f32924a.f34899a, (ExecutorService) this.f32925b.f34899a);
    }
}
