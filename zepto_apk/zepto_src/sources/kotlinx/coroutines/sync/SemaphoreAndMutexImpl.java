package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class SemaphoreAndMutexImpl {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f55239c = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "head$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f55240d = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "deqIdx$volatile");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f55241e = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "tail$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f55242f = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "enqIdx$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f55243g = AtomicIntegerFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "_availablePermits$volatile");
    private volatile /* synthetic */ int _availablePermits$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f55244a;

    /* renamed from: b, reason: collision with root package name */
    public final c f55245b;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private volatile /* synthetic */ Object tail$volatile;

    /* JADX WARN: Type inference failed for: r6v6, types: [kotlinx.coroutines.sync.c] */
    public SemaphoreAndMutexImpl(int i2, int i3) {
        this.f55244a = i2;
        if (i2 <= 0) {
            throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "Semaphore should have at least 1 permit, but had ").toString());
        }
        if (i3 < 0 || i3 > i2) {
            throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "The number of acquired permits should be in 0..").toString());
        }
        SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
        this.head$volatile = semaphoreSegment;
        this.tail$volatile = semaphoreSegment;
        this._availablePermits$volatile = i2 - i3;
        this.f55245b = new Function3() { // from class: kotlinx.coroutines.sync.c
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = SemaphoreAndMutexImpl.f55239c;
                this.f55261a.release();
                return Unit.f53572a;
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        r1.n(kotlin.Unit.f53572a, r4.f55245b);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(kotlin.coroutines.jvm.internal.ContinuationImpl r5) throws java.lang.Throwable {
        /*
            r4 = this;
        L0:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.sync.SemaphoreAndMutexImpl.f55243g
            int r1 = r0.getAndDecrement(r4)
            int r2 = r4.f55244a
            if (r1 > r2) goto L0
            if (r1 <= 0) goto Lf
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        Lf:
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r5)
            kotlinx.coroutines.CancellableContinuationImpl r1 = kotlinx.coroutines.CancellableContinuationKt.b(r1)
            boolean r3 = r4.d(r1)     // Catch: java.lang.Throwable -> L34
            if (r3 != 0) goto L36
        L1d:
            int r3 = r0.getAndDecrement(r4)     // Catch: java.lang.Throwable -> L34
            if (r3 > r2) goto L1d
            if (r3 <= 0) goto L2d
            kotlin.Unit r0 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L34
            kotlinx.coroutines.sync.c r2 = r4.f55245b     // Catch: java.lang.Throwable -> L34
            r1.n(r0, r2)     // Catch: java.lang.Throwable -> L34
            goto L36
        L2d:
            boolean r3 = r4.d(r1)     // Catch: java.lang.Throwable -> L34
            if (r3 == 0) goto L1d
            goto L36
        L34:
            r5 = move-exception
            goto L4e
        L36:
            java.lang.Object r0 = r1.r()
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            if (r0 != r1) goto L43
            java.lang.String r2 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
        L43:
            if (r0 != r1) goto L46
            goto L48
        L46:
            kotlin.Unit r0 = kotlin.Unit.f53572a
        L48:
            if (r0 != r1) goto L4b
            return r0
        L4b:
            kotlin.Unit r5 = kotlin.Unit.f53572a
            return r5
        L4e:
            r1.z()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreAndMutexImpl.a(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final boolean d(Waiter waiter) {
        Object objA;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f55241e;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f55242f.getAndIncrement(this);
        SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1.f55246b;
        long j2 = andIncrement / SemaphoreKt.f55253f;
        loop0: while (true) {
            objA = ConcurrentLinkedListKt.a(semaphoreSegment, j2, semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1);
            if (!SegmentOrClosed.b(objA)) {
                Segment segmentA = SegmentOrClosed.a(objA);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.f55105c >= segmentA.f55105c) {
                        break loop0;
                    }
                    if (!segmentA.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, segment, segmentA)) {
                        if (atomicReferenceFieldUpdater.get(this) != segment) {
                            if (segmentA.f()) {
                                segmentA.e();
                            }
                        }
                    }
                    if (segment.f()) {
                        segment.e();
                    }
                }
            } else {
                break;
            }
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.a(objA);
        int i2 = (int) (andIncrement % SemaphoreKt.f55253f);
        AtomicReferenceArray atomicReferenceArray = semaphoreSegment2.f55256e;
        while (!atomicReferenceArray.compareAndSet(i2, null, waiter)) {
            if (atomicReferenceArray.get(i2) != null) {
                Symbol symbol = SemaphoreKt.f55249b;
                Symbol symbol2 = SemaphoreKt.f55250c;
                while (!atomicReferenceArray.compareAndSet(i2, symbol, symbol2)) {
                    if (atomicReferenceArray.get(i2) != symbol) {
                        return false;
                    }
                }
                if (waiter instanceof CancellableContinuation) {
                    ((CancellableContinuation) waiter).n(Unit.f53572a, this.f55245b);
                    return true;
                }
                if (waiter instanceof SelectInstance) {
                    ((SelectInstance) waiter).c(Unit.f53572a);
                    return true;
                }
                throw new IllegalStateException(("unexpected: " + waiter).toString());
            }
        }
        waiter.a(semaphoreSegment2, i2);
        return true;
    }

    public final void release() {
        int i2;
        Object objA;
        boolean zE;
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f55243g;
            int andIncrement = atomicIntegerFieldUpdater.getAndIncrement(this);
            int i3 = this.f55244a;
            if (andIncrement >= i3) {
                do {
                    i2 = atomicIntegerFieldUpdater.get(this);
                    if (i2 <= i3) {
                        break;
                    }
                } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, i3));
                throw new IllegalStateException(("The number of released permits cannot be greater than " + i3).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f55239c;
            SemaphoreSegment semaphoreSegment = (SemaphoreSegment) atomicReferenceFieldUpdater.get(this);
            long andIncrement2 = f55240d.getAndIncrement(this);
            long j2 = andIncrement2 / SemaphoreKt.f55253f;
            SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1.f55247b;
            while (true) {
                objA = ConcurrentLinkedListKt.a(semaphoreSegment, j2, semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1);
                if (SegmentOrClosed.b(objA)) {
                    break;
                }
                Segment segmentA = SegmentOrClosed.a(objA);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.f55105c >= segmentA.f55105c) {
                        break;
                    }
                    if (!segmentA.j()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, segment, segmentA)) {
                        if (atomicReferenceFieldUpdater.get(this) != segment) {
                            if (segmentA.f()) {
                                segmentA.e();
                            }
                        }
                    }
                    if (segment.f()) {
                        segment.e();
                    }
                }
            }
            SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.a(objA);
            semaphoreSegment2.a();
            zE = false;
            if (semaphoreSegment2.f55105c <= j2) {
                int i4 = (int) (andIncrement2 % SemaphoreKt.f55253f);
                Symbol symbol = SemaphoreKt.f55249b;
                AtomicReferenceArray atomicReferenceArray = semaphoreSegment2.f55256e;
                Object andSet = atomicReferenceArray.getAndSet(i4, symbol);
                if (andSet == null) {
                    int i5 = SemaphoreKt.f55248a;
                    for (int i6 = 0; i6 < i5; i6++) {
                        if (atomicReferenceArray.get(i4) == SemaphoreKt.f55250c) {
                            zE = true;
                            break;
                        }
                    }
                    Symbol symbol2 = SemaphoreKt.f55249b;
                    Symbol symbol3 = SemaphoreKt.f55251d;
                    while (true) {
                        if (!atomicReferenceArray.compareAndSet(i4, symbol2, symbol3)) {
                            if (atomicReferenceArray.get(i4) != symbol2) {
                                break;
                            }
                        } else {
                            zE = true;
                            break;
                        }
                    }
                    zE = !zE;
                } else if (andSet != SemaphoreKt.f55252e) {
                    if (andSet instanceof CancellableContinuation) {
                        CancellableContinuation cancellableContinuation = (CancellableContinuation) andSet;
                        Symbol symbolF = cancellableContinuation.f(Unit.f53572a, this.f55245b);
                        if (symbolF != null) {
                            cancellableContinuation.q(symbolF);
                            zE = true;
                            break;
                            break;
                        }
                    } else {
                        if (!(andSet instanceof SelectInstance)) {
                            throw new IllegalStateException(("unexpected: " + andSet).toString());
                        }
                        zE = ((SelectInstance) andSet).e(this, Unit.f53572a);
                    }
                }
            }
        } while (!zE);
    }
}
