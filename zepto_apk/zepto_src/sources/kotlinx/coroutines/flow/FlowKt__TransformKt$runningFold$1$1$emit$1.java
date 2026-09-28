package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1", f = "Transform.kt", l = {105, Type.L64}, m = "emit")
/* loaded from: classes3.dex */
final class FlowKt__TransformKt$runningFold$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54837a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowKt__TransformKt$runningFold$1$1 f54838b;

    /* renamed from: c, reason: collision with root package name */
    public int f54839c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__TransformKt$runningFold$1$1$emit$1(FlowKt__TransformKt$runningFold$1$1 flowKt__TransformKt$runningFold$1$1, Continuation continuation) {
        super(continuation);
        this.f54838b = flowKt__TransformKt$runningFold$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54837a = obj;
        this.f54839c |= Integer.MIN_VALUE;
        return this.f54838b.a(null, this);
    }
}
