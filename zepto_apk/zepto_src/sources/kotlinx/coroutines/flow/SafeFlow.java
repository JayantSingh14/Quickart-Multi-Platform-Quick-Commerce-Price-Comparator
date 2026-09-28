package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.SafeCollector;

@Metadata
/* loaded from: classes.dex */
final class SafeFlow<T> extends AbstractFlow<T> {

    /* renamed from: a, reason: collision with root package name */
    public final SuspendLambda f54877a;

    /* JADX WARN: Multi-variable type inference failed */
    public SafeFlow(Function2 function2) {
        this.f54877a = (SuspendLambda) function2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function2] */
    @Override // kotlinx.coroutines.flow.AbstractFlow
    public final Object a(SafeCollector safeCollector, Continuation continuation) {
        Object objInvoke = this.f54877a.invoke(safeCollector, continuation);
        return objInvoke == CoroutineSingletons.f53689a ? objInvoke : Unit.f53572a;
    }
}
