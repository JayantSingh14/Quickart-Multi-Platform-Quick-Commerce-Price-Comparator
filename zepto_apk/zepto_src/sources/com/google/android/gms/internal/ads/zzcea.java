package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
/* loaded from: classes4.dex */
public class zzcea {

    /* renamed from: a, reason: collision with root package name */
    public final zzcdt f25997a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f25998b;

    public zzcea() {
        zzcdt zzcdtVar = new zzcdt();
        this.f25997a = zzcdtVar;
        this.f25998b = new AtomicInteger(0);
        zzcdy zzcdyVar = new zzcdy(this);
        zzcdtVar.q(new zzgyk(zzcdtVar, zzcdyVar), zzcdo.f25988g);
    }

    public final void a(zzcdx zzcdxVar, zzcdv zzcdvVar) {
        zzcdz zzcdzVar = new zzcdz(this, zzcdxVar, zzcdvVar);
        zzcdt zzcdtVar = this.f25997a;
        zzcdtVar.q(new zzgyk(zzcdtVar, zzcdzVar), zzcdo.f25988g);
    }

    public final void b() {
        this.f25997a.c(new Exception());
    }

    public final void c(String str, Throwable th) {
        this.f25997a.c(th);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.w8)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.e(str, th);
        }
    }
}
