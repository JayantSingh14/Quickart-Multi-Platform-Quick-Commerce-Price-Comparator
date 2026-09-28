package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

@Metadata
/* loaded from: classes3.dex */
public final class NamedDispatcher extends CoroutineDispatcher implements Delay {
    @Override // kotlinx.coroutines.Delay
    public final void A(long j2, CancellableContinuationImpl cancellableContinuationImpl) {
        throw null;
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle b(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void c1(CoroutineContext coroutineContext, Runnable runnable) {
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void l1(CoroutineContext coroutineContext, Runnable runnable) {
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean o1(CoroutineContext coroutineContext) {
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return null;
    }
}
