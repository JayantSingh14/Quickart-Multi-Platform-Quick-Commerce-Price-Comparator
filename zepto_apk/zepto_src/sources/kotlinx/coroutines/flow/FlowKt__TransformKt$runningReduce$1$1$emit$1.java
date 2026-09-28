package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1", f = "Transform.kt", l = {WKSRecord.Service.LOCUS_CON, WKSRecord.Service.PWDGEN}, m = "emit")
/* loaded from: classes3.dex */
final class FlowKt__TransformKt$runningReduce$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54840a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FlowKt__TransformKt$runningReduce$1$1 f54841b;

    /* renamed from: c, reason: collision with root package name */
    public int f54842c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__TransformKt$runningReduce$1$1$emit$1(FlowKt__TransformKt$runningReduce$1$1 flowKt__TransformKt$runningReduce$1$1, Continuation continuation) {
        super(continuation);
        this.f54841b = flowKt__TransformKt$runningReduce$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54840a = obj;
        this.f54842c |= Integer.MIN_VALUE;
        return this.f54841b.a(null, this);
    }
}
