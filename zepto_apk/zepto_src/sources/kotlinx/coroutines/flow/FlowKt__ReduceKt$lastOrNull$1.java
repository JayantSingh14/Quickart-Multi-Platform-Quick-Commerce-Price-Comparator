package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {163}, m = "lastOrNull")
/* loaded from: classes3.dex */
final class FlowKt__ReduceKt$lastOrNull$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Ref.ObjectRef f54775a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f54776b;

    /* renamed from: c, reason: collision with root package name */
    public int f54777c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54776b = obj;
        int i2 = (this.f54777c | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54777c = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            this.f54775a = new Ref.ObjectRef();
            this.f54777c = 1;
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Ref.ObjectRef objectRef = this.f54775a;
        ResultKt.b(obj);
        return objectRef.f53801a;
    }
}
