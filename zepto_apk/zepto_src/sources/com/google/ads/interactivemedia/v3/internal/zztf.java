package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
final class zztf extends zztc implements ScheduledExecutorService, zztb {
    final ScheduledExecutorService zza;

    public zztf(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.zza;
        zztl zztlVarZzp = zztl.zzp(runnable, null);
        return new zztd(zztlVarZzp, scheduledExecutorService.schedule(zztlVarZzp, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        zzte zzteVar = new zzte(runnable);
        return new zztd(zzteVar, this.zza.scheduleAtFixedRate(zzteVar, j2, j3, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        zzte zzteVar = new zzte(runnable);
        return new zztd(zzteVar, this.zza.scheduleWithFixedDelay(zzteVar, j2, j3, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j2, TimeUnit timeUnit) {
        zztl zztlVar = new zztl(callable);
        return new zztd(zztlVar, this.zza.schedule(zztlVar, j2, timeUnit));
    }
}
