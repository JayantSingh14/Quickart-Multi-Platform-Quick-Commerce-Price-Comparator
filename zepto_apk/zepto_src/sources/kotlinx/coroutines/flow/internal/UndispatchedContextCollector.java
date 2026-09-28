package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata
/* loaded from: classes3.dex */
final class UndispatchedContextCollector<T> implements FlowCollector<T> {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f55055a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f55056b;

    /* renamed from: c, reason: collision with root package name */
    public final Function2 f55057c;

    public UndispatchedContextCollector(FlowCollector flowCollector, CoroutineContext coroutineContext) {
        this.f55055a = coroutineContext;
        this.f55056b = ThreadContextKt.b(coroutineContext);
        this.f55057c = new UndispatchedContextCollector$emitRef$1(flowCollector, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object a(Object obj, Continuation continuation) {
        Object objA = ChannelFlowKt.a(this.f55055a, obj, this.f55056b, this.f55057c, continuation);
        return objA == CoroutineSingletons.f53689a ? objA : Unit.f53572a;
    }
}
