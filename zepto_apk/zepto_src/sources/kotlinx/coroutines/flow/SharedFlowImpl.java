package kotlinx.coroutines.flow;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {

    /* renamed from: d, reason: collision with root package name */
    public Object[] f54878d;

    /* renamed from: e, reason: collision with root package name */
    public long f54879e;

    /* renamed from: f, reason: collision with root package name */
    public long f54880f;

    /* renamed from: g, reason: collision with root package name */
    public int f54881g;

    /* renamed from: h, reason: collision with root package name */
    public int f54882h;

    @Metadata
    public static final class Emitter implements DisposableHandle {

        /* renamed from: a, reason: collision with root package name */
        public final SharedFlowImpl f54883a;

        /* renamed from: b, reason: collision with root package name */
        public final long f54884b;

        /* renamed from: c, reason: collision with root package name */
        public final Object f54885c;

        /* renamed from: d, reason: collision with root package name */
        public final CancellableContinuationImpl f54886d;

        public Emitter(SharedFlowImpl sharedFlowImpl, long j2, Object obj, CancellableContinuationImpl cancellableContinuationImpl) {
            this.f54883a = sharedFlowImpl;
            this.f54884b = j2;
            this.f54885c = obj;
            this.f54886d = cancellableContinuationImpl;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            SharedFlowImpl sharedFlowImpl = this.f54883a;
            synchronized (sharedFlowImpl) {
                if (this.f54884b < sharedFlowImpl.n()) {
                    return;
                }
                Object[] objArr = sharedFlowImpl.f54878d;
                Intrinsics.c(objArr);
                long j2 = this.f54884b;
                if (objArr[((int) j2) & (objArr.length - 1)] != this) {
                    return;
                }
                SharedFlowKt.a(objArr, j2, SharedFlowKt.f54894a);
                sharedFlowImpl.j();
                Unit unit = Unit.f53572a;
            }
        }
    }

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[BufferOverflow.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BufferOverflow bufferOverflow = BufferOverflow.f54203a;
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BufferOverflow bufferOverflow2 = BufferOverflow.f54203a;
                iArr[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00bb, code lost:
    
        throw r2.O();
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void k(kotlinx.coroutines.flow.SharedFlowImpl r8, kotlinx.coroutines.flow.FlowCollector r9, kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.k(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):void");
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object a(Object obj, Continuation frame) throws Throwable {
        Throwable th;
        Continuation[] continuationArrM;
        Emitter emitter;
        if (p(obj)) {
            return Unit.f53572a;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
        cancellableContinuationImpl.s();
        Continuation[] continuationArr = AbstractSharedFlowKt.f54941a;
        synchronized (this) {
            try {
                if (q(obj)) {
                    try {
                        Result.Companion companion = Result.f53538b;
                        cancellableContinuationImpl.resumeWith(Unit.f53572a);
                        continuationArrM = m(continuationArr);
                        emitter = null;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    try {
                        emitter = new Emitter(this, n() + this.f54881g + this.f54882h, obj, cancellableContinuationImpl);
                        l(emitter);
                        this.f54882h++;
                        continuationArrM = m(continuationArr);
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
                if (emitter != null) {
                    CancellableContinuationKt.a(cancellableContinuationImpl, emitter);
                }
                for (Continuation continuation : continuationArrM) {
                    if (continuation != null) {
                        Result.Companion companion2 = Result.f53538b;
                        continuation.resumeWith(Unit.f53572a);
                    }
                }
                Object objR = cancellableContinuationImpl.r();
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
                if (objR == coroutineSingletons) {
                    Intrinsics.checkNotNullParameter(frame, "frame");
                }
                if (objR != coroutineSingletons) {
                    objR = Unit.f53572a;
                }
                return objR == coroutineSingletons ? objR : Unit.f53572a;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow b(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        return SharedFlowKt.b(this, coroutineContext, i2, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object c(FlowCollector flowCollector, Continuation continuation) {
        k(this, flowCollector, continuation);
        return CoroutineSingletons.f53689a;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public final AbstractSharedFlowSlot f() {
        return new SharedFlowSlot();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public final AbstractSharedFlowSlot[] g() {
        return new SharedFlowSlot[2];
    }

    public final Object i(SharedFlowSlot sharedFlowSlot, Continuation frame) throws Throwable {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
        cancellableContinuationImpl.s();
        synchronized (this) {
            if (r(sharedFlowSlot) < 0) {
                sharedFlowSlot.f54896b = cancellableContinuationImpl;
            } else {
                Result.Companion companion = Result.f53538b;
                cancellableContinuationImpl.resumeWith(Unit.f53572a);
            }
            Unit unit = Unit.f53572a;
        }
        Object objR = cancellableContinuationImpl.r();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (objR == coroutineSingletons) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objR == coroutineSingletons ? objR : Unit.f53572a;
    }

    public final void j() {
        if (this.f54882h <= 1) {
            return;
        }
        Object[] objArr = this.f54878d;
        Intrinsics.c(objArr);
        while (this.f54882h > 0) {
            long jN = n();
            int i2 = this.f54881g;
            int i3 = this.f54882h;
            if (objArr[((int) ((jN + (i2 + i3)) - 1)) & (objArr.length - 1)] != SharedFlowKt.f54894a) {
                return;
            }
            this.f54882h = i3 - 1;
            SharedFlowKt.a(objArr, n() + this.f54881g + this.f54882h, null);
        }
    }

    public final void l(Object obj) {
        int i2 = this.f54881g + this.f54882h;
        Object[] objArrO = this.f54878d;
        if (objArrO == null) {
            objArrO = o(null, 0, 2);
        } else if (i2 >= objArrO.length) {
            objArrO = o(objArrO, i2, objArrO.length * 2);
        }
        SharedFlowKt.a(objArrO, n() + i2, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object, java.lang.Object[]] */
    public final Continuation[] m(Continuation[] continuationArr) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        SharedFlowSlot sharedFlowSlot;
        CancellableContinuationImpl cancellableContinuationImpl;
        int length = continuationArr.length;
        if (this.f54939b != 0 && (abstractSharedFlowSlotArr = this.f54938a) != null) {
            int length2 = abstractSharedFlowSlotArr.length;
            int i2 = 0;
            continuationArr = continuationArr;
            while (i2 < length2) {
                AbstractSharedFlowSlot abstractSharedFlowSlot = abstractSharedFlowSlotArr[i2];
                if (abstractSharedFlowSlot != null && (cancellableContinuationImpl = (sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot).f54896b) != null && r(sharedFlowSlot) >= 0) {
                    int length3 = continuationArr.length;
                    continuationArr = continuationArr;
                    if (length >= length3) {
                        ?? CopyOf = Arrays.copyOf(continuationArr, Math.max(2, continuationArr.length * 2));
                        Intrinsics.checkNotNullExpressionValue(CopyOf, "copyOf(...)");
                        continuationArr = CopyOf;
                    }
                    continuationArr[length] = cancellableContinuationImpl;
                    sharedFlowSlot.f54896b = null;
                    length++;
                }
                i2++;
                continuationArr = continuationArr;
            }
        }
        return continuationArr;
    }

    public final long n() {
        return Math.min(this.f54880f, this.f54879e);
    }

    public final Object[] o(Object[] objArr, int i2, int i3) {
        if (i3 <= 0) {
            throw new IllegalStateException("Buffer size overflow");
        }
        Object[] objArr2 = new Object[i3];
        this.f54878d = objArr2;
        if (objArr != null) {
            long jN = n();
            for (int i4 = 0; i4 < i2; i4++) {
                long j2 = i4 + jN;
                SharedFlowKt.a(objArr2, j2, objArr[((int) j2) & (objArr.length - 1)]);
            }
        }
        return objArr2;
    }

    public final boolean p(Object obj) {
        int i2;
        boolean z;
        Continuation[] continuationArrM = AbstractSharedFlowKt.f54941a;
        synchronized (this) {
            if (q(obj)) {
                continuationArrM = m(continuationArrM);
                z = true;
            } else {
                z = false;
            }
        }
        for (Continuation continuation : continuationArrM) {
            if (continuation != null) {
                Result.Companion companion = Result.f53538b;
                continuation.resumeWith(Unit.f53572a);
            }
        }
        return z;
    }

    public final boolean q(Object obj) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (this.f54939b != 0) {
            if (this.f54881g >= 0 && this.f54880f <= this.f54879e) {
                throw null;
            }
            l(obj);
            int i2 = this.f54881g + 1;
            this.f54881g = i2;
            if (i2 > 0) {
                Object[] objArr = this.f54878d;
                Intrinsics.c(objArr);
                SharedFlowKt.a(objArr, n(), null);
                this.f54881g--;
                long jN = n() + 1;
                if (this.f54879e < jN) {
                    this.f54879e = jN;
                }
                if (this.f54880f < jN) {
                    if (this.f54939b != 0 && (abstractSharedFlowSlotArr = this.f54938a) != null) {
                        for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                            if (abstractSharedFlowSlot != null) {
                                SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                                long j2 = sharedFlowSlot.f54895a;
                                if (j2 >= 0 && j2 < jN) {
                                    sharedFlowSlot.f54895a = jN;
                                }
                            }
                        }
                    }
                    this.f54880f = jN;
                }
            }
            long jN2 = n() + this.f54881g;
            long j3 = this.f54879e;
            if (((int) (jN2 - j3)) > 0) {
                t(1 + j3, this.f54880f, n() + this.f54881g, n() + this.f54881g + this.f54882h);
            }
        }
        return true;
    }

    public final long r(SharedFlowSlot sharedFlowSlot) {
        long j2 = sharedFlowSlot.f54895a;
        if (j2 < n() + this.f54881g) {
            return j2;
        }
        if (j2 <= n() && this.f54882h != 0) {
            return j2;
        }
        return -1L;
    }

    public final Object s(SharedFlowSlot sharedFlowSlot) {
        Object obj;
        Continuation[] continuationArrU = AbstractSharedFlowKt.f54941a;
        synchronized (this) {
            try {
                long jR = r(sharedFlowSlot);
                if (jR < 0) {
                    obj = SharedFlowKt.f54894a;
                } else {
                    long j2 = sharedFlowSlot.f54895a;
                    Object[] objArr = this.f54878d;
                    Intrinsics.c(objArr);
                    Object obj2 = objArr[((int) jR) & (objArr.length - 1)];
                    if (obj2 instanceof Emitter) {
                        obj2 = ((Emitter) obj2).f54885c;
                    }
                    sharedFlowSlot.f54895a = jR + 1;
                    Object obj3 = obj2;
                    continuationArrU = u(j2);
                    obj = obj3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation continuation : continuationArrU) {
            if (continuation != null) {
                Result.Companion companion = Result.f53538b;
                continuation.resumeWith(Unit.f53572a);
            }
        }
        return obj;
    }

    public final void t(long j2, long j3, long j4, long j5) {
        long jMin = Math.min(j3, j2);
        for (long jN = n(); jN < jMin; jN++) {
            Object[] objArr = this.f54878d;
            Intrinsics.c(objArr);
            SharedFlowKt.a(objArr, jN, null);
        }
        this.f54879e = j2;
        this.f54880f = j3;
        this.f54881g = (int) (j4 - jMin);
        this.f54882h = (int) (j5 - j4);
    }

    public final Continuation[] u(long j2) {
        long j3;
        long j4;
        Continuation[] continuationArr;
        Continuation[] continuationArr2;
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        long j5 = this.f54880f;
        Continuation[] continuationArr3 = AbstractSharedFlowKt.f54941a;
        if (j2 <= j5) {
            long jN = n();
            long j6 = this.f54881g + jN;
            if (this.f54882h > 0) {
                j6++;
            }
            int i2 = 0;
            if (this.f54939b != 0 && (abstractSharedFlowSlotArr = this.f54938a) != null) {
                for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                    if (abstractSharedFlowSlot != null) {
                        long j7 = ((SharedFlowSlot) abstractSharedFlowSlot).f54895a;
                        if (j7 >= 0 && j7 < j6) {
                            j6 = j7;
                        }
                    }
                }
            }
            if (j6 > this.f54880f) {
                long jN2 = n() + this.f54881g;
                int iMin = this.f54939b > 0 ? Math.min(this.f54882h, 0 - ((int) (jN2 - j6))) : this.f54882h;
                long j8 = this.f54882h + jN2;
                Symbol symbol = SharedFlowKt.f54894a;
                if (iMin > 0) {
                    Continuation[] continuationArr4 = new Continuation[iMin];
                    Object[] objArr = this.f54878d;
                    Intrinsics.c(objArr);
                    j4 = 1;
                    long j9 = jN2;
                    while (true) {
                        if (jN2 >= j8) {
                            continuationArr2 = continuationArr4;
                            j3 = jN;
                            break;
                        }
                        continuationArr2 = continuationArr4;
                        Object obj = objArr[((int) jN2) & (objArr.length - 1)];
                        j3 = jN;
                        if (obj != symbol) {
                            Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                            Emitter emitter = (Emitter) obj;
                            int i3 = i2 + 1;
                            continuationArr2[i2] = emitter.f54886d;
                            SharedFlowKt.a(objArr, jN2, symbol);
                            SharedFlowKt.a(objArr, j9, emitter.f54885c);
                            j9++;
                            if (i3 >= iMin) {
                                break;
                            }
                            i2 = i3;
                        }
                        jN2++;
                        continuationArr4 = continuationArr2;
                        jN = j3;
                    }
                    jN2 = j9;
                    continuationArr = continuationArr2;
                } else {
                    j3 = jN;
                    j4 = 1;
                    continuationArr = continuationArr3;
                }
                int i4 = (int) (jN2 - j3);
                long j10 = this.f54939b == 0 ? jN2 : j6;
                long jMax = Math.max(this.f54879e, jN2 - Math.min(0, i4));
                if (jMax < j8) {
                    Object[] objArr2 = this.f54878d;
                    Intrinsics.c(objArr2);
                    if (Intrinsics.b(objArr2[((int) jMax) & (objArr2.length - 1)], symbol)) {
                        jN2 += j4;
                        jMax += j4;
                    }
                }
                t(jMax, j10, jN2, j8);
                j();
                return continuationArr.length == 0 ? continuationArr : m(continuationArr);
            }
        }
        return continuationArr3;
    }
}
