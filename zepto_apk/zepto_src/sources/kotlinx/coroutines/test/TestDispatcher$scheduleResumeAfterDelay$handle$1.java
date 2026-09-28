package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.NotCompleted;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class TestDispatcher$scheduleResumeAfterDelay$handle$1 extends FunctionReferenceImpl implements Function1<CancellableContinuationRunnable, Boolean> {

    /* renamed from: b, reason: collision with root package name */
    public static final TestDispatcher$scheduleResumeAfterDelay$handle$1 f55321b = new TestDispatcher$scheduleResumeAfterDelay$handle$1(1, TestDispatcherKt.class, "cancellableRunnableIsCancelled", "cancellableRunnableIsCancelled(Lkotlinx/coroutines/test/CancellableContinuationRunnable;)Z", 1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ((CancellableContinuationRunnable) obj).f55265a.getClass();
        return Boolean.valueOf(!(CancellableContinuationImpl.f54059g.get(r2) instanceof NotCompleted));
    }
}
