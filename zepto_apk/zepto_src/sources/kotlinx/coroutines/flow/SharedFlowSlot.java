package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SharedFlowSlot extends AbstractSharedFlowSlot<SharedFlowImpl<?>> {

    /* renamed from: a, reason: collision with root package name */
    public long f54895a = -1;

    /* renamed from: b, reason: collision with root package name */
    public CancellableContinuationImpl f54896b;

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public final boolean a(AbstractSharedFlow abstractSharedFlow) {
        SharedFlowImpl sharedFlowImpl = (SharedFlowImpl) abstractSharedFlow;
        if (this.f54895a >= 0) {
            return false;
        }
        long j2 = sharedFlowImpl.f54879e;
        if (j2 < sharedFlowImpl.f54880f) {
            sharedFlowImpl.f54880f = j2;
        }
        this.f54895a = j2;
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public final Continuation[] b(AbstractSharedFlow abstractSharedFlow) {
        long j2 = this.f54895a;
        this.f54895a = -1L;
        this.f54896b = null;
        return ((SharedFlowImpl) abstractSharedFlow).u(j2);
    }
}
