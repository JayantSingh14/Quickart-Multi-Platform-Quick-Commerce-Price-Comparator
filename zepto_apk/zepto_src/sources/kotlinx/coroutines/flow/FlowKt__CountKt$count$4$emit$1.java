package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CountKt$count$4", f = "Count.kt", l = {26}, m = "emit")
/* loaded from: classes3.dex */
final class FlowKt__CountKt$count$4$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f54559a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f54560b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FlowKt__CountKt$count$4 f54561c;

    /* renamed from: d, reason: collision with root package name */
    public int f54562d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__CountKt$count$4$emit$1(FlowKt__CountKt$count$4 flowKt__CountKt$count$4, Continuation continuation) {
        super(continuation);
        this.f54561c = flowKt__CountKt$count$4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54560b = obj;
        this.f54562d |= Integer.MIN_VALUE;
        return this.f54561c.a(null, this);
    }
}
