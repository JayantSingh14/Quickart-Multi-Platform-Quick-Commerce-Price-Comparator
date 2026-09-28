package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class FlowKt__ContextKt {
    public static final Flow a(Flow flow) {
        BufferOverflow bufferOverflow = BufferOverflow.f54203a;
        BufferOverflow bufferOverflow2 = BufferOverflow.f54204b;
        if (flow instanceof FusibleFlow) {
            return ((FusibleFlow) flow).b(EmptyCoroutineContext.f53685a, 0, bufferOverflow2);
        }
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f53685a;
        int i2 = (2 & 4) != 0 ? -3 : 0;
        if ((2 & 8) != 0) {
            bufferOverflow2 = BufferOverflow.f54203a;
        }
        return new ChannelFlowOperatorImpl(flow, emptyCoroutineContext, i2, bufferOverflow2);
    }
}
