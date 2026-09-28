package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.Job;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {389, 401, 406}, m = "collect")
/* loaded from: classes.dex */
final class StateFlowImpl$collect$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f54918a;

    /* renamed from: b, reason: collision with root package name */
    public FlowCollector f54919b;

    /* renamed from: c, reason: collision with root package name */
    public Object f54920c;

    /* renamed from: d, reason: collision with root package name */
    public Job f54921d;

    /* renamed from: e, reason: collision with root package name */
    public Object f54922e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f54923f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ StateFlowImpl f54924g;

    /* renamed from: h, reason: collision with root package name */
    public int f54925h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StateFlowImpl$collect$1(StateFlowImpl stateFlowImpl, Continuation continuation) {
        super(continuation);
        this.f54924g = stateFlowImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f54923f = obj;
        this.f54925h |= Integer.MIN_VALUE;
        this.f54924g.c(null, this);
        return CoroutineSingletons.f53689a;
    }
}
