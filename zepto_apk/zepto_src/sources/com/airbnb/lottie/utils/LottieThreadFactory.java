package com.airbnb.lottie.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class LottieThreadFactory implements ThreadFactory {

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f14794d = new AtomicInteger(1);

    /* renamed from: a, reason: collision with root package name */
    public final ThreadGroup f14795a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f14796b = new AtomicInteger(1);

    /* renamed from: c, reason: collision with root package name */
    public final String f14797c;

    public LottieThreadFactory() {
        SecurityManager securityManager = System.getSecurityManager();
        this.f14795a = securityManager == null ? Thread.currentThread().getThreadGroup() : securityManager.getThreadGroup();
        this.f14797c = "lottie-" + f14794d.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f14795a, runnable, this.f14797c + this.f14796b.getAndIncrement(), 0L);
        thread.setDaemon(false);
        thread.setPriority(10);
        return thread;
    }
}
