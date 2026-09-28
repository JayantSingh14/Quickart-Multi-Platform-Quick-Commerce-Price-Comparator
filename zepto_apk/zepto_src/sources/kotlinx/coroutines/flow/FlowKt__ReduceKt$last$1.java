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
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {151}, m = "last")
/* loaded from: classes3.dex */
final class FlowKt__ReduceKt$last$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Ref.ObjectRef f54772a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f54773b;

    /* renamed from: c, reason: collision with root package name */
    public int f54774c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54773b = obj;
        int i2 = (this.f54774c | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54774c = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        Symbol symbol = NullSurrogateKt.f55041a;
        if (i2 == 0) {
            ResultKt.b(obj);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.f53801a = symbol;
            this.f54772a = objectRef;
            this.f54774c = 1;
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Ref.ObjectRef objectRef2 = this.f54772a;
        ResultKt.b(obj);
        Object obj2 = objectRef2.f53801a;
        if (obj2 != symbol) {
            return obj2;
        }
        throw new NoSuchElementException("Expected at least one element");
    }
}
