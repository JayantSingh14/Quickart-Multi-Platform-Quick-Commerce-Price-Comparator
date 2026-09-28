package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1", f = "Limit.kt", l = {Type.TALINK, 60}, m = "emit")
/* loaded from: classes3.dex */
final class FlowKt__LimitKt$take$2$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54710a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowKt__LimitKt$take$2$1 f54711b;

    /* renamed from: c, reason: collision with root package name */
    public int f54712c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__LimitKt$take$2$1$emit$1(FlowKt__LimitKt$take$2$1 flowKt__LimitKt$take$2$1, Continuation continuation) {
        super(continuation);
        this.f54711b = flowKt__LimitKt$take$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54710a = obj;
        this.f54712c |= Integer.MIN_VALUE;
        return this.f54711b.a(null, this);
    }
}
