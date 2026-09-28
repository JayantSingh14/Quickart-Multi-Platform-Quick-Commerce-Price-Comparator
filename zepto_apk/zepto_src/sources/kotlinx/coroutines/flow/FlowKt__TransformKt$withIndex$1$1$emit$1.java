package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$withIndex$1$1", f = "Transform.kt", l = {67}, m = "emit")
/* loaded from: classes3.dex */
final class FlowKt__TransformKt$withIndex$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54843a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowKt__TransformKt$withIndex$1$1 f54844b;

    /* renamed from: c, reason: collision with root package name */
    public int f54845c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__TransformKt$withIndex$1$1$emit$1(FlowKt__TransformKt$withIndex$1$1 flowKt__TransformKt$withIndex$1$1, Continuation continuation) {
        super(continuation);
        this.f54844b = flowKt__TransformKt$withIndex$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54843a = obj;
        this.f54845c |= Integer.MIN_VALUE;
        return this.f54844b.a(null, this);
    }
}
