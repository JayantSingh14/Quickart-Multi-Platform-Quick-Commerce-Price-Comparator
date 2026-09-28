package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzclk implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijf f26514a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfqe f26515b;

    /* renamed from: c, reason: collision with root package name */
    public final zzijf f26516c;

    public zzclk(zzijf zzijfVar, zzfqe zzfqeVar, zzijf zzijfVar2) {
        this.f26514a = zzijfVar;
        this.f26515b = zzfqeVar;
        this.f26516c = zzijfVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzbgb zzbgbVar = zzbgk.Q;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        Integer num = (Integer) zzbdVar.f21153c.a(zzbgbVar);
        num.getClass();
        int iIntValue = num.intValue();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f26514a.zzb();
        zzfqd zzfqdVarZzb = this.f26515b.zzb();
        Clock clock = (Clock) this.f26516c.zzb();
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.O)).booleanValue()) {
            return new zzfpp(iIntValue, scheduledExecutorService, zzfqdVarZzb, clock);
        }
        return null;
    }
}
