package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzewf implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzeyd f30466a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30467b;

    public zzewf(zzeyd zzeydVar, zzijf zzijfVar) {
        this.f30466a = zzeydVar;
        this.f30467b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzeyd zzeydVar = this.f30466a;
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeyj(new zzeyb(zzeydVar.f30569a.a(), zzgywVar), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.nd)).intValue(), (ScheduledExecutorService) this.f30467b.zzb());
    }
}
