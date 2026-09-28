package com.google.android.gms.internal.pal;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
final class zzdq implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final ThreadFactory f37628a = Executors.defaultThreadFactory();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f37629b = new AtomicInteger(1);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f37628a.newThread(runnable);
        threadNewThread.setName("gads-" + this.f37629b.getAndIncrement());
        return threadNewThread;
    }
}
