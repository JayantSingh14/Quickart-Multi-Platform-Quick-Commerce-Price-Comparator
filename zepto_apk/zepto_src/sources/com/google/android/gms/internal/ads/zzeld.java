package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzeld implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f29619a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcmg f29620b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdab f29621c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f29622d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijh f29623e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f29624f;

    /* renamed from: g, reason: collision with root package name */
    public final zzijf f29625g;

    /* renamed from: h, reason: collision with root package name */
    public final zzijf f29626h;

    /* renamed from: i, reason: collision with root package name */
    public final zzijf f29627i;

    public zzeld(zzcmg zzcmgVar, zzdab zzdabVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4, zzijf zzijfVar5, zzijf zzijfVar6, zzijh zzijhVar) {
        this.f29619a = zzijfVar;
        this.f29620b = zzcmgVar;
        this.f29621c = zzdabVar;
        this.f29622d = zzijfVar2;
        this.f29623e = zzijhVar;
        this.f29624f = zzijfVar3;
        this.f29625g = zzijfVar4;
        this.f29626h = zzijfVar5;
        this.f29627i = zzijfVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzelc((Context) this.f29619a.zzb(), this.f29620b.a(), this.f29621c.a(), (Executor) this.f29622d.zzb(), (zzdkz) this.f29623e.f34899a, (zzdua) this.f29624f.zzb(), new zzbnq(), (zzeif) this.f29625g.zzb(), (zzdwy) this.f29626h.zzb(), (zzdxe) this.f29627i.zzb());
    }
}
