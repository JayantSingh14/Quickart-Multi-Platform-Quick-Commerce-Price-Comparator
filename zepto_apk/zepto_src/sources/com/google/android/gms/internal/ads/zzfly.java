package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzfly implements zzbde {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f31375a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f31376b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f31377c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public boolean f31378d = false;

    public zzfly(ScheduledExecutorService scheduledExecutorService, zzgyw zzgywVar) {
        this.f31375a = scheduledExecutorService;
        this.f31376b = zzgywVar;
    }

    public final synchronized void a(long j2, Runnable runnable) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        synchronized (this) {
            try {
                if (!this.f31378d) {
                    com.google.android.gms.ads.internal.zzt.C.f21683g.b(this);
                    this.f31378d = true;
                }
                final zzflx zzflxVar = new zzflx(this, runnable, com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis() + timeUnit.toMillis(j2));
                ScheduledFuture<?> scheduledFutureSchedule = this.f31375a.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzflv
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzflx zzflxVar2;
                        zzflx zzflxVar3 = zzflxVar;
                        zzfly zzflyVar = zzflxVar3.f31374d;
                        synchronized (zzflyVar) {
                            try {
                                ScheduledFuture scheduledFuture = zzflxVar3.f31373c;
                                zzflxVar2 = scheduledFuture != null ? (zzflx) zzflyVar.f31377c.remove(scheduledFuture) : null;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (zzflxVar2 != null) {
                            zzflxVar3.f31374d.f31376b.execute(zzflxVar3.f31371a);
                        }
                    }
                }, j2, timeUnit);
                zzflxVar.f31373c = scheduledFutureSchedule;
                this.f31377c.put(scheduledFutureSchedule, zzflxVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbde
    public final void j1(boolean z) {
        if (z) {
            this.f31376b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzflw
                @Override // java.lang.Runnable
                public final void run() {
                    zzfly zzflyVar = this.f31370a;
                    synchronized (zzflyVar) {
                        HashMap map = zzflyVar.f31377c;
                        ArrayList arrayList = new ArrayList(map.keySet());
                        int size = arrayList.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            ScheduledFuture scheduledFuture = (ScheduledFuture) arrayList.get(i2);
                            zzflx zzflxVar = (zzflx) map.get(scheduledFuture);
                            if (zzflxVar != null && scheduledFuture != null && !scheduledFuture.isDone()) {
                                scheduledFuture.cancel(false);
                                map.remove(scheduledFuture);
                                long jCurrentTimeMillis = zzflxVar.f31372b - com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();
                                Runnable runnable = zzflxVar.f31371a;
                                long jMax = Math.max(0L, jCurrentTimeMillis);
                                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                                zzflyVar.a(jMax, runnable);
                            }
                        }
                    }
                }
            });
        }
    }
}
