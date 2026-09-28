package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgmv implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f32942a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijh f32943b;

    public zzgmv(zzijh zzijhVar, zzijh zzijhVar2) {
        this.f32942a = zzijhVar;
        this.f32943b = zzijhVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzgmu((Context) this.f32942a.f34899a, (ExecutorService) this.f32943b.f34899a);
    }
}
