package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzekh implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f29536a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f29537b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f29538c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f29539d;

    /* renamed from: e, reason: collision with root package name */
    public final zzdab f29540e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f29541f;

    /* renamed from: g, reason: collision with root package name */
    public final zzijf f29542g;

    public zzekh(zzijh zzijhVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzdab zzdabVar, zzijf zzijfVar4, zzijf zzijfVar5) {
        this.f29536a = zzijhVar;
        this.f29537b = zzijfVar;
        this.f29538c = zzijfVar2;
        this.f29539d = zzijfVar3;
        this.f29540e = zzdabVar;
        this.f29541f = zzijfVar4;
        this.f29542g = zzijfVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzekg zzb() {
        return new zzekg((zzcuh) this.f29536a.f34899a, (Context) this.f29537b.zzb(), (Executor) this.f29538c.zzb(), (zzdua) this.f29539d.zzb(), this.f29540e.a(), (zzgpr) this.f29541f.zzb(), (zzdwy) this.f29542g.zzb());
    }
}
