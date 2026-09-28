package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TestCoroutineSchedulerKt {
    public static final void a(TestCoroutineScheduler testCoroutineScheduler, CoroutineContext coroutineContext) {
        TestCoroutineScheduler testCoroutineScheduler2 = (TestCoroutineScheduler) coroutineContext.get(TestCoroutineScheduler.f55302f);
        if (testCoroutineScheduler2 != null && testCoroutineScheduler2 != testCoroutineScheduler) {
            throw new IllegalStateException("Detected use of different schedulers. If you need to use several test coroutine dispatchers, create one `TestCoroutineScheduler` and pass it to each of them.");
        }
    }
}
