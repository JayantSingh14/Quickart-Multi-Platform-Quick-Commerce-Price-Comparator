package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzeul implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f30350a = new AtomicReference();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f30351b = new AtomicReference(Boolean.FALSE);

    /* renamed from: c, reason: collision with root package name */
    public final Clock f30352c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgyw f30353d;

    /* renamed from: e, reason: collision with root package name */
    public final zzezx f30354e;

    /* renamed from: f, reason: collision with root package name */
    public final long f30355f;

    /* renamed from: g, reason: collision with root package name */
    public final zzdxe f30356g;

    public zzeul(zzezx zzezxVar, long j2, Clock clock, zzgyw zzgywVar, zzdxe zzdxeVar) {
        this.f30352c = clock;
        this.f30354e = zzezxVar;
        this.f30355f = j2;
        this.f30353d = zzgywVar;
        this.f30356g = zzdxeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        zzeui zzeuiVar;
        zzbgb zzbgbVar = zzbgk.Tc;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.Sc)).booleanValue() && !((Boolean) this.f30351b.getAndSet(Boolean.TRUE)).booleanValue()) {
                ScheduledExecutorService scheduledExecutorService = zzcdo.f25985d;
                Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzeuk
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        final zzeul zzeulVar = this.f30349a;
                        zzeulVar.getClass();
                        zzeulVar.f30353d.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeuj
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzeul zzeulVar2 = zzeulVar;
                                zzeulVar2.f30350a.set(new zzeui(zzeulVar2.f30354e.zza(), zzeulVar2.f30355f, zzeulVar2.f30352c));
                            }
                        });
                    }
                };
                long j2 = this.f30355f;
                ((ScheduledThreadPoolExecutor) scheduledExecutorService).scheduleWithFixedDelay(runnable, j2, j2, TimeUnit.MILLISECONDS);
            }
            synchronized (this) {
                try {
                    AtomicReference atomicReference = this.f30350a;
                    zzeui zzeuiVar2 = (zzeui) atomicReference.get();
                    if (zzeuiVar2 == null) {
                        ListenableFuture listenableFutureZza = this.f30354e.zza();
                        atomicReference.set(new zzeui(listenableFutureZza, this.f30355f, this.f30352c));
                        return listenableFutureZza;
                    }
                    if (((Boolean) this.f30351b.get()).booleanValue() || zzeuiVar2.f30346b >= zzeuiVar2.f30347c.elapsedRealtime()) {
                        zzeuiVar = zzeuiVar2;
                    } else {
                        ListenableFuture listenableFuture = zzeuiVar2.f30345a;
                        zzezx zzezxVar = this.f30354e;
                        zzeui zzeuiVar3 = new zzeui(zzezxVar.zza(), this.f30355f, this.f30352c);
                        this.f30350a.set(zzeuiVar3);
                        if (((Boolean) zzbdVar.f21153c.a(zzbgk.Uc)).booleanValue()) {
                            if (((Boolean) zzbdVar.f21153c.a(zzbgk.Vc)).booleanValue()) {
                                zzdxd zzdxdVarA = this.f30356g.a();
                                zzdxdVarA.b("action", "scs");
                                zzdxdVarA.b("sid", String.valueOf(zzezxVar.zzb()));
                                zzdxdVarA.c();
                            }
                            return listenableFuture;
                        }
                        zzeuiVar = zzeuiVar3;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            AtomicReference atomicReference2 = this.f30350a;
            zzeuiVar = (zzeui) atomicReference2.get();
            if (zzeuiVar == null || zzeuiVar.f30346b < zzeuiVar.f30347c.elapsedRealtime()) {
                zzezx zzezxVar2 = this.f30354e;
                zzeui zzeuiVar4 = new zzeui(zzezxVar2.zza(), this.f30355f, this.f30352c);
                atomicReference2.set(zzeuiVar4);
                zzeuiVar = zzeuiVar4;
            }
        }
        return zzeuiVar.f30345a;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return this.f30354e.zzb();
    }
}
