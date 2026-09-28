package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1", f = "Emitters.kt", l = {181}, m = "emit")
/* loaded from: classes3.dex */
final class FlowKt__EmittersKt$onEmpty$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54635a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowKt__EmittersKt$onEmpty$1$1 f54636b;

    /* renamed from: c, reason: collision with root package name */
    public int f54637c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__EmittersKt$onEmpty$1$1$emit$1(FlowKt__EmittersKt$onEmpty$1$1 flowKt__EmittersKt$onEmpty$1$1, Continuation continuation) {
        super(continuation);
        this.f54636b = flowKt__EmittersKt$onEmpty$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54635a = obj;
        this.f54637c |= Integer.MIN_VALUE;
        return this.f54636b.a(null, this);
    }
}
