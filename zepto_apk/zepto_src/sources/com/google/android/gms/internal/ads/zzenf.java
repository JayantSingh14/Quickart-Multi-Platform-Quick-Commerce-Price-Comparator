package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzenf implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f29859a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f29860b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijh f29861c;

    public zzenf(zzijf zzijfVar, zzijf zzijfVar2, zzijh zzijhVar) {
        this.f29859a = zzijfVar;
        this.f29860b = zzijfVar2;
        this.f29861c = zzijhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzene((Context) this.f29859a.zzb(), (Executor) this.f29860b.zzb(), (zzdtj) this.f29861c.f34899a);
    }
}
