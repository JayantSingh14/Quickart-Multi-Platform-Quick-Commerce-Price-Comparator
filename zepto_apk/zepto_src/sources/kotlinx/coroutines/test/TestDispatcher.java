package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.time.Duration;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DelayWithTimeoutDiagnostics;
import kotlinx.coroutines.DisposableHandle;

@Metadata
/* loaded from: classes3.dex */
public abstract class TestDispatcher extends CoroutineDispatcher implements Delay, DelayWithTimeoutDiagnostics {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f55320b = 0;

    @Override // kotlinx.coroutines.Delay
    public final void A(long j2, CancellableContinuationImpl cancellableContinuationImpl) {
        CancellableContinuationRunnable cancellableContinuationRunnable = new CancellableContinuationRunnable(cancellableContinuationImpl, this);
        CancellableContinuationKt.a(cancellableContinuationImpl, O1().c1(this, j2, cancellableContinuationRunnable, cancellableContinuationImpl.f54062e, TestDispatcher$scheduleResumeAfterDelay$handle$1.f55321b));
    }

    public abstract TestCoroutineScheduler O1();

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle b(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        return O1().c1(this, j2, runnable, coroutineContext, new a(2));
    }

    @Override // kotlinx.coroutines.DelayWithTimeoutDiagnostics
    public final /* synthetic */ String l(long j2) {
        return "Timed out after " + ((Object) Duration.i(j2)) + " of _virtual_ (kotlinx.coroutines.test) time. To use the real time, wrap 'withTimeout' in 'withContext(Dispatchers.Default.limitedParallelism(1))'";
    }
}
