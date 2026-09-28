package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DispatchedTaskKt {
    public static final void a(CancellableContinuationImpl cancellableContinuationImpl, Continuation continuation, boolean z) {
        Object objE;
        Object obj = CancellableContinuationImpl.f54059g.get(cancellableContinuationImpl);
        Throwable thD = cancellableContinuationImpl.d(obj);
        if (thD != null) {
            Result.Companion companion = Result.f53538b;
            objE = ResultKt.a(thD);
        } else {
            Result.Companion companion2 = Result.f53538b;
            objE = cancellableContinuationImpl.e(obj);
        }
        if (!z) {
            continuation.resumeWith(objE);
            return;
        }
        Intrinsics.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        ContinuationImpl continuationImpl = dispatchedContinuation.f55070e;
        CoroutineContext context = continuationImpl.getContext();
        Object objC = ThreadContextKt.c(context, dispatchedContinuation.f55072g);
        UndispatchedCoroutine undispatchedCoroutineC = objC != ThreadContextKt.f55109a ? CoroutineContextKt.c(continuationImpl, context, objC) : null;
        try {
            continuationImpl.resumeWith(objE);
            Unit unit = Unit.f53572a;
            if (undispatchedCoroutineC == null || undispatchedCoroutineC.B0()) {
                ThreadContextKt.a(context, objC);
            }
        } catch (Throwable th) {
            if (undispatchedCoroutineC == null || undispatchedCoroutineC.B0()) {
                ThreadContextKt.a(context, objC);
            }
            throw th;
        }
    }
}
