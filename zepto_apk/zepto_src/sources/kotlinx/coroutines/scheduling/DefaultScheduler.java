package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

@Metadata
/* loaded from: classes.dex */
public final class DefaultScheduler extends SchedulerCoroutineDispatcher {

    /* renamed from: c, reason: collision with root package name */
    public static final DefaultScheduler f55152c = new DefaultScheduler(TasksKt.f55162e, TasksKt.f55158a, TasksKt.f55160c, TasksKt.f55161d);

    @Override // kotlinx.coroutines.scheduling.SchedulerCoroutineDispatcher, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher s1(int i2) {
        LimitedDispatcherKt.a(i2);
        return i2 >= TasksKt.f55160c ? this : super.s1(i2);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "Dispatchers.Default";
    }
}
