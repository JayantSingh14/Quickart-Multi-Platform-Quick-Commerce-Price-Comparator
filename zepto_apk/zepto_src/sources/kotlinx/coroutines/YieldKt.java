package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;

@Metadata
/* loaded from: classes.dex */
public final class YieldKt {
    public static final Object a(ContinuationImpl frame) {
        Object obj;
        CoroutineContext context = frame.getContext();
        JobKt.d(context);
        Continuation continuationB = IntrinsicsKt.b(frame);
        DispatchedContinuation dispatchedContinuation = continuationB instanceof DispatchedContinuation ? (DispatchedContinuation) continuationB : null;
        if (dispatchedContinuation == null) {
            obj = Unit.f53572a;
        } else {
            CoroutineDispatcher coroutineDispatcher = dispatchedContinuation.f55069d;
            if (coroutineDispatcher.o1(context)) {
                dispatchedContinuation.f55071f = Unit.f53572a;
                dispatchedContinuation.f54090c = 1;
                coroutineDispatcher.l1(context, dispatchedContinuation);
            } else {
                YieldContext yieldContext = new YieldContext();
                CoroutineContext coroutineContextPlus = context.plus(yieldContext);
                Unit unit = Unit.f53572a;
                dispatchedContinuation.f55071f = unit;
                dispatchedContinuation.f54090c = 1;
                coroutineDispatcher.l1(coroutineContextPlus, dispatchedContinuation);
                if (yieldContext.f54174a) {
                    EventLoop eventLoopA = ThreadLocalEventLoop.a();
                    ArrayDeque arrayDeque = eventLoopA.f54100d;
                    if (arrayDeque != null ? arrayDeque.isEmpty() : true) {
                        obj = Unit.f53572a;
                    } else {
                        if (eventLoopA.f54098b >= 4294967296L) {
                            dispatchedContinuation.f55071f = unit;
                            dispatchedContinuation.f54090c = 1;
                            eventLoopA.S1(dispatchedContinuation);
                            obj = CoroutineSingletons.f53689a;
                        } else {
                            eventLoopA.T1(true);
                            try {
                                dispatchedContinuation.run();
                                do {
                                } while (eventLoopA.V1());
                            } finally {
                                try {
                                } finally {
                                }
                            }
                            obj = Unit.f53572a;
                        }
                    }
                }
            }
            obj = CoroutineSingletons.f53689a;
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (obj == coroutineSingletons) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return obj == coroutineSingletons ? obj : Unit.f53572a;
    }
}
