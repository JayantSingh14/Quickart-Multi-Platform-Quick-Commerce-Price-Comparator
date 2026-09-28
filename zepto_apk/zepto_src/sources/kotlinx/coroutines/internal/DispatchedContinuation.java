package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ThreadLocalEventLoop;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f55068h = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* renamed from: d, reason: collision with root package name */
    public final CoroutineDispatcher f55069d;

    /* renamed from: e, reason: collision with root package name */
    public final ContinuationImpl f55070e;

    /* renamed from: f, reason: collision with root package name */
    public Object f55071f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f55072g;

    public DispatchedContinuation(CoroutineDispatcher coroutineDispatcher, ContinuationImpl continuationImpl) {
        super(-1);
        this.f55069d = coroutineDispatcher;
        this.f55070e = continuationImpl;
        this.f55071f = DispatchedContinuationKt.f55073a;
        this.f55072g = ThreadContextKt.b(continuationImpl.getContext());
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation c() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        ContinuationImpl continuationImpl = this.f55070e;
        if (continuationImpl != null) {
            return continuationImpl;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f55070e.getContext();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Object h() {
        Object obj = this.f55071f;
        this.f55071f = DispatchedContinuationKt.f55073a;
        return obj;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Throwable thA = Result.a(obj);
        Object completedExceptionally = thA == null ? obj : new CompletedExceptionally(false, thA);
        ContinuationImpl continuationImpl = this.f55070e;
        CoroutineContext context = continuationImpl.getContext();
        CoroutineDispatcher coroutineDispatcher = this.f55069d;
        if (coroutineDispatcher.o1(context)) {
            this.f55071f = completedExceptionally;
            this.f54090c = 0;
            coroutineDispatcher.c1(continuationImpl.getContext(), this);
            return;
        }
        EventLoop eventLoopA = ThreadLocalEventLoop.a();
        if (eventLoopA.f54098b >= 4294967296L) {
            this.f55071f = completedExceptionally;
            this.f54090c = 0;
            eventLoopA.S1(this);
            return;
        }
        eventLoopA.T1(true);
        try {
            CoroutineContext context2 = continuationImpl.getContext();
            Object objC = ThreadContextKt.c(context2, this.f55072g);
            try {
                continuationImpl.resumeWith(obj);
                Unit unit = Unit.f53572a;
                while (eventLoopA.V1()) {
                }
            } finally {
                ThreadContextKt.a(context2, objC);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f55069d + ", " + DebugStringsKt.b(this.f55070e) + ']';
    }
}
