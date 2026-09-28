package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1", f = "Migration.kt", l = {189, 189}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f54728a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ FlowCollector f54729b;

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f54728a;
        if (i2 == 0) {
            ResultKt.b(obj);
            this.f54729b = this.f54729b;
            this.f54728a = 1;
            throw null;
        }
        if (i2 == 1) {
            FlowCollector flowCollector = this.f54729b;
            ResultKt.b(obj);
            this.f54729b = null;
            this.f54728a = 2;
            if (FlowKt__CollectKt.a(this, (Flow) obj, flowCollector) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f53572a;
    }
}
