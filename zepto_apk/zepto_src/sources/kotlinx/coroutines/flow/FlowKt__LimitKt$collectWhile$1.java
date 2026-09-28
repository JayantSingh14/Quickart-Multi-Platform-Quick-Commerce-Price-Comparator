package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", l = {WKSRecord.Service.STATSRV}, m = "collectWhile")
/* loaded from: classes3.dex */
final class FlowKt__LimitKt$collectWhile$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public FlowKt__LimitKt$collectWhile$collector$1 f54690a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f54691b;

    /* renamed from: c, reason: collision with root package name */
    public int f54692c;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54691b = obj;
        int i2 = (this.f54692c | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54692c = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        try {
        } catch (AbortFlowException e2) {
            if (e2.f54937a != i2) {
                throw e2;
            }
        }
        if (i2 == 0) {
            ResultKt.b(obj);
            this.f54690a = new FlowKt__LimitKt$collectWhile$collector$1();
            this.f54692c = 1;
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1 = this.f54690a;
        ResultKt.b(obj);
        return Unit.f53572a;
    }
}
