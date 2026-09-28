package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzfdu implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f30904a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30905b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijh f30906c;

    /* renamed from: d, reason: collision with root package name */
    public final zzffl f30907d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f30908e;

    /* renamed from: f, reason: collision with root package name */
    public final zzcmg f30909f;

    public zzfdu(zzijh zzijhVar, zzijf zzijfVar, zzijh zzijhVar2, zzffl zzfflVar, zzijf zzijfVar2, zzcmg zzcmgVar) {
        this.f30904a = zzijhVar;
        this.f30905b = zzijfVar;
        this.f30906c = zzijhVar2;
        this.f30907d = zzfflVar;
        this.f30908e = zzijfVar2;
        this.f30909f = zzcmgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzfdt((Context) this.f30904a.f34899a, (Executor) this.f30905b.zzb(), (zzclg) this.f30906c.f34899a, this.f30907d.zzb(), (zzfdr) this.f30908e.zzb(), new zzfij(), this.f30909f.a());
    }
}
