package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzeku implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f29578a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f29579b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijh f29580c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f29581d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f29582e;

    public zzeku(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4, zzijh zzijhVar) {
        this.f29578a = zzijfVar;
        this.f29579b = zzijfVar2;
        this.f29580c = zzijhVar;
        this.f29581d = zzijfVar3;
        this.f29582e = zzijfVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzekt((Context) this.f29578a.zzb(), (Executor) this.f29579b.zzb(), (zzdkz) this.f29580c.f34899a, (zzfhq) this.f29581d.zzb(), (zzdxe) this.f29582e.zzb());
    }
}
