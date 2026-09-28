package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class FlowKt__CollectKt {
    public static final Object a(ContinuationImpl continuationImpl, Flow flow, FlowCollector flowCollector) throws Throwable {
        if (flowCollector instanceof ThrowingCollector) {
            throw ((ThrowingCollector) flowCollector).f54935a;
        }
        Object objC = flow.c(flowCollector, continuationImpl);
        return objC == CoroutineSingletons.f53689a ? objC : Unit.f53572a;
    }
}
