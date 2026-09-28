package com.zeptonow.horizon;

import com.zeptonow.horizon.entity.Event;
import com.zeptonow.horizon.utils.EventQueue;
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
@DebugMetadata(c = "com.zeptonow.horizon.HorizonSDK$track$1", f = "HorizonSDK.kt", l = {53}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class HorizonSDK$track$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f47842a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Event f47843b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizonSDK$track$1(Event event, Continuation continuation) {
        super(2, continuation);
        this.f47843b = event;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new HorizonSDK$track$1(this.f47843b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((HorizonSDK$track$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f47842a;
        if (i2 == 0) {
            ResultKt.b(obj);
            EventQueue eventQueue = HorizonSDK.f47833d;
            this.f47842a = 1;
            if (eventQueue.c(this.f47843b, this) == coroutineSingletons) {
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
