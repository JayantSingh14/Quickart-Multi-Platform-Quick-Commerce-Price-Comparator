package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzcuy implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f27193a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcua f27194b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcwb f27195c;

    /* renamed from: d, reason: collision with root package name */
    public final zzcmg f27196d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f27197e;

    public zzcuy(zzclp zzclpVar, zzcua zzcuaVar, zzcwb zzcwbVar, zzcmg zzcmgVar, zzijf zzijfVar) {
        this.f27193a = zzclpVar;
        this.f27194b = zzcuaVar;
        this.f27195c = zzcwbVar;
        this.f27196d = zzcmgVar;
        this.f27197e = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f27193a.a();
        zzctj zzctjVar = this.f27194b.f27154a;
        return new zzcux(contextA, zzctjVar.f27120d, this.f27195c.a(), this.f27196d.a(), (zzeiz) this.f27197e.zzb());
    }
}
