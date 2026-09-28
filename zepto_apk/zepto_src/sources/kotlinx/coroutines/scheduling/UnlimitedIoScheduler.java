package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

@Metadata
/* loaded from: classes.dex */
final class UnlimitedIoScheduler extends CoroutineDispatcher {

    /* renamed from: b, reason: collision with root package name */
    public static final UnlimitedIoScheduler f55164b = new UnlimitedIoScheduler();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void c1(CoroutineContext coroutineContext, Runnable runnable) {
        DefaultScheduler.f55152c.f55154b.b(runnable, true, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void l1(CoroutineContext coroutineContext, Runnable runnable) {
        DefaultScheduler.f55152c.f55154b.b(runnable, true, true);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher s1(int i2) {
        LimitedDispatcherKt.a(i2);
        return i2 >= TasksKt.f55161d ? this : super.s1(i2);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "Dispatchers.IO";
    }
}
