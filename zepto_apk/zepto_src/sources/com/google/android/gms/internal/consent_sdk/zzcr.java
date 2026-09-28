package com.google.android.gms.internal.consent_sdk;

import android.support.v4.media.b;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
final class zzcr implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public final ThreadPoolExecutor f36538b;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f36537a = new AtomicInteger(1);

    /* renamed from: c, reason: collision with root package name */
    public WeakReference f36539c = new WeakReference(null);

    public zzcr() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.google.android.gms.internal.consent_sdk.zzcq
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                zzcr zzcrVar = this.f36536a;
                Thread thread = new Thread(runnable, b.f(zzcrVar.f36537a.getAndIncrement(), "Google consent worker #"));
                zzcrVar.f36539c = new WeakReference(thread);
                return thread;
            }
        });
        this.f36538b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (Thread.currentThread() == this.f36539c.get()) {
            runnable.run();
        } else {
            this.f36538b.execute(runnable);
        }
    }
}
