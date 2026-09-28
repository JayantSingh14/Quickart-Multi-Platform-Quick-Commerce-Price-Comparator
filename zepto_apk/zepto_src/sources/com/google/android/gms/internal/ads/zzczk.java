package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzczk implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzcwe f27473a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcwb f27474b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f27475c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f27476d;

    /* renamed from: e, reason: collision with root package name */
    public final zzijf f27477e;

    public zzczk(zzcwe zzcweVar, zzcwb zzcwbVar, zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3) {
        this.f27473a = zzcweVar;
        this.f27474b = zzcwbVar;
        this.f27475c = zzijfVar;
        this.f27476d = zzijfVar2;
        this.f27477e = zzijfVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzczj(this.f27473a.a(), this.f27474b.a(), (Clock) this.f27475c.zzb(), (zzdxe) this.f27476d.zzb(), (ScheduledExecutorService) this.f27477e.zzb());
    }
}
