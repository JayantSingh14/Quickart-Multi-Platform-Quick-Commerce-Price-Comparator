package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

@Metadata
/* loaded from: classes.dex */
public class SchedulerCoroutineDispatcher extends ExecutorCoroutineDispatcher {

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineScheduler f55154b;

    public SchedulerCoroutineDispatcher() {
        this(TasksKt.f55162e, "CoroutineScheduler", TasksKt.f55160c, TasksKt.f55161d);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void c1(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.c(this.f55154b, runnable, 6);
    }

    public void close() throws InterruptedException {
        this.f55154b.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void l1(CoroutineContext coroutineContext, Runnable runnable) {
        CoroutineScheduler.c(this.f55154b, runnable, 2);
    }

    public SchedulerCoroutineDispatcher(long j2, String str, int i2, int i3) {
        this.f55154b = new CoroutineScheduler(j2, str, i2, i3);
    }
}
