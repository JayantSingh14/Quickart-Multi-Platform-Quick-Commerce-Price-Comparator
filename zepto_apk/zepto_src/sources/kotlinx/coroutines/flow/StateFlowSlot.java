package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.internal.Symbol;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f54928a = new AtomicReference(null);

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public final boolean a(AbstractSharedFlow abstractSharedFlow) {
        AtomicReference atomicReference = this.f54928a;
        if (atomicReference.get() != null) {
            return false;
        }
        atomicReference.set(StateFlowKt.f54926a);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public final Continuation[] b(AbstractSharedFlow abstractSharedFlow) {
        this.f54928a.set(null);
        return AbstractSharedFlowKt.f54941a;
    }

    public final Object c(Continuation frame) throws Throwable {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
        cancellableContinuationImpl.s();
        AtomicReference atomicReference = this.f54928a;
        Symbol symbol = StateFlowKt.f54926a;
        while (true) {
            if (atomicReference.compareAndSet(symbol, cancellableContinuationImpl)) {
                break;
            }
            if (atomicReference.get() != symbol) {
                Result.Companion companion = Result.f53538b;
                cancellableContinuationImpl.resumeWith(Unit.f53572a);
                break;
            }
        }
        Object objR = cancellableContinuationImpl.r();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (objR == coroutineSingletons) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objR == coroutineSingletons ? objR : Unit.f53572a;
    }
}
