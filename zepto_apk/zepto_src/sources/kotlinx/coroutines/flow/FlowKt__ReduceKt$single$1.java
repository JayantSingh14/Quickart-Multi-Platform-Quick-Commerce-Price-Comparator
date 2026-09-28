package kotlinx.coroutines.flow;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {53}, m = "single")
/* loaded from: classes3.dex */
final class FlowKt__ReduceKt$single$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Ref.ObjectRef f54784a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f54785b;

    /* renamed from: c, reason: collision with root package name */
    public int f54786c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54785b = obj;
        int i2 = (this.f54786c | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54786c = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        Symbol symbol = NullSurrogateKt.f55041a;
        if (i2 == 0) {
            ResultKt.b(obj);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.f53801a = symbol;
            this.f54784a = objectRef;
            this.f54786c = 1;
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Ref.ObjectRef objectRef2 = this.f54784a;
        ResultKt.b(obj);
        Object obj2 = objectRef2.f53801a;
        if (obj2 != symbol) {
            return obj2;
        }
        throw new NoSuchElementException("Flow is empty");
    }
}
