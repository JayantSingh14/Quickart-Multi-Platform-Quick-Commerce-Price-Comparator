package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata
/* loaded from: classes.dex */
public final class DefaultIoScheduler extends ExecutorCoroutineDispatcher implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public static final DefaultIoScheduler f55150b = new DefaultIoScheduler();

    /* renamed from: c, reason: collision with root package name */
    public static final CoroutineDispatcher f55151c;

    static {
        UnlimitedIoScheduler unlimitedIoScheduler = UnlimitedIoScheduler.f55164b;
        int iA = SystemPropsKt.a();
        if (64 >= iA) {
            iA = 64;
        }
        f55151c = unlimitedIoScheduler.s1(SystemPropsKt.d(iA, 12, "kotlinx.coroutines.io.parallelism"));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void c1(CoroutineContext coroutineContext, Runnable runnable) {
        f55151c.c1(coroutineContext, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        c1(EmptyCoroutineContext.f53685a, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void l1(CoroutineContext coroutineContext, Runnable runnable) {
        f55151c.l1(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher s1(int i2) {
        return UnlimitedIoScheduler.f55164b.s1(i2);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "Dispatchers.IO";
    }
}
