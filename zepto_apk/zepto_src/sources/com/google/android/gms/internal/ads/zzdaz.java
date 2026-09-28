package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzdaz implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzday f27576a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijs f27577b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f27578c;

    public zzdaz(zzday zzdayVar, zzijs zzijsVar, zzijf zzijfVar) {
        this.f27576a = zzdayVar;
        this.f27577b = zzijsVar;
        this.f27578c = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzdat zzdatVar = new zzdat(this.f27576a.f27575a.zzb());
        Set setZzb = this.f27577b.zzb();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzdax(zzdatVar, setZzb, zzgywVar, (ScheduledExecutorService) this.f27578c.zzb());
    }
}
