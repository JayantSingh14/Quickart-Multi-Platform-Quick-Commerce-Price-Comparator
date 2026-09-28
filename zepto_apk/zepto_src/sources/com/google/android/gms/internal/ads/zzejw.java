package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzejw implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f29512a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijh f29513b;

    public zzejw(zzijf zzijfVar, zzijh zzijhVar) {
        this.f29512a = zzijfVar;
        this.f29513b = zzijhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context context = (Context) this.f29512a.zzb();
        zzcsq zzcsqVar = (zzcsq) this.f29513b.f34899a;
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzejv(context, zzcsqVar, zzgywVar);
    }
}
