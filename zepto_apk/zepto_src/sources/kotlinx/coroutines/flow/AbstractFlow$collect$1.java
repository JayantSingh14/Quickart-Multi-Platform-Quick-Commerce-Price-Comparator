package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.SafeCollector;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {226}, m = "collect")
/* loaded from: classes.dex */
final class AbstractFlow$collect$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public SafeCollector f54469a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f54470b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractFlow f54471c;

    /* renamed from: d, reason: collision with root package name */
    public int f54472d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractFlow$collect$1(AbstractFlow abstractFlow, Continuation continuation) {
        super(continuation);
        this.f54471c = abstractFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54470b = obj;
        this.f54472d |= Integer.MIN_VALUE;
        return this.f54471c.c(null, this);
    }
}
