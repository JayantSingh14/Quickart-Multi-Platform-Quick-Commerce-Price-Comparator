package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzetk implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzcda f30277a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.gms.internal.appset.zzr f30278b;

    /* renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f30279c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgyw f30280d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f30281e;

    public zzetk(Context context, zzcda zzcdaVar, ScheduledExecutorService scheduledExecutorService, zzgyw zzgywVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.D3)).booleanValue()) {
            this.f30278b = new com.google.android.gms.internal.appset.zzr(context);
        }
        this.f30281e = context;
        this.f30277a = zzcdaVar;
        this.f30279c = scheduledExecutorService;
        this.f30280d = zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        Task taskA;
        zzbgb zzbgbVar = zzbgk.z3;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            if (!((Boolean) zzbdVar.f21153c.a(zzbgk.E3)).booleanValue()) {
                if (!((Boolean) zzbdVar.f21153c.a(zzbgk.A3)).booleanValue()) {
                    return zzgym.i(zzfzr.a(this.f30278b.a()), zzetj.f30276a, zzcdo.f25988g);
                }
                if (((Boolean) zzbdVar.f21153c.a(zzbgk.D3)).booleanValue()) {
                    zzfjp.a(this.f30281e, false);
                    synchronized (zzfjp.f31278c) {
                        taskA = zzfjp.f31276a;
                    }
                } else {
                    taskA = this.f30278b.a();
                }
                if (taskA == null) {
                    return zzgym.a(new zzetl(null, -1));
                }
                ListenableFuture listenableFutureH = zzgym.h(zzfzr.a(taskA), zzeth.f30274a, zzcdo.f25988g);
                if (((Boolean) zzbdVar.f21153c.a(zzbgk.B3)).booleanValue()) {
                    listenableFutureH = zzgym.g(listenableFutureH, ((Long) zzbdVar.f21153c.a(zzbgk.C3)).longValue(), TimeUnit.MILLISECONDS, this.f30279c);
                }
                return zzgym.e(listenableFutureH, Exception.class, new zzgpr() { // from class: com.google.android.gms.internal.ads.zzeti
                    @Override // com.google.android.gms.internal.ads.zzgpr
                    public final /* synthetic */ Object apply(Object obj) {
                        this.f30275a.f30277a.d("AppSetIdInfoSignal", (Exception) obj);
                        return new zzetl(null, -1);
                    }
                }, this.f30280d);
            }
        }
        return zzgym.a(new zzetl(null, -1));
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 11;
    }
}
