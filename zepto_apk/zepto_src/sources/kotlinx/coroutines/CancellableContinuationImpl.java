package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;

@Metadata
@PublishedApi
@SourceDebugExtension
/* loaded from: classes.dex */
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame, Waiter {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f54058f = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decisionAndIndex$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f54059g = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f54060h = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: d, reason: collision with root package name */
    public final Continuation f54061d;

    /* renamed from: e, reason: collision with root package name */
    public final CoroutineContext f54062e;

    public CancellableContinuationImpl(int i2, Continuation continuation) {
        super(i2);
        this.f54061d = continuation;
        this.f54062e = continuation.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = Active.f54037a;
    }

    public static Object C(NotCompleted notCompleted, Object obj, int i2, Function3 function3) {
        if (obj instanceof CompletedExceptionally) {
            return obj;
        }
        if (i2 != 1 && i2 != 2) {
            return obj;
        }
        if (function3 != null || (notCompleted instanceof CancelHandler)) {
            return new CompletedContinuation(obj, notCompleted instanceof CancelHandler ? (CancelHandler) notCompleted : null, function3, (CancellationException) null, 16);
        }
        return obj;
    }

    public static void x(NotCompleted notCompleted, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + notCompleted + ", already has " + obj).toString());
    }

    public final void A(Object obj, int i2, Function3 function3) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54059g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof NotCompleted) {
                Object objC = C((NotCompleted) obj2, obj, i2, function3);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objC)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!w()) {
                    m();
                }
                o(i2);
                return;
            }
            if (obj2 instanceof CancelledContinuation) {
                CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                cancelledContinuation.getClass();
                if (CancelledContinuation.f54064c.compareAndSet(cancelledContinuation, 0, 1)) {
                    if (function3 != null) {
                        j(function3, cancelledContinuation.f54073a, obj);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
        }
    }

    public final void B(CoroutineDispatcher coroutineDispatcher, Object obj) {
        Continuation continuation = this.f54061d;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        A(obj, (dispatchedContinuation != null ? dispatchedContinuation.f55069d : null) == coroutineDispatcher ? 4 : this.f54090c, null);
    }

    public final Symbol D(Object obj, Function3 function3) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54059g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            boolean z = obj2 instanceof NotCompleted;
            Symbol symbol = CancellableContinuationImplKt.f54063a;
            if (!z) {
                boolean z2 = obj2 instanceof CompletedContinuation;
                return null;
            }
            Object objC = C((NotCompleted) obj2, obj, this.f54090c, function3);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objC)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    break;
                }
            }
            if (!w()) {
                m();
            }
            return symbol;
        }
    }

    @Override // kotlinx.coroutines.Waiter
    public final void a(Segment segment, int i2) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        do {
            atomicIntegerFieldUpdater = f54058f;
            i3 = atomicIntegerFieldUpdater.get(this);
            if ((i3 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, ((i3 >> 29) << 29) + i2));
        v(segment);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final void b(CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54059g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof NotCompleted) {
                throw new IllegalStateException("Not completed");
            }
            if (obj instanceof CompletedExceptionally) {
                return;
            }
            if (!(obj instanceof CompletedContinuation)) {
                cancellationException2 = cancellationException;
                CompletedContinuation completedContinuation = new CompletedContinuation(obj, (CancelHandler) null, (Function3) null, cancellationException2, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, completedContinuation)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            CompletedContinuation completedContinuation2 = (CompletedContinuation) obj;
            if (completedContinuation2.f54071e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            CompletedContinuation completedContinuationA = CompletedContinuation.a(completedContinuation2, null, cancellationException, 15);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, completedContinuationA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    cancellationException2 = cancellationException;
                }
            }
            CancelHandler cancelHandler = completedContinuation2.f54068b;
            if (cancelHandler != null) {
                i(cancelHandler, cancellationException);
            }
            Function3 function3 = completedContinuation2.f54069c;
            if (function3 != null) {
                j(function3, cancellationException, completedContinuation2.f54067a);
                return;
            }
            return;
            cancellationException = cancellationException2;
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation c() {
        return this.f54061d;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Throwable d(Object obj) {
        Throwable thD = super.d(obj);
        if (thD != null) {
            return thD;
        }
        return null;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Object e(Object obj) {
        return obj instanceof CompletedContinuation ? ((CompletedContinuation) obj).f54067a : obj;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final Symbol f(Object obj, Function3 function3) {
        return D(obj, function3);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.f54061d;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f54062e;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Object h() {
        return f54059g.get(this);
    }

    public final void i(CancelHandler cancelHandler, Throwable th) {
        try {
            cancelHandler.b(th);
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.a(this.f54062e, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void j(Function3 function3, Throwable th, Object obj) {
        CoroutineContext coroutineContext = this.f54062e;
        try {
            function3.invoke(th, obj, coroutineContext);
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.a(coroutineContext, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void k(Segment segment, Throwable th) {
        CoroutineContext coroutineContext = this.f54062e;
        int i2 = f54058f.get(this) & 536870911;
        if (i2 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            segment.h(i2, coroutineContext);
        } catch (Throwable th2) {
            CoroutineExceptionHandlerKt.a(coroutineContext, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final boolean l(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54059g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            CancelledContinuation cancelledContinuation = new CancelledContinuation(this, th, (obj instanceof CancelHandler) || (obj instanceof Segment));
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, cancelledContinuation)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            NotCompleted notCompleted = (NotCompleted) obj;
            if (notCompleted instanceof CancelHandler) {
                i((CancelHandler) obj, th);
            } else if (notCompleted instanceof Segment) {
                k((Segment) obj, th);
            }
            if (!w()) {
                m();
            }
            o(this.f54090c);
            return true;
        }
    }

    public final void m() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54060h;
        DisposableHandle disposableHandle = (DisposableHandle) atomicReferenceFieldUpdater.get(this);
        if (disposableHandle == null) {
            return;
        }
        disposableHandle.dispose();
        atomicReferenceFieldUpdater.set(this, NonDisposableHandle.f54155a);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void n(Object obj, Function3 function3) {
        A(obj, this.f54090c, function3);
    }

    public final void o(int i2) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        do {
            atomicIntegerFieldUpdater = f54058f;
            i3 = atomicIntegerFieldUpdater.get(this);
            int i4 = i3 >> 29;
            if (i4 != 0) {
                if (i4 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z = i2 == 4;
                Continuation continuation = this.f54061d;
                if (!z && (continuation instanceof DispatchedContinuation)) {
                    boolean z2 = i2 == 1 || i2 == 2;
                    int i5 = this.f54090c;
                    if (z2 == (i5 == 1 || i5 == 2)) {
                        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
                        CoroutineDispatcher coroutineDispatcher = dispatchedContinuation.f55069d;
                        CoroutineContext context = dispatchedContinuation.f55070e.getContext();
                        if (coroutineDispatcher.o1(context)) {
                            coroutineDispatcher.c1(context, this);
                            return;
                        }
                        EventLoop eventLoopA = ThreadLocalEventLoop.a();
                        if (eventLoopA.f54098b >= 4294967296L) {
                            eventLoopA.S1(this);
                            return;
                        }
                        eventLoopA.T1(true);
                        try {
                            DispatchedTaskKt.a(this, continuation, true);
                            do {
                            } while (eventLoopA.V1());
                        } finally {
                            try {
                                return;
                            } finally {
                            }
                        }
                        return;
                    }
                }
                DispatchedTaskKt.a(this, continuation, z);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, 1073741824 + (536870911 & i3)));
    }

    public Throwable p(JobSupport jobSupport) {
        return jobSupport.O();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public final void q(Object obj) {
        o(this.f54090c);
    }

    public final Object r() throws Throwable {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        boolean zW = w();
        do {
            atomicIntegerFieldUpdater = f54058f;
            i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = i2 >> 29;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zW) {
                    z();
                }
                Object obj = f54059g.get(this);
                if (obj instanceof CompletedExceptionally) {
                    throw ((CompletedExceptionally) obj).f54073a;
                }
                int i4 = this.f54090c;
                if (i4 == 1 || i4 == 2) {
                    Job job = (Job) this.f54062e.get(Job.Key.f54121a);
                    if (job != null && !job.a()) {
                        CancellationException cancellationExceptionO = job.O();
                        b(cancellationExceptionO);
                        throw cancellationExceptionO;
                    }
                }
                return e(obj);
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 536870912 + (536870911 & i2)));
        if (((DisposableHandle) f54060h.get(this)) == null) {
            t();
        }
        if (zW) {
            z();
        }
        return CoroutineSingletons.f53689a;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Throwable thA = Result.a(obj);
        if (thA != null) {
            obj = new CompletedExceptionally(false, thA);
        }
        A(obj, this.f54090c, null);
    }

    public final void s() {
        DisposableHandle disposableHandleT = t();
        if (disposableHandleT == null || (f54059g.get(this) instanceof NotCompleted)) {
            return;
        }
        disposableHandleT.dispose();
        f54060h.set(this, NonDisposableHandle.f54155a);
    }

    public final DisposableHandle t() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Job job = (Job) this.f54062e.get(Job.Key.f54121a);
        if (job == null) {
            return null;
        }
        DisposableHandle disposableHandleF = JobKt.f(job, new ChildContinuation(this));
        do {
            atomicReferenceFieldUpdater = f54060h;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, disposableHandleF)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return disposableHandleF;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(y());
        sb.append('(');
        sb.append(DebugStringsKt.b(this.f54061d));
        sb.append("){");
        Object obj = f54059g.get(this);
        sb.append(obj instanceof NotCompleted ? "Active" : obj instanceof CancelledContinuation ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(DebugStringsKt.a(this));
        return sb.toString();
    }

    public final void u(Function1 function1) {
        v(new CancelHandler.UserSupplied(function1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b7, code lost:
    
        x(r8, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ba, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(kotlinx.coroutines.NotCompleted r8) {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.CancellableContinuationImpl.f54059g
            java.lang.Object r2 = r0.get(r7)
            boolean r1 = r2 instanceof kotlinx.coroutines.Active
            if (r1 == 0) goto L19
        La:
            boolean r1 = r0.compareAndSet(r7, r2, r8)
            if (r1 == 0) goto L12
            goto Lae
        L12:
            java.lang.Object r1 = r0.get(r7)
            if (r1 == r2) goto La
            goto L0
        L19:
            boolean r1 = r2 instanceof kotlinx.coroutines.CancelHandler
            r3 = 0
            if (r1 != 0) goto Lb7
            boolean r1 = r2 instanceof kotlinx.coroutines.internal.Segment
            if (r1 != 0) goto Lb7
            boolean r1 = r2 instanceof kotlinx.coroutines.CompletedExceptionally
            if (r1 == 0) goto L5b
            r0 = r2
            kotlinx.coroutines.CompletedExceptionally r0 = (kotlinx.coroutines.CompletedExceptionally) r0
            r0.getClass()
            r1 = 1
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r4 = kotlinx.coroutines.CompletedExceptionally.f54072b
            r5 = 0
            boolean r1 = r4.compareAndSet(r0, r5, r1)
            if (r1 == 0) goto L57
            boolean r1 = r2 instanceof kotlinx.coroutines.CancelledContinuation
            if (r1 == 0) goto Lae
            if (r2 == 0) goto L3d
            goto L3e
        L3d:
            r0 = r3
        L3e:
            if (r0 == 0) goto L42
            java.lang.Throwable r3 = r0.f54073a
        L42:
            boolean r0 = r8 instanceof kotlinx.coroutines.CancelHandler
            if (r0 == 0) goto L4c
            kotlinx.coroutines.CancelHandler r8 = (kotlinx.coroutines.CancelHandler) r8
            r7.i(r8, r3)
            return
        L4c:
            java.lang.String r0 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>"
            kotlin.jvm.internal.Intrinsics.d(r8, r0)
            kotlinx.coroutines.internal.Segment r8 = (kotlinx.coroutines.internal.Segment) r8
            r7.k(r8, r3)
            return
        L57:
            x(r8, r2)
            throw r3
        L5b:
            boolean r1 = r2 instanceof kotlinx.coroutines.CompletedContinuation
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler"
            if (r1 == 0) goto L94
            r1 = r2
            kotlinx.coroutines.CompletedContinuation r1 = (kotlinx.coroutines.CompletedContinuation) r1
            kotlinx.coroutines.CancelHandler r5 = r1.f54068b
            if (r5 != 0) goto L90
            boolean r5 = r8 instanceof kotlinx.coroutines.internal.Segment
            if (r5 == 0) goto L6d
            return
        L6d:
            kotlin.jvm.internal.Intrinsics.d(r8, r4)
            r4 = r8
            kotlinx.coroutines.CancelHandler r4 = (kotlinx.coroutines.CancelHandler) r4
            java.lang.Throwable r5 = r1.f54071e
            if (r5 == 0) goto L7b
            r7.i(r4, r5)
            return
        L7b:
            r5 = 29
            kotlinx.coroutines.CompletedContinuation r1 = kotlinx.coroutines.CompletedContinuation.a(r1, r4, r3, r5)
        L81:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto L88
            goto Lae
        L88:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto L81
            goto L0
        L90:
            x(r8, r2)
            throw r3
        L94:
            boolean r1 = r8 instanceof kotlinx.coroutines.internal.Segment
            if (r1 == 0) goto L99
            return
        L99:
            kotlin.jvm.internal.Intrinsics.d(r8, r4)
            r3 = r8
            kotlinx.coroutines.CancelHandler r3 = (kotlinx.coroutines.CancelHandler) r3
            kotlinx.coroutines.CompletedContinuation r1 = new kotlinx.coroutines.CompletedContinuation
            r4 = 0
            r5 = 0
            r6 = 28
            r1.<init>(r2, r3, r4, r5, r6)
        La8:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto Laf
        Lae:
            return
        Laf:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto La8
            goto L0
        Lb7:
            x(r8, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CancellableContinuationImpl.v(kotlinx.coroutines.NotCompleted):void");
    }

    public final boolean w() {
        if (this.f54090c != 2) {
            return false;
        }
        Continuation continuation = this.f54061d;
        Intrinsics.d(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return DispatchedContinuation.f55068h.get((DispatchedContinuation) continuation) != null;
    }

    public String y() {
        return "CancellableContinuation";
    }

    public final void z() {
        Continuation continuation = this.f54061d;
        Throwable th = null;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        if (dispatchedContinuation != null) {
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = DispatchedContinuation.f55068h;
                Object obj = atomicReferenceFieldUpdater.get(dispatchedContinuation);
                Symbol symbol = DispatchedContinuationKt.f55074b;
                if (obj == symbol) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, symbol, this)) {
                        if (atomicReferenceFieldUpdater.get(dispatchedContinuation) != symbol) {
                            break;
                        }
                    }
                    break loop0;
                } else {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(dispatchedContinuation, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(dispatchedContinuation) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = (Throwable) obj;
                }
            }
            if (th == null) {
                return;
            }
            m();
            l(th);
        }
    }
}
