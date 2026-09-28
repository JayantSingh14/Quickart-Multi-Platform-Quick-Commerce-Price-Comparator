package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes3.dex */
public final class zztg {
    public static zztb zza(ExecutorService executorService) {
        return executorService instanceof zztb ? (zztb) executorService : executorService instanceof ScheduledExecutorService ? new zztf((ScheduledExecutorService) executorService) : new zztc(executorService);
    }

    public static Executor zzb() {
        return zzsh.INSTANCE;
    }
}
