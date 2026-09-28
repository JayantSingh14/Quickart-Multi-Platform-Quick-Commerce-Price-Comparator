package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata
/* loaded from: classes.dex */
final class ChildContinuation extends JobNode {

    /* renamed from: e, reason: collision with root package name */
    public final CancellableContinuationImpl f54065e;

    public ChildContinuation(CancellableContinuationImpl cancellableContinuationImpl) {
        this.f54065e = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.JobNode
    public final boolean l() {
        return true;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void m(Throwable th) {
        JobSupport jobSupportK = k();
        CancellableContinuationImpl cancellableContinuationImpl = this.f54065e;
        Throwable thP = cancellableContinuationImpl.p(jobSupportK);
        if (cancellableContinuationImpl.w()) {
            Continuation continuation = cancellableContinuationImpl.f54061d;
            Intrinsics.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation.f55068h;
                Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuation);
                Symbol symbol = DispatchedContinuationKt.f55074b;
                if (!Intrinsics.b(obj, symbol)) {
                    if (!(obj instanceof Throwable)) {
                        while (!atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, obj, null)) {
                            if (atomicReferenceFieldUpdater.get(dispatchedContinuation) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    return;
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, symbol, thP)) {
                    if (atomicReferenceFieldUpdater.get(dispatchedContinuation) != symbol) {
                        break;
                    }
                }
                return;
            }
        }
        cancellableContinuationImpl.l(thP);
        if (cancellableContinuationImpl.w()) {
            return;
        }
        cancellableContinuationImpl.m();
    }
}
