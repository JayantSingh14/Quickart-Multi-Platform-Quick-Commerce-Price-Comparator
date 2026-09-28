package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
final class ChannelAsFlow<T> extends ChannelFlow<T> {
    private volatile /* synthetic */ int consumed$volatile;

    /* renamed from: d, reason: collision with root package name */
    public final ReceiveChannel f54481d;

    static {
        AtomicIntegerFieldUpdater.newUpdater(ChannelAsFlow.class, "consumed$volatile");
    }

    public ChannelAsFlow(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        super(coroutineContext, i2, bufferOverflow);
        this.f54481d = receiveChannel;
        this.consumed$volatile = 0;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final String a() {
        return "channel=" + this.f54481d;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    public final Object c(FlowCollector flowCollector, Continuation continuation) {
        if (this.f54943b == -3) {
            Object objA = FlowKt__ChannelsKt.a(flowCollector, this.f54481d, false, continuation);
            return objA == CoroutineSingletons.f53689a ? objA : Unit.f53572a;
        }
        Object objC = super.c(flowCollector, continuation);
        return objC == CoroutineSingletons.f53689a ? objC : Unit.f53572a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final Object d(ProducerScope producerScope, Continuation continuation) {
        Object objA = FlowKt__ChannelsKt.a(new SendingCollector(producerScope), this.f54481d, false, continuation);
        return objA == CoroutineSingletons.f53689a ? objA : Unit.f53572a;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ChannelFlow f(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        return new ChannelAsFlow(this.f54481d, coroutineContext, i2, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public final ReceiveChannel g(CoroutineScope coroutineScope) {
        return this.f54943b == -3 ? this.f54481d : super.g(coroutineScope);
    }
}
