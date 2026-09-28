package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ExecutionList;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes4.dex */
public class ListenableFutureTask<V> extends FutureTask<V> implements ListenableFuture<V> {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutionList f43462a;

    public ListenableFutureTask(androidx.media3.datasource.b bVar) {
        super(bVar);
        this.f43462a = new ExecutionList();
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        ExecutionList executionList = this.f43462a;
        synchronized (executionList) {
            try {
                if (executionList.f43440b) {
                    return;
                }
                executionList.f43440b = true;
                ExecutionList.RunnableExecutorPair runnableExecutorPair = executionList.f43439a;
                ExecutionList.RunnableExecutorPair runnableExecutorPair2 = null;
                executionList.f43439a = null;
                while (runnableExecutorPair != null) {
                    ExecutionList.RunnableExecutorPair runnableExecutorPair3 = runnableExecutorPair.f43443c;
                    runnableExecutorPair.f43443c = runnableExecutorPair2;
                    runnableExecutorPair2 = runnableExecutorPair;
                    runnableExecutorPair = runnableExecutorPair3;
                }
                while (runnableExecutorPair2 != null) {
                    ExecutionList.a(runnableExecutorPair2.f43441a, runnableExecutorPair2.f43442b);
                    runnableExecutorPair2 = runnableExecutorPair2.f43443c;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j2);
        return nanos <= 2147483647999999999L ? super.get(j2, timeUnit) : super.get(Math.min(nanos, 2147483647999999999L), TimeUnit.NANOSECONDS);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void q(Runnable runnable, Executor executor) {
        ExecutionList executionList = this.f43462a;
        executionList.getClass();
        Preconditions.j(runnable, "Runnable was null.");
        Preconditions.j(executor, "Executor was null.");
        synchronized (executionList) {
            try {
                if (executionList.f43440b) {
                    ExecutionList.a(runnable, executor);
                } else {
                    executionList.f43439a = new ExecutionList.RunnableExecutorPair(runnable, executor, executionList.f43439a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
