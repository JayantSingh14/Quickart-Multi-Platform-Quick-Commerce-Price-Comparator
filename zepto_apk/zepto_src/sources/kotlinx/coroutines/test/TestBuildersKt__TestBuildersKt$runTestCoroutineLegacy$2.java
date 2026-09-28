package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AbstractCoroutine;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2", f = "TestBuilders.kt", l = {459}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2 extends SuspendLambda implements Function2<AbstractCoroutine<? super Unit>, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f55287a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f55288b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2 testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2 = new TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2(2, continuation);
        testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2.f55288b = obj;
        return testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$2) create((AbstractCoroutine) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f55287a;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f53572a;
        }
        ResultKt.b(obj);
        this.f55287a = 1;
        throw null;
    }
}
