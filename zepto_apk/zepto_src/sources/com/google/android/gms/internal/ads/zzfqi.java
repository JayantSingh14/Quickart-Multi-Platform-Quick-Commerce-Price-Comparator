package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes4.dex */
public final class zzfqi implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f31636a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfqe f31637b;

    /* renamed from: c, reason: collision with root package name */
    public final zzclp f31638c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f31639d;

    public zzfqi(zzijf zzijfVar, zzfqe zzfqeVar, zzclp zzclpVar, zzijf zzijfVar2) {
        this.f31636a = zzijfVar;
        this.f31637b = zzfqeVar;
        this.f31638c = zzclpVar;
        this.f31639d = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfqh((zzfqz) this.f31636a.zzb(), this.f31637b.zzb(), this.f31638c.a(), (Clock) this.f31639d.zzb());
    }
}
