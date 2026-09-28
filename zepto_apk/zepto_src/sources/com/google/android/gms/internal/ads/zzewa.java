package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzewa implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzexd f30453a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30454b;

    public zzewa(zzexd zzexdVar, zzijf zzijfVar) {
        this.f30453a = zzexdVar;
        this.f30454b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzexd zzexdVar = this.f30453a;
        zzexdVar.getClass();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeyj(new zzexb(zzgywVar, zzexdVar.f30517a.a()), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Fd)).intValue(), (ScheduledExecutorService) this.f30454b.zzb());
    }
}
