package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public interface zzgyx extends ScheduledExecutorService, zzgyw {
    @Override // java.util.concurrent.ScheduledExecutorService
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    zzgyv schedule(Runnable runnable, long j2, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    zzgyv scheduleWithFixedDelay(Runnable runnable, long j2, long j3, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    zzgyv schedule(Callable callable, long j2, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    zzgyv scheduleAtFixedRate(Runnable runnable, long j2, long j3, TimeUnit timeUnit);
}
