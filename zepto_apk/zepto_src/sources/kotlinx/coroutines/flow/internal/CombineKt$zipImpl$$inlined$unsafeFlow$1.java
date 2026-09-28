package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CombineKt$zipImpl$$inlined$unsafeFlow$1 implements Flow<Object> {
    @Override // kotlinx.coroutines.flow.Flow
    public final Object c(FlowCollector flowCollector, Continuation continuation) {
        Object objC = CoroutineScopeKt.c(new CombineKt$zipImpl$1$1(flowCollector, null), continuation);
        return objC == CoroutineSingletons.f53689a ? objC : Unit.f53572a;
    }
}
