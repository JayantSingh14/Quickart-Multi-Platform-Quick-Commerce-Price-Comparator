package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzcrb implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f26937a;

    /* renamed from: b, reason: collision with root package name */
    public final zzclj f26938b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f26939c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f26940d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f26941e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f26942f;

    public zzcrb(zzclp zzclpVar, zzclj zzcljVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4) {
        this.f26937a = zzclpVar;
        this.f26938b = zzcljVar;
        this.f26939c = zzijfVar;
        this.f26940d = zzijfVar2;
        this.f26941e = zzijfVar3;
        this.f26942f = zzijfVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f26937a.a();
        com.google.android.gms.ads.internal.util.zzj zzjVarZzb = this.f26938b.zzb();
        zzejc zzejcVar = (zzejc) this.f26939c.zzb();
        zzduf zzdufVar = (zzduf) this.f26940d.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzcra(contextA, zzjVarZzb, zzejcVar, zzdufVar, zzgywVar, (zzgyw) this.f26941e.zzb(), (ScheduledExecutorService) this.f26942f.zzb());
    }
}
