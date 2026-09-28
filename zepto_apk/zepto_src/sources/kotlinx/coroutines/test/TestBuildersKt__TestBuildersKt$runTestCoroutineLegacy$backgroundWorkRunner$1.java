package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.YieldKt;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$backgroundWorkRunner$1", f = "TestBuilders.kt", l = {499, 503}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$backgroundWorkRunner$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f55294a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f55295b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TestCoroutineScheduler f55296c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$backgroundWorkRunner$1(TestCoroutineScheduler testCoroutineScheduler, Continuation continuation) {
        super(2, continuation);
        this.f55296c = testCoroutineScheduler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$backgroundWorkRunner$1 testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$backgroundWorkRunner$1 = new TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$backgroundWorkRunner$1(this.f55296c, continuation);
        testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$backgroundWorkRunner$1.f55295b = obj;
        return testBuildersKt__TestBuildersKt$runTestCoroutineLegacy$backgroundWorkRunner$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        ((TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$backgroundWorkRunner$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        return CoroutineSingletons.f53689a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineScope coroutineScope;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f55294a;
        if (i2 == 0) {
            ResultKt.b(obj);
            coroutineScope = (CoroutineScope) this.f55295b;
        } else {
            if (i2 != 1 && i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.f55295b;
            ResultKt.b(obj);
        }
        while (true) {
            d dVar = new d(coroutineScope, 1);
            TestCoroutineScheduler testCoroutineScheduler = this.f55296c;
            if (testCoroutineScheduler.l1(dVar)) {
                this.f55295b = coroutineScope;
                this.f55294a = 1;
                if (YieldKt.a(this) == coroutineSingletons) {
                    break;
                }
            } else {
                this.f55295b = coroutineScope;
                this.f55294a = 2;
                Object objK = testCoroutineScheduler.f55308e.K(this);
                if (objK != CoroutineSingletons.f53689a) {
                    objK = Unit.f53572a;
                }
                if (objK == coroutineSingletons) {
                    break;
                }
            }
        }
        return coroutineSingletons;
    }
}
