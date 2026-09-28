package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzemd implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f29719a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f29720b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f29721c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f29722d;

    public zzemd(zzijf zzijfVar, zzijf zzijfVar2, zzijf zzijfVar3, zzijf zzijfVar4) {
        this.f29719a = zzijfVar;
        this.f29720b = zzijfVar2;
        this.f29721c = zzijfVar3;
        this.f29722d = zzijfVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzemb zzb() {
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzemb(zzgywVar, (ScheduledExecutorService) this.f29719a.zzb(), (zzcvn) this.f29720b.zzb(), (zzemr) this.f29721c.zzb(), (zzfpe) this.f29722d.zzb());
    }
}
