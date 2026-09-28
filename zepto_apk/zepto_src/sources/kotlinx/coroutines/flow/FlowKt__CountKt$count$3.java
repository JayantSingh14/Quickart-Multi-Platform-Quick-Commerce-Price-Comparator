package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__CountKt", f = "Count.kt", l = {25}, m = "count")
/* loaded from: classes3.dex */
final class FlowKt__CountKt$count$3<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Ref.IntRef f54556a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f54557b;

    /* renamed from: c, reason: collision with root package name */
    public int f54558c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowKt__CountKt$count$3<T> flowKt__CountKt$count$3;
        this.f54557b = obj;
        int i2 = this.f54558c | Integer.MIN_VALUE;
        this.f54558c = i2;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f54558c = i2 - Integer.MIN_VALUE;
            flowKt__CountKt$count$3 = this;
        } else {
            flowKt__CountKt$count$3 = new FlowKt__CountKt$count$3<>(this);
        }
        Object obj2 = flowKt__CountKt$count$3.f54557b;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = flowKt__CountKt$count$3.f54558c;
        if (i3 == 0) {
            ResultKt.b(obj2);
            flowKt__CountKt$count$3.f54556a = new Ref.IntRef();
            flowKt__CountKt$count$3.f54558c = 1;
            throw null;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Ref.IntRef intRef = flowKt__CountKt$count$3.f54556a;
        ResultKt.b(obj2);
        return new Integer(intRef.f53799a);
    }
}
