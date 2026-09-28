package io.ktor.http.content;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "io.ktor.http.content.BlockingBridgeKt$withBlockingAndRedispatch$2", f = "BlockingBridge.kt", l = {45}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class BlockingBridgeKt$withBlockingAndRedispatch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f50283a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f50284b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockingBridgeKt$withBlockingAndRedispatch$2(Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f50284b = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BlockingBridgeKt$withBlockingAndRedispatch$2(this.f50284b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((BlockingBridgeKt$withBlockingAndRedispatch$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f50283a;
        if (i2 == 0) {
            ResultKt.b(obj);
            this.f50283a = 1;
            if (((OutputStreamContent$writeTo$2) this.f50284b).invoke(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f53572a;
    }
}
