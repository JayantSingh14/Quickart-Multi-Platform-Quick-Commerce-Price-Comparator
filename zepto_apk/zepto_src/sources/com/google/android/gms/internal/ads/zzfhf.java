package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzfhf implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f31106a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f31107b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijh f31108c;

    /* renamed from: d, reason: collision with root package name */
    public final zzffm f31109d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f31110e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f31111f;

    public zzfhf(zzijh zzijhVar, zzijf zzijfVar, zzijh zzijhVar2, zzffm zzffmVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f31106a = zzijhVar;
        this.f31107b = zzijfVar;
        this.f31108c = zzijhVar2;
        this.f31109d = zzffmVar;
        this.f31110e = zzijfVar2;
        this.f31111f = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzfhe((Context) this.f31106a.f34899a, (Executor) this.f31107b.zzb(), (zzclg) this.f31108c.f34899a, this.f31109d.zzb(), (zzfgv) this.f31110e.zzb(), new zzfij(), (zzfid) this.f31111f.zzb());
    }
}
