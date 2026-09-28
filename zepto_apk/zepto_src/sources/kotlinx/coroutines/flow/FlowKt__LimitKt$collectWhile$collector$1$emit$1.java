package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1", f = "Limit.kt", l = {WKSRecord.Service.LOCUS_CON}, m = "emit")
/* loaded from: classes3.dex */
public final class FlowKt__LimitKt$collectWhile$collector$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public FlowKt__LimitKt$collectWhile$collector$1 f54693a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f54694b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FlowKt__LimitKt$collectWhile$collector$1 f54695c;

    /* renamed from: d, reason: collision with root package name */
    public int f54696d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__LimitKt$collectWhile$collector$1$emit$1(FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1, Continuation continuation) {
        super(continuation);
        this.f54695c = flowKt__LimitKt$collectWhile$collector$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54694b = obj;
        this.f54696d |= Integer.MIN_VALUE;
        return this.f54695c.a(null, this);
    }
}
