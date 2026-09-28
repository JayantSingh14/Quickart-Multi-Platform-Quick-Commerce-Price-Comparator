package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
/* loaded from: classes.dex */
public final class ExecutorCoroutineDispatcherImpl extends ExecutorCoroutineDispatcher implements Delay {

    /* renamed from: b, reason: collision with root package name */
    public final Executor f54112b;

    public ExecutorCoroutineDispatcherImpl(Executor executor) {
        this.f54112b = executor;
        if (executor instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) executor).setRemoveOnCancelPolicy(true);
        }
    }

    @Override // kotlinx.coroutines.Delay
    public final void A(long j2, CancellableContinuationImpl cancellableContinuationImpl) {
        Executor executor = this.f54112b;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(new ResumeUndispatchedRunnable(this, cancellableContinuationImpl), j2, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e2) {
                JobKt.b(cancellableContinuationImpl.f54062e, ExceptionsKt.a("The task was rejected", e2));
            }
        }
        if (scheduledFutureSchedule != null) {
            cancellableContinuationImpl.v(new CancelFutureOnCancel(scheduledFutureSchedule));
        } else {
            DefaultExecutor.f54084i.A(j2, cancellableContinuationImpl);
        }
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle b(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        Executor executor = this.f54112b;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(runnable, j2, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e2) {
                JobKt.b(coroutineContext, ExceptionsKt.a("The task was rejected", e2));
            }
        }
        return scheduledFutureSchedule != null ? new DisposableFutureHandle(scheduledFutureSchedule) : DefaultExecutor.f54084i.b(j2, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void c1(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            this.f54112b.execute(runnable);
        } catch (RejectedExecutionException e2) {
            JobKt.b(coroutineContext, ExceptionsKt.a("The task was rejected", e2));
            DefaultScheduler defaultScheduler = Dispatchers.f54091a;
            DefaultIoScheduler.f55150b.c1(coroutineContext, runnable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.f54112b;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ExecutorCoroutineDispatcherImpl) && ((ExecutorCoroutineDispatcherImpl) obj).f54112b == this.f54112b;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f54112b);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return this.f54112b.toString();
    }
}
