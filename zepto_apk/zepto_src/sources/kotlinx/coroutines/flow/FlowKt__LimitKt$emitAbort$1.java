package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.AbortFlowException;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", l = {70}, m = "emitAbort$FlowKt__LimitKt")
/* loaded from: classes3.dex */
final class FlowKt__LimitKt$emitAbort$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f54708a;

    /* renamed from: b, reason: collision with root package name */
    public int f54709b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowKt__LimitKt$emitAbort$1<T> flowKt__LimitKt$emitAbort$1;
        this.f54708a = obj;
        int i2 = this.f54709b | Integer.MIN_VALUE;
        this.f54709b = i2;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f54709b = i2 - Integer.MIN_VALUE;
            flowKt__LimitKt$emitAbort$1 = this;
        } else {
            flowKt__LimitKt$emitAbort$1 = new FlowKt__LimitKt$emitAbort$1<>(this);
        }
        Object obj2 = flowKt__LimitKt$emitAbort$1.f54708a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = flowKt__LimitKt$emitAbort$1.f54709b;
        if (i3 == 0) {
            ResultKt.b(obj2);
            flowKt__LimitKt$emitAbort$1.f54709b = 1;
            throw null;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj2);
        throw new AbortFlowException(null);
    }
}
