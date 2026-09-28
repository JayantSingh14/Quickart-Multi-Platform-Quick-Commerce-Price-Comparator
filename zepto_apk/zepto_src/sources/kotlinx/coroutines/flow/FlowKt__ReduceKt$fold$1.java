package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {40}, m = "fold")
/* loaded from: classes3.dex */
final class FlowKt__ReduceKt$fold$1<T, R> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Ref.ObjectRef f54766a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f54767b;

    /* renamed from: c, reason: collision with root package name */
    public int f54768c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54767b = obj;
        int i2 = (this.f54768c | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54768c = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.ObjectRef objectRef = this.f54766a;
            ResultKt.b(obj);
            return objectRef.f53801a;
        }
        ResultKt.b(obj);
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.f53801a = null;
        this.f54766a = objectRef2;
        this.f54768c = 1;
        throw null;
    }
}
