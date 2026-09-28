package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzfeg implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f30954a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30955b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijh f30956c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijh f30957d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f30958e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f30959f;

    /* renamed from: g, reason: collision with root package name */
    public final zzijf f30960g;

    public zzfeg(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4, zzijh zzijhVar, zzijh zzijhVar2, zzijh zzijhVar3) {
        this.f30954a = zzijhVar;
        this.f30955b = zzijfVar;
        this.f30956c = zzijhVar2;
        this.f30957d = zzijhVar3;
        this.f30958e = zzijfVar2;
        this.f30959f = zzijfVar3;
        this.f30960g = zzijfVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzfef((Context) this.f30954a.f34899a, (Executor) this.f30955b.zzb(), (com.google.android.gms.ads.internal.client.zzr) this.f30956c.f34899a, (zzclg) this.f30957d.f34899a, (zzeqp) this.f30958e.zzb(), (zzeqt) this.f30959f.zzb(), new zzfij(), (zzdfq) this.f30960g.zzb());
    }
}
