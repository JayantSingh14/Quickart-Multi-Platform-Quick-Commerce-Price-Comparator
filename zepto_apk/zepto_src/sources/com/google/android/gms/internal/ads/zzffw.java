package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzffw implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f31041a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f31042b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijh f31043c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f31044d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f31045e;

    public zzffw(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijh zzijhVar, zzijh zzijhVar2) {
        this.f31041a = zzijhVar;
        this.f31042b = zzijfVar;
        this.f31043c = zzijhVar2;
        this.f31044d = zzijfVar2;
        this.f31045e = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzffv((Context) this.f31041a.f34899a, (Executor) this.f31042b.zzb(), (zzclg) this.f31043c.f34899a, (zzeqp) this.f31044d.zzb(), (zzfgv) this.f31045e.zzb(), new zzfij());
    }
}
