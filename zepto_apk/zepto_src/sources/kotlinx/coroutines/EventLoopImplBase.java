package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f54101f = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f54102g = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f54103h = AtomicIntegerFieldUpdater.newUpdater(EventLoopImplBase.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    @Metadata
    @SourceDebugExtension
    public final class DelayedResumeTask extends DelayedTask {

        /* renamed from: c, reason: collision with root package name */
        public final CancellableContinuationImpl f54104c;

        public DelayedResumeTask(long j2, CancellableContinuationImpl cancellableContinuationImpl) {
            super(j2);
            this.f54104c = cancellableContinuationImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f54104c.B(EventLoopImplBase.this, Unit.f53572a);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public final String toString() {
            return super.toString() + this.f54104c;
        }
    }

    @Metadata
    public static final class DelayedRunnableTask extends DelayedTask {

        /* renamed from: c, reason: collision with root package name */
        public final Runnable f54106c;

        public DelayedRunnableTask(long j2, Runnable runnable) {
            super(j2);
            this.f54106c = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f54106c.run();
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public final String toString() {
            return super.toString() + this.f54106c;
        }
    }

    @Metadata
    @SourceDebugExtension
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {

        @Nullable
        private volatile Object _heap;

        /* renamed from: a, reason: collision with root package name */
        public long f54107a;

        /* renamed from: b, reason: collision with root package name */
        public int f54108b = -1;

        public DelayedTask(long j2) {
            this.f54107a = j2;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public final void a(ThreadSafeHeap threadSafeHeap) {
            if (this._heap == EventLoop_commonKt.f54110a) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            this._heap = threadSafeHeap;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public final void c(int i2) {
            this.f54108b = i2;
        }

        @Override // java.lang.Comparable
        public final int compareTo(DelayedTask delayedTask) {
            long j2 = this.f54107a - delayedTask.f54107a;
            if (j2 > 0) {
                return 1;
            }
            return j2 < 0 ? -1 : 0;
        }

        public final int d(long j2, DelayedTaskQueue delayedTaskQueue, EventLoopImplBase eventLoopImplBase) {
            synchronized (this) {
                if (this._heap == EventLoop_commonKt.f54110a) {
                    return 2;
                }
                synchronized (delayedTaskQueue) {
                    try {
                        ThreadSafeHeapNode[] threadSafeHeapNodeArr = delayedTaskQueue.f55114a;
                        DelayedTask delayedTask = (DelayedTask) (threadSafeHeapNodeArr != null ? threadSafeHeapNodeArr[0] : null);
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = EventLoopImplBase.f54101f;
                        eventLoopImplBase.getClass();
                        if (EventLoopImplBase.f54103h.get(eventLoopImplBase) != 0) {
                            return 1;
                        }
                        if (delayedTask == null) {
                            delayedTaskQueue.f54109c = j2;
                        } else {
                            long j3 = delayedTask.f54107a;
                            if (j3 - j2 < 0) {
                                j2 = j3;
                            }
                            if (j2 - delayedTaskQueue.f54109c > 0) {
                                delayedTaskQueue.f54109c = j2;
                            }
                        }
                        long j4 = this.f54107a;
                        long j5 = delayedTaskQueue.f54109c;
                        if (j4 - j5 < 0) {
                            this.f54107a = j5;
                        }
                        delayedTaskQueue.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    Symbol symbol = EventLoop_commonKt.f54110a;
                    if (obj == symbol) {
                        return;
                    }
                    DelayedTaskQueue delayedTaskQueue = obj instanceof DelayedTaskQueue ? (DelayedTaskQueue) obj : null;
                    if (delayedTaskQueue != null) {
                        synchronized (delayedTaskQueue) {
                            Object obj2 = this._heap;
                            if ((obj2 instanceof ThreadSafeHeap ? (ThreadSafeHeap) obj2 : null) != null) {
                                delayedTaskQueue.b(this.f54108b);
                            }
                        }
                    }
                    this._heap = symbol;
                    Unit unit = Unit.f53572a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public String toString() {
            return "Delayed[nanos=" + this.f54107a + ']';
        }
    }

    @Metadata
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {

        /* renamed from: c, reason: collision with root package name */
        public long f54109c;
    }

    @Override // kotlinx.coroutines.Delay
    public final void A(long j2, CancellableContinuationImpl cancellableContinuationImpl) {
        long jA = EventLoop_commonKt.a(j2);
        if (jA < 4611686018427387903L) {
            long jNanoTime = System.nanoTime();
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(jA + jNanoTime, cancellableContinuationImpl);
            c2(jNanoTime, delayedResumeTask);
            CancellableContinuationKt.a(cancellableContinuationImpl, delayedResumeTask);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        r7 = null;
     */
    @Override // kotlinx.coroutines.EventLoop
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long U1() {
        /*
            r10 = this;
            boolean r0 = r10.V1()
            r1 = 0
            if (r0 == 0) goto La
            goto Lb3
        La:
            r10.Z1()
        Ld:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.EventLoopImplBase.f54101f
            java.lang.Object r3 = r0.get(r10)
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.EventLoop_commonKt.f54111b
            r5 = 0
            if (r3 != 0) goto L1a
        L18:
            r7 = r5
            goto L4a
        L1a:
            boolean r6 = r3 instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore
            if (r6 == 0) goto L3e
            r6 = r3
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r6 = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) r6
            java.lang.Object r7 = r6.d()
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.f55093g
            if (r7 == r8) goto L2c
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            goto L4a
        L2c:
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r6 = r6.c()
        L30:
            boolean r4 = r0.compareAndSet(r10, r3, r6)
            if (r4 == 0) goto L37
            goto Ld
        L37:
            java.lang.Object r4 = r0.get(r10)
            if (r4 == r3) goto L30
            goto Ld
        L3e:
            if (r3 != r4) goto L41
            goto L18
        L41:
            boolean r6 = r0.compareAndSet(r10, r3, r5)
            if (r6 == 0) goto Lb9
            r7 = r3
            java.lang.Runnable r7 = (java.lang.Runnable) r7
        L4a:
            if (r7 == 0) goto L50
            r7.run()
            return r1
        L50:
            kotlin.collections.ArrayDeque r3 = r10.f54100d
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r3 != 0) goto L5b
        L59:
            r8 = r6
            goto L63
        L5b:
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L62
            goto L59
        L62:
            r8 = r1
        L63:
            int r3 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r3 != 0) goto L68
            goto Lb3
        L68:
            java.lang.Object r0 = r0.get(r10)
            if (r0 == 0) goto L90
            boolean r3 = r0 instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore
            if (r3 == 0) goto L8d
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.f55092f
            long r3 = r3.get(r0)
            r8 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r8 = r8 & r3
            int r0 = (int) r8
            r8 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r3 = r3 & r8
            r8 = 30
            long r3 = r3 >> r8
            int r3 = (int) r3
            if (r0 != r3) goto L8c
            goto L90
        L8c:
            return r1
        L8d:
            if (r0 != r4) goto Lb3
            goto Lb8
        L90:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.EventLoopImplBase.f54102g
            java.lang.Object r0 = r0.get(r10)
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
            if (r0 == 0) goto Lb8
            monitor-enter(r0)
            kotlinx.coroutines.internal.ThreadSafeHeapNode[] r3 = r0.f55114a     // Catch: java.lang.Throwable -> Lb5
            if (r3 == 0) goto La2
            r4 = 0
            r5 = r3[r4]     // Catch: java.lang.Throwable -> Lb5
        La2:
            monitor-exit(r0)
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r5 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r5
            if (r5 != 0) goto La8
            goto Lb8
        La8:
            long r3 = r5.f54107a
            long r5 = java.lang.System.nanoTime()
            long r3 = r3 - r5
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto Lb4
        Lb3:
            return r1
        Lb4:
            return r3
        Lb5:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        Lb8:
            return r6
        Lb9:
            java.lang.Object r6 = r0.get(r10)
            if (r6 == r3) goto L41
            goto Ld
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.U1():long");
    }

    public void Y1(Runnable runnable) {
        Z1();
        if (!a2(runnable)) {
            DefaultExecutor.f54084i.Y1(runnable);
            return;
        }
        Thread threadW1 = W1();
        if (Thread.currentThread() != threadW1) {
            LockSupport.unpark(threadW1);
        }
    }

    public final void Z1() {
        ThreadSafeHeapNode threadSafeHeapNodeB;
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) f54102g.get(this);
        if (delayedTaskQueue == null || ThreadSafeHeap.f55113b.get(delayedTaskQueue) == 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        do {
            synchronized (delayedTaskQueue) {
                try {
                    ThreadSafeHeapNode[] threadSafeHeapNodeArr = delayedTaskQueue.f55114a;
                    ThreadSafeHeapNode threadSafeHeapNode = threadSafeHeapNodeArr != null ? threadSafeHeapNodeArr[0] : null;
                    if (threadSafeHeapNode != null) {
                        DelayedTask delayedTask = (DelayedTask) threadSafeHeapNode;
                        threadSafeHeapNodeB = ((jNanoTime - delayedTask.f54107a) > 0L ? 1 : ((jNanoTime - delayedTask.f54107a) == 0L ? 0 : -1)) >= 0 ? a2(delayedTask) : false ? delayedTaskQueue.b(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (((DelayedTask) threadSafeHeapNodeB) != null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0050, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a2(java.lang.Runnable r7) {
        /*
            r6 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.EventLoopImplBase.f54101f
            java.lang.Object r1 = r0.get(r6)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = kotlinx.coroutines.EventLoopImplBase.f54103h
            int r2 = r2.get(r6)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L12
            r2 = r4
            goto L13
        L12:
            r2 = r3
        L13:
            if (r2 == 0) goto L16
            goto L50
        L16:
            if (r1 != 0) goto L27
        L18:
            r1 = 0
            boolean r1 = r0.compareAndSet(r6, r1, r7)
            if (r1 == 0) goto L20
            goto L67
        L20:
            java.lang.Object r1 = r0.get(r6)
            if (r1 == 0) goto L18
            goto L0
        L27:
            boolean r2 = r1 instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore
            if (r2 == 0) goto L4c
            r2 = r1
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r2 = (kotlinx.coroutines.internal.LockFreeTaskQueueCore) r2
            int r5 = r2.a(r7)
            if (r5 == 0) goto L67
            if (r5 == r4) goto L3a
            r0 = 2
            if (r5 == r0) goto L50
            goto L0
        L3a:
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r2 = r2.c()
        L3e:
            boolean r3 = r0.compareAndSet(r6, r1, r2)
            if (r3 == 0) goto L45
            goto L0
        L45:
            java.lang.Object r3 = r0.get(r6)
            if (r3 == r1) goto L3e
            goto L0
        L4c:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.EventLoop_commonKt.f54111b
            if (r1 != r2) goto L51
        L50:
            return r3
        L51:
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r2 = new kotlinx.coroutines.internal.LockFreeTaskQueueCore
            r3 = 8
            r2.<init>(r3, r4)
            r3 = r1
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r2.a(r3)
            r2.a(r7)
        L61:
            boolean r3 = r0.compareAndSet(r6, r1, r2)
            if (r3 == 0) goto L68
        L67:
            return r4
        L68:
            java.lang.Object r3 = r0.get(r6)
            if (r3 == r1) goto L61
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.a2(java.lang.Runnable):boolean");
    }

    public DisposableHandle b(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.a(j2, runnable, coroutineContext);
    }

    public final boolean b2() {
        DelayedTaskQueue delayedTaskQueue;
        ArrayDeque arrayDeque = this.f54100d;
        if (!(arrayDeque != null ? arrayDeque.isEmpty() : true) || ((delayedTaskQueue = (DelayedTaskQueue) f54102g.get(this)) != null && ThreadSafeHeap.f55113b.get(delayedTaskQueue) != 0)) {
            return false;
        }
        Object obj = f54101f.get(this);
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                long j2 = LockFreeTaskQueueCore.f55092f.get((LockFreeTaskQueueCore) obj);
                return ((int) (1073741823 & j2)) == ((int) ((j2 & 1152921503533105152L) >> 30));
            }
            if (obj != EventLoop_commonKt.f54111b) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void c1(CoroutineContext coroutineContext, Runnable runnable) {
        Y1(runnable);
    }

    public final void c2(long j2, DelayedTask delayedTask) {
        int iD;
        Thread threadW1;
        boolean z = f54103h.get(this) != 0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54102g;
        if (z) {
            iD = 1;
        } else {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) atomicReferenceFieldUpdater.get(this);
            if (delayedTaskQueue == null) {
                DelayedTaskQueue delayedTaskQueue2 = new DelayedTaskQueue();
                delayedTaskQueue2.f54109c = j2;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, delayedTaskQueue2) && atomicReferenceFieldUpdater.get(this) == null) {
                }
                Object obj = atomicReferenceFieldUpdater.get(this);
                Intrinsics.c(obj);
                delayedTaskQueue = (DelayedTaskQueue) obj;
            }
            iD = delayedTask.d(j2, delayedTaskQueue, this);
        }
        if (iD != 0) {
            if (iD == 1) {
                X1(j2, delayedTask);
                return;
            } else {
                if (iD != 2) {
                    throw new IllegalStateException("unexpected result");
                }
                return;
            }
        }
        DelayedTaskQueue delayedTaskQueue3 = (DelayedTaskQueue) atomicReferenceFieldUpdater.get(this);
        if (delayedTaskQueue3 != null) {
            synchronized (delayedTaskQueue3) {
                ThreadSafeHeapNode[] threadSafeHeapNodeArr = delayedTaskQueue3.f55114a;
                threadSafeHeapNode = threadSafeHeapNodeArr != null ? threadSafeHeapNodeArr[0] : null;
            }
            threadSafeHeapNode = (DelayedTask) threadSafeHeapNode;
        }
        if (threadSafeHeapNode != delayedTask || Thread.currentThread() == (threadW1 = W1())) {
            return;
        }
        LockSupport.unpark(threadW1);
    }

    @Override // kotlinx.coroutines.EventLoop
    public void shutdown() {
        ThreadSafeHeapNode threadSafeHeapNodeB;
        ThreadLocalEventLoop.f54160a.set(null);
        f54103h.set(this, 1);
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54101f;
            Object obj = atomicReferenceFieldUpdater.get(this);
            Symbol symbol = EventLoop_commonKt.f54111b;
            if (obj != null) {
                if (!(obj instanceof LockFreeTaskQueueCore)) {
                    if (obj != symbol) {
                        LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                        lockFreeTaskQueueCore.a((Runnable) obj);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((LockFreeTaskQueueCore) obj).b();
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, symbol)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                    break;
                }
            }
            break loop0;
        }
        while (U1() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) f54102g.get(this);
            if (delayedTaskQueue == null) {
                return;
            }
            synchronized (delayedTaskQueue) {
                threadSafeHeapNodeB = ThreadSafeHeap.f55113b.get(delayedTaskQueue) > 0 ? delayedTaskQueue.b(0) : null;
            }
            DelayedTask delayedTask = (DelayedTask) threadSafeHeapNodeB;
            if (delayedTask == null) {
                return;
            } else {
                X1(jNanoTime, delayedTask);
            }
        }
    }
}
