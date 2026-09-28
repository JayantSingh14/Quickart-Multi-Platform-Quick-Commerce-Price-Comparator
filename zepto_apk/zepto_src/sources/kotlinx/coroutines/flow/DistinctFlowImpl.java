package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

@Metadata
/* loaded from: classes.dex */
final class DistinctFlowImpl<T> implements Flow<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Flow f54483a;

    public DistinctFlowImpl(Flow flow) {
        this.f54483a = flow;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object c(FlowCollector flowCollector, Continuation continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f53801a = NullSurrogateKt.f55041a;
        Object objC = this.f54483a.c(new DistinctFlowImpl$collect$2(this, objectRef, flowCollector), continuation);
        return objC == CoroutineSingletons.f53689a ? objC : Unit.f53572a;
    }
}
