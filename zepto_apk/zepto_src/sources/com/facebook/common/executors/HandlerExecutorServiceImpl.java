package com.facebook.common.executors;

import android.os.Handler;
import com.facebook.infer.annotation.Nullsafe;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Nullsafe
/* loaded from: classes.dex */
public class HandlerExecutorServiceImpl extends AbstractExecutorService implements HandlerExecutorService {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f17071a;

    public HandlerExecutorServiceImpl(Handler handler) {
        this.f17071a = handler;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f17071a.post(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final RunnableFuture newTaskFor(Runnable runnable, Object obj) {
        return new ScheduledFutureImpl(runnable, obj);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Runnable runnable, long j2, TimeUnit timeUnit) {
        ScheduledFutureImpl scheduledFutureImpl = new ScheduledFutureImpl(runnable, null);
        this.f17071a.postDelayed(scheduledFutureImpl, timeUnit.toMillis(j2));
        return scheduledFutureImpl;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable) {
        runnable.getClass();
        ScheduledFutureImpl scheduledFutureImpl = new ScheduledFutureImpl(runnable, null);
        execute(scheduledFutureImpl);
        return scheduledFutureImpl;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public final RunnableFuture newTaskFor(Callable callable) {
        return new ScheduledFutureImpl(callable);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Callable callable, long j2, TimeUnit timeUnit) {
        ScheduledFutureImpl scheduledFutureImpl = new ScheduledFutureImpl(callable);
        this.f17071a.postDelayed(scheduledFutureImpl, timeUnit.toMillis(j2));
        return scheduledFutureImpl;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable, Object obj) {
        runnable.getClass();
        ScheduledFutureImpl scheduledFutureImpl = new ScheduledFutureImpl(runnable, obj);
        execute(scheduledFutureImpl);
        return scheduledFutureImpl;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future submit(Callable callable) {
        callable.getClass();
        ScheduledFutureImpl scheduledFutureImpl = new ScheduledFutureImpl(callable);
        execute(scheduledFutureImpl);
        return scheduledFutureImpl;
    }
}
