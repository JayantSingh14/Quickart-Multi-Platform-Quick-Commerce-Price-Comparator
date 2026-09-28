package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzfra implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzclp f31689a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcmg f31690b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f31691c;

    /* renamed from: d, reason: collision with root package name */
    public final zzijf f31692d;

    /* renamed from: e, reason: collision with root package name */
    public final zzcoz f31693e;

    /* renamed from: f, reason: collision with root package name */
    public final zzijf f31694f;

    /* renamed from: g, reason: collision with root package name */
    public final zzijf f31695g;

    public zzfra(zzclp zzclpVar, zzcmg zzcmgVar, zzijf zzijfVar, zzijf zzijfVar2, zzcoz zzcozVar, zzijf zzijfVar3, zzijf zzijfVar4) {
        this.f31689a = zzclpVar;
        this.f31690b = zzcmgVar;
        this.f31691c = zzijfVar;
        this.f31692d = zzijfVar2;
        this.f31693e = zzcozVar;
        this.f31694f = zzijfVar3;
        this.f31695g = zzijfVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        return new zzfqz(this.f31689a.a(), this.f31690b.a(), (ScheduledExecutorService) this.f31691c.zzb(), (zzfly) this.f31692d.zzb(), zzfjg.a(this.f31693e.f26853a.a()), (Clock) this.f31694f.zzb(), (zzfpp) this.f31695g.zzb());
    }
}
