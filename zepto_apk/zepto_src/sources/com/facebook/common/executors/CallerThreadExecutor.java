package com.facebook.common.executors;

import com.facebook.infer.annotation.Nullsafe;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

@Nullsafe
/* loaded from: classes3.dex */
public class CallerThreadExecutor extends AbstractExecutorService {

    /* renamed from: a, reason: collision with root package name */
    public static final CallerThreadExecutor f17069a = new CallerThreadExecutor();

    public static CallerThreadExecutor a() {
        return f17069a;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j2, TimeUnit timeUnit) {
        return true;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        return Collections.EMPTY_LIST;
    }
}
