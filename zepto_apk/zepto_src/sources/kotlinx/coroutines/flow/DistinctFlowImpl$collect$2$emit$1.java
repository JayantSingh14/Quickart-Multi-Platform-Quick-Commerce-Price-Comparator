package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.DistinctFlowImpl$collect$2", f = "Distinct.kt", l = {WKSRecord.Service.NETRJS_3}, m = "emit")
/* loaded from: classes.dex */
final class DistinctFlowImpl$collect$2$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54487a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DistinctFlowImpl$collect$2 f54488b;

    /* renamed from: c, reason: collision with root package name */
    public int f54489c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistinctFlowImpl$collect$2$emit$1(DistinctFlowImpl$collect$2 distinctFlowImpl$collect$2, Continuation continuation) {
        super(continuation);
        this.f54488b = distinctFlowImpl$collect$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54487a = obj;
        this.f54489c |= Integer.MIN_VALUE;
        return this.f54488b.a(null, this);
    }
}
