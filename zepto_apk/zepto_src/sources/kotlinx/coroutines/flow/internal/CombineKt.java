package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CombineKt {
    public static final Object a(Continuation frame, Function0 function0, Function3 function3, FlowCollector flowCollector, Flow[] flowArr) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(null, function0, function3, flowCollector, flowArr);
        FlowCoroutine flowCoroutine = new FlowCoroutine(frame, frame.getContext());
        Object objA = UndispatchedKt.a(flowCoroutine, flowCoroutine, combineKt$combineInternal$2);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (objA == coroutineSingletons) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objA == coroutineSingletons ? objA : Unit.f53572a;
    }
}
