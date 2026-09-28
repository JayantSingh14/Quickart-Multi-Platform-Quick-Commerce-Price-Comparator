package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2", f = "Reduce.kt", l = {21}, m = "emit")
/* loaded from: classes3.dex */
final class FlowKt__ReduceKt$reduce$2$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54781a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowKt__ReduceKt$reduce$2 f54782b;

    /* renamed from: c, reason: collision with root package name */
    public int f54783c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ReduceKt$reduce$2$emit$1(FlowKt__ReduceKt$reduce$2 flowKt__ReduceKt$reduce$2, Continuation continuation) {
        super(continuation);
        this.f54782b = flowKt__ReduceKt$reduce$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54781a = obj;
        this.f54783c |= Integer.MIN_VALUE;
        return this.f54782b.a(null, this);
    }
}
