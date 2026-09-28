package kotlinx.coroutines.channels;

import android.support.v4.media.b;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class BufferedChannel<E> implements Channel<E> {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f54208b = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f54209c = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f54210d = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd$volatile");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f54211e = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f54212f = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f54213g = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment$volatile");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f54214h = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment$volatile");

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f54215i = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f54216j = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f54217a;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    @Metadata
    @SourceDebugExtension
    public final class BufferedChannelIterator implements ChannelIterator<E>, Waiter {

        /* renamed from: a, reason: collision with root package name */
        public Object f54218a = BufferedChannelKt.p;

        /* renamed from: b, reason: collision with root package name */
        public CancellableContinuationImpl f54219b;

        public BufferedChannelIterator() {
        }

        @Override // kotlinx.coroutines.Waiter
        public final void a(Segment segment, int i2) {
            CancellableContinuationImpl cancellableContinuationImpl = this.f54219b;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.a(segment, i2);
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public final Object b(Continuation frame) throws Throwable {
            ChannelSegment channelSegmentW;
            Boolean bool;
            Object obj = this.f54218a;
            boolean z = true;
            if (obj == BufferedChannelKt.p || obj == BufferedChannelKt.f54246l) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = BufferedChannel.f54213g;
                BufferedChannel bufferedChannel = BufferedChannel.this;
                ChannelSegment channelSegment = (ChannelSegment) atomicReferenceFieldUpdater.get(bufferedChannel);
                while (true) {
                    if (bufferedChannel.E()) {
                        this.f54218a = BufferedChannelKt.f54246l;
                        Throwable thX = bufferedChannel.x();
                        if (thX != null) {
                            int i2 = StackTraceRecoveryKt.f55106a;
                            throw thX;
                        }
                        z = false;
                    } else {
                        long andIncrement = BufferedChannel.f54209c.getAndIncrement(bufferedChannel);
                        long j2 = BufferedChannelKt.f54236b;
                        long j3 = andIncrement / j2;
                        int i3 = (int) (andIncrement % j2);
                        if (channelSegment.f55105c != j3) {
                            channelSegmentW = bufferedChannel.w(j3, channelSegment);
                            if (channelSegmentW == null) {
                                continue;
                            }
                        } else {
                            channelSegmentW = channelSegment;
                        }
                        Object objT = bufferedChannel.T(channelSegmentW, i3, andIncrement, null);
                        Symbol symbol = BufferedChannelKt.f54247m;
                        if (objT == symbol) {
                            throw new IllegalStateException("unreachable");
                        }
                        Symbol symbol2 = BufferedChannelKt.o;
                        if (objT == symbol2) {
                            if (andIncrement < bufferedChannel.A()) {
                                channelSegmentW.a();
                            }
                            channelSegment = channelSegmentW;
                        } else {
                            if (objT == BufferedChannelKt.n) {
                                BufferedChannel bufferedChannel2 = BufferedChannel.this;
                                CancellableContinuationImpl cancellableContinuationImplB = CancellableContinuationKt.b(IntrinsicsKt.b(frame));
                                try {
                                    this.f54219b = cancellableContinuationImplB;
                                    Object objT2 = bufferedChannel2.T(channelSegmentW, i3, andIncrement, this);
                                    if (objT2 == symbol) {
                                        a(channelSegmentW, i3);
                                    } else {
                                        if (objT2 == symbol2) {
                                            if (andIncrement < bufferedChannel2.A()) {
                                                channelSegmentW.a();
                                            }
                                            ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.f54213g.get(bufferedChannel2);
                                            while (true) {
                                                if (bufferedChannel2.E()) {
                                                    CancellableContinuationImpl cancellableContinuationImpl = this.f54219b;
                                                    Intrinsics.c(cancellableContinuationImpl);
                                                    this.f54219b = null;
                                                    this.f54218a = BufferedChannelKt.f54246l;
                                                    Throwable thX2 = bufferedChannel.x();
                                                    if (thX2 == null) {
                                                        Result.Companion companion = Result.f53538b;
                                                        cancellableContinuationImpl.resumeWith(Boolean.FALSE);
                                                    } else {
                                                        Result.Companion companion2 = Result.f53538b;
                                                        cancellableContinuationImpl.resumeWith(ResultKt.a(thX2));
                                                    }
                                                } else {
                                                    long andIncrement2 = BufferedChannel.f54209c.getAndIncrement(bufferedChannel2);
                                                    long j4 = BufferedChannelKt.f54236b;
                                                    long j5 = andIncrement2 / j4;
                                                    int i4 = (int) (andIncrement2 % j4);
                                                    if (channelSegment2.f55105c != j5) {
                                                        ChannelSegment channelSegmentW2 = bufferedChannel2.w(j5, channelSegment2);
                                                        if (channelSegmentW2 != null) {
                                                            channelSegment2 = channelSegmentW2;
                                                        }
                                                    }
                                                    Object objT3 = bufferedChannel2.T(channelSegment2, i4, andIncrement2, this);
                                                    if (objT3 == BufferedChannelKt.f54247m) {
                                                        a(channelSegment2, i4);
                                                        break;
                                                    }
                                                    if (objT3 == BufferedChannelKt.o) {
                                                        if (andIncrement2 < bufferedChannel2.A()) {
                                                            channelSegment2.a();
                                                        }
                                                    } else {
                                                        if (objT3 == BufferedChannelKt.n) {
                                                            throw new IllegalStateException("unexpected");
                                                        }
                                                        channelSegment2.a();
                                                        this.f54218a = objT3;
                                                        this.f54219b = null;
                                                        bool = Boolean.TRUE;
                                                    }
                                                }
                                            }
                                        } else {
                                            channelSegmentW.a();
                                            this.f54218a = objT2;
                                            this.f54219b = null;
                                            bool = Boolean.TRUE;
                                        }
                                        cancellableContinuationImplB.n(bool, null);
                                    }
                                    Object objR = cancellableContinuationImplB.r();
                                    if (objR == CoroutineSingletons.f53689a) {
                                        Intrinsics.checkNotNullParameter(frame, "frame");
                                    }
                                    return objR;
                                } catch (Throwable th) {
                                    cancellableContinuationImplB.z();
                                    throw th;
                                }
                            }
                            channelSegmentW.a();
                            this.f54218a = objT;
                        }
                    }
                }
            }
            return Boolean.valueOf(z);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public final Object next() throws Throwable {
            Object obj = this.f54218a;
            Symbol symbol = BufferedChannelKt.p;
            if (obj == symbol) {
                throw new IllegalStateException("`hasNext()` has not been invoked");
            }
            this.f54218a = symbol;
            if (obj != BufferedChannelKt.f54246l) {
                return obj;
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater = BufferedChannel.f54208b;
            Throwable thY = BufferedChannel.this.y();
            int i2 = StackTraceRecoveryKt.f55106a;
            throw thY;
        }
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class SendBroadcast implements Waiter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellableContinuationImpl f54221a;

        /* renamed from: b, reason: collision with root package name */
        public final CancellableContinuationImpl f54222b;

        public SendBroadcast(CancellableContinuationImpl cancellableContinuationImpl) {
            this.f54221a = cancellableContinuationImpl;
            this.f54222b = cancellableContinuationImpl;
        }

        @Override // kotlinx.coroutines.Waiter
        public final void a(Segment segment, int i2) {
            this.f54221a.a(segment, i2);
        }

        public final CancellableContinuation b() {
            return this.f54222b;
        }
    }

    public BufferedChannel(int i2) {
        this.f54217a = i2;
        if (i2 < 0) {
            throw new IllegalArgumentException(b.g(i2, "Invalid channel capacity: ", ", should be >=0").toString());
        }
        ChannelSegment channelSegment = BufferedChannelKt.f54235a;
        this.bufferEnd$volatile = i2 != 0 ? i2 != Integer.MAX_VALUE ? i2 : Long.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag$volatile = f54210d.get(this);
        ChannelSegment channelSegment2 = new ChannelSegment(0L, null, this, 3);
        this.sendSegment$volatile = channelSegment2;
        this.receiveSegment$volatile = channelSegment2;
        if (H()) {
            channelSegment2 = BufferedChannelKt.f54235a;
            Intrinsics.d(channelSegment2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = channelSegment2;
        this._closeCause$volatile = BufferedChannelKt.s;
    }

    public static void C(BufferedChannel bufferedChannel) {
        bufferedChannel.getClass();
        AtomicLongFieldUpdater atomicLongFieldUpdater = f54211e;
        if ((atomicLongFieldUpdater.addAndGet(bufferedChannel, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(bufferedChannel) & 4611686018427387904L) != 0) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object L(kotlinx.coroutines.channels.BufferedChannel r13, kotlin.coroutines.jvm.internal.ContinuationImpl r14) throws java.lang.Throwable {
        /*
            boolean r0 = r14 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L14
            r0 = r14
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.f54231c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f54231c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.f54229a
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r6.f54231c
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            kotlin.ResultKt.b(r14)
            kotlinx.coroutines.channels.ChannelResult r14 = (kotlinx.coroutines.channels.ChannelResult) r14
            java.lang.Object r13 = r14.f54255a
            return r13
        L2d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L35:
            kotlin.ResultKt.b(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = kotlinx.coroutines.channels.BufferedChannel.f54213g
            java.lang.Object r14 = r14.get(r13)
            kotlinx.coroutines.channels.ChannelSegment r14 = (kotlinx.coroutines.channels.ChannelSegment) r14
        L40:
            boolean r1 = r13.E()
            if (r1 == 0) goto L51
            kotlinx.coroutines.channels.ChannelResult$Failed r14 = kotlinx.coroutines.channels.ChannelResult.f54254b
            java.lang.Throwable r13 = r13.x()
            kotlinx.coroutines.channels.ChannelResult$Closed r13 = kotlinx.coroutines.channels.ChannelResult.Companion.a(r13)
            return r13
        L51:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.channels.BufferedChannel.f54209c
            long r4 = r1.getAndIncrement(r13)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.f54236b
            long r7 = (long) r1
            long r9 = r4 / r7
            long r7 = r4 % r7
            int r3 = (int) r7
            long r7 = r14.f55105c
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 == 0) goto L6e
            kotlinx.coroutines.channels.ChannelSegment r1 = r13.w(r9, r14)
            if (r1 != 0) goto L6c
            goto L40
        L6c:
            r8 = r1
            goto L6f
        L6e:
            r8 = r14
        L6f:
            r12 = 0
            r7 = r13
            r9 = r3
            r10 = r4
            java.lang.Object r13 = r7.T(r8, r9, r10, r12)
            r1 = r7
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.f54247m
            if (r13 == r14) goto La3
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.o
            if (r13 != r14) goto L8e
            long r13 = r1.A()
            int r13 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r13 >= 0) goto L8b
            r8.a()
        L8b:
            r13 = r1
            r14 = r8
            goto L40
        L8e:
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.n
            if (r13 != r14) goto L9d
            r6.f54231c = r2
            r2 = r8
            java.lang.Object r13 = r1.M(r2, r3, r4, r6)
            if (r13 != r0) goto L9c
            return r0
        L9c:
            return r13
        L9d:
            r8.a()
            kotlinx.coroutines.channels.ChannelResult$Failed r14 = kotlinx.coroutines.channels.ChannelResult.f54254b
            return r13
        La3:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.L(kotlinx.coroutines.channels.BufferedChannel, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static final ChannelSegment a(BufferedChannel bufferedChannel, long j2, ChannelSegment channelSegment) {
        Object objA;
        BufferedChannel bufferedChannel2;
        bufferedChannel.getClass();
        ChannelSegment channelSegment2 = BufferedChannelKt.f54235a;
        BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.f54248b;
        loop0: while (true) {
            objA = ConcurrentLinkedListKt.a(channelSegment, j2, bufferedChannelKt$createSegmentFunction$1);
            if (!SegmentOrClosed.b(objA)) {
                Segment segmentA = SegmentOrClosed.a(objA);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54212f;
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(bufferedChannel);
                    if (segment.f55105c >= segmentA.f55105c) {
                        break loop0;
                    }
                    if (!segmentA.j()) {
                        break;
                    }
                    if (com.google.android.gms.internal.pal.a.s(atomicReferenceFieldUpdater, bufferedChannel, segment, segmentA)) {
                        if (segment.f()) {
                            segment.e();
                        }
                    } else if (segmentA.f()) {
                        segmentA.e();
                    }
                }
            } else {
                break;
            }
        }
        boolean zB = SegmentOrClosed.b(objA);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f54209c;
        if (zB) {
            bufferedChannel.p();
            if (channelSegment.f55105c * BufferedChannelKt.f54236b < atomicLongFieldUpdater.get(bufferedChannel)) {
                channelSegment.a();
                return null;
            }
        } else {
            ChannelSegment channelSegment3 = (ChannelSegment) SegmentOrClosed.a(objA);
            long j3 = channelSegment3.f55105c;
            if (j3 <= j2) {
                return channelSegment3;
            }
            long j4 = BufferedChannelKt.f54236b * j3;
            while (true) {
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = f54208b;
                long j5 = atomicLongFieldUpdater2.get(bufferedChannel);
                long j6 = 1152921504606846975L & j5;
                if (j6 >= j4) {
                    bufferedChannel2 = bufferedChannel;
                    break;
                }
                bufferedChannel2 = bufferedChannel;
                if (atomicLongFieldUpdater2.compareAndSet(bufferedChannel2, j5, j6 + (((int) (j5 >> 60)) << 60))) {
                    break;
                }
                bufferedChannel = bufferedChannel2;
            }
            if (j3 * BufferedChannelKt.f54236b < atomicLongFieldUpdater.get(bufferedChannel2)) {
                channelSegment3.a();
            }
        }
        return null;
    }

    public static final void c(BufferedChannel bufferedChannel, Object obj, CancellableContinuationImpl cancellableContinuationImpl) {
        bufferedChannel.getClass();
        Throwable thZ = bufferedChannel.z();
        Result.Companion companion = Result.f53538b;
        cancellableContinuationImpl.resumeWith(ResultKt.a(thZ));
    }

    public static final void f(BufferedChannel bufferedChannel, Waiter waiter, ChannelSegment channelSegment, int i2) {
        bufferedChannel.getClass();
        waiter.a(channelSegment, i2 + BufferedChannelKt.f54236b);
    }

    public static final void l(BufferedChannel bufferedChannel, SelectInstance selectInstance) {
        ChannelSegment channelSegment;
        BufferedChannel bufferedChannel2;
        SelectInstance selectInstance2;
        int i2;
        bufferedChannel.getClass();
        ChannelSegment channelSegment2 = (ChannelSegment) f54213g.get(bufferedChannel);
        while (!bufferedChannel.E()) {
            long andIncrement = f54209c.getAndIncrement(bufferedChannel);
            long j2 = BufferedChannelKt.f54236b;
            long j3 = andIncrement / j2;
            int i3 = (int) (andIncrement % j2);
            if (channelSegment2.f55105c != j3) {
                ChannelSegment channelSegmentW = bufferedChannel.w(j3, channelSegment2);
                if (channelSegmentW == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentW;
                    selectInstance2 = selectInstance;
                    i2 = i3;
                    bufferedChannel2 = bufferedChannel;
                }
            } else {
                channelSegment = channelSegment2;
                bufferedChannel2 = bufferedChannel;
                selectInstance2 = selectInstance;
                i2 = i3;
            }
            Object objT = bufferedChannel2.T(channelSegment, i2, andIncrement, selectInstance2);
            channelSegment2 = channelSegment;
            if (objT == BufferedChannelKt.f54247m) {
                Waiter waiter = selectInstance2 instanceof Waiter ? (Waiter) selectInstance2 : null;
                if (waiter != null) {
                    waiter.a(channelSegment2, i2);
                    return;
                }
                return;
            }
            if (objT != BufferedChannelKt.o) {
                if (objT == BufferedChannelKt.n) {
                    throw new IllegalStateException("unexpected");
                }
                channelSegment2.a();
                selectInstance2.c(objT);
                return;
            }
            if (andIncrement < bufferedChannel2.A()) {
                channelSegment2.a();
            }
            bufferedChannel = bufferedChannel2;
            selectInstance = selectInstance2;
        }
        selectInstance.c(BufferedChannelKt.f54246l);
    }

    public static final int n(BufferedChannel bufferedChannel, ChannelSegment channelSegment, int i2, Object obj, long j2, Object obj2, boolean z) {
        bufferedChannel.getClass();
        channelSegment.n(i2, obj);
        if (z) {
            return bufferedChannel.U(channelSegment, i2, obj, j2, obj2, z);
        }
        Object objL = channelSegment.l(i2);
        if (objL == null) {
            if (bufferedChannel.q(j2)) {
                if (channelSegment.k(i2, null, BufferedChannelKt.f54238d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (channelSegment.k(i2, null, obj2)) {
                    return 2;
                }
            }
        } else if (objL instanceof Waiter) {
            channelSegment.n(i2, null);
            if (bufferedChannel.R(objL, obj)) {
                channelSegment.o(i2, BufferedChannelKt.f54243i);
                return 0;
            }
            Symbol symbol = BufferedChannelKt.f54245k;
            if (channelSegment.f54258f.getAndSet((i2 * 2) + 1, symbol) == symbol) {
                return 5;
            }
            channelSegment.m(i2, true);
            return 5;
        }
        return bufferedChannel.U(channelSegment, i2, obj, j2, obj2, z);
    }

    public final long A() {
        return f54208b.get(this) & 1152921504606846975L;
    }

    public final boolean B() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54213g;
            ChannelSegment channelSegmentW = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
            AtomicLongFieldUpdater atomicLongFieldUpdater = f54209c;
            long j2 = atomicLongFieldUpdater.get(this);
            if (A() <= j2) {
                return false;
            }
            int i2 = BufferedChannelKt.f54236b;
            long j3 = j2 / i2;
            if (channelSegmentW.f55105c == j3 || (channelSegmentW = w(j3, channelSegmentW)) != null) {
                channelSegmentW.a();
                int i3 = (int) (j2 % i2);
                while (true) {
                    Object objL = channelSegmentW.l(i3);
                    if (objL == null || objL == BufferedChannelKt.f54239e) {
                        if (channelSegmentW.k(i3, objL, BufferedChannelKt.f54242h)) {
                            v();
                            break;
                        }
                    } else {
                        if (objL == BufferedChannelKt.f54238d) {
                            return true;
                        }
                        if (objL != BufferedChannelKt.f54244j && objL != BufferedChannelKt.f54246l && objL != BufferedChannelKt.f54243i && objL != BufferedChannelKt.f54242h) {
                            if (objL == BufferedChannelKt.f54241g) {
                                return true;
                            }
                            if (objL != BufferedChannelKt.f54240f && j2 == atomicLongFieldUpdater.get(this)) {
                                return true;
                            }
                        }
                    }
                }
                f54209c.compareAndSet(this, j2, j2 + 1);
            } else if (((ChannelSegment) atomicReferenceFieldUpdater.get(this)).f55105c < j3) {
                return false;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a3, code lost:
    
        r11 = (kotlinx.coroutines.channels.ChannelSegment) ((kotlinx.coroutines.internal.ConcurrentLinkedListNode) kotlinx.coroutines.internal.ConcurrentLinkedListNode.f55064b.get(r11));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean D(long r11, boolean r13) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.D(long, boolean):boolean");
    }

    public final boolean E() {
        return D(f54208b.get(this), true);
    }

    public final boolean F(long j2) {
        return D(j2, false);
    }

    public boolean G() {
        return false;
    }

    public final boolean H() {
        long j2 = f54210d.get(this);
        return j2 == 0 || j2 == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I(long r5, kotlinx.coroutines.channels.ChannelSegment r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f55105c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r7.c()
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.d()
            if (r5 == 0) goto L22
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r5 = r7.c()
            kotlinx.coroutines.channels.ChannelSegment r5 = (kotlinx.coroutines.channels.ChannelSegment) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.channels.BufferedChannel.f54214h
            java.lang.Object r6 = r5.get(r4)
            kotlinx.coroutines.internal.Segment r6 = (kotlinx.coroutines.internal.Segment) r6
            long r0 = r6.f55105c
            long r2 = r7.f55105c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.j()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r5 = com.google.android.gms.internal.pal.a.r(r5, r4, r6, r7)
            if (r5 == 0) goto L4a
            boolean r5 = r6.f()
            if (r5 == 0) goto L49
            r6.e()
        L49:
            return
        L4a:
            boolean r5 = r7.f()
            if (r5 == 0) goto L22
            r7.e()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.I(long, kotlinx.coroutines.channels.ChannelSegment):void");
    }

    public final Object J(Object obj, Continuation frame) throws Throwable {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
        cancellableContinuationImpl.s();
        Throwable thZ = z();
        Result.Companion companion = Result.f53538b;
        cancellableContinuationImpl.resumeWith(ResultKt.a(thZ));
        Object objR = cancellableContinuationImpl.r();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (objR == coroutineSingletons) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objR == coroutineSingletons ? objR : Unit.f53572a;
    }

    public final Object K(ContinuationImpl frame) throws Throwable {
        ChannelSegment channelSegment;
        Throwable th;
        ChannelSegment channelSegment2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54213g;
        ChannelSegment channelSegment3 = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
        while (!E()) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f54209c;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j2 = BufferedChannelKt.f54236b;
            long j3 = andIncrement / j2;
            int i2 = (int) (andIncrement % j2);
            if (channelSegment3.f55105c != j3) {
                ChannelSegment channelSegmentW = w(j3, channelSegment3);
                if (channelSegmentW == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentW;
                }
            } else {
                channelSegment = channelSegment3;
            }
            Object objT = T(channelSegment, i2, andIncrement, null);
            Symbol symbol = BufferedChannelKt.f54247m;
            if (objT == symbol) {
                throw new IllegalStateException("unexpected");
            }
            Symbol symbol2 = BufferedChannelKt.o;
            if (objT == symbol2) {
                if (andIncrement < A()) {
                    channelSegment.a();
                }
                channelSegment3 = channelSegment;
            } else {
                if (objT != BufferedChannelKt.n) {
                    channelSegment.a();
                    return objT;
                }
                CancellableContinuationImpl cancellableContinuationImplB = CancellableContinuationKt.b(IntrinsicsKt.b(frame));
                BufferedChannel<E> bufferedChannel = this;
                try {
                    Object objT2 = bufferedChannel.T(channelSegment, i2, andIncrement, cancellableContinuationImplB);
                    if (objT2 == symbol) {
                        cancellableContinuationImplB.a(channelSegment, i2);
                    } else if (objT2 == symbol2) {
                        if (andIncrement < A()) {
                            channelSegment.a();
                        }
                        ChannelSegment channelSegment4 = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
                        while (true) {
                            if (E()) {
                                Result.Companion companion = Result.f53538b;
                                cancellableContinuationImplB.resumeWith(ResultKt.a(y()));
                                break;
                            }
                            CancellableContinuationImpl cancellableContinuationImpl = cancellableContinuationImplB;
                            try {
                                long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(this);
                                long j4 = BufferedChannelKt.f54236b;
                                long j5 = andIncrement2 / j4;
                                int i3 = (int) (andIncrement2 % j4);
                                if (channelSegment4.f55105c != j5) {
                                    try {
                                        ChannelSegment channelSegmentW2 = w(j5, channelSegment4);
                                        if (channelSegmentW2 == null) {
                                            cancellableContinuationImplB = cancellableContinuationImpl;
                                        } else {
                                            channelSegment2 = channelSegmentW2;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        cancellableContinuationImplB = cancellableContinuationImpl;
                                        cancellableContinuationImplB.z();
                                        throw th;
                                    }
                                } else {
                                    channelSegment2 = channelSegment4;
                                }
                                Object objT3 = bufferedChannel.T(channelSegment2, i3, andIncrement2, cancellableContinuationImpl);
                                ChannelSegment channelSegment5 = channelSegment2;
                                cancellableContinuationImplB = cancellableContinuationImpl;
                                if (objT3 == BufferedChannelKt.f54247m) {
                                    cancellableContinuationImplB.a(channelSegment5, i3);
                                    break;
                                }
                                if (objT3 == BufferedChannelKt.o) {
                                    if (andIncrement2 < A()) {
                                        channelSegment5.a();
                                    }
                                    bufferedChannel = this;
                                    channelSegment4 = channelSegment5;
                                } else {
                                    if (objT3 == BufferedChannelKt.n) {
                                        throw new IllegalStateException("unexpected");
                                    }
                                    channelSegment5.a();
                                    cancellableContinuationImplB.n(objT3, null);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                cancellableContinuationImplB = cancellableContinuationImpl;
                                th = th;
                                cancellableContinuationImplB.z();
                                throw th;
                            }
                        }
                    } else {
                        channelSegment.a();
                        cancellableContinuationImplB.n(objT2, null);
                    }
                    Object objR = cancellableContinuationImplB.r();
                    if (objR == CoroutineSingletons.f53689a) {
                        Intrinsics.checkNotNullParameter(frame, "frame");
                    }
                    return objR;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
        Throwable thY = y();
        int i4 = StackTraceRecoveryKt.f55106a;
        throw thY;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object M(kotlinx.coroutines.channels.ChannelSegment r16, int r17, long r18, kotlin.coroutines.jvm.internal.ContinuationImpl r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.M(kotlinx.coroutines.channels.ChannelSegment, int, long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x008f, code lost:
    
        r11.c(kotlin.Unit.f53572a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0094, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void N(kotlinx.coroutines.selects.SelectInstance r14, java.lang.Object r15) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.channels.BufferedChannel.f54212f
            java.lang.Object r0 = r0.get(r13)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
        L8:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.channels.BufferedChannel.f54208b
            long r1 = r1.getAndIncrement(r13)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r9 = r1 & r3
            r3 = 0
            boolean r12 = r13.D(r1, r3)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.f54236b
            long r1 = (long) r1
            long r3 = r9 / r1
            long r1 = r9 % r1
            int r7 = (int) r1
            long r1 = r0.f55105c
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L3b
            kotlinx.coroutines.channels.ChannelSegment r1 = a(r13, r3, r0)
            if (r1 != 0) goto L36
            if (r12 == 0) goto L8
            kotlinx.coroutines.internal.Symbol r15 = kotlinx.coroutines.channels.BufferedChannelKt.f54246l
            r14.c(r15)
            return
        L36:
            r6 = r1
        L37:
            r5 = r13
            r11 = r14
            r8 = r15
            goto L3d
        L3b:
            r6 = r0
            goto L37
        L3d:
            int r14 = n(r5, r6, r7, r8, r9, r11, r12)
            r0 = r6
            if (r14 == 0) goto L95
            r15 = 1
            if (r14 == r15) goto L8f
            r15 = 2
            if (r14 == r15) goto L75
            r15 = 3
            if (r14 == r15) goto L6d
            r15 = 4
            if (r14 == r15) goto L5a
            r15 = 5
            if (r14 == r15) goto L54
            goto L57
        L54:
            r0.a()
        L57:
            r15 = r8
            r14 = r11
            goto L8
        L5a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r14 = kotlinx.coroutines.channels.BufferedChannel.f54209c
            long r14 = r14.get(r13)
            int r14 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r14 >= 0) goto L67
            r0.a()
        L67:
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.f54246l
            r11.c(r14)
            return
        L6d:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            r14.<init>(r15)
            throw r14
        L75:
            if (r12 == 0) goto L80
            r0.i()
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.f54246l
            r11.c(r14)
            return
        L80:
            boolean r14 = r11 instanceof kotlinx.coroutines.Waiter
            if (r14 == 0) goto L88
            r14 = r11
            kotlinx.coroutines.Waiter r14 = (kotlinx.coroutines.Waiter) r14
            goto L89
        L88:
            r14 = 0
        L89:
            if (r14 == 0) goto L8e
            f(r13, r14, r0, r7)
        L8e:
            return
        L8f:
            kotlin.Unit r14 = kotlin.Unit.f53572a
            r11.c(r14)
            return
        L95:
            r0.a()
            goto L8f
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.N(kotlinx.coroutines.selects.SelectInstance, java.lang.Object):void");
    }

    public final void O(Waiter waiter, boolean z) {
        if (waiter instanceof SendBroadcast) {
            CancellableContinuation cancellableContinuationB = ((SendBroadcast) waiter).b();
            Result.Companion companion = Result.f53538b;
            ((CancellableContinuationImpl) cancellableContinuationB).resumeWith(Boolean.FALSE);
            return;
        }
        if (waiter instanceof CancellableContinuation) {
            Continuation continuation = (Continuation) waiter;
            Result.Companion companion2 = Result.f53538b;
            continuation.resumeWith(ResultKt.a(z ? y() : z()));
            return;
        }
        if (waiter instanceof ReceiveCatching) {
            CancellableContinuationImpl cancellableContinuationImpl = ((ReceiveCatching) waiter).f54427a;
            Result.Companion companion3 = Result.f53538b;
            ChannelResult.Failed failed = ChannelResult.f54254b;
            cancellableContinuationImpl.resumeWith(new ChannelResult(ChannelResult.Companion.a(x())));
            return;
        }
        if (!(waiter instanceof BufferedChannelIterator)) {
            if (waiter instanceof SelectInstance) {
                ((SelectInstance) waiter).e(this, BufferedChannelKt.f54246l);
                return;
            } else {
                throw new IllegalStateException(("Unexpected waiter: " + waiter).toString());
            }
        }
        BufferedChannelIterator bufferedChannelIterator = (BufferedChannelIterator) waiter;
        CancellableContinuationImpl cancellableContinuationImpl2 = bufferedChannelIterator.f54219b;
        Intrinsics.c(cancellableContinuationImpl2);
        bufferedChannelIterator.f54219b = null;
        bufferedChannelIterator.f54218a = BufferedChannelKt.f54246l;
        Throwable thX = BufferedChannel.this.x();
        if (thX == null) {
            Result.Companion companion4 = Result.f53538b;
            cancellableContinuationImpl2.resumeWith(Boolean.FALSE);
        } else {
            Result.Companion companion5 = Result.f53538b;
            cancellableContinuationImpl2.resumeWith(ResultKt.a(thX));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0098, code lost:
    
        r0.resumeWith(java.lang.Boolean.TRUE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object P(java.lang.Object r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            r13 = this;
            kotlinx.coroutines.CancellableContinuationImpl r0 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r15)
            r2 = 1
            r0.<init>(r2, r1)
            r0.s()
            kotlinx.coroutines.channels.BufferedChannel$SendBroadcast r9 = new kotlinx.coroutines.channels.BufferedChannel$SendBroadcast
            r9.<init>(r0)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.channels.BufferedChannel.f54212f
            java.lang.Object r1 = r1.get(r13)
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
        L1a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = kotlinx.coroutines.channels.BufferedChannel.f54208b
            long r3 = r3.getAndIncrement(r13)
            r5 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r7 = r3 & r5
            r5 = 0
            boolean r10 = r13.D(r3, r5)
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.f54236b
            long r3 = (long) r3
            long r5 = r7 / r3
            long r3 = r7 % r3
            int r3 = (int) r3
            long r11 = r1.f55105c
            int r4 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r4 == 0) goto L50
            kotlinx.coroutines.channels.ChannelSegment r4 = a(r13, r5, r1)
            if (r4 != 0) goto L4c
            if (r10 == 0) goto L1a
            kotlin.Result$Companion r14 = kotlin.Result.f53538b
            java.lang.Boolean r14 = java.lang.Boolean.FALSE
            r0.resumeWith(r14)
            r3 = r13
            goto La4
        L4c:
            r6 = r14
            r5 = r3
            r3 = r13
            goto L52
        L50:
            r4 = r1
            goto L4c
        L52:
            int r14 = n(r3, r4, r5, r6, r7, r9, r10)
            r1 = r4
            if (r14 == 0) goto L9e
            if (r14 == r2) goto L96
            r4 = 2
            if (r14 == r4) goto L8a
            r4 = 3
            if (r14 == r4) goto L82
            r4 = 4
            if (r14 == r4) goto L6d
            r4 = 5
            if (r14 == r4) goto L68
            goto L6b
        L68:
            r1.a()
        L6b:
            r14 = r6
            goto L1a
        L6d:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r14 = kotlinx.coroutines.channels.BufferedChannel.f54209c
            long r4 = r14.get(r13)
            int r14 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r14 >= 0) goto L7a
            r1.a()
        L7a:
            kotlin.Result$Companion r14 = kotlin.Result.f53538b
        L7c:
            java.lang.Boolean r14 = java.lang.Boolean.FALSE
            r0.resumeWith(r14)
            goto La4
        L82:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            r14.<init>(r15)
            throw r14
        L8a:
            if (r10 == 0) goto L92
            r1.i()
            kotlin.Result$Companion r14 = kotlin.Result.f53538b
            goto L7c
        L92:
            f(r13, r9, r1, r5)
            goto La4
        L96:
            kotlin.Result$Companion r14 = kotlin.Result.f53538b
        L98:
            java.lang.Boolean r14 = java.lang.Boolean.TRUE
            r0.resumeWith(r14)
            goto La4
        L9e:
            r1.a()
            kotlin.Result$Companion r14 = kotlin.Result.f53538b
            goto L98
        La4:
            java.lang.Object r14 = r0.r()
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            if (r14 != r0) goto Lb1
            java.lang.String r0 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
        Lb1:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.P(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean Q() {
        if (F(f54208b.get(this))) {
            return false;
        }
        return !q(r0 & 1152921504606846975L);
    }

    public final boolean R(Object obj, Object obj2) {
        if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).e(this, obj2);
        }
        if (obj instanceof ReceiveCatching) {
            Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            return BufferedChannelKt.a(((ReceiveCatching) obj).f54427a, new ChannelResult(obj2), null);
        }
        if (!(obj instanceof BufferedChannelIterator)) {
            if (obj instanceof CancellableContinuation) {
                Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
                return BufferedChannelKt.a((CancellableContinuation) obj, obj2, null);
            }
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
        BufferedChannelIterator bufferedChannelIterator = (BufferedChannelIterator) obj;
        CancellableContinuationImpl cancellableContinuationImpl = bufferedChannelIterator.f54219b;
        Intrinsics.c(cancellableContinuationImpl);
        bufferedChannelIterator.f54219b = null;
        bufferedChannelIterator.f54218a = obj2;
        Boolean bool = Boolean.TRUE;
        BufferedChannel.this.getClass();
        return BufferedChannelKt.a(cancellableContinuationImpl, bool, null);
    }

    public final boolean S(Object obj, ChannelSegment channelSegment, int i2) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.a((CancellableContinuation) obj, Unit.f53572a, null);
        }
        if (obj instanceof SelectInstance) {
            Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult trySelectDetailedResultM = ((SelectImplementation) obj).m(this, Unit.f53572a);
            if (trySelectDetailedResultM == TrySelectDetailedResult.f55213b) {
                channelSegment.n(i2, null);
            }
            return trySelectDetailedResultM == TrySelectDetailedResult.f55212a;
        }
        if (obj instanceof SendBroadcast) {
            return BufferedChannelKt.a(((SendBroadcast) obj).b(), Boolean.TRUE, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    public final Object T(ChannelSegment channelSegment, int i2, long j2, Object obj) {
        Object objL = channelSegment.l(i2);
        AtomicReferenceArray atomicReferenceArray = channelSegment.f54258f;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f54208b;
        if (objL == null) {
            if (j2 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return BufferedChannelKt.n;
                }
                if (channelSegment.k(i2, objL, obj)) {
                    v();
                    return BufferedChannelKt.f54247m;
                }
            }
        } else if (objL == BufferedChannelKt.f54238d && channelSegment.k(i2, objL, BufferedChannelKt.f54243i)) {
            v();
            Object obj2 = atomicReferenceArray.get(i2 * 2);
            channelSegment.n(i2, null);
            return obj2;
        }
        while (true) {
            Object objL2 = channelSegment.l(i2);
            if (objL2 == null || objL2 == BufferedChannelKt.f54239e) {
                if (j2 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (channelSegment.k(i2, objL2, BufferedChannelKt.f54242h)) {
                        v();
                        return BufferedChannelKt.o;
                    }
                } else {
                    if (obj == null) {
                        return BufferedChannelKt.n;
                    }
                    if (channelSegment.k(i2, objL2, obj)) {
                        v();
                        return BufferedChannelKt.f54247m;
                    }
                }
            } else if (objL2 != BufferedChannelKt.f54238d) {
                Symbol symbol = BufferedChannelKt.f54244j;
                if (objL2 == symbol) {
                    return BufferedChannelKt.o;
                }
                if (objL2 == BufferedChannelKt.f54242h) {
                    return BufferedChannelKt.o;
                }
                if (objL2 == BufferedChannelKt.f54246l) {
                    v();
                    return BufferedChannelKt.o;
                }
                if (objL2 != BufferedChannelKt.f54241g && channelSegment.k(i2, objL2, BufferedChannelKt.f54240f)) {
                    boolean z = objL2 instanceof WaiterEB;
                    if (z) {
                        objL2 = ((WaiterEB) objL2).f54440a;
                    }
                    if (S(objL2, channelSegment, i2)) {
                        channelSegment.o(i2, BufferedChannelKt.f54243i);
                        v();
                        Object obj3 = atomicReferenceArray.get(i2 * 2);
                        channelSegment.n(i2, null);
                        return obj3;
                    }
                    channelSegment.o(i2, symbol);
                    channelSegment.i();
                    if (z) {
                        v();
                    }
                    return BufferedChannelKt.o;
                }
            } else if (channelSegment.k(i2, objL2, BufferedChannelKt.f54243i)) {
                v();
                Object obj4 = atomicReferenceArray.get(i2 * 2);
                channelSegment.n(i2, null);
                return obj4;
            }
        }
    }

    public final int U(ChannelSegment channelSegment, int i2, Object obj, long j2, Object obj2, boolean z) {
        while (true) {
            Object objL = channelSegment.l(i2);
            if (objL == null) {
                if (!q(j2) || z) {
                    if (z) {
                        if (channelSegment.k(i2, null, BufferedChannelKt.f54244j)) {
                            channelSegment.i();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (channelSegment.k(i2, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (channelSegment.k(i2, null, BufferedChannelKt.f54238d)) {
                    break;
                }
            } else {
                if (objL != BufferedChannelKt.f54239e) {
                    Symbol symbol = BufferedChannelKt.f54245k;
                    if (objL == symbol) {
                        channelSegment.n(i2, null);
                        return 5;
                    }
                    if (objL == BufferedChannelKt.f54242h) {
                        channelSegment.n(i2, null);
                        return 5;
                    }
                    if (objL == BufferedChannelKt.f54246l) {
                        channelSegment.n(i2, null);
                        p();
                        return 4;
                    }
                    channelSegment.n(i2, null);
                    if (objL instanceof WaiterEB) {
                        objL = ((WaiterEB) objL).f54440a;
                    }
                    if (R(objL, obj)) {
                        channelSegment.o(i2, BufferedChannelKt.f54243i);
                        return 0;
                    }
                    if (channelSegment.f54258f.getAndSet((i2 * 2) + 1, symbol) != symbol) {
                        channelSegment.m(i2, true);
                    }
                    return 5;
                }
                if (channelSegment.k(i2, objL, BufferedChannelKt.f54238d)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void V(long j2) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        BufferedChannel<E> bufferedChannel = this;
        if (bufferedChannel.H()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = f54210d;
            if (atomicLongFieldUpdater.get(bufferedChannel) > j2) {
                break;
            } else {
                bufferedChannel = this;
            }
        }
        int i2 = BufferedChannelKt.f54237c;
        int i3 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f54211e;
            if (i3 < i2) {
                long j3 = atomicLongFieldUpdater.get(bufferedChannel);
                if (j3 == (4611686018427387903L & atomicLongFieldUpdater2.get(bufferedChannel)) && j3 == atomicLongFieldUpdater.get(bufferedChannel)) {
                    return;
                } else {
                    i3++;
                }
            } else {
                while (true) {
                    long j4 = atomicLongFieldUpdater2.get(bufferedChannel);
                    if (atomicLongFieldUpdater2.compareAndSet(bufferedChannel, j4, (j4 & 4611686018427387903L) + 4611686018427387904L)) {
                        break;
                    } else {
                        bufferedChannel = this;
                    }
                }
                while (true) {
                    long j5 = atomicLongFieldUpdater.get(bufferedChannel);
                    long j6 = atomicLongFieldUpdater2.get(bufferedChannel);
                    long j7 = j6 & 4611686018427387903L;
                    boolean z = (j6 & 4611686018427387904L) != 0;
                    if (j5 == j7 && j5 == atomicLongFieldUpdater.get(bufferedChannel)) {
                        break;
                    }
                    if (!z) {
                        atomicLongFieldUpdater2.compareAndSet(this, j6, 4611686018427387904L + j7);
                    }
                    bufferedChannel = this;
                }
                while (true) {
                    long j8 = atomicLongFieldUpdater2.get(bufferedChannel);
                    if (atomicLongFieldUpdater2.compareAndSet(bufferedChannel, j8, j8 & 4611686018427387903L)) {
                        return;
                    } else {
                        bufferedChannel = this;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean d(Throwable th) {
        return s(false, th);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void e(CancellationException cancellationException) {
        r(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object g(ContinuationImpl continuationImpl) {
        return L(this, continuationImpl);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void h(Function1 function1) {
        Symbol symbol;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54216j;
        if (com.google.android.gms.internal.pal.a.q(atomicReferenceFieldUpdater, this, function1)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            symbol = BufferedChannelKt.q;
            if (obj != symbol) {
                if (obj == BufferedChannelKt.r) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        } while (!com.google.android.gms.internal.pal.a.t(atomicReferenceFieldUpdater, this, symbol, BufferedChannelKt.r));
        function1.invoke(x());
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c0 A[SYNTHETIC] */
    @Override // kotlinx.coroutines.channels.SendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object i(java.lang.Object r16) {
        /*
            r15 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = kotlinx.coroutines.channels.BufferedChannel.f54208b
            long r1 = r8.get(r15)
            boolean r3 = r15.F(r1)
            r9 = 1
            r10 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            r12 = 0
            if (r3 == 0) goto L15
            r1 = r12
            goto L1b
        L15:
            long r1 = r1 & r10
            boolean r1 = r15.q(r1)
            r1 = r1 ^ r9
        L1b:
            if (r1 == 0) goto L20
            kotlinx.coroutines.channels.ChannelResult$Failed r1 = kotlinx.coroutines.channels.ChannelResult.f54254b
            return r1
        L20:
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.channels.BufferedChannelKt.f54244j
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.channels.BufferedChannel.f54212f
            java.lang.Object r1 = r1.get(r15)
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
        L2a:
            long r2 = r8.getAndIncrement(r15)
            long r4 = r2 & r10
            boolean r7 = r15.D(r2, r12)
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.f54236b
            long r2 = (long) r2
            long r13 = r4 / r2
            long r2 = r4 % r2
            int r2 = (int) r2
            long r10 = r1.f55105c
            int r3 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r3 == 0) goto L5c
            kotlinx.coroutines.channels.ChannelSegment r3 = a(r15, r13, r1)
            if (r3 != 0) goto L5b
            if (r7 == 0) goto L55
            kotlinx.coroutines.channels.ChannelResult$Failed r1 = kotlinx.coroutines.channels.ChannelResult.f54254b
            java.lang.Throwable r1 = r15.z()
            kotlinx.coroutines.channels.ChannelResult$Closed r1 = kotlinx.coroutines.channels.ChannelResult.Companion.a(r1)
            return r1
        L55:
            r10 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            goto L2a
        L5b:
            r1 = r3
        L5c:
            r0 = r15
            r3 = r16
            int r10 = n(r0, r1, r2, r3, r4, r6, r7)
            if (r10 == 0) goto Lc0
            if (r10 == r9) goto Lbb
            r3 = 2
            if (r10 == r3) goto L98
            r2 = 3
            if (r10 == r2) goto L90
            r2 = 4
            if (r10 == r2) goto L78
            r2 = 5
            if (r10 == r2) goto L74
            goto L55
        L74:
            r1.a()
            goto L55
        L78:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = kotlinx.coroutines.channels.BufferedChannel.f54209c
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L85
            r1.a()
        L85:
            kotlinx.coroutines.channels.ChannelResult$Failed r1 = kotlinx.coroutines.channels.ChannelResult.f54254b
            java.lang.Throwable r1 = r15.z()
            kotlinx.coroutines.channels.ChannelResult$Closed r1 = kotlinx.coroutines.channels.ChannelResult.Companion.a(r1)
            return r1
        L90:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "unexpected"
            r1.<init>(r2)
            throw r1
        L98:
            if (r7 == 0) goto La8
            r1.i()
            kotlinx.coroutines.channels.ChannelResult$Failed r1 = kotlinx.coroutines.channels.ChannelResult.f54254b
            java.lang.Throwable r1 = r15.z()
            kotlinx.coroutines.channels.ChannelResult$Closed r1 = kotlinx.coroutines.channels.ChannelResult.Companion.a(r1)
            return r1
        La8:
            boolean r3 = r6 instanceof kotlinx.coroutines.Waiter
            if (r3 == 0) goto Laf
            kotlinx.coroutines.Waiter r6 = (kotlinx.coroutines.Waiter) r6
            goto Lb0
        Laf:
            r6 = 0
        Lb0:
            if (r6 == 0) goto Lb5
            f(r15, r6, r1, r2)
        Lb5:
            r1.i()
            kotlinx.coroutines.channels.ChannelResult$Failed r1 = kotlinx.coroutines.channels.ChannelResult.f54254b
            return r1
        Lbb:
            kotlinx.coroutines.channels.ChannelResult$Failed r1 = kotlinx.coroutines.channels.ChannelResult.f54254b
            kotlin.Unit r1 = kotlin.Unit.f53572a
            return r1
        Lc0:
            r1.a()
            kotlinx.coroutines.channels.ChannelResult$Failed r1 = kotlinx.coroutines.channels.ChannelResult.f54254b
            kotlin.Unit r1 = kotlin.Unit.f53572a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.i(java.lang.Object):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator iterator() {
        return new BufferedChannelIterator();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 j() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.f54223b;
        TypeIntrinsics.b(3, bufferedChannel$onReceive$1);
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.f54224b;
        TypeIntrinsics.b(3, bufferedChannel$onReceive$2);
        return new SelectClause1Impl(this, bufferedChannel$onReceive$1, bufferedChannel$onReceive$2, null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 k() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.f54225b;
        TypeIntrinsics.b(3, bufferedChannel$onReceiveCatching$1);
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.f54226b;
        TypeIntrinsics.b(3, bufferedChannel$onReceiveCatching$2);
        return new SelectClause1Impl(this, bufferedChannel$onReceiveCatching$1, bufferedChannel$onReceiveCatching$2, null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object m() {
        ChannelSegment channelSegmentW;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f54209c;
        long j2 = atomicLongFieldUpdater.get(this);
        long j3 = f54208b.get(this);
        if (D(j3, true)) {
            ChannelResult.Failed failed = ChannelResult.f54254b;
            return ChannelResult.Companion.a(x());
        }
        if (j2 >= (j3 & 1152921504606846975L)) {
            return ChannelResult.f54254b;
        }
        Object obj = BufferedChannelKt.f54245k;
        ChannelSegment channelSegment = (ChannelSegment) f54213g.get(this);
        while (!E()) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j4 = BufferedChannelKt.f54236b;
            long j5 = andIncrement / j4;
            int i2 = (int) (andIncrement % j4);
            if (channelSegment.f55105c != j5) {
                channelSegmentW = w(j5, channelSegment);
                if (channelSegmentW == null) {
                    continue;
                }
            } else {
                channelSegmentW = channelSegment;
            }
            Object objT = T(channelSegmentW, i2, andIncrement, obj);
            channelSegment = channelSegmentW;
            if (objT == BufferedChannelKt.f54247m) {
                Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                if (waiter != null) {
                    waiter.a(channelSegment, i2);
                }
                V(andIncrement);
                channelSegment.i();
                return ChannelResult.f54254b;
            }
            if (objT != BufferedChannelKt.o) {
                if (objT == BufferedChannelKt.n) {
                    throw new IllegalStateException("unexpected");
                }
                channelSegment.a();
                ChannelResult.Failed failed2 = ChannelResult.f54254b;
                return objT;
            }
            if (andIncrement < A()) {
                channelSegment.a();
            }
        }
        ChannelResult.Failed failed3 = ChannelResult.f54254b;
        return ChannelResult.Companion.a(x());
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0159 A[RETURN] */
    @Override // kotlinx.coroutines.channels.SendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object o(java.lang.Object r24, kotlin.coroutines.Continuation r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.o(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean p() {
        return D(f54208b.get(this), false);
    }

    public final boolean q(long j2) {
        return j2 < f54210d.get(this) || j2 < f54209c.get(this) + ((long) this.f54217a);
    }

    public boolean r(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        return s(true, cancellationException);
    }

    public final boolean s(boolean z, Throwable th) {
        BufferedChannel<E> bufferedChannel;
        boolean z2;
        long j2;
        long j3;
        long j4;
        Object obj;
        long j5;
        long j6;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f54208b;
        if (!z) {
            bufferedChannel = this;
            break;
        }
        do {
            j6 = atomicLongFieldUpdater.get(this);
            if (((int) (j6 >> 60)) != 0) {
                bufferedChannel = this;
                break;
            }
            ChannelSegment channelSegment = BufferedChannelKt.f54235a;
            bufferedChannel = this;
        } while (!atomicLongFieldUpdater.compareAndSet(bufferedChannel, j6, (j6 & 1152921504606846975L) + (1 << 60)));
        Symbol symbol = BufferedChannelKt.s;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54215i;
            if (atomicReferenceFieldUpdater.compareAndSet(this, symbol, th)) {
                z2 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != symbol) {
                z2 = false;
                break;
            }
        }
        if (z) {
            do {
                j5 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(bufferedChannel, j5, (3 << 60) + (j5 & 1152921504606846975L)));
        } else {
            do {
                j2 = atomicLongFieldUpdater.get(this);
                int i2 = (int) (j2 >> 60);
                if (i2 == 0) {
                    j3 = j2 & 1152921504606846975L;
                    j4 = 2;
                } else {
                    if (i2 != 1) {
                        break;
                    }
                    j3 = j2 & 1152921504606846975L;
                    j4 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(bufferedChannel, j2, (j4 << 60) + j3));
        }
        p();
        if (z2) {
            loop3: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f54216j;
                obj = atomicReferenceFieldUpdater2.get(this);
                Symbol symbol2 = obj == null ? BufferedChannelKt.q : BufferedChannelKt.r;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, symbol2)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
            }
            if (obj != null) {
                TypeIntrinsics.b(1, obj);
                ((Function1) obj).invoke(x());
                return z2;
            }
        }
        return z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008f, code lost:
    
        r1 = (kotlinx.coroutines.channels.ChannelSegment) ((kotlinx.coroutines.internal.ConcurrentLinkedListNode) kotlinx.coroutines.internal.ConcurrentLinkedListNode.f55064b.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlinx.coroutines.channels.ChannelSegment t(long r13) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.t(long):kotlinx.coroutines.channels.ChannelSegment");
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x01c1, code lost:
    
        r16 = r7;
        r3 = (kotlinx.coroutines.channels.ChannelSegment) r3.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01ca, code lost:
    
        if (r3 != null) goto L95;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    public final void u(long j2) {
        ChannelSegment channelSegment = (ChannelSegment) f54213g.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f54209c;
            long j3 = atomicLongFieldUpdater.get(this);
            if (j2 < Math.max(this.f54217a + j3, f54210d.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j3, 1 + j3)) {
                long j4 = BufferedChannelKt.f54236b;
                long j5 = j3 / j4;
                int i2 = (int) (j3 % j4);
                if (channelSegment.f55105c != j5) {
                    ChannelSegment channelSegmentW = w(j5, channelSegment);
                    if (channelSegmentW != null) {
                        channelSegment = channelSegmentW;
                    }
                }
                ChannelSegment channelSegment2 = channelSegment;
                if (T(channelSegment2, i2, j3, null) != BufferedChannelKt.o || j3 < A()) {
                    channelSegment2.a();
                }
                channelSegment = channelSegment2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0188, code lost:
    
        C(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x018b, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v() {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.v():void");
    }

    public final ChannelSegment w(long j2, ChannelSegment channelSegment) {
        Object objA;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j3;
        ChannelSegment channelSegment2 = BufferedChannelKt.f54235a;
        BufferedChannelKt$createSegmentFunction$1 bufferedChannelKt$createSegmentFunction$1 = BufferedChannelKt$createSegmentFunction$1.f54248b;
        loop0: while (true) {
            objA = ConcurrentLinkedListKt.a(channelSegment, j2, bufferedChannelKt$createSegmentFunction$1);
            if (!SegmentOrClosed.b(objA)) {
                Segment segmentA = SegmentOrClosed.a(objA);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54213g;
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.f55105c >= segmentA.f55105c) {
                        break loop0;
                    }
                    if (!segmentA.j()) {
                        break;
                    }
                    if (com.google.android.gms.internal.pal.a.s(atomicReferenceFieldUpdater, this, segment, segmentA)) {
                        if (segment.f()) {
                            segment.e();
                        }
                    } else if (segmentA.f()) {
                        segmentA.e();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.b(objA)) {
            p();
            if (channelSegment.f55105c * BufferedChannelKt.f54236b < A()) {
                channelSegment.a();
                return null;
            }
        } else {
            ChannelSegment channelSegment3 = (ChannelSegment) SegmentOrClosed.a(objA);
            boolean zH = H();
            long j4 = channelSegment3.f55105c;
            if (!zH && j2 <= f54210d.get(this) / BufferedChannelKt.f54236b) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f54214h;
                    Segment segment2 = (Segment) atomicReferenceFieldUpdater2.get(this);
                    if (segment2.f55105c >= j4 || !channelSegment3.j()) {
                        break;
                    }
                    if (com.google.android.gms.internal.pal.a.r(atomicReferenceFieldUpdater2, this, segment2, channelSegment3)) {
                        if (segment2.f()) {
                            segment2.e();
                        }
                    } else if (channelSegment3.f()) {
                        channelSegment3.e();
                    }
                }
            }
            if (j4 <= j2) {
                return channelSegment3;
            }
            long j5 = j4 * BufferedChannelKt.f54236b;
            do {
                atomicLongFieldUpdater = f54209c;
                j3 = atomicLongFieldUpdater.get(this);
                if (j3 >= j5) {
                    break;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(this, j3, j5));
            if (j4 * BufferedChannelKt.f54236b < A()) {
                channelSegment3.a();
            }
        }
        return null;
    }

    public final Throwable x() {
        return (Throwable) f54215i.get(this);
    }

    public final Throwable y() {
        Throwable thX = x();
        return thX == null ? new ClosedReceiveChannelException("Channel was closed") : thX;
    }

    public final Throwable z() {
        Throwable thX = x();
        return thX == null ? new ClosedSendChannelException("Channel was closed") : thX;
    }
}
