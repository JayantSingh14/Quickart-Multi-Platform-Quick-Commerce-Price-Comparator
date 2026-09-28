package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.CancellableFlowImpl$collect$2", f = "Context.kt", l = {271}, m = "emit")
/* loaded from: classes3.dex */
final class CancellableFlowImpl$collect$2$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54478a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CancellableFlowImpl$collect$2 f54479b;

    /* renamed from: c, reason: collision with root package name */
    public int f54480c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CancellableFlowImpl$collect$2$emit$1(CancellableFlowImpl$collect$2 cancellableFlowImpl$collect$2, Continuation continuation) {
        super(continuation);
        this.f54479b = cancellableFlowImpl$collect$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54478a = obj;
        this.f54480c |= Integer.MIN_VALUE;
        return this.f54479b.a(null, this);
    }
}
