package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.Job;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", l = {387, 394, 397}, m = "collect$suspendImpl")
/* loaded from: classes3.dex */
final class SharedFlowImpl$collect$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public SharedFlowImpl f54887a;

    /* renamed from: b, reason: collision with root package name */
    public FlowCollector f54888b;

    /* renamed from: c, reason: collision with root package name */
    public SharedFlowSlot f54889c;

    /* renamed from: d, reason: collision with root package name */
    public Job f54890d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f54891e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ SharedFlowImpl f54892f;

    /* renamed from: g, reason: collision with root package name */
    public int f54893g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedFlowImpl$collect$1(SharedFlowImpl sharedFlowImpl, Continuation continuation) {
        super(continuation);
        this.f54892f = sharedFlowImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54891e = obj;
        this.f54893g |= Integer.MIN_VALUE;
        SharedFlowImpl.k(this.f54892f, null, this);
        return CoroutineSingletons.f53689a;
    }
}
