package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {

    /* renamed from: e, reason: collision with root package name */
    public final SuspendLambda f54965e;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest(Function3 function3, Flow flow, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        super(flow, coroutineContext, i2, bufferOverflow);
        this.f54965e = (SuspendLambda) function3;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function3] */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ChannelFlow f(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest(this.f54965e, this.f54961d, coroutineContext, i2, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    public final Object h(FlowCollector flowCollector, Continuation continuation) {
        Object objC = CoroutineScopeKt.c(new ChannelFlowTransformLatest$flowCollect$3(this, flowCollector, null), continuation);
        return objC == CoroutineSingletons.f53689a ? objC : Unit.f53572a;
    }
}
