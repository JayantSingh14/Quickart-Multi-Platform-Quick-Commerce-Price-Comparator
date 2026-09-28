package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata
/* loaded from: classes3.dex */
final class UnconfinedTestDispatcherImpl extends TestDispatcher {
    @Override // kotlinx.coroutines.test.TestDispatcher
    public final TestCoroutineScheduler O1() {
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void c1(CoroutineContext coroutineContext, Runnable runnable) {
        TestCoroutineSchedulerKt.a(null, coroutineContext);
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean o1(CoroutineContext coroutineContext) {
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return android.support.v4.media.b.k("UnconfinedTestDispatcher", "[scheduler=null]");
    }
}
