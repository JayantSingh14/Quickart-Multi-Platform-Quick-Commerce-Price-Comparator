package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {418, 422}, m = "onSubscription")
/* loaded from: classes3.dex */
final class SubscribedFlowCollector$onSubscription$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54929a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SubscribedFlowCollector f54930b;

    /* renamed from: c, reason: collision with root package name */
    public int f54931c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscribedFlowCollector$onSubscription$1(SubscribedFlowCollector subscribedFlowCollector, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f54930b = subscribedFlowCollector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54929a = obj;
        this.f54931c |= Integer.MIN_VALUE;
        return this.f54930b.b(this);
    }
}
