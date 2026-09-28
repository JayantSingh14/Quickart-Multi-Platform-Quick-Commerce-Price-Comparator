package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzekl implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f29550a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijh f29551b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f29552c;

    public zzekl(zzijf zzijfVar, zzijf zzijfVar2, zzijh zzijhVar) {
        this.f29550a = zzijfVar;
        this.f29551b = zzijhVar;
        this.f29552c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzekk((Context) this.f29550a.zzb(), (zzcuh) this.f29551b.f34899a, (Executor) this.f29552c.zzb());
    }
}
