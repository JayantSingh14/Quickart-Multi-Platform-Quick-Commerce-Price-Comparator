package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$drop$2$1", f = "Limit.kt", l = {21}, m = "emit")
/* loaded from: classes3.dex */
final class FlowKt__LimitKt$drop$2$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54697a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowKt__LimitKt$drop$2$1 f54698b;

    /* renamed from: c, reason: collision with root package name */
    public int f54699c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__LimitKt$drop$2$1$emit$1(FlowKt__LimitKt$drop$2$1 flowKt__LimitKt$drop$2$1, Continuation continuation) {
        super(continuation);
        this.f54698b = flowKt__LimitKt$drop$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54697a = obj;
        this.f54699c |= Integer.MIN_VALUE;
        return this.f54698b.a(null, this);
    }
}
