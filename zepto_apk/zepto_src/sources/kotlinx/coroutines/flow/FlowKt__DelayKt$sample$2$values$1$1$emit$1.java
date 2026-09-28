package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1", f = "Delay.kt", l = {273}, m = "emit")
/* loaded from: classes3.dex */
final class FlowKt__DelayKt$sample$2$values$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54597a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowKt__DelayKt$sample$2$values$1.AnonymousClass1 f54598b;

    /* renamed from: c, reason: collision with root package name */
    public int f54599c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$values$1$1$emit$1(FlowKt__DelayKt$sample$2$values$1.AnonymousClass1 anonymousClass1, Continuation continuation) {
        super(continuation);
        this.f54598b = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54597a = obj;
        this.f54599c |= Integer.MIN_VALUE;
        return this.f54598b.a(null, this);
    }
}
