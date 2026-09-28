package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzevm implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzesa f30420a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30421b;

    public zzevm(zzesa zzesaVar, zzijf zzijfVar) {
        this.f30420a = zzesaVar;
        this.f30421b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzeyj(this.f30420a.zzb(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.zd)).intValue(), (ScheduledExecutorService) this.f30421b.zzb());
    }
}
