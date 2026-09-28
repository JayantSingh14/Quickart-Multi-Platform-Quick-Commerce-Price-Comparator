package androidx.work;

import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobImpl;

@Metadata
/* loaded from: classes3.dex */
public final class JobListenableFuture<R> implements ListenableFuture<R> {

    /* renamed from: a, reason: collision with root package name */
    public final SettableFuture f12525a;

    public JobListenableFuture(JobImpl job) {
        SettableFuture underlying = new SettableFuture();
        Intrinsics.checkNotNullExpressionValue(underlying, "create()");
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(underlying, "underlying");
        this.f12525a = underlying;
        job.j0(new Function1<Throwable, Unit>() { // from class: androidx.work.JobListenableFuture.1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                JobListenableFuture jobListenableFuture = JobListenableFuture.this;
                if (th == null) {
                    if (!jobListenableFuture.f12525a.isDone()) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                } else if (th instanceof CancellationException) {
                    jobListenableFuture.f12525a.cancel(true);
                } else {
                    SettableFuture settableFuture = jobListenableFuture.f12525a;
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        th = cause;
                    }
                    settableFuture.j(th);
                }
                return Unit.f53572a;
            }
        });
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.f12525a.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f12525a.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f12525a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f12525a.isDone();
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void q(Runnable runnable, Executor executor) {
        this.f12525a.q(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) {
        return this.f12525a.get(j2, timeUnit);
    }
}
