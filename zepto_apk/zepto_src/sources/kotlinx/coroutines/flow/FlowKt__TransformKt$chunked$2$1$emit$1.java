package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$chunked$2$1", f = "Transform.kt", l = {159}, m = "emit")
/* loaded from: classes3.dex */
final class FlowKt__TransformKt$chunked$2$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54834a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowKt__TransformKt$chunked$2$1 f54835b;

    /* renamed from: c, reason: collision with root package name */
    public int f54836c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__TransformKt$chunked$2$1$emit$1(FlowKt__TransformKt$chunked$2$1 flowKt__TransformKt$chunked$2$1, Continuation continuation) {
        super(continuation);
        this.f54835b = flowKt__TransformKt$chunked$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54834a = obj;
        this.f54836c |= Integer.MIN_VALUE;
        this.f54835b.a(null, this);
        throw null;
    }
}
