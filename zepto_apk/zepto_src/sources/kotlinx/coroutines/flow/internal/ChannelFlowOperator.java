package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata
/* loaded from: classes3.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {

    /* renamed from: d, reason: collision with root package name */
    public final Flow f54961d;

    public ChannelFlowOperator(Flow flow, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        super(coroutineContext, i2, bufferOverflow);
        this.f54961d = flow;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public final Object c(FlowCollector flowCollector, Continuation continuation) {
        if (this.f54943b == -3) {
            CoroutineContext context = continuation.getContext();
            Boolean bool = Boolean.FALSE;
            kotlin.coroutines.a aVar = new kotlin.coroutines.a(1);
            CoroutineContext coroutineContext = this.f54942a;
            CoroutineContext coroutineContextPlus = !((Boolean) coroutineContext.fold(bool, aVar)).booleanValue() ? context.plus(coroutineContext) : CoroutineContextKt.a(context, coroutineContext, false);
            if (Intrinsics.b(coroutineContextPlus, context)) {
                Object objH = h(flowCollector, continuation);
                return objH == CoroutineSingletons.f53689a ? objH : Unit.f53572a;
            }
            ContinuationInterceptor.Key key = ContinuationInterceptor.y0;
            if (Intrinsics.b(coroutineContextPlus.get(key), context.get(key))) {
                CoroutineContext context2 = continuation.getContext();
                if (!(flowCollector instanceof SendingCollector) && !(flowCollector instanceof NopCollector)) {
                    flowCollector = new UndispatchedContextCollector(flowCollector, context2);
                }
                Object objA = ChannelFlowKt.a(coroutineContextPlus, flowCollector, ThreadContextKt.b(coroutineContextPlus), new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), continuation);
                return objA == CoroutineSingletons.f53689a ? objA : Unit.f53572a;
            }
        }
        Object objC = super.c(flowCollector, continuation);
        return objC == CoroutineSingletons.f53689a ? objC : Unit.f53572a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final Object d(ProducerScope producerScope, Continuation continuation) {
        Object objH = h(new SendingCollector(producerScope), continuation);
        return objH == CoroutineSingletons.f53689a ? objH : Unit.f53572a;
    }

    public abstract Object h(FlowCollector flowCollector, Continuation continuation);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final String toString() {
        return this.f54961d + " -> " + super.toString();
    }
}
