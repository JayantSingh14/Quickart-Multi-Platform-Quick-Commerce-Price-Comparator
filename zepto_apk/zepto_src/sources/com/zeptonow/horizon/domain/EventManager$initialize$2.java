package com.zeptonow.horizon.domain;

import com.zeptonow.horizon.storage.EventStorage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventManager$initialize$2", f = "EventManager.kt", l = {32}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class EventManager$initialize$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f47989a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EventManager f47990b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventManager$initialize$2(EventManager eventManager, Continuation continuation) {
        super(2, continuation);
        this.f47990b = eventManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new EventManager$initialize$2(this.f47990b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((EventManager$initialize$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f47989a;
        if (i2 == 0) {
            ResultKt.b(obj);
            EventStorage eventStorage = this.f47990b.f47981b;
            this.f47989a = 1;
            if (eventStorage.g(this) == coroutineSingletons) {
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
