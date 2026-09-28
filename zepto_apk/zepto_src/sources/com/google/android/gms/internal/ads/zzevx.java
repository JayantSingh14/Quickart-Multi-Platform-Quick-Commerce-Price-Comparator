package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzevx implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzewr f30447a;

    /* renamed from: b, reason: collision with root package name */
    public final zzijf f30448b;

    public zzevx(zzewr zzewrVar, zzijf zzijfVar) {
        this.f30447a = zzewrVar;
        this.f30448b = zzijfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        Context contextA = this.f30447a.f30495a.a();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        return new zzeyj(new zzewq(contextA, zzgywVar), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.sd)).intValue(), (ScheduledExecutorService) this.f30448b.zzb());
    }
}
