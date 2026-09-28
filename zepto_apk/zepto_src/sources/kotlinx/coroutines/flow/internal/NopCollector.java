package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
/* loaded from: classes3.dex */
public final class NopCollector implements FlowCollector<Object> {
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object a(Object obj, Continuation continuation) {
        return Unit.f53572a;
    }
}
