package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2", f = "Reduce.kt", l = {41}, m = "emit")
/* loaded from: classes3.dex */
public final class FlowKt__ReduceKt$fold$2$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54769a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowKt__ReduceKt$fold$2 f54770b;

    /* renamed from: c, reason: collision with root package name */
    public int f54771c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ReduceKt$fold$2$emit$1(FlowKt__ReduceKt$fold$2 flowKt__ReduceKt$fold$2, Continuation continuation) {
        super(continuation);
        this.f54770b = flowKt__ReduceKt$fold$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54769a = obj;
        this.f54771c |= Integer.MIN_VALUE;
        return this.f54770b.a(null, this);
    }
}
