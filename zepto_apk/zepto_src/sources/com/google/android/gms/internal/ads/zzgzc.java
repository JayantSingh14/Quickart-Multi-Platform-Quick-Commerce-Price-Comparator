package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class zzgzc extends zzgyy implements zzgyx {

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f33395b;

    public zzgzc(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.f33395b = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzgyx, java.util.concurrent.ScheduledExecutorService
    /* renamed from: N */
    public final zzgyv schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
        zzgzl zzgzlVar = new zzgzl(Executors.callable(runnable, null));
        return new zzgza(zzgzlVar, this.f33395b.schedule(zzgzlVar, j2, timeUnit));
    }

    @Override // com.google.android.gms.internal.ads.zzgyx, java.util.concurrent.ScheduledExecutorService
    /* renamed from: Z */
    public final zzgyv scheduleWithFixedDelay(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        zzgzb zzgzbVar = new zzgzb(runnable);
        return new zzgza(zzgzbVar, this.f33395b.scheduleWithFixedDelay(zzgzbVar, j2, j3, timeUnit));
    }

    @Override // com.google.android.gms.internal.ads.zzgyx, java.util.concurrent.ScheduledExecutorService
    /* renamed from: j1 */
    public final zzgyv schedule(Callable callable, long j2, TimeUnit timeUnit) {
        zzgzl zzgzlVar = new zzgzl(callable);
        return new zzgza(zzgzlVar, this.f33395b.schedule(zzgzlVar, j2, timeUnit));
    }

    @Override // com.google.android.gms.internal.ads.zzgyx, java.util.concurrent.ScheduledExecutorService
    /* renamed from: l0 */
    public final zzgyv scheduleAtFixedRate(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        zzgzb zzgzbVar = new zzgzb(runnable);
        return new zzgza(zzgzbVar, this.f33395b.scheduleAtFixedRate(zzgzbVar, j2, j3, timeUnit));
    }
}
