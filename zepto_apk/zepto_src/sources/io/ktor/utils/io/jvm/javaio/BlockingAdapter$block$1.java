package io.ktor.utils.io.jvm.javaio;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.BlockingAdapter$block$1", f = "Blocking.kt", l = {186}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class BlockingAdapter$block$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f51302a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BlockingAdapter f51303b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockingAdapter$block$1(BlockingAdapter blockingAdapter, Continuation continuation) {
        super(1, continuation);
        this.f51303b = blockingAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BlockingAdapter$block$1(this.f51303b, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((BlockingAdapter$block$1) create((Continuation) obj)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f51302a;
        if (i2 == 0) {
            ResultKt.b(obj);
            this.f51302a = 1;
            if (this.f51303b.b(this) == coroutineSingletons) {
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
