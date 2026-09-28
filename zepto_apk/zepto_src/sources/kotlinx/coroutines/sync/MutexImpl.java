package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstanceInternal;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class MutexImpl extends SemaphoreAndMutexImpl implements Mutex {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f55229h = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner$volatile");
    private volatile /* synthetic */ Object owner$volatile;

    @Metadata
    @SourceDebugExtension
    public final class CancellableContinuationWithOwner implements CancellableContinuation<Unit>, Waiter {

        /* renamed from: a, reason: collision with root package name */
        public final CancellableContinuationImpl f55230a;

        public CancellableContinuationWithOwner(CancellableContinuationImpl cancellableContinuationImpl) {
            this.f55230a = cancellableContinuationImpl;
        }

        @Override // kotlinx.coroutines.Waiter
        public final void a(Segment segment, int i2) {
            this.f55230a.a(segment, i2);
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final Symbol f(Object obj, Function3 function3) {
            final MutexImpl mutexImpl = MutexImpl.this;
            Function3 function32 = new Function3() { // from class: kotlinx.coroutines.sync.a
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl.f55229h;
                    this.getClass();
                    MutexImpl mutexImpl2 = mutexImpl;
                    atomicReferenceFieldUpdater.set(mutexImpl2, null);
                    mutexImpl2.b(null);
                    return Unit.f53572a;
                }
            };
            Symbol symbolD = this.f55230a.D((Unit) obj, function32);
            if (symbolD != null) {
                MutexImpl.f55229h.set(mutexImpl, null);
            }
            return symbolD;
        }

        @Override // kotlin.coroutines.Continuation
        public final CoroutineContext getContext() {
            return this.f55230a.f54062e;
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final void n(Object obj, Function3 function3) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = MutexImpl.f55229h;
            MutexImpl mutexImpl = MutexImpl.this;
            atomicReferenceFieldUpdater.set(mutexImpl, null);
            final b bVar = new b(mutexImpl, this);
            CancellableContinuationImpl cancellableContinuationImpl = this.f55230a;
            cancellableContinuationImpl.A((Unit) obj, cancellableContinuationImpl.f54090c, new Function3() { // from class: kotlinx.coroutines.a
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = CancellableContinuationImpl.f54058f;
                    bVar.invoke((Throwable) obj2);
                    return Unit.f53572a;
                }
            });
        }

        @Override // kotlinx.coroutines.CancellableContinuation
        public final void q(Object obj) {
            this.f55230a.q(obj);
        }

        @Override // kotlin.coroutines.Continuation
        public final void resumeWith(Object obj) {
            this.f55230a.resumeWith(obj);
        }
    }

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public final class SelectInstanceWithOwner<Q> implements SelectInstanceInternal<Q> {

        /* renamed from: a, reason: collision with root package name */
        public final SelectInstanceInternal f55232a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f55233b;

        public SelectInstanceWithOwner(SelectInstanceInternal selectInstanceInternal, Object obj) {
            this.f55232a = selectInstanceInternal;
            this.f55233b = obj;
        }

        @Override // kotlinx.coroutines.Waiter
        public final void a(Segment segment, int i2) {
            this.f55232a.a(segment, i2);
        }

        @Override // kotlinx.coroutines.selects.SelectInstance
        public final void c(Object obj) {
            MutexImpl.f55229h.set(MutexImpl.this, this.f55233b);
            this.f55232a.c(obj);
        }

        @Override // kotlinx.coroutines.selects.SelectInstance
        public final void d(DisposableHandle disposableHandle) {
            this.f55232a.d(disposableHandle);
        }

        @Override // kotlinx.coroutines.selects.SelectInstance
        public final boolean e(Object obj, Object obj2) {
            boolean zE = this.f55232a.e(obj, obj2);
            if (zE) {
                MutexImpl.f55229h.set(MutexImpl.this, this.f55233b);
            }
            return zE;
        }

        @Override // kotlinx.coroutines.selects.SelectInstance
        public final CoroutineContext getContext() {
            return this.f55232a.getContext();
        }
    }

    public MutexImpl(boolean z) {
        super(1, z ? 1 : 0);
        this.owner$volatile = z ? null : MutexKt.f55235a;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public final void b(Object obj) {
        while (e()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f55229h;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            Symbol symbol = MutexKt.f55235a;
            if (obj2 != symbol) {
                if (obj2 == obj || obj == null) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, symbol)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            break;
                        }
                    }
                    release();
                    return;
                }
                throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        r1.n(kotlin.Unit.f53572a, r4.f55245b);
     */
    @Override // kotlinx.coroutines.sync.Mutex
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(kotlin.coroutines.jvm.internal.ContinuationImpl r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r4.f()
            if (r0 == 0) goto L9
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        L9:
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r5)
            kotlinx.coroutines.CancellableContinuationImpl r0 = kotlinx.coroutines.CancellableContinuationKt.b(r0)
            kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner r1 = new kotlinx.coroutines.sync.MutexImpl$CancellableContinuationWithOwner     // Catch: java.lang.Throwable -> L48
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L48
        L16:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = kotlinx.coroutines.sync.SemaphoreAndMutexImpl.f55243g     // Catch: java.lang.Throwable -> L48
            int r2 = r2.getAndDecrement(r4)     // Catch: java.lang.Throwable -> L48
            int r3 = r4.f55244a     // Catch: java.lang.Throwable -> L48
            if (r2 > r3) goto L16
            if (r2 <= 0) goto L2a
            kotlin.Unit r2 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L48
            kotlinx.coroutines.sync.c r3 = r4.f55245b     // Catch: java.lang.Throwable -> L48
            r1.n(r2, r3)     // Catch: java.lang.Throwable -> L48
            goto L30
        L2a:
            boolean r2 = r4.d(r1)     // Catch: java.lang.Throwable -> L48
            if (r2 == 0) goto L16
        L30:
            java.lang.Object r0 = r0.r()
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            if (r0 != r1) goto L3d
            java.lang.String r2 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
        L3d:
            if (r0 != r1) goto L40
            goto L42
        L40:
            kotlin.Unit r0 = kotlin.Unit.f53572a
        L42:
            if (r0 != r1) goto L45
            return r0
        L45:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        L48:
            r5 = move-exception
            r0.z()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexImpl.c(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final boolean e() {
        return Math.max(SemaphoreAndMutexImpl.f55243g.get(this), 0) == 0;
    }

    public final boolean f() {
        int i2;
        char c2;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = SemaphoreAndMutexImpl.f55243g;
            int i3 = atomicIntegerFieldUpdater.get(this);
            int i4 = this.f55244a;
            if (i3 > i4) {
                do {
                    i2 = atomicIntegerFieldUpdater.get(this);
                    if (i2 > i4) {
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, i4));
            } else {
                if (i3 <= 0) {
                    c2 = 1;
                    break;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i3, i3 - 1)) {
                    f55229h.set(this, null);
                    c2 = 0;
                    break;
                }
            }
        }
        if (c2 == 0) {
            return true;
        }
        if (c2 == 1) {
            return false;
        }
        if (c2 != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException("This mutex is already locked by the specified owner: null".toString());
    }

    public final String toString() {
        return "Mutex@" + DebugStringsKt.a(this) + "[isLocked=" + e() + ",owner=" + f55229h.get(this) + ']';
    }
}
