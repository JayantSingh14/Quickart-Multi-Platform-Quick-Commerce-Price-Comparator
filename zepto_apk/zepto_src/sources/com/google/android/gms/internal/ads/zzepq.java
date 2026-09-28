package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzepq implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f30057a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdlr f30058b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdab f30059c;

    /* renamed from: d, reason: collision with root package name */
    public final zzctp f30060d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f30061e;

    public zzepq(zzijf zzijfVar, zzdlr zzdlrVar, zzdab zzdabVar, zzctp zzctpVar, zzijf zzijfVar2) {
        this.f30057a = zzijfVar;
        this.f30058b = zzdlrVar;
        this.f30059c = zzdabVar;
        this.f30060d = zzctpVar;
        this.f30061e = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzepp((Context) this.f30057a.zzb(), this.f30058b.f27911a.f27910b, this.f30059c.a(), this.f30060d.f27127a.zzb(), (zzdxe) this.f30061e.zzb());
    }
}
