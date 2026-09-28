package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public interface zzgyw extends ExecutorService {
    @Override // java.util.concurrent.ExecutorService, com.google.android.gms.internal.ads.zzgyw
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    ListenableFuture submit(Runnable runnable);

    @Override // java.util.concurrent.ExecutorService, com.google.android.gms.internal.ads.zzgyw
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    ListenableFuture submit(Runnable runnable, Object obj);

    @Override // java.util.concurrent.ExecutorService, com.google.android.gms.internal.ads.zzgyw
    /* renamed from: y0, reason: merged with bridge method [inline-methods] */
    ListenableFuture submit(Callable callable);
}
