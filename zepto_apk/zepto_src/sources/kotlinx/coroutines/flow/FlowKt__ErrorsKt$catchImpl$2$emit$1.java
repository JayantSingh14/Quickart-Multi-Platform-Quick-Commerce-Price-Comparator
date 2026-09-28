package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2", f = "Errors.kt", l = {154}, m = "emit")
/* loaded from: classes3.dex */
final class FlowKt__ErrorsKt$catchImpl$2$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f54663a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f54664b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FlowKt__ErrorsKt$catchImpl$2 f54665c;

    /* renamed from: d, reason: collision with root package name */
    public int f54666d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ErrorsKt$catchImpl$2$emit$1(FlowKt__ErrorsKt$catchImpl$2 flowKt__ErrorsKt$catchImpl$2, Continuation continuation) {
        super(continuation);
        this.f54665c = flowKt__ErrorsKt$catchImpl$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54664b = obj;
        this.f54666d |= Integer.MIN_VALUE;
        return this.f54665c.a(null, this);
    }
}
