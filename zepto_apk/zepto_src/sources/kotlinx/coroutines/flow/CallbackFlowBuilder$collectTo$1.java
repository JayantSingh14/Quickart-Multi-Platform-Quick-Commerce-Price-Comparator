package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", l = {330}, m = "collectTo")
/* loaded from: classes3.dex */
final class CallbackFlowBuilder$collectTo$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public ProducerScope f54474a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f54475b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CallbackFlowBuilder f54476c;

    /* renamed from: d, reason: collision with root package name */
    public int f54477d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallbackFlowBuilder$collectTo$1(CallbackFlowBuilder callbackFlowBuilder, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f54476c = callbackFlowBuilder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54475b = obj;
        this.f54477d |= Integer.MIN_VALUE;
        return this.f54476c.d(null, this);
    }
}
