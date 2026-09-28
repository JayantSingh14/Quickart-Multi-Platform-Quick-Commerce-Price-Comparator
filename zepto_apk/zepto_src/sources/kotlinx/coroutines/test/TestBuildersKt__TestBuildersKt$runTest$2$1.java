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
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.YieldKt;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTest$2$1", f = "TestBuilders.kt", l = {339, 363, 368}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class TestBuildersKt__TestBuildersKt$runTest$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTest$2$1$1", f = "TestBuilders.kt", l = {316, 318}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTest$2$1$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<TestScopeImpl, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f55274a;

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f55275b;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            throw null;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            throw null;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f55274a;
            if (i2 == 0) {
                ResultKt.b(obj);
                this.f55275b = (TestScopeImpl) this.f55275b;
                this.f55274a = 1;
                if (YieldKt.a(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                throw null;
            }
            if (i2 == 1) {
                ResultKt.b(obj);
                throw null;
            }
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            throw null;
        }
    }

    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTest$2$1$2", f = "TestBuilders.kt", l = {359, 360}, m = "invokeSuspend")
    /* renamed from: kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTest$2$1$2, reason: invalid class name */
    final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f55276a;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            throw null;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            throw null;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f55276a;
            if (i2 == 0) {
                ResultKt.b(obj);
                throw null;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.f53572a;
            }
            ResultKt.b(obj);
            this.f55276a = 2;
            JobKt.c(null, this);
            throw null;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        throw null;
    }
}
