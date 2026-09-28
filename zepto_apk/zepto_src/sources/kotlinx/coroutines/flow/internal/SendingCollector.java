package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;

@InternalCoroutinesApi
@Metadata
/* loaded from: classes3.dex */
public final class SendingCollector<T> implements FlowCollector<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ProducerScope f55052a;

    public SendingCollector(ProducerScope producerScope) {
        this.f55052a = producerScope;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object a(Object obj, Continuation continuation) {
        Object objO = this.f55052a.o(obj, continuation);
        return objO == CoroutineSingletons.f53689a ? objO : Unit.f53572a;
    }
}
