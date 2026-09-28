package com.zeptonow.horizon.domain;

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
@DebugMetadata(c = "com.zeptonow.horizon.domain.EventProcessor$processBatch$eventsToSend$1$1$2", f = "EventProcessor.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class EventProcessor$processBatch$eventsToSend$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new EventProcessor$processBatch$eventsToSend$1$1$2(2, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        ((EventProcessor$processBatch$eventsToSend$1$1$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        return Boolean.FALSE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        return Boolean.FALSE;
    }
}
