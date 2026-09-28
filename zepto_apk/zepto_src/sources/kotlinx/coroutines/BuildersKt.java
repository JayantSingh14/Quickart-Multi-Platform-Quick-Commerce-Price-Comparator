package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata
/* loaded from: classes.dex */
public final class BuildersKt {
    public static Deferred a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, int i2) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f53685a;
        }
        CoroutineStart coroutineStart = CoroutineStart.f54078a;
        CoroutineContext coroutineContextB = CoroutineContextKt.b(coroutineScope, coroutineContext);
        CoroutineStart coroutineStart2 = CoroutineStart.f54078a;
        DeferredCoroutine deferredCoroutine = new DeferredCoroutine(coroutineContextB, true, true);
        deferredCoroutine.A0(coroutineStart, deferredCoroutine, function2);
        return deferredCoroutine;
    }

    public static final Job b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2) {
        CoroutineContext coroutineContextB = CoroutineContextKt.b(coroutineScope, coroutineContext);
        coroutineStart.getClass();
        AbstractCoroutine lazyStandaloneCoroutine = coroutineStart == CoroutineStart.f54079b ? new LazyStandaloneCoroutine(coroutineContextB, function2) : new StandaloneCoroutine(coroutineContextB, true, true);
        lazyStandaloneCoroutine.A0(coroutineStart, lazyStandaloneCoroutine, function2);
        return lazyStandaloneCoroutine;
    }

    public static /* synthetic */ Job c(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Function2 function2, int i2) {
        CoroutineStart coroutineStart = CoroutineStart.f54081d;
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f53685a;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.f54078a;
        }
        return b(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static Object d(Function2 function2) throws Throwable {
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f53685a;
        Thread threadCurrentThread = Thread.currentThread();
        emptyCoroutineContext.get(ContinuationInterceptor.y0);
        GlobalScope globalScope = GlobalScope.f54113a;
        EventLoop eventLoopA = ThreadLocalEventLoop.a();
        emptyCoroutineContext.plus(eventLoopA);
        BlockingCoroutine blockingCoroutine = new BlockingCoroutine(CoroutineContextKt.b(globalScope, eventLoopA), threadCurrentThread, eventLoopA);
        blockingCoroutine.A0(CoroutineStart.f54078a, blockingCoroutine, function2);
        EventLoop eventLoop = blockingCoroutine.f54054e;
        if (eventLoop != null) {
            int i2 = EventLoop.f54097e;
            eventLoop.T1(false);
        }
        while (!Thread.interrupted()) {
            try {
                long jU1 = eventLoop != null ? eventLoop.U1() : Long.MAX_VALUE;
                if (blockingCoroutine.W()) {
                    if (eventLoop != null) {
                        int i3 = EventLoop.f54097e;
                        eventLoop.O1(false);
                    }
                    Object objA = JobSupportKt.a(JobSupport.f54125a.get(blockingCoroutine));
                    CompletedExceptionally completedExceptionally = objA instanceof CompletedExceptionally ? (CompletedExceptionally) objA : null;
                    if (completedExceptionally == null) {
                        return objA;
                    }
                    throw completedExceptionally.f54073a;
                }
                LockSupport.parkNanos(blockingCoroutine, jU1);
            } catch (Throwable th) {
                if (eventLoop != null) {
                    int i4 = EventLoop.f54097e;
                    eventLoop.O1(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        blockingCoroutine.w(interruptedException);
        throw interruptedException;
    }

    public static final Object e(CoroutineContext coroutineContext, Function2 function2, Continuation frame) throws Throwable {
        Object objA;
        CoroutineContext context = frame.getContext();
        CoroutineContext coroutineContextPlus = !((Boolean) coroutineContext.fold(Boolean.FALSE, new kotlin.coroutines.a(1))).booleanValue() ? context.plus(coroutineContext) : CoroutineContextKt.a(context, coroutineContext, false);
        JobKt.d(coroutineContextPlus);
        if (coroutineContextPlus == context) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(frame, coroutineContextPlus);
            objA = UndispatchedKt.a(scopeCoroutine, scopeCoroutine, function2);
        } else {
            ContinuationInterceptor.Key key = ContinuationInterceptor.y0;
            if (Intrinsics.b(coroutineContextPlus.get(key), context.get(key))) {
                UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(frame, coroutineContextPlus);
                CoroutineContext coroutineContext2 = undispatchedCoroutine.f54036c;
                Object objC = ThreadContextKt.c(coroutineContext2, null);
                try {
                    Object objA2 = UndispatchedKt.a(undispatchedCoroutine, undispatchedCoroutine, function2);
                    ThreadContextKt.a(coroutineContext2, objC);
                    objA = objA2;
                } catch (Throwable th) {
                    ThreadContextKt.a(coroutineContext2, objC);
                    throw th;
                }
            } else {
                DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(frame, coroutineContextPlus);
                CancellableKt.b(function2, dispatchedCoroutine, dispatchedCoroutine);
                while (true) {
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = DispatchedCoroutine.f54089e;
                    int i2 = atomicIntegerFieldUpdater.get(dispatchedCoroutine);
                    if (i2 != 0) {
                        if (i2 != 2) {
                            throw new IllegalStateException("Already suspended");
                        }
                        objA = JobSupportKt.a(JobSupport.f54125a.get(dispatchedCoroutine));
                        if (objA instanceof CompletedExceptionally) {
                            throw ((CompletedExceptionally) objA).f54073a;
                        }
                    } else if (atomicIntegerFieldUpdater.compareAndSet(dispatchedCoroutine, 0, 1)) {
                        objA = CoroutineSingletons.f53689a;
                        break;
                    }
                }
            }
        }
        if (objA == CoroutineSingletons.f53689a) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objA;
    }
}
