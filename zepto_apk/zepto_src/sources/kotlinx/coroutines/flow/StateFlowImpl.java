package kotlinx.coroutines.flow;

import androidx.datastore.core.State;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f54916e = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state$volatile");
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: d, reason: collision with root package name */
    public int f54917d;

    public StateFlowImpl(Object obj) {
        this._state$volatile = obj;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object a(Object obj, Continuation continuation) {
        setValue(obj);
        return Unit.f53572a;
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public final Flow b(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        return (((i2 < 0 || i2 >= 2) && i2 != -2) || bufferOverflow != BufferOverflow.f54204b) ? SharedFlowKt.b(this, coroutineContext, i2, bufferOverflow) : this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
    
        if (((kotlinx.coroutines.flow.SubscribedFlowCollector) r11).b(r0) == r1) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bc, code lost:
    
        if (r11.equals(r12) == false) goto L47;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:45:0x00b8, B:47:0x00be], limit reached: 61 */
    /* JADX WARN: Path cross not found for [B:47:0x00be, B:45:0x00b8], limit reached: 61 */
    /* JADX WARN: Path cross not found for [B:47:0x00be, B:55:0x00d9], limit reached: 61 */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00aa A[Catch: all -> 0x003d, TryCatch #0 {all -> 0x003d, blocks: (B:14:0x0038, B:37:0x00a2, B:39:0x00aa, B:42:0x00b1, B:43:0x00b5, B:45:0x00b8, B:55:0x00d9, B:58:0x00e9, B:47:0x00be, B:51:0x00c5, B:21:0x0056, B:24:0x0067, B:36:0x0093), top: B:63:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b8 A[Catch: all -> 0x003d, TryCatch #0 {all -> 0x003d, blocks: (B:14:0x0038, B:37:0x00a2, B:39:0x00aa, B:42:0x00b1, B:43:0x00b5, B:45:0x00b8, B:55:0x00d9, B:58:0x00e9, B:47:0x00be, B:51:0x00c5, B:21:0x0056, B:24:0x0067, B:36:0x0093), top: B:63:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e9 A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #0 {all -> 0x003d, blocks: (B:14:0x0038, B:37:0x00a2, B:39:0x00aa, B:42:0x00b1, B:43:0x00b5, B:45:0x00b8, B:55:0x00d9, B:58:0x00e9, B:47:0x00be, B:51:0x00c5, B:21:0x0056, B:24:0x0067, B:36:0x0093), top: B:63:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00e8 -> B:37:0x00a2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00f9 -> B:37:0x00a2). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(kotlinx.coroutines.flow.FlowCollector r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.c(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.datastore.core.State] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2 */
    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public final boolean e(Object obj, State state) {
        Symbol symbol = NullSurrogateKt.f55041a;
        if (obj == null) {
            obj = symbol;
        }
        if (state == 0) {
            state = symbol;
        }
        return i(obj, state);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public final AbstractSharedFlowSlot f() {
        return new StateFlowSlot();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public final AbstractSharedFlowSlot[] g() {
        return new StateFlowSlot[2];
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public final Object getValue() {
        Symbol symbol = NullSurrogateKt.f55041a;
        Object obj = f54916e.get(this);
        if (obj == symbol) {
            return null;
        }
        return obj;
    }

    public final boolean i(Object obj, Object obj2) {
        int i2;
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        synchronized (this) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f54916e;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj != null && !Intrinsics.b(obj3, obj)) {
                return false;
            }
            if (Intrinsics.b(obj3, obj2)) {
                return true;
            }
            atomicReferenceFieldUpdater.set(this, obj2);
            int i3 = this.f54917d;
            if ((i3 & 1) != 0) {
                this.f54917d = i3 + 2;
                return true;
            }
            int i4 = i3 + 1;
            this.f54917d = i4;
            AbstractSharedFlowSlot[] abstractSharedFlowSlotArr2 = this.f54938a;
            Unit unit = Unit.f53572a;
            while (true) {
                StateFlowSlot[] stateFlowSlotArr = (StateFlowSlot[]) abstractSharedFlowSlotArr2;
                if (stateFlowSlotArr != null) {
                    for (StateFlowSlot stateFlowSlot : stateFlowSlotArr) {
                        if (stateFlowSlot != null) {
                            AtomicReference atomicReference = stateFlowSlot.f54928a;
                            while (true) {
                                Object obj4 = atomicReference.get();
                                if (obj4 != null && obj4 != StateFlowKt.f54927b) {
                                    if (obj4 != StateFlowKt.f54926a) {
                                        if (com.google.android.gms.internal.pal.a.y(atomicReference, obj4)) {
                                            Result.Companion companion = Result.f53538b;
                                            ((CancellableContinuationImpl) obj4).resumeWith(Unit.f53572a);
                                            break;
                                        }
                                    } else {
                                        if (com.google.android.gms.internal.pal.a.l(atomicReference, obj4)) {
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                synchronized (this) {
                    i2 = this.f54917d;
                    if (i2 == i4) {
                        this.f54917d = i4 + 1;
                        return true;
                    }
                    abstractSharedFlowSlotArr = this.f54938a;
                    Unit unit2 = Unit.f53572a;
                }
                abstractSharedFlowSlotArr2 = abstractSharedFlowSlotArr;
                i4 = i2;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public final void setValue(Object obj) {
        if (obj == null) {
            obj = NullSurrogateKt.f55041a;
        }
        i(null, obj);
    }
}
