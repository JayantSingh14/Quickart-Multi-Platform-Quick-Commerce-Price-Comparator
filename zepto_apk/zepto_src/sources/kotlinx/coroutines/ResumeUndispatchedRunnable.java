package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ResumeUndispatchedRunnable implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorCoroutineDispatcherImpl f54158a;

    /* renamed from: b, reason: collision with root package name */
    public final CancellableContinuationImpl f54159b;

    public ResumeUndispatchedRunnable(ExecutorCoroutineDispatcherImpl executorCoroutineDispatcherImpl, CancellableContinuationImpl cancellableContinuationImpl) {
        this.f54158a = executorCoroutineDispatcherImpl;
        this.f54159b = cancellableContinuationImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f54159b.B(this.f54158a, Unit.f53572a);
    }
}
